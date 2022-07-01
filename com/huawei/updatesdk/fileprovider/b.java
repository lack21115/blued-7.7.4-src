package com.huawei.updatesdk.fileprovider;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class b implements a {
  private final String a;
  
  private final HashMap<String, File> b = new HashMap<String, File>();
  
  protected b(String paramString) {
    this.a = paramString;
  }
  
  public Uri a(File paramFile) {
    try {
      Map.Entry<String, File> entry;
      String str = paramFile.getCanonicalPath();
      paramFile = null;
      for (Map.Entry<String, File> entry1 : this.b.entrySet()) {
        String str1 = ((File)entry1.getValue()).getPath();
        if (str.startsWith(str1) && (paramFile == null || str1.length() > ((File)paramFile.getValue()).getPath().length()))
          entry = entry1; 
      } 
      if (entry != null) {
        String str2 = ((File)entry.getValue()).getPath();
        boolean bool = str2.endsWith("/");
        int i = str2.length();
        if (!bool)
          i++; 
        str2 = str.substring(i);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Uri.encode(entry.getKey()));
        stringBuilder.append('/');
        stringBuilder.append(Uri.encode(str2, "/"));
        String str1 = stringBuilder.toString();
        return (new Uri.Builder()).scheme("content").authority(this.a).encodedPath(str1).build();
      } 
      throw new IllegalArgumentException("wisedist: Failed to find configured root that contains");
    } catch (Exception exception) {
      throw new IllegalArgumentException("Failed to resolve canonical path for wisedist");
    } 
  }
  
  public File a(Uri paramUri) {
    try {
      String str2 = paramUri.getEncodedPath();
      int i = str2.indexOf('/', 1);
      String str1 = Uri.decode(str2.substring(1, i));
      str2 = Uri.decode(str2.substring(i + 1));
      File file = this.b.get(str1);
      if (file != null) {
        if (!TextUtils.isEmpty(str2) && !str2.contains("../") && !str2.contains("..") && !str2.contains("%00") && !str2.contains(".\\.\\") && !str2.contains("./")) {
          File file1 = new File(file, str2);
          try {
            file1 = file1.getCanonicalFile();
            if (file1.getPath().startsWith(file.getPath()))
              return file1; 
            throw new SecurityException("wisedist: Resolved path jumped beyond configured root");
          } catch (IOException iOException) {
            throw new IllegalArgumentException("wisedist: Failed to resolve canonical path for");
          } 
        } 
        throw new IllegalArgumentException("wisedist: Not a standard path");
      } 
      throw new IllegalArgumentException("wisedist: Unable to find configured root for");
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("UpdateSDKFileProvider error: ");
      stringBuilder.append(exception.toString());
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
  }
  
  public void a(String paramString, File paramFile) {
    if (!TextUtils.isEmpty(paramString))
      try {
        paramFile = paramFile.getCanonicalFile();
        this.b.put(paramString, paramFile);
        return;
      } catch (Exception exception) {
        throw new IllegalArgumentException("Failed to resolve canonical path for root");
      }  
    throw new IllegalArgumentException("wisedist Name must not be empty");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\fileprovider\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */