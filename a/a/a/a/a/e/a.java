package a.a.a.a.a.e;

import java.security.GeneralSecurityException;
import java.security.SignatureException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class a {
  public static Mac a(SecretKeySpec paramSecretKeySpec) throws GeneralSecurityException {
    Mac mac = Mac.getInstance("HmacSHA1");
    mac.init(paramSecretKeySpec);
    return mac;
  }
  
  public static byte[] a(String paramString1, String paramString2) throws SignatureException {
    try {
      Mac mac = a(new SecretKeySpec(paramString1.getBytes("UTF-8"), "HmacSHA1"));
      mac.update(paramString2.getBytes("UTF-8"));
      return mac.doFinal();
    } catch (Exception exception) {
      exception.printStackTrace();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to digest: ");
      stringBuilder.append(exception.getMessage());
      throw new SignatureException(stringBuilder.toString());
    } 
  }
  
  public static String b(String paramString1, String paramString2) throws SignatureException {
    return g.a(a(paramString1, paramString2));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */