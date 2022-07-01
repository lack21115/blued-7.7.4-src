package c.t.maploc.lite.tsa;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a {
  private static byte[] a = new byte[0];
  
  private static final byte[] b = new byte[] { 
      84, 101, 110, 99, 101, 110, 116, 76, 111, 99, 
      97, 116, 105, 111, 110, 49 };
  
  public static byte[] a(byte[] paramArrayOfbyte, String paramString) {
    return b(paramArrayOfbyte, paramString);
  }
  
  private static byte[] b(byte[] paramArrayOfbyte, String paramString) {
    if (paramArrayOfbyte != null && paramArrayOfbyte.length != 0)
      try {
        SecretKeySpec secretKeySpec = new SecretKeySpec(paramString.getBytes("UTF-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(b));
        return (cipher == null) ? a : cipher.doFinal(paramArrayOfbyte);
      } finally {} 
    return a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */