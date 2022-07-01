package com.qiniu.pili.droid.shortvideo.d;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.f.k;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class b extends k {
  private String A = "unknown";
  
  private String B = "unknown";
  
  protected MediaExtractor a;
  
  protected MediaCodec b;
  
  protected a c;
  
  protected d d;
  
  protected boolean e;
  
  private MediaFormat f;
  
  private Surface g;
  
  private ByteBuffer[] h;
  
  private ByteBuffer[] i;
  
  private c j;
  
  private e k;
  
  private b l;
  
  private int m;
  
  private long n;
  
  private long o;
  
  private boolean p;
  
  private List<Long> q;
  
  private List<Long> r;
  
  private List<Integer> s;
  
  private List<Integer> t;
  
  private int u;
  
  private int v;
  
  private long w = -1L;
  
  private long x = -1L;
  
  private long y = -1L;
  
  private int z = 0;
  
  public b(MediaExtractor paramMediaExtractor, MediaFormat paramMediaFormat) {
    this.a = paramMediaExtractor;
    this.f = paramMediaFormat;
  }
  
  private void g() {
    this.q = new LinkedList<Long>();
    this.r = new LinkedList<Long>();
    this.s = new LinkedList<Integer>();
    this.t = new LinkedList<Integer>();
    b();
    int i = 0;
    while (true) {
      long l = this.a.getSampleTime();
      int j = i;
      if (l >= this.n) {
        j = i;
        if (l <= this.o) {
          this.q.add(Long.valueOf(l));
          j = i;
          if ((this.a.getSampleFlags() & 0x1) > 0) {
            this.r.add(Long.valueOf(l));
            if (this.r.size() > 1) {
              this.s.add(Integer.valueOf(i));
              com.qiniu.pili.droid.shortvideo.f.e e1 = com.qiniu.pili.droid.shortvideo.f.e.u;
              String str = j();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("the gop frame num is : ");
              stringBuilder.append(i);
              e1.c(str, stringBuilder.toString());
            } 
            j = 0;
          } 
          j++;
        } 
      } 
      i = j;
      if (!this.a.advance()) {
        this.s.add(Integer.valueOf(j));
        com.qiniu.pili.droid.shortvideo.f.e e1 = com.qiniu.pili.droid.shortvideo.f.e.u;
        String str = j();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("the gop frame num is : ");
        stringBuilder.append(j);
        e1.c(str, stringBuilder.toString());
        Collections.sort(this.q);
        Collections.reverse(this.s);
        Collections.reverse(this.r);
        return;
      } 
    } 
  }
  
  private void h() {
    try {
      int j = this.b.dequeueInputBuffer(10000L);
      if (j == -1) {
        com.qiniu.pili.droid.shortvideo.f.e.u.b(j(), "dequeueInputBuffer INFO_TRY_AGAIN_LATER");
        return;
      } 
      if (this.u >= this.r.size()) {
        this.b.queueInputBuffer(j, 0, 0, 0L, 4);
        return;
      } 
      if (this.v == 0) {
        i = 1;
      } else {
        i = 0;
      } 
      if (i) {
        this.a.seekTo(((Long)this.r.get(this.u)).longValue(), 2);
        this.t.add(this.s.get(this.u));
      } else {
        this.t.add(Integer.valueOf(0));
      } 
      int i = this.a.readSampleData(this.h[j], 0);
      this.b.queueInputBuffer(j, 0, i, ((Long)this.q.remove(0)).longValue(), 0);
      this.v++;
      if (this.v < ((Integer)this.s.get(this.u)).intValue()) {
        this.a.advance();
        return;
      } 
      this.v = 0;
      this.u++;
      return;
    } catch (IllegalStateException illegalStateException) {
      com.qiniu.pili.droid.shortvideo.f.e.u.e(j(), illegalStateException.toString());
      return;
    } 
  }
  
  private void i() {
    try {
      int i = this.b.dequeueInputBuffer(10000L);
      if (i == -1) {
        com.qiniu.pili.droid.shortvideo.f.e.u.b(j(), "dequeueInputBuffer INFO_TRY_AGAIN_LATER");
        return;
      } 
      int j = this.a.readSampleData(this.h[i], 0);
      if (j > 0) {
        this.b.queueInputBuffer(i, 0, j, this.a.getSampleTime(), 0);
        this.a.advance();
        return;
      } 
      com.qiniu.pili.droid.shortvideo.f.e e1 = com.qiniu.pili.droid.shortvideo.f.e.u;
      String str = j();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("read size <= 0 need loop: ");
      stringBuilder.append(this.e);
      e1.c(str, stringBuilder.toString());
      if (this.e) {
        b();
        this.b.flush();
        return;
      } 
      this.b.queueInputBuffer(i, 0, 0, 0L, 4);
      return;
    } catch (IllegalStateException illegalStateException) {
      com.qiniu.pili.droid.shortvideo.f.e.u.e(j(), illegalStateException.toString());
      if (f())
        c(); 
      return;
    } 
  }
  
  private boolean k() {
    try {
      MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
      if (!m()) {
        int i = this.b.dequeueOutputBuffer(bufferInfo, 10000L);
        if (i == -1) {
          com.qiniu.pili.droid.shortvideo.f.e.u.b(j(), "dequeueOutputBuffer INFO_TRY_AGAIN_LATER");
        } else if (i == -3) {
          this.i = this.b.getOutputBuffers();
          com.qiniu.pili.droid.shortvideo.f.e.u.c(j(), "processOutputFrame: INFO_OUTPUT_BUFFERS_CHANGED !");
        } else {
          MediaFormat mediaFormat;
          if (i == -2) {
            mediaFormat = this.b.getOutputFormat();
            com.qiniu.pili.droid.shortvideo.f.e e1 = com.qiniu.pili.droid.shortvideo.f.e.u;
            String str = j();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("decoder output format changed: ");
            stringBuilder.append(mediaFormat);
            e1.c(str, stringBuilder.toString());
            if (this.d != null)
              this.d.a(mediaFormat); 
          } else if (i >= 0) {
            if ((((MediaCodec.BufferInfo)mediaFormat).flags & 0x2) != 0) {
              com.qiniu.pili.droid.shortvideo.f.e.i.c(j(), "codec config frame ignore.");
            } else {
              a(i, (MediaCodec.BufferInfo)mediaFormat, (ByteBuffer)null);
            } 
          } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unexpected result from decoder.dequeueOutputBuffer: ");
            stringBuilder.append(i);
            throw new RuntimeException(stringBuilder.toString());
          } 
        } 
      } 
      return true;
    } catch (IllegalStateException illegalStateException) {
      com.qiniu.pili.droid.shortvideo.f.e.u.e(j(), illegalStateException.toString());
      return false;
    } 
  }
  
  protected void a(int paramInt, MediaCodec.BufferInfo paramBufferInfo, ByteBuffer paramByteBuffer) {
    // Byte code:
    //   0: aload_2
    //   1: getfield flags : I
    //   4: iconst_4
    //   5: iand
    //   6: ifeq -> 15
    //   9: iconst_1
    //   10: istore #5
    //   12: goto -> 18
    //   15: iconst_0
    //   16: istore #5
    //   18: aload_2
    //   19: getfield presentationTimeUs : J
    //   22: lstore #7
    //   24: iload #5
    //   26: ifeq -> 123
    //   29: aload_0
    //   30: getfield m : I
    //   33: ifne -> 69
    //   36: aload_0
    //   37: getfield c : Lcom/qiniu/pili/droid/shortvideo/d/b$a;
    //   40: astore #15
    //   42: aload #15
    //   44: ifnull -> 69
    //   47: aload #15
    //   49: bipush #20
    //   51: invokeinterface a : (I)V
    //   56: getstatic com/qiniu/pili/droid/shortvideo/f/e.i : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   59: aload_0
    //   60: invokevirtual j : ()Ljava/lang/String;
    //   63: ldc_w 'decode error : reach eos, but no frame has been decoded !'
    //   66: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   69: getstatic com/qiniu/pili/droid/shortvideo/f/e.i : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   72: astore #15
    //   74: aload_0
    //   75: invokevirtual j : ()Ljava/lang/String;
    //   78: astore #16
    //   80: new java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial <init> : ()V
    //   87: astore #17
    //   89: aload #17
    //   91: ldc_w 'reach eos, total decoded frame: '
    //   94: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload #17
    //   100: aload_0
    //   101: getfield m : I
    //   104: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload #15
    //   110: aload #16
    //   112: aload #17
    //   114: invokevirtual toString : ()Ljava/lang/String;
    //   117: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   120: goto -> 519
    //   123: getstatic com/qiniu/pili/droid/shortvideo/f/e.i : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   126: astore #15
    //   128: aload_0
    //   129: invokevirtual j : ()Ljava/lang/String;
    //   132: astore #16
    //   134: new java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial <init> : ()V
    //   141: astore #17
    //   143: aload #17
    //   145: ldc_w 'decoded frame '
    //   148: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload_0
    //   153: getfield m : I
    //   156: iconst_1
    //   157: iadd
    //   158: istore #4
    //   160: aload_0
    //   161: iload #4
    //   163: putfield m : I
    //   166: aload #17
    //   168: iload #4
    //   170: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload #17
    //   176: ldc_w ' key frame:'
    //   179: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload_2
    //   184: getfield flags : I
    //   187: iconst_1
    //   188: iand
    //   189: ifeq -> 198
    //   192: iconst_1
    //   193: istore #6
    //   195: goto -> 201
    //   198: iconst_0
    //   199: istore #6
    //   201: aload #17
    //   203: iload #6
    //   205: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload #17
    //   211: ldc_w ' eos:'
    //   214: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload_2
    //   219: getfield flags : I
    //   222: iconst_4
    //   223: iand
    //   224: ifeq -> 233
    //   227: iconst_1
    //   228: istore #6
    //   230: goto -> 236
    //   233: iconst_0
    //   234: istore #6
    //   236: aload #17
    //   238: iload #6
    //   240: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload #17
    //   246: ldc_w ' config:'
    //   249: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload_2
    //   254: getfield flags : I
    //   257: iconst_2
    //   258: iand
    //   259: ifeq -> 268
    //   262: iconst_1
    //   263: istore #6
    //   265: goto -> 271
    //   268: iconst_0
    //   269: istore #6
    //   271: aload #17
    //   273: iload #6
    //   275: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload #17
    //   281: ldc_w ' sync:'
    //   284: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload_2
    //   289: getfield flags : I
    //   292: iconst_1
    //   293: iand
    //   294: ifeq -> 303
    //   297: iconst_1
    //   298: istore #6
    //   300: goto -> 306
    //   303: iconst_0
    //   304: istore #6
    //   306: aload #17
    //   308: iload #6
    //   310: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload #17
    //   316: ldc_w ' time:'
    //   319: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload #17
    //   325: lload #7
    //   327: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload #17
    //   333: ldc_w ' size:'
    //   336: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload #17
    //   342: aload_2
    //   343: getfield size : I
    //   346: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload #15
    //   352: aload #16
    //   354: aload #17
    //   356: invokevirtual toString : ()Ljava/lang/String;
    //   359: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   362: lload #7
    //   364: aload_0
    //   365: getfield n : J
    //   368: lcmp
    //   369: iflt -> 401
    //   372: aload_0
    //   373: getfield o : J
    //   376: lstore #9
    //   378: lload #7
    //   380: lload #9
    //   382: lcmp
    //   383: ifle -> 395
    //   386: lload #9
    //   388: ldc2_w -1
    //   391: lcmp
    //   392: ifne -> 401
    //   395: iconst_1
    //   396: istore #4
    //   398: goto -> 404
    //   401: iconst_0
    //   402: istore #4
    //   404: iload #4
    //   406: ifne -> 519
    //   409: lload #7
    //   411: aload_0
    //   412: getfield n : J
    //   415: lcmp
    //   416: ifge -> 427
    //   419: ldc_w 'frame is before the range, ignore.'
    //   422: astore #15
    //   424: goto -> 442
    //   427: aload_0
    //   428: getfield e : Z
    //   431: ifeq -> 805
    //   434: ldc_w 'frame is after the range, but loop is on, so don't callback.'
    //   437: astore #15
    //   439: goto -> 442
    //   442: getstatic com/qiniu/pili/droid/shortvideo/f/e.i : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   445: aload_0
    //   446: invokevirtual j : ()Ljava/lang/String;
    //   449: aload #15
    //   451: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   454: aload_0
    //   455: getfield n : J
    //   458: lstore #9
    //   460: lload #7
    //   462: lload #9
    //   464: lcmp
    //   465: ifge -> 478
    //   468: aload_0
    //   469: getfield b : Landroid/media/MediaCodec;
    //   472: iload_1
    //   473: iconst_0
    //   474: invokevirtual releaseOutputBuffer : (IZ)V
    //   477: return
    //   478: aload_0
    //   479: getfield e : Z
    //   482: ifeq -> 492
    //   485: aload_0
    //   486: invokevirtual b : ()V
    //   489: goto -> 468
    //   492: aload_0
    //   493: getfield b : Landroid/media/MediaCodec;
    //   496: iload_1
    //   497: iconst_0
    //   498: invokevirtual releaseOutputBuffer : (IZ)V
    //   501: iconst_1
    //   502: istore #5
    //   504: goto -> 519
    //   507: astore_2
    //   508: aload_0
    //   509: getfield b : Landroid/media/MediaCodec;
    //   512: iload_1
    //   513: iconst_0
    //   514: invokevirtual releaseOutputBuffer : (IZ)V
    //   517: aload_2
    //   518: athrow
    //   519: aload_0
    //   520: getfield g : Landroid/view/Surface;
    //   523: ifnull -> 540
    //   526: iload #5
    //   528: ifne -> 540
    //   531: aload_0
    //   532: getfield b : Landroid/media/MediaCodec;
    //   535: iload_1
    //   536: iconst_1
    //   537: invokevirtual releaseOutputBuffer : (IZ)V
    //   540: aload_0
    //   541: getfield j : Lcom/qiniu/pili/droid/shortvideo/d/b$c;
    //   544: ifnull -> 773
    //   547: aload_3
    //   548: astore #15
    //   550: aload_3
    //   551: ifnonnull -> 584
    //   554: aload_0
    //   555: getfield i : [Ljava/nio/ByteBuffer;
    //   558: astore #16
    //   560: aload_3
    //   561: astore #15
    //   563: aload #16
    //   565: ifnull -> 584
    //   568: aload_3
    //   569: astore #15
    //   571: iload_1
    //   572: aload #16
    //   574: arraylength
    //   575: if_icmpge -> 584
    //   578: aload #16
    //   580: iload_1
    //   581: aaload
    //   582: astore #15
    //   584: aload_0
    //   585: getfield p : Z
    //   588: ifeq -> 643
    //   591: iload #5
    //   593: ifne -> 629
    //   596: aload_0
    //   597: getfield t : Ljava/util/List;
    //   600: invokeinterface isEmpty : ()Z
    //   605: ifne -> 629
    //   608: aload_0
    //   609: getfield t : Ljava/util/List;
    //   612: iconst_0
    //   613: invokeinterface remove : (I)Ljava/lang/Object;
    //   618: checkcast java/lang/Integer
    //   621: invokevirtual intValue : ()I
    //   624: istore #4
    //   626: goto -> 632
    //   629: iconst_0
    //   630: istore #4
    //   632: aload_0
    //   633: getfield k : Lcom/qiniu/pili/droid/shortvideo/d/b$e;
    //   636: iload #4
    //   638: invokeinterface a : (I)V
    //   643: aload_0
    //   644: getfield x : J
    //   647: lstore #9
    //   649: lload #9
    //   651: ldc2_w -1
    //   654: lcmp
    //   655: ifne -> 667
    //   658: aload_0
    //   659: lload #7
    //   661: putfield x : J
    //   664: goto -> 696
    //   667: lload #7
    //   669: lload #9
    //   671: lcmp
    //   672: ifne -> 696
    //   675: aload_0
    //   676: aload_0
    //   677: getfield w : J
    //   680: lload #9
    //   682: lsub
    //   683: putfield y : J
    //   686: aload_0
    //   687: aload_0
    //   688: getfield z : I
    //   691: iconst_1
    //   692: iadd
    //   693: putfield z : I
    //   696: aload_0
    //   697: getfield y : J
    //   700: ldc2_w -1
    //   703: lcmp
    //   704: ifne -> 713
    //   707: aload_0
    //   708: lload #7
    //   710: putfield w : J
    //   713: aload_0
    //   714: getfield y : J
    //   717: lstore #9
    //   719: aload_0
    //   720: getfield z : I
    //   723: i2l
    //   724: lstore #11
    //   726: aload_0
    //   727: getfield x : J
    //   730: lstore #13
    //   732: aload_0
    //   733: getfield j : Lcom/qiniu/pili/droid/shortvideo/d/b$c;
    //   736: aload #15
    //   738: aload_2
    //   739: getfield size : I
    //   742: lload #7
    //   744: lload #7
    //   746: lload #13
    //   748: lsub
    //   749: lload #9
    //   751: lload #11
    //   753: lmul
    //   754: ladd
    //   755: iload #5
    //   757: invokeinterface a : (Ljava/nio/ByteBuffer;IJJZ)V
    //   762: aload #15
    //   764: ifnull -> 773
    //   767: aload #15
    //   769: invokevirtual clear : ()Ljava/nio/Buffer;
    //   772: pop
    //   773: aload_0
    //   774: getfield g : Landroid/view/Surface;
    //   777: ifnonnull -> 794
    //   780: iload #5
    //   782: ifne -> 794
    //   785: aload_0
    //   786: getfield b : Landroid/media/MediaCodec;
    //   789: iload_1
    //   790: iconst_0
    //   791: invokevirtual releaseOutputBuffer : (IZ)V
    //   794: iload #5
    //   796: ifeq -> 804
    //   799: aload_0
    //   800: invokevirtual c : ()Z
    //   803: pop
    //   804: return
    //   805: ldc_w 'frame is after the range, make eos.'
    //   808: astore #15
    //   810: goto -> 442
    // Exception table:
    //   from	to	target	type
    //   409	419	507	finally
    //   427	434	507	finally
    //   442	460	507	finally
    //   478	489	507	finally
  }
  
  public void a(Surface paramSurface) {
    this.g = paramSurface;
  }
  
  public void a(a parama) {
    this.c = parama;
  }
  
  public void a(b paramb) {
    this.l = paramb;
  }
  
  public void a(c paramc) {
    this.j = paramc;
  }
  
  public void a(d paramd) {
    this.d = paramd;
  }
  
  public void a(e parame) {
    this.k = parame;
  }
  
  public void a(String paramString) {
    this.A = paramString;
  }
  
  public void a(boolean paramBoolean) {
    this.e = paramBoolean;
  }
  
  public boolean a() {
    return a(0L, -1L);
  }
  
  public boolean a(long paramLong) {
    this.n = paramLong;
    this.o = -1L;
    return super.a();
  }
  
  public boolean a(long paramLong1, long paramLong2) {
    this.n = paramLong1;
    this.o = paramLong2;
    return super.a();
  }
  
  public boolean a(long paramLong1, long paramLong2, boolean paramBoolean) {
    this.n = paramLong1;
    this.o = paramLong2;
    this.p = paramBoolean;
    if (this.p)
      g(); 
    return super.a();
  }
  
  protected boolean a(MediaCodec.Callback paramCallback, Handler paramHandler) {
    byte b1;
    com.qiniu.pili.droid.shortvideo.f.e.u.c(j(), "startDecoder +");
    MediaFormat mediaFormat = this.f;
    if (mediaFormat == null) {
      com.qiniu.pili.droid.shortvideo.f.e.u.e(j(), "startDecoder failed: NULL format");
      return false;
    } 
    this.B = mediaFormat.getString("mime");
    if (paramCallback != null && paramHandler != null) {
      b1 = 1;
    } else {
      b1 = 0;
    } 
    try {
      this.b = MediaCodec.createDecoderByType(this.B);
      if (b1)
        this.b.setCallback(paramCallback, paramHandler); 
      try {
        this.b.configure(this.f, this.g, null, 0);
        this.b.start();
        if (!b1) {
          this.h = this.b.getInputBuffers();
          if (this.g == null)
            this.i = this.b.getOutputBuffers(); 
        } 
        com.qiniu.pili.droid.shortvideo.f.e.u.c(j(), "startDecoder success !");
        return true;
      } catch (RuntimeException runtimeException) {
        com.qiniu.pili.droid.shortvideo.f.e e1 = com.qiniu.pili.droid.shortvideo.f.e.u;
        String str = j();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("startDecoder failed: error message: ");
        stringBuilder.append(runtimeException.getMessage());
        e1.d(str, stringBuilder.toString());
        if (runtimeException.getMessage() != null && runtimeException.getMessage().contains("0xfffffc03")) {
          e1 = com.qiniu.pili.droid.shortvideo.f.e.u;
          str = j();
          stringBuilder = new StringBuilder();
          stringBuilder.append("not support multiple media codec!");
          stringBuilder.append(runtimeException.getMessage());
          e1.d(str, stringBuilder.toString());
          b1 = 16;
        } else {
          e1 = com.qiniu.pili.droid.shortvideo.f.e.u;
          str = j();
          stringBuilder = new StringBuilder();
          stringBuilder.append("configure decoder failed! ");
          stringBuilder.append(runtimeException.getMessage());
          e1.d(str, stringBuilder.toString());
          b1 = 17;
        } 
        if (this.c != null)
          this.c.a(b1); 
        return false;
      } 
    } catch (Exception exception) {
      com.qiniu.pili.droid.shortvideo.f.e e1 = com.qiniu.pili.droid.shortvideo.f.e.u;
      String str = j();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("startDecoder failed: ");
      stringBuilder.append(exception.getMessage());
      e1.e(str, stringBuilder.toString());
      a a1 = this.c;
      if (a1 != null)
        a1.a(17); 
      return false;
    } 
  }
  
  protected void b() {
    this.a.seekTo(this.n, 0);
  }
  
  protected boolean d() {
    return a((MediaCodec.Callback)null, (Handler)null);
  }
  
  protected void e() {
    com.qiniu.pili.droid.shortvideo.f.e e2 = com.qiniu.pili.droid.shortvideo.f.e.u;
    String str = j();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("stopDecoder + ");
    stringBuilder.append(this.A);
    e2.c(str, stringBuilder.toString());
    try {
      if (this.b != null) {
        this.b.stop();
        this.b.release();
        this.b = null;
      } 
    } catch (Exception exception) {
      com.qiniu.pili.droid.shortvideo.f.e e3 = com.qiniu.pili.droid.shortvideo.f.e.u;
      String str1 = j();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("stop decoder failed : ");
      stringBuilder1.append(exception.getMessage());
      e3.c(str1, stringBuilder1.toString());
    } 
    try {
      if (this.a != null) {
        this.a.release();
        this.a = null;
      } 
    } catch (Exception exception) {
      com.qiniu.pili.droid.shortvideo.f.e e3 = com.qiniu.pili.droid.shortvideo.f.e.u;
      String str1 = j();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("release extractor failed : ");
      stringBuilder1.append(exception.getMessage());
      e3.c(str1, stringBuilder1.toString());
    } 
    b b1 = this.l;
    if (b1 != null)
      b1.a(); 
    com.qiniu.pili.droid.shortvideo.f.e e1 = com.qiniu.pili.droid.shortvideo.f.e.u;
    str = j();
    stringBuilder = new StringBuilder();
    stringBuilder.append("stopDecoder - ");
    stringBuilder.append(this.A);
    e1.c(str, stringBuilder.toString());
  }
  
  protected boolean f() {
    return this.B.contains("audio");
  }
  
  public String j() {
    return "RawFrameExtractor";
  }
  
  public void run() {
    b();
    boolean bool = d();
    while (!m() && bool) {
      if (this.p) {
        h();
      } else {
        i();
      } 
      k();
    } 
    e();
  }
  
  public static interface a {
    void a(int param1Int);
  }
  
  public static interface b {
    void a();
  }
  
  public static interface c {
    void a(ByteBuffer param1ByteBuffer, int param1Int, long param1Long1, long param1Long2, boolean param1Boolean);
  }
  
  public static interface d {
    void a(MediaFormat param1MediaFormat);
  }
  
  public static interface e {
    void a(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */