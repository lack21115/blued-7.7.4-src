package com.ta.utdid2.a.a;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class a {
  public static String a(String paramString) {
    try {
      byte[] arrayOfByte = a(a(), paramString.getBytes());
    } catch (Exception exception) {
      exception = null;
    } 
    return (exception != null) ? a((byte[])exception) : null;
  }
  
  private static String a(byte[] paramArrayOfbyte) {
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
  
  private static byte[] a() throws Exception {
    return f.a(new byte[] { 
          33, 83, -50, -89, -84, -114, 80, 99, 10, 63, 
          22, -65, -11, 30, 101, -118 });
  }
  
  private static byte[] a(String paramString) {
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    for (int i = 0; i < j; i++) {
      int k = i * 2;
      arrayOfByte[i] = Integer.valueOf(paramString.substring(k, k + 2), 16).byteValue();
    } 
    return arrayOfByte;
  }
  
  private static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) throws Exception {
    SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte1, "AES");
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(1, secretKeySpec, new IvParameterSpec(b()));
    return cipher.doFinal(paramArrayOfbyte2);
  }
  
  public static String b(String paramString) {
    try {
      return new String(b(a(), a(paramString)));
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private static byte[] b() {
    try {
      byte[] arrayOfByte = b.decode("IUQSvE6r1TfFPdPEjfklLw==".getBytes("UTF-8"), 2);
      if (arrayOfByte != null)
        return f.a(arrayOfByte); 
    } catch (Exception exception) {}
    return new byte[16];
  }
  
  private static byte[] b(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) throws Exception {
    SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte1, "AES");
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(2, secretKeySpec, new IvParameterSpec(b()));
    return cipher.doFinal(paramArrayOfbyte2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\t\\utdid2\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */