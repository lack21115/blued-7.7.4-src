package com.amap.api.col.s;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class bq {
  public static String a(String paramString) {
    return (paramString == null) ? null : bs.e(c(paramString));
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    return bs.e(a(paramArrayOfbyte, bs.c("ETUQ1")));
  }
  
  private static byte[] a(byte[] paramArrayOfbyte, String paramString) {
    try {
      return messageDigest.digest();
    } finally {
      paramArrayOfbyte = null;
      cd.a((Throwable)paramArrayOfbyte, "MD5", "gmb");
    } 
  }
  
  public static String b(String paramString) {
    return bs.f(d(paramString));
  }
  
  private static byte[] c(String paramString) {
    try {
      return e(paramString);
    } finally {
      paramString = null;
      cd.a((Throwable)paramString, "MD5", "gmb");
    } 
  }
  
  private static byte[] d(String paramString) {
    try {
      return e(paramString);
    } finally {
      paramString = null;
      paramString.printStackTrace();
    } 
  }
  
  private static byte[] e(String paramString) throws NoSuchAlgorithmException, UnsupportedEncodingException {
    if (paramString == null)
      return null; 
    MessageDigest messageDigest = MessageDigest.getInstance(bs.c("ETUQ1"));
    messageDigest.update(bs.a(paramString));
    return messageDigest.digest();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */