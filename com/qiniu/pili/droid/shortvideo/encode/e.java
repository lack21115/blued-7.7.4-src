package com.qiniu.pili.droid.shortvideo.encode;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.f.g;
import java.nio.ByteBuffer;

public class e extends d implements a.a {
  private PLVideoEncodeSetting g;
  
  private a.a h;
  
  public e(PLVideoEncodeSetting paramPLVideoEncodeSetting) {
    this.g = paramPLVideoEncodeSetting;
    super.a(this);
  }
  
  public void a(MediaFormat paramMediaFormat) {
    a.a a1 = this.h;
    if (a1 != null)
      a1.a(paramMediaFormat); 
  }
  
  public void a(Surface paramSurface) {
    a.a a1 = this.h;
    if (a1 != null)
      a1.a(paramSurface); 
  }
  
  public void a(a.a parama) {
    this.h = parama;
  }
  
  public void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo) {
    a.a a1 = this.h;
    if (a1 != null)
      a1.a(paramByteBuffer, paramBufferInfo); 
  }
  
  public void a(boolean paramBoolean) {
    a.a a1 = this.h;
    if (a1 != null)
      a1.a(paramBoolean); 
  }
  
  public boolean a(long paramLong) {
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
    //   49: lload_1
    //   50: invokevirtual b : (J)J
    //   53: lstore_1
    //   54: lload_1
    //   55: lconst_0
    //   56: lcmp
    //   57: ifge -> 64
    //   60: aload_0
    //   61: monitorexit
    //   62: iconst_0
    //   63: ireturn
    //   64: aload_0
    //   65: invokevirtual d : ()V
    //   68: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   71: astore_3
    //   72: aload_0
    //   73: invokevirtual j : ()Ljava/lang/String;
    //   76: astore #4
    //   78: new java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial <init> : ()V
    //   85: astore #5
    //   87: aload #5
    //   89: ldc 'input frame: '
    //   91: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload #5
    //   97: aload_0
    //   98: getfield b : I
    //   101: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload #5
    //   107: ldc ' timestampNs:'
    //   109: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload #5
    //   115: lload_1
    //   116: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_3
    //   121: aload #4
    //   123: aload #5
    //   125: invokevirtual toString : ()Ljava/lang/String;
    //   128: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload_0
    //   132: monitorexit
    //   133: iconst_1
    //   134: ireturn
    //   135: astore_3
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_3
    //   139: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	135	finally
    //   25	44	135	finally
    //   48	54	135	finally
    //   64	131	135	finally
  }
  
  public void b(boolean paramBoolean) {
    a.a a1 = this.h;
    if (a1 != null)
      a1.b(paramBoolean); 
  }
  
  protected MediaFormat g() {
    double d1;
    MediaFormat mediaFormat = MediaFormat.createVideoFormat("video/avc", this.g.getVideoEncodingWidth(), this.g.getVideoEncodingHeight());
    int i = Math.round(this.g.getIFrameInterval() * 1.0F / this.g.getVideoEncodingFps());
    mediaFormat.setInteger("color-format", 2130708361);
    double d3 = this.g.getEncodingBitrate();
    boolean bool = this.g.IsConstFrameRateEnabled();
    double d2 = 1.0D;
    if (bool) {
      d1 = 1.0D;
    } else {
      d1 = this.a;
    } 
    mediaFormat.setInteger("bitrate", (int)(d3 * d1));
    d3 = this.g.getVideoEncodingFps();
    if (this.g.IsConstFrameRateEnabled()) {
      d1 = d2;
    } else {
      d1 = this.a;
    } 
    mediaFormat.setInteger("frame-rate", (int)(d3 * d1));
    mediaFormat.setInteger("i-frame-interval", i);
    mediaFormat.setInteger("profile", g.a(this.g.getProfileMode()));
    i = 1;
    mediaFormat.setInteger("level", 1);
    if (this.g.getBitrateMode() == PLVideoEncodeSetting.BitrateMode.BITRATE_PRIORITY) {
      i = 2;
    } else if (this.g.getBitrateMode() == PLVideoEncodeSetting.BitrateMode.CONSTANT_QUALITY_PRIORITY) {
      i = 0;
    } 
    mediaFormat.setInteger("bitrate-mode", i);
    return mediaFormat;
  }
  
  protected String h() {
    return "video/avc";
  }
  
  protected d.a i() {
    return d.a.a;
  }
  
  public String j() {
    return "HWVideoEncoder";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\encode\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */