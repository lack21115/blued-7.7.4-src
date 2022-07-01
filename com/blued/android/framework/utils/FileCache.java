package com.blued.android.framework.utils;

import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.provider.ProviderHolder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCache {
  String a = null;
  
  String b = null;
  
  private FileCache() {
    b();
  }
  
  private static FileCache a() {
    return SingletonCreator.a();
  }
  
  public static String a(String paramString) {
    String str = ProviderHolder.a().b().a();
    FileCache fileCache = a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(paramString);
    return fileCache.b(stringBuilder.toString());
  }
  
  public static void a(String paramString1, String paramString2) {
    String str = ProviderHolder.a().b().a();
    FileCache fileCache = a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(paramString1);
    fileCache.b(stringBuilder.toString(), paramString2);
  }
  
  private String b(String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifeq -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: invokespecial c : ()Ljava/io/File;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull -> 28
    //   18: ldc 'FileCache'
    //   20: ldc '缓存路径获取失败'
    //   22: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   25: pop
    //   26: aconst_null
    //   27: areturn
    //   28: new java/io/File
    //   31: dup
    //   32: aload_2
    //   33: aload_1
    //   34: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   37: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   40: astore_1
    //   41: aload_1
    //   42: invokevirtual exists : ()Z
    //   45: ifeq -> 180
    //   48: new java/io/FileInputStream
    //   51: dup
    //   52: aload_1
    //   53: invokespecial <init> : (Ljava/io/File;)V
    //   56: astore_2
    //   57: aload_2
    //   58: astore_1
    //   59: aload_2
    //   60: invokevirtual available : ()I
    //   63: newarray byte
    //   65: astore_3
    //   66: aload_2
    //   67: astore_1
    //   68: aload_2
    //   69: aload_3
    //   70: invokevirtual read : ([B)I
    //   73: pop
    //   74: aload_2
    //   75: astore_1
    //   76: new java/lang/String
    //   79: dup
    //   80: aload_3
    //   81: ldc 'UTF-8'
    //   83: invokespecial <init> : ([BLjava/lang/String;)V
    //   86: astore_3
    //   87: aload_2
    //   88: invokevirtual close : ()V
    //   91: aload_3
    //   92: areturn
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual printStackTrace : ()V
    //   98: aload_3
    //   99: areturn
    //   100: astore_3
    //   101: goto -> 121
    //   104: astore_3
    //   105: goto -> 140
    //   108: astore_3
    //   109: goto -> 159
    //   112: astore_1
    //   113: aconst_null
    //   114: astore_2
    //   115: goto -> 187
    //   118: astore_3
    //   119: aconst_null
    //   120: astore_2
    //   121: aload_2
    //   122: astore_1
    //   123: aload_3
    //   124: invokevirtual printStackTrace : ()V
    //   127: aload_2
    //   128: ifnull -> 180
    //   131: aload_2
    //   132: invokevirtual close : ()V
    //   135: aconst_null
    //   136: areturn
    //   137: astore_3
    //   138: aconst_null
    //   139: astore_2
    //   140: aload_2
    //   141: astore_1
    //   142: aload_3
    //   143: invokevirtual printStackTrace : ()V
    //   146: aload_2
    //   147: ifnull -> 180
    //   150: aload_2
    //   151: invokevirtual close : ()V
    //   154: aconst_null
    //   155: areturn
    //   156: astore_3
    //   157: aconst_null
    //   158: astore_2
    //   159: aload_2
    //   160: astore_1
    //   161: aload_3
    //   162: invokevirtual printStackTrace : ()V
    //   165: aload_2
    //   166: ifnull -> 180
    //   169: aload_2
    //   170: invokevirtual close : ()V
    //   173: aconst_null
    //   174: areturn
    //   175: astore_1
    //   176: aload_1
    //   177: invokevirtual printStackTrace : ()V
    //   180: aconst_null
    //   181: areturn
    //   182: astore_3
    //   183: aload_1
    //   184: astore_2
    //   185: aload_3
    //   186: astore_1
    //   187: aload_2
    //   188: ifnull -> 203
    //   191: aload_2
    //   192: invokevirtual close : ()V
    //   195: goto -> 203
    //   198: astore_2
    //   199: aload_2
    //   200: invokevirtual printStackTrace : ()V
    //   203: aload_1
    //   204: athrow
    // Exception table:
    //   from	to	target	type
    //   41	57	156	java/io/UnsupportedEncodingException
    //   41	57	137	java/io/FileNotFoundException
    //   41	57	118	java/io/IOException
    //   41	57	112	finally
    //   59	66	108	java/io/UnsupportedEncodingException
    //   59	66	104	java/io/FileNotFoundException
    //   59	66	100	java/io/IOException
    //   59	66	182	finally
    //   68	74	108	java/io/UnsupportedEncodingException
    //   68	74	104	java/io/FileNotFoundException
    //   68	74	100	java/io/IOException
    //   68	74	182	finally
    //   76	87	108	java/io/UnsupportedEncodingException
    //   76	87	104	java/io/FileNotFoundException
    //   76	87	100	java/io/IOException
    //   76	87	182	finally
    //   87	91	93	java/io/IOException
    //   123	127	182	finally
    //   131	135	175	java/io/IOException
    //   142	146	182	finally
    //   150	154	175	java/io/IOException
    //   161	165	182	finally
    //   169	173	175	java/io/IOException
    //   191	195	198	java/io/IOException
  }
  
  private void b() {
    File file = AppInfo.d().getExternalFilesDir(null);
    if (file != null) {
      file = new File(file, "filecache");
      if (file.exists() || file.mkdirs())
        this.a = file.getAbsolutePath(); 
    } 
    file = AppInfo.d().getFilesDir();
    if (file != null) {
      file = new File(file, "filecache");
      if (file.exists() || file.mkdirs()) {
        if (TextUtils.isEmpty(this.a)) {
          this.a = file.getAbsolutePath();
          return;
        } 
        this.b = file.getAbsolutePath();
      } 
    } 
  }
  
  private boolean b(String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString1)) {
      if (paramString2 == null)
        return false; 
      File file2 = c();
      if (file2 == null) {
        Log.e("FileCache", "缓存路径获取失败");
        return false;
      } 
      File file3 = new File(file2, Md5.a(paramString1));
      String str2 = null;
      file2 = null;
      File file1 = file2;
      try {
        if (!file3.exists()) {
          file1 = file2;
          file3.createNewFile();
        } 
        file1 = file2;
        FileWriter fileWriter = new FileWriter(file3);
        try {
          fileWriter.write(paramString2);
          fileWriter.flush();
        } catch (IOException iOException1) {
          FileWriter fileWriter1 = fileWriter;
        } finally {
          IOException iOException1;
          paramString2 = null;
        } 
      } catch (IOException iOException) {
        paramString2 = str2;
      } finally {}
      String str1 = paramString2;
      iOException.printStackTrace();
      if (paramString2 != null)
        try {
          paramString2.close();
          return false;
        } catch (IOException iOException1) {
          iOException1.printStackTrace();
        }  
      return false;
    } 
    return false;
  }
  
  private File c() {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Ljava/lang/String;
    //   4: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   7: ifeq -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: new java/io/File
    //   15: dup
    //   16: aload_0
    //   17: getfield a : Ljava/lang/String;
    //   20: invokespecial <init> : (Ljava/lang/String;)V
    //   23: astore_2
    //   24: aload_2
    //   25: invokevirtual exists : ()Z
    //   28: ifeq -> 40
    //   31: aload_2
    //   32: astore_1
    //   33: aload_2
    //   34: invokevirtual canWrite : ()Z
    //   37: ifne -> 148
    //   40: new java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial <init> : ()V
    //   47: astore_1
    //   48: aload_1
    //   49: ldc '主缓存路径获取失败, cachePath:'
    //   51: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_1
    //   56: aload_0
    //   57: getfield a : Ljava/lang/String;
    //   60: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: ldc 'FileCache'
    //   66: aload_1
    //   67: invokevirtual toString : ()Ljava/lang/String;
    //   70: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   73: pop
    //   74: aload_0
    //   75: getfield b : Ljava/lang/String;
    //   78: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   81: ifne -> 146
    //   84: new java/io/File
    //   87: dup
    //   88: aload_0
    //   89: getfield a : Ljava/lang/String;
    //   92: invokespecial <init> : (Ljava/lang/String;)V
    //   95: astore_2
    //   96: aload_2
    //   97: invokevirtual exists : ()Z
    //   100: ifeq -> 112
    //   103: aload_2
    //   104: astore_1
    //   105: aload_2
    //   106: invokevirtual canWrite : ()Z
    //   109: ifne -> 148
    //   112: new java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial <init> : ()V
    //   119: astore_1
    //   120: aload_1
    //   121: ldc '从缓存路径获取失败, otherCachePath:'
    //   123: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload_1
    //   128: aload_0
    //   129: getfield b : Ljava/lang/String;
    //   132: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: ldc 'FileCache'
    //   138: aload_1
    //   139: invokevirtual toString : ()Ljava/lang/String;
    //   142: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   145: pop
    //   146: aconst_null
    //   147: astore_1
    //   148: aload_1
    //   149: areturn
  }
  
  static class SingletonCreator {
    private static final FileCache a = new FileCache();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\FileCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */