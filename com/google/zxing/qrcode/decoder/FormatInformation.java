package com.google.zxing.qrcode.decoder;

final class FormatInformation {
  private static final int[][] a;
  
  private final ErrorCorrectionLevel b;
  
  private final byte c;
  
  static {
    int[] arrayOfInt1 = { 20773, 1 };
    int[] arrayOfInt2 = { 17913, 4 };
    int[] arrayOfInt3 = { 20375, 6 };
    int[] arrayOfInt4 = { 19104, 7 };
    int[] arrayOfInt5 = { 30660, 8 };
    int[] arrayOfInt6 = { 29427, 9 };
    int[] arrayOfInt7 = { 32170, 10 };
    int[] arrayOfInt8 = { 26159, 12 };
    int[] arrayOfInt9 = { 25368, 13 };
    int[] arrayOfInt10 = { 5769, 16 };
    int[] arrayOfInt11 = { 1890, 20 };
    int[] arrayOfInt12 = { 597, 21 };
    int[] arrayOfInt13 = { 3340, 22 };
    int[] arrayOfInt14 = { 12392, 25 };
    a = new int[][] { 
        { 21522, 0 }, arrayOfInt1, { 24188, 2 }, { 23371, 3 }, arrayOfInt2, { 16590, 5 }, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, 
        arrayOfInt7, { 30877, 11 }, arrayOfInt8, arrayOfInt9, { 27713, 14 }, { 26998, 15 }, arrayOfInt10, { 5054, 17 }, { 7399, 18 }, { 6608, 19 }, 
        arrayOfInt11, arrayOfInt12, arrayOfInt13, { 2107, 23 }, { 13663, 24 }, arrayOfInt14, { 16177, 26 }, { 14854, 27 }, { 9396, 28 }, { 8579, 29 }, 
        { 11994, 30 }, { 11245, 31 } };
  }
  
  private FormatInformation(int paramInt) {
    this.b = ErrorCorrectionLevel.a(paramInt >> 3 & 0x3);
    this.c = (byte)(paramInt & 0x7);
  }
  
  static int a(int paramInt1, int paramInt2) {
    return Integer.bitCount(paramInt1 ^ paramInt2);
  }
  
  static FormatInformation b(int paramInt1, int paramInt2) {
    FormatInformation formatInformation = c(paramInt1, paramInt2);
    return (formatInformation != null) ? formatInformation : c(paramInt1 ^ 0x5412, paramInt2 ^ 0x5412);
  }
  
  private static FormatInformation c(int paramInt1, int paramInt2) {
    int[][] arrayOfInt = a;
    int m = arrayOfInt.length;
    int k = 0;
    int j = Integer.MAX_VALUE;
    int i;
    for (i = 0; k < m; i = i1) {
      int[] arrayOfInt1 = arrayOfInt[k];
      int i2 = arrayOfInt1[0];
      if (i2 == paramInt1 || i2 == paramInt2)
        return new FormatInformation(arrayOfInt1[1]); 
      int i1 = a(paramInt1, i2);
      int n = j;
      if (i1 < j) {
        i = arrayOfInt1[1];
        n = i1;
      } 
      j = n;
      i1 = i;
      if (paramInt1 != paramInt2) {
        i2 = a(paramInt2, i2);
        j = n;
        i1 = i;
        if (i2 < n) {
          i1 = arrayOfInt1[1];
          j = i2;
        } 
      } 
      k++;
    } 
    return (j <= 3) ? new FormatInformation(i) : null;
  }
  
  ErrorCorrectionLevel a() {
    return this.b;
  }
  
  byte b() {
    return this.c;
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof FormatInformation))
      return false; 
    paramObject = paramObject;
    return (this.b == ((FormatInformation)paramObject).b && this.c == ((FormatInformation)paramObject).c);
  }
  
  public int hashCode() {
    return this.b.ordinal() << 3 | this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\qrcode\decoder\FormatInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */