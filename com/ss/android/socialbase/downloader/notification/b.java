package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.f.a;
import com.ss.android.socialbase.downloader.g.c;
import java.util.HashSet;
import java.util.Set;

public class b {
  private static volatile b a;
  
  private static final Object c = new Object();
  
  private final Set<String> b = new HashSet<String>();
  
  private final SparseArray<a> d = new SparseArray();
  
  public static b a() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/notification/b.a : Lcom/ss/android/socialbase/downloader/notification/b;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/socialbase/downloader/notification/b
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/downloader/notification/b.a : Lcom/ss/android/socialbase/downloader/notification/b;
    //   12: ifnonnull -> 25
    //   15: new com/ss/android/socialbase/downloader/notification/b
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/socialbase/downloader/notification/b.a : Lcom/ss/android/socialbase/downloader/notification/b;
    //   25: ldc com/ss/android/socialbase/downloader/notification/b
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/socialbase/downloader/notification/b
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/socialbase/downloader/notification/b.a : Lcom/ss/android/socialbase/downloader/notification/b;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  static boolean b(int paramInt) {
    return (paramInt != 1) ? ((paramInt == 3)) : true;
  }
  
  static boolean c(c paramc) {
    return (paramc.aB() && b(paramc.ae()));
  }
  
  public void a(int paramInt) {
    c c = f.a(com.ss.android.socialbase.downloader.downloader.b.B()).h(paramInt);
    if (c == null)
      return; 
    a(c);
    b(c);
  }
  
  public void a(int paramInt1, int paramInt2, Notification paramNotification) {
    Context context = com.ss.android.socialbase.downloader.downloader.b.B();
    if (context != null && paramInt1 != 0) {
      if (paramNotification == null)
        return; 
      try {
        Intent intent = new Intent(context, DownloadNotificationService.class);
        intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY");
        intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA", (Parcelable)paramNotification);
        intent.putExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", paramInt2);
        intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", paramInt1);
        return;
      } finally {
        paramNotification = null;
      } 
    } 
  }
  
  void a(c paramc) {
    k k = com.ss.android.socialbase.downloader.downloader.b.p();
    if (k == null)
      return; 
    if (paramc.aB()) {
      paramc.d(3);
      try {
        k.a(paramc);
        return;
      } catch (SQLiteException sQLiteException) {
        sQLiteException.printStackTrace();
      } 
    } 
  }
  
  public void a(a parama) {
    if (parama == null)
      return; 
    synchronized (this.d) {
      this.d.put(parama.a(), parama);
      return;
    } 
  }
  
  SparseArray<a> b() {
    synchronized (this.d) {
      return this.d;
    } 
  }
  
  void b(c paramc) {
    if (c(paramc))
      f(paramc.g()); 
  }
  
  public void c(int paramInt) {
    Context context = com.ss.android.socialbase.downloader.downloader.b.B();
    if (context != null) {
      if (paramInt == 0)
        return; 
      try {
        Intent intent = new Intent(context, DownloadNotificationService.class);
        intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
        intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", paramInt);
        return;
      } finally {
        context = null;
      } 
    } 
  }
  
  public a d(int paramInt) {
    if (paramInt == 0)
      return null; 
    synchronized (this.d) {
      a a = (a)this.d.get(paramInt);
      if (a != null) {
        this.d.remove(paramInt);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("removeNotificationId ");
        stringBuilder.append(paramInt);
        a.a(stringBuilder.toString());
      } 
      return a;
    } 
  }
  
  public a e(int paramInt) {
    if (paramInt == 0)
      return null; 
    synchronized (this.d) {
      return (a)this.d.get(paramInt);
    } 
  }
  
  public void f(int paramInt) {
    d(paramInt);
    if (paramInt != 0)
      a().c(paramInt); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\notification\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */