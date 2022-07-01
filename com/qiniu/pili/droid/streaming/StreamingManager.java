package com.qiniu.pili.droid.streaming;

import a.a.a.a.a.a.b;
import a.a.a.a.a.a.c;
import a.a.a.a.a.a.e.c;
import a.a.a.a.a.a.e.d;
import a.a.a.a.a.a.e.e.b;
import a.a.a.a.a.a.i.b;
import a.a.a.a.a.a.i.c;
import a.a.a.a.a.a.i.d;
import a.a.a.a.a.a.j.c;
import a.a.a.a.a.a.j.d;
import a.a.a.a.a.a.j.f;
import a.a.a.a.a.a.j.g;
import a.a.a.a.a.d.b;
import a.a.a.a.a.e.e;
import a.a.a.a.a.e.h;
import a.a.a.a.a.f.b;
import a.a.a.a.a.k.b;
import a.a.a.a.a.n.b;
import android.content.Context;
import android.view.Surface;
import com.qiniu.pili.droid.streaming.av.common.PLFourCC;
import java.nio.ByteBuffer;

public final class StreamingManager implements b.b, c {
  public boolean a;
  
  public c b;
  
  public a.a.a.a.a.a.e.a c;
  
  public b d;
  
  public StreamingProfile e;
  
  public c f;
  
  public f g;
  
  public d h;
  
  public AVCodecType i;
  
  public Context j;
  
  public StreamingStateChangedListener k;
  
  public StreamingSessionListener l;
  
  public StreamStatusCallback m;
  
  public f.a n;
  
  public boolean o = false;
  
  public boolean p = false;
  
  public boolean q = false;
  
  public volatile boolean r;
  
  public volatile boolean s;
  
  public volatile long t;
  
  public SurfaceTextureCallback2 u;
  
  public StreamingManager(Context paramContext) {
    this(paramContext, AVCodecType.HW_AUDIO_CODEC);
  }
  
  public StreamingManager(Context paramContext, AVCodecType paramAVCodecType) {
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("created, AVCodecType = ");
    stringBuilder.append(paramAVCodecType);
    e.c("StreamingManager", stringBuilder.toString());
    e.e.c("StreamingManager", h.h(paramContext));
    StreamingEnv.a();
    this.j = paramContext.getApplicationContext();
    this.i = paramAVCodecType;
    b.a();
    b.a(paramAVCodecType);
  }
  
  public final boolean A() {
    if (this.q) {
      this.q = false;
      if (J())
        return true; 
    } 
    return false;
  }
  
  public void B() {
    e.d.d("StreamingManager", "signalAudioRecordingException ");
    c c1 = this.b;
    if (c1 != null) {
      c1.c(0);
      a(b.c.n, null);
    } 
  }
  
  public final void C() {
    e.f.c("StreamingManager", "startAudioEncoding");
    c c1 = this.f;
    if (c1 != null)
      c1.a(this.b); 
  }
  
  public void D() {
    d d1 = this.h;
    if (d1 != null) {
      this.s = true;
      d1.a(this.n);
    } 
  }
  
  public final boolean E() {
    e.f.c("StreamingManager", "startStreamingInternal +");
    boolean bool = this.b.a(this.d);
    if (bool) {
      this.a = true;
      C();
      F();
      e e = e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("startStreamingInternal -, isOk: ");
      stringBuilder.append(bool);
      e.c("StreamingManager", stringBuilder.toString());
      return true;
    } 
    e.f.c("StreamingManager", "startStreamingInternal -");
    return false;
  }
  
  public void F() {
    if (m())
      return; 
    this.r = false;
    e e = e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("startVideoEncoding mCurrentTransferSessionCfg:");
    stringBuilder.append(this.n);
    e.c("StreamingManager", stringBuilder.toString());
    z();
  }
  
  public final void G() {
    e.f.c("StreamingManager", "stopAudioEncoding");
    c c1 = this.f;
    if (c1 != null)
      c1.a(); 
  }
  
  public void H() {
    d d1 = this.h;
    if (d1 != null) {
      this.s = false;
      d1.b(false);
    } 
  }
  
  public final void I() {
    e.f.c("StreamingManager", "stopStreamingInternal +");
    G();
    a(false);
    H();
    c c1 = this.b;
    if (c1 != null) {
      c1.a();
      this.b.a(false);
    } 
    e.f.c("StreamingManager", "stopStreamingInternal -");
  }
  
  public final boolean J() {
    StreamingSessionListener streamingSessionListener = this.l;
    if (streamingSessionListener != null && streamingSessionListener.onRestartStreamingHandled(0)) {
      e.f.c("StreamingManager", "RestartStreamingHandled");
      return true;
    } 
    return false;
  }
  
  public void a() {
    e.f.c("StreamingManager", "onEncoderExitDone");
    if (!this.s)
      this.r = false; 
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4) {
    f.a a1;
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
    e.c("StreamingManager", stringBuilder.toString());
    boolean bool = q();
    if (bool) {
      a1 = new f.a(this.b, paramInt1, paramInt2, -1, paramBoolean, paramInt3, paramInt4, null, bool);
    } else if (v()) {
      a1 = new f.a(this.b, paramInt1, paramInt2, -1, paramBoolean, paramInt3, paramInt4, null, bool);
    } else {
      a1 = new f.a(this.b, paramInt1, paramInt2, -1, paramBoolean, paramInt3, PLFourCC.FOURCC_ABGR, null, null, bool);
    } 
    this.n = a1;
  }
  
  public void a(b.c paramc, Object paramObject) {
    StreamingState streamingState1;
    StreamingState streamingState2 = StreamingState.UNKNOWN;
    e e = e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("muxerStatusUpdate muxerState:");
    stringBuilder.append(paramc);
    stringBuilder.append(",isNeedUpdateProfile:");
    stringBuilder.append(this.p);
    e.b("StreamingManager", stringBuilder.toString());
    switch (a.a[paramc.ordinal()]) {
      default:
        streamingState1 = streamingState2;
        break;
      case 15:
        streamingState1 = StreamingState.INVALID_STREAMING_URL;
        break;
      case 14:
        this.q = true;
        stopStreaming();
        streamingState1 = StreamingState.UNAUTHORIZED_STREAMING_URL;
        break;
      case 13:
        stopStreaming();
        streamingState1 = StreamingState.AUDIO_RECORDING_FAIL;
        break;
      case 12:
        this.q = true;
        stopStreaming();
        streamingState1 = StreamingState.DISCONNECTED;
        break;
      case 11:
        b();
        streamingState1 = streamingState2;
        break;
      case 10:
        streamingState1 = StreamingState.SENDING_BUFFER_HAS_MANY_ITEMS;
        break;
      case 9:
        streamingState1 = StreamingState.SENDING_BUFFER_HAS_FEW_ITEMS;
        break;
      case 8:
        streamingState1 = StreamingState.SENDING_BUFFER_FULL;
        break;
      case 7:
        streamingState1 = StreamingState.SENDING_BUFFER_EMPTY;
        break;
      case 6:
        streamingState1 = StreamingState.IOERROR;
        this.q = true;
        break;
      case 5:
        streamingState1 = StreamingState.SHUTDOWN;
        try {
          this.e.getVideoQualityRank().clear();
        } catch (NullPointerException nullPointerException) {
          e = e.f;
          stringBuilder = new StringBuilder();
          stringBuilder.append("Fail:");
          stringBuilder.append(nullPointerException.getMessage());
          e.d("StreamingManager", stringBuilder.toString());
        } 
        this.p = false;
        if (A())
          return; 
        break;
      case 4:
        streamingState1 = StreamingState.STREAMING;
        break;
      case 3:
        streamingState1 = StreamingState.CONNECTING;
        break;
      case 2:
        this.q = false;
        streamingState1 = StreamingState.PREPARING;
        break;
      case 1:
        streamingState1 = StreamingState.READY;
        return;
    } 
    StreamingStateChangedListener streamingStateChangedListener = this.k;
    if (streamingStateChangedListener != null && !this.p)
      streamingStateChangedListener.onStateChanged(streamingState1, paramObject); 
  }
  
  public void a(boolean paramBoolean) {
    e.f.c("StreamingManager", "stopVideoEncoding");
    if (m())
      return; 
    this.s = paramBoolean;
    f f1 = this.g;
    if (f1 != null)
      f1.b(true); 
  }
  
  public boolean adjustVideoBitrate(int paramInt) {
    if (!s()) {
      e.d.e("StreamingManager", "Dynamic bitrate is not supported!");
      return false;
    } 
    if (this.g != null) {
      StreamingProfile streamingProfile = this.e;
      if (streamingProfile != null && streamingProfile.getVideoProfile() != null) {
        if (!this.e.b(paramInt)) {
          e.d.e("StreamingManager", "invalid bitrate!");
          return false;
        } 
        if (this.e.a()) {
          e.d.e("StreamingManager", "adaptive bitrate is enabled, please disable!");
          return false;
        } 
        if (!this.e.b()) {
          e.d.e("StreamingManager", "adjust bitrate is not enabled, pls call setAdjustBitrateEnable first ");
          return false;
        } 
        this.g.a(paramInt);
        return true;
      } 
    } 
    e.d.e("StreamingManager", "No start streaming!");
    return false;
  }
  
  public final void b() {
    if (s() && this.g != null) {
      StreamingProfile streamingProfile = this.e;
      if (streamingProfile != null && streamingProfile.getVideoProfile() != null && !this.e.e())
        this.g.a((this.e.getVideoProfile()).reqBitrate); 
    } 
  }
  
  public final boolean b(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4) {
    if (paramInt3 % 90 == 0) {
      if (c(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4)) {
        w();
        a(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4);
        y();
        return false;
      } 
      return this.g.f();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Fatal Error. rotation is illegal:");
    stringBuilder.append(paramInt3);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final boolean c() {
    return (this.a && (m() || this.r));
  }
  
  public final boolean c(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4) {
    f.a a1 = this.n;
    return (a1 == null || a1.b * a1.c != paramInt1 * paramInt2 || a1.e != paramInt3 || a1.f != paramInt4);
  }
  
  public void d() {
    e.f.c("StreamingManager", "onEncoderInitDone");
    this.r = true;
  }
  
  public void destroy() {
    b.i();
    e.d.c("StreamingManager", "destroy");
  }
  
  public final StreamingProfile e() {
    StreamingProfile streamingProfile = new StreamingProfile();
    streamingProfile.setEncodingSizeLevel(1).setAudioQuality(20).setSendingBufferProfile(new StreamingProfile.SendingBufferProfile(0.2F, 0.8F, 3.0F, 20000L)).setVideoQuality(10);
    return streamingProfile;
  }
  
  public b f() {
    return this.d;
  }
  
  public void frameAvailable(boolean paramBoolean) {
    if (o()) {
      f f1 = this.g;
      if (f1 != null && this.a)
        f1.c(paramBoolean); 
      return;
    } 
    throw new IllegalStateException("In wrong Encoding Type. Only HW_SCREEN_VIDEO_WITH_HW_AUDIO_CODEC is supported");
  }
  
  public d g() {
    if (this.h == null) {
      d d1 = new d();
      this.h = d1;
      d1.a(this.u);
      this.h.a(null);
    } 
    return this.h;
  }
  
  public Surface getInputSurface(int paramInt1, int paramInt2) {
    if (o()) {
      if (this.g != null && this.a) {
        a(paramInt1, paramInt2, 0, false, PLFourCC.FOURCC_ABGR);
        return this.g.b(this.n);
      } 
      return null;
    } 
    throw new IllegalStateException("In wrong Encoding Type. Only HW_SCREEN_VIDEO_WITH_HW_AUDIO_CODEC is supported");
  }
  
  public boolean h() {
    return this.a;
  }
  
  public final void i() {
    if (p() && !SharedLibraryNameHelper.a(true))
      return; 
    if (t()) {
      e.f.d("StreamingManager", "no need initializeAudio");
      return;
    } 
    if (p()) {
      this.f = (c)new b();
      return;
    } 
    this.f = (c)new d();
  }
  
  public void inputAudioFrame(ByteBuffer paramByteBuffer, int paramInt, long paramLong, boolean paramBoolean) {
    if (this.f != null && c())
      this.f.a(paramByteBuffer, paramInt, paramLong, paramBoolean); 
  }
  
  public void inputAudioFrame(byte[] paramArrayOfbyte, long paramLong, boolean paramBoolean) {
    if (this.f != null && c())
      this.f.a(paramArrayOfbyte, paramLong / 1000L, paramBoolean); 
  }
  
  public void inputVideoFrame(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, long paramLong) {
    if (this.g != null && this.a) {
      this.b.c(true);
      if (b(paramInt2, paramInt3, paramInt4, paramBoolean, paramInt5)) {
        this.g.a(paramBoolean);
        this.g.a(paramByteBuffer, paramInt1, paramLong);
        this.t = paramLong;
      } 
    } 
  }
  
  public void inputVideoFrame(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, long paramLong) {
    inputVideoFrame(ByteBuffer.wrap(paramArrayOfbyte), paramArrayOfbyte.length, paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramLong);
  }
  
  public final void j() {
    if (this.e.getEncodingOrientation() == null) {
      StreamingProfile.ENCODING_ORIENTATION eNCODING_ORIENTATION;
      if (h.c(this.j)) {
        eNCODING_ORIENTATION = StreamingProfile.ENCODING_ORIENTATION.LAND;
      } else {
        eNCODING_ORIENTATION = StreamingProfile.ENCODING_ORIENTATION.PORT;
      } 
      this.e.setEncodingOrientation(eNCODING_ORIENTATION);
    } 
    this.c = a.a.a.a.a.a.e.a.a(this.e.getAudioProfile());
    b b1 = new b(this.j, this);
    this.d = b1;
    b1.a(this.e);
    this.d.a(this.e.getVideoEncodingSize(null));
    this.d.a(this.c);
  }
  
  public final void k() {
    if (m()) {
      b b1 = new b();
      this.b = (c)b1;
      (b1.e()).a = true;
      (this.b.e()).b = false;
    } else if (t()) {
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
    StreamStatusCallback streamStatusCallback = this.m;
    if (streamStatusCallback != null)
      this.b.a(streamStatusCallback); 
  }
  
  public final void l() {
    if (q() && !SharedLibraryNameHelper.c(true))
      return; 
    if (m()) {
      e.f.d("StreamingManager", "no need initializeVideo");
      return;
    } 
    if (u()) {
      this.g = (f)new g();
    } else if (o()) {
      this.g = (f)new c();
    } else {
      d d1 = new d();
      this.g = (f)d1;
      d1.a(this.u);
    } 
    this.g.a(this);
    this.a = this.g.f();
  }
  
  public boolean m() {
    AVCodecType aVCodecType = this.i;
    return (aVCodecType == AVCodecType.HW_AUDIO_CODEC || aVCodecType == AVCodecType.SW_AUDIO_CODEC);
  }
  
  public final boolean n() {
    boolean bool = m();
    boolean bool2 = false;
    boolean bool1 = false;
    null = false;
    if (bool) {
      if (!this.d.l() || SharedLibraryNameHelper.a(true))
        null = true; 
      return null;
    } 
    if (t()) {
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
  
  public final boolean o() {
    AVCodecType aVCodecType = this.i;
    return (aVCodecType == AVCodecType.HW_VIDEO_SURFACE_AS_INPUT_WITH_HW_AUDIO_CODEC || aVCodecType == AVCodecType.HW_VIDEO_SURFACE_AS_INPUT_WITH_SW_AUDIO_CODEC);
  }
  
  public final boolean p() {
    AVCodecType aVCodecType = this.i;
    return (aVCodecType == AVCodecType.SW_VIDEO_WITH_SW_AUDIO_CODEC || aVCodecType == AVCodecType.SW_AUDIO_CODEC || aVCodecType == AVCodecType.HW_VIDEO_SURFACE_AS_INPUT_WITH_SW_AUDIO_CODEC);
  }
  
  public void pause() {
    e.d.c("StreamingManager", "pause +");
    this.o = false;
    stopStreaming();
    this.a = false;
    b.b();
    e.d.c("StreamingManager", "pause -");
  }
  
  public boolean prepare(StreamingProfile paramStreamingProfile) {
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("prepare, profile = ");
    stringBuilder.append(paramStreamingProfile);
    e.c("StreamingManager", stringBuilder.toString());
    if (!this.o) {
      if (paramStreamingProfile != null) {
        this.e = paramStreamingProfile;
        b.a(paramStreamingProfile);
      } else {
        this.e = e();
      } 
      j();
      k();
      l();
      i();
      this.o = true;
      return true;
    } 
    return false;
  }
  
  public final boolean q() {
    AVCodecType aVCodecType = this.i;
    return (aVCodecType == AVCodecType.SW_VIDEO_WITH_HW_AUDIO_CODEC || aVCodecType == AVCodecType.SW_VIDEO_WITH_SW_AUDIO_CODEC || aVCodecType == AVCodecType.SW_VIDEO_CODEC);
  }
  
  public final boolean r() {
    return (SharedLibraryNameHelper.e(true) && n());
  }
  
  public boolean resume() {
    e.d.c("StreamingManager", "resume +");
    b.a(this.j);
    if (this.f == null) {
      e.c.c("StreamingManager", "try to initializeAudio again");
      i();
    } 
    StreamingStateChangedListener streamingStateChangedListener = this.k;
    if (streamingStateChangedListener != null)
      streamingStateChangedListener.onStateChanged(StreamingState.READY, null); 
    e.d.c("StreamingManager", "resume -");
    return true;
  }
  
  public final boolean s() {
    return q() ? true : h.a();
  }
  
  public void sendSEIMessage(String paramString, int paramInt) {
    sendSEIMessage(paramString, paramInt, this.t);
  }
  
  public void sendSEIMessage(String paramString, int paramInt, long paramLong) {
    b.a().a(paramInt);
    b.a().b(0);
    b.a().a(paramString);
    b.a().a(paramLong);
  }
  
  public void setNativeLoggingEnabled(boolean paramBoolean) {
    e.a(paramBoolean);
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
    e.c("StreamingManager", stringBuilder.toString());
    c c1 = this.b;
    if (c1 != null) {
      c1.a(paramStreamStatusCallback);
      return;
    } 
    this.m = paramStreamStatusCallback;
  }
  
  public void setStreamingProfile(StreamingProfile paramStreamingProfile) {
    if (paramStreamingProfile != null) {
      e e = e.d;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("setStreamingProfile profile =");
      stringBuilder1.append(paramStreamingProfile);
      e.c("StreamingManager", stringBuilder1.toString());
      this.e = paramStreamingProfile;
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
    e.c("StreamingManager", stringBuilder.toString());
    this.l = paramStreamingSessionListener;
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
    e.c("StreamingManager", stringBuilder.toString());
    this.k = paramStreamingStateChangedListener;
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
    e.c("StreamingManager", stringBuilder.toString());
    this.u = paramSurfaceTextureCallback2;
    f f1 = this.g;
    if (f1 != null && f1 instanceof d)
      ((d)f1).a(paramSurfaceTextureCallback2); 
    d d1 = this.h;
    if (d1 != null)
      d1.a(paramSurfaceTextureCallback2); 
  }
  
  public boolean startStreaming() {
    b.g();
    if (!b.a().b()) {
      e.d.e("StreamingManager", "Authentication failed!!!");
      StreamingStateChangedListener streamingStateChangedListener = this.k;
      if (streamingStateChangedListener != null)
        streamingStateChangedListener.onStateChanged(StreamingState.UNAUTHORIZED_PACKAGE, null); 
      return false;
    } 
    if (!r())
      return false; 
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("startStreaming mRecordingEnabled=");
    stringBuilder.append(this.a);
    e.c("StreamingManager", stringBuilder.toString());
    return (!this.a && this.d.i()) ? E() : false;
  }
  
  public boolean stopStreaming() {
    if (!r())
      return false; 
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("stopStreaming mRecordingEnabled:");
    stringBuilder.append(this.a);
    stringBuilder.append(",mIsInitialized:");
    stringBuilder.append(this.o);
    e.c("StreamingManager", stringBuilder.toString());
    if (this.a) {
      this.a = false;
      I();
      b.h();
      return true;
    } 
    return false;
  }
  
  public final boolean t() {
    AVCodecType aVCodecType = this.i;
    return (aVCodecType == AVCodecType.SW_VIDEO_CODEC || aVCodecType == AVCodecType.HW_VIDEO_CODEC);
  }
  
  public final boolean u() {
    return (q() || this.i == AVCodecType.HW_VIDEO_YUV_AS_INPUT_WITH_HW_AUDIO_CODEC);
  }
  
  public void updateEncodingType(AVCodecType paramAVCodecType) {
    if (paramAVCodecType != null) {
      e e = e.d;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("updateEncodingType newType = ");
      stringBuilder2.append(paramAVCodecType);
      e.c("StreamingManager", stringBuilder2.toString());
      if (paramAVCodecType != this.i) {
        this.i = paramAVCodecType;
        k();
        l();
        return;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Ignore the same Encoding Type:");
      stringBuilder1.append(paramAVCodecType);
      throw new IllegalArgumentException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Illegal encoding type:");
    stringBuilder.append(paramAVCodecType);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final boolean v() {
    return (this.i == AVCodecType.HW_VIDEO_YUV_AS_INPUT_WITH_HW_AUDIO_CODEC);
  }
  
  public final void w() {
    e e = e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("pauseStreaming thread:");
    stringBuilder.append(Thread.currentThread().getId());
    e.c("StreamingManager", stringBuilder.toString());
    c c1 = this.b;
    if (c1 != null)
      c1.a(true); 
    x();
  }
  
  public final void x() {
    f f1 = this.g;
    if (f1 != null)
      f1.b(false); 
  }
  
  public final void y() {
    e e = e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("resumeStreaming mCurrentTransferSessionCfg:");
    stringBuilder.append(this.n);
    e.c("StreamingManager", stringBuilder.toString());
    z();
    this.b.a(false);
  }
  
  public final void z() {
    f f1 = this.g;
    if (f1 != null)
      f1.a(this.n); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\StreamingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */