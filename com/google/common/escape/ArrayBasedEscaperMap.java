package com.google.common.escape;

import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public final class ArrayBasedEscaperMap {
  private static final char[][] b = (char[][])Array.newInstance(char.class, new int[] { 0, 0 });
  
  private final char[][] a;
  
  private ArrayBasedEscaperMap(char[][] paramArrayOfchar) {
    this.a = paramArrayOfchar;
  }
  
  public static ArrayBasedEscaperMap a(Map<Character, String> paramMap) {
    return new ArrayBasedEscaperMap(b(paramMap));
  }
  
  static char[][] b(Map<Character, String> paramMap) {
    Preconditions.a(paramMap);
    if (paramMap.isEmpty())
      return b; 
    char[][] arrayOfChar = new char[((Character)Collections.max(paramMap.keySet())).charValue() + 1][];
    Iterator<Character> iterator = paramMap.keySet().iterator();
    while (iterator.hasNext()) {
      char c = ((Character)iterator.next()).charValue();
      arrayOfChar[c] = ((String)paramMap.get(Character.valueOf(c))).toCharArray();
    } 
    return arrayOfChar;
  }
  
  char[][] a() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\escape\ArrayBasedEscaperMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */