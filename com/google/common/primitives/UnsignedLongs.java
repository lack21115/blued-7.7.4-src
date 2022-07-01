package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.math.BigInteger;
import java.util.Comparator;

public final class UnsignedLongs {
  public static int a(long paramLong1, long paramLong2) {
    return Longs.a(b(paramLong1), b(paramLong2));
  }
  
  public static String a(long paramLong) {
    return a(paramLong, 10);
  }
  
  public static String a(long paramLong, int paramInt) {
    int j;
    boolean bool;
    if (paramInt >= 2 && paramInt <= 36) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", paramInt);
    int i = paramLong cmp 0L;
    if (i == 0)
      return "0"; 
    if (i > 0)
      return Long.toString(paramLong, paramInt); 
    char[] arrayOfChar = new char[64];
    i = arrayOfChar.length;
    int k = paramInt - 1;
    if ((paramInt & k) == 0) {
      long l;
      int m = Integer.numberOfTrailingZeros(paramInt);
      do {
        j = i - 1;
        arrayOfChar[j] = Character.forDigit((int)paramLong & k, paramInt);
        l = paramLong >>> m;
        i = j;
        paramLong = l;
      } while (l != 0L);
    } else {
      long l1;
      if ((paramInt & 0x1) == 0) {
        l1 = (paramLong >>> 1L) / (paramInt >>> 1);
      } else {
        l1 = b(paramLong, paramInt);
      } 
      long l2 = paramInt;
      arrayOfChar[--i] = Character.forDigit((int)(paramLong - l1 * l2), paramInt);
      while (true) {
        j = i;
        if (l1 > 0L) {
          arrayOfChar[--i] = Character.forDigit((int)(l1 % l2), paramInt);
          l1 /= l2;
          continue;
        } 
        break;
      } 
    } 
    return new String(arrayOfChar, j, arrayOfChar.length - j);
  }
  
  private static long b(long paramLong) {
    return paramLong ^ Long.MIN_VALUE;
  }
  
  public static long b(long paramLong1, long paramLong2) {
    if (paramLong2 < 0L)
      return (a(paramLong1, paramLong2) < 0) ? 0L : 1L; 
    if (paramLong1 >= 0L)
      return paramLong1 / paramLong2; 
    boolean bool = true;
    long l = (paramLong1 >>> 1L) / paramLong2 << 1L;
    if (a(paramLong1 - l * paramLong2, paramLong2) < 0)
      bool = false; 
    return l + bool;
  }
  
  public static long c(long paramLong1, long paramLong2) {
    if (paramLong2 < 0L)
      return (a(paramLong1, paramLong2) < 0) ? paramLong1 : (paramLong1 - paramLong2); 
    if (paramLong1 >= 0L)
      return paramLong1 % paramLong2; 
    paramLong1 -= ((paramLong1 >>> 1L) / paramLong2 << 1L) * paramLong2;
    if (a(paramLong1, paramLong2) < 0)
      paramLong2 = 0L; 
    return paramLong1 - paramLong2;
  }
  
  enum LexicographicalComparator implements Comparator<long[]> {
    a;
    
    public int a(long[] param1ArrayOflong1, long[] param1ArrayOflong2) {
      int j = Math.min(param1ArrayOflong1.length, param1ArrayOflong2.length);
      for (int i = 0; i < j; i++) {
        if (param1ArrayOflong1[i] != param1ArrayOflong2[i])
          return UnsignedLongs.a(param1ArrayOflong1[i], param1ArrayOflong2[i]); 
      } 
      return param1ArrayOflong1.length - param1ArrayOflong2.length;
    }
    
    public String toString() {
      return "UnsignedLongs.lexicographicalComparator()";
    }
  }
  
  static final class ParseOverflowDetection {
    static final long[] a = new long[37];
    
    static final int[] b = new int[37];
    
    static final int[] c = new int[37];
    
    static {
      BigInteger bigInteger = new BigInteger("10000000000000000", 16);
      for (int i = 2; i <= 36; i++) {
        long[] arrayOfLong = a;
        long l = i;
        arrayOfLong[i] = UnsignedLongs.b(-1L, l);
        b[i] = (int)UnsignedLongs.c(-1L, l);
        c[i] = bigInteger.toString(i).length() - 1;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\primitives\UnsignedLongs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */