package cn.com.chinatelecom.account.api.a;

public class c {
  private static final char[] a = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  public static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      stringBuilder.append(a[paramArrayOfbyte[i] >> 4 & 0xF]);
      stringBuilder.append(a[paramArrayOfbyte[i] & 0xF]);
    } 
    return stringBuilder.toString();
  }
  
  public static byte[] a(String paramString) {
    if (paramString == null)
      return null; 
    char[] arrayOfChar = paramString.toCharArray();
    int j = arrayOfChar.length / 2;
    byte[] arrayOfByte = new byte[j];
    for (int i = 0; i < j; i++) {
      int k = i * 2;
      int m = Character.digit(arrayOfChar[k], 16);
      m = Character.digit(arrayOfChar[k + 1], 16) | m << 4;
      k = m;
      if (m > 127)
        k = m - 256; 
      arrayOfByte[i] = (byte)k;
    } 
    return arrayOfByte;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\api\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */