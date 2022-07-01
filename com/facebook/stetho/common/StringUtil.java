package com.facebook.stetho.common;

public final class StringUtil {
  public static String removeAll(String paramString, char paramChar) {
    int j = paramString.length();
    StringBuilder stringBuilder = new StringBuilder(j);
    for (int i = 0; i < j; i++) {
      char c = paramString.charAt(i);
      if (c != paramChar)
        stringBuilder.append(c); 
    } 
    return stringBuilder.toString();
  }
  
  public static String removePrefix(String paramString1, String paramString2) {
    String str = paramString1;
    if (paramString1.startsWith(paramString2))
      str = paramString1.substring(paramString2.length()); 
    return str;
  }
  
  public static String removePrefix(String paramString1, String paramString2, String paramString3) {
    return (paramString1 != paramString3) ? paramString3 : removePrefix(paramString1, paramString2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\common\StringUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */