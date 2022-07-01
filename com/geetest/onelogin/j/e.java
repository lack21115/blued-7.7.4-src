package com.geetest.onelogin.j;

import java.io.IOException;
import java.io.InputStream;

public class e {
  public static String a(InputStream paramInputStream) {
    try {
      byte[] arrayOfByte = new byte[4];
      paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
      String str2 = a(arrayOfByte);
      String str1 = str2;
    } catch (Exception exception) {
      if (iOException != null)
        try {
          iOException.close();
        } catch (IOException iOException) {} 
    } finally {
      if (iOException != null)
        try {
          iOException.close();
        } catch (IOException iOException1) {} 
    } 
    return c((String)SYNTHETIC_LOCAL_VARIABLE_1);
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder();
    if (paramArrayOfbyte == null || paramArrayOfbyte.length <= 0)
      return null; 
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      String str = Integer.toHexString(paramArrayOfbyte[i] & 0xFF).toUpperCase();
      if (str.length() < 2)
        stringBuilder.append(0); 
      stringBuilder.append(str);
    } 
    return stringBuilder.toString();
  }
  
  public static boolean a(String paramString) {
    return paramString.equals("gif");
  }
  
  public static boolean b(String paramString) {
    return (paramString.equals("jpg") || paramString.equals("jpeg") || paramString.equals("png") || paramString.equals("bmp"));
  }
  
  private static String c(String paramString) {
    return ("FFD8FF".equals(paramString) || paramString.startsWith("FFD8FF")) ? "jpg" : (paramString.startsWith("FFD8") ? "jpeg" : (("89504E47".equals(paramString) || paramString.startsWith("89504E")) ? "png" : (("47494638".equals(paramString) || paramString.startsWith("474946")) ? "gif" : (("424D".equals(paramString) || paramString.startsWith("424D")) ? "bmp" : "unknown"))));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\j\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */