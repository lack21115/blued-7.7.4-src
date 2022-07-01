package com.alibaba.mtl.log.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class m {
  private static final Random a = new Random();
  
  public static String getImei(Context paramContext) {
    String str2 = null;
    String str1 = str2;
    if (paramContext != null) {
      try {
        str1 = paramContext.getSharedPreferences("UTCommon", 0).getString("_ie", "");
        if (!TextUtils.isEmpty(str1)) {
          str1 = new String(c.decode(str1.getBytes(), 2), "UTF-8");
          boolean bool = TextUtils.isEmpty(str1);
          if (!bool)
            return str1; 
        } 
      } catch (Exception exception) {}
      try {
        TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
        str1 = str2;
        if (telephonyManager != null)
          str1 = telephonyManager.getDeviceId(); 
      } catch (Exception exception) {
        str1 = str2;
      } 
    } 
    str2 = str1;
    if (TextUtils.isEmpty(str1))
      str2 = getUniqueID(); 
    if (paramContext != null)
      try {
        SharedPreferences.Editor editor = paramContext.getSharedPreferences("UTCommon", 0).edit();
        editor.putString("_ie", new String(c.encode(str2.getBytes("UTF-8"), 2)));
        editor.commit();
        return str2;
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
      }  
    return str2;
  }
  
  public static String getImsi(Context paramContext) {
    String str2 = null;
    String str1 = str2;
    if (paramContext != null) {
      try {
        str1 = paramContext.getSharedPreferences("UTCommon", 0).getString("_is", "");
        if (!TextUtils.isEmpty(str1)) {
          str1 = new String(c.decode(str1.getBytes(), 2), "UTF-8");
          boolean bool = TextUtils.isEmpty(str1);
          if (!bool)
            return str1; 
        } 
      } catch (Exception exception) {}
      try {
        TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
        str1 = str2;
        if (telephonyManager != null)
          str1 = telephonyManager.getSubscriberId(); 
      } catch (Exception exception) {
        str1 = str2;
      } 
    } 
    str2 = str1;
    if (TextUtils.isEmpty(str1))
      str2 = getUniqueID(); 
    if (paramContext != null)
      try {
        SharedPreferences.Editor editor = paramContext.getSharedPreferences("UTCommon", 0).edit();
        editor.putString("_is", new String(c.encode(str2.getBytes("UTF-8"), 2)));
        editor.commit();
        return str2;
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
      }  
    return str2;
  }
  
  public static final String getUniqueID() {
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = (int)System.nanoTime();
    int k = a.nextInt();
    int n = a.nextInt();
    byte[] arrayOfByte1 = f.getBytes(i);
    byte[] arrayOfByte2 = f.getBytes(j);
    byte[] arrayOfByte3 = f.getBytes(k);
    byte[] arrayOfByte4 = f.getBytes(n);
    byte[] arrayOfByte5 = new byte[16];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte5, 0, 4);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte5, 4, 4);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte5, 8, 4);
    System.arraycopy(arrayOfByte4, 0, arrayOfByte5, 12, 4);
    return c.encodeToString(arrayOfByte5, 2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\e\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */