package com.ss.android.socialbase.downloader.impls;

import android.os.Handler;
import com.ss.android.socialbase.downloader.b.f;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.f.a;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.g.d;
import com.ss.android.socialbase.downloader.l.c;
import com.ss.android.socialbase.downloader.l.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class e extends a {
  private static d b;
  
  public e() {
    b = new d();
  }
  
  public static void b(List<Callable<Object>> paramList) throws InterruptedException {
    ExecutorService executorService = b.l();
    if (executorService != null)
      executorService.invokeAll(paramList); 
  }
  
  public static List<Future> c(List<Runnable> paramList) {
    ExecutorService executorService = b.l();
    ArrayList<Future<?>> arrayList = new ArrayList(paramList.size());
    Iterator<Runnable> iterator = paramList.iterator();
    while (iterator.hasNext())
      arrayList.add(executorService.submit(iterator.next())); 
    return (List)arrayList;
  }
  
  public static Runnable d(List<Future> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 146
    //   4: aload_0
    //   5: invokeinterface isEmpty : ()Z
    //   10: ifeq -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: invokestatic l : ()Ljava/util/concurrent/ExecutorService;
    //   18: astore_1
    //   19: aload_1
    //   20: instanceof java/util/concurrent/ThreadPoolExecutor
    //   23: ifeq -> 146
    //   26: aload_1
    //   27: checkcast java/util/concurrent/ThreadPoolExecutor
    //   30: invokevirtual getQueue : ()Ljava/util/concurrent/BlockingQueue;
    //   33: astore_1
    //   34: aload_1
    //   35: ifnull -> 146
    //   38: aload_1
    //   39: invokeinterface isEmpty : ()Z
    //   44: ifne -> 146
    //   47: aload_0
    //   48: invokeinterface iterator : ()Ljava/util/Iterator;
    //   53: astore_2
    //   54: aload_2
    //   55: invokeinterface hasNext : ()Z
    //   60: ifeq -> 148
    //   63: aload_2
    //   64: invokeinterface next : ()Ljava/lang/Object;
    //   69: checkcast java/util/concurrent/Future
    //   72: astore_3
    //   73: aload_3
    //   74: instanceof java/lang/Runnable
    //   77: ifeq -> 54
    //   80: aload_1
    //   81: aload_3
    //   82: invokeinterface remove : (Ljava/lang/Object;)Z
    //   87: ifeq -> 54
    //   90: aload_3
    //   91: checkcast java/lang/Runnable
    //   94: astore_1
    //   95: goto -> 98
    //   98: aload_1
    //   99: ifnull -> 146
    //   102: aload_0
    //   103: aload_1
    //   104: invokeinterface remove : (Ljava/lang/Object;)Z
    //   109: pop
    //   110: aload_1
    //   111: areturn
    //   112: astore_0
    //   113: new java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial <init> : ()V
    //   120: astore_1
    //   121: aload_1
    //   122: ldc 'getUnstartedTask() error: '
    //   124: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_1
    //   129: aload_0
    //   130: invokevirtual toString : ()Ljava/lang/String;
    //   133: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: ldc 'DefaultDownloadEngine'
    //   139: aload_1
    //   140: invokevirtual toString : ()Ljava/lang/String;
    //   143: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   146: aconst_null
    //   147: areturn
    //   148: aconst_null
    //   149: astore_1
    //   150: goto -> 98
    // Exception table:
    //   from	to	target	type
    //   15	34	112	finally
    //   38	54	112	finally
    //   54	95	112	finally
    //   102	110	112	finally
  }
  
  public List<Integer> a() {
    return b.a();
  }
  
  public void a(int paramInt, d paramd) {
    if (paramd == null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("start doDownload for task : ");
    stringBuilder.append(paramInt);
    a.b("DownloadTask", stringBuilder.toString());
    c c = new c(paramd, (Handler)this.a);
    b.a(c);
  }
  
  public void a(c paramc) {
    d d1 = b;
    if (d1 == null)
      return; 
    d1.b(paramc);
  }
  
  public boolean a(int paramInt) {
    d d1 = b;
    if (d1 == null)
      return false; 
    if (!d1.a(paramInt))
      return false; 
    c c = d(paramInt);
    if (c == null)
      return false; 
    if (!f.b(c.q())) {
      b(paramInt);
      return false;
    } 
    return true;
  }
  
  public void b(int paramInt) {
    d d1 = b;
    if (d1 == null)
      return; 
    d1.c(paramInt);
  }
  
  protected c c(int paramInt) {
    d d1 = b;
    return (d1 == null) ? null : d1.b(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\impls\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */