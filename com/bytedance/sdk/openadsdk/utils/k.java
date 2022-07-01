package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class k {
  public static File a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2) {
    String str3 = a(paramContext);
    String str2 = paramString1;
    if (paramBoolean) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("/");
      stringBuilder1.append(z.a(paramContext));
      stringBuilder1.append("-");
      stringBuilder1.append(paramString1);
      str2 = stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str3);
    stringBuilder.append(str2);
    String str1 = stringBuilder.toString();
    File file = new File(str1);
    if (!file.exists())
      file.mkdirs(); 
    return new File(str1, paramString2);
  }
  
  private static String a(Context paramContext) {
    boolean bool;
    File file1;
    if (paramContext == null)
      return null; 
    if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      file1 = paramContext.getExternalCacheDir();
    } else {
      file1 = null;
    } 
    File file2 = file1;
    if (file1 == null)
      file2 = paramContext.getCacheDir(); 
    return (file2 == null) ? null : file2.getPath();
  }
  
  public static List<File> a(File paramFile) {
    LinkedList linkedList = new LinkedList();
    File[] arrayOfFile = paramFile.listFiles();
    List<File> list = linkedList;
    if (arrayOfFile != null) {
      list = Arrays.asList(arrayOfFile);
      Collections.sort(list, new a());
    } 
    return list;
  }
  
  public static void b(File paramFile) throws IOException {
    if (paramFile.exists()) {
      long l = System.currentTimeMillis();
      if (!paramFile.setLastModified(l)) {
        e(paramFile);
        if (paramFile.lastModified() < l) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Last modified date ");
          stringBuilder.append(new Date(paramFile.lastModified()));
          stringBuilder.append(" is not set for file ");
          stringBuilder.append(paramFile.getAbsolutePath());
          t.d("Files", stringBuilder.toString());
        } 
      } 
    } 
  }
  
  public static void c(File paramFile) {
    if (paramFile != null) {
      if (!paramFile.exists())
        return; 
      if (paramFile.isFile())
        try {
          return;
        } finally {
          paramFile = null;
        }  
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null && arrayOfFile.length > 0) {
        int j = arrayOfFile.length;
        int i = 0;
        while (true) {
          if (i < j) {
            File file = arrayOfFile[i];
            if (file.isDirectory()) {
              c(file);
            } else {
              try {
                file.delete();
              } finally {}
            } 
            i++;
            continue;
          } 
          paramFile.delete();
          return;
        } 
      } 
    } else {
      return;
    } 
    paramFile.delete();
  }
  
  public static byte[] d(File paramFile) {
    File file;
    if (paramFile != null && paramFile.isFile() && paramFile.exists() && paramFile.canRead() && paramFile.length() > 0L) {
      try {
        Long long_ = Long.valueOf(paramFile.length());
        FileInputStream fileInputStream = new FileInputStream(paramFile);
      } finally {
        paramFile = null;
      } 
      if (paramFile != null) {
        file = paramFile;
      } else {
        return null;
      } 
    } else {
      return null;
    } 
    try {
      return null;
    } finally {
      paramFile = null;
    } 
  }
  
  private static void e(File paramFile) throws IOException {
    long l = paramFile.length();
    if (l == 0L) {
      f(paramFile);
      return;
    } 
    try {
      RandomAccessFile randomAccessFile = new RandomAccessFile(paramFile, "rwd");
      l--;
    } finally {
      paramFile = null;
    } 
    if (paramFile != null) {
      paramFile.close();
      return;
    } 
  }
  
  private static void f(File paramFile) throws IOException {
    if (paramFile.delete() && paramFile.createNewFile())
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Error recreate zero-size file ");
    stringBuilder.append(paramFile);
    throw new IOException(stringBuilder.toString());
  }
  
  static final class a implements Comparator<File> {
    private a() {}
    
    private int a(long param1Long1, long param1Long2) {
      int i = param1Long1 cmp param1Long2;
      return (i < 0) ? -1 : ((i == 0) ? 0 : 1);
    }
    
    public int a(File param1File1, File param1File2) {
      return a(param1File1.lastModified(), param1File2.lastModified());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */