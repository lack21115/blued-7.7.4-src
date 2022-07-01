package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class SHA {
  private static final String a = SHA.class.getSimpleName();
  
  private static final String[] b = new String[] { "SHA-256", "SHA-384", "SHA-512" };
  
  public static String a(String paramString) {
    return a(paramString, "SHA-256");
  }
  
  public static String a(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2)) {
      b.c(a, "content or algorithm is null.");
      return "";
    } 
    if (!b(paramString2)) {
      b.c(a, "algorithm is not safe or legal");
      return "";
    } 
    try {
      MessageDigest messageDigest = MessageDigest.getInstance(paramString2);
      messageDigest.update(paramString1.getBytes("UTF-8"));
      return HexUtil.a(messageDigest.digest());
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      b.c(a, "Error in generate SHA UnsupportedEncodingException");
      return "";
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      b.c(a, "Error in generate SHA NoSuchAlgorithmException");
      return "";
    } 
  }
  
  private static boolean b(String paramString) {
    String[] arrayOfString = b;
    int j = arrayOfString.length;
    for (int i = 0; i < j; i++) {
      if (arrayOfString[i].equals(paramString))
        return true; 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\encrypt\hash\SHA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */