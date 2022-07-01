package com.bytedance.sdk.a.b.a.e;

import java.util.Arrays;

public final class n {
  private int a;
  
  private final int[] b = new int[10];
  
  n a(int paramInt1, int paramInt2) {
    if (paramInt1 >= 0) {
      int[] arrayOfInt = this.b;
      if (paramInt1 >= arrayOfInt.length)
        return this; 
      this.a = 1 << paramInt1 | this.a;
      arrayOfInt[paramInt1] = paramInt2;
    } 
    return this;
  }
  
  void a() {
    this.a = 0;
    Arrays.fill(this.b, 0);
  }
  
  void a(n paramn) {
    for (int i = 0; i < 10; i++) {
      if (paramn.a(i))
        a(i, paramn.b(i)); 
    } 
  }
  
  boolean a(int paramInt) {
    return ((1 << paramInt & this.a) != 0);
  }
  
  int b() {
    return Integer.bitCount(this.a);
  }
  
  int b(int paramInt) {
    return this.b[paramInt];
  }
  
  int c() {
    return ((this.a & 0x2) != 0) ? this.b[1] : -1;
  }
  
  int c(int paramInt) {
    if ((this.a & 0x10) != 0)
      paramInt = this.b[4]; 
    return paramInt;
  }
  
  int d() {
    return ((this.a & 0x80) != 0) ? this.b[7] : 65535;
  }
  
  int d(int paramInt) {
    if ((this.a & 0x20) != 0)
      paramInt = this.b[5]; 
    return paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\e\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */