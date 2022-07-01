package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.opengl.GLSurfaceView;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLBuiltinFilter;
import com.qiniu.pili.droid.shortvideo.PLCameraParamSelectListener;
import com.qiniu.pili.droid.shortvideo.PLCameraPreviewListener;
import com.qiniu.pili.droid.shortvideo.PLCameraSetting;
import com.qiniu.pili.droid.shortvideo.PLCaptureFrameListener;
import com.qiniu.pili.droid.shortvideo.PLEffectPlugin;
import com.qiniu.pili.droid.shortvideo.PLFaceBeautySetting;
import com.qiniu.pili.droid.shortvideo.PLFocusListener;
import com.qiniu.pili.droid.shortvideo.PLMicrophoneSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoFilterListener;
import com.qiniu.pili.droid.shortvideo.PLVideoFrame;
import com.qiniu.pili.droid.shortvideo.PLWatermarkSetting;
import com.qiniu.pili.droid.shortvideo.a.a.b;
import com.qiniu.pili.droid.shortvideo.a.a.d;
import com.qiniu.pili.droid.shortvideo.encode.SWVideoEncoder;
import com.qiniu.pili.droid.shortvideo.encode.a;
import com.qiniu.pili.droid.shortvideo.encode.e;
import com.qiniu.pili.droid.shortvideo.f.b;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.gl.a.d;
import com.qiniu.pili.droid.shortvideo.gl.b.b;
import com.qiniu.pili.droid.shortvideo.gl.b.c;
import com.qiniu.pili.droid.shortvideo.gl.c.i;
import com.qiniu.pili.droid.shortvideo.gl.c.k;
import com.qiniu.pili.droid.shortvideo.gl.c.l;
import com.qiniu.pili.droid.shortvideo.gl.texread.d;
import com.qiniu.pili.droid.shortvideo.process.a.d;
import java.nio.ByteBuffer;
import java.util.List;
import org.json.JSONObject;

public class p extends j implements PLVideoFilterListener, b.a, i.a {
  private d A;
  
  private k B;
  
  private b C;
  
  private d D;
  
  private d E;
  
  private i F;
  
  private PLVideoFilterListener G;
  
  private PLFocusListener H;
  
  private PLCaptureFrameListener I;
  
  private Object J;
  
  private PLVideoEncodeSetting K;
  
  private PLFaceBeautySetting L;
  
  private PLCameraSetting M;
  
  private PLEffectPlugin N;
  
  private volatile boolean O;
  
  private volatile boolean P = true;
  
  private int Q;
  
  private float R = 1.0F;
  
  private float S = 1.0F;
  
  private final Object T = new Object();
  
  private long U;
  
  private int V = 0;
  
  private int W = 0;
  
  private volatile boolean X;
  
  private volatile boolean Y;
  
  private a.a Z = new a.a(this) {
      public void a(MediaFormat param1MediaFormat) {
        e e = e.n;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("got video format:");
        stringBuilder.append(param1MediaFormat.toString());
        e.c("ShortVideoRecorderCore", stringBuilder.toString());
        this.a.r.a(param1MediaFormat);
        p.b(this.a, true);
        this.a.r();
      }
      
      public void a(Surface param1Surface) {
        synchronized (p.b(this.a)) {
          p.a(this.a, new c(p.c(this.a), param1Surface, p.d(this.a).getVideoEncodingWidth(), p.d(this.a).getVideoEncodingHeight(), this.a.n.getDisplayMode()));
          p.a(this.a).a(p.e(this.a));
          p.a(this.a).a(p.f(this.a), p.g(this.a));
          p.a(this.a).a();
          return;
        } 
      }
      
      public void a(ByteBuffer param1ByteBuffer, MediaCodec.BufferInfo param1BufferInfo) {
        if (this.a.l) {
          e e = e.h;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("video encoded frame size:");
          stringBuilder.append(param1BufferInfo.size);
          stringBuilder.append(" ts:");
          stringBuilder.append(param1BufferInfo.presentationTimeUs);
          e.b("ShortVideoRecorderCore", stringBuilder.toString());
          this.a.r.a(param1ByteBuffer, param1BufferInfo);
        } 
      }
      
      public void a(boolean param1Boolean) {
        e e = e.h;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("video encoder started: ");
        stringBuilder.append(param1Boolean);
        e.c("ShortVideoRecorderCore", stringBuilder.toString());
        p.a(this.a, param1Boolean);
        if (!param1Boolean && this.a.s != null) {
          p p1 = this.a;
          p1.i = false;
          p1.s.onError(6);
          QosManager.a().a(6);
        } 
      }
      
      public void b(boolean param1Boolean) {
        e.h.c("ShortVideoRecorderCore", "video encoder stopped.");
        if (p.a(this.a) != null)
          p.a(this.a).b(); 
        p.a(this.a, false);
        p.b(this.a, false);
        this.a.s();
      }
    };
  
  private volatile boolean a;
  
  private volatile boolean b;
  
  private volatile boolean c;
  
  private volatile boolean d;
  
  private b e;
  
  private a f;
  
  private c z;
  
  public p() {
    e.d.c("ShortVideoRecorderCore", "init");
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
    int m = paramInt1;
    if (a()) {
      if (this.F == null) {
        this.F = new i();
        this.F.a(this.K.getVideoEncodingWidth(), this.K.getVideoEncodingHeight());
        this.F.b();
      } 
      m = this.F.a(paramInt1);
    } 
    if (this.K.isHWCodecEnabled()) {
      if (this.f.a(paramLong)) {
        long l = paramLong - this.f.b();
        this.z.a(m, paramInt2, paramInt3, l);
        e e = e.h;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("input frame texId: ");
        stringBuilder.append(m);
        stringBuilder.append(" width: ");
        stringBuilder.append(paramInt2);
        stringBuilder.append(" height: ");
        stringBuilder.append(paramInt3);
        stringBuilder.append(" timestampNs:");
        stringBuilder.append(l);
        e.b("HWVideoEncoder", stringBuilder.toString());
      } 
    } else {
      if (this.B == null) {
        this.B = new k();
        this.B.a(this.K.getVideoEncodingWidth(), this.K.getVideoEncodingHeight());
        this.B.a(paramInt2, paramInt3, this.n.getDisplayMode());
      } 
      paramInt1 = this.B.a(m);
      if (this.A == null)
        this.A = new d(this.K.getVideoEncodingWidth(), this.K.getVideoEncodingHeight()); 
      ByteBuffer byteBuffer = this.A.a(paramInt1);
      this.f.a(byteBuffer, byteBuffer.capacity(), paramLong);
    } 
    this.U = paramLong;
  }
  
  private boolean a() {
    return ((this.X && !this.Y) || (!this.X && this.Y));
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
    l l = new l();
    l.a(paramInt2, paramInt3);
    l.b();
    l.a(paramInt1);
    PLVideoFrame pLVideoFrame = new PLVideoFrame();
    pLVideoFrame.setWidth(paramInt2);
    pLVideoFrame.setHeight(paramInt3);
    pLVideoFrame.setTimestampMs(paramLong);
    pLVideoFrame.setData(l.h());
    pLVideoFrame.setDataFormat(PLVideoFrame.a.a);
    PLCaptureFrameListener pLCaptureFrameListener = this.I;
    if (pLCaptureFrameListener != null)
      pLCaptureFrameListener.onFrameCaptured(pLVideoFrame); 
    l.f();
    this.O = false;
    this.P = true;
  }
  
  public List<Float> A() {
    return this.e.h();
  }
  
  public void B() {
    if (!a(b.a.h))
      return; 
    a((PLCameraSetting.CAMERA_FACING_ID)null);
  }
  
  public void a(float paramFloat) {
    if (!a(b.a.l))
      return; 
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setZoom: ");
    stringBuilder.append(paramFloat);
    e.c("ShortVideoRecorderCore", stringBuilder.toString());
    this.e.a(paramFloat);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (this.g && !this.b && this.a) {
      this.b = true;
      q();
    } 
    this.C.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(GLSurfaceView paramGLSurfaceView, PLCameraSetting paramPLCameraSetting, PLMicrophoneSetting paramPLMicrophoneSetting, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLAudioEncodeSetting paramPLAudioEncodeSetting, PLFaceBeautySetting paramPLFaceBeautySetting, PLRecordSetting paramPLRecordSetting) {
    Context context = paramGLSurfaceView.getContext().getApplicationContext();
    this.K = paramPLVideoEncodeSetting;
    this.L = paramPLFaceBeautySetting;
    this.M = paramPLCameraSetting;
    a(context, paramPLMicrophoneSetting, paramPLAudioEncodeSetting, paramPLRecordSetting);
    this.e = new b(context, paramPLCameraSetting);
    this.C = new b(paramGLSurfaceView, paramPLFaceBeautySetting, paramPLRecordSetting.getDisplayMode());
    this.D = new d();
    this.E = new d(context);
    if (paramPLVideoEncodeSetting.isHWCodecEnabled()) {
      this.f = (a)new e(paramPLVideoEncodeSetting);
    } else {
      this.f = (a)new SWVideoEncoder(paramPLVideoEncodeSetting);
    } 
    this.f.a(this.Z);
    this.e.a(this);
    this.e.a(this.H);
    this.C.a(this);
    this.D.a(paramPLVideoEncodeSetting.getVideoEncodingFps());
  }
  
  public final void a(PLCameraParamSelectListener paramPLCameraParamSelectListener) {
    this.e.a(paramPLCameraParamSelectListener);
  }
  
  public final void a(PLCameraPreviewListener paramPLCameraPreviewListener) {
    this.e.a(paramPLCameraPreviewListener);
  }
  
  public void a(PLCameraSetting.CAMERA_FACING_ID paramCAMERA_FACING_ID) {
    e.d.c("ShortVideoRecorderCore", "switching camera +");
    k();
    this.e.a(paramCAMERA_FACING_ID);
    j();
    e.d.c("ShortVideoRecorderCore", "switching camera -");
  }
  
  public void a(PLCaptureFrameListener paramPLCaptureFrameListener, boolean paramBoolean) {
    if (!a(b.a.t))
      return; 
    e.d.c("ShortVideoRecorderCore", "captureFrame");
    this.I = paramPLCaptureFrameListener;
    this.P = paramBoolean;
    this.O = true;
  }
  
  public void a(PLEffectPlugin paramPLEffectPlugin) {
    this.N = paramPLEffectPlugin;
  }
  
  public void a(PLFaceBeautySetting paramPLFaceBeautySetting) {
    if (!a(b.a.B))
      return; 
    this.C.a(paramPLFaceBeautySetting);
  }
  
  public void a(PLFocusListener paramPLFocusListener) {
    if (!a(b.a.k))
      return; 
    this.H = paramPLFocusListener;
    b b1 = this.e;
    if (b1 != null)
      b1.a(paramPLFocusListener); 
  }
  
  public final void a(PLVideoFilterListener paramPLVideoFilterListener, boolean paramBoolean) {
    if (!a(b.a.D))
      return; 
    this.C.a(paramBoolean);
    this.G = paramPLVideoFilterListener;
  }
  
  public void a(PLWatermarkSetting paramPLWatermarkSetting) {
    if (!a(b.a.A))
      return; 
    e.d.c("ShortVideoRecorderCore", "setWatermark +");
    this.E.a(paramPLWatermarkSetting);
    e.d.c("ShortVideoRecorderCore", "setWatermark -");
  }
  
  public boolean a(GLSurfaceView paramGLSurfaceView, b paramb) {
    if (paramb == null) {
      e.d.e("ShortVideoRecorderCore", "Error on recoverFromDraft, null draft");
      return false;
    } 
    this.M = paramb.c();
    this.o = paramb.d();
    this.K = paramb.e();
    this.p = paramb.f();
    this.L = paramb.g();
    this.n = paramb.h();
    a(paramGLSurfaceView, this.M, this.o, this.K, this.p, this.L, this.n);
    this.r = g();
    this.r.a(this.n.getMaxRecordDuration());
    this.r.a(this);
    return this.r.a(paramb);
  }
  
  public boolean a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getstatic com/qiniu/pili/droid/shortvideo/core/b$a.a : Lcom/qiniu/pili/droid/shortvideo/core/b$a;
    //   6: invokevirtual a : (Lcom/qiniu/pili/droid/shortvideo/core/b$a;)Z
    //   9: istore_2
    //   10: iload_2
    //   11: ifne -> 18
    //   14: aload_0
    //   15: monitorexit
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial a : (Ljava/lang/String;)Z
    //   23: istore_2
    //   24: iload_2
    //   25: ifeq -> 47
    //   28: aload_0
    //   29: getfield f : Lcom/qiniu/pili/droid/shortvideo/encode/a;
    //   32: aload_0
    //   33: getfield t : D
    //   36: invokevirtual a : (D)V
    //   39: aload_0
    //   40: getfield f : Lcom/qiniu/pili/droid/shortvideo/encode/a;
    //   43: invokevirtual a : ()Z
    //   46: pop
    //   47: aload_0
    //   48: monitorexit
    //   49: iload_2
    //   50: ireturn
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	51	finally
    //   18	24	51	finally
    //   28	47	51	finally
  }
  
  public void b(float paramFloat1, float paramFloat2) {
    if (paramFloat1 <= 0.0F || paramFloat2 <= 0.0F) {
      e.d.e("ShortVideoRecorderCore", "setTextureScale failed, params must be greater than 0!");
      return;
    } 
    this.C.a(paramFloat1, paramFloat2);
    synchronized (this.T) {
      if (this.z != null) {
        this.z.a(paramFloat1, paramFloat2);
      } else {
        this.R = paramFloat1;
        this.S = paramFloat2;
      } 
      return;
    } 
  }
  
  public void b(int paramInt) {
    this.C.a(paramInt);
    synchronized (this.T) {
      if (this.z != null) {
        this.z.a(paramInt);
      } else {
        this.Q = paramInt;
      } 
      return;
    } 
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!a(b.a.k))
      return; 
    e.d.c("ShortVideoRecorderCore", "manualFocus");
    b b1 = this.e;
    if (b1 != null)
      b1.a(paramInt1, paramInt2, paramInt3, paramInt4); 
  }
  
  public void b(String paramString, boolean paramBoolean) {
    if (!u.a().a(b.a.E))
      return; 
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setFilter: ");
    stringBuilder.append(paramString);
    e.c("ShortVideoRecorderCore", stringBuilder.toString());
    this.E.a(paramString, paramBoolean);
  }
  
  public void b(boolean paramBoolean) {
    super.b(paramBoolean);
    this.e.b();
  }
  
  public void c(int paramInt) {
    if (!a(b.a.j))
      return; 
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setExposureCompensation: ");
    stringBuilder.append(paramInt);
    e.c("ShortVideoRecorderCore", stringBuilder.toString());
    this.e.a(paramInt);
  }
  
  public boolean c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial c : ()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq -> 39
    //   11: aload_0
    //   12: iconst_0
    //   13: putfield c : Z
    //   16: aload_0
    //   17: getfield f : Lcom/qiniu/pili/droid/shortvideo/encode/a;
    //   20: invokevirtual c : ()Z
    //   23: pop
    //   24: aload_0
    //   25: lconst_0
    //   26: putfield U : J
    //   29: aload_0
    //   30: iconst_0
    //   31: putfield V : I
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield W : I
    //   39: aload_0
    //   40: monitorexit
    //   41: iload_1
    //   42: ireturn
    //   43: astore_2
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_2
    //   47: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	43	finally
    //   11	39	43	finally
  }
  
  public boolean c(String paramString) {
    return !a(b.a.ae) ? false : this.r.a(paramString, this.M, this.o, this.K, this.p, this.L, this.n);
  }
  
  protected boolean d() {
    return (this.c && this.j);
  }
  
  public void e(boolean paramBoolean) {
    if (!a(b.a.m))
      return; 
    this.X = paramBoolean;
    b b1 = this.C;
    if (b1 != null) {
      b1.b(paramBoolean);
      e e = e.d;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setMirrorForPreview : ");
      stringBuilder.append(paramBoolean);
      e.c("ShortVideoRecorderCore", stringBuilder.toString());
      return;
    } 
    e.d.e("ShortVideoRecorderCore", "setMirrorForPreview failed : you must prepare first");
  }
  
  protected boolean e() {
    return (this.d && this.k);
  }
  
  public void f(boolean paramBoolean) {
    if (!a(b.a.m))
      return; 
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setMirrorForEncode : ");
    stringBuilder.append(paramBoolean);
    e.c("ShortVideoRecorderCore", stringBuilder.toString());
    this.Y = paramBoolean;
  }
  
  protected boolean f() {
    return (!this.d && !this.k);
  }
  
  protected i g() {
    return new i(this.m, this.n, this.p, this.K);
  }
  
  public JSONObject h() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void j() {
    super.j();
    this.C.a();
  }
  
  public void k() {
    super.k();
    this.b = false;
    this.d = false;
    c c1 = this.z;
    if (c1 != null)
      c1.c(); 
    this.C.b();
    this.e.a();
  }
  
  protected boolean l() {
    return (this.b && this.h);
  }
  
  public int onDrawFrame(int paramInt1, int paramInt2, int paramInt3, long paramLong, float[] paramArrayOffloat) {
    // Byte code:
    //   0: aload_0
    //   1: getfield O : Z
    //   4: ifeq -> 23
    //   7: aload_0
    //   8: getfield P : Z
    //   11: ifne -> 23
    //   14: aload_0
    //   15: iload_1
    //   16: iload_2
    //   17: iload_3
    //   18: lload #4
    //   20: invokespecial b : (IIIJ)V
    //   23: aload_0
    //   24: getfield N : Lcom/qiniu/pili/droid/shortvideo/PLEffectPlugin;
    //   27: astore #15
    //   29: aload #15
    //   31: ifnull -> 52
    //   34: aload #15
    //   36: iload_1
    //   37: iload_2
    //   38: iload_3
    //   39: lload #4
    //   41: aload #6
    //   43: invokeinterface onDrawFrame : (IIIJ[F)I
    //   48: istore_1
    //   49: goto -> 52
    //   52: getstatic com/qiniu/pili/droid/shortvideo/f/d.a : Ljava/lang/Object;
    //   55: astore #15
    //   57: aload #15
    //   59: monitorenter
    //   60: iload_1
    //   61: istore #7
    //   63: aload_0
    //   64: getfield G : Lcom/qiniu/pili/droid/shortvideo/PLVideoFilterListener;
    //   67: ifnull -> 100
    //   70: aload_0
    //   71: getfield G : Lcom/qiniu/pili/droid/shortvideo/PLVideoFilterListener;
    //   74: iload_1
    //   75: iload_2
    //   76: iload_3
    //   77: lload #4
    //   79: aload #6
    //   81: invokeinterface onDrawFrame : (IIIJ[F)I
    //   86: istore #8
    //   88: iload_1
    //   89: istore #7
    //   91: iload #8
    //   93: ifle -> 100
    //   96: iload #8
    //   98: istore #7
    //   100: aload_0
    //   101: getfield E : Lcom/qiniu/pili/droid/shortvideo/process/a/d;
    //   104: invokevirtual i : ()Z
    //   107: ifne -> 119
    //   110: aload_0
    //   111: getfield E : Lcom/qiniu/pili/droid/shortvideo/process/a/d;
    //   114: iload_2
    //   115: iload_3
    //   116: invokevirtual a : (II)V
    //   119: aload_0
    //   120: getfield E : Lcom/qiniu/pili/droid/shortvideo/process/a/d;
    //   123: iload #7
    //   125: invokevirtual a : (I)I
    //   128: istore_1
    //   129: invokestatic glFinish : ()V
    //   132: aload #15
    //   134: monitorexit
    //   135: aload_0
    //   136: getfield O : Z
    //   139: ifeq -> 158
    //   142: aload_0
    //   143: getfield P : Z
    //   146: ifeq -> 158
    //   149: aload_0
    //   150: iload_1
    //   151: iload_2
    //   152: iload_3
    //   153: lload #4
    //   155: invokespecial b : (IIIJ)V
    //   158: aload_0
    //   159: getfield c : Z
    //   162: ifeq -> 823
    //   165: aload_0
    //   166: getfield j : Z
    //   169: ifeq -> 823
    //   172: aload_0
    //   173: getfield D : Lcom/qiniu/pili/droid/shortvideo/a/a/d;
    //   176: invokevirtual a : ()Z
    //   179: ifne -> 823
    //   182: lload #4
    //   184: l2d
    //   185: aload_0
    //   186: getfield t : D
    //   189: ddiv
    //   190: d2l
    //   191: lstore #11
    //   193: getstatic com/qiniu/pili/droid/shortvideo/f/e.d : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   196: astore #6
    //   198: new java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial <init> : ()V
    //   205: astore #15
    //   207: aload #15
    //   209: ldc_w 'video frame captured texId:'
    //   212: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload #15
    //   218: iload_1
    //   219: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload #15
    //   225: ldc_w ' width:'
    //   228: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload #15
    //   234: iload_2
    //   235: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload #15
    //   241: ldc_w ' height:'
    //   244: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload #15
    //   250: iload_3
    //   251: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload #15
    //   257: ldc_w ' ts:'
    //   260: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload #15
    //   266: lload #11
    //   268: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload #6
    //   274: ldc 'ShortVideoRecorderCore'
    //   276: aload #15
    //   278: invokevirtual toString : ()Ljava/lang/String;
    //   281: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   284: aload_0
    //   285: getfield K : Lcom/qiniu/pili/droid/shortvideo/PLVideoEncodeSetting;
    //   288: invokevirtual IsConstFrameRateEnabled : ()Z
    //   291: ifeq -> 723
    //   294: aload_0
    //   295: getfield K : Lcom/qiniu/pili/droid/shortvideo/PLVideoEncodeSetting;
    //   298: invokevirtual getVideoEncodingFps : ()I
    //   301: istore #7
    //   303: lload #11
    //   305: aload_0
    //   306: getfield U : J
    //   309: lsub
    //   310: ldc2_w 1000000
    //   313: ldiv
    //   314: lstore #4
    //   316: aload_0
    //   317: getfield t : D
    //   320: dconst_1
    //   321: dcmpl
    //   322: ifle -> 453
    //   325: lload #4
    //   327: l2f
    //   328: ldc_w 1000.0
    //   331: iload #7
    //   333: i2f
    //   334: ldc_w 1.3
    //   337: fmul
    //   338: fdiv
    //   339: fcmpg
    //   340: ifge -> 713
    //   343: getstatic com/qiniu/pili/droid/shortvideo/f/e.d : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   346: astore #6
    //   348: new java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial <init> : ()V
    //   355: astore #15
    //   357: aload #15
    //   359: ldc_w 'Abandoned frame for timestamp:'
    //   362: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload #15
    //   368: lload #11
    //   370: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload #15
    //   376: ldc_w ', LastTimeStamp: '
    //   379: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload #15
    //   385: aload_0
    //   386: getfield U : J
    //   389: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload #15
    //   395: ldc_w '; delta'
    //   398: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload #15
    //   404: lload #4
    //   406: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload #15
    //   412: ldc_w '; count:'
    //   415: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload #15
    //   421: aload_0
    //   422: getfield V : I
    //   425: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload #6
    //   431: ldc 'ShortVideoRecorderCore'
    //   433: aload #15
    //   435: invokevirtual toString : ()Ljava/lang/String;
    //   438: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   441: aload_0
    //   442: aload_0
    //   443: getfield V : I
    //   446: iconst_1
    //   447: iadd
    //   448: putfield V : I
    //   451: iload_1
    //   452: ireturn
    //   453: aload_0
    //   454: getfield t : D
    //   457: dconst_1
    //   458: dcmpg
    //   459: ifge -> 713
    //   462: aload_0
    //   463: getfield W : I
    //   466: ifeq -> 713
    //   469: getstatic com/qiniu/pili/droid/shortvideo/f/e.d : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   472: astore #6
    //   474: new java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial <init> : ()V
    //   481: astore #15
    //   483: aload #15
    //   485: ldc_w 'Init Delta value:'
    //   488: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload #15
    //   494: lload #4
    //   496: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload #6
    //   502: ldc 'ShortVideoRecorderCore'
    //   504: aload #15
    //   506: invokevirtual toString : ()Ljava/lang/String;
    //   509: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   512: lload #4
    //   514: l2f
    //   515: ldc_w 1000.0
    //   518: iload #7
    //   520: i2f
    //   521: ldc_w 0.7
    //   524: fmul
    //   525: fdiv
    //   526: fcmpl
    //   527: ifle -> 541
    //   530: lload #4
    //   532: ldc2_w 2
    //   535: ldiv
    //   536: lstore #4
    //   538: goto -> 512
    //   541: aload_0
    //   542: getfield U : J
    //   545: lstore #9
    //   547: lload #4
    //   549: ldc2_w 1000000
    //   552: lmul
    //   553: lstore #13
    //   555: lload #9
    //   557: lload #13
    //   559: ladd
    //   560: lstore #9
    //   562: getstatic com/qiniu/pili/droid/shortvideo/f/e.d : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   565: astore #6
    //   567: new java/lang/StringBuilder
    //   570: dup
    //   571: invokespecial <init> : ()V
    //   574: astore #15
    //   576: aload #15
    //   578: ldc_w 'Final Delta value:'
    //   581: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: pop
    //   585: aload #15
    //   587: lload #4
    //   589: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: aload #15
    //   595: ldc_w '; Target timestamp:'
    //   598: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: aload #15
    //   604: lload #9
    //   606: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   609: pop
    //   610: aload #15
    //   612: ldc_w '; End:'
    //   615: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: pop
    //   619: aload #15
    //   621: lload #11
    //   623: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   626: pop
    //   627: aload #6
    //   629: ldc 'ShortVideoRecorderCore'
    //   631: aload #15
    //   633: invokevirtual toString : ()Ljava/lang/String;
    //   636: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   639: lload #9
    //   641: lstore #4
    //   643: lload #4
    //   645: lload #11
    //   647: lcmp
    //   648: ifge -> 713
    //   651: lload #4
    //   653: lload #13
    //   655: ladd
    //   656: lstore #4
    //   658: getstatic com/qiniu/pili/droid/shortvideo/f/e.d : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   661: astore #6
    //   663: new java/lang/StringBuilder
    //   666: dup
    //   667: invokespecial <init> : ()V
    //   670: astore #15
    //   672: aload #15
    //   674: ldc_w 'Inserted frame timestamp: '
    //   677: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: pop
    //   681: aload #15
    //   683: lload #4
    //   685: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   688: pop
    //   689: aload #6
    //   691: ldc 'ShortVideoRecorderCore'
    //   693: aload #15
    //   695: invokevirtual toString : ()Ljava/lang/String;
    //   698: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   701: aload_0
    //   702: iload_1
    //   703: iload_2
    //   704: iload_3
    //   705: lload #4
    //   707: invokespecial a : (IIIJ)V
    //   710: goto -> 643
    //   713: aload_0
    //   714: aload_0
    //   715: getfield W : I
    //   718: iconst_1
    //   719: iadd
    //   720: putfield W : I
    //   723: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   726: astore #6
    //   728: new java/lang/StringBuilder
    //   731: dup
    //   732: invokespecial <init> : ()V
    //   735: astore #15
    //   737: aload #15
    //   739: ldc_w 'video frame captured texId:'
    //   742: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: pop
    //   746: aload #15
    //   748: iload_1
    //   749: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   752: pop
    //   753: aload #15
    //   755: ldc_w ' width:'
    //   758: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: pop
    //   762: aload #15
    //   764: iload_2
    //   765: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   768: pop
    //   769: aload #15
    //   771: ldc_w ' height:'
    //   774: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: pop
    //   778: aload #15
    //   780: iload_3
    //   781: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   784: pop
    //   785: aload #15
    //   787: ldc_w ' ts:'
    //   790: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: pop
    //   794: aload #15
    //   796: lload #11
    //   798: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   801: pop
    //   802: aload #6
    //   804: ldc 'ShortVideoRecorderCore'
    //   806: aload #15
    //   808: invokevirtual toString : ()Ljava/lang/String;
    //   811: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   814: aload_0
    //   815: iload_1
    //   816: iload_2
    //   817: iload_3
    //   818: lload #11
    //   820: invokespecial a : (IIIJ)V
    //   823: iload_1
    //   824: ireturn
    //   825: astore #6
    //   827: aload #15
    //   829: monitorexit
    //   830: aload #6
    //   832: athrow
    // Exception table:
    //   from	to	target	type
    //   63	88	825	finally
    //   100	119	825	finally
    //   119	135	825	finally
    //   827	830	825	finally
  }
  
  public void onSurfaceChanged(int paramInt1, int paramInt2) {
    this.e.a(paramInt1, paramInt2);
    PLEffectPlugin pLEffectPlugin = this.N;
    if (pLEffectPlugin != null)
      pLEffectPlugin.onSurfaceChanged(paramInt1, paramInt2); 
    PLVideoFilterListener pLVideoFilterListener = this.G;
    if (pLVideoFilterListener != null)
      pLVideoFilterListener.onSurfaceChanged(paramInt1, paramInt2); 
  }
  
  public void onSurfaceCreated() {
    if (this.e.a(this.C.c())) {
      this.J = d.b();
    } else if (this.s != null) {
      this.s.onError(4);
      QosManager.a().a(4);
    } 
    PLEffectPlugin pLEffectPlugin = this.N;
    if (pLEffectPlugin != null)
      pLEffectPlugin.onSurfaceCreated(); 
    PLVideoFilterListener pLVideoFilterListener = this.G;
    if (pLVideoFilterListener != null)
      pLVideoFilterListener.onSurfaceCreated(); 
    this.a = true;
  }
  
  public void onSurfaceDestroy() {
    this.E.j();
    PLEffectPlugin pLEffectPlugin = this.N;
    if (pLEffectPlugin != null)
      pLEffectPlugin.onSurfaceDestroy(); 
    PLVideoFilterListener pLVideoFilterListener = this.G;
    if (pLVideoFilterListener != null)
      pLVideoFilterListener.onSurfaceDestroy(); 
    this.a = false;
    d d1 = this.A;
    if (d1 != null) {
      d1.a();
      this.A = null;
    } 
    k k1 = this.B;
    if (k1 != null) {
      k1.f();
      this.B = null;
    } 
    i i1 = this.F;
    if (i1 != null) {
      i1.f();
      this.F = null;
    } 
  }
  
  public PLBuiltinFilter[] u() {
    return this.E.a();
  }
  
  public boolean v() {
    if (!a(b.a.i))
      return false; 
    e.d.c("ShortVideoRecorderCore", "turnLightOn");
    return this.e.c();
  }
  
  public boolean w() {
    if (!a(b.a.i))
      return false; 
    e.d.c("ShortVideoRecorderCore", "turnLightOff");
    return this.e.d();
  }
  
  public boolean x() {
    return this.e.e();
  }
  
  public int y() {
    return this.e.f();
  }
  
  public int z() {
    return this.e.g();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\core\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */