package com.google.zxing;

public abstract class LuminanceSource {
  private final int a;
  
  private final int b;
  
  protected LuminanceSource(int paramInt1, int paramInt2) {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public LuminanceSource a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    throw new UnsupportedOperationException("This luminance source does not support cropping.");
  }
  
  public abstract byte[] a();
  
  public abstract byte[] a(int paramInt, byte[] paramArrayOfbyte);
  
  public boolean b() {
    return false;
  }
  
  public LuminanceSource c() {
    throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
  }
  
  public final int d() {
    return this.a;
  }
  
  public final int e() {
    return this.b;
  }
  
  public final String toString() {
    int i = this.a;
    byte[] arrayOfByte = new byte[i];
    StringBuilder stringBuilder = new StringBuilder(this.b * (i + 1));
    for (i = 0; i < this.b; i++) {
      arrayOfByte = a(i, arrayOfByte);
      for (int j = 0; j < this.a; j++) {
        byte b;
        int k = arrayOfByte[j] & 0xFF;
        if (k < 64) {
          b = 35;
        } else if (k < 128) {
          b = 43;
        } else if (k < 192) {
          b = 46;
        } else {
          b = 32;
        } 
        stringBuilder.append(b);
      } 
      stringBuilder.append('\n');
    } 
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\LuminanceSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */