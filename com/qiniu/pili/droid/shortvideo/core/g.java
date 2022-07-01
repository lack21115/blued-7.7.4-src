package com.qiniu.pili.droid.shortvideo.core;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLAudioFrameListener;
import com.qiniu.pili.droid.shortvideo.PLMicrophoneSetting;
import com.qiniu.pili.droid.shortvideo.PLScreenRecordStateListener;
import com.qiniu.pili.droid.shortvideo.PLScreenRecorderSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.a.b.a;
import com.qiniu.pili.droid.shortvideo.a.c.a;
import com.qiniu.pili.droid.shortvideo.encode.a;
import com.qiniu.pili.droid.shortvideo.encode.c;
import com.qiniu.pili.droid.shortvideo.encode.e;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.muxer.b;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public final class g implements PLAudioFrameListener {
  private MediaProjectionManager a;
  
  private e b;
  
  private a c;
  
  private long d;
  
  private int e = -1;
  
  private a f;
  
  private c g;
  
  private int h = -1;
  
  private b i;
  
  private MediaFormat j;
  
  private MediaFormat k;
  
  private volatile boolean l;
  
  private PLScreenRecorderSetting m;
  
  private PLScreenRecordStateListener n;
  
  private PLAudioFrameListener o;
  
  private volatile boolean p;
  
  private volatile boolean q;
  
  private volatile boolean r;
  
  private volatile boolean s;
  
  private AtomicBoolean t = new AtomicBoolean(false);
  
  private boolean u;
  
  private Activity v;
  
  private a.a w = new a.a(this) {
      public void a(MediaFormat param1MediaFormat) {
        e e = e.n;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("got video format:");
        stringBuilder.append(param1MediaFormat.toString());
        e.c("ScreenRecorderCore", stringBuilder.toString());
        g.a(this.a, param1MediaFormat);
        g.b(this.a, true);
        g.d(this.a);
      }
      
      public void a(Surface param1Surface) {
        g.c(this.a).a(param1Surface);
      }
      
      public void a(ByteBuffer param1ByteBuffer, MediaCodec.BufferInfo param1BufferInfo) {
        if (g.e(this.a) && g.f(this.a) >= 0 && !g.g(this.a).get()) {
          e e = e.h;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("video encoded frame size:");
          stringBuilder.append(param1BufferInfo.size);
          stringBuilder.append(" ts:");
          stringBuilder.append(param1BufferInfo.presentationTimeUs);
          e.b("ScreenRecorderCore", stringBuilder.toString());
          if (g.h(this.a) == 0L)
            g.a(this.a, param1BufferInfo.presentationTimeUs); 
          param1BufferInfo.presentationTimeUs -= g.h(this.a);
          g.i(this.a).a(g.f(this.a), param1ByteBuffer, param1BufferInfo);
        } 
      }
      
      public void a(boolean param1Boolean) {
        e e = e.h;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("video encoder started: ");
        stringBuilder.append(param1Boolean);
        e.c("ScreenRecorderCore", stringBuilder.toString());
        g.a(this.a, param1Boolean);
        if (!param1Boolean && g.a(this.a) != null) {
          this.a.c();
          g.a(this.a).onError(6);
          QosManager.a().a(6);
        } 
      }
      
      public void b(boolean param1Boolean) {
        e.h.c("ScreenRecorderCore", "video encoder stopped.");
        g.a(this.a, false);
        g.b(this.a, false);
        g.b(this.a);
      }
    };
  
  private a.a x = new a.a(this) {
      public void a(MediaFormat param1MediaFormat) {
        e e = e.n;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("got audio format:");
        stringBuilder.append(param1MediaFormat.toString());
        e.c("ScreenRecorderCore", stringBuilder.toString());
        g.b(this.a, param1MediaFormat);
        g.d(this.a, true);
        g.d(this.a);
      }
      
      public void a(Surface param1Surface) {}
      
      public void a(ByteBuffer param1ByteBuffer, MediaCodec.BufferInfo param1BufferInfo) {
        if (g.e(this.a) && g.j(this.a) >= 0 && !g.g(this.a).get()) {
          e e = e.h;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("audio encoded frame size:");
          stringBuilder.append(param1BufferInfo.size);
          stringBuilder.append(" ts:");
          stringBuilder.append(param1BufferInfo.presentationTimeUs);
          e.b("ScreenRecorderCore", stringBuilder.toString());
          g.i(this.a).a(g.j(this.a), param1ByteBuffer, param1BufferInfo);
        } 
      }
      
      public void a(boolean param1Boolean) {
        e e = e.h;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("audio encoder started: ");
        stringBuilder.append(param1Boolean);
        e.c("ScreenRecorderCore", stringBuilder.toString());
        g.c(this.a, param1Boolean);
        if (!param1Boolean && g.a(this.a) != null) {
          this.a.c();
          g.a(this.a).onError(7);
          QosManager.a().a(7);
        } 
      }
      
      public void b(boolean param1Boolean) {
        e.h.c("ScreenRecorderCore", "audio encoder stopped.");
        g.c(this.a, false);
        g.d(this.a, false);
        g.b(this.a);
      }
    };
  
  public g(Activity paramActivity) {
    e.e.c("ScreenRecorderCore", "init +");
    this.v = paramActivity;
    l.a(this.v.getApplicationContext());
    e.e.c("ScreenRecorderCore", "init -");
  }
  
  private boolean a(String paramString) {
    if (paramString == null || !paramString.endsWith(".mp4")) {
      e.c.e("ScreenRecorderCore", "set mp4 file failed!");
      return false;
    } 
    File file = (new File(paramString)).getParentFile();
    if (!file.exists() && !file.mkdir()) {
      e e1 = e.c;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("failed to mkdir: ");
      stringBuilder.append(file.getAbsolutePath());
      e1.e("ScreenRecorderCore", stringBuilder.toString());
      return false;
    } 
    return true;
  }
  
  private boolean f() {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    if (i < 21) {
      PLScreenRecordStateListener pLScreenRecordStateListener = this.n;
      if (pLScreenRecordStateListener != null) {
        pLScreenRecordStateListener.onError(9);
        QosManager.a().a(9);
      } 
      e.c.e("ScreenRecorderCore", "failed to requestScreenRecord, Android version < LOLLIPOP !");
      return false;
    } 
    if (!this.u || this.v == null) {
      PLScreenRecordStateListener pLScreenRecordStateListener = this.n;
      if (pLScreenRecordStateListener != null) {
        pLScreenRecordStateListener.onError(1);
        QosManager.a().a(1);
      } 
      e.c.e("ScreenRecorderCore", "please invoke prepare() first!");
    } 
    boolean bool1 = bool2;
    if (this.u) {
      bool1 = bool2;
      if (this.v != null)
        bool1 = true; 
    } 
    return bool1;
  }
  
  private void g() {
    c c1 = this.g;
    if (c1 != null)
      c1.a(); 
    e e1 = this.b;
    if (e1 != null)
      e1.a(); 
  }
  
  private void h() {
    if (this.b != null) {
      e.h.c("ScreenRecorderCore", "stop video encoder +");
      this.b.c();
    } 
    if (this.g != null) {
      e.h.c("ScreenRecorderCore", "stop audio encoder +");
      this.g.c();
    } 
    e.h.c("ScreenRecorderCore", "stop encoder -");
  }
  
  private void i() {
    if (this.c != null) {
      e.f.c("ScreenRecorderCore", "stop screen record +");
      this.c.a();
    } 
    if (this.f != null) {
      e.f.c("ScreenRecorderCore", "stop audio record +");
      this.f.b();
    } 
    e.f.c("ScreenRecorderCore", "stop record -");
  }
  
  private boolean j() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield p : Z
    //   6: ifeq -> 121
    //   9: aload_0
    //   10: getfield g : Lcom/qiniu/pili/droid/shortvideo/encode/c;
    //   13: ifnull -> 23
    //   16: aload_0
    //   17: getfield q : Z
    //   20: ifeq -> 121
    //   23: aload_0
    //   24: getfield l : Z
    //   27: ifeq -> 33
    //   30: goto -> 121
    //   33: aload_0
    //   34: getfield i : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   37: aload_0
    //   38: getfield m : Lcom/qiniu/pili/droid/shortvideo/PLScreenRecorderSetting;
    //   41: invokevirtual getRecordFile : ()Ljava/lang/String;
    //   44: aload_0
    //   45: getfield j : Landroid/media/MediaFormat;
    //   48: aload_0
    //   49: getfield k : Landroid/media/MediaFormat;
    //   52: invokevirtual a : (Ljava/lang/String;Landroid/media/MediaFormat;Landroid/media/MediaFormat;)Z
    //   55: pop
    //   56: aload_0
    //   57: aload_0
    //   58: getfield i : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   61: invokevirtual b : ()I
    //   64: putfield e : I
    //   67: aload_0
    //   68: getfield g : Lcom/qiniu/pili/droid/shortvideo/encode/c;
    //   71: ifnull -> 85
    //   74: aload_0
    //   75: aload_0
    //   76: getfield i : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   79: invokevirtual c : ()I
    //   82: putfield h : I
    //   85: aload_0
    //   86: iconst_1
    //   87: putfield l : Z
    //   90: aload_0
    //   91: getfield n : Lcom/qiniu/pili/droid/shortvideo/PLScreenRecordStateListener;
    //   94: ifnull -> 106
    //   97: aload_0
    //   98: getfield n : Lcom/qiniu/pili/droid/shortvideo/PLScreenRecordStateListener;
    //   101: invokeinterface onRecordStarted : ()V
    //   106: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   109: ldc 'ScreenRecorderCore'
    //   111: ldc_w 'start muxer success'
    //   114: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload_0
    //   118: monitorexit
    //   119: iconst_1
    //   120: ireturn
    //   121: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   124: ldc 'ScreenRecorderCore'
    //   126: ldc_w 'start muxer failed'
    //   129: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload_0
    //   133: monitorexit
    //   134: iconst_0
    //   135: ireturn
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_1
    //   140: athrow
    // Exception table:
    //   from	to	target	type
    //   2	23	136	finally
    //   23	30	136	finally
    //   33	85	136	finally
    //   85	106	136	finally
    //   106	117	136	finally
    //   121	132	136	finally
  }
  
  private void k() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield p : Z
    //   6: ifne -> 120
    //   9: aload_0
    //   10: getfield r : Z
    //   13: ifne -> 120
    //   16: aload_0
    //   17: getfield q : Z
    //   20: ifne -> 120
    //   23: aload_0
    //   24: getfield s : Z
    //   27: ifne -> 120
    //   30: aload_0
    //   31: getfield l : Z
    //   34: ifne -> 40
    //   37: goto -> 120
    //   40: aload_0
    //   41: iconst_0
    //   42: putfield l : Z
    //   45: aload_0
    //   46: getfield i : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   49: invokevirtual a : ()Z
    //   52: pop
    //   53: aload_0
    //   54: getfield n : Lcom/qiniu/pili/droid/shortvideo/PLScreenRecordStateListener;
    //   57: ifnull -> 106
    //   60: aload_0
    //   61: getfield n : Lcom/qiniu/pili/droid/shortvideo/PLScreenRecordStateListener;
    //   64: invokeinterface onRecordStopped : ()V
    //   69: goto -> 106
    //   72: astore_1
    //   73: aload_0
    //   74: getfield n : Lcom/qiniu/pili/droid/shortvideo/PLScreenRecordStateListener;
    //   77: ifnull -> 97
    //   80: aload_0
    //   81: getfield n : Lcom/qiniu/pili/droid/shortvideo/PLScreenRecordStateListener;
    //   84: iconst_3
    //   85: invokeinterface onError : (I)V
    //   90: invokestatic a : ()Lcom/qiniu/pili/droid/shortvideo/core/QosManager;
    //   93: iconst_3
    //   94: invokevirtual a : (I)V
    //   97: aload_0
    //   98: aconst_null
    //   99: putfield i : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   102: aload_1
    //   103: invokevirtual printStackTrace : ()V
    //   106: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   109: ldc 'ScreenRecorderCore'
    //   111: ldc_w 'muxer stop!'
    //   114: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload_0
    //   118: monitorexit
    //   119: return
    //   120: aload_0
    //   121: monitorexit
    //   122: return
    //   123: astore_1
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    // Exception table:
    //   from	to	target	type
    //   2	37	123	finally
    //   40	45	123	finally
    //   45	69	72	java/lang/IllegalStateException
    //   45	69	123	finally
    //   73	97	123	finally
    //   97	106	123	finally
    //   106	117	123	finally
  }
  
  public void a() {
    e.c.c("ScreenRecorderCore", "requestScreenRecord +");
    if (!f())
      return; 
    this.a = (MediaProjectionManager)this.v.getSystemService("media_projection");
    Intent intent = this.a.createScreenCaptureIntent();
    this.v.startActivityForResult(intent, 2008);
    a a1 = this.f;
    if (a1 != null && !a1.a()) {
      PLScreenRecordStateListener pLScreenRecordStateListener = this.n;
      if (pLScreenRecordStateListener != null) {
        pLScreenRecordStateListener.onError(5);
        QosManager.a().a(5);
      } 
      e.f.e("ScreenRecorderCore", "Error: setup microphone failed");
      return;
    } 
    e.c.c("ScreenRecorderCore", "requestScreenRecord -");
  }
  
  public void a(PLAudioFrameListener paramPLAudioFrameListener) {
    this.o = paramPLAudioFrameListener;
  }
  
  public void a(PLScreenRecordStateListener paramPLScreenRecordStateListener) {
    this.n = paramPLScreenRecordStateListener;
  }
  
  public void a(byte[] paramArrayOfbyte, long paramLong) {
    if (f() && this.m.isInputAudioEnabled())
      onAudioFrameAvailable(paramArrayOfbyte, paramLong); 
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent) {
    e.c.c("ScreenRecorderCore", "onActivityResult +");
    if (!f())
      return false; 
    if (paramInt1 != 2008 || paramIntent == null) {
      e.f.e("ScreenRecorderCore", "param error, screen recorder init failed!");
      return false;
    } 
    MediaProjection mediaProjection = this.a.getMediaProjection(paramInt2, paramIntent);
    if (mediaProjection == null) {
      e.f.e("ScreenRecorderCore", "something is wrong, screen recorder init failed!");
      return false;
    } 
    PLScreenRecorderSetting pLScreenRecorderSetting = this.m;
    if (pLScreenRecorderSetting == null) {
      e.f.e("ScreenRecorderCore", "please invoke prepare interface first!");
      return false;
    } 
    this.c = new a(pLScreenRecorderSetting.getWidth(), this.m.getHeight(), this.m.getDpi(), mediaProjection);
    PLScreenRecordStateListener pLScreenRecordStateListener = this.n;
    if (pLScreenRecordStateListener != null)
      pLScreenRecordStateListener.onReady(); 
    e.c.c("ScreenRecorderCore", "onActivityResult -");
    return true;
  }
  
  public boolean a(PLScreenRecorderSetting paramPLScreenRecorderSetting, PLMicrophoneSetting paramPLMicrophoneSetting) {
    e.c.c("ScreenRecorderCore", "prepare +");
    if (paramPLScreenRecorderSetting == null || !a(paramPLScreenRecorderSetting.getRecordFile())) {
      e.c.e("ScreenRecorderCore", "Error: something is null!");
      return false;
    } 
    this.m = paramPLScreenRecorderSetting;
    e e1 = e.c;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("prepare, screenSetting = ");
    stringBuilder.append(paramPLScreenRecorderSetting);
    e1.c("ScreenRecorderCore", stringBuilder.toString());
    PLVideoEncodeSetting pLVideoEncodeSetting = new PLVideoEncodeSetting(this.v.getApplicationContext());
    pLVideoEncodeSetting.setEncodingBitrate(paramPLScreenRecorderSetting.getEncodingBitrate());
    pLVideoEncodeSetting.setPreferredEncodingSize(this.m.getWidth(), this.m.getHeight());
    this.b = new e(pLVideoEncodeSetting);
    this.b.a(this.w);
    if (paramPLMicrophoneSetting != null) {
      byte b1;
      PLAudioEncodeSetting pLAudioEncodeSetting = new PLAudioEncodeSetting();
      pLAudioEncodeSetting.setSampleRate(paramPLMicrophoneSetting.getSampleRate());
      if (paramPLMicrophoneSetting.getChannelConfig() == 16) {
        b1 = 1;
      } else {
        b1 = 2;
      } 
      pLAudioEncodeSetting.setChannels(b1);
      this.g = new c(pLAudioEncodeSetting);
      this.g.a(this.x);
      if (!paramPLScreenRecorderSetting.isInputAudioEnabled()) {
        paramPLMicrophoneSetting.setPtsOptimizeEnabled(false);
        this.f = new a(paramPLMicrophoneSetting);
        this.f.a(this);
      } 
    } 
    this.u = true;
    e.c.c("ScreenRecorderCore", "prepare -");
    return true;
  }
  
  public void b() {
    e.c.c("ScreenRecorderCore", "start +");
    if (!u.a().a(b.a.w)) {
      QosManager.a().a(8);
      PLScreenRecordStateListener pLScreenRecordStateListener = this.n;
      if (pLScreenRecordStateListener != null)
        pLScreenRecordStateListener.onError(8); 
      return;
    } 
    if (!f())
      return; 
    this.t.set(false);
    this.d = 0L;
    g();
    this.i = new b();
    e.c.c("ScreenRecorderCore", "start -");
  }
  
  public void c() {
    e.c.c("ScreenRecorderCore", "stop +");
    this.t.set(true);
    this.p = false;
    this.q = false;
    this.r = false;
    this.s = false;
    i();
    h();
    e.c.c("ScreenRecorderCore", "stop -");
  }
  
  public boolean d() {
    return this.l;
  }
  
  public JSONObject e() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("operation_record_screen", 1);
      jSONObject.put("data_type", QosManager.a.c);
      return jSONObject;
    } catch (JSONException jSONException) {
      return null;
    } 
  }
  
  public void onAudioFrameAvailable(byte[] paramArrayOfbyte, long paramLong) {
    if (this.q) {
      ByteBuffer byteBuffer = ByteBuffer.wrap(paramArrayOfbyte);
      e e1 = e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("audio frame captured size:");
      stringBuilder.append(paramArrayOfbyte.length);
      stringBuilder.append(" ts:");
      stringBuilder.append(paramLong);
      e1.b("ScreenRecorderCore", stringBuilder.toString());
      this.g.a(byteBuffer, paramArrayOfbyte.length, paramLong / 1000L);
    } 
  }
  
  public void onAudioRecordFailed(int paramInt) {
    PLAudioFrameListener pLAudioFrameListener = this.o;
    if (pLAudioFrameListener != null)
      pLAudioFrameListener.onAudioRecordFailed(paramInt); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\core\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */