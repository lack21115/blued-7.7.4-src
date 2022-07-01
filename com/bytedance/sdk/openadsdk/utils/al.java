package com.bytedance.sdk.openadsdk.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class al {
  private static File a(String paramString) {
    return b(paramString) ? null : new File(paramString);
  }
  
  public static List<File> a(File paramFile1, File paramFile2, String paramString) throws IOException {
    if (paramFile1 == null || paramFile2 == null)
      return null; 
    ArrayList<File> arrayList = new ArrayList();
    ZipFile zipFile = new ZipFile(paramFile1);
    Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
    try {
      boolean bool = b(paramString);
      if (bool) {
        while (enumeration.hasMoreElements()) {
          StringBuilder stringBuilder;
          ZipEntry zipEntry = enumeration.nextElement();
          paramString = zipEntry.getName();
          if (paramString.contains("../")) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("entryName: ");
            stringBuilder.append(paramString);
            stringBuilder.append(" is dangerous!");
            t.d("ZipUtils", stringBuilder.toString());
            continue;
          } 
          bool = a(paramFile2, arrayList, zipFile, (ZipEntry)stringBuilder, paramString);
          if (!bool)
            return arrayList; 
        } 
      } else {
        while (enumeration.hasMoreElements()) {
          StringBuilder stringBuilder;
          ZipEntry zipEntry = enumeration.nextElement();
          String str = zipEntry.getName();
          if (str.contains("../")) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("entryName: ");
            stringBuilder.append(str);
            stringBuilder.append(" is dangerous!");
            t.d("ZipUtils", stringBuilder.toString());
            continue;
          } 
          if (str.contains(paramString)) {
            bool = a(paramFile2, arrayList, zipFile, (ZipEntry)stringBuilder, str);
            if (!bool)
              return arrayList; 
          } 
        } 
      } 
      return arrayList;
    } finally {
      zipFile.close();
    } 
  }
  
  public static List<File> a(String paramString1, String paramString2) throws IOException {
    return a(paramString1, paramString2, (String)null);
  }
  
  public static List<File> a(String paramString1, String paramString2, String paramString3) throws IOException {
    return a(a(paramString1), a(paramString2), paramString3);
  }
  
  private static boolean a(File paramFile) {
    return (paramFile != null && (paramFile.exists() ? paramFile.isDirectory() : paramFile.mkdirs()));
  }
  
  private static boolean a(File paramFile, List<File> paramList, ZipFile paramZipFile, ZipEntry paramZipEntry, String paramString) throws IOException {
    File file;
    paramFile = new File(paramFile, paramString);
    paramList.add(paramFile);
    if (paramZipEntry.isDirectory())
      return a(paramFile); 
    if (!b(paramFile))
      return false; 
    ZipFile zipFile = null;
    try {
      FileOutputStream fileOutputStream;
    } finally {
      paramList = null;
      paramFile = null;
      file = paramFile;
    } 
    if (paramZipFile != null)
      paramZipFile.close(); 
    if (paramFile != null)
      paramFile.close(); 
    if (file != null)
      file.close(); 
    throw paramList;
  }
  
  private static boolean b(File paramFile) {
    if (paramFile == null)
      return false; 
    if (paramFile.exists())
      return paramFile.isFile(); 
    if (!a(paramFile.getParentFile()))
      return false; 
    try {
      return paramFile.createNewFile();
    } finally {
      paramFile = null;
    } 
  }
  
  private static boolean b(String paramString) {
    if (paramString == null)
      return true; 
    int j = paramString.length();
    for (int i = 0; i < j; i++) {
      if (!Character.isWhitespace(paramString.charAt(i)))
        return false; 
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */