package com.huawei.hms.push;

import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;

public class c {
  public static byte[] a(Bundle paramBundle, String paramString) {
    try {
      byte[] arrayOfByte2 = paramBundle.getByteArray(paramString);
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null)
        arrayOfByte1 = new byte[0]; 
      return arrayOfByte1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getByteArray exception");
      stringBuilder.append(exception.getMessage());
      HMSLog.i("BundleUtil", stringBuilder.toString());
      return new byte[0];
    } 
  }
  
  public static String b(Bundle paramBundle, String paramString) {
    try {
      return paramBundle.getString(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getString exception");
      stringBuilder.append(exception.getMessage());
      HMSLog.i("BundleUtil", stringBuilder.toString());
      return null;
    } 
  }
  
  public static String c(Bundle paramBundle, String paramString) {
    try {
      String str = paramBundle.getString(paramString);
      return (str == null) ? "" : str;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getString exception");
      stringBuilder.append(exception.getMessage());
      HMSLog.i("BundleUtil", stringBuilder.toString());
      return "";
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\push\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */