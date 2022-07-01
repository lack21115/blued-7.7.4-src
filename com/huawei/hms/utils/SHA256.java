package com.huawei.hms.utils;

import com.huawei.hms.support.log.HMSLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class SHA256 {
  public static byte[] digest(File paramFile) {
    BufferedInputStream bufferedInputStream;
    Exception exception = null;
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte1 = arrayOfByte2;
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
      arrayOfByte1 = arrayOfByte2;
      BufferedInputStream bufferedInputStream1 = new BufferedInputStream(new FileInputStream(paramFile));
    } catch (NoSuchAlgorithmException|java.io.IOException noSuchAlgorithmException) {
    
    } finally {
      IOUtils.closeQuietly(bufferedInputStream);
    } 
    File file = paramFile;
    HMSLog.e("SHA256", "An exception occurred while computing file 'SHA-256'.");
    IOUtils.closeQuietly((InputStream)paramFile);
    return new byte[0];
  }
  
  public static byte[] digest(byte[] paramArrayOfbyte) {
    try {
      return MessageDigest.getInstance("SHA-256").digest(paramArrayOfbyte);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("NoSuchAlgorithmException");
      stringBuilder.append(noSuchAlgorithmException.getMessage());
      HMSLog.e("SHA256", stringBuilder.toString());
      return new byte[0];
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\utils\SHA256.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */