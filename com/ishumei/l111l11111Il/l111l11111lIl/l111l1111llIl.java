package com.ishumei.l111l11111Il.l111l11111lIl;

import android.util.Pair;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class l111l1111llIl {
  private static final int l1111l111111Il = 22;
  
  private static final int l111l11111I1l = 12;
  
  private static final int l111l11111Il = 16;
  
  private static final int l111l11111lIl = 101010256;
  
  private static final int l111l1111l1Il = 20;
  
  private static final int l111l1111lI1l = 1347094023;
  
  private static final int l111l1111lIl = 65535;
  
  private static final int l111l1111llIl = 20;
  
  public static long l1111l111111Il(ByteBuffer paramByteBuffer) {
    l111l11111Il(paramByteBuffer);
    return l1111l111111Il(paramByteBuffer, paramByteBuffer.position() + 16);
  }
  
  private static long l1111l111111Il(ByteBuffer paramByteBuffer, int paramInt) {
    return paramByteBuffer.getInt(paramInt) & 0xFFFFFFFFL;
  }
  
  static Pair<ByteBuffer, Long> l1111l111111Il(RandomAccessFile paramRandomAccessFile) {
    if (paramRandomAccessFile.length() < 22L)
      return null; 
    Pair<ByteBuffer, Long> pair = l1111l111111Il(paramRandomAccessFile, 0);
    return (pair != null) ? pair : l1111l111111Il(paramRandomAccessFile, 65535);
  }
  
  private static Pair<ByteBuffer, Long> l1111l111111Il(RandomAccessFile paramRandomAccessFile, int paramInt) {
    if (paramInt >= 0 && paramInt <= 65535) {
      long l = paramRandomAccessFile.length();
      if (l < 22L)
        return null; 
      ByteBuffer byteBuffer2 = ByteBuffer.allocate((int)Math.min(paramInt, l - 22L) + 22);
      byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
      l -= byteBuffer2.capacity();
      paramRandomAccessFile.seek(l);
      paramRandomAccessFile.readFully(byteBuffer2.array(), byteBuffer2.arrayOffset(), byteBuffer2.capacity());
      paramInt = l111l11111I1l(byteBuffer2);
      if (paramInt == -1)
        return null; 
      byteBuffer2.position(paramInt);
      ByteBuffer byteBuffer1 = byteBuffer2.slice();
      byteBuffer1.order(ByteOrder.LITTLE_ENDIAN);
      return Pair.create(byteBuffer1, Long.valueOf(l + paramInt));
    } 
    StringBuilder stringBuilder = new StringBuilder("maxCommentSize: ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  static final boolean l1111l111111Il(RandomAccessFile paramRandomAccessFile, long paramLong) {
    paramLong -= 20L;
    if (paramLong < 0L)
      return false; 
    paramRandomAccessFile.seek(paramLong);
    return (paramRandomAccessFile.readInt() == 1347094023);
  }
  
  private static int l111l11111I1l(ByteBuffer paramByteBuffer) {
    l111l11111Il(paramByteBuffer);
    int i = paramByteBuffer.capacity();
    if (i < 22)
      return -1; 
    int j = i - 22;
    int k = Math.min(j, 65535);
    for (i = 0; i <= k; i++) {
      int m = j - i;
      if (paramByteBuffer.getInt(m) == 101010256 && (paramByteBuffer.getShort(m + 20) & 0xFFFF) == i)
        return m; 
    } 
    return -1;
  }
  
  private static void l111l11111Il(ByteBuffer paramByteBuffer) {
    if (paramByteBuffer.order() == ByteOrder.LITTLE_ENDIAN)
      return; 
    throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
  }
  
  private static int l111l11111lIl(ByteBuffer paramByteBuffer, int paramInt) {
    return paramByteBuffer.getShort(paramInt) & 0xFFFF;
  }
  
  public static long l111l11111lIl(ByteBuffer paramByteBuffer) {
    l111l11111Il(paramByteBuffer);
    return l1111l111111Il(paramByteBuffer, paramByteBuffer.position() + 12);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l111l11111lIl\l111l1111llIl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */