package com.mcxiaoke.packer.support.walle;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.LinkedHashMap;
import java.util.Map;

final class ApkUtil {
  public static long a(FileChannel paramFileChannel) throws IOException {
    long l = paramFileChannel.size();
    if (l >= 22L) {
      l -= 22L;
      long l1 = Math.min(l, 65535L);
      int i = 0;
      while (true) {
        long l2 = i;
        if (l2 <= l1) {
          l2 = l - l2;
          ByteBuffer byteBuffer = ByteBuffer.allocate(4);
          paramFileChannel.position(l2);
          paramFileChannel.read(byteBuffer);
          byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
          if (byteBuffer.getInt(0) == 101010256) {
            byteBuffer = ByteBuffer.allocate(2);
            paramFileChannel.position(l2 + 20L);
            paramFileChannel.read(byteBuffer);
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            short s = byteBuffer.getShort(0);
            if (s == i)
              return s; 
          } 
          int j = i + 1;
          continue;
        } 
        throw new IOException("ZIP End of Central Directory (EOCD) record not found");
      } 
    } 
    throw new IOException("APK too small for ZIP End of Central Directory (EOCD) record");
  }
  
  public static long a(FileChannel paramFileChannel, long paramLong) throws IOException {
    ByteBuffer byteBuffer = ByteBuffer.allocate(4);
    byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    paramFileChannel.position(paramFileChannel.size() - paramLong - 6L);
    paramFileChannel.read(byteBuffer);
    return byteBuffer.getInt(0);
  }
  
  private static ByteBuffer a(ByteBuffer paramByteBuffer, int paramInt) throws BufferUnderflowException {
    if (paramInt >= 0) {
      int i = paramByteBuffer.limit();
      int j = paramByteBuffer.position();
      paramInt += j;
      if (paramInt >= j && paramInt <= i) {
        paramByteBuffer.limit(paramInt);
        try {
          ByteBuffer byteBuffer = paramByteBuffer.slice();
          byteBuffer.order(paramByteBuffer.order());
          paramByteBuffer.position(paramInt);
          return byteBuffer;
        } finally {
          paramByteBuffer.limit(i);
        } 
      } 
      throw new BufferUnderflowException();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("size: ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private static ByteBuffer a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {
    if (paramInt1 >= 0) {
      if (paramInt2 >= paramInt1) {
        int i = paramByteBuffer.capacity();
        if (paramInt2 <= paramByteBuffer.capacity()) {
          i = paramByteBuffer.limit();
          int j = paramByteBuffer.position();
          try {
            paramByteBuffer.position(0);
            paramByteBuffer.limit(paramInt2);
            paramByteBuffer.position(paramInt1);
            ByteBuffer byteBuffer = paramByteBuffer.slice();
            byteBuffer.order(paramByteBuffer.order());
            return byteBuffer;
          } finally {
            paramByteBuffer.position(0);
            paramByteBuffer.limit(i);
            paramByteBuffer.position(j);
          } 
        } 
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("end > capacity: ");
        stringBuilder2.append(paramInt2);
        stringBuilder2.append(" > ");
        stringBuilder2.append(i);
        throw new IllegalArgumentException(stringBuilder2.toString());
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("end < start: ");
      stringBuilder1.append(paramInt2);
      stringBuilder1.append(" < ");
      stringBuilder1.append(paramInt1);
      throw new IllegalArgumentException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("start: ");
    stringBuilder.append(paramInt1);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static Map<Integer, ByteBuffer> a(ByteBuffer paramByteBuffer) throws IOException {
    StringBuilder stringBuilder;
    b(paramByteBuffer);
    paramByteBuffer = a(paramByteBuffer, 8, paramByteBuffer.capacity() - 24);
    LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
    int i = 0;
    while (paramByteBuffer.hasRemaining()) {
      i++;
      if (paramByteBuffer.remaining() >= 8) {
        long l = paramByteBuffer.getLong();
        if (l >= 4L && l <= 2147483647L) {
          int j = (int)l;
          int k = paramByteBuffer.position();
          if (j <= paramByteBuffer.remaining()) {
            linkedHashMap.put(Integer.valueOf(paramByteBuffer.getInt()), a(paramByteBuffer, j - 4));
            paramByteBuffer.position(k + j);
            continue;
          } 
          stringBuilder = new StringBuilder();
          stringBuilder.append("APK Signing Block entry #");
          stringBuilder.append(i);
          stringBuilder.append(" size out of range: ");
          stringBuilder.append(j);
          stringBuilder.append(", available: ");
          stringBuilder.append(paramByteBuffer.remaining());
          throw new IOException(stringBuilder.toString());
        } 
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("APK Signing Block entry #");
        stringBuilder2.append(i);
        stringBuilder2.append(" size out of range: ");
        stringBuilder2.append(l);
        throw new IOException(stringBuilder2.toString());
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Insufficient data to read size of APK Signing Block entry #");
      stringBuilder1.append(i);
      throw new IOException(stringBuilder1.toString());
    } 
    return (Map<Integer, ByteBuffer>)stringBuilder;
  }
  
  public static long b(FileChannel paramFileChannel) throws IOException {
    return a(paramFileChannel, a(paramFileChannel));
  }
  
  public static Pair<ByteBuffer, Long> b(FileChannel paramFileChannel, long paramLong) throws IOException {
    if (paramLong >= 32L) {
      paramFileChannel.position(paramLong - 24L);
      ByteBuffer byteBuffer = ByteBuffer.allocate(24);
      paramFileChannel.read(byteBuffer);
      byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      if (byteBuffer.getLong(8) == 2334950737559900225L && byteBuffer.getLong(16) == 3617552046287187010L) {
        long l = byteBuffer.getLong(0);
        if (l >= byteBuffer.capacity() && l <= 2147483639L) {
          int i = (int)(8L + l);
          paramLong -= i;
          if (paramLong >= 0L) {
            paramFileChannel.position(paramLong);
            byteBuffer = ByteBuffer.allocate(i);
            paramFileChannel.read(byteBuffer);
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            long l1 = byteBuffer.getLong(0);
            if (l1 == l)
              return Pair.a(byteBuffer, Long.valueOf(paramLong)); 
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("APK Signing Block sizes in header and footer do not match: ");
            stringBuilder3.append(l1);
            stringBuilder3.append(" vs ");
            stringBuilder3.append(l);
            throw new IOException(stringBuilder3.toString());
          } 
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("APK Signing Block offset out of range: ");
          stringBuilder2.append(paramLong);
          throw new IOException(stringBuilder2.toString());
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("APK Signing Block size out of range: ");
        stringBuilder1.append(l);
        throw new IOException(stringBuilder1.toString());
      } 
      throw new IOException("No APK Signing Block before ZIP Central Directory");
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("APK too small for APK Signing Block. ZIP Central Directory offset: ");
    stringBuilder.append(paramLong);
    throw new IOException(stringBuilder.toString());
  }
  
  private static void b(ByteBuffer paramByteBuffer) {
    if (paramByteBuffer.order() == ByteOrder.LITTLE_ENDIAN)
      return; 
    throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
  }
  
  public static Pair<ByteBuffer, Long> c(FileChannel paramFileChannel) throws IOException {
    return b(paramFileChannel, b(paramFileChannel));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\mcxiaoke\packer\support\walle\ApkUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */