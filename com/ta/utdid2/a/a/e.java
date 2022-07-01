package com.ta.utdid2.a.a;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Random;

public class e {
  public static String a() {
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = (int)System.nanoTime();
    int k = (new Random()).nextInt();
    int m = (new Random()).nextInt();
    byte[] arrayOfByte1 = d.getBytes(i);
    byte[] arrayOfByte2 = d.getBytes(j);
    byte[] arrayOfByte3 = d.getBytes(k);
    byte[] arrayOfByte4 = d.getBytes(m);
    byte[] arrayOfByte5 = new byte[16];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte5, 0, 4);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte5, 4, 4);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte5, 8, 4);
    System.arraycopy(arrayOfByte4, 0, arrayOfByte5, 12, 4);
    return b.encodeToString(arrayOfByte5, 2);
  }
  
  public static String a(Context paramContext) {
    boolean bool = c.a();
    String str3 = null;
    String str2 = str3;
    if (!bool) {
      str2 = str3;
      if (paramContext != null)
        try {
          TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
          str2 = str3;
          if (telephonyManager != null)
            str2 = telephonyManager.getDeviceId(); 
        } catch (Exception exception) {
          str2 = str3;
        }  
    } 
    str3 = str2;
    if (g.a(str2))
      str3 = b(); 
    str2 = str3;
    if (g.a(str3))
      str2 = b(paramContext); 
    String str1 = str2;
    if (g.a(str2))
      str1 = a(); 
    return str1;
  }
  
  private static String b() {
    String str2 = h.get("ro.aliyun.clouduuid", "");
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = h.get("ro.sys.aliyun.clouduuid", ""); 
    return TextUtils.isEmpty(str1) ? c() : str1;
  }
  
  private static String b(Context paramContext) {
    String str;
    try {
      str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    } finally {
      paramContext = null;
    } 
    return str;
  }
  
  private static String c() {
    try {
      return (String)Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public static String c(Context paramContext) {
    String str3 = null;
    String str2 = str3;
    if (paramContext != null)
      try {
        TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
        str2 = str3;
        if (telephonyManager != null)
          str2 = telephonyManager.getSubscriberId(); 
      } catch (Exception exception) {
        str2 = str3;
      }  
    String str1 = str2;
    if (g.a(str2))
      str1 = a(); 
    return str1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\t\\utdid2\a\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */