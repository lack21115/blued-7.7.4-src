package a.a.a.a.a.a.g;

import a.a.a.a.a.a.b;
import a.a.a.a.a.a.i.c;
import a.a.a.a.a.a.j.f;
import a.a.a.a.a.e.f;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaFormat;
import com.qiniu.pili.droid.streaming.WatermarkSetting;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import com.qiniu.pili.droid.streaming.processing.image.ImageProcessor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;

public class e extends c {
  public c k;
  
  public ArrayDeque<PLAVFrame> l = new ArrayDeque<PLAVFrame>();
  
  public final Object m = new Object();
  
  public volatile int n = 0;
  
  public ByteBuffer o;
  
  public ImageProcessor p;
  
  public e(MediaFormat paramMediaFormat, String paramString, boolean paramBoolean, f.a parama) {
    this.g = paramBoolean;
    this.k = parama.a;
    try {
      this.c = new MediaCodec.BufferInfo();
      MediaCodec mediaCodec = MediaCodec.createEncoderByType(paramString);
      this.b = mediaCodec;
      mediaCodec.configure(paramMediaFormat, null, null, 1);
      this.f = paramBoolean ^ true;
      a(parama);
      return;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return;
    } 
  }
  
  public void a() {
    super.a();
    ImageProcessor imageProcessor = this.p;
    if (imageProcessor != null)
      imageProcessor.a(); 
  }
  
  public final void a(f.a parama) {
    b b = parama.a.d();
    int i = b.a().a();
    int j = b.a().b();
    Point point = b.c();
    f f = b.b();
    ImageProcessor imageProcessor = new ImageProcessor();
    this.p = imageProcessor;
    imageProcessor.initYUVProcessor(parama.h, false, parama.b, parama.c, point.x, point.y, f.a(), f.b(), i, j, parama.e, parama.f, parama.k, parama.m);
  }
  
  public void a(WatermarkSetting paramWatermarkSetting) {
    ImageProcessor imageProcessor = this.p;
    if (imageProcessor != null)
      imageProcessor.updateWatermarkSetting(paramWatermarkSetting); 
  }
  
  public void a(PLAVFrame paramPLAVFrame) {
    // Byte code:
    //   0: aload_0
    //   1: getfield m : Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnull -> 20
    //   11: aload_0
    //   12: getfield l : Ljava/util/ArrayDeque;
    //   15: aload_1
    //   16: invokevirtual add : (Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_2
    //   21: monitorexit
    //   22: return
    //   23: astore_1
    //   24: aload_2
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    // Exception table:
    //   from	to	target	type
    //   11	20	23	finally
    //   20	22	23	finally
    //   24	26	23	finally
  }
  
  public void a(PLAVFrame paramPLAVFrame, f.a parama, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield k : La/a/a/a/a/a/i/c;
    //   4: astore #7
    //   6: aload #7
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield k : La/a/a/a/a/a/i/c;
    //   13: invokevirtual f : ()Z
    //   16: ifeq -> 1561
    //   19: aload_0
    //   20: getfield f : Z
    //   23: ifeq -> 1561
    //   26: getstatic com/qiniu/pili/droid/streaming/processing/image/ImageProcessor.b : Z
    //   29: ifeq -> 1561
    //   32: aload_0
    //   33: getfield p : Lcom/qiniu/pili/droid/streaming/processing/image/ImageProcessor;
    //   36: ifnonnull -> 42
    //   39: goto -> 1561
    //   42: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   45: astore #6
    //   47: new java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial <init> : ()V
    //   54: astore #8
    //   56: aload #8
    //   58: ldc 'drainEncoder('
    //   60: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload #8
    //   66: iconst_0
    //   67: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload #8
    //   73: ldc ') track: '
    //   75: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload #8
    //   81: aload_0
    //   82: getfield i : I
    //   85: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload #6
    //   91: ldc 'PLYuvHWEncoder'
    //   93: aload #8
    //   95: invokevirtual toString : ()Ljava/lang/String;
    //   98: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload_0
    //   102: getfield b : Landroid/media/MediaCodec;
    //   105: invokevirtual getOutputBuffers : ()[Ljava/nio/ByteBuffer;
    //   108: astore #6
    //   110: aload_0
    //   111: getfield b : Landroid/media/MediaCodec;
    //   114: invokevirtual getInputBuffers : ()[Ljava/nio/ByteBuffer;
    //   117: astore #8
    //   119: aload_0
    //   120: getfield b : Landroid/media/MediaCodec;
    //   123: ldc2_w 1000
    //   126: invokevirtual dequeueInputBuffer : (J)I
    //   129: istore #4
    //   131: iload #4
    //   133: iflt -> 483
    //   136: aload #8
    //   138: iload #4
    //   140: aaload
    //   141: astore #8
    //   143: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   146: astore #9
    //   148: new java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial <init> : ()V
    //   155: astore #10
    //   157: aload #10
    //   159: ldc '00 dstBuf:'
    //   161: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload #10
    //   167: aload #8
    //   169: invokevirtual capacity : ()I
    //   172: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload #10
    //   178: ldc ',frame.mSize:'
    //   180: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload #10
    //   186: aload_1
    //   187: getfield mSize : I
    //   190: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload #10
    //   196: ldc ',frame.mBuffer.capacity:'
    //   198: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload #10
    //   204: aload_1
    //   205: getfield mBuffer : Ljava/nio/ByteBuffer;
    //   208: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload #10
    //   214: ldc ',mSrcSize:'
    //   216: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload #10
    //   222: aload_2
    //   223: getfield d : I
    //   226: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload #9
    //   232: ldc 'PLYuvHWEncoder'
    //   234: aload #10
    //   236: invokevirtual toString : ()Ljava/lang/String;
    //   239: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   242: aload_0
    //   243: getfield o : Ljava/nio/ByteBuffer;
    //   246: ifnull -> 264
    //   249: aload_0
    //   250: getfield o : Ljava/nio/ByteBuffer;
    //   253: invokevirtual capacity : ()I
    //   256: aload #8
    //   258: invokevirtual capacity : ()I
    //   261: if_icmpge -> 276
    //   264: aload_0
    //   265: aload #8
    //   267: invokevirtual capacity : ()I
    //   270: invokestatic allocateDirect : (I)Ljava/nio/ByteBuffer;
    //   273: putfield o : Ljava/nio/ByteBuffer;
    //   276: aload_0
    //   277: getfield o : Ljava/nio/ByteBuffer;
    //   280: invokevirtual clear : ()Ljava/nio/Buffer;
    //   283: pop
    //   284: aload_0
    //   285: getfield p : Lcom/qiniu/pili/droid/streaming/processing/image/ImageProcessor;
    //   288: aload_2
    //   289: getfield n : I
    //   292: invokevirtual a : (I)V
    //   295: aload_0
    //   296: getfield p : Lcom/qiniu/pili/droid/streaming/processing/image/ImageProcessor;
    //   299: aload_1
    //   300: getfield mBuffer : Ljava/nio/ByteBuffer;
    //   303: aload_1
    //   304: getfield mSize : I
    //   307: aload_0
    //   308: getfield o : Ljava/nio/ByteBuffer;
    //   311: aload_2
    //   312: getfield m : Z
    //   315: invokevirtual convertYUV : (Ljava/nio/ByteBuffer;ILjava/nio/ByteBuffer;Z)I
    //   318: istore #5
    //   320: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   323: astore #9
    //   325: new java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial <init> : ()V
    //   332: astore #10
    //   334: aload #10
    //   336: ldc '11 dstBuf:'
    //   338: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload #10
    //   344: aload #8
    //   346: invokevirtual capacity : ()I
    //   349: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload #10
    //   355: ldc ',frame.mSize:'
    //   357: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: aload #10
    //   363: aload_1
    //   364: getfield mSize : I
    //   367: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload #10
    //   373: ldc ',frame.mBuffer.capacity:'
    //   375: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload #10
    //   381: aload_1
    //   382: getfield mBuffer : Ljava/nio/ByteBuffer;
    //   385: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload #10
    //   391: ldc ',mSrcSize:'
    //   393: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload #10
    //   399: aload_2
    //   400: getfield d : I
    //   403: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload #10
    //   409: ldc ',size:'
    //   411: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: aload #10
    //   417: iload #5
    //   419: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload #9
    //   425: ldc 'PLYuvHWEncoder'
    //   427: aload #10
    //   429: invokevirtual toString : ()Ljava/lang/String;
    //   432: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   435: iload #5
    //   437: ifle -> 1668
    //   440: aload #8
    //   442: invokevirtual clear : ()Ljava/nio/Buffer;
    //   445: pop
    //   446: aload #8
    //   448: aload_0
    //   449: getfield o : Ljava/nio/ByteBuffer;
    //   452: invokevirtual put : (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   455: pop
    //   456: aload_0
    //   457: getfield b : Landroid/media/MediaCodec;
    //   460: iload #4
    //   462: iconst_0
    //   463: iload #5
    //   465: aload_1
    //   466: getfield mPresentationTimeUs : J
    //   469: ldc2_w 1000
    //   472: ldiv
    //   473: iconst_0
    //   474: invokevirtual queueInputBuffer : (IIIJI)V
    //   477: iconst_1
    //   478: istore #4
    //   480: goto -> 497
    //   483: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   486: ldc 'PLYuvHWEncoder'
    //   488: ldc_w 'queueInputBuffer warning. The size of inputBuffer is too small'
    //   491: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   494: goto -> 1668
    //   497: aload_0
    //   498: aload_1
    //   499: invokevirtual a : (Lcom/qiniu/pili/droid/streaming/av/common/PLAVFrame;)V
    //   502: aload #6
    //   504: astore_2
    //   505: iload #4
    //   507: ifne -> 525
    //   510: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   513: ldc 'PLYuvHWEncoder'
    //   515: ldc_w 'Warning. The source is not queue properly'
    //   518: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   521: aload #7
    //   523: monitorexit
    //   524: return
    //   525: aload_0
    //   526: getfield b : Landroid/media/MediaCodec;
    //   529: aload_0
    //   530: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   533: ldc2_w 1000
    //   536: invokevirtual dequeueOutputBuffer : (Landroid/media/MediaCodec$BufferInfo;J)I
    //   539: istore #5
    //   541: iload #5
    //   543: iconst_m1
    //   544: if_icmpne -> 550
    //   547: goto -> 1514
    //   550: iload #5
    //   552: bipush #-3
    //   554: if_icmpne -> 568
    //   557: aload_0
    //   558: getfield b : Landroid/media/MediaCodec;
    //   561: invokevirtual getOutputBuffers : ()[Ljava/nio/ByteBuffer;
    //   564: astore_2
    //   565: goto -> 525
    //   568: iload #5
    //   570: bipush #-2
    //   572: if_icmpne -> 733
    //   575: aload_0
    //   576: getfield b : Landroid/media/MediaCodec;
    //   579: invokevirtual getOutputFormat : ()Landroid/media/MediaFormat;
    //   582: astore_1
    //   583: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   586: astore #6
    //   588: new java/lang/StringBuilder
    //   591: dup
    //   592: invokespecial <init> : ()V
    //   595: astore #8
    //   597: aload #8
    //   599: ldc_w 'encoder output format changed: '
    //   602: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: pop
    //   606: aload #8
    //   608: aload_1
    //   609: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: aload #6
    //   615: ldc 'PLYuvHWEncoder'
    //   617: aload #8
    //   619: invokevirtual toString : ()Ljava/lang/String;
    //   622: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   625: aload_1
    //   626: ldc_w 'mime'
    //   629: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   632: ldc_w 'video/avc'
    //   635: invokevirtual compareTo : (Ljava/lang/String;)I
    //   638: ifne -> 649
    //   641: aload_0
    //   642: iconst_1
    //   643: putfield i : I
    //   646: goto -> 654
    //   649: aload_0
    //   650: iconst_0
    //   651: putfield i : I
    //   654: aload_0
    //   655: getfield k : La/a/a/a/a/a/i/c;
    //   658: aload_0
    //   659: getfield i : I
    //   662: invokevirtual a : (I)V
    //   665: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   668: astore_1
    //   669: new java/lang/StringBuilder
    //   672: dup
    //   673: invokespecial <init> : ()V
    //   676: astore #6
    //   678: aload #6
    //   680: ldc_w 'ADDED TRACK INDEX: '
    //   683: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: pop
    //   687: aload #6
    //   689: aload_0
    //   690: getfield i : I
    //   693: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   696: pop
    //   697: aload #6
    //   699: ldc_w ' '
    //   702: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: pop
    //   706: aload #6
    //   708: aload_0
    //   709: invokevirtual getClass : ()Ljava/lang/Class;
    //   712: invokevirtual getName : ()Ljava/lang/String;
    //   715: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: aload_1
    //   720: ldc 'PLYuvHWEncoder'
    //   722: aload #6
    //   724: invokevirtual toString : ()Ljava/lang/String;
    //   727: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   730: goto -> 525
    //   733: iload #5
    //   735: ifge -> 782
    //   738: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   741: astore_1
    //   742: new java/lang/StringBuilder
    //   745: dup
    //   746: invokespecial <init> : ()V
    //   749: astore #6
    //   751: aload #6
    //   753: ldc_w 'unexpected result from encoder.dequeueOutputBuffer: '
    //   756: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: pop
    //   760: aload #6
    //   762: iload #5
    //   764: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   767: pop
    //   768: aload_1
    //   769: ldc 'PLYuvHWEncoder'
    //   771: aload #6
    //   773: invokevirtual toString : ()Ljava/lang/String;
    //   776: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   779: goto -> 525
    //   782: aload_2
    //   783: iload #5
    //   785: aaload
    //   786: astore #8
    //   788: aload #8
    //   790: ifnull -> 1518
    //   793: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   796: astore_1
    //   797: new java/lang/StringBuilder
    //   800: dup
    //   801: invokespecial <init> : ()V
    //   804: astore #6
    //   806: aload #6
    //   808: ldc_w 'mTrackIndex:'
    //   811: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: pop
    //   815: aload #6
    //   817: aload_0
    //   818: getfield i : I
    //   821: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   824: pop
    //   825: aload #6
    //   827: ldc_w 'mBufferInfo.size:'
    //   830: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: pop
    //   834: aload #6
    //   836: aload_0
    //   837: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   840: getfield size : I
    //   843: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   846: pop
    //   847: aload #6
    //   849: ldc_w ',mForceEos='
    //   852: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: pop
    //   856: aload #6
    //   858: aload_0
    //   859: getfield h : Z
    //   862: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   865: pop
    //   866: aload #6
    //   868: ldc_w ',endOfStream='
    //   871: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: pop
    //   875: aload #6
    //   877: iconst_0
    //   878: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   881: pop
    //   882: aload #6
    //   884: ldc_w ',BUFFER_FLAG_CODEC_CONFIG:'
    //   887: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: pop
    //   891: aload_0
    //   892: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   895: getfield flags : I
    //   898: iconst_2
    //   899: iand
    //   900: ifeq -> 1674
    //   903: iconst_1
    //   904: istore_3
    //   905: goto -> 908
    //   908: aload #6
    //   910: iload_3
    //   911: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   914: pop
    //   915: aload_1
    //   916: ldc 'PLYuvHWEncoder'
    //   918: aload #6
    //   920: invokevirtual toString : ()Ljava/lang/String;
    //   923: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   926: aload_0
    //   927: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   930: getfield size : I
    //   933: iflt -> 1491
    //   936: aload #8
    //   938: aload_0
    //   939: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   942: getfield offset : I
    //   945: invokevirtual position : (I)Ljava/nio/Buffer;
    //   948: pop
    //   949: aload #8
    //   951: aload_0
    //   952: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   955: getfield offset : I
    //   958: aload_0
    //   959: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   962: getfield size : I
    //   965: iadd
    //   966: invokevirtual limit : (I)Ljava/nio/Buffer;
    //   969: pop
    //   970: aload_0
    //   971: getfield h : Z
    //   974: ifeq -> 1004
    //   977: aload_0
    //   978: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   981: aload_0
    //   982: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   985: getfield flags : I
    //   988: iconst_4
    //   989: ior
    //   990: putfield flags : I
    //   993: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   996: ldc 'PLYuvHWEncoder'
    //   998: ldc_w 'Forcing EOS'
    //   1001: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   1004: aload_0
    //   1005: invokevirtual f : ()V
    //   1008: aload_0
    //   1009: getfield a : Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;
    //   1012: invokestatic b : (Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;)Z
    //   1015: ifeq -> 1101
    //   1018: aload_0
    //   1019: getfield i : I
    //   1022: ifne -> 1101
    //   1025: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   1028: astore_1
    //   1029: new java/lang/StringBuilder
    //   1032: dup
    //   1033: invokespecial <init> : ()V
    //   1036: astore #6
    //   1038: aload #6
    //   1040: ldc_w 'mBufferInfo.size = '
    //   1043: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: pop
    //   1047: aload #6
    //   1049: aload_0
    //   1050: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   1053: getfield size : I
    //   1056: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1059: pop
    //   1060: aload #6
    //   1062: ldc_w 'ignore mBufferInfo.presentationTimeUs '
    //   1065: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: pop
    //   1069: aload #6
    //   1071: aload_0
    //   1072: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   1075: getfield presentationTimeUs : J
    //   1078: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   1081: pop
    //   1082: aload_1
    //   1083: ldc 'PLYuvHWEncoder'
    //   1085: aload #6
    //   1087: invokevirtual toString : ()Ljava/lang/String;
    //   1090: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   1093: aload_0
    //   1094: getfield a : Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;
    //   1097: lconst_0
    //   1098: putfield presentationTimeUs : J
    //   1101: aload_0
    //   1102: getfield j : Ljava/util/ArrayDeque;
    //   1105: invokevirtual isEmpty : ()Z
    //   1108: ifeq -> 1167
    //   1111: aload_0
    //   1112: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   1115: getfield size : I
    //   1118: istore #4
    //   1120: aload_0
    //   1121: getfield a : Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;
    //   1124: invokestatic a : (Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;)Z
    //   1127: ifeq -> 1137
    //   1130: aload #8
    //   1132: invokevirtual capacity : ()I
    //   1135: istore #4
    //   1137: new com/qiniu/pili/droid/streaming/av/common/PLAVFrame
    //   1140: dup
    //   1141: iload #4
    //   1143: invokestatic allocateDirect : (I)Ljava/nio/ByteBuffer;
    //   1146: aload_0
    //   1147: getfield a : Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;
    //   1150: getfield size : I
    //   1153: aload_0
    //   1154: getfield a : Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;
    //   1157: getfield presentationTimeUs : J
    //   1160: invokespecial <init> : (Ljava/nio/ByteBuffer;IJ)V
    //   1163: astore_1
    //   1164: goto -> 1248
    //   1167: aload_0
    //   1168: getfield j : Ljava/util/ArrayDeque;
    //   1171: invokevirtual remove : ()Ljava/lang/Object;
    //   1174: checkcast com/qiniu/pili/droid/streaming/av/common/PLAVFrame
    //   1177: astore #6
    //   1179: aload_0
    //   1180: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   1183: getfield size : I
    //   1186: istore #4
    //   1188: aload_0
    //   1189: getfield a : Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;
    //   1192: invokestatic a : (Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;)Z
    //   1195: ifeq -> 1205
    //   1198: aload #8
    //   1200: invokevirtual capacity : ()I
    //   1203: istore #4
    //   1205: aload #6
    //   1207: astore_1
    //   1208: aload #6
    //   1210: getfield mBuffer : Ljava/nio/ByteBuffer;
    //   1213: invokevirtual capacity : ()I
    //   1216: iload #4
    //   1218: if_icmpge -> 1248
    //   1221: new com/qiniu/pili/droid/streaming/av/common/PLAVFrame
    //   1224: dup
    //   1225: iload #4
    //   1227: invokestatic allocateDirect : (I)Ljava/nio/ByteBuffer;
    //   1230: aload_0
    //   1231: getfield a : Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;
    //   1234: getfield size : I
    //   1237: aload_0
    //   1238: getfield a : Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;
    //   1241: getfield presentationTimeUs : J
    //   1244: invokespecial <init> : (Ljava/nio/ByteBuffer;IJ)V
    //   1247: astore_1
    //   1248: aload_1
    //   1249: getfield mBuffer : Ljava/nio/ByteBuffer;
    //   1252: invokevirtual clear : ()Ljava/nio/Buffer;
    //   1255: pop
    //   1256: aload #8
    //   1258: invokevirtual isReadOnly : ()Z
    //   1261: ifeq -> 1362
    //   1264: aload_0
    //   1265: getfield d : Ljava/nio/ByteBuffer;
    //   1268: ifnonnull -> 1283
    //   1271: aload_0
    //   1272: aload #8
    //   1274: invokevirtual capacity : ()I
    //   1277: invokestatic allocateDirect : (I)Ljava/nio/ByteBuffer;
    //   1280: putfield d : Ljava/nio/ByteBuffer;
    //   1283: aload_0
    //   1284: getfield d : Ljava/nio/ByteBuffer;
    //   1287: invokevirtual clear : ()Ljava/nio/Buffer;
    //   1290: pop
    //   1291: aload_0
    //   1292: getfield d : Ljava/nio/ByteBuffer;
    //   1295: aload #8
    //   1297: invokevirtual put : (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   1300: pop
    //   1301: aload_0
    //   1302: getfield d : Ljava/nio/ByteBuffer;
    //   1305: aload_0
    //   1306: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   1309: getfield offset : I
    //   1312: invokevirtual position : (I)Ljava/nio/Buffer;
    //   1315: pop
    //   1316: aload_0
    //   1317: getfield d : Ljava/nio/ByteBuffer;
    //   1320: aload_0
    //   1321: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   1324: getfield offset : I
    //   1327: aload_0
    //   1328: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   1331: getfield size : I
    //   1334: iadd
    //   1335: invokevirtual limit : (I)Ljava/nio/Buffer;
    //   1338: pop
    //   1339: aload_1
    //   1340: getfield mBuffer : Ljava/nio/ByteBuffer;
    //   1343: aload_0
    //   1344: getfield d : Ljava/nio/ByteBuffer;
    //   1347: invokevirtual put : (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   1350: pop
    //   1351: aload_0
    //   1352: getfield d : Ljava/nio/ByteBuffer;
    //   1355: invokevirtual compact : ()Ljava/nio/ByteBuffer;
    //   1358: pop
    //   1359: goto -> 1378
    //   1362: aload_1
    //   1363: getfield mBuffer : Ljava/nio/ByteBuffer;
    //   1366: aload #8
    //   1368: invokevirtual put : (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   1371: pop
    //   1372: aload #8
    //   1374: invokevirtual compact : ()Ljava/nio/ByteBuffer;
    //   1377: pop
    //   1378: aload_1
    //   1379: getfield mBuffer : Ljava/nio/ByteBuffer;
    //   1382: invokevirtual flip : ()Ljava/nio/Buffer;
    //   1385: pop
    //   1386: aload_0
    //   1387: getfield k : La/a/a/a/a/a/i/c;
    //   1390: aload_0
    //   1391: getfield i : I
    //   1394: iload #5
    //   1396: aload_1
    //   1397: aload_0
    //   1398: getfield a : Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;
    //   1401: invokevirtual a : (IILcom/qiniu/pili/droid/streaming/av/common/PLAVFrame;Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;)V
    //   1404: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   1407: astore_1
    //   1408: new java/lang/StringBuilder
    //   1411: dup
    //   1412: invokespecial <init> : ()V
    //   1415: astore #6
    //   1417: aload #6
    //   1419: ldc_w 'sent '
    //   1422: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: pop
    //   1426: aload #6
    //   1428: aload_0
    //   1429: getfield a : Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;
    //   1432: getfield size : I
    //   1435: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1438: pop
    //   1439: aload #6
    //   1441: ldc_w ' bytes to muxer, \\t ts='
    //   1444: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1447: pop
    //   1448: aload #6
    //   1450: aload_0
    //   1451: getfield a : Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;
    //   1454: getfield presentationTimeUs : J
    //   1457: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   1460: pop
    //   1461: aload #6
    //   1463: ldc_w 'track '
    //   1466: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1469: pop
    //   1470: aload #6
    //   1472: aload_0
    //   1473: getfield i : I
    //   1476: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1479: pop
    //   1480: aload_1
    //   1481: ldc 'PLYuvHWEncoder'
    //   1483: aload #6
    //   1485: invokevirtual toString : ()Ljava/lang/String;
    //   1488: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   1491: aload_0
    //   1492: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   1495: getfield flags : I
    //   1498: iconst_4
    //   1499: iand
    //   1500: ifeq -> 525
    //   1503: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   1506: ldc 'PLYuvHWEncoder'
    //   1508: ldc_w 'reached end of stream unexpectedly'
    //   1511: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   1514: aload #7
    //   1516: monitorexit
    //   1517: return
    //   1518: new java/lang/StringBuilder
    //   1521: dup
    //   1522: invokespecial <init> : ()V
    //   1525: astore_1
    //   1526: aload_1
    //   1527: ldc_w 'encoderOutputBuffer '
    //   1530: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1533: pop
    //   1534: aload_1
    //   1535: iload #5
    //   1537: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1540: pop
    //   1541: aload_1
    //   1542: ldc_w ' was null'
    //   1545: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1548: pop
    //   1549: new java/lang/RuntimeException
    //   1552: dup
    //   1553: aload_1
    //   1554: invokevirtual toString : ()Ljava/lang/String;
    //   1557: invokespecial <init> : (Ljava/lang/String;)V
    //   1560: athrow
    //   1561: aload_0
    //   1562: aload_1
    //   1563: invokevirtual a : (Lcom/qiniu/pili/droid/streaming/av/common/PLAVFrame;)V
    //   1566: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   1569: astore_1
    //   1570: new java/lang/StringBuilder
    //   1573: dup
    //   1574: invokespecial <init> : ()V
    //   1577: astore_2
    //   1578: aload_2
    //   1579: ldc_w 'isReady:'
    //   1582: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1585: pop
    //   1586: aload_2
    //   1587: aload_0
    //   1588: getfield k : La/a/a/a/a/a/i/c;
    //   1591: invokevirtual f : ()Z
    //   1594: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   1597: pop
    //   1598: aload_2
    //   1599: ldc_w ',mEncoderStarted:'
    //   1602: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1605: pop
    //   1606: aload_2
    //   1607: aload_0
    //   1608: getfield f : Z
    //   1611: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   1614: pop
    //   1615: aload_2
    //   1616: ldc_w ',ImageProcessor.isLoadOk:'
    //   1619: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1622: pop
    //   1623: aload_2
    //   1624: getstatic com/qiniu/pili/droid/streaming/processing/image/ImageProcessor.b : Z
    //   1627: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   1630: pop
    //   1631: aload_2
    //   1632: ldc_w ',mImageProcessor:'
    //   1635: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1638: pop
    //   1639: aload_2
    //   1640: aload_0
    //   1641: getfield p : Lcom/qiniu/pili/droid/streaming/processing/image/ImageProcessor;
    //   1644: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1647: pop
    //   1648: aload_1
    //   1649: ldc 'PLYuvHWEncoder'
    //   1651: aload_2
    //   1652: invokevirtual toString : ()Ljava/lang/String;
    //   1655: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   1658: aload #7
    //   1660: monitorexit
    //   1661: return
    //   1662: astore_1
    //   1663: aload #7
    //   1665: monitorexit
    //   1666: aload_1
    //   1667: athrow
    //   1668: iconst_0
    //   1669: istore #4
    //   1671: goto -> 497
    //   1674: iconst_0
    //   1675: istore_3
    //   1676: goto -> 908
    // Exception table:
    //   from	to	target	type
    //   9	39	1662	finally
    //   42	47	1662	finally
    //   47	131	1662	finally
    //   143	148	1662	finally
    //   148	264	1662	finally
    //   264	276	1662	finally
    //   276	325	1662	finally
    //   325	435	1662	finally
    //   440	477	1662	finally
    //   483	494	1662	finally
    //   497	502	1662	finally
    //   510	524	1662	finally
    //   525	541	1662	finally
    //   557	565	1662	finally
    //   575	588	1662	finally
    //   588	646	1662	finally
    //   649	654	1662	finally
    //   654	669	1662	finally
    //   669	730	1662	finally
    //   738	742	1662	finally
    //   742	779	1662	finally
    //   793	797	1662	finally
    //   797	903	1662	finally
    //   908	1004	1662	finally
    //   1004	1029	1662	finally
    //   1029	1101	1662	finally
    //   1101	1120	1662	finally
    //   1120	1137	1662	finally
    //   1137	1164	1662	finally
    //   1167	1188	1662	finally
    //   1188	1205	1662	finally
    //   1208	1248	1662	finally
    //   1248	1283	1662	finally
    //   1283	1359	1662	finally
    //   1362	1378	1662	finally
    //   1378	1408	1662	finally
    //   1408	1491	1662	finally
    //   1491	1514	1662	finally
    //   1514	1517	1662	finally
    //   1518	1561	1662	finally
    //   1561	1570	1662	finally
    //   1570	1661	1662	finally
    //   1663	1666	1662	finally
  }
  
  public PLAVFrame b(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield m : Ljava/lang/Object;
    //   4: astore #4
    //   6: aload #4
    //   8: monitorenter
    //   9: iload_1
    //   10: ifgt -> 58
    //   13: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   16: astore_3
    //   17: new java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial <init> : ()V
    //   24: astore #5
    //   26: aload #5
    //   28: ldc_w 'Init improperly:'
    //   31: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload #5
    //   37: iload_1
    //   38: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_3
    //   43: ldc 'PLYuvHWEncoder'
    //   45: aload #5
    //   47: invokevirtual toString : ()Ljava/lang/String;
    //   50: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload #4
    //   55: monitorexit
    //   56: aconst_null
    //   57: areturn
    //   58: aload_0
    //   59: getfield l : Ljava/util/ArrayDeque;
    //   62: invokevirtual isEmpty : ()Z
    //   65: ifne -> 148
    //   68: aload_0
    //   69: getfield l : Ljava/util/ArrayDeque;
    //   72: invokevirtual remove : ()Ljava/lang/Object;
    //   75: checkcast com/qiniu/pili/droid/streaming/av/common/PLAVFrame
    //   78: astore_3
    //   79: aload_3
    //   80: ifnull -> 106
    //   83: aload_3
    //   84: getfield mBuffer : Ljava/nio/ByteBuffer;
    //   87: ifnull -> 106
    //   90: aload_3
    //   91: getfield mBuffer : Ljava/nio/ByteBuffer;
    //   94: invokevirtual capacity : ()I
    //   97: iload_1
    //   98: if_icmplt -> 106
    //   101: aload #4
    //   103: monitorexit
    //   104: aload_3
    //   105: areturn
    //   106: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   109: astore #5
    //   111: new java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial <init> : ()V
    //   118: astore #6
    //   120: aload #6
    //   122: ldc_w 'The frame is:'
    //   125: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload #6
    //   131: aload_3
    //   132: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload #5
    //   138: ldc 'PLYuvHWEncoder'
    //   140: aload #6
    //   142: invokevirtual toString : ()Ljava/lang/String;
    //   145: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload_0
    //   149: getfield n : I
    //   152: istore_2
    //   153: iload_2
    //   154: iconst_2
    //   155: if_icmpge -> 267
    //   158: new com/qiniu/pili/droid/streaming/av/common/PLAVFrame
    //   161: dup
    //   162: iload_1
    //   163: invokestatic allocateDirect : (I)Ljava/nio/ByteBuffer;
    //   166: iconst_0
    //   167: lconst_0
    //   168: invokespecial <init> : (Ljava/nio/ByteBuffer;IJ)V
    //   171: astore_3
    //   172: aload_0
    //   173: aload_0
    //   174: getfield n : I
    //   177: iconst_1
    //   178: iadd
    //   179: putfield n : I
    //   182: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   185: astore #5
    //   187: new java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial <init> : ()V
    //   194: astore #6
    //   196: aload #6
    //   198: ldc_w 'Allocate extra buffer mInputExtraNum:'
    //   201: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload #6
    //   207: aload_0
    //   208: getfield n : I
    //   211: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload #6
    //   217: ldc_w ',frame.buffer:'
    //   220: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload #6
    //   226: aload_3
    //   227: getfield mBuffer : Ljava/nio/ByteBuffer;
    //   230: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload #5
    //   236: ldc 'PLYuvHWEncoder'
    //   238: aload #6
    //   240: invokevirtual toString : ()Ljava/lang/String;
    //   243: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   246: goto -> 262
    //   249: aconst_null
    //   250: astore_3
    //   251: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   254: ldc 'PLYuvHWEncoder'
    //   256: ldc_w 'Fatal Error. OOM !!!'
    //   259: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload #4
    //   264: monitorexit
    //   265: aload_3
    //   266: areturn
    //   267: aload #4
    //   269: monitorexit
    //   270: aconst_null
    //   271: areturn
    //   272: astore_3
    //   273: aload #4
    //   275: monitorexit
    //   276: aload_3
    //   277: athrow
    //   278: astore_3
    //   279: goto -> 249
    //   282: astore #5
    //   284: goto -> 251
    // Exception table:
    //   from	to	target	type
    //   13	17	272	finally
    //   17	56	272	finally
    //   58	79	272	finally
    //   83	104	272	finally
    //   106	111	272	finally
    //   111	148	272	finally
    //   148	153	272	finally
    //   158	172	278	java/lang/OutOfMemoryError
    //   158	172	272	finally
    //   172	187	282	java/lang/OutOfMemoryError
    //   172	187	272	finally
    //   187	246	282	java/lang/OutOfMemoryError
    //   187	246	272	finally
    //   251	262	272	finally
    //   262	265	272	finally
    //   267	270	272	finally
    //   273	276	272	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\g\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */