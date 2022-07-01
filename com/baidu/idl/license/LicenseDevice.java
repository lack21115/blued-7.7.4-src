package com.baidu.idl.license;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Iterator;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class LicenseDevice {
  private static final String KEY_DEVICE = "com.baidu.face.deviceid";
  
  private static final String KEY_FACE = "com.baidu.face";
  
  private static final String KEY_IMEI = "com.baidu.face.i";
  
  public static String decrypt(String paramString1, String paramString2) throws Exception {
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramString2.getBytes("ASCII"), "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      cipher.init(2, secretKeySpec, new IvParameterSpec("01251500ascfacei".getBytes()));
      byte[] arrayOfByte = Base64.decode(paramString1, 2);
      try {
        return new String(cipher.doFinal(arrayOfByte));
      } catch (Exception exception) {
        return "";
      } 
    } catch (Exception exception) {
      System.out.println(exception.toString());
      return "";
    } 
  }
  
  public static String encrypt(String paramString1, String paramString2) throws Exception {
    SecretKeySpec secretKeySpec = new SecretKeySpec(paramString2.getBytes(), "AES");
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(1, secretKeySpec, new IvParameterSpec("01251500ascfacei".getBytes()));
    return Base64.encodeToString(cipher.doFinal(paramString1.getBytes()), 2);
  }
  
  public static String getAndroidID(Context paramContext) {
    return Settings.System.getString(paramContext.getContentResolver(), "android_id");
  }
  
  public static String getDeviceCode(Context paramContext) {
    try {
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (telephonyManager != null && paramContext.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0)
        return telephonyManager.getDeviceId(); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return "";
  }
  
  public static String getDeviceID(Context paramContext) {
    StringBuilder stringBuilder;
    String str2 = "";
    String str3 = getAndroidID(paramContext);
    if (Build.VERSION.SDK_INT >= 23) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("com.baidu.face");
      stringBuilder.append(str3);
      return md5(stringBuilder.toString().getBytes());
    } 
    String str1 = str2;
    try {
      String str4;
      String str5 = getImei((Context)stringBuilder);
      str1 = str2;
      if (!TextUtils.isEmpty(str5)) {
        str1 = str2;
        String str = Settings.System.getString(stringBuilder.getContentResolver(), "com.baidu.face.deviceid");
        str1 = str2;
        boolean bool = TextUtils.isEmpty(str);
        if (!bool)
          try {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(str5);
            stringBuilder4.append(1);
            String str6 = decrypt(str, stringBuilder4.toString());
            bool = TextUtils.isEmpty(str6);
            if (!bool)
              return str6; 
          } catch (Exception exception) {
            str1 = str2;
            exception.printStackTrace();
          }  
        str1 = str2;
        StringBuilder stringBuilder3 = new StringBuilder();
        str1 = str2;
        stringBuilder3.append(str5);
        str1 = str2;
        stringBuilder3.append(str3);
        str1 = str2;
        stringBuilder3.append(UUID.randomUUID());
        str1 = str2;
        str2 = md5(stringBuilder3.toString().getBytes());
        str1 = str2;
        StringBuilder stringBuilder2 = new StringBuilder();
        str1 = str2;
        stringBuilder2.append(str5);
        str1 = str2;
        stringBuilder2.append(1);
        str1 = str2;
        str4 = encrypt(str2, stringBuilder2.toString());
        str1 = str2;
        Settings.System.putString(stringBuilder.getContentResolver(), "com.baidu.face.deviceid", str4);
        return str2;
      } 
      str1 = str2;
      null = getMacAddr();
      str1 = str2;
      StringBuilder stringBuilder1 = new StringBuilder();
      str1 = str2;
      stringBuilder1.append(null);
      str1 = str2;
      stringBuilder1.append(str4);
      str1 = str2;
      return md5(stringBuilder1.toString().getBytes());
    } catch (Exception exception) {
      exception.printStackTrace();
      return str1;
    } 
  }
  
  private static String getImei(Context paramContext) {
    String str = Settings.System.getString(paramContext.getContentResolver(), "com.baidu.face.i");
    if (!TextUtils.isEmpty(str))
      try {
        str = decrypt(str, "01251500ascfacei");
        if (!TextUtils.isEmpty(str)) {
          int i = str.length();
          if (i == 15)
            return str; 
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    str = getDeviceCode(paramContext);
    if (!TextUtils.isEmpty(str))
      try {
        String str1 = encrypt(str, "01251500ascfacei");
        Settings.System.putString(paramContext.getContentResolver(), "com.baidu.face.i", str1);
        return str;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return str;
  }
  
  public static String getMacAddr() {
    try {
      Iterator<NetworkInterface> iterator = Collections.<NetworkInterface>list(NetworkInterface.getNetworkInterfaces()).iterator();
      while (iterator.hasNext()) {
        NetworkInterface networkInterface = iterator.next();
        if (!networkInterface.getName().equalsIgnoreCase("wlan0"))
          continue; 
        byte[] arrayOfByte = networkInterface.getHardwareAddress();
        if (arrayOfByte == null)
          return ""; 
        StringBuilder stringBuilder = new StringBuilder();
        int j = arrayOfByte.length;
        for (int i = 0; i < j; i++) {
          stringBuilder.append(String.format("%02X:", new Object[] { Byte.valueOf(arrayOfByte[i]) }));
        } 
        if (stringBuilder.length() > 0)
          stringBuilder.deleteCharAt(stringBuilder.length() - 1); 
        return stringBuilder.toString();
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return "";
  }
  
  public static String md5(byte[] paramArrayOfbyte) {
    try {
      paramArrayOfbyte = MessageDigest.getInstance("MD5").digest(paramArrayOfbyte);
      StringBuilder stringBuilder = new StringBuilder(paramArrayOfbyte.length * 2);
      int j = paramArrayOfbyte.length;
      for (int i = 0; i < j; i++) {
        int k = paramArrayOfbyte[i] & 0xFF;
        if (k < 16)
          stringBuilder.append('0'); 
        stringBuilder.append(Integer.toHexString(k));
      } 
      return stringBuilder.toString();
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      noSuchAlgorithmException.printStackTrace();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return "";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\idl\license\LicenseDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */