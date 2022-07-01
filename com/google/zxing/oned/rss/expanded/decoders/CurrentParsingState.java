package com.google.zxing.oned.rss.expanded.decoders;

final class CurrentParsingState {
  private int a = 0;
  
  private State b = State.a;
  
  int a() {
    return this.a;
  }
  
  void a(int paramInt) {
    this.a = paramInt;
  }
  
  void b(int paramInt) {
    this.a += paramInt;
  }
  
  boolean b() {
    return (this.b == State.b);
  }
  
  boolean c() {
    return (this.b == State.c);
  }
  
  void d() {
    this.b = State.a;
  }
  
  void e() {
    this.b = State.b;
  }
  
  void f() {
    this.b = State.c;
  }
  
  enum State {
    a, b, c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\CurrentParsingState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */