package com.geetest.onepassv2.b;

import com.geetest.onelogin.e.a.i;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class a {
  public static String a(String paramString) {
    byte[] arrayOfByte = paramString.getBytes();
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
      messageDigest.update(arrayOfByte);
      return i.b(messageDigest.digest());
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      return paramString;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onepassv2\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */