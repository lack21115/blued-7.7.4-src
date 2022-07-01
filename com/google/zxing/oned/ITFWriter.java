package com.google.zxing.oned;

public final class ITFWriter extends OneDimensionalCodeWriter {
  private static final int[] a = new int[] { 1, 1, 1, 1 };
  
  private static final int[] b = new int[] { 3, 1, 1 };
  
  private static final int[][] c;
  
  static {
    int[] arrayOfInt1 = { 3, 1, 1, 1, 3 };
    int[] arrayOfInt2 = { 1, 1, 3, 1, 3 };
    int[] arrayOfInt3 = { 3, 1, 3, 1, 1 };
    int[] arrayOfInt4 = { 1, 3, 3, 1, 1 };
    c = new int[][] { { 1, 1, 3, 3, 1 }, arrayOfInt1, { 1, 3, 1, 1, 3 }, { 3, 3, 1, 1, 1 }, arrayOfInt2, arrayOfInt3, arrayOfInt4, { 1, 1, 1, 3, 3 }, { 3, 1, 1, 3, 1 }, { 1, 3, 1, 3, 1 } };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\ITFWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */