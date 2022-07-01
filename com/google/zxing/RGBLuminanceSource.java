package com.google.zxing;

public final class RGBLuminanceSource extends LuminanceSource {
  private final byte[] a;
  
  private final int b;
  
  private final int c;
  
  private final int d;
  
  private final int e;
  
  public RGBLuminanceSource(int paramInt1, int paramInt2, int[] paramArrayOfint) {
    super(paramInt1, paramInt2);
    this.b = paramInt1;
    this.c = paramInt2;
    int i = 0;
    this.d = 0;
    this.e = 0;
    paramInt2 = paramInt1 * paramInt2;
    this.a = new byte[paramInt2];
    for (paramInt1 = i; paramInt1 < paramInt2; paramInt1++) {
      i = paramArrayOfint[paramInt1];
      this.a[paramInt1] = (byte)(((i >> 16 & 0xFF) + (i >> 7 & 0x1FE) + (i & 0xFF)) / 4);
    } 
  }
  
  private RGBLuminanceSource(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    super(paramInt5, paramInt6);
    if (paramInt5 + paramInt3 <= paramInt1 && paramInt6 + paramInt4 <= paramInt2) {
      this.a = paramArrayOfbyte;
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramInt3;
      this.e = paramInt4;
      return;
    } 
    throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
  }
  
  public LuminanceSource a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return new RGBLuminanceSource(this.a, this.b, this.c, this.d + paramInt1, this.e + paramInt2, paramInt3, paramInt4);
  }
  
  public byte[] a() {
    int m = d();
    int n = e();
    if (m == this.b && n == this.c)
      return this.a; 
    int i1 = m * n;
    byte[] arrayOfByte = new byte[i1];
    int i = this.e;
    int i2 = this.b;
    int k = i * i2 + this.d;
    int j = 0;
    i = k;
    if (m == i2) {
      System.arraycopy(this.a, k, arrayOfByte, 0, i1);
      return arrayOfByte;
    } 
    while (j < n) {
      System.arraycopy(this.a, i, arrayOfByte, j * m, m);
      i += this.b;
      j++;
    } 
    return arrayOfByte;
  }
  
  public byte[] a(int paramInt, byte[] paramArrayOfbyte) {
    int i;
    if (paramInt >= 0 && paramInt < e()) {
      i = d();
      if (paramArrayOfbyte != null) {
        byte[] arrayOfByte1 = paramArrayOfbyte;
        if (paramArrayOfbyte.length < i) {
          arrayOfByte1 = new byte[i];
          int i3 = this.e;
          int i4 = this.b;
          int i5 = this.d;
          System.arraycopy(this.a, (paramInt + i3) * i4 + i5, arrayOfByte1, 0, i);
          return arrayOfByte1;
        } 
        int n = this.e;
        int i1 = this.b;
        int i2 = this.d;
        System.arraycopy(this.a, (paramInt + n) * i1 + i2, arrayOfByte1, 0, i);
        return arrayOfByte1;
      } 
    } else {
      throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(paramInt)));
    } 
    byte[] arrayOfByte = new byte[i];
    int j = this.e;
    int k = this.b;
    int m = this.d;
    System.arraycopy(this.a, (paramInt + j) * k + m, arrayOfByte, 0, i);
    return arrayOfByte;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\RGBLuminanceSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */