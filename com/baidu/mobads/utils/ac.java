package com.baidu.mobads.utils;

import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class ac {
  private static File a(String paramString) {
    return b(paramString) ? null : new File(paramString);
  }
  
  public static List<File> a(File paramFile1, File paramFile2, String paramString) {
    ZipEntry zipEntry;
    if (paramFile1 == null || paramFile2 == null)
      return null; 
    ArrayList<File> arrayList = new ArrayList();
    ZipFile zipFile = new ZipFile(paramFile1);
    Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
    if (b(paramString)) {
      while (enumeration.hasMoreElements()) {
        zipEntry = enumeration.nextElement();
        String str = zipEntry.getName();
        if (c(str) && !a(paramFile2, arrayList, zipFile, zipEntry, str))
          return arrayList; 
      } 
    } else {
      while (enumeration.hasMoreElements()) {
        ZipEntry zipEntry1 = enumeration.nextElement();
        String str = zipEntry1.getName();
        if (c(str) && str.contains((CharSequence)zipEntry) && !a(paramFile2, arrayList, zipFile, zipEntry1, str))
          break; 
      } 
    } 
    return arrayList;
  }
  
  public static List<File> a(String paramString1, String paramString2) {
    return a(paramString1, paramString2, (String)null);
  }
  
  public static List<File> a(String paramString1, String paramString2, String paramString3) {
    return a(a(paramString1), a(paramString2), paramString3);
  }
  
  private static boolean a(File paramFile) {
    return (paramFile != null && (paramFile.exists() ? paramFile.isDirectory() : paramFile.mkdirs()));
  }
  
  private static boolean a(File paramFile, List<File> paramList, ZipFile paramZipFile, ZipEntry paramZipEntry, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramFile);
    stringBuilder.append(File.separator);
    stringBuilder.append(paramString);
    paramFile = new File(stringBuilder.toString());
    paramList.add(paramFile);
    if (paramZipEntry.isDirectory()) {
      if (!a(paramFile))
        return false; 
    } else {
      String str;
      if (!b(paramFile))
        return false; 
      paramString = null;
      try {
      
      } finally {
        paramFile = null;
        paramList = null;
      } 
      paramList.close();
      str.close();
      throw paramFile;
    } 
    return true;
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
    } catch (IOException iOException) {
      return false;
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
  
  private static boolean c(String paramString) {
    return TextUtils.isEmpty(paramString) ? false : (paramString.contains("../") ^ true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\\utils\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */