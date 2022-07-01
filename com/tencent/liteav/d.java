package com.tencent.liteav;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.view.Surface;
import com.tencent.liteav.basic.b.c;
import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.license.e;
import com.tencent.liteav.basic.license.g;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.module.a;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.opengl.f;
import com.tencent.liteav.basic.opengl.g;
import com.tencent.liteav.basic.opengl.h;
import com.tencent.liteav.basic.opengl.j;
import com.tencent.liteav.basic.opengl.n;
import com.tencent.liteav.basic.opengl.p;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.structs.b;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.c;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.beauty.b;
import com.tencent.liteav.beauty.b.p;
import com.tencent.liteav.beauty.b.w;
import com.tencent.liteav.beauty.e;
import com.tencent.liteav.beauty.g;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import com.tencent.liteav.screencapture.a;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.liteav.videoencoder.b;
import com.tencent.liteav.videoencoder.d;
import com.tencent.rtmp.TXLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class d extends a implements b.b, b, g, r, d {
  private Surface A = null;
  
  private int B = 0;
  
  private int C = 0;
  
  private g D = null;
  
  private b E;
  
  private int F = 0;
  
  private boolean G = false;
  
  private boolean H = false;
  
  private long I = 0L;
  
  private long J = 0L;
  
  private int K = 2;
  
  private WeakReference<u> L;
  
  private boolean M = false;
  
  private WeakReference<a> N = null;
  
  private j O = null;
  
  private j P;
  
  private j Q;
  
  private p R;
  
  private int S = -1;
  
  private boolean T = false;
  
  private boolean U = false;
  
  private boolean V = false;
  
  private final b W;
  
  private boolean X = true;
  
  private WeakReference<s> Y;
  
  private f Z = null;
  
  b a;
  
  private WeakReference<b> aa;
  
  private int ab = 0;
  
  private int ac = 0;
  
  b b;
  
  private final c c = new c("capturer", (int)TimeUnit.SECONDS.toMillis(5L));
  
  private final f d = new f(Looper.getMainLooper());
  
  private q e = null;
  
  private e f = null;
  
  private boolean g = false;
  
  private boolean h = false;
  
  private TXSVideoEncoderParam i = null;
  
  private b j = null;
  
  private int k = 15;
  
  private boolean l = false;
  
  private TXSVideoEncoderParam m = null;
  
  private b n = null;
  
  private final Object o = new Object();
  
  private Context p = null;
  
  private i q = null;
  
  private int r = 0;
  
  private int s = 0;
  
  private int t = 0;
  
  private boolean u = false;
  
  private int v = 0;
  
  private int w = 0;
  
  private boolean x = false;
  
  private TXCloudVideoView y = null;
  
  private final Object z = new Object();
  
  public d(Context paramContext) {
    this.p = paramContext.getApplicationContext();
    this.q = new i();
    this.f = new e(this.p, true);
    this.f.a(this);
    this.f.a(this);
    if (this.q.U) {
      this.f.a(e.d.a);
    } else if (this.q.T) {
      this.f.a(e.d.b);
    } else {
      this.f.a(e.d.c);
    } 
    this.i = new TXSVideoEncoderParam();
    this.i.encoderMode = 1;
    this.j = null;
    this.m = new TXSVideoEncoderParam();
    this.m.encoderMode = 1;
    this.a = new b(this);
    this.W = new b((e)new g(this.p));
    this.W.setPreprocessor(this.f);
    c.a().a(this.p);
  }
  
  private void A() {
    try {
      b b1 = this.n;
      this.n = null;
      if (b1 != null) {
        b1.a();
        b1.a(null);
        return;
      } 
    } catch (Exception exception) {
      TXCLog.e("TXCCaptureAndEnc", "stop video encoder failed.", exception);
    } 
  }
  
  private void B() {
    try {
      TXCLog.i("TXCCaptureAndEnc", "stopBigVideoEncoderInGLThread");
      b b1 = this.j;
      this.j = null;
      if (b1 != null) {
        b1.a();
        b1.a(null);
      } 
      this.U = true;
      return;
    } catch (Exception exception) {
      TXCLog.e("TXCCaptureAndEnc", "stopBigVideoEncoder failed.", exception);
      return;
    } 
  }
  
  private void C() {
    q q1 = this.e;
    if (q1 != null)
      q1.a(new Runnable(this) {
            public void run() {
              d d1 = this.a;
              d.a(d1, (d.c(d1)).width, (d.c(this.a)).height);
            }
          }); 
  }
  
  private void D() {
    if (this.f != null) {
      if (this.q.U) {
        this.f.a(e.d.a);
        return;
      } 
      if (this.q.T) {
        this.f.a(e.d.b);
        return;
      } 
      this.f.a(e.d.c);
    } 
  }
  
  private int a(int paramInt1, int paramInt2, Object paramObject) {
    paramInt1 = this.q.a;
    paramInt2 = this.q.b;
    if (this.q.l == 0 || this.q.l == 2) {
      paramInt1 = this.q.b;
      paramInt2 = this.q.a;
    } 
    if (paramInt1 <= 0 || paramInt2 <= 0) {
      TXCLog.e("TXCCaptureAndEnc", "sendCustomYUVData: invalid video encode resolution");
      return -1;
    } 
    if (this.q.M) {
      B();
      return -1000;
    } 
    b(paramInt1, paramInt2, paramObject);
    return 0;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
    long l = paramLong;
    if (paramLong == 0L)
      l = TXCTimeUtil.generatePtsMS(); 
    b(paramInt2, paramInt3, this.f.a());
    b b1 = this.j;
    if (b1 != null) {
      b1.b(this.X);
      b1.a(paramInt1, paramInt2, paramInt3, l);
    } 
    b1 = this.n;
    if (b1 != null) {
      b1.b(this.X);
      b1.a(paramInt1, paramInt2, paramInt3, l);
    } 
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, int paramInt4, boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("New encode size width = ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" height = ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" encType = ");
    stringBuilder.append(paramInt3);
    stringBuilder.append(" eglContext: ");
    stringBuilder.append(paramObject);
    TXCLog.i("TXCCaptureAndEnc", stringBuilder.toString());
    B();
    b b1 = new b(paramInt3);
    TXCStatus.a(getID(), 4005, this.F, Integer.valueOf(paramInt3));
    if (paramInt3 == 1) {
      TXCEventRecorderProxy.a(getID(), 4004, 1L, -1L, "", this.F);
    } else {
      TXCEventRecorderProxy.a(getID(), 4004, 0L, -1L, "", this.F);
    } 
    this.U = false;
    TXSVideoEncoderParam tXSVideoEncoderParam = this.i;
    tXSVideoEncoderParam.encodeType = paramInt3;
    tXSVideoEncoderParam.width = paramInt1;
    tXSVideoEncoderParam.height = paramInt2;
    tXSVideoEncoderParam.fps = paramInt4;
    tXSVideoEncoderParam.gop = this.q.i;
    this.i.encoderProfile = this.q.n;
    tXSVideoEncoderParam = this.i;
    if (paramObject == null)
      paramObject = b1.a(paramInt1, paramInt2); 
    tXSVideoEncoderParam.glContext = paramObject;
    paramObject = this.i;
    ((TXSVideoEncoderParam)paramObject).realTime = paramBoolean;
    ((TXSVideoEncoderParam)paramObject).streamType = this.F;
    ((TXSVideoEncoderParam)paramObject).annexb = this.H;
    ((TXSVideoEncoderParam)paramObject).bMultiRef = this.G;
    ((TXSVideoEncoderParam)paramObject).baseFrameIndex = this.I + 20L;
    ((TXSVideoEncoderParam)paramObject).baseGopIndex = (this.J + 1L) % 255L + 1L;
    ((TXSVideoEncoderParam)paramObject).bLimitFps = this.h;
    ((TXSVideoEncoderParam)paramObject).record = this.V;
    ((TXSVideoEncoderParam)paramObject).encFmt = this.q.Y;
    b1.a(this);
    b1.a(this);
    b1.a(this.i);
    b1.c(this.q.c);
    b1.d(this.k);
    b1.setID(getID());
    b1.a(this.ab);
    this.j = b1;
    TXCStatus.a(getID(), 4003, this.F, Integer.valueOf(this.i.width << 16 | this.i.height));
    TXCStatus.a(getID(), 13003, this.F, Integer.valueOf(this.i.gop * 1000));
    TXCEventRecorderProxy.a(getID(), 4003, this.i.width, this.i.height, "", this.F);
    TXCKeyPointReportProxy.a(40036, this.i.encodeType, this.F);
    TXCKeyPointReportProxy.a(40037, this.i.width << 16 | this.i.height, this.F);
  }
  
  private void a(int paramInt, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("EVT_USERID", getID());
    bundle.putInt("EVT_ID", paramInt);
    bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    bundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
    if (paramString != null)
      bundle.putCharSequence("EVT_MSG", paramString); 
    g.a(this.aa, paramInt, bundle);
    if (paramInt == -1317) {
      TXCEventRecorderProxy.a(getID(), 2002, 4L, -1L, "", this.F);
    } else if (paramInt == -1314) {
      TXCEventRecorderProxy.a(getID(), 2002, 5L, -1L, "", this.F);
    } else if (paramInt == 1003 && this.e != null) {
      long l;
      paramString = getID();
      if (this.e.l()) {
        l = 0L;
      } else {
        l = 1L;
      } 
      TXCEventRecorderProxy.a(paramString, 4001, l, -1L, "", this.F);
    } 
    if (paramInt == -1302 || paramInt == -1317 || paramInt == -1318 || paramInt == -1319) {
      TXCKeyPointReportProxy.b(30002, paramInt);
      return;
    } 
    if (paramInt == -1301 || paramInt == -1314 || paramInt == -1315 || paramInt == -1316) {
      TXCKeyPointReportProxy.b(30003, paramInt);
      if (this.e != null) {
        long l;
        paramString = getID();
        if (this.e.l()) {
          l = 0L;
        } else {
          l = 1L;
        } 
        TXCEventRecorderProxy.a(paramString, 4002, l, paramInt, "", this.F);
        return;
      } 
    } 
  }
  
  private void a(b paramb, int paramInt1, int paramInt2, Object paramObject, long paramLong) {
    synchronized (this.o) {
      if (this.t == 2)
        return; 
      paramb.e = paramInt1;
      paramb.f = paramInt2;
      paramb.i = this.q.S;
      if (this.q.l == 0) {
        paramb.g = this.q.b;
        paramb.h = this.q.a;
      } else {
        paramb.g = this.q.a;
        paramb.h = this.q.b;
      } 
      paramb.l = g.a(paramb.e, paramb.f, paramb.g, paramb.h);
      try {
        this.f.a(this.q.l);
        this.f.a(paramObject);
        this.f.a(paramb, paramb.b, 0, paramLong);
      } catch (Exception exception) {
        paramObject = new StringBuilder();
        paramObject.append("send custom video frame failed.");
        paramObject.append(exception.getMessage());
        TXCLog.e("TXCCaptureAndEnc", paramObject.toString());
      } 
      return;
    } 
  }
  
  private void a(b paramb, boolean paramBoolean) {
    e(paramb.e, paramb.f);
    this.E = paramb;
    if (this.y != null) {
      q q1 = this.e;
      if (q1 != null) {
        q1.a(paramb);
        return;
      } 
    } else {
      synchronized (this.z) {
        if (this.A != null && this.D == null && this.e != null && this.e.f() != null) {
          this.D = new g();
          this.D.a(this.e.f(), this.A);
          this.D.a(this.w);
          this.D.b(this.ac);
        } 
        if (this.D != null && this.e != null)
          this.D.a(paramb.a, paramb.i, this.v, this.B, this.C, paramb.e, paramb.f, paramBoolean, this.e.l()); 
        return;
      } 
    } 
  }
  
  private void a(Object paramObject, int paramInt, boolean paramBoolean) {
    A();
    b b1 = new b(paramInt);
    TXCStatus.a(getID(), 4005, 3, Integer.valueOf(paramInt));
    if (paramInt == 1) {
      TXCEventRecorderProxy.a(getID(), 4004, 1L, -1L, "", 3);
    } else {
      TXCEventRecorderProxy.a(getID(), 4004, 0L, -1L, "", 3);
    } 
    TXSVideoEncoderParam tXSVideoEncoderParam = this.m;
    if (paramObject == null)
      paramObject = b1.a(tXSVideoEncoderParam.width, this.m.height); 
    tXSVideoEncoderParam.glContext = paramObject;
    paramObject = this.m;
    ((TXSVideoEncoderParam)paramObject).encodeType = paramInt;
    ((TXSVideoEncoderParam)paramObject).realTime = paramBoolean;
    TXCLog.i("TXCCaptureAndEnc", "start small video encoder");
    b1.a(this);
    b1.a(this);
    b1.a(this.m);
    b1.c(this.m.bitrate);
    b1.setID(getID());
    b1.a(this.ab);
    this.n = b1;
    TXCStatus.a(getID(), 4003, 3, Integer.valueOf(this.m.width << 16 | this.m.height));
    TXCStatus.a(getID(), 13003, 3, Integer.valueOf(this.m.gop * 1000));
  }
  
  private void a(Runnable paramRunnable) {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.d.a(paramRunnable);
      return;
    } 
    paramRunnable.run();
  }
  
  private void b(int paramInt1, int paramInt2, Object paramObject) {
    int n = this.q.j;
    int m = 2;
    int k = m;
    if (n != 0)
      if (n != 1) {
        if (n != 2) {
          k = m;
        } else {
          k = 3;
        } 
      } else {
        k = 1;
      }  
    m = k;
    if (this.r == 1) {
      m = k;
      if (this.s == 0)
        m = 1; 
    } 
    k = this.q.i;
    if (this.j == null || this.U || this.i.width != paramInt1 || this.i.height != paramInt2 || this.i.encodeType != m || this.i.gop != k)
      a(paramInt1, paramInt2, m, paramObject, this.q.h, this.q.P); 
    if ((this.n == null || this.m.encodeType != m) && this.l)
      a(paramObject, m, this.q.P); 
  }
  
  private int c(b paramb) {
    boolean bool;
    if (this.M)
      return paramb.a; 
    int m = paramb.a;
    if (this.ac == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    int k = m;
    if (bool != paramb.i) {
      if (this.P == null) {
        j j2 = new j();
        j2.c();
        j2.a(true);
        j2.a(paramb.e, paramb.f);
        if (paramb.e > paramb.f) {
          j2.h();
        } else {
          j2.g();
        } 
        this.P = j2;
      } 
      j j1 = this.P;
      k = m;
      if (j1 != null) {
        j1.a(paramb.e, paramb.f);
        k = j1.a(paramb.a);
      } 
    } 
    m = k;
    if (this.v != 0) {
      if (this.Q == null) {
        j j2 = new j();
        j2.c();
        j2.a(true);
        j2.a(paramb.e, paramb.f);
        this.Q = j2;
      } 
      j j1 = this.Q;
      m = k;
      if (j1 != null) {
        int n;
        GLES20.glViewport(0, 0, paramb.e, paramb.f);
        int i1 = paramb.e;
        int i2 = paramb.f;
        float[] arrayOfFloat = j1.a(i1, i2, null, g.a(i1, i2, paramb.e, paramb.f), 0);
        int i3 = (720 - this.v) % 360;
        if (i3 == 90 || i3 == 270) {
          m = paramb.f;
        } else {
          m = paramb.e;
        } 
        if (i3 == 90 || i3 == 270) {
          n = paramb.e;
        } else {
          n = paramb.f;
        } 
        j1.a(i1, i2, i3, arrayOfFloat, m / n, false, false);
        j1.a(k);
        m = j1.l();
      } 
    } 
    return m;
  }
  
  private void c(int paramInt1, int paramInt2) {
    if (this.q.J != -1.0F) {
      e e1 = this.f;
      if (e1 != null) {
        e1.a(this.q.E, this.q.H, this.q.I, this.q.J);
        return;
      } 
    } else {
      e e1 = this.f;
      if (e1 != null && paramInt1 != 0 && paramInt2 != 0) {
        Bitmap bitmap = this.q.E;
        float f2 = this.q.F;
        float f1 = paramInt1;
        f2 /= f1;
        float f3 = this.q.G / paramInt2;
        if (this.q.E == null) {
          f1 = 0.0F;
        } else {
          f1 = this.q.E.getWidth() / f1;
        } 
        e1.a(bitmap, f2, f3, f1);
      } 
    } 
  }
  
  private void d(int paramInt1, int paramInt2) {
    c(paramInt1, paramInt2);
  }
  
  private void d(b paramb) {
    u u;
    ByteBuffer byteBuffer;
    WeakReference<u> weakReference = this.L;
    if (weakReference == null) {
      weakReference = null;
    } else {
      u = weakReference.get();
    } 
    if (u == null)
      return; 
    TXSVideoFrame tXSVideoFrame = new TXSVideoFrame();
    tXSVideoFrame.width = paramb.e;
    tXSVideoFrame.height = paramb.f;
    tXSVideoFrame.pts = TXCTimeUtil.generatePtsMS();
    int m = c(paramb);
    int k = this.K;
    if (k == 5) {
      tXSVideoFrame.textureId = m;
      tXSVideoFrame.eglContext = this.f.a();
      if (this.S == -1) {
        this.S = TXCOpenGlUtils.d();
        TXCLog.i("TXCCaptureAndEnc", "create FrameBuffer: %d", new Object[] { Integer.valueOf(this.S) });
      } 
      TXCOpenGlUtils.a(tXSVideoFrame.textureId, this.S);
      GLES20.glBindFramebuffer(36160, this.S);
      u.onRenderVideoFrame(getID(), this.F, tXSVideoFrame);
      TXCOpenGlUtils.d(this.S);
      if (this.M) {
        if (tXSVideoFrame.data != null) {
          byteBuffer = ByteBuffer.wrap(tXSVideoFrame.data);
        } else {
          byteBuffer = tXSVideoFrame.buffer;
        } 
        byteBuffer.position(0);
        paramb.a = TXCOpenGlUtils.a(byteBuffer, paramb.e, paramb.f, m);
      } 
    } else if (k == 2) {
      tXSVideoFrame.textureId = m;
      tXSVideoFrame.eglContext = this.f.a();
      byteBuffer.onRenderVideoFrame(getID(), this.F, tXSVideoFrame);
      if (this.M)
        paramb.a = tXSVideoFrame.textureId; 
    } else if (k == 1 || k == 4) {
      j j1 = this.O;
      k = 3;
      if (j1 == null) {
        w w;
        if (this.K == 1) {
          w = new w(1);
        } else {
          w = new w(3);
        } 
        w.a(true);
        if (w.c()) {
          w.a(paramb.e, paramb.f);
          this.O = (j)w;
        } else {
          TXCLog.i("TXCCaptureAndEnc", "init filter error ");
          this.O = null;
        } 
      } 
      j1 = this.O;
      if (j1 != null) {
        GLES20.glViewport(0, 0, paramb.e, paramb.f);
        j1.a(paramb.e, paramb.f);
        j1.a(m);
        GLES20.glBindFramebuffer(36160, j1.m());
        byteBuffer.onRenderVideoFrame(getID(), this.F, tXSVideoFrame);
      } 
      if (this.M && (tXSVideoFrame.data != null || tXSVideoFrame.buffer != null)) {
        m = this.K;
        if (m == 1 || m != 4)
          k = 1; 
        if (this.R == null) {
          p p2 = new p(k);
          p2.a(true);
          if (!p2.c())
            TXCLog.w("TXCCaptureAndEnc", " init i420ToRGBA filter failed"); 
          p2.a(paramb.e, paramb.f);
          this.R = p2;
        } 
        p p1 = this.R;
        GLES20.glViewport(0, 0, paramb.e, paramb.f);
        p1.a(paramb.e, paramb.f);
        if (tXSVideoFrame.data != null) {
          p1.a(tXSVideoFrame.data);
        } else {
          p1.a(tXSVideoFrame.buffer);
        } 
        paramb.a = p1.r();
      } 
    } 
    if (this.M) {
      TXCloudVideoView tXCloudVideoView = this.y;
      if (tXCloudVideoView != null) {
        TXCGLSurfaceView tXCGLSurfaceView = tXCloudVideoView.getGLSurfaceView();
        if (tXCGLSurfaceView != null)
          tXCGLSurfaceView.d(); 
      } 
    } 
  }
  
  private void e(int paramInt1, int paramInt2) {
    if (!this.x) {
      Bundle bundle = new Bundle();
      bundle.putString("EVT_USERID", getID());
      bundle.putInt("EVT_ID", 2003);
      bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      bundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
      bundle.putCharSequence("EVT_MSG", "Renders the first video frame");
      bundle.putInt("EVT_PARAM1", paramInt1);
      bundle.putInt("EVT_PARAM2", paramInt2);
      g.a(this.aa, 2003, bundle);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("trtc_render render first frame ");
      stringBuilder.append(getID());
      stringBuilder.append(", ");
      stringBuilder.append(this.F);
      TXCLog.i("TXCCaptureAndEnc", stringBuilder.toString());
      this.x = true;
    } 
  }
  
  private void k(boolean paramBoolean) {
    q q1 = this.e;
    if (q1 == null)
      return; 
    q1.a(new Runnable(this) {
          public void run() {
            if (d.l(this.a) != null)
              d.l(this.a).b(); 
          }
        });
    u();
    this.e.a(paramBoolean);
    this.e = null;
    TXCLog.i("TXCCaptureAndEnc", "stopped CaptureSource");
    TXCloudVideoView tXCloudVideoView = this.y;
    this.d.post(new Runnable(this, tXCloudVideoView, paramBoolean) {
          public void run() {
            TXCloudVideoView tXCloudVideoView = this.a;
            if (tXCloudVideoView != null)
              tXCloudVideoView.stop(this.b); 
          }
        });
    this.y = null;
    synchronized (this.z) {
      this.A = null;
      if (this.D != null) {
        this.D.a();
        this.D = null;
      } 
      if (this.a.a())
        this.a.b(); 
      if (this.u)
        x(); 
      return;
    } 
  }
  
  private void l(boolean paramBoolean) {
    q q1 = this.e;
    if (q1 != null)
      q1.a(new Runnable(this, paramBoolean) {
            public void run() {
              q q = d.e(this.b);
              if (q == null)
                return; 
              q.f((d.d(this.b)).h);
              q.e((d.d(this.b)).l);
              q.a((d.d(this.b)).k);
              q.b((d.d(this.b)).a, (d.d(this.b)).b);
              q.e((d.d(this.b)).U);
              if (this.a && q.d())
                q.b(false); 
            }
          }); 
  }
  
  private void x() {
    TXCLog.i("TXCCaptureAndEnc", " startBlackStream");
    if (this.b == null)
      this.b = new b(this); 
    this.b.a(10, -1, null, 64, 64);
  }
  
  private void y() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" stopBlackStream when enableBlackStream ");
    stringBuilder.append(this.u);
    TXCLog.i("TXCCaptureAndEnc", stringBuilder.toString());
    b b1 = this.b;
    if (b1 != null)
      b1.b(); 
  }
  
  private void z() {
    int k = this.S;
    if (k != -1) {
      TXCLog.i("TXCCaptureAndEnc", "destroy FrameBuffer: %d", new Object[] { Integer.valueOf(k) });
      TXCOpenGlUtils.b(this.S);
      this.S = -1;
    } 
    f f1 = this.Z;
    s s = null;
    if (f1 != null) {
      f1.e();
      this.Z = null;
    } 
    WeakReference<s> weakReference = this.Y;
    if (weakReference != null)
      s = weakReference.get(); 
    if (s != null)
      s.onGLContextReadyToDestory(); 
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong) {
    synchronized (this.o) {
      if (this.t == 2)
        return 0; 
      int k = a(paramInt2, paramInt3, paramObject);
      if (k != 0)
        return k; 
      if (paramLong == 0L)
        paramLong = TXCTimeUtil.generatePtsMS(); 
      paramObject = this.j;
      if (paramObject != null) {
        paramObject.a(this.q.S);
        paramObject.a(paramInt1, paramInt2, paramInt3, paramLong);
      } 
      paramObject = this.n;
      if (paramObject != null) {
        paramObject.a(this.q.S);
        paramObject.a(paramInt1, paramInt2, paramInt3, paramLong);
      } 
      return 0;
    } 
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong, int paramInt4) {
    b b1 = new b();
    b1.a = paramInt1;
    b1.b = 0;
    a(b1, paramInt2, paramInt3, paramObject, paramLong);
    return 0;
  }
  
  public int a(b paramb) {
    WeakReference<s> weakReference = this.Y;
    if (weakReference != null) {
      s s = weakReference.get();
    } else {
      weakReference = null;
    } 
    if (weakReference != null) {
      f f1 = this.Z;
      if (f1 == null || f1.c() != paramb.e || this.Z.d() != paramb.f) {
        f1 = this.Z;
        if (f1 != null)
          f1.e(); 
        this.Z = new f(paramb.e, paramb.f);
        this.Z.a();
      } 
      paramb.a = weakReference.onProcessVideoFrame(paramb.a, paramb.e, paramb.f, this.Z.b());
      GLES20.glDisable(3042);
      GLES20.glDisable(2929);
    } 
    d(paramb);
    a(paramb, false);
    return paramb.a;
  }
  
  public int a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    boolean bool;
    if (this.m.width != paramInt1 || this.m.height != paramInt2) {
      bool = true;
    } else {
      bool = false;
    } 
    TXSVideoEncoderParam tXSVideoEncoderParam = this.m;
    tXSVideoEncoderParam.width = paramInt1;
    tXSVideoEncoderParam.height = paramInt2;
    tXSVideoEncoderParam.fps = paramInt3;
    tXSVideoEncoderParam.gop = paramInt5;
    tXSVideoEncoderParam.encoderProfile = 1;
    tXSVideoEncoderParam.realTime = this.q.P;
    tXSVideoEncoderParam = this.m;
    tXSVideoEncoderParam.streamType = 3;
    tXSVideoEncoderParam.bitrate = paramInt4;
    tXSVideoEncoderParam.annexb = true;
    tXSVideoEncoderParam.bMultiRef = false;
    if (this.n != null && (bool || (this.l && !paramBoolean))) {
      q q1 = this.e;
      if (q1 != null) {
        q1.a(new Runnable(this) {
              public void run() {
                d.h(this.a);
              }
            });
      } else {
        A();
      } 
    } 
    this.l = paramBoolean;
    return 0;
  }
  
  public int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, long paramLong) {
    synchronized (this.o) {
      if (this.t == 2)
        return 0; 
      int k = a(paramInt2, paramInt3, (Object)null);
      if (k != 0)
        return k; 
      b b1 = this.j;
      if (b1 != null) {
        if (paramLong == 0L)
          paramLong = TXCTimeUtil.generatePtsMS(); 
        b1.a(paramArrayOfbyte, paramInt1, paramInt2, paramInt3, paramLong);
      } 
      return 0;
    } 
  }
  
  public int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong, int paramInt4) {
    b b1 = new b();
    b1.m = paramArrayOfbyte;
    b1.b = paramInt1;
    b1.d = true;
    a(b1, paramInt2, paramInt3, paramObject, paramLong);
    return 0;
  }
  
  public void a() {
    TXCLog.i("TXCCaptureAndEnc", "onPushEnd");
    WeakReference<a> weakReference = this.N;
    if (weakReference == null)
      return; 
    a a1 = weakReference.get();
    if (a1 == null)
      return; 
    a1.onBackgroudPushStop();
  }
  
  public void a(float paramFloat) {
    q q1 = this.e;
    if (q1 == null)
      return; 
    q1.a(paramFloat);
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    if (this.e != null && this.q.K)
      this.e.a(paramFloat1, paramFloat2); 
  }
  
  public void a(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("vrotation setVideoEncRotation ");
    stringBuilder.append(paramInt);
    TXCLog.i("TXCCaptureAndEnc", stringBuilder.toString());
    this.ab = paramInt;
    q q1 = this.e;
    if (q1 != null) {
      q1.a(new Runnable(this, paramInt) {
            public void run() {
              if (d.a(this.b) != null)
                d.a(this.b).a(this.a); 
              if (d.b(this.b) != null)
                d.b(this.b).a(this.a); 
            }
          });
      return;
    } 
    b b1 = this.j;
    if (b1 != null)
      b1.a(paramInt); 
    b1 = this.n;
    if (b1 != null)
      b1.a(paramInt); 
  }
  
  public void a(int paramInt1, int paramInt2) {
    synchronized (this.z) {
      if (this.D != null) {
        this.D.a(new Runnable(this, paramInt1, paramInt2) {
              public void run() {
                d.b(this.c, this.a);
                d.c(this.c, this.b);
                if (d.j(this.c) != null && d.k(this.c) != null) {
                  d d1 = this.c;
                  d.a(d1, d.j(d1), true);
                } 
              }
            });
      } else {
        this.B = paramInt1;
        this.C = paramInt2;
      } 
      return;
    } 
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {
    q q1 = this.e;
    if (q1 == null)
      return; 
    q1.a(new Runnable(this, paramInt2, paramInt3, paramInt1) {
          public void run() {
            if (this.a != 0 && this.b != 0) {
              (d.d(this.d)).a = this.a;
              (d.d(this.d)).b = this.b;
              if (d.e(this.d) != null) {
                d.e(this.d).a(c.a);
                d.e(this.d).b(this.a, this.b);
              } 
            } 
            if (this.c != 0 && d.a(this.d) != null) {
              (d.d(this.d)).c = this.c;
              d.a(this.d).c(this.c);
            } 
          }
        });
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
    if (paramInt1 == 2) {
      if (this.i.width != 0 && this.i.height != 0 && (paramInt2 != this.i.width || paramInt3 != this.i.height || paramInt4 > this.i.fps)) {
        q q1 = this.e;
        if (q1 != null)
          q1.a(new Runnable(this, paramInt2, paramInt3, paramInt4, paramInt5) {
                public void run() {
                  if (this.a != (d.c(this.e)).width || this.b != (d.c(this.e)).height || this.c > (d.c(this.e)).fps) {
                    int i = this.a;
                    int j = this.b;
                    if (i > j) {
                      (d.d(this.e)).l = 0;
                    } else if (i < j) {
                      (d.d(this.e)).l = 1;
                    } 
                    i i1 = d.d(this.e);
                    j = this.a;
                    int k = this.b;
                    i = j;
                    if (j > k)
                      i = k; 
                    i1.a = i;
                    i1 = d.d(this.e);
                    i = this.a;
                    j = this.b;
                    if (i <= j)
                      i = j; 
                    i1.b = i;
                    q q = d.e(this.e);
                    if (q != null) {
                      q.a(c.a);
                      q.b((d.d(this.e)).a, (d.d(this.e)).b);
                      q.e((d.d(this.e)).l);
                    } 
                    (d.d(this.e)).c = this.d;
                    (d.d(this.e)).h = this.c;
                    d.f(this.e);
                    TXCLog.e("TXCCaptureAndEnc", String.format("QOS restart big encoder old resolution %dx%d fps %d, new resolution %dx%d fps %d", new Object[] { Integer.valueOf((d.c(this.e)).width), Integer.valueOf((d.c(this.e)).height), Integer.valueOf((d.c(this.e)).fps), Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c) }));
                  } 
                }
              }); 
      } else {
        b b2 = this.j;
        if (b2 != null) {
          b2.b(paramInt5, paramInt6);
          b2.b(paramInt4);
        } 
      } 
      d(paramInt7);
      return;
    } 
    TXSVideoEncoderParam tXSVideoEncoderParam = this.m;
    if (tXSVideoEncoderParam != null && (paramInt2 != tXSVideoEncoderParam.width || paramInt3 != this.m.height)) {
      q q1 = this.e;
      if (q1 != null)
        q1.a(new Runnable(this, paramInt2, paramInt3, paramInt4) {
              public void run() {
                TXCLog.w("TXCCaptureAndEnc", String.format("QOS restart big encoder old resolution %dx%d fps %d, new resolution %dx%d fps %d", new Object[] { Integer.valueOf((d.g(this.d)).width), Integer.valueOf((d.g(this.d)).height), Integer.valueOf((d.g(this.d)).fps), Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c) }));
                (d.g(this.d)).width = this.a;
                (d.g(this.d)).height = this.b;
                d.h(this.d);
              }
            }); 
    } 
    b b1 = this.n;
    if (b1 != null) {
      b1.b(paramInt5, paramInt6);
      b1.b(paramInt4);
    } 
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3) {
    i i1 = this.q;
    i1.E = paramBitmap;
    i1.H = paramFloat1;
    i1.I = paramFloat2;
    i1.J = paramFloat3;
    C();
  }
  
  public void a(Bitmap paramBitmap, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {
    Runnable runnable = new Runnable(this, paramBitmap, paramByteBuffer, paramInt1, paramInt2) {
        public void run() {
          try {
            if ((d.m(this.e) == 2 || d.n(this.e)) && this.a != null) {
              if (this.b == null)
                return; 
              if (d.a(this.e) == null || d.o(this.e) || (d.c(this.e)).width != this.c || (d.c(this.e)).height != this.d || (d.c(this.e)).encodeType != 2 || (d.c(this.e)).gop != (d.d(this.e)).i)
                d.a(this.e, this.c, this.d, 2, (Object)null, (d.d(this.e)).C, true); 
              if ((d.b(this.e) == null || (d.g(this.e)).encodeType != 2) && d.p(this.e))
                d.a(this.e, (Object)null, 2, true); 
              int i = this.a.getWidth();
              int j = this.a.getHeight();
              b b = d.a(this.e);
              if (b != null)
                b.a(this.b.array(), 2, i, j, TXCTimeUtil.generatePtsMS()); 
              b = d.b(this.e);
              if (b != null) {
                b.a(this.b.array(), 2, i, j, TXCTimeUtil.generatePtsMS());
                return;
              } 
            } else {
              return;
            } 
          } catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onPushBitmap failed.");
            stringBuilder.append(exception.getMessage());
            TXCLog.e("TXCCaptureAndEnc", stringBuilder.toString());
          } 
        }
      };
    q q1 = this.e;
    if (q1 != null) {
      q1.a(runnable);
      return;
    } 
    runnable.run();
  }
  
  public void a(SurfaceTexture paramSurfaceTexture) {
    e e1 = this.f;
    if (e1 != null)
      e1.b(); 
    WeakReference<s> weakReference = this.Y;
    if (weakReference != null) {
      s s = weakReference.get();
    } else {
      weakReference = null;
    } 
    if (weakReference != null)
      weakReference.onGLContextCreated(); 
  }
  
  public void a(Surface paramSurface) {
    if (this.y != null) {
      TXCLog.w("TXCCaptureAndEnc", "camera preview view is not null, can't set surface");
      return;
    } 
    synchronized (this.z) {
      if (this.A != paramSurface) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("surface-render: set surface ");
        stringBuilder.append(paramSurface);
        TXCLog.i("TXCCaptureAndEnc", stringBuilder.toString());
        this.A = paramSurface;
        if (this.D != null) {
          this.D.a();
          this.D = null;
        } 
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("surface-render: set surface the same");
        stringBuilder.append(paramSurface);
        TXCLog.i("TXCCaptureAndEnc", stringBuilder.toString());
      } 
      return;
    } 
  }
  
  public void a(b paramb) {
    this.aa = new WeakReference<b>(paramb);
  }
  
  public void a(p paramp) {
    TXCloudVideoView tXCloudVideoView = this.y;
    if (tXCloudVideoView != null) {
      TXCGLSurfaceView tXCGLSurfaceView = tXCloudVideoView.getGLSurfaceView();
      if (tXCGLSurfaceView != null) {
        tXCGLSurfaceView.a(new p(this, paramp) {
              public void onTakePhotoComplete(Bitmap param1Bitmap) {
                p p1 = this.a;
                if (p1 != null)
                  p1.onTakePhotoComplete(param1Bitmap); 
              }
            });
        return;
      } 
      if (paramp != null) {
        paramp.onTakePhotoComplete(null);
        return;
      } 
    } else {
      g g1 = this.D;
      if (g1 != null) {
        g1.a(new p(this, paramp) {
              public void onTakePhotoComplete(Bitmap param1Bitmap) {
                p p1 = this.a;
                if (p1 != null)
                  p1.onTakePhotoComplete(param1Bitmap); 
              }
            });
        return;
      } 
      if (paramp != null)
        paramp.onTakePhotoComplete(null); 
    } 
  }
  
  public void a(b paramb, long paramLong) {
    a(paramb.a, paramb.e, paramb.f, paramLong);
  }
  
  public void a(a parama) {
    this.N = new WeakReference<a>(parama);
  }
  
  public void a(i parami) {
    boolean bool1;
    boolean bool2;
    boolean bool3;
    boolean bool4 = false;
    if (parami != null && (this.q.E != parami.E || this.q.F != parami.F || this.q.G != parami.G || this.q.J != parami.J || this.q.H != parami.H || this.q.I != parami.I)) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (parami != null && (this.q.a != parami.a || this.q.b != parami.b)) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (parami != null && this.q.a > 0 && this.q.b > 0 && parami.a > 0 && parami.b > 0 && Math.abs((this.q.a / this.q.b) - (parami.a / parami.b)) > 0.1D) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    if (parami != null) {
      try {
        this.q = (i)parami.clone();
      } catch (CloneNotSupportedException cloneNotSupportedException) {
        this.q = new i();
        cloneNotSupportedException.printStackTrace();
      } 
    } else {
      this.q = new i();
    } 
    TXCLog.i("TXCCaptureAndEnc", String.format("vsize setConfig w*h:%d*%d orientation:%d", new Object[] { Integer.valueOf(this.q.a), Integer.valueOf(this.q.b), Integer.valueOf(this.q.l) }));
    q q1 = this.e;
    if (q1 != null)
      q1.e(this.q.l); 
    D();
    if (this.q.T) {
      bool2 = bool4;
    } else if (!this.q.U) {
      bool2 = bool3;
    } 
    l(bool2);
    if (k() && bool1)
      C(); 
  }
  
  public void a(s params) {
    this.Y = new WeakReference<s>(params);
  }
  
  public void a(a.a parama) {
    StringBuilder stringBuilder;
    if (Build.VERSION.SDK_INT < 21) {
      Bundle bundle = new Bundle();
      bundle.putString("EVT_MSG", "Screen recording failed, unsupported Android system version. system version should above 5.0");
      onNotifyEvent(-1309, bundle);
      stringBuilder = new StringBuilder();
      stringBuilder.append("Screen capture need running on Android Lollipop or higher version, current:");
      stringBuilder.append(Build.VERSION.SDK_INT);
      TXLog.e("TXCCaptureAndEnc", stringBuilder.toString());
      return;
    } 
    this.r = 1;
    if (this.e == null) {
      this.e = new l(this.p, this.q, (a.a)stringBuilder);
      TXCLog.i("TXCCaptureAndEnc", "create TXCScreenCaptureSource");
    } 
    this.W.a(false);
    j(this.F);
    this.e.a(this);
    this.e.a(this);
    this.e.a();
    this.e.a(getID());
    TXCDRApi.txReportDAU(this.p, a.aH);
  }
  
  public void a(u paramu, int paramInt) {
    this.K = paramInt;
    if (paramu != null) {
      this.L = new WeakReference<u>(paramu);
      return;
    } 
    this.L = null;
  }
  
  public void a(TXCloudVideoView paramTXCloudVideoView) {
    h h;
    if (this.q.M) {
      TXCLog.e("TXCCaptureAndEnc", "enable pure audio push , so can not start preview!");
      return;
    } 
    b b1 = this.a;
    if (b1 != null)
      b1.b(); 
    this.x = false;
    boolean bool = this.q.W;
    if (paramTXCloudVideoView != null) {
      TXCGLSurfaceView[] arrayOfTXCGLSurfaceView = new TXCGLSurfaceView[1];
      a(new Runnable(this, arrayOfTXCGLSurfaceView, paramTXCloudVideoView) {
            public void run() {
              this.a[0] = new TXCGLSurfaceView(this.b.getContext());
              this.b.addVideoView(this.a[0]);
            }
          });
      TXCGLSurfaceView tXCGLSurfaceView = arrayOfTXCGLSurfaceView[0];
      arrayOfTXCGLSurfaceView[0].setNotifyListener(this);
      TXCLog.i("TXCCaptureAndEnc", "start camera preview with GLSurfaceView");
    } else {
      h = new h();
      TXCLog.i("TXCCaptureAndEnc", "start camera preview with SurfaceTexture");
      bool = false;
    } 
    this.r = 0;
    this.e = new c(this.p, this.q, (n)h, bool);
    y();
    j(this.F);
    this.e.a(getID());
    this.e.a(this);
    this.e.a(this);
    this.e.a();
    this.e.b(this.v);
    this.e.c(this.w);
    this.e.d(this.ac);
    this.y = paramTXCloudVideoView;
    this.d.post(new Runnable(this, paramTXCloudVideoView) {
          public void run() {
            TXCloudVideoView tXCloudVideoView = this.a;
            if (tXCloudVideoView != null)
              tXCloudVideoView.start((d.d(this.b)).K, (d.d(this.b)).L, d.e(this.b)); 
          }
        });
    this.x = false;
    TXCKeyPointReportProxy.a(30003);
  }
  
  public void a(boolean paramBoolean) {
    this.M = paramBoolean;
  }
  
  public TXBeautyManager b() {
    return (TXBeautyManager)this.W;
  }
  
  public void b(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setLocalViewMirror ");
    stringBuilder.append(paramInt);
    TXCLog.i("TXCCaptureAndEnc", stringBuilder.toString());
    this.ac = paramInt;
    q q1 = this.e;
    if (q1 != null)
      q1.d(this.ac); 
    g g1 = this.D;
    if (g1 != null)
      g1.b(this.ac); 
  }
  
  public void b(int paramInt1, int paramInt2) {
    q q1 = this.e;
    if (q1 == null)
      return; 
    q1.a(paramInt1, paramInt2);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3) {
    this.W.setBeautyLevel(paramInt1);
    this.W.setWhitenessLevel(paramInt2);
    this.W.setRuddyLevel(paramInt3);
  }
  
  public void b(b paramb) {
    this.c.a();
    if (!this.T) {
      this.T = true;
      TXCKeyPointReportProxy.b(30003, 0);
    } 
    if (this.t == 2)
      return; 
    q q1 = this.e;
    if (this.f != null && !this.q.M && q1 != null) {
      if (this.i.height != paramb.h || this.i.width != paramb.g)
        d(paramb.g, paramb.h); 
      this.f.a(q1.f());
      this.f.a(this.q.l);
      this.f.a(paramb, paramb.b, 0, 0L);
    } 
  }
  
  public void b(boolean paramBoolean) {
    this.X = paramBoolean;
    TXCLog.i("TXCCaptureAndEnc", "Is encoder need texture after glFinish: %b", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, long paramLong) {}
  
  public i c() {
    return this.q;
  }
  
  public void c(int paramInt) {
    q q1 = this.e;
    if (q1 == null)
      return; 
    q1.a(new Runnable(this, paramInt) {
          public void run() {
            if (d.a(this.b) != null)
              d.a(this.b).d(this.a); 
            d.a(this.b, this.a);
          }
        });
  }
  
  public void c(boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("enableBlackStream ");
    stringBuilder.append(paramBoolean);
    TXCLog.i("TXCCaptureAndEnc", stringBuilder.toString());
    this.u = paramBoolean;
    if (this.u) {
      if (this.e == null) {
        x();
        return;
      } 
    } else {
      y();
    } 
  }
  
  public int d() {
    return this.i.width;
  }
  
  public void d(int paramInt) {
    q q1 = this.e;
    if (q1 == null)
      return; 
    q1.a(new Runnable(this, paramInt) {
          public void run() {
            if (d.a(this.b) != null)
              d.a(this.b).e(this.a); 
          }
        });
  }
  
  public void d(boolean paramBoolean) {
    k(paramBoolean);
  }
  
  public int e() {
    return this.i.height;
  }
  
  public void e(int paramInt) {
    if (this.q.h == paramInt)
      return; 
    this.q.h = paramInt;
    q q1 = this.e;
    if (q1 != null && q1.g() < paramInt) {
      int k = this.r;
      if (k != 0) {
        if (k != 1)
          return; 
        this.e.f(paramInt);
        return;
      } 
      l(true);
      u();
    } 
  }
  
  public void e(boolean paramBoolean) {
    this.V = paramBoolean;
  }
  
  public int f() {
    if (k()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ignore startPush when pushing, status:");
      stringBuilder.append(this.t);
      TXCLog.w("TXCCaptureAndEnc", stringBuilder.toString());
      return -2;
    } 
    TXCDRApi.initCrashReport(this.p);
    this.t = 1;
    TXCLog.i("TXCCaptureAndEnc", "startWithoutAudio");
    D();
    TXCDRApi.txReportDAU(this.p, a.bv);
    return 0;
  }
  
  public void f(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setRenderMode ");
    stringBuilder.append(paramInt);
    TXCLog.i("TXCCaptureAndEnc", stringBuilder.toString());
    this.w = paramInt;
    q q1 = this.e;
    if (q1 != null)
      q1.c(paramInt); 
    g g1 = this.D;
    if (g1 != null)
      g1.a(this.w); 
  }
  
  public boolean f(boolean paramBoolean) {
    q q1 = this.e;
    return (q1 == null) ? false : q1.d(paramBoolean);
  }
  
  public void g() {
    if (!k()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ignore stopPush when not pushing, status:");
      stringBuilder.append(this.t);
      TXCLog.w("TXCCaptureAndEnc", stringBuilder.toString());
      return;
    } 
    TXCLog.i("TXCCaptureAndEnc", "stop");
    this.t = 0;
    u();
    this.q.P = false;
    b b1 = this.a;
    if (b1 != null)
      b1.b(); 
    c(false);
    this.E = null;
  }
  
  public void g(int paramInt) {
    if (this.v != paramInt) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("vrotation setRenderRotation ");
      stringBuilder.append(paramInt);
      TXCLog.i("TXCCaptureAndEnc", stringBuilder.toString());
    } 
    this.v = paramInt;
    q q1 = this.e;
    if (q1 == null)
      return; 
    q1.b(paramInt);
  }
  
  public boolean g(boolean paramBoolean) {
    this.q.S = paramBoolean;
    q q1 = this.e;
    if (q1 == null)
      return false; 
    q1.c(paramBoolean);
    return true;
  }
  
  public void h() {
    if (this.t != 1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ignore pause push when is not pushing, status:");
      stringBuilder.append(this.t);
      TXCLog.w("TXCCaptureAndEnc", stringBuilder.toString());
      return;
    } 
    this.t = 2;
    TXCLog.i("TXCCaptureAndEnc", "pausePusher");
    if ((this.q.D & 0x1) == 1) {
      u();
      if (this.a != null && !this.q.M)
        this.a.a(this.q.C, this.q.B, this.q.A, this.i.width, this.i.height); 
      q q1 = this.e;
      if (q1 != null)
        q1.c(); 
    } 
  }
  
  public void h(int paramInt) {
    this.W.setBeautyStyle(paramInt);
  }
  
  public void h(boolean paramBoolean) {
    if (this.G == paramBoolean)
      return; 
    this.G = paramBoolean;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("trtc_api onVideoConfigChanged enableRps ");
    stringBuilder.append(this.G);
    TXCLog.i("TXCCaptureAndEnc", stringBuilder.toString());
    if (this.G)
      this.q.j = 0; 
    u();
  }
  
  public void i() {
    if (this.t != 2) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ignore resume push when is not pause, status:");
      stringBuilder.append(this.t);
      TXCLog.w("TXCCaptureAndEnc", stringBuilder.toString());
      return;
    } 
    this.t = 1;
    TXCLog.i("TXCCaptureAndEnc", "resumePusher");
    if ((this.q.D & 0x1) == 1) {
      if (this.a != null && !this.q.M)
        this.a.b(); 
      u();
      q q1 = this.e;
      if (q1 != null)
        q1.b(); 
      C();
    } 
  }
  
  public void i(boolean paramBoolean) {
    this.h = paramBoolean;
  }
  
  public boolean i(int paramInt) {
    q q1 = this.e;
    return (q1 == null) ? false : q1.a(paramInt);
  }
  
  public void j(int paramInt) {
    this.F = paramInt;
    q q1 = this.e;
    if (q1 != null)
      q1.g(this.F); 
  }
  
  public void j(boolean paramBoolean) {
    this.H = paramBoolean;
  }
  
  public boolean j() {
    return this.u;
  }
  
  public void k(int paramInt) {
    b b1;
    if (paramInt == 2) {
      b1 = this.j;
    } else if (paramInt == 3) {
      b1 = this.n;
    } else {
      b1 = null;
    } 
    if (b1 != null)
      b1.b(); 
  }
  
  public boolean k() {
    return (this.t != 0);
  }
  
  public void l() {
    q q1 = this.e;
    if (q1 == null)
      return; 
    q1.a(new Runnable(this) {
          public void run() {
            if (d.e(this.a) != null)
              d.e(this.a).b(true); 
            d d1 = this.a;
            d.a(d1, (d.c(d1)).width, (d.c(this.a)).height);
            d1 = this.a;
            d1.a(d.i(d1));
          }
        });
  }
  
  public void l(int paramInt) {
    int k = paramInt;
    if (paramInt < 1)
      k = 1; 
    paramInt = k;
    if (k > 2)
      paramInt = 2; 
    Runnable runnable = new Runnable(this, paramInt) {
        public void run() {
          if ((d.c(this.b)).encoderMode == this.a)
            return; 
          (d.c(this.b)).encoderMode = this.a;
          (d.g(this.b)).encoderMode = this.a;
          d.f(this.b);
          d.h(this.b);
        }
      };
    q q1 = this.e;
    if (q1 == null) {
      runnable.run();
      return;
    } 
    q1.a(runnable);
  }
  
  public void m() {
    if (this.e == null)
      return; 
    this.W.a(true);
    k(true);
  }
  
  public boolean n() {
    q q1 = this.e;
    return (q1 != null) ? q1.h() : false;
  }
  
  public boolean o() {
    q q1 = this.e;
    return (q1 != null) ? q1.i() : false;
  }
  
  public void onEncodeDataIn(int paramInt) {}
  
  public void onEncodeFinished(int paramInt, long paramLong1, long paramLong2) {
    if (paramInt == 2) {
      this.J = paramLong1;
      this.I = paramLong2;
    } 
  }
  
  public void onEncodeFormat(MediaFormat paramMediaFormat) {
    WeakReference<a> weakReference = this.N;
    if (weakReference == null)
      return; 
    a a1 = weakReference.get();
    if (a1 != null)
      a1.onEncVideoFormat(paramMediaFormat); 
  }
  
  public void onEncodeNAL(TXSNALPacket paramTXSNALPacket, int paramInt) {
    if (paramInt == 0) {
      if (paramTXSNALPacket.streamType == 2) {
        this.J = paramTXSNALPacket.gopIndex;
        this.I = paramTXSNALPacket.frameIndex;
      } 
      WeakReference<a> weakReference = this.N;
      if (weakReference == null)
        return; 
      a a1 = weakReference.get();
      if (a1 != null) {
        a1.onEncVideo(paramTXSNALPacket);
        return;
      } 
    } else if ((paramInt == 10000004 || paramInt == 10000005) && this.i.encodeType == 1) {
      Monitor.a(2, String.format("VideoEncoder: hardware encoder error %d, switch to software encoder", new Object[] { Integer.valueOf(paramInt) }), "", 0);
      u();
      this.s++;
      this.q.j = 0;
      a(1103, "Failed to enable hardware encoder, use software encoder");
    } 
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle) {
    if (paramBundle != null)
      paramBundle.putString("EVT_USERID", getID()); 
    g.a(this.aa, paramInt, paramBundle);
    if (paramInt == -1317) {
      TXCEventRecorderProxy.a(getID(), 2002, 4L, -1L, "", this.F);
    } else if (paramInt == -1314) {
      TXCEventRecorderProxy.a(getID(), 2002, 5L, -1L, "", this.F);
    } else if (paramInt == 1003) {
      if (this.e != null) {
        long l;
        String str = getID();
        if (this.e.l()) {
          l = 0L;
        } else {
          l = 1L;
        } 
        TXCEventRecorderProxy.a(str, 4001, l, -1L, "", this.F);
      } 
    } else if (paramInt == -1308) {
      m();
    } 
    if (paramInt == -1302 || paramInt == -1317 || paramInt == -1318 || paramInt == -1319) {
      TXCKeyPointReportProxy.b(30002, paramInt);
      return;
    } 
    if (paramInt == -1301 || paramInt == -1314 || paramInt == -1315 || paramInt == -1316) {
      TXCKeyPointReportProxy.b(30003, paramInt);
      if (this.e != null) {
        long l;
        String str = getID();
        if (this.e.l()) {
          l = 0L;
        } else {
          l = 1L;
        } 
        TXCEventRecorderProxy.a(str, 4002, l, paramInt, "", this.F);
        return;
      } 
    } 
  }
  
  public void onRestartEncoder(int paramInt) {
    if (this.i.width * this.i.height < 518400) {
      this.q.j = 0;
    } else if (this.i.width * this.i.height < 921600 && this.g) {
      this.q.j = 0;
    } 
    if (paramInt == 3) {
      w();
      return;
    } 
    this.g = true;
    v();
  }
  
  public boolean p() {
    q q1 = this.e;
    return (q1 != null) ? q1.j() : false;
  }
  
  public boolean q() {
    q q1 = this.e;
    return (q1 != null) ? q1.k() : false;
  }
  
  public int r() {
    q q1 = this.e;
    return (q1 == null) ? 0 : q1.e();
  }
  
  public void s() {
    try {
      if (this.f != null)
        this.f.b(); 
      if (this.O != null) {
        this.O.e();
        this.O = null;
      } 
      if (this.Q != null) {
        this.Q.e();
        this.Q = null;
      } 
      if (this.P != null) {
        this.P.e();
        this.P = null;
      } 
      B();
      A();
      z();
      return;
    } catch (Exception exception) {
      TXCLog.e("TXCCaptureAndEnc", "stop preprocessor and encoder failed.", exception);
      return;
    } 
  }
  
  public void setID(String paramString) {
    super.setID(paramString);
    b b1 = this.j;
    if (b1 != null)
      b1.setID(paramString); 
    b1 = this.n;
    if (b1 != null)
      b1.setID(paramString); 
    e e1 = this.f;
    if (e1 != null)
      e1.setID(paramString); 
    q q1 = this.e;
    if (q1 != null)
      q1.a(getID()); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setID:");
    stringBuilder.append(paramString);
    TXCLog.w("TXCCaptureAndEnc", stringBuilder.toString());
  }
  
  public void t() {
    TXCLog.i("TXCCaptureAndEnc", "onCaptureDestroy->enter ");
    e e1 = this.f;
    if (e1 != null)
      e1.b(); 
    j j1 = this.O;
    if (j1 != null) {
      j1.e();
      this.O = null;
    } 
    j1 = this.Q;
    if (j1 != null) {
      j1.e();
      this.Q = null;
    } 
    j1 = this.P;
    if (j1 != null) {
      j1.e();
      this.P = null;
    } 
    p p1 = this.R;
    if (p1 != null) {
      p1.e();
      this.R = null;
    } 
    B();
    A();
    z();
  }
  
  public void u() {
    null = new Runnable(this) {
        public void run() {
          d.f(this.a);
          d.h(this.a);
        }
      };
    q q1 = this.e;
    if (q1 != null) {
      q1.a(null);
      return;
    } 
    synchronized (this.o) {
      null.run();
      return;
    } 
  }
  
  public void v() {
    if (this.j == null)
      return; 
    q q1 = this.e;
    if (q1 != null) {
      q1.a(new Runnable(this) {
            public void run() {
              d.f(this.a);
            }
          });
      return;
    } 
    B();
  }
  
  public void w() {
    if (this.n == null)
      return; 
    q q1 = this.e;
    if (q1 != null) {
      q1.a(new Runnable(this) {
            public void run() {
              d.h(this.a);
            }
          });
      return;
    } 
    A();
  }
  
  public static interface a {
    void onBackgroudPushStop();
    
    void onEncVideo(TXSNALPacket param1TXSNALPacket);
    
    void onEncVideoFormat(MediaFormat param1MediaFormat);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\liteav\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */