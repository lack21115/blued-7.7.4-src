package com.qiniu.pili.droid.streaming.av.encoder;

import a.a.a.a.a.a.f.a;
import a.a.a.a.a.a.g.a;
import a.a.a.a.a.a.j.f;
import a.a.a.a.a.e.e;
import com.qiniu.pili.droid.streaming.SharedLibraryNameHelper;
import com.qiniu.pili.droid.streaming.StreamingProfile;
import com.qiniu.pili.droid.streaming.WatermarkSetting;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import com.qiniu.pili.droid.streaming.av.common.PLBufferInfo;
import com.qiniu.pili.droid.streaming.av.common.PLFourCC;
import com.qiniu.pili.droid.streaming.processing.image.ImageProcessor;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;

public class PLH264Encoder {
  public static final boolean i = SharedLibraryNameHelper.getInstance().c();
  
  public ArrayDeque<PLAVFrame> a = new ArrayDeque<PLAVFrame>();
  
  public final Object b = new Object();
  
  public volatile int c = 0;
  
  public boolean d = false;
  
  public a e = new a(2);
  
  public a f;
  
  public ByteBuffer g;
  
  public ImageProcessor h;
  
  private void doSPSAndPPSCallback(PLAVFrame paramPLAVFrame) {
    e e = e.i;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("doSPSAndPPSCallback size:");
    stringBuilder.append(paramPLAVFrame.mSize);
    stringBuilder.append(",encodedBuffer:");
    stringBuilder.append(paramPLAVFrame.mBuffer);
    e.c("PLH264Encoder", stringBuilder.toString());
    PLBufferInfo pLBufferInfo = new PLBufferInfo();
    int i = pLBufferInfo.flags | 0x2;
    pLBufferInfo.flags = i;
    int j = paramPLAVFrame.mSize;
    long l = paramPLAVFrame.mPresentationTimeUs / 1000L;
    pLBufferInfo.set(0, j, l, l, i);
    pLBufferInfo.isNeedAddHeader = false;
    paramPLAVFrame.mBuffer.position(0);
    paramPLAVFrame.mBuffer.limit(paramPLAVFrame.mSize);
    a a1 = this.f;
    if (a1 != null)
      a1.a(paramPLAVFrame, pLBufferInfo); 
    e.i.c("PLH264Encoder", "doSPSAndPPSCallback -");
  }
  
  private void encodeCallback(PLAVFrame paramPLAVFrame, int paramInt) {
    if (paramPLAVFrame == null) {
      e e = e.i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("encodedFrame:");
      stringBuilder.append(paramPLAVFrame);
      e.d("PLH264Encoder", stringBuilder.toString());
      return;
    } 
    e e2 = e.i;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("encodeCallback + size:");
    stringBuilder2.append(paramPLAVFrame.mSize);
    stringBuilder2.append(",frameType:");
    stringBuilder2.append(paramInt);
    stringBuilder2.append(",ts:");
    stringBuilder2.append(paramPLAVFrame.mPresentationTimeUs);
    e2.a("PLH264Encoder", stringBuilder2.toString());
    long l = System.currentTimeMillis();
    PLBufferInfo pLBufferInfo = new PLBufferInfo();
    if (paramInt == 1 || paramInt == 2) {
      pLBufferInfo.flags |= 0x1;
    } else {
      pLBufferInfo.flags |= 0x8;
    } 
    pLBufferInfo.set(0, paramPLAVFrame.mSize, paramPLAVFrame.mPresentationTimeUs / 1000L, paramPLAVFrame.mDtsUs / 1000L, pLBufferInfo.flags);
    pLBufferInfo.isNeedAddHeader = false;
    paramPLAVFrame.mBuffer.position(0);
    paramPLAVFrame.mBuffer.limit(paramPLAVFrame.mSize);
    e e3 = e.i;
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("encodeCallback buffer:");
    stringBuilder3.append(paramPLAVFrame.mBuffer);
    e3.a("PLH264Encoder", stringBuilder3.toString());
    a a1 = this.f;
    if (a1 != null)
      a1.a(paramPLAVFrame, pLBufferInfo); 
    e e1 = e.i;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("encodeCallback - cost:");
    stringBuilder1.append(System.currentTimeMillis() - l);
    e1.a("PLH264Encoder", stringBuilder1.toString());
  }
  
  private PLAVFrame getOutputFrame(int paramInt) {
    e e1 = e.i;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("getOutputFrame + reqSize:");
    stringBuilder1.append(paramInt);
    e1.a("PLH264Encoder", stringBuilder1.toString());
    PLAVFrame pLAVFrame = this.e.a(paramInt);
    pLAVFrame.mBuffer.clear();
    e e2 = e.i;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("getOutputFrame - ,mBuffer:");
    stringBuilder2.append(pLAVFrame.mBuffer);
    e2.a("PLH264Encoder", stringBuilder2.toString());
    return pLAVFrame;
  }
  
  public static native void getPixelFromPBO(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  public int a() {
    this.e.a();
    this.d = false;
    this.h.a();
    release();
    synchronized (this.b) {
      this.a.clear();
      return 0;
    } 
  }
  
  public int a(int paramInt) {
    return reconfig(paramInt);
  }
  
  public void a(a parama) {
    this.f = parama;
  }
  
  public void a(WatermarkSetting paramWatermarkSetting) {
    ImageProcessor imageProcessor = this.h;
    if (imageProcessor != null)
      imageProcessor.updateWatermarkSetting(paramWatermarkSetting); 
  }
  
  public void a(PLAVFrame paramPLAVFrame) {
    synchronized (this.b) {
      this.a.add(paramPLAVFrame);
      return;
    } 
  }
  
  public void a(PLAVFrame paramPLAVFrame, f.a parama, boolean paramBoolean) {
    if (!this.d) {
      e.i.d("PLH264Encoder", "encodeFrame not ready");
      return;
    } 
    ByteBuffer byteBuffer = this.g;
    if (byteBuffer == null || byteBuffer.capacity() < paramPLAVFrame.mSize)
      this.g = ByteBuffer.allocateDirect(paramPLAVFrame.mSize); 
    this.g.clear();
    this.h.a(parama.n);
    int i = this.h.convertYUV(paramPLAVFrame.mBuffer, paramPLAVFrame.mSize, this.g, parama.m);
    i = encode(this.g, i, paramPLAVFrame.mPresentationTimeUs, paramBoolean, parama.m);
    if (i < 0) {
      e e = e.i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("encodeFrame ret=");
      stringBuilder.append(i);
      e.a("PLH264Encoder", stringBuilder.toString());
    } 
    a(paramPLAVFrame);
  }
  
  public void a(Parameters paramParameters) {
    int i = paramParameters.srcSize;
    e e2 = e.i;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("isLoggingEnabled:");
    stringBuilder.append(paramParameters.isLoggingEnabled);
    e2.c("PLH264Encoder", stringBuilder.toString());
    ImageProcessor imageProcessor = new ImageProcessor();
    this.h = imageProcessor;
    imageProcessor.initYUVProcessor(paramParameters.wmSetting, false, paramParameters.srcWidth, paramParameters.srcHeight, paramParameters.cropX, paramParameters.cropY, paramParameters.imageWidth, paramParameters.imageHeight, paramParameters.destWidth, paramParameters.destHeight, paramParameters.rotation, paramParameters.srcFormat, PLFourCC.FOURCC_I420, paramParameters.needEncodingFlip);
    initialize(paramParameters);
    i = paramParameters.destWidth * paramParameters.destHeight * 2;
    e e1 = e.i;
    stringBuilder = new StringBuilder();
    stringBuilder.append("dest size = ");
    stringBuilder.append(i);
    stringBuilder.append(", w = ");
    stringBuilder.append(paramParameters.destWidth);
    stringBuilder.append(", h = ");
    stringBuilder.append(paramParameters.destHeight);
    e1.c("PLH264Encoder", stringBuilder.toString());
    this.g = ByteBuffer.allocateDirect(i);
    this.d = true;
    this.c = 0;
  }
  
  public PLAVFrame b(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Ljava/lang/Object;
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
    //   43: ldc 'PLH264Encoder'
    //   45: aload #5
    //   47: invokevirtual toString : ()Ljava/lang/String;
    //   50: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload #4
    //   55: monitorexit
    //   56: aconst_null
    //   57: areturn
    //   58: aload_0
    //   59: getfield a : Ljava/util/ArrayDeque;
    //   62: invokevirtual isEmpty : ()Z
    //   65: ifne -> 148
    //   68: aload_0
    //   69: getfield a : Ljava/util/ArrayDeque;
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
    //   138: ldc 'PLH264Encoder'
    //   140: aload #6
    //   142: invokevirtual toString : ()Ljava/lang/String;
    //   145: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload_0
    //   149: getfield c : I
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
    //   174: getfield c : I
    //   177: iconst_1
    //   178: iadd
    //   179: putfield c : I
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
    //   208: getfield c : I
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
    //   236: ldc 'PLH264Encoder'
    //   238: aload #6
    //   240: invokevirtual toString : ()Ljava/lang/String;
    //   243: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   246: goto -> 262
    //   249: aconst_null
    //   250: astore_3
    //   251: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   254: ldc 'PLH264Encoder'
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
  
  public void b() {}
  
  public void b(PLAVFrame paramPLAVFrame) {
    paramPLAVFrame.mBuffer.clear();
    this.e.a(paramPLAVFrame);
  }
  
  public void c(PLAVFrame paramPLAVFrame) {
    b(paramPLAVFrame);
  }
  
  public native int encode(ByteBuffer paramByteBuffer, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2);
  
  public final native void initialize(Parameters paramParameters);
  
  public final native int reconfig(int paramInt);
  
  public native void release();
  
  public static class Parameters {
    public boolean adaptiveBitrateEnable;
    
    public int bitrate;
    
    public int cpuWorkload;
    
    public int cropX;
    
    public int cropY;
    
    public int destHeight;
    
    public int destWidth;
    
    public int fps;
    
    public int h264Profile;
    
    public int imageHeight;
    
    public int imageWidth;
    
    public boolean isLoggingEnabled = e.a();
    
    public int maxKeyFrameInterval;
    
    public int mode;
    
    public boolean needEncodingFlip;
    
    public int rotation;
    
    public int srcFormat;
    
    public int srcHeight;
    
    public int srcSize;
    
    public int srcWidth;
    
    public WatermarkSetting wmSetting;
    
    public Parameters(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int param1Int6, int param1Int7, int param1Int8, int param1Int9, int param1Int10, int param1Int11, int param1Int12, boolean param1Boolean1, int param1Int13, int param1Int14, StreamingProfile.EncoderRCModes param1EncoderRCModes, StreamingProfile.a param1a, StreamingProfile.H264Profile param1H264Profile, WatermarkSetting param1WatermarkSetting, boolean param1Boolean2) {
      this.srcSize = param1Int3;
      this.srcWidth = param1Int1;
      this.srcHeight = param1Int2;
      this.cropX = param1Int4;
      this.cropY = param1Int5;
      this.imageWidth = param1Int6;
      this.imageHeight = param1Int7;
      this.destWidth = param1Int8;
      this.destHeight = param1Int9;
      this.fps = param1Int10;
      this.bitrate = param1Int11;
      this.needEncodingFlip = param1Boolean1;
      this.rotation = param1Int13;
      this.maxKeyFrameInterval = param1Int12;
      this.srcFormat = param1Int14;
      if (param1EncoderRCModes == StreamingProfile.EncoderRCModes.QUALITY_PRIORITY) {
        this.mode = 0;
      } else if (param1EncoderRCModes == StreamingProfile.EncoderRCModes.BITRATE_PRIORITY) {
        this.mode = 1;
      } else {
        this.mode = 0;
      } 
      this.adaptiveBitrateEnable = param1Boolean2;
      e e = e.i;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("cpuWorkload ");
      stringBuilder2.append(param1a);
      e.c("PLH264Encoder", stringBuilder2.toString());
      if (param1a == StreamingProfile.a.a) {
        this.cpuWorkload = 0;
      } else if (param1a == StreamingProfile.a.b) {
        this.cpuWorkload = 1;
      } else if (param1a == StreamingProfile.a.c) {
        this.cpuWorkload = 2;
      } else {
        this.cpuWorkload = 1;
      } 
      e = e.i;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("h264Profile ");
      stringBuilder1.append(param1H264Profile);
      e.c("PLH264Encoder", stringBuilder1.toString());
      if (param1H264Profile == StreamingProfile.H264Profile.BASELINE) {
        this.h264Profile = 0;
      } else if (param1H264Profile == StreamingProfile.H264Profile.MAIN) {
        this.h264Profile = 1;
      } else if (param1H264Profile == StreamingProfile.H264Profile.HIGH) {
        this.h264Profile = 2;
      } else {
        this.h264Profile = 0;
      } 
      this.wmSetting = param1WatermarkSetting;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\av\encoder\PLH264Encoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */