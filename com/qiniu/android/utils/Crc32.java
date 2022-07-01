package com.qiniu.android.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CRC32;

public final class Crc32 {
  public static long bytes(byte[] paramArrayOfbyte) {
    return bytes(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public static long bytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    CRC32 cRC32 = new CRC32();
    cRC32.update(paramArrayOfbyte, paramInt1, paramInt2);
    return cRC32.getValue();
  }
  
  public static long file(File paramFile) throws IOException {
    FileInputStream fileInputStream = new FileInputStream(paramFile);
    byte[] arrayOfByte = new byte[65536];
    CRC32 cRC32 = new CRC32();
    try {
      while (true) {
        int i = fileInputStream.read(arrayOfByte);
        if (i != -1) {
          cRC32.update(arrayOfByte, 0, i);
          continue;
        } 
        break;
      } 
      fileInputStream.close();
    } catch (Exception exception) {
      exception.printStackTrace();
      fileInputStream.close();
    } finally {}
    return cRC32.getValue();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\androi\\utils\Crc32.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */