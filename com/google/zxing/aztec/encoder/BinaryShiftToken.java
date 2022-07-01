package com.google.zxing.aztec.encoder;

final class BinaryShiftToken extends Token {
  private final short b;
  
  private final short c;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("<");
    stringBuilder.append(this.b);
    stringBuilder.append("::");
    stringBuilder.append(this.b + this.c - 1);
    stringBuilder.append('>');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\aztec\encoder\BinaryShiftToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */