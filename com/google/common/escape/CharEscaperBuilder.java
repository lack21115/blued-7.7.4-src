package com.google.common.escape;

import java.util.HashMap;
import java.util.Map;

public final class CharEscaperBuilder {
  private final Map<Character, String> a = new HashMap<Character, String>();
  
  private int b = -1;
  
  static class CharArrayDecorator extends CharEscaper {
    private final char[][] a;
    
    private final int b;
    
    public String a(String param1String) {
      int j = param1String.length();
      for (int i = 0; i < j; i++) {
        char c = param1String.charAt(i);
        char[][] arrayOfChar = this.a;
        if (c < arrayOfChar.length && arrayOfChar[c] != null)
          return a(param1String, i); 
      } 
      return param1String;
    }
    
    protected char[] a(char param1Char) {
      return (param1Char < this.b) ? this.a[param1Char] : null;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\escape\CharEscaperBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */