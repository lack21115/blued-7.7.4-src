package com.tencent.liteav;

import android.content.Context;
import com.tencent.liteav.basic.b.c;
import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.b;
import com.tencent.liteav.basic.util.e;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.screencapture.a;
import com.tencent.liteav.screencapture.b;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import javax.microedition.khronos.egl.EGLContext;

public class l implements q, b {
  private final a a;
  
  private r b;
  
  private EGLContext c = null;
  
  private WeakReference<b> d = null;
  
  private int e;
  
  private e f;
  
  private int g;
  
  private int h;
  
  private String i = "";
  
  private int j = 0;
  
  private long k;
  
  private long l;
  
  private long m;
  
  private boolean n;
  
  private final Queue<Runnable> o = new LinkedList<Runnable>();
  
  public l(Context paramContext, i parami, a.a parama) {
    this.a = new a(paramContext, parami.V, parama);
    this.a.a(this);
    parami.a();
    this.f = c(parami.a, parami.b);
    this.e = parami.h;
    this.g = parami.a;
    this.h = parami.b;
    TXCLog.i("TXCScreenCaptureSource", "capture size: %s, encode size: %dx%d", new Object[] { this.f, Integer.valueOf(this.g), Integer.valueOf(this.h) });
  }
  
  private boolean a(Queue<Runnable> paramQueue) {
    // Byte code:
    //   0: aload_1
    //   1: monitorenter
    //   2: aload_1
    //   3: invokeinterface isEmpty : ()Z
    //   8: ifeq -> 15
    //   11: aload_1
    //   12: monitorexit
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_1
    //   16: invokeinterface poll : ()Ljava/lang/Object;
    //   21: checkcast java/lang/Runnable
    //   24: astore_2
    //   25: aload_1
    //   26: monitorexit
    //   27: aload_2
    //   28: ifnonnull -> 33
    //   31: iconst_0
    //   32: ireturn
    //   33: aload_2
    //   34: invokeinterface run : ()V
    //   39: iconst_1
    //   40: ireturn
    //   41: astore_2
    //   42: aload_1
    //   43: monitorexit
    //   44: aload_2
    //   45: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	41	finally
    //   15	27	41	finally
    //   42	44	41	finally
  }
  
  private e c(int paramInt1, int paramInt2) {
    boolean bool;
    if (paramInt1 > paramInt2) {
      bool = true;
    } else {
      bool = false;
    } 
    e e1 = new e();
    if (paramInt1 > 1280 || paramInt2 > 1280) {
      int i;
      if (bool) {
        i = Math.max(paramInt1, paramInt2);
      } else {
        i = Math.min(paramInt1, paramInt2);
      } 
      e1.a = i;
      if (bool) {
        paramInt1 = Math.min(paramInt1, paramInt2);
      } else {
        paramInt1 = Math.max(paramInt1, paramInt2);
      } 
      e1.b = paramInt1;
      return e1;
    } 
    paramInt2 = 720;
    if (bool) {
      paramInt1 = 1280;
    } else {
      paramInt1 = 720;
    } 
    e1.a = paramInt1;
    if (bool) {
      paramInt1 = paramInt2;
    } else {
      paramInt1 = 1280;
    } 
    e1.b = paramInt1;
    return e1;
  }
  
  private void f(boolean paramBoolean) {
    if (paramBoolean) {
      int i = this.g;
      int j = this.h;
      if (i > j) {
        b(j, i);
        return;
      } 
    } else {
      int i = this.g;
      int j = this.h;
      if (i < j)
        b(j, i); 
    } 
  }
  
  public void a() {
    Monitor.a(2, String.format("VideoCapture[%d]: start screen", new Object[] { Integer.valueOf(hashCode()) }), "", 0);
    this.k = 0L;
    this.l = 0L;
    this.m = 0L;
    this.n = true;
    this.a.a(this.f.a, this.f.b, this.e);
  }
  
  public void a(float paramFloat) {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt1, EGLContext paramEGLContext, int paramInt2, int paramInt3, int paramInt4, long paramLong) {
    this.c = paramEGLContext;
    while (a(this.o));
    if (paramInt1 != 0) {
      TXCLog.e("TXCScreenCaptureSource", "onScreenCaptureFrame failed");
      return;
    } 
    boolean bool1 = this.n;
    boolean bool = true;
    if (bool1) {
      this.n = false;
      Monitor.a(2, String.format("VideoCapture[%d]: capture first frame", new Object[] { Integer.valueOf(hashCode()) }), "", 0);
      g.a(this.d, 1007, "First frame capture completed");
      TXCLog.i("TXCScreenCaptureSource", "on Got first frame");
    } 
    this.k++;
    paramLong = System.currentTimeMillis() - this.l;
    if (paramLong >= TimeUnit.SECONDS.toMillis(1L)) {
      long l1 = this.k;
      double d = (l1 - this.m) * 1000.0D / paramLong;
      this.m = l1;
      this.l = System.currentTimeMillis();
      TXCStatus.a(this.i, 1001, this.j, Double.valueOf(d));
    } 
    if (this.b != null) {
      if (paramInt3 >= paramInt4)
        bool = false; 
      f(bool);
      b b1 = new b();
      b1.e = paramInt3;
      b1.f = paramInt4;
      b1.g = this.g;
      b1.h = this.h;
      b1.a = paramInt2;
      b1.b = 0;
      b1.j = 0;
      b1.l = g.a(b1.e, b1.f, this.g, this.h);
      this.b.b(b1);
    } 
  }
  
  public void a(c paramc) {}
  
  public void a(b paramb) {
    this.d = new WeakReference<b>(paramb);
    a a1 = this.a;
    if (a1 != null)
      a1.a(paramb); 
  }
  
  public void a(b paramb) {}
  
  public void a(r paramr) {
    this.b = paramr;
  }
  
  public void a(Object paramObject) {
    while (a(this.o));
    paramObject = this.b;
    if (paramObject != null)
      paramObject.t(); 
  }
  
  public void a(Runnable paramRunnable) {
    a a1 = this.a;
    if (a1 != null)
      a1.a(paramRunnable); 
  }
  
  public void a(String paramString) {
    this.i = paramString;
  }
  
  public void a(boolean paramBoolean) {
    Monitor.a(2, String.format("VideoCapture[%d]: stop screen", new Object[] { Integer.valueOf(hashCode()) }), "", 0);
    this.a.a(null);
  }
  
  public boolean a(int paramInt) {
    return false;
  }
  
  public void b() {
    this.a.a(true);
  }
  
  public void b(int paramInt) {}
  
  public void b(int paramInt1, int paramInt2) {
    this.g = paramInt1;
    this.h = paramInt2;
  }
  
  public void b(boolean paramBoolean) {
    e e1 = c(this.g, this.h);
    if (!e1.equals(this.f)) {
      this.f = e1;
      this.a.a(e1.a, e1.b);
      TXCLog.i("TXCScreenCaptureSource", "capture size: %s, encode size: %dx%d", new Object[] { this.f, Integer.valueOf(this.g), Integer.valueOf(this.h) });
    } 
  }
  
  public void c() {
    this.a.a(false);
  }
  
  public void c(int paramInt) {}
  
  public void c(boolean paramBoolean) {}
  
  public void d(int paramInt) {}
  
  public boolean d() {
    return true;
  }
  
  public boolean d(boolean paramBoolean) {
    return false;
  }
  
  public int e() {
    return 0;
  }
  
  public void e(int paramInt) {}
  
  public void e(boolean paramBoolean) {}
  
  public EGLContext f() {
    return this.c;
  }
  
  public void f(int paramInt) {
    this.e = paramInt;
    this.a.a(paramInt);
  }
  
  public int g() {
    return this.e;
  }
  
  public void g(int paramInt) {
    this.j = paramInt;
  }
  
  public boolean h() {
    return false;
  }
  
  public boolean i() {
    return false;
  }
  
  public boolean j() {
    return false;
  }
  
  public boolean k() {
    return false;
  }
  
  public boolean l() {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\liteav\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */