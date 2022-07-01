package com.google.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

final class ByteBufferWriter {
  private static final ThreadLocal<SoftReference<byte[]>> BUFFER = new ThreadLocal<SoftReference<byte[]>>();
  
  private static final float BUFFER_REALLOCATION_THRESHOLD = 0.5F;
  
  private static final long CHANNEL_FIELD_OFFSET;
  
  private static final Class<?> FILE_OUTPUT_STREAM_CLASS = safeGetClass("java.io.FileOutputStream");
  
  private static final int MAX_CACHED_BUFFER_SIZE = 16384;
  
  private static final int MIN_CACHED_BUFFER_SIZE = 1024;
  
  static {
    CHANNEL_FIELD_OFFSET = getChannelFieldOffset(FILE_OUTPUT_STREAM_CLASS);
  }
  
  static void clearCachedBuffer() {
    BUFFER.set(null);
  }
  
  private static byte[] getBuffer() {
    SoftReference<byte[]> softReference = BUFFER.get();
    return (softReference == null) ? null : softReference.get();
  }
  
  private static long getChannelFieldOffset(Class<?> paramClass) {
    if (paramClass != null)
      try {
        if (UnsafeUtil.hasUnsafeArrayOperations())
          return UnsafeUtil.objectFieldOffset(paramClass.getDeclaredField("channel")); 
      } finally {} 
    return -1L;
  }
  
  private static byte[] getOrCreateBuffer(int paramInt) {
    // Byte code:
    //   0: iload_0
    //   1: sipush #1024
    //   4: invokestatic max : (II)I
    //   7: istore_0
    //   8: invokestatic getBuffer : ()[B
    //   11: astore_2
    //   12: aload_2
    //   13: ifnull -> 27
    //   16: aload_2
    //   17: astore_1
    //   18: iload_0
    //   19: aload_2
    //   20: arraylength
    //   21: invokestatic needToReallocate : (II)Z
    //   24: ifeq -> 46
    //   27: iload_0
    //   28: newarray byte
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: iload_0
    //   34: sipush #16384
    //   37: if_icmpgt -> 46
    //   40: aload_2
    //   41: invokestatic setBuffer : ([B)V
    //   44: aload_2
    //   45: astore_1
    //   46: aload_1
    //   47: areturn
  }
  
  private static boolean needToReallocate(int paramInt1, int paramInt2) {
    return (paramInt2 < paramInt1 && paramInt2 < paramInt1 * 0.5F);
  }
  
  private static Class<?> safeGetClass(String paramString) {
    try {
      return Class.forName(paramString);
    } catch (ClassNotFoundException classNotFoundException) {
      return null;
    } 
  }
  
  private static void setBuffer(byte[] paramArrayOfbyte) {
    BUFFER.set((SoftReference)new SoftReference<byte>(paramArrayOfbyte));
  }
  
  static void write(ByteBuffer paramByteBuffer, OutputStream paramOutputStream) throws IOException {
    int i = paramByteBuffer.position();
    try {
      if (paramByteBuffer.hasArray()) {
        paramOutputStream.write(paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining());
      } else if (!writeToChannel(paramByteBuffer, paramOutputStream)) {
        byte[] arrayOfByte = getOrCreateBuffer(paramByteBuffer.remaining());
        while (paramByteBuffer.hasRemaining()) {
          int j = Math.min(paramByteBuffer.remaining(), arrayOfByte.length);
          paramByteBuffer.get(arrayOfByte, 0, j);
          paramOutputStream.write(arrayOfByte, 0, j);
        } 
      } 
      return;
    } finally {
      paramByteBuffer.position(i);
    } 
  }
  
  private static boolean writeToChannel(ByteBuffer paramByteBuffer, OutputStream paramOutputStream) throws IOException {
    if (CHANNEL_FIELD_OFFSET >= 0L && FILE_OUTPUT_STREAM_CLASS.isInstance(paramOutputStream)) {
      try {
        WritableByteChannel writableByteChannel = (WritableByteChannel)UnsafeUtil.getObject(paramOutputStream, CHANNEL_FIELD_OFFSET);
      } catch (ClassCastException classCastException) {
        classCastException = null;
      } 
      if (classCastException != null) {
        classCastException.write(paramByteBuffer);
        return true;
      } 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\ByteBufferWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */