package com.huawei.updatesdk.a.a.c;

import android.text.TextUtils;
import com.huawei.updatesdk.a.a.b.a.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.IllegalFormatException;
import java.util.Locale;

public abstract class g {
  public static String a(String paramString) {
    if (paramString == null)
      return null; 
    try {
      return URLEncoder.encode(paramString, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("~", "%7E");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      a.a("StringUtils", "encode2utf8 error", unsupportedEncodingException);
      return null;
    } 
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    String str;
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
      messageDigest.update(paramArrayOfbyte);
      StringBuilder stringBuilder = new StringBuilder(256);
      for (byte b : messageDigest.digest()) {
        Locale locale = Locale.ENGLISH;
        stringBuilder.append(String.format(locale, "%02X", new Object[] { Byte.valueOf(b) }));
      } 
      return stringBuilder.toString();
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      str = "sha256EncryptStr error:NoSuchAlgorithmException";
    } catch (IllegalFormatException illegalFormatException) {
      str = "sha256EncryptStr error:IllegalFormatException";
    } catch (Exception exception) {
      str = "sha256EncryptStr error:Exception";
    } 
    a.b("StringUtils", str);
    return null;
  }
  
  public static String b(String paramString) {
    paramString = e(paramString);
    return (paramString == null) ? null : paramString.toLowerCase(Locale.getDefault());
  }
  
  public static byte[] c(String paramString) {
    char[] arrayOfChar = paramString.toCharArray();
    int j = arrayOfChar.length / 2;
    byte[] arrayOfByte = new byte[j];
    for (int i = 0; i < j; i++) {
      int k = i * 2;
      int m = Character.digit(arrayOfChar[k], 16);
      m = Character.digit(arrayOfChar[k + 1], 16) | m << 4;
      k = m;
      if (m > 127)
        k = m - 256; 
      arrayOfByte[i] = Byte.valueOf(String.valueOf(k)).byteValue();
    } 
    return arrayOfByte;
  }
  
  public static boolean d(String paramString) {
    return (paramString != null && paramString.trim().startsWith("{") && paramString.trim().endsWith("}"));
  }
  
  public static String e(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    try {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      return a(arrayOfByte);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      a.b("StringUtils", "can not getBytes");
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\a\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */