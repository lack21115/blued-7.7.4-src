package com.cmic.sso.sdk.utils;

import android.os.Build;
import com.cmic.sso.sdk.utils.a.a;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class m {
  private static final String a = m.class.getSimpleName();
  
  private static m c = null;
  
  private PublicKey b = null;
  
  private m() {
    try {
      if (this.b == null) {
        b();
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static m a() {
    if (c == null)
      c = new m(); 
    return c;
  }
  
  private void b() throws Exception {
    try {
      KeyFactory keyFactory;
      byte[] arrayOfByte = (new a()).a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/YHP9utFGOhGk7Xf5L7jOgQz5\nv2JKxdrIE3yzYsHoZJwzKC7Ttx380UZmBFzr5I1k6FFMn/YGXd4ts6UHT/nzsCIc\ngZlTTem7Pjdm1V9bJgQ6iQvFHsvT+vNgJ3wAIRd+iCMXm8y96yZhD2+SH5odBYS2\nZzwTYXBQDvB/rTfdjwIDAQAB");
      int i = Build.VERSION.SDK_INT;
      if (i >= 28) {
        keyFactory = KeyFactory.getInstance("RSA");
      } else {
        keyFactory = KeyFactory.getInstance("RSA", "BC");
      } 
      this.b = keyFactory.generatePublic(new X509EncodedKeySpec(arrayOfByte));
      return;
    } catch (IOException iOException) {
      throw new Exception("公钥数据流读取错误");
    } catch (NullPointerException nullPointerException) {
      throw new Exception("公钥输入流为空");
    } 
  }
  
  public String a(String paramString) {
    if (this.b == null) {
      f.a(a, "mServerPublicKey == null");
      return null;
    } 
    try {
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      cipher.init(1, this.b);
      return r.a(cipher.doFinal(paramString.getBytes("UTF-8")));
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */