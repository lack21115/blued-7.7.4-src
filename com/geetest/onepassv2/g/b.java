package com.geetest.onepassv2.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.geetest.onelogin.e.a.a;
import java.security.MessageDigest;

public class b {
  private static final char[] a = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  public static String a(Context paramContext) {
    PackageManager packageManager = paramContext.getPackageManager();
    try {
      return (packageManager.getPackageInfo(paramContext.getPackageName(), 0)).packageName;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      nameNotFoundException.printStackTrace();
      return null;
    } 
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2) {
    try {
      return a.d(a(a(paramContext, paramString1)), paramString2.substring(0, 16));
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    try {
      paramArrayOfbyte = MessageDigest.getInstance("MD5").digest(paramArrayOfbyte);
      int j = paramArrayOfbyte.length;
      char[] arrayOfChar = new char[j * 2];
      for (int i = 0; i < j; i++) {
        byte b1 = paramArrayOfbyte[i];
        byte b2 = paramArrayOfbyte[i];
        int k = i * 2;
        arrayOfChar[k] = a[(b2 & 0xF0) >> 4];
        arrayOfChar[k + 1] = a[b1 & 0xF];
      } 
      return new String(arrayOfChar);
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
  
  private static byte[] a(Context paramContext, String paramString) {
    if (paramString != null) {
      if (paramString.length() == 0)
        return null; 
      PackageManager packageManager = paramContext.getPackageManager();
      try {
        PackageInfo packageInfo = packageManager.getPackageInfo(paramString, 64);
        return packageInfo.packageName.equals(paramString) ? packageInfo.signatures[0].toByteArray() : null;
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onepassv2\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */