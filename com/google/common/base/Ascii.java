package com.google.common.base;

public final class Ascii {
  public static char a(char paramChar) {
    char c = paramChar;
    if (b(paramChar))
      c = (char)(paramChar ^ 0x20); 
    return c;
  }
  
  public static String a(CharSequence paramCharSequence, int paramInt, String paramString) {
    boolean bool;
    Preconditions.a(paramCharSequence);
    int i = paramInt - paramString.length();
    if (i >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool, "maxLength (%s) must be >= length of the truncation indicator (%s)", paramInt, paramString.length());
    CharSequence charSequence = paramCharSequence;
    if (paramCharSequence.length() <= paramInt) {
      paramCharSequence = paramCharSequence.toString();
      charSequence = paramCharSequence;
      if (paramCharSequence.length() <= paramInt)
        return (String)paramCharSequence; 
    } 
    paramCharSequence = new StringBuilder(paramInt);
    paramCharSequence.append(charSequence, 0, i);
    paramCharSequence.append(paramString);
    return paramCharSequence.toString();
  }
  
  public static String a(String paramString) {
    char[] arrayOfChar;
    int j = paramString.length();
    for (int i = 0; i < j; i++) {
      if (c(paramString.charAt(i))) {
        arrayOfChar = paramString.toCharArray();
        while (i < j) {
          char c = arrayOfChar[i];
          if (c(c))
            arrayOfChar[i] = (char)(c ^ 0x20); 
          i++;
        } 
        return String.valueOf(arrayOfChar);
      } 
    } 
    return (String)arrayOfChar;
  }
  
  public static String b(String paramString) {
    char[] arrayOfChar;
    int j = paramString.length();
    for (int i = 0; i < j; i++) {
      if (b(paramString.charAt(i))) {
        arrayOfChar = paramString.toCharArray();
        while (i < j) {
          char c = arrayOfChar[i];
          if (b(c))
            arrayOfChar[i] = (char)(c ^ 0x20); 
          i++;
        } 
        return String.valueOf(arrayOfChar);
      } 
    } 
    return (String)arrayOfChar;
  }
  
  public static boolean b(char paramChar) {
    return (paramChar >= 'a' && paramChar <= 'z');
  }
  
  public static boolean c(char paramChar) {
    return (paramChar >= 'A' && paramChar <= 'Z');
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\Ascii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */