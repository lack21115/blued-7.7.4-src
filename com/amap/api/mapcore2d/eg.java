package com.amap.api.mapcore2d;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class eg {
  private static final eg a = new eg();
  
  private static final ThreadFactory d = new b();
  
  private final Map<String, ei> b = new HashMap<String, ei>();
  
  private final Map<String, a> c = new HashMap<String, a>();
  
  private ExecutorService e = null;
  
  public static eg b() {
    return a;
  }
  
  private boolean b(da paramda) {
    return (paramda != null && !TextUtils.isEmpty(paramda.b()) && !TextUtils.isEmpty(paramda.a()));
  }
  
  a a(da paramda) {
    synchronized (this.c) {
      if (!b(paramda))
        return null; 
      String str = paramda.a();
      a a2 = this.c.get(str);
      a a1 = a2;
      if (a2 == null)
        try {
          a1 = new a(this);
        } finally {
          a1 = null;
        }  
      return a1;
    } 
  }
  
  ei a(Context paramContext, da paramda) throws Exception {
    if (!b(paramda) || paramContext == null)
      return null; 
    String str = paramda.a();
    synchronized (this.b) {
      ei ei2 = this.b.get(str);
      ei ei1 = ei2;
      if (ei2 == null)
        try {
          ei1 = new ek(paramContext.getApplicationContext(), paramda, true);
        } finally {
          paramContext = null;
        }  
      return ei1;
    } 
  }
  
  public ExecutorService a() {
    try {
      if (this.e == null || this.e.isShutdown())
        this.e = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(128), d); 
    } finally {
      Exception exception;
    } 
    return this.e;
  }
  
  class a {
    volatile boolean a = false;
    
    volatile boolean b = false;
    
    a(eg this$0) {}
  }
  
  static final class b implements ThreadFactory {
    private final AtomicInteger a = new AtomicInteger(1);
    
    public Thread newThread(Runnable param1Runnable) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("amapD#");
      stringBuilder.append(this.a.getAndIncrement());
      return new Thread(param1Runnable, stringBuilder.toString());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\eg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */