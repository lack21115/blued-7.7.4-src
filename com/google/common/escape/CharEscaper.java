package com.google.common.escape;

import com.google.common.base.Preconditions;

public abstract class CharEscaper extends Escaper {
  private static char[] a(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    if (paramInt2 >= 0) {
      char[] arrayOfChar = new char[paramInt2];
      if (paramInt1 > 0)
        System.arraycopy(paramArrayOfchar, 0, arrayOfChar, 0, paramInt1); 
      return arrayOfChar;
    } 
    throw new AssertionError("Cannot increase internal buffer any further");
  }
  
  public String a(String paramString) {
    Preconditions.a(paramString);
    int j = paramString.length();
    for (int i = 0; i < j; i++) {
      if (a(paramString.charAt(i)) != null)
        return a(paramString, i); 
    } 
    return paramString;
  }
  
  protected final String a(String paramString, int paramInt) {
    int n = paramString.length();
    char[] arrayOfChar = Platform.a();
    int i = arrayOfChar.length;
    int m = 0;
    int j = 0;
    int k = paramInt;
    paramInt = j;
    while (k < n) {
      char[] arrayOfChar1 = a(paramString.charAt(k));
      if (arrayOfChar1 != null) {
        int i2 = arrayOfChar1.length;
        int i3 = k - m;
        int i1 = paramInt + i3;
        int i4 = i1 + i2;
        j = i;
        char[] arrayOfChar2 = arrayOfChar;
        if (i < i4) {
          j = (n - k) * 2 + i4;
          arrayOfChar2 = a(arrayOfChar, paramInt, j);
        } 
        i = paramInt;
        if (i3 > 0) {
          paramString.getChars(m, k, arrayOfChar2, paramInt);
          i = i1;
        } 
        paramInt = i;
        if (i2 > 0) {
          System.arraycopy(arrayOfChar1, 0, arrayOfChar2, i, i2);
          paramInt = i + i2;
        } 
        m = k + 1;
        arrayOfChar = arrayOfChar2;
        i = j;
      } 
      k++;
    } 
    j = n - m;
    if (j > 0) {
      j += paramInt;
      char[] arrayOfChar1 = arrayOfChar;
      if (i < j)
        arrayOfChar1 = a(arrayOfChar, paramInt, j); 
      paramString.getChars(m, n, arrayOfChar1, paramInt);
      arrayOfChar = arrayOfChar1;
      paramInt = j;
    } 
    return new String(arrayOfChar, 0, paramInt);
  }
  
  protected abstract char[] a(char paramChar);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\escape\CharEscaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */