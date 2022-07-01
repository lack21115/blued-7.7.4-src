package com.blued.android.module.external_sense_library.encoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class MediaMuxerWrapper {
  private static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.US);
  
  private final MediaMuxer b;
  
  private int c;
  
  private int d;
  
  private boolean e;
  
  int a(MediaFormat paramMediaFormat) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield e : Z
    //   6: ifne -> 22
    //   9: aload_0
    //   10: getfield b : Landroid/media/MediaMuxer;
    //   13: aload_1
    //   14: invokevirtual addTrack : (Landroid/media/MediaFormat;)I
    //   17: istore_2
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_2
    //   21: ireturn
    //   22: new java/lang/IllegalStateException
    //   25: dup
    //   26: ldc 'muxer already started'
    //   28: invokespecial <init> : (Ljava/lang/String;)V
    //   31: athrow
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	32	finally
    //   22	32	32	finally
  }
  
  void a(int paramInt, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : I
    //   6: ifle -> 19
    //   9: aload_0
    //   10: getfield b : Landroid/media/MediaMuxer;
    //   13: iload_1
    //   14: aload_2
    //   15: aload_3
    //   16: invokevirtual writeSampleData : (ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	22	finally
  }
  
  public boolean a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield e : Z
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  boolean b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield d : I
    //   7: iconst_1
    //   8: iadd
    //   9: putfield d : I
    //   12: aload_0
    //   13: getfield c : I
    //   16: ifle -> 46
    //   19: aload_0
    //   20: getfield d : I
    //   23: aload_0
    //   24: getfield c : I
    //   27: if_icmpne -> 46
    //   30: aload_0
    //   31: getfield b : Landroid/media/MediaMuxer;
    //   34: invokevirtual start : ()V
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield e : Z
    //   42: aload_0
    //   43: invokevirtual notifyAll : ()V
    //   46: aload_0
    //   47: getfield e : Z
    //   50: istore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: iload_1
    //   54: ireturn
    //   55: astore_2
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    // Exception table:
    //   from	to	target	type
    //   2	46	55	finally
    //   46	51	55	finally
  }
  
  void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield d : I
    //   7: iconst_1
    //   8: isub
    //   9: putfield d : I
    //   12: aload_0
    //   13: getfield c : I
    //   16: ifle -> 45
    //   19: aload_0
    //   20: getfield d : I
    //   23: ifgt -> 45
    //   26: aload_0
    //   27: getfield b : Landroid/media/MediaMuxer;
    //   30: invokevirtual stop : ()V
    //   33: aload_0
    //   34: getfield b : Landroid/media/MediaMuxer;
    //   37: invokevirtual release : ()V
    //   40: aload_0
    //   41: iconst_0
    //   42: putfield e : Z
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Exception table:
    //   from	to	target	type
    //   2	45	48	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\encoder\MediaMuxerWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */