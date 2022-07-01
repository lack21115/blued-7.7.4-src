package com.google.zxing.aztec.encoder;

final class SimpleToken extends Token {
  private final short b;
  
  private final short c;
  
  SimpleToken(Token paramToken, int paramInt1, int paramInt2) {
    super(paramToken);
    this.b = (short)paramInt1;
    this.c = (short)paramInt2;
  }
  
  public String toString() {
    short s1 = this.b;
    short s2 = this.c;
    StringBuilder stringBuilder = new StringBuilder("<");
    stringBuilder.append(Integer.toBinaryString(s1 & (1 << s2) - 1 | 1 << s2 | 1 << this.c).substring(1));
    stringBuilder.append('>');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\aztec\encoder\SimpleToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */