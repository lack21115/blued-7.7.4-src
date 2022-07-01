package com.blued.android.framework.utils;

import android.text.TextUtils;
import com.blued.android.framework.Hashids;

public class HashidEncryptTool {
  public static String a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString))
      try {
        long[] arrayOfLong = (new Hashids("1766", 6)).a(paramString);
        int j = arrayOfLong.length;
        for (int i = 0; i < j; i++)
          stringBuilder.append(arrayOfLong[i]); 
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return stringBuilder.toString();
  }
  
  public static String b(String paramString) {
    if (!TextUtils.isEmpty(paramString) && TextUtils.isDigitsOnly(paramString))
      try {
        Long long_ = Long.valueOf(paramString);
        return (new Hashids("1766", 6)).a(new long[] { long_.longValue() });
      } catch (NumberFormatException numberFormatException) {
        numberFormatException.printStackTrace();
      } catch (Exception exception) {
        exception.printStackTrace();
        return paramString;
      }  
    return paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\HashidEncryptTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */