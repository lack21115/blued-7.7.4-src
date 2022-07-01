package com.qiniu.pili.droid.streaming;

import a.a.a.a.a.a.b;
import a.a.a.a.a.a.c;
import a.a.a.a.a.a.e.c;
import a.a.a.a.a.a.e.d;
import a.a.a.a.a.a.e.e.b;
import a.a.a.a.a.a.h.f;
import a.a.a.a.a.a.i.b;
import a.a.a.a.a.a.i.c;
import a.a.a.a.a.a.i.d;
import a.a.a.a.a.a.j.b;
import a.a.a.a.a.a.j.d;
import a.a.a.a.a.a.j.f;
import a.a.a.a.a.a.j.g;
import a.a.a.a.a.a.j.h.c;
import a.a.a.a.a.b.b;
import a.a.a.a.a.b.c;
import a.a.a.a.a.b.d;
import a.a.a.a.a.d.b;
import a.a.a.a.a.e.d;
import a.a.a.a.a.e.e;
import a.a.a.a.a.e.h;
import a.a.a.a.a.f.b;
import a.a.a.a.a.f.e;
import a.a.a.a.a.g.b;
import a.a.a.a.a.i.a;
import a.a.a.a.a.k.b;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.opengl.GLSurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.qiniu.pili.droid.streaming.av.common.PLFourCC;
import com.qiniu.pili.droid.streaming.microphone.AudioMixer;
import com.qiniu.pili.droid.streaming.widget.AspectFrameLayout;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.List;

public final class MediaStreamingManager implements b.b, c, c.j, b.a, a.a {
  public volatile boolean A = false;
  
  public WeakReference<GLSurfaceView> B;
  
  public f.a C;
  
  public boolean D = false;
  
  public volatile boolean E;
  
  public SurfaceTextureCallback2 F;
  
  public volatile long G;
  
  public volatile boolean a;
  
  public c b;
  
  public a.a.a.a.a.a.e.a c;
  
  public b d;
  
  public CameraStreamingSetting e;
  
  public MicrophoneStreamingSetting f;
  
  public StreamingProfile g;
  
  public c h;
  
  public f i;
  
  public c j;
  
  public b k;
  
  public AVCodecType l;
  
  public a m;
  
  public a.a.a.a.a.a.j.h.a n;
  
  public AudioMixer o;
  
  public Context p;
  
  public StreamingStateChangedListener q;
  
  public StreamingSessionListener r;
  
  public StreamingPreviewCallback s;
  
  public StreamStatusCallback t;
  
  public AudioSourceCallback u;
  
  public a.a.a.a.a.h.a v;
  
  public d w;
  
  public boolean x = false;
  
  public boolean y = false;
  
  public boolean z = false;
  
  public MediaStreamingManager(Context paramContext) {
    e.d.c("MediaStreamingManager", "created, AVCodecType = HW_AUDIO_CODEC");
    a(paramContext);
  }
  
  public MediaStreamingManager(Context paramContext, GLSurfaceView paramGLSurfaceView) {
    this(paramContext, (AspectFrameLayout)null, paramGLSurfaceView);
  }
  
  public MediaStreamingManager(Context paramContext, GLSurfaceView paramGLSurfaceView, AVCodecType paramAVCodecType) {
    this(paramContext, null, paramGLSurfaceView, paramAVCodecType);
  }
  
  public MediaStreamingManager(Context paramContext, AVCodecType paramAVCodecType) {
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("created, AVCodecType = ");
    stringBuilder.append(paramAVCodecType);
    e.c("MediaStreamingManager", stringBuilder.toString());
    a(paramContext);
    this.l = paramAVCodecType;
    b.a(paramAVCodecType);
    if (q())
      return; 
    throw new IllegalStateException("Wrong Encoding Type. Ony SW_AUDIO_CODEC and SW_AUDIO_CODEC are accept in this ctor");
  }
  
  public MediaStreamingManager(Context paramContext, AspectFrameLayout paramAspectFrameLayout, GLSurfaceView paramGLSurfaceView) {
    this(paramContext, paramAspectFrameLayout, paramGLSurfaceView, AVCodecType.HW_VIDEO_WITH_HW_AUDIO_CODEC);
  }
  
  public MediaStreamingManager(Context paramContext, AspectFrameLayout paramAspectFrameLayout, GLSurfaceView paramGLSurfaceView, AVCodecType paramAVCodecType) {
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("created, AVCodecType = ");
    stringBuilder.append(paramAVCodecType);
    e.c("MediaStreamingManager", stringBuilder.toString());
    a(paramContext);
    if (paramGLSurfaceView != null) {
      this.B = new WeakReference<GLSurfaceView>(paramGLSurfaceView);
      this.j = new c(paramContext, paramAspectFrameLayout, paramGLSurfaceView, this);
      this.l = paramAVCodecType;
      b.a(paramAVCodecType);
      return;
    } 
    throw new IllegalStateException("Error, Illegal AspectFrameLayout Or GLSurfaceView! Cannot be null!");
  }
  
  public static boolean isSupportPreviewAppearance() {
    return f.a();
  }
  
  public final boolean A() {
    return this.e.f();
  }
  
  public final void B() {
    e e = e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("pauseStreaming thread:");
    stringBuilder.append(Thread.currentThread().getId());
    e.c("MediaStreamingManager", stringBuilder.toString());
    c c2 = this.j;
    if (c2 != null)
      c2.b(true); 
    c c1 = this.b;
    if (c1 != null)
      c1.a(true); 
    f f1 = this.i;
    if (f1 != null)
      f1.b(false); 
  }
  
  public final void C() {
    e.f.c("MediaStreamingManager", "resumeStreaming");
    if (this.i != null)
      D(); 
    c c1 = this.j;
    if (c1 != null)
      c1.b(false); 
    this.b.a(false);
  }
  
  public final void D() {
    this.i.a(this.C);
    this.i.a(this.w.a());
    this.i.a(this.s);
  }
  
  public final void E() {
    c c1 = this.b;
    if (c1 != null) {
      if (c1.e() == null)
        return; 
      if (!b.a())
        b.a(this.p); 
      (this.b.e()).v = 0L;
      (this.b.e()).w = 0L;
      (this.b.e()).t = 0L;
      (this.b.e()).u = 0L;
      (this.b.e()).y = 0L;
      (this.b.e()).x = 0L;
      Intent intent = new Intent("pldroid-qos-filter");
      intent.putExtra("pldroid-qos-msg-type", 163);
      intent.putExtra("videoEncoderType", this.d.m());
      intent.putExtra("audioEncoderType", this.d.n());
      boolean bool = (this.b.e()).b;
      byte b1 = 0;
      if (bool) {
        i = this.d.r();
      } else {
        i = 0;
      } 
      intent.putExtra("videoFps", i);
      int i = b1;
      if ((this.b.e()).a)
        i = this.d.j().b() / 1000; 
      intent.putExtra("audioFps", i);
      intent.putExtra("gopTime", this.b.n());
      a.a.a.a.a.j.a.a().a(intent);
    } 
  }
  
  public final boolean F() {
    if (this.z) {
      this.z = false;
      if (O())
        return true; 
    } else if (this.D) {
      this.D = false;
      if (N())
        return true; 
    } 
    return false;
  }
  
  public final void G() {
    b b1 = this.k;
    if (b1 != null)
      b1.a(this.p); 
    c c1 = this.h;
    if (c1 != null)
      c1.a(this.b); 
  }
  
  public final void H() {
    e.d.c("MediaStreamingManager", "startPictureStreaming +");
    this.n.a(this.g.getPictureStreamingFps());
    this.n.e();
    e.d.c("MediaStreamingManager", "startPictureStreaming -");
  }
  
  public final boolean I() {
    StreamingProfile streamingProfile = this.g;
    if (streamingProfile != null) {
      CameraStreamingSetting cameraStreamingSetting = this.e;
      if (cameraStreamingSetting != null) {
        StreamingProfile.VideoEncodingSize videoEncodingSize = streamingProfile.getVideoEncodingSize(cameraStreamingSetting.getPrvSizeRatio());
        if (this.e.getCameraPreviewWidth() < videoEncodingSize.width && this.e.getCameraPreviewHeight() < videoEncodingSize.height) {
          e e1 = e.f;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Warning: camera preview resolution ");
          stringBuilder1.append(this.e.getCameraPreviewWidth());
          stringBuilder1.append(" x ");
          stringBuilder1.append(this.e.getCameraPreviewHeight());
          stringBuilder1.append(" < publish streaming size ");
          stringBuilder1.append(videoEncodingSize.width);
          stringBuilder1.append(" x ");
          stringBuilder1.append(videoEncodingSize.height);
          e1.d("MediaStreamingManager", stringBuilder1.toString());
        } 
      } 
    } 
    boolean bool = this.b.a(this.d);
    e e = e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("isOK:");
    stringBuilder.append(bool);
    e.c("MediaStreamingManager", stringBuilder.toString());
    if (bool) {
      StreamStatusCallback streamStatusCallback = this.t;
      if (streamStatusCallback != null)
        this.b.a(streamStatusCallback); 
      this.a = true;
      if (q()) {
        G();
        E();
        return true;
      } 
      if (A()) {
        c c1 = this.h;
        if (c1 != null)
          c1.a(this.b); 
      } 
      J();
      E();
      return true;
    } 
    return false;
  }
  
  public final void J() {
    if (q())
      return; 
    this.E = false;
    h();
    if (this.i != null)
      D(); 
    a a1 = this.m;
    if (a1 != null)
      a1.a(); 
    if (this.j.b()) {
      this.j.a(true);
    } else if (this.A && this.n != null) {
      H();
      G();
    } 
    this.A = false;
  }
  
  public final void K() {
    stopPlayback();
    if (this.k != null && !this.f.c())
      this.k.b(this.p); 
    c c1 = this.h;
    if (c1 != null)
      c1.a(); 
  }
  
  public final void L() {
    K();
    M();
    c c1 = this.b;
    if (c1 != null) {
      c1.a();
      this.b.a(false);
    } 
  }
  
  public final void M() {
    if (q())
      return; 
    this.j.a(false);
    if (isPictureStreaming())
      a(false); 
    a a1 = this.m;
    if (a1 != null)
      a1.b(); 
    f f1 = this.i;
    if (f1 != null)
      f1.b(true); 
  }
  
  public final boolean N() {
    this.h = null;
    StreamingSessionListener streamingSessionListener = this.r;
    if (streamingSessionListener != null && streamingSessionListener.onRecordAudioFailedHandled(0)) {
      e.f.c("MediaStreamingManager", "RecordAudioFailedHandled");
      return true;
    } 
    if (this.h == null)
      m(); 
    return false;
  }
  
  public final boolean O() {
    StreamingSessionListener streamingSessionListener = this.r;
    if (streamingSessionListener != null && streamingSessionListener.onRestartStreamingHandled(0)) {
      e.f.c("MediaStreamingManager", "RestartStreamingHandled");
      return true;
    } 
    return false;
  }
  
  public final void P() {
    e.f.c("MediaStreamingManager", "tryResumeStreaming");
    if (!this.a) {
      e.f.d("MediaStreamingManager", "not recording, no need try resuming stream.");
      return;
    } 
    if (!this.j.b())
      e.f.d("MediaStreamingManager", "preview is not ready yet."); 
    C();
  }
  
  public void a() {
    e.f.c("MediaStreamingManager", "onEncoderExitDone");
    this.E = false;
  }
  
  public void a(int paramInt) {
    e e = e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("openCameraDeviceFailed ");
    stringBuilder.append(paramInt);
    e.c("MediaStreamingManager", stringBuilder.toString());
    StreamingStateChangedListener streamingStateChangedListener = this.q;
    if (streamingStateChangedListener != null)
      streamingStateChangedListener.onStateChanged(StreamingState.OPEN_CAMERA_FAIL, Integer.valueOf(paramInt)); 
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4) {
    f.a a1;
    int i = (b.a().b()).facing;
    e e = e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("buildTransferSessionConfig width:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(",height:");
    stringBuilder.append(paramInt2);
    stringBuilder.append(",rotation:");
    stringBuilder.append(paramInt3);
    stringBuilder.append(",mirror:");
    stringBuilder.append(paramBoolean);
    stringBuilder.append(",fmt:");
    stringBuilder.append(paramInt4);
    e.c("MediaStreamingManager", stringBuilder.toString());
    if (v()) {
      c c1 = this.b;
      if (this.j.b()) {
        Object object = (this.j.j()).c;
      } else {
        e = null;
      } 
      a1 = new f.a(c1, paramInt1, paramInt2, i, paramBoolean, paramInt3, paramInt4, e, this.j.i(), this.d.k());
      a1.a(this.j.a());
    } else {
      a1 = new f.a(this.b, paramInt1, paramInt2, i, paramBoolean, paramInt3, paramInt4, this.j.i(), this.d.k());
    } 
    a1.n = this.g.getYuvFilterMode().ordinal();
    this.C = a1;
    a.a.a.a.a.a.j.h.a a2 = this.n;
    if (a2 != null && a2 instanceof c)
      ((c)a2).a(a1); 
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean) {
    if (this.i != null) {
      if (!this.d.k())
        this.b.c(true); 
      if ((z() || v()) && !this.e.f()) {
        this.i.a(paramInt, paramLong, paramBoolean);
        this.G = paramLong;
      } 
    } 
  }
  
  public void a(b.c paramc, Object paramObject) {
    StreamingState streamingState1;
    StreamingState streamingState2 = StreamingState.UNKNOWN;
    e e = e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onStateChanged:");
    stringBuilder.append(paramc);
    stringBuilder.append(",mNeedUpdateProfile:");
    stringBuilder.append(this.y);
    e.c("MediaStreamingManager", stringBuilder.toString());
    switch (a.a[paramc.ordinal()]) {
      default:
        streamingState1 = streamingState2;
        break;
      case 15:
        streamingState1 = StreamingState.INVALID_STREAMING_URL;
        break;
      case 14:
        this.z = true;
        stopStreaming();
        streamingState1 = StreamingState.UNAUTHORIZED_STREAMING_URL;
        break;
      case 13:
        stopStreaming();
        streamingState1 = StreamingState.AUDIO_RECORDING_FAIL;
        this.D = true;
        break;
      case 12:
        this.z = true;
        this.A = isPictureStreaming();
        stopStreaming();
        streamingState1 = StreamingState.DISCONNECTED;
        break;
      case 11:
        g();
        return;
      case 10:
        a(StreamingState.SENDING_BUFFER_HAS_MANY_ITEMS);
        return;
      case 9:
        a(StreamingState.SENDING_BUFFER_HAS_FEW_ITEMS);
        return;
      case 8:
        streamingState1 = StreamingState.SENDING_BUFFER_FULL;
        try {
          this.g.getVideoQualityRank().clear();
          e.f.c("MediaStreamingManager", "signal many items after rank clear!");
          a(StreamingState.SENDING_BUFFER_HAS_MANY_ITEMS);
          return;
        } catch (NullPointerException nullPointerException) {
          e = e.f;
          stringBuilder = new StringBuilder();
          stringBuilder.append("Fail:");
          stringBuilder.append(nullPointerException.getMessage());
          e.d("MediaStreamingManager", stringBuilder.toString());
          break;
        } 
      case 7:
        streamingState1 = StreamingState.SENDING_BUFFER_EMPTY;
        break;
      case 6:
        streamingState1 = StreamingState.IOERROR;
        this.z = true;
        break;
      case 5:
        streamingState1 = StreamingState.SHUTDOWN;
        try {
          this.g.getVideoQualityRank().clear();
        } catch (NullPointerException nullPointerException) {
          e = e.f;
          stringBuilder = new StringBuilder();
          stringBuilder.append("Fail:");
          stringBuilder.append(nullPointerException.getMessage());
          e.d("MediaStreamingManager", stringBuilder.toString());
        } 
        this.y = false;
        if (F())
          return; 
        e.a().b(false);
        break;
      case 4:
        e.a().b(true);
        streamingState1 = StreamingState.STREAMING;
        break;
      case 3:
        streamingState1 = StreamingState.CONNECTING;
        break;
      case 2:
        this.z = false;
        streamingState1 = StreamingState.PREPARING;
        break;
      case 1:
        streamingState1 = StreamingState.READY;
        return;
    } 
    StreamingStateChangedListener streamingStateChangedListener = this.q;
    if (streamingStateChangedListener != null && !this.y)
      streamingStateChangedListener.onStateChanged(streamingState1, paramObject); 
  }
  
  public final void a(Context paramContext) {
    e.e.c("MediaStreamingManager", h.h(paramContext));
    StreamingEnv.a();
    this.p = paramContext.getApplicationContext();
    this.j = null;
    this.l = AVCodecType.HW_AUDIO_CODEC;
    b.a();
  }
  
  public void a(Camera.Size paramSize) {
    e.f.c("MediaStreamingManager", "notifyPrvSizeChanged");
    b b1 = this.d;
    if (b1 != null) {
      if (paramSize != null) {
        b1.a(new StreamingProfile.VideoEncodingSize(-1, paramSize.width, paramSize.height));
        return;
      } 
      b1.a(this.e.getPrvSizeRatio());
      this.d.a(null);
      return;
    } 
    e.f.e("MediaStreamingManager", "mEncodingConfig is null");
  }
  
  public final void a(StreamingState paramStreamingState) {
    if (this.z) {
      e.f.e("MediaStreamingManager", "had been disconnected!");
      return;
    } 
    StreamingStateChangedListener streamingStateChangedListener = this.q;
    if (streamingStateChangedListener != null)
      streamingStateChangedListener.onStateChanged(paramStreamingState, null); 
  }
  
  public final void a(WatermarkSetting paramWatermarkSetting, PreviewAppearance paramPreviewAppearance) {
    if (this.j != null) {
      boolean bool;
      boolean bool1 = v();
      e e = e.a();
      if (paramPreviewAppearance != null) {
        bool = true;
      } else {
        bool = false;
      } 
      e.c(bool).d(this.e.e()).a(this.l).a(this.e.f());
      this.m = new a(this.p, this.e, bool1, this);
      this.j.a(this.e, paramWatermarkSetting, paramPreviewAppearance, bool1, this.s);
      this.j.a((SurfaceTextureCallback)this.m);
      p();
    } 
  }
  
  public void a(ByteBuffer paramByteBuffer, int paramInt, long paramLong, boolean paramBoolean) {
    if (this.b != null && this.a)
      this.b.c(false); 
    AudioMixer audioMixer = this.o;
    if (audioMixer != null && audioMixer.isRunning())
      this.o.a(paramByteBuffer, paramByteBuffer, paramInt); 
    AudioSourceCallback audioSourceCallback = this.u;
    if (audioSourceCallback != null)
      audioSourceCallback.onAudioSourceAvailable(paramByteBuffer, paramInt, paramLong * 1000L, paramBoolean); 
    if (this.v != null && this.a)
      this.v.a(paramByteBuffer.array(), paramByteBuffer.arrayOffset(), paramInt); 
    if (!this.f.c() && this.h != null && r())
      this.h.a(paramByteBuffer, paramInt, paramLong, paramBoolean); 
  }
  
  public final void a(boolean paramBoolean) {
    e.d.c("MediaStreamingManager", "stopPictureStreaming +");
    this.n.b(paramBoolean);
    e.d.c("MediaStreamingManager", "stopPictureStreaming -");
  }
  
  public void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean) {
    StreamingPreviewCallback streamingPreviewCallback = this.s;
    if (streamingPreviewCallback != null)
      streamingPreviewCallback.onPreviewFrame(paramArrayOfbyte, paramInt1, paramInt2, paramInt3, paramInt4, paramLong); 
    if (this.i != null) {
      if (paramBoolean)
        this.b.c(true); 
      if (paramBoolean && !this.e.f()) {
        this.i.a(paramArrayOfbyte, paramLong);
        this.G = paramLong;
      } 
    } 
  }
  
  public void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, long paramLong, boolean paramBoolean) {
    StreamingPreviewCallback streamingPreviewCallback = this.s;
    if (streamingPreviewCallback != null)
      streamingPreviewCallback.onPreviewFrame(paramArrayOfbyte, paramInt1, paramInt2, this.j.h(), paramInt3, paramLong); 
    if (paramBoolean)
      this.b.c(true); 
    if (paramBoolean && !this.e.f()) {
      this.i.a(paramArrayOfbyte, paramLong);
      this.G = paramLong;
    } 
  }
  
  public void addOverlay(View paramView) {
    addOverlay(paramView, null);
  }
  
  public void addOverlay(View paramView, ViewGroup paramViewGroup) {
    if (paramView == null) {
      e.g.d("MediaStreamingManager", "view is null, cannot add");
      return;
    } 
    f f1 = this.i;
    if (f1 != null && f1 instanceof d)
      ((d)f1).a(paramView, paramViewGroup); 
  }
  
  public boolean adjustVideoBitrate(int paramInt) {
    if (!u()) {
      e.d.e("MediaStreamingManager", "Dynamic bitrate is not supported!");
      return false;
    } 
    if (this.i != null) {
      StreamingProfile streamingProfile = this.g;
      if (streamingProfile != null && streamingProfile.getVideoProfile() != null) {
        if (!this.g.b(paramInt)) {
          e.d.e("MediaStreamingManager", "invalid bitrate!");
          return false;
        } 
        if (this.g.a()) {
          e.d.e("MediaStreamingManager", "adaptive bitrate is enabled, please disable!");
          return false;
        } 
        if (!this.g.b()) {
          e.d.e("MediaStreamingManager", "adjust bitrate is not enabled, pls call setAdjustBitrateEnable first ");
          return false;
        } 
        this.i.a(paramInt);
        return true;
      } 
    } 
    e.d.e("MediaStreamingManager", "No start streaming!");
    return false;
  }
  
  public void b() {
    e.f.c("MediaStreamingManager", "doPauseStreaming");
    B();
  }
  
  public void b(int paramInt) {
    c c1 = this.b;
    if (c1 != null) {
      c1.c(0);
      a(b.c.n, (Object)null);
    } 
  }
  
  public final boolean b(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4) {
    if (paramInt3 % 90 == 0) {
      if (c(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4)) {
        B();
        a(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4);
        C();
        return false;
      } 
      return this.i.f();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Fatal Error. rotation is illegal:");
    stringBuilder.append(paramInt3);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void c() {
    e.f.c("MediaStreamingManager", "doResumeStreaming");
    if (!this.a) {
      StreamingStateChangedListener streamingStateChangedListener = this.q;
      if (streamingStateChangedListener != null) {
        streamingStateChangedListener.onStateChanged(StreamingState.READY, Integer.valueOf(this.e.getReqCameraId()));
        return;
      } 
    } else {
      h();
      P();
    } 
  }
  
  public void c(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   5: astore_2
    //   6: new java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc_w 'notifyFirstAudioFrame: '
    //   18: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_3
    //   23: iload_1
    //   24: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: ldc 'MediaStreamingManager'
    //   31: aload_3
    //   32: invokevirtual toString : ()Ljava/lang/String;
    //   35: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_0
    //   39: getfield x : Z
    //   42: ifeq -> 77
    //   45: aload_0
    //   46: getfield j : La/a/a/a/a/b/c;
    //   49: astore_2
    //   50: aload_2
    //   51: ifnull -> 61
    //   54: aload_2
    //   55: iload_1
    //   56: iconst_1
    //   57: ixor
    //   58: invokevirtual c : (Z)V
    //   61: aload_0
    //   62: getfield m : La/a/a/a/a/i/a;
    //   65: astore_2
    //   66: aload_2
    //   67: ifnull -> 77
    //   70: aload_2
    //   71: iload_1
    //   72: iconst_1
    //   73: ixor
    //   74: invokevirtual a : (Z)V
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: astore_2
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_2
    //   84: athrow
    // Exception table:
    //   from	to	target	type
    //   2	50	80	finally
    //   54	61	80	finally
    //   61	66	80	finally
    //   70	77	80	finally
  }
  
  public final boolean c(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4) {
    f.a a1 = this.C;
    return (a1 == null || a1.b * a1.c != paramInt1 * paramInt2 || a1.e != paramInt3 || a1.f != paramInt4);
  }
  
  public void captureFrame(int paramInt1, int paramInt2, FrameCapturedCallback paramFrameCapturedCallback) {
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("captureFrame ");
    stringBuilder.append(paramInt1);
    stringBuilder.append("x");
    stringBuilder.append(paramInt2);
    e.c("MediaStreamingManager", stringBuilder.toString());
    if (paramFrameCapturedCallback != null) {
      c c1 = this.j;
      if (c1 != null && c1.b()) {
        this.j.a(this.d.k(), paramInt1, paramInt2, paramFrameCapturedCallback);
      } else {
        String str;
        if (this.j == null) {
          str = "camera manager is null";
        } else {
          str = "camera is not ready";
        } 
        e e1 = e.d;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("ERROR. capture failed since:");
        stringBuilder1.append(str);
        e1.e("MediaStreamingManager", stringBuilder1.toString());
        paramFrameCapturedCallback.onFrameCaptured(null);
      } 
      b.m();
      return;
    } 
    throw new IllegalArgumentException("callback is null");
  }
  
  public void d() {
    e.f.c("MediaStreamingManager", "onEncoderInitDone");
    this.E = true;
  }
  
  public void destroy() {
    e.d.c("MediaStreamingManager", "destroy +");
    c c1 = this.j;
    if (c1 != null)
      c1.l(); 
    a a1 = this.m;
    if (a1 != null)
      a1.d(); 
    AudioMixer audioMixer = this.o;
    if (audioMixer != null)
      audioMixer.a(); 
    this.p = null;
    this.n = null;
    b.f();
    e.d.c("MediaStreamingManager", "destroy -");
  }
  
  public void doSingleTapUp(int paramInt1, int paramInt2) {
    if (this.j != null) {
      e e = e.d;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onSingleTapUp x:");
      stringBuilder.append(paramInt1);
      stringBuilder.append(",y:");
      stringBuilder.append(paramInt2);
      e.c("MediaStreamingManager", stringBuilder.toString());
      this.j.a(paramInt1, paramInt2);
    } 
  }
  
  public void e() {
    e.f.c("MediaStreamingManager", "notifyFirstEncodingFrame");
    if (x() || this.e.f()) {
      String str;
      c c1 = this.j;
      if (c1 != null)
        c1.c(true); 
      a a1 = this.m;
      if (a1 != null)
        a1.a(true); 
      e e = e.f;
      if (x()) {
        str = "pure video streaming";
      } else {
        str = "capture camera frame only";
      } 
      e.c("MediaStreamingManager", str);
      return;
    } 
    G();
  }
  
  public void f() {
    e.f.c("MediaStreamingManager", "noNV21PrvFormat");
    if (this.q != null) {
      stopStreaming();
      this.q.onStateChanged(StreamingState.NO_NV21_PREVIEW_FORMAT, null);
    } 
  }
  
  public final void g() {
    if (u() && this.i != null) {
      StreamingProfile streamingProfile = this.g;
      if (streamingProfile != null && streamingProfile.getVideoProfile() != null) {
        int k = (this.g.getVideoProfile()).reqBitrate;
        int i = this.g.getVideoMinBitrate();
        int m = this.g.getVideoMaxBitrate();
        if (i > 0 && m > 0) {
          if (k >= i) {
            i = k;
            if (k > m)
              i = m; 
          } 
        } else {
          i = k;
          if (this.g.e())
            return; 
        } 
        this.i.a(i);
      } 
    } 
  }
  
  public AudioMixer getAudioMixer() {
    if (this.f != null) {
      if (this.o == null) {
        byte b1;
        this.o = new AudioMixer();
        int i = this.f.getReqSampleRate();
        if (this.f.getChannelConfig() == 16) {
          b1 = 1;
        } else {
          b1 = 2;
        } 
        this.o.a(i, b1, 16, b1 * 2048);
      } 
      return this.o;
    } 
    return null;
  }
  
  public int getMaxExposureCompensation() {
    e.d.c("MediaStreamingManager", "getMaxExposureCompensation");
    c c1 = this.j;
    if (c1 == null) {
      e.d.d("MediaStreamingManager", "Pure Audio Streaming can't get exposure compensation");
      return 0;
    } 
    return c1.g();
  }
  
  public int getMaxZoom() {
    c c1 = this.j;
    return (c1 != null) ? c1.o() : 0;
  }
  
  public int getMinExposureCompensation() {
    e.d.c("MediaStreamingManager", "getMinExposureCompensation");
    c c1 = this.j;
    if (c1 == null) {
      e.d.d("MediaStreamingManager", "Pure Audio Streaming can't get exposure compensation");
      return 0;
    } 
    return c1.f();
  }
  
  public int getZoom() {
    c c1 = this.j;
    return (c1 != null) ? c1.p() : 0;
  }
  
  public final void h() {
    if (q())
      return; 
    int i = this.e.getCameraPreviewWidth();
    int k = this.e.getCameraPreviewHeight();
    if (this.e.d()) {
      i = this.e.c();
      k = this.e.b();
    } 
    int m = PLFourCC.FOURCC_NV21;
    if (v())
      m = PLFourCC.FOURCC_ABGR; 
    a(i, k, this.j.h(), w(), m);
  }
  
  public final boolean i() {
    if (this.d.s() != b.c.d && this.d.s() != b.c.b && this.d.s() != b.c.c) {
      a.a.a.a.a.a.j.h.a a1 = this.n;
      if (a1 == null || !a1.c())
        return true; 
    } 
    return false;
  }
  
  public void inputAudioFrame(ByteBuffer paramByteBuffer, int paramInt, long paramLong, boolean paramBoolean) {
    if (!this.f.c()) {
      e.d.d("MediaStreamingManager", "inputAudioFrame must be called in CaptureAudioFrameOnly");
      return;
    } 
    if (this.h != null && r())
      this.h.a(paramByteBuffer, paramInt, paramLong / 1000L, paramBoolean); 
  }
  
  public void inputAudioFrame(byte[] paramArrayOfbyte, long paramLong, boolean paramBoolean) {
    if (!this.f.c()) {
      e.d.d("MediaStreamingManager", "inputAudioFrame must be called in CaptureAudioFrameOnly");
      return;
    } 
    if (this.h != null && r())
      this.h.a(paramArrayOfbyte, paramLong / 1000L, paramBoolean); 
  }
  
  public void inputVideoFrame(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, long paramLong) {
    if (!this.e.f()) {
      e.d.d("MediaStreamingManager", "inputVideoFrame must be called in CaptureCameraFrameOnly");
      return;
    } 
    if (this.i != null && this.a && b(paramInt2, paramInt3, paramInt4, paramBoolean, paramInt5)) {
      setEncodingMirror(paramBoolean);
      this.i.a(paramByteBuffer, paramInt1, paramLong);
    } 
  }
  
  public void inputVideoFrame(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, long paramLong) {
    if (!this.e.f()) {
      e.d.d("MediaStreamingManager", "inputVideoFrame must be called in CaptureCameraFrameOnly");
      return;
    } 
    inputVideoFrame(ByteBuffer.wrap(paramArrayOfbyte), paramArrayOfbyte.length, paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramLong);
  }
  
  public boolean isPictureStreaming() {
    a.a.a.a.a.a.j.h.a a1 = this.n;
    return (a1 != null && a1.c());
  }
  
  public boolean isZoomSupported() {
    c c1 = this.j;
    return (c1 != null && c1.n());
  }
  
  public final CameraStreamingSetting j() {
    CameraStreamingSetting cameraStreamingSetting = new CameraStreamingSetting();
    cameraStreamingSetting.setContinuousFocusModeEnabled(true).setCameraId(0).setCameraPrvSizeRatio(d.c).setCameraPrvSizeLevel(d.d);
    return cameraStreamingSetting;
  }
  
  public final MicrophoneStreamingSetting k() {
    MicrophoneStreamingSetting microphoneStreamingSetting = new MicrophoneStreamingSetting();
    microphoneStreamingSetting.setBluetoothSCOEnabled(false);
    return microphoneStreamingSetting;
  }
  
  public final StreamingProfile l() {
    StreamingProfile streamingProfile = new StreamingProfile();
    streamingProfile.setEncodingSizeLevel(1).setAudioQuality(20).setSendingBufferProfile(new StreamingProfile.SendingBufferProfile(0.2F, 0.8F, 3.0F, 20000L)).setVideoQuality(10);
    return streamingProfile;
  }
  
  public final void m() {
    if (this.d.l() && !SharedLibraryNameHelper.a(true))
      return; 
    if (x()) {
      e.f.d("MediaStreamingManager", "no need initializeAudio");
      return;
    } 
    if (this.d.l()) {
      this.h = (c)new b();
      return;
    } 
    this.h = (c)new d();
  }
  
  public void mute(boolean paramBoolean) {
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mute ");
    stringBuilder.append(paramBoolean);
    e.c("MediaStreamingManager", stringBuilder.toString());
    b b1 = this.k;
    if (b1 != null) {
      b1.a(paramBoolean);
    } else {
      e.d.d("MediaStreamingManager", "mute failed, mAudioManager == NULL !");
    } 
    AudioMixer audioMixer = this.o;
    if (audioMixer != null)
      audioMixer.a(paramBoolean); 
    b.a(paramBoolean);
  }
  
  public final void n() {
    if (this.g.getEncodingOrientation() == null) {
      StreamingProfile.ENCODING_ORIENTATION eNCODING_ORIENTATION;
      if (h.c(this.p)) {
        eNCODING_ORIENTATION = StreamingProfile.ENCODING_ORIENTATION.LAND;
      } else {
        eNCODING_ORIENTATION = StreamingProfile.ENCODING_ORIENTATION.PORT;
      } 
      this.g.setEncodingOrientation(eNCODING_ORIENTATION);
    } 
    if (this.e.getPrvSizeLevel() == null)
      this.e.setCameraPrvSizeLevel(d.d); 
    StreamingProfile.AudioProfile audioProfile = this.g.getAudioProfile();
    MicrophoneStreamingSetting microphoneStreamingSetting = this.f;
    if (microphoneStreamingSetting != null && microphoneStreamingSetting.getChannelConfig() == 12)
      audioProfile.channelNumber = 2; 
    this.c = a.a.a.a.a.a.e.a.a(audioProfile);
    b b1 = new b(this.p, this);
    this.d = b1;
    b1.a(this.e.getPrvSizeRatio());
    this.d.a(this.g);
    this.d.a(this.c);
    this.d.a(this.l);
  }
  
  public void notifyActivityOrientationChanged() {
    e.d.c("MediaStreamingManager", "notifyActivityOrientationChanged");
    c c1 = this.j;
    if (c1 != null)
      c1.m(); 
    a a1 = this.m;
    if (a1 != null)
      a1.e(); 
  }
  
  public final void o() {
    if (q()) {
      b b1 = new b();
      this.b = (c)b1;
      (b1.e()).a = true;
      (this.b.e()).b = false;
    } else if (x()) {
      d d1 = new d();
      this.b = (c)d1;
      (d1.e()).a = false;
      (this.b.e()).b = true;
    } else {
      a.a.a.a.a.a.i.a a1 = new a.a.a.a.a.a.i.a();
      this.b = (c)a1;
      (a1.e()).a = true;
      (this.b.e()).b = true;
    } 
    (this.b.e()).c = System.currentTimeMillis();
    StreamStatusCallback streamStatusCallback = this.t;
    if (streamStatusCallback != null)
      this.b.a(streamStatusCallback); 
    this.b.a(this.p);
    this.b.b(q());
  }
  
  public int onPreviewFpsSelected(List<int[]> paramList) {
    StreamingSessionListener streamingSessionListener = this.r;
    return (streamingSessionListener != null) ? streamingSessionListener.onPreviewFpsSelected(paramList) : -1;
  }
  
  public Camera.Size onPreviewSizeSelected(List<Camera.Size> paramList) {
    StreamingSessionListener streamingSessionListener = this.r;
    if (streamingSessionListener != null) {
      Camera.Size size = streamingSessionListener.onPreviewSizeSelected(paramList);
      if (size != null) {
        e e = e.d;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onPreviewSizeSelected: ");
        stringBuilder.append(size.width);
        stringBuilder.append("x");
        stringBuilder.append(size.height);
        e.c("MediaStreamingManager", stringBuilder.toString());
      } 
      return size;
    } 
    return null;
  }
  
  public void onStateChanged(StreamingState paramStreamingState, Object paramObject) {
    e e = e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onStateChanged: ");
    stringBuilder.append(paramStreamingState);
    e.c("MediaStreamingManager", stringBuilder.toString());
    StreamingStateChangedListener streamingStateChangedListener = this.q;
    if (streamingStateChangedListener != null)
      streamingStateChangedListener.onStateChanged(paramStreamingState, paramObject); 
  }
  
  public final void p() {
    if (this.d.k() && !SharedLibraryNameHelper.c(true))
      return; 
    if (q()) {
      e.f.d("MediaStreamingManager", "no need initializeVideo");
      return;
    } 
    if (y()) {
      if (z()) {
        this.i = (f)new b();
      } else {
        this.i = (f)new g();
      } 
    } else if (v()) {
      d d1 = new d();
      this.i = (f)d1;
      d1.a(this.B);
      ((d)this.i).a(this.F);
    } else {
      throw new IllegalArgumentException("Shouldn't invoking here");
    } 
    this.a = this.i.f();
    this.i.a(this);
    a.a.a.a.a.a.j.a.a().a(this.g.d());
  }
  
  public void pause() {
    // Byte code:
    //   0: getstatic a/a/a/a/a/e/e.d : La/a/a/a/a/e/e;
    //   3: ldc 'MediaStreamingManager'
    //   5: ldc_w 'pause +'
    //   8: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield b : La/a/a/a/a/a/i/c;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull -> 24
    //   20: aload_1
    //   21: invokevirtual k : ()V
    //   24: aload_0
    //   25: monitorenter
    //   26: aload_0
    //   27: iconst_0
    //   28: putfield x : Z
    //   31: aload_0
    //   32: invokevirtual stopStreaming : ()Z
    //   35: pop
    //   36: aload_0
    //   37: iconst_0
    //   38: putfield a : Z
    //   41: aload_0
    //   42: getfield j : La/a/a/a/a/b/c;
    //   45: ifnull -> 58
    //   48: aload_0
    //   49: getfield j : La/a/a/a/a/b/c;
    //   52: invokevirtual k : ()V
    //   55: invokestatic l : ()V
    //   58: aload_0
    //   59: monitorexit
    //   60: getstatic a/a/a/a/a/e/e.d : La/a/a/a/a/e/e;
    //   63: ldc 'MediaStreamingManager'
    //   65: ldc_w 'pause -'
    //   68: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   71: return
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Exception table:
    //   from	to	target	type
    //   26	58	72	finally
    //   58	60	72	finally
    //   73	75	72	finally
  }
  
  public boolean prepare(CameraStreamingSetting paramCameraStreamingSetting, MicrophoneStreamingSetting paramMicrophoneStreamingSetting, StreamingProfile paramStreamingProfile) {
    return prepare(paramCameraStreamingSetting, paramMicrophoneStreamingSetting, null, paramStreamingProfile, null);
  }
  
  public boolean prepare(CameraStreamingSetting paramCameraStreamingSetting, MicrophoneStreamingSetting paramMicrophoneStreamingSetting, WatermarkSetting paramWatermarkSetting, StreamingProfile paramStreamingProfile) {
    return prepare(paramCameraStreamingSetting, paramMicrophoneStreamingSetting, paramWatermarkSetting, paramStreamingProfile, null);
  }
  
  public boolean prepare(CameraStreamingSetting paramCameraStreamingSetting, MicrophoneStreamingSetting paramMicrophoneStreamingSetting, WatermarkSetting paramWatermarkSetting, StreamingProfile paramStreamingProfile, PreviewAppearance paramPreviewAppearance) {
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("prepare, camSetting = ");
    stringBuilder.append(paramCameraStreamingSetting);
    stringBuilder.append(", microphoneSetting = ");
    stringBuilder.append(paramMicrophoneStreamingSetting);
    stringBuilder.append(", wmSetting = ");
    stringBuilder.append(paramWatermarkSetting);
    stringBuilder.append(", profile = ");
    stringBuilder.append(paramStreamingProfile);
    stringBuilder.append(", previewAppearance = ");
    stringBuilder.append(paramPreviewAppearance);
    e.c("MediaStreamingManager", stringBuilder.toString());
    StreamingEnv.a();
    if (!this.x) {
      if (paramCameraStreamingSetting != null) {
        this.e = paramCameraStreamingSetting;
        b.b();
        b.a(paramCameraStreamingSetting.getVideoFilterType());
      } else {
        this.e = j();
      } 
      if (paramStreamingProfile != null) {
        this.g = paramStreamingProfile;
        b.a(paramStreamingProfile);
      } else {
        this.g = l();
      } 
      if (paramMicrophoneStreamingSetting != null) {
        this.f = paramMicrophoneStreamingSetting;
        b.c();
      } else {
        this.f = k();
      } 
      if (paramWatermarkSetting != null)
        b.a(paramWatermarkSetting); 
      n();
      o();
      if (!isSupportPreviewAppearance())
        paramPreviewAppearance = null; 
      a(paramWatermarkSetting, paramPreviewAppearance);
      this.k = new b(this.f, this);
      m();
      this.x = true;
      d d1 = new d();
      this.w = d1;
      d1.a(this.e.isFrontCameraMirror());
      this.w.b(v());
      this.w.a(this.e.getCameraFacingId());
      return true;
    } 
    return false;
  }
  
  public boolean prepare(CameraStreamingSetting paramCameraStreamingSetting, StreamingProfile paramStreamingProfile) {
    return prepare(paramCameraStreamingSetting, null, paramStreamingProfile);
  }
  
  public boolean prepare(StreamingProfile paramStreamingProfile) {
    return prepare(null, paramStreamingProfile);
  }
  
  public final boolean q() {
    AVCodecType aVCodecType = this.l;
    return (aVCodecType == AVCodecType.HW_AUDIO_CODEC || aVCodecType == AVCodecType.SW_AUDIO_CODEC);
  }
  
  public final boolean r() {
    if (this.a)
      if (!q()) {
        c c1 = this.j;
        if ((c1 != null && c1.c()) || this.E)
          return true; 
      } else {
        return true;
      }  
    return false;
  }
  
  public void refreshOverlay(View paramView, boolean paramBoolean) {
    f f1 = this.i;
    if (f1 != null && f1 instanceof d)
      ((d)f1).a(paramView, paramBoolean); 
  }
  
  public void removeAllOverlays() {
    f f1 = this.i;
    if (f1 != null && f1 instanceof d)
      ((d)f1).a(); 
  }
  
  public void removeOverlay(View paramView) {
    if (paramView == null) {
      e.g.d("MediaStreamingManager", "view is null, cannot remove");
      return;
    } 
    f f1 = this.i;
    if (f1 != null && f1 instanceof d)
      ((d)f1).a(paramView); 
  }
  
  public boolean resume() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic a/a/a/a/a/e/e.d : La/a/a/a/a/e/e;
    //   5: ldc 'MediaStreamingManager'
    //   7: ldc_w 'resume +'
    //   10: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield p : Landroid/content/Context;
    //   17: invokestatic a : (Landroid/content/Context;)V
    //   20: aload_0
    //   21: getfield b : La/a/a/a/a/a/i/c;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull -> 33
    //   29: aload_2
    //   30: invokevirtual l : ()V
    //   33: aload_0
    //   34: getfield h : La/a/a/a/a/a/e/c;
    //   37: ifnonnull -> 55
    //   40: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   43: ldc 'MediaStreamingManager'
    //   45: ldc_w 'try to initialize Audio again'
    //   48: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   51: aload_0
    //   52: invokevirtual m : ()V
    //   55: aload_0
    //   56: iconst_1
    //   57: putfield x : Z
    //   60: aload_0
    //   61: invokevirtual q : ()Z
    //   64: ifeq -> 90
    //   67: aload_0
    //   68: getfield q : Lcom/qiniu/pili/droid/streaming/StreamingStateChangedListener;
    //   71: astore_2
    //   72: aload_2
    //   73: ifnull -> 86
    //   76: aload_2
    //   77: getstatic com/qiniu/pili/droid/streaming/StreamingState.READY : Lcom/qiniu/pili/droid/streaming/StreamingState;
    //   80: aconst_null
    //   81: invokeinterface onStateChanged : (Lcom/qiniu/pili/droid/streaming/StreamingState;Ljava/lang/Object;)V
    //   86: aload_0
    //   87: monitorexit
    //   88: iconst_1
    //   89: ireturn
    //   90: aload_0
    //   91: getfield j : La/a/a/a/a/b/c;
    //   94: aload_0
    //   95: getfield d : La/a/a/a/a/a/b;
    //   98: invokevirtual a : (La/a/a/a/a/a/b;)Z
    //   101: istore_1
    //   102: invokestatic k : ()V
    //   105: getstatic a/a/a/a/a/e/e.d : La/a/a/a/a/e/e;
    //   108: ldc 'MediaStreamingManager'
    //   110: ldc_w 'resume -'
    //   113: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_0
    //   117: monitorexit
    //   118: iload_1
    //   119: ireturn
    //   120: astore_2
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_2
    //   124: athrow
    // Exception table:
    //   from	to	target	type
    //   2	25	120	finally
    //   29	33	120	finally
    //   33	55	120	finally
    //   55	72	120	finally
    //   76	86	120	finally
    //   90	116	120	finally
  }
  
  public final boolean s() {
    boolean bool = q();
    boolean bool2 = false;
    boolean bool1 = false;
    null = false;
    if (bool) {
      if (!this.d.l() || SharedLibraryNameHelper.a(true))
        null = true; 
      return null;
    } 
    if (x()) {
      if (this.d.k()) {
        null = bool2;
        return SharedLibraryNameHelper.c(true) ? true : null;
      } 
    } else {
      boolean bool3;
      boolean bool4;
      if (!this.d.l() || SharedLibraryNameHelper.a(true)) {
        bool3 = true;
      } else {
        bool3 = false;
      } 
      if (!this.d.k() || SharedLibraryNameHelper.c(true)) {
        bool4 = true;
      } else {
        bool4 = false;
      } 
      null = bool1;
      if (bool3) {
        null = bool1;
        if (bool4)
          null = true; 
      } 
      return null;
    } 
    return true;
  }
  
  public void sendSEIMessage(String paramString, int paramInt) {
    sendSEIMessage(paramString, paramInt, this.G);
  }
  
  public void sendSEIMessage(String paramString, int paramInt, long paramLong) {
    b.a().a(paramInt);
    b.a().b(0);
    b.a().a(paramString);
    b.a().a(paramLong);
  }
  
  public final void setAudioSourceCallback(AudioSourceCallback paramAudioSourceCallback) {
    boolean bool;
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setAudioSourceCallback ");
    if (paramAudioSourceCallback != null) {
      bool = true;
    } else {
      bool = false;
    } 
    stringBuilder.append(bool);
    e.c("MediaStreamingManager", stringBuilder.toString());
    this.u = paramAudioSourceCallback;
  }
  
  public void setAutoRefreshOverlay(boolean paramBoolean) {
    f f1 = this.i;
    if (f1 != null && f1 instanceof d)
      ((d)f1).d(paramBoolean); 
  }
  
  public boolean setEncodingMirror(boolean paramBoolean) {
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setEncodingMirror ");
    stringBuilder.append(paramBoolean);
    e.c("MediaStreamingManager", stringBuilder.toString());
    f f1 = this.i;
    if (f1 != null) {
      f1.a(this.w.d(paramBoolean));
      return true;
    } 
    e.d.e("MediaStreamingManager", "setEncodingMirror failed, not allowed in pure audio streaming mode !");
    return false;
  }
  
  public void setExposureCompensation(int paramInt) {
    e.d.c("MediaStreamingManager", "setExposureCompensation");
    c c1 = this.j;
    if (c1 == null) {
      e.d.d("MediaStreamingManager", "Pure Audio Streaming can't set exposure compensation");
      return;
    } 
    c1.a(paramInt);
  }
  
  public void setFocusAreaIndicator(ViewGroup paramViewGroup, View paramView) {
    c c1 = this.j;
    if (c1 != null)
      c1.a(paramViewGroup, paramView); 
  }
  
  public void setNativeLoggingEnabled(boolean paramBoolean) {
    e.a(paramBoolean);
  }
  
  public void setPictureStreamingFilePath(String paramString) {
    this.g.setPictureStreamingFilePath(paramString);
    if (isPictureStreaming())
      this.n.a(paramString); 
  }
  
  public void setPictureStreamingResourceId(int paramInt) {
    this.g.setPictureStreamingResourceId(paramInt);
    if (isPictureStreaming())
      this.n.a(paramInt); 
  }
  
  public boolean setPreviewMirror(boolean paramBoolean) {
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setPreviewMirror ");
    stringBuilder.append(paramBoolean);
    e.c("MediaStreamingManager", stringBuilder.toString());
    c c1 = this.j;
    if (c1 != null)
      return c1.e(paramBoolean); 
    e.d.e("MediaStreamingManager", "setPreviewMirror failed, not allowed in pure audio streaming mode !");
    return false;
  }
  
  public final void setStreamStatusCallback(StreamStatusCallback paramStreamStatusCallback) {
    boolean bool;
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setStreamStatusCallback ");
    if (paramStreamStatusCallback != null) {
      bool = true;
    } else {
      bool = false;
    } 
    stringBuilder.append(bool);
    e.c("MediaStreamingManager", stringBuilder.toString());
    if (this.t != paramStreamStatusCallback) {
      this.t = paramStreamStatusCallback;
      c c1 = this.b;
      if (c1 != null)
        c1.a(paramStreamStatusCallback); 
    } 
  }
  
  public final void setStreamingPreviewCallback(StreamingPreviewCallback paramStreamingPreviewCallback) {
    setStreamingPreviewCallback(paramStreamingPreviewCallback, false);
  }
  
  public final void setStreamingPreviewCallback(StreamingPreviewCallback paramStreamingPreviewCallback, boolean paramBoolean) {
    boolean bool;
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setStreamingPreviewCallback ");
    if (paramStreamingPreviewCallback != null) {
      bool = true;
    } else {
      bool = false;
    } 
    stringBuilder.append(bool);
    e.c("MediaStreamingManager", stringBuilder.toString());
    c c1 = this.j;
    if (c1 != null)
      c1.a(paramStreamingPreviewCallback, paramBoolean); 
    this.s = paramStreamingPreviewCallback;
  }
  
  public void setStreamingProfile(StreamingProfile paramStreamingProfile) {
    e.d.c("MediaStreamingManager", "setStreamingProfile");
    if (paramStreamingProfile != null) {
      this.g = paramStreamingProfile;
      this.d.a(paramStreamingProfile);
      b.a(paramStreamingProfile);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Illegal profile:");
    stringBuilder.append(paramStreamingProfile);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final void setStreamingSessionListener(StreamingSessionListener paramStreamingSessionListener) {
    boolean bool;
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setStreamingSessionListener ");
    if (paramStreamingSessionListener != null) {
      bool = true;
    } else {
      bool = false;
    } 
    stringBuilder.append(bool);
    e.c("MediaStreamingManager", stringBuilder.toString());
    this.r = paramStreamingSessionListener;
  }
  
  public final void setStreamingStateListener(StreamingStateChangedListener paramStreamingStateChangedListener) {
    boolean bool;
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setStreamingStateListener ");
    if (paramStreamingStateChangedListener != null) {
      bool = true;
    } else {
      bool = false;
    } 
    stringBuilder.append(bool);
    e.c("MediaStreamingManager", stringBuilder.toString());
    this.q = paramStreamingStateChangedListener;
  }
  
  public final void setSurfaceTextureCallback(SurfaceTextureCallback paramSurfaceTextureCallback) {
    boolean bool;
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setSurfaceTextureCallback ");
    if (paramSurfaceTextureCallback != null) {
      bool = true;
    } else {
      bool = false;
    } 
    stringBuilder.append(bool);
    e.c("MediaStreamingManager", stringBuilder.toString());
    c c1 = this.j;
    if (c1 != null) {
      c1.a(paramSurfaceTextureCallback);
      return;
    } 
    e.d.e("MediaStreamingManager", "setSurfaceTextureCallback failed, mCameraManager is null !");
  }
  
  public final void setSurfaceTextureCallback2(SurfaceTextureCallback2 paramSurfaceTextureCallback2) {
    boolean bool;
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setSurfaceTextureCallback2 ");
    if (paramSurfaceTextureCallback2 != null) {
      bool = true;
    } else {
      bool = false;
    } 
    stringBuilder.append(bool);
    e.c("MediaStreamingManager", stringBuilder.toString());
    this.F = paramSurfaceTextureCallback2;
    f f1 = this.i;
    if (f1 != null && f1 instanceof d)
      ((d)f1).a(paramSurfaceTextureCallback2); 
  }
  
  public void setTextureRotation(int paramInt) {
    this.j.b(paramInt);
  }
  
  public final void setVideoFilterType(CameraStreamingSetting.VIDEO_FILTER_TYPE paramVIDEO_FILTER_TYPE) {
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setVideoFilterType ");
    stringBuilder.append(paramVIDEO_FILTER_TYPE);
    e.c("MediaStreamingManager", stringBuilder.toString());
    if (paramVIDEO_FILTER_TYPE != null) {
      CameraStreamingSetting cameraStreamingSetting = this.e;
      if (cameraStreamingSetting != null)
        cameraStreamingSetting.setVideoFilter(paramVIDEO_FILTER_TYPE); 
      a a1 = this.m;
      if (a1 != null)
        a1.a(paramVIDEO_FILTER_TYPE); 
      b.a(paramVIDEO_FILTER_TYPE);
    } 
  }
  
  public void setZoomValue(int paramInt) {
    if (this.j != null) {
      e e = e.d;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setZoomValue ");
      stringBuilder.append(paramInt);
      e.c("MediaStreamingManager", stringBuilder.toString());
      this.j.c(paramInt);
    } 
  }
  
  public void startMicrophoneRecording() {
    boolean bool = this.f.c();
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("startMicrophoneRecording isCaptureAudioFrameOnly = ");
    stringBuilder.append(bool);
    e.c("MediaStreamingManager", stringBuilder.toString());
    if (bool) {
      b b1 = this.k;
      if (b1 != null)
        b1.a(this.p); 
    } 
  }
  
  public boolean startPlayback() {
    stopPlayback();
    a.a.a.a.a.h.a a1 = new a.a.a.a.a.h.a();
    this.v = a1;
    boolean bool = a1.a(this.f.getReqSampleRate(), this.f.getChannelConfigOut(), this.k.a());
    if (bool) {
      this.v.b();
    } else {
      e.d.e("MediaStreamingManager", "ERROR. init playback failed");
    } 
    b.o();
    return bool;
  }
  
  public boolean startStreaming() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic a : ()La/a/a/a/a/n/b;
    //   5: invokevirtual b : ()Z
    //   8: ifne -> 45
    //   11: getstatic a/a/a/a/a/e/e.d : La/a/a/a/a/e/e;
    //   14: ldc 'MediaStreamingManager'
    //   16: ldc_w 'Authentication failed!!!'
    //   19: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: getfield q : Lcom/qiniu/pili/droid/streaming/StreamingStateChangedListener;
    //   26: astore_3
    //   27: aload_3
    //   28: ifnull -> 41
    //   31: aload_3
    //   32: getstatic com/qiniu/pili/droid/streaming/StreamingState.UNAUTHORIZED_PACKAGE : Lcom/qiniu/pili/droid/streaming/StreamingState;
    //   35: aconst_null
    //   36: invokeinterface onStateChanged : (Lcom/qiniu/pili/droid/streaming/StreamingState;Ljava/lang/Object;)V
    //   41: aload_0
    //   42: monitorexit
    //   43: iconst_0
    //   44: ireturn
    //   45: aload_0
    //   46: invokevirtual t : ()Z
    //   49: ifne -> 67
    //   52: getstatic a/a/a/a/a/e/e.d : La/a/a/a/a/e/e;
    //   55: ldc 'MediaStreamingManager'
    //   57: ldc_w 'streaming core is not available!!!'
    //   60: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_0
    //   64: monitorexit
    //   65: iconst_0
    //   66: ireturn
    //   67: getstatic a/a/a/a/a/e/e.d : La/a/a/a/a/e/e;
    //   70: astore_3
    //   71: new java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial <init> : ()V
    //   78: astore #4
    //   80: aload #4
    //   82: ldc_w 'startStreaming  mIsInitialized '
    //   85: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload #4
    //   91: aload_0
    //   92: getfield x : Z
    //   95: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload #4
    //   101: ldc_w ' mRecordingEnabled='
    //   104: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload #4
    //   110: aload_0
    //   111: getfield a : Z
    //   114: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload #4
    //   120: ldc_w ',mIsPreviewReady='
    //   123: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload_0
    //   128: getfield j : La/a/a/a/a/b/c;
    //   131: astore #5
    //   133: iconst_1
    //   134: istore_2
    //   135: aload #5
    //   137: ifnull -> 286
    //   140: aload #5
    //   142: invokevirtual b : ()Z
    //   145: ifeq -> 286
    //   148: iconst_1
    //   149: istore_1
    //   150: goto -> 153
    //   153: aload #4
    //   155: iload_1
    //   156: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload #4
    //   162: ldc_w ',mDisconnectedWhilePictureStreaming='
    //   165: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload #4
    //   171: aload_0
    //   172: getfield A : Z
    //   175: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload #4
    //   181: ldc_w ',mIsOnlyAudioStreaming='
    //   184: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload_0
    //   189: getfield j : La/a/a/a/a/b/c;
    //   192: ifnonnull -> 291
    //   195: iload_2
    //   196: istore_1
    //   197: goto -> 200
    //   200: aload #4
    //   202: iload_1
    //   203: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload_3
    //   208: ldc 'MediaStreamingManager'
    //   210: aload #4
    //   212: invokevirtual toString : ()Ljava/lang/String;
    //   215: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload_0
    //   219: getfield x : Z
    //   222: ifeq -> 277
    //   225: aload_0
    //   226: getfield a : Z
    //   229: ifne -> 277
    //   232: aload_0
    //   233: getfield d : La/a/a/a/a/a/b;
    //   236: invokevirtual i : ()Z
    //   239: ifeq -> 277
    //   242: aload_0
    //   243: getfield j : La/a/a/a/a/b/c;
    //   246: astore_3
    //   247: aload_3
    //   248: ifnull -> 265
    //   251: aload_3
    //   252: invokevirtual b : ()Z
    //   255: ifne -> 265
    //   258: aload_0
    //   259: getfield A : Z
    //   262: ifeq -> 277
    //   265: invokestatic d : ()V
    //   268: aload_0
    //   269: invokevirtual I : ()Z
    //   272: istore_1
    //   273: aload_0
    //   274: monitorexit
    //   275: iload_1
    //   276: ireturn
    //   277: aload_0
    //   278: monitorexit
    //   279: iconst_0
    //   280: ireturn
    //   281: astore_3
    //   282: aload_0
    //   283: monitorexit
    //   284: aload_3
    //   285: athrow
    //   286: iconst_0
    //   287: istore_1
    //   288: goto -> 153
    //   291: iconst_0
    //   292: istore_1
    //   293: goto -> 200
    // Exception table:
    //   from	to	target	type
    //   2	27	281	finally
    //   31	41	281	finally
    //   45	63	281	finally
    //   67	133	281	finally
    //   140	148	281	finally
    //   153	195	281	finally
    //   200	247	281	finally
    //   251	265	281	finally
    //   265	273	281	finally
  }
  
  public void stopMicrophoneRecording() {
    boolean bool = this.f.c();
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("stopMicrophoneRecording isCaptureAudioFrameOnly = ");
    stringBuilder.append(bool);
    e.c("MediaStreamingManager", stringBuilder.toString());
    if (bool) {
      b b1 = this.k;
      if (b1 != null)
        b1.b(this.p); 
    } 
  }
  
  public void stopPlayback() {
    a.a.a.a.a.h.a a1 = this.v;
    if (a1 != null) {
      a1.a();
      this.v = null;
    } 
  }
  
  public boolean stopStreaming() {
    boolean bool;
    if (!t()) {
      e.d.d("MediaStreamingManager", "stopStreaming ignore, already stopped");
      return false;
    } 
    c c1 = this.j;
    if (c1 != null && c1.c()) {
      bool = true;
    } else {
      bool = false;
    } 
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("stopStreaming mRecordingEnabled:");
    stringBuilder.append(this.a);
    stringBuilder.append(",isCamSwitching=");
    stringBuilder.append(bool);
    stringBuilder.append(",mIsInitialized:");
    stringBuilder.append(this.x);
    e.c("MediaStreamingManager", stringBuilder.toString());
    if (isPictureStreaming())
      this.A = true; 
    if (this.a && (q() || !bool || !this.x)) {
      this.a = false;
      L();
      b.e();
      return true;
    } 
    return false;
  }
  
  public boolean switchCamera() {
    CameraStreamingSetting.CAMERA_FACING_ID cAMERA_FACING_ID;
    if (this.j == null) {
      e.d.e("MediaStreamingManager", "switchCamera failed, not allowed in pure audio streaming mode !");
      return false;
    } 
    if (this.e.getReqCameraId() == 0) {
      cAMERA_FACING_ID = CameraStreamingSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT;
    } else {
      if (this.e.getReqCameraId() == 1) {
        cAMERA_FACING_ID = CameraStreamingSetting.CAMERA_FACING_ID.CAMERA_FACING_BACK;
        e e1 = e.d;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("switchCamera reqCamId = ");
        stringBuilder1.append(cAMERA_FACING_ID);
        e1.c("MediaStreamingManager", stringBuilder1.toString());
        return switchCamera(cAMERA_FACING_ID);
      } 
      e.d.d("MediaStreamingManager", "switchCamera failed, no more camera device can do switch !");
      return false;
    } 
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("switchCamera reqCamId = ");
    stringBuilder.append(cAMERA_FACING_ID);
    e.c("MediaStreamingManager", stringBuilder.toString());
    return switchCamera(cAMERA_FACING_ID);
  }
  
  public boolean switchCamera(CameraStreamingSetting.CAMERA_FACING_ID paramCAMERA_FACING_ID) {
    e e1;
    if (this.j == null) {
      e.d.e("MediaStreamingManager", "switchCamera failed, not allowed in pure audio streaming mode !");
      return false;
    } 
    if (!i()) {
      e1 = e.d;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("switchCamera failed, muxer state:");
      stringBuilder1.append(this.d.s());
      e1.d("MediaStreamingManager", stringBuilder1.toString());
      return false;
    } 
    e e2 = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("switchCamera facingId = ");
    stringBuilder.append(e1);
    stringBuilder.append("mRecordingEnabled:");
    stringBuilder.append(this.a);
    e2.c("MediaStreamingManager", stringBuilder.toString());
    if (this.a)
      this.j.b(true); 
    if (this.j.a(this.d, (CameraStreamingSetting.CAMERA_FACING_ID)e1)) {
      this.w.a((CameraStreamingSetting.CAMERA_FACING_ID)e1);
      this.w.c(true);
      a a1 = this.m;
      if (a1 != null)
        a1.c(); 
      b.j();
      return true;
    } 
    return false;
  }
  
  public final boolean t() {
    return (SharedLibraryNameHelper.e(true) && s());
  }
  
  public boolean togglePictureStreaming() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Lcom/qiniu/pili/droid/streaming/StreamingProfile;
    //   6: invokevirtual getPictureStreamingFilePath : ()Ljava/lang/String;
    //   9: astore_2
    //   10: aload_0
    //   11: getfield g : Lcom/qiniu/pili/droid/streaming/StreamingProfile;
    //   14: invokevirtual getPictureStreamingResourceId : ()I
    //   17: istore_1
    //   18: aload_2
    //   19: ifnonnull -> 41
    //   22: iload_1
    //   23: ifge -> 41
    //   26: getstatic a/a/a/a/a/e/e.d : La/a/a/a/a/e/e;
    //   29: ldc 'MediaStreamingManager'
    //   31: ldc_w 'toggle picture streaming failed cause no file set.'
    //   34: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload_0
    //   38: monitorexit
    //   39: iconst_0
    //   40: ireturn
    //   41: aload_0
    //   42: invokevirtual q : ()Z
    //   45: ifeq -> 63
    //   48: getstatic a/a/a/a/a/e/e.d : La/a/a/a/a/e/e;
    //   51: ldc 'MediaStreamingManager'
    //   53: ldc_w 'toggle picture streaming failed cause this is a audio only stream'
    //   56: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_0
    //   60: monitorexit
    //   61: iconst_0
    //   62: ireturn
    //   63: aload_0
    //   64: invokevirtual t : ()Z
    //   67: ifeq -> 261
    //   70: aload_0
    //   71: getfield x : Z
    //   74: ifeq -> 261
    //   77: aload_0
    //   78: getfield a : Z
    //   81: ifne -> 106
    //   84: aload_0
    //   85: invokevirtual v : ()Z
    //   88: ifeq -> 106
    //   91: getstatic a/a/a/a/a/e/e.d : La/a/a/a/a/e/e;
    //   94: ldc 'MediaStreamingManager'
    //   96: ldc_w 'toggle picture streaming failed cause no recording enabled in TextureMovieVideoType.'
    //   99: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload_0
    //   103: monitorexit
    //   104: iconst_0
    //   105: ireturn
    //   106: aload_0
    //   107: getfield n : La/a/a/a/a/a/j/h/a;
    //   110: ifnonnull -> 235
    //   113: aload_0
    //   114: invokevirtual v : ()Z
    //   117: ifeq -> 153
    //   120: aload_0
    //   121: new a/a/a/a/a/a/j/h/b
    //   124: dup
    //   125: aload_0
    //   126: getfield p : Landroid/content/Context;
    //   129: aload_0
    //   130: getfield j : La/a/a/a/a/b/c;
    //   133: aload_0
    //   134: getfield d : La/a/a/a/a/a/b;
    //   137: aload_0
    //   138: getfield i : La/a/a/a/a/a/j/f;
    //   141: checkcast a/a/a/a/a/a/j/d
    //   144: invokespecial <init> : (Landroid/content/Context;La/a/a/a/a/b/c;La/a/a/a/a/a/b;La/a/a/a/a/a/j/d;)V
    //   147: putfield n : La/a/a/a/a/a/j/h/a;
    //   150: goto -> 212
    //   153: aload_0
    //   154: getfield a : Z
    //   157: ifne -> 164
    //   160: aload_0
    //   161: invokevirtual h : ()V
    //   164: new a/a/a/a/a/a/j/h/c
    //   167: dup
    //   168: aload_0
    //   169: getfield p : Landroid/content/Context;
    //   172: aload_0
    //   173: getfield j : La/a/a/a/a/b/c;
    //   176: aload_0
    //   177: getfield d : La/a/a/a/a/a/b;
    //   180: aload_0
    //   181: getfield i : La/a/a/a/a/a/j/f;
    //   184: checkcast a/a/a/a/a/a/j/g
    //   187: aload_0
    //   188: getfield C : La/a/a/a/a/a/j/f$a;
    //   191: aload_0
    //   192: getfield s : Lcom/qiniu/pili/droid/streaming/StreamingPreviewCallback;
    //   195: invokespecial <init> : (Landroid/content/Context;La/a/a/a/a/b/c;La/a/a/a/a/a/b;La/a/a/a/a/a/j/g;La/a/a/a/a/a/j/f$a;Lcom/qiniu/pili/droid/streaming/StreamingPreviewCallback;)V
    //   198: astore_3
    //   199: aload_0
    //   200: aload_3
    //   201: putfield n : La/a/a/a/a/a/j/h/a;
    //   204: aload_3
    //   205: aload_0
    //   206: getfield a : Z
    //   209: invokevirtual a : (Z)V
    //   212: aload_2
    //   213: ifnull -> 227
    //   216: aload_0
    //   217: getfield n : La/a/a/a/a/a/j/h/a;
    //   220: aload_2
    //   221: invokevirtual a : (Ljava/lang/String;)V
    //   224: goto -> 235
    //   227: aload_0
    //   228: getfield n : La/a/a/a/a/a/j/h/a;
    //   231: iload_1
    //   232: invokevirtual a : (I)V
    //   235: aload_0
    //   236: getfield n : La/a/a/a/a/a/j/h/a;
    //   239: invokevirtual c : ()Z
    //   242: ifeq -> 253
    //   245: aload_0
    //   246: iconst_1
    //   247: invokevirtual a : (Z)V
    //   250: goto -> 257
    //   253: aload_0
    //   254: invokevirtual H : ()V
    //   257: aload_0
    //   258: monitorexit
    //   259: iconst_1
    //   260: ireturn
    //   261: getstatic a/a/a/a/a/e/e.d : La/a/a/a/a/e/e;
    //   264: ldc 'MediaStreamingManager'
    //   266: ldc_w 'toggle picture streaming failed cause in invalid state'
    //   269: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   272: aload_0
    //   273: monitorexit
    //   274: iconst_0
    //   275: ireturn
    //   276: astore_2
    //   277: aload_0
    //   278: monitorexit
    //   279: aload_2
    //   280: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	276	finally
    //   26	37	276	finally
    //   41	59	276	finally
    //   63	102	276	finally
    //   106	150	276	finally
    //   153	164	276	finally
    //   164	212	276	finally
    //   216	224	276	finally
    //   227	235	276	finally
    //   235	250	276	finally
    //   253	257	276	finally
    //   261	272	276	finally
  }
  
  public boolean turnLightOff() {
    e.d.c("MediaStreamingManager", "turnLightOff");
    c c1 = this.j;
    if (c1 == null) {
      e.d.d("MediaStreamingManager", "Pure Audio Streaming can't support torch");
      return false;
    } 
    return c1.d();
  }
  
  public boolean turnLightOn() {
    e.d.c("MediaStreamingManager", "turnLightOn");
    c c1 = this.j;
    if (c1 == null) {
      e.d.d("MediaStreamingManager", "Pure Audio Streaming can't support torch");
      return false;
    } 
    return c1.e();
  }
  
  public final boolean u() {
    return this.d.k() ? true : h.a();
  }
  
  public void updateEncodingType(AVCodecType paramAVCodecType) {
    b b1;
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("updateEncodingType newType = ");
    stringBuilder.append(paramAVCodecType);
    e.c("MediaStreamingManager", stringBuilder.toString());
    if (paramAVCodecType == null) {
      e = e.d;
      stringBuilder = new StringBuilder();
      stringBuilder.append("Illegal encoding type:");
      stringBuilder.append(paramAVCodecType);
      e.d("MediaStreamingManager", stringBuilder.toString());
      return;
    } 
    if (paramAVCodecType != this.l) {
      this.l = paramAVCodecType;
      e.a().a(this.l);
      o();
      p();
      c c1 = this.j;
      if (c1 != null)
        c1.d(v()); 
      b1 = this.d;
      if (b1 != null) {
        b1.a(this.l);
        return;
      } 
    } else {
      e = e.d;
      stringBuilder = new StringBuilder();
      stringBuilder.append("Error.Ignore the same Encoding Type:");
      stringBuilder.append(b1);
      e.d("MediaStreamingManager", stringBuilder.toString());
    } 
  }
  
  public final void updateFaceBeautySetting(CameraStreamingSetting.FaceBeautySetting paramFaceBeautySetting) {
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("updateFaceBeautySetting ");
    stringBuilder.append(paramFaceBeautySetting);
    e.c("MediaStreamingManager", stringBuilder.toString());
    a a1 = this.m;
    if (a1 != null)
      a1.a(paramFaceBeautySetting); 
  }
  
  public void updateMicrophoneSetting(MicrophoneStreamingSetting paramMicrophoneStreamingSetting) {
    this.f = paramMicrophoneStreamingSetting;
    this.k = new b(paramMicrophoneStreamingSetting, this);
    b.c();
  }
  
  public final void updateWatermarkSetting(WatermarkSetting paramWatermarkSetting) {
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("updateWatermarkSetting ");
    stringBuilder.append(paramWatermarkSetting);
    e.c("MediaStreamingManager", stringBuilder.toString());
    c c1 = this.j;
    if (c1 != null)
      c1.a(paramWatermarkSetting); 
    f f1 = this.i;
    if (f1 != null)
      f1.a(paramWatermarkSetting); 
    b.a(paramWatermarkSetting);
  }
  
  public final boolean v() {
    AVCodecType aVCodecType = this.l;
    return (aVCodecType == AVCodecType.HW_VIDEO_WITH_HW_AUDIO_CODEC || aVCodecType == AVCodecType.HW_VIDEO_CODEC || aVCodecType == AVCodecType.HW_VIDEO_SURFACE_AS_INPUT_WITH_HW_AUDIO_CODEC || aVCodecType == AVCodecType.HW_VIDEO_SURFACE_AS_INPUT_WITH_SW_AUDIO_CODEC);
  }
  
  public final boolean w() {
    return (b.a().c() && this.e.isFrontCameraMirror());
  }
  
  public final boolean x() {
    AVCodecType aVCodecType = this.l;
    return (aVCodecType == AVCodecType.SW_VIDEO_CODEC || aVCodecType == AVCodecType.HW_VIDEO_CODEC);
  }
  
  public final boolean y() {
    return (this.d.k() || this.l == AVCodecType.HW_VIDEO_YUV_AS_INPUT_WITH_HW_AUDIO_CODEC);
  }
  
  public final boolean z() {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\MediaStreamingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */