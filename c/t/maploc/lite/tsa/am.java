package c.t.maploc.lite.tsa;

import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

public final class am {
  private static final byte[] a = new byte[0];
  
  private static byte[] a(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte1 = arrayOfByte2;
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfbyte.length);
      arrayOfByte1 = arrayOfByte2;
      GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
      arrayOfByte1 = arrayOfByte2;
      gZIPOutputStream.write(paramArrayOfbyte);
      arrayOfByte1 = arrayOfByte2;
      gZIPOutputStream.close();
      arrayOfByte1 = arrayOfByte2;
      paramArrayOfbyte = byteArrayOutputStream.toByteArray();
      return paramArrayOfbyte;
    } finally {
      paramArrayOfbyte = null;
      paramArrayOfbyte.printStackTrace();
    } 
  }
  
  public static byte[] a(byte[] paramArrayOfbyte, String paramString) {
    if (paramArrayOfbyte != null && paramArrayOfbyte.length != 0) {
      paramArrayOfbyte = a.a(a(paramArrayOfbyte), paramString);
      if (paramArrayOfbyte != null && paramArrayOfbyte.length != 0) {
        byte[] arrayOfByte1 = new byte[paramArrayOfbyte.length + 2];
        int j = paramArrayOfbyte.length;
        byte[] arrayOfByte2 = new byte[2];
        for (int i = 0; i < 2; i++) {
          arrayOfByte2[i] = Integer.valueOf(j & 0xFF).byteValue();
          j >>= 8;
        } 
        System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, 2);
        System.arraycopy(paramArrayOfbyte, 0, arrayOfByte1, 2, paramArrayOfbyte.length);
        return arrayOfByte1;
      } 
    } 
    return a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */