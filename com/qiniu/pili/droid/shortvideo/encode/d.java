package com.qiniu.pili.droid.shortvideo.encode;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.qiniu.pili.droid.shortvideo.f.e;
import java.nio.ByteBuffer;

public abstract class d extends a {
  private static long g = 500L;
  
  protected MediaCodec e;
  
  protected volatile boolean f;
  
  private volatile long h;
  
  private volatile boolean i;
  
  private boolean n() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: aload_0
    //   6: invokevirtual j : ()Ljava/lang/String;
    //   9: ldc 'startEncode +'
    //   11: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield b : I
    //   19: aload_0
    //   20: iconst_0
    //   21: putfield c : I
    //   24: aload_0
    //   25: invokevirtual g : ()Landroid/media/MediaFormat;
    //   28: astore_1
    //   29: aload_0
    //   30: aload_0
    //   31: invokevirtual h : ()Ljava/lang/String;
    //   34: invokestatic createEncoderByType : (Ljava/lang/String;)Landroid/media/MediaCodec;
    //   37: putfield e : Landroid/media/MediaCodec;
    //   40: aload_0
    //   41: getfield e : Landroid/media/MediaCodec;
    //   44: aload_1
    //   45: aconst_null
    //   46: aconst_null
    //   47: iconst_1
    //   48: invokevirtual configure : (Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   51: aload_0
    //   52: invokevirtual i : ()Lcom/qiniu/pili/droid/shortvideo/encode/d$a;
    //   55: getstatic com/qiniu/pili/droid/shortvideo/encode/d$a.a : Lcom/qiniu/pili/droid/shortvideo/encode/d$a;
    //   58: if_acmpne -> 86
    //   61: aload_0
    //   62: getfield e : Landroid/media/MediaCodec;
    //   65: invokevirtual createInputSurface : ()Landroid/view/Surface;
    //   68: astore_1
    //   69: aload_0
    //   70: getfield d : Lcom/qiniu/pili/droid/shortvideo/encode/a$a;
    //   73: ifnull -> 86
    //   76: aload_0
    //   77: getfield d : Lcom/qiniu/pili/droid/shortvideo/encode/a$a;
    //   80: aload_1
    //   81: invokeinterface a : (Landroid/view/Surface;)V
    //   86: aload_0
    //   87: getfield e : Landroid/media/MediaCodec;
    //   90: invokevirtual start : ()V
    //   93: aload_0
    //   94: getfield d : Lcom/qiniu/pili/droid/shortvideo/encode/a$a;
    //   97: ifnull -> 110
    //   100: aload_0
    //   101: getfield d : Lcom/qiniu/pili/droid/shortvideo/encode/a$a;
    //   104: iconst_1
    //   105: invokeinterface a : (Z)V
    //   110: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   113: aload_0
    //   114: invokevirtual j : ()Ljava/lang/String;
    //   117: ldc 'startEncode -'
    //   119: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_0
    //   123: monitorexit
    //   124: iconst_1
    //   125: ireturn
    //   126: astore_1
    //   127: goto -> 215
    //   130: astore_1
    //   131: aload_0
    //   132: aconst_null
    //   133: putfield e : Landroid/media/MediaCodec;
    //   136: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   139: astore_2
    //   140: aload_0
    //   141: invokevirtual j : ()Ljava/lang/String;
    //   144: astore_3
    //   145: new java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial <init> : ()V
    //   152: astore #4
    //   154: aload #4
    //   156: ldc 'start encoder failed: '
    //   158: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload #4
    //   164: aload_1
    //   165: invokevirtual getMessage : ()Ljava/lang/String;
    //   168: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload_2
    //   173: aload_3
    //   174: aload #4
    //   176: invokevirtual toString : ()Ljava/lang/String;
    //   179: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload_0
    //   183: getfield d : Lcom/qiniu/pili/droid/shortvideo/encode/a$a;
    //   186: ifnull -> 199
    //   189: aload_0
    //   190: getfield d : Lcom/qiniu/pili/droid/shortvideo/encode/a$a;
    //   193: iconst_0
    //   194: invokeinterface a : (Z)V
    //   199: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   202: aload_0
    //   203: invokevirtual j : ()Ljava/lang/String;
    //   206: ldc 'startEncode -'
    //   208: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload_0
    //   212: monitorexit
    //   213: iconst_0
    //   214: ireturn
    //   215: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   218: aload_0
    //   219: invokevirtual j : ()Ljava/lang/String;
    //   222: ldc 'startEncode -'
    //   224: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   227: aload_1
    //   228: athrow
    //   229: astore_1
    //   230: aload_0
    //   231: monitorexit
    //   232: aload_1
    //   233: athrow
    // Exception table:
    //   from	to	target	type
    //   2	29	229	finally
    //   29	86	130	java/lang/Exception
    //   29	86	126	finally
    //   86	110	130	java/lang/Exception
    //   86	110	126	finally
    //   110	122	229	finally
    //   131	199	126	finally
    //   199	211	229	finally
    //   215	229	229	finally
  }
  
  private void o() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: aload_0
    //   6: invokevirtual j : ()Ljava/lang/String;
    //   9: ldc 'stopEncode +'
    //   11: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield e : Landroid/media/MediaCodec;
    //   18: ifnonnull -> 36
    //   21: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   24: aload_0
    //   25: invokevirtual j : ()Ljava/lang/String;
    //   28: ldc 'encoder is null.'
    //   30: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: aload_0
    //   37: getfield e : Landroid/media/MediaCodec;
    //   40: invokevirtual stop : ()V
    //   43: aload_0
    //   44: getfield e : Landroid/media/MediaCodec;
    //   47: invokevirtual release : ()V
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield e : Landroid/media/MediaCodec;
    //   55: goto -> 105
    //   58: astore_1
    //   59: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   62: astore_2
    //   63: aload_0
    //   64: invokevirtual j : ()Ljava/lang/String;
    //   67: astore_3
    //   68: new java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial <init> : ()V
    //   75: astore #4
    //   77: aload #4
    //   79: ldc 'encoder stop, release failed: '
    //   81: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload #4
    //   87: aload_1
    //   88: invokevirtual getMessage : ()Ljava/lang/String;
    //   91: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_2
    //   96: aload_3
    //   97: aload #4
    //   99: invokevirtual toString : ()Ljava/lang/String;
    //   102: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_0
    //   106: getfield d : Lcom/qiniu/pili/droid/shortvideo/encode/a$a;
    //   109: ifnull -> 125
    //   112: aload_0
    //   113: getfield d : Lcom/qiniu/pili/droid/shortvideo/encode/a$a;
    //   116: aload_0
    //   117: getfield f : Z
    //   120: invokeinterface b : (Z)V
    //   125: aload_0
    //   126: iconst_0
    //   127: putfield f : Z
    //   130: aload_0
    //   131: iconst_0
    //   132: putfield i : Z
    //   135: aload_0
    //   136: lconst_0
    //   137: putfield h : J
    //   140: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   143: aload_0
    //   144: invokevirtual j : ()Ljava/lang/String;
    //   147: ldc 'stopEncode -'
    //   149: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   152: aload_0
    //   153: monitorexit
    //   154: return
    //   155: astore_1
    //   156: aload_0
    //   157: monitorexit
    //   158: aload_1
    //   159: athrow
    // Exception table:
    //   from	to	target	type
    //   2	33	155	finally
    //   36	55	58	java/lang/Exception
    //   36	55	155	finally
    //   59	105	155	finally
    //   105	125	155	finally
    //   125	152	155	finally
  }
  
  public boolean a(long paramLong) {
    e.h.d(j(), "unimplemented !");
    return false;
  }
  
  public boolean a(ByteBuffer paramByteBuffer, int paramInt, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual m : ()Z
    //   6: ifeq -> 25
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: aload_0
    //   13: invokevirtual j : ()Ljava/lang/String;
    //   16: ldc 'stop is marked, not accepting anymore frames.'
    //   18: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: monitorexit
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_0
    //   26: getfield e : Landroid/media/MediaCodec;
    //   29: ifnonnull -> 48
    //   32: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   35: aload_0
    //   36: invokevirtual j : ()Ljava/lang/String;
    //   39: ldc 'encoder is null.'
    //   41: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: monitorexit
    //   46: iconst_0
    //   47: ireturn
    //   48: aload_0
    //   49: lload_3
    //   50: invokevirtual b : (J)J
    //   53: lstore_3
    //   54: lload_3
    //   55: lconst_0
    //   56: lcmp
    //   57: ifge -> 64
    //   60: aload_0
    //   61: monitorexit
    //   62: iconst_0
    //   63: ireturn
    //   64: aload_0
    //   65: getfield e : Landroid/media/MediaCodec;
    //   68: ldc2_w -1
    //   71: invokevirtual dequeueInputBuffer : (J)I
    //   74: istore #5
    //   76: iload #5
    //   78: ifge -> 131
    //   81: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   84: astore_1
    //   85: aload_0
    //   86: invokevirtual j : ()Ljava/lang/String;
    //   89: astore #6
    //   91: new java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial <init> : ()V
    //   98: astore #7
    //   100: aload #7
    //   102: ldc 'dequeueInputBuffer failed: '
    //   104: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload #7
    //   110: iload #5
    //   112: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_1
    //   117: aload #6
    //   119: aload #7
    //   121: invokevirtual toString : ()Ljava/lang/String;
    //   124: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload_0
    //   128: monitorexit
    //   129: iconst_0
    //   130: ireturn
    //   131: aload_0
    //   132: getfield e : Landroid/media/MediaCodec;
    //   135: invokevirtual getInputBuffers : ()[Ljava/nio/ByteBuffer;
    //   138: iload #5
    //   140: aaload
    //   141: astore #6
    //   143: aload #6
    //   145: ifnull -> 185
    //   148: aload_1
    //   149: ifnull -> 185
    //   152: aload_1
    //   153: aload_1
    //   154: invokevirtual position : ()I
    //   157: iload_2
    //   158: iadd
    //   159: aload_1
    //   160: invokevirtual capacity : ()I
    //   163: invokestatic min : (II)I
    //   166: aload #6
    //   168: invokevirtual remaining : ()I
    //   171: invokestatic min : (II)I
    //   174: invokevirtual limit : (I)Ljava/nio/Buffer;
    //   177: pop
    //   178: aload #6
    //   180: aload_1
    //   181: invokevirtual put : (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   184: pop
    //   185: aload_0
    //   186: getfield e : Landroid/media/MediaCodec;
    //   189: iload #5
    //   191: iconst_0
    //   192: iload_2
    //   193: lload_3
    //   194: iconst_0
    //   195: invokevirtual queueInputBuffer : (IIIJI)V
    //   198: aload_0
    //   199: invokevirtual d : ()V
    //   202: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   205: astore #6
    //   207: aload_0
    //   208: invokevirtual j : ()Ljava/lang/String;
    //   211: astore #7
    //   213: new java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial <init> : ()V
    //   220: astore #8
    //   222: aload #8
    //   224: ldc 'input frame: '
    //   226: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload #8
    //   232: aload_0
    //   233: getfield b : I
    //   236: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload #8
    //   242: ldc ' buffer:'
    //   244: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload #8
    //   250: aload_1
    //   251: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload #8
    //   257: ldc ' size:'
    //   259: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload #8
    //   265: iload_2
    //   266: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload #8
    //   272: ldc ' timestampUs:'
    //   274: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload #8
    //   280: lload_3
    //   281: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload #6
    //   287: aload #7
    //   289: aload #8
    //   291: invokevirtual toString : ()Ljava/lang/String;
    //   294: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   297: aload_0
    //   298: monitorexit
    //   299: iconst_1
    //   300: ireturn
    //   301: astore_1
    //   302: aload_1
    //   303: invokevirtual printStackTrace : ()V
    //   306: aload_0
    //   307: monitorexit
    //   308: iconst_0
    //   309: ireturn
    //   310: astore_1
    //   311: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   314: astore #6
    //   316: aload_0
    //   317: invokevirtual j : ()Ljava/lang/String;
    //   320: astore #7
    //   322: new java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial <init> : ()V
    //   329: astore #8
    //   331: aload #8
    //   333: ldc 'dequeueInputBuffer failed: '
    //   335: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload #8
    //   341: aload_1
    //   342: invokevirtual getMessage : ()Ljava/lang/String;
    //   345: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload #6
    //   351: aload #7
    //   353: aload #8
    //   355: invokevirtual toString : ()Ljava/lang/String;
    //   358: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   361: aload_0
    //   362: monitorexit
    //   363: iconst_0
    //   364: ireturn
    //   365: astore_1
    //   366: aload_0
    //   367: monitorexit
    //   368: aload_1
    //   369: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	365	finally
    //   25	44	365	finally
    //   48	54	365	finally
    //   64	76	310	java/lang/Exception
    //   64	76	365	finally
    //   81	127	365	finally
    //   131	143	365	finally
    //   152	185	365	finally
    //   185	198	301	java/lang/Exception
    //   185	198	365	finally
    //   198	297	365	finally
    //   302	306	365	finally
    //   311	361	365	finally
  }
  
  protected abstract MediaFormat g();
  
  protected abstract String h();
  
  protected abstract a i();
  
  protected void k() {
    // Byte code:
    //   0: aload_0
    //   1: getfield e : Landroid/media/MediaCodec;
    //   4: ifnonnull -> 20
    //   7: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   10: aload_0
    //   11: invokevirtual j : ()Ljava/lang/String;
    //   14: ldc 'encoder is null.'
    //   16: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   19: return
    //   20: new android/media/MediaCodec$BufferInfo
    //   23: dup
    //   24: invokespecial <init> : ()V
    //   27: astore #4
    //   29: iconst_1
    //   30: istore_3
    //   31: aload_0
    //   32: getfield e : Landroid/media/MediaCodec;
    //   35: aload #4
    //   37: ldc2_w 1000
    //   40: invokevirtual dequeueOutputBuffer : (Landroid/media/MediaCodec$BufferInfo;J)I
    //   43: istore_1
    //   44: iload_1
    //   45: bipush #-3
    //   47: if_icmpne -> 65
    //   50: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   53: aload_0
    //   54: invokevirtual j : ()Ljava/lang/String;
    //   57: ldc 'output buffers changed !'
    //   59: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   62: goto -> 218
    //   65: iload_1
    //   66: bipush #-2
    //   68: if_icmpne -> 101
    //   71: aload_0
    //   72: getfield e : Landroid/media/MediaCodec;
    //   75: invokevirtual getOutputFormat : ()Landroid/media/MediaFormat;
    //   78: astore #5
    //   80: aload_0
    //   81: getfield d : Lcom/qiniu/pili/droid/shortvideo/encode/a$a;
    //   84: ifnull -> 218
    //   87: aload_0
    //   88: getfield d : Lcom/qiniu/pili/droid/shortvideo/encode/a$a;
    //   91: aload #5
    //   93: invokeinterface a : (Landroid/media/MediaFormat;)V
    //   98: goto -> 218
    //   101: iload_1
    //   102: ifge -> 108
    //   105: goto -> 218
    //   108: aload #4
    //   110: getfield flags : I
    //   113: iconst_2
    //   114: iand
    //   115: ifeq -> 133
    //   118: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   121: aload_0
    //   122: invokevirtual j : ()Ljava/lang/String;
    //   125: ldc 'ignoring BUFFER_FLAG_CODEC_CONFIG'
    //   127: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   130: goto -> 209
    //   133: aload_0
    //   134: getfield e : Landroid/media/MediaCodec;
    //   137: invokevirtual getOutputBuffers : ()[Ljava/nio/ByteBuffer;
    //   140: iload_1
    //   141: aaload
    //   142: astore #5
    //   144: aload #5
    //   146: aload #4
    //   148: getfield offset : I
    //   151: invokevirtual position : (I)Ljava/nio/Buffer;
    //   154: pop
    //   155: aload #5
    //   157: aload #4
    //   159: getfield offset : I
    //   162: aload #4
    //   164: getfield size : I
    //   167: iadd
    //   168: invokevirtual limit : (I)Ljava/nio/Buffer;
    //   171: pop
    //   172: aload_0
    //   173: getfield d : Lcom/qiniu/pili/droid/shortvideo/encode/a$a;
    //   176: ifnull -> 192
    //   179: aload_0
    //   180: getfield d : Lcom/qiniu/pili/droid/shortvideo/encode/a$a;
    //   183: aload #5
    //   185: aload #4
    //   187: invokeinterface a : (Ljava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   192: aload #5
    //   194: invokevirtual clear : ()Ljava/nio/Buffer;
    //   197: pop
    //   198: aload_0
    //   199: invokevirtual e : ()V
    //   202: aload_0
    //   203: invokestatic currentTimeMillis : ()J
    //   206: putfield h : J
    //   209: aload_0
    //   210: getfield e : Landroid/media/MediaCodec;
    //   213: iload_1
    //   214: iconst_0
    //   215: invokevirtual releaseOutputBuffer : (IZ)V
    //   218: iload_1
    //   219: iconst_m1
    //   220: if_icmpeq -> 462
    //   223: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   226: astore #5
    //   228: aload_0
    //   229: invokevirtual j : ()Ljava/lang/String;
    //   232: astore #6
    //   234: new java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial <init> : ()V
    //   241: astore #7
    //   243: aload #7
    //   245: ldc_w 'output frame: '
    //   248: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload #7
    //   254: aload_0
    //   255: getfield c : I
    //   258: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload #7
    //   264: ldc_w ' index:'
    //   267: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload #7
    //   273: iload_1
    //   274: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload #7
    //   280: ldc_w ' key frame:'
    //   283: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload #4
    //   289: getfield flags : I
    //   292: iconst_1
    //   293: iand
    //   294: ifeq -> 302
    //   297: iconst_1
    //   298: istore_2
    //   299: goto -> 304
    //   302: iconst_0
    //   303: istore_2
    //   304: aload #7
    //   306: iload_2
    //   307: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload #7
    //   313: ldc_w ' eos:'
    //   316: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload #4
    //   322: getfield flags : I
    //   325: iconst_4
    //   326: iand
    //   327: ifeq -> 335
    //   330: iconst_1
    //   331: istore_2
    //   332: goto -> 337
    //   335: iconst_0
    //   336: istore_2
    //   337: aload #7
    //   339: iload_2
    //   340: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload #7
    //   346: ldc_w ' config:'
    //   349: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload #4
    //   355: getfield flags : I
    //   358: iconst_2
    //   359: iand
    //   360: ifeq -> 368
    //   363: iconst_1
    //   364: istore_2
    //   365: goto -> 370
    //   368: iconst_0
    //   369: istore_2
    //   370: aload #7
    //   372: iload_2
    //   373: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload #7
    //   379: ldc_w ' sync:'
    //   382: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload #4
    //   388: getfield flags : I
    //   391: iconst_1
    //   392: iand
    //   393: ifeq -> 401
    //   396: iload_3
    //   397: istore_2
    //   398: goto -> 403
    //   401: iconst_0
    //   402: istore_2
    //   403: aload #7
    //   405: iload_2
    //   406: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload #7
    //   412: ldc_w ' time:'
    //   415: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload #7
    //   421: aload #4
    //   423: getfield presentationTimeUs : J
    //   426: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload #7
    //   432: ldc ' size:'
    //   434: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload #7
    //   440: aload #4
    //   442: getfield size : I
    //   445: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload #5
    //   451: aload #6
    //   453: aload #7
    //   455: invokevirtual toString : ()Ljava/lang/String;
    //   458: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   461: return
    //   462: aload_0
    //   463: invokevirtual m : ()Z
    //   466: ifeq -> 623
    //   469: invokestatic currentTimeMillis : ()J
    //   472: aload_0
    //   473: getfield h : J
    //   476: lsub
    //   477: getstatic com/qiniu/pili/droid/shortvideo/encode/d.g : J
    //   480: lcmp
    //   481: ifle -> 623
    //   484: aload_0
    //   485: invokevirtual i : ()Lcom/qiniu/pili/droid/shortvideo/encode/d$a;
    //   488: getstatic com/qiniu/pili/droid/shortvideo/encode/d$a.a : Lcom/qiniu/pili/droid/shortvideo/encode/d$a;
    //   491: if_acmpne -> 502
    //   494: ldc_w 'video'
    //   497: astore #4
    //   499: goto -> 507
    //   502: ldc_w 'audio'
    //   505: astore #4
    //   507: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   510: astore #5
    //   512: aload_0
    //   513: invokevirtual j : ()Ljava/lang/String;
    //   516: astore #6
    //   518: new java/lang/StringBuilder
    //   521: dup
    //   522: invokespecial <init> : ()V
    //   525: astore #7
    //   527: aload #7
    //   529: aload #4
    //   531: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: aload #7
    //   537: ldc_w ' frame output time out, stop encode! '
    //   540: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: aload #7
    //   546: ldc_w ' input frame count: '
    //   549: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: pop
    //   553: aload #7
    //   555: aload_0
    //   556: getfield b : I
    //   559: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   562: pop
    //   563: aload #7
    //   565: ldc_w ' output frame count: '
    //   568: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: aload #7
    //   574: aload_0
    //   575: getfield c : I
    //   578: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload #7
    //   584: ldc_w ' drop frames: '
    //   587: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: aload #7
    //   593: aload_0
    //   594: getfield b : I
    //   597: aload_0
    //   598: getfield c : I
    //   601: isub
    //   602: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   605: pop
    //   606: aload #5
    //   608: aload #6
    //   610: aload #7
    //   612: invokevirtual toString : ()Ljava/lang/String;
    //   615: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   618: aload_0
    //   619: iconst_1
    //   620: putfield i : Z
    //   623: return
    //   624: astore #4
    //   626: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   629: astore #5
    //   631: aload_0
    //   632: invokevirtual j : ()Ljava/lang/String;
    //   635: astore #6
    //   637: new java/lang/StringBuilder
    //   640: dup
    //   641: invokespecial <init> : ()V
    //   644: astore #7
    //   646: aload #7
    //   648: ldc_w 'releaseOutputBuffer failed: '
    //   651: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: pop
    //   655: aload #7
    //   657: aload #4
    //   659: invokevirtual getMessage : ()Ljava/lang/String;
    //   662: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: pop
    //   666: aload #5
    //   668: aload #6
    //   670: aload #7
    //   672: invokevirtual toString : ()Ljava/lang/String;
    //   675: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   678: return
    //   679: astore #4
    //   681: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   684: astore #5
    //   686: aload_0
    //   687: invokevirtual j : ()Ljava/lang/String;
    //   690: astore #6
    //   692: new java/lang/StringBuilder
    //   695: dup
    //   696: invokespecial <init> : ()V
    //   699: astore #7
    //   701: aload #7
    //   703: ldc_w 'dequeueOutputBuffer failed: '
    //   706: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: pop
    //   710: aload #7
    //   712: aload #4
    //   714: invokevirtual getMessage : ()Ljava/lang/String;
    //   717: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: pop
    //   721: aload #5
    //   723: aload #6
    //   725: aload #7
    //   727: invokevirtual toString : ()Ljava/lang/String;
    //   730: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   733: aload_0
    //   734: iconst_1
    //   735: putfield f : Z
    //   738: return
    // Exception table:
    //   from	to	target	type
    //   31	44	679	java/lang/Exception
    //   209	218	624	java/lang/Exception
  }
  
  public void run() {
    if (n()) {
      while ((!m() || f()) && !this.f && !this.i)
        k(); 
      o();
      return;
    } 
    e.h.e(j(), "encoder start failed");
  }
  
  public enum a {
    a, b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\encode\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */