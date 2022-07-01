package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLAudioFrameListener;
import com.qiniu.pili.droid.shortvideo.PLMicrophoneSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordStateListener;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.a.b.a;
import com.qiniu.pili.droid.shortvideo.d.b;
import com.qiniu.pili.droid.shortvideo.encode.SWAudioEncoder;
import com.qiniu.pili.droid.shortvideo.encode.a;
import com.qiniu.pili.droid.shortvideo.encode.c;
import com.qiniu.pili.droid.shortvideo.f.b;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.g;
import com.qiniu.pili.droid.shortvideo.transcoder.audio.b;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Stack;
import org.json.JSONObject;

public class j implements PLAudioFrameListener, i.a {
  private MediaPlayer A;
  
  private Stack<Integer> B;
  
  private Stack<Object> C;
  
  private boolean D;
  
  private boolean E;
  
  private String F;
  
  private double G;
  
  private long H;
  
  private long I = -1L;
  
  private Stack<Double> J = new Stack<Double>();
  
  private Stack<Long> K = new Stack<Long>();
  
  private b L;
  
  private MediaExtractor M;
  
  private b N;
  
  private volatile long O;
  
  private final Object P = new Object();
  
  private long Q;
  
  private Stack<Long> R;
  
  private long S;
  
  private int T;
  
  private volatile boolean U;
  
  private b.a V = new b.a(this) {
      public void a(ByteBuffer param1ByteBuffer, int param1Int) {
        j.a(this.a).a(param1ByteBuffer, param1Int, j.f(this.a));
        j j1 = this.a;
        j.a(j1, j.f(j1) + j.g(this.a));
      }
    };
  
  private b.c W = new b.c(this) {
      private boolean a() {
        if (j.j(this.a)) {
          j.k(this.a);
          j.l(this.a);
          j.a(this.a, false);
          return true;
        } 
        return false;
      }
      
      public void a(ByteBuffer param1ByteBuffer, int param1Int, long param1Long1, long param1Long2, boolean param1Boolean) {
        if (!this.a.j)
          return; 
        synchronized (j.h(this.a)) {
          j.e(this.a).a(param1ByteBuffer, param1ByteBuffer.position(), param1Int);
          j.b(this.a, param1Long1);
          while (j.i(this.a)) {
            if (a())
              return; 
            try {
              j.h(this.a).wait();
            } catch (InterruptedException interruptedException) {
              interruptedException.printStackTrace();
            } 
            if (a())
              return; 
          } 
          return;
        } 
      }
    };
  
  private a a;
  
  private PLAudioFrameListener b;
  
  private volatile boolean c;
  
  private volatile boolean d;
  
  private PLVideoSaveListener e;
  
  private boolean f = false;
  
  protected volatile boolean g;
  
  protected volatile boolean h;
  
  protected volatile boolean i;
  
  protected volatile boolean j;
  
  protected volatile boolean k;
  
  protected volatile boolean l;
  
  protected Context m;
  
  protected PLRecordSetting n;
  
  protected PLMicrophoneSetting o;
  
  protected PLAudioEncodeSetting p;
  
  protected a q;
  
  protected i r;
  
  protected PLRecordStateListener s;
  
  protected double t = 1.0D;
  
  protected String u = null;
  
  protected AssetFileDescriptor v = null;
  
  protected boolean w;
  
  protected volatile double x;
  
  protected a.a y = new a.a(this) {
      public void a(MediaFormat param1MediaFormat) {
        e e = e.n;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("got audio format:");
        stringBuilder.append(param1MediaFormat.toString());
        e.c("ShortAudioRecorderCore", stringBuilder.toString());
        this.a.r.b(param1MediaFormat);
        j j1 = this.a;
        j1.k = true;
        j1.r();
      }
      
      public void a(Surface param1Surface) {}
      
      public void a(ByteBuffer param1ByteBuffer, MediaCodec.BufferInfo param1BufferInfo) {
        if (this.a.l) {
          e e = e.h;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("audio encoded frame size:");
          stringBuilder.append(param1BufferInfo.size);
          stringBuilder.append(" ts:");
          stringBuilder.append(param1BufferInfo.presentationTimeUs);
          e.b("ShortAudioRecorderCore", stringBuilder.toString());
          this.a.r.b(param1ByteBuffer, param1BufferInfo);
        } 
      }
      
      public void a(boolean param1Boolean) {
        e e = e.h;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("audio encoder started: ");
        stringBuilder.append(param1Boolean);
        e.c("ShortAudioRecorderCore", stringBuilder.toString());
        j j1 = this.a;
        j1.j = param1Boolean;
        if (!param1Boolean && j1.s != null) {
          j1 = this.a;
          j1.i = false;
          j1.s.onError(7);
          QosManager.a().a(7);
        } 
      }
      
      public void b(boolean param1Boolean) {
        e.h.c("ShortAudioRecorderCore", "audio encoder stopped.");
        j j1 = this.a;
        j1.j = false;
        j1.k = false;
        j.c(j1, -1L);
        j1 = this.a;
        j1.x = 0.0D;
        j.a(j1, 0L);
        this.a.s();
      }
    };
  
  private a z = new a();
  
  public j() {
    e.d.c("ShortAudioRecorderCore", "init");
  }
  
  private void a(long paramLong) {
    long l = this.I;
    if (l == -1L) {
      this.G += (1024000 / this.p.getSamplerate());
      this.x += (1024000 / this.p.getSamplerate());
      return;
    } 
    this.G += (paramLong - l) / this.t / 1000000.0D;
    this.x += (paramLong - this.I) / this.t / 1000000.0D;
  }
  
  private void a(Object paramObject) {
    e.d.c("ShortAudioRecorderCore", "configMusicPlayer...");
    MediaPlayer mediaPlayer = this.A;
    if (mediaPlayer != null) {
      mediaPlayer.reset();
      this.d = false;
    } 
    if (this.A == null) {
      this.A = new MediaPlayer();
      this.B = new Stack<Integer>();
      this.C = new Stack();
      this.R = new Stack<Long>();
    } 
    try {
      if (paramObject instanceof String) {
        this.A.setDataSource((String)paramObject);
      } else {
        this.A.setDataSource(((AssetFileDescriptor)paramObject).getFileDescriptor(), ((AssetFileDescriptor)paramObject).getStartOffset(), ((AssetFileDescriptor)paramObject).getLength());
      } 
      if (this.E)
        this.A.setVolume(0.0F, 0.0F); 
      this.A.prepare();
      this.A.setOnCompletionListener(new MediaPlayer.OnCompletionListener(this) {
            public void onCompletion(MediaPlayer param1MediaPlayer) {
              j.c(this.a).seekTo(j.b(this.a));
              j.c(this.a).start();
            }
          });
      this.d = true;
      this.S = 0L;
      return;
    } catch (IOException iOException) {
      e.d.e("ShortAudioRecorderCore", iOException.toString());
      w();
      PLRecordStateListener pLRecordStateListener = this.s;
      if (pLRecordStateListener != null)
        pLRecordStateListener.onError(0); 
      return;
    } 
  }
  
  private boolean a() {
    return (this.A != null && this.w);
  }
  
  private void b() {
    this.j = false;
    this.a.c();
  }
  
  private void c(boolean paramBoolean) {
    Object object1 = this.C.pop();
    int k = ((Integer)this.B.pop()).intValue();
    long l2 = ((Long)this.R.pop()).longValue();
    Object object2 = object1;
    int m = k;
    long l1 = l2;
    if (paramBoolean) {
      int n;
      while (true) {
        n = k;
        if (this.C.size() > 0) {
          object1 = this.C.pop();
          continue;
        } 
        break;
      } 
      while (true) {
        l1 = l2;
        if (this.B.size() > 0) {
          n = ((Integer)this.B.pop()).intValue();
          continue;
        } 
        break;
      } 
      while (true) {
        object2 = object1;
        m = n;
        if (this.R.size() > 0) {
          l1 = ((Long)this.R.pop()).longValue();
          continue;
        } 
        break;
      } 
    } 
    if (object2 instanceof String) {
      object1 = this.u;
      if (object1 == null || !object1.equals(object2)) {
        this.u = (String)object2;
        this.v = null;
        a(object2);
      } 
    } else {
      object1 = this.v;
      if (object1 == null || !object1.equals(object2)) {
        this.v = (AssetFileDescriptor)object2;
        this.u = null;
        a(object2);
      } 
    } 
    this.A.seekTo(m);
    this.D = false;
    this.S = l1;
  }
  
  private void u() {
    e.d.c("ShortAudioRecorderCore", "startMusicExtractorInternal + ");
    AssetFileDescriptor assetFileDescriptor = this.v;
    if (assetFileDescriptor != null) {
      this.M = g.a(assetFileDescriptor);
    } else {
      this.M = g.a(this.u);
    } 
    MediaFormat mediaFormat = g.a(this.M);
    if (mediaFormat == null) {
      e.d.e("ShortAudioRecorderCore", "start music extractor failed!");
      return;
    } 
    this.L = new b(this.M, mediaFormat);
    this.L.a(true);
    this.L.a(this.W);
    this.L.a(new b.d(this) {
          public void a(MediaFormat param1MediaFormat) {
            j.a(this.a, new b());
            j.e(this.a).a(j.d(this.a));
            j.e(this.a).a(param1MediaFormat.getInteger("sample-rate"), param1MediaFormat.getInteger("channel-count"), 16, this.a.p.getSamplerate(), this.a.p.getChannels(), 16);
          }
        });
    this.L.a(this.S);
    e.d.c("ShortAudioRecorderCore", "startMusicExtractorInternal - ");
  }
  
  private void v() {
    b b2 = this.L;
    if (b2 != null) {
      b2.c();
      this.L = null;
    } 
    MediaExtractor mediaExtractor = this.M;
    if (mediaExtractor != null) {
      mediaExtractor.release();
      this.M = null;
    } 
    b b1 = this.N;
    if (b1 != null) {
      b1.a();
      this.N = null;
    } 
  }
  
  private void w() {
    MediaPlayer mediaPlayer = this.A;
    if (mediaPlayer != null) {
      mediaPlayer.stop();
      this.A.release();
    } 
    this.A = null;
    this.B = null;
    this.C = null;
    this.d = false;
    this.D = false;
    this.R = null;
    this.T = 0;
  }
  
  private boolean x() {
    return (this.O > this.x * 1000.0D);
  }
  
  public void a(double paramDouble) {
    if (!a(b.a.p))
      return; 
    if (d()) {
      e.d.d("ShortAudioRecorderCore", "can't set speed while recording!!!");
      return;
    } 
    int k = paramDouble cmp 1.0D;
    if ((k > 0 && paramDouble % 2.0D == 0.0D) || (paramDouble < 1.0D && 1.0D / paramDouble % 2.0D == 0.0D) || k == 0) {
      k = 1;
    } else {
      k = 0;
    } 
    if (k != 0) {
      e e = e.d;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("set record speed to: ");
      stringBuilder.append(paramDouble);
      e.c("ShortAudioRecorderCore", stringBuilder.toString());
      this.t = paramDouble;
      this.z.a(this.t);
      this.r.a(this.t);
      return;
    } 
    e.d.d("ShortAudioRecorderCore", "only support multiple of 2 !!!");
  }
  
  public void a(int paramInt) {
    MediaPlayer mediaPlayer = this.A;
    if (mediaPlayer != null) {
      this.T = paramInt;
      mediaPlayer.seekTo(paramInt);
      this.S = paramInt * 1000L;
      return;
    } 
    e.d.e("ShortAudioRecorderCore", "setMusicPosition failed, you must set music file firstly!");
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt) {
    double d1 = (paramLong2 - paramLong1);
    double d2 = paramLong1;
    double d3 = this.t;
    long l = (long)(d1 + d2 * d3);
    this.J.push(new Double(d3));
    this.K.push(new Long(l));
    this.H += paramLong1;
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Section increased speed: ");
    stringBuilder.append(this.t);
    stringBuilder.append("; Section count");
    stringBuilder.append(paramInt);
    stringBuilder.append("; Total duration: ");
    stringBuilder.append(paramLong2);
    stringBuilder.append("; Section duration: ");
    stringBuilder.append(paramLong1);
    stringBuilder.append("; Recording duration: ");
    stringBuilder.append(l);
    e.c("ShortAudioRecorderCore", stringBuilder.toString());
    PLRecordStateListener pLRecordStateListener = this.s;
    if (pLRecordStateListener != null)
      pLRecordStateListener.onSectionIncreased((long)(d2 * this.t), l, paramInt); 
  }
  
  public void a(Context paramContext, PLMicrophoneSetting paramPLMicrophoneSetting, PLAudioEncodeSetting paramPLAudioEncodeSetting, PLRecordSetting paramPLRecordSetting) {
    e.d.c("ShortAudioRecorderCore", "prepare +");
    l.a(paramContext);
    this.m = paramContext;
    this.n = paramPLRecordSetting;
    this.o = paramPLMicrophoneSetting;
    this.p = paramPLAudioEncodeSetting;
    this.q = new a(paramPLMicrophoneSetting);
    if (paramPLAudioEncodeSetting.isHWCodecEnabled()) {
      this.a = (a)new c(paramPLAudioEncodeSetting);
    } else {
      this.a = (a)new SWAudioEncoder(paramPLAudioEncodeSetting);
    } 
    this.r = g();
    this.r.a(paramPLRecordSetting.getMaxRecordDuration());
    this.r.a(this);
    this.a.a(this.y);
    this.q.a(this);
    this.Q = (long)('Ѐ' * 1000000.0D / this.p.getSamplerate());
    e.d.c("ShortAudioRecorderCore", "prepare -");
  }
  
  public void a(AssetFileDescriptor paramAssetFileDescriptor) {
    if (!a(b.a.s))
      return; 
    if (d()) {
      e.d.e("ShortAudioRecorderCore", "Cannot add audio file when recording!");
      return;
    } 
    if (paramAssetFileDescriptor == null) {
      w();
      return;
    } 
    a(true);
    this.u = null;
    this.v = paramAssetFileDescriptor;
    a(this.v);
  }
  
  public final void a(PLAudioFrameListener paramPLAudioFrameListener) {
    this.b = paramPLAudioFrameListener;
  }
  
  public final void a(PLRecordStateListener paramPLRecordStateListener) {
    this.s = paramPLRecordStateListener;
  }
  
  public void a(PLVideoSaveListener paramPLVideoSaveListener) {
    e.d.c("ShortAudioRecorderCore", "concatSections +");
    if (!u.a().b()) {
      e.b.d("unauthorized !");
      QosManager.a().a(8);
      if (paramPLVideoSaveListener != null)
        paramPLVideoSaveListener.onSaveVideoFailed(8); 
      return;
    } 
    if (this.i) {
      e.d.d("ShortAudioRecorderCore", "cannot concat sections while readying !!!");
      QosManager.a().a(1);
      if (paramPLVideoSaveListener != null)
        paramPLVideoSaveListener.onSaveVideoFailed(1); 
      return;
    } 
    if (this.l) {
      this.c = true;
      this.e = paramPLVideoSaveListener;
      c();
    } else {
      this.r.a(paramPLVideoSaveListener);
    } 
    e.d.c("ShortAudioRecorderCore", "concatSections -");
  }
  
  public void a(String paramString, boolean paramBoolean) {
    this.E = paramBoolean;
    b(paramString);
  }
  
  public void a(boolean paramBoolean) {
    if (!a(b.a.u))
      return; 
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mute: ");
    stringBuilder.append(paramBoolean);
    e.c("ShortAudioRecorderCore", stringBuilder.toString());
    this.w = paramBoolean;
    this.q.a(paramBoolean);
  }
  
  public boolean a(Context paramContext, b paramb) {
    if (paramb == null) {
      e.d.e("ShortAudioRecorderCore", "Error on recoverFromDraft, null draft");
      return false;
    } 
    this.n = paramb.h();
    this.o = paramb.d();
    this.p = paramb.f();
    a(paramContext, this.o, this.p, this.n);
    this.r = g();
    this.r.a(this.n.getMaxRecordDuration());
    this.r.a(this);
    return this.r.a(paramb);
  }
  
  protected boolean a(b.a parama) {
    if (!u.a().a(parama)) {
      PLRecordStateListener pLRecordStateListener = this.s;
      if (pLRecordStateListener != null)
        pLRecordStateListener.onError(8); 
      QosManager.a().a(8);
      return false;
    } 
    return true;
  }
  
  public boolean a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.d : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: ldc 'ShortAudioRecorderCore'
    //   7: ldc_w 'beginSection +'
    //   10: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getstatic com/qiniu/pili/droid/shortvideo/core/b$a.b : Lcom/qiniu/pili/droid/shortvideo/core/b$a;
    //   17: invokevirtual a : (Lcom/qiniu/pili/droid/shortvideo/core/b$a;)Z
    //   20: istore_2
    //   21: iload_2
    //   22: ifne -> 29
    //   25: aload_0
    //   26: monitorexit
    //   27: iconst_0
    //   28: ireturn
    //   29: aload_0
    //   30: getfield n : Lcom/qiniu/pili/droid/shortvideo/PLRecordSetting;
    //   33: invokevirtual IsRecordSpeedVariable : ()Z
    //   36: ifne -> 73
    //   39: aload_0
    //   40: getfield f : Z
    //   43: ifne -> 73
    //   46: aload_0
    //   47: getfield n : Lcom/qiniu/pili/droid/shortvideo/PLRecordSetting;
    //   50: aload_0
    //   51: getfield n : Lcom/qiniu/pili/droid/shortvideo/PLRecordSetting;
    //   54: invokevirtual getMaxRecordDuration : ()J
    //   57: l2d
    //   58: aload_0
    //   59: getfield t : D
    //   62: ddiv
    //   63: d2l
    //   64: invokevirtual setMaxRecordDuration : (J)Lcom/qiniu/pili/droid/shortvideo/PLRecordSetting;
    //   67: pop
    //   68: aload_0
    //   69: iconst_1
    //   70: putfield f : Z
    //   73: aload_0
    //   74: getfield A : Landroid/media/MediaPlayer;
    //   77: ifnull -> 102
    //   80: aload_0
    //   81: getfield d : Z
    //   84: ifne -> 102
    //   87: getstatic com/qiniu/pili/droid/shortvideo/f/e.d : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   90: ldc 'ShortAudioRecorderCore'
    //   92: ldc_w 'player is not prepared!'
    //   95: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload_0
    //   99: monitorexit
    //   100: iconst_0
    //   101: ireturn
    //   102: aload_0
    //   103: getfield i : Z
    //   106: ifne -> 282
    //   109: aload_0
    //   110: getfield l : Z
    //   113: ifeq -> 119
    //   116: goto -> 282
    //   119: aload_0
    //   120: getfield H : J
    //   123: aload_0
    //   124: getfield n : Lcom/qiniu/pili/droid/shortvideo/PLRecordSetting;
    //   127: invokevirtual getMaxRecordDuration : ()J
    //   130: lcmp
    //   131: iflt -> 149
    //   134: getstatic com/qiniu/pili/droid/shortvideo/f/e.d : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   137: ldc 'ShortAudioRecorderCore'
    //   139: ldc_w 'reached the max record duration'
    //   142: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload_0
    //   146: monitorexit
    //   147: iconst_0
    //   148: ireturn
    //   149: aload_0
    //   150: aload_1
    //   151: putfield F : Ljava/lang/String;
    //   154: aload_0
    //   155: iconst_1
    //   156: putfield i : Z
    //   159: aload_0
    //   160: getfield z : Lcom/qiniu/pili/droid/shortvideo/core/a;
    //   163: new com/qiniu/pili/droid/shortvideo/core/j$1
    //   166: dup
    //   167: aload_0
    //   168: invokespecial <init> : (Lcom/qiniu/pili/droid/shortvideo/core/j;)V
    //   171: invokevirtual a : (Lcom/qiniu/pili/droid/shortvideo/core/a$a;)V
    //   174: aload_0
    //   175: getfield a : Lcom/qiniu/pili/droid/shortvideo/encode/a;
    //   178: invokevirtual a : ()Z
    //   181: pop
    //   182: aload_0
    //   183: getfield A : Landroid/media/MediaPlayer;
    //   186: ifnull -> 267
    //   189: aload_0
    //   190: getfield D : Z
    //   193: ifne -> 267
    //   196: aload_0
    //   197: getfield C : Ljava/util/Stack;
    //   200: astore_3
    //   201: aload_0
    //   202: getfield u : Ljava/lang/String;
    //   205: ifnonnull -> 216
    //   208: aload_0
    //   209: getfield v : Landroid/content/res/AssetFileDescriptor;
    //   212: astore_1
    //   213: goto -> 221
    //   216: aload_0
    //   217: getfield u : Ljava/lang/String;
    //   220: astore_1
    //   221: aload_3
    //   222: aload_1
    //   223: invokevirtual push : (Ljava/lang/Object;)Ljava/lang/Object;
    //   226: pop
    //   227: aload_0
    //   228: getfield A : Landroid/media/MediaPlayer;
    //   231: invokevirtual start : ()V
    //   234: aload_0
    //   235: getfield B : Ljava/util/Stack;
    //   238: aload_0
    //   239: getfield A : Landroid/media/MediaPlayer;
    //   242: invokevirtual getCurrentPosition : ()I
    //   245: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   248: invokevirtual push : (Ljava/lang/Object;)Ljava/lang/Object;
    //   251: pop
    //   252: aload_0
    //   253: getfield R : Ljava/util/Stack;
    //   256: aload_0
    //   257: getfield S : J
    //   260: invokestatic valueOf : (J)Ljava/lang/Long;
    //   263: invokevirtual push : (Ljava/lang/Object;)Ljava/lang/Object;
    //   266: pop
    //   267: getstatic com/qiniu/pili/droid/shortvideo/f/e.d : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   270: ldc 'ShortAudioRecorderCore'
    //   272: ldc_w 'beginSection -'
    //   275: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   278: aload_0
    //   279: monitorexit
    //   280: iconst_1
    //   281: ireturn
    //   282: getstatic com/qiniu/pili/droid/shortvideo/f/e.d : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   285: ldc 'ShortAudioRecorderCore'
    //   287: ldc_w 'section begin ongoing !!!'
    //   290: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   293: aload_0
    //   294: monitorexit
    //   295: iconst_0
    //   296: ireturn
    //   297: astore_1
    //   298: aload_0
    //   299: monitorexit
    //   300: aload_1
    //   301: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	297	finally
    //   29	73	297	finally
    //   73	98	297	finally
    //   102	116	297	finally
    //   119	145	297	finally
    //   149	213	297	finally
    //   216	221	297	finally
    //   221	267	297	finally
    //   267	278	297	finally
    //   282	293	297	finally
  }
  
  public void b(long paramLong1, long paramLong2, int paramInt) {
    double d;
    long l;
    if (paramInt == 0 && !this.n.IsRecordSpeedVariable()) {
      this.f = false;
      PLRecordSetting pLRecordSetting = this.n;
      pLRecordSetting.setMaxRecordDuration((long)(pLRecordSetting.getMaxRecordDuration() * this.t));
    } 
    while (this.K.size() > paramInt)
      this.K.pop(); 
    this.H -= paramLong1;
    this.G = this.H;
    if (this.J.isEmpty()) {
      d = 0.0D;
    } else {
      d = ((Double)this.J.pop()).doubleValue();
    } 
    if (this.K.isEmpty()) {
      l = 0L;
    } else {
      l = ((Long)this.K.pop()).longValue();
    } 
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Section decreased speed: ");
    stringBuilder.append(d);
    stringBuilder.append("; Section count");
    stringBuilder.append(paramInt);
    stringBuilder.append("RecDurationStackSz: ");
    stringBuilder.append(this.K.size());
    stringBuilder.append("; Total duration: ");
    stringBuilder.append(paramLong2);
    stringBuilder.append("; Section duration: ");
    stringBuilder.append(paramLong1);
    stringBuilder.append("; Recording duration: ");
    stringBuilder.append(l);
    e.c("ShortAudioRecorderCore", stringBuilder.toString());
    PLRecordStateListener pLRecordStateListener = this.s;
    if (pLRecordStateListener != null)
      pLRecordStateListener.onSectionDecreased((long)(paramLong1 * d), l, paramInt); 
  }
  
  public void b(String paramString) {
    if (!a(b.a.s))
      return; 
    if (d()) {
      e.d.e("ShortAudioRecorderCore", "cannot add audio file when recording!");
      return;
    } 
    if (paramString == null) {
      w();
      return;
    } 
    a(true);
    this.u = paramString;
    this.v = null;
    a(this.u);
  }
  
  public void b(boolean paramBoolean) {
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("destroy + clearSections: ");
    stringBuilder.append(paramBoolean);
    e.c("ShortAudioRecorderCore", stringBuilder.toString());
    if (paramBoolean)
      this.r.a(false); 
    e.d.c("ShortAudioRecorderCore", "destroy -");
  }
  
  public boolean c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.d : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: ldc 'ShortAudioRecorderCore'
    //   7: ldc_w 'endSection +'
    //   10: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield i : Z
    //   17: ifne -> 42
    //   20: aload_0
    //   21: getfield l : Z
    //   24: ifne -> 42
    //   27: getstatic com/qiniu/pili/droid/shortvideo/f/e.d : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   30: ldc 'ShortAudioRecorderCore'
    //   32: ldc_w 'not started !!!'
    //   35: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_0
    //   39: monitorexit
    //   40: iconst_0
    //   41: ireturn
    //   42: aload_0
    //   43: getfield A : Landroid/media/MediaPlayer;
    //   46: ifnull -> 56
    //   49: aload_0
    //   50: getfield A : Landroid/media/MediaPlayer;
    //   53: invokevirtual pause : ()V
    //   56: aload_0
    //   57: invokespecial a : ()Z
    //   60: ifeq -> 99
    //   63: aload_0
    //   64: getfield P : Ljava/lang/Object;
    //   67: astore_1
    //   68: aload_1
    //   69: monitorenter
    //   70: aload_0
    //   71: iconst_1
    //   72: putfield U : Z
    //   75: aload_0
    //   76: invokespecial x : ()Z
    //   79: ifeq -> 89
    //   82: aload_0
    //   83: getfield P : Ljava/lang/Object;
    //   86: invokevirtual notify : ()V
    //   89: aload_1
    //   90: monitorexit
    //   91: goto -> 103
    //   94: astore_2
    //   95: aload_1
    //   96: monitorexit
    //   97: aload_2
    //   98: athrow
    //   99: aload_0
    //   100: invokespecial b : ()V
    //   103: getstatic com/qiniu/pili/droid/shortvideo/f/e.d : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   106: ldc 'ShortAudioRecorderCore'
    //   108: ldc_w 'endSection -'
    //   111: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   114: aload_0
    //   115: monitorexit
    //   116: iconst_1
    //   117: ireturn
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    // Exception table:
    //   from	to	target	type
    //   2	38	118	finally
    //   42	56	118	finally
    //   56	70	118	finally
    //   70	89	94	finally
    //   89	91	94	finally
    //   95	97	94	finally
    //   97	99	118	finally
    //   99	103	118	finally
    //   103	114	118	finally
  }
  
  public boolean c(String paramString) {
    return this.r.a(paramString, null, this.o, null, this.p, null, this.n);
  }
  
  protected boolean d() {
    return this.j;
  }
  
  protected boolean e() {
    return this.k;
  }
  
  protected boolean f() {
    return this.k ^ true;
  }
  
  protected i g() {
    return new i(this.m, this.n, this.p);
  }
  
  public JSONObject h() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void i() {
    PLRecordStateListener pLRecordStateListener = this.s;
    if (pLRecordStateListener != null)
      pLRecordStateListener.onDurationTooShort(); 
  }
  
  public void j() {
    e.d.c("ShortAudioRecorderCore", "resume +");
    if (l()) {
      e.d.d("ShortAudioRecorderCore", "sources already ready !!!");
      return;
    } 
    if (this.g) {
      e.d.d("ShortAudioRecorderCore", "source readying !!!");
      return;
    } 
    this.g = true;
    if (!this.q.a()) {
      PLRecordStateListener pLRecordStateListener = this.s;
      if (pLRecordStateListener != null) {
        pLRecordStateListener.onError(5);
        QosManager.a().a(5);
      } 
    } 
    e.d.c("ShortAudioRecorderCore", "resume -");
  }
  
  public void k() {
    e.d.c("ShortAudioRecorderCore", "pause +");
    c();
    this.g = false;
    this.h = false;
    this.k = false;
    this.q.b();
    e.d.c("ShortAudioRecorderCore", "pause -");
  }
  
  protected boolean l() {
    return this.h;
  }
  
  public boolean m() {
    e.d.c("ShortAudioRecorderCore", "deleteLastSection +");
    if (this.i || this.l) {
      e.d.d("ShortAudioRecorderCore", "cannot delete while working !!!");
      return false;
    } 
    boolean bool = this.r.c();
    Stack<Object> stack = this.C;
    if (stack != null && stack.empty())
      w(); 
    if (bool && this.A != null)
      c(false); 
    e.d.c("ShortAudioRecorderCore", "deleteLastSection -");
    return bool;
  }
  
  public boolean n() {
    e.d.c("ShortAudioRecorderCore", "deleteAllSections +");
    if (this.i || this.l) {
      e.d.d("ShortAudioRecorderCore", "cannot delete sections while working !!!");
      return false;
    } 
    boolean bool = this.r.a(true);
    Stack<Object> stack = this.C;
    if (stack != null && stack.empty())
      w(); 
    if (bool && this.A != null)
      c(true); 
    e.d.c("ShortAudioRecorderCore", "deleteAllSections -");
    return bool;
  }
  
  public void o() {
    e.d.c("ShortAudioRecorderCore", "cancelConcat +");
    this.r.e();
    e.d.c("ShortAudioRecorderCore", "cancelConcat -");
  }
  
  public void onAudioFrameAvailable(byte[] paramArrayOfbyte, long paramLong) {
    if (this.g && !this.h) {
      this.h = true;
      q();
    } 
    PLAudioFrameListener pLAudioFrameListener = this.b;
    if (pLAudioFrameListener != null)
      pLAudioFrameListener.onAudioFrameAvailable(paramArrayOfbyte, paramLong); 
    if (d()) {
      ByteBuffer byteBuffer;
      if (this.G >= ((float)this.n.getMaxRecordDuration() * 1.02F)) {
        e.d.d("ShortAudioRecorderCore", "reached the max record duration");
        c();
        t();
        return;
      } 
      if (a()) {
        synchronized (this.P) {
          a(paramLong);
        } 
      } else {
        a(paramLong);
      } 
      e e = e.d;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("mVideoTailMs: ");
      stringBuilder.append(this.G);
      stringBuilder.append("; END: ");
      stringBuilder.append((float)this.n.getMaxRecordDuration() * 1.02F);
      e.c("ShortAudioRecorderCore", stringBuilder.toString());
      this.I = paramLong;
      PLRecordStateListener pLRecordStateListener = this.s;
      if (pLRecordStateListener != null) {
        double d = this.G;
        pLRecordStateListener.onSectionRecording((long)(d - this.H), (long)d, this.K.size() + 1);
      } 
      if (!a()) {
        byteBuffer = ByteBuffer.wrap(paramArrayOfbyte);
        this.z.c(byteBuffer, byteBuffer.remaining(), paramLong / 1000L);
      } else if (!this.k) {
        byteBuffer = ByteBuffer.allocateDirect(byteBuffer.length);
        this.a.a(byteBuffer, byteBuffer.remaining(), 0L);
      } 
    } 
    if (a())
      synchronized (this.P) {
        if (!x())
          this.P.notify(); 
        return;
      }  
  }
  
  public void onAudioRecordFailed(int paramInt) {
    PLAudioFrameListener pLAudioFrameListener = this.b;
    if (pLAudioFrameListener != null)
      pLAudioFrameListener.onAudioRecordFailed(paramInt); 
  }
  
  public int p() {
    MediaPlayer mediaPlayer = this.A;
    return (mediaPlayer != null) ? mediaPlayer.getCurrentPosition() : -1;
  }
  
  protected void q() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual l : ()Z
    //   6: ifeq -> 41
    //   9: aload_0
    //   10: iconst_0
    //   11: putfield g : Z
    //   14: getstatic com/qiniu/pili/droid/shortvideo/f/e.d : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   17: ldc 'ShortAudioRecorderCore'
    //   19: ldc_w 'sources are set, we are ready now.'
    //   22: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield s : Lcom/qiniu/pili/droid/shortvideo/PLRecordStateListener;
    //   29: ifnull -> 41
    //   32: aload_0
    //   33: getfield s : Lcom/qiniu/pili/droid/shortvideo/PLRecordStateListener;
    //   36: invokeinterface onReady : ()V
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Exception table:
    //   from	to	target	type
    //   2	41	44	finally
  }
  
  protected void r() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield l : Z
    //   6: ifne -> 76
    //   9: aload_0
    //   10: invokevirtual e : ()Z
    //   13: ifeq -> 76
    //   16: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   19: ldc 'ShortAudioRecorderCore'
    //   21: ldc_w 'formats are set, begin section now.'
    //   24: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_0
    //   28: getfield r : Lcom/qiniu/pili/droid/shortvideo/core/i;
    //   31: aload_0
    //   32: getfield F : Ljava/lang/String;
    //   35: invokevirtual a : (Ljava/lang/String;)Z
    //   38: pop
    //   39: aload_0
    //   40: iconst_1
    //   41: putfield l : Z
    //   44: aload_0
    //   45: iconst_0
    //   46: putfield i : Z
    //   49: aload_0
    //   50: getfield s : Lcom/qiniu/pili/droid/shortvideo/PLRecordStateListener;
    //   53: ifnull -> 65
    //   56: aload_0
    //   57: getfield s : Lcom/qiniu/pili/droid/shortvideo/PLRecordStateListener;
    //   60: invokeinterface onRecordStarted : ()V
    //   65: aload_0
    //   66: invokespecial a : ()Z
    //   69: ifeq -> 76
    //   72: aload_0
    //   73: invokespecial u : ()V
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Exception table:
    //   from	to	target	type
    //   2	65	79	finally
    //   65	76	79	finally
  }
  
  protected void s() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield i : Z
    //   7: aload_0
    //   8: getfield l : Z
    //   11: ifeq -> 91
    //   14: aload_0
    //   15: invokevirtual f : ()Z
    //   18: ifeq -> 91
    //   21: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   24: ldc 'ShortAudioRecorderCore'
    //   26: ldc_w 'formats are unset, end section now.'
    //   29: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield r : Lcom/qiniu/pili/droid/shortvideo/core/i;
    //   36: invokevirtual b : ()Z
    //   39: pop
    //   40: aload_0
    //   41: iconst_0
    //   42: putfield l : Z
    //   45: aload_0
    //   46: getfield s : Lcom/qiniu/pili/droid/shortvideo/PLRecordStateListener;
    //   49: ifnull -> 61
    //   52: aload_0
    //   53: getfield s : Lcom/qiniu/pili/droid/shortvideo/PLRecordStateListener;
    //   56: invokeinterface onRecordStopped : ()V
    //   61: aload_0
    //   62: getfield c : Z
    //   65: ifeq -> 84
    //   68: aload_0
    //   69: iconst_0
    //   70: putfield c : Z
    //   73: aload_0
    //   74: getfield r : Lcom/qiniu/pili/droid/shortvideo/core/i;
    //   77: aload_0
    //   78: getfield e : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   81: invokevirtual a : (Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;)V
    //   84: aload_0
    //   85: getfield z : Lcom/qiniu/pili/droid/shortvideo/core/a;
    //   88: invokevirtual b : ()V
    //   91: aload_0
    //   92: monitorexit
    //   93: return
    //   94: astore_1
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_1
    //   98: athrow
    // Exception table:
    //   from	to	target	type
    //   2	61	94	finally
    //   61	84	94	finally
    //   84	91	94	finally
  }
  
  public void t() {
    this.G = 0.0D;
    PLRecordStateListener pLRecordStateListener = this.s;
    if (pLRecordStateListener != null)
      pLRecordStateListener.onRecordCompleted(); 
    MediaPlayer mediaPlayer = this.A;
    if (mediaPlayer != null) {
      mediaPlayer.pause();
      this.D = true;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\core\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */