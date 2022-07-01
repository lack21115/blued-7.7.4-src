package com.blued.android.core.image.apng.io;

import android.text.TextUtils;
import java.io.IOException;

public class APNGReader extends FilterReader {
  private static ThreadLocal<byte[]> b = (ThreadLocal)new ThreadLocal<byte>();
  
  public APNGReader(Reader paramReader) {
    super(paramReader);
  }
  
  protected static byte[] a() {
    byte[] arrayOfByte2 = b.get();
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null) {
      arrayOfByte1 = new byte[4];
      b.set(arrayOfByte1);
    } 
    return arrayOfByte1;
  }
  
  public boolean a(String paramString) throws IOException {
    if (!TextUtils.isEmpty(paramString)) {
      if (paramString.length() != 4)
        return false; 
      int j = d();
      for (int i = 0; i < 4; i++) {
        if ((j >> i * 8 & 0xFF) != paramString.charAt(i))
          return false; 
      } 
      return true;
    } 
    return false;
  }
  
  public short c() throws IOException {
    byte[] arrayOfByte = a();
    read(arrayOfByte, 0, 2);
    byte b = arrayOfByte[1];
    return (short)((arrayOfByte[0] & 0xFF) << 8 | b & 0xFF);
  }
  
  public int d() throws IOException {
    byte[] arrayOfByte = a();
    read(arrayOfByte, 0, 4);
    byte b1 = arrayOfByte[0];
    byte b2 = arrayOfByte[1];
    byte b3 = arrayOfByte[2];
    return (arrayOfByte[3] & 0xFF) << 24 | b1 & 0xFF | (b2 & 0xFF) << 8 | (b3 & 0xFF) << 16;
  }
  
  public int r_() throws IOException {
    byte[] arrayOfByte = a();
    read(arrayOfByte, 0, 4);
    byte b1 = arrayOfByte[3];
    byte b2 = arrayOfByte[2];
    byte b3 = arrayOfByte[1];
    return (arrayOfByte[0] & 0xFF) << 24 | b1 & 0xFF | (b2 & 0xFF) << 8 | (b3 & 0xFF) << 16;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\apng\io\APNGReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */