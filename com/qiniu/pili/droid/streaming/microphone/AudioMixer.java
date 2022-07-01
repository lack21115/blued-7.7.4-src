package com.qiniu.pili.droid.streaming.microphone;

import a.a.a.a.a.d.b;
import a.a.a.a.a.e.e;
import a.a.a.a.a.g.a;
import com.qiniu.pili.droid.streaming.SharedLibraryNameHelper;
import java.io.IOException;
import java.nio.ByteBuffer;

public class AudioMixer {
  public static final boolean s = SharedLibraryNameHelper.getInstance().b();
  
  public a a = new a();
  
  public AudioTransformer b = new AudioTransformer();
  
  public ByteBuffer c;
  
  public ByteBuffer d;
  
  public int e;
  
  public int f;
  
  public int g;
  
  public int h;
  
  public int i;
  
  public int j;
  
  public boolean k;
  
  public boolean l;
  
  public boolean m;
  
  public float n = 1.0F;
  
  public float o = 1.0F;
  
  public OnAudioMixListener p;
  
  public long q = 0L;
  
  public long r = 0L;
  
  public final int a(int paramInt) {
    return (int)(paramInt * 1.0D / this.j * this.i);
  }
  
  public void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic a/a/a/a/a/e/e.h : La/a/a/a/a/e/e;
    //   5: ldc 'PLAudioMixer'
    //   7: ldc 'amix destroy'
    //   9: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual stop : ()Z
    //   16: pop
    //   17: aload_0
    //   18: getfield a : La/a/a/a/a/g/a;
    //   21: invokevirtual h : ()V
    //   24: aload_0
    //   25: getfield b : Lcom/qiniu/pili/droid/streaming/microphone/AudioTransformer;
    //   28: aload_0
    //   29: getfield r : J
    //   32: invokevirtual destroy : (J)V
    //   35: aload_0
    //   36: aload_0
    //   37: getfield q : J
    //   40: invokevirtual destroy : (J)V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Exception table:
    //   from	to	target	type
    //   2	43	46	finally
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!SharedLibraryNameHelper.b(true)) {
      e.h.e("PLAudioMixer", "init failed : audio mix so load unsuccessfully !");
      return;
    } 
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
    this.h = paramInt4;
    this.i = paramInt1 * paramInt2 * paramInt3 / 8;
    e e = e.h;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("incoming data parameters will be sampleRate:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" channels:");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" sampleSize:");
    stringBuilder.append(paramInt3);
    stringBuilder.append(" maxBytes:");
    stringBuilder.append(paramInt4);
    stringBuilder.append(" bytesPerSecond:");
    stringBuilder.append(this.i);
    e.c("PLAudioMixer", stringBuilder.toString());
    this.q = init(paramInt4);
  }
  
  public void a(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Ljava/nio/ByteBuffer;
    //   6: invokevirtual remaining : ()I
    //   9: iload_3
    //   10: if_icmpge -> 229
    //   13: aload_0
    //   14: getfield a : La/a/a/a/a/g/a;
    //   17: invokevirtual f : ()Ljava/nio/ByteBuffer;
    //   20: astore #9
    //   22: aload #9
    //   24: ifnull -> 152
    //   27: aload #9
    //   29: invokevirtual remaining : ()I
    //   32: istore #5
    //   34: aload_0
    //   35: getfield c : Ljava/nio/ByteBuffer;
    //   38: astore #10
    //   40: aload #10
    //   42: ifnull -> 69
    //   45: aload #10
    //   47: invokevirtual capacity : ()I
    //   50: iload #5
    //   52: if_icmpge -> 58
    //   55: goto -> 69
    //   58: aload_0
    //   59: getfield c : Ljava/nio/ByteBuffer;
    //   62: invokevirtual clear : ()Ljava/nio/Buffer;
    //   65: pop
    //   66: goto -> 78
    //   69: aload_0
    //   70: iload #5
    //   72: invokestatic allocateDirect : (I)Ljava/nio/ByteBuffer;
    //   75: putfield c : Ljava/nio/ByteBuffer;
    //   78: aload_0
    //   79: getfield c : Ljava/nio/ByteBuffer;
    //   82: aload #9
    //   84: invokevirtual put : (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   87: pop
    //   88: aload_0
    //   89: getfield c : Ljava/nio/ByteBuffer;
    //   92: invokevirtual flip : ()Ljava/nio/Buffer;
    //   95: pop
    //   96: aload_0
    //   97: getfield b : Lcom/qiniu/pili/droid/streaming/microphone/AudioTransformer;
    //   100: astore #9
    //   102: aload_0
    //   103: getfield r : J
    //   106: lstore #7
    //   108: aload_0
    //   109: getfield c : Ljava/nio/ByteBuffer;
    //   112: astore #10
    //   114: aload #10
    //   116: invokevirtual position : ()I
    //   119: istore #6
    //   121: aload_0
    //   122: getfield d : Ljava/nio/ByteBuffer;
    //   125: astore #11
    //   127: aload #9
    //   129: lload #7
    //   131: aload #10
    //   133: iload #6
    //   135: iload #5
    //   137: aload #11
    //   139: aload #11
    //   141: invokevirtual limit : ()I
    //   144: invokevirtual resample : (JLjava/nio/ByteBuffer;IILjava/nio/ByteBuffer;I)I
    //   147: istore #5
    //   149: goto -> 199
    //   152: getstatic a/a/a/a/a/e/e.h : La/a/a/a/a/e/e;
    //   155: ldc 'PLAudioMixer'
    //   157: ldc 'returns null means EOF, stop it.'
    //   159: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload_0
    //   163: invokevirtual stop : ()Z
    //   166: pop
    //   167: aload_0
    //   168: getfield p : Lcom/qiniu/pili/droid/streaming/microphone/OnAudioMixListener;
    //   171: astore #9
    //   173: aload #9
    //   175: ifnull -> 188
    //   178: aload #9
    //   180: getstatic com/qiniu/pili/droid/streaming/microphone/OnAudioMixListener$MixStatus.Finish : Lcom/qiniu/pili/droid/streaming/microphone/OnAudioMixListener$MixStatus;
    //   183: invokeinterface onStatusChanged : (Lcom/qiniu/pili/droid/streaming/microphone/OnAudioMixListener$MixStatus;)V
    //   188: iload_3
    //   189: aload_0
    //   190: getfield d : Ljava/nio/ByteBuffer;
    //   193: invokevirtual limit : ()I
    //   196: isub
    //   197: istore #5
    //   199: aload_0
    //   200: getfield d : Ljava/nio/ByteBuffer;
    //   203: astore #9
    //   205: aload #9
    //   207: aload #9
    //   209: invokevirtual limit : ()I
    //   212: iload #5
    //   214: iadd
    //   215: invokevirtual limit : (I)Ljava/nio/Buffer;
    //   218: pop
    //   219: aload_0
    //   220: getfield a : La/a/a/a/a/g/a;
    //   223: invokevirtual g : ()V
    //   226: goto -> 2
    //   229: aload_0
    //   230: getfield m : Z
    //   233: ifne -> 293
    //   236: aload_0
    //   237: getfield q : J
    //   240: lstore #7
    //   242: aload_1
    //   243: invokevirtual position : ()I
    //   246: istore #5
    //   248: aload_0
    //   249: getfield n : F
    //   252: fstore #4
    //   254: aload_0
    //   255: getfield d : Ljava/nio/ByteBuffer;
    //   258: astore #9
    //   260: aload_0
    //   261: lload #7
    //   263: aload_1
    //   264: iload #5
    //   266: fload #4
    //   268: aload #9
    //   270: aload #9
    //   272: invokevirtual position : ()I
    //   275: aload_0
    //   276: getfield o : F
    //   279: aload_2
    //   280: aload_2
    //   281: invokevirtual position : ()I
    //   284: aload_0
    //   285: getfield g : I
    //   288: iload_3
    //   289: invokevirtual mix : (JLjava/nio/ByteBuffer;IFLjava/nio/ByteBuffer;IFLjava/nio/ByteBuffer;III)Z
    //   292: pop
    //   293: aload_0
    //   294: getfield d : Ljava/nio/ByteBuffer;
    //   297: invokevirtual remaining : ()I
    //   300: iload_3
    //   301: isub
    //   302: istore #5
    //   304: aload_0
    //   305: getfield d : Ljava/nio/ByteBuffer;
    //   308: invokevirtual clear : ()Ljava/nio/Buffer;
    //   311: pop
    //   312: iload #5
    //   314: ifle -> 350
    //   317: aload_0
    //   318: getfield d : Ljava/nio/ByteBuffer;
    //   321: astore_1
    //   322: aload_1
    //   323: aload_1
    //   324: invokevirtual array : ()[B
    //   327: aload_0
    //   328: getfield d : Ljava/nio/ByteBuffer;
    //   331: invokevirtual arrayOffset : ()I
    //   334: aload_0
    //   335: getfield d : Ljava/nio/ByteBuffer;
    //   338: invokevirtual position : ()I
    //   341: iadd
    //   342: iload_3
    //   343: iadd
    //   344: iload #5
    //   346: invokevirtual put : ([BII)Ljava/nio/ByteBuffer;
    //   349: pop
    //   350: aload_0
    //   351: getfield d : Ljava/nio/ByteBuffer;
    //   354: invokevirtual flip : ()Ljava/nio/Buffer;
    //   357: pop
    //   358: aload_0
    //   359: monitorexit
    //   360: return
    //   361: astore_1
    //   362: aload_0
    //   363: monitorexit
    //   364: aload_1
    //   365: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	361	finally
    //   27	40	361	finally
    //   45	55	361	finally
    //   58	66	361	finally
    //   69	78	361	finally
    //   78	149	361	finally
    //   152	173	361	finally
    //   178	188	361	finally
    //   188	199	361	finally
    //   199	226	361	finally
    //   229	293	361	finally
    //   293	312	361	finally
    //   317	350	361	finally
    //   350	358	361	finally
  }
  
  public void a(boolean paramBoolean) {
    e.h.c("PLAudioMixer", "amix is decode only!");
    this.m = paramBoolean;
  }
  
  public final boolean b() {
    if (!this.k)
      e.h.d("PLAudioMixer", "file for mixing not setup yet!!!"); 
    return this.k;
  }
  
  public final native void destroy(long paramLong);
  
  public long getDuration() {
    return this.a.b();
  }
  
  public final native long init(int paramInt);
  
  public boolean isRunning() {
    return this.l;
  }
  
  public final native boolean mix(long paramLong, ByteBuffer paramByteBuffer1, int paramInt1, float paramFloat1, ByteBuffer paramByteBuffer2, int paramInt2, float paramFloat2, ByteBuffer paramByteBuffer3, int paramInt3, int paramInt4, int paramInt5);
  
  public boolean pause() {
    if (!b())
      return false; 
    this.l = false;
    b.q();
    return true;
  }
  
  public boolean play() {
    if (!b())
      return false; 
    this.l = true;
    return true;
  }
  
  public boolean seek(float paramFloat) {
    if (!b())
      return false; 
    this.a.a((long)((float)getDuration() * paramFloat));
    return true;
  }
  
  public boolean setFile(String paramString, boolean paramBoolean) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : La/a/a/a/a/g/a;
    //   6: invokevirtual h : ()V
    //   9: aload_0
    //   10: getfield a : La/a/a/a/a/g/a;
    //   13: aload_1
    //   14: iload_2
    //   15: invokevirtual a : (Ljava/lang/String;Z)Z
    //   18: istore #7
    //   20: iconst_0
    //   21: istore_2
    //   22: iload #7
    //   24: ifne -> 80
    //   27: getstatic a/a/a/a/a/e/e.h : La/a/a/a/a/e/e;
    //   30: astore #10
    //   32: new java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial <init> : ()V
    //   39: astore #11
    //   41: aload #11
    //   43: ldc 'setup decoder for '
    //   45: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload #11
    //   51: aload_1
    //   52: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload #11
    //   58: ldc ' failed'
    //   60: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload #10
    //   66: ldc 'PLAudioMixer'
    //   68: aload #11
    //   70: invokevirtual toString : ()Ljava/lang/String;
    //   73: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_0
    //   77: monitorexit
    //   78: iconst_0
    //   79: ireturn
    //   80: aload_0
    //   81: getfield a : La/a/a/a/a/g/a;
    //   84: invokevirtual d : ()I
    //   87: istore_3
    //   88: aload_0
    //   89: getfield a : La/a/a/a/a/g/a;
    //   92: invokevirtual e : ()I
    //   95: istore #4
    //   97: aload_0
    //   98: getfield a : La/a/a/a/a/g/a;
    //   101: invokevirtual c : ()I
    //   104: istore #5
    //   106: aload_0
    //   107: iload_3
    //   108: iload #4
    //   110: imul
    //   111: iload #5
    //   113: bipush #8
    //   115: idiv
    //   116: imul
    //   117: putfield j : I
    //   120: getstatic a/a/a/a/a/e/e.h : La/a/a/a/a/e/e;
    //   123: astore_1
    //   124: new java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial <init> : ()V
    //   131: astore #10
    //   133: aload #10
    //   135: ldc_w 'decode data parameters will be sampleRate:'
    //   138: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload #10
    //   144: iload_3
    //   145: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload #10
    //   151: ldc ' channels:'
    //   153: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload #10
    //   159: iload #4
    //   161: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload #10
    //   167: ldc ' sampleSize:'
    //   169: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload #10
    //   175: iload #5
    //   177: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload #10
    //   183: ldc ' bytesPerSecond:'
    //   185: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload #10
    //   191: aload_0
    //   192: getfield j : I
    //   195: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_1
    //   200: ldc 'PLAudioMixer'
    //   202: aload #10
    //   204: invokevirtual toString : ()Ljava/lang/String;
    //   207: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload_0
    //   211: aload_0
    //   212: getfield a : La/a/a/a/a/g/a;
    //   215: invokevirtual a : ()I
    //   218: invokevirtual a : (I)I
    //   221: istore #6
    //   223: iload #6
    //   225: aload_0
    //   226: getfield h : I
    //   229: i2d
    //   230: dconst_1
    //   231: dmul
    //   232: iload #6
    //   234: i2d
    //   235: ddiv
    //   236: invokestatic ceil : (D)D
    //   239: d2i
    //   240: imul
    //   241: iconst_2
    //   242: imul
    //   243: invokestatic allocateDirect : (I)Ljava/nio/ByteBuffer;
    //   246: astore_1
    //   247: aload_0
    //   248: aload_1
    //   249: putfield d : Ljava/nio/ByteBuffer;
    //   252: aload_1
    //   253: iconst_0
    //   254: invokevirtual limit : (I)Ljava/nio/Buffer;
    //   257: pop
    //   258: getstatic a/a/a/a/a/e/e.h : La/a/a/a/a/e/e;
    //   261: astore_1
    //   262: new java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial <init> : ()V
    //   269: astore #10
    //   271: aload #10
    //   273: ldc_w 'mResampledFrames cap:'
    //   276: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload #10
    //   282: aload_0
    //   283: getfield d : Ljava/nio/ByteBuffer;
    //   286: invokevirtual capacity : ()I
    //   289: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload_1
    //   294: ldc 'PLAudioMixer'
    //   296: aload #10
    //   298: invokevirtual toString : ()Ljava/lang/String;
    //   301: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload_0
    //   305: getfield b : Lcom/qiniu/pili/droid/streaming/microphone/AudioTransformer;
    //   308: iload_3
    //   309: iload #4
    //   311: iload #5
    //   313: aload_0
    //   314: getfield e : I
    //   317: aload_0
    //   318: getfield f : I
    //   321: aload_0
    //   322: getfield g : I
    //   325: invokevirtual init : (IIIIII)J
    //   328: lstore #8
    //   330: aload_0
    //   331: lload #8
    //   333: putfield r : J
    //   336: lload #8
    //   338: ldc2_w -1
    //   341: lcmp
    //   342: ifeq -> 347
    //   345: iconst_1
    //   346: istore_2
    //   347: aload_0
    //   348: iload_2
    //   349: putfield k : Z
    //   352: invokestatic p : ()V
    //   355: aload_0
    //   356: getfield k : Z
    //   359: istore_2
    //   360: aload_0
    //   361: monitorexit
    //   362: iload_2
    //   363: ireturn
    //   364: astore_1
    //   365: aload_0
    //   366: monitorexit
    //   367: aload_1
    //   368: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	364	finally
    //   27	76	364	finally
    //   80	336	364	finally
    //   347	360	364	finally
  }
  
  public void setOnAudioMixListener(OnAudioMixListener paramOnAudioMixListener) {
    this.p = paramOnAudioMixListener;
    this.a.a(paramOnAudioMixListener);
  }
  
  public void setVolume(float paramFloat1, float paramFloat2) {
    this.n = paramFloat1;
    this.o = paramFloat2;
  }
  
  public boolean stop() {
    if (pause()) {
      this.a.a(0L);
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\microphone\AudioMixer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */