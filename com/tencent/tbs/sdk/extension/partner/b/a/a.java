package com.tencent.tbs.sdk.extension.partner.b.a;

public class a {
  public static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null || paramArrayOfbyte.length <= 0)
      return null; 
    StringBuffer stringBuffer = new StringBuffer(paramArrayOfbyte.length * 2);
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      if ((paramArrayOfbyte[i] & 0xFF) < 16)
        stringBuffer.append("0"); 
      stringBuffer.append(Long.toString((paramArrayOfbyte[i] & 0xFF), 16));
    } 
    return stringBuffer.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */