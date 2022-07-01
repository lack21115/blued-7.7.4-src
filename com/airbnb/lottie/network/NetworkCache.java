package com.airbnb.lottie.network;

import android.content.Context;
import androidx.core.util.Pair;
import com.airbnb.lottie.utils.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

class NetworkCache {
  private final Context a;
  
  private final String b;
  
  NetworkCache(Context paramContext, String paramString) {
    this.a = paramContext.getApplicationContext();
    this.b = paramString;
  }
  
  private File a(String paramString) throws FileNotFoundException {
    File file2 = new File(this.a.getCacheDir(), a(paramString, FileExtension.a, false));
    if (file2.exists())
      return file2; 
    File file1 = new File(this.a.getCacheDir(), a(paramString, FileExtension.b, false));
    return file1.exists() ? file1 : null;
  }
  
  private static String a(String paramString, FileExtension paramFileExtension, boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("lottie_cache_");
    stringBuilder.append(paramString.replaceAll("\\W+", ""));
    if (paramBoolean) {
      paramString = paramFileExtension.a();
    } else {
      paramString = paramFileExtension.c;
    } 
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  Pair<FileExtension, InputStream> a() {
    try {
      FileExtension fileExtension;
      File file = a(this.b);
      if (file == null)
        return null; 
      FileInputStream fileInputStream = new FileInputStream(file);
      if (file.getAbsolutePath().endsWith(".zip")) {
        fileExtension = FileExtension.b;
      } else {
        fileExtension = FileExtension.a;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Cache hit for ");
      stringBuilder.append(this.b);
      stringBuilder.append(" at ");
      stringBuilder.append(file.getAbsolutePath());
      Logger.a(stringBuilder.toString());
      return new Pair(fileExtension, fileInputStream);
    } catch (FileNotFoundException fileNotFoundException) {
      return null;
    } 
  }
  
  File a(InputStream paramInputStream, FileExtension paramFileExtension) throws IOException {
    null = a(this.b, paramFileExtension, true);
    File file = new File(this.a.getCacheDir(), null);
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(file);
    } finally {
      paramInputStream.close();
    } 
  }
  
  void a(FileExtension paramFileExtension) {
    String str = a(this.b, paramFileExtension, true);
    File file1 = new File(this.a.getCacheDir(), str);
    File file2 = new File(file1.getAbsolutePath().replace(".temp", ""));
    boolean bool = file1.renameTo(file2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Copying temp file to real file (");
    stringBuilder.append(file2);
    stringBuilder.append(")");
    Logger.a(stringBuilder.toString());
    if (!bool) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to rename cache file ");
      stringBuilder.append(file1.getAbsolutePath());
      stringBuilder.append(" to ");
      stringBuilder.append(file2.getAbsolutePath());
      stringBuilder.append(".");
      Logger.b(stringBuilder.toString());
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\network\NetworkCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */