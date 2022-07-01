package com.huawei.agconnect.config.a;

import android.content.Context;
import android.util.Log;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

class g extends f {
  private final Map<String, String> a = new HashMap<String, String>();
  
  private final Object b = new Object();
  
  private SecretKey c;
  
  g(Context paramContext, String paramString) {
    super(paramContext, paramString);
    try {
      String str1 = a("/AD91D45E3E72DB6989DDCB13287E75061FABCB933D886E6C6ABEF0939B577138");
      paramString = a("/B314B3BF013DF5AC4134E880AF3D2B7C9FFBE8F0305EAC1C898145E2BCF1F21C");
      String str2 = a("/C767BD8FDF53E53D059BE95B09E2A71056F5F180AECC62836B287ACA5793421B");
      String str3 = a("/DCB3E6D4C2CF80F30D89CDBC412C964DA8381BB84668769391FBCC3E329AD0FD");
      if (str1 != null && paramString != null && str2 != null && str3 != null) {
        this.c = e.a(c.a(str1), c.a(paramString), c.a(str2), c.a(str3));
        return;
      } 
    } catch (NoSuchAlgorithmException|java.security.spec.InvalidKeySpecException noSuchAlgorithmException) {
      Log.e("SecurityResourcesReader", "Exception when reading the 'K&I' for 'Config'.");
      this.c = null;
    } 
  }
  
  private String a(String paramString) {
    return super.a(paramString, null);
  }
  
  private static byte[] a(SecretKey paramSecretKey, byte[] paramArrayOfbyte) throws GeneralSecurityException {
    if (paramSecretKey != null && paramArrayOfbyte != null) {
      byte[] arrayOfByte = Arrays.copyOfRange(paramArrayOfbyte, 1, 17);
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      cipher.init(2, paramSecretKey, new IvParameterSpec(arrayOfByte));
      return cipher.doFinal(paramArrayOfbyte, arrayOfByte.length + 1, paramArrayOfbyte.length - arrayOfByte.length - 1);
    } 
    throw new NullPointerException("key or cipherText must not be null.");
  }
  
  public String a(String paramString1, String paramString2) {
    if (this.c == null) {
      Log.e("SecurityResourcesReader", "KEY is null return def directly");
      return paramString2;
    } 
    synchronized (this.b) {
      String str = this.a.get(paramString1);
      if (str != null)
        return str; 
      str = a(paramString1);
      if (str == null)
        return paramString2; 
      try {
        str = new String(a(this.c, c.a(str)), "UTF-8");
        this.a.put(paramString1, str);
        return str;
      } catch (GeneralSecurityException|java.io.UnsupportedEncodingException generalSecurityException) {}
      Log.e("SecurityResourcesReader", "Exception when reading the 'V' for 'Config'.");
      return paramString2;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\agconnect\config\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */