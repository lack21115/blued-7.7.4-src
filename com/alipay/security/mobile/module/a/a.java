package com.alipay.security.mobile.module.a;

import android.os.Environment;
import android.util.Base64;
import com.alipay.security.mobile.module.a.a.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

public final class a {
  public static File a() {
    try {
      return (File)Environment.class.getMethod(new String(a.a("Z2V0RXh0ZXJuYWxTdG9yYWdlRGlyZWN0b3J5")), new Class[0]).invoke(null, new Object[0]);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static String a(Throwable paramThrowable) {
    StringWriter stringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(stringWriter));
    return stringWriter.toString();
  }
  
  public static String a(Map<String, String> paramMap, String paramString1, String paramString2) {
    if (paramMap == null)
      return paramString2; 
    String str = paramMap.get(paramString1);
    return (str == null) ? paramString2 : str;
  }
  
  public static boolean a(String paramString) {
    if (paramString != null) {
      int j = paramString.length();
      if (j == 0)
        return true; 
      for (int i = 0; i < j; i++) {
        if (!Character.isWhitespace(paramString.charAt(i)))
          return false; 
      } 
    } 
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2) {
    return (paramString1 == null) ? ((paramString2 == null)) : paramString1.equals(paramString2);
  }
  
  public static String b(String paramString1, String paramString2) {
    try {
      return (String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class, String.class }).invoke(null, new Object[] { paramString1, paramString2 });
    } catch (Exception exception) {
      return paramString2;
    } 
  }
  
  public static boolean b(String paramString) {
    return !a(paramString);
  }
  
  public static boolean c(String paramString) {
    for (byte b : paramString.getBytes()) {
      if ((b >= 0 && b <= 31) || b >= Byte.MAX_VALUE)
        return false; 
    } 
    return true;
  }
  
  public static String d(String paramString) {
    String str = paramString;
    if (paramString == null)
      str = ""; 
    return str;
  }
  
  public static String e(String paramString) {
    try {
      if (a(paramString))
        return null; 
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
      messageDigest.update(paramString.getBytes("UTF-8"));
      byte[] arrayOfByte = messageDigest.digest();
      StringBuilder stringBuilder = new StringBuilder();
      for (int i = 0; i < arrayOfByte.length; i++) {
        stringBuilder.append(String.format("%02x", new Object[] { Byte.valueOf(arrayOfByte[i]) }));
      } 
      return stringBuilder.toString();
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static String f(String paramString) {
    try {
      byte[] arrayOfByte2 = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(paramString.length()).array();
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(paramString.length());
      GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
      gZIPOutputStream.write(paramString.getBytes("UTF-8"));
      gZIPOutputStream.close();
      byteArrayOutputStream.close();
      byte[] arrayOfByte1 = new byte[(byteArrayOutputStream.toByteArray()).length + 4];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, 4);
      System.arraycopy(byteArrayOutputStream.toByteArray(), 0, arrayOfByte1, 4, (byteArrayOutputStream.toByteArray()).length);
      return Base64.encodeToString(arrayOfByte1, 8);
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public static String g(String paramString) {
    if (a(paramString))
      return ""; 
    try {
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(paramString.getBytes("utf-8"));
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
      byte[] arrayOfByte = new byte[1024];
      while (true) {
        int i = byteArrayInputStream.read(arrayOfByte, 0, 1024);
        if (i != -1) {
          gZIPOutputStream.write(arrayOfByte, 0, i);
          continue;
        } 
        gZIPOutputStream.flush();
        gZIPOutputStream.close();
        byte[] arrayOfByte1 = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        byteArrayInputStream.close();
        return new String(Base64.encode(arrayOfByte1, 2));
      } 
    } catch (Exception exception) {
      return "";
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\security\mobile\module\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */