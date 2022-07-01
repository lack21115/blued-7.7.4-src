package com.tencent.tbs.sdk.extension.partner.incrupdate.a;

import java.io.File;
import java.io.FileInputStream;
import java.util.zip.CRC32;

public final class a {
  public static long a(File paramFile) {
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\incrupdate\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */