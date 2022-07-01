package com.blued.android.core;

import com.blued.android.core.utils.ByteArrayPool;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Zip {
  public static String a(InputStream paramInputStream, String paramString) throws Exception {
    ZipInputStream zipInputStream = new ZipInputStream(paramInputStream);
    paramInputStream = null;
    while (true) {
      String str;
      ZipEntry zipEntry = zipInputStream.getNextEntry();
      if (zipEntry != null) {
        str = zipEntry.getName();
        if (zipEntry.isDirectory()) {
          str = str.substring(0, str.length() - 1);
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(paramString);
          stringBuilder1.append(File.separator);
          stringBuilder1.append(str);
          (new File(stringBuilder1.toString())).mkdirs();
          continue;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString);
        stringBuilder.append(File.separator);
        stringBuilder.append(str);
        File file = new File(stringBuilder.toString());
        if (!file.exists()) {
          File file1 = file.getParentFile();
          if (!file1.exists())
            file1.mkdirs(); 
          file.createNewFile();
        } 
        str = file.getParentFile().getName();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] arrayOfByte = ByteArrayPool.a.a(1024);
        while (true) {
          int i = zipInputStream.read(arrayOfByte);
          if (i != -1) {
            fileOutputStream.write(arrayOfByte, 0, i);
            fileOutputStream.flush();
            continue;
          } 
          ByteArrayPool.a.a(arrayOfByte);
          fileOutputStream.close();
        } 
        break;
      } 
      zipInputStream.close();
      return str;
    } 
  }
  
  public static String a(String paramString1, String paramString2) throws Exception {
    paramString2 = a(new FileInputStream(paramString1), paramString2);
    File file = new File(paramString1);
    if (file.exists())
      file.delete(); 
    return paramString2;
  }
  
  private static void a(String paramString1, String paramString2, ZipOutputStream paramZipOutputStream) throws Exception {
    StringBuilder stringBuilder1;
    FileInputStream fileInputStream;
    if (paramZipOutputStream == null)
      return; 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString1);
    stringBuilder2.append(paramString2);
    File file = new File(stringBuilder2.toString());
    boolean bool = file.isFile();
    int i = 0;
    if (bool) {
      ZipEntry zipEntry = new ZipEntry(paramString2);
      fileInputStream = new FileInputStream(file);
      paramZipOutputStream.putNextEntry(zipEntry);
      byte[] arrayOfByte = ByteArrayPool.a.a(1024);
      while (true) {
        i = fileInputStream.read(arrayOfByte);
        if (i != -1) {
          paramZipOutputStream.write(arrayOfByte, 0, i);
          continue;
        } 
        paramZipOutputStream.closeEntry();
        fileInputStream.close();
        ByteArrayPool.a.a(arrayOfByte);
        return;
      } 
    } 
    String[] arrayOfString = file.list();
    if (arrayOfString == null || arrayOfString.length <= 0) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append((String)fileInputStream);
      stringBuilder1.append(File.separator);
      paramZipOutputStream.putNextEntry(new ZipEntry(stringBuilder1.toString()));
      paramZipOutputStream.closeEntry();
      return;
    } 
    while (i < arrayOfString.length) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append((String)fileInputStream);
      stringBuilder.append(File.separator);
      stringBuilder.append(arrayOfString[i]);
      a((String)stringBuilder1, stringBuilder.toString(), paramZipOutputStream);
      i++;
    } 
  }
  
  public static void b(String paramString1, String paramString2) throws Exception {
    ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(paramString2));
    File file = new File(paramString1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(file.getParent());
    stringBuilder.append(File.separator);
    a(stringBuilder.toString(), file.getName(), zipOutputStream);
    zipOutputStream.finish();
    zipOutputStream.close();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\Zip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */