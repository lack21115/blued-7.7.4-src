package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.t;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class k {
  private static volatile k a;
  
  private c b = c.a();
  
  private Map<String, Object> c;
  
  private b d;
  
  public static k a() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/c/k.a : Lcom/bytedance/sdk/openadsdk/c/k;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/c/k
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/c/k.a : Lcom/bytedance/sdk/openadsdk/c/k;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/c/k
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/c/k.a : Lcom/bytedance/sdk/openadsdk/c/k;
    //   25: ldc com/bytedance/sdk/openadsdk/c/k
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/c/k
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/c/k.a : Lcom/bytedance/sdk/openadsdk/c/k;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void a(b paramb) {
    if (paramb == null)
      return; 
    paramb.b();
    if (paramb.a() * this.b.a > this.b.b) {
      c(paramb.a(false));
      return;
    } 
    com.bytedance.sdk.openadsdk.i.a.a().a(new a(this, 100), this.b.a);
  }
  
  private void b(b paramb) {
    if (paramb == null)
      return; 
    Context context = o.a();
    if (ah.d(context, context.getPackageName())) {
      a(paramb);
      return;
    } 
    c(paramb.a(true));
  }
  
  private void c(b paramb) {
    if (paramb == null)
      return; 
    com.bytedance.sdk.openadsdk.i.a.a().d(paramb, 5);
  }
  
  public void a(com.bytedance.sdk.openadsdk.core.d.k paramk, String paramString) {
    this.d = b.a(paramk, paramString, this.c);
    com.bytedance.sdk.openadsdk.i.a.a().a(new a(this, 100), 0L);
  }
  
  class a implements Runnable {
    private int b;
    
    public a(k this$0, int param1Int) {
      this.b = param1Int;
    }
    
    public void run() {
      if (this.b == 100 && k.a(this.a) != null) {
        k k1 = this.a;
        k.a(k1, k.a(k1));
      } 
    }
  }
  
  static class b implements Serializable, Runnable {
    public final AtomicInteger a = new AtomicInteger(0);
    
    public final AtomicBoolean b = new AtomicBoolean(false);
    
    public com.bytedance.sdk.openadsdk.core.d.k c;
    
    public String d;
    
    public Map<String, Object> e;
    
    public b() {}
    
    public b(com.bytedance.sdk.openadsdk.core.d.k param1k, String param1String, Map<String, Object> param1Map) {
      this.c = param1k;
      this.d = param1String;
      this.e = param1Map;
    }
    
    public static b a(com.bytedance.sdk.openadsdk.core.d.k param1k, String param1String, Map<String, Object> param1Map) {
      return new b(param1k, param1String, param1Map);
    }
    
    public int a() {
      return this.a.get();
    }
    
    public b a(boolean param1Boolean) {
      this.b.set(param1Boolean);
      return this;
    }
    
    public void b() {
      this.a.incrementAndGet();
    }
    
    public void run() {
      String str;
      if (this.c == null || TextUtils.isEmpty(this.d)) {
        t.a("materialMeta or eventTag is null, pls check");
        return;
      } 
      if (this.b.get()) {
        str = "dpl_success";
      } else {
        str = "dpl_failed";
      } 
      d.p(o.a(), this.c, this.d, str, this.e);
    }
  }
  
  static class c {
    public int a = 500;
    
    public int b = 5000;
    
    public static c a() {
      return new c();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\c\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */