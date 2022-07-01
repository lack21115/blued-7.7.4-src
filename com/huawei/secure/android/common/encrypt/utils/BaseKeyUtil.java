package com.huawei.secure.android.common.encrypt.utils;

import com.huawei.secure.android.common.encrypt.hash.PBKDF2;

public class BaseKeyUtil {
  private static final String a = BaseKeyUtil.class.getSimpleName();
  
  private static int a(int paramInt1, int paramInt2, int paramInt3) {
    int i = paramInt1;
    if (paramInt2 < paramInt1)
      i = paramInt2; 
    paramInt1 = i;
    if (paramInt3 < i)
      paramInt1 = paramInt3; 
    return paramInt1;
  }
  
  private static boolean a(int paramInt) {
    return (paramInt >= 16);
  }
  
  private static boolean a(int paramInt, byte[] paramArrayOfbyte) {
    return a(paramInt) & a(paramArrayOfbyte);
  }
  
  private static boolean a(byte[] paramArrayOfbyte) {
    return (paramArrayOfbyte.length >= 16);
  }
  
  public static byte[] a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfbyte, int paramInt, boolean paramBoolean) {
    byte[] arrayOfByte1 = HexUtil.a(paramString1);
    byte[] arrayOfByte2 = HexUtil.a(paramString2);
    byte[] arrayOfByte3 = HexUtil.a(paramString3);
    int i = a(arrayOfByte1.length, arrayOfByte2.length, arrayOfByte3.length);
    if (a(i, paramArrayOfbyte)) {
      char[] arrayOfChar = new char[i];
      int j;
      for (j = 0; j < i; j++)
        arrayOfChar[j] = (char)(arrayOfByte1[j] ^ arrayOfByte2[j] ^ arrayOfByte3[j]); 
      if (!paramBoolean) {
        b.b(a, "exportRootKey: sha1");
        return PBKDF2.a(arrayOfChar, paramArrayOfbyte, 10000, paramInt * 8);
      } 
      b.b(a, "exportRootKey: sha256");
      return PBKDF2.b(arrayOfChar, paramArrayOfbyte, 10000, paramInt * 8);
    } 
    throw new IllegalArgumentException("key length must be more than 128bit.");
  }
  
  public static byte[] a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfbyte, boolean paramBoolean) {
    return a(paramString1, paramString2, paramString3, paramArrayOfbyte, 16, paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\encryp\\utils\BaseKeyUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */