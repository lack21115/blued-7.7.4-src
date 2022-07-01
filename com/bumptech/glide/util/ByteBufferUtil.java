package com.bumptech.glide.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

public final class ByteBufferUtil {
  private static final AtomicReference<byte[]> a = (AtomicReference)new AtomicReference<byte>();
  
  public static ByteBuffer a(File paramFile) throws IOException {
    RandomAccessFile randomAccessFile;
    IOException iOException;
    MappedByteBuffer mappedByteBuffer = null;
    try {
      long l = paramFile.length();
    } finally {
      paramFile = null;
    } 
    if (iOException != null)
      try {
        iOException.close();
      } catch (IOException iOException1) {} 
    if (randomAccessFile != null)
      try {
        randomAccessFile.close();
      } catch (IOException iOException1) {} 
    throw paramFile;
  }
  
  public static ByteBuffer a(InputStream paramInputStream) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
    byte[] arrayOfByte2 = a.getAndSet(null);
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
      arrayOfByte1 = new byte[16384]; 
    while (true) {
      int i = paramInputStream.read(arrayOfByte1);
      if (i >= 0) {
        byteArrayOutputStream.write(arrayOfByte1, 0, i);
        continue;
      } 
      a.set(arrayOfByte1);
      byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
      return (ByteBuffer)ByteBuffer.allocateDirect(arrayOfByte.length).put(arrayOfByte).position(0);
    } 
  }
  
  public static void a(ByteBuffer paramByteBuffer, File paramFile) throws IOException {
    paramByteBuffer.position(0);
    FileChannel fileChannel = null;
    File file = null;
    try {
      RandomAccessFile randomAccessFile = new RandomAccessFile(paramFile, "rw");
      paramFile = file;
    } finally {
      paramByteBuffer = null;
    } 
    if (fileChannel != null)
      try {
        fileChannel.close();
      } catch (IOException iOException) {} 
    if (paramFile != null)
      try {
        paramFile.close();
      } catch (IOException iOException) {} 
    throw paramByteBuffer;
  }
  
  public static byte[] a(ByteBuffer paramByteBuffer) {
    SafeArray safeArray = c(paramByteBuffer);
    if (safeArray != null && safeArray.a == 0 && safeArray.b == safeArray.c.length)
      return paramByteBuffer.array(); 
    paramByteBuffer = paramByteBuffer.asReadOnlyBuffer();
    byte[] arrayOfByte = new byte[paramByteBuffer.limit()];
    paramByteBuffer.position(0);
    paramByteBuffer.get(arrayOfByte);
    return arrayOfByte;
  }
  
  public static InputStream b(ByteBuffer paramByteBuffer) {
    return new ByteBufferStream(paramByteBuffer);
  }
  
  private static SafeArray c(ByteBuffer paramByteBuffer) {
    return (!paramByteBuffer.isReadOnly() && paramByteBuffer.hasArray()) ? new SafeArray(paramByteBuffer.array(), paramByteBuffer.arrayOffset(), paramByteBuffer.limit()) : null;
  }
  
  static class ByteBufferStream extends InputStream {
    private final ByteBuffer a;
    
    private int b = -1;
    
    ByteBufferStream(ByteBuffer param1ByteBuffer) {
      this.a = param1ByteBuffer;
    }
    
    public int available() {
      return this.a.remaining();
    }
    
    public void mark(int param1Int) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: aload_0
      //   4: getfield a : Ljava/nio/ByteBuffer;
      //   7: invokevirtual position : ()I
      //   10: putfield b : I
      //   13: aload_0
      //   14: monitorexit
      //   15: return
      //   16: astore_2
      //   17: aload_0
      //   18: monitorexit
      //   19: aload_2
      //   20: athrow
      // Exception table:
      //   from	to	target	type
      //   2	13	16	finally
    }
    
    public boolean markSupported() {
      return true;
    }
    
    public int read() {
      return !this.a.hasRemaining() ? -1 : (this.a.get() & 0xFF);
    }
    
    public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      if (!this.a.hasRemaining())
        return -1; 
      param1Int2 = Math.min(param1Int2, available());
      this.a.get(param1ArrayOfbyte, param1Int1, param1Int2);
      return param1Int2;
    }
    
    public void reset() throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield b : I
      //   6: iconst_m1
      //   7: if_icmpeq -> 25
      //   10: aload_0
      //   11: getfield a : Ljava/nio/ByteBuffer;
      //   14: aload_0
      //   15: getfield b : I
      //   18: invokevirtual position : (I)Ljava/nio/Buffer;
      //   21: pop
      //   22: aload_0
      //   23: monitorexit
      //   24: return
      //   25: new java/io/IOException
      //   28: dup
      //   29: ldc 'Cannot reset to unset mark position'
      //   31: invokespecial <init> : (Ljava/lang/String;)V
      //   34: athrow
      //   35: astore_1
      //   36: aload_0
      //   37: monitorexit
      //   38: aload_1
      //   39: athrow
      // Exception table:
      //   from	to	target	type
      //   2	22	35	finally
      //   25	35	35	finally
    }
    
    public long skip(long param1Long) throws IOException {
      if (!this.a.hasRemaining())
        return -1L; 
      param1Long = Math.min(param1Long, available());
      ByteBuffer byteBuffer = this.a;
      byteBuffer.position((int)(byteBuffer.position() + param1Long));
      return param1Long;
    }
  }
  
  static final class SafeArray {
    final int a;
    
    final int b;
    
    final byte[] c;
    
    SafeArray(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      this.c = param1ArrayOfbyte;
      this.a = param1Int1;
      this.b = param1Int2;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glid\\util\ByteBufferUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */