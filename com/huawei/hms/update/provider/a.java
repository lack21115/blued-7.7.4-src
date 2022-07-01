package com.huawei.hms.update.provider;

import android.content.Context;
import android.net.Uri;
import com.huawei.hms.utils.Checker;
import java.io.File;
import java.io.IOException;

class a {
  private Context a;
  
  private String b;
  
  private String a() {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Landroid/content/Context;
    //   4: ldc 'mContext is null, call setContext first.'
    //   6: invokestatic assertNonNull : (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   9: checkcast android/content/Context
    //   12: astore_1
    //   13: aload_0
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield b : Ljava/lang/String;
    //   19: ifnonnull -> 54
    //   22: aload_1
    //   23: invokevirtual getExternalCacheDir : ()Ljava/io/File;
    //   26: ifnull -> 43
    //   29: aload_0
    //   30: aload_1
    //   31: invokevirtual getExternalCacheDir : ()Ljava/io/File;
    //   34: invokestatic a : (Ljava/io/File;)Ljava/lang/String;
    //   37: putfield b : Ljava/lang/String;
    //   40: goto -> 54
    //   43: aload_0
    //   44: aload_1
    //   45: invokevirtual getFilesDir : ()Ljava/io/File;
    //   48: invokestatic a : (Ljava/io/File;)Ljava/lang/String;
    //   51: putfield b : Ljava/lang/String;
    //   54: aload_0
    //   55: getfield b : Ljava/lang/String;
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: areturn
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Exception table:
    //   from	to	target	type
    //   15	40	63	finally
    //   43	54	63	finally
    //   54	61	63	finally
    //   64	66	63	finally
  }
  
  private static String a(File paramFile) {
    if (paramFile == null)
      return null; 
    try {
      return paramFile.getCanonicalPath();
    } catch (IOException iOException) {
      return null;
    } 
  }
  
  private static File b(File paramFile) {
    if (paramFile == null)
      return null; 
    try {
      return paramFile.getCanonicalFile();
    } catch (IOException iOException) {
      return null;
    } 
  }
  
  private String b(String paramString) {
    int i;
    String str = a();
    if (str == null)
      return null; 
    if (!paramString.startsWith(str))
      return null; 
    if (str.endsWith("/")) {
      i = str.length();
    } else {
      i = str.length() + 1;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Uri.encode("ContentUriHelper"));
    stringBuilder.append('/');
    stringBuilder.append(paramString.substring(i));
    return stringBuilder.toString();
  }
  
  private String c(String paramString) {
    String str = a();
    if (str == null)
      return null; 
    int i = paramString.indexOf('/', 1);
    if (i < 0)
      return null; 
    if (!"ContentUriHelper".equals(Uri.decode(paramString.substring(1, i))))
      return null; 
    paramString = a(new File(str, Uri.decode(paramString.substring(i + 1))));
    return (paramString == null) ? null : (!paramString.startsWith(str) ? null : paramString);
  }
  
  public Uri a(File paramFile, String paramString) {
    String str = a(paramFile);
    if (str == null)
      return null; 
    str = b(str);
    return (str == null) ? null : (new Uri.Builder()).scheme("content").authority(paramString).encodedPath(str).build();
  }
  
  File a(Uri paramUri) {
    String str = paramUri.getEncodedPath();
    if (str == null)
      return null; 
    str = c(str);
    return (str == null) ? null : b(new File(str));
  }
  
  public File a(String paramString) {
    String str = a();
    return (str == null) ? null : b(new File(str, paramString));
  }
  
  public void a(Context paramContext) {
    if (this.a == null) {
      Checker.checkNonNull(paramContext, "context must not be null.");
      this.a = paramContext;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\update\provider\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */