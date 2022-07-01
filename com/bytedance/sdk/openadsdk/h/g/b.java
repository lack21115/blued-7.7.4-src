package com.bytedance.sdk.openadsdk.h.g;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class b {
  private static final MessageDigest a = a();
  
  private static final char[] b = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  public static String a(String paramString) {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/h/g/b.a : Ljava/security/MessageDigest;
    //   3: astore_1
    //   4: aload_1
    //   5: ifnonnull -> 11
    //   8: ldc ''
    //   10: areturn
    //   11: aload_0
    //   12: getstatic com/bytedance/sdk/openadsdk/h/g/d.a : Ljava/nio/charset/Charset;
    //   15: invokevirtual getBytes : (Ljava/nio/charset/Charset;)[B
    //   18: astore_0
    //   19: ldc com/bytedance/sdk/openadsdk/h/g/b
    //   21: monitorenter
    //   22: aload_1
    //   23: aload_0
    //   24: invokevirtual digest : ([B)[B
    //   27: astore_0
    //   28: ldc com/bytedance/sdk/openadsdk/h/g/b
    //   30: monitorexit
    //   31: aload_0
    //   32: invokestatic a : ([B)Ljava/lang/String;
    //   35: areturn
    //   36: astore_0
    //   37: ldc com/bytedance/sdk/openadsdk/h/g/b
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   22	31	36	finally
    //   37	40	36	finally
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0)
      return null; 
    char[] arrayOfChar = new char[paramArrayOfbyte.length << 1];
    int k = paramArrayOfbyte.length;
    int i = 0;
    int j = 0;
    while (i < k) {
      byte b1 = paramArrayOfbyte[i];
      int m = j + 1;
      char[] arrayOfChar1 = b;
      arrayOfChar[j] = arrayOfChar1[(b1 & 0xF0) >> 4];
      j = m + 1;
      arrayOfChar[m] = arrayOfChar1[b1 & 0xF];
      i++;
    } 
    return new String(arrayOfChar);
  }
  
  private static MessageDigest a() {
    try {
      return MessageDigest.getInstance("md5");
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\h\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */