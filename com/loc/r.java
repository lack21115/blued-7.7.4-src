package com.loc;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class r {
  public static String a(String paramString) {
    return (paramString == null) ? null : u.e(c(paramString));
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    return u.e(a(paramArrayOfbyte, u.c("ETUQ1")));
  }
  
  public static byte[] a(byte[] paramArrayOfbyte, String paramString) {
    try {
      return messageDigest.digest();
    } finally {
      paramArrayOfbyte = null;
      y.a((Throwable)paramArrayOfbyte, "MD5", "gmb");
    } 
  }
  
  public static String b(String paramString) {
    return u.f(d(paramString));
  }
  
  private static byte[] c(String paramString) {
    try {
      return e(paramString);
    } finally {
      paramString = null;
      y.a((Throwable)paramString, "MD5", "gmb");
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
    MessageDigest messageDigest = MessageDigest.getInstance(u.c("ETUQ1"));
    messageDigest.update(u.a(paramString));
    return messageDigest.digest();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */