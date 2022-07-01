package com.google.common.hash;

import com.google.common.base.Preconditions;

final class FarmHashFingerprint64 extends AbstractNonStreamingHashFunction {
  static final HashFunction a = new FarmHashFingerprint64();
  
  private static long a(long paramLong) {
    return paramLong ^ paramLong >>> 47L;
  }
  
  private static long a(long paramLong1, long paramLong2, long paramLong3) {
    paramLong1 = (paramLong1 ^ paramLong2) * paramLong3;
    paramLong1 = (paramLong1 ^ paramLong1 >>> 47L ^ paramLong2) * paramLong3;
    return (paramLong1 ^ paramLong1 >>> 47L) * paramLong3;
  }
  
  private static void a(byte[] paramArrayOfbyte, int paramInt, long paramLong1, long paramLong2, long[] paramArrayOflong) {
    long l4 = LittleEndianByteArray.a(paramArrayOfbyte, paramInt);
    long l2 = LittleEndianByteArray.a(paramArrayOfbyte, paramInt + 8);
    long l3 = LittleEndianByteArray.a(paramArrayOfbyte, paramInt + 16);
    long l1 = LittleEndianByteArray.a(paramArrayOfbyte, paramInt + 24);
    paramLong1 += l4;
    paramLong2 = Long.rotateRight(paramLong2 + paramLong1 + l1, 21);
    l2 = l2 + paramLong1 + l3;
    l3 = Long.rotateRight(l2, 44);
    paramArrayOflong[0] = l2 + l1;
    paramArrayOflong[1] = paramLong2 + l3 + paramLong1;
  }
  
  static long b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return (paramInt2 <= 32) ? ((paramInt2 <= 16) ? c(paramArrayOfbyte, paramInt1, paramInt2) : d(paramArrayOfbyte, paramInt1, paramInt2)) : ((paramInt2 <= 64) ? e(paramArrayOfbyte, paramInt1, paramInt2) : f(paramArrayOfbyte, paramInt1, paramInt2));
  }
  
  private static long c(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (paramInt2 >= 8) {
      long l1 = (paramInt2 * 2) - 7286425919675154353L;
      long l2 = LittleEndianByteArray.a(paramArrayOfbyte, paramInt1) - 7286425919675154353L;
      long l3 = LittleEndianByteArray.a(paramArrayOfbyte, paramInt1 + paramInt2 - 8);
      return a(Long.rotateRight(l3, 37) * l1 + l2, (Long.rotateRight(l2, 25) + l3) * l1, l1);
    } 
    if (paramInt2 >= 4) {
      long l1 = (paramInt2 * 2);
      long l2 = LittleEndianByteArray.b(paramArrayOfbyte, paramInt1);
      return a(paramInt2 + ((l2 & 0xFFFFFFFFL) << 3L), LittleEndianByteArray.b(paramArrayOfbyte, paramInt1 + paramInt2 - 4) & 0xFFFFFFFFL, l1 - 7286425919675154353L);
    } 
    if (paramInt2 > 0) {
      byte b1 = paramArrayOfbyte[paramInt1];
      byte b2 = paramArrayOfbyte[(paramInt2 >> 1) + paramInt1];
      paramInt1 = paramArrayOfbyte[paramInt1 + paramInt2 - 1];
      return a(((b1 & 0xFF) + ((b2 & 0xFF) << 8)) * -7286425919675154353L ^ (paramInt2 + ((paramInt1 & 0xFF) << 2)) * -4348849565147123417L) * -7286425919675154353L;
    } 
    return -7286425919675154353L;
  }
  
  private static long d(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    long l1 = (paramInt2 * 2) - 7286425919675154353L;
    long l2 = LittleEndianByteArray.a(paramArrayOfbyte, paramInt1) * -5435081209227447693L;
    long l3 = LittleEndianByteArray.a(paramArrayOfbyte, paramInt1 + 8);
    paramInt1 += paramInt2;
    long l4 = LittleEndianByteArray.a(paramArrayOfbyte, paramInt1 - 8) * l1;
    return a(LittleEndianByteArray.a(paramArrayOfbyte, paramInt1 - 16) * -7286425919675154353L + Long.rotateRight(l2 + l3, 43) + Long.rotateRight(l4, 30), l2 + Long.rotateRight(l3 - 7286425919675154353L, 18) + l4, l1);
  }
  
  private static long e(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    long l1 = (paramInt2 * 2) - 7286425919675154353L;
    long l2 = LittleEndianByteArray.a(paramArrayOfbyte, paramInt1) * -7286425919675154353L;
    long l4 = LittleEndianByteArray.a(paramArrayOfbyte, paramInt1 + 8);
    paramInt2 = paramInt1 + paramInt2;
    long l5 = LittleEndianByteArray.a(paramArrayOfbyte, paramInt2 - 8) * l1;
    long l3 = LittleEndianByteArray.a(paramArrayOfbyte, paramInt2 - 16);
    l3 = Long.rotateRight(l2 + l4, 43) + Long.rotateRight(l5, 30) + l3 * -7286425919675154353L;
    l4 = a(l3, l5 + Long.rotateRight(l4 - 7286425919675154353L, 18) + l2, l1);
    l5 = LittleEndianByteArray.a(paramArrayOfbyte, paramInt1 + 16) * l1;
    long l6 = LittleEndianByteArray.a(paramArrayOfbyte, paramInt1 + 24);
    l3 = (l3 + LittleEndianByteArray.a(paramArrayOfbyte, paramInt2 - 32)) * l1;
    return a((l4 + LittleEndianByteArray.a(paramArrayOfbyte, paramInt2 - 24)) * l1 + Long.rotateRight(l5 + l6, 43) + Long.rotateRight(l3, 30), l5 + Long.rotateRight(l6 + l2, 18) + l3, l1);
  }
  
  private static long f(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    long l1 = a(-7956866745689871395L) * -7286425919675154353L;
    long[] arrayOfLong1 = new long[2];
    long[] arrayOfLong2 = new long[2];
    long l3 = 95310865018149119L + LittleEndianByteArray.a(paramArrayOfbyte, paramInt1);
    int i = paramInt2 - 1;
    paramInt2 = paramInt1 + i / 64 * 64;
    i &= 0x3F;
    int j = paramInt2 + i - 63;
    long l2 = 2480279821605975764L;
    while (true) {
      l3 = Long.rotateRight(l3 + l2 + arrayOfLong1[0] + LittleEndianByteArray.a(paramArrayOfbyte, paramInt1 + 8), 37);
      long l = Long.rotateRight(l2 + arrayOfLong1[1] + LittleEndianByteArray.a(paramArrayOfbyte, paramInt1 + 48), 42);
      l2 = l3 * -5435081209227447693L ^ arrayOfLong2[1];
      l3 = l * -5435081209227447693L + arrayOfLong1[0] + LittleEndianByteArray.a(paramArrayOfbyte, paramInt1 + 40);
      l = Long.rotateRight(l1 + arrayOfLong2[0], 33) * -5435081209227447693L;
      a(paramArrayOfbyte, paramInt1, arrayOfLong1[1] * -5435081209227447693L, l2 + arrayOfLong2[0], arrayOfLong1);
      a(paramArrayOfbyte, paramInt1 + 32, l + arrayOfLong2[1], l3 + LittleEndianByteArray.a(paramArrayOfbyte, paramInt1 + 16), arrayOfLong2);
      paramInt1 += 64;
      if (paramInt1 == paramInt2) {
        l1 = ((l2 & 0xFFL) << 1L) - 5435081209227447693L;
        arrayOfLong2[0] = arrayOfLong2[0] + i;
        arrayOfLong1[0] = arrayOfLong1[0] + arrayOfLong2[0];
        arrayOfLong2[0] = arrayOfLong2[0] + arrayOfLong1[0];
        l = Long.rotateRight(l + l3 + arrayOfLong1[0] + LittleEndianByteArray.a(paramArrayOfbyte, j + 8), 37);
        long l4 = Long.rotateRight(l3 + arrayOfLong1[1] + LittleEndianByteArray.a(paramArrayOfbyte, j + 48), 42);
        l3 = l * l1 ^ arrayOfLong2[1] * 9L;
        l = l4 * l1 + arrayOfLong1[0] * 9L + LittleEndianByteArray.a(paramArrayOfbyte, j + 40);
        l2 = Long.rotateRight(l2 + arrayOfLong2[0], 33) * l1;
        a(paramArrayOfbyte, j, arrayOfLong1[1] * l1, l3 + arrayOfLong2[0], arrayOfLong1);
        a(paramArrayOfbyte, j + 32, l2 + arrayOfLong2[1], LittleEndianByteArray.a(paramArrayOfbyte, j + 16) + l, arrayOfLong2);
        return a(a(arrayOfLong1[0], arrayOfLong2[0], l1) + a(l) * -4348849565147123417L + l3, a(arrayOfLong1[1], arrayOfLong2[1], l1) + l2, l1);
      } 
      l1 = l2;
      l2 = l3;
      l3 = l;
    } 
  }
  
  public HashCode a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    Preconditions.a(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
    return HashCode.a(b(paramArrayOfbyte, paramInt1, paramInt2));
  }
  
  public int b() {
    return 64;
  }
  
  public String toString() {
    return "Hashing.farmHashFingerprint64()";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\FarmHashFingerprint64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */