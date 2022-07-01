package com.sina.weibo.sdk.cmd;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.NetUtils;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.sina.weibo.sdk.utils.SDKNotification;
import java.io.File;
import java.util.Iterator;
import java.util.List;

class AppInstallCmdExecutor implements CmdExecutor<AppInstallCmd> {
  private static final int MESSAGE_DO_CMD = 1;
  
  private static final int MESSAGE_QUIT_LOOP = 2;
  
  private static final String TAG;
  
  private static final String WB_APK_FILE_DIR;
  
  private boolean isStarted = false;
  
  private Context mContext;
  
  private InstallHandler mHandler;
  
  private Looper mLooper;
  
  private HandlerThread thread;
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Environment.getExternalStorageDirectory());
    stringBuilder.append("/Android/org_share_data/");
    WB_APK_FILE_DIR = stringBuilder.toString();
    TAG = AppInstallCmdExecutor.class.getName();
  }
  
  public AppInstallCmdExecutor(Context paramContext) {
    this.mContext = paramContext.getApplicationContext();
  }
  
  private static PendingIntent buildInstallApkIntent(Context paramContext, String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      Intent intent = new Intent("android.intent.action.VIEW");
      intent.setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
      return PendingIntent.getActivity(paramContext, 0, intent, 16);
    } 
    return PendingIntent.getActivity(paramContext, 0, new Intent(), 16);
  }
  
  private static boolean checkApkInstalled(Context paramContext, String paramString) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(paramString, 1);
      return !(packageInfo == null);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return false;
    } 
  }
  
  private static boolean checkApkSign(PackageInfo paramPackageInfo, String paramString) {
    if (paramPackageInfo == null)
      return false; 
    if (paramPackageInfo.signatures == null)
      return (Build.VERSION.SDK_INT < 11); 
    String str = "";
    for (int i = 0;; i++) {
      if (i >= paramPackageInfo.signatures.length)
        return (str == null) ? false : str.equals(paramString); 
      byte[] arrayOfByte = paramPackageInfo.signatures[i].toByteArray();
      if (arrayOfByte != null)
        str = MD5.hexdigest(arrayOfByte); 
    } 
  }
  
  private static boolean checkPackageName(PackageInfo paramPackageInfo, String paramString) {
    return (paramPackageInfo == null) ? false : paramString.equals(paramPackageInfo.packageName);
  }
  
  private static String generateSaveFileName(String paramString) {
    int i = paramString.lastIndexOf("/");
    return (i != -1) ? paramString.substring(i + 1, paramString.length()) : "";
  }
  
  private static String getNotificationTitle(Context paramContext, String paramString) {
    return TextUtils.isEmpty(paramString) ? ResourceManager.getString(paramContext, "Weibo", "微博", "微博") : paramString;
  }
  
  private void handleCmd(AppInstallCmd paramAppInstallCmd) {
    String str1 = "";
    if (!needActivate(this.mContext, paramAppInstallCmd))
      return; 
    String str2 = WB_APK_FILE_DIR;
    String str3 = paramAppInstallCmd.getDownloadUrl();
    long l = paramAppInstallCmd.getAppVersion();
    Pair<Integer, File> pair = walkDir(this.mContext, str2, paramAppInstallCmd);
    if (pair != null && pair.second != null && ((Integer)pair.first).intValue() >= l) {
      showNotification(this.mContext, paramAppInstallCmd, ((File)pair.second).getAbsolutePath());
      return;
    } 
    if (NetworkHelper.isWifiValid(this.mContext) && !TextUtils.isEmpty(str3)) {
      try {
        str3 = NetUtils.internalGetRedirectUri(this.mContext, str3, "GET", new WeiboParameters(""));
        String str = generateSaveFileName(str3);
        if (TextUtils.isEmpty(str) || !str.endsWith(".apk")) {
          LogUtil.e(TAG, "redirectDownloadUrl is illeagle");
          if (!TextUtils.isEmpty(""))
            showNotification(this.mContext, paramAppInstallCmd, ""); 
          return;
        } 
        str2 = NetUtils.internalDownloadFile(this.mContext, str3, str2, str);
        if (!TextUtils.isEmpty(str2)) {
          str1 = str2;
        } else {
          return;
        } 
      } catch (WeiboException weiboException) {
        weiboException.printStackTrace();
        if (!TextUtils.isEmpty("")) {
          showNotification(this.mContext, paramAppInstallCmd, str1);
          return;
        } 
      } finally {}
    } else {
      return;
    } 
    showNotification(this.mContext, paramAppInstallCmd, str1);
  }
  
  private static boolean isSpecifiedApk(PackageInfo paramPackageInfo, List<String> paramList, String paramString) {
    boolean bool;
    Iterator<String> iterator = paramList.iterator();
    while (true) {
      if (!iterator.hasNext()) {
        bool = false;
        break;
      } 
      if (checkPackageName(paramPackageInfo, iterator.next())) {
        bool = true;
        break;
      } 
    } 
    boolean bool1 = checkApkSign(paramPackageInfo, paramString);
    return (bool && bool1);
  }
  
  private static boolean needActivate(Context paramContext, AppInstallCmd paramAppInstallCmd) {
    List<String> list = paramAppInstallCmd.getAppPackage();
    if (list != null && list.size() != 0 && !TextUtils.isEmpty(paramAppInstallCmd.getAppSign()) && !TextUtils.isEmpty(paramAppInstallCmd.getDownloadUrl())) {
      WeiboAppManager.WeiboInfo weiboInfo;
      if (TextUtils.isEmpty(paramAppInstallCmd.getNotificationText()))
        return false; 
      if (list.contains("com.sina.weibo")) {
        weiboInfo = WeiboAppManager.getInstance(paramContext).getWeiboInfo();
        return !(weiboInfo != null && weiboInfo.isLegal());
      } 
      Iterator<String> iterator = list.iterator();
      do {
        if (!iterator.hasNext())
          return true; 
      } while (!checkApkInstalled((Context)weiboInfo, iterator.next()));
    } 
    return false;
  }
  
  private static void showNotification(Context paramContext, AppInstallCmd paramAppInstallCmd, String paramString) {
    SDKNotification.SDKNotificationBuilder.buildUpon().setNotificationContent(paramAppInstallCmd.getNotificationText()).setNotificationPendingIntent(buildInstallApkIntent(paramContext, paramString)).setNotificationTitle(getNotificationTitle(paramContext, paramAppInstallCmd.getNotificationTitle())).setTickerText(paramAppInstallCmd.getNotificationText()).build(paramContext).show(1);
  }
  
  private static Pair<Integer, File> walkDir(Context paramContext, String paramString, AppInstallCmd paramAppInstallCmd) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    File file = new File(paramString);
    if (file.exists()) {
      if (!file.isDirectory())
        return null; 
      File[] arrayOfFile = file.listFiles();
      if (arrayOfFile == null)
        return null; 
      int k = arrayOfFile.length;
      int i = 0;
      file = null;
      int j = 0;
      while (true) {
        if (i >= k)
          return new Pair(Integer.valueOf(j), file); 
        File file2 = arrayOfFile[i];
        String str = file2.getName();
        int m = j;
        File file1 = file;
        if (file2.isFile()) {
          m = j;
          file1 = file;
          if (str.endsWith(".apk")) {
            PackageInfo packageInfo = paramContext.getPackageManager().getPackageArchiveInfo(file2.getAbsolutePath(), 64);
            if (!isSpecifiedApk(packageInfo, paramAppInstallCmd.getAppPackage(), paramAppInstallCmd.getAppSign())) {
              m = j;
              file1 = file;
            } else {
              m = j;
              file1 = file;
              if (packageInfo.versionCode > j) {
                m = packageInfo.versionCode;
                file1 = file2;
              } 
            } 
          } 
        } 
        i++;
        j = m;
        file = file1;
      } 
    } 
    return null;
  }
  
  public boolean doExecutor(AppInstallCmd paramAppInstallCmd) {
    if (this.thread != null) {
      InstallHandler installHandler = this.mHandler;
      if (installHandler != null) {
        if (paramAppInstallCmd != null) {
          Message message = installHandler.obtainMessage();
          message.what = 1;
          message.obj = paramAppInstallCmd;
          this.mHandler.sendMessage(message);
        } 
        return false;
      } 
    } 
    throw new RuntimeException("no thread running. please call start method first!");
  }
  
  public void start() {
    if (this.isStarted)
      return; 
    this.isStarted = true;
    this.thread = new HandlerThread("");
    this.thread.start();
    this.mLooper = this.thread.getLooper();
    this.mHandler = new InstallHandler(this.mLooper);
  }
  
  public void stop() {
    if (this.thread != null) {
      InstallHandler installHandler = this.mHandler;
      if (installHandler != null) {
        Message message = installHandler.obtainMessage();
        message.what = 2;
        this.mHandler.sendMessage(message);
        return;
      } 
    } 
    LogUtil.w(TAG, "no thread running. please call start method first!");
  }
  
  class InstallHandler extends Handler {
    public InstallHandler(Looper param1Looper) {
      super(param1Looper);
    }
    
    public void handleMessage(Message param1Message) {
      int i = param1Message.what;
      if (i != 1) {
        if (i != 2)
          return; 
        AppInstallCmdExecutor.this.mLooper.quit();
        AppInstallCmdExecutor.this.isStarted = false;
        return;
      } 
      AppInstallCmdExecutor.this.handleCmd((AppInstallCmd)param1Message.obj);
    }
  }
  
  static final class NOTIFICATION_CONSTANTS {
    private static final int NOTIFICATIONID = 1;
    
    private static final String WEIBO = "Weibo";
    
    private static final String WEIBO_ZH_CN = "微博";
    
    private static final String WEIBO_ZH_TW = "微博";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\cmd\AppInstallCmdExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */