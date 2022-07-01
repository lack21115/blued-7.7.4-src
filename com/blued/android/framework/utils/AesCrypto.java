package com.blued.android.framework.utils;

import android.text.TextUtils;
import android.util.Base64;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AesCrypto {
  public static final String a = "df0b".toLowerCase();
  
  public static final byte[] b = Base64.decode("VlEc5qsEDXWChrWJ0AzMXQ==", 2);
  
  public static final byte[] c = Base64.decode("MC8Lpxk9zqyuRPXMdO8rJQ==", 2);
  
  public static final byte[] d = a();
  
  public static String a(String paramString) throws Exception {
    byte[] arrayOfByte = a();
    paramString = a(paramString, arrayOfByte);
    String str = a(arrayOfByte);
    int i = Integer.parseInt(a.substring(0, 1), 16);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append(paramString.substring(0, i));
    stringBuilder.append(str);
    stringBuilder.append(paramString.substring(i));
    return stringBuilder.toString();
  }
  
  private static String a(String paramString1, String paramString2, byte[] paramArrayOfbyte) throws Exception {
    if (TextUtils.isEmpty(paramString1))
      return ""; 
    byte[] arrayOfByte = Base64.decode(paramString1, 2);
    String str2 = ByteTransformUtils.a(arrayOfByte, 0, arrayOfByte.length).toLowerCase();
    String str1 = str2;
    if (str2.startsWith(paramString2))
      str1 = str2.substring(paramString2.length()); 
    int i = Integer.parseInt(paramString2.substring(0, 1), 16);
    int j = i + 32;
    paramString2 = str1.substring(i, j);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str1.substring(0, i));
    stringBuilder.append(str1.substring(j));
    str1 = stringBuilder.toString();
    return new String(b(b(paramArrayOfbyte), f(str1), ByteTransformUtils.a(paramString2)));
  }
  
  public static String a(String paramString, byte[] paramArrayOfbyte) throws Exception {
    return a(a(b(b), paramString.getBytes(), paramArrayOfbyte));
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return ""; 
    StringBuffer stringBuffer = new StringBuffer(paramArrayOfbyte.length * 2);
    for (int i = 0; i < paramArrayOfbyte.length; i++)
      a(stringBuffer, paramArrayOfbyte[i]); 
    return stringBuffer.toString();
  }
  
  private static void a(StringBuffer paramStringBuffer, byte paramByte) {
    paramStringBuffer.append("0123456789ABCDEF".charAt(paramByte >> 4 & 0xF));
    paramStringBuffer.append("0123456789ABCDEF".charAt(paramByte & 0xF));
  }
  
  private static byte[] a() {
    Random random = new Random();
    byte[] arrayOfByte = new byte[16];
    for (int i = 0; i < 16; i++)
      arrayOfByte[i] = (byte)(random.nextInt(256) - 128); 
    return arrayOfByte;
  }
  
  private static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3) throws Exception {
    SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte1, "AES");
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
    cipher.init(1, secretKeySpec, new IvParameterSpec(paramArrayOfbyte3));
    return cipher.doFinal(paramArrayOfbyte2);
  }
  
  public static String b(String paramString) throws Exception {
    return b(paramString, a, b);
  }
  
  private static String b(String paramString1, String paramString2, byte[] paramArrayOfbyte) throws Exception {
    byte[] arrayOfByte = a();
    paramString1 = a(a(b(paramArrayOfbyte), paramString1.getBytes(), arrayOfByte));
    String str = a(arrayOfByte);
    int i = Integer.parseInt(paramString2.substring(0, 1), 16);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append(paramString1.substring(0, i));
    stringBuilder.append(str);
    stringBuilder.append(paramString1.substring(i));
    return Base64.encodeToString(ByteTransformUtils.a(stringBuilder.toString()), 2);
  }
  
  private static byte[] b(byte[] paramArrayOfbyte) throws Exception {
    return paramArrayOfbyte;
  }
  
  private static byte[] b(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3) throws Exception {
    SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte1, "AES");
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
    cipher.init(2, secretKeySpec, new IvParameterSpec(paramArrayOfbyte3));
    return cipher.doFinal(paramArrayOfbyte2);
  }
  
  public static String c(String paramString) throws Exception {
    return a(paramString, a, b);
  }
  
  public static String d(String paramString) throws Exception {
    return b(paramString, "4545", c);
  }
  
  public static String e(String paramString) throws Exception {
    return a(paramString, "4545", c);
  }
  
  public static byte[] f(String paramString) {
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    for (int i = 0; i < j; i++) {
      int k = i * 2;
      arrayOfByte[i] = Integer.valueOf(paramString.substring(k, k + 2), 16).byteValue();
    } 
    return arrayOfByte;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\AesCrypto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */