package com.google.common.primitives;

import java.util.Comparator;

public final class UnsignedInts {
  static int a(int paramInt) {
    return paramInt ^ Integer.MIN_VALUE;
  }
  
  public static int a(int paramInt1, int paramInt2) {
    return Ints.a(a(paramInt1), a(paramInt2));
  }
  
  public static long b(int paramInt) {
    return paramInt & 0xFFFFFFFFL;
  }
  
  public static String b(int paramInt1, int paramInt2) {
    return Long.toString(paramInt1 & 0xFFFFFFFFL, paramInt2);
  }
  
  enum LexicographicalComparator implements Comparator<int[]> {
    a;
    
    public int a(int[] param1ArrayOfint1, int[] param1ArrayOfint2) {
      int j = Math.min(param1ArrayOfint1.length, param1ArrayOfint2.length);
      for (int i = 0; i < j; i++) {
        if (param1ArrayOfint1[i] != param1ArrayOfint2[i])
          return UnsignedInts.a(param1ArrayOfint1[i], param1ArrayOfint2[i]); 
      } 
      return param1ArrayOfint1.length - param1ArrayOfint2.length;
    }
    
    public String toString() {
      return "UnsignedInts.lexicographicalComparator()";
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\primitives\UnsignedInts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */