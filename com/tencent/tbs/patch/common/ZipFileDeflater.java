package com.tencent.tbs.patch.common;

import com.tencent.tbs.patch.common.util.FileUtils;
import com.tencent.tbs.patch.common.util.PatchLogger;
import com.tencent.tbs.patch.common.util.StringUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipFileDeflater extends FileHolderDeflater {
  public ZipFileDeflater() {
    super(new DefaultFileDeflateAdapter());
  }
  
  public ZipFileDeflater(FileDeflateAdapter paramFileDeflateAdapter) {
    super(paramFileDeflateAdapter);
  }
  
  public void parse(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Parent dir: ");
    stringBuilder.append(paramString1);
    PatchLogger.e(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("Path: ");
    stringBuilder.append(paramString2);
    PatchLogger.e(stringBuilder.toString());
    try {
      File file = FileUtils.makeTempDir(paramString1);
      FileUtils.assertFileExists(paramString2);
      ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(paramString2));
      label22: while (true) {
        ZipEntry zipEntry = zipInputStream.getNextEntry();
        if (zipEntry != null) {
          String str = zipEntry.getName();
          PatchLogger.e(str);
          if (!StringUtils.isBlank(str) && a(str) && !str.endsWith(File.separator)) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(file.getAbsolutePath());
            stringBuilder1.append(File.separator);
            stringBuilder1.append(str.replaceAll("\\*", File.separator));
            File file1 = new File(stringBuilder1.toString());
            FileUtils.makeParentDir(file1);
            FileOutputStream fileOutputStream = new FileOutputStream(file1);
            byte[] arrayOfByte = new byte[1024];
            while (true) {
              int i = zipInputStream.read(arrayOfByte);
              if (i <= 0) {
                FileUtils.closeQuietly(fileOutputStream);
                a(str, file1.getAbsolutePath());
                continue label22;
              } 
              fileOutputStream.write(arrayOfByte, 0, i);
            } 
          } 
          continue;
        } 
        break;
      } 
      return;
    } catch (IOException iOException) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Error: ");
      stringBuilder1.append(iOException.getMessage());
      throw new PatchException(stringBuilder1.toString());
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\common\ZipFileDeflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */