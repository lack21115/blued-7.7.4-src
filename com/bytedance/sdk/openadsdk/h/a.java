package com.bytedance.sdk.openadsdk.h;

import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.h.a.a;
import com.bytedance.sdk.openadsdk.h.b.c;
import com.bytedance.sdk.openadsdk.h.c.a;
import com.bytedance.sdk.openadsdk.h.d.a;
import com.bytedance.sdk.openadsdk.h.e.a;
import com.bytedance.sdk.openadsdk.h.e.b;
import com.bytedance.sdk.openadsdk.h.e.c;
import com.bytedance.sdk.openadsdk.h.e.f;
import com.bytedance.sdk.openadsdk.h.g.d;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

abstract class a implements k {
  private static final AtomicLong m = new AtomicLong();
  
  protected volatile a a;
  
  protected final c b;
  
  protected final AtomicInteger c = new AtomicInteger();
  
  protected final AtomicLong d = new AtomicLong();
  
  protected a e;
  
  protected volatile List<i.b> f;
  
  protected volatile String g;
  
  protected volatile String h;
  
  protected volatile i i;
  
  protected volatile l j;
  
  protected volatile boolean k = false;
  
  public final long l = m.incrementAndGet();
  
  private final AtomicInteger n = new AtomicInteger(0);
  
  private int o = -1;
  
  public a(a parama, c paramc) {
    this.a = parama;
    this.b = paramc;
  }
  
  protected a a(l.a parama, int paramInt1, int paramInt2, String paramString) throws IOException, VAdError {
    c c1;
    c c2;
    b b = c.a().b();
    f f = new f();
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    f.b = parama.a;
    f.a = 0;
    if ("HEAD".equalsIgnoreCase(paramString))
      f.a = 4; 
    List<i.b> list = this.f;
    if (list != null && !list.isEmpty())
      for (i.b b1 : list) {
        if ("Range".equalsIgnoreCase(b1.a) || "Connection".equalsIgnoreCase(b1.a) || "Proxy-Connection".equalsIgnoreCase(b1.a) || "Host".equalsIgnoreCase(b1.a))
          continue; 
        hashMap.put(b1.a, b1.b);
      }  
    String str = d.a(paramInt1, paramInt2);
    if (str != null)
      hashMap.put("Range", str); 
    if (e.f)
      hashMap.put("Cache-Control", "no-cache"); 
    d d = d.c();
    f f1 = f.a();
    if (this.i == null) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    } 
    if (paramInt1 != 0) {
      c1 = d.a();
    } else {
      c1 = f1.b();
    } 
    if (paramInt1 != 0) {
      c2 = d.b();
    } else {
      c2 = f1.c();
    } 
    if (c1 != null || c2 != null) {
      if (c1 != null)
        f.c = c1.a(parama.b); 
      if (c2 != null)
        f.d = c2.a(parama.b); 
    } 
    f.e = hashMap;
    if (this.k) {
      this.k = false;
      return null;
    } 
    return b.a(f);
  }
  
  public void a() {
    this.n.compareAndSet(0, 1);
  }
  
  protected void a(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iload_1
    //   1: ifle -> 95
    //   4: iload_2
    //   5: ifge -> 9
    //   8: return
    //   9: getstatic com/bytedance/sdk/openadsdk/h/e.g : I
    //   12: istore_3
    //   13: aload_0
    //   14: invokevirtual f : ()I
    //   17: istore #4
    //   19: iload_3
    //   20: iconst_1
    //   21: if_icmpeq -> 35
    //   24: iload_3
    //   25: iconst_2
    //   26: if_icmpne -> 87
    //   29: iload #4
    //   31: iconst_1
    //   32: if_icmpne -> 87
    //   35: iload_2
    //   36: i2f
    //   37: iload_1
    //   38: i2f
    //   39: fdiv
    //   40: ldc 100.0
    //   42: fmul
    //   43: f2i
    //   44: istore_2
    //   45: iload_2
    //   46: istore_1
    //   47: iload_2
    //   48: bipush #100
    //   50: if_icmple -> 56
    //   53: bipush #100
    //   55: istore_1
    //   56: aload_0
    //   57: monitorenter
    //   58: iload_1
    //   59: aload_0
    //   60: getfield o : I
    //   63: if_icmpgt -> 69
    //   66: aload_0
    //   67: monitorexit
    //   68: return
    //   69: aload_0
    //   70: iload_1
    //   71: putfield o : I
    //   74: aload_0
    //   75: monitorexit
    //   76: new com/bytedance/sdk/openadsdk/h/a$1
    //   79: dup
    //   80: aload_0
    //   81: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/h/a;)V
    //   84: invokestatic b : (Ljava/lang/Runnable;)V
    //   87: return
    //   88: astore #5
    //   90: aload_0
    //   91: monitorexit
    //   92: aload #5
    //   94: athrow
    //   95: return
    // Exception table:
    //   from	to	target	type
    //   58	68	88	finally
    //   69	76	88	finally
    //   90	92	88	finally
  }
  
  protected void a(Boolean paramBoolean, String paramString, Throwable paramThrowable) {}
  
  public boolean b() {
    return (this.n.get() == 1);
  }
  
  protected void c() {
    this.n.compareAndSet(0, 2);
  }
  
  public boolean d() {
    return (this.n.get() == 2);
  }
  
  protected void e() throws a {
    if (!b())
      return; 
    throw new a();
  }
  
  protected int f() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:513)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected boolean g() {
    return (f() == 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */