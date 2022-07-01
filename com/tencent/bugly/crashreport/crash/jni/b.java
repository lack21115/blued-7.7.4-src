package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b {
  private static List<File> a = new ArrayList<File>();
  
  public static CrashDetailBean a(Context paramContext, String paramString, NativeExceptionHandler paramNativeExceptionHandler) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 289
    //   4: aload_1
    //   5: ifnull -> 289
    //   8: aload_2
    //   9: ifnonnull -> 15
    //   12: goto -> 289
    //   15: new java/io/File
    //   18: dup
    //   19: aload_1
    //   20: ldc 'rqd_record.eup'
    //   22: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   25: astore_1
    //   26: aload_1
    //   27: invokevirtual exists : ()Z
    //   30: ifeq -> 287
    //   33: aload_1
    //   34: invokevirtual canRead : ()Z
    //   37: ifne -> 42
    //   40: aconst_null
    //   41: areturn
    //   42: new java/io/BufferedInputStream
    //   45: dup
    //   46: new java/io/FileInputStream
    //   49: dup
    //   50: aload_1
    //   51: invokespecial <init> : (Ljava/io/File;)V
    //   54: invokespecial <init> : (Ljava/io/InputStream;)V
    //   57: astore_3
    //   58: aload_3
    //   59: astore_1
    //   60: aload_3
    //   61: invokestatic a : (Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   64: astore #4
    //   66: aload #4
    //   68: ifnull -> 200
    //   71: aload_3
    //   72: astore_1
    //   73: aload #4
    //   75: ldc 'NATIVE_RQD_REPORT'
    //   77: invokevirtual equals : (Ljava/lang/Object;)Z
    //   80: ifne -> 86
    //   83: goto -> 200
    //   86: aload_3
    //   87: astore_1
    //   88: new java/util/HashMap
    //   91: dup
    //   92: invokespecial <init> : ()V
    //   95: astore #6
    //   97: goto -> 301
    //   100: aload_3
    //   101: astore_1
    //   102: aload_3
    //   103: invokestatic a : (Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   106: astore #5
    //   108: aload #5
    //   110: ifnull -> 142
    //   113: aload #4
    //   115: ifnonnull -> 125
    //   118: aload #5
    //   120: astore #4
    //   122: goto -> 100
    //   125: aload_3
    //   126: astore_1
    //   127: aload #6
    //   129: aload #4
    //   131: aload #5
    //   133: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   138: pop
    //   139: goto -> 301
    //   142: aload #4
    //   144: ifnull -> 177
    //   147: aload_3
    //   148: astore_1
    //   149: ldc 'record not pair! drop! %s'
    //   151: iconst_1
    //   152: anewarray java/lang/Object
    //   155: dup
    //   156: iconst_0
    //   157: aload #4
    //   159: aastore
    //   160: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   163: pop
    //   164: aload_3
    //   165: invokevirtual close : ()V
    //   168: aconst_null
    //   169: areturn
    //   170: astore_0
    //   171: aload_0
    //   172: invokevirtual printStackTrace : ()V
    //   175: aconst_null
    //   176: areturn
    //   177: aload_3
    //   178: astore_1
    //   179: aload_0
    //   180: aload #6
    //   182: aload_2
    //   183: invokestatic a : (Landroid/content/Context;Ljava/util/Map;Lcom/tencent/bugly/crashreport/crash/jni/NativeExceptionHandler;)Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;
    //   186: astore_0
    //   187: aload_3
    //   188: invokevirtual close : ()V
    //   191: aload_0
    //   192: areturn
    //   193: astore_1
    //   194: aload_1
    //   195: invokevirtual printStackTrace : ()V
    //   198: aload_0
    //   199: areturn
    //   200: aload_3
    //   201: astore_1
    //   202: ldc 'record read fail! %s'
    //   204: iconst_1
    //   205: anewarray java/lang/Object
    //   208: dup
    //   209: iconst_0
    //   210: aload #4
    //   212: aastore
    //   213: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   216: pop
    //   217: aload_3
    //   218: invokevirtual close : ()V
    //   221: aconst_null
    //   222: areturn
    //   223: astore_0
    //   224: aload_0
    //   225: invokevirtual printStackTrace : ()V
    //   228: aconst_null
    //   229: areturn
    //   230: astore_2
    //   231: aload_3
    //   232: astore_0
    //   233: goto -> 245
    //   236: astore_0
    //   237: aconst_null
    //   238: astore_1
    //   239: goto -> 269
    //   242: astore_2
    //   243: aconst_null
    //   244: astore_0
    //   245: aload_0
    //   246: astore_1
    //   247: aload_2
    //   248: invokevirtual printStackTrace : ()V
    //   251: aload_0
    //   252: ifnull -> 266
    //   255: aload_0
    //   256: invokevirtual close : ()V
    //   259: aconst_null
    //   260: areturn
    //   261: astore_0
    //   262: aload_0
    //   263: invokevirtual printStackTrace : ()V
    //   266: aconst_null
    //   267: areturn
    //   268: astore_0
    //   269: aload_1
    //   270: ifnull -> 285
    //   273: aload_1
    //   274: invokevirtual close : ()V
    //   277: goto -> 285
    //   280: astore_1
    //   281: aload_1
    //   282: invokevirtual printStackTrace : ()V
    //   285: aload_0
    //   286: athrow
    //   287: aconst_null
    //   288: areturn
    //   289: ldc 'get eup record file args error'
    //   291: iconst_0
    //   292: anewarray java/lang/Object
    //   295: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   298: pop
    //   299: aconst_null
    //   300: areturn
    //   301: aconst_null
    //   302: astore #4
    //   304: goto -> 100
    // Exception table:
    //   from	to	target	type
    //   42	58	242	java/io/IOException
    //   42	58	236	finally
    //   60	66	230	java/io/IOException
    //   60	66	268	finally
    //   73	83	230	java/io/IOException
    //   73	83	268	finally
    //   88	97	230	java/io/IOException
    //   88	97	268	finally
    //   102	108	230	java/io/IOException
    //   102	108	268	finally
    //   127	139	230	java/io/IOException
    //   127	139	268	finally
    //   149	164	230	java/io/IOException
    //   149	164	268	finally
    //   164	168	170	java/io/IOException
    //   179	187	230	java/io/IOException
    //   179	187	268	finally
    //   187	191	193	java/io/IOException
    //   202	217	230	java/io/IOException
    //   202	217	268	finally
    //   217	221	223	java/io/IOException
    //   247	251	268	finally
    //   255	259	261	java/io/IOException
    //   273	277	280	java/io/IOException
  }
  
  private static CrashDetailBean a(Context paramContext, Map<String, String> paramMap, NativeExceptionHandler paramNativeExceptionHandler) {
    if (paramMap == null)
      return null; 
    if (a.a(paramContext) == null) {
      x.e("abnormal com info not created", new Object[0]);
      return null;
    } 
    String str = paramMap.get("intStateStr");
    if (str == null || str.trim().length() <= 0) {
      x.e("no intStateStr", new Object[0]);
      return null;
    } 
    Map<String, Integer> map = d(str);
    if (map == null) {
      x.e("parse intSateMap fail", new Object[] { Integer.valueOf(paramMap.size()) });
      return null;
    } 
    try {
      String str2;
      ((Integer)map.get("sino")).intValue();
      ((Integer)map.get("sud")).intValue();
      String str11 = paramMap.get("soVersion");
      if (TextUtils.isEmpty(str11))
        return null; 
      String str4 = paramMap.get("errorAddr");
      String str10 = "unknown";
      if (str4 == null)
        str4 = "unknown"; 
      String str1 = paramMap.get("codeMsg");
      str = str1;
      if (str1 == null)
        str = "unknown"; 
      String str5 = paramMap.get("tombPath");
      if (str5 == null)
        str5 = "unknown"; 
      String str3 = paramMap.get("signalName");
      str1 = str3;
      if (str3 == null)
        str1 = "unknown"; 
      paramMap.get("errnoMsg");
      String str6 = paramMap.get("stack");
      str3 = str6;
      if (str6 == null)
        str3 = "unknown"; 
      String str7 = paramMap.get("jstack");
      str6 = str3;
      if (str7 != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str3);
        stringBuilder.append("java:\n");
        stringBuilder.append(str7);
        str6 = stringBuilder.toString();
      } 
      Integer integer1 = map.get("sico");
      if (integer1 != null && integer1.intValue() > 0) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str1);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(")");
        str1 = stringBuilder.toString();
        str2 = "KERNEL";
      } else {
        str2 = str;
      } 
      str = paramMap.get("nativeLog");
      if (str != null && !str.isEmpty()) {
        byte[] arrayOfByte = z.a(null, str, "BuglyNativeLog.txt");
      } else {
        str7 = null;
      } 
      String str8 = paramMap.get("sendingProcess");
      str = str8;
      if (str8 == null)
        str = "unknown"; 
      Integer integer2 = map.get("spd");
      str8 = str;
      if (integer2 != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("(");
        stringBuilder.append(integer2);
        stringBuilder.append(")");
        str8 = stringBuilder.toString();
      } 
      String str9 = paramMap.get("threadName");
      str = str9;
      if (str9 == null)
        str = "unknown"; 
      Integer integer3 = map.get("et");
      str9 = str;
      if (integer3 != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("(");
        stringBuilder.append(integer3);
        stringBuilder.append(")");
        str9 = stringBuilder.toString();
      } 
      str = paramMap.get("processName");
      if (str == null)
        str = str10; 
      integer3 = map.get("ep");
      str10 = str;
      if (integer3 != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("(");
        stringBuilder.append(integer3);
        stringBuilder.append(")");
        str10 = stringBuilder.toString();
      } 
      str = paramMap.get("key-value");
      if (str != null) {
        HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
        String[] arrayOfString = str.split("\n");
        int j = arrayOfString.length;
        for (int i = 0; i < j; i++) {
          String[] arrayOfString1 = arrayOfString[i].split("=");
          if (arrayOfString1.length == 2)
            hashMap2.put(arrayOfString1[0], arrayOfString1[1]); 
        } 
        HashMap<Object, Object> hashMap1 = hashMap2;
      } else {
        str = null;
      } 
      return crashDetailBean;
    } finally {
      str = null;
      x.e("error format", new Object[0]);
      str.printStackTrace();
    } 
  }
  
  private static String a(BufferedInputStream paramBufferedInputStream) throws IOException {
    if (paramBufferedInputStream == null)
      return null; 
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
    } finally {
      null = null;
    } 
    try {
      x.a(null);
      return null;
    } finally {
      if (paramBufferedInputStream != null)
        paramBufferedInputStream.close(); 
    } 
  }
  
  protected static String a(String paramString) {
    if (paramString == null)
      return ""; 
    String[] arrayOfString = paramString.split("\n");
    String str = paramString;
    if (arrayOfString != null) {
      if (arrayOfString.length == 0)
        return paramString; 
      StringBuilder stringBuilder = new StringBuilder();
      int j = arrayOfString.length;
      for (int i = 0; i < j; i++) {
        str = arrayOfString[i];
        if (!str.contains("java.lang.Thread.getStackTrace(")) {
          stringBuilder.append(str);
          stringBuilder.append("\n");
        } 
      } 
      str = stringBuilder.toString();
    } 
    return str;
  }
  
  public static String a(String paramString1, int paramInt, String paramString2, boolean paramBoolean) {
    if (paramString1 != null) {
      if (paramInt <= 0)
        return null; 
      File file = new File(paramString1);
      if (file.exists()) {
        if (!file.canRead())
          return null; 
        x.a("Read system log from native record file(length: %s bytes): %s", new Object[] { Long.valueOf(file.length()), file.getAbsolutePath() });
        a.add(file);
        x.c("Add this record file to list for cleaning lastly.", new Object[0]);
        if (paramString2 == null)
          return z.a(new File(paramString1), paramInt, paramBoolean); 
        StringBuilder stringBuilder = new StringBuilder();
        try {
          BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
        } finally {
          paramString2 = null;
        } 
        try {
          x.a((Throwable)paramString2);
          StringBuilder stringBuilder1 = new StringBuilder("\n[error:");
          stringBuilder1.append(paramString2.toString());
          stringBuilder1.append("]");
          stringBuilder.append(stringBuilder1.toString());
          String str = stringBuilder.toString();
          return str;
        } finally {
          if (paramString1 != null)
            try {
              paramString1.close();
            } catch (Exception exception) {
              x.a(exception);
            }  
        } 
      } 
    } 
    return null;
  }
  
  public static String a(String paramString1, String paramString2) {
    if (paramString1 == null || paramString2 == null)
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    String str = b(paramString1, paramString2);
    if (str != null && !str.isEmpty()) {
      stringBuilder.append("Register infos:\n");
      stringBuilder.append(str);
    } 
    paramString1 = c(paramString1, paramString2);
    if (paramString1 != null && !paramString1.isEmpty()) {
      if (stringBuilder.length() > 0)
        stringBuilder.append("\n"); 
      stringBuilder.append("System SO infos:\n");
      stringBuilder.append(paramString1);
    } 
    return stringBuilder.toString();
  }
  
  public static void a(boolean paramBoolean, String paramString) {
    if (paramString != null) {
      a.add(new File(paramString, "rqd_record.eup"));
      a.add(new File(paramString, "reg_record.txt"));
      a.add(new File(paramString, "map_record.txt"));
      a.add(new File(paramString, "backup_record.txt"));
      if (paramBoolean)
        c(paramString); 
    } 
    List<File> list = a;
    if (list != null && list.size() > 0)
      for (File file : a) {
        if (file.exists() && file.canWrite()) {
          file.delete();
          x.c("Delete record file %s", new Object[] { file.getAbsoluteFile() });
        } 
      }  
  }
  
  public static String b(String paramString) {
    if (paramString == null)
      return null; 
    File file = new File(paramString, "backup_record.txt");
    return file.exists() ? file.getAbsolutePath() : null;
  }
  
  private static String b(String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 'reg_record.txt'
    //   4: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/io/BufferedReader;
    //   7: astore_0
    //   8: aload_0
    //   9: ifnonnull -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: new java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial <init> : ()V
    //   21: astore #5
    //   23: aload_0
    //   24: invokevirtual readLine : ()Ljava/lang/String;
    //   27: astore #6
    //   29: aload #6
    //   31: ifnull -> 166
    //   34: aload #6
    //   36: aload_1
    //   37: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   40: ifne -> 228
    //   43: goto -> 166
    //   46: aload_0
    //   47: invokevirtual readLine : ()Ljava/lang/String;
    //   50: astore_1
    //   51: aload_1
    //   52: ifnull -> 134
    //   55: iload_3
    //   56: iconst_4
    //   57: irem
    //   58: ifne -> 85
    //   61: iload_3
    //   62: ifle -> 73
    //   65: aload #5
    //   67: ldc '\\n'
    //   69: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload #5
    //   75: ldc_w '  '
    //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: goto -> 114
    //   85: aload_1
    //   86: invokevirtual length : ()I
    //   89: bipush #16
    //   91: if_icmple -> 97
    //   94: bipush #28
    //   96: istore_2
    //   97: aload #5
    //   99: ldc_w '                '
    //   102: iconst_0
    //   103: iload_2
    //   104: iload #4
    //   106: isub
    //   107: invokevirtual substring : (II)Ljava/lang/String;
    //   110: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_1
    //   115: invokevirtual length : ()I
    //   118: istore #4
    //   120: aload #5
    //   122: aload_1
    //   123: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: iload_3
    //   128: iconst_1
    //   129: iadd
    //   130: istore_3
    //   131: goto -> 46
    //   134: aload #5
    //   136: ldc '\\n'
    //   138: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload #5
    //   144: invokevirtual toString : ()Ljava/lang/String;
    //   147: astore_1
    //   148: aload_0
    //   149: ifnull -> 164
    //   152: aload_0
    //   153: invokevirtual close : ()V
    //   156: aload_1
    //   157: areturn
    //   158: astore_0
    //   159: aload_0
    //   160: invokestatic a : (Ljava/lang/Throwable;)Z
    //   163: pop
    //   164: aload_1
    //   165: areturn
    //   166: aload_0
    //   167: ifnull -> 182
    //   170: aload_0
    //   171: invokevirtual close : ()V
    //   174: aconst_null
    //   175: areturn
    //   176: astore_0
    //   177: aload_0
    //   178: invokestatic a : (Ljava/lang/Throwable;)Z
    //   181: pop
    //   182: aconst_null
    //   183: areturn
    //   184: astore_1
    //   185: aload_1
    //   186: invokestatic a : (Ljava/lang/Throwable;)Z
    //   189: pop
    //   190: aload_0
    //   191: ifnull -> 206
    //   194: aload_0
    //   195: invokevirtual close : ()V
    //   198: aconst_null
    //   199: areturn
    //   200: astore_0
    //   201: aload_0
    //   202: invokestatic a : (Ljava/lang/Throwable;)Z
    //   205: pop
    //   206: aconst_null
    //   207: areturn
    //   208: astore_1
    //   209: aload_0
    //   210: ifnull -> 226
    //   213: aload_0
    //   214: invokevirtual close : ()V
    //   217: goto -> 226
    //   220: astore_0
    //   221: aload_0
    //   222: invokestatic a : (Ljava/lang/Throwable;)Z
    //   225: pop
    //   226: aload_1
    //   227: athrow
    //   228: iconst_0
    //   229: istore_3
    //   230: bipush #18
    //   232: istore_2
    //   233: iconst_0
    //   234: istore #4
    //   236: goto -> 46
    // Exception table:
    //   from	to	target	type
    //   14	29	184	finally
    //   34	43	184	finally
    //   46	51	184	finally
    //   65	73	184	finally
    //   73	82	184	finally
    //   85	94	184	finally
    //   97	114	184	finally
    //   114	127	184	finally
    //   134	148	184	finally
    //   152	156	158	java/lang/Exception
    //   170	174	176	java/lang/Exception
    //   185	190	208	finally
    //   194	198	200	java/lang/Exception
    //   213	217	220	java/lang/Exception
  }
  
  private static String c(String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 'map_record.txt'
    //   4: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/io/BufferedReader;
    //   7: astore_0
    //   8: aload_0
    //   9: ifnonnull -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: new java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial <init> : ()V
    //   21: astore_2
    //   22: aload_0
    //   23: invokevirtual readLine : ()Ljava/lang/String;
    //   26: astore_3
    //   27: aload_3
    //   28: ifnull -> 98
    //   31: aload_3
    //   32: aload_1
    //   33: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   36: ifne -> 42
    //   39: goto -> 98
    //   42: aload_0
    //   43: invokevirtual readLine : ()Ljava/lang/String;
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull -> 75
    //   51: aload_2
    //   52: ldc_w '  '
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_2
    //   60: aload_1
    //   61: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_2
    //   66: ldc '\\n'
    //   68: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: goto -> 42
    //   75: aload_2
    //   76: invokevirtual toString : ()Ljava/lang/String;
    //   79: astore_1
    //   80: aload_0
    //   81: ifnull -> 96
    //   84: aload_0
    //   85: invokevirtual close : ()V
    //   88: aload_1
    //   89: areturn
    //   90: astore_0
    //   91: aload_0
    //   92: invokestatic a : (Ljava/lang/Throwable;)Z
    //   95: pop
    //   96: aload_1
    //   97: areturn
    //   98: aload_0
    //   99: ifnull -> 114
    //   102: aload_0
    //   103: invokevirtual close : ()V
    //   106: aconst_null
    //   107: areturn
    //   108: astore_0
    //   109: aload_0
    //   110: invokestatic a : (Ljava/lang/Throwable;)Z
    //   113: pop
    //   114: aconst_null
    //   115: areturn
    //   116: astore_1
    //   117: aload_1
    //   118: invokestatic a : (Ljava/lang/Throwable;)Z
    //   121: pop
    //   122: aload_0
    //   123: ifnull -> 138
    //   126: aload_0
    //   127: invokevirtual close : ()V
    //   130: aconst_null
    //   131: areturn
    //   132: astore_0
    //   133: aload_0
    //   134: invokestatic a : (Ljava/lang/Throwable;)Z
    //   137: pop
    //   138: aconst_null
    //   139: areturn
    //   140: astore_1
    //   141: aload_0
    //   142: ifnull -> 158
    //   145: aload_0
    //   146: invokevirtual close : ()V
    //   149: goto -> 158
    //   152: astore_0
    //   153: aload_0
    //   154: invokestatic a : (Ljava/lang/Throwable;)Z
    //   157: pop
    //   158: aload_1
    //   159: athrow
    // Exception table:
    //   from	to	target	type
    //   14	27	116	finally
    //   31	39	116	finally
    //   42	47	116	finally
    //   51	72	116	finally
    //   75	80	116	finally
    //   84	88	90	java/lang/Exception
    //   102	106	108	java/lang/Exception
    //   117	122	140	finally
    //   126	130	132	java/lang/Exception
    //   145	149	152	java/lang/Exception
  }
  
  public static void c(String paramString) {
    if (paramString == null)
      return; 
    try {
      return;
    } finally {
      paramString = null;
      x.a((Throwable)paramString);
    } 
  }
  
  private static Map<String, Integer> d(String paramString) {
    if (paramString == null)
      return null; 
    try {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      for (String str : paramString.split(",")) {
        String[] arrayOfString = str.split(":");
        if (arrayOfString.length != 2) {
          x.e("error format at %s", new Object[] { str });
          return null;
        } 
        int i = Integer.parseInt(arrayOfString[1]);
        hashMap.put(arrayOfString[0], Integer.valueOf(i));
      } 
      return (Map)hashMap;
    } catch (Exception exception) {
      x.e("error format intStateStr %s", new Object[] { paramString });
      exception.printStackTrace();
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\crashreport\crash\jni\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */