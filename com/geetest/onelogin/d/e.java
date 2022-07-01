package com.geetest.onelogin.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.security.MessageDigest;

public class e {
  public static String a(Context paramContext) {
    Signature[] arrayOfSignature = b(paramContext);
    return (arrayOfSignature == null || arrayOfSignature.length == 0) ? null : a(arrayOfSignature[0].toByteArray());
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    char[] arrayOfChar = new char[16];
    arrayOfChar[0] = '0';
    arrayOfChar[1] = '1';
    arrayOfChar[2] = '2';
    arrayOfChar[3] = '3';
    arrayOfChar[4] = '4';
    arrayOfChar[5] = '5';
    arrayOfChar[6] = '6';
    arrayOfChar[7] = '7';
    arrayOfChar[8] = '8';
    arrayOfChar[9] = '9';
    arrayOfChar[10] = 'a';
    arrayOfChar[11] = 'b';
    arrayOfChar[12] = 'c';
    arrayOfChar[13] = 'd';
    arrayOfChar[14] = 'e';
    arrayOfChar[15] = 'f';
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(paramArrayOfbyte);
      paramArrayOfbyte = messageDigest.digest();
      int k = paramArrayOfbyte.length;
      char[] arrayOfChar1 = new char[k * 2];
      int i = 0;
      int j = 0;
      while (true) {
        if (i >= k)
          return new String(arrayOfChar1); 
        byte b = paramArrayOfbyte[i];
        int m = j + 1;
        arrayOfChar1[j] = arrayOfChar[b >>> 4 & 0xF];
        j = m + 1;
        arrayOfChar1[m] = arrayOfChar[b & 0xF];
        i++;
      } 
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private static Signature[] b(Context paramContext) {
    PackageManager packageManager = paramContext.getPackageManager();
    try {
      PackageInfo packageInfo = packageManager.getPackageInfo(paramContext.getPackageName(), 64);
      return (packageInfo == null) ? null : packageInfo.signatures;
    } catch (Exception exception) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */