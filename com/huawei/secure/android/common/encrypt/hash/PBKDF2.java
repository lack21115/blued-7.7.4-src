package com.huawei.secure.android.common.encrypt.hash;

import android.os.Build;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public abstract class PBKDF2 {
  private static final String a = PBKDF2.class.getSimpleName();
  
  public static byte[] a(char[] paramArrayOfchar, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return a(paramArrayOfchar, paramArrayOfbyte, paramInt1, paramInt2, false);
  }
  
  private static byte[] a(char[] paramArrayOfchar, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
    try {
      SecretKeyFactory secretKeyFactory;
      PBEKeySpec pBEKeySpec = new PBEKeySpec(paramArrayOfchar, paramArrayOfbyte, paramInt1, paramInt2);
      if (paramBoolean) {
        secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
      } else {
        secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
      } 
      return secretKeyFactory.generateSecret(pBEKeySpec).getEncoded();
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
    
    } catch (InvalidKeySpecException invalidKeySpecException) {}
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("pbkdf exception : ");
    stringBuilder.append(invalidKeySpecException.getMessage());
    b.c(str, stringBuilder.toString());
    return new byte[0];
  }
  
  public static byte[] b(char[] paramArrayOfchar, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (Build.VERSION.SDK_INT < 26) {
      b.c(a, "system version not high than 26");
      return new byte[0];
    } 
    return a(paramArrayOfchar, paramArrayOfbyte, paramInt1, paramInt2, true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\encrypt\hash\PBKDF2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */