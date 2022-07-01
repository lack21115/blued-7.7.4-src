package com.google.common.base;

final class SmallCharMatcher extends CharMatcher.NamedFastMatcher {
  private final char[] a;
  
  private final boolean b;
  
  private final long c;
  
  static int a(int paramInt) {
    return Integer.rotateLeft(paramInt * -862048943, 15) * 461845907;
  }
  
  private boolean b(int paramInt) {
    return (1L == (this.c >> paramInt & 0x1L));
  }
  
  public boolean c(char paramChar) {
    if (paramChar == '\000')
      return this.b; 
    if (!b(paramChar))
      return false; 
    int k = this.a.length - 1;
    int j = a(paramChar) & k;
    int i = j;
    while (true) {
      char[] arrayOfChar = this.a;
      if (arrayOfChar[i] == '\000')
        return false; 
      if (arrayOfChar[i] == paramChar)
        return true; 
      int m = i + 1 & k;
      i = m;
      if (m == j)
        return false; 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\SmallCharMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */