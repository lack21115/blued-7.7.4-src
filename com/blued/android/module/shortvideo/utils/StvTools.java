package com.blued.android.module.shortvideo.utils;

import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Md5;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class StvTools {
  public static String a() {
    return d("autn_");
  }
  
  public static String a(String paramString) {
    File file1;
    File file2 = AppInfo.d().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
    if (file2 != null) {
      file2 = new File(file2, "Pictures");
      if (file2.exists() || file2.mkdirs()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("temp_");
        stringBuilder.append(paramString.toLowerCase().trim());
        file1 = new File(file2, stringBuilder.toString());
        if (!file1.exists())
          file1.mkdir(); 
        return file1.getAbsolutePath();
      } 
    } 
    file2 = AppInfo.d().getFilesDir();
    if (file2 != null) {
      file2 = new File(file2, "Pictures");
      if (file2.exists() || file2.mkdirs()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("temp_");
        stringBuilder.append(file1.toLowerCase().trim());
        file1 = new File(file2, stringBuilder.toString());
        if (!file2.exists())
          file2.mkdir(); 
        return file1.getAbsolutePath();
      } 
    } 
    return null;
  }
  
  public static byte[] a(Bitmap paramBitmap, String paramString, int paramInt) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, byteArrayOutputStream);
      FileOutputStream fileOutputStream = new FileOutputStream(paramString);
      fileOutputStream.write(byteArrayOutputStream.toByteArray());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("baos.size() = ");
      stringBuilder.append(byteArrayOutputStream.size());
      Log.v("drb", stringBuilder.toString());
      fileOutputStream.flush();
      fileOutputStream.close();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return byteArrayOutputStream.toByteArray();
  }
  
  public static String b() {
    return d("record_");
  }
  
  public static String b(String paramString) {
    File file = AppInfo.d().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
    if (file != null) {
      file = new File(file, "Pictures");
      c(file.getAbsolutePath());
      if (file.exists() || file.mkdirs()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("temp_");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("_");
        stringBuilder.append(Md5.a(paramString.toLowerCase().trim()));
        stringBuilder.append(".jpg");
        return (new File(file, stringBuilder.toString())).getAbsolutePath();
      } 
    } 
    file = AppInfo.d().getFilesDir();
    if (file != null) {
      file = new File(file, "Pictures");
      c(file.getAbsolutePath());
      if (file.exists() || file.mkdirs()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("temp_");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("_");
        stringBuilder.append(Md5.a(paramString.toLowerCase().trim()));
        stringBuilder.append(".jpg");
        return (new File(file, stringBuilder.toString())).getAbsolutePath();
      } 
    } 
    return null;
  }
  
  public static String c() {
    return d("edited_");
  }
  
  public static void c(String paramString) {
    // Byte code:
    //   0: new java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial <init> : (Ljava/lang/String;)V
    //   8: astore_3
    //   9: new java/io/File
    //   12: dup
    //   13: aload_0
    //   14: ldc '.nomedia'
    //   16: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   19: astore #4
    //   21: aconst_null
    //   22: astore_2
    //   23: aconst_null
    //   24: astore_1
    //   25: aconst_null
    //   26: astore_0
    //   27: aload_3
    //   28: invokevirtual exists : ()Z
    //   31: ifne -> 39
    //   34: aload_3
    //   35: invokevirtual mkdirs : ()Z
    //   38: pop
    //   39: aload #4
    //   41: invokevirtual exists : ()Z
    //   44: ifne -> 81
    //   47: aload #4
    //   49: invokevirtual createNewFile : ()Z
    //   52: pop
    //   53: new java/io/FileOutputStream
    //   56: dup
    //   57: aload #4
    //   59: invokespecial <init> : (Ljava/io/File;)V
    //   62: astore_0
    //   63: aload_0
    //   64: invokevirtual flush : ()V
    //   67: goto -> 81
    //   70: astore_1
    //   71: aload_0
    //   72: astore_2
    //   73: aload_1
    //   74: astore_0
    //   75: goto -> 97
    //   78: goto -> 115
    //   81: aload_0
    //   82: ifnull -> 95
    //   85: aload_0
    //   86: invokevirtual close : ()V
    //   89: return
    //   90: astore_0
    //   91: aload_0
    //   92: invokevirtual printStackTrace : ()V
    //   95: return
    //   96: astore_0
    //   97: aload_2
    //   98: ifnull -> 113
    //   101: aload_2
    //   102: invokevirtual close : ()V
    //   105: goto -> 113
    //   108: astore_1
    //   109: aload_1
    //   110: invokevirtual printStackTrace : ()V
    //   113: aload_0
    //   114: athrow
    //   115: aload_0
    //   116: ifnull -> 129
    //   119: aload_0
    //   120: invokevirtual close : ()V
    //   123: return
    //   124: astore_0
    //   125: aload_0
    //   126: invokevirtual printStackTrace : ()V
    //   129: return
    //   130: astore_0
    //   131: aload_1
    //   132: astore_0
    //   133: goto -> 115
    //   136: astore_1
    //   137: goto -> 78
    // Exception table:
    //   from	to	target	type
    //   27	39	130	java/lang/Exception
    //   27	39	96	finally
    //   39	63	130	java/lang/Exception
    //   39	63	96	finally
    //   63	67	136	java/lang/Exception
    //   63	67	70	finally
    //   85	89	90	java/lang/Exception
    //   101	105	108	java/lang/Exception
    //   119	123	124	java/lang/Exception
  }
  
  public static String d() {
    return d("trimmed_");
  }
  
  private static String d(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(StvConfig.b());
    stringBuilder.append(paramString);
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append("_");
    paramString = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(Md5.a(paramString.toLowerCase().trim()));
    stringBuilder.append(".mp4");
    return stringBuilder.toString();
  }
  
  public static String e() {
    return d("transcoder_");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvide\\utils\StvTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */