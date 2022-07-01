package com.huawei.hms.utils;

import java.util.regex.Pattern;

public class StringUtil {
  public static String addByteForNum(String paramString, int paramInt, char paramChar) {
    int i = paramString.length();
    if (i == paramInt)
      return paramString; 
    if (i > paramInt)
      return paramString.substring(i - paramInt); 
    StringBuffer stringBuffer = new StringBuffer();
    while (i < paramInt) {
      stringBuffer.append(paramChar);
      i++;
    } 
    stringBuffer.append(paramString);
    return stringBuffer.toString();
  }
  
  public static boolean checkVersion(String paramString) {
    return Pattern.compile("(^([0-9]{1,2}\\.){2}[0-9]{1,2}$)|(^([0-9]{1,2}\\.){3}[0-9]{1,3}$)").matcher(paramString).find();
  }
  
  public static int convertVersion2Integer(String paramString) {
    if (checkVersion(paramString)) {
      String[] arrayOfString = paramString.split("\\.");
      if (arrayOfString.length < 3)
        return 0; 
      int j = Integer.parseInt(arrayOfString[0]) * 10000000 + Integer.parseInt(arrayOfString[1]) * 100000 + Integer.parseInt(arrayOfString[2]) * 1000;
      int i = j;
      if (arrayOfString.length == 4)
        i = j + Integer.parseInt(arrayOfString[3]); 
      return i;
    } 
    return 0;
  }
  
  public static String objDesc(Object paramObject) {
    if (paramObject == null)
      return "null"; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramObject.getClass().getName());
    stringBuilder.append('@');
    stringBuilder.append(Integer.toHexString(paramObject.hashCode()));
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\utils\StringUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */