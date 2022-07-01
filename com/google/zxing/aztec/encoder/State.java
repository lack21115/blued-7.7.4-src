package com.google.zxing.aztec.encoder;

final class State {
  static final State a = new State(Token.a, 0, 0, 0);
  
  private final int b;
  
  private final Token c;
  
  private final int d;
  
  private final int e;
  
  private State(Token paramToken, int paramInt1, int paramInt2, int paramInt3) {
    this.c = paramToken;
    this.b = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
  }
  
  int a() {
    return this.e;
  }
  
  public String toString() {
    return String.format("%s bits=%d bytes=%d", new Object[] { HighLevelEncoder.a[this.b], Integer.valueOf(this.e), Integer.valueOf(this.d) });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\aztec\encoder\State.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */