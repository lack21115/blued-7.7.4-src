package com.google.common.net;

import com.google.common.base.Preconditions;
import com.google.common.escape.UnicodeEscaper;

public final class PercentEscaper extends UnicodeEscaper {
  private static final char[] a = new char[] { '+' };
  
  private static final char[] b = "0123456789ABCDEF".toCharArray();
  
  private final boolean c;
  
  private final boolean[] d;
  
  public PercentEscaper(String paramString, boolean paramBoolean) {
    Preconditions.a(paramString);
    if (!paramString.matches(".*[0-9A-Za-z].*")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
      paramString = stringBuilder.toString();
      if (!paramBoolean || !paramString.contains(" ")) {
        this.c = paramBoolean;
        this.d = b(paramString);
        return;
      } 
      throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
    } 
    throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
  }
  
  private static boolean[] b(String paramString) {
    char[] arrayOfChar = paramString.toCharArray();
    int k = arrayOfChar.length;
    boolean bool = false;
    int i = 0;
    int j = -1;
    while (i < k) {
      j = Math.max(arrayOfChar[i], j);
      i++;
    } 
    boolean[] arrayOfBoolean = new boolean[j + 1];
    j = arrayOfChar.length;
    for (i = bool; i < j; i++)
      arrayOfBoolean[arrayOfChar[i]] = true; 
    return arrayOfBoolean;
  }
  
  public int a(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
    Preconditions.a(paramCharSequence);
    while (paramInt1 < paramInt2) {
      char c = paramCharSequence.charAt(paramInt1);
      boolean[] arrayOfBoolean = this.d;
      if (c < arrayOfBoolean.length) {
        if (!arrayOfBoolean[c])
          return paramInt1; 
        paramInt1++;
      } 
    } 
    return paramInt1;
  }
  
  public String a(String paramString) {
    String str;
    Preconditions.a(paramString);
    int j = paramString.length();
    int i = 0;
    while (true) {
      str = paramString;
      if (i < j) {
        char c = paramString.charAt(i);
        boolean[] arrayOfBoolean = this.d;
        if (c >= arrayOfBoolean.length || !arrayOfBoolean[c]) {
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
  
  public char[] a(int paramInt) {
    boolean[] arrayOfBoolean = this.d;
    if (paramInt < arrayOfBoolean.length && arrayOfBoolean[paramInt])
      return null; 
    if (paramInt == 32 && this.c)
      return a; 
    if (paramInt <= 127) {
      char[] arrayOfChar = b;
      char c = arrayOfChar[paramInt & 0xF];
      return new char[] { '%', arrayOfChar[paramInt >>> 4], c };
    } 
    if (paramInt <= 2047) {
      char[] arrayOfChar = b;
      char c1 = arrayOfChar[paramInt & 0xF];
      paramInt >>>= 4;
      char c2 = arrayOfChar[paramInt & 0x3 | 0x8];
      paramInt >>>= 2;
      char c3 = arrayOfChar[paramInt & 0xF];
      return new char[] { '%', arrayOfChar[paramInt >>> 4 | 0xC], c3, '%', c2, c1 };
    } 
    if (paramInt <= 65535) {
      char[] arrayOfChar = b;
      char c1 = arrayOfChar[paramInt & 0xF];
      paramInt >>>= 4;
      char c2 = arrayOfChar[paramInt & 0x3 | 0x8];
      paramInt >>>= 2;
      char c3 = arrayOfChar[paramInt & 0xF];
      paramInt >>>= 4;
      char c4 = arrayOfChar[paramInt & 0x3 | 0x8];
      return new char[] { '%', 'E', arrayOfChar[paramInt >>> 2], '%', c4, c3, '%', c2, c1 };
    } 
    if (paramInt <= 1114111) {
      char[] arrayOfChar = b;
      char c1 = arrayOfChar[paramInt & 0xF];
      paramInt >>>= 4;
      char c2 = arrayOfChar[paramInt & 0x3 | 0x8];
      paramInt >>>= 2;
      char c3 = arrayOfChar[paramInt & 0xF];
      paramInt >>>= 4;
      char c4 = arrayOfChar[paramInt & 0x3 | 0x8];
      paramInt >>>= 2;
      char c5 = arrayOfChar[paramInt & 0xF];
      paramInt >>>= 4;
      char c6 = arrayOfChar[paramInt & 0x3 | 0x8];
      return new char[] { 
          '%', 'F', arrayOfChar[paramInt >>> 2 & 0x7], '%', c6, c5, '%', c4, c3, '%', 
          c2, c1 };
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid unicode character value ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\net\PercentEscaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */