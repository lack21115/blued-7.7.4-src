package com.ishumei.sdk.captcha;

import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.crypto.Cipher;

public class O000O00000OoO {
  public static PublicKey O0000O000000oO(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(paramString, 0));
      return ((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream)).getPublicKey();
    } 
    throw new IllegalAccessException("empty publicKeyStr");
  }
  
  public static byte[] O0000O000000oO(PublicKey paramPublicKey, byte[] paramArrayOfbyte) {
    if (paramPublicKey != null) {
      if (paramArrayOfbyte != null && paramArrayOfbyte.length != 0) {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, paramPublicKey);
        return cipher.doFinal(paramArrayOfbyte);
      } 
      throw new IllegalArgumentException("empty data");
    } 
    throw new Exception("public key can not be null!");
  }
  
  public static byte[] O0000O000000oO(byte[] paramArrayOfbyte) {
    return O0000O000000oO(O0000O000000oO("MIIDOzCCAiOgAwIBAgIBMDANBgkqhkiG9w0BAQUFADA4MQswCQYDVQQGEwJDTjENMAsGA1UECwwEQ05DQjEaMBgGA1UEAwwRZS5iYW5rLmVjaXRpYy5jb20wHhcNMTgwMjExMDg0NTIyWhcNMzgwMjA2MDg0NTIyWjA4MQswCQYDVQQGEwJDTjENMAsGA1UECwwEQ05DQjEaMBgGA1UEAwwRZS5iYW5rLmVjaXRpYy5jb20wggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCkF+2AicVKj7SaHw3dbJt3i6fkL1WfLw1WRqe8r8Cc7qJOshaqNvCzW1qRX6E5H/umtl1Uj99V07uewUFk96xY/+s/GuBnbGoSrcu3OAHDgEGuY5atZo+umIk7LufAif2VUcNGY3nWxGcig20ExO/6nAf/G3Xxo4QL8fBdPG/prOXxSvtJiPls1Qg9zzSgAH+HMCAINMsuJmzDQiTt6Me8k7YHts+jWQF7KF25plITcW1Qmy3Aw8qYjVhbHn8KTAEeuQhmM5RS6KP1Hu71q4DYOWcx44QThSbiAYwG1JQBBwM8XnBfVYMpr6Qi0owibNYoZ/S6xwfRFGB0W1HeG9WfAgMBAAGjUDBOMB0GA1UdDgQWBBT0iLEXY9HIKNy5DG4d72l+R7Nf1zAfBgNVHSMEGDAWgBT0iLEXY9HIKNy5DG4d72l+R7Nf1zAMBgNVHRMEBTADAQH/MA0GCSqGSIb3DQEBBQUAA4IBAQB5MWz1RGFG537rJCtHp+LqxR9iJSFsHiW3ZoLIAeyD0oJ69RcL2gE/TNWmE9zYUkd9TdNtXqxlNPpj1P1/+x781neWnGou/n/XFS82T5S339X3DIjHc/IqOzwnxEOKH2V0NmK9iKgx6H05Q9MMvUXFsL3QK2hDMAVY28roRiC4S1yfJJaA08DfvXZf6cVx1xfWl+ks57+3knkoWap1rjwh1RdGk5ChPbzD0AnAcWTMWRCbjuJnttlmWZnI1I6mhcQUKUEMoj8sR8m11YJ5woscYPsIle/rJOOosuMghczD1vRcg3eLUaWn1A5rsBa82RyxhiuYocEQVX59Hy6v3npT"), paramArrayOfbyte);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\sdk\captcha\O000O00000OoO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */