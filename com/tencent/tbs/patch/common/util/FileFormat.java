package com.tencent.tbs.patch.common.util;

import java.io.File;
import java.io.FileInputStream;

public class FileFormat {
  public static boolean isElf32(String paramString) {
    File file = new File(paramString);
    if (!file.exists())
      return false; 
    try {
      FileInputStream fileInputStream = new FileInputStream(file);
      byte[] arrayOfByte = new byte[16];
      int i = fileInputStream.read(arrayOfByte, 0, 16);
      if (i != 16) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error: e_indent lenght should be 16, but actual is ");
        stringBuilder.append(i);
        PatchLogger.e("Read ELF header indent array", new Throwable(stringBuilder.toString()));
      } 
      i = arrayOfByte[4];
      return (i == 1);
    } catch (Throwable throwable) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Error:");
      stringBuilder.append(throwable.toString());
      PatchLogger.e("Read ELF header indent array", new Throwable(stringBuilder.toString()));
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\commo\\util\FileFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */