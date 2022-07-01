package com.qiniu.pili.droid.shortvideo.muxer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.nio.ByteBuffer;

public class a extends c {
  private MediaMuxer f;
  
  public void a(int paramInt, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Landroid/media/MediaMuxer;
    //   6: ifnull -> 257
    //   9: iload_1
    //   10: ifge -> 16
    //   13: goto -> 257
    //   16: aload_0
    //   17: getfield b : I
    //   20: iload_1
    //   21: if_icmpne -> 107
    //   24: aload_3
    //   25: getfield presentationTimeUs : J
    //   28: aload_0
    //   29: getfield d : J
    //   32: lcmp
    //   33: ifgt -> 99
    //   36: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   39: astore_2
    //   40: new java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial <init> : ()V
    //   47: astore #4
    //   49: aload #4
    //   51: ldc 'ignored, video timestamp fall back, this: '
    //   53: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload #4
    //   59: aload_3
    //   60: getfield presentationTimeUs : J
    //   63: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload #4
    //   69: ldc ' last: '
    //   71: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload #4
    //   77: aload_0
    //   78: getfield d : J
    //   81: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_2
    //   86: ldc 'DroidMP4Muxer'
    //   88: aload #4
    //   90: invokevirtual toString : ()Ljava/lang/String;
    //   93: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_0
    //   97: monitorexit
    //   98: return
    //   99: aload_0
    //   100: aload_3
    //   101: getfield presentationTimeUs : J
    //   104: putfield d : J
    //   107: aload_0
    //   108: getfield c : I
    //   111: iload_1
    //   112: if_icmpne -> 198
    //   115: aload_3
    //   116: getfield presentationTimeUs : J
    //   119: aload_0
    //   120: getfield e : J
    //   123: lcmp
    //   124: ifgt -> 190
    //   127: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   130: astore_2
    //   131: new java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial <init> : ()V
    //   138: astore #4
    //   140: aload #4
    //   142: ldc 'ignored, audio timestamp fall back, this: '
    //   144: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload #4
    //   150: aload_3
    //   151: getfield presentationTimeUs : J
    //   154: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload #4
    //   160: ldc ' last: '
    //   162: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload #4
    //   168: aload_0
    //   169: getfield e : J
    //   172: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload_2
    //   177: ldc 'DroidMP4Muxer'
    //   179: aload #4
    //   181: invokevirtual toString : ()Ljava/lang/String;
    //   184: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload_0
    //   188: monitorexit
    //   189: return
    //   190: aload_0
    //   191: aload_3
    //   192: getfield presentationTimeUs : J
    //   195: putfield e : J
    //   198: aload_0
    //   199: getfield f : Landroid/media/MediaMuxer;
    //   202: iload_1
    //   203: aload_2
    //   204: aload_3
    //   205: invokevirtual writeSampleData : (ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   208: goto -> 254
    //   211: astore_2
    //   212: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   215: astore_3
    //   216: new java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial <init> : ()V
    //   223: astore #4
    //   225: aload #4
    //   227: ldc 'mux write data failed: '
    //   229: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload #4
    //   235: aload_2
    //   236: invokevirtual getMessage : ()Ljava/lang/String;
    //   239: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload_3
    //   244: ldc 'DroidMP4Muxer'
    //   246: aload #4
    //   248: invokevirtual toString : ()Ljava/lang/String;
    //   251: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   254: aload_0
    //   255: monitorexit
    //   256: return
    //   257: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   260: ldc 'DroidMP4Muxer'
    //   262: ldc 'write failed, mMediaMuxer == null or trackIndex < 0 !'
    //   264: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   267: aload_0
    //   268: monitorexit
    //   269: return
    //   270: astore_2
    //   271: aload_0
    //   272: monitorexit
    //   273: aload_2
    //   274: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	270	finally
    //   16	96	270	finally
    //   99	107	270	finally
    //   107	187	270	finally
    //   190	198	270	finally
    //   198	208	211	java/lang/Exception
    //   198	208	270	finally
    //   212	254	270	finally
    //   257	267	270	finally
  }
  
  public boolean a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: ldc 'DroidMP4Muxer'
    //   7: ldc 'stop +'
    //   9: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield f : Landroid/media/MediaMuxer;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnonnull -> 25
    //   21: aload_0
    //   22: monitorexit
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_0
    //   26: getfield f : Landroid/media/MediaMuxer;
    //   29: invokevirtual stop : ()V
    //   32: aload_0
    //   33: getfield f : Landroid/media/MediaMuxer;
    //   36: invokevirtual release : ()V
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield f : Landroid/media/MediaMuxer;
    //   44: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   47: ldc 'DroidMP4Muxer'
    //   49: ldc 'stop -'
    //   51: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: monitorexit
    //   56: iconst_1
    //   57: ireturn
    //   58: astore_1
    //   59: goto -> 109
    //   62: astore_1
    //   63: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   66: ldc 'DroidMP4Muxer'
    //   68: aload_1
    //   69: invokevirtual getMessage : ()Ljava/lang/String;
    //   72: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   75: new java/io/File
    //   78: dup
    //   79: aload_0
    //   80: getfield a : Ljava/lang/String;
    //   83: invokespecial <init> : (Ljava/lang/String;)V
    //   86: invokevirtual delete : ()Z
    //   89: pop
    //   90: aload_0
    //   91: aconst_null
    //   92: putfield f : Landroid/media/MediaMuxer;
    //   95: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   98: ldc 'DroidMP4Muxer'
    //   100: ldc 'stop -'
    //   102: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_0
    //   106: monitorexit
    //   107: iconst_0
    //   108: ireturn
    //   109: aload_0
    //   110: aconst_null
    //   111: putfield f : Landroid/media/MediaMuxer;
    //   114: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   117: ldc 'DroidMP4Muxer'
    //   119: ldc 'stop -'
    //   121: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_1
    //   125: athrow
    //   126: astore_1
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_1
    //   130: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	126	finally
    //   25	39	62	java/lang/IllegalStateException
    //   25	39	58	finally
    //   39	54	126	finally
    //   63	90	58	finally
    //   90	105	126	finally
    //   109	126	126	finally
  }
  
  public boolean a(String paramString, MediaFormat paramMediaFormat1, MediaFormat paramMediaFormat2, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: ldc 'DroidMP4Muxer'
    //   7: ldc 'start +'
    //   9: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   12: new java/io/File
    //   15: dup
    //   16: aload_1
    //   17: invokespecial <init> : (Ljava/lang/String;)V
    //   20: astore #5
    //   22: aload #5
    //   24: invokevirtual exists : ()Z
    //   27: ifeq -> 85
    //   30: aload #5
    //   32: invokevirtual isFile : ()Z
    //   35: ifeq -> 85
    //   38: aload #5
    //   40: invokevirtual delete : ()Z
    //   43: pop
    //   44: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   47: astore #5
    //   49: new java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial <init> : ()V
    //   56: astore #6
    //   58: aload #6
    //   60: ldc 'delete existed file: '
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload #6
    //   68: aload_1
    //   69: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload #5
    //   75: ldc 'DroidMP4Muxer'
    //   77: aload #6
    //   79: invokevirtual toString : ()Ljava/lang/String;
    //   82: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_0
    //   86: aload_1
    //   87: putfield a : Ljava/lang/String;
    //   90: aload_0
    //   91: new android/media/MediaMuxer
    //   94: dup
    //   95: aload_0
    //   96: getfield a : Ljava/lang/String;
    //   99: iconst_0
    //   100: invokespecial <init> : (Ljava/lang/String;I)V
    //   103: putfield f : Landroid/media/MediaMuxer;
    //   106: aload_2
    //   107: ifnull -> 160
    //   110: aload_0
    //   111: aload_0
    //   112: getfield f : Landroid/media/MediaMuxer;
    //   115: aload_2
    //   116: invokevirtual addTrack : (Landroid/media/MediaFormat;)I
    //   119: putfield b : I
    //   122: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   125: astore_1
    //   126: new java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial <init> : ()V
    //   133: astore_2
    //   134: aload_2
    //   135: ldc 'addTrack video track: '
    //   137: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_2
    //   142: aload_0
    //   143: getfield b : I
    //   146: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_1
    //   151: ldc 'DroidMP4Muxer'
    //   153: aload_2
    //   154: invokevirtual toString : ()Ljava/lang/String;
    //   157: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   160: aload_3
    //   161: ifnull -> 214
    //   164: aload_0
    //   165: aload_0
    //   166: getfield f : Landroid/media/MediaMuxer;
    //   169: aload_3
    //   170: invokevirtual addTrack : (Landroid/media/MediaFormat;)I
    //   173: putfield c : I
    //   176: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   179: astore_1
    //   180: new java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial <init> : ()V
    //   187: astore_2
    //   188: aload_2
    //   189: ldc 'addTrack audio track: '
    //   191: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_2
    //   196: aload_0
    //   197: getfield c : I
    //   200: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_1
    //   205: ldc 'DroidMP4Muxer'
    //   207: aload_2
    //   208: invokevirtual toString : ()Ljava/lang/String;
    //   211: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   214: aload_0
    //   215: getfield f : Landroid/media/MediaMuxer;
    //   218: iload #4
    //   220: invokevirtual setOrientationHint : (I)V
    //   223: aload_0
    //   224: getfield f : Landroid/media/MediaMuxer;
    //   227: invokevirtual start : ()V
    //   230: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   233: ldc 'DroidMP4Muxer'
    //   235: ldc 'start -'
    //   237: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   240: aload_0
    //   241: monitorexit
    //   242: iconst_1
    //   243: ireturn
    //   244: astore_1
    //   245: goto -> 275
    //   248: astore_1
    //   249: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   252: ldc 'DroidMP4Muxer'
    //   254: aload_1
    //   255: invokevirtual getMessage : ()Ljava/lang/String;
    //   258: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   261: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   264: ldc 'DroidMP4Muxer'
    //   266: ldc 'start -'
    //   268: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   271: aload_0
    //   272: monitorexit
    //   273: iconst_0
    //   274: ireturn
    //   275: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   278: ldc 'DroidMP4Muxer'
    //   280: ldc 'start -'
    //   282: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   285: aload_1
    //   286: athrow
    //   287: astore_1
    //   288: aload_0
    //   289: monitorexit
    //   290: aload_1
    //   291: athrow
    // Exception table:
    //   from	to	target	type
    //   2	85	287	finally
    //   85	106	248	java/lang/Exception
    //   85	106	244	finally
    //   110	160	248	java/lang/Exception
    //   110	160	244	finally
    //   164	214	248	java/lang/Exception
    //   164	214	244	finally
    //   214	230	248	java/lang/Exception
    //   214	230	244	finally
    //   230	240	287	finally
    //   249	261	244	finally
    //   261	271	287	finally
    //   275	287	287	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\muxer\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */