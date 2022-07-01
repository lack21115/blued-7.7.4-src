package com.tencent.tbs.patch.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipNormalizer {
  private static void a(Closeable paramCloseable) {
    if (paramCloseable == null)
      return; 
    try {
      paramCloseable.close();
      return;
    } catch (Throwable throwable) {
      return;
    } 
  }
  
  private static void a(InputStream paramInputStream, OutputStream paramOutputStream) {
    byte[] arrayOfByte = new byte[1024];
    while (true) {
      int i = paramInputStream.read(arrayOfByte);
      if (i <= 0)
        return; 
      paramOutputStream.write(arrayOfByte, 0, i);
    } 
  }
  
  private static void a(ZipInputStream paramZipInputStream, ZipOutputStream paramZipOutputStream, String paramString, boolean paramBoolean) {
    ZipEntry zipEntry;
    if (paramBoolean) {
      while (true) {
        ZipEntry zipEntry1 = paramZipInputStream.getNextEntry();
        if (zipEntry1 != null) {
          paramString = zipEntry1.getName();
          if (!zipEntry1.isDirectory()) {
            ByteArrayOutputStream byteArrayOutputStream;
            if (paramString.endsWith(".jar") || paramString.endsWith(".apk") || paramString.endsWith(".zip")) {
              ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
              a(paramZipInputStream, byteArrayOutputStream1);
              a(byteArrayOutputStream1);
              byteArrayOutputStream = new ByteArrayOutputStream();
              ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
              zipOutputStream.setLevel(9);
              a(new ZipInputStream(new ByteArrayInputStream(byteArrayOutputStream1.toByteArray())), zipOutputStream, null, true);
              a(zipOutputStream);
              zipEntry = new ZipEntry(paramString);
              zipEntry.setTime(0L);
              zipEntry.setComment(null);
              zipEntry.setExtra(null);
              zipEntry.setMethod(8);
              paramZipOutputStream.putNextEntry(zipEntry);
              paramZipOutputStream.write(byteArrayOutputStream.toByteArray());
              paramZipOutputStream.flush();
              paramZipOutputStream.closeEntry();
              continue;
            } 
            a(paramZipInputStream, paramZipOutputStream, byteArrayOutputStream.getName(), false);
          } 
          continue;
        } 
        break;
      } 
    } else if (zipEntry != null) {
      zipEntry = new ZipEntry((String)zipEntry);
      zipEntry.setTime(0L);
      zipEntry.setExtra(null);
      paramZipOutputStream.putNextEntry(zipEntry);
      a(paramZipInputStream, paramZipOutputStream);
      paramZipOutputStream.flush();
      paramZipOutputStream.closeEntry();
    } 
  }
  
  public static void normalizeArchive(String paramString1, String paramString2) {
    ZipOutputStream zipOutputStream;
    File file2 = new File(paramString2);
    File file1 = new File(paramString1);
    if (file1.exists()) {
      if (!file2.getParentFile().exists())
        file2.getParentFile().mkdirs(); 
      zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
      zipOutputStream.setLevel(9);
      ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(paramString1));
      a(zipInputStream, zipOutputStream, null, true);
      a(zipInputStream);
      a(zipOutputStream);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Input file is not exist: ");
    stringBuilder.append(zipOutputStream.getAbsolutePath());
    throw new IOException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\common\ZipNormalizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */