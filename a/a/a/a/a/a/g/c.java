package a.a.a.a.a.a.g;

import a.a.a.a.a.e.e;
import a.a.a.a.a.e.h;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import com.qiniu.pili.droid.streaming.av.common.PLBufferInfo;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;

public class c extends b {
  public MediaCodec b;
  
  public MediaCodec.BufferInfo c;
  
  public ByteBuffer d;
  
  public int e = 0;
  
  public volatile boolean f;
  
  public boolean g = false;
  
  public volatile boolean h = false;
  
  public int i;
  
  public ArrayDeque<PLAVFrame> j = new ArrayDeque<PLAVFrame>();
  
  public c() {}
  
  public c(MediaFormat paramMediaFormat, String paramString, boolean paramBoolean) {
    this.g = paramBoolean;
    try {
      this.c = new MediaCodec.BufferInfo();
      MediaCodec mediaCodec = MediaCodec.createEncoderByType(paramString);
      this.b = mediaCodec;
      mediaCodec.configure(paramMediaFormat, null, null, 1);
      this.f = paramBoolean ^ true;
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void a() {
    MediaCodec mediaCodec = this.b;
    if (mediaCodec == null) {
      e.i.d("PLHWEncoder", "mEncoder had been released!");
      return;
    } 
    try {
      this.f = false;
      mediaCodec.stop();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    this.j.clear();
    this.b.release();
    this.b = null;
    e.i.c("PLHWEncoder", "Released encoder");
  }
  
  public void a(int paramInt) {
    if (h.a() && this.b != null && this.f) {
      Bundle bundle = new Bundle();
      bundle.putInt("video-bitrate", paramInt);
      this.b.setParameters(bundle);
      return;
    } 
    if (!h.a())
      e.i.d("PLHWEncoder", "Ignoring adjustVideoBitrate call. This functionality is only available on Android API 19+"); 
  }
  
  public void a(a.a.a.a.a.a.i.c paramc, boolean paramBoolean) {
    // Byte code:
    //   0: aload_1
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual f : ()Z
    //   6: ifeq -> 1320
    //   9: aload_0
    //   10: getfield f : Z
    //   13: ifne -> 19
    //   16: goto -> 1320
    //   19: iload_2
    //   20: ifeq -> 26
    //   23: aload_1
    //   24: monitorexit
    //   25: return
    //   26: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   29: astore #6
    //   31: new java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial <init> : ()V
    //   38: astore #7
    //   40: aload #7
    //   42: ldc 'drainEncoder('
    //   44: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload #7
    //   50: iload_2
    //   51: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload #7
    //   57: ldc ') track: '
    //   59: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload #7
    //   65: aload_0
    //   66: getfield i : I
    //   69: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload #6
    //   75: ldc 'PLHWEncoder'
    //   77: aload #7
    //   79: invokevirtual toString : ()Ljava/lang/String;
    //   82: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   85: iload_2
    //   86: ifeq -> 133
    //   89: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   92: astore #6
    //   94: new java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial <init> : ()V
    //   101: astore #7
    //   103: aload #7
    //   105: ldc 'sending EOS to encoder for track '
    //   107: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload #7
    //   113: aload_0
    //   114: getfield i : I
    //   117: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload #6
    //   123: ldc 'PLHWEncoder'
    //   125: aload #7
    //   127: invokevirtual toString : ()Ljava/lang/String;
    //   130: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload_0
    //   134: getfield b : Landroid/media/MediaCodec;
    //   137: invokevirtual getOutputBuffers : ()[Ljava/nio/ByteBuffer;
    //   140: astore #7
    //   142: aload_0
    //   143: getfield b : Landroid/media/MediaCodec;
    //   146: aload_0
    //   147: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   150: ldc2_w 1000
    //   153: invokevirtual dequeueOutputBuffer : (Landroid/media/MediaCodec$BufferInfo;J)I
    //   156: istore #4
    //   158: iconst_1
    //   159: istore #5
    //   161: iload #4
    //   163: iconst_m1
    //   164: if_icmpne -> 222
    //   167: iload_2
    //   168: ifne -> 174
    //   171: goto -> 1233
    //   174: aload_0
    //   175: getfield e : I
    //   178: iconst_1
    //   179: iadd
    //   180: istore_3
    //   181: aload_0
    //   182: iload_3
    //   183: putfield e : I
    //   186: iload_3
    //   187: bipush #10
    //   189: if_icmple -> 209
    //   192: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   195: ldc 'PLHWEncoder'
    //   197: ldc 'Force shutting down Muxer'
    //   199: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   202: aload_1
    //   203: invokevirtual a : ()V
    //   206: goto -> 1233
    //   209: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   212: ldc 'PLHWEncoder'
    //   214: ldc 'no output available, spinning to await EOS'
    //   216: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   219: goto -> 142
    //   222: iload #4
    //   224: bipush #-3
    //   226: if_icmpne -> 241
    //   229: aload_0
    //   230: getfield b : Landroid/media/MediaCodec;
    //   233: invokevirtual getOutputBuffers : ()[Ljava/nio/ByteBuffer;
    //   236: astore #7
    //   238: goto -> 142
    //   241: iload #4
    //   243: bipush #-2
    //   245: if_icmpne -> 403
    //   248: aload_0
    //   249: getfield b : Landroid/media/MediaCodec;
    //   252: invokevirtual getOutputFormat : ()Landroid/media/MediaFormat;
    //   255: astore #6
    //   257: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   260: astore #8
    //   262: new java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial <init> : ()V
    //   269: astore #9
    //   271: aload #9
    //   273: ldc 'encoder output format changed: '
    //   275: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload #9
    //   281: aload #6
    //   283: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload #8
    //   289: ldc 'PLHWEncoder'
    //   291: aload #9
    //   293: invokevirtual toString : ()Ljava/lang/String;
    //   296: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   299: aload #6
    //   301: ldc 'mime'
    //   303: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   306: ldc 'video/avc'
    //   308: invokevirtual compareTo : (Ljava/lang/String;)I
    //   311: ifne -> 322
    //   314: aload_0
    //   315: iconst_1
    //   316: putfield i : I
    //   319: goto -> 327
    //   322: aload_0
    //   323: iconst_0
    //   324: putfield i : I
    //   327: aload_1
    //   328: aload_0
    //   329: getfield i : I
    //   332: invokevirtual a : (I)V
    //   335: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   338: astore #6
    //   340: new java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial <init> : ()V
    //   347: astore #8
    //   349: aload #8
    //   351: ldc 'ADDED TRACK INDEX: '
    //   353: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload #8
    //   359: aload_0
    //   360: getfield i : I
    //   363: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload #8
    //   369: ldc ' '
    //   371: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload #8
    //   377: aload_0
    //   378: invokevirtual getClass : ()Ljava/lang/Class;
    //   381: invokevirtual getName : ()Ljava/lang/String;
    //   384: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: pop
    //   388: aload #6
    //   390: ldc 'PLHWEncoder'
    //   392: aload #8
    //   394: invokevirtual toString : ()Ljava/lang/String;
    //   397: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   400: goto -> 142
    //   403: iload #4
    //   405: ifge -> 453
    //   408: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   411: astore #6
    //   413: new java/lang/StringBuilder
    //   416: dup
    //   417: invokespecial <init> : ()V
    //   420: astore #8
    //   422: aload #8
    //   424: ldc 'unexpected result from encoder.dequeueOutputBuffer: '
    //   426: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload #8
    //   432: iload #4
    //   434: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload #6
    //   440: ldc 'PLHWEncoder'
    //   442: aload #8
    //   444: invokevirtual toString : ()Ljava/lang/String;
    //   447: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   450: goto -> 142
    //   453: aload #7
    //   455: iload #4
    //   457: aaload
    //   458: astore #9
    //   460: aload #9
    //   462: ifnull -> 1272
    //   465: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   468: astore #6
    //   470: new java/lang/StringBuilder
    //   473: dup
    //   474: invokespecial <init> : ()V
    //   477: astore #8
    //   479: aload #8
    //   481: ldc 'mTrackIndex:'
    //   483: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload #8
    //   489: aload_0
    //   490: getfield i : I
    //   493: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload #8
    //   499: ldc 'mBufferInfo.size:'
    //   501: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: aload #8
    //   507: aload_0
    //   508: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   511: getfield size : I
    //   514: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: aload #8
    //   520: ldc ',mForceEos='
    //   522: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: aload #8
    //   528: aload_0
    //   529: getfield h : Z
    //   532: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   535: pop
    //   536: aload #8
    //   538: ldc ',endOfStream='
    //   540: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: aload #8
    //   546: iload_2
    //   547: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload #8
    //   553: ldc ',BUFFER_FLAG_CODEC_CONFIG:'
    //   555: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: pop
    //   559: aload_0
    //   560: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   563: getfield flags : I
    //   566: iconst_2
    //   567: iand
    //   568: ifeq -> 1330
    //   571: goto -> 574
    //   574: aload #8
    //   576: iload #5
    //   578: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload #6
    //   584: ldc 'PLHWEncoder'
    //   586: aload #8
    //   588: invokevirtual toString : ()Ljava/lang/String;
    //   591: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   594: aload_0
    //   595: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   598: getfield size : I
    //   601: iflt -> 1158
    //   604: aload #9
    //   606: aload_0
    //   607: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   610: getfield offset : I
    //   613: invokevirtual position : (I)Ljava/nio/Buffer;
    //   616: pop
    //   617: aload #9
    //   619: aload_0
    //   620: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   623: getfield offset : I
    //   626: aload_0
    //   627: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   630: getfield size : I
    //   633: iadd
    //   634: invokevirtual limit : (I)Ljava/nio/Buffer;
    //   637: pop
    //   638: aload_0
    //   639: getfield h : Z
    //   642: ifeq -> 671
    //   645: aload_0
    //   646: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   649: aload_0
    //   650: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   653: getfield flags : I
    //   656: iconst_4
    //   657: ior
    //   658: putfield flags : I
    //   661: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   664: ldc 'PLHWEncoder'
    //   666: ldc 'Forcing EOS'
    //   668: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   671: aload_0
    //   672: invokevirtual f : ()V
    //   675: aload_0
    //   676: getfield a : Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;
    //   679: invokestatic b : (Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;)Z
    //   682: ifeq -> 768
    //   685: aload_0
    //   686: getfield i : I
    //   689: ifne -> 768
    //   692: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   695: astore #6
    //   697: new java/lang/StringBuilder
    //   700: dup
    //   701: invokespecial <init> : ()V
    //   704: astore #8
    //   706: aload #8
    //   708: ldc 'mBufferInfo.size = '
    //   710: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: pop
    //   714: aload #8
    //   716: aload_0
    //   717: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   720: getfield size : I
    //   723: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   726: pop
    //   727: aload #8
    //   729: ldc 'ignore mBufferInfo.presentationTimeUs '
    //   731: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: aload #8
    //   737: aload_0
    //   738: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   741: getfield presentationTimeUs : J
    //   744: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: aload #6
    //   750: ldc 'PLHWEncoder'
    //   752: aload #8
    //   754: invokevirtual toString : ()Ljava/lang/String;
    //   757: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   760: aload_0
    //   761: getfield a : Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;
    //   764: lconst_0
    //   765: putfield presentationTimeUs : J
    //   768: aload_0
    //   769: getfield j : Ljava/util/ArrayDeque;
    //   772: invokevirtual isEmpty : ()Z
    //   775: ifeq -> 832
    //   778: aload_0
    //   779: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   782: getfield size : I
    //   785: istore_3
    //   786: aload_0
    //   787: getfield a : Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;
    //   790: invokestatic a : (Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;)Z
    //   793: ifeq -> 802
    //   796: aload #9
    //   798: invokevirtual capacity : ()I
    //   801: istore_3
    //   802: new com/qiniu/pili/droid/streaming/av/common/PLAVFrame
    //   805: dup
    //   806: iload_3
    //   807: invokestatic allocateDirect : (I)Ljava/nio/ByteBuffer;
    //   810: aload_0
    //   811: getfield a : Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;
    //   814: getfield size : I
    //   817: aload_0
    //   818: getfield a : Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;
    //   821: getfield presentationTimeUs : J
    //   824: invokespecial <init> : (Ljava/nio/ByteBuffer;IJ)V
    //   827: astore #6
    //   829: goto -> 911
    //   832: aload_0
    //   833: getfield j : Ljava/util/ArrayDeque;
    //   836: invokevirtual remove : ()Ljava/lang/Object;
    //   839: checkcast com/qiniu/pili/droid/streaming/av/common/PLAVFrame
    //   842: astore #8
    //   844: aload_0
    //   845: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   848: getfield size : I
    //   851: istore_3
    //   852: aload_0
    //   853: getfield a : Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;
    //   856: invokestatic a : (Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;)Z
    //   859: ifeq -> 868
    //   862: aload #9
    //   864: invokevirtual capacity : ()I
    //   867: istore_3
    //   868: aload #8
    //   870: astore #6
    //   872: aload #8
    //   874: getfield mBuffer : Ljava/nio/ByteBuffer;
    //   877: invokevirtual capacity : ()I
    //   880: iload_3
    //   881: if_icmpge -> 911
    //   884: new com/qiniu/pili/droid/streaming/av/common/PLAVFrame
    //   887: dup
    //   888: iload_3
    //   889: invokestatic allocateDirect : (I)Ljava/nio/ByteBuffer;
    //   892: aload_0
    //   893: getfield a : Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;
    //   896: getfield size : I
    //   899: aload_0
    //   900: getfield a : Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;
    //   903: getfield presentationTimeUs : J
    //   906: invokespecial <init> : (Ljava/nio/ByteBuffer;IJ)V
    //   909: astore #6
    //   911: aload #6
    //   913: getfield mBuffer : Ljava/nio/ByteBuffer;
    //   916: invokevirtual clear : ()Ljava/nio/Buffer;
    //   919: pop
    //   920: aload #9
    //   922: invokevirtual isReadOnly : ()Z
    //   925: ifeq -> 1027
    //   928: aload_0
    //   929: getfield d : Ljava/nio/ByteBuffer;
    //   932: ifnonnull -> 947
    //   935: aload_0
    //   936: aload #9
    //   938: invokevirtual capacity : ()I
    //   941: invokestatic allocateDirect : (I)Ljava/nio/ByteBuffer;
    //   944: putfield d : Ljava/nio/ByteBuffer;
    //   947: aload_0
    //   948: getfield d : Ljava/nio/ByteBuffer;
    //   951: invokevirtual clear : ()Ljava/nio/Buffer;
    //   954: pop
    //   955: aload_0
    //   956: getfield d : Ljava/nio/ByteBuffer;
    //   959: aload #9
    //   961: invokevirtual put : (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   964: pop
    //   965: aload_0
    //   966: getfield d : Ljava/nio/ByteBuffer;
    //   969: aload_0
    //   970: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   973: getfield offset : I
    //   976: invokevirtual position : (I)Ljava/nio/Buffer;
    //   979: pop
    //   980: aload_0
    //   981: getfield d : Ljava/nio/ByteBuffer;
    //   984: aload_0
    //   985: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   988: getfield offset : I
    //   991: aload_0
    //   992: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   995: getfield size : I
    //   998: iadd
    //   999: invokevirtual limit : (I)Ljava/nio/Buffer;
    //   1002: pop
    //   1003: aload #6
    //   1005: getfield mBuffer : Ljava/nio/ByteBuffer;
    //   1008: aload_0
    //   1009: getfield d : Ljava/nio/ByteBuffer;
    //   1012: invokevirtual put : (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   1015: pop
    //   1016: aload_0
    //   1017: getfield d : Ljava/nio/ByteBuffer;
    //   1020: invokevirtual compact : ()Ljava/nio/ByteBuffer;
    //   1023: pop
    //   1024: goto -> 1044
    //   1027: aload #6
    //   1029: getfield mBuffer : Ljava/nio/ByteBuffer;
    //   1032: aload #9
    //   1034: invokevirtual put : (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   1037: pop
    //   1038: aload #9
    //   1040: invokevirtual compact : ()Ljava/nio/ByteBuffer;
    //   1043: pop
    //   1044: aload #6
    //   1046: getfield mBuffer : Ljava/nio/ByteBuffer;
    //   1049: invokevirtual flip : ()Ljava/nio/Buffer;
    //   1052: pop
    //   1053: aload_1
    //   1054: aload_0
    //   1055: getfield i : I
    //   1058: iload #4
    //   1060: aload #6
    //   1062: aload_0
    //   1063: getfield a : Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;
    //   1066: invokevirtual a : (IILcom/qiniu/pili/droid/streaming/av/common/PLAVFrame;Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;)V
    //   1069: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   1072: astore #6
    //   1074: new java/lang/StringBuilder
    //   1077: dup
    //   1078: invokespecial <init> : ()V
    //   1081: astore #8
    //   1083: aload #8
    //   1085: ldc_w 'sent '
    //   1088: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: pop
    //   1092: aload #8
    //   1094: aload_0
    //   1095: getfield a : Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;
    //   1098: getfield size : I
    //   1101: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1104: pop
    //   1105: aload #8
    //   1107: ldc_w ' bytes to muxer, \\t ts='
    //   1110: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: pop
    //   1114: aload #8
    //   1116: aload_0
    //   1117: getfield a : Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;
    //   1120: getfield presentationTimeUs : J
    //   1123: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   1126: pop
    //   1127: aload #8
    //   1129: ldc_w 'track '
    //   1132: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: pop
    //   1136: aload #8
    //   1138: aload_0
    //   1139: getfield i : I
    //   1142: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1145: pop
    //   1146: aload #6
    //   1148: ldc 'PLHWEncoder'
    //   1150: aload #8
    //   1152: invokevirtual toString : ()Ljava/lang/String;
    //   1155: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   1158: aload_0
    //   1159: getfield c : Landroid/media/MediaCodec$BufferInfo;
    //   1162: getfield flags : I
    //   1165: iconst_4
    //   1166: iand
    //   1167: ifeq -> 142
    //   1170: iload_2
    //   1171: ifne -> 1188
    //   1174: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   1177: ldc 'PLHWEncoder'
    //   1179: ldc_w 'reached end of stream unexpectedly'
    //   1182: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   1185: goto -> 1233
    //   1188: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   1191: astore #6
    //   1193: new java/lang/StringBuilder
    //   1196: dup
    //   1197: invokespecial <init> : ()V
    //   1200: astore #7
    //   1202: aload #7
    //   1204: ldc_w 'end of stream reached for track '
    //   1207: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1210: pop
    //   1211: aload #7
    //   1213: aload_0
    //   1214: getfield i : I
    //   1217: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1220: pop
    //   1221: aload #6
    //   1223: ldc 'PLHWEncoder'
    //   1225: aload #7
    //   1227: invokevirtual toString : ()Ljava/lang/String;
    //   1230: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   1233: iload_2
    //   1234: ifeq -> 1269
    //   1237: aload_0
    //   1238: getfield g : Z
    //   1241: ifeq -> 1258
    //   1244: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   1247: ldc 'PLHWEncoder'
    //   1249: ldc_w 'final video drain complete'
    //   1252: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   1255: goto -> 1269
    //   1258: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   1261: ldc 'PLHWEncoder'
    //   1263: ldc_w 'final audio drain complete'
    //   1266: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   1269: aload_1
    //   1270: monitorexit
    //   1271: return
    //   1272: new java/lang/StringBuilder
    //   1275: dup
    //   1276: invokespecial <init> : ()V
    //   1279: astore #6
    //   1281: aload #6
    //   1283: ldc_w 'encoderOutputBuffer '
    //   1286: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1289: pop
    //   1290: aload #6
    //   1292: iload #4
    //   1294: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1297: pop
    //   1298: aload #6
    //   1300: ldc_w ' was null'
    //   1303: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: pop
    //   1307: new java/lang/RuntimeException
    //   1310: dup
    //   1311: aload #6
    //   1313: invokevirtual toString : ()Ljava/lang/String;
    //   1316: invokespecial <init> : (Ljava/lang/String;)V
    //   1319: athrow
    //   1320: aload_1
    //   1321: monitorexit
    //   1322: return
    //   1323: astore #6
    //   1325: aload_1
    //   1326: monitorexit
    //   1327: aload #6
    //   1329: athrow
    //   1330: iconst_0
    //   1331: istore #5
    //   1333: goto -> 574
    // Exception table:
    //   from	to	target	type
    //   2	16	1323	finally
    //   23	25	1323	finally
    //   26	31	1323	finally
    //   31	85	1323	finally
    //   89	94	1323	finally
    //   94	133	1323	finally
    //   133	142	1323	finally
    //   142	158	1323	finally
    //   174	186	1323	finally
    //   192	206	1323	finally
    //   209	219	1323	finally
    //   229	238	1323	finally
    //   248	262	1323	finally
    //   262	319	1323	finally
    //   322	327	1323	finally
    //   327	340	1323	finally
    //   340	400	1323	finally
    //   408	413	1323	finally
    //   413	450	1323	finally
    //   465	470	1323	finally
    //   470	571	1323	finally
    //   574	671	1323	finally
    //   671	697	1323	finally
    //   697	768	1323	finally
    //   768	786	1323	finally
    //   786	802	1323	finally
    //   802	829	1323	finally
    //   832	852	1323	finally
    //   852	868	1323	finally
    //   872	911	1323	finally
    //   911	947	1323	finally
    //   947	1024	1323	finally
    //   1027	1044	1323	finally
    //   1044	1074	1323	finally
    //   1074	1158	1323	finally
    //   1158	1170	1323	finally
    //   1174	1185	1323	finally
    //   1188	1193	1323	finally
    //   1193	1233	1323	finally
    //   1237	1255	1323	finally
    //   1258	1269	1323	finally
    //   1269	1271	1323	finally
    //   1272	1320	1323	finally
    //   1320	1322	1323	finally
    //   1325	1327	1323	finally
  }
  
  public void a(PLAVFrame paramPLAVFrame, int paramInt) {
    if (this.b != null) {
      this.j.add(paramPLAVFrame);
      this.b.releaseOutputBuffer(paramInt, false);
    } 
  }
  
  public void b() {
    this.h = true;
  }
  
  public Object c() {
    return this.b;
  }
  
  public void d() {
    MediaCodec mediaCodec = this.b;
    if (mediaCodec != null)
      try {
        mediaCodec.start();
        this.f = true;
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public Surface e() {
    MediaCodec mediaCodec = this.b;
    if (mediaCodec != null)
      try {
        return mediaCodec.createInputSurface();
      } catch (IllegalStateException illegalStateException) {
        illegalStateException.printStackTrace();
      }  
    return null;
  }
  
  public void f() {
    PLBufferInfo pLBufferInfo = this.a;
    MediaCodec.BufferInfo bufferInfo = this.c;
    pLBufferInfo.flags = bufferInfo.flags;
    pLBufferInfo.offset = bufferInfo.offset;
    pLBufferInfo.size = bufferInfo.size;
    pLBufferInfo.presentationTimeUs = bufferInfo.presentationTimeUs;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\g\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */