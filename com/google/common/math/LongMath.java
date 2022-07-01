package com.google.common.math;

import java.math.RoundingMode;

public final class LongMath {
  static final byte[] a = new byte[] { 
      19, 18, 18, 18, 18, 17, 17, 17, 16, 16, 
      16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 
      13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 
      10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 
      7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 
      4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 
      1, 0, 0, 0 };
  
  static final long[] b = new long[] { 
      1L, 10L, 100L, 1000L, 10000L, 100000L, 1000000L, 10000000L, 100000000L, 1000000000L, 
      10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L };
  
  static final long[] c = new long[] { 
      3L, 31L, 316L, 3162L, 31622L, 316227L, 3162277L, 31622776L, 316227766L, 3162277660L, 
      31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L };
  
  static final long[] d = new long[] { 
      1L, 1L, 2L, 6L, 24L, 120L, 720L, 5040L, 40320L, 362880L, 
      3628800L, 39916800L, 479001600L, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 
      2432902008176640000L };
  
  static final int[] e = new int[] { 
      Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 
      361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 
      83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 
      66, 66, 66, 66 };
  
  static final int[] f = new int[] { 
      Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, 419, 
      287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 
      73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 
      61 };
  
  private static final long[][] g;
  
  static {
    long[] arrayOfLong1 = { 885594168L, 725270293939359937L, 3569819667048198375L };
    long[] arrayOfLong2 = { 273919523040L, 15L, 7363882082L, 992620450144556L };
    long[] arrayOfLong3 = { 7999252175582850L, 2L, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L };
    long[] arrayOfLong4 = { Long.MAX_VALUE, 2L, 325L, 9375L, 28178L, 450775L, 9780504L, 1795265022L };
    g = new long[][] { { 291830L, 126401071349994536L }, arrayOfLong1, arrayOfLong2, { 47636622961200L, 2L, 2570940L, 211991001L, 3749873356L }, arrayOfLong3, { 585226005592931976L, 2L, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L }, arrayOfLong4 };
  }
  
  public static long a(long paramLong1, long paramLong2) {
    boolean bool1;
    long l = paramLong1 + paramLong2;
    boolean bool2 = true;
    if ((paramLong1 ^ paramLong2) < 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if ((paramLong1 ^ l) < 0L)
      bool2 = false; 
    MathPreconditions.a(bool1 | bool2, "checkedAdd", paramLong1, paramLong2);
    return l;
  }
  
  public static long b(long paramLong1, long paramLong2) {
    boolean bool1;
    long l = paramLong1 - paramLong2;
    boolean bool2 = true;
    if ((paramLong1 ^ paramLong2) >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if ((paramLong1 ^ l) < 0L)
      bool2 = false; 
    MathPreconditions.a(bool1 | bool2, "checkedSubtract", paramLong1, paramLong2);
    return l;
  }
  
  public static long c(long paramLong1, long paramLong2) {
    byte b;
    int i = Long.numberOfLeadingZeros(paramLong1) + Long.numberOfLeadingZeros(paramLong1) + Long.numberOfLeadingZeros(paramLong2) + Long.numberOfLeadingZeros(paramLong2);
    if (i > 65)
      return paramLong1 * paramLong2; 
    if (i >= 64) {
      bool = true;
    } else {
      bool = false;
    } 
    MathPreconditions.a(bool, "checkedMultiply", paramLong1, paramLong2);
    int j = paramLong1 cmp 0L;
    if (j >= 0) {
      i = 1;
    } else {
      i = 0;
    } 
    if (paramLong2 != Long.MIN_VALUE) {
      b = 1;
    } else {
      b = 0;
    } 
    MathPreconditions.a(i | b, "checkedMultiply", paramLong1, paramLong2);
    long l = paramLong1 * paramLong2;
    if (j == 0 || l / paramLong1 == paramLong2) {
      bool = true;
      MathPreconditions.a(bool, "checkedMultiply", paramLong1, paramLong2);
      return l;
    } 
    boolean bool = false;
    MathPreconditions.a(bool, "checkedMultiply", paramLong1, paramLong2);
    return l;
  }
  
  enum MillerRabinTester {
    a {
    
    },
    b {
    
    };
  }
  
  enum null {
  
  }
  
  enum null {
  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\math\LongMath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */