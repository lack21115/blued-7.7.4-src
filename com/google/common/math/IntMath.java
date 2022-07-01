package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;

public final class IntMath {
  static final byte[] a = new byte[] { 
      9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 
      6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 
      3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 
      0, 0, 0 };
  
  static final int[] b = new int[] { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };
  
  static final int[] c = new int[] { 3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE };
  
  static int[] d;
  
  private static final int[] e = new int[] { 
      1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 
      3628800, 39916800, 479001600 };
  
  static {
    d = new int[] { 
        Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 
        43, 39, 37, 35, 34, 34, 33 };
  }
  
  static int a(int paramInt1, int paramInt2) {
    return paramInt1 - paramInt2 >>> 31;
  }
  
  public static int a(int paramInt1, int paramInt2, RoundingMode paramRoundingMode) {
    Preconditions.a(paramRoundingMode);
    if (paramInt2 != 0) {
      int i = paramInt1 / paramInt2;
      int k = paramInt1 - paramInt2 * i;
      if (k == 0)
        return i; 
      boolean bool1 = true;
      boolean bool2 = true;
      int j = (paramInt1 ^ paramInt2) >> 31 | 0x1;
      paramInt1 = bool1;
      switch (null.a[paramRoundingMode.ordinal()]) {
        default:
          throw new AssertionError();
        case 6:
        case 7:
        case 8:
          paramInt1 = Math.abs(k);
          paramInt1 -= Math.abs(paramInt2) - paramInt1;
          if (paramInt1 == 0) {
            paramInt1 = bool1;
            if (paramRoundingMode != RoundingMode.HALF_UP) {
              if (paramRoundingMode == RoundingMode.HALF_EVEN) {
                paramInt1 = 1;
              } else {
                paramInt1 = 0;
              } 
              if ((i & 0x1) != 0) {
                paramInt2 = 1;
              } else {
                paramInt2 = 0;
              } 
              if ((paramInt1 & paramInt2) != 0) {
                paramInt1 = bool1;
                break;
              } 
            } else {
              break;
            } 
          } else if (paramInt1 > 0) {
            paramInt1 = bool1;
            break;
          } 
        case 5:
          if (j > 0) {
            paramInt1 = bool1;
            break;
          } 
        case 3:
          if (j < 0) {
            paramInt1 = bool1;
            break;
          } 
        case 1:
          if (k != 0)
            bool2 = false; 
          MathPreconditions.a(bool2);
        case 2:
          paramInt1 = 0;
          break;
        case 4:
          break;
      } 
      paramInt2 = i;
      if (paramInt1 != 0)
        paramInt2 = i + j; 
      return paramInt2;
    } 
    throw new ArithmeticException("/ by zero");
  }
  
  public static int a(int paramInt, RoundingMode paramRoundingMode) {
    int i;
    MathPreconditions.a("x", paramInt);
    switch (null.a[paramRoundingMode.ordinal()]) {
      default:
        throw new AssertionError();
      case 6:
      case 7:
      case 8:
        i = Integer.numberOfLeadingZeros(paramInt);
        return 31 - i + a(-1257966797 >>> i, paramInt);
      case 4:
      case 5:
        return 32 - Integer.numberOfLeadingZeros(paramInt - 1);
      case 1:
        MathPreconditions.a(a(paramInt));
        break;
      case 2:
      case 3:
        break;
    } 
    return 31 - Integer.numberOfLeadingZeros(paramInt);
  }
  
  public static boolean a(int paramInt) {
    boolean bool1;
    boolean bool2 = false;
    if (paramInt > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if ((paramInt & paramInt - 1) == 0)
      bool2 = true; 
    return bool1 & bool2;
  }
  
  public static int b(int paramInt) {
    MathPreconditions.b("n", paramInt);
    int[] arrayOfInt = e;
    return (paramInt < arrayOfInt.length) ? arrayOfInt[paramInt] : Integer.MAX_VALUE;
  }
  
  public static int b(int paramInt1, int paramInt2) {
    boolean bool;
    long l = paramInt1 + paramInt2;
    int i = (int)l;
    if (l == i) {
      bool = true;
    } else {
      bool = false;
    } 
    MathPreconditions.a(bool, "checkedAdd", paramInt1, paramInt2);
    return i;
  }
  
  public static int c(int paramInt1, int paramInt2) {
    boolean bool;
    long l = paramInt1 - paramInt2;
    int i = (int)l;
    if (l == i) {
      bool = true;
    } else {
      bool = false;
    } 
    MathPreconditions.a(bool, "checkedSubtract", paramInt1, paramInt2);
    return i;
  }
  
  public static int d(int paramInt1, int paramInt2) {
    boolean bool;
    long l = paramInt1 * paramInt2;
    int i = (int)l;
    if (l == i) {
      bool = true;
    } else {
      bool = false;
    } 
    MathPreconditions.a(bool, "checkedMultiply", paramInt1, paramInt2);
    return i;
  }
  
  public static int e(int paramInt1, int paramInt2) {
    return Ints.b(paramInt1 + paramInt2);
  }
  
  public static int f(int paramInt1, int paramInt2) {
    return Ints.b(paramInt1 * paramInt2);
  }
  
  public static int g(int paramInt1, int paramInt2) {
    boolean bool2;
    MathPreconditions.b("n", paramInt1);
    MathPreconditions.b("k", paramInt2);
    boolean bool1 = false;
    if (paramInt2 <= paramInt1) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.a(bool2, "k (%s) > n (%s)", paramInt2, paramInt1);
    int i = paramInt2;
    if (paramInt2 > paramInt1 >> 1)
      i = paramInt1 - paramInt2; 
    int[] arrayOfInt = d;
    if (i >= arrayOfInt.length || paramInt1 > arrayOfInt[i])
      return Integer.MAX_VALUE; 
    if (i != 0) {
      paramInt2 = paramInt1;
      if (i != 1) {
        long l = 1L;
        paramInt2 = bool1;
        while (paramInt2 < i) {
          long l1 = (paramInt1 - paramInt2);
          l = l * l1 / ++paramInt2;
        } 
        paramInt2 = (int)l;
      } 
      return paramInt2;
    } 
    return 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\math\IntMath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */