package com.google.zxing.datamatrix.encoder;

public class SymbolInfo {
  static final SymbolInfo[] a;
  
  private static SymbolInfo[] d;
  
  public final int b;
  
  public final int c;
  
  private final boolean e;
  
  private final int f;
  
  private final int g;
  
  private final int h;
  
  private final int i;
  
  private final int j;
  
  static {
    SymbolInfo[] arrayOfSymbolInfo = new SymbolInfo[30];
    arrayOfSymbolInfo[0] = new SymbolInfo(false, 3, 5, 8, 8, 1);
    arrayOfSymbolInfo[1] = new SymbolInfo(false, 5, 7, 10, 10, 1);
    arrayOfSymbolInfo[2] = new SymbolInfo(true, 5, 7, 16, 6, 1);
    arrayOfSymbolInfo[3] = new SymbolInfo(false, 8, 10, 12, 12, 1);
    arrayOfSymbolInfo[4] = new SymbolInfo(true, 10, 11, 14, 6, 2);
    arrayOfSymbolInfo[5] = new SymbolInfo(false, 12, 12, 14, 14, 1);
    arrayOfSymbolInfo[6] = new SymbolInfo(true, 16, 14, 24, 10, 1);
    arrayOfSymbolInfo[7] = new SymbolInfo(false, 18, 14, 16, 16, 1);
    arrayOfSymbolInfo[8] = new SymbolInfo(false, 22, 18, 18, 18, 1);
    arrayOfSymbolInfo[9] = new SymbolInfo(true, 22, 18, 16, 10, 2);
    arrayOfSymbolInfo[10] = new SymbolInfo(false, 30, 20, 20, 20, 1);
    arrayOfSymbolInfo[11] = new SymbolInfo(true, 32, 24, 16, 14, 2);
    arrayOfSymbolInfo[12] = new SymbolInfo(false, 36, 24, 22, 22, 1);
    arrayOfSymbolInfo[13] = new SymbolInfo(false, 44, 28, 24, 24, 1);
    arrayOfSymbolInfo[14] = new SymbolInfo(true, 49, 28, 22, 14, 2);
    arrayOfSymbolInfo[15] = new SymbolInfo(false, 62, 36, 14, 14, 4);
    arrayOfSymbolInfo[16] = new SymbolInfo(false, 86, 42, 16, 16, 4);
    arrayOfSymbolInfo[17] = new SymbolInfo(false, 114, 48, 18, 18, 4);
    arrayOfSymbolInfo[18] = new SymbolInfo(false, 144, 56, 20, 20, 4);
    arrayOfSymbolInfo[19] = new SymbolInfo(false, 174, 68, 22, 22, 4);
    arrayOfSymbolInfo[20] = new SymbolInfo(false, 204, 84, 24, 24, 4, 102, 42);
    arrayOfSymbolInfo[21] = new SymbolInfo(false, 280, 112, 14, 14, 16, 140, 56);
    arrayOfSymbolInfo[22] = new SymbolInfo(false, 368, 144, 16, 16, 16, 92, 36);
    arrayOfSymbolInfo[23] = new SymbolInfo(false, 456, 192, 18, 18, 16, 114, 48);
    arrayOfSymbolInfo[24] = new SymbolInfo(false, 576, 224, 20, 20, 16, 144, 56);
    arrayOfSymbolInfo[25] = new SymbolInfo(false, 696, 272, 22, 22, 16, 174, 68);
    arrayOfSymbolInfo[26] = new SymbolInfo(false, 816, 336, 24, 24, 16, 136, 56);
    arrayOfSymbolInfo[27] = new SymbolInfo(false, 1050, 408, 18, 18, 36, 175, 68);
    arrayOfSymbolInfo[28] = new SymbolInfo(false, 1304, 496, 20, 20, 36, 163, 62);
    arrayOfSymbolInfo[29] = new DataMatrixSymbolInfo144();
    a = arrayOfSymbolInfo;
    d = arrayOfSymbolInfo;
  }
  
  public SymbolInfo(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    this(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt1, paramInt2);
  }
  
  SymbolInfo(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
    this.e = paramBoolean;
    this.f = paramInt1;
    this.g = paramInt2;
    this.b = paramInt3;
    this.c = paramInt4;
    this.h = paramInt5;
    this.i = paramInt6;
    this.j = paramInt7;
  }
  
  private int e() {
    int i = this.h;
    byte b = 1;
    if (i != 1) {
      byte b1 = 2;
      b = b1;
      if (i != 2) {
        b = b1;
        if (i != 4) {
          if (i != 16) {
            if (i == 36)
              return 6; 
            throw new IllegalStateException("Cannot handle this number of data regions");
          } 
          return 4;
        } 
      } 
    } 
    return b;
  }
  
  private int f() {
    int i = this.h;
    if (i != 1 && i != 2) {
      if (i != 4) {
        if (i != 16) {
          if (i == 36)
            return 6; 
          throw new IllegalStateException("Cannot handle this number of data regions");
        } 
        return 4;
      } 
      return 2;
    } 
    return 1;
  }
  
  public final int a() {
    return e() * this.b;
  }
  
  public final int b() {
    return f() * this.c;
  }
  
  public final int c() {
    return a() + (e() << 1);
  }
  
  public final int d() {
    return b() + (f() << 1);
  }
  
  public final String toString() {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    if (this.e) {
      str = "Rectangular Symbol:";
    } else {
      str = "Square Symbol:";
    } 
    stringBuilder.append(str);
    stringBuilder.append(" data region ");
    stringBuilder.append(this.b);
    stringBuilder.append('x');
    stringBuilder.append(this.c);
    stringBuilder.append(", symbol size ");
    stringBuilder.append(c());
    stringBuilder.append('x');
    stringBuilder.append(d());
    stringBuilder.append(", symbol data size ");
    stringBuilder.append(a());
    stringBuilder.append('x');
    stringBuilder.append(b());
    stringBuilder.append(", codewords ");
    stringBuilder.append(this.f);
    stringBuilder.append('+');
    stringBuilder.append(this.g);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\datamatrix\encoder\SymbolInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */