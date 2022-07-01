package com.sina.weibo.sdk.statistic;

import android.os.Environment;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.MD5;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class LogFileUtil {
  public static final String ANALYTICS_FILE_NAME = "app_logs";
  
  private static final String ANALYTICS_FILE_SUFFIX = ".txt";
  
  private static final String SDCARD_WEIBO_ANALYTICS_DIR = "/sina/weibo/.applogs/";
  
  public static boolean delete(String paramString) {
    File file = new File(paramString);
    if (!file.exists())
      return false; 
    if (file.isFile()) {
      file.delete();
      return true;
    } 
    return false;
  }
  
  public static String getAppLogPath(String paramString) {
    String str;
    if (LogReport.getPackageName() != null) {
      StringBuilder stringBuilder1 = new StringBuilder(String.valueOf(MD5.hexdigest(LogReport.getPackageName())));
      stringBuilder1.append("/");
      str = stringBuilder1.toString();
    } else {
      str = "";
    } 
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(getSDPath()));
    stringBuilder.append("/sina/weibo/.applogs/");
    stringBuilder.append(str);
    stringBuilder.append(paramString);
    stringBuilder.append(".txt");
    return stringBuilder.toString();
  }
  
  public static String getAppLogs(String paramString) {
    return TextUtils.isEmpty(paramString) ? "" : readStringFromFile(paramString);
  }
  
  private static String getSDPath() {
    File file;
    if (Environment.getExternalStorageState().equals("mounted")) {
      file = Environment.getExternalStorageDirectory();
    } else {
      file = null;
    } 
    return (file != null) ? file.toString() : null;
  }
  
  private static String readStringFromFile(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    File file = new File(paramString);
    if (file.isFile()) {
      OutOfMemoryError outOfMemoryError;
      if (!file.exists())
        return ""; 
      BufferedReader bufferedReader = null;
      File file2 = null;
      paramString = null;
      StringBuilder stringBuilder = new StringBuilder((int)file.length());
      try {
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file));
        try {
          while (true)
            return stringBuilder.toString(); 
        } catch (IOException null) {
        
        } catch (OutOfMemoryError null) {
        
        } finally {
          BufferedReader bufferedReader2;
          paramString = null;
          bufferedReader = bufferedReader1;
          String str = paramString;
        } 
      } catch (IOException iOException) {
        file = file2;
      } catch (OutOfMemoryError outOfMemoryError1) {
        IOException iOException2 = iOException;
        outOfMemoryError = outOfMemoryError1;
        IOException iOException1 = iOException2;
        outOfMemoryError.printStackTrace();
        if (iOException2 != null) {
          iOException2.close();
          return stringBuilder.toString();
        } 
      } finally {}
      File file1 = file;
      outOfMemoryError.printStackTrace();
      if (file != null) {
        file.close();
        return stringBuilder.toString();
      } 
      return stringBuilder.toString();
    } 
    return "";
  }
  
  public static void writeToFile(String paramString1, String paramString2, boolean paramBoolean) {
    // Byte code:
    //   0: ldc com/sina/weibo/sdk/statistic/LogFileUtil
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   7: istore_3
    //   8: iload_3
    //   9: ifeq -> 16
    //   12: ldc com/sina/weibo/sdk/statistic/LogFileUtil
    //   14: monitorexit
    //   15: return
    //   16: new java/lang/StringBuilder
    //   19: dup
    //   20: ldc 'filePath:'
    //   22: invokespecial <init> : (Ljava/lang/String;)V
    //   25: astore #4
    //   27: aload #4
    //   29: aload_0
    //   30: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: ldc 'WBAgent'
    //   36: aload #4
    //   38: invokevirtual toString : ()Ljava/lang/String;
    //   41: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_1
    //   45: ifnull -> 295
    //   48: aload_1
    //   49: invokevirtual length : ()I
    //   52: ifne -> 58
    //   55: goto -> 295
    //   58: new java/lang/StringBuilder
    //   61: dup
    //   62: aload_1
    //   63: invokespecial <init> : (Ljava/lang/String;)V
    //   66: astore #5
    //   68: iconst_0
    //   69: istore_3
    //   70: aload #5
    //   72: iconst_0
    //   73: invokevirtual charAt : (I)C
    //   76: bipush #91
    //   78: if_icmpne -> 91
    //   81: aload #5
    //   83: iconst_0
    //   84: iconst_1
    //   85: ldc ''
    //   87: invokevirtual replace : (IILjava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload #5
    //   93: aload #5
    //   95: invokevirtual length : ()I
    //   98: iconst_1
    //   99: isub
    //   100: invokevirtual charAt : (I)C
    //   103: bipush #44
    //   105: if_icmpeq -> 128
    //   108: aload #5
    //   110: aload #5
    //   112: invokevirtual length : ()I
    //   115: iconst_1
    //   116: isub
    //   117: aload #5
    //   119: invokevirtual length : ()I
    //   122: ldc ','
    //   124: invokevirtual replace : (IILjava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: new java/io/File
    //   131: dup
    //   132: aload_0
    //   133: invokespecial <init> : (Ljava/lang/String;)V
    //   136: astore_0
    //   137: aconst_null
    //   138: astore #4
    //   140: aconst_null
    //   141: astore_1
    //   142: aload_0
    //   143: invokevirtual getParentFile : ()Ljava/io/File;
    //   146: astore #6
    //   148: aload #6
    //   150: invokevirtual exists : ()Z
    //   153: ifne -> 162
    //   156: aload #6
    //   158: invokevirtual mkdirs : ()Z
    //   161: pop
    //   162: aload_0
    //   163: invokevirtual exists : ()Z
    //   166: ifne -> 177
    //   169: aload_0
    //   170: invokevirtual createNewFile : ()Z
    //   173: pop
    //   174: goto -> 316
    //   177: aload_0
    //   178: invokevirtual lastModified : ()J
    //   181: lconst_0
    //   182: lcmp
    //   183: ifle -> 316
    //   186: invokestatic currentTimeMillis : ()J
    //   189: aload_0
    //   190: invokevirtual lastModified : ()J
    //   193: lsub
    //   194: ldc2_w 86400000
    //   197: lcmp
    //   198: ifle -> 316
    //   201: iload_3
    //   202: istore_2
    //   203: goto -> 206
    //   206: new java/io/FileWriter
    //   209: dup
    //   210: aload_0
    //   211: iload_2
    //   212: invokespecial <init> : (Ljava/io/File;Z)V
    //   215: astore_0
    //   216: aload_0
    //   217: aload #5
    //   219: invokevirtual toString : ()Ljava/lang/String;
    //   222: invokevirtual write : (Ljava/lang/String;)V
    //   225: aload_0
    //   226: invokevirtual flush : ()V
    //   229: aload_0
    //   230: invokevirtual close : ()V
    //   233: goto -> 291
    //   236: astore_0
    //   237: aload_0
    //   238: invokevirtual printStackTrace : ()V
    //   241: goto -> 291
    //   244: astore #4
    //   246: aload_0
    //   247: astore_1
    //   248: aload #4
    //   250: astore_0
    //   251: goto -> 258
    //   254: goto -> 276
    //   257: astore_0
    //   258: aload_1
    //   259: ifnull -> 274
    //   262: aload_1
    //   263: invokevirtual close : ()V
    //   266: goto -> 274
    //   269: astore_1
    //   270: aload_1
    //   271: invokevirtual printStackTrace : ()V
    //   274: aload_0
    //   275: athrow
    //   276: aload_0
    //   277: ifnull -> 291
    //   280: aload_0
    //   281: invokevirtual close : ()V
    //   284: goto -> 291
    //   287: astore_0
    //   288: goto -> 237
    //   291: ldc com/sina/weibo/sdk/statistic/LogFileUtil
    //   293: monitorexit
    //   294: return
    //   295: ldc com/sina/weibo/sdk/statistic/LogFileUtil
    //   297: monitorexit
    //   298: return
    //   299: astore_0
    //   300: ldc com/sina/weibo/sdk/statistic/LogFileUtil
    //   302: monitorexit
    //   303: aload_0
    //   304: athrow
    //   305: astore_0
    //   306: aload #4
    //   308: astore_0
    //   309: goto -> 276
    //   312: astore_1
    //   313: goto -> 254
    //   316: goto -> 206
    // Exception table:
    //   from	to	target	type
    //   3	8	299	finally
    //   16	44	299	finally
    //   48	55	299	finally
    //   58	68	299	finally
    //   70	91	299	finally
    //   91	128	299	finally
    //   128	137	299	finally
    //   142	162	305	java/io/IOException
    //   142	162	257	finally
    //   162	174	305	java/io/IOException
    //   162	174	257	finally
    //   177	201	305	java/io/IOException
    //   177	201	257	finally
    //   206	216	305	java/io/IOException
    //   206	216	257	finally
    //   216	229	312	java/io/IOException
    //   216	229	244	finally
    //   229	233	236	java/io/IOException
    //   229	233	299	finally
    //   237	241	299	finally
    //   262	266	269	java/io/IOException
    //   262	266	299	finally
    //   270	274	299	finally
    //   274	276	299	finally
    //   280	284	287	java/io/IOException
    //   280	284	299	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\statistic\LogFileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */