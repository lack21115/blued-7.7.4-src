package com.tencent.tbs.patch.common.util;

import com.tencent.tbs.patch.common.PatchException;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileUtils {
  public static void assertCopy(File paramFile1, File paramFile2) {
    if (paramFile1 != null && paramFile2 != null) {
      FileChannel fileChannel1;
      Exception exception;
      FileChannel fileChannel2 = null;
      File file = null;
      try {
      
      } finally {
        exception = null;
        paramFile1 = null;
      } 
      if (fileChannel1 != null)
        fileChannel1.close(); 
      if (paramFile1 != null)
        paramFile1.close(); 
      throw exception;
    } 
    throw new PatchException("srcFile == null || dstFile == null");
  }
  
  public static void assertFileExists(String paramString) {
    if (!StringUtils.isBlank(paramString)) {
      File file = new File(paramString);
      if (file.isFile())
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(file.getAbsolutePath());
      stringBuilder.append(" not exist!");
      throw new PatchException(stringBuilder.toString());
    } 
    throw new PatchException("Empty pach!");
  }
  
  public static void closeQuietly(Closeable paramCloseable) {
    if (paramCloseable == null)
      return; 
    try {
      paramCloseable.close();
      return;
    } catch (Throwable throwable) {
      return;
    } 
  }
  
  public static boolean copyFiles(File paramFile1, File paramFile2) {
    if (paramFile1 != null) {
      StringBuilder stringBuilder;
      if (paramFile2 == null)
        return false; 
      if (!paramFile1.exists()) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramFile1);
        str = " not exist";
      } else {
        if (str.isFile()) {
          try {
            return performCopy((File)str, (File)stringBuilder);
          } catch (Exception exception) {
            str = exception.getMessage();
          } 
          PatchLogger.e(str);
          return false;
        } 
        File[] arrayOfFile = str.listFiles();
        if (arrayOfFile == null) {
          stringBuilder = new StringBuilder();
          stringBuilder.append(str);
          str = " is directory but empty";
        } else {
          int j = arrayOfFile.length;
          int i = 0;
          boolean bool = true;
          while (i < j) {
            File file = arrayOfFile[i];
            if (!copyFiles(file, new File((File)stringBuilder, file.getName()))) {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("failed when copy dir: ");
              stringBuilder1.append(str);
              stringBuilder1.append(",");
              stringBuilder1.append(file);
              PatchLogger.e(stringBuilder1.toString());
              bool = false;
            } 
            i++;
          } 
          return bool;
        } 
      } 
      stringBuilder.append(str);
      String str = stringBuilder.toString();
      PatchLogger.e(str);
      return false;
    } 
    return false;
  }
  
  public static void delete(File paramFile) {
    delete(paramFile, false);
  }
  
  public static void delete(File paramFile, boolean paramBoolean) {
    if (paramFile != null) {
      if (!paramFile.exists())
        return; 
      if (paramFile.isFile()) {
        paramFile.delete();
        return;
      } 
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile == null)
        return; 
      int j = arrayOfFile.length;
      for (int i = 0; i < j; i++)
        delete(arrayOfFile[i], paramBoolean); 
      if (!paramBoolean)
        paramFile.delete(); 
    } 
  }
  
  public static void deleteDir(File paramFile) {
    if (!paramFile.exists())
      return; 
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null) {
      int j = arrayOfFile.length;
      for (int i = 0; i < j; i++) {
        File file = arrayOfFile[i];
        if (file.isDirectory()) {
          deleteDir(file);
        } else {
          file.delete();
        } 
      } 
    } 
    paramFile.delete();
  }
  
  public static String getFileName(String paramString) {
    return (new File(paramString)).getName();
  }
  
  public static String getNameSuffix(String paramString) {
    if (StringUtils.isBlank(paramString))
      return ""; 
    int i = paramString.lastIndexOf(".");
    return (i != -1) ? paramString.substring(i) : "";
  }
  
  public static boolean isExist(String paramString) {
    return StringUtils.isBlank(paramString) ? false : (new File(paramString)).exists();
  }
  
  public static void makeParentDir(File paramFile) {
    paramFile = paramFile.getParentFile();
    if (paramFile != null && !paramFile.exists()) {
      if (paramFile.mkdirs())
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to make dir: ");
      stringBuilder.append(paramFile.getAbsolutePath());
      throw new PatchException(stringBuilder.toString());
    } 
  }
  
  public static File makeTempDir(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("t_dir_");
    stringBuilder.append(StringUtils.getRandomString(32));
    File file = new File(paramString, stringBuilder.toString());
    file.delete();
    if (file.mkdirs())
      return file; 
    stringBuilder = new StringBuilder();
    stringBuilder.append("Could not create temp directory: ");
    stringBuilder.append(file.getAbsolutePath());
    throw new IOException(stringBuilder.toString());
  }
  
  public static File makeTempFile(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("t_file_");
    stringBuilder.append(StringUtils.getRandomString(32));
    stringBuilder.append(paramString2);
    File file = new File(paramString1, stringBuilder.toString());
    try {
      file.createNewFile();
      return file;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return file;
    } 
  }
  
  public static boolean performCopy(File paramFile1, File paramFile2) {
    if (paramFile1 != null) {
      FileChannel fileChannel1;
      if (paramFile2 == null)
        return false; 
      FileChannel fileChannel3 = null;
      FileChannel fileChannel2 = null;
      try {
        StringBuilder stringBuilder1;
        StringBuilder stringBuilder2;
        FileChannel fileChannel;
        if (!paramFile1.exists() || !paramFile1.isFile()) {
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(paramFile1);
          return false;
        } 
        File file = stringBuilder2.getParentFile();
        if (file.isFile())
          delete(file); 
        if (!file.exists() && !file.mkdirs()) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(file);
          return false;
        } 
      } finally {
        paramFile2 = null;
        fileChannel2 = null;
      } 
      if (fileChannel1 != null)
        fileChannel1.close(); 
      if (fileChannel2 != null)
        fileChannel2.close(); 
      throw paramFile2;
    } 
    return false;
  }
  
  public static byte[] readBytesFromFile(File paramFile) {
    // Byte code:
    //   0: new java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial <init> : (Ljava/io/File;)V
    //   8: astore_0
    //   9: new java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: astore #6
    //   18: aload_0
    //   19: astore_2
    //   20: aload #6
    //   22: astore_3
    //   23: sipush #1024
    //   26: newarray byte
    //   28: astore #4
    //   30: aload_0
    //   31: astore_2
    //   32: aload #6
    //   34: astore_3
    //   35: aload_0
    //   36: aload #4
    //   38: invokevirtual read : ([B)I
    //   41: istore_1
    //   42: iload_1
    //   43: iconst_m1
    //   44: if_icmpeq -> 64
    //   47: aload_0
    //   48: astore_2
    //   49: aload #6
    //   51: astore_3
    //   52: aload #6
    //   54: aload #4
    //   56: iconst_0
    //   57: iload_1
    //   58: invokevirtual write : ([BII)V
    //   61: goto -> 30
    //   64: aload_0
    //   65: astore_2
    //   66: aload #6
    //   68: astore_3
    //   69: aload #6
    //   71: invokevirtual toByteArray : ()[B
    //   74: astore #4
    //   76: aload #6
    //   78: invokevirtual close : ()V
    //   81: aload_0
    //   82: invokevirtual close : ()V
    //   85: aload #4
    //   87: areturn
    //   88: astore #5
    //   90: aload_0
    //   91: astore #4
    //   93: aload #6
    //   95: astore_0
    //   96: goto -> 132
    //   99: astore_2
    //   100: aconst_null
    //   101: astore_3
    //   102: goto -> 169
    //   105: astore #5
    //   107: aconst_null
    //   108: astore_2
    //   109: aload_0
    //   110: astore #4
    //   112: aload_2
    //   113: astore_0
    //   114: goto -> 132
    //   117: astore_2
    //   118: aconst_null
    //   119: astore_0
    //   120: aload_0
    //   121: astore_3
    //   122: goto -> 169
    //   125: astore #5
    //   127: aconst_null
    //   128: astore_0
    //   129: aload_0
    //   130: astore #4
    //   132: aload #4
    //   134: astore_2
    //   135: aload_0
    //   136: astore_3
    //   137: aload #5
    //   139: invokevirtual printStackTrace : ()V
    //   142: aload_0
    //   143: ifnull -> 150
    //   146: aload_0
    //   147: invokevirtual close : ()V
    //   150: aload #4
    //   152: ifnull -> 160
    //   155: aload #4
    //   157: invokevirtual close : ()V
    //   160: aconst_null
    //   161: areturn
    //   162: astore #4
    //   164: aload_2
    //   165: astore_0
    //   166: aload #4
    //   168: astore_2
    //   169: aload_3
    //   170: ifnull -> 177
    //   173: aload_3
    //   174: invokevirtual close : ()V
    //   177: aload_0
    //   178: ifnull -> 185
    //   181: aload_0
    //   182: invokevirtual close : ()V
    //   185: aload_2
    //   186: athrow
    // Exception table:
    //   from	to	target	type
    //   0	9	125	java/lang/Exception
    //   0	9	117	finally
    //   9	18	105	java/lang/Exception
    //   9	18	99	finally
    //   23	30	88	java/lang/Exception
    //   23	30	162	finally
    //   35	42	88	java/lang/Exception
    //   35	42	162	finally
    //   52	61	88	java/lang/Exception
    //   52	61	162	finally
    //   69	76	88	java/lang/Exception
    //   69	76	162	finally
    //   137	142	162	finally
  }
  
  public static byte[] readBytesFromFile(String paramString) {
    return readBytesFromFile(new File(paramString));
  }
  
  public static String readStrFromFile(File paramFile) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore #6
    //   7: new java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial <init> : (Ljava/io/File;)V
    //   15: astore_0
    //   16: aload_3
    //   17: astore_2
    //   18: aload_0
    //   19: astore_3
    //   20: new java/io/ByteArrayOutputStream
    //   23: dup
    //   24: invokespecial <init> : ()V
    //   27: astore #4
    //   29: sipush #1024
    //   32: newarray byte
    //   34: astore_2
    //   35: aload_0
    //   36: aload_2
    //   37: invokevirtual read : ([B)I
    //   40: istore_1
    //   41: iload_1
    //   42: iconst_m1
    //   43: if_icmpeq -> 57
    //   46: aload #4
    //   48: aload_2
    //   49: iconst_0
    //   50: iload_1
    //   51: invokevirtual write : ([BII)V
    //   54: goto -> 35
    //   57: aload #4
    //   59: invokevirtual toString : ()Ljava/lang/String;
    //   62: astore_2
    //   63: aload #4
    //   65: invokevirtual close : ()V
    //   68: aload_0
    //   69: invokevirtual close : ()V
    //   72: aload_2
    //   73: areturn
    //   74: astore_3
    //   75: aload #4
    //   77: astore_2
    //   78: aload_3
    //   79: astore #4
    //   81: goto -> 148
    //   84: astore #5
    //   86: goto -> 113
    //   89: astore #5
    //   91: aload #6
    //   93: astore #4
    //   95: goto -> 113
    //   98: astore #4
    //   100: aconst_null
    //   101: astore_0
    //   102: goto -> 148
    //   105: astore #5
    //   107: aconst_null
    //   108: astore_0
    //   109: aload #6
    //   111: astore #4
    //   113: aload #4
    //   115: astore_2
    //   116: aload_0
    //   117: astore_3
    //   118: aload #5
    //   120: invokevirtual printStackTrace : ()V
    //   123: aload #4
    //   125: ifnull -> 133
    //   128: aload #4
    //   130: invokevirtual close : ()V
    //   133: aload_0
    //   134: ifnull -> 141
    //   137: aload_0
    //   138: invokevirtual close : ()V
    //   141: ldc ''
    //   143: areturn
    //   144: astore #4
    //   146: aload_3
    //   147: astore_0
    //   148: aload_2
    //   149: ifnull -> 156
    //   152: aload_2
    //   153: invokevirtual close : ()V
    //   156: aload_0
    //   157: ifnull -> 164
    //   160: aload_0
    //   161: invokevirtual close : ()V
    //   164: aload #4
    //   166: athrow
    // Exception table:
    //   from	to	target	type
    //   7	16	105	java/lang/Exception
    //   7	16	98	finally
    //   20	29	89	java/lang/Exception
    //   20	29	144	finally
    //   29	35	84	java/lang/Exception
    //   29	35	74	finally
    //   35	41	84	java/lang/Exception
    //   35	41	74	finally
    //   46	54	84	java/lang/Exception
    //   46	54	74	finally
    //   57	63	84	java/lang/Exception
    //   57	63	74	finally
    //   118	123	144	finally
  }
  
  public static String readStrFromFile(String paramString) {
    return readStrFromFile(new File(paramString));
  }
  
  public static void unZipFiles(File paramFile, String paramString) {
    // Byte code:
    //   0: new java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial <init> : (Ljava/lang/String;)V
    //   8: astore #4
    //   10: aload #4
    //   12: invokevirtual exists : ()Z
    //   15: ifne -> 24
    //   18: aload #4
    //   20: invokevirtual mkdirs : ()Z
    //   23: pop
    //   24: aload_1
    //   25: astore #4
    //   27: aload_1
    //   28: ldc '/'
    //   30: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   33: ifne -> 67
    //   36: new java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial <init> : ()V
    //   43: astore #4
    //   45: aload #4
    //   47: aload_1
    //   48: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload #4
    //   54: ldc '/'
    //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload #4
    //   62: invokevirtual toString : ()Ljava/lang/String;
    //   65: astore #4
    //   67: new java/util/zip/ZipFile
    //   70: dup
    //   71: aload_0
    //   72: invokespecial <init> : (Ljava/io/File;)V
    //   75: astore #7
    //   77: aload #7
    //   79: invokevirtual entries : ()Ljava/util/Enumeration;
    //   82: astore #6
    //   84: aload #6
    //   86: invokeinterface hasMoreElements : ()Z
    //   91: istore_3
    //   92: iload_3
    //   93: ifeq -> 319
    //   96: aconst_null
    //   97: astore_1
    //   98: aload #6
    //   100: invokeinterface nextElement : ()Ljava/lang/Object;
    //   105: checkcast java/util/zip/ZipEntry
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual getName : ()Ljava/lang/String;
    //   113: astore #5
    //   115: aload #7
    //   117: aload_0
    //   118: invokevirtual getInputStream : (Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   121: astore_0
    //   122: new java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial <init> : ()V
    //   129: astore #8
    //   131: aload #8
    //   133: aload #4
    //   135: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload #8
    //   141: aload #5
    //   143: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload #8
    //   149: invokevirtual toString : ()Ljava/lang/String;
    //   152: ldc_w '\*'
    //   155: ldc '/'
    //   157: invokevirtual replaceAll : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   160: astore #8
    //   162: aload #5
    //   164: ifnull -> 347
    //   167: aload #5
    //   169: ldc_w '../'
    //   172: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   175: ifeq -> 181
    //   178: goto -> 347
    //   181: new java/io/File
    //   184: dup
    //   185: aload #8
    //   187: iconst_0
    //   188: aload #8
    //   190: bipush #47
    //   192: invokevirtual lastIndexOf : (I)I
    //   195: invokevirtual substring : (II)Ljava/lang/String;
    //   198: invokespecial <init> : (Ljava/lang/String;)V
    //   201: astore #5
    //   203: aload #5
    //   205: invokevirtual exists : ()Z
    //   208: ifne -> 217
    //   211: aload #5
    //   213: invokevirtual mkdirs : ()Z
    //   216: pop
    //   217: new java/io/File
    //   220: dup
    //   221: aload #8
    //   223: invokespecial <init> : (Ljava/lang/String;)V
    //   226: invokevirtual isDirectory : ()Z
    //   229: istore_3
    //   230: iload_3
    //   231: ifeq -> 245
    //   234: aload_0
    //   235: ifnull -> 84
    //   238: aload_0
    //   239: invokevirtual close : ()V
    //   242: goto -> 84
    //   245: new java/io/FileOutputStream
    //   248: dup
    //   249: aload #8
    //   251: invokespecial <init> : (Ljava/lang/String;)V
    //   254: astore #5
    //   256: sipush #1024
    //   259: newarray byte
    //   261: astore_1
    //   262: aload_0
    //   263: aload_1
    //   264: invokevirtual read : ([B)I
    //   267: istore_2
    //   268: iload_2
    //   269: ifle -> 283
    //   272: aload #5
    //   274: aload_1
    //   275: iconst_0
    //   276: iload_2
    //   277: invokevirtual write : ([BII)V
    //   280: goto -> 262
    //   283: aload_0
    //   284: ifnull -> 291
    //   287: aload_0
    //   288: invokevirtual close : ()V
    //   291: aload #5
    //   293: invokevirtual close : ()V
    //   296: goto -> 84
    //   299: aload #4
    //   301: ifnull -> 309
    //   304: aload #4
    //   306: invokevirtual close : ()V
    //   309: aload_1
    //   310: ifnull -> 317
    //   313: aload_1
    //   314: invokevirtual close : ()V
    //   317: aload_0
    //   318: athrow
    //   319: aload #7
    //   321: invokevirtual close : ()V
    //   324: return
    //   325: astore_0
    //   326: aload #7
    //   328: invokevirtual close : ()V
    //   331: aload_0
    //   332: athrow
    //   333: astore #6
    //   335: aload #5
    //   337: astore_1
    //   338: aload_0
    //   339: astore #4
    //   341: aload #6
    //   343: astore_0
    //   344: goto -> 299
    //   347: aload_0
    //   348: ifnull -> 84
    //   351: goto -> 238
    //   354: astore #5
    //   356: aload_0
    //   357: astore #4
    //   359: aload #5
    //   361: astore_0
    //   362: goto -> 299
    //   365: astore_0
    //   366: aconst_null
    //   367: astore #4
    //   369: goto -> 299
    // Exception table:
    //   from	to	target	type
    //   77	84	325	finally
    //   84	92	325	finally
    //   98	122	365	finally
    //   122	162	354	finally
    //   167	178	354	finally
    //   181	217	354	finally
    //   217	230	354	finally
    //   238	242	325	finally
    //   245	256	354	finally
    //   256	262	333	finally
    //   262	268	333	finally
    //   272	280	333	finally
    //   287	291	325	finally
    //   291	296	325	finally
    //   304	309	325	finally
    //   313	317	325	finally
    //   317	319	325	finally
  }
  
  public static void writeBytesTo(File paramFile, ByteBuffer paramByteBuffer) {
    if (paramFile != null) {
      if (paramByteBuffer == null)
        return; 
      try {
        FileOutputStream fileOutputStream = new FileOutputStream(paramFile);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(paramByteBuffer.array());
        byte[] arrayOfByte = new byte[1024];
        while (true) {
          int i = byteArrayInputStream.read(arrayOfByte, 0, arrayOfByte.length);
          if (i != -1) {
            fileOutputStream.write(arrayOfByte, 0, i);
            continue;
          } 
          closeQuietly(byteArrayInputStream);
          closeQuietly(fileOutputStream);
          return;
        } 
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\commo\\util\FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */