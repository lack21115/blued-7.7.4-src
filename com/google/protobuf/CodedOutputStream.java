package com.google.protobuf;

import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CodedOutputStream extends ByteOutput {
  static final long ARRAY_BASE_OFFSET = 0L;
  
  static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = false;
  
  private static final Logger logger;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private CodedOutputStream() {}
  
  public static int computeBoolSize$2563259(int paramInt) {
    return computeTagSize(paramInt) + 1;
  }
  
  public static int computeBytesSize(int paramInt, ByteString paramByteString) {
    paramInt = computeTagSize(paramInt);
    int i = paramByteString.size();
    return paramInt + computeUInt32SizeNoTag(i) + i;
  }
  
  public static int computeFixed32Size$255f288(int paramInt) {
    return computeTagSize(paramInt) + 4;
  }
  
  public static int computeFixed64Size$255f649(int paramInt) {
    return computeTagSize(paramInt) + 8;
  }
  
  public static int computePreferredBufferSize(int paramInt) {
    return (paramInt > 4096) ? 4096 : paramInt;
  }
  
  public static int computeStringSize(int paramInt, String paramString) {
    return computeTagSize(paramInt) + computeStringSizeNoTag(paramString);
  }
  
  private static int computeStringSizeNoTag(String paramString) {
    int i;
    try {
      i = Utf8.encodedLength(paramString);
    } catch (Utf8$UnpairedSurrogateException utf8$UnpairedSurrogateException) {
      i = (paramString.getBytes(Internal.UTF_8)).length;
    } 
    return computeUInt32SizeNoTag(i) + i;
  }
  
  public static int computeTagSize(int paramInt) {
    return computeUInt32SizeNoTag(paramInt << 3);
  }
  
  public static int computeUInt32SizeNoTag(int paramInt) {
    return ((paramInt & 0xFFFFFF80) == 0) ? 1 : (((paramInt & 0xFFFFC000) == 0) ? 2 : (((0xFFE00000 & paramInt) == 0) ? 3 : (((paramInt & 0xF0000000) == 0) ? 4 : 5)));
  }
  
  public static int computeUInt64Size(int paramInt, long paramLong) {
    int i = computeTagSize(paramInt);
    if ((0xFFFFFFFFFFFFFF80L & paramLong) == 0L) {
      paramInt = 1;
    } else if (paramLong < 0L) {
      paramInt = 10;
    } else {
      if ((0xFFFFFFF800000000L & paramLong) != 0L) {
        j = 6;
        paramLong >>>= 28L;
      } else {
        j = 2;
      } 
      paramInt = j;
      long l = paramLong;
      if ((0xFFFFFFFFFFE00000L & paramLong) != 0L) {
        paramInt = j + 2;
        l = paramLong >>> 14L;
      } 
      int j = paramInt;
      if ((l & 0xFFFFFFFFFFFFC000L) != 0L)
        j = paramInt + 1; 
      paramInt = j;
    } 
    return i + paramInt;
  }
  
  public static CodedOutputStream newInstance(OutputStream paramOutputStream, int paramInt) {
    return new CodedOutputStream$OutputStreamEncoder(paramOutputStream, paramInt);
  }
  
  public static CodedOutputStream newInstance(byte[] paramArrayOfbyte) {
    return new CodedOutputStream$ArrayEncoder(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public abstract void flush();
  
  final void inefficientWriteStringNoTag(String paramString, Utf8$UnpairedSurrogateException paramUtf8$UnpairedSurrogateException) {
    logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", paramUtf8$UnpairedSurrogateException);
    byte[] arrayOfByte = paramString.getBytes(Internal.UTF_8);
    try {
      writeUInt32NoTag(arrayOfByte.length);
      writeLazy(arrayOfByte, 0, arrayOfByte.length);
      return;
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      throw new CodedOutputStream$OutOfSpaceException(indexOutOfBoundsException);
    } catch (CodedOutputStream$OutOfSpaceException codedOutputStream$OutOfSpaceException) {
      throw codedOutputStream$OutOfSpaceException;
    } 
  }
  
  public abstract int spaceLeft();
  
  public abstract void writeBool(int paramInt, boolean paramBoolean);
  
  public abstract void writeBytes(int paramInt, ByteString paramByteString);
  
  public abstract void writeFixed32(int paramInt1, int paramInt2);
  
  public abstract void writeFixed64(int paramInt, long paramLong);
  
  public abstract void writeLazy(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
  
  public abstract void writeString(int paramInt, String paramString);
  
  public abstract void writeTag(int paramInt1, int paramInt2);
  
  public abstract void writeUInt32NoTag(int paramInt);
  
  public abstract void writeUInt64(int paramInt, long paramLong);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\CodedOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */