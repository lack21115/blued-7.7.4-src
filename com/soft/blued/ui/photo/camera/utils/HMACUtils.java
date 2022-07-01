package com.soft.blued.ui.photo.camera.utils;

import com.soft.blued.utils.Logger;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HMACUtils {
  public static final String a = HMACUtils.class.getSimpleName();
  
  public static String a(String paramString1, String paramString2) {
    try {
      Mac mac = Mac.getInstance("HmacSHA256");
      mac.init(new SecretKeySpec(paramString2.getBytes(), "HmacSHA256"));
      return a(mac.doFinal(paramString1.getBytes()));
    } catch (Exception exception) {
      Logger.b(a, new Object[] { "Error sha256_HMAC == =========", exception });
      return "";
    } 
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; paramArrayOfbyte != null && i < paramArrayOfbyte.length; i++) {
      String str = Integer.toHexString(paramArrayOfbyte[i] & 0xFF);
      if (str.length() == 1)
        stringBuilder.append('0'); 
      stringBuilder.append(str);
    } 
    return stringBuilder.toString().toLowerCase();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\photo\camer\\utils\HMACUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */