package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLExternalRecordStateListener;
import com.qiniu.pili.droid.shortvideo.PLRecordSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.encode.SWVideoEncoder;
import com.qiniu.pili.droid.shortvideo.encode.a;
import com.qiniu.pili.droid.shortvideo.encode.c;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.muxer.b;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
  private SWVideoEncoder a;
  
  private long b;
  
  private c c;
  
  private long d;
  
  private b e;
  
  private MediaFormat f;
  
  private MediaFormat g;
  
  private volatile boolean h;
  
  private PLRecordSetting i;
  
  private PLExternalRecordStateListener j;
  
  private volatile boolean k;
  
  private volatile boolean l;
  
  private volatile boolean m;
  
  private volatile boolean n;
  
  private AtomicBoolean o = new AtomicBoolean(false);
  
  private boolean p;
  
  private Context q;
  
  private a.a r = new a.a(this) {
      public void a(MediaFormat param1MediaFormat) {
        e e = e.h;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("got video format:");
        stringBuilder.append(param1MediaFormat.toString());
        e.b("ExternalMediaRecorderCore", stringBuilder.toString());
        d.a(this.a, param1MediaFormat);
        d.b(this.a, true);
        d.c(this.a);
      }
      
      public void a(Surface param1Surface) {}
      
      public void a(ByteBuffer param1ByteBuffer, MediaCodec.BufferInfo param1BufferInfo) {
        if (d.d(this.a) && d.e(this.a).b() >= 0 && !d.f(this.a).get()) {
          e e = e.h;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("video encoded frame size:");
          stringBuilder.append(param1BufferInfo.size);
          stringBuilder.append(" ts:");
          stringBuilder.append(param1BufferInfo.presentationTimeUs);
          e.b("ExternalMediaRecorderCore", stringBuilder.toString());
          if (d.g(this.a) == 0L)
            d.a(this.a, param1BufferInfo.presentationTimeUs); 
          param1BufferInfo.presentationTimeUs -= d.g(this.a);
          d.e(this.a).a(param1ByteBuffer, param1BufferInfo);
        } 
      }
      
      public void a(boolean param1Boolean) {
        e e = e.h;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("video encoder started: ");
        stringBuilder.append(param1Boolean);
        e.c("ExternalMediaRecorderCore", stringBuilder.toString());
        d.a(this.a, param1Boolean);
        if (!param1Boolean && d.a(this.a) != null) {
          this.a.b();
          d.a(this.a).onError(6);
          QosManager.a().a(6);
        } 
      }
      
      public void b(boolean param1Boolean) {
        e.h.c("ExternalMediaRecorderCore", "video encoder stopped.");
        d.a(this.a, false);
        d.b(this.a, false);
        d.b(this.a);
      }
    };
  
  private a.a s = new a.a(this) {
      public void a(MediaFormat param1MediaFormat) {
        e e = e.n;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("got audio format:");
        stringBuilder.append(param1MediaFormat.toString());
        e.c("ExternalMediaRecorderCore", stringBuilder.toString());
        d.b(this.a, param1MediaFormat);
        d.d(this.a, true);
        d.c(this.a);
      }
      
      public void a(Surface param1Surface) {}
      
      public void a(ByteBuffer param1ByteBuffer, MediaCodec.BufferInfo param1BufferInfo) {
        if (d.d(this.a) && d.e(this.a).c() >= 0 && !d.f(this.a).get()) {
          e e = e.h;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("audio encoded frame size:");
          stringBuilder.append(param1BufferInfo.size);
          stringBuilder.append(" ts:");
          stringBuilder.append(param1BufferInfo.presentationTimeUs);
          e.b("ExternalMediaRecorderCore", stringBuilder.toString());
          if (d.h(this.a) == 0L)
            d.b(this.a, param1BufferInfo.presentationTimeUs); 
          param1BufferInfo.presentationTimeUs -= d.h(this.a);
          d.e(this.a).b(param1ByteBuffer, param1BufferInfo);
        } 
      }
      
      public void a(boolean param1Boolean) {
        e e = e.h;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("audio encoder started: ");
        stringBuilder.append(param1Boolean);
        e.c("ExternalMediaRecorderCore", stringBuilder.toString());
        d.c(this.a, param1Boolean);
        if (!param1Boolean && d.a(this.a) != null) {
          this.a.b();
          d.a(this.a).onError(7);
          QosManager.a().a(7);
        } 
      }
      
      public void b(boolean param1Boolean) {
        e.h.c("ExternalMediaRecorderCore", "audio encoder stopped.");
        d.c(this.a, false);
        d.d(this.a, false);
        d.b(this.a);
      }
    };
  
  public d(Context paramContext) {
    e.d.c("ExternalMediaRecorderCore", "init +");
    this.q = paramContext;
    l.a(this.q);
    e.d.c("ExternalMediaRecorderCore", "init -");
  }
  
  private boolean a(b.a parama) {
    if (!u.a().a(parama)) {
      PLExternalRecordStateListener pLExternalRecordStateListener = this.j;
      if (pLExternalRecordStateListener != null)
        pLExternalRecordStateListener.onError(8); 
      QosManager.a().a(8);
      return false;
    } 
    return true;
  }
  
  private boolean a(String paramString) {
    if (paramString == null) {
      e.d.e("ExternalMediaRecorderCore", "set file failed!");
      return false;
    } 
    File file = (new File(paramString)).getParentFile();
    if (!file.exists() && !file.mkdir()) {
      e e = e.d;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("failed to mkdir: ");
      stringBuilder.append(file.getAbsolutePath());
      e.e("ExternalMediaRecorderCore", stringBuilder.toString());
      return false;
    } 
    return true;
  }
  
  private boolean e() {
    if (!this.p || this.q == null) {
      PLExternalRecordStateListener pLExternalRecordStateListener = this.j;
      if (pLExternalRecordStateListener != null) {
        pLExternalRecordStateListener.onError(1);
        QosManager.a().a(1);
      } 
      e.d.e("ExternalMediaRecorderCore", "please invoke prepare() first!");
    } 
    return (this.p && this.q != null);
  }
  
  private void f() {
    if (this.c != null) {
      e.h.c("ExternalMediaRecorderCore", "start audio encoder +");
      this.c.a();
    } 
    if (this.a != null) {
      e.h.c("ExternalMediaRecorderCore", "start video encoder +");
      this.a.a();
    } 
    e.h.c("ExternalMediaRecorderCore", "start encoder -");
  }
  
  private void g() {
    if (this.c != null) {
      e.h.c("ExternalMediaRecorderCore", "stop audio encoder +");
      this.c.c();
    } 
    if (this.a != null) {
      e.h.c("ExternalMediaRecorderCore", "stop video encoder +");
      this.a.c();
    } 
    e.h.c("ExternalMediaRecorderCore", "stop encoder -");
  }
  
  private boolean h() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield m : Z
    //   6: ifeq -> 131
    //   9: aload_0
    //   10: getfield n : Z
    //   13: ifeq -> 131
    //   16: aload_0
    //   17: getfield h : Z
    //   20: istore_1
    //   21: iload_1
    //   22: ifeq -> 28
    //   25: goto -> 131
    //   28: aload_0
    //   29: getfield e : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   32: aload_0
    //   33: getfield i : Lcom/qiniu/pili/droid/shortvideo/PLRecordSetting;
    //   36: invokevirtual getVideoFilepath : ()Ljava/lang/String;
    //   39: aload_0
    //   40: getfield f : Landroid/media/MediaFormat;
    //   43: aload_0
    //   44: getfield g : Landroid/media/MediaFormat;
    //   47: invokevirtual a : (Ljava/lang/String;Landroid/media/MediaFormat;Landroid/media/MediaFormat;)Z
    //   50: pop
    //   51: aload_0
    //   52: getfield j : Lcom/qiniu/pili/droid/shortvideo/PLExternalRecordStateListener;
    //   55: ifnull -> 67
    //   58: aload_0
    //   59: getfield j : Lcom/qiniu/pili/droid/shortvideo/PLExternalRecordStateListener;
    //   62: invokeinterface onRecordStarted : ()V
    //   67: aload_0
    //   68: iconst_1
    //   69: putfield h : Z
    //   72: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   75: ldc 'ExternalMediaRecorderCore'
    //   77: ldc 'start muxer success.'
    //   79: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   82: aload_0
    //   83: monitorexit
    //   84: iconst_1
    //   85: ireturn
    //   86: astore_2
    //   87: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   90: ldc 'ExternalMediaRecorderCore'
    //   92: ldc 'start muxer failed'
    //   94: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload_0
    //   98: getfield j : Lcom/qiniu/pili/droid/shortvideo/PLExternalRecordStateListener;
    //   101: ifnull -> 123
    //   104: aload_0
    //   105: getfield j : Lcom/qiniu/pili/droid/shortvideo/PLExternalRecordStateListener;
    //   108: bipush #18
    //   110: invokeinterface onError : (I)V
    //   115: invokestatic a : ()Lcom/qiniu/pili/droid/shortvideo/core/QosManager;
    //   118: bipush #18
    //   120: invokevirtual a : (I)V
    //   123: aload_2
    //   124: invokevirtual printStackTrace : ()V
    //   127: aload_0
    //   128: monitorexit
    //   129: iconst_0
    //   130: ireturn
    //   131: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   134: ldc 'ExternalMediaRecorderCore'
    //   136: ldc 'not ready to start muxer.'
    //   138: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload_0
    //   142: monitorexit
    //   143: iconst_0
    //   144: ireturn
    //   145: astore_2
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_2
    //   149: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	145	finally
    //   28	67	86	java/lang/IllegalStateException
    //   28	67	145	finally
    //   67	82	145	finally
    //   87	123	145	finally
    //   123	127	145	finally
    //   131	141	145	finally
  }
  
  private void i() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield k : Z
    //   6: ifne -> 137
    //   9: aload_0
    //   10: getfield m : Z
    //   13: ifne -> 137
    //   16: aload_0
    //   17: getfield l : Z
    //   20: ifne -> 137
    //   23: aload_0
    //   24: getfield n : Z
    //   27: ifne -> 137
    //   30: aload_0
    //   31: getfield h : Z
    //   34: ifne -> 40
    //   37: goto -> 137
    //   40: aload_0
    //   41: iconst_0
    //   42: putfield h : Z
    //   45: aload_0
    //   46: getfield e : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   49: invokevirtual a : ()Z
    //   52: pop
    //   53: aload_0
    //   54: getfield j : Lcom/qiniu/pili/droid/shortvideo/PLExternalRecordStateListener;
    //   57: ifnull -> 106
    //   60: aload_0
    //   61: getfield j : Lcom/qiniu/pili/droid/shortvideo/PLExternalRecordStateListener;
    //   64: invokeinterface onRecordStopped : ()V
    //   69: goto -> 106
    //   72: astore_1
    //   73: aload_0
    //   74: getfield j : Lcom/qiniu/pili/droid/shortvideo/PLExternalRecordStateListener;
    //   77: ifnull -> 97
    //   80: aload_0
    //   81: getfield j : Lcom/qiniu/pili/droid/shortvideo/PLExternalRecordStateListener;
    //   84: iconst_3
    //   85: invokeinterface onError : (I)V
    //   90: invokestatic a : ()Lcom/qiniu/pili/droid/shortvideo/core/QosManager;
    //   93: iconst_3
    //   94: invokevirtual a : (I)V
    //   97: aload_0
    //   98: aconst_null
    //   99: putfield e : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   102: aload_1
    //   103: invokevirtual printStackTrace : ()V
    //   106: aload_0
    //   107: getfield o : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   110: iconst_1
    //   111: invokevirtual set : (Z)V
    //   114: aload_0
    //   115: lconst_0
    //   116: putfield d : J
    //   119: aload_0
    //   120: lconst_0
    //   121: putfield b : J
    //   124: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   127: ldc 'ExternalMediaRecorderCore'
    //   129: ldc 'muxer stop!'
    //   131: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload_0
    //   135: monitorexit
    //   136: return
    //   137: aload_0
    //   138: monitorexit
    //   139: return
    //   140: astore_1
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_1
    //   144: athrow
    // Exception table:
    //   from	to	target	type
    //   2	37	140	finally
    //   40	45	140	finally
    //   45	69	72	java/lang/IllegalStateException
    //   45	69	140	finally
    //   73	97	140	finally
    //   97	106	140	finally
    //   106	134	140	finally
  }
  
  public void a() {
    e.d.c("ExternalMediaRecorderCore", "start +");
    if (!a(b.a.y))
      return; 
    if (!e())
      return; 
    this.o.set(false);
    f();
    this.e = new b();
    e.d.c("ExternalMediaRecorderCore", "start -");
  }
  
  public void a(PLExternalRecordStateListener paramPLExternalRecordStateListener) {
    this.j = paramPLExternalRecordStateListener;
  }
  
  public void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, long paramLong) {
    if (e() && this.k) {
      paramInt1 = paramInt1 * paramInt2 * 3 / 2;
      ByteBuffer byteBuffer = ByteBuffer.wrap(paramArrayOfbyte);
      e e = e.h;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("input video frame size:");
      stringBuilder.append(paramInt1);
      stringBuilder.append(" ts:");
      stringBuilder.append(paramLong);
      e.b("ExternalMediaRecorderCore", stringBuilder.toString());
      this.a.a(byteBuffer, paramInt1, paramLong);
    } 
  }
  
  public void a(byte[] paramArrayOfbyte, int paramInt, long paramLong) {
    if (e() && this.l) {
      ByteBuffer byteBuffer = ByteBuffer.wrap(paramArrayOfbyte);
      this.c.a(byteBuffer, paramInt, paramLong / 1000L);
    } 
  }
  
  public boolean a(PLVideoEncodeSetting paramPLVideoEncodeSetting, PLAudioEncodeSetting paramPLAudioEncodeSetting, PLRecordSetting paramPLRecordSetting) {
    e.d.c("ExternalMediaRecorderCore", "prepare +");
    if (paramPLVideoEncodeSetting == null || paramPLAudioEncodeSetting == null || paramPLRecordSetting == null) {
      e.d.e("ExternalMediaRecorderCore", "prepare error : videoEncodeSetting, audioEncodeSetting or recordSetting can not be null !");
      return false;
    } 
    if (!a(paramPLRecordSetting.getVideoFilepath())) {
      e.d.e("ExternalMediaRecorderCore", "Error: set output file path failed!");
      return false;
    } 
    this.i = paramPLRecordSetting;
    this.a = new SWVideoEncoder(paramPLVideoEncodeSetting);
    SWVideoEncoder sWVideoEncoder = this.a;
    if (sWVideoEncoder != null) {
      sWVideoEncoder.a(this.r);
      this.c = new c(paramPLAudioEncodeSetting);
      c c1 = this.c;
      if (c1 != null) {
        c1.a(this.s);
        this.p = true;
        PLExternalRecordStateListener pLExternalRecordStateListener = this.j;
        if (pLExternalRecordStateListener != null)
          pLExternalRecordStateListener.onReady(); 
        e.d.c("ExternalMediaRecorderCore", "prepare -");
        return true;
      } 
      e.d.e("ExternalMediaRecorderCore", "Building audio encoder failed!!!!");
      return false;
    } 
    e.d.e("ExternalMediaRecorderCore", "Building video encoder failed!!!!");
    return false;
  }
  
  public void b() {
    e.d.c("ExternalMediaRecorderCore", "stop +");
    g();
    e.d.c("ExternalMediaRecorderCore", "stop -");
  }
  
  public boolean c() {
    return this.h;
  }
  
  public JSONObject d() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("operation_record_external_media", 1);
      jSONObject.put("data_type", QosManager.a.c);
      return jSONObject;
    } catch (JSONException jSONException) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\core\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */