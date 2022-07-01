package com.heytap.mcssdk.utils;

import android.util.Base64;
import java.nio.charset.Charset;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public abstract class DESUtil {
  public static String a(String paramString1, String paramString2) {
    Cipher cipher = Cipher.getInstance("DES");
    cipher.init(2, a(paramString2));
    return (new String(cipher.doFinal(Base64.decode(paramString1, 0)), Charset.defaultCharset())).trim();
  }
  
  private static Key a(String paramString) {
    DESKeySpec dESKeySpec = new DESKeySpec(Base64.decode(paramString, 0));
    return SecretKeyFactory.getInstance("DES").generateSecret(dESKeySpec);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\heytap\mcssd\\utils\DESUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */