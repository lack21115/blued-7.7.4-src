package com.google.zxing;

public final class InvertedLuminanceSource extends LuminanceSource {
  private final LuminanceSource a;
  
  public InvertedLuminanceSource(LuminanceSource paramLuminanceSource) {
    super(paramLuminanceSource.d(), paramLuminanceSource.e());
    this.a = paramLuminanceSource;
  }
  
  public LuminanceSource a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return new InvertedLuminanceSource(this.a.a(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public byte[] a() {
    byte[] arrayOfByte1 = this.a.a();
    int j = d() * e();
    byte[] arrayOfByte2 = new byte[j];
    for (int i = 0; i < j; i++)
      arrayOfByte2[i] = (byte)(255 - (arrayOfByte1[i] & 0xFF)); 
    return arrayOfByte2;
  }
  
  public byte[] a(int paramInt, byte[] paramArrayOfbyte) {
    paramArrayOfbyte = this.a.a(paramInt, paramArrayOfbyte);
    int i = d();
    for (paramInt = 0; paramInt < i; paramInt++)
      paramArrayOfbyte[paramInt] = (byte)(255 - (paramArrayOfbyte[paramInt] & 0xFF)); 
    return paramArrayOfbyte;
  }
  
  public boolean b() {
    return this.a.b();
  }
  
  public LuminanceSource c() {
    return new InvertedLuminanceSource(this.a.c());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\InvertedLuminanceSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */