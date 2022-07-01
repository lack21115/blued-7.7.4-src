package com.huawei.hms.framework.network.grs.d;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class b {
  private static final String a = "b";
  
  private static final Pattern b = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");
  
  public static String a(String paramString) {
    return a(paramString, "SHA-256");
  }
  
  private static String a(String paramString1, String paramString2) {
    try {
      byte[] arrayOfByte = paramString1.getBytes("UTF-8");
      try {
        return a(MessageDigest.getInstance(paramString2).digest(arrayOfByte));
      } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
        String str = a;
        paramString2 = "encrypt NoSuchAlgorithmException";
      } 
    } catch (UnsupportedEncodingException unsupportedEncodingException) {}
    Logger.w((String)unsupportedEncodingException, paramString2);
    return null;
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      String str = Integer.toHexString(paramArrayOfbyte[i] & 0xFF);
      if (str.length() == 1)
        stringBuffer.append("0"); 
      stringBuffer.append(str);
    } 
    return stringBuffer.toString();
  }
  
  public static String b(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return paramString; 
    int i = paramString.length();
    int j = 1;
    if (i == 1)
      return "*"; 
    StringBuffer stringBuffer = new StringBuffer();
    i = 0;
    while (i < paramString.length()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString.charAt(i));
      stringBuilder.append("");
      String str1 = stringBuilder.toString();
      int k = j;
      String str2 = str1;
      if (b.matcher(str1).matches()) {
        if (j % 2 == 0)
          str1 = "*"; 
        k = j + 1;
        str2 = str1;
      } 
      stringBuffer.append(str2);
      i++;
      j = k;
    } 
    return stringBuffer.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */