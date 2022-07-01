package com.huawei.hms.opendevice;

import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HEX;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class r {
  public static String a(String paramString1, String paramString2) {
    try {
      byte[] arrayOfByte = paramString1.getBytes("UTF-8");
      boolean bool = TextUtils.isEmpty(paramString2);
      if (bool)
        paramString2 = "SHA-256"; 
      MessageDigest messageDigest = MessageDigest.getInstance(paramString2);
      messageDigest.update(arrayOfByte);
      return HEX.encodeHexString(messageDigest.digest(), false);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      HMSLog.e("SHACoder", "encrypt failed .");
      return null;
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      HMSLog.e("SHACoder", "trans failed .");
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\opendevice\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */