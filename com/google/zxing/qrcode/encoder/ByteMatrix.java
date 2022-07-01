package com.google.zxing.qrcode.encoder;

public final class ByteMatrix {
  private final byte[][] a;
  
  private final int b;
  
  private final int c;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(this.b * 2 * this.c + 2);
    for (int i = 0; i < this.c; i++) {
      byte[] arrayOfByte = this.a[i];
      for (int j = 0; j < this.b; j++) {
        byte b = arrayOfByte[j];
        if (b != 0) {
          if (b != 1) {
            stringBuilder.append("  ");
          } else {
            stringBuilder.append(" 1");
          } 
        } else {
          stringBuilder.append(" 0");
        } 
      } 
      stringBuilder.append('\n');
    } 
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\qrcode\encoder\ByteMatrix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */