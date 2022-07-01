package com.google.zxing.oned.rss;

final class Pair extends DataCharacter {
  private final FinderPattern a;
  
  private int b;
  
  Pair(int paramInt1, int paramInt2, FinderPattern paramFinderPattern) {
    super(paramInt1, paramInt2);
    this.a = paramFinderPattern;
  }
  
  FinderPattern c() {
    return this.a;
  }
  
  int d() {
    return this.b;
  }
  
  void e() {
    this.b++;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\Pair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */