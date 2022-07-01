package com.qiniu.pili.droid.shortvideo.gl.b;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Message;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.f.d;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.gl.a.d;
import com.qiniu.pili.droid.shortvideo.gl.a.f;
import com.qiniu.pili.droid.shortvideo.gl.c.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class a implements SurfaceTexture.OnFrameAvailableListener, Runnable {
  private PLDisplayMode A;
  
  private int B;
  
  private List<Integer> C;
  
  private List<Long> D;
  
  private double E = 1.0D;
  
  private long F;
  
  private long G;
  
  private int H;
  
  private int I;
  
  private int J;
  
  private int K;
  
  private int a;
  
  private int b;
  
  private int c;
  
  private int d;
  
  private int e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private Object i;
  
  private int j;
  
  private SurfaceTexture k;
  
  private Surface l;
  
  private Surface m;
  
  private f n;
  
  private com.qiniu.pili.droid.shortvideo.gl.c.a o;
  
  private g p;
  
  private c q;
  
  private b r;
  
  private a s;
  
  private List<Long> t = new LinkedList<Long>();
  
  private float[] u = new float[16];
  
  private volatile boolean v = false;
  
  private int w;
  
  private volatile boolean x;
  
  private int y;
  
  private int z;
  
  public a(Surface paramSurface, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, List<Long> paramList) {
    this.m = paramSurface;
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.g = paramInt4;
    this.h = paramInt5;
    this.t = paramList;
    List<Long> list = this.t;
    if (list != null && !list.isEmpty())
      this.F = ((Long)this.t.get(0)).longValue(); 
    e e = e.s;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("src size: ");
    stringBuilder.append(paramInt1);
    stringBuilder.append("x");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" rotation: ");
    stringBuilder.append(paramInt3);
    stringBuilder.append(" dst size: ");
    stringBuilder.append(paramInt4);
    stringBuilder.append("x");
    stringBuilder.append(paramInt5);
    e.c("OffScreenRenderer", stringBuilder.toString());
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2) {
    paramInt1 = d.a(null, paramInt1, paramInt2, 6408);
    paramInt1 = this.o.b(this.j, this.u, paramInt1);
    if (this.C.size() < this.B) {
      this.C.add(Integer.valueOf(paramInt1));
      this.D.add(Long.valueOf(paramLong));
    } 
    if (this.C.size() >= this.B || this.t.size() == 0)
      g(); 
  }
  
  private void d() {
    List<Integer> list = this.C;
    if (list != null && !list.isEmpty())
      g(); 
  }
  
  private void e() {
    try {
      this.k.updateTexImage();
      List<Long> list = this.t;
      if (list == null || list.isEmpty()) {
        e.e.e("OffScreenRenderer", "something went wrong");
        return;
      } 
      this.t.remove(0);
      b b1 = this.r;
      if (b1 != null)
        b1.b(); 
      return;
    } catch (Exception exception) {
      e.e.e("OffScreenRenderer", "update surface texture failed !!!");
      return;
    } 
  }
  
  private void f() {
    try {
      int i;
      int j;
      int k;
      this.k.updateTexImage();
      this.k.getTransformMatrix(this.u);
      List<Long> list = this.t;
      if (list == null || list.isEmpty()) {
        e.s.e("OffScreenRenderer", "something went wrong");
        return;
      } 
      long l = (long)(((((Long)this.t.remove(0)).longValue() - this.F) * 1000L) / this.E);
      if ((this.c + this.z) % 180 == 90) {
        k = this.b;
      } else {
        k = this.a;
      } 
      if ((this.c + this.z) % 180 == 90) {
        j = this.a;
      } else {
        j = this.b;
      } 
      if (this.x) {
        b b1 = this.r;
        if (b1 != null) {
          i = b1.a(this.j, this.a, this.b, l, this.u);
        } else {
          i = 0;
        } 
      } else {
        if (this.o == null) {
          this.o = new com.qiniu.pili.droid.shortvideo.gl.c.a();
          this.o.b();
          this.o.a(k, j);
        } 
        i = this.o.c(this.j, this.u, this.z);
        b b1 = this.r;
        if (b1 != null)
          i = b1.a(i, k, j, l, d.f); 
      } 
      int m = this.d;
      if (m != 0)
        k = m; 
      m = this.e;
      if (m != 0)
        j = m; 
      if (this.p == null) {
        e e1 = e.s;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("init mTextureRatioDrawer afterCallbackWidth: ");
        stringBuilder1.append(k);
        stringBuilder1.append(" afterCallbackHeight: ");
        stringBuilder1.append(j);
        e1.c("OffScreenRenderer", stringBuilder1.toString());
        this.p = new g();
        this.p.a(this.g, this.h);
        this.p.b(this.y);
        m = this.J;
        if (m > 0) {
          int n = this.K;
          if (n > 0) {
            float f1 = this.H;
            float f2 = k;
            f1 = f1 * 1.0F / f2;
            float f4 = this.I;
            float f3 = j;
            f4 = 1.0F - f4 / f3;
            f2 = m * 1.0F / f2 + f1;
            f3 = f4 - n * 1.0F / f3;
            e1 = e.s;
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("texture clip area left: ");
            stringBuilder1.append(f1);
            stringBuilder1.append(" top: ");
            stringBuilder1.append(f4);
            stringBuilder1.append(" right: ");
            stringBuilder1.append(f2);
            stringBuilder1.append(" bottom: ");
            stringBuilder1.append(f3);
            e1.c("OffScreenRenderer", stringBuilder1.toString());
            this.p.a(new float[] { f1, f3, f1, f4, f2, f3, f2, f4 });
          } 
        } 
        this.p.a(k, j, this.A);
      } 
      if (this.B > 0 && this.o != null) {
        a(l, k, j);
      } else {
        synchronized (d.a) {
          GLES20.glClear(16384);
          this.p.b(i);
          this.n.a(l);
          this.n.c();
          null = e.s;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("onDrawFrame: ");
          stringBuilder1.append(l);
          null.b("OffScreenRenderer", stringBuilder1.toString());
          return;
        } 
      } 
      e e = e.s;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onDrawFrame: ");
      stringBuilder.append(l);
      e.b("OffScreenRenderer", stringBuilder.toString());
      return;
    } catch (Exception exception) {
      e.s.e("OffScreenRenderer", "update surface texture failed !!!");
      return;
    } 
  }
  
  private void g() {
    Collections.reverse(this.C);
    int i = 0;
    while (i < this.C.size()) {
      int j = ((Integer)this.C.get(i)).intValue();
      long l = ((Long)this.D.get(i)).longValue();
      synchronized (d.a) {
        GLES20.glClear(16384);
        this.p.b(j);
        this.n.a(l);
        this.n.c();
        if (j != 0)
          GLES20.glDeleteTextures(1, new int[] { j }, 0); 
        i++;
      } 
    } 
    this.B = 0;
    this.C.clear();
    this.D.clear();
  }
  
  private void h() {
    Surface surface = this.l;
    if (surface != null) {
      surface.release();
      this.l = null;
    } 
    SurfaceTexture surfaceTexture = this.k;
    if (surfaceTexture != null) {
      surfaceTexture.release();
      this.k = null;
    } 
    int i = this.j;
    if (i > 0) {
      GLES20.glDeleteTextures(1, new int[] { i }, 0);
      this.j = 0;
    } 
    com.qiniu.pili.droid.shortvideo.gl.c.a a1 = this.o;
    if (a1 != null) {
      a1.f();
      this.o = null;
    } 
    g g1 = this.p;
    if (g1 != null) {
      g1.f();
      this.p = null;
    } 
    this.w = 0;
  }
  
  private void i() {
    this.j = d.c();
    this.k = new SurfaceTexture(this.j);
    this.k.setOnFrameAvailableListener(this);
    this.l = new Surface(this.k);
    b b1 = this.r;
    if (b1 != null) {
      b1.a(d.b(), this.l);
      this.r.a(this.g, this.h);
    } 
  }
  
  private void j() {
    h();
    i();
  }
  
  public void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield v : Z
    //   6: ifeq -> 23
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: ldc 'OffScreenRenderer'
    //   14: ldc_w 'already started !!!'
    //   17: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: new java/lang/Thread
    //   26: dup
    //   27: aload_0
    //   28: ldc 'OffScreenRenderer'
    //   30: invokespecial <init> : (Ljava/lang/Runnable;Ljava/lang/String;)V
    //   33: invokevirtual start : ()V
    //   36: aload_0
    //   37: getfield v : Z
    //   40: istore_1
    //   41: iload_1
    //   42: ifne -> 60
    //   45: aload_0
    //   46: invokevirtual wait : ()V
    //   49: goto -> 36
    //   52: astore_2
    //   53: aload_2
    //   54: invokevirtual printStackTrace : ()V
    //   57: goto -> 36
    //   60: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   63: ldc 'OffScreenRenderer'
    //   65: ldc_w 'start success !'
    //   68: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_0
    //   72: monitorexit
    //   73: return
    //   74: astore_2
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_2
    //   78: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	74	finally
    //   23	36	74	finally
    //   36	41	74	finally
    //   45	49	52	java/lang/InterruptedException
    //   45	49	74	finally
    //   53	57	74	finally
    //   60	71	74	finally
  }
  
  public void a(double paramDouble) {
    this.E = paramDouble;
  }
  
  public void a(int paramInt) {
    this.f = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2) {
    g g1 = this.p;
    if (g1 != null)
      g1.f(); 
    this.p = new g();
    this.p.a(this.g, this.h);
    this.p.b(this.y);
    this.p.a(paramInt1, paramInt2, this.A);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.H = paramInt1;
    this.I = paramInt2;
    this.J = paramInt3;
    this.K = paramInt4;
    e e = e.s;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setClipArea x: ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" y: ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" width: ");
    stringBuilder.append(paramInt3);
    stringBuilder.append(" height: ");
    stringBuilder.append(paramInt4);
    e.c("OffScreenRenderer", stringBuilder.toString());
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, List<Long> paramList) {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.t = paramList;
    this.G = 0L;
    c c1 = this.q;
    if (c1 != null)
      c1.sendEmptyMessage(2); 
  }
  
  public void a(int paramInt1, int paramInt2, b paramb) {
    this.d = paramInt1;
    this.e = paramInt2;
    this.r = paramb;
  }
  
  public void a(long paramLong) {
    this.n.a(paramLong);
    this.n.c();
  }
  
  public void a(PLDisplayMode paramPLDisplayMode) {
    this.A = paramPLDisplayMode;
  }
  
  public void a(a parama) {
    this.s = parama;
  }
  
  public void a(b paramb) {
    this.r = paramb;
  }
  
  public void a(Object paramObject) {
    this.i = paramObject;
  }
  
  public void a(Runnable paramRunnable) {
    this.q.post(paramRunnable);
  }
  
  public void a(boolean paramBoolean) {
    this.x = paramBoolean;
  }
  
  public void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield v : Z
    //   6: ifne -> 23
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: ldc 'OffScreenRenderer'
    //   14: ldc_w 'not started yet !!!'
    //   17: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield q : Lcom/qiniu/pili/droid/shortvideo/gl/b/a$c;
    //   27: ifnull -> 40
    //   30: aload_0
    //   31: getfield q : Lcom/qiniu/pili/droid/shortvideo/gl/b/a$c;
    //   34: invokevirtual getLooper : ()Landroid/os/Looper;
    //   37: invokevirtual quit : ()V
    //   40: aload_0
    //   41: getfield v : Z
    //   44: istore_1
    //   45: iload_1
    //   46: ifeq -> 64
    //   49: aload_0
    //   50: invokevirtual wait : ()V
    //   53: goto -> 40
    //   56: astore_2
    //   57: aload_2
    //   58: invokevirtual printStackTrace : ()V
    //   61: goto -> 40
    //   64: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   67: ldc 'OffScreenRenderer'
    //   69: ldc_w 'stop success !'
    //   72: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: astore_2
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_2
    //   82: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	78	finally
    //   23	40	78	finally
    //   40	45	78	finally
    //   49	53	56	java/lang/InterruptedException
    //   49	53	78	finally
    //   57	61	78	finally
    //   64	75	78	finally
  }
  
  public void b(int paramInt) {
    this.y = paramInt;
    e e = e.s;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setDrawRotation: ");
    stringBuilder.append(paramInt);
    e.c("OffScreenRenderer", stringBuilder.toString());
  }
  
  public void c() {
    e.s.c("OffScreenRenderer", "stop reverse !");
    c c1 = this.q;
    if (c1 != null)
      c1.sendEmptyMessage(1); 
  }
  
  public void c(int paramInt) {
    this.z = paramInt;
  }
  
  public void d(int paramInt) {
    this.B = paramInt;
    List<Integer> list1 = this.C;
    if (list1 == null) {
      this.C = new ArrayList<Integer>();
    } else {
      list1.clear();
    } 
    List<Long> list = this.D;
    if (list == null) {
      this.D = new ArrayList<Long>();
      return;
    } 
    list.clear();
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture) {
    e e = e.j;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("received frame count: ");
    int i = this.w + 1;
    this.w = i;
    stringBuilder.append(i);
    e.b("OffScreenRenderer", stringBuilder.toString());
    c c1 = this.q;
    if (c1 != null) {
      if (this.f > 0) {
        long l1 = ((Long)this.t.get(0)).longValue();
        long l2 = this.G;
        long l3 = (1000000 / this.f);
        if (l2 != 0L && l1 - l2 < l3) {
          this.q.sendEmptyMessage(3);
          return;
        } 
        this.G = l1;
        this.q.sendEmptyMessage(0);
        return;
      } 
      c1.sendEmptyMessage(0);
    } 
  }
  
  public void run() {
    // Byte code:
    //   0: new com/qiniu/pili/droid/shortvideo/gl/a/d
    //   3: dup
    //   4: aload_0
    //   5: getfield i : Ljava/lang/Object;
    //   8: iconst_1
    //   9: invokespecial <init> : (Ljava/lang/Object;I)V
    //   12: astore_1
    //   13: aload_0
    //   14: new com/qiniu/pili/droid/shortvideo/gl/a/f
    //   17: dup
    //   18: aload_1
    //   19: aload_0
    //   20: getfield m : Landroid/view/Surface;
    //   23: iconst_0
    //   24: invokespecial <init> : (Lcom/qiniu/pili/droid/shortvideo/gl/a/d;Landroid/view/Surface;Z)V
    //   27: putfield n : Lcom/qiniu/pili/droid/shortvideo/gl/a/f;
    //   30: aload_0
    //   31: getfield n : Lcom/qiniu/pili/droid/shortvideo/gl/a/f;
    //   34: invokevirtual b : ()V
    //   37: aload_0
    //   38: invokespecial i : ()V
    //   41: invokestatic prepare : ()V
    //   44: aload_0
    //   45: new com/qiniu/pili/droid/shortvideo/gl/b/a$c
    //   48: dup
    //   49: aload_0
    //   50: invokespecial <init> : (Lcom/qiniu/pili/droid/shortvideo/gl/b/a;)V
    //   53: putfield q : Lcom/qiniu/pili/droid/shortvideo/gl/b/a$c;
    //   56: aload_0
    //   57: monitorenter
    //   58: aload_0
    //   59: iconst_1
    //   60: putfield v : Z
    //   63: aload_0
    //   64: invokevirtual notify : ()V
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_0
    //   70: getfield s : Lcom/qiniu/pili/droid/shortvideo/gl/b/a$a;
    //   73: astore_2
    //   74: aload_2
    //   75: ifnull -> 84
    //   78: aload_2
    //   79: invokeinterface a : ()V
    //   84: invokestatic loop : ()V
    //   87: aload_0
    //   88: getfield r : Lcom/qiniu/pili/droid/shortvideo/gl/b/a$b;
    //   91: astore_2
    //   92: aload_2
    //   93: ifnull -> 102
    //   96: aload_2
    //   97: invokeinterface a : ()V
    //   102: aload_0
    //   103: invokespecial h : ()V
    //   106: aload_0
    //   107: getfield n : Lcom/qiniu/pili/droid/shortvideo/gl/a/f;
    //   110: invokevirtual d : ()V
    //   113: aload_1
    //   114: invokevirtual a : ()V
    //   117: aload_0
    //   118: monitorenter
    //   119: aload_0
    //   120: iconst_0
    //   121: putfield v : Z
    //   124: aload_0
    //   125: invokevirtual notify : ()V
    //   128: aload_0
    //   129: monitorexit
    //   130: return
    //   131: astore_1
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_1
    //   135: athrow
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_1
    //   140: athrow
    // Exception table:
    //   from	to	target	type
    //   58	69	136	finally
    //   119	130	131	finally
    //   132	134	131	finally
    //   137	139	136	finally
  }
  
  public static interface a {
    void a();
  }
  
  public static interface b {
    int a(int param1Int1, int param1Int2, int param1Int3, long param1Long, float[] param1ArrayOffloat);
    
    void a();
    
    void a(int param1Int1, int param1Int2);
    
    void a(Object param1Object, Surface param1Surface);
    
    void b();
  }
  
  static class c extends Handler {
    private WeakReference<a> a;
    
    public c(a param1a) {
      this.a = new WeakReference<a>(param1a);
    }
    
    public void handleMessage(Message param1Message) {
      super.handleMessage(param1Message);
      a a = this.a.get();
      if (a == null)
        return; 
      if (param1Message.what == 0) {
        a.a(a);
        return;
      } 
      if (param1Message.what == 1) {
        a.b(a);
        return;
      } 
      if (param1Message.what == 2) {
        a.c(a);
        return;
      } 
      if (param1Message.what == 3)
        a.d(a); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\gl\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */