package com.qq.e.comm.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StringUtil {
  public static boolean isEmpty(String paramString) {
    return (paramString == null || paramString.trim().length() == 0);
  }
  
  public static String join(String paramString, String[] paramArrayOfString) {
    StringBuffer stringBuffer = new StringBuffer();
    if (paramArrayOfString != null)
      for (int i = 0; i < paramArrayOfString.length; i++) {
        if (paramString != null && i != 0)
          stringBuffer.append(paramString); 
        stringBuffer.append(paramArrayOfString[i]);
      }  
    return stringBuffer.toString();
  }
  
  public static int parseInteger(String paramString, int paramInt) {
    try {
      return Integer.parseInt(paramString);
    } finally {
      paramString = null;
    } 
  }
  
  public static String readAll(File paramFile) throws IOException {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: ifnull -> 122
    //   8: aload_0
    //   9: invokevirtual exists : ()Z
    //   12: ifne -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: new java/io/BufferedReader
    //   20: dup
    //   21: new java/io/FileReader
    //   24: dup
    //   25: aload_0
    //   26: invokespecial <init> : (Ljava/io/File;)V
    //   29: invokespecial <init> : (Ljava/io/Reader;)V
    //   32: astore_0
    //   33: new java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial <init> : ()V
    //   40: astore_1
    //   41: aload_0
    //   42: invokevirtual readLine : ()Ljava/lang/String;
    //   45: astore_2
    //   46: aload_2
    //   47: ifnull -> 59
    //   50: aload_1
    //   51: aload_2
    //   52: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: goto -> 41
    //   59: aload_1
    //   60: invokevirtual toString : ()Ljava/lang/String;
    //   63: astore_1
    //   64: aload_0
    //   65: invokevirtual close : ()V
    //   68: aload_1
    //   69: areturn
    //   70: astore_0
    //   71: ldc 'Exception while close bufferreader'
    //   73: aload_0
    //   74: invokestatic e : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   77: aload_1
    //   78: areturn
    //   79: astore_2
    //   80: aload_0
    //   81: astore_1
    //   82: goto -> 102
    //   85: astore_2
    //   86: aload_0
    //   87: astore_1
    //   88: aload_2
    //   89: astore_0
    //   90: goto -> 100
    //   93: astore_2
    //   94: goto -> 102
    //   97: astore_0
    //   98: aload_2
    //   99: astore_1
    //   100: aload_0
    //   101: athrow
    //   102: aload_1
    //   103: ifnull -> 120
    //   106: aload_1
    //   107: invokevirtual close : ()V
    //   110: goto -> 120
    //   113: astore_0
    //   114: ldc 'Exception while close bufferreader'
    //   116: aload_0
    //   117: invokestatic e : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   120: aload_2
    //   121: athrow
    //   122: aconst_null
    //   123: areturn
    // Exception table:
    //   from	to	target	type
    //   17	33	97	java/io/IOException
    //   17	33	93	finally
    //   33	41	85	java/io/IOException
    //   33	41	79	finally
    //   41	46	85	java/io/IOException
    //   41	46	79	finally
    //   50	56	85	java/io/IOException
    //   50	56	79	finally
    //   59	64	85	java/io/IOException
    //   59	64	79	finally
    //   64	68	70	java/lang/Exception
    //   100	102	93	finally
    //   106	110	113	java/lang/Exception
  }
  
  public static void writeTo(String paramString, File paramFile) throws IOException {
    if (paramFile != null) {
      File file = paramFile.getParentFile();
      if (!file.exists())
        file.mkdirs(); 
      FileWriter fileWriter = new FileWriter(paramFile);
      fileWriter.write(paramString);
      fileWriter.close();
      return;
    } 
    throw new IOException("Target File Can not be null in StringUtil.writeTo");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\com\\util\StringUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */