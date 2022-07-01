package com.huawei.hms.utils;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public abstract class FileUtil {
  public static final String LOCAL_REPORT_FILE = "hms/HwMobileServiceReport.txt";
  
  public static final String LOCAL_REPORT_FILE_CONFIG = "hms/config.txt";
  
  public static final long LOCAL_REPORT_FILE_MAX_SIZE = 10240L;
  
  private static boolean a = false;
  
  private static ScheduledExecutorService b = Executors.newSingleThreadScheduledExecutor();
  
  public static boolean verifyHash(String paramString, File paramFile) {
    byte[] arrayOfByte = SHA256.digest(paramFile);
    return (arrayOfByte != null && HEX.encodeHexString(arrayOfByte, true).equalsIgnoreCase(paramString));
  }
  
  public static void writeFile(File paramFile, String paramString, long paramLong) {
    b.execute(new Runnable(paramFile, paramLong, paramString) {
          public void run() {
            // Byte code:
            //   0: aload_0
            //   1: getfield a : Ljava/io/File;
            //   4: astore #5
            //   6: aload #5
            //   8: ifnonnull -> 19
            //   11: ldc 'FileUtil'
            //   13: ldc 'In writeFile Failed to get local file.'
            //   15: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
            //   18: return
            //   19: aload #5
            //   21: invokevirtual getParentFile : ()Ljava/io/File;
            //   24: astore #5
            //   26: aload #5
            //   28: ifnull -> 332
            //   31: aload #5
            //   33: invokevirtual mkdirs : ()Z
            //   36: ifne -> 50
            //   39: aload #5
            //   41: invokevirtual isDirectory : ()Z
            //   44: ifne -> 50
            //   47: goto -> 332
            //   50: aconst_null
            //   51: astore #8
            //   53: aconst_null
            //   54: astore #5
            //   56: aload #5
            //   58: astore #6
            //   60: aload #8
            //   62: astore #7
            //   64: aload_0
            //   65: getfield a : Ljava/io/File;
            //   68: invokevirtual length : ()J
            //   71: lstore_1
            //   72: aload #5
            //   74: astore #6
            //   76: aload #8
            //   78: astore #7
            //   80: aload_0
            //   81: getfield b : J
            //   84: lstore_3
            //   85: lload_1
            //   86: lload_3
            //   87: lcmp
            //   88: ifle -> 172
            //   91: aload #5
            //   93: astore #6
            //   95: aload #8
            //   97: astore #7
            //   99: aload_0
            //   100: getfield a : Ljava/io/File;
            //   103: invokevirtual getCanonicalPath : ()Ljava/lang/String;
            //   106: astore #9
            //   108: aload #5
            //   110: astore #6
            //   112: aload #8
            //   114: astore #7
            //   116: aload_0
            //   117: getfield a : Ljava/io/File;
            //   120: invokevirtual delete : ()Z
            //   123: ifne -> 141
            //   126: aload #5
            //   128: astore #6
            //   130: aload #8
            //   132: astore #7
            //   134: ldc 'FileUtil'
            //   136: ldc 'last file delete failed.'
            //   138: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
            //   141: aload #5
            //   143: astore #6
            //   145: aload #8
            //   147: astore #7
            //   149: new java/io/RandomAccessFile
            //   152: dup
            //   153: new java/io/File
            //   156: dup
            //   157: aload #9
            //   159: invokespecial <init> : (Ljava/lang/String;)V
            //   162: ldc 'rw'
            //   164: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
            //   167: astore #5
            //   169: goto -> 201
            //   172: aload #5
            //   174: astore #6
            //   176: aload #8
            //   178: astore #7
            //   180: new java/io/RandomAccessFile
            //   183: dup
            //   184: aload_0
            //   185: getfield a : Ljava/io/File;
            //   188: ldc 'rw'
            //   190: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
            //   193: astore #5
            //   195: aload #5
            //   197: lload_1
            //   198: invokevirtual seek : (J)V
            //   201: aload #5
            //   203: astore #6
            //   205: aload #5
            //   207: astore #7
            //   209: new java/lang/StringBuilder
            //   212: dup
            //   213: invokespecial <init> : ()V
            //   216: astore #8
            //   218: aload #5
            //   220: astore #6
            //   222: aload #5
            //   224: astore #7
            //   226: aload #8
            //   228: aload_0
            //   229: getfield c : Ljava/lang/String;
            //   232: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   235: pop
            //   236: aload #5
            //   238: astore #6
            //   240: aload #5
            //   242: astore #7
            //   244: aload #8
            //   246: ldc 'line.separator'
            //   248: invokestatic getProperty : (Ljava/lang/String;)Ljava/lang/String;
            //   251: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   254: pop
            //   255: aload #5
            //   257: astore #6
            //   259: aload #5
            //   261: astore #7
            //   263: aload #5
            //   265: aload #8
            //   267: invokevirtual toString : ()Ljava/lang/String;
            //   270: invokevirtual writeBytes : (Ljava/lang/String;)V
            //   273: goto -> 318
            //   276: astore #7
            //   278: aload #5
            //   280: astore #6
            //   282: aload #7
            //   284: astore #5
            //   286: goto -> 324
            //   289: astore #8
            //   291: goto -> 305
            //   294: astore #5
            //   296: goto -> 324
            //   299: astore #8
            //   301: aload #7
            //   303: astore #5
            //   305: aload #5
            //   307: astore #6
            //   309: ldc 'FileUtil'
            //   311: ldc 'writeFile exception:'
            //   313: aload #8
            //   315: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
            //   318: aload #5
            //   320: invokestatic closeQuietly : (Ljava/io/Closeable;)V
            //   323: return
            //   324: aload #6
            //   326: invokestatic closeQuietly : (Ljava/io/Closeable;)V
            //   329: aload #5
            //   331: athrow
            //   332: ldc 'FileUtil'
            //   334: ldc 'In writeFile, Failed to create directory.'
            //   336: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
            //   339: return
            // Exception table:
            //   from	to	target	type
            //   64	72	299	java/io/IOException
            //   64	72	294	finally
            //   80	85	299	java/io/IOException
            //   80	85	294	finally
            //   99	108	299	java/io/IOException
            //   99	108	294	finally
            //   116	126	299	java/io/IOException
            //   116	126	294	finally
            //   134	141	299	java/io/IOException
            //   134	141	294	finally
            //   149	169	299	java/io/IOException
            //   149	169	294	finally
            //   180	195	299	java/io/IOException
            //   180	195	294	finally
            //   195	201	289	java/io/IOException
            //   195	201	276	finally
            //   209	218	299	java/io/IOException
            //   209	218	294	finally
            //   226	236	299	java/io/IOException
            //   226	236	294	finally
            //   244	255	299	java/io/IOException
            //   244	255	294	finally
            //   263	273	299	java/io/IOException
            //   263	273	294	finally
            //   309	318	294	finally
          }
        });
  }
  
  public static void writeFileReport(Context paramContext, File paramFile1, File paramFile2, String paramString, long paramLong, int paramInt) {
    if (paramFile1 != null && paramFile1.isFile() && paramFile1.exists()) {
      if (!a) {
        if (paramFile2 != null && paramFile2.exists() && !paramFile2.delete())
          HMSLog.e("FileUtil", "file delete failed."); 
        a = true;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("|");
      stringBuilder.append(paramLong);
      stringBuilder.append("|");
      stringBuilder.append(paramInt);
      writeFile(paramFile2, stringBuilder.toString(), 10240L);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\utils\FileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */