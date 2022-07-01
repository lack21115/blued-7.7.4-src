package com.google.zxing.common;

public final class BitSource {
  private final byte[] a;
  
  private int b;
  
  private int c;
  
  public BitSource(byte[] paramArrayOfbyte) {
    this.a = paramArrayOfbyte;
  }
  
  public int a() {
    return this.c;
  }
  
  public int a(int paramInt) {
    if (paramInt > 0 && paramInt <= 32 && paramInt <= c()) {
      int i = this.c;
      if (i > 0) {
        int k = 8 - i;
        if (paramInt < k) {
          i = paramInt;
        } else {
          i = k;
        } 
        k -= i;
        byte[] arrayOfByte = this.a;
        int n = this.b;
        k = (255 >> 8 - i << k & arrayOfByte[n]) >> k;
        int m = paramInt - i;
        this.c += i;
        paramInt = k;
        i = m;
        if (this.c == 8) {
          this.c = 0;
          this.b = n + 1;
          paramInt = k;
          i = m;
        } 
      } else {
        boolean bool = false;
        i = paramInt;
        paramInt = bool;
      } 
      int j = paramInt;
      if (i > 0) {
        while (i >= 8) {
          byte[] arrayOfByte = this.a;
          j = this.b;
          paramInt = paramInt << 8 | arrayOfByte[j] & 0xFF;
          this.b = j + 1;
          i -= 8;
        } 
        j = paramInt;
        if (i > 0) {
          j = 8 - i;
          j = paramInt << i | (255 >> j << j & this.a[this.b]) >> j;
          this.c += i;
        } 
      } 
      return j;
    } 
    throw new IllegalArgumentException(String.valueOf(paramInt));
  }
  
  public int b() {
    return this.b;
  }
  
  public int c() {
    return (this.a.length - this.b) * 8 - this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\common\BitSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */