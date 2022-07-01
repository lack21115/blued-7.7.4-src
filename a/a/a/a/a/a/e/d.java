package a.a.a.a.a.a.e;

import a.a.a.a.a.a.i.c;
import a.a.a.a.a.e.e;
import android.media.MediaCodec;
import java.nio.ByteBuffer;

public class d extends c {
  public MediaCodec a = null;
  
  public volatile b b;
  
  public void a() {
    if (this.b != null) {
      this.b.a();
      this.b.a(true);
      this.b.b();
    } 
  }
  
  public void a(c paramc) {
    e.f.c("MicrophoneTransfer", "startRecording");
    this.b = new b(paramc);
    this.a = this.b.c();
  }
  
  public void a(ByteBuffer paramByteBuffer, int paramInt, long paramLong, boolean paramBoolean) {
    a(paramByteBuffer, paramInt, null, paramLong, paramBoolean);
  }
  
  public final void a(ByteBuffer paramByteBuffer, int paramInt, byte[] paramArrayOfbyte, long paramLong, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : La/a/a/a/a/a/e/b;
    //   4: ifnonnull -> 8
    //   7: return
    //   8: iload #6
    //   10: ifne -> 22
    //   13: aload_0
    //   14: getfield b : La/a/a/a/a/a/e/b;
    //   17: iload #6
    //   19: invokevirtual a : (Z)V
    //   22: aload_0
    //   23: getfield a : Landroid/media/MediaCodec;
    //   26: invokevirtual getInputBuffers : ()[Ljava/nio/ByteBuffer;
    //   29: astore #8
    //   31: aload_0
    //   32: getfield a : Landroid/media/MediaCodec;
    //   35: ldc2_w -1
    //   38: invokevirtual dequeueInputBuffer : (J)I
    //   41: istore #7
    //   43: iload #7
    //   45: iflt -> 171
    //   48: aload #8
    //   50: iload #7
    //   52: aaload
    //   53: astore #8
    //   55: aload #8
    //   57: invokevirtual clear : ()Ljava/nio/Buffer;
    //   60: pop
    //   61: aload_1
    //   62: ifnull -> 87
    //   65: aload_1
    //   66: iconst_0
    //   67: invokevirtual position : (I)Ljava/nio/Buffer;
    //   70: pop
    //   71: aload_1
    //   72: iload_2
    //   73: invokevirtual limit : (I)Ljava/nio/Buffer;
    //   76: pop
    //   77: aload #8
    //   79: aload_1
    //   80: invokevirtual put : (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   83: pop
    //   84: goto -> 101
    //   87: aload_3
    //   88: ifnull -> 146
    //   91: aload #8
    //   93: aload_3
    //   94: invokevirtual put : ([B)Ljava/nio/ByteBuffer;
    //   97: pop
    //   98: aload_3
    //   99: arraylength
    //   100: istore_2
    //   101: iload #6
    //   103: ifeq -> 131
    //   106: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   109: ldc 'MicrophoneTransfer'
    //   111: ldc 'EOS received in sendAudioToEncoder'
    //   113: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_0
    //   117: getfield a : Landroid/media/MediaCodec;
    //   120: iload #7
    //   122: iconst_0
    //   123: iload_2
    //   124: lload #4
    //   126: iconst_4
    //   127: invokevirtual queueInputBuffer : (IIIJI)V
    //   130: return
    //   131: aload_0
    //   132: getfield a : Landroid/media/MediaCodec;
    //   135: iload #7
    //   137: iconst_0
    //   138: iload_2
    //   139: lload #4
    //   141: iconst_0
    //   142: invokevirtual queueInputBuffer : (IIIJI)V
    //   145: return
    //   146: new java/lang/IllegalStateException
    //   149: dup
    //   150: ldc 'Illegal buffer state.'
    //   152: invokespecial <init> : (Ljava/lang/String;)V
    //   155: athrow
    //   156: astore_1
    //   157: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   160: ldc 'MicrophoneTransfer'
    //   162: ldc '_offerAudioEncoder exception'
    //   164: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   167: aload_1
    //   168: invokevirtual printStackTrace : ()V
    //   171: return
    // Exception table:
    //   from	to	target	type
    //   13	22	156	finally
    //   22	43	156	finally
    //   55	61	156	finally
    //   65	84	156	finally
    //   91	101	156	finally
    //   106	130	156	finally
    //   131	145	156	finally
    //   146	156	156	finally
  }
  
  public void a(byte[] paramArrayOfbyte, long paramLong, boolean paramBoolean) {
    a(null, 0, paramArrayOfbyte, paramLong, paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */