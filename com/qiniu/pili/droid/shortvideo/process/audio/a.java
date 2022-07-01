package com.qiniu.pili.droid.shortvideo.process.audio;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLComposeItem;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.f;
import com.qiniu.pili.droid.shortvideo.f.h;
import com.qiniu.pili.droid.shortvideo.transcoder.audio.AudioMixer;
import com.qiniu.pili.droid.shortvideo.transcoder.audio.AudioTransformer;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public class a {
  private static final boolean a = h.a().c();
  
  private Object A = new Object();
  
  private float B = 1.0F;
  
  private float C = 1.0F;
  
  private b D;
  
  private long E;
  
  private boolean F = false;
  
  private com.qiniu.pili.droid.shortvideo.encode.a.a G = new com.qiniu.pili.droid.shortvideo.encode.a.a(this) {
      public void a(MediaFormat param1MediaFormat) {
        if (a.b(this.a) != null)
          a.b(this.a).a(param1MediaFormat); 
      }
      
      public void a(Surface param1Surface) {}
      
      public void a(ByteBuffer param1ByteBuffer, MediaCodec.BufferInfo param1BufferInfo) {
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("muxer write audio: ");
        stringBuilder.append(param1BufferInfo.presentationTimeUs);
        e.b("MultiAudioComposer", stringBuilder.toString());
        if (a.b(this.a) != null)
          a.b(this.a).a(param1ByteBuffer, param1BufferInfo); 
      }
      
      public void a(boolean param1Boolean) {
        if (param1Boolean) {
          a a1 = this.a;
          a.a(a1, a.a(a1).poll());
        } 
        if (a.b(this.a) != null)
          a.b(this.a).a(param1Boolean); 
      }
      
      public void b(boolean param1Boolean) {
        e.t.c("MultiAudioComposer", "audio encode stopped");
        if (a.b(this.a) != null)
          a.b(this.a).b(param1Boolean); 
      }
    };
  
  private LinkedList<PLComposeItem> b;
  
  private int c;
  
  private int d;
  
  private long e;
  
  private int f;
  
  private com.qiniu.pili.droid.shortvideo.encode.c g;
  
  private com.qiniu.pili.droid.shortvideo.d.b h;
  
  private com.qiniu.pili.droid.shortvideo.d.b i;
  
  private long j;
  
  private com.qiniu.pili.droid.shortvideo.encode.a.a k;
  
  private String l;
  
  private AudioTransformer m;
  
  private ByteBuffer n;
  
  private long o = 0L;
  
  private MediaFormat p;
  
  private volatile boolean q;
  
  private volatile boolean r;
  
  private volatile AudioMixer s;
  
  private ByteBuffer t;
  
  private int u;
  
  private boolean v;
  
  private Object w = new Object();
  
  private boolean x;
  
  private Object y = new Object();
  
  private boolean z;
  
  public a(List<PLComposeItem> paramList) {
    this.b = new LinkedList<PLComposeItem>(paramList);
    for (int i = 0; i < this.b.size(); i++) {
      if (((PLComposeItem)this.b.get(i)).getItemType() == PLComposeItem.ItemType.VIDEO) {
        e e;
        f f = new f(((PLComposeItem)this.b.get(i)).getFilePath(), false, true);
        if (f.f() != null) {
          this.p = f.f();
          this.c = f.o();
          this.d = f.n();
          f.a();
          e = e.t;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("found output audio format: ");
          stringBuilder.append(this.p);
          stringBuilder.append(" in file: ");
          stringBuilder.append(((PLComposeItem)this.b.get(i)).getFilePath());
          e.c("MultiAudioComposer", stringBuilder.toString());
          return;
        } 
        e.a();
      } 
    } 
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (this.s != null)
      this.s.a(); 
    this.s = new AudioMixer();
    this.s.a(this.C, this.B);
    this.s.a(paramInt1, paramInt2, paramInt3, paramInt4);
    e e = e.t;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setupAudioMixer : mainSampleRate ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" mainChannels ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" otherSampleRate ");
    stringBuilder.append(paramInt3);
    stringBuilder.append(" otherChannels ");
    stringBuilder.append(paramInt4);
    e.c("MultiAudioComposer", stringBuilder.toString());
  }
  
  private void a(PLComposeItem paramPLComposeItem) {
    e e = e.t;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("compose audio + ");
    stringBuilder.append(paramPLComposeItem.getFilePath());
    e.c("MultiAudioComposer", stringBuilder.toString());
    if (e() && this.i == null)
      a((com.qiniu.pili.droid.shortvideo.d.b.d)null, new c()); 
    f f = new f(paramPLComposeItem.getFilePath(), false, true);
    if (f.f() != null) {
      b(paramPLComposeItem);
    } else {
      (new Thread(new Runnable(this, paramPLComposeItem) {
            public void run() {
              if (a.c(this.b)) {
                a.b(this.b, this.a);
                return;
              } 
              a.c(this.b, this.a);
            }
          })).start();
    } 
    f.a();
    e.t.c("MultiAudioComposer", "compose audio -");
  }
  
  private void a(com.qiniu.pili.droid.shortvideo.d.b.d paramd, com.qiniu.pili.droid.shortvideo.d.b.c paramc) {
    f f = new f(this.l, false, true);
    if (f.f() != null) {
      this.i = new com.qiniu.pili.droid.shortvideo.d.b(f.d(), f.f());
      if (paramc != null)
        this.i.a(paramc); 
      if (paramd != null)
        this.i.a(paramd); 
      this.i.a();
    } 
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.m = new AudioTransformer();
    this.o = this.m.init(paramInt1, paramInt2, 16, paramInt3, paramInt4, 16);
  }
  
  private void b(PLComposeItem paramPLComposeItem) {
    e e;
    f f = new f(paramPLComposeItem.getFilePath(), false, true);
    if (f.f() == null) {
      e = e.t;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("the item has no audio format, do not need startSrcExtractor ! item path is : ");
      stringBuilder.append(paramPLComposeItem.getFilePath());
      e.c("MultiAudioComposer", stringBuilder.toString());
      return;
    } 
    this.h = new com.qiniu.pili.droid.shortvideo.d.b(e.d(), e.f());
    if (e()) {
      this.D = new b();
      this.h.a(this.D);
    } else {
      this.h.a(new a());
    } 
    this.h.a(new d());
    this.h.a();
  }
  
  private void c(PLComposeItem paramPLComposeItem) {
    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(this.f);
    long l2 = paramPLComposeItem.getDurationMs();
    long l1;
    for (l1 = 0L; l1 < l2 * 1000L && !this.q; l1 += this.e) {
      this.g.a(byteBuffer, byteBuffer.remaining(), this.j + l1);
      byteBuffer.clear();
    } 
    if (this.q) {
      h();
      return;
    } 
    this.j += l1;
    f();
  }
  
  private void d(PLComposeItem paramPLComposeItem) {
    int i = this.c;
    int j = this.d;
    a(i, j, i, j);
    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(this.f);
    long l2 = paramPLComposeItem.getDurationMs();
    if (this.D == null)
      this.D = new b(); 
    long l1;
    for (l1 = 0L; l1 < l2 * 1000L && !this.q; l1 += this.e)
      this.D.a(byteBuffer, byteBuffer.capacity(), 0L, 0L, false); 
    this.D.a(byteBuffer, byteBuffer.capacity(), 0L, 0L, true);
  }
  
  private boolean e() {
    return (this.l != null);
  }
  
  private void f() {
    if (!this.b.isEmpty()) {
      a(this.b.poll());
      return;
    } 
    this.g.c();
  }
  
  private boolean g() {
    a(new com.qiniu.pili.droid.shortvideo.d.b.d(this) {
          public void a(MediaFormat param1MediaFormat) {
            null = e.t;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("got music decoder format: ");
            stringBuilder.append(param1MediaFormat);
            null.c("MultiAudioComposer", stringBuilder.toString());
            a.a(this.a, param1MediaFormat);
            a.a(this.a, param1MediaFormat.getInteger("sample-rate"));
            a.b(this.a, param1MediaFormat.getInteger("channel-count"));
            synchronized (a.d(this.a)) {
              a.a(this.a, true);
              a.d(this.a).notify();
              return;
            } 
          }
        }(com.qiniu.pili.droid.shortvideo.d.b.c)null);
    synchronized (this.A) {
      while (true) {
        boolean bool = this.z;
        if (!bool) {
          try {
            this.A.wait();
          } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
            return false;
          } 
          continue;
        } 
        this.i.c();
        this.i = null;
        return true;
      } 
    } 
  }
  
  private void h() {
    com.qiniu.pili.droid.shortvideo.d.b b1 = this.h;
    if (b1 != null)
      b1.c(); 
    b1 = this.i;
    if (b1 != null)
      b1.c(); 
    com.qiniu.pili.droid.shortvideo.encode.c c1 = this.g;
    if (c1 != null)
      c1.c(); 
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    this.B = paramFloat1;
    this.C = paramFloat2;
  }
  
  public void a(com.qiniu.pili.droid.shortvideo.encode.a.a parama) {
    this.k = parama;
  }
  
  public void a(String paramString) {
    e e;
    if (paramString == null) {
      e.t.e("MultiAudioComposer", "setAudioMixFile error, the audio mix file can not be null !");
      return;
    } 
    f f = new f(paramString, false, true);
    if (f.f() != null) {
      this.l = paramString;
      this.p = f.f();
      e = e.t;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setAudioMixFile the mix file is : ");
      stringBuilder.append(this.l);
      e.c("MultiAudioComposer", stringBuilder.toString());
    } else {
      e e1 = e.t;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setAudioMixFile error, there is no audio format can be found! the file is : ");
      stringBuilder.append((String)e);
      e1.e("MultiAudioComposer", stringBuilder.toString());
    } 
    f.a();
  }
  
  public boolean a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield r : Z
    //   7: aload_0
    //   8: getfield p : Landroid/media/MediaFormat;
    //   11: ifnull -> 133
    //   14: getstatic com/qiniu/pili/droid/shortvideo/process/audio/a.a : Z
    //   17: ifeq -> 133
    //   20: aload_0
    //   21: invokespecial e : ()Z
    //   24: ifeq -> 40
    //   27: aload_0
    //   28: invokespecial g : ()Z
    //   31: istore_1
    //   32: iload_1
    //   33: ifne -> 40
    //   36: aload_0
    //   37: monitorexit
    //   38: iconst_0
    //   39: ireturn
    //   40: aload_0
    //   41: sipush #2048
    //   44: aload_0
    //   45: getfield d : I
    //   48: imul
    //   49: putfield f : I
    //   52: aload_0
    //   53: sipush #1024
    //   56: i2d
    //   57: ldc2_w 1000000.0
    //   60: dmul
    //   61: aload_0
    //   62: getfield c : I
    //   65: i2d
    //   66: ddiv
    //   67: d2l
    //   68: putfield e : J
    //   71: new com/qiniu/pili/droid/shortvideo/PLAudioEncodeSetting
    //   74: dup
    //   75: invokespecial <init> : ()V
    //   78: astore_2
    //   79: aload_2
    //   80: aload_0
    //   81: getfield d : I
    //   84: invokevirtual setChannels : (I)Lcom/qiniu/pili/droid/shortvideo/PLAudioEncodeSetting;
    //   87: pop
    //   88: aload_2
    //   89: aload_0
    //   90: getfield c : I
    //   93: invokevirtual setSampleRate : (I)Lcom/qiniu/pili/droid/shortvideo/PLAudioEncodeSetting;
    //   96: pop
    //   97: aload_0
    //   98: new com/qiniu/pili/droid/shortvideo/encode/c
    //   101: dup
    //   102: aload_2
    //   103: invokespecial <init> : (Lcom/qiniu/pili/droid/shortvideo/PLAudioEncodeSetting;)V
    //   106: putfield g : Lcom/qiniu/pili/droid/shortvideo/encode/c;
    //   109: aload_0
    //   110: getfield g : Lcom/qiniu/pili/droid/shortvideo/encode/c;
    //   113: aload_0
    //   114: getfield G : Lcom/qiniu/pili/droid/shortvideo/encode/a$a;
    //   117: invokevirtual a : (Lcom/qiniu/pili/droid/shortvideo/encode/a$a;)V
    //   120: aload_0
    //   121: getfield g : Lcom/qiniu/pili/droid/shortvideo/encode/c;
    //   124: invokevirtual a : ()Z
    //   127: pop
    //   128: aload_0
    //   129: iconst_1
    //   130: putfield r : Z
    //   133: aload_0
    //   134: getfield r : Z
    //   137: istore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: iload_1
    //   141: ireturn
    //   142: astore_2
    //   143: aload_0
    //   144: monitorexit
    //   145: aload_2
    //   146: athrow
    // Exception table:
    //   from	to	target	type
    //   2	32	142	finally
    //   40	133	142	finally
    //   133	138	142	finally
  }
  
  public void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield r : Z
    //   6: ifeq -> 28
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield q : Z
    //   14: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   17: ldc 'MultiAudioComposer'
    //   19: ldc_w 'cancel compose'
    //   22: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   25: goto -> 39
    //   28: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   31: ldc 'MultiAudioComposer'
    //   33: ldc_w 'cancel compose failed'
    //   36: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Exception table:
    //   from	to	target	type
    //   2	25	42	finally
    //   28	39	42	finally
  }
  
  public void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: ldc 'MultiAudioComposer'
    //   7: ldc_w 'destroy +'
    //   10: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield m : Lcom/qiniu/pili/droid/shortvideo/transcoder/audio/AudioTransformer;
    //   17: ifnull -> 36
    //   20: aload_0
    //   21: getfield m : Lcom/qiniu/pili/droid/shortvideo/transcoder/audio/AudioTransformer;
    //   24: aload_0
    //   25: getfield o : J
    //   28: invokevirtual destroy : (J)V
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield m : Lcom/qiniu/pili/droid/shortvideo/transcoder/audio/AudioTransformer;
    //   36: aload_0
    //   37: getfield s : Lcom/qiniu/pili/droid/shortvideo/transcoder/audio/AudioMixer;
    //   40: ifnull -> 51
    //   43: aload_0
    //   44: getfield s : Lcom/qiniu/pili/droid/shortvideo/transcoder/audio/AudioMixer;
    //   47: invokevirtual a : ()Z
    //   50: pop
    //   51: aload_0
    //   52: iconst_0
    //   53: putfield c : I
    //   56: aload_0
    //   57: iconst_0
    //   58: putfield d : I
    //   61: aload_0
    //   62: lconst_0
    //   63: putfield e : J
    //   66: aload_0
    //   67: iconst_0
    //   68: putfield f : I
    //   71: aload_0
    //   72: aconst_null
    //   73: putfield b : Ljava/util/LinkedList;
    //   76: aload_0
    //   77: aconst_null
    //   78: putfield h : Lcom/qiniu/pili/droid/shortvideo/d/b;
    //   81: aload_0
    //   82: aconst_null
    //   83: putfield i : Lcom/qiniu/pili/droid/shortvideo/d/b;
    //   86: aload_0
    //   87: aconst_null
    //   88: putfield n : Ljava/nio/ByteBuffer;
    //   91: aload_0
    //   92: lconst_0
    //   93: putfield o : J
    //   96: aload_0
    //   97: lconst_0
    //   98: putfield j : J
    //   101: aload_0
    //   102: aconst_null
    //   103: putfield g : Lcom/qiniu/pili/droid/shortvideo/encode/c;
    //   106: aload_0
    //   107: aconst_null
    //   108: putfield l : Ljava/lang/String;
    //   111: aload_0
    //   112: aconst_null
    //   113: putfield p : Landroid/media/MediaFormat;
    //   116: aload_0
    //   117: iconst_0
    //   118: putfield q : Z
    //   121: aload_0
    //   122: iconst_0
    //   123: putfield r : Z
    //   126: aload_0
    //   127: aconst_null
    //   128: putfield s : Lcom/qiniu/pili/droid/shortvideo/transcoder/audio/AudioMixer;
    //   131: aload_0
    //   132: aconst_null
    //   133: putfield t : Ljava/nio/ByteBuffer;
    //   136: aload_0
    //   137: iconst_0
    //   138: putfield u : I
    //   141: aload_0
    //   142: iconst_0
    //   143: putfield v : Z
    //   146: aload_0
    //   147: iconst_0
    //   148: putfield x : Z
    //   151: aload_0
    //   152: iconst_0
    //   153: putfield z : Z
    //   156: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   159: ldc 'MultiAudioComposer'
    //   161: ldc_w 'destroy -'
    //   164: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   167: aload_0
    //   168: monitorexit
    //   169: return
    //   170: astore_1
    //   171: aload_0
    //   172: monitorexit
    //   173: aload_1
    //   174: athrow
    // Exception table:
    //   from	to	target	type
    //   2	36	170	finally
    //   36	51	170	finally
    //   51	167	170	finally
  }
  
  public boolean d() {
    return this.r;
  }
  
  class a implements com.qiniu.pili.droid.shortvideo.d.b.c {
    private long b;
    
    private a(a this$0) {}
    
    public void a(ByteBuffer param1ByteBuffer, int param1Int, long param1Long1, long param1Long2, boolean param1Boolean) {
      a a1;
      if (a.g(this.a) == null) {
        e.t.d("mResampler has not been init !");
        return;
      } 
      if (param1Boolean) {
        a1 = this.a;
        a.a(a1, a.h(a1) + this.b + a.i(this.a));
        a.g(this.a).destroy(a.j(this.a));
        a.a(this.a, (AudioTransformer)null);
        a.k(this.a);
        return;
      } 
      if (a.l(this.a) == null) {
        a.a(this.a, ByteBuffer.allocateDirect(a1.capacity() * 4));
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("init mResampledFramesBuffer with size: ");
        stringBuilder.append(a.l(this.a).capacity());
        e.c("MultiAudioComposer", stringBuilder.toString());
      } 
      param1Int = a.g(this.a).resample(a.j(this.a), (ByteBuffer)a1, a1.position(), param1Int, a.l(this.a), a.l(this.a).position(), 0);
      a.l(this.a).position(a.l(this.a).position() + param1Int);
      while (a.l(this.a).position() >= a.m(this.a)) {
        param1Int = a.l(this.a).position();
        int i = a.m(this.a);
        a.l(this.a).flip();
        a.n(this.a).a(a.l(this.a), a.m(this.a), a.h(this.a) + this.b);
        a.l(this.a).clear();
        a.l(this.a).put(a.l(this.a).array(), a.l(this.a).arrayOffset() + a.m(this.a), param1Int - i);
        this.b += a.i(this.a);
      } 
      if (a.o(this.a))
        a.p(this.a); 
    }
  }
  
  class b implements com.qiniu.pili.droid.shortvideo.d.b.c {
    private b(a this$0) {}
    
    private void a() {
      synchronized (a.r(this.a)) {
        a.c(this.a, true);
        a.r(this.a).notify();
        return;
      } 
    }
    
    private boolean b() {
      // Byte code:
      //   0: aload_0
      //   1: getfield a : Lcom/qiniu/pili/droid/shortvideo/process/audio/a;
      //   4: invokestatic q : (Lcom/qiniu/pili/droid/shortvideo/process/audio/a;)Ljava/lang/Object;
      //   7: astore_2
      //   8: aload_2
      //   9: monitorenter
      //   10: aload_0
      //   11: getfield a : Lcom/qiniu/pili/droid/shortvideo/process/audio/a;
      //   14: invokestatic n : (Lcom/qiniu/pili/droid/shortvideo/process/audio/a;)Lcom/qiniu/pili/droid/shortvideo/encode/c;
      //   17: invokevirtual l : ()Z
      //   20: ifeq -> 53
      //   23: aload_0
      //   24: getfield a : Lcom/qiniu/pili/droid/shortvideo/process/audio/a;
      //   27: invokestatic w : (Lcom/qiniu/pili/droid/shortvideo/process/audio/a;)Z
      //   30: istore_1
      //   31: iload_1
      //   32: ifne -> 48
      //   35: aload_0
      //   36: getfield a : Lcom/qiniu/pili/droid/shortvideo/process/audio/a;
      //   39: invokestatic q : (Lcom/qiniu/pili/droid/shortvideo/process/audio/a;)Ljava/lang/Object;
      //   42: invokevirtual wait : ()V
      //   45: goto -> 23
      //   48: iconst_1
      //   49: istore_1
      //   50: goto -> 55
      //   53: iconst_0
      //   54: istore_1
      //   55: iload_1
      //   56: ifeq -> 71
      //   59: aload_0
      //   60: getfield a : Lcom/qiniu/pili/droid/shortvideo/process/audio/a;
      //   63: iconst_0
      //   64: invokestatic b : (Lcom/qiniu/pili/droid/shortvideo/process/audio/a;Z)Z
      //   67: pop
      //   68: goto -> 92
      //   71: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
      //   74: ldc 'MultiAudioComposer'
      //   76: ldc 'src audio eof, so stop music audio too.'
      //   78: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
      //   81: aload_0
      //   82: getfield a : Lcom/qiniu/pili/droid/shortvideo/process/audio/a;
      //   85: invokestatic x : (Lcom/qiniu/pili/droid/shortvideo/process/audio/a;)Lcom/qiniu/pili/droid/shortvideo/d/b;
      //   88: invokevirtual c : ()Z
      //   91: pop
      //   92: aload_2
      //   93: monitorexit
      //   94: iload_1
      //   95: ireturn
      //   96: astore_3
      //   97: aload_2
      //   98: monitorexit
      //   99: aload_3
      //   100: athrow
      //   101: astore_3
      //   102: goto -> 53
      // Exception table:
      //   from	to	target	type
      //   10	23	96	finally
      //   23	31	96	finally
      //   35	45	101	java/lang/InterruptedException
      //   35	45	96	finally
      //   59	68	96	finally
      //   71	92	96	finally
      //   92	94	96	finally
      //   97	99	96	finally
    }
    
    public void a(ByteBuffer param1ByteBuffer, int param1Int, long param1Long1, long param1Long2, boolean param1Boolean) {
      if (a.o(this.a)) {
        a.p(this.a);
        return;
      } 
      if (param1Boolean) {
        a.k(this.a);
        return;
      } 
      if (!a.y(this.a) && !b())
        return; 
      while (a.z(this.a).a(a.u(this.a), a.v(this.a))) {
        a();
        b();
      } 
      a.z(this.a).b(param1ByteBuffer, param1Int);
      a.d(this.a, true);
    }
  }
  
  class c implements com.qiniu.pili.droid.shortvideo.d.b.c {
    private c(a this$0) {}
    
    private void a() {
      synchronized (a.q(this.a)) {
        a.b(this.a, true);
        a.q(this.a).notify();
        return;
      } 
    }
    
    private void b() {
      synchronized (a.r(this.a)) {
        while (true) {
          boolean bool = a.s(this.a);
          if (!bool) {
            try {
              a.r(this.a).wait();
            } catch (InterruptedException interruptedException) {
              return;
            } 
            continue;
          } 
          a.c(this.a, false);
          return;
        } 
      } 
    }
    
    public void a(ByteBuffer param1ByteBuffer, int param1Int, long param1Long1, long param1Long2, boolean param1Boolean) {
      a a1;
      if (param1Boolean) {
        while (a.n(this.a).l()) {
          param1ByteBuffer = ByteBuffer.allocateDirect(a.m(this.a));
          a.b(this.a, param1ByteBuffer);
          a.c(this.a, param1ByteBuffer.capacity());
          a();
          b();
          a1 = this.a;
          a.b(a1, a.t(a1) + a.i(this.a));
          a.n(this.a).a(a.u(this.a), a.v(this.a), a.t(this.a));
        } 
        return;
      } 
      a.b(this.a, (ByteBuffer)a1);
      a.c(this.a, param1Int);
      a();
      b();
      a.n(this.a).a((ByteBuffer)a1, param1Int, param1Long1);
      a.b(this.a, param1Long1);
    }
  }
  
  class d implements com.qiniu.pili.droid.shortvideo.d.b.d {
    private d(a this$0) {}
    
    public void a(MediaFormat param1MediaFormat) {
      e e = e.t;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("got src audio decoder format: ");
      stringBuilder.append(param1MediaFormat);
      e.c("MultiAudioComposer", stringBuilder.toString());
      if (a.c(this.a)) {
        a a1 = this.a;
        a.a(a1, a.e(a1), a.f(this.a), param1MediaFormat.getInteger("sample-rate"), param1MediaFormat.getInteger("channel-count"));
        return;
      } 
      a.b(this.a, param1MediaFormat.getInteger("sample-rate"), param1MediaFormat.getInteger("channel-count"), a.e(this.a), a.f(this.a));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\process\audio\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */