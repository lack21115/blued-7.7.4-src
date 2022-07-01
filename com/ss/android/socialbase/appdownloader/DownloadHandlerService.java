package com.ss.android.socialbase.appdownloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.c.d;
import com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity;
import com.ss.android.socialbase.downloader.b.f;
import com.ss.android.socialbase.downloader.d.ac;
import com.ss.android.socialbase.downloader.d.z;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.f.a;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.k.a;
import com.ss.android.socialbase.downloader.notification.a;
import com.ss.android.socialbase.downloader.notification.b;
import java.util.ArrayList;

public class DownloadHandlerService extends Service {
  private static final String a = DownloadHandlerService.class.getSimpleName();
  
  private void a(Context paramContext, int paramInt, boolean paramBoolean) {
    // Byte code:
    //   0: iload_3
    //   1: ifeq -> 53
    //   4: invokestatic a : ()Lcom/ss/android/socialbase/downloader/downloader/c;
    //   7: iload_2
    //   8: invokevirtual l : (I)Lcom/ss/android/socialbase/downloader/d/ac;
    //   11: astore #4
    //   13: aload #4
    //   15: ifnull -> 53
    //   18: aload_1
    //   19: invokestatic a : (Landroid/content/Context;)Lcom/ss/android/socialbase/downloader/downloader/f;
    //   22: iload_2
    //   23: invokevirtual h : (I)Lcom/ss/android/socialbase/downloader/g/c;
    //   26: astore #5
    //   28: aload #5
    //   30: ifnull -> 53
    //   33: aload #4
    //   35: aload #5
    //   37: invokeinterface b : (Lcom/ss/android/socialbase/downloader/g/c;)Z
    //   42: istore_3
    //   43: goto -> 55
    //   46: astore #4
    //   48: aload #4
    //   50: invokevirtual printStackTrace : ()V
    //   53: iconst_0
    //   54: istore_3
    //   55: iload_3
    //   56: ifeq -> 60
    //   59: return
    //   60: aload_1
    //   61: iload_2
    //   62: iconst_1
    //   63: invokestatic a : (Landroid/content/Context;IZ)I
    //   66: ifne -> 79
    //   69: aload_1
    //   70: ldc 'Open Fail!'
    //   72: iconst_0
    //   73: invokestatic makeText : (Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   76: invokevirtual show : ()V
    //   79: return
    // Exception table:
    //   from	to	target	type
    //   18	28	46	finally
    //   33	43	46	finally
  }
  
  private void a(Context paramContext, Intent paramIntent) {
    String str = paramIntent.getAction();
    boolean bool = false;
    try {
      c c;
      int i = paramIntent.getIntExtra("extra_click_download_ids", 0);
      boolean bool1 = paramIntent.getBooleanExtra("extra_from_notification", false);
      if ("android.ss.intent.action.DOWNLOAD_DELETE".equals(str)) {
        boolean bool2 = bool;
        if (bool1) {
          ac ac2 = c.a().l(i);
          ac ac1 = ac2;
          if (ac2 == null)
            ac1 = b.y(); 
          bool2 = bool;
          if (ac1 != null)
            try {
              c = f.a(paramContext).h(i);
            } finally {
              ac1 = null;
              ac1.printStackTrace();
            }  
        } 
        if (!bool2) {
          paramIntent = new Intent(paramContext, DownloadTaskDeleteActivity.class);
          paramIntent.putExtra("extra_click_download_ids", i);
          paramIntent.addFlags(268435456);
          paramContext.startActivity(paramIntent);
          b.a().a(i);
          return;
        } 
      } else if ("android.ss.intent.action.DOWNLOAD_OPEN".equals(c)) {
        a(paramContext, i, bool1);
        d d = d.h().b();
        z z = f.a((Context)this).i(i);
        if (d != null || z != null) {
          c c1 = f.a((Context)this).h(i);
          if (c1 != null)
            a(d, c1); 
        } 
        a a = a.a(i);
        boolean bool3 = true;
        boolean bool2 = bool3;
        if (a.a("notification_click_install_auto_cancel", 1) == 0) {
          a a1 = b.a().e(i);
          bool2 = bool3;
          if (a1 != null) {
            a1.g();
            a1.a(-3, null, false, true);
            bool2 = false;
          } 
        } 
        if (bool2) {
          b.a().a(i);
          return;
        } 
      } else if ("android.ss.intent.action.DOWNLOAD_HIDE".equals(c)) {
        b.a().a(i);
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private void a(d paramd, c paramc) {
    if (paramc == null)
      return; 
    z z = f.a((Context)this).i(paramc.g());
    if (paramd == null && z == null)
      return; 
    b.k().execute(new Runnable(this, paramc, paramd, z) {
          public void run() {
            // Byte code:
            //   0: new java/io/File
            //   3: dup
            //   4: aload_0
            //   5: getfield a : Lcom/ss/android/socialbase/downloader/g/c;
            //   8: invokevirtual k : ()Ljava/lang/String;
            //   11: aload_0
            //   12: getfield a : Lcom/ss/android/socialbase/downloader/g/c;
            //   15: invokevirtual h : ()Ljava/lang/String;
            //   18: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
            //   21: astore_2
            //   22: aload_2
            //   23: invokevirtual exists : ()Z
            //   26: istore_1
            //   27: iload_1
            //   28: ifeq -> 136
            //   31: invokestatic B : ()Landroid/content/Context;
            //   34: astore_3
            //   35: aload_3
            //   36: ifnull -> 137
            //   39: aload_3
            //   40: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
            //   43: aload_2
            //   44: invokevirtual getAbsolutePath : ()Ljava/lang/String;
            //   47: invokestatic a : ()I
            //   50: invokevirtual getPackageArchiveInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
            //   53: astore_2
            //   54: aload_2
            //   55: ifnull -> 137
            //   58: aload_2
            //   59: getfield packageName : Ljava/lang/String;
            //   62: astore_2
            //   63: goto -> 66
            //   66: aload_0
            //   67: getfield b : Lcom/ss/android/socialbase/appdownloader/c/d;
            //   70: ifnull -> 100
            //   73: aload_0
            //   74: getfield b : Lcom/ss/android/socialbase/appdownloader/c/d;
            //   77: aload_0
            //   78: getfield a : Lcom/ss/android/socialbase/downloader/g/c;
            //   81: invokevirtual g : ()I
            //   84: iconst_3
            //   85: aload_2
            //   86: bipush #-3
            //   88: aload_0
            //   89: getfield a : Lcom/ss/android/socialbase/downloader/g/c;
            //   92: invokevirtual aw : ()J
            //   95: invokeinterface a : (IILjava/lang/String;IJ)V
            //   100: aload_0
            //   101: getfield c : Lcom/ss/android/socialbase/downloader/d/z;
            //   104: ifnull -> 136
            //   107: aload_0
            //   108: getfield c : Lcom/ss/android/socialbase/downloader/d/z;
            //   111: iconst_3
            //   112: aload_0
            //   113: getfield a : Lcom/ss/android/socialbase/downloader/g/c;
            //   116: aload_2
            //   117: ldc ''
            //   119: invokeinterface a : (ILcom/ss/android/socialbase/downloader/g/c;Ljava/lang/String;Ljava/lang/String;)V
            //   124: return
            //   125: astore_2
            //   126: aload_2
            //   127: invokevirtual printStackTrace : ()V
            //   130: return
            //   131: astore_2
            //   132: aload_2
            //   133: invokevirtual printStackTrace : ()V
            //   136: return
            //   137: ldc ''
            //   139: astore_2
            //   140: goto -> 66
            // Exception table:
            //   from	to	target	type
            //   0	27	131	java/lang/Exception
            //   31	35	125	java/lang/Exception
            //   39	54	125	java/lang/Exception
            //   58	63	125	java/lang/Exception
            //   66	100	125	java/lang/Exception
            //   100	124	125	java/lang/Exception
            //   126	130	131	java/lang/Exception
          }
        });
  }
  
  private void a(c paramc, d paramd, z paramz) {
    int i = paramc.g();
    switch (paramc.q()) {
      default:
        return;
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
        f.a((Context)this).a(i);
        if (paramd != null)
          paramd.a(i, 5, "", paramc.q(), paramc.aw()); 
        if (paramz != null) {
          paramz.a(5, paramc, "", "");
          return;
        } 
        return;
      case -2:
        f.a((Context)this).c(i);
        if (paramd != null)
          paramd.a(i, 6, "", paramc.q(), paramc.aw()); 
        if (paramz != null) {
          paramz.a(6, paramc, "", "");
          return;
        } 
        return;
      case -3:
        c.a((Context)this, i, true);
        a(paramd, paramc);
        return;
      case -4:
      case -1:
        break;
    } 
    f.a((Context)this).e(i);
  }
  
  private boolean a(Intent paramIntent) {
    if (paramIntent == null)
      return false; 
    String str = paramIntent.getAction();
    if (TextUtils.isEmpty(str))
      return false; 
    d d = d.h().b();
    int i = paramIntent.getIntExtra("extra_click_download_ids", 0);
    int j = paramIntent.getIntExtra("extra_click_download_type", 0);
    z z = f.a((Context)this).i(i);
    if (str.equals("android.ss.intent.action.DOWNLOAD_OPEN") || str.equals("android.ss.intent.action.DOWNLOAD_DELETE") || str.equals("android.ss.intent.action.DOWNLOAD_HIDE")) {
      a((Context)this, paramIntent);
      if (str.equals("android.ss.intent.action.DOWNLOAD_DELETE")) {
        c c = f.a((Context)this).h(i);
        if (c != null) {
          c.P();
          if (d != null)
            d.a(i, 7, "", c.q(), c.aw()); 
          if (z != null)
            z.a(7, c, "", ""); 
        } 
      } 
      return false;
    } 
    if (str.equals("android.ss.intent.action.DOWNLOAD_CLICK")) {
      c c = f.a((Context)this).h(i);
      if (c == null)
        return false; 
      int k = c.q();
      if (k == 0)
        return false; 
      if (j == 1 || j == 4) {
        if (f.b(k)) {
          f.a((Context)this).a(i);
          if (d != null)
            d.a(i, 5, "", c.q(), c.aw()); 
          if (z != null)
            z.a(5, c, "", ""); 
        } else if (k == -3) {
          c.a((Context)this, i, true);
          a(d, c);
        } 
      } else if (j == 2) {
        if (k == -3) {
          c.a((Context)this, i, true);
          a(d, c);
        } else {
          f.a((Context)this).c(i);
          if (d != null)
            d.a(i, 6, "", c.q(), c.aw()); 
          if (z != null)
            z.a(6, c, "", ""); 
        } 
      } else if (j == 3) {
        if (k == -1 || k == -4) {
          f.a((Context)this).e(i);
        } else if (k == -3) {
          c.a((Context)this, i, true);
          a(d, c);
        } 
      } else {
        a(c, d, z);
      } 
      if (c.aB()) {
        b.a().a(i);
        b.a().f(i);
        return false;
      } 
    } else if (str.equals("android.intent.action.BOOT_COMPLETED") || str.equals("android.intent.action.MEDIA_MOUNTED")) {
      b.k().execute(new Runnable(this) {
            public void run() {
              try {
                ArrayList<String> arrayList = new ArrayList();
                arrayList.add("application/vnd.android.package-archive");
                arrayList.add("mime_type_plugin");
                f.a(b.B()).a(arrayList);
                return;
              } catch (Exception exception) {
                exception.printStackTrace();
                return;
              } 
            }
          });
      return true;
    } 
    return false;
  }
  
  public IBinder onBind(Intent paramIntent) {
    return null;
  }
  
  public void onCreate() {
    super.onCreate();
    b.a((Context)this);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    super.onStartCommand(paramIntent, paramInt1, paramInt2);
    if (a.a())
      a.b(a, "onStartCommand"); 
    a(paramIntent);
    stopSelf();
    return 2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\DownloadHandlerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */