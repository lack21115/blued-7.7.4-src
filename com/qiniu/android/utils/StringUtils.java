package com.qiniu.android.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

public final class StringUtils {
  public static String getAkAndScope(String paramString) {
    String[] arrayOfString = paramString.split(":");
    paramString = arrayOfString[0];
    try {
      String str = (new JSONObject(new String(UrlSafeBase64.decode(arrayOfString[2]), "utf-8"))).getString("scope").split(":")[0];
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(str);
      return stringBuilder.toString();
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static String getBucket(String paramString) {
    String[] arrayOfString = paramString.split(":");
    try {
      return (new JSONObject(new String(UrlSafeBase64.decode(arrayOfString[2]), "utf-8"))).getString("scope").split(":")[0];
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
  
  public static boolean isBlank(String paramString) {
    return (paramString == null || paramString.trim().equals(""));
  }
  
  public static boolean isNullOrEmpty(String paramString) {
    return (paramString == null || "".equals(paramString));
  }
  
  public static String join(String[] paramArrayOfString, String paramString) {
    if (paramArrayOfString == null)
      return null; 
    int j = paramArrayOfString.length;
    boolean bool = false;
    if (paramString != null && !paramString.equals("")) {
      i = paramString.length();
    } else {
      i = 0;
    } 
    if (j == 0) {
      i = 0;
    } else {
      int k;
      if (paramArrayOfString[0] == null) {
        k = 16;
      } else {
        k = paramArrayOfString[0].length();
      } 
      i = (k + i) * j;
    } 
    StringBuilder stringBuilder = new StringBuilder(i);
    for (int i = bool; i < j; i++) {
      if (i > 0)
        stringBuilder.append(paramString); 
      if (paramArrayOfString[i] != null)
        stringBuilder.append(paramArrayOfString[i]); 
    } 
    return stringBuilder.toString();
  }
  
  public static String jsonJoin(Long[] paramArrayOfLong) {
    return jsonJoin(longToString(paramArrayOfLong));
  }
  
  public static String jsonJoin(String[] paramArrayOfString) {
    int j = paramArrayOfString.length;
    int i = 0;
    if (paramArrayOfString[0] == null)
      paramArrayOfString[0] = ""; 
    StringBuilder stringBuilder = new StringBuilder((paramArrayOfString[0].length() + 3) * j);
    while (i < j) {
      if (i > 0)
        stringBuilder.append(','); 
      stringBuilder.append('"');
      stringBuilder.append(paramArrayOfString[i]);
      stringBuilder.append('"');
      i++;
    } 
    return stringBuilder.toString();
  }
  
  public static String[] longToString(Long[] paramArrayOfLong) {
    String[] arrayOfString = new String[paramArrayOfLong.length];
    int i = 0;
    while (true) {
      if (i < arrayOfString.length) {
        try {
          arrayOfString[i] = String.valueOf(paramArrayOfLong[i]);
        } catch (NumberFormatException numberFormatException) {
          arrayOfString[i] = "null";
        } 
        i++;
        continue;
      } 
      return arrayOfString;
    } 
  }
  
  public static String strip(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    int j = paramString.length();
    for (int i = 0; i < j; i++) {
      char c = paramString.charAt(i);
      if (c > '\037' && c < '')
        stringBuilder.append(c); 
    } 
    return stringBuilder.toString();
  }
  
  public static byte[] toByteArray(Object paramObject) {
    Object object = null;
    Object object1 = null;
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      Object object2 = object1;
      try {
      
      } finally {
        object = object2;
        byteArrayOutputStream.close();
        object = object2;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      return (byte[])object;
    } 
  }
  
  public static Object toObject(byte[] paramArrayOfbyte) {
    Object object1 = null;
    Object object = null;
    byte[] arrayOfByte = null;
    try {
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(paramArrayOfbyte);
      paramArrayOfbyte = arrayOfByte;
      object = object1;
      try {
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        paramArrayOfbyte = arrayOfByte;
        object = object1;
        Object object3 = objectInputStream.readObject();
        Object object2 = object3;
        object = object3;
        objectInputStream.close();
      } catch (Exception exception) {
        Object object2 = object;
      } finally {}
      object = arrayOfByte;
      byteArrayInputStream.close();
      return arrayOfByte;
    } catch (Exception exception) {
      exception.printStackTrace();
      return object;
    } 
  }
  
  public static String upperCase(String paramString) {
    if (paramString.length() <= 0 || paramString == null)
      return ""; 
    char[] arrayOfChar = paramString.toCharArray();
    if (arrayOfChar[0] >= 'a' && arrayOfChar[0] <= 'z')
      arrayOfChar[0] = (char)(arrayOfChar[0] - 32); 
    return new String(arrayOfChar);
  }
  
  public static byte[] utf8Bytes(String paramString) {
    try {
      return paramString.getBytes("utf-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new AssertionError(unsupportedEncodingException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\androi\\utils\StringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */