package com.baidu.mobads.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import com.baidu.mobads.MobadsPermissionSettings;
import com.baidu.mobads.constants.a;
import com.baidu.mobads.interfaces.utils.IBase64;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.BdFileProvider;
import com.baidu.mobads.openad.d.a;
import com.baidu.mobads.openad.d.b;
import java.io.File;
import java.util.List;

public class r implements IXAdPackageUtils {
  public static boolean a(Context paramContext) {
    return (Build.VERSION.SDK_INT >= 24 && d(paramContext) >= 24);
  }
  
  public static boolean b(Context paramContext) {
    if (paramContext == null)
      return false; 
    try {
      if (!a(paramContext))
        return true; 
      if (c(paramContext))
        return true; 
      File file = paramContext.getExternalFilesDir(null);
      if (file != null) {
        boolean bool = c(paramContext, p.a(file.getPath()));
        if (bool)
          return true; 
      } 
      return false;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private static Uri c(Context paramContext, File paramFile) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramContext.getPackageName());
      stringBuilder.append(".bd.provider");
      return BdFileProvider.getUriForFile(paramContext, stringBuilder.toString(), paramFile);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static boolean c(Context paramContext) {
    if (Build.VERSION.SDK_INT > 28)
      return false; 
    if (XAdSDKFoundationFacade.getInstance().getCommonUtils().checkSelfPermission(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE") && MobadsPermissionSettings.hasPermissionGranted("permission_storage")) {
      File file = Environment.getExternalStorageDirectory();
      if (file != null && c(paramContext, p.a(file.getPath())))
        return true; 
    } 
    return false;
  }
  
  private static boolean c(Context paramContext, String paramString) {
    if (a(paramContext)) {
      boolean bool = false;
      try {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString);
        stringBuilder.append("t");
        File file = new File(stringBuilder.toString());
        if (!file.exists())
          file.mkdir(); 
        Uri uri = c(paramContext, file);
        if (uri != null)
          bool = true; 
        return bool;
      } catch (Exception exception) {
        q.a().e(exception);
        return false;
      } 
    } 
    return true;
  }
  
  public static int d(Context paramContext) {
    try {
      return (paramContext.getApplicationContext().getApplicationInfo()).targetSdkVersion;
    } catch (Exception exception) {
      return 0;
    } 
  }
  
  public Intent a(Context paramContext, File paramFile) {
    Intent intent2 = null;
    Intent intent1 = intent2;
    if (paramFile != null) {
      intent1 = intent2;
      try {
        if (paramFile.exists()) {
          Uri uri;
          intent1 = new Intent("android.intent.action.VIEW");
          intent1.addCategory("android.intent.category.DEFAULT");
          if (!a(paramContext)) {
            intent1.addFlags(268435456);
            uri = Uri.fromFile(paramFile);
          } else {
            intent1.addFlags(268435457);
            uri = c((Context)uri, paramFile);
          } 
        } else {
          return intent1;
        } 
      } catch (Exception exception) {
        return null;
      } 
    } else {
      return intent1;
    } 
    if (exception == null)
      return null; 
    intent1.setDataAndType((Uri)exception, "application/vnd.android.package-archive");
    return intent1;
  }
  
  public Intent a(Context paramContext, String paramString) {
    try {
      return a(paramContext, new File(paramString));
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public void b(Context paramContext, File paramFile) {
    try {
      paramContext.startActivity(a(paramContext, paramFile));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void b(Context paramContext, String paramString) {
    try {
      paramContext.startActivity(a(paramContext, paramString));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public int getAppVersion(Context paramContext) {
    try {
      return (paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 16384)).versionCode;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return 0;
    } 
  }
  
  @Deprecated
  public Intent getInstallIntent(String paramString) {
    try {
      Uri uri = Uri.fromFile(new File(paramString));
      Intent intent = new Intent("android.intent.action.VIEW");
      try {
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        return intent;
      } catch (Exception exception) {}
      return intent;
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public IXAdPackageUtils.ApkInfo getLocalApkFileInfo(Context paramContext, String paramString) {
    String str = null;
    try {
      IXAdPackageUtils.ApkInfo apkInfo;
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 1);
      paramString = str;
      if (packageInfo != null)
        apkInfo = new IXAdPackageUtils.ApkInfo(paramContext, packageInfo); 
      return apkInfo;
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public boolean isForeground(Context paramContext, String paramString) {
    try {
      for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses()) {
        if (runningAppProcessInfo.processName.equals(paramString)) {
          int i = runningAppProcessInfo.importance;
          if (i == 100)
            return true; 
          break;
        } 
      } 
      return false;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public boolean isInstalled(Context paramContext, String paramString) {
    boolean bool = false;
    try {
      ApplicationInfo applicationInfo = paramContext.getPackageManager().getApplicationInfo(paramString, 0);
      boolean bool1 = bool;
      if (applicationInfo != null) {
        boolean bool2 = paramString.equals(applicationInfo.packageName);
        bool1 = bool;
        if (bool2)
          bool1 = true; 
      } 
      return bool1;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return false;
    } 
  }
  
  public boolean isSystemPackage(PackageInfo paramPackageInfo) {
    return ((paramPackageInfo.applicationInfo.flags & 0x1) != 0);
  }
  
  public void openApp(Context paramContext, String paramString) {
    try {
      Intent intent = paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
      intent.addFlags(268435456);
      paramContext.startActivity(intent);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public boolean sendAPOInfo(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3) {
    PackageManager packageManager = paramContext.getPackageManager();
    IXAdSystemUtils iXAdSystemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
    IXAdURIUitls iXAdURIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
    h h = XAdSDKFoundationFacade.getInstance().getCommonUtils();
    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
    intent.addFlags(268435456);
    paramString1 = iXAdURIUitls.encodeUrl(paramString1);
    List<ResolveInfo> list = packageManager.queryIntentActivities(intent, 65536);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("&sn=");
    stringBuilder2.append(iXAdSystemUtils.getEncodedSN(paramContext));
    stringBuilder2.append("&fb_act=");
    stringBuilder2.append(paramInt2);
    stringBuilder2.append("&pack=");
    stringBuilder2.append(paramContext.getPackageName());
    stringBuilder2.append("&v=");
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("android_");
    stringBuilder1.append(a.c);
    stringBuilder1.append("_");
    stringBuilder1.append("4.1.30");
    stringBuilder2.append(stringBuilder1.toString());
    stringBuilder2.append("&targetscheme=");
    stringBuilder2.append(paramString1);
    stringBuilder2.append("&pk=");
    stringBuilder2.append(paramString2);
    String str2 = stringBuilder2.toString();
    if (list.size() > 0) {
      StringBuilder stringBuilder3;
      Object object;
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("&open=");
      stringBuilder1.append("true");
      String str3 = stringBuilder1.toString();
      StringBuilder stringBuilder4 = new StringBuilder();
      stringBuilder4.append(str3);
      stringBuilder4.append("&n=");
      stringBuilder4.append(list.size());
      str3 = stringBuilder4.toString();
      String str4 = "";
      paramInt2 = 0;
      boolean bool1 = true;
      while (true) {
        String str;
        boolean bool2;
        if (paramInt2 < list.size()) {
          ResolveInfo resolveInfo = list.get(paramInt2);
          if (paramInt2 == 0) {
            stringBuilder4 = new StringBuilder();
            stringBuilder4.append((String)stringBuilder3);
            stringBuilder4.append("&p=");
            stringBuilder4.append(resolveInfo.activityInfo.packageName);
            str = stringBuilder4.toString();
          } else {
            stringBuilder4 = new StringBuilder();
            stringBuilder4.append(str);
            stringBuilder4.append(",");
            stringBuilder4.append(resolveInfo.activityInfo.packageName);
            str = stringBuilder4.toString();
          } 
          String str5 = str;
          str = str4;
          Object object1 = object;
          if (paramString2.equals(resolveInfo.activityInfo.packageName)) {
            byte b;
            try {
              b = (packageManager.getPackageInfo(resolveInfo.activityInfo.packageName, 0)).versionCode;
              if (b < paramInt3)
                bool2 = false; 
              try {
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append(str4);
                stringBuilder5.append("&installedVersion=");
                stringBuilder5.append(b);
                stringBuilder5.append("&requiredVersion=");
                stringBuilder5.append(paramInt3);
                stringBuilder5.append("&realopen=");
                stringBuilder5.append(bool2);
                String str6 = stringBuilder5.toString();
                boolean bool4 = bool2;
                continue;
              } catch (Exception exception) {}
            } catch (Exception exception) {
              b = -1;
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str4);
            stringBuilder.append("&exception=true&installedVersion=");
            stringBuilder.append(b);
            stringBuilder.append("&requiredVersion=");
            stringBuilder.append(paramInt3);
            stringBuilder.append("&realopen=");
            stringBuilder.append(bool2);
            str = stringBuilder.toString();
          } else {
            continue;
          } 
        } else {
          String str6 = str;
          boolean bool4 = bool2;
          if (!str4.equals("")) {
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append(str);
            stringBuilder5.append(str4);
            str6 = stringBuilder5.toString();
            bool4 = bool2;
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str2);
          stringBuilder.append(str6);
          String str5 = h.vdUrl(stringBuilder.toString(), paramInt1);
        } 
        boolean bool3 = bool2;
        continue;
        paramInt2++;
        str4 = str3;
        stringBuilder3 = stringBuilder4;
        object = SYNTHETIC_LOCAL_VARIABLE_9;
      } 
    } 
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append("&open=");
    stringBuilder1.append("false");
    paramString1 = stringBuilder1.toString();
    boolean bool = false;
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str2);
    stringBuilder1.append(paramString1);
    String str1 = h.vdUrl(stringBuilder1.toString(), paramInt1);
  }
  
  public void sendAPOIsSuccess(Context paramContext, boolean paramBoolean, int paramInt, String paramString1, String paramString2) {
    h h = XAdSDKFoundationFacade.getInstance().getCommonUtils();
    IXAdURIUitls iXAdURIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
    IXAdSystemUtils iXAdSystemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
    IBase64 iBase64 = XAdSDKFoundationFacade.getInstance().getBase64();
    String str2 = iXAdURIUitls.encodeUrl(paramString1);
    StringBuilder stringBuilder2 = new StringBuilder();
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append("aposuccess=");
    stringBuilder4.append(paramBoolean);
    stringBuilder2.append(stringBuilder4.toString());
    if (!paramBoolean) {
      stringBuilder4 = new StringBuilder();
      stringBuilder4.append("&failtime=");
      stringBuilder4.append(paramInt);
      stringBuilder2.append(stringBuilder4.toString());
    } 
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append("&sn=");
    stringBuilder4.append(iXAdSystemUtils.getEncodedSN(paramContext));
    stringBuilder2.append(stringBuilder4.toString());
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append("&mac=");
    stringBuilder4.append(iBase64.encode(iXAdSystemUtils.getMacAddress(paramContext)));
    stringBuilder2.append(stringBuilder4.toString());
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append("&cuid=");
    stringBuilder4.append(iBase64.encode(iXAdSystemUtils.getCUID(paramContext)));
    stringBuilder2.append(stringBuilder4.toString());
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("&pack=");
    stringBuilder3.append(paramContext.getPackageName());
    stringBuilder2.append(stringBuilder3.toString());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("&v=");
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append("android_");
    stringBuilder3.append(a.c);
    stringBuilder3.append("_");
    stringBuilder3.append("4.1.30");
    stringBuilder1.append(stringBuilder3.toString());
    stringBuilder2.append(stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append("&targetscheme=");
    stringBuilder1.append(str2);
    stringBuilder2.append(stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append("&pk=");
    stringBuilder1.append(paramString2);
    stringBuilder2.append(stringBuilder1.toString());
    String str1 = h.vdUrl(stringBuilder2.toString(), 369);
    try {
      b b = new b(iXAdURIUitls.addParameters(str1, null), "");
      b.e = 1;
      (new a()).a(b);
      return;
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d("XAdPackageUtils", exception.getMessage());
      return;
    } 
  }
  
  public void sendDialerIsSuccess(Context paramContext, boolean paramBoolean, int paramInt, String paramString) {
    h h = XAdSDKFoundationFacade.getInstance().getCommonUtils();
    IXAdURIUitls iXAdURIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
    IXAdSystemUtils iXAdSystemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
    IBase64 iBase64 = XAdSDKFoundationFacade.getInstance().getBase64();
    StringBuilder stringBuilder2 = new StringBuilder();
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append("callstate=");
    stringBuilder4.append(paramBoolean);
    stringBuilder2.append(stringBuilder4.toString());
    if (!paramBoolean) {
      stringBuilder4 = new StringBuilder();
      stringBuilder4.append("&duration=");
      stringBuilder4.append(paramInt);
      stringBuilder2.append(stringBuilder4.toString());
    } 
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append("&sn=");
    stringBuilder4.append(iXAdSystemUtils.getEncodedSN(paramContext));
    stringBuilder2.append(stringBuilder4.toString());
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append("&mac=");
    stringBuilder4.append(iBase64.encode(iXAdSystemUtils.getMacAddress(paramContext)));
    stringBuilder2.append(stringBuilder4.toString());
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append("&bdr=");
    stringBuilder4.append(Build.VERSION.SDK_INT);
    stringBuilder2.append(stringBuilder4.toString());
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append("&cuid=");
    stringBuilder4.append(iBase64.encode(iXAdSystemUtils.getCUID(paramContext)));
    stringBuilder2.append(stringBuilder4.toString());
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("&pack=");
    stringBuilder3.append(paramContext.getPackageName());
    stringBuilder2.append(stringBuilder3.toString());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("&v=");
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append("android_");
    stringBuilder3.append(a.c);
    stringBuilder3.append("_");
    stringBuilder3.append("4.1.30");
    stringBuilder1.append(stringBuilder3.toString());
    stringBuilder2.append(stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append("&pk=");
    stringBuilder1.append(paramString);
    stringBuilder2.append(stringBuilder1.toString());
    String str = h.vdUrl(stringBuilder2.toString(), 372);
    try {
      b b = new b(iXAdURIUitls.addParameters(str, null), "");
      b.e = 1;
      (new a()).a(b);
      return;
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d("XAdPackageUtils", exception.getMessage());
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\\utils\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */