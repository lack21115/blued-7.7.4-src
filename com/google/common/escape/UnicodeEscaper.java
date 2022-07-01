package com.google.common.escape;

import com.google.common.base.Preconditions;

public abstract class UnicodeEscaper extends Escaper {
  private static char[] a(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    if (paramInt2 >= 0) {
      char[] arrayOfChar = new char[paramInt2];
      if (paramInt1 > 0)
        System.arraycopy(paramArrayOfchar, 0, arrayOfChar, 0, paramInt1); 
      return arrayOfChar;
    } 
    throw new AssertionError("Cannot increase internal buffer any further");
  }
  
  protected static int b(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
    Preconditions.a(paramCharSequence);
    if (paramInt1 < paramInt2) {
      int i = paramInt1 + 1;
      char c = paramCharSequence.charAt(paramInt1);
      if (c >= '?') {
        if (c > '?')
          return c; 
        if (c <= '?') {
          if (i == paramInt2)
            return -c; 
          char c1 = paramCharSequence.charAt(i);
          if (Character.isLowSurrogate(c1))
            return Character.toCodePoint(c, c1); 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Expected low surrogate but got char '");
          stringBuilder1.append(c1);
          stringBuilder1.append("' with value ");
          stringBuilder1.append(c1);
          stringBuilder1.append(" at index ");
          stringBuilder1.append(i);
          stringBuilder1.append(" in '");
          stringBuilder1.append(paramCharSequence);
          stringBuilder1.append("'");
          throw new IllegalArgumentException(stringBuilder1.toString());
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected low surrogate character '");
        stringBuilder.append(c);
        stringBuilder.append("' with value ");
        stringBuilder.append(c);
        stringBuilder.append(" at index ");
        stringBuilder.append(i - 1);
        stringBuilder.append(" in '");
        stringBuilder.append(paramCharSequence);
        stringBuilder.append("'");
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      return c;
    } 
    throw new IndexOutOfBoundsException("Index exceeds specified range");
  }
  
  protected int a(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      int i = b(paramCharSequence, paramInt1, paramInt2);
      if (i >= 0) {
        if (a(i) != null)
          return paramInt1; 
        if (Character.isSupplementaryCodePoint(i)) {
          i = 2;
        } else {
          i = 1;
        } 
        paramInt1 += i;
      } 
    } 
    return paramInt1;
  }
  
  public String a(String paramString) {
    Preconditions.a(paramString);
    int i = paramString.length();
    int j = a(paramString, 0, i);
    return (j == i) ? paramString : a(paramString, j);
  }
  
  protected final String a(String paramString, int paramInt) {
    int m = paramString.length();
    char[] arrayOfChar = Platform.a();
    int j = 0;
    int i = 0;
    int k = paramInt;
    paramInt = i;
    while (k < m) {
      i = b(paramString, k, m);
      if (i >= 0) {
        char[] arrayOfChar2 = a(i);
        if (Character.isSupplementaryCodePoint(i)) {
          i = 2;
        } else {
          i = 1;
        } 
        int i1 = i + k;
        int n = j;
        i = paramInt;
        char[] arrayOfChar1 = arrayOfChar;
        if (arrayOfChar2 != null) {
          int i2 = k - j;
          n = paramInt + i2;
          i = arrayOfChar2.length + n;
          arrayOfChar1 = arrayOfChar;
          if (arrayOfChar.length < i)
            arrayOfChar1 = a(arrayOfChar, paramInt, i + m - k + 32); 
          i = paramInt;
          if (i2 > 0) {
            paramString.getChars(j, k, arrayOfChar1, paramInt);
            i = n;
          } 
          paramInt = i;
          if (arrayOfChar2.length > 0) {
            System.arraycopy(arrayOfChar2, 0, arrayOfChar1, i, arrayOfChar2.length);
            paramInt = i + arrayOfChar2.length;
          } 
          n = i1;
          i = paramInt;
        } 
        k = a(paramString, i1, m);
        j = n;
        paramInt = i;
        arrayOfChar = arrayOfChar1;
        continue;
      } 
      throw new IllegalArgumentException("Trailing high surrogate at end of input");
    } 
    i = m - j;
    if (i > 0) {
      i += paramInt;
      char[] arrayOfChar1 = arrayOfChar;
      if (arrayOfChar.length < i)
        arrayOfChar1 = a(arrayOfChar, paramInt, i); 
      paramString.getChars(j, m, arrayOfChar1, paramInt);
      arrayOfChar = arrayOfChar1;
      paramInt = i;
    } 
    return new String(arrayOfChar, 0, paramInt);
  }
  
  protected abstract char[] a(int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\escape\UnicodeEscaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */