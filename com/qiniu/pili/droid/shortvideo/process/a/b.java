package com.qiniu.pili.droid.shortvideo.process.a;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoRange;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.encode.c;
import com.qiniu.pili.droid.shortvideo.encode.e;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.f;
import com.qiniu.pili.droid.shortvideo.f.h;
import com.qiniu.pili.droid.shortvideo.transcoder.audio.AudioTransformer;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class b {
  private static final boolean a = h.a().c();
  
  private long A;
  
  private long B;
  
  private long C = 0L;
  
  private AudioTransformer D;
  
  private ByteBuffer E;
  
  private long F = 0L;
  
  private LinkedList<PLVideoRange> G;
  
  private LinkedList<PLVideoRange> H;
  
  private final PLVideoSaveListener I = new PLVideoSaveListener(this) {
      public void onProgressUpdate(float param1Float) {
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onProgressUpdate: ");
        stringBuilder.append(param1Float);
        e.c("MultiVideoComposer", stringBuilder.toString());
      }
      
      public void onSaveVideoCanceled() {
        e.t.c("MultiVideoComposer", "onSaveVideoCanceled");
      }
      
      public void onSaveVideoFailed(int param1Int) {
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSaveVideoFailed: ");
        stringBuilder.append(param1Int);
        e.c("MultiVideoComposer", stringBuilder.toString());
      }
      
      public void onSaveVideoSuccess(String param1String) {
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSaveVideoSuccess: ");
        stringBuilder.append(param1String);
        e.c("MultiVideoComposer", stringBuilder.toString());
      }
    };
  
  private com.qiniu.pili.droid.shortvideo.encode.a.a J = new com.qiniu.pili.droid.shortvideo.encode.a.a(this) {
      public void a(MediaFormat param1MediaFormat) {
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("video encode output format retrieved: ");
        stringBuilder.append(param1MediaFormat);
        e.c("MultiVideoComposer", stringBuilder.toString());
        b.a(this.a, param1MediaFormat);
        b.k(this.a);
      }
      
      public void a(Surface param1Surface) {
        e.t.c("MultiVideoComposer", "encode surface created");
        b.a(this.a, param1Surface);
      }
      
      public void a(ByteBuffer param1ByteBuffer, MediaCodec.BufferInfo param1BufferInfo) {
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("muxer write video: ");
        stringBuilder.append(param1BufferInfo.presentationTimeUs);
        e.b("MultiVideoComposer", stringBuilder.toString());
        if (b.l(this.a) != null) {
          b.l(this.a).a(param1ByteBuffer, param1BufferInfo);
          float f2 = (float)param1BufferInfo.presentationTimeUs * 1.0F / (float)b.m(this.a);
          PLVideoSaveListener pLVideoSaveListener = b.n(this.a);
          float f1 = f2;
          if (f2 > 1.0F)
            f1 = 1.0F; 
          pLVideoSaveListener.onProgressUpdate(f1);
        } 
      }
      
      public void a(boolean param1Boolean) {
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("video encode started result: ");
        stringBuilder.append(param1Boolean);
        e.c("MultiVideoComposer", stringBuilder.toString());
        if (param1Boolean) {
          b b1 = this.a;
          b.b(b1, b.i(b1).poll());
          return;
        } 
        b.a(this.a, 6);
      }
      
      public void b(boolean param1Boolean) {
        e.t.c("MultiVideoComposer", "video encode stopped");
        b.j(this.a);
      }
    };
  
  private com.qiniu.pili.droid.shortvideo.encode.a.a K = new com.qiniu.pili.droid.shortvideo.encode.a.a(this) {
      public void a(MediaFormat param1MediaFormat) {
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("audio encode output format retrieved: ");
        stringBuilder.append(param1MediaFormat);
        e.c("MultiVideoComposer", stringBuilder.toString());
        b.b(this.a, param1MediaFormat);
        b.k(this.a);
      }
      
      public void a(Surface param1Surface) {}
      
      public void a(ByteBuffer param1ByteBuffer, MediaCodec.BufferInfo param1BufferInfo) {
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("muxer write audio: ");
        stringBuilder.append(param1BufferInfo.presentationTimeUs);
        e.b("MultiVideoComposer", stringBuilder.toString());
        if (b.l(this.a) != null)
          b.l(this.a).b(param1ByteBuffer, param1BufferInfo); 
      }
      
      public void a(boolean param1Boolean) {
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("audio encode started result: ");
        stringBuilder.append(param1Boolean);
        e.c("MultiVideoComposer", stringBuilder.toString());
        if (param1Boolean) {
          b b1 = this.a;
          b.a(b1, b.h(b1).poll());
          return;
        } 
        b.a(this.a, 7);
      }
      
      public void b(boolean param1Boolean) {
        e.t.c("MultiVideoComposer", "audio encode stopped");
        b.j(this.a);
      }
    };
  
  private com.qiniu.pili.droid.shortvideo.gl.b.a.b L = new com.qiniu.pili.droid.shortvideo.gl.b.a.b(this) {
      public int a(int param1Int1, int param1Int2, int param1Int3, long param1Long, float[] param1ArrayOffloat) {
        b.q(this.a);
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("offscreen surface onDrawFrame: ");
        stringBuilder.append(param1Long);
        e.b("MultiVideoComposer", stringBuilder.toString());
        b.r(this.a).a(param1Long);
        return param1Int1;
      }
      
      public void a() {}
      
      public void a(int param1Int1, int param1Int2) {}
      
      public void a(Object param1Object, Surface param1Surface) {
        b.o(this.a).a(new b.b());
        b.o(this.a).a(param1Surface);
        param1Object = this.a;
        if (b.a((b)param1Object, b.p((b)param1Object))) {
          param1Object = b.p(this.a).getFirst();
          b.o(this.a).a(param1Object.getStartTime() * 1000L, param1Object.getEndTime() * 1000L);
          return;
        } 
        b.o(this.a).a();
      }
      
      public void b() {
        b.q(this.a);
      }
    };
  
  private boolean b = false;
  
  private final Object c = new Object();
  
  private LinkedList<String> d;
  
  private LinkedList<String> e;
  
  private String f;
  
  private PLVideoSaveListener g;
  
  private PLVideoEncodeSetting h;
  
  private e i;
  
  private com.qiniu.pili.droid.shortvideo.gl.b.a j;
  
  private com.qiniu.pili.droid.shortvideo.d.b k;
  
  private c l;
  
  private com.qiniu.pili.droid.shortvideo.d.b m;
  
  private com.qiniu.pili.droid.shortvideo.muxer.b n;
  
  private int o = 0;
  
  private int p = 0;
  
  private MediaFormat q;
  
  private MediaFormat r;
  
  private volatile Surface s;
  
  private int t;
  
  private int u;
  
  private long v;
  
  private int w;
  
  private volatile boolean x;
  
  private volatile boolean y;
  
  private volatile int z = -1;
  
  private void a(int paramInt) {
    e e1 = e.t;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("exceptionalStop + ");
    stringBuilder.append(paramInt);
    e1.c("MultiVideoComposer", stringBuilder.toString());
    this.z = paramInt;
    a();
    c();
    e1 = e.t;
    stringBuilder = new StringBuilder();
    stringBuilder.append("exceptionalStop - ");
    stringBuilder.append(paramInt);
    e1.c("MultiVideoComposer", stringBuilder.toString());
  }
  
  private void a(String paramString) {
    e e1 = e.t;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("compose video + ");
    stringBuilder.append(paramString);
    e1.c("MultiVideoComposer", stringBuilder.toString());
    boolean bool3 = false;
    boolean bool2 = false;
    f f = new f(paramString, true, false);
    this.k = new com.qiniu.pili.droid.shortvideo.d.b(f.c(), f.e());
    MediaFormat mediaFormat = f.e();
    if (mediaFormat.containsKey("rotation-degrees")) {
      int i = mediaFormat.getInteger("rotation-degrees");
    } else if (mediaFormat.containsKey("rotation")) {
      int i = mediaFormat.getInteger("rotation");
    } else {
      int i = f.m();
      boolean bool = false;
      List list1 = f.p();
    } 
    boolean bool1 = false;
    List list = f.p();
  }
  
  private boolean a(LinkedList<PLVideoRange> paramLinkedList) {
    return (paramLinkedList != null && !paramLinkedList.isEmpty()) ? ((PLVideoRange)paramLinkedList.getFirst()).isValidRange() : false;
  }
  
  private void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: ldc 'MultiVideoComposer'
    //   7: ldc_w 'startMuxer +'
    //   10: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: aload_0
    //   15: getfield o : I
    //   18: iconst_1
    //   19: iadd
    //   20: putfield o : I
    //   23: aload_0
    //   24: getfield l : Lcom/qiniu/pili/droid/shortvideo/encode/c;
    //   27: ifnull -> 64
    //   30: aload_0
    //   31: getfield o : I
    //   34: iconst_2
    //   35: if_icmpge -> 64
    //   38: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   41: ldc 'MultiVideoComposer'
    //   43: ldc_w 'not ready to start muxer.'
    //   46: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_0
    //   50: invokevirtual wait : ()V
    //   53: goto -> 61
    //   56: astore_1
    //   57: aload_1
    //   58: invokevirtual printStackTrace : ()V
    //   61: aload_0
    //   62: monitorexit
    //   63: return
    //   64: aload_0
    //   65: new com/qiniu/pili/droid/shortvideo/muxer/b
    //   68: dup
    //   69: invokespecial <init> : ()V
    //   72: putfield n : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   75: aload_0
    //   76: getfield n : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   79: aload_0
    //   80: getfield f : Ljava/lang/String;
    //   83: aload_0
    //   84: getfield q : Landroid/media/MediaFormat;
    //   87: aload_0
    //   88: getfield r : Landroid/media/MediaFormat;
    //   91: iconst_0
    //   92: invokevirtual a : (Ljava/lang/String;Landroid/media/MediaFormat;Landroid/media/MediaFormat;I)Z
    //   95: ifne -> 116
    //   98: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   101: ldc 'MultiVideoComposer'
    //   103: ldc_w 'start muxer failed!'
    //   106: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload_0
    //   110: invokevirtual a : ()V
    //   113: goto -> 131
    //   116: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   119: ldc 'MultiVideoComposer'
    //   121: ldc_w 'start muxer success!'
    //   124: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload_0
    //   128: invokevirtual notify : ()V
    //   131: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   134: ldc 'MultiVideoComposer'
    //   136: ldc_w 'startMuxer -'
    //   139: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload_0
    //   143: monitorexit
    //   144: return
    //   145: astore_1
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_1
    //   149: athrow
    // Exception table:
    //   from	to	target	type
    //   2	49	145	finally
    //   49	53	56	java/lang/InterruptedException
    //   49	53	145	finally
    //   57	61	145	finally
    //   64	113	145	finally
    //   116	131	145	finally
    //   131	142	145	finally
  }
  
  private void b(String paramString) {
    PLVideoRange pLVideoRange;
    e e1 = e.t;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("compose audio + ");
    stringBuilder.append(paramString);
    e1.c("MultiVideoComposer", stringBuilder.toString());
    f f = new f(paramString, false, true);
    if (f.f() != null) {
      this.m = new com.qiniu.pili.droid.shortvideo.d.b(f.d(), f.f());
      this.m.a(new a());
      this.m.a(new com.qiniu.pili.droid.shortvideo.d.b.d(this) {
            public void a(MediaFormat param1MediaFormat) {
              e e = e.t;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("got audio decoder format: ");
              stringBuilder.append(param1MediaFormat);
              e.c("MultiVideoComposer", stringBuilder.toString());
              b.a(this.a, new AudioTransformer());
              b b1 = this.a;
              b.a(b1, b.c(b1).init(param1MediaFormat.getInteger("sample-rate"), param1MediaFormat.getInteger("channel-count"), 16, b.a(this.a), b.b(this.a), 16));
            }
          });
      if (a(this.H)) {
        pLVideoRange = this.H.poll();
        this.m.a(pLVideoRange.getStartTime() * 1000L, pLVideoRange.getEndTime() * 1000L);
      } else {
        this.m.a();
      } 
    } else {
      (new Thread(new Runnable(this, (f)pLVideoRange) {
            public void run() {
              ByteBuffer byteBuffer = ByteBuffer.allocateDirect(b.d(this.b));
              long l2 = this.a.g();
              long l1;
              for (l1 = 0L; l1 < l2 * 1000L; l1 += b.g(this.b)) {
                b.f(this.b).a(byteBuffer, byteBuffer.remaining(), b.e(this.b) + l1);
                byteBuffer.clear();
              } 
              b b1 = this.b;
              b.b(b1, b.e(b1) + l1);
              if (!b.h(this.b).isEmpty()) {
                b1 = this.b;
                b.a(b1, b.h(b1).poll());
                return;
              } 
              b.f(this.b).c();
            }
          })).start();
    } 
    e.t.c("MultiVideoComposer", "compose audio -");
  }
  
  private void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: ldc 'MultiVideoComposer'
    //   7: ldc_w 'stopMuxer +'
    //   10: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield p : I
    //   17: istore_2
    //   18: iconst_1
    //   19: istore_1
    //   20: aload_0
    //   21: iload_2
    //   22: iconst_1
    //   23: iadd
    //   24: putfield p : I
    //   27: aload_0
    //   28: getfield l : Lcom/qiniu/pili/droid/shortvideo/encode/c;
    //   31: ifnull -> 56
    //   34: aload_0
    //   35: getfield p : I
    //   38: iconst_2
    //   39: if_icmpge -> 56
    //   42: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   45: ldc 'MultiVideoComposer'
    //   47: ldc_w 'not ready to stop muxer.'
    //   50: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: aload_0
    //   57: getfield n : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   60: ifnull -> 382
    //   63: aload_0
    //   64: getfield n : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   67: invokevirtual a : ()Z
    //   70: ifeq -> 382
    //   73: goto -> 76
    //   76: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   79: astore #4
    //   81: new java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial <init> : ()V
    //   88: astore #5
    //   90: aload #5
    //   92: ldc_w 'stop muxer '
    //   95: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: iload_1
    //   100: ifeq -> 387
    //   103: ldc_w 'success'
    //   106: astore_3
    //   107: goto -> 110
    //   110: aload #5
    //   112: aload_3
    //   113: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload #4
    //   119: ldc 'MultiVideoComposer'
    //   121: aload #5
    //   123: invokevirtual toString : ()Ljava/lang/String;
    //   126: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload_0
    //   130: aconst_null
    //   131: putfield n : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   134: aload_0
    //   135: aconst_null
    //   136: putfield i : Lcom/qiniu/pili/droid/shortvideo/encode/e;
    //   139: aload_0
    //   140: aconst_null
    //   141: putfield l : Lcom/qiniu/pili/droid/shortvideo/encode/c;
    //   144: aload_0
    //   145: aconst_null
    //   146: putfield d : Ljava/util/LinkedList;
    //   149: aload_0
    //   150: aconst_null
    //   151: putfield e : Ljava/util/LinkedList;
    //   154: aload_0
    //   155: aconst_null
    //   156: putfield G : Ljava/util/LinkedList;
    //   159: aload_0
    //   160: aconst_null
    //   161: putfield H : Ljava/util/LinkedList;
    //   164: aload_0
    //   165: aconst_null
    //   166: putfield q : Landroid/media/MediaFormat;
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield r : Landroid/media/MediaFormat;
    //   174: aload_0
    //   175: aconst_null
    //   176: putfield k : Lcom/qiniu/pili/droid/shortvideo/d/b;
    //   179: aload_0
    //   180: aconst_null
    //   181: putfield m : Lcom/qiniu/pili/droid/shortvideo/d/b;
    //   184: aload_0
    //   185: aconst_null
    //   186: putfield s : Landroid/view/Surface;
    //   189: aload_0
    //   190: aconst_null
    //   191: putfield j : Lcom/qiniu/pili/droid/shortvideo/gl/b/a;
    //   194: aload_0
    //   195: aconst_null
    //   196: putfield D : Lcom/qiniu/pili/droid/shortvideo/transcoder/audio/AudioTransformer;
    //   199: aload_0
    //   200: aconst_null
    //   201: putfield E : Ljava/nio/ByteBuffer;
    //   204: aload_0
    //   205: lconst_0
    //   206: putfield F : J
    //   209: aload_0
    //   210: iconst_0
    //   211: putfield o : I
    //   214: aload_0
    //   215: iconst_0
    //   216: putfield p : I
    //   219: aload_0
    //   220: lconst_0
    //   221: putfield A : J
    //   224: aload_0
    //   225: lconst_0
    //   226: putfield B : J
    //   229: aload_0
    //   230: lconst_0
    //   231: putfield C : J
    //   234: aload_0
    //   235: iconst_0
    //   236: putfield y : Z
    //   239: aload_0
    //   240: getfield x : Z
    //   243: ifeq -> 308
    //   246: aload_0
    //   247: iconst_0
    //   248: putfield x : Z
    //   251: new java/io/File
    //   254: dup
    //   255: aload_0
    //   256: getfield f : Ljava/lang/String;
    //   259: invokespecial <init> : (Ljava/lang/String;)V
    //   262: invokevirtual delete : ()Z
    //   265: pop
    //   266: aload_0
    //   267: invokespecial d : ()Z
    //   270: ifeq -> 296
    //   273: aload_0
    //   274: getfield z : I
    //   277: istore_1
    //   278: aload_0
    //   279: iconst_m1
    //   280: putfield z : I
    //   283: aload_0
    //   284: getfield g : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   287: iload_1
    //   288: invokeinterface onSaveVideoFailed : (I)V
    //   293: goto -> 363
    //   296: aload_0
    //   297: getfield g : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   300: invokeinterface onSaveVideoCanceled : ()V
    //   305: goto -> 363
    //   308: iload_1
    //   309: ifeq -> 338
    //   312: aload_0
    //   313: getfield g : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   316: fconst_1
    //   317: invokeinterface onProgressUpdate : (F)V
    //   322: aload_0
    //   323: getfield g : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   326: aload_0
    //   327: getfield f : Ljava/lang/String;
    //   330: invokeinterface onSaveVideoSuccess : (Ljava/lang/String;)V
    //   335: goto -> 363
    //   338: new java/io/File
    //   341: dup
    //   342: aload_0
    //   343: getfield f : Ljava/lang/String;
    //   346: invokespecial <init> : (Ljava/lang/String;)V
    //   349: invokevirtual delete : ()Z
    //   352: pop
    //   353: aload_0
    //   354: getfield g : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   357: iconst_3
    //   358: invokeinterface onSaveVideoFailed : (I)V
    //   363: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   366: ldc 'MultiVideoComposer'
    //   368: ldc_w 'stopMuxer -'
    //   371: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   374: aload_0
    //   375: monitorexit
    //   376: return
    //   377: astore_3
    //   378: aload_0
    //   379: monitorexit
    //   380: aload_3
    //   381: athrow
    //   382: iconst_0
    //   383: istore_1
    //   384: goto -> 76
    //   387: ldc_w 'fail'
    //   390: astore_3
    //   391: goto -> 110
    // Exception table:
    //   from	to	target	type
    //   2	18	377	finally
    //   20	53	377	finally
    //   56	73	377	finally
    //   76	99	377	finally
    //   110	293	377	finally
    //   296	305	377	finally
    //   312	335	377	finally
    //   338	363	377	finally
    //   363	374	377	finally
  }
  
  private boolean c(String paramString) {
    if (paramString == null) {
      e.t.e("MultiVideoComposer", "dest video path is wrong!");
      return false;
    } 
    File file = (new File(paramString)).getParentFile();
    if (!file.exists() && !file.mkdir()) {
      e e1 = e.t;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("failed to mkdir: ");
      stringBuilder.append(file.getAbsolutePath());
      e1.e("MultiVideoComposer", stringBuilder.toString());
      return false;
    } 
    return true;
  }
  
  private boolean c(List<String> paramList, String paramString, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLVideoSaveListener paramPLVideoSaveListener) {
    PLVideoSaveListener pLVideoSaveListener = paramPLVideoSaveListener;
    if (paramPLVideoSaveListener == null)
      pLVideoSaveListener = this.I; 
    if (paramList == null || paramList.isEmpty() || paramString == null || paramPLVideoEncodeSetting == null) {
      e.t.e("MultiVideoComposer", "compose: invalid params !");
      pLVideoSaveListener.onSaveVideoFailed(10);
      return false;
    } 
    if (!c(paramString)) {
      e.t.e("MultiVideoComposer", "compose: destVideoPath is wrong!");
      return false;
    } 
    if (paramList.size() == 1) {
      e.t.d("MultiVideoComposer", "compose: only one src videos, ignore !");
      pLVideoSaveListener.onSaveVideoSuccess(paramList.get(0));
      return false;
    } 
    Iterator<String> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      if (((String)iterator.next()).equals(paramString)) {
        e.t.e("MultiVideoComposer", "compose failed, the dest video path must be different with src videos !");
        pLVideoSaveListener.onSaveVideoFailed(10);
        return false;
      } 
    } 
    return true;
  }
  
  private boolean d() {
    return (this.z >= 0);
  }
  
  private void e() {
    synchronized (this.c) {
      this.b = true;
      this.c.notify();
      return;
    } 
  }
  
  public void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield y : Z
    //   6: ifeq -> 28
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield x : Z
    //   14: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   17: ldc 'MultiVideoComposer'
    //   19: ldc_w 'cancel compose'
    //   22: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   25: goto -> 39
    //   28: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   31: ldc 'MultiVideoComposer'
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
  
  public boolean a(List<String> paramList, String paramString, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLVideoSaveListener paramPLVideoSaveListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: ldc 'MultiVideoComposer'
    //   7: ldc_w 'compose +'
    //   10: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield y : Z
    //   17: ifeq -> 35
    //   20: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   23: ldc 'MultiVideoComposer'
    //   25: ldc_w 'compose already started'
    //   28: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_0
    //   32: monitorexit
    //   33: iconst_0
    //   34: ireturn
    //   35: aload_0
    //   36: aload_1
    //   37: aload_2
    //   38: aload_3
    //   39: aload #4
    //   41: invokespecial c : (Ljava/util/List;Ljava/lang/String;Lcom/qiniu/pili/droid/shortvideo/PLVideoEncodeSetting;Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;)Z
    //   44: istore #6
    //   46: iload #6
    //   48: ifne -> 55
    //   51: aload_0
    //   52: monitorexit
    //   53: iconst_0
    //   54: ireturn
    //   55: aload_0
    //   56: getfield G : Ljava/util/LinkedList;
    //   59: ifnull -> 149
    //   62: aload_0
    //   63: getfield G : Ljava/util/LinkedList;
    //   66: invokevirtual isEmpty : ()Z
    //   69: ifne -> 149
    //   72: aload_0
    //   73: getfield G : Ljava/util/LinkedList;
    //   76: invokevirtual iterator : ()Ljava/util/Iterator;
    //   79: astore #11
    //   81: aload #11
    //   83: invokeinterface hasNext : ()Z
    //   88: ifeq -> 196
    //   91: aload #11
    //   93: invokeinterface next : ()Ljava/lang/Object;
    //   98: checkcast com/qiniu/pili/droid/shortvideo/PLVideoRange
    //   101: astore #12
    //   103: aload_0
    //   104: getfield C : J
    //   107: lstore #9
    //   109: aload #12
    //   111: invokevirtual isValidRange : ()Z
    //   114: ifeq -> 127
    //   117: aload #12
    //   119: invokevirtual getRangeTime : ()J
    //   122: lstore #7
    //   124: goto -> 137
    //   127: aload #12
    //   129: invokevirtual getVideoPath : ()Ljava/lang/String;
    //   132: invokestatic a : (Ljava/lang/Object;)J
    //   135: lstore #7
    //   137: aload_0
    //   138: lload #9
    //   140: lload #7
    //   142: ladd
    //   143: putfield C : J
    //   146: goto -> 81
    //   149: aload_1
    //   150: invokeinterface iterator : ()Ljava/util/Iterator;
    //   155: astore #11
    //   157: aload #11
    //   159: invokeinterface hasNext : ()Z
    //   164: ifeq -> 196
    //   167: aload #11
    //   169: invokeinterface next : ()Ljava/lang/Object;
    //   174: checkcast java/lang/String
    //   177: astore #12
    //   179: aload_0
    //   180: aload_0
    //   181: getfield C : J
    //   184: aload #12
    //   186: invokestatic a : (Ljava/lang/Object;)J
    //   189: ladd
    //   190: putfield C : J
    //   193: goto -> 157
    //   196: aload_0
    //   197: aload_0
    //   198: getfield C : J
    //   201: ldc2_w 1000
    //   204: lmul
    //   205: putfield C : J
    //   208: aload_0
    //   209: new java/util/LinkedList
    //   212: dup
    //   213: aload_1
    //   214: invokespecial <init> : (Ljava/util/Collection;)V
    //   217: putfield d : Ljava/util/LinkedList;
    //   220: aload_0
    //   221: new java/util/LinkedList
    //   224: dup
    //   225: aload_1
    //   226: invokespecial <init> : (Ljava/util/Collection;)V
    //   229: putfield e : Ljava/util/LinkedList;
    //   232: aload_0
    //   233: aload_2
    //   234: putfield f : Ljava/lang/String;
    //   237: aload #4
    //   239: astore_2
    //   240: aload #4
    //   242: ifnonnull -> 250
    //   245: aload_0
    //   246: getfield I : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   249: astore_2
    //   250: aload_0
    //   251: aload_2
    //   252: putfield g : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   255: aload_0
    //   256: aload_3
    //   257: putfield h : Lcom/qiniu/pili/droid/shortvideo/PLVideoEncodeSetting;
    //   260: aconst_null
    //   261: astore #4
    //   263: iconst_0
    //   264: istore #5
    //   266: aload #4
    //   268: astore_2
    //   269: iload #5
    //   271: aload_1
    //   272: invokeinterface size : ()I
    //   277: if_icmpge -> 405
    //   280: new com/qiniu/pili/droid/shortvideo/f/f
    //   283: dup
    //   284: aload_1
    //   285: iload #5
    //   287: invokeinterface get : (I)Ljava/lang/Object;
    //   292: checkcast java/lang/String
    //   295: iconst_0
    //   296: iconst_1
    //   297: invokespecial <init> : (Ljava/lang/String;ZZ)V
    //   300: astore #11
    //   302: aload #11
    //   304: invokevirtual f : ()Landroid/media/MediaFormat;
    //   307: ifnull -> 615
    //   310: aload #11
    //   312: invokevirtual f : ()Landroid/media/MediaFormat;
    //   315: astore_2
    //   316: aload_0
    //   317: aload #11
    //   319: invokevirtual o : ()I
    //   322: putfield t : I
    //   325: aload_0
    //   326: aload #11
    //   328: invokevirtual n : ()I
    //   331: putfield u : I
    //   334: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   337: astore #4
    //   339: new java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial <init> : ()V
    //   346: astore #11
    //   348: aload #11
    //   350: ldc_w 'found output audio format: '
    //   353: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload #11
    //   359: aload_2
    //   360: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload #11
    //   366: ldc_w ' in file: '
    //   369: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload #11
    //   375: aload_1
    //   376: iload #5
    //   378: invokeinterface get : (I)Ljava/lang/Object;
    //   383: checkcast java/lang/String
    //   386: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload #4
    //   392: ldc 'MultiVideoComposer'
    //   394: aload #11
    //   396: invokevirtual toString : ()Ljava/lang/String;
    //   399: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   402: goto -> 405
    //   405: aload_0
    //   406: new com/qiniu/pili/droid/shortvideo/encode/e
    //   409: dup
    //   410: aload_3
    //   411: invokespecial <init> : (Lcom/qiniu/pili/droid/shortvideo/PLVideoEncodeSetting;)V
    //   414: putfield i : Lcom/qiniu/pili/droid/shortvideo/encode/e;
    //   417: aload_0
    //   418: getfield i : Lcom/qiniu/pili/droid/shortvideo/encode/e;
    //   421: aload_0
    //   422: getfield J : Lcom/qiniu/pili/droid/shortvideo/encode/a$a;
    //   425: invokevirtual a : (Lcom/qiniu/pili/droid/shortvideo/encode/a$a;)V
    //   428: aload_0
    //   429: getfield i : Lcom/qiniu/pili/droid/shortvideo/encode/e;
    //   432: invokevirtual a : ()Z
    //   435: pop
    //   436: aload_2
    //   437: ifnull -> 590
    //   440: getstatic com/qiniu/pili/droid/shortvideo/process/a/b.a : Z
    //   443: ifeq -> 590
    //   446: aload_0
    //   447: sipush #2048
    //   450: aload_0
    //   451: getfield u : I
    //   454: imul
    //   455: putfield w : I
    //   458: aload_0
    //   459: sipush #1024
    //   462: i2d
    //   463: ldc2_w 1000000.0
    //   466: dmul
    //   467: aload_0
    //   468: getfield t : I
    //   471: i2d
    //   472: ddiv
    //   473: d2l
    //   474: putfield v : J
    //   477: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   480: astore_1
    //   481: new java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial <init> : ()V
    //   488: astore_2
    //   489: aload_2
    //   490: ldc_w 'output audio frame size in bytes: '
    //   493: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload_2
    //   498: aload_0
    //   499: getfield w : I
    //   502: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload_2
    //   507: ldc_w ' interval in Us: '
    //   510: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: aload_2
    //   515: aload_0
    //   516: getfield v : J
    //   519: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: aload_1
    //   524: ldc 'MultiVideoComposer'
    //   526: aload_2
    //   527: invokevirtual toString : ()Ljava/lang/String;
    //   530: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   533: new com/qiniu/pili/droid/shortvideo/PLAudioEncodeSetting
    //   536: dup
    //   537: invokespecial <init> : ()V
    //   540: astore_1
    //   541: aload_1
    //   542: aload_0
    //   543: getfield u : I
    //   546: invokevirtual setChannels : (I)Lcom/qiniu/pili/droid/shortvideo/PLAudioEncodeSetting;
    //   549: pop
    //   550: aload_1
    //   551: aload_0
    //   552: getfield t : I
    //   555: invokevirtual setSampleRate : (I)Lcom/qiniu/pili/droid/shortvideo/PLAudioEncodeSetting;
    //   558: pop
    //   559: aload_0
    //   560: new com/qiniu/pili/droid/shortvideo/encode/c
    //   563: dup
    //   564: aload_1
    //   565: invokespecial <init> : (Lcom/qiniu/pili/droid/shortvideo/PLAudioEncodeSetting;)V
    //   568: putfield l : Lcom/qiniu/pili/droid/shortvideo/encode/c;
    //   571: aload_0
    //   572: getfield l : Lcom/qiniu/pili/droid/shortvideo/encode/c;
    //   575: aload_0
    //   576: getfield K : Lcom/qiniu/pili/droid/shortvideo/encode/a$a;
    //   579: invokevirtual a : (Lcom/qiniu/pili/droid/shortvideo/encode/a$a;)V
    //   582: aload_0
    //   583: getfield l : Lcom/qiniu/pili/droid/shortvideo/encode/c;
    //   586: invokevirtual a : ()Z
    //   589: pop
    //   590: aload_0
    //   591: iconst_1
    //   592: putfield y : Z
    //   595: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   598: ldc 'MultiVideoComposer'
    //   600: ldc_w 'compose -'
    //   603: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   606: aload_0
    //   607: monitorexit
    //   608: iconst_1
    //   609: ireturn
    //   610: astore_1
    //   611: aload_0
    //   612: monitorexit
    //   613: aload_1
    //   614: athrow
    //   615: iload #5
    //   617: iconst_1
    //   618: iadd
    //   619: istore #5
    //   621: goto -> 266
    // Exception table:
    //   from	to	target	type
    //   2	31	610	finally
    //   35	46	610	finally
    //   55	81	610	finally
    //   81	124	610	finally
    //   127	137	610	finally
    //   137	146	610	finally
    //   149	157	610	finally
    //   157	193	610	finally
    //   196	237	610	finally
    //   245	250	610	finally
    //   250	260	610	finally
    //   269	402	610	finally
    //   405	436	610	finally
    //   440	590	610	finally
    //   590	606	610	finally
  }
  
  public boolean b(List<PLVideoRange> paramList, String paramString, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLVideoSaveListener paramPLVideoSaveListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: new java/util/LinkedList
    //   6: dup
    //   7: aload_1
    //   8: invokespecial <init> : (Ljava/util/Collection;)V
    //   11: putfield G : Ljava/util/LinkedList;
    //   14: aload_0
    //   15: new java/util/LinkedList
    //   18: dup
    //   19: aload_1
    //   20: invokespecial <init> : (Ljava/util/Collection;)V
    //   23: putfield H : Ljava/util/LinkedList;
    //   26: new java/util/LinkedList
    //   29: dup
    //   30: invokespecial <init> : ()V
    //   33: astore #6
    //   35: aload_1
    //   36: invokeinterface iterator : ()Ljava/util/Iterator;
    //   41: astore_1
    //   42: aload_1
    //   43: invokeinterface hasNext : ()Z
    //   48: ifeq -> 74
    //   51: aload #6
    //   53: aload_1
    //   54: invokeinterface next : ()Ljava/lang/Object;
    //   59: checkcast com/qiniu/pili/droid/shortvideo/PLVideoRange
    //   62: invokevirtual getVideoPath : ()Ljava/lang/String;
    //   65: invokeinterface add : (Ljava/lang/Object;)Z
    //   70: pop
    //   71: goto -> 42
    //   74: aload_0
    //   75: aload #6
    //   77: aload_2
    //   78: aload_3
    //   79: aload #4
    //   81: invokevirtual a : (Ljava/util/List;Ljava/lang/String;Lcom/qiniu/pili/droid/shortvideo/PLVideoEncodeSetting;Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;)Z
    //   84: istore #5
    //   86: aload_0
    //   87: monitorexit
    //   88: iload #5
    //   90: ireturn
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Exception table:
    //   from	to	target	type
    //   2	42	91	finally
    //   42	71	91	finally
    //   74	86	91	finally
  }
  
  class a implements com.qiniu.pili.droid.shortvideo.d.b.c {
    private long b;
    
    private a(b this$0) {}
    
    public void a(ByteBuffer param1ByteBuffer, int param1Int, long param1Long1, long param1Long2, boolean param1Boolean) {
      b b1;
      if (b.c(this.a) == null) {
        e.t.d("mResampler has not been init !");
        return;
      } 
      if (param1Boolean) {
        b1 = this.a;
        b.b(b1, b.e(b1) + this.b + b.g(this.a));
        b.c(this.a).destroy(b.y(this.a));
        if (!b.h(this.a).isEmpty()) {
          b1 = this.a;
          b.a(b1, b.h(b1).poll());
          return;
        } 
        e.t.c("MultiVideoComposer", "audio tracks concate done, stop audio encoder now.");
        b.f(this.a).c();
        return;
      } 
      if (b.z(this.a) == null) {
        b.a(this.a, ByteBuffer.allocateDirect(b1.capacity() * 4));
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("init mResampledFramesBuffer with size: ");
        stringBuilder.append(b.z(this.a).capacity());
        e.c("MultiVideoComposer", stringBuilder.toString());
      } 
      param1Int = b.c(this.a).resample(b.y(this.a), (ByteBuffer)b1, b1.position(), param1Int, b.z(this.a), b.z(this.a).position(), 0);
      b.z(this.a).position(b.z(this.a).position() + param1Int);
      while (b.z(this.a).position() >= b.d(this.a)) {
        param1Int = b.z(this.a).position();
        int i = b.d(this.a);
        b.z(this.a).flip();
        b.f(this.a).a(b.z(this.a), b.d(this.a), b.e(this.a) + this.b);
        b.z(this.a).clear();
        b.z(this.a).put(b.z(this.a).array(), b.z(this.a).arrayOffset() + b.d(this.a), param1Int - i);
        this.b += b.g(this.a);
      } 
      if (b.w(this.a)) {
        e.t.c("MultiVideoComposer", "cancel marked, stop audio things now.");
        b.A(this.a).c();
        b.c(this.a).destroy(b.y(this.a));
        b.f(this.a).c();
      } 
    }
  }
  
  class b implements com.qiniu.pili.droid.shortvideo.d.b.c {
    private long b;
    
    private long c;
    
    private b(b this$0) {}
    
    public void a(ByteBuffer param1ByteBuffer, int param1Int, long param1Long1, long param1Long2, boolean param1Boolean) {
      if (param1Boolean) {
        b b2 = this.a;
        b.c(b2, b.s(b2) + this.b - this.c + (1000000 / b.t(this.a).getVideoEncodingFps()));
        this.c = 0L;
        b2 = this.a;
        if (b.a(b2, b.p(b2)))
          b.p(this.a).poll(); 
        if (!b.i(this.a).isEmpty()) {
          b2 = this.a;
          b.b(b2, b.i(b2).poll());
          return;
        } 
        e.t.c("MultiVideoComposer", "video tracks concate done, stop video encoder now.");
        b.r(this.a).c();
        return;
      } 
      this.b = param1Long1;
      b b1 = this.a;
      if (b.a(b1, b.p(b1)) && this.c == 0L)
        this.c = param1Long1; 
      synchronized (b.u(this.a)) {
        while (true) {
          param1Boolean = b.v(this.a);
          if (!param1Boolean) {
            try {
              b.u(this.a).wait();
            } catch (InterruptedException interruptedException) {
              interruptedException.printStackTrace();
            } 
            continue;
          } 
          b.a(this.a, false);
          if (b.w(this.a)) {
            e.t.c("MultiVideoComposer", "cancel marked, stop video things now.");
            b.o(this.a).c();
            b.x(this.a).b();
            b.r(this.a).c();
          } 
          return;
        } 
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\process\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */