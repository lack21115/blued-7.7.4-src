package c.t.maploc.lite.tsa;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class ak {
  private static final byte[] a = new byte[0];
  
  private static final int[] b = new int[] { 93629, 99879, 79843, 75029, 59699, 55667, 46867, 38039 };
  
  public static byte[] a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return null; 
    for (int i = 0; i < paramArrayOfbyte.length; i++)
      paramArrayOfbyte[i] = (byte)(byte)(paramArrayOfbyte[i] ^ b[i & 0x7] & 0xFF); 
    return paramArrayOfbyte;
  }
  
  public static byte[] a(byte[] paramArrayOfbyte, String paramString) {
    return b(paramArrayOfbyte, paramString);
  }
  
  private static byte[] b(byte[] paramArrayOfbyte, String paramString) {
    if (paramArrayOfbyte != null && paramArrayOfbyte.length != 0)
      try {
        byte[] arrayOfByte;
        SecretKeySpec secretKeySpec = new SecretKeySpec(paramString.getBytes("UTF-8"), "AES");
        Cipher cipher = Cipher.getInstance(new String(Base64.decode("QUVTL0VDQi9Ob1BhZGRpbmc=", 2)));
        cipher.init(1, secretKeySpec);
        if (cipher == null)
          return a; 
        int j = paramArrayOfbyte.length;
        int i = 0;
        while (true) {
          arrayOfByte = paramArrayOfbyte;
          if (i < j) {
            int k = i + 16;
            if (k > j) {
              while (true) {
                arrayOfByte = paramArrayOfbyte;
                if (i < j) {
                  paramArrayOfbyte[i] = (byte)(byte)(paramArrayOfbyte[i] ^ 0x5B);
                  i++;
                  continue;
                } 
                break;
              } 
              break;
            } 
            cipher.doFinal(paramArrayOfbyte, i, 16, paramArrayOfbyte, i);
            i = k;
            continue;
          } 
          break;
        } 
        return arrayOfByte;
      } finally {} 
    return a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */