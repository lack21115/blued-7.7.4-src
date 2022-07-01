package com.google.android.gms.common.util;

public class NumberUtils {
  public static long parseHexLong(String paramString) {
    if (paramString.length() <= 16) {
      if (paramString.length() == 16) {
        long l = Long.parseLong(paramString.substring(8), 16);
        return Long.parseLong(paramString.substring(0, 8), 16) << 32L | l;
      } 
      return Long.parseLong(paramString, 16);
    } 
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString).length() + 37);
    stringBuilder.append("Invalid input: ");
    stringBuilder.append(paramString);
    stringBuilder.append(" exceeds 16 characters");
    throw new NumberFormatException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\commo\\util\NumberUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */