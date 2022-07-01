package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.k.a;
import com.ss.android.socialbase.downloader.m.f;
import java.util.ArrayList;

public class DownloadNotificationService extends Service {
  private static final String a = DownloadNotificationService.class.getSimpleName();
  
  private static int b = -1;
  
  private static int c = -1;
  
  private static boolean d = true;
  
  private static boolean e = false;
  
  private static volatile long f;
  
  private static volatile long g;
  
  private static boolean h;
  
  private static long i = 900L;
  
  private HandlerThread j;
  
  private Handler k;
  
  private void a(NotificationManager paramNotificationManager, int paramInt) {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/notification/DownloadNotificationService.b : I
    //   3: iload_2
    //   4: if_icmpeq -> 23
    //   7: getstatic com/ss/android/socialbase/downloader/notification/DownloadNotificationService.c : I
    //   10: iload_2
    //   11: if_icmpne -> 17
    //   14: goto -> 23
    //   17: aload_1
    //   18: iload_2
    //   19: invokevirtual cancel : (I)V
    //   22: return
    //   23: getstatic com/ss/android/socialbase/downloader/notification/DownloadNotificationService.b : I
    //   26: istore_3
    //   27: iconst_1
    //   28: istore #7
    //   30: iload_3
    //   31: iload_2
    //   32: if_icmpne -> 45
    //   35: iconst_0
    //   36: putstatic com/ss/android/socialbase/downloader/notification/DownloadNotificationService.b : I
    //   39: iconst_0
    //   40: istore #5
    //   42: goto -> 52
    //   45: iconst_0
    //   46: putstatic com/ss/android/socialbase/downloader/notification/DownloadNotificationService.c : I
    //   49: iconst_1
    //   50: istore #5
    //   52: invokestatic a : ()Lcom/ss/android/socialbase/downloader/downloader/c;
    //   55: iload_2
    //   56: invokevirtual c : (I)Lcom/ss/android/socialbase/downloader/downloader/n;
    //   59: astore #8
    //   61: aload #8
    //   63: invokeinterface b : ()Z
    //   68: istore #6
    //   70: iload #6
    //   72: ifne -> 134
    //   75: iconst_0
    //   76: putstatic com/ss/android/socialbase/downloader/notification/DownloadNotificationService.d : Z
    //   79: getstatic com/ss/android/socialbase/downloader/notification/DownloadNotificationService.a : Ljava/lang/String;
    //   82: astore #9
    //   84: new java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial <init> : ()V
    //   91: astore #10
    //   93: aload #10
    //   95: ldc 'try to stopForeground when is not Foreground, id = '
    //   97: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload #10
    //   103: iload_2
    //   104: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload #10
    //   110: ldc ', isIndependentProcess = '
    //   112: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload #10
    //   118: iload #5
    //   120: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload #9
    //   126: aload #10
    //   128: invokevirtual toString : ()Ljava/lang/String;
    //   131: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   134: getstatic com/ss/android/socialbase/downloader/notification/DownloadNotificationService.a : Ljava/lang/String;
    //   137: astore #9
    //   139: new java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial <init> : ()V
    //   146: astore #10
    //   148: aload #10
    //   150: ldc 'doCancel, ========== stopForeground id = '
    //   152: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload #10
    //   158: iload_2
    //   159: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload #10
    //   165: ldc ', isIndependentProcess = '
    //   167: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload #10
    //   173: iload #5
    //   175: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload #9
    //   181: aload #10
    //   183: invokevirtual toString : ()Ljava/lang/String;
    //   186: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload #8
    //   191: iconst_0
    //   192: iconst_1
    //   193: invokeinterface a : (ZZ)V
    //   198: goto -> 208
    //   201: astore #8
    //   203: aload #8
    //   205: invokevirtual printStackTrace : ()V
    //   208: aload_1
    //   209: iload_2
    //   210: invokevirtual cancel : (I)V
    //   213: goto -> 216
    //   216: getstatic com/ss/android/socialbase/downloader/notification/DownloadNotificationService.d : Z
    //   219: ifne -> 223
    //   222: return
    //   223: invokestatic a : ()Lcom/ss/android/socialbase/downloader/notification/b;
    //   226: invokevirtual b : ()Landroid/util/SparseArray;
    //   229: astore #9
    //   231: aload #9
    //   233: ifnull -> 450
    //   236: aload #9
    //   238: invokevirtual size : ()I
    //   241: iconst_1
    //   242: isub
    //   243: istore_3
    //   244: iload_3
    //   245: iflt -> 450
    //   248: aload #9
    //   250: iload_3
    //   251: invokevirtual valueAt : (I)Ljava/lang/Object;
    //   254: checkcast com/ss/android/socialbase/downloader/notification/a
    //   257: astore #8
    //   259: aload #8
    //   261: ifnull -> 443
    //   264: aload #8
    //   266: invokevirtual a : ()I
    //   269: istore #4
    //   271: iload #4
    //   273: iload_2
    //   274: if_icmpeq -> 443
    //   277: iload #4
    //   279: getstatic com/ss/android/socialbase/downloader/notification/DownloadNotificationService.b : I
    //   282: if_icmpeq -> 443
    //   285: iload #4
    //   287: getstatic com/ss/android/socialbase/downloader/notification/DownloadNotificationService.c : I
    //   290: if_icmpeq -> 443
    //   293: aload #8
    //   295: invokevirtual i : ()Z
    //   298: ifeq -> 443
    //   301: invokestatic a : ()Lcom/ss/android/socialbase/downloader/downloader/c;
    //   304: aload #8
    //   306: invokevirtual a : ()I
    //   309: invokevirtual a : (I)I
    //   312: iconst_1
    //   313: if_icmpne -> 430
    //   316: invokestatic c : ()Z
    //   319: ifne -> 430
    //   322: iconst_1
    //   323: istore #6
    //   325: goto -> 433
    //   328: aload #8
    //   330: ifnull -> 422
    //   333: aload #8
    //   335: invokevirtual a : ()I
    //   338: istore_2
    //   339: aload_1
    //   340: iload_2
    //   341: invokevirtual cancel : (I)V
    //   344: goto -> 352
    //   347: astore_1
    //   348: aload_1
    //   349: invokevirtual printStackTrace : ()V
    //   352: aload_0
    //   353: invokestatic a : (Landroid/content/Context;)Lcom/ss/android/socialbase/downloader/downloader/f;
    //   356: iload_2
    //   357: invokevirtual f : (I)I
    //   360: iconst_1
    //   361: if_icmpne -> 456
    //   364: iload #7
    //   366: istore #5
    //   368: goto -> 371
    //   371: getstatic com/ss/android/socialbase/downloader/notification/DownloadNotificationService.a : Ljava/lang/String;
    //   374: astore_1
    //   375: new java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial <init> : ()V
    //   382: astore #9
    //   384: aload #9
    //   386: ldc 'doCancel, updateNotification id = '
    //   388: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload #9
    //   394: iload_2
    //   395: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload_1
    //   400: aload #9
    //   402: invokevirtual toString : ()Ljava/lang/String;
    //   405: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   408: aload #8
    //   410: aconst_null
    //   411: iload #5
    //   413: invokevirtual a : (Lcom/ss/android/socialbase/downloader/e/a;Z)V
    //   416: return
    //   417: astore_1
    //   418: aload_1
    //   419: invokevirtual printStackTrace : ()V
    //   422: return
    //   423: astore_1
    //   424: return
    //   425: astore #8
    //   427: goto -> 216
    //   430: iconst_0
    //   431: istore #6
    //   433: iload #6
    //   435: iload #5
    //   437: if_icmpne -> 443
    //   440: goto -> 328
    //   443: iload_3
    //   444: iconst_1
    //   445: isub
    //   446: istore_3
    //   447: goto -> 244
    //   450: aconst_null
    //   451: astore #8
    //   453: goto -> 328
    //   456: iconst_0
    //   457: istore #5
    //   459: goto -> 371
    // Exception table:
    //   from	to	target	type
    //   17	22	423	finally
    //   52	70	201	finally
    //   75	134	201	finally
    //   134	198	201	finally
    //   208	213	425	finally
    //   223	231	417	finally
    //   236	244	417	finally
    //   248	259	417	finally
    //   264	271	417	finally
    //   277	322	417	finally
    //   333	339	417	finally
    //   339	344	347	finally
    //   348	352	417	finally
    //   352	364	417	finally
    //   371	416	417	finally
  }
  
  private void a(NotificationManager paramNotificationManager, int paramInt, Notification paramNotification) {
    long l2 = i - System.currentTimeMillis() - f;
    long l1 = l2;
    if (l2 <= 0L)
      l1 = 0L; 
    l2 = l1;
    if (l1 > 20000L)
      l2 = 20000L; 
    l1 = System.currentTimeMillis() + l2;
    g = l1;
    f = l1;
    if (l2 <= 0L) {
      b(paramNotificationManager, paramInt, paramNotification);
      return;
    } 
    Handler handler = this.k;
    if (handler != null)
      handler.postDelayed(new Runnable(this, paramNotificationManager, paramInt, paramNotification) {
            public void run() {
              DownloadNotificationService.a(this.d, this.a, this.b, this.c);
            }
          }l2); 
  }
  
  private void a(Intent paramIntent) {
    if (paramIntent == null)
      return; 
    String str = paramIntent.getAction();
    if (TextUtils.isEmpty(str))
      return; 
    Handler handler = this.k;
    if (handler != null)
      handler.post(new Runnable(this, paramIntent, str) {
            public void run() {
              Runnable runnable;
              NotificationManager notificationManager = (NotificationManager)this.c.getSystemService("notification");
              int i = this.a.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
              if (this.b.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY")) {
                Notification notification = (Notification)this.a.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
                int j = this.a.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
                if (i != 0 && notification != null && notificationManager != null)
                  if (j == 4) {
                    if (!f.a(b.B()).g(i))
                      return; 
                    c c = f.a(b.B()).h(i);
                    if (DownloadNotificationService.a()) {
                      if (c != null && c.a() && System.currentTimeMillis() - DownloadNotificationService.b() > DownloadNotificationService.c()) {
                        DownloadNotificationService.a(this.c, notificationManager, i, notification);
                        c.b();
                        return;
                      } 
                    } else if (c != null && c.a()) {
                      DownloadNotificationService.a(this.c, notificationManager, i, notification);
                      c.b();
                      return;
                    } 
                  } else {
                    if (j == -2 || j == -3) {
                      if (DownloadNotificationService.a()) {
                        DownloadNotificationService.b(this.c, notificationManager, i, notification);
                        return;
                      } 
                      if (DownloadNotificationService.a(this.c) != null) {
                        long l;
                        Handler handler = DownloadNotificationService.a(this.c);
                        runnable = new Runnable(this, notificationManager, i, notification) {
                            public void run() {
                              DownloadNotificationService.a(this.d.c, this.a, this.b, this.c);
                            }
                          };
                        if (j == -2) {
                          l = 50L;
                        } else {
                          l = 200L;
                        } 
                        handler.postDelayed(runnable, l);
                        return;
                      } 
                      return;
                    } 
                    if (DownloadNotificationService.a()) {
                      DownloadNotificationService.b(this.c, (NotificationManager)runnable, i, notification);
                      return;
                    } 
                    DownloadNotificationService.a(this.c, (NotificationManager)runnable, i, notification);
                    return;
                  }  
              } else if (this.b.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL")) {
                if (i != 0) {
                  DownloadNotificationService.a(this.c, (NotificationManager)runnable, i);
                  return;
                } 
              } else if (this.b.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                try {
                  if (f.a((Context)this.c, "android.permission.ACCESS_NETWORK_STATE")) {
                    ConnectivityManager connectivityManager = (ConnectivityManager)this.c.getSystemService("connectivity");
                    if (connectivityManager == null)
                      return; 
                    NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                    if (networkInfo != null) {
                      if (!networkInfo.isConnected())
                        return; 
                      ArrayList<String> arrayList = new ArrayList();
                      arrayList.add("application/vnd.android.package-archive");
                      arrayList.add("mime_type_plugin");
                      Context context = this.c.getApplicationContext();
                      if (context != null) {
                        f.a(context).a(arrayList);
                        return;
                      } 
                    } else {
                      return;
                    } 
                  } else {
                    return;
                  } 
                } catch (Exception exception) {
                  exception.printStackTrace();
                  return;
                } 
              } else if (this.b.equals("android.intent.action.MEDIA_UNMOUNTED") || this.b.equals("android.intent.action.MEDIA_REMOVED") || this.b.equals("android.intent.action.MEDIA_BAD_REMOVAL") || this.b.equals("android.intent.action.MEDIA_EJECT")) {
                try {
                  f.a((Context)this.c).a();
                  return;
                } catch (Exception exception) {
                  exception.printStackTrace();
                } 
              } 
            }
          }); 
  }
  
  private boolean a(int paramInt, Notification paramNotification) {
    if (!d)
      return false; 
    int i = b;
    if (i != paramInt) {
      int j = c;
      return (j == paramInt) ? false : ((i != 0 && j != 0) ? false : ((e && (paramNotification.flags & 0x2) == 0) ? false : (!(Build.VERSION.SDK_INT >= 26 && TextUtils.isEmpty(paramNotification.getChannelId())))));
    } 
    return false;
  }
  
  private void b(NotificationManager paramNotificationManager, int paramInt, Notification paramNotification) {
    if (a(paramInt, paramNotification)) {
      try {
        boolean bool2;
        int i = c.a().a(paramInt);
        boolean bool1 = true;
        if (i == 1 && !f.c()) {
          bool2 = true;
        } else {
          bool2 = false;
        } 
        if ((bool2 || b != 0) && (!bool2 || c != 0))
          bool1 = false; 
      } finally {
        Exception exception = null;
      } 
    } else if ((b == paramInt || c == paramInt) && e && (paramNotification.flags & 0x2) == 0) {
      a(paramNotificationManager, paramInt);
    } 
    try {
      long l = System.currentTimeMillis();
      if (f < l)
        f = l; 
      return;
    } finally {
      paramNotificationManager = null;
    } 
  }
  
  private void d() {
    if (this.j == null) {
      this.j = new HandlerThread("DownloaderNotifyThread");
      this.j.start();
      this.k = new Handler(this.j.getLooper());
    } 
  }
  
  public IBinder onBind(Intent paramIntent) {
    return null;
  }
  
  public void onCreate() {
    super.onCreate();
    d();
    b.a((Context)this);
    a a = a.b();
    int i = a.a("download_service_foreground", 0);
    if ((i == 1 || i == 3) && b == -1)
      b = 0; 
    if ((i == 2 || i == 3) && c == -1)
      c = 0; 
    e = a.b("non_going_notification_foreground", false);
    h = a.b("notify_too_fast", false);
    i = a.a("notification_time_window", 900L);
    long l = i;
    if (l < 0L || l > 1200L)
      i = 900L; 
  }
  
  public void onDestroy() {
    super.onDestroy();
    HandlerThread handlerThread = this.j;
    if (handlerThread != null) {
      try {
        handlerThread.quit();
      } finally {}
      this.j = null;
      this.k = null;
    } 
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    a(paramIntent);
    return 2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\notification\DownloadNotificationService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */