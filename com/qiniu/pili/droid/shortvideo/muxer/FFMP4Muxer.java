package com.qiniu.pili.droid.shortvideo.muxer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import java.nio.ByteBuffer;

public class FFMP4Muxer extends c {
  private long f = 0L;
  
  private native int addAudioStream(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  private native int addAudioStream2(long paramLong1, long paramLong2);
  
  private native int addVideoStream(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  private native int addVideoStream2(long paramLong1, int paramInt1, int paramInt2, long paramLong2);
  
  private native int closeFile(long paramLong);
  
  private native long createFile(String paramString);
  
  private native int setESDSHeader(long paramLong, ByteBuffer paramByteBuffer, int paramInt);
  
  private native int setSPSPPSHeader(long paramLong, ByteBuffer paramByteBuffer, int paramInt);
  
  private native int start(long paramLong);
  
  private native int writeAudioFrame(long paramLong1, ByteBuffer paramByteBuffer, int paramInt1, long paramLong2, int paramInt2);
  
  private native int writeAudioFrame2(long paramLong1, ByteBuffer paramByteBuffer, int paramInt1, long paramLong2, int paramInt2, int paramInt3, int paramInt4);
  
  private native int writeVideoFrame(long paramLong1, ByteBuffer paramByteBuffer, int paramInt, boolean paramBoolean, long paramLong2, long paramLong3);
  
  private native int writeVideoFrame2(long paramLong1, ByteBuffer paramByteBuffer, int paramInt1, boolean paramBoolean, long paramLong2, long paramLong3, int paramInt2, int paramInt3);
  
  public void a(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, boolean paramBoolean, long paramLong1, long paramLong2, int paramInt3, int paramInt4, int paramInt5) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : J
    //   6: lconst_0
    //   7: lcmp
    //   8: ifeq -> 87
    //   11: aload_0
    //   12: getfield f : J
    //   15: ldc2_w -1
    //   18: lcmp
    //   19: ifne -> 25
    //   22: goto -> 87
    //   25: aload_0
    //   26: getfield b : I
    //   29: iload_1
    //   30: if_icmpne -> 57
    //   33: aload_0
    //   34: aload_0
    //   35: getfield f : J
    //   38: aload_2
    //   39: iload_3
    //   40: iload #4
    //   42: lload #5
    //   44: lload #7
    //   46: iload #10
    //   48: iload #11
    //   50: invokespecial writeVideoFrame2 : (JLjava/nio/ByteBuffer;IZJJII)I
    //   53: pop
    //   54: goto -> 84
    //   57: aload_0
    //   58: getfield c : I
    //   61: iload_1
    //   62: if_icmpne -> 84
    //   65: aload_0
    //   66: aload_0
    //   67: getfield f : J
    //   70: aload_2
    //   71: iload_3
    //   72: lload #5
    //   74: iload #9
    //   76: iload #10
    //   78: iload #11
    //   80: invokespecial writeAudioFrame2 : (JLjava/nio/ByteBuffer;IJIII)I
    //   83: pop
    //   84: aload_0
    //   85: monitorexit
    //   86: return
    //   87: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   90: ldc 'FFMP4Muxer'
    //   92: ldc 'write failed, mMediaMuxer == null or trackIndex < 0 !'
    //   94: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: astore_2
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_2
    //   104: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	100	finally
    //   25	54	100	finally
    //   57	84	100	finally
    //   87	97	100	finally
  }
  
  public void a(int paramInt, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : J
    //   6: lconst_0
    //   7: lcmp
    //   8: ifeq -> 107
    //   11: aload_0
    //   12: getfield f : J
    //   15: ldc2_w -1
    //   18: lcmp
    //   19: ifne -> 25
    //   22: goto -> 107
    //   25: aload_0
    //   26: getfield b : I
    //   29: iload_1
    //   30: if_icmpne -> 75
    //   33: aload_3
    //   34: getfield flags : I
    //   37: iconst_1
    //   38: iand
    //   39: ifeq -> 125
    //   42: iconst_1
    //   43: istore #4
    //   45: goto -> 48
    //   48: aload_0
    //   49: aload_0
    //   50: getfield f : J
    //   53: aload_2
    //   54: aload_3
    //   55: getfield size : I
    //   58: iload #4
    //   60: aload_3
    //   61: getfield presentationTimeUs : J
    //   64: aload_3
    //   65: getfield presentationTimeUs : J
    //   68: invokespecial writeVideoFrame : (JLjava/nio/ByteBuffer;IZJJ)I
    //   71: pop
    //   72: goto -> 104
    //   75: aload_0
    //   76: getfield c : I
    //   79: iload_1
    //   80: if_icmpne -> 104
    //   83: aload_0
    //   84: aload_0
    //   85: getfield f : J
    //   88: aload_2
    //   89: aload_3
    //   90: getfield size : I
    //   93: aload_3
    //   94: getfield presentationTimeUs : J
    //   97: sipush #1152
    //   100: invokespecial writeAudioFrame : (JLjava/nio/ByteBuffer;IJI)I
    //   103: pop
    //   104: aload_0
    //   105: monitorexit
    //   106: return
    //   107: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   110: ldc 'FFMP4Muxer'
    //   112: ldc 'write failed, mMediaMuxer == null or trackIndex < 0 !'
    //   114: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload_0
    //   118: monitorexit
    //   119: return
    //   120: astore_2
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_2
    //   124: athrow
    //   125: iconst_0
    //   126: istore #4
    //   128: goto -> 48
    // Exception table:
    //   from	to	target	type
    //   2	22	120	finally
    //   25	42	120	finally
    //   48	72	120	finally
    //   75	104	120	finally
    //   107	117	120	finally
  }
  
  public boolean a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: ldc 'FFMP4Muxer'
    //   7: ldc 'stop +'
    //   9: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield f : J
    //   16: lconst_0
    //   17: lcmp
    //   18: ifeq -> 58
    //   21: aload_0
    //   22: getfield f : J
    //   25: ldc2_w -1
    //   28: lcmp
    //   29: ifne -> 35
    //   32: goto -> 58
    //   35: aload_0
    //   36: aload_0
    //   37: getfield f : J
    //   40: invokespecial closeFile : (J)I
    //   43: pop
    //   44: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   47: ldc 'FFMP4Muxer'
    //   49: ldc 'stop -'
    //   51: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: monitorexit
    //   56: iconst_1
    //   57: ireturn
    //   58: aload_0
    //   59: monitorexit
    //   60: iconst_0
    //   61: ireturn
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    // Exception table:
    //   from	to	target	type
    //   2	32	62	finally
    //   35	54	62	finally
  }
  
  public boolean a(String paramString, MediaFormat paramMediaFormat1, MediaFormat paramMediaFormat2, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: ldc 'FFMP4Muxer'
    //   7: ldc 'start +'
    //   9: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   12: new java/io/File
    //   15: dup
    //   16: aload_1
    //   17: invokespecial <init> : (Ljava/lang/String;)V
    //   20: astore #12
    //   22: aload #12
    //   24: invokevirtual exists : ()Z
    //   27: ifeq -> 85
    //   30: aload #12
    //   32: invokevirtual isFile : ()Z
    //   35: ifeq -> 85
    //   38: aload #12
    //   40: invokevirtual delete : ()Z
    //   43: pop
    //   44: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   47: astore #12
    //   49: new java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial <init> : ()V
    //   56: astore #13
    //   58: aload #13
    //   60: ldc 'delete existed file: '
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload #13
    //   68: aload_1
    //   69: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload #12
    //   75: ldc 'FFMP4Muxer'
    //   77: aload #13
    //   79: invokevirtual toString : ()Ljava/lang/String;
    //   82: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_0
    //   86: aload_1
    //   87: putfield a : Ljava/lang/String;
    //   90: aload_0
    //   91: aload_0
    //   92: aload_0
    //   93: getfield a : Ljava/lang/String;
    //   96: invokespecial createFile : (Ljava/lang/String;)J
    //   99: putfield f : J
    //   102: aload_0
    //   103: getfield f : J
    //   106: ldc2_w -1
    //   109: lcmp
    //   110: ifne -> 137
    //   113: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   116: ldc 'FFMP4Muxer'
    //   118: ldc 'muxer create failed!'
    //   120: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   123: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   126: ldc 'FFMP4Muxer'
    //   128: ldc 'start -'
    //   130: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload_0
    //   134: monitorexit
    //   135: iconst_0
    //   136: ireturn
    //   137: aload_2
    //   138: ifnull -> 928
    //   141: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   144: astore_1
    //   145: new java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial <init> : ()V
    //   152: astore #12
    //   154: aload #12
    //   156: ldc 'video format : '
    //   158: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload #12
    //   164: aload_2
    //   165: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_1
    //   170: ldc 'FFMP4Muxer'
    //   172: aload #12
    //   174: invokevirtual toString : ()Ljava/lang/String;
    //   177: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   180: aload_2
    //   181: ldc 'width'
    //   183: invokevirtual getInteger : (Ljava/lang/String;)I
    //   186: istore #8
    //   188: aload_2
    //   189: ldc 'height'
    //   191: invokevirtual getInteger : (Ljava/lang/String;)I
    //   194: istore #9
    //   196: aload_2
    //   197: ldc 'bitrate'
    //   199: invokevirtual containsKey : (Ljava/lang/String;)Z
    //   202: ifeq -> 902
    //   205: aload_2
    //   206: ldc 'bitrate'
    //   208: invokevirtual getInteger : (Ljava/lang/String;)I
    //   211: istore #5
    //   213: goto -> 216
    //   216: aload_2
    //   217: ldc 'i-frame-interval'
    //   219: invokevirtual containsKey : (Ljava/lang/String;)Z
    //   222: ifeq -> 909
    //   225: aload_2
    //   226: ldc 'i-frame-interval'
    //   228: invokevirtual getInteger : (Ljava/lang/String;)I
    //   231: istore #6
    //   233: goto -> 236
    //   236: aload_2
    //   237: ldc 'frame-rate'
    //   239: invokevirtual containsKey : (Ljava/lang/String;)Z
    //   242: ifeq -> 915
    //   245: aload_2
    //   246: ldc 'frame-rate'
    //   248: invokevirtual getInteger : (Ljava/lang/String;)I
    //   251: istore #7
    //   253: goto -> 256
    //   256: aload_0
    //   257: aload_0
    //   258: aload_0
    //   259: getfield f : J
    //   262: iload #8
    //   264: iload #9
    //   266: iload #5
    //   268: iload #6
    //   270: iload #7
    //   272: imul
    //   273: iload #7
    //   275: iconst_0
    //   276: iload #4
    //   278: invokespecial addVideoStream : (JIIIIIII)I
    //   281: putfield b : I
    //   284: aload_0
    //   285: getfield b : I
    //   288: ifge -> 922
    //   291: iconst_0
    //   292: istore #10
    //   294: goto -> 297
    //   297: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   300: astore_1
    //   301: new java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial <init> : ()V
    //   308: astore #12
    //   310: aload #12
    //   312: ldc 'addTrack video track: '
    //   314: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload #12
    //   320: aload_0
    //   321: getfield b : I
    //   324: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload_1
    //   329: ldc 'FFMP4Muxer'
    //   331: aload #12
    //   333: invokevirtual toString : ()Ljava/lang/String;
    //   336: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   339: goto -> 342
    //   342: iload #10
    //   344: istore #11
    //   346: aload_3
    //   347: ifnull -> 551
    //   350: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   353: astore_1
    //   354: new java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial <init> : ()V
    //   361: astore #12
    //   363: aload #12
    //   365: ldc 'audio format : '
    //   367: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload #12
    //   373: aload_3
    //   374: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload_1
    //   379: ldc 'FFMP4Muxer'
    //   381: aload #12
    //   383: invokevirtual toString : ()Ljava/lang/String;
    //   386: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   389: aload_3
    //   390: ldc 'sample-rate'
    //   392: invokevirtual containsKey : (Ljava/lang/String;)Z
    //   395: ifeq -> 934
    //   398: aload_3
    //   399: ldc 'sample-rate'
    //   401: invokevirtual getInteger : (Ljava/lang/String;)I
    //   404: istore #4
    //   406: goto -> 409
    //   409: aload_3
    //   410: ldc 'channel-count'
    //   412: invokevirtual containsKey : (Ljava/lang/String;)Z
    //   415: ifeq -> 941
    //   418: aload_3
    //   419: ldc 'channel-count'
    //   421: invokevirtual getInteger : (Ljava/lang/String;)I
    //   424: istore #5
    //   426: goto -> 429
    //   429: aload_3
    //   430: ldc 'bit-width'
    //   432: invokevirtual containsKey : (Ljava/lang/String;)Z
    //   435: ifeq -> 947
    //   438: aload_3
    //   439: ldc 'bit-width'
    //   441: invokevirtual getInteger : (Ljava/lang/String;)I
    //   444: istore #6
    //   446: goto -> 449
    //   449: aload_3
    //   450: ldc 'bitrate'
    //   452: invokevirtual containsKey : (Ljava/lang/String;)Z
    //   455: ifeq -> 954
    //   458: aload_3
    //   459: ldc 'bitrate'
    //   461: invokevirtual getInteger : (Ljava/lang/String;)I
    //   464: istore #7
    //   466: iload #7
    //   468: ifle -> 954
    //   471: goto -> 474
    //   474: aload_0
    //   475: aload_0
    //   476: aload_0
    //   477: getfield f : J
    //   480: iload #4
    //   482: iload #5
    //   484: iload #6
    //   486: iload #7
    //   488: iconst_0
    //   489: invokespecial addAudioStream : (JIIIII)I
    //   492: putfield c : I
    //   495: aload_0
    //   496: getfield c : I
    //   499: ifge -> 505
    //   502: iconst_0
    //   503: istore #10
    //   505: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   508: astore_1
    //   509: new java/lang/StringBuilder
    //   512: dup
    //   513: invokespecial <init> : ()V
    //   516: astore #12
    //   518: aload #12
    //   520: ldc 'addTrack audio track: '
    //   522: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: aload #12
    //   528: aload_0
    //   529: getfield c : I
    //   532: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   535: pop
    //   536: aload_1
    //   537: ldc 'FFMP4Muxer'
    //   539: aload #12
    //   541: invokevirtual toString : ()Ljava/lang/String;
    //   544: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   547: iload #10
    //   549: istore #11
    //   551: iload #11
    //   553: ifeq -> 839
    //   556: aload_0
    //   557: aload_0
    //   558: getfield f : J
    //   561: invokespecial start : (J)I
    //   564: pop
    //   565: aload_2
    //   566: ifnull -> 755
    //   569: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   572: astore_1
    //   573: new java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial <init> : ()V
    //   580: astore #12
    //   582: aload #12
    //   584: ldc 'write video csd from format: '
    //   586: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: aload #12
    //   592: aload_2
    //   593: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   596: pop
    //   597: aload_1
    //   598: ldc 'FFMP4Muxer'
    //   600: aload #12
    //   602: invokevirtual toString : ()Ljava/lang/String;
    //   605: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   608: aload_2
    //   609: ldc 'csd-0'
    //   611: invokevirtual getByteBuffer : (Ljava/lang/String;)Ljava/nio/ByteBuffer;
    //   614: astore_1
    //   615: aload_2
    //   616: ldc 'csd-1'
    //   618: invokevirtual getByteBuffer : (Ljava/lang/String;)Ljava/nio/ByteBuffer;
    //   621: astore_2
    //   622: aload_1
    //   623: ifnull -> 696
    //   626: aload_2
    //   627: ifnonnull -> 633
    //   630: goto -> 696
    //   633: aload_1
    //   634: invokevirtual remaining : ()I
    //   637: aload_2
    //   638: invokevirtual remaining : ()I
    //   641: iadd
    //   642: invokestatic allocateDirect : (I)Ljava/nio/ByteBuffer;
    //   645: astore #12
    //   647: aload #12
    //   649: aload_1
    //   650: invokevirtual put : (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   653: pop
    //   654: aload #12
    //   656: aload_2
    //   657: invokevirtual put : (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   660: pop
    //   661: aload_1
    //   662: invokevirtual clear : ()Ljava/nio/Buffer;
    //   665: pop
    //   666: aload_2
    //   667: invokevirtual clear : ()Ljava/nio/Buffer;
    //   670: pop
    //   671: aload #12
    //   673: invokevirtual clear : ()Ljava/nio/Buffer;
    //   676: pop
    //   677: aload_0
    //   678: aload_0
    //   679: getfield f : J
    //   682: aload #12
    //   684: aload #12
    //   686: invokevirtual capacity : ()I
    //   689: invokespecial setSPSPPSHeader : (JLjava/nio/ByteBuffer;I)I
    //   692: pop
    //   693: goto -> 755
    //   696: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   699: astore_2
    //   700: new java/lang/StringBuilder
    //   703: dup
    //   704: invokespecial <init> : ()V
    //   707: astore_3
    //   708: aload_3
    //   709: ldc 'video format error : no '
    //   711: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: pop
    //   715: aload_1
    //   716: ifnonnull -> 961
    //   719: ldc 'csd-0'
    //   721: astore_1
    //   722: goto -> 725
    //   725: aload_3
    //   726: aload_1
    //   727: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: pop
    //   731: aload_2
    //   732: ldc 'FFMP4Muxer'
    //   734: aload_3
    //   735: invokevirtual toString : ()Ljava/lang/String;
    //   738: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   741: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   744: ldc 'FFMP4Muxer'
    //   746: ldc 'start -'
    //   748: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   751: aload_0
    //   752: monitorexit
    //   753: iconst_0
    //   754: ireturn
    //   755: aload_3
    //   756: ifnull -> 839
    //   759: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   762: astore_1
    //   763: new java/lang/StringBuilder
    //   766: dup
    //   767: invokespecial <init> : ()V
    //   770: astore_2
    //   771: aload_2
    //   772: ldc 'write audio csd from format: '
    //   774: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: pop
    //   778: aload_2
    //   779: aload_3
    //   780: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   783: pop
    //   784: aload_1
    //   785: ldc 'FFMP4Muxer'
    //   787: aload_2
    //   788: invokevirtual toString : ()Ljava/lang/String;
    //   791: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   794: aload_3
    //   795: ldc 'csd-0'
    //   797: invokevirtual getByteBuffer : (Ljava/lang/String;)Ljava/nio/ByteBuffer;
    //   800: astore_1
    //   801: aload_1
    //   802: invokevirtual remaining : ()I
    //   805: invokestatic allocateDirect : (I)Ljava/nio/ByteBuffer;
    //   808: astore_2
    //   809: aload_2
    //   810: aload_1
    //   811: invokevirtual put : (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   814: pop
    //   815: aload_1
    //   816: invokevirtual clear : ()Ljava/nio/Buffer;
    //   819: pop
    //   820: aload_2
    //   821: invokevirtual clear : ()Ljava/nio/Buffer;
    //   824: pop
    //   825: aload_0
    //   826: aload_0
    //   827: getfield f : J
    //   830: aload_2
    //   831: aload_2
    //   832: invokevirtual capacity : ()I
    //   835: invokespecial setESDSHeader : (JLjava/nio/ByteBuffer;I)I
    //   838: pop
    //   839: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   842: ldc 'FFMP4Muxer'
    //   844: ldc 'start -'
    //   846: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   849: aload_0
    //   850: monitorexit
    //   851: iload #11
    //   853: ireturn
    //   854: astore_1
    //   855: goto -> 885
    //   858: astore_1
    //   859: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   862: ldc 'FFMP4Muxer'
    //   864: aload_1
    //   865: invokevirtual getMessage : ()Ljava/lang/String;
    //   868: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   871: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   874: ldc 'FFMP4Muxer'
    //   876: ldc 'start -'
    //   878: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   881: aload_0
    //   882: monitorexit
    //   883: iconst_0
    //   884: ireturn
    //   885: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   888: ldc 'FFMP4Muxer'
    //   890: ldc 'start -'
    //   892: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   895: aload_1
    //   896: athrow
    //   897: astore_1
    //   898: aload_0
    //   899: monitorexit
    //   900: aload_1
    //   901: athrow
    //   902: ldc 1024000
    //   904: istore #5
    //   906: goto -> 216
    //   909: iconst_1
    //   910: istore #6
    //   912: goto -> 236
    //   915: bipush #30
    //   917: istore #7
    //   919: goto -> 256
    //   922: iconst_1
    //   923: istore #10
    //   925: goto -> 297
    //   928: iconst_1
    //   929: istore #10
    //   931: goto -> 342
    //   934: ldc 44100
    //   936: istore #4
    //   938: goto -> 409
    //   941: iconst_1
    //   942: istore #5
    //   944: goto -> 429
    //   947: bipush #16
    //   949: istore #6
    //   951: goto -> 449
    //   954: ldc 64000
    //   956: istore #7
    //   958: goto -> 474
    //   961: ldc 'csd-1'
    //   963: astore_1
    //   964: goto -> 725
    // Exception table:
    //   from	to	target	type
    //   2	85	897	finally
    //   85	123	858	java/lang/Exception
    //   85	123	854	finally
    //   123	133	897	finally
    //   141	213	858	java/lang/Exception
    //   141	213	854	finally
    //   216	233	858	java/lang/Exception
    //   216	233	854	finally
    //   236	253	858	java/lang/Exception
    //   236	253	854	finally
    //   256	291	858	java/lang/Exception
    //   256	291	854	finally
    //   297	339	858	java/lang/Exception
    //   297	339	854	finally
    //   350	406	858	java/lang/Exception
    //   350	406	854	finally
    //   409	426	858	java/lang/Exception
    //   409	426	854	finally
    //   429	446	858	java/lang/Exception
    //   429	446	854	finally
    //   449	466	858	java/lang/Exception
    //   449	466	854	finally
    //   474	495	858	java/lang/Exception
    //   474	495	854	finally
    //   495	502	858	java/lang/Exception
    //   495	502	854	finally
    //   505	547	858	java/lang/Exception
    //   505	547	854	finally
    //   556	565	858	java/lang/Exception
    //   556	565	854	finally
    //   569	622	858	java/lang/Exception
    //   569	622	854	finally
    //   633	693	858	java/lang/Exception
    //   633	693	854	finally
    //   696	715	858	java/lang/Exception
    //   696	715	854	finally
    //   725	741	858	java/lang/Exception
    //   725	741	854	finally
    //   741	751	897	finally
    //   759	839	858	java/lang/Exception
    //   759	839	854	finally
    //   839	849	897	finally
    //   859	871	854	finally
    //   871	881	897	finally
    //   885	897	897	finally
  }
  
  public boolean a(String paramString, FFMP4Demuxer paramFFMP4Demuxer) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: ldc 'FFMP4Muxer'
    //   7: ldc 'start +'
    //   9: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   12: new java/io/File
    //   15: dup
    //   16: aload_1
    //   17: invokespecial <init> : (Ljava/lang/String;)V
    //   20: astore #10
    //   22: aload #10
    //   24: invokevirtual exists : ()Z
    //   27: ifeq -> 85
    //   30: aload #10
    //   32: invokevirtual isFile : ()Z
    //   35: ifeq -> 85
    //   38: aload #10
    //   40: invokevirtual delete : ()Z
    //   43: pop
    //   44: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   47: astore #10
    //   49: new java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial <init> : ()V
    //   56: astore #11
    //   58: aload #11
    //   60: ldc 'delete existed file: '
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload #11
    //   68: aload_1
    //   69: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload #10
    //   75: ldc 'FFMP4Muxer'
    //   77: aload #11
    //   79: invokevirtual toString : ()Ljava/lang/String;
    //   82: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_2
    //   86: ifnonnull -> 113
    //   89: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   92: ldc 'FFMP4Muxer'
    //   94: ldc 'muxer create failed, demuxer is null'
    //   96: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   99: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   102: ldc 'FFMP4Muxer'
    //   104: ldc 'start -'
    //   106: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload_0
    //   110: monitorexit
    //   111: iconst_0
    //   112: ireturn
    //   113: aload_0
    //   114: aload_0
    //   115: aload_1
    //   116: invokespecial createFile : (Ljava/lang/String;)J
    //   119: putfield f : J
    //   122: aload_0
    //   123: getfield f : J
    //   126: ldc2_w -1
    //   129: lcmp
    //   130: ifne -> 157
    //   133: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   136: ldc 'FFMP4Muxer'
    //   138: ldc 'muxer create failed!'
    //   140: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   143: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   146: ldc 'FFMP4Muxer'
    //   148: ldc 'start -'
    //   150: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload_0
    //   154: monitorexit
    //   155: iconst_0
    //   156: ireturn
    //   157: iconst_1
    //   158: istore #6
    //   160: aload_0
    //   161: aload_2
    //   162: invokevirtual a : ()I
    //   165: putfield b : I
    //   168: aload_0
    //   169: aload_2
    //   170: invokevirtual b : ()I
    //   173: putfield c : I
    //   176: aload_0
    //   177: getfield b : I
    //   180: istore_3
    //   181: iconst_m1
    //   182: istore #4
    //   184: iload_3
    //   185: iflt -> 438
    //   188: aload_2
    //   189: invokevirtual c : ()I
    //   192: istore_3
    //   193: aload_2
    //   194: invokevirtual d : ()I
    //   197: istore #5
    //   199: aload_2
    //   200: invokevirtual j : ()J
    //   203: lstore #8
    //   205: aload_0
    //   206: aload_0
    //   207: getfield f : J
    //   210: iload_3
    //   211: iload #5
    //   213: lload #8
    //   215: invokespecial addVideoStream2 : (JIIJ)I
    //   218: istore #5
    //   220: iload #5
    //   222: istore_3
    //   223: iload #5
    //   225: ifge -> 237
    //   228: iconst_0
    //   229: istore #6
    //   231: iload #5
    //   233: istore_3
    //   234: goto -> 237
    //   237: iload #6
    //   239: istore #7
    //   241: aload_0
    //   242: getfield c : I
    //   245: iflt -> 286
    //   248: aload_2
    //   249: invokevirtual k : ()J
    //   252: lstore #8
    //   254: aload_0
    //   255: aload_0
    //   256: getfield f : J
    //   259: lload #8
    //   261: invokespecial addAudioStream2 : (JJ)I
    //   264: istore #5
    //   266: iload #5
    //   268: istore #4
    //   270: iload #6
    //   272: istore #7
    //   274: iload #5
    //   276: ifge -> 286
    //   279: iconst_0
    //   280: istore #7
    //   282: iload #5
    //   284: istore #4
    //   286: iload #7
    //   288: ifeq -> 375
    //   291: aload_0
    //   292: aload_0
    //   293: getfield f : J
    //   296: invokespecial start : (J)I
    //   299: pop
    //   300: iload_3
    //   301: iflt -> 337
    //   304: sipush #1024
    //   307: invokestatic allocateDirect : (I)Ljava/nio/ByteBuffer;
    //   310: astore_1
    //   311: aload_2
    //   312: aload_1
    //   313: aload_1
    //   314: invokevirtual capacity : ()I
    //   317: invokevirtual a : (Ljava/nio/ByteBuffer;I)I
    //   320: istore_3
    //   321: aload_1
    //   322: invokevirtual clear : ()Ljava/nio/Buffer;
    //   325: pop
    //   326: aload_0
    //   327: aload_0
    //   328: getfield f : J
    //   331: aload_1
    //   332: iload_3
    //   333: invokespecial setSPSPPSHeader : (JLjava/nio/ByteBuffer;I)I
    //   336: pop
    //   337: iload #4
    //   339: iflt -> 375
    //   342: sipush #1024
    //   345: invokestatic allocateDirect : (I)Ljava/nio/ByteBuffer;
    //   348: astore_1
    //   349: aload_2
    //   350: aload_1
    //   351: aload_1
    //   352: invokevirtual capacity : ()I
    //   355: invokevirtual b : (Ljava/nio/ByteBuffer;I)I
    //   358: istore_3
    //   359: aload_1
    //   360: invokevirtual clear : ()Ljava/nio/Buffer;
    //   363: pop
    //   364: aload_0
    //   365: aload_0
    //   366: getfield f : J
    //   369: aload_1
    //   370: iload_3
    //   371: invokespecial setESDSHeader : (JLjava/nio/ByteBuffer;I)I
    //   374: pop
    //   375: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   378: ldc 'FFMP4Muxer'
    //   380: ldc 'start -'
    //   382: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   385: aload_0
    //   386: monitorexit
    //   387: iload #7
    //   389: ireturn
    //   390: astore_1
    //   391: goto -> 421
    //   394: astore_1
    //   395: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   398: ldc 'FFMP4Muxer'
    //   400: aload_1
    //   401: invokevirtual getMessage : ()Ljava/lang/String;
    //   404: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   407: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   410: ldc 'FFMP4Muxer'
    //   412: ldc 'start -'
    //   414: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   417: aload_0
    //   418: monitorexit
    //   419: iconst_0
    //   420: ireturn
    //   421: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   424: ldc 'FFMP4Muxer'
    //   426: ldc 'start -'
    //   428: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   431: aload_1
    //   432: athrow
    //   433: astore_1
    //   434: aload_0
    //   435: monitorexit
    //   436: aload_1
    //   437: athrow
    //   438: iconst_m1
    //   439: istore_3
    //   440: goto -> 237
    // Exception table:
    //   from	to	target	type
    //   2	85	433	finally
    //   89	99	394	java/lang/Exception
    //   89	99	390	finally
    //   99	109	433	finally
    //   113	143	394	java/lang/Exception
    //   113	143	390	finally
    //   143	153	433	finally
    //   160	181	394	java/lang/Exception
    //   160	181	390	finally
    //   188	220	394	java/lang/Exception
    //   188	220	390	finally
    //   241	266	394	java/lang/Exception
    //   241	266	390	finally
    //   291	300	394	java/lang/Exception
    //   291	300	390	finally
    //   304	337	394	java/lang/Exception
    //   304	337	390	finally
    //   342	375	394	java/lang/Exception
    //   342	375	390	finally
    //   375	385	433	finally
    //   395	407	390	finally
    //   407	417	433	finally
    //   421	433	433	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\muxer\FFMP4Muxer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */