package com.blued.android.module.external_sense_library.encoder;

import android.media.MediaCodec;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public abstract class MediaEncoder implements Runnable {
  protected final Object a;
  
  protected volatile boolean b;
  
  protected volatile boolean c;
  
  protected boolean d;
  
  protected boolean e;
  
  protected int f;
  
  protected MediaCodec g;
  
  protected final WeakReference<MediaMuxerWrapper> h;
  
  protected final MediaEncoderListener i;
  
  private int j;
  
  private MediaCodec.BufferInfo k;
  
  private long l;
  
  protected void a() {
    try {
      this.i.a(this);
    } catch (Exception exception) {
      Log.e("MediaEncoder", "failed onStopped", exception);
    } 
    this.b = false;
    MediaCodec mediaCodec = this.g;
    if (mediaCodec != null)
      try {
        mediaCodec.stop();
        this.g.release();
        this.g = null;
      } catch (Exception exception) {
        Log.e("MediaEncoder", "failed releasing MediaCodec", exception);
      }  
    if (this.e) {
      WeakReference<MediaMuxerWrapper> weakReference = this.h;
      if (weakReference != null) {
        MediaMuxerWrapper mediaMuxerWrapper = weakReference.get();
      } else {
        weakReference = null;
      } 
      if (weakReference != null)
        try {
          weakReference.c();
        } catch (Exception exception) {
          Log.e("MediaEncoder", "failed stopping muxer", exception);
        }  
    } 
    this.k = null;
  }
  
  protected void a(ByteBuffer paramByteBuffer, int paramInt, long paramLong) {
    if (!this.b)
      return; 
    ByteBuffer[] arrayOfByteBuffer = this.g.getInputBuffers();
    while (this.b) {
      int i = this.g.dequeueInputBuffer(10000L);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("inputBufferIndex: ");
      stringBuilder.append(i);
      Log.e("MediaEncoder", stringBuilder.toString());
      if (i >= 0) {
        ByteBuffer byteBuffer = arrayOfByteBuffer[i];
        byteBuffer.clear();
        if (paramByteBuffer != null)
          byteBuffer.put(paramByteBuffer); 
        if (paramInt <= 0) {
          this.d = true;
          this.g.queueInputBuffer(i, 0, 0, paramLong, 4);
          return;
        } 
        this.g.queueInputBuffer(i, 0, paramInt, paramLong, 0);
        break;
      } 
    } 
  }
  
  public boolean c() {
    synchronized (this.a) {
      if (!this.b || this.c)
        return false; 
      this.j++;
      this.a.notifyAll();
      return true;
    } 
  }
  
  protected void d() {
    a(null, 0, f());
  }
  
  protected void e() {
    // Byte code:
    //   0: aload_0
    //   1: getfield g : Landroid/media/MediaCodec;
    //   4: astore #4
    //   6: aload #4
    //   8: ifnonnull -> 12
    //   11: return
    //   12: aload #4
    //   14: invokevirtual getOutputBuffers : ()[Ljava/nio/ByteBuffer;
    //   17: astore #4
    //   19: new java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial <init> : ()V
    //   26: astore #5
    //   28: aload #5
    //   30: ldc 'encoderOutputBuffers: '
    //   32: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload #5
    //   38: aload #4
    //   40: arraylength
    //   41: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: ldc 'MediaEncoder'
    //   47: aload #5
    //   49: invokevirtual toString : ()Ljava/lang/String;
    //   52: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   55: pop
    //   56: aload_0
    //   57: getfield h : Ljava/lang/ref/WeakReference;
    //   60: invokevirtual get : ()Ljava/lang/Object;
    //   63: checkcast com/blued/android/module/external_sense_library/encoder/MediaMuxerWrapper
    //   66: astore #5
    //   68: aload #5
    //   70: ifnonnull -> 82
    //   73: ldc 'MediaEncoder'
    //   75: ldc 'muxer is unexpectedly null'
    //   77: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   80: pop
    //   81: return
    //   82: new java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial <init> : ()V
    //   89: astore #6
    //   91: aload #6
    //   93: ldc 'mIsCapturing: '
    //   95: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload #6
    //   101: aload_0
    //   102: getfield b : Z
    //   105: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: ldc 'MediaEncoder'
    //   111: aload #6
    //   113: invokevirtual toString : ()Ljava/lang/String;
    //   116: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   119: pop
    //   120: iconst_0
    //   121: istore_1
    //   122: aload_0
    //   123: getfield b : Z
    //   126: ifeq -> 494
    //   129: aload_0
    //   130: getfield g : Landroid/media/MediaCodec;
    //   133: aload_0
    //   134: getfield k : Landroid/media/MediaCodec$BufferInfo;
    //   137: ldc2_w 10000
    //   140: invokevirtual dequeueOutputBuffer : (Landroid/media/MediaCodec$BufferInfo;J)I
    //   143: istore_2
    //   144: new java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial <init> : ()V
    //   151: astore #6
    //   153: aload #6
    //   155: ldc 'encoderStatus: '
    //   157: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload #6
    //   163: iload_2
    //   164: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: ldc 'MediaEncoder'
    //   170: aload #6
    //   172: invokevirtual toString : ()Ljava/lang/String;
    //   175: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   178: pop
    //   179: iload_2
    //   180: iconst_m1
    //   181: if_icmpne -> 203
    //   184: aload_0
    //   185: getfield d : Z
    //   188: ifne -> 122
    //   191: iload_1
    //   192: iconst_1
    //   193: iadd
    //   194: istore_2
    //   195: iload_2
    //   196: istore_1
    //   197: iload_2
    //   198: iconst_5
    //   199: if_icmple -> 122
    //   202: return
    //   203: iload_2
    //   204: bipush #-3
    //   206: if_icmpne -> 221
    //   209: aload_0
    //   210: getfield g : Landroid/media/MediaCodec;
    //   213: invokevirtual getOutputBuffers : ()[Ljava/nio/ByteBuffer;
    //   216: astore #4
    //   218: goto -> 122
    //   221: iload_2
    //   222: bipush #-2
    //   224: if_icmpne -> 315
    //   227: aload_0
    //   228: getfield e : Z
    //   231: ifne -> 305
    //   234: aload_0
    //   235: aload #5
    //   237: aload_0
    //   238: getfield g : Landroid/media/MediaCodec;
    //   241: invokevirtual getOutputFormat : ()Landroid/media/MediaFormat;
    //   244: invokevirtual a : (Landroid/media/MediaFormat;)I
    //   247: putfield f : I
    //   250: aload_0
    //   251: iconst_1
    //   252: putfield e : Z
    //   255: aload #5
    //   257: invokevirtual b : ()Z
    //   260: ifne -> 122
    //   263: aload #5
    //   265: monitorenter
    //   266: aload #5
    //   268: invokevirtual a : ()Z
    //   271: istore_3
    //   272: iload_3
    //   273: ifne -> 291
    //   276: aload #5
    //   278: ldc2_w 100
    //   281: invokevirtual wait : (J)V
    //   284: goto -> 266
    //   287: aload #5
    //   289: monitorexit
    //   290: return
    //   291: aload #5
    //   293: monitorexit
    //   294: goto -> 122
    //   297: astore #4
    //   299: aload #5
    //   301: monitorexit
    //   302: aload #4
    //   304: athrow
    //   305: new java/lang/RuntimeException
    //   308: dup
    //   309: ldc 'format changed twice'
    //   311: invokespecial <init> : (Ljava/lang/String;)V
    //   314: athrow
    //   315: iload_2
    //   316: ifge -> 322
    //   319: goto -> 122
    //   322: aload #4
    //   324: iload_2
    //   325: aaload
    //   326: astore #6
    //   328: aload #6
    //   330: ifnull -> 449
    //   333: aload_0
    //   334: getfield k : Landroid/media/MediaCodec$BufferInfo;
    //   337: getfield flags : I
    //   340: iconst_2
    //   341: iand
    //   342: ifeq -> 353
    //   345: aload_0
    //   346: getfield k : Landroid/media/MediaCodec$BufferInfo;
    //   349: iconst_0
    //   350: putfield size : I
    //   353: aload_0
    //   354: getfield k : Landroid/media/MediaCodec$BufferInfo;
    //   357: getfield size : I
    //   360: ifeq -> 422
    //   363: aload_0
    //   364: getfield e : Z
    //   367: ifeq -> 412
    //   370: aload_0
    //   371: getfield k : Landroid/media/MediaCodec$BufferInfo;
    //   374: aload_0
    //   375: invokevirtual f : ()J
    //   378: putfield presentationTimeUs : J
    //   381: aload #5
    //   383: aload_0
    //   384: getfield f : I
    //   387: aload #6
    //   389: aload_0
    //   390: getfield k : Landroid/media/MediaCodec$BufferInfo;
    //   393: invokevirtual a : (ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   396: aload_0
    //   397: aload_0
    //   398: getfield k : Landroid/media/MediaCodec$BufferInfo;
    //   401: getfield presentationTimeUs : J
    //   404: putfield l : J
    //   407: iconst_0
    //   408: istore_1
    //   409: goto -> 422
    //   412: new java/lang/RuntimeException
    //   415: dup
    //   416: ldc 'drain:muxer hasn't started'
    //   418: invokespecial <init> : (Ljava/lang/String;)V
    //   421: athrow
    //   422: aload_0
    //   423: getfield g : Landroid/media/MediaCodec;
    //   426: iload_2
    //   427: iconst_0
    //   428: invokevirtual releaseOutputBuffer : (IZ)V
    //   431: aload_0
    //   432: getfield k : Landroid/media/MediaCodec$BufferInfo;
    //   435: getfield flags : I
    //   438: iconst_4
    //   439: iand
    //   440: ifeq -> 122
    //   443: aload_0
    //   444: iconst_0
    //   445: putfield b : Z
    //   448: return
    //   449: new java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial <init> : ()V
    //   456: astore #4
    //   458: aload #4
    //   460: ldc 'encoderOutputBuffer '
    //   462: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload #4
    //   468: iload_2
    //   469: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   472: pop
    //   473: aload #4
    //   475: ldc ' was null'
    //   477: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: new java/lang/RuntimeException
    //   484: dup
    //   485: aload #4
    //   487: invokevirtual toString : ()Ljava/lang/String;
    //   490: invokespecial <init> : (Ljava/lang/String;)V
    //   493: athrow
    //   494: return
    //   495: astore #4
    //   497: goto -> 287
    // Exception table:
    //   from	to	target	type
    //   266	272	297	finally
    //   276	284	495	java/lang/InterruptedException
    //   276	284	297	finally
    //   287	290	297	finally
    //   291	294	297	finally
    //   299	302	297	finally
  }
  
  protected long f() {
    long l2 = System.nanoTime() / 1000L;
    long l3 = this.l;
    long l1 = l2;
    if (l2 < l3)
      l1 = l2 + l3 - l2; 
    return l1;
  }
  
  public void run() {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield c : Z
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield j : I
    //   17: aload_0
    //   18: getfield a : Ljava/lang/Object;
    //   21: invokevirtual notify : ()V
    //   24: aload_3
    //   25: monitorexit
    //   26: aload_0
    //   27: getfield a : Ljava/lang/Object;
    //   30: astore_3
    //   31: aload_3
    //   32: monitorenter
    //   33: aload_0
    //   34: getfield c : Z
    //   37: istore_2
    //   38: aload_0
    //   39: getfield j : I
    //   42: ifle -> 172
    //   45: iconst_1
    //   46: istore_1
    //   47: goto -> 50
    //   50: iload_1
    //   51: ifeq -> 64
    //   54: aload_0
    //   55: aload_0
    //   56: getfield j : I
    //   59: iconst_1
    //   60: isub
    //   61: putfield j : I
    //   64: aload_3
    //   65: monitorexit
    //   66: iload_2
    //   67: ifeq -> 89
    //   70: aload_0
    //   71: invokevirtual e : ()V
    //   74: aload_0
    //   75: invokevirtual d : ()V
    //   78: aload_0
    //   79: invokevirtual e : ()V
    //   82: aload_0
    //   83: invokevirtual a : ()V
    //   86: goto -> 121
    //   89: iload_1
    //   90: ifeq -> 100
    //   93: aload_0
    //   94: invokevirtual e : ()V
    //   97: goto -> 26
    //   100: aload_0
    //   101: getfield a : Ljava/lang/Object;
    //   104: astore_3
    //   105: aload_3
    //   106: monitorenter
    //   107: aload_0
    //   108: getfield a : Ljava/lang/Object;
    //   111: invokevirtual wait : ()V
    //   114: aload_3
    //   115: monitorexit
    //   116: goto -> 26
    //   119: aload_3
    //   120: monitorexit
    //   121: aload_0
    //   122: getfield a : Ljava/lang/Object;
    //   125: astore_3
    //   126: aload_3
    //   127: monitorenter
    //   128: aload_0
    //   129: iconst_1
    //   130: putfield c : Z
    //   133: aload_0
    //   134: iconst_0
    //   135: putfield b : Z
    //   138: aload_3
    //   139: monitorexit
    //   140: return
    //   141: astore #4
    //   143: aload_3
    //   144: monitorexit
    //   145: aload #4
    //   147: athrow
    //   148: aload_3
    //   149: monitorexit
    //   150: aload #4
    //   152: athrow
    //   153: astore #4
    //   155: aload_3
    //   156: monitorexit
    //   157: aload #4
    //   159: athrow
    //   160: astore #4
    //   162: aload_3
    //   163: monitorexit
    //   164: aload #4
    //   166: athrow
    //   167: astore #4
    //   169: goto -> 119
    //   172: iconst_0
    //   173: istore_1
    //   174: goto -> 50
    //   177: astore #4
    //   179: goto -> 148
    // Exception table:
    //   from	to	target	type
    //   7	26	160	finally
    //   33	45	153	finally
    //   54	64	153	finally
    //   64	66	153	finally
    //   107	114	167	java/lang/InterruptedException
    //   107	114	177	finally
    //   114	116	177	finally
    //   119	121	177	finally
    //   128	140	141	finally
    //   143	145	141	finally
    //   148	150	177	finally
    //   155	157	153	finally
    //   162	164	160	finally
  }
  
  public static interface MediaEncoderListener {
    void a(MediaEncoder param1MediaEncoder);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\encoder\MediaEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */