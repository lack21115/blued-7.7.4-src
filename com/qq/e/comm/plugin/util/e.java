package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import com.qq.e.comm.util.GDTLogger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class e {
  private static final char[] a = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  public static String a(Context paramContext) {
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64);
      int j = packageInfo.signatures.length;
      StringBuilder stringBuilder = new StringBuilder();
      for (int i = 0;; i++) {
        if (i < j) {
          Signature signature = packageInfo.signatures[i];
          try {
            stringBuilder.append(a(MessageDigest.getInstance("MD5").digest(signature.toByteArray())));
            if (i != j - 1)
              stringBuilder.append(";"); 
          } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("get Signature Message Digest encounter exception: ");
            stringBuilder1.append(noSuchAlgorithmException.getMessage());
            GDTLogger.d(stringBuilder1.toString());
          } 
        } else {
          return stringBuilder.toString();
        } 
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("get Signature Digest encounter exception: ");
      stringBuilder.append(exception.getMessage());
      GDTLogger.d(stringBuilder.toString());
      return null;
    } 
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    char[] arrayOfChar = new char[paramArrayOfbyte.length * 2];
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      byte b = paramArrayOfbyte[i];
      int j = i * 2;
      char[] arrayOfChar1 = a;
      arrayOfChar[j] = (char)arrayOfChar1[b >>> 4 & 0xF];
      arrayOfChar[j + 1] = (char)arrayOfChar1[b & 0xF];
    } 
    return new String(arrayOfChar);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */