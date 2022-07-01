package com.qq.e.comm.plugin.t;

import com.qq.e.comm.plugin.t.a.b;
import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.t.b.f;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class d implements c {
  private static final c a = new d();
  
  private final ExecutorService b = new ThreadPoolExecutor(5, 10, 180L, TimeUnit.SECONDS, this.c);
  
  private PriorityBlockingQueue<Runnable> c = new PriorityBlockingQueue<Runnable>(15);
  
  public static c a() {
    return a;
  }
  
  public Future<f> a(e parame) {
    return a(parame, c.a.b);
  }
  
  public Future<f> a(e parame, c.a parama) {
    a<f> a1 = new a(this, new b(parame), parama);
    this.b.execute(a1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("QueueSize:");
    stringBuilder.append(this.c.size());
    GDTLogger.d(stringBuilder.toString());
    return a1;
  }
  
  public void a(e parame, c.a parama, b paramb) {
    a(parame, parama, paramb, this.b);
  }
  
  public void a(e parame, c.a parama, b paramb, Executor paramExecutor) {
    if (paramExecutor == null) {
      GDTLogger.e("Submit failed for no executor");
      return;
    } 
    paramExecutor.execute(new a(this, new b(parame, paramb), parama));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("QueueSize:");
    stringBuilder.append(this.c.size());
    GDTLogger.d(stringBuilder.toString());
  }
  
  class a<T> extends FutureTask<T> implements Comparable<a<T>> {
    private final c.a b;
    
    public a(d this$0, Callable<T> param1Callable, c.a param1a) {
      super(param1Callable);
      this.b = param1a;
    }
    
    public int a(a<T> param1a) {
      return (param1a == null) ? 1 : (this.b.a() - param1a.b.a());
    }
  }
  
  static class b implements Callable<f> {
    final e a;
    
    final b b;
    
    public b(e param1e) {
      this(param1e, null);
    }
    
    public b(e param1e, b param1b) {
      this.a = param1e;
      this.b = param1b;
    }
    
    private f b() throws Exception {
      ArrayList<b> arrayList = new ArrayList();
      arrayList.add(new b());
      return (new a(0, (List)arrayList, this.a)).a(this.a);
    }
    
    public f a() throws Exception {
      f f;
      b b1;
      exception = null;
      try {
        f = b();
      } catch (Exception exception) {
        f = null;
      } 
      if (exception == null) {
        b1 = this.b;
        if (b1 != null)
          b1.a(this.a, f); 
        if (this.a.j()) {
          f.c();
          return f;
        } 
      } else {
        if (f != null)
          f.c(); 
        if (this.b != null) {
          GDTLogger.w("NetworkClientException", (Throwable)b1);
          this.b.a((Exception)b1);
          return f;
        } 
        throw b1;
      } 
      return f;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\t\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */