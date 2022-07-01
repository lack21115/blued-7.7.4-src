package com.geetest.onelogin.e.a;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class f {
  public static String a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    try {
      byte[] arrayOfByte = MessageDigest.getInstance("MD5").digest(paramString.getBytes());
      int j = arrayOfByte.length;
      int i = 0;
      paramString = "";
      while (i < j) {
        String str2 = Integer.toHexString(arrayOfByte[i] & 0xFF);
        String str1 = str2;
        if (str2.length() == 1) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("0");
          stringBuilder1.append(str2);
          str1 = stringBuilder1.toString();
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString);
        stringBuilder.append(str1);
        paramString = stringBuilder.toString();
        i++;
      } 
      return paramString;
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      noSuchAlgorithmException.printStackTrace();
      return "";
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\e\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */