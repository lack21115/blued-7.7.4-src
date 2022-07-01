package com.google.zxing.qrcode.encoder;

final class MatrixUtil {
  private static final int[][] a;
  
  private static final int[][] b;
  
  private static final int[][] c;
  
  private static final int[][] d;
  
  static {
    int[] arrayOfInt1 = { 1, 1, 1, 1, 1, 1, 1 };
    int[] arrayOfInt2 = { 1, 0, 0, 0, 0, 0, 1 };
    int[] arrayOfInt3 = { 1, 0, 1, 1, 1, 0, 1 };
    int[] arrayOfInt4 = { 1, 0, 0, 0, 0, 0, 1 };
    a = new int[][] { arrayOfInt1, arrayOfInt2, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, arrayOfInt3, arrayOfInt4, { 1, 1, 1, 1, 1, 1, 1 } };
    arrayOfInt1 = new int[] { 1, 0, 1, 0, 1 };
    arrayOfInt2 = new int[] { 1, 1, 1, 1, 1 };
    b = new int[][] { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, arrayOfInt1, { 1, 0, 0, 0, 1 }, arrayOfInt2 };
    arrayOfInt1 = new int[] { 6, 18, -1, -1, -1, -1, -1 };
    arrayOfInt2 = new int[] { 6, 26, -1, -1, -1, -1, -1 };
    arrayOfInt3 = new int[] { 6, 30, -1, -1, -1, -1, -1 };
    arrayOfInt4 = new int[] { 6, 22, 38, -1, -1, -1, -1 };
    int[] arrayOfInt5 = { 6, 24, 42, -1, -1, -1, -1 };
    int[] arrayOfInt6 = { 6, 28, 50, -1, -1, -1, -1 };
    int[] arrayOfInt7 = { 6, 30, 54, -1, -1, -1, -1 };
    int[] arrayOfInt8 = { 6, 34, 62, -1, -1, -1, -1 };
    int[] arrayOfInt9 = { 6, 26, 46, 66, -1, -1, -1 };
    int[] arrayOfInt10 = { 6, 26, 48, 70, -1, -1, -1 };
    int[] arrayOfInt11 = { 6, 30, 54, 78, -1, -1, -1 };
    int[] arrayOfInt12 = { 6, 30, 56, 82, -1, -1, -1 };
    int[] arrayOfInt13 = { 6, 28, 50, 72, 94, -1, -1 };
    int[] arrayOfInt14 = { 6, 26, 50, 74, 98, -1, -1 };
    int[] arrayOfInt15 = { 6, 30, 54, 78, 102, -1, -1 };
    int[] arrayOfInt16 = { 6, 34, 62, 90, 118, -1, -1 };
    int[] arrayOfInt17 = { 6, 30, 54, 78, 102, 126, -1 };
    int[] arrayOfInt18 = { 6, 26, 52, 78, 104, 130, -1 };
    int[] arrayOfInt19 = { 6, 34, 60, 86, 112, 138, -1 };
    int[] arrayOfInt20 = { 6, 34, 62, 90, 118, 146, -1 };
    int[] arrayOfInt21 = { 6, 30, 54, 78, 102, 126, 150 };
    int[] arrayOfInt22 = { 6, 28, 54, 80, 106, 132, 158 };
    int[] arrayOfInt23 = { 6, 32, 58, 84, 110, 136, 162 };
    c = new int[][] { 
        { -1, -1, -1, -1, -1, -1, -1 }, arrayOfInt1, { 6, 22, -1, -1, -1, -1, -1 }, arrayOfInt2, arrayOfInt3, { 6, 34, -1, -1, -1, -1, -1 }, arrayOfInt4, arrayOfInt5, { 6, 26, 46, -1, -1, -1, -1 }, arrayOfInt6, 
        arrayOfInt7, { 6, 32, 58, -1, -1, -1, -1 }, arrayOfInt8, arrayOfInt9, arrayOfInt10, { 6, 26, 50, 74, -1, -1, -1 }, arrayOfInt11, arrayOfInt12, { 6, 30, 58, 86, -1, -1, -1 }, { 6, 34, 62, 90, -1, -1, -1 }, 
        arrayOfInt13, arrayOfInt14, arrayOfInt15, { 6, 28, 54, 80, 106, -1, -1 }, { 6, 32, 58, 84, 110, -1, -1 }, { 6, 30, 58, 86, 114, -1, -1 }, arrayOfInt16, { 6, 26, 50, 74, 98, 122, -1 }, arrayOfInt17, arrayOfInt18, 
        { 6, 30, 56, 82, 108, 134, -1 }, arrayOfInt19, { 6, 30, 58, 86, 114, 142, -1 }, arrayOfInt20, arrayOfInt21, { 6, 24, 50, 76, 102, 128, 154 }, arrayOfInt22, arrayOfInt23, { 6, 26, 54, 82, 110, 138, 166 }, { 6, 30, 58, 86, 114, 142, 170 } };
    arrayOfInt1 = new int[] { 8, 2 };
    arrayOfInt2 = new int[] { 8, 3 };
    arrayOfInt3 = new int[] { 8, 5 };
    arrayOfInt4 = new int[] { 8, 8 };
    arrayOfInt5 = new int[] { 7, 8 };
    arrayOfInt6 = new int[] { 3, 8 };
    arrayOfInt7 = new int[] { 0, 8 };
    d = new int[][] { 
        { 8, 0 }, { 8, 1 }, arrayOfInt1, arrayOfInt2, { 8, 4 }, arrayOfInt3, { 8, 7 }, arrayOfInt4, arrayOfInt5, { 5, 8 }, 
        { 4, 8 }, arrayOfInt6, { 2, 8 }, { 1, 8 }, arrayOfInt7 };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\qrcode\encoder\MatrixUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */