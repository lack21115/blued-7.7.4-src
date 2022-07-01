package com.ss.android.socialbase.downloader.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.s;
import com.ss.android.socialbase.downloader.g.b;
import com.ss.android.socialbase.downloader.g.c;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class f implements ServiceConnection, s {
  private static boolean b;
  
  private static int c;
  
  private static long d;
  
  private c a;
  
  private Handler e = new Handler(Looper.getMainLooper());
  
  private b f = null;
  
  private CountDownLatch g = new CountDownLatch(1);
  
  private a h;
  
  private Runnable i = new Runnable(this) {
      public void run() {
        if (!f.e() && f.a(this.a) != null)
          f.a(this.a).a(); 
      }
    };
  
  public f() {
    SqlDownloadCacheService.a(b.B(), this);
  }
  
  private boolean f() {
    if (Build.VERSION.SDK_INT >= 26)
      return false; 
    if (b)
      return false; 
    if (c > 5) {
      com.ss.android.socialbase.downloader.f.a.d("SqlDownloadCacheAidlWra", "bindMainProcess: bind too many times!!! ");
      return false;
    } 
    long l = System.currentTimeMillis();
    if (l - d < 15000L) {
      com.ss.android.socialbase.downloader.f.a.d("SqlDownloadCacheAidlWra", "bindMainProcess: time too short since last bind!!! ");
      return false;
    } 
    c++;
    d = l;
    this.e.postDelayed(new Runnable(this) {
          public void run() {
            SqlDownloadCacheService.a(b.B(), this.a);
          }
        }1000L);
    return true;
  }
  
  public c a(int paramInt1, int paramInt2) {
    try {
      if (this.a != null)
        return this.a.a(paramInt1, paramInt2); 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    return null;
  }
  
  public c a(int paramInt, long paramLong) {
    try {
      if (this.a != null)
        return this.a.a(paramInt, paramLong); 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    return null;
  }
  
  public c a(int paramInt, long paramLong, String paramString1, String paramString2) {
    try {
      if (this.a != null)
        return this.a.a(paramInt, paramLong, paramString1, paramString2); 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    return null;
  }
  
  public List<c> a(String paramString) {
    try {
      if (this.a != null)
        return this.a.a(paramString); 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    return null;
  }
  
  public void a() {
    try {
      this.g.await(5000L, TimeUnit.MILLISECONDS);
    } catch (InterruptedException interruptedException) {
      interruptedException.printStackTrace();
    } 
    try {
      if (this.a != null) {
        this.a.a();
        return;
      } 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    try {
      if (this.a != null) {
        this.a.a(paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      } 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
    try {
      if (this.a != null) {
        this.a.a(paramInt1, paramInt2, paramInt3, paramLong);
        return;
      } 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong) {
    try {
      if (this.a != null) {
        this.a.a(paramInt1, paramInt2, paramLong);
        return;
      } 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
  }
  
  public void a(int paramInt, List<b> paramList) {
    try {
      if (this.a != null) {
        this.a.a(paramInt, paramList);
        return;
      } 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
  }
  
  public void a(SparseArray<c> paramSparseArray, SparseArray<List<b>> paramSparseArray1, d paramd) {
    b.k().submit(new Runnable(this, paramSparseArray, paramSparseArray1, paramd) {
          public void run() {
            this.d.a(new b.a(this) {
                  public void a(Map param2Map1, Map param2Map2) {
                    com.ss.android.socialbase.downloader.m.f.a(this.a.a, param2Map1);
                    com.ss.android.socialbase.downloader.m.f.a(this.a.b, param2Map2);
                    this.a.c.a();
                    this.a.d.a((b)null);
                  }
                });
            this.d.a();
          }
        });
  }
  
  public void a(b paramb) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Lcom/ss/android/socialbase/downloader/c/c;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull -> 32
    //   11: aload_0
    //   12: getfield a : Lcom/ss/android/socialbase/downloader/c/c;
    //   15: aload_1
    //   16: invokeinterface a : (Lcom/ss/android/socialbase/downloader/c/b;)V
    //   21: goto -> 37
    //   24: astore_1
    //   25: aload_1
    //   26: invokevirtual printStackTrace : ()V
    //   29: goto -> 37
    //   32: aload_0
    //   33: aload_1
    //   34: putfield f : Lcom/ss/android/socialbase/downloader/c/b;
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	40	finally
    //   11	21	24	android/os/RemoteException
    //   11	21	40	finally
    //   25	29	40	finally
    //   32	37	40	finally
    //   37	39	40	finally
    //   41	43	40	finally
  }
  
  public void a(a parama) {
    this.h = parama;
  }
  
  public void a(b paramb) {
    try {
      if (this.a != null) {
        this.a.a(paramb);
        return;
      } 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
  }
  
  public boolean a(c paramc) {
    try {
      if (this.a != null)
        return this.a.a(paramc); 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    return false;
  }
  
  public c b(int paramInt) {
    try {
      if (this.a != null)
        return this.a.b(paramInt); 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    return null;
  }
  
  public c b(int paramInt, long paramLong) {
    try {
      if (this.a != null)
        return this.a.b(paramInt, paramLong); 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    return null;
  }
  
  public List<c> b(String paramString) {
    try {
      if (this.a != null)
        return this.a.b(paramString); 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    return null;
  }
  
  public void b() {
    try {
      if (this.a != null) {
        this.a.b();
        return;
      } 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
  }
  
  public void b(int paramInt, List<b> paramList) {
    try {
      if (this.a != null) {
        this.a.b(paramInt, paramList);
        return;
      } 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
  }
  
  public void b(b paramb) {
    try {
      if (this.a != null) {
        this.a.b(paramb);
        return;
      } 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
  }
  
  public void b(c paramc) {
    try {
      if (this.a != null) {
        this.a.b(paramc);
        return;
      } 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
  }
  
  public c c(int paramInt, long paramLong) {
    try {
      if (this.a != null)
        return this.a.c(paramInt, paramLong); 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    return null;
  }
  
  public List<b> c(int paramInt) {
    try {
      if (this.a != null)
        return this.a.c(paramInt); 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    return null;
  }
  
  public List<c> c(String paramString) {
    try {
      if (this.a != null)
        return this.a.c(paramString); 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    return null;
  }
  
  public boolean c() {
    try {
      if (this.a != null)
        return this.a.c(); 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    return false;
  }
  
  public c d(int paramInt, long paramLong) {
    try {
      if (this.a != null)
        return this.a.d(paramInt, paramLong); 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    return null;
  }
  
  public List<c> d(String paramString) {
    try {
      if (this.a != null)
        return this.a.d(paramString); 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    return null;
  }
  
  public void d(int paramInt) {
    try {
      if (this.a != null) {
        this.a.d(paramInt);
        return;
      } 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
  }
  
  public boolean d() {
    try {
      if (this.a != null)
        return this.a.d(); 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    return false;
  }
  
  public boolean e(int paramInt) {
    try {
      if (this.a != null)
        return this.a.e(paramInt); 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    return false;
  }
  
  public boolean f(int paramInt) {
    try {
      if (this.a != null)
        return this.a.f(paramInt); 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    return false;
  }
  
  public c g(int paramInt) {
    try {
      if (this.a != null)
        return this.a.g(paramInt); 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    return null;
  }
  
  public c h(int paramInt) {
    try {
      if (this.a != null)
        return this.a.h(paramInt); 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    return null;
  }
  
  public c i(int paramInt) {
    try {
      if (this.a != null)
        return this.a.i(paramInt); 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    return null;
  }
  
  public c j(int paramInt) {
    try {
      if (this.a != null)
        return this.a.j(paramInt); 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    return null;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    // Byte code:
    //   0: iconst_1
    //   1: putstatic com/ss/android/socialbase/downloader/c/f.b : Z
    //   4: aload_0
    //   5: getfield e : Landroid/os/Handler;
    //   8: aload_0
    //   9: getfield i : Ljava/lang/Runnable;
    //   12: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   15: aload_0
    //   16: monitorenter
    //   17: aload_0
    //   18: aload_2
    //   19: invokestatic a : (Landroid/os/IBinder;)Lcom/ss/android/socialbase/downloader/c/c;
    //   22: putfield a : Lcom/ss/android/socialbase/downloader/c/c;
    //   25: aload_0
    //   26: getfield f : Lcom/ss/android/socialbase/downloader/c/b;
    //   29: ifnull -> 52
    //   32: aload_0
    //   33: getfield a : Lcom/ss/android/socialbase/downloader/c/c;
    //   36: ifnull -> 52
    //   39: aload_0
    //   40: getfield a : Lcom/ss/android/socialbase/downloader/c/c;
    //   43: aload_0
    //   44: getfield f : Lcom/ss/android/socialbase/downloader/c/b;
    //   47: invokeinterface a : (Lcom/ss/android/socialbase/downloader/c/b;)V
    //   52: aload_2
    //   53: new com/ss/android/socialbase/downloader/c/f$2
    //   56: dup
    //   57: aload_0
    //   58: invokespecial <init> : (Lcom/ss/android/socialbase/downloader/c/f;)V
    //   61: iconst_0
    //   62: invokeinterface linkToDeath : (Landroid/os/IBinder$DeathRecipient;I)V
    //   67: aload_0
    //   68: getfield g : Ljava/util/concurrent/CountDownLatch;
    //   71: astore_1
    //   72: aload_1
    //   73: invokevirtual countDown : ()V
    //   76: goto -> 113
    //   79: astore_1
    //   80: ldc 'SqlDownloadCacheAidlWra'
    //   82: ldc_w 'onServiceConnected fail'
    //   85: aload_1
    //   86: invokestatic b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   89: aload_0
    //   90: getfield h : Lcom/ss/android/socialbase/downloader/c/f$a;
    //   93: ifnull -> 105
    //   96: aload_0
    //   97: getfield h : Lcom/ss/android/socialbase/downloader/c/f$a;
    //   100: invokeinterface a : ()V
    //   105: aload_0
    //   106: getfield g : Ljava/util/concurrent/CountDownLatch;
    //   109: astore_1
    //   110: goto -> 72
    //   113: aload_0
    //   114: monitorexit
    //   115: return
    //   116: astore_1
    //   117: aload_0
    //   118: getfield g : Ljava/util/concurrent/CountDownLatch;
    //   121: invokevirtual countDown : ()V
    //   124: aload_1
    //   125: athrow
    //   126: astore_1
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_1
    //   130: athrow
    // Exception table:
    //   from	to	target	type
    //   17	52	79	finally
    //   52	67	79	finally
    //   67	72	126	finally
    //   72	76	126	finally
    //   80	105	116	finally
    //   105	110	126	finally
    //   113	115	126	finally
    //   117	126	126	finally
    //   127	129	126	finally
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {
    this.a = null;
    b = false;
  }
  
  public static interface a {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */