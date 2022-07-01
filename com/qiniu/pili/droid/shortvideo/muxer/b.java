package com.qiniu.pili.droid.shortvideo.muxer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import java.nio.ByteBuffer;

public class b {
  private c a = new FFMP4Muxer();
  
  public void a(int paramInt, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Lcom/qiniu/pili/droid/shortvideo/muxer/c;
    //   6: iload_1
    //   7: aload_2
    //   8: aload_3
    //   9: invokevirtual a : (ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: astore_2
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_2
    //   19: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	15	finally
  }
  
  public void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo) {
    a(b(), paramByteBuffer, paramBufferInfo);
  }
  
  public boolean a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Lcom/qiniu/pili/droid/shortvideo/muxer/c;
    //   6: invokevirtual a : ()Z
    //   9: istore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_1
    //   13: ireturn
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public boolean a(String paramString, MediaFormat paramMediaFormat1, MediaFormat paramMediaFormat2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: aload_2
    //   5: aload_3
    //   6: iconst_0
    //   7: invokevirtual a : (Ljava/lang/String;Landroid/media/MediaFormat;Landroid/media/MediaFormat;I)Z
    //   10: istore #4
    //   12: aload_0
    //   13: monitorexit
    //   14: iload #4
    //   16: ireturn
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	17	finally
  }
  
  public boolean a(String paramString, MediaFormat paramMediaFormat1, MediaFormat paramMediaFormat2, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Lcom/qiniu/pili/droid/shortvideo/muxer/c;
    //   6: aload_1
    //   7: aload_2
    //   8: aload_3
    //   9: iload #4
    //   11: invokevirtual a : (Ljava/lang/String;Landroid/media/MediaFormat;Landroid/media/MediaFormat;I)Z
    //   14: istore #5
    //   16: iload #5
    //   18: ifne -> 69
    //   21: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   24: ldc 'MP4Muxer'
    //   26: ldc 'MP4Muxer start failed, will switch to System Muxer'
    //   28: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_0
    //   32: getfield a : Lcom/qiniu/pili/droid/shortvideo/muxer/c;
    //   35: invokevirtual a : ()Z
    //   38: pop
    //   39: aload_0
    //   40: new com/qiniu/pili/droid/shortvideo/muxer/a
    //   43: dup
    //   44: invokespecial <init> : ()V
    //   47: putfield a : Lcom/qiniu/pili/droid/shortvideo/muxer/c;
    //   50: aload_0
    //   51: getfield a : Lcom/qiniu/pili/droid/shortvideo/muxer/c;
    //   54: aload_1
    //   55: aload_2
    //   56: aload_3
    //   57: iload #4
    //   59: invokevirtual a : (Ljava/lang/String;Landroid/media/MediaFormat;Landroid/media/MediaFormat;I)Z
    //   62: istore #5
    //   64: aload_0
    //   65: monitorexit
    //   66: iload #5
    //   68: ireturn
    //   69: aload_0
    //   70: monitorexit
    //   71: iload #5
    //   73: ireturn
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	74	finally
    //   21	64	74	finally
  }
  
  public int b() {
    return this.a.b();
  }
  
  public void b(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo) {
    a(c(), paramByteBuffer, paramBufferInfo);
  }
  
  public int c() {
    return this.a.c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\muxer\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */