package com.tencent.liteav;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.liteav.basic.b.c;
import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.opengl.n;
import com.tencent.liteav.basic.opengl.o;
import com.tencent.liteav.basic.structs.b;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.capturer.a;
import com.tencent.liteav.capturer.b;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import java.lang.ref.WeakReference;
import java.util.List;
import javax.microedition.khronos.egl.EGLContext;

public class c implements b, o, b, q {
  WeakReference<b> a;
  
  private Context b;
  
  private final a c = new a();
  
  private r d;
  
  private boolean e;
  
  private i f;
  
  private int g = 0;
  
  private n h = null;
  
  private boolean i = false;
  
  private long j = 0L;
  
  private long k;
  
  private long l = 0L;
  
  private int m = 0;
  
  private Object n = new Object();
  
  private HandlerThread o = null;
  
  private Handler p = null;
  
  private String q = "";
  
  private boolean r = true;
  
  public c(Context paramContext, i parami, n paramn, boolean paramBoolean) {
    try {
      this.f = (i)parami.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      this.f = new i();
      cloneNotSupportedException.printStackTrace();
    } 
    this.b = paramContext;
    this.h = paramn;
    this.h.setSurfaceTextureListener(this);
    i i1 = this.f;
    i1.W = paramBoolean;
    this.c.b(i1.U);
    TXCLog.i("TXCCameraCaptureSource", "camera capture with nv21: %b", new Object[] { Boolean.valueOf(this.f.W) });
  }
  
  private void a(int paramInt, String paramString) {
    g.a(this.a, paramInt, paramString);
  }
  
  private void a(int paramInt1, byte[] paramArrayOfbyte, float[] paramArrayOffloat, int paramInt2) {
    boolean bool;
    if (!this.e)
      return; 
    if (!this.i) {
      Monitor.a(2, String.format("VideoCapture[%d]: capture first frame", new Object[] { Integer.valueOf(hashCode()) }), "", 0);
      g.a(this.a, 1007, "First frame capture completed");
      this.i = true;
      this.r = true;
      TXCLog.i("CameraCapture", "trtc_render: render first frame");
    } 
    b b1 = new b();
    b1.e = this.c.j();
    b1.f = this.c.k();
    b1.g = this.f.a;
    b1.h = this.f.b;
    b1.j = this.c.h();
    if (this.c.i()) {
      if (!this.f.S) {
        bool = true;
      } else {
        bool = false;
      } 
    } else {
      bool = this.f.S;
    } 
    b1.i = bool;
    b1.a = paramInt1;
    b1.c = paramArrayOffloat;
    b1.d = this.f.W;
    b1.m = paramArrayOfbyte;
    b1.b = paramInt2;
    if (b1.j == 0 || b1.j == 180) {
      b1.g = this.f.b;
      b1.h = this.f.a;
    } else {
      b1.g = this.f.a;
      b1.h = this.f.b;
    } 
    b1.l = g.a(b1.e, b1.f, this.f.b, this.f.a);
    r r1 = this.d;
    if (r1 != null)
      r1.b(b1); 
    if (this.r) {
      this.r = false;
      TXCLog.i("CameraCapture", String.format("vsize onCaptureFrame w*h:%d*%d angle:%d", new Object[] { Integer.valueOf(b1.g), Integer.valueOf(b1.h), Integer.valueOf(b1.j) }));
    } 
    this.j++;
    long l = System.currentTimeMillis() - this.k;
    if (l >= 1000L) {
      double d = (this.j - this.l) * 1000.0D / l;
      TXCStatus.a(this.q, 1001, this.m, Double.valueOf(d));
      this.l = this.j;
      this.k += l;
    } 
  }
  
  private void a(SurfaceTexture paramSurfaceTexture) {
    if (paramSurfaceTexture != null && !this.e) {
      a a1 = this.c;
      if (a1 != null) {
        a1.a(this);
        this.c.a(paramSurfaceTexture);
        this.c.a(this.f.h);
        this.c.c(this.f.l);
        this.c.c(this.f.K);
        this.c.a(n());
        this.c.a(this.f.W, this.f.a, this.f.b);
        int j = this.c.d(this.f.m);
        String str = "front";
        if (j == 0) {
          this.e = true;
          this.k = System.currentTimeMillis();
          j = hashCode();
          if (!this.f.m)
            str = "back"; 
          Monitor.a(2, String.format("VideoCapture[%d]: start %s camera successfully", new Object[] { Integer.valueOf(j), str }), String.format("w*h:%d*%d orientation:%d", new Object[] { Integer.valueOf(this.f.a), Integer.valueOf(this.f.b), Integer.valueOf(this.f.l) }), 0);
          a(1003, "Enabled camera successfully");
          this.i = false;
          return;
        } 
        this.e = false;
        a(-1301, "Failed to open camera, please confirm whether the camera permission is turned on");
        j = hashCode();
        if (!this.f.m)
          str = "back"; 
        Monitor.a(2, String.format("VideoCapture[%d]: start %s camera failed", new Object[] { Integer.valueOf(j), str }), String.format("w*h:%d*%d orientation:%d", new Object[] { Integer.valueOf(this.f.a), Integer.valueOf(this.f.b), Integer.valueOf(this.f.l) }), 0);
      } 
    } 
  }
  
  private a.a n() {
    if (this.f.T)
      return a.a.i; 
    int j = null.a[this.f.k.ordinal()];
    return (j != 1) ? ((j != 2) ? ((j != 3) ? ((j != 4) ? ((j != 5) ? a.a.g : a.a.d) : a.a.h) : a.a.f) : a.a.e) : a.a.a;
  }
  
  private boolean o() {
    try {
      if (this.b != null) {
        List list = ((ActivityManager)this.b.getSystemService("activity")).getRunningAppProcesses();
        if (list == null) {
          TXCLog.w("CameraCapture", "List of RunningAppProcessInfo is null");
          return false;
        } 
      } else {
        return false;
      } 
    } catch (Exception exception) {
      return false;
    } 
    int j;
    for (j = 0; j < exception.size(); j++) {
      ActivityManager.RunningAppProcessInfo runningAppProcessInfo = exception.get(j);
      if (runningAppProcessInfo == null) {
        TXCLog.w("CameraCapture", "ActivityManager.RunningAppProcessInfo is null");
      } else if (runningAppProcessInfo.processName.equals(this.b.getPackageName())) {
        int k = runningAppProcessInfo.importance;
        if (k == 100)
          return true; 
      } 
    } 
    return false;
  }
  
  public void a() {
    int j;
    int k = hashCode();
    if (this.h.getSurfaceTexture() == null) {
      j = 0;
    } else {
      j = this.h.getSurfaceTexture().hashCode();
    } 
    Monitor.a(2, String.format("VideoCapture[%d]: start camera. sufaceTexture:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(j) }), "", 0);
    this.h.a(this.f.h, this.f.W ^ true);
    a(this.h.getSurfaceTexture());
  }
  
  public void a(float paramFloat) {
    this.c.a(paramFloat);
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    if (this.c != null && this.f.K)
      this.c.a(paramFloat1, paramFloat2); 
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.c.a(paramInt1, paramInt2);
  }
  
  public void a(c paramc) {
    this.f.k = paramc;
    this.r = true;
  }
  
  public void a(b paramb) {
    this.a = new WeakReference<b>(paramb);
  }
  
  public void a(b paramb) {
    n n1 = this.h;
    if (n1 != null)
      n1.a(paramb.a, paramb.i, this.g, paramb.e, paramb.f, this.c.i()); 
  }
  
  public void a(r paramr) {
    this.d = paramr;
  }
  
  public void a(Runnable paramRunnable) {
    this.h.a(paramRunnable);
  }
  
  public void a(String paramString) {
    this.q = paramString;
  }
  
  public void a(boolean paramBoolean) {
    Monitor.a(2, String.format("VideoCapture[%d]: stop camera", new Object[] { Integer.valueOf(hashCode()) }), "", 0);
    c();
    this.h.a();
    synchronized (this.n) {
      if (this.p != null)
        this.p.removeCallbacksAndMessages(null); 
      if (this.o != null) {
        TXCLog.w("CameraCapture", "stop camera monitor ");
        this.o.quit();
        this.o = null;
        this.p = null;
      } 
      return;
    } 
  }
  
  public void a(byte[] paramArrayOfbyte) {
    n n1 = this.h;
    if (n1 != null)
      n1.a(paramArrayOfbyte); 
  }
  
  public boolean a(int paramInt) {
    return this.c.b(paramInt);
  }
  
  public void b() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("startCapture->enter with getSurfaceTexture:");
    stringBuilder.append(this.h.getSurfaceTexture());
    TXCLog.i("CameraCapture", stringBuilder.toString());
    a(this.h.getSurfaceTexture());
  }
  
  public void b(int paramInt) {
    this.g = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2) {
    i i1 = this.f;
    i1.a = paramInt1;
    i1.b = paramInt2;
    this.r = true;
    TXCLog.i("CameraCapture", String.format("vsize setVideoEncSize w*h:%d*%d orientation:%d", new Object[] { Integer.valueOf(i1.a), Integer.valueOf(this.f.b), Integer.valueOf(this.f.l) }));
  }
  
  public void b(boolean paramBoolean) {
    if (this.e && this.c != null) {
      i i1 = this.f;
      if (paramBoolean) {
        if (!i1.m) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        } 
      } else {
        paramBoolean = i1.m;
      } 
      i1.m = paramBoolean;
      this.c.g();
      this.h.a(false);
      this.c.a(this.f.h);
      this.c.c(this.f.l);
      this.c.a(n());
      this.c.a(this.f.W, this.f.a, this.f.b);
      this.c.a(this);
      this.c.a(this.h.getSurfaceTexture());
      int j = this.c.d(this.f.m);
      String str = "front";
      if (j == 0) {
        this.e = true;
        j = hashCode();
        if (!this.f.m)
          str = "back"; 
        Monitor.a(2, String.format("VideoCapture[%d]: start %s camera successfully", new Object[] { Integer.valueOf(j), str }), String.format("w*h:%d*%d orientation:%d", new Object[] { Integer.valueOf(this.f.a), Integer.valueOf(this.f.b), Integer.valueOf(this.f.l) }), 0);
        a(1003, "Enabled camera successfully");
      } else {
        this.e = false;
        a(-1301, "Failed to open the camera, please confirm whether the camera permission is turned on");
        j = hashCode();
        if (!this.f.m)
          str = "back"; 
        Monitor.a(2, String.format("VideoCapture[%d]: start %s camera failed", new Object[] { Integer.valueOf(j), str }), String.format("w*h:%d*%d orientation:%d", new Object[] { Integer.valueOf(this.f.a), Integer.valueOf(this.f.b), Integer.valueOf(this.f.l) }), 0);
      } 
      this.i = false;
    } 
  }
  
  public void c() {
    TXCLog.i("CameraCapture", "stopCapture->enter with null");
    this.c.a(null);
    this.c.g();
    this.e = false;
  }
  
  public void c(int paramInt) {
    n n1 = this.h;
    if (n1 != null)
      n1.setRendMode(paramInt); 
  }
  
  public void c(boolean paramBoolean) {
    a(new Runnable(this, paramBoolean) {
          public void run() {
            (c.a(this.b)).S = this.a;
          }
        });
  }
  
  public void d(int paramInt) {
    n n1 = this.h;
    if (n1 != null)
      n1.setRendMirror(paramInt); 
  }
  
  public boolean d() {
    return this.e;
  }
  
  public boolean d(boolean paramBoolean) {
    return this.c.a(paramBoolean);
  }
  
  public int e() {
    return this.c.f();
  }
  
  public void e(int paramInt) {
    i i1 = this.f;
    i1.l = paramInt;
    this.c.c(i1.l);
    this.r = true;
    TXCLog.i("CameraCapture", String.format("vsize setCaptureOrientation w*h:%d*%d orientation:%d", new Object[] { Integer.valueOf(this.f.a), Integer.valueOf(this.f.b), Integer.valueOf(this.f.l) }));
  }
  
  public void e(boolean paramBoolean) {
    this.f.U = paramBoolean;
    this.c.b(paramBoolean);
    this.r = true;
  }
  
  public EGLContext f() {
    return this.h.getGLContext();
  }
  
  public void f(int paramInt) {
    this.f.h = paramInt;
    a a1 = this.c;
    if (a1 != null)
      a1.a(paramInt); 
    n n1 = this.h;
    if (n1 != null && n1 instanceof TXCGLSurfaceView)
      ((TXCGLSurfaceView)n1).setFPS(paramInt); 
  }
  
  public int g() {
    return this.f.h;
  }
  
  public void g(int paramInt) {
    this.m = paramInt;
  }
  
  public boolean h() {
    a a1 = this.c;
    return (a1 != null) ? a1.b() : false;
  }
  
  public boolean i() {
    a a1 = this.c;
    return (a1 != null) ? a1.c() : false;
  }
  
  public boolean j() {
    a a1 = this.c;
    return (a1 != null) ? a1.d() : false;
  }
  
  public boolean k() {
    a a1 = this.c;
    return (a1 != null) ? a1.e() : false;
  }
  
  public boolean l() {
    a a1 = this.c;
    return (a1 != null) ? a1.i() : false;
  }
  
  public void m() {
    if (this.c.l() != null)
      this.c.g(); 
    synchronized (this.n) {
      if (this.o == null) {
        this.o = new HandlerThread("cameraMonitorThread");
        this.o.start();
        this.p = new Handler(this.o.getLooper());
        TXCLog.w("CameraCapture", "start camera monitor ");
      } 
      if (this.p != null)
        this.p.postDelayed(new Runnable(this) {
              public void run() {
                try {
                  if (this.a.d() && c.b(this.a) && c.c(this.a).l() == null) {
                    TXCLog.w("CameraCapture", "camera monitor restart capture");
                    c.c(this.a).g();
                    c.d(this.a).a(false);
                    c.c(this.a).a((c.a(this.a)).h);
                    c.c(this.a).a((c.a(this.a)).W, (c.a(this.a)).a, (c.a(this.a)).b);
                    c.c(this.a).a(c.d(this.a).getSurfaceTexture());
                    c.c(this.a).d((c.a(this.a)).m);
                    return;
                  } 
                  if (c.e(this.a) != null) {
                    c.e(this.a).postDelayed(this, 2000L);
                    return;
                  } 
                } catch (Exception exception) {
                  TXCLog.w("CameraCapture", "camera monitor exception ");
                } 
              }
            }2000L); 
      return;
    } 
  }
  
  public void onBufferProcess(byte[] paramArrayOfbyte, float[] paramArrayOffloat) {
    a(-1, paramArrayOfbyte, paramArrayOffloat, 3);
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle) {
    g.a(this.a, paramInt, paramBundle);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onSurfaceTextureAvailable->enter with mListener:");
    stringBuilder.append(this.d);
    TXCLog.i("CameraCapture", stringBuilder.toString());
    a(paramSurfaceTexture);
    r r1 = this.d;
    if (r1 != null)
      r1.a(paramSurfaceTexture); 
  }
  
  public void onSurfaceTextureDestroy(SurfaceTexture paramSurfaceTexture) {
    c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onSurfaceTextureDestroy->enter with mListener:");
    stringBuilder.append(this.d);
    TXCLog.i("CameraCapture", stringBuilder.toString());
    r r1 = this.d;
    if (r1 != null)
      r1.t(); 
  }
  
  public int onTextureProcess(int paramInt, float[] paramArrayOffloat) {
    a(paramInt, null, paramArrayOffloat, 4);
    return 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\liteav\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */