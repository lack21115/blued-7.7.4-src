package com.google.common.escape;

import com.google.common.base.Preconditions;
import java.util.Map;

public abstract class ArrayBasedCharEscaper extends CharEscaper {
  private final char[][] a;
  
  private final int b;
  
  private final char c;
  
  private final char d;
  
  protected ArrayBasedCharEscaper(ArrayBasedEscaperMap paramArrayBasedEscaperMap, char paramChar1, char paramChar2) {
    Preconditions.a(paramArrayBasedEscaperMap);
    this.a = paramArrayBasedEscaperMap.a();
    this.b = this.a.length;
    char c2 = paramChar1;
    char c1 = paramChar2;
    if (paramChar2 < paramChar1) {
      c1 = Character.MIN_VALUE;
      c2 = '￿';
    } 
    this.c = c2;
    this.d = c1;
  }
  
  protected ArrayBasedCharEscaper(Map<Character, String> paramMap, char paramChar1, char paramChar2) {
    this(ArrayBasedEscaperMap.a(paramMap), paramChar1, paramChar2);
  }
  
  public final String a(String paramString) {
    String str;
    Preconditions.a(paramString);
    int i = 0;
    while (true) {
      str = paramString;
      if (i < paramString.length()) {
        char c = paramString.charAt(i);
        if ((c < this.b && this.a[c] != null) || c > this.d || c < this.c) {
          str = a(paramString, i);
          break;
        } 
        i++;
        continue;
      } 
      break;
    } 
    return str;
  }
  
  protected final char[] a(char paramChar) {
    if (paramChar < this.b) {
      char[] arrayOfChar = this.a[paramChar];
      if (arrayOfChar != null)
        return arrayOfChar; 
    } 
    return (paramChar >= this.c && paramChar <= this.d) ? null : b(paramChar);
  }
  
  protected abstract char[] b(char paramChar);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\escape\ArrayBasedCharEscaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */