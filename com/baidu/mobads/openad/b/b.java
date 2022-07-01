package com.baidu.mobads.openad.b;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.baidu.mobads.AppActivity;
import com.baidu.mobads.a.a;
import com.baidu.mobads.b.a;
import com.baidu.mobads.command.a;
import com.baidu.mobads.command.a.a;
import com.baidu.mobads.interfaces.download.activate.IXAppInfo;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.q;
import com.baidu.mobads.utils.t;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

public class b implements Observer {
  private static NotificationManager a;
  
  private static int b = 10091;
  
  private static HashMap<String, b> g = new HashMap<String, b>();
  
  private a c = null;
  
  private Context d;
  
  private com.baidu.mobads.a.b e = null;
  
  private String f = "";
  
  private Handler h = new Handler(Looper.getMainLooper());
  
  public b(Context paramContext, a parama) {
    XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdApkDownloaderObserver", "observer created");
    if (a == null)
      a = (NotificationManager)paramContext.getSystemService("notification"); 
    if (Build.VERSION.SDK_INT >= 26)
      ((NotificationManager)paramContext.getSystemService(NotificationManager.class)).createNotificationChannel(new NotificationChannel("down", "下载信息", 2)); 
    this.d = paramContext.getApplicationContext();
    this.c = parama;
    a(this.c.i, this);
  }
  
  public static b a(String paramString) {
    // Byte code:
    //   0: ldc com/baidu/mobads/openad/b/b
    //   2: monitorenter
    //   3: getstatic com/baidu/mobads/openad/b/b.g : Ljava/util/HashMap;
    //   6: aload_0
    //   7: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast com/baidu/mobads/openad/b/b
    //   13: astore_0
    //   14: ldc com/baidu/mobads/openad/b/b
    //   16: monitorexit
    //   17: aload_0
    //   18: areturn
    //   19: astore_0
    //   20: ldc com/baidu/mobads/openad/b/b
    //   22: monitorexit
    //   23: aload_0
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   3	14	19	finally
  }
  
  public static void a(String paramString, b paramb) {
    // Byte code:
    //   0: ldc com/baidu/mobads/openad/b/b
    //   2: monitorenter
    //   3: getstatic com/baidu/mobads/openad/b/b.g : Ljava/util/HashMap;
    //   6: aload_0
    //   7: aload_1
    //   8: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   11: pop
    //   12: ldc com/baidu/mobads/openad/b/b
    //   14: monitorexit
    //   15: return
    //   16: astore_0
    //   17: ldc com/baidu/mobads/openad/b/b
    //   19: monitorexit
    //   20: aload_0
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   3	12	16	finally
  }
  
  private Notification b(IOAdDownloader paramIOAdDownloader) {
    String str2;
    String str1 = this.c.a;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("正在下载 ");
    stringBuilder2.append(this.c.a);
    String str3 = stringBuilder2.toString();
    IOAdDownloader.DownloadStatus downloadStatus1 = this.c.g;
    IOAdDownloader.DownloadStatus downloadStatus2 = IOAdDownloader.DownloadStatus.COMPLETED;
    int i = 17301634;
    if (downloadStatus1 == downloadStatus2) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.c.g.getMessage());
      stringBuilder.append(": ");
      stringBuilder.append(str1);
      str1 = stringBuilder.toString();
      str2 = " 点击这里安装应用";
    } else if (this.c.g == IOAdDownloader.DownloadStatus.PAUSED) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.c.g.getMessage());
      stringBuilder.append(": ");
      stringBuilder.append(str1);
      str3 = stringBuilder.toString();
      if (!paramIOAdDownloader.isPausedManually()) {
        str1 = "目前不在wifi网络下， 点击这里继续下载";
      } else {
        str1 = "点击这里继续下载";
      } 
      str2 = str1;
      String str = "已为您暂停下载， 点击通知栏继续下载";
      str1 = str3;
      str3 = str;
    } else if (this.c.g == IOAdDownloader.DownloadStatus.ERROR) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.c.g.getMessage());
      stringBuilder.append(": ");
      stringBuilder.append(str1);
      str1 = stringBuilder.toString();
      str2 = " 稍后点击这里重新下载";
    } else {
      if (this.c.g == IOAdDownloader.DownloadStatus.DOWNLOADING) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.c.g.getMessage());
        stringBuilder.append(": ");
        stringBuilder.append(str1);
        str1 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("下载进度: ");
        stringBuilder.append(this.c.e);
        stringBuilder.append("%  应用大小: ");
        stringBuilder.append(this.f);
        str2 = stringBuilder.toString();
      } else if (this.c.g == IOAdDownloader.DownloadStatus.INITING) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.c.g.getMessage());
        stringBuilder.append(": ");
        stringBuilder.append(str1);
        str1 = stringBuilder.toString();
        str2 = this.c.g.getMessage();
      } else {
        str2 = "";
      } 
      i = 17301633;
    } 
    Intent intent = new Intent(this.d, AppActivity.getActivityClass());
    intent.putExtra("dealWithDownload", true);
    intent.putExtra("pausedManually", paramIOAdDownloader.isPausedManually());
    intent.putExtra("status", this.c.g.getCode());
    intent.putExtra("pk", this.c.i);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.c.c);
    stringBuilder1.append(this.c.b);
    intent.putExtra("localApkPath", stringBuilder1.toString());
    intent.putExtra("title", str1);
    intent.addFlags(268435456);
    intent.setAction(Long.toString(System.currentTimeMillis()));
    PendingIntent pendingIntent = PendingIntent.getActivity(this.d, this.c.f, intent, 134217728);
    if (Build.VERSION.SDK_INT >= 16) {
      if (Build.VERSION.SDK_INT >= 26) {
        this.c.h = new Notification.Builder(this.d, "down");
        return ((Notification.Builder)this.c.h).setContentTitle(str1).setContentText(str2).setTicker(str3).setSmallIcon(i).setContentIntent(pendingIntent).setAutoCancel(true).setProgress(100, this.c.e, false).build();
      } 
      this.c.h = new Notification.Builder(this.d);
      return ((Notification.Builder)this.c.h).setContentTitle(str1).setContentText(str2).setTicker(str3).setSmallIcon(i).setContentIntent(pendingIntent).setAutoCancel(true).setProgress(100, this.c.e, false).build();
    } 
    if (this.c.h == null)
      this.c.h = new Notification(); 
    Notification notification = (Notification)this.c.h;
    notification.icon = i;
    notification.flags |= 0x10;
    notification.tickerText = str3;
    notification.contentIntent = pendingIntent;
    try {
      notification.getClass().getMethod("setLatestEventInfo", new Class[] { Context.class, CharSequence.class, CharSequence.class, PendingIntent.class }).invoke(notification, new Object[] { this.d, str1, str2, pendingIntent });
    } catch (NoSuchMethodException|IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException noSuchMethodException) {}
    return notification;
  }
  
  public static b b(String paramString) {
    // Byte code:
    //   0: ldc com/baidu/mobads/openad/b/b
    //   2: monitorenter
    //   3: getstatic com/baidu/mobads/openad/b/b.g : Ljava/util/HashMap;
    //   6: aload_0
    //   7: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast com/baidu/mobads/openad/b/b
    //   13: astore_0
    //   14: ldc com/baidu/mobads/openad/b/b
    //   16: monitorexit
    //   17: aload_0
    //   18: areturn
    //   19: astore_0
    //   20: ldc com/baidu/mobads/openad/b/b
    //   22: monitorexit
    //   23: aload_0
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   3	14	19	finally
  }
  
  public static int c(String paramString) {
    // Byte code:
    //   0: ldc com/baidu/mobads/openad/b/b
    //   2: monitorenter
    //   3: getstatic com/baidu/mobads/openad/b/b.g : Ljava/util/HashMap;
    //   6: aload_0
    //   7: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast com/baidu/mobads/openad/b/b
    //   13: astore_0
    //   14: aload_0
    //   15: ifnull -> 38
    //   18: aload_0
    //   19: invokevirtual a : ()Lcom/baidu/mobads/command/a;
    //   22: ifnull -> 38
    //   25: aload_0
    //   26: invokevirtual a : ()Lcom/baidu/mobads/command/a;
    //   29: getfield f : I
    //   32: istore_1
    //   33: ldc com/baidu/mobads/openad/b/b
    //   35: monitorexit
    //   36: iload_1
    //   37: ireturn
    //   38: getstatic com/baidu/mobads/openad/b/b.b : I
    //   41: istore_1
    //   42: iload_1
    //   43: iconst_1
    //   44: iadd
    //   45: putstatic com/baidu/mobads/openad/b/b.b : I
    //   48: ldc com/baidu/mobads/openad/b/b
    //   50: monitorexit
    //   51: iload_1
    //   52: ireturn
    //   53: astore_0
    //   54: ldc com/baidu/mobads/openad/b/b
    //   56: monitorexit
    //   57: aload_0
    //   58: athrow
    // Exception table:
    //   from	to	target	type
    //   3	14	53	finally
    //   18	33	53	finally
    //   38	48	53	finally
  }
  
  private void d(String paramString) {
    Toast.makeText(this.d, paramString, 0).show();
  }
  
  public a a() {
    return this.c;
  }
  
  public void a(IOAdDownloader paramIOAdDownloader) {
    this.h.post(new c(this, paramIOAdDownloader));
  }
  
  public void update(Observable paramObservable, Object paramObject) {
    IOAdDownloader iOAdDownloader = (IOAdDownloader)paramObservable;
    this.c.g = iOAdDownloader.getState();
    paramObject = XAdSDKFoundationFacade.getInstance().getURIUitls().getFileName(iOAdDownloader.getOutputPath());
    if (!this.c.b.equals(paramObject))
      this.c.b = (String)paramObject; 
    if (this.c.g == IOAdDownloader.DownloadStatus.DOWNLOADING) {
      if (this.c.d < 0L) {
        XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdApkDownloaderObserver", "download update---mExtraInfo.contentLength < 0");
        this.c.d = iOAdDownloader.getFileSize();
        this.c.k = iOAdDownloader.getTargetURL();
        this.c.a(this.d);
        this.f = String.format(Locale.CHINA, "%.1fM", new Object[] { Float.valueOf((float)this.c.d / 1048576.0F) });
      } 
      if (iOAdDownloader.getProgress() > 0.0F) {
        int i = (int)iOAdDownloader.getProgress();
        if (i > this.c.e) {
          paramObject = this.c;
          ((a)paramObject).e = i;
          if (((a)paramObject).m) {
            a(iOAdDownloader);
            return;
          } 
        } 
      } 
    } else {
      if (this.c.g == IOAdDownloader.DownloadStatus.COMPLETED) {
        paramObject = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        t t = (t)XAdSDKFoundationFacade.getInstance().getSystemUtils();
        paramObject.sendDownloadAdLog(this.d, 528, "complete", this.c.q, this.c.i, paramObject.getAppId(this.d), "", t.getPhoneOSBrand(), Build.MODEL, Build.VERSION.RELEASE, Build.VERSION.SDK_INT);
        paramObject = XAdSDKFoundationFacade.getInstance().getAdLogger();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("download success-->>");
        stringBuilder.append(iOAdDownloader.getOutputPath());
        paramObject.d("OAdApkDownloaderObserver", stringBuilder.toString());
        boolean bool = this.c.l;
        if (bool) {
          XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdApkDownloaderObserver", "launch installing .............");
          paramObject = new StringBuilder();
          paramObject.append(this.c.c);
          paramObject.append(this.c.b);
          paramObject = paramObject.toString();
          if (!this.c.i.contains(".")) {
            IXAdPackageUtils.ApkInfo apkInfo = XAdSDKFoundationFacade.getInstance().getPackageUtils().getLocalApkFileInfo(this.d, (String)paramObject);
            this.c.i = apkInfo.packageName;
          } 
          if (this.e == null) {
            a a1 = new a(this.c);
            paramObject = new File((String)paramObject);
            this.e = new com.baidu.mobads.a.b(this.d, this.c.i, (File)paramObject, bool);
            this.e.a((BroadcastReceiver)a1);
            this.e.a();
          } 
        } 
        a.a().a(this.d, this.c);
        paramObject = a.a(this.c);
        if (paramObject != null)
          com.baidu.mobads.production.b.j().getXMonitorActivation(this.d, (IXAdLogger)q.a()).addAppInfoForMonitor((IXAppInfo)paramObject); 
      } else if (this.c.g == IOAdDownloader.DownloadStatus.ERROR) {
        this.c.k = iOAdDownloader.getTargetURL();
        paramObject = XAdSDKFoundationFacade.getInstance().getAdLogger();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("download failed-->>");
        stringBuilder.append(iOAdDownloader.getOutputPath());
        paramObject.d("OAdApkDownloaderObserver", stringBuilder.toString());
        a.a().a(this.c);
      } else if (iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.INITING) {
        paramObject = this.c;
        ((a)paramObject).r++;
      } 
      if (this.c.m)
        a(iOAdDownloader); 
      this.c.a(this.d);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\openad\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */