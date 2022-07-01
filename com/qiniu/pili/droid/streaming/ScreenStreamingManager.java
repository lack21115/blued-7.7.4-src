package com.qiniu.pili.droid.streaming;

import a.a.a.a.a.a.j.h.b;
import a.a.a.a.a.e.e;
import a.a.a.a.a.g.b;
import a.a.a.a.a.l.a;
import a.a.a.a.a.n.b;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Surface;
import java.nio.ByteBuffer;

public class ScreenStreamingManager implements b.a, a.c, StreamingStateChangedListener {
  public Context a;
  
  public b b;
  
  public StreamingManager c;
  
  public b d;
  
  public StreamingStateChangedListener e;
  
  public StreamingSessionListener f;
  
  public StreamStatusCallback g;
  
  public AudioSourceCallback h;
  
  public ScreenSetting i;
  
  public StreamingProfile j;
  
  public boolean k = false;
  
  public boolean l = false;
  
  public final MicrophoneStreamingSetting a() {
    MicrophoneStreamingSetting microphoneStreamingSetting = new MicrophoneStreamingSetting();
    microphoneStreamingSetting.setBluetoothSCOEnabled(false);
    return microphoneStreamingSetting;
  }
  
  public void a(ByteBuffer paramByteBuffer, int paramInt, long paramLong, boolean paramBoolean) {
    AudioSourceCallback audioSourceCallback = this.h;
    if (audioSourceCallback != null)
      audioSourceCallback.onAudioSourceAvailable(paramByteBuffer, paramInt, paramLong * 1000L, paramBoolean); 
    this.c.inputAudioFrame(paramByteBuffer, paramInt, paramLong, paramBoolean);
  }
  
  public void a(boolean paramBoolean) {
    if (this.l) {
      this.c.frameAvailable(paramBoolean);
      return;
    } 
    e.c.b("ScreenStreamingManager", "onFrameCaptured audio frame not available");
  }
  
  public final boolean a(Surface paramSurface) {
    String str;
    e.c.c("ScreenStreamingManager", "startDataCollection");
    this.l = false;
    a.a().a(this);
    boolean bool = a.a().a(this.a, this.i.getWidth(), this.i.getHeight(), this.i.getDpi(), paramSurface);
    if (bool) {
      b b1 = this.b;
      if (b1 != null) {
        b1.a(this.a);
        return true;
      } 
    } 
    e e = e.c;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("screenCaptureOk ");
    if (bool) {
      str = "true";
    } else {
      str = "false";
    } 
    stringBuilder.append(str);
    stringBuilder.append(", audioManager is ");
    if (this.b != null) {
      str = "exist";
    } else {
      str = "null";
    } 
    stringBuilder.append(str);
    e.d("ScreenStreamingManager", stringBuilder.toString());
    e.c.e("ScreenStreamingManager", "startDataCollection failed");
    return false;
  }
  
  public final ScreenSetting b() {
    DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
    ScreenSetting screenSetting = new ScreenSetting();
    screenSetting.setSize(displayMetrics.widthPixels, displayMetrics.heightPixels);
    screenSetting.setDpi(displayMetrics.densityDpi);
    return screenSetting;
  }
  
  public void b(int paramInt) {
    this.c.B();
  }
  
  public void b(boolean paramBoolean) {
    e e = e.c;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onRequestResult ");
    stringBuilder.append(paramBoolean);
    e.c("ScreenStreamingManager", stringBuilder.toString());
    if (paramBoolean) {
      this.k = true;
      this.e.onStateChanged(StreamingState.READY, null);
      return;
    } 
    this.e.onStateChanged(StreamingState.REQUEST_SCREEN_CAPTURING_FAIL, null);
  }
  
  public final StreamingProfile c() {
    StreamingProfile streamingProfile = new StreamingProfile();
    streamingProfile.setEncodingSizeLevel(1).setAudioQuality(20).setSendingBufferProfile(new StreamingProfile.SendingBufferProfile(0.2F, 0.8F, 3.0F, 20000L)).setVideoQuality(10);
    return streamingProfile;
  }
  
  public void c(boolean paramBoolean) {
    if (!paramBoolean) {
      this.l = true;
      return;
    } 
    e e = e.c;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("notifyFirstAudioFrame MicrophoneOpenFailed:");
    stringBuilder.append(paramBoolean);
    e.c("ScreenStreamingManager", stringBuilder.toString());
  }
  
  public final void d(boolean paramBoolean) {
    e.d.c("ScreenStreamingManager", "stopPictureStreaming +");
    this.c.H();
    this.d.b(paramBoolean);
    e.d.c("ScreenStreamingManager", "stopPictureStreaming -");
  }
  
  public final boolean d() {
    if (this.c == null) {
      e.d.d("ScreenStreamingManager", "toggle picture streaming failed cause not is streaming.");
      return false;
    } 
    if (this.d == null) {
      String str = this.j.getPictureStreamingFilePath();
      int i = this.j.getPictureStreamingResourceId();
      if (str == null && i < 0) {
        e.d.d("ScreenStreamingManager", "toggle picture streaming failed cause no file set.");
        return false;
      } 
      b b1 = new b(this.a, null, this.c.f(), this.c.g());
      this.d = b1;
      if (str != null) {
        b1.a(str);
      } else {
        b1.a(i);
      } 
    } 
    return true;
  }
  
  public void destroy() {
    e.d.c("ScreenStreamingManager", "destroy +");
    h();
    StreamingManager streamingManager = this.c;
    if (streamingManager != null) {
      streamingManager.pause();
      this.c.destroy();
    } 
    this.a = null;
    e.d.c("ScreenStreamingManager", "destroy -");
  }
  
  public final boolean e() {
    b b1 = this.d;
    return (b1 != null && b1.c());
  }
  
  public final void f() {
    e.d.c("ScreenStreamingManager", "startPictureStreaming +");
    this.c.D();
    this.d.a(this.j.getPictureStreamingFps());
    this.d.e();
    e.d.c("ScreenStreamingManager", "startPictureStreaming -");
  }
  
  public final void g() {
    StreamingManager streamingManager = this.c;
    if (streamingManager == null || this.i == null) {
      e.c.d("ScreenStreamingManager", "something is null !!!");
      return;
    } 
    streamingManager.F();
    Surface surface = this.c.getInputSurface(this.i.getWidth(), this.i.getHeight());
    a.a().a(this);
    a.a().a(this.a, this.i.getWidth(), this.i.getHeight(), this.i.getDpi(), surface);
  }
  
  public final void h() {
    e.c.c("ScreenStreamingManager", "stopDataCollection");
    a.a().b();
    b b1 = this.b;
    if (b1 != null) {
      b1.b(this.a);
      return;
    } 
    e.c.d("ScreenStreamingManager", "AudioManager is null !!!");
  }
  
  public final void i() {
    if (this.c == null) {
      e.c.d("ScreenStreamingManager", "no streaming.");
      return;
    } 
    a.a().b();
    this.c.a(true);
  }
  
  public void mute(boolean paramBoolean) {
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mute ");
    stringBuilder.append(paramBoolean);
    e.c("ScreenStreamingManager", stringBuilder.toString());
    b b1 = this.b;
    if (b1 != null) {
      b1.a(paramBoolean);
      return;
    } 
    e.d.e("ScreenStreamingManager", "mute opreation only can be used after prepare");
  }
  
  public void onStateChanged(StreamingState paramStreamingState, Object paramObject) {
    if (paramStreamingState == StreamingState.READY)
      return; 
    if (paramStreamingState == StreamingState.DISCONNECTED || paramStreamingState == StreamingState.UNAUTHORIZED_STREAMING_URL)
      h(); 
    StreamingStateChangedListener streamingStateChangedListener = this.e;
    if (streamingStateChangedListener != null) {
      streamingStateChangedListener.onStateChanged(paramStreamingState, paramObject);
      e e = e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onStateChanged state=");
      stringBuilder.append(paramStreamingState);
      stringBuilder.append(", extra=");
      stringBuilder.append(paramObject);
      e.b("ScreenStreamingManager", stringBuilder.toString());
    } 
  }
  
  public boolean prepare(Context paramContext, ScreenSetting paramScreenSetting, MicrophoneStreamingSetting paramMicrophoneStreamingSetting, StreamingProfile paramStreamingProfile) {
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("prepare, screenSetting = ");
    stringBuilder.append(paramScreenSetting);
    stringBuilder.append(", microphoneSetting = ");
    stringBuilder.append(paramMicrophoneStreamingSetting);
    stringBuilder.append(", profile = ");
    stringBuilder.append(paramStreamingProfile);
    e.c("ScreenStreamingManager", stringBuilder.toString());
    StreamingEnv.a();
    if (this.k)
      return false; 
    if (paramContext == null)
      e.d.e("ScreenStreamingManager", "context cannot be null."); 
    this.a = paramContext.getApplicationContext();
    if (paramScreenSetting == null) {
      this.i = b();
    } else {
      this.i = paramScreenSetting;
    } 
    StreamingProfile streamingProfile = paramStreamingProfile;
    if (paramStreamingProfile == null)
      streamingProfile = c(); 
    MicrophoneStreamingSetting microphoneStreamingSetting = paramMicrophoneStreamingSetting;
    if (paramMicrophoneStreamingSetting == null)
      microphoneStreamingSetting = a(); 
    StreamingManager streamingManager = new StreamingManager(this.a, AVCodecType.HW_VIDEO_SURFACE_AS_INPUT_WITH_SW_AUDIO_CODEC);
    this.c = streamingManager;
    streamingManager.prepare(streamingProfile);
    this.c.setStreamingStateListener(this);
    StreamingSessionListener streamingSessionListener = this.f;
    if (streamingSessionListener != null)
      this.c.setStreamingSessionListener(streamingSessionListener); 
    StreamStatusCallback streamStatusCallback = this.g;
    if (streamStatusCallback != null)
      this.c.setStreamStatusCallback(streamStatusCallback); 
    this.b = new b(microphoneStreamingSetting, this);
    this.j = streamingProfile;
    a.a().a(this.a, this);
    return true;
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
    e.c("ScreenStreamingManager", stringBuilder.toString());
    this.h = paramAudioSourceCallback;
  }
  
  public void setNativeLoggingEnabled(boolean paramBoolean) {
    e.a(paramBoolean);
  }
  
  public void setPictureStreamingFilePath(String paramString) {
    StreamingProfile streamingProfile = this.j;
    if (streamingProfile == null) {
      e.d.d("ScreenStreamingManager", "StreamingProfile is null !!!");
      return;
    } 
    streamingProfile.setPictureStreamingFilePath(paramString);
    if (e())
      this.d.a(paramString); 
  }
  
  public void setPictureStreamingResourceId(int paramInt) {
    StreamingProfile streamingProfile = this.j;
    if (streamingProfile == null) {
      e.d.d("ScreenStreamingManager", "StreamingProfile is null !!!");
      return;
    } 
    streamingProfile.setPictureStreamingResourceId(paramInt);
    if (e())
      this.d.a(paramInt); 
  }
  
  public final void setScreenCaptureSessionListener(ScreenCaptureSessionListener paramScreenCaptureSessionListener) {
    a.a().a(paramScreenCaptureSessionListener);
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
    e.c("ScreenStreamingManager", stringBuilder.toString());
    if (paramStreamStatusCallback != null) {
      this.g = paramStreamStatusCallback;
      return;
    } 
    throw new IllegalArgumentException("StreamStatusCallback is null");
  }
  
  public void setStreamingProfile(StreamingProfile paramStreamingProfile) {
    e e = e.d;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("setStreamingProfile ");
    stringBuilder2.append(paramStreamingProfile);
    e.c("ScreenStreamingManager", stringBuilder2.toString());
    if (paramStreamingProfile != null) {
      this.c.setStreamingProfile(paramStreamingProfile);
      return;
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("Illegal profile:");
    stringBuilder1.append(paramStreamingProfile);
    throw new IllegalArgumentException(stringBuilder1.toString());
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
    e.c("ScreenStreamingManager", stringBuilder.toString());
    if (paramStreamingSessionListener != null) {
      this.f = paramStreamingSessionListener;
      return;
    } 
    throw new IllegalArgumentException("Error!!! listener cannot be null");
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
    e.c("ScreenStreamingManager", stringBuilder.toString());
    if (paramStreamingStateChangedListener != null) {
      this.e = paramStreamingStateChangedListener;
      return;
    } 
    throw new IllegalArgumentException("Error!!! listener cannot be null");
  }
  
  public boolean startStreaming() {
    e.d.c("ScreenStreamingManager", "startStreaming +");
    boolean bool1 = b.a().b();
    boolean bool = false;
    if (!bool1) {
      e.d.e("ScreenStreamingManager", "Authentication failed!!!");
      StreamingStateChangedListener streamingStateChangedListener = this.e;
      if (streamingStateChangedListener != null)
        streamingStateChangedListener.onStateChanged(StreamingState.UNAUTHORIZED_PACKAGE, null); 
      return false;
    } 
    if (this.c.startStreaming()) {
      Surface surface = this.c.getInputSurface(this.i.getWidth(), this.i.getHeight());
      if (surface != null && a(surface)) {
        e.d.c("ScreenStreamingManager", "startStreaming success");
        bool = true;
      } else {
        String str;
        e e = e.d;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("inputSurface ");
        stringBuilder.append(surface);
        if (stringBuilder.toString() == null) {
          str = "is null";
        } else {
          stringBuilder = new StringBuilder();
          stringBuilder.append("exist, startDataCollection ");
          if (a((Surface)str)) {
            str = "success";
          } else {
            str = "failed";
          } 
          stringBuilder.append(str);
          str = stringBuilder.toString();
        } 
        e.d("ScreenStreamingManager", str);
        this.c.stopStreaming();
      } 
    } else {
      e.d.e("ScreenStreamingManager", "startStreaming failed");
    } 
    e.d.c("ScreenStreamingManager", "startStreaming -");
    return bool;
  }
  
  public boolean stopStreaming() {
    e.d.c("ScreenStreamingManager", "stopStreaming +");
    h();
    if (e())
      d(false); 
    StreamingManager streamingManager = this.c;
    if (streamingManager != null)
      return streamingManager.stopStreaming(); 
    e.d.c("ScreenStreamingManager", "stopStreaming -");
    return false;
  }
  
  public boolean togglePictureStreaming() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Lcom/qiniu/pili/droid/streaming/StreamingManager;
    //   6: ifnonnull -> 24
    //   9: getstatic a/a/a/a/a/e/e.d : La/a/a/a/a/e/e;
    //   12: ldc 'ScreenStreamingManager'
    //   14: ldc_w 'no streaming.'
    //   17: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_0
    //   21: monitorexit
    //   22: iconst_0
    //   23: ireturn
    //   24: aload_0
    //   25: invokevirtual d : ()Z
    //   28: istore_1
    //   29: iload_1
    //   30: ifne -> 37
    //   33: aload_0
    //   34: monitorexit
    //   35: iconst_0
    //   36: ireturn
    //   37: aload_0
    //   38: getfield k : Z
    //   41: ifeq -> 91
    //   44: aload_0
    //   45: getfield c : Lcom/qiniu/pili/droid/streaming/StreamingManager;
    //   48: invokevirtual h : ()Z
    //   51: ifeq -> 91
    //   54: aload_0
    //   55: getfield d : La/a/a/a/a/a/j/h/b;
    //   58: invokevirtual c : ()Z
    //   61: ifeq -> 76
    //   64: aload_0
    //   65: iconst_0
    //   66: invokevirtual d : (Z)V
    //   69: aload_0
    //   70: invokevirtual g : ()V
    //   73: goto -> 87
    //   76: aload_0
    //   77: invokevirtual i : ()V
    //   80: aload_0
    //   81: invokevirtual f : ()V
    //   84: invokestatic n : ()V
    //   87: aload_0
    //   88: monitorexit
    //   89: iconst_1
    //   90: ireturn
    //   91: getstatic a/a/a/a/a/e/e.d : La/a/a/a/a/e/e;
    //   94: ldc 'ScreenStreamingManager'
    //   96: ldc_w 'toggle picture streaming failed cause in invalid state'
    //   99: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload_0
    //   103: monitorexit
    //   104: iconst_0
    //   105: ireturn
    //   106: astore_2
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_2
    //   110: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	106	finally
    //   24	29	106	finally
    //   37	73	106	finally
    //   76	87	106	finally
    //   91	102	106	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\ScreenStreamingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */