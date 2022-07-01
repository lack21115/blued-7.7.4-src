package com.blued.android.chat.utils;

import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Iterator;

public class BytesUtils {
  public static final int MAX_UNSIGNED_BYTE8 = 255;
  
  public static final long MAX_UNSIGNED_INT32 = 4394967295L;
  
  public static final int MAX_UNSIGNED_SHORT16 = 65535;
  
  private static final HashSet<SoftReference<byte[]>> reusableBytes = new HashSet<SoftReference<byte[]>>();
  
  public static String byte2HexStr(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    StringBuffer stringBuffer = new StringBuffer();
    while (paramInt1 < paramInt2) {
      String str = Integer.toHexString(paramArrayOfbyte[paramInt1] & 0xFF);
      if (str.length() == 1) {
        stringBuffer.append("0");
        stringBuffer.append(str);
      } else {
        stringBuffer.append(str);
      } 
      paramInt1++;
    } 
    return stringBuffer.toString().toUpperCase();
  }
  
  public static short byteTo1Number(byte[] paramArrayOfbyte, int paramInt) {
    return (short)((short)paramArrayOfbyte[paramInt] & 0xFF);
  }
  
  public static long byteTo8Number(byte[] paramArrayOfbyte, int paramInt) {
    long l1 = paramArrayOfbyte[paramInt + 0];
    long l2 = paramArrayOfbyte[paramInt + 1];
    long l3 = paramArrayOfbyte[paramInt + 2];
    long l4 = paramArrayOfbyte[paramInt + 3];
    long l5 = paramArrayOfbyte[paramInt + 4];
    long l6 = paramArrayOfbyte[paramInt + 5];
    long l7 = paramArrayOfbyte[paramInt + 6];
    return (paramArrayOfbyte[paramInt + 7] & 0xFFL) << 0L | (l1 & 0xFFL) << 56L | (l2 & 0xFFL) << 48L | (l3 & 0xFFL) << 40L | (l4 & 0xFFL) << 32L | (l5 & 0xFFL) << 24L | (l6 & 0xFFL) << 16L | (l7 & 0xFFL) << 8L;
  }
  
  public static int bytesTo2Number(byte[] paramArrayOfbyte, int paramInt) {
    short s = (short)paramArrayOfbyte[paramInt + 0];
    return (short)((short)paramArrayOfbyte[paramInt + 1] & 0xFF | (s & 0xFF) << 8);
  }
  
  public static long bytesTo4Number(byte[] paramArrayOfbyte, int paramInt) {
    long l1 = paramArrayOfbyte[paramInt + 0];
    long l2 = paramArrayOfbyte[paramInt + 1];
    long l3 = paramArrayOfbyte[paramInt + 2];
    return (paramArrayOfbyte[paramInt + 3] & 0xFFL) << 0L | (l1 & 0xFFL) << 24L | (l2 & 0xFFL) << 16L | (l3 & 0xFFL) << 8L;
  }
  
  public static void copy(byte[] paramArrayOfbyte1, int paramInt1, byte[] paramArrayOfbyte2, int paramInt2, int paramInt3) {
    System.arraycopy(paramArrayOfbyte1, paramInt1, paramArrayOfbyte2, paramInt2, paramInt3);
  }
  
  public static byte[] getReuseByte(int paramInt) {
    synchronized (reusableBytes) {
      Iterator<SoftReference<byte[]>> iterator = reusableBytes.iterator();
      while (iterator.hasNext()) {
        byte[] arrayOfByte = ((SoftReference<byte[]>)iterator.next()).get();
        if (arrayOfByte == null) {
          iterator.remove();
          continue;
        } 
        if (arrayOfByte.length >= paramInt) {
          iterator.remove();
          return arrayOfByte;
        } 
      } 
      return new byte[paramInt];
    } 
  }
  
  public static byte[] hexStr2Bytes(String paramString) {
    int j = paramString.length() / 2;
    System.out.println(j);
    byte[] arrayOfByte = new byte[j];
    for (int i = 0; i < j; i++) {
      int k = i * 2;
      int m = k + 1;
      arrayOfByte[i] = uniteBytes(paramString.substring(k, m), paramString.substring(m, m + 1));
    } 
    return arrayOfByte;
  }
  
  public static void numberTo1Byte(byte[] paramArrayOfbyte, int paramInt, short paramShort) {
    if (paramShort <= 255) {
      paramArrayOfbyte[paramInt] = (byte)(paramShort & 0xFF);
      return;
    } 
    throw new NumberFormatException("value is out of unsigned byte8 range");
  }
  
  public static void numberTo2Bytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (paramInt2 <= 65535) {
      paramArrayOfbyte[paramInt1 + 0] = (byte)(paramInt2 >> 8);
      paramArrayOfbyte[paramInt1 + 1] = (byte)(paramInt2 >> 0);
      return;
    } 
    throw new NumberFormatException("value is out of unsigned short16 range");
  }
  
  public static void numberTo4Bytes(byte[] paramArrayOfbyte, int paramInt, long paramLong) {
    if (paramLong <= 4394967295L) {
      paramArrayOfbyte[paramInt + 0] = (byte)(int)(paramLong >> 24L);
      paramArrayOfbyte[paramInt + 1] = (byte)(int)(paramLong >> 16L);
      paramArrayOfbyte[paramInt + 2] = (byte)(int)(paramLong >> 8L);
      paramArrayOfbyte[paramInt + 3] = (byte)(int)(paramLong >> 0L);
      return;
    } 
    throw new NumberFormatException("value is out of unsigned int32 range");
  }
  
  public static void numberTo8Bytes(byte[] paramArrayOfbyte, int paramInt, long paramLong) {
    paramArrayOfbyte[paramInt + 0] = (byte)(int)(paramLong >> 56L);
    paramArrayOfbyte[paramInt + 1] = (byte)(int)(paramLong >> 48L);
    paramArrayOfbyte[paramInt + 2] = (byte)(int)(paramLong >> 40L);
    paramArrayOfbyte[paramInt + 3] = (byte)(int)(paramLong >> 32L);
    paramArrayOfbyte[paramInt + 4] = (byte)(int)(paramLong >> 24L);
    paramArrayOfbyte[paramInt + 5] = (byte)(int)(paramLong >> 16L);
    paramArrayOfbyte[paramInt + 6] = (byte)(int)(paramLong >> 8L);
    paramArrayOfbyte[paramInt + 7] = (byte)(int)(paramLong >> 0L);
  }
  
  public static void saveToReuseByte(byte[] paramArrayOfbyte) {
    synchronized (reusableBytes) {
      reusableBytes.add((SoftReference)new SoftReference<byte>(paramArrayOfbyte));
      return;
    } 
  }
  
  private static byte uniteBytes(String paramString1, String paramString2) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("0x");
    stringBuilder2.append(paramString1);
    byte b = (byte)(Byte.decode(stringBuilder2.toString()).byteValue() << 4);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("0x");
    stringBuilder1.append(paramString2);
    return (byte)(b | Byte.decode(stringBuilder1.toString()).byteValue());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cha\\utils\BytesUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */