package com.qq.e.comm.util;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
  public static boolean copyTo(InputStream paramInputStream, File paramFile) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 149
    //   4: aload_1
    //   5: ifnonnull -> 11
    //   8: goto -> 149
    //   11: aconst_null
    //   12: astore #6
    //   14: aconst_null
    //   15: astore #4
    //   17: aload_1
    //   18: invokevirtual getParentFile : ()Ljava/io/File;
    //   21: invokevirtual exists : ()Z
    //   24: ifne -> 51
    //   27: aload_1
    //   28: invokevirtual getParentFile : ()Ljava/io/File;
    //   31: invokevirtual mkdirs : ()Z
    //   34: istore_3
    //   35: iload_3
    //   36: ifne -> 51
    //   39: aload_0
    //   40: invokestatic tryClose : (Ljava/io/InputStream;)V
    //   43: aload #4
    //   45: invokestatic tryClose : (Ljava/io/OutputStream;)V
    //   48: goto -> 149
    //   51: new java/io/FileOutputStream
    //   54: dup
    //   55: aload_1
    //   56: invokespecial <init> : (Ljava/io/File;)V
    //   59: astore #4
    //   61: sipush #4096
    //   64: newarray byte
    //   66: astore #5
    //   68: aload_0
    //   69: aload #5
    //   71: invokevirtual read : ([B)I
    //   74: istore_2
    //   75: iload_2
    //   76: ifle -> 91
    //   79: aload #4
    //   81: aload #5
    //   83: iconst_0
    //   84: iload_2
    //   85: invokevirtual write : ([BII)V
    //   88: goto -> 68
    //   91: aload_0
    //   92: invokestatic tryClose : (Ljava/io/InputStream;)V
    //   95: aload #4
    //   97: invokestatic tryClose : (Ljava/io/OutputStream;)V
    //   100: iconst_1
    //   101: ireturn
    //   102: astore #5
    //   104: goto -> 113
    //   107: astore #5
    //   109: aload #6
    //   111: astore #4
    //   113: ldc 'Exception while copy from InputStream to File %s'
    //   115: iconst_1
    //   116: anewarray java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: aload_1
    //   122: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   125: aastore
    //   126: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   129: aload #5
    //   131: invokestatic e : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   134: goto -> 39
    //   137: astore_1
    //   138: aload_0
    //   139: invokestatic tryClose : (Ljava/io/InputStream;)V
    //   142: aload #4
    //   144: invokestatic tryClose : (Ljava/io/OutputStream;)V
    //   147: aload_1
    //   148: athrow
    //   149: iconst_0
    //   150: ireturn
    // Exception table:
    //   from	to	target	type
    //   17	35	107	finally
    //   51	61	107	finally
    //   61	68	102	finally
    //   68	75	102	finally
    //   79	88	102	finally
    //   113	134	137	finally
  }
  
  public static String getFileName(String paramString) {
    return Md5Util.encode(paramString);
  }
  
  public static String getTempFileName(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Md5Util.encode(paramString));
    stringBuilder.append(".temp");
    return stringBuilder.toString();
  }
  
  public static boolean renameTo(File paramFile1, File paramFile2) {
    return (paramFile1 == null || paramFile2 == null || !paramFile1.exists()) ? false : (!paramFile1.renameTo(paramFile2) ? copyTo(null, paramFile2) : true);
  }
  
  public static void tryClose(InputStream paramInputStream) {
    if (paramInputStream != null)
      try {
        paramInputStream.close();
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  public static void tryClose(OutputStream paramOutputStream) {
    if (paramOutputStream != null)
      try {
        paramOutputStream.close();
        return;
      } catch (Exception exception) {
        return;
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\com\\util\FileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */