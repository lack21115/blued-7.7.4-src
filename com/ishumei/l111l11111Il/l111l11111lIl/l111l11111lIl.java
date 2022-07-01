package com.ishumei.l111l11111Il.l111l11111lIl;

import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;

final class l111l11111lIl {
  private static final long l1111l111111Il = 3617552046287187010L;
  
  private static final int l111l11111I1l = 32;
  
  private static int l111l11111Il = 257;
  
  private static final long l111l11111lIl = 2334950737559900225L;
  
  private static int l111l1111l1Il = 258;
  
  private static int l111l1111lI1l = 260;
  
  private static int l111l1111lIl = 513;
  
  private static int l111l1111llIl = 259;
  
  private static int l11l1111I11l = 769;
  
  private static int l11l1111I1l = 1057;
  
  private static int l11l1111I1ll = 1059;
  
  private static int l11l1111Il = 1061;
  
  private static int l11l1111Il1l = 1;
  
  private static int l11l1111Ill = 2;
  
  private static int l11l1111lIIl = 514;
  
  private static int l11l11IlIIll = 3;
  
  static int l1111l111111Il(int paramInt) {
    if (paramInt != 513)
      if (paramInt != 514) {
        if (paramInt != 769)
          if (paramInt != 1057 && paramInt != 1059 && paramInt != 1061) {
            StringBuilder stringBuilder;
            switch (paramInt) {
              default:
                stringBuilder = new StringBuilder("Unknown signature algorithm: 0x");
                stringBuilder.append(Long.toHexString(paramInt));
                throw new IllegalArgumentException(stringBuilder.toString());
              case 258:
              case 260:
                return 2;
              case 257:
              case 259:
                break;
            } 
          } else {
            return 3;
          }  
        return 1;
      }  
    return 1;
  }
  
  private static long l1111l111111Il(ByteBuffer paramByteBuffer, long paramLong) {
    long l = l111l1111llIl.l1111l111111Il(paramByteBuffer);
    if (l <= paramLong) {
      if (l111l1111llIl.l111l11111lIl(paramByteBuffer) + l == paramLong)
        return l; 
      throw new IOException("ZIP Central Directory is not immediately followed by End of Central Directory");
    } 
    StringBuilder stringBuilder = new StringBuilder("ZIP Central Directory offset out of range: ");
    stringBuilder.append(l);
    stringBuilder.append(". ZIP End of Central Directory offset: ");
    stringBuilder.append(paramLong);
    throw new IOException(stringBuilder.toString());
  }
  
  private static Pair<ByteBuffer, Long> l1111l111111Il(RandomAccessFile paramRandomAccessFile) {
    Pair<ByteBuffer, Long> pair = l111l1111llIl.l1111l111111Il(paramRandomAccessFile);
    if (pair != null)
      return pair; 
    throw new IOException("Not an APK file: ZIP End of Central Directory record not found");
  }
  
  private static Pair<ByteBuffer, Long> l1111l111111Il(RandomAccessFile paramRandomAccessFile, long paramLong) {
    if (paramLong >= 32L) {
      ByteBuffer byteBuffer = ByteBuffer.allocate(24);
      byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      paramRandomAccessFile.seek(paramLong - byteBuffer.capacity());
      paramRandomAccessFile.readFully(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
      if (byteBuffer.getLong(8) == 2334950737559900225L && byteBuffer.getLong(16) == 3617552046287187010L) {
        long l = byteBuffer.getLong(0);
        if (l >= byteBuffer.capacity() && l <= 2147483639L) {
          int i = (int)(8L + l);
          paramLong -= i;
          if (paramLong >= 0L) {
            byteBuffer = ByteBuffer.allocate(i);
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            paramRandomAccessFile.seek(paramLong);
            paramRandomAccessFile.readFully(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
            long l1 = byteBuffer.getLong(0);
            if (l1 == l)
              return Pair.create(byteBuffer, Long.valueOf(paramLong)); 
            StringBuilder stringBuilder3 = new StringBuilder("APK Signing Block sizes in header and footer do not match: ");
            stringBuilder3.append(l1);
            stringBuilder3.append(" vs ");
            stringBuilder3.append(l);
            throw new IOException(stringBuilder3.toString());
          } 
          StringBuilder stringBuilder2 = new StringBuilder("APK Signing Block offset out of range: ");
          stringBuilder2.append(paramLong);
          throw new IOException(stringBuilder2.toString());
        } 
        StringBuilder stringBuilder1 = new StringBuilder("APK Signing Block size out of range: ");
        stringBuilder1.append(l);
        throw new IOException(stringBuilder1.toString());
      } 
      throw new IOException("No APK Signing Block before ZIP Central Directory");
    } 
    StringBuilder stringBuilder = new StringBuilder("APK too small for APK Signing Block. ZIP Central Directory offset: ");
    stringBuilder.append(paramLong);
    throw new IOException(stringBuilder.toString());
  }
  
  static l1111l111111Il l1111l111111Il(RandomAccessFile paramRandomAccessFile, int paramInt) {
    Pair<ByteBuffer, Long> pair = l1111l111111Il(paramRandomAccessFile);
    ByteBuffer byteBuffer = (ByteBuffer)pair.first;
    long l = ((Long)pair.second).longValue();
    if (!l111l1111llIl.l1111l111111Il(paramRandomAccessFile, l)) {
      long l1 = l1111l111111Il(byteBuffer, l);
      Pair<ByteBuffer, Long> pair1 = l1111l111111Il(paramRandomAccessFile, l1);
      ByteBuffer byteBuffer1 = (ByteBuffer)pair1.first;
      long l2 = ((Long)pair1.second).longValue();
      return new l1111l111111Il(l1111l111111Il(byteBuffer1, 1896449818), l2, l1, l, byteBuffer);
    } 
    throw new IOException("ZIP64 APK not supported");
  }
  
  static ByteBuffer l1111l111111Il(ByteBuffer paramByteBuffer) {
    if (paramByteBuffer.remaining() >= 4) {
      int i = paramByteBuffer.getInt();
      if (i >= 0) {
        if (i <= paramByteBuffer.remaining())
          return l111l11111lIl(paramByteBuffer, i); 
        StringBuilder stringBuilder1 = new StringBuilder("Length-prefixed field longer than remaining buffer. Field length: ");
        stringBuilder1.append(i);
        stringBuilder1.append(", remaining: ");
        stringBuilder1.append(paramByteBuffer.remaining());
        throw new IOException(stringBuilder1.toString());
      } 
      throw new IllegalArgumentException("Negative length");
    } 
    StringBuilder stringBuilder = new StringBuilder("Remaining buffer too short to contain length of length-prefixed field. Remaining: ");
    stringBuilder.append(paramByteBuffer.remaining());
    throw new IOException(stringBuilder.toString());
  }
  
  static ByteBuffer l1111l111111Il(ByteBuffer paramByteBuffer, int paramInt) {
    if (paramByteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
      paramByteBuffer = l1111l111111Il(paramByteBuffer, 8, paramByteBuffer.capacity() - 24);
      int i = 0;
      while (paramByteBuffer.hasRemaining()) {
        i++;
        if (paramByteBuffer.remaining() >= 8) {
          long l = paramByteBuffer.getLong();
          if (l >= 4L && l <= 2147483647L) {
            int j = (int)l;
            int k = paramByteBuffer.position();
            if (j <= paramByteBuffer.remaining()) {
              if (paramByteBuffer.getInt() == paramInt)
                return l111l11111lIl(paramByteBuffer, j - 4); 
              paramByteBuffer.position(k + j);
              continue;
            } 
            StringBuilder stringBuilder3 = new StringBuilder("APK Signing Block entry #");
            stringBuilder3.append(i);
            stringBuilder3.append(" size out of range: ");
            stringBuilder3.append(j);
            stringBuilder3.append(", available: ");
            stringBuilder3.append(paramByteBuffer.remaining());
            throw new IOException(stringBuilder3.toString());
          } 
          StringBuilder stringBuilder2 = new StringBuilder("APK Signing Block entry #");
          stringBuilder2.append(i);
          stringBuilder2.append(" size out of range: ");
          stringBuilder2.append(l);
          throw new IOException(stringBuilder2.toString());
        } 
        StringBuilder stringBuilder1 = new StringBuilder("Insufficient data to read size of APK Signing Block entry #");
        stringBuilder1.append(i);
        throw new IOException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder("No block with ID ");
      stringBuilder.append(paramInt);
      stringBuilder.append(" in APK Signing Block.");
      throw new IOException(stringBuilder.toString());
    } 
    throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
  }
  
  private static ByteBuffer l1111l111111Il(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {
    if (paramInt2 >= 8) {
      paramInt1 = paramByteBuffer.capacity();
      if (paramInt2 <= paramByteBuffer.capacity()) {
        paramInt1 = paramByteBuffer.limit();
        int i = paramByteBuffer.position();
        try {
          paramByteBuffer.position(0);
          paramByteBuffer.limit(paramInt2);
          paramByteBuffer.position(8);
          ByteBuffer byteBuffer = paramByteBuffer.slice();
          byteBuffer.order(paramByteBuffer.order());
          return byteBuffer;
        } finally {
          paramByteBuffer.position(0);
          paramByteBuffer.limit(paramInt1);
          paramByteBuffer.position(i);
        } 
      } 
      StringBuilder stringBuilder1 = new StringBuilder("end > capacity: ");
      stringBuilder1.append(paramInt2);
      stringBuilder1.append(" > ");
      stringBuilder1.append(paramInt1);
      throw new IllegalArgumentException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder("end < start: ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" < 8");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  static byte[] l1111l111111Il(byte[] paramArrayOfbyte, long paramLong, l1111l111111Il paraml1111l111111Il) {
    if (paramArrayOfbyte.length == 40) {
      ByteBuffer byteBuffer = ByteBuffer.wrap(paramArrayOfbyte).order(ByteOrder.LITTLE_ENDIAN);
      byteBuffer.position(32);
      if (byteBuffer.getLong() == paramLong - paraml1111l111111Il.l111l11111lIl - paraml1111l111111Il.l1111l111111Il)
        return Arrays.copyOfRange(paramArrayOfbyte, 0, 32); 
      throw new SecurityException("APK content size did not verify");
    } 
    StringBuilder stringBuilder = new StringBuilder("Verity digest size is wrong: ");
    stringBuilder.append(paramArrayOfbyte.length);
    throw new SecurityException(stringBuilder.toString());
  }
  
  static Pair<String, ? extends AlgorithmParameterSpec> l111l11111I1l(int paramInt) {
    if (paramInt != 513)
      if (paramInt != 514) {
        if (paramInt != 769) {
          if (paramInt != 1057) {
            if (paramInt != 1059) {
              if (paramInt != 1061) {
                StringBuilder stringBuilder;
                switch (paramInt) {
                  default:
                    stringBuilder = new StringBuilder("Unknown signature algorithm: 0x");
                    stringBuilder.append(Long.toHexString(paramInt));
                    throw new IllegalArgumentException(stringBuilder.toString());
                  case 260:
                    return Pair.create("SHA512withRSA", null);
                  case 258:
                    return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                  case 257:
                    return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                  case 259:
                    break;
                } 
                return Pair.create("SHA256withRSA", null);
              } 
              return Pair.create("SHA256withDSA", null);
            } 
          } else {
            return Pair.create("SHA256withRSA", null);
          } 
        } else {
          return Pair.create("SHA256withDSA", null);
        } 
      } else {
        return Pair.create("SHA512withECDSA", null);
      }  
    return Pair.create("SHA256withECDSA", null);
  }
  
  private static void l111l11111I1l(ByteBuffer paramByteBuffer) {
    if (paramByteBuffer.order() == ByteOrder.LITTLE_ENDIAN)
      return; 
    throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
  }
  
  static String l111l11111lIl(int paramInt) {
    if (paramInt != 513 && paramInt != 514)
      if (paramInt != 769) {
        if (paramInt != 1057) {
          if (paramInt != 1059) {
            if (paramInt != 1061) {
              StringBuilder stringBuilder;
              switch (paramInt) {
                default:
                  stringBuilder = new StringBuilder("Unknown signature algorithm: 0x");
                  stringBuilder.append(Long.toHexString(paramInt));
                  throw new IllegalArgumentException(stringBuilder.toString());
                case 257:
                case 258:
                case 259:
                case 260:
                  break;
              } 
              return "RSA";
            } 
            return "DSA";
          } 
        } else {
          return "RSA";
        } 
      } else {
        return "DSA";
      }  
    return "EC";
  }
  
  private static ByteBuffer l111l11111lIl(ByteBuffer paramByteBuffer, int paramInt) {
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
    StringBuilder stringBuilder = new StringBuilder("size: ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  static byte[] l111l11111lIl(ByteBuffer paramByteBuffer) {
    int i = paramByteBuffer.getInt();
    if (i >= 0) {
      if (i <= paramByteBuffer.remaining()) {
        byte[] arrayOfByte = new byte[i];
        paramByteBuffer.get(arrayOfByte);
        return arrayOfByte;
      } 
      StringBuilder stringBuilder = new StringBuilder("Underflow while reading length-prefixed value. Length: ");
      stringBuilder.append(i);
      stringBuilder.append(", available: ");
      stringBuilder.append(paramByteBuffer.remaining());
      throw new IOException(stringBuilder.toString());
    } 
    throw new IOException("Negative length");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l111l11111lIl\l111l11111lIl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */