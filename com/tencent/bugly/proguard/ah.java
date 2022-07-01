package com.tencent.bugly.proguard;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class ah implements aj {
  private String a = null;
  
  public final void a(String paramString) {
    if (paramString != null) {
      for (int i = paramString.length(); i < 16; i++) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString);
        stringBuilder.append("0");
        paramString = stringBuilder.toString();
      } 
      this.a = paramString.substring(0, 16);
    } 
  }
  
  public final byte[] a(byte[] paramArrayOfbyte) throws Exception {
    if (this.a == null || paramArrayOfbyte == null)
      return null; 
    StringBuffer stringBuffer2 = new StringBuffer();
    int j = paramArrayOfbyte.length;
    byte b = 0;
    int i;
    for (i = 0; i < j; i++) {
      byte b1 = paramArrayOfbyte[i];
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(b1);
      stringBuilder.append(" ");
      stringBuffer2.append(stringBuilder.toString());
    } 
    SecretKeySpec secretKeySpec = new SecretKeySpec(this.a.getBytes(), "AES");
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(2, secretKeySpec, new IvParameterSpec(this.a.getBytes()));
    paramArrayOfbyte = cipher.doFinal(paramArrayOfbyte);
    StringBuffer stringBuffer1 = new StringBuffer();
    j = paramArrayOfbyte.length;
    for (i = b; i < j; i++) {
      b = paramArrayOfbyte[i];
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(b);
      stringBuilder.append(" ");
      stringBuffer1.append(stringBuilder.toString());
    } 
    return paramArrayOfbyte;
  }
  
  public final byte[] b(byte[] paramArrayOfbyte) throws Exception, NoSuchAlgorithmException {
    if (this.a == null || paramArrayOfbyte == null)
      return null; 
    StringBuffer stringBuffer2 = new StringBuffer();
    int j = paramArrayOfbyte.length;
    byte b = 0;
    int i;
    for (i = 0; i < j; i++) {
      byte b1 = paramArrayOfbyte[i];
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(b1);
      stringBuilder.append(" ");
      stringBuffer2.append(stringBuilder.toString());
    } 
    SecretKeySpec secretKeySpec = new SecretKeySpec(this.a.getBytes(), "AES");
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(1, secretKeySpec, new IvParameterSpec(this.a.getBytes()));
    paramArrayOfbyte = cipher.doFinal(paramArrayOfbyte);
    StringBuffer stringBuffer1 = new StringBuffer();
    j = paramArrayOfbyte.length;
    for (i = b; i < j; i++) {
      b = paramArrayOfbyte[i];
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(b);
      stringBuilder.append(" ");
      stringBuffer1.append(stringBuilder.toString());
    } 
    return paramArrayOfbyte;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */