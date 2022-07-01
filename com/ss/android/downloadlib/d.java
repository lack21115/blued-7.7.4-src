package com.ss.android.downloadlib;

import com.ss.android.downloadlib.e.g;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class d {
  private final ThreadPoolExecutor a;
  
  private d() {
    TimeUnit timeUnit = TimeUnit.SECONDS;
    SynchronousQueue<Runnable> synchronousQueue = new SynchronousQueue();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(h.class.getName());
    stringBuilder.append("-ThreadPool");
    this.a = new ThreadPoolExecutor(0, 2147483647, 30L, timeUnit, synchronousQueue, (ThreadFactory)new com.ss.android.socialbase.downloader.l.a(stringBuilder.toString()));
  }
  
  public static d a() {
    return a.a();
  }
  
  public void a(Runnable paramRunnable) {
    try {
      return;
    } finally {
      paramRunnable = null;
      paramRunnable.printStackTrace();
    } 
  }
  
  public ThreadPoolExecutor b() {
    return this.a;
  }
  
  public void b(Runnable paramRunnable) {
    if (g.a()) {
      a(paramRunnable);
      return;
    } 
    paramRunnable.run();
  }
  
  public void c() {
    a(new Runnable(this) {
          public void run() {
            // Byte code:
            //   0: ldc com/ss/android/downloadlib/d
            //   2: monitorenter
            //   3: bipush #8
            //   5: anewarray java/lang/String
            //   8: astore #4
            //   10: aload #4
            //   12: iconst_0
            //   13: ldc 'sp_ad_download_event'
            //   15: aastore
            //   16: aload #4
            //   18: iconst_1
            //   19: ldc 'sp_download_finish_cache'
            //   21: aastore
            //   22: aload #4
            //   24: iconst_2
            //   25: ldc 'sp_delay_operation_info'
            //   27: aastore
            //   28: aload #4
            //   30: iconst_3
            //   31: ldc 'sp_ttdownloader_md5'
            //   33: aastore
            //   34: aload #4
            //   36: iconst_4
            //   37: ldc 'sp_name_installed_app'
            //   39: aastore
            //   40: aload #4
            //   42: iconst_5
            //   43: ldc 'misc_config'
            //   45: aastore
            //   46: aload #4
            //   48: bipush #6
            //   50: ldc 'sp_ad_install_back_dialog'
            //   52: aastore
            //   53: aload #4
            //   55: bipush #7
            //   57: ldc 'sp_appdownloader'
            //   59: aastore
            //   60: aload #4
            //   62: arraylength
            //   63: istore_2
            //   64: iconst_0
            //   65: istore_1
            //   66: iload_1
            //   67: iload_2
            //   68: if_icmpge -> 113
            //   71: aload #4
            //   73: iload_1
            //   74: aaload
            //   75: astore #5
            //   77: invokestatic a : ()Landroid/content/Context;
            //   80: aload #5
            //   82: iconst_0
            //   83: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
            //   86: astore #5
            //   88: aload #5
            //   90: ifnull -> 216
            //   93: aload #5
            //   95: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
            //   100: invokeinterface clear : ()Landroid/content/SharedPreferences$Editor;
            //   105: invokeinterface apply : ()V
            //   110: goto -> 216
            //   113: invokestatic p : ()Lcom/ss/android/socialbase/downloader/downloader/k;
            //   116: astore #4
            //   118: aload #4
            //   120: instanceof com/ss/android/socialbase/downloader/impls/d
            //   123: istore_3
            //   124: iload_3
            //   125: ifne -> 132
            //   128: ldc com/ss/android/downloadlib/d
            //   130: monitorexit
            //   131: return
            //   132: aload #4
            //   134: checkcast com/ss/android/socialbase/downloader/impls/d
            //   137: invokevirtual a : ()Lcom/ss/android/socialbase/downloader/impls/k;
            //   140: invokevirtual a : ()Landroid/util/SparseArray;
            //   143: astore #4
            //   145: aload #4
            //   147: invokevirtual size : ()I
            //   150: iconst_1
            //   151: isub
            //   152: istore_1
            //   153: iload_1
            //   154: iflt -> 199
            //   157: aload #4
            //   159: aload #4
            //   161: iload_1
            //   162: invokevirtual keyAt : (I)I
            //   165: invokevirtual get : (I)Ljava/lang/Object;
            //   168: checkcast com/ss/android/socialbase/downloader/g/c
            //   171: astore #5
            //   173: aload #5
            //   175: ifnull -> 192
            //   178: invokestatic a : ()Landroid/content/Context;
            //   181: invokestatic a : (Landroid/content/Context;)Lcom/ss/android/socialbase/downloader/downloader/f;
            //   184: aload #5
            //   186: invokevirtual g : ()I
            //   189: invokevirtual j : (I)V
            //   192: iload_1
            //   193: iconst_1
            //   194: isub
            //   195: istore_1
            //   196: goto -> 153
            //   199: ldc com/ss/android/downloadlib/d
            //   201: monitorexit
            //   202: return
            //   203: astore #4
            //   205: ldc com/ss/android/downloadlib/d
            //   207: monitorexit
            //   208: aload #4
            //   210: athrow
            //   211: astore #4
            //   213: goto -> 199
            //   216: iload_1
            //   217: iconst_1
            //   218: iadd
            //   219: istore_1
            //   220: goto -> 66
            // Exception table:
            //   from	to	target	type
            //   3	10	211	finally
            //   60	64	211	finally
            //   77	88	211	finally
            //   93	110	211	finally
            //   113	124	211	finally
            //   128	131	203	finally
            //   132	153	211	finally
            //   157	173	211	finally
            //   178	192	211	finally
            //   199	202	203	finally
            //   205	208	203	finally
          }
        });
  }
  
  static class a {
    private static d a = new d();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */