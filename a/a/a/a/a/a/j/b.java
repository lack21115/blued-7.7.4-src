package a.a.a.a.a.a.j;

import a.a.a.a.a.a.h.d;
import a.a.a.a.a.a.h.g;
import a.a.a.a.a.a.j.i.a;
import a.a.a.a.a.b.i.i;
import a.a.a.a.a.b.i.j;
import a.a.a.a.a.b.i.o;
import a.a.a.a.a.b.i.p;
import a.a.a.a.a.e.e;
import a.a.a.a.a.e.f;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.qiniu.pili.droid.streaming.PreviewAppearance;
import com.qiniu.pili.droid.streaming.StreamingPreviewCallback;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public final class b extends f {
  public g a;
  
  public d b;
  
  public StreamingPreviewCallback c;
  
  public a.a.a.a.a.a.a d;
  
  public j e;
  
  public p f;
  
  public o g;
  
  public i h;
  
  public byte[] i;
  
  public volatile a j;
  
  public final void a() {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield w : La/a/a/a/a/a/j/f$a;
    //   5: invokevirtual a_ : (La/a/a/a/a/a/j/f$a;)V
    //   8: aload_0
    //   9: getfield v : La/a/a/a/a/a/c;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull -> 23
    //   17: aload_1
    //   18: invokeinterface d : ()V
    //   23: aload_0
    //   24: lconst_0
    //   25: putfield y : J
    //   28: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   31: ldc 'RGBDataTransfer'
    //   33: ldc 'startEncoding -'
    //   35: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_0
    //   39: monitorenter
    //   40: aload_0
    //   41: getstatic a/a/a/a/a/f/c.c : La/a/a/a/a/f/c;
    //   44: putfield t : La/a/a/a/a/f/c;
    //   47: aload_0
    //   48: invokevirtual e : ()V
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Exception table:
    //   from	to	target	type
    //   40	53	54	finally
    //   55	57	54	finally
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, long paramLong, boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(f.a parama) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 19
    //   6: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   9: ldc 'RGBDataTransfer'
    //   11: ldc 'config is null when startEncoding'
    //   13: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: getfield t : La/a/a/a/a/f/c;
    //   23: getstatic a/a/a/a/a/f/c.c : La/a/a/a/a/f/c;
    //   26: if_acmpne -> 42
    //   29: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   32: ldc 'RGBDataTransfer'
    //   34: ldc 'startEncoding failed as already being running'
    //   36: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: aload_0
    //   43: getfield t : La/a/a/a/a/f/c;
    //   46: getstatic a/a/a/a/a/f/c.d : La/a/a/a/a/f/c;
    //   49: if_acmpne -> 77
    //   52: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   55: ldc 'RGBDataTransfer'
    //   57: ldc 'set pending action as START'
    //   59: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload_0
    //   63: getstatic a/a/a/a/a/f/a.b : La/a/a/a/a/f/a;
    //   66: putfield u : La/a/a/a/a/f/a;
    //   69: aload_0
    //   70: aload_1
    //   71: putfield x : La/a/a/a/a/a/j/f$a;
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: aload_0
    //   78: getfield t : La/a/a/a/a/f/c;
    //   81: getstatic a/a/a/a/a/f/c.b : La/a/a/a/a/f/c;
    //   84: if_acmpne -> 122
    //   87: aload_0
    //   88: getfield u : La/a/a/a/a/f/a;
    //   91: getstatic a/a/a/a/a/f/a.c : La/a/a/a/a/f/a;
    //   94: if_acmpne -> 119
    //   97: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   100: ldc 'RGBDataTransfer'
    //   102: ldc 'set pending action as RESTART'
    //   104: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_0
    //   108: getstatic a/a/a/a/a/f/a.d : La/a/a/a/a/f/a;
    //   111: putfield u : La/a/a/a/a/f/a;
    //   114: aload_0
    //   115: aload_1
    //   116: putfield x : La/a/a/a/a/a/j/f$a;
    //   119: aload_0
    //   120: monitorexit
    //   121: return
    //   122: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   125: ldc 'RGBDataTransfer'
    //   127: ldc 'startEncoding +'
    //   129: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload_0
    //   133: aload_1
    //   134: putfield w : La/a/a/a/a/a/j/f$a;
    //   137: aload_0
    //   138: getstatic a/a/a/a/a/f/c.b : La/a/a/a/a/f/c;
    //   141: putfield t : La/a/a/a/a/f/c;
    //   144: new android/os/HandlerThread
    //   147: dup
    //   148: ldc 'RGBDataTransfer'
    //   150: invokespecial <init> : (Ljava/lang/String;)V
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual start : ()V
    //   158: aload_0
    //   159: new a/a/a/a/a/a/j/b$a
    //   162: dup
    //   163: aload_1
    //   164: invokevirtual getLooper : ()Landroid/os/Looper;
    //   167: aload_0
    //   168: invokespecial <init> : (Landroid/os/Looper;La/a/a/a/a/a/j/b;)V
    //   171: putfield j : La/a/a/a/a/a/j/b$a;
    //   174: aload_0
    //   175: getfield j : La/a/a/a/a/a/j/b$a;
    //   178: iconst_0
    //   179: invokevirtual sendEmptyMessage : (I)Z
    //   182: pop
    //   183: aload_0
    //   184: monitorexit
    //   185: return
    //   186: astore_1
    //   187: aload_0
    //   188: monitorexit
    //   189: aload_1
    //   190: athrow
    // Exception table:
    //   from	to	target	type
    //   6	16	186	finally
    //   19	39	186	finally
    //   42	74	186	finally
    //   77	119	186	finally
    //   122	183	186	finally
  }
  
  public void a(StreamingPreviewCallback paramStreamingPreviewCallback) {
    this.c = paramStreamingPreviewCallback;
  }
  
  public final void a(PLAVFrame paramPLAVFrame) {
    f.a a1 = this.w;
    if (a1.g) {
      this.d.a(paramPLAVFrame, a1, true);
      return;
    } 
    this.d.a(paramPLAVFrame, a1, false);
  }
  
  public void a(ByteBuffer paramByteBuffer, int paramInt, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield t : La/a/a/a/a/f/c;
    //   6: getstatic a/a/a/a/a/f/c.c : La/a/a/a/a/f/c;
    //   9: if_acmpne -> 85
    //   12: aload_0
    //   13: getfield j : La/a/a/a/a/a/j/b$a;
    //   16: ifnull -> 85
    //   19: aload_0
    //   20: getfield d : La/a/a/a/a/a/a;
    //   23: astore #5
    //   25: aload #5
    //   27: ifnull -> 85
    //   30: aload_1
    //   31: ifnonnull -> 37
    //   34: goto -> 85
    //   37: aload #5
    //   39: aload_1
    //   40: invokevirtual capacity : ()I
    //   43: invokevirtual b : (I)Lcom/qiniu/pili/droid/streaming/av/common/PLAVFrame;
    //   46: astore #5
    //   48: aload #5
    //   50: ifnull -> 82
    //   53: aload #5
    //   55: aload_1
    //   56: aload_1
    //   57: invokevirtual capacity : ()I
    //   60: lload_3
    //   61: invokevirtual fillFrame : (Ljava/nio/ByteBuffer;IJ)V
    //   64: aload_0
    //   65: getfield j : La/a/a/a/a/a/j/b$a;
    //   68: aload_0
    //   69: getfield j : La/a/a/a/a/a/j/b$a;
    //   72: iconst_3
    //   73: aload #5
    //   75: invokevirtual obtainMessage : (ILjava/lang/Object;)Landroid/os/Message;
    //   78: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   81: pop
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_0
    //   86: monitorexit
    //   87: return
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    // Exception table:
    //   from	to	target	type
    //   2	25	88	finally
    //   37	48	88	finally
    //   53	82	88	finally
  }
  
  public boolean a(boolean paramBoolean) {
    f.a a1 = this.w;
    if (a1 != null) {
      a1.a(paramBoolean);
      return true;
    } 
    e.f.e("RGBDataTransfer", "setEncodingMirror failed.");
    return false;
  }
  
  public final void a_(f.a parama) {
    e.f.c("RGBDataTransfer", "prepareEncoder");
    if (parama.g) {
      this.d = (a.a.a.a.a.a.a)new a(parama);
    } else {
      this.d = new e(parama);
    } 
    try {
      this.b = new d(parama.i, 0);
      g g1 = new g(this.b, 2, 2);
      this.a = g1;
      g1.d();
      f f1 = parama.a.d().a();
      int n = f1.a();
      int i2 = f1.b();
      int k = parama.b;
      int m = parama.c;
      if (parama.e == 90 || parama.e == 270) {
        k = parama.c;
        m = parama.b;
      } 
      j j1 = new j();
      this.e = j1;
      j1.a(k, m);
      o o1 = new o();
      this.g = o1;
      o1.a(n, i2, true);
      PreviewAppearance previewAppearance = parama.o;
      if (previewAppearance != null) {
        this.g.a(k, m, previewAppearance.x, previewAppearance.y, previewAppearance.w, previewAppearance.h, previewAppearance.scaleType);
      } else {
        this.g.a(k, m, 0.0F, 0.0F, 1.0F, 1.0F, PreviewAppearance.ScaleType.FULL);
      } 
      if (parama.h != null) {
        p p1 = new p();
        this.f = p1;
        if (previewAppearance != null) {
          p1.a(n, i2, previewAppearance.x, previewAppearance.y, previewAppearance.w, previewAppearance.h, parama.h);
        } else {
          p1.a(n, i2, parama.h);
        } 
      } 
      i i1 = new i();
      this.h = i1;
      i1.a(n, i2);
      return;
    } catch (Exception exception) {
      e e = e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("exception:");
      stringBuilder.append(exception.getMessage());
      e.d("RGBDataTransfer", stringBuilder.toString());
      return;
    } 
  }
  
  public final void a_(boolean paramBoolean) {
    // Byte code:
    //   0: invokestatic myLooper : ()Landroid/os/Looper;
    //   3: invokevirtual quit : ()V
    //   6: aload_0
    //   7: getfield d : La/a/a/a/a/a/a;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull -> 31
    //   15: iload_1
    //   16: ifeq -> 31
    //   19: aload_2
    //   20: invokevirtual a : ()V
    //   23: aload_0
    //   24: getfield d : La/a/a/a/a/a/a;
    //   27: iconst_1
    //   28: invokevirtual a : (Z)V
    //   31: aload_0
    //   32: invokevirtual b : ()V
    //   35: aload_0
    //   36: getfield v : La/a/a/a/a/a/c;
    //   39: astore_2
    //   40: aload_2
    //   41: ifnull -> 50
    //   44: aload_2
    //   45: invokeinterface a : ()V
    //   50: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   53: ldc 'RGBDataTransfer'
    //   55: ldc_w 'stopEncoding -'
    //   58: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload_0
    //   62: monitorenter
    //   63: aload_0
    //   64: getstatic a/a/a/a/a/f/c.a : La/a/a/a/a/f/c;
    //   67: putfield t : La/a/a/a/a/f/c;
    //   70: aload_0
    //   71: invokevirtual e : ()V
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: astore_2
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_2
    //   81: athrow
    // Exception table:
    //   from	to	target	type
    //   63	76	77	finally
    //   78	80	77	finally
  }
  
  public final void b() {
    e.f.c("RGBDataTransfer", "releaseEncoder");
    this.c = null;
    a.a.a.a.a.a.a a1 = this.d;
    if (a1 != null) {
      a1.b();
      this.d = null;
    } 
    g g1 = this.a;
    if (g1 != null) {
      g1.g();
      this.a = null;
    } 
    d d1 = this.b;
    if (d1 != null) {
      d1.b();
      this.b = null;
    } 
  }
  
  public final void b(int paramInt, long paramLong, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield h : La/a/a/a/a/b/i/i;
    //   4: ifnull -> 327
    //   7: aload_0
    //   8: getfield a : La/a/a/a/a/a/h/g;
    //   11: ifnull -> 327
    //   14: aload_0
    //   15: getfield w : La/a/a/a/a/a/j/f$a;
    //   18: astore #6
    //   20: aload #6
    //   22: ifnonnull -> 28
    //   25: goto -> 327
    //   28: aload_0
    //   29: getfield d : La/a/a/a/a/a/a;
    //   32: aload #6
    //   34: getfield d : I
    //   37: invokevirtual b : (I)Lcom/qiniu/pili/droid/streaming/av/common/PLAVFrame;
    //   40: astore #6
    //   42: aload #6
    //   44: ifnonnull -> 59
    //   47: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   50: ldc 'RGBDataTransfer'
    //   52: ldc_w 'frame is null'
    //   55: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   58: return
    //   59: aload_0
    //   60: getfield w : La/a/a/a/a/a/j/f$a;
    //   63: getfield m : Z
    //   66: istore #4
    //   68: getstatic a/a/a/a/a/a/h/f.d : Ljava/lang/Object;
    //   71: astore #7
    //   73: aload #7
    //   75: monitorenter
    //   76: iload #4
    //   78: ifeq -> 93
    //   81: aload_0
    //   82: getfield e : La/a/a/a/a/b/i/j;
    //   85: iload_1
    //   86: invokevirtual d : (I)I
    //   89: istore_1
    //   90: goto -> 103
    //   93: aload_0
    //   94: getfield g : La/a/a/a/a/b/i/o;
    //   97: iconst_0
    //   98: iload_1
    //   99: invokevirtual a : (II)I
    //   102: istore_1
    //   103: aload #7
    //   105: monitorexit
    //   106: iload_1
    //   107: istore #5
    //   109: iload #4
    //   111: ifeq -> 125
    //   114: aload_0
    //   115: getfield g : La/a/a/a/a/b/i/o;
    //   118: iconst_0
    //   119: iload_1
    //   120: invokevirtual a : (II)I
    //   123: istore #5
    //   125: aload_0
    //   126: getfield f : La/a/a/a/a/b/i/p;
    //   129: astore #7
    //   131: aload #7
    //   133: ifnull -> 143
    //   136: aload #7
    //   138: iload #5
    //   140: invokevirtual a : (I)V
    //   143: aload_0
    //   144: getfield h : La/a/a/a/a/b/i/i;
    //   147: iload #5
    //   149: invokevirtual a : (I)[Ljava/nio/ByteBuffer;
    //   152: astore #7
    //   154: aload #7
    //   156: ifnull -> 167
    //   159: aload #6
    //   161: aload #7
    //   163: lload_2
    //   164: invokevirtual fillFrame : ([Ljava/nio/ByteBuffer;J)V
    //   167: aload_0
    //   168: getfield h : La/a/a/a/a/b/i/i;
    //   171: invokevirtual a : ()V
    //   174: aload_0
    //   175: getfield i : [B
    //   178: astore #7
    //   180: aload #7
    //   182: ifnull -> 196
    //   185: aload #7
    //   187: arraylength
    //   188: aload #6
    //   190: getfield mSize : I
    //   193: if_icmpge -> 207
    //   196: aload_0
    //   197: aload #6
    //   199: getfield mSize : I
    //   202: newarray byte
    //   204: putfield i : [B
    //   207: aload #6
    //   209: getfield mBuffer : Ljava/nio/ByteBuffer;
    //   212: invokevirtual rewind : ()Ljava/nio/Buffer;
    //   215: pop
    //   216: aload_0
    //   217: getfield c : Lcom/qiniu/pili/droid/streaming/StreamingPreviewCallback;
    //   220: ifnull -> 279
    //   223: aload #6
    //   225: getfield mBuffer : Ljava/nio/ByteBuffer;
    //   228: aload_0
    //   229: getfield i : [B
    //   232: iconst_0
    //   233: aload #6
    //   235: getfield mSize : I
    //   238: invokevirtual get : ([BII)Ljava/nio/ByteBuffer;
    //   241: pop
    //   242: aload_0
    //   243: getfield c : Lcom/qiniu/pili/droid/streaming/StreamingPreviewCallback;
    //   246: aload_0
    //   247: getfield i : [B
    //   250: aload_0
    //   251: getfield g : La/a/a/a/a/b/i/o;
    //   254: invokevirtual a : ()I
    //   257: aload_0
    //   258: getfield g : La/a/a/a/a/b/i/o;
    //   261: invokevirtual b : ()I
    //   264: iconst_0
    //   265: getstatic com/qiniu/pili/droid/streaming/av/common/PLFourCC.FOURCC_I420 : I
    //   268: aload #6
    //   270: getfield mPresentationTimeUs : J
    //   273: invokeinterface onPreviewFrame : ([BIIIIJ)Z
    //   278: pop
    //   279: aload_0
    //   280: getfield w : La/a/a/a/a/a/j/f$a;
    //   283: astore #7
    //   285: aload #7
    //   287: getfield g : Z
    //   290: ifeq -> 306
    //   293: aload_0
    //   294: getfield d : La/a/a/a/a/a/a;
    //   297: aload #6
    //   299: aload #7
    //   301: iconst_1
    //   302: invokevirtual a : (Lcom/qiniu/pili/droid/streaming/av/common/PLAVFrame;La/a/a/a/a/a/j/f$a;Z)V
    //   305: return
    //   306: aload_0
    //   307: getfield d : La/a/a/a/a/a/a;
    //   310: aload #6
    //   312: aload #7
    //   314: iconst_0
    //   315: invokevirtual a : (Lcom/qiniu/pili/droid/streaming/av/common/PLAVFrame;La/a/a/a/a/a/j/f$a;Z)V
    //   318: return
    //   319: astore #6
    //   321: aload #7
    //   323: monitorexit
    //   324: aload #6
    //   326: athrow
    //   327: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   330: astore #6
    //   332: new java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial <init> : ()V
    //   339: astore #7
    //   341: aload #7
    //   343: ldc_w 'ERROR. handleFrameAvailable mTextureI420Reader:'
    //   346: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload #7
    //   352: aload_0
    //   353: getfield h : La/a/a/a/a/b/i/i;
    //   356: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload #7
    //   362: ldc_w ',mInputWindowSurface:'
    //   365: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload #7
    //   371: aload_0
    //   372: getfield a : La/a/a/a/a/a/h/g;
    //   375: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload #7
    //   381: ldc_w ',mEncoderConfig:'
    //   384: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: pop
    //   388: aload #7
    //   390: aload_0
    //   391: getfield w : La/a/a/a/a/a/j/f$a;
    //   394: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload #6
    //   400: ldc 'RGBDataTransfer'
    //   402: aload #7
    //   404: invokevirtual toString : ()Ljava/lang/String;
    //   407: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   410: return
    // Exception table:
    //   from	to	target	type
    //   81	90	319	finally
    //   93	103	319	finally
    //   103	106	319	finally
    //   321	324	319	finally
  }
  
  public void b(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield t : La/a/a/a/a/f/c;
    //   6: getstatic a/a/a/a/a/f/c.a : La/a/a/a/a/f/c;
    //   9: if_acmpne -> 26
    //   12: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   15: ldc 'RGBDataTransfer'
    //   17: ldc_w 'stopEncoding failed as not being running'
    //   20: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield t : La/a/a/a/a/f/c;
    //   30: getstatic a/a/a/a/a/f/c.b : La/a/a/a/a/f/c;
    //   33: if_acmpne -> 57
    //   36: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   39: ldc 'RGBDataTransfer'
    //   41: ldc_w 'set pending action as STOP'
    //   44: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload_0
    //   48: getstatic a/a/a/a/a/f/a.c : La/a/a/a/a/f/a;
    //   51: putfield u : La/a/a/a/a/f/a;
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: aload_0
    //   58: getfield t : La/a/a/a/a/f/c;
    //   61: getstatic a/a/a/a/a/f/c.d : La/a/a/a/a/f/c;
    //   64: if_acmpne -> 98
    //   67: aload_0
    //   68: getfield u : La/a/a/a/a/f/a;
    //   71: getstatic a/a/a/a/a/f/a.b : La/a/a/a/a/f/a;
    //   74: if_acmpne -> 95
    //   77: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   80: ldc 'RGBDataTransfer'
    //   82: ldc_w 'clear pending start action'
    //   85: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_0
    //   89: getstatic a/a/a/a/a/f/a.a : La/a/a/a/a/f/a;
    //   92: putfield u : La/a/a/a/a/f/a;
    //   95: aload_0
    //   96: monitorexit
    //   97: return
    //   98: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   101: ldc 'RGBDataTransfer'
    //   103: ldc_w 'stopEncoding +'
    //   106: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload_0
    //   110: getstatic a/a/a/a/a/f/c.d : La/a/a/a/a/f/c;
    //   113: putfield t : La/a/a/a/a/f/c;
    //   116: aload_0
    //   117: getfield j : La/a/a/a/a/a/j/b$a;
    //   120: aload_0
    //   121: getfield j : La/a/a/a/a/a/j/b$a;
    //   124: iconst_1
    //   125: iload_1
    //   126: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   129: invokevirtual obtainMessage : (ILjava/lang/Object;)Landroid/os/Message;
    //   132: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   135: pop
    //   136: aload_0
    //   137: monitorexit
    //   138: return
    //   139: astore_2
    //   140: aload_0
    //   141: monitorexit
    //   142: aload_2
    //   143: athrow
    // Exception table:
    //   from	to	target	type
    //   2	23	139	finally
    //   26	54	139	finally
    //   57	95	139	finally
    //   98	136	139	finally
  }
  
  public static class a extends Handler {
    public WeakReference<b> a;
    
    public a(Looper param1Looper, b param1b) {
      super(param1Looper);
      this.a = new WeakReference<b>(param1b);
    }
    
    public void handleMessage(Message param1Message) {
      int i = param1Message.what;
      Object object = param1Message.obj;
      b b = this.a.get();
      e e = e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("EncoderHandler what:");
      stringBuilder.append(i);
      stringBuilder.append(",encoder=");
      stringBuilder.append(b);
      e.a("RGBDataTransfer", stringBuilder.toString());
      if (b == null) {
        e.f.d("RGBDataTransfer", "EncoderHandler.handleMessage: encoder is null");
        return;
      } 
      if (i != 0) {
        boolean bool = true;
        if (i != 1) {
          StringBuilder stringBuilder1;
          if (i != 2) {
            if (i == 3) {
              b.a(b, (PLAVFrame)object);
              return;
            } 
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Unhandled msg what=");
            stringBuilder1.append(i);
            throw new RuntimeException(stringBuilder1.toString());
          } 
          i = ((Message)stringBuilder1).arg1;
          long l = ((Long)object).longValue();
          if (((Message)stringBuilder1).arg2 != 1)
            bool = false; 
          b.a(b, i, l, bool);
          return;
        } 
        b.a(b, ((Boolean)object).booleanValue());
        return;
      } 
      b.a(b);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\j\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */