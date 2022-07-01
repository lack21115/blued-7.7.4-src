package a.a.a.a.a.b;

import a.a.a.a.a.a.h.d;
import a.a.a.a.a.a.h.f;
import a.a.a.a.a.b.i.a;
import a.a.a.a.a.b.i.j;
import a.a.a.a.a.b.i.l;
import a.a.a.a.a.b.i.m;
import a.a.a.a.a.b.i.o;
import a.a.a.a.a.b.i.p;
import a.a.a.a.a.b.i.q.a;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import com.qiniu.pili.droid.streaming.PreviewAppearance;
import com.qiniu.pili.droid.streaming.StreamingPreviewCallback;
import com.qiniu.pili.droid.streaming.SurfaceTextureCallback;
import com.qiniu.pili.droid.streaming.WatermarkSetting;
import com.qiniu.pili.droid.streaming.av.common.PLFourCC;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class e implements GLSurfaceView.Renderer {
  public a A;
  
  public o B;
  
  public j C;
  
  public p D;
  
  public o E;
  
  public o F;
  
  public m G;
  
  public h H;
  
  public h I;
  
  public a J;
  
  public boolean K;
  
  public boolean L;
  
  public WatermarkSetting M;
  
  public PreviewAppearance N;
  
  public boolean O;
  
  public long P;
  
  public long Q;
  
  public StreamingPreviewCallback R;
  
  public int S;
  
  public boolean T;
  
  public final float[] a = new float[16];
  
  public c.i b;
  
  public Looper c;
  
  public int d;
  
  public int e;
  
  public final Object f = new Object();
  
  public long g;
  
  public SurfaceTexture h = null;
  
  public List<SurfaceTextureCallback> i = new ArrayList<SurfaceTextureCallback>();
  
  public boolean j;
  
  public int k;
  
  public int l;
  
  public int m;
  
  public int n;
  
  public int o;
  
  public int p;
  
  public int q;
  
  public int r;
  
  public boolean s;
  
  public boolean t;
  
  public int u;
  
  public int v;
  
  public boolean w;
  
  public int x;
  
  public boolean y = false;
  
  public l z;
  
  public e(c.i parami) {
    h h1 = new h();
    this.H = h1;
    this.I = h1;
    this.P = 0L;
    this.Q = 0L;
    this.T = false;
    this.b = parami;
    this.d = -1;
    this.y = false;
  }
  
  public void a(int paramInt) {
    this.S = paramInt;
    m m1 = this.G;
    if (m1 != null)
      m1.a(paramInt); 
  }
  
  public final void a(int paramInt1, int paramInt2) {
    o o1 = new o();
    this.E = o1;
    o1.a(paramInt1, paramInt2, false);
  }
  
  public void a(PreviewAppearance paramPreviewAppearance) {
    this.N = paramPreviewAppearance;
  }
  
  public void a(StreamingPreviewCallback paramStreamingPreviewCallback) {
    this.R = paramStreamingPreviewCallback;
  }
  
  public void a(SurfaceTextureCallback paramSurfaceTextureCallback) {
    if (paramSurfaceTextureCallback != null)
      this.i.add(paramSurfaceTextureCallback); 
  }
  
  public void a(WatermarkSetting paramWatermarkSetting) {
    this.M = paramWatermarkSetting;
    this.L = true;
  }
  
  public void a(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean2, boolean paramBoolean3, int paramInt7) {
    if (paramInt3 == this.o && paramInt4 == this.p && paramInt5 == this.q && paramInt6 == this.r && paramBoolean3 == this.w && this.x == paramInt7) {
      a.a.a.a.a.e.e e2 = a.a.a.a.a.e.e.g;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("setCameraPreviewSize equal!!");
      stringBuilder1.append(paramInt3);
      stringBuilder1.append("  ");
      stringBuilder1.append(paramInt4);
      e2.c("CameraSurfaceRenderer", stringBuilder1.toString());
      if (!this.O)
        this.j = true; 
      return;
    } 
    this.t = paramBoolean1;
    a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.g;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setCameraPreviewSize previewSettingWidth:");
    stringBuilder.append(paramInt3);
    stringBuilder.append(",previewSettingHeight:");
    stringBuilder.append(paramInt4);
    e1.c("CameraSurfaceRenderer", stringBuilder.toString());
    this.o = paramInt3;
    this.p = paramInt4;
    if (paramInt7 == 0 || paramInt7 == 180) {
      this.u = paramInt1;
      this.v = paramInt2;
      this.k = paramInt3;
      this.l = paramInt4;
    } else {
      this.u = paramInt2;
      this.v = paramInt1;
      this.k = paramInt4;
      this.l = paramInt3;
    } 
    this.q = paramInt5;
    this.r = paramInt6;
    this.s = paramBoolean2;
    if (paramBoolean2) {
      this.m = paramInt5;
      this.n = paramInt6;
    } else {
      this.m = this.k;
      this.n = this.l;
    } 
    this.w = paramBoolean3;
    this.x = paramInt7;
    this.j = true;
  }
  
  public boolean a() {
    return this.O;
  }
  
  public boolean a(boolean paramBoolean) {
    this.K = paramBoolean;
    return true;
  }
  
  public int b() {
    return this.e;
  }
  
  public final void b(int paramInt) {
    long l1 = this.P + paramInt;
    this.P = l1;
    long l2 = this.Q + 1L;
    this.Q = l2;
    if (l2 >= 90L) {
      paramInt = (int)(l1 / l2);
      a.a.a.a.a.j.a.a().a(paramInt);
      this.Q = 0L;
      this.P = 0L;
    } 
  }
  
  public void c() {
    a.a.a.a.a.e.e.g.c("CameraSurfaceRenderer", "notifyPausing +");
    this.y = true;
    if (this.h != null) {
      a.a.a.a.a.e.e.g.c("CameraSurfaceRenderer", "renderer pausing -- releasing SurfaceTexture");
      if (Build.VERSION.SDK_INT < 16)
        this.h.release(); 
      this.h = null;
    } 
    h();
    if (!this.i.isEmpty()) {
      Iterator<SurfaceTextureCallback> iterator = this.i.iterator();
      while (iterator.hasNext())
        ((SurfaceTextureCallback)iterator.next()).onSurfaceDestroyed(); 
    } 
    Looper looper = this.c;
    if (looper != null) {
      looper.quit();
      this.c = null;
    } 
    a.a.a.a.a.e.e.g.c("CameraSurfaceRenderer", "notifyPausing -");
  }
  
  public void d() {
    if (this.h != null) {
      a.a.a.a.a.e.e.g.c("CameraSurfaceRenderer", "releasing SurfaceTexture");
      this.h.release();
      this.h = null;
    } 
  }
  
  public final void e() {
    if (this.M != null) {
      p p1 = new p();
      this.D = p1;
      PreviewAppearance previewAppearance = this.N;
      if (previewAppearance != null) {
        p1.a(this.m, this.n, previewAppearance.x, previewAppearance.y, previewAppearance.w, previewAppearance.h, this.M);
        return;
      } 
      p1.a(this.m, this.n, this.M);
    } 
  }
  
  public final void f() {
    p p1 = this.D;
    if (p1 != null) {
      p1.a();
      this.D = null;
    } 
  }
  
  public final c.m g() {
    return new c.m(this.h, this.d, d.a());
  }
  
  public final void h() {
    this.E = null;
    this.O = false;
    this.A = null;
    this.z = null;
    this.B = null;
    this.C = null;
    this.D = null;
    this.F = null;
    this.I.a();
    this.I = this.H;
  }
  
  public final void i() {
    this.O = false;
    a a2 = this.J;
    if (a2 != null) {
      a2.a();
      this.J = null;
    } 
    m m1 = this.G;
    if (m1 != null) {
      m1.g();
      this.G = null;
    } 
    a a1 = this.A;
    if (a1 != null) {
      a1.g();
      this.A = null;
    } 
    l l1 = this.z;
    if (l1 != null) {
      l1.g();
      this.z = null;
    } 
    o o2 = this.B;
    if (o2 != null) {
      o2.e();
      this.B = null;
    } 
    j j1 = this.C;
    if (j1 != null) {
      j1.g();
      this.C = null;
    } 
    f();
    o o1 = this.F;
    if (o1 != null) {
      o1.e();
      this.F = null;
    } 
    this.I.a();
    this.I = this.H;
  }
  
  public final void j() {
    int k;
    int n;
    a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.g;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("cropEnabled: ");
    stringBuilder.append(this.t);
    stringBuilder.append(" cropWidth: ");
    stringBuilder.append(this.u);
    stringBuilder.append(" cropHeight: ");
    stringBuilder.append(this.v);
    stringBuilder.append(" isFrontCamera: ");
    stringBuilder.append(this.w);
    stringBuilder.append(",previewWidth:");
    stringBuilder.append(this.k);
    stringBuilder.append(",previewHeight:");
    stringBuilder.append(this.l);
    stringBuilder.append(" rotation: ");
    stringBuilder.append(this.x);
    stringBuilder.append(" encodingWidth: ");
    stringBuilder.append(this.q);
    stringBuilder.append(" encodingHeight: ");
    stringBuilder.append(this.r);
    stringBuilder.append(" mIsMirror:");
    stringBuilder.append(this.K);
    e1.c("CameraSurfaceRenderer", stringBuilder.toString());
    l l1 = new l();
    this.z = l1;
    l1.a(0, this.k, this.l);
    a a1 = new a();
    this.A = a1;
    a1.a(0, this.k, this.l);
    m m1 = new m();
    this.G = m1;
    m1.a(this.k, this.l);
    this.G.a(this.S);
    if (this.t) {
      k = this.u;
      n = this.v;
      o o1 = new o();
      this.B = o1;
      o1.a(this.u, this.v, true);
      this.B.a(this.k, this.l, 0.0F, 0.0F, 1.0F, 1.0F, PreviewAppearance.ScaleType.FULL);
    } else {
      k = this.k;
      n = this.l;
    } 
    j j1 = new j();
    this.C = j1;
    j1.a(k, n);
    if (this.s) {
      o o1 = new o();
      this.F = o1;
      o1.a(this.m, this.n, true);
      PreviewAppearance previewAppearance = this.N;
      if (previewAppearance != null) {
        this.F.a(k, n, previewAppearance.x, previewAppearance.y, previewAppearance.w, previewAppearance.h, previewAppearance.scaleType);
      } else {
        this.F.a(k, n, 0.0F, 0.0F, 1.0F, 1.0F, PreviewAppearance.ScaleType.FULL);
      } 
    } 
    e();
    this.O = true;
  }
  
  public final void k() {
    PreviewAppearance.ScaleType scaleType;
    this.E.d();
    o o1 = this.E;
    int k = this.m;
    int n = this.n;
    PreviewAppearance previewAppearance = this.N;
    if (previewAppearance != null) {
      scaleType = previewAppearance.scaleType;
    } else {
      scaleType = PreviewAppearance.ScaleType.FULL;
    } 
    o1.a(k, n, 0.0F, 0.0F, 1.0F, 1.0F, scaleType);
  }
  
  public final void l() {
    Looper looper = this.c;
    if (looper != null) {
      looper.quit();
      this.c = null;
    } 
    (new Thread(new a(this))).start();
    Object object = this.f;
    /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
    try {
      while (this.c == null)
        this.f.wait(); 
    } catch (InterruptedException interruptedException) {
      interruptedException.printStackTrace();
    } finally {
      Exception exception;
    } 
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
  }
  
  public void onDrawFrame(GL10 paramGL10) {
    a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.g;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onDrawFrame tex=");
    stringBuilder.append(this.d);
    e1.a("CameraSurfaceRenderer", stringBuilder.toString());
    if (this.g != Thread.currentThread().getId()) {
      a.a.a.a.a.e.e.g.e("CameraSurfaceRenderer", "Error. Not in GLThread");
      return;
    } 
    if (this.y) {
      e1 = a.a.a.a.a.e.e.g;
      stringBuilder = new StringBuilder();
      stringBuilder.append("mPaused:");
      stringBuilder.append(this.y);
      e1.c("CameraSurfaceRenderer", stringBuilder.toString());
      return;
    } 
    SurfaceTexture surfaceTexture = this.h;
    if (surfaceTexture == null)
      return; 
    try {
      surfaceTexture.updateTexImage();
      if (this.T) {
        this.T = false;
        return;
      } 
      this.h.getTransformMatrix(this.a);
      if (this.o != 0) {
        if (this.p == 0)
          return; 
        int k = this.d;
        int n = k;
        if (!this.i.isEmpty()) {
          long l1 = System.currentTimeMillis();
          Iterator<SurfaceTextureCallback> iterator = this.i.iterator();
          while (iterator.hasNext()) {
            n = ((SurfaceTextureCallback)iterator.next()).onDrawFrame(k, this.o, this.p, this.a);
            if (n > 0)
              k = n; 
          } 
          b((int)(System.currentTimeMillis() - Long.valueOf(l1).longValue()));
          n = k;
        } 
        if (this.j) {
          this.j = false;
          i();
          j();
          k();
        } 
        if (!this.O)
          return; 
        synchronized (f.d) {
          if (n != this.d) {
            this.e = this.z.b(n, this.a);
          } else {
            this.e = this.A.b(n, this.a);
          } 
          if (this.G != null)
            this.e = this.G.d(this.e); 
          if (this.R != null) {
            if (this.J == null)
              this.J = new a(); 
            ByteBuffer byteBuffer = this.J.a(this.e, this.k, this.l);
            this.R.onPreviewFrame(byteBuffer.array(), this.k, this.l, 0, PLFourCC.FOURCC_I420, this.h.getTimestamp());
          } 
          if (this.B != null)
            this.e = this.B.a(0, this.e); 
          n = this.e;
          k = n;
          if (this.K) {
            null = this.C;
            k = n;
            if (null != null)
              k = null.d(n); 
          } 
          null = this.F;
          n = k;
          if (null != null)
            n = null.a(0, k); 
          if (this.L) {
            this.L = false;
            f();
            e();
          } 
          if (this.R != null && a.a.a.a.a.f.e.a().b()) {
            if (this.I == this.H) {
              null = new h();
              this.I = (h)null;
              null.a(this.R);
              null = new h.a(this.k, this.l, this.m, this.n, d.a());
              this.I.a(null);
            } 
            if (this.D != null)
              synchronized (f.d) {
                this.D.a(n);
                GLES20.glFinish();
              }  
            this.I.a(n, this.h);
          } else {
            null = this.D;
            if (null != null)
              null.a(n); 
          } 
          this.E.b(0, n);
          return;
        } 
      } 
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      a.a.a.a.a.e.e.g.e("CameraSurfaceRenderer", "update surface texture failed !!!");
      return;
    } 
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2) {
    a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.g;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onSurfaceChanged ");
    stringBuilder.append(paramInt1);
    stringBuilder.append("x");
    stringBuilder.append(paramInt2);
    e1.c("CameraSurfaceRenderer", stringBuilder.toString());
    this.T = true;
    if (!this.i.isEmpty()) {
      Iterator<SurfaceTextureCallback> iterator = this.i.iterator();
      while (iterator.hasNext())
        ((SurfaceTextureCallback)iterator.next()).onSurfaceChanged(paramInt1, paramInt2); 
    } 
    o o1 = this.E;
    boolean bool1 = false;
    boolean bool2 = false;
    if (o1 != null) {
      bool1 = bool2;
      if (o1.c() > 0)
        bool1 = true; 
      this.E.e();
    } 
    a(paramInt1, paramInt2);
    if (bool1)
      k(); 
    c.i i1 = this.b;
    i1.sendMessage(i1.obtainMessage(1));
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig) {
    a.a.a.a.a.e.e.g.c("CameraSurfaceRenderer", "onSurfaceCreated");
    this.g = Thread.currentThread().getId();
    this.b.removeCallbacksAndMessages(null);
    h();
    this.d = f.e();
    l();
    c.i i1 = this.b;
    i1.sendMessage(i1.obtainMessage(0, g()));
    if (!this.i.isEmpty()) {
      Iterator<SurfaceTextureCallback> iterator = this.i.iterator();
      while (iterator.hasNext())
        ((SurfaceTextureCallback)iterator.next()).onSurfaceCreated(); 
    } 
    this.y = false;
  }
  
  public class a implements Runnable {
    public a(e this$0) {}
    
    public void run() {
      Process.setThreadPriority(-8);
      Looper.prepare();
      e e1 = this.a;
      e.a(e1, new SurfaceTexture(e.a(e1)));
      e.a(this.a, Looper.myLooper());
      synchronized (e.b(this.a)) {
        e.b(this.a).notify();
        Looper.loop();
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */