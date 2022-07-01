package com.google.zxing.aztec.encoder;

abstract class Token {
  static final Token a = new SimpleToken(null, 0, 0);
  
  private final Token b;
  
  Token(Token paramToken) {
    this.b = paramToken;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\aztec\encoder\Token.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */