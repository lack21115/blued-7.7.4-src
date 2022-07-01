package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;

public final class Version {
  private static final Version[] a = h();
  
  private final int b;
  
  private final int c;
  
  private final int d;
  
  private final int e;
  
  private final int f;
  
  private final ECBlocks g;
  
  private final int h;
  
  private Version(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, ECBlocks paramECBlocks) {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramInt5;
    this.g = paramECBlocks;
    paramInt3 = paramECBlocks.a();
    ECB[] arrayOfECB = paramECBlocks.b();
    paramInt4 = arrayOfECB.length;
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < paramInt4) {
      ECB eCB = arrayOfECB[paramInt1];
      paramInt2 += eCB.a() * (eCB.b() + paramInt3);
      paramInt1++;
    } 
    this.h = paramInt2;
  }
  
  public static Version a(int paramInt1, int paramInt2) throws FormatException {
    if ((paramInt1 & 0x1) == 0 && (paramInt2 & 0x1) == 0) {
      for (Version version : a) {
        if (version.c == paramInt1 && version.d == paramInt2)
          return version; 
      } 
      throw FormatException.a();
    } 
    throw FormatException.a();
  }
  
  private static Version[] h() {
    return new Version[] { 
        new Version(1, 10, 10, 8, 8, new ECBlocks(5, new ECB(1, 3))), new Version(2, 12, 12, 10, 10, new ECBlocks(7, new ECB(1, 5))), new Version(3, 14, 14, 12, 12, new ECBlocks(10, new ECB(1, 8))), new Version(4, 16, 16, 14, 14, new ECBlocks(12, new ECB(1, 12))), new Version(5, 18, 18, 16, 16, new ECBlocks(14, new ECB(1, 18))), new Version(6, 20, 20, 18, 18, new ECBlocks(18, new ECB(1, 22))), new Version(7, 22, 22, 20, 20, new ECBlocks(20, new ECB(1, 30))), new Version(8, 24, 24, 22, 22, new ECBlocks(24, new ECB(1, 36))), new Version(9, 26, 26, 24, 24, new ECBlocks(28, new ECB(1, 44))), new Version(10, 32, 32, 14, 14, new ECBlocks(36, new ECB(1, 62))), 
        new Version(11, 36, 36, 16, 16, new ECBlocks(42, new ECB(1, 86))), new Version(12, 40, 40, 18, 18, new ECBlocks(48, new ECB(1, 114))), new Version(13, 44, 44, 20, 20, new ECBlocks(56, new ECB(1, 144))), new Version(14, 48, 48, 22, 22, new ECBlocks(68, new ECB(1, 174))), new Version(15, 52, 52, 24, 24, new ECBlocks(42, new ECB(2, 102))), new Version(16, 64, 64, 14, 14, new ECBlocks(56, new ECB(2, 140))), new Version(17, 72, 72, 16, 16, new ECBlocks(36, new ECB(4, 92))), new Version(18, 80, 80, 18, 18, new ECBlocks(48, new ECB(4, 114))), new Version(19, 88, 88, 20, 20, new ECBlocks(56, new ECB(4, 144))), new Version(20, 96, 96, 22, 22, new ECBlocks(68, new ECB(4, 174))), 
        new Version(21, 104, 104, 24, 24, new ECBlocks(56, new ECB(6, 136))), new Version(22, 120, 120, 18, 18, new ECBlocks(68, new ECB(6, 175))), new Version(23, 132, 132, 20, 20, new ECBlocks(62, new ECB(8, 163))), new Version(24, 144, 144, 22, 22, new ECBlocks(62, new ECB(8, 156), new ECB(2, 155))), new Version(25, 8, 18, 6, 16, new ECBlocks(7, new ECB(1, 5))), new Version(26, 8, 32, 6, 14, new ECBlocks(11, new ECB(1, 10))), new Version(27, 12, 26, 10, 24, new ECBlocks(14, new ECB(1, 16))), new Version(28, 12, 36, 10, 16, new ECBlocks(18, new ECB(1, 22))), new Version(29, 16, 36, 14, 16, new ECBlocks(24, new ECB(1, 32))), new Version(30, 16, 48, 14, 22, new ECBlocks(28, new ECB(1, 49))) };
  }
  
  public int a() {
    return this.b;
  }
  
  public int b() {
    return this.c;
  }
  
  public int c() {
    return this.d;
  }
  
  public int d() {
    return this.e;
  }
  
  public int e() {
    return this.f;
  }
  
  public int f() {
    return this.h;
  }
  
  ECBlocks g() {
    return this.g;
  }
  
  public String toString() {
    return String.valueOf(this.b);
  }
  
  static final class ECB {
    private final int a;
    
    private final int b;
    
    private ECB(int param1Int1, int param1Int2) {
      this.a = param1Int1;
      this.b = param1Int2;
    }
    
    int a() {
      return this.a;
    }
    
    int b() {
      return this.b;
    }
  }
  
  static final class ECBlocks {
    private final int a;
    
    private final Version.ECB[] b;
    
    private ECBlocks(int param1Int, Version.ECB param1ECB) {
      this.a = param1Int;
      this.b = new Version.ECB[] { param1ECB };
    }
    
    private ECBlocks(int param1Int, Version.ECB param1ECB1, Version.ECB param1ECB2) {
      this.a = param1Int;
      this.b = new Version.ECB[] { param1ECB1, param1ECB2 };
    }
    
    int a() {
      return this.a;
    }
    
    Version.ECB[] b() {
      return this.b;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\datamatrix\decoder\Version.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */