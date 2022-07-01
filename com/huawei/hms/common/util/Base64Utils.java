package com.huawei.hms.common.util;

import android.util.Base64;
import com.huawei.hms.support.log.HMSLog;

public final class Base64Utils {
  private static final int FLAG_DEFAULT = 0;
  
  private static final int FLAG_URL = 10;
  
  private static final int FLAG_URL_NOPADDING = 11;
  
  private static final String TAG = "Base64Utils";
  
  public static byte[] decode(String paramString) {
    if (paramString != null)
      try {
        return Base64.decode(paramString, 0);
      } catch (IllegalArgumentException illegalArgumentException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("decode failed : ");
        stringBuilder.append(illegalArgumentException.getMessage());
        HMSLog.e("Base64Utils", stringBuilder.toString());
      }  
    return new byte[0];
  }
  
  public static byte[] decodeUrlSafe(String paramString) {
    if (paramString != null)
      try {
        return Base64.decode(paramString, 10);
      } catch (IllegalArgumentException illegalArgumentException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("decodeUrlSafe failed : ");
        stringBuilder.append(illegalArgumentException.getMessage());
        HMSLog.e("Base64Utils", stringBuilder.toString());
      }  
    return new byte[0];
  }
  
  public static byte[] decodeUrlSafeNoPadding(String paramString) {
    if (paramString != null)
      try {
        return Base64.decode(paramString, 11);
      } catch (IllegalArgumentException illegalArgumentException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("decodeUrlSafeNoPadding failed : ");
        stringBuilder.append(illegalArgumentException.getMessage());
        HMSLog.e("Base64Utils", stringBuilder.toString());
      }  
    return new byte[0];
  }
  
  public static String encode(byte[] paramArrayOfbyte) {
    return (paramArrayOfbyte != null) ? Base64.encodeToString(paramArrayOfbyte, 0) : null;
  }
  
  public static String encodeUrlSafe(byte[] paramArrayOfbyte) {
    return (paramArrayOfbyte != null) ? Base64.encodeToString(paramArrayOfbyte, 10) : null;
  }
  
  public static String encodeUrlSafeNoPadding(byte[] paramArrayOfbyte) {
    return (paramArrayOfbyte != null) ? Base64.encodeToString(paramArrayOfbyte, 11) : null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\commo\\util\Base64Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */