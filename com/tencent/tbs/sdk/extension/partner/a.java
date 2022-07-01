package com.tencent.tbs.sdk.extension.partner;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import com.tencent.tbs.sdk.extension.TbsSDKExtension;
import com.tencent.tbs.sdk.extension.partner.a.a;
import com.tencent.tbs.sdk.extension.partner.c.g;
import com.tencent.tbs.sdk.extension.partner.precheck.TbsCrashHandler;
import com.tencent.tbs.sdk.extension.partner.precheck.b;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class a {
  static volatile boolean a = false;
  
  private static String b = "1";
  
  private static int c = 3;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static String a(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic d : (Landroid/content/Context;)Ljava/io/File;
    //   4: new com/tencent/tbs/sdk/extension/partner/a$2
    //   7: dup
    //   8: invokespecial <init> : ()V
    //   11: invokevirtual listFiles : (Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   14: astore_0
    //   15: aload_0
    //   16: arraylength
    //   17: iconst_1
    //   18: if_icmpge -> 51
    //   21: new java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial <init> : ()V
    //   28: astore_3
    //   29: aload_3
    //   30: ldc 'stackTraceFiles lenght: '
    //   32: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_3
    //   37: aload_0
    //   38: arraylength
    //   39: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual toString : ()Ljava/lang/String;
    //   47: pop
    //   48: ldc ''
    //   50: areturn
    //   51: aload_0
    //   52: iconst_0
    //   53: aaload
    //   54: astore_0
    //   55: new java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial <init> : ()V
    //   62: astore_3
    //   63: aload_3
    //   64: ldc 'stackTraceFiles -- file: '
    //   66: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_3
    //   71: aload_0
    //   72: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   75: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_3
    //   80: invokevirtual toString : ()Ljava/lang/String;
    //   83: pop
    //   84: new java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial <init> : ()V
    //   91: astore #4
    //   93: new java/io/BufferedReader
    //   96: dup
    //   97: new java/io/FileReader
    //   100: dup
    //   101: aload_0
    //   102: invokespecial <init> : (Ljava/io/File;)V
    //   105: invokespecial <init> : (Ljava/io/Reader;)V
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual readLine : ()Ljava/lang/String;
    //   113: pop
    //   114: aload_0
    //   115: invokevirtual readLine : ()Ljava/lang/String;
    //   118: pop
    //   119: aload_0
    //   120: invokevirtual readLine : ()Ljava/lang/String;
    //   123: astore #5
    //   125: aload_0
    //   126: astore_3
    //   127: aload #5
    //   129: ifnull -> 151
    //   132: aload #4
    //   134: aload #5
    //   136: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload #4
    //   142: bipush #10
    //   144: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: goto -> 119
    //   151: aload_3
    //   152: invokevirtual close : ()V
    //   155: goto -> 198
    //   158: goto -> 198
    //   161: astore #4
    //   163: aload_0
    //   164: astore_3
    //   165: aload #4
    //   167: astore_0
    //   168: goto -> 177
    //   171: goto -> 189
    //   174: astore_0
    //   175: aconst_null
    //   176: astore_3
    //   177: aload_3
    //   178: ifnull -> 185
    //   181: aload_3
    //   182: invokevirtual close : ()V
    //   185: aload_0
    //   186: athrow
    //   187: aconst_null
    //   188: astore_0
    //   189: aload_0
    //   190: ifnull -> 198
    //   193: aload_0
    //   194: astore_3
    //   195: goto -> 151
    //   198: aload #4
    //   200: invokevirtual toString : ()Ljava/lang/String;
    //   203: astore_0
    //   204: new java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial <init> : ()V
    //   211: astore_3
    //   212: aload_3
    //   213: ldc 'content: '
    //   215: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload_3
    //   220: aload_0
    //   221: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload_3
    //   226: invokevirtual toString : ()Ljava/lang/String;
    //   229: pop
    //   230: aload_0
    //   231: invokevirtual length : ()I
    //   234: istore_2
    //   235: sipush #1024
    //   238: istore_1
    //   239: iload_2
    //   240: sipush #1024
    //   243: if_icmple -> 249
    //   246: goto -> 254
    //   249: aload_0
    //   250: invokevirtual length : ()I
    //   253: istore_1
    //   254: aload_0
    //   255: iconst_0
    //   256: iload_1
    //   257: invokevirtual substring : (II)Ljava/lang/String;
    //   260: areturn
    //   261: astore_0
    //   262: goto -> 187
    //   265: astore_3
    //   266: goto -> 171
    //   269: astore_0
    //   270: goto -> 158
    //   273: astore_3
    //   274: goto -> 185
    // Exception table:
    //   from	to	target	type
    //   93	109	261	java/io/IOException
    //   93	109	174	finally
    //   109	119	265	java/io/IOException
    //   109	119	161	finally
    //   119	125	265	java/io/IOException
    //   119	125	161	finally
    //   132	148	265	java/io/IOException
    //   132	148	161	finally
    //   151	155	269	java/lang/Exception
    //   181	185	273	java/lang/Exception
  }
  
  public static String a(File paramFile) {
    // Byte code:
    //   0: bipush #16
    //   2: newarray char
    //   4: astore #6
    //   6: aload #6
    //   8: dup
    //   9: iconst_0
    //   10: ldc 48
    //   12: castore
    //   13: dup
    //   14: iconst_1
    //   15: ldc 49
    //   17: castore
    //   18: dup
    //   19: iconst_2
    //   20: ldc 50
    //   22: castore
    //   23: dup
    //   24: iconst_3
    //   25: ldc 51
    //   27: castore
    //   28: dup
    //   29: iconst_4
    //   30: ldc 52
    //   32: castore
    //   33: dup
    //   34: iconst_5
    //   35: ldc 53
    //   37: castore
    //   38: dup
    //   39: bipush #6
    //   41: ldc 54
    //   43: castore
    //   44: dup
    //   45: bipush #7
    //   47: ldc 55
    //   49: castore
    //   50: dup
    //   51: bipush #8
    //   53: ldc 56
    //   55: castore
    //   56: dup
    //   57: bipush #9
    //   59: ldc 57
    //   61: castore
    //   62: dup
    //   63: bipush #10
    //   65: ldc 97
    //   67: castore
    //   68: dup
    //   69: bipush #11
    //   71: ldc 98
    //   73: castore
    //   74: dup
    //   75: bipush #12
    //   77: ldc 99
    //   79: castore
    //   80: dup
    //   81: bipush #13
    //   83: ldc 100
    //   85: castore
    //   86: dup
    //   87: bipush #14
    //   89: ldc 101
    //   91: castore
    //   92: dup
    //   93: bipush #15
    //   95: ldc 102
    //   97: castore
    //   98: pop
    //   99: bipush #32
    //   101: newarray char
    //   103: astore #7
    //   105: ldc 'MD5'
    //   107: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/MessageDigest;
    //   110: astore #8
    //   112: new java/io/FileInputStream
    //   115: dup
    //   116: aload_0
    //   117: invokespecial <init> : (Ljava/io/File;)V
    //   120: astore #5
    //   122: aload #5
    //   124: astore_0
    //   125: sipush #8192
    //   128: newarray byte
    //   130: astore #9
    //   132: aload #5
    //   134: astore_0
    //   135: aload #5
    //   137: aload #9
    //   139: invokevirtual read : ([B)I
    //   142: istore_1
    //   143: iconst_0
    //   144: istore_2
    //   145: iload_1
    //   146: iconst_m1
    //   147: if_icmpeq -> 165
    //   150: aload #5
    //   152: astore_0
    //   153: aload #8
    //   155: aload #9
    //   157: iconst_0
    //   158: iload_1
    //   159: invokevirtual update : ([BII)V
    //   162: goto -> 132
    //   165: aload #5
    //   167: astore_0
    //   168: aload #8
    //   170: invokevirtual digest : ()[B
    //   173: astore #8
    //   175: iconst_0
    //   176: istore_1
    //   177: goto -> 275
    //   180: aload #5
    //   182: astore_0
    //   183: new java/lang/String
    //   186: dup
    //   187: aload #7
    //   189: invokespecial <init> : ([C)V
    //   192: astore #6
    //   194: aload #5
    //   196: invokevirtual close : ()V
    //   199: aload #6
    //   201: areturn
    //   202: astore_0
    //   203: aload_0
    //   204: invokevirtual printStackTrace : ()V
    //   207: aload #6
    //   209: areturn
    //   210: astore #6
    //   212: goto -> 227
    //   215: astore #5
    //   217: aconst_null
    //   218: astore_0
    //   219: goto -> 256
    //   222: astore #6
    //   224: aconst_null
    //   225: astore #5
    //   227: aload #5
    //   229: astore_0
    //   230: aload #6
    //   232: invokevirtual printStackTrace : ()V
    //   235: aload #5
    //   237: ifnull -> 252
    //   240: aload #5
    //   242: invokevirtual close : ()V
    //   245: aconst_null
    //   246: areturn
    //   247: astore_0
    //   248: aload_0
    //   249: invokevirtual printStackTrace : ()V
    //   252: aconst_null
    //   253: areturn
    //   254: astore #5
    //   256: aload_0
    //   257: ifnull -> 272
    //   260: aload_0
    //   261: invokevirtual close : ()V
    //   264: goto -> 272
    //   267: astore_0
    //   268: aload_0
    //   269: invokevirtual printStackTrace : ()V
    //   272: aload #5
    //   274: athrow
    //   275: iload_2
    //   276: bipush #16
    //   278: if_icmpge -> 180
    //   281: aload #8
    //   283: iload_2
    //   284: baload
    //   285: istore_3
    //   286: iload_1
    //   287: iconst_1
    //   288: iadd
    //   289: istore #4
    //   291: aload #7
    //   293: iload_1
    //   294: aload #6
    //   296: iload_3
    //   297: iconst_4
    //   298: iushr
    //   299: bipush #15
    //   301: iand
    //   302: caload
    //   303: castore
    //   304: iload #4
    //   306: iconst_1
    //   307: iadd
    //   308: istore_1
    //   309: aload #7
    //   311: iload #4
    //   313: aload #6
    //   315: iload_3
    //   316: bipush #15
    //   318: iand
    //   319: caload
    //   320: castore
    //   321: iload_2
    //   322: iconst_1
    //   323: iadd
    //   324: istore_2
    //   325: goto -> 275
    // Exception table:
    //   from	to	target	type
    //   105	122	222	java/lang/Throwable
    //   105	122	215	finally
    //   125	132	210	java/lang/Throwable
    //   125	132	254	finally
    //   135	143	210	java/lang/Throwable
    //   135	143	254	finally
    //   153	162	210	java/lang/Throwable
    //   153	162	254	finally
    //   168	175	210	java/lang/Throwable
    //   168	175	254	finally
    //   183	194	210	java/lang/Throwable
    //   183	194	254	finally
    //   194	199	202	java/lang/Throwable
    //   230	235	254	finally
    //   240	245	247	java/lang/Throwable
    //   260	264	267	java/lang/Throwable
  }
  
  private static void a(Context paramContext, int paramInt, StringBuilder paramStringBuilder) {
    try {
      paramContext = paramContext.getApplicationContext();
      int i = Integer.parseInt("044800");
      a.a(paramContext).a(paramInt, paramStringBuilder.toString(), i);
      c c = c.a(paramContext);
      c.a(System.currentTimeMillis());
      c.c(i);
      c.o();
      return;
    } catch (Throwable throwable) {
      paramStringBuilder = new StringBuilder();
      paramStringBuilder.append("report load error exception: ");
      paramStringBuilder.append(throwable);
      g.c("TbsPrecheck", paramStringBuilder.toString());
      return;
    } 
  }
  
  private static void a(Context paramContext, String paramString, StringBuilder paramStringBuilder, int paramInt) {
    c c = c.a(paramContext);
    long l = c.f();
    int i = c.e();
    if (paramInt > 0) {
      TbsCrashHandler.a(paramContext, String.valueOf(i));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("clearTbsCoreDisabled for odex_failure_cnt:");
      stringBuilder.append(paramInt);
      stringBuilder.append(";");
      paramStringBuilder.append(stringBuilder.toString());
    } 
    paramStringBuilder.append("lastDisableTime:");
    paramStringBuilder.append(l);
    paramStringBuilder.append(";");
    paramStringBuilder.append("lastDisableCoreVersion:");
    paramStringBuilder.append(i);
    paramStringBuilder.append(";");
    String str1 = a(paramContext);
    String str2 = b(paramContext);
    if (str2 != null) {
      paramStringBuilder.append(str2);
      paramStringBuilder.append(str1);
      paramInt = 1200;
    } else {
      paramStringBuilder.append(str1);
      paramInt = 1100;
    } 
    a(paramContext, paramInt, paramStringBuilder);
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("TbsPreckeck -- startTbsCheckTask -- msg: ");
    stringBuilder.append(paramString2);
    stringBuilder.append("; isTbsCheckReport: ");
    stringBuilder.append(paramBoolean);
    stringBuilder.toString();
    (new Thread(new Runnable(paramContext, paramString1, paramBoolean, paramString2) {
          public void run() {
            try {
              Thread.sleep(2000L);
            } catch (InterruptedException interruptedException) {
              interruptedException.printStackTrace();
            } 
            if (a.a)
              return; 
            a.a = true;
            a.b(this.a, this.b, this.c, this.d);
          }
        })).start();
  }
  
  public static void a(Context paramContext, boolean paramBoolean) {
    if (!paramBoolean) {
      c c = c.a(paramContext);
      int i = c.r();
      if (i < 3) {
        c.e(i + 1);
        c.o();
        return;
      } 
    } 
    try {
      File file = new File(new File(TbsSDKExtension.getTbsFolderDir(paramContext), "core_private"), "self_maps_at_crash");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("exception_info -- file: ");
      stringBuilder.append(file.getAbsolutePath());
      stringBuilder.toString();
      file.delete();
      return;
    } catch (Throwable throwable) {
      throwable.printStackTrace();
      return;
    } 
  }
  
  public static void a(File paramFile, boolean paramBoolean) {
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
        a(arrayOfFile[i], paramBoolean); 
      if (!paramBoolean)
        paramFile.delete(); 
    } 
  }
  
  public static String b(Context paramContext) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #5
    //   3: aconst_null
    //   4: astore #4
    //   6: new java/io/File
    //   9: dup
    //   10: new java/io/File
    //   13: dup
    //   14: aload_0
    //   15: invokestatic getTbsFolderDir : (Landroid/content/Context;)Ljava/io/File;
    //   18: ldc_w 'core_private'
    //   21: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   24: ldc_w 'self_maps_at_crash'
    //   27: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   30: astore_0
    //   31: new java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial <init> : ()V
    //   38: astore_3
    //   39: aload_3
    //   40: ldc_w 'exception_info -- file: '
    //   43: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_3
    //   48: aload_0
    //   49: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   52: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_3
    //   57: invokevirtual toString : ()Ljava/lang/String;
    //   60: pop
    //   61: goto -> 75
    //   64: astore_3
    //   65: goto -> 71
    //   68: astore_3
    //   69: aconst_null
    //   70: astore_0
    //   71: aload_3
    //   72: invokevirtual printStackTrace : ()V
    //   75: aload_0
    //   76: ifnull -> 248
    //   79: aload_0
    //   80: invokevirtual exists : ()Z
    //   83: ifne -> 88
    //   86: aconst_null
    //   87: areturn
    //   88: new java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial <init> : ()V
    //   95: astore_3
    //   96: new java/io/BufferedReader
    //   99: dup
    //   100: new java/io/FileReader
    //   103: dup
    //   104: aload_0
    //   105: invokespecial <init> : (Ljava/io/File;)V
    //   108: invokespecial <init> : (Ljava/io/Reader;)V
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual readLine : ()Ljava/lang/String;
    //   116: astore #4
    //   118: aload #4
    //   120: ifnull -> 140
    //   123: aload_3
    //   124: aload #4
    //   126: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_3
    //   131: bipush #10
    //   133: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: goto -> 112
    //   140: aload_0
    //   141: invokevirtual close : ()V
    //   144: goto -> 185
    //   147: goto -> 185
    //   150: astore #4
    //   152: aload_0
    //   153: astore_3
    //   154: aload #4
    //   156: astore_0
    //   157: goto -> 167
    //   160: goto -> 177
    //   163: astore_0
    //   164: aload #4
    //   166: astore_3
    //   167: aload_3
    //   168: ifnull -> 175
    //   171: aload_3
    //   172: invokevirtual close : ()V
    //   175: aload_0
    //   176: athrow
    //   177: aload_0
    //   178: ifnull -> 185
    //   181: aload_0
    //   182: invokevirtual close : ()V
    //   185: aload_3
    //   186: invokevirtual toString : ()Ljava/lang/String;
    //   189: astore_0
    //   190: new java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial <init> : ()V
    //   197: astore_3
    //   198: aload_3
    //   199: ldc_w 'exception_info: '
    //   202: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_3
    //   207: aload_0
    //   208: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload_3
    //   213: invokevirtual toString : ()Ljava/lang/String;
    //   216: pop
    //   217: aload_0
    //   218: invokevirtual length : ()I
    //   221: istore_2
    //   222: ldc_w 1048576
    //   225: istore_1
    //   226: iload_2
    //   227: ldc_w 1048576
    //   230: if_icmple -> 236
    //   233: goto -> 241
    //   236: aload_0
    //   237: invokevirtual length : ()I
    //   240: istore_1
    //   241: aload_0
    //   242: iconst_0
    //   243: iload_1
    //   244: invokevirtual substring : (II)Ljava/lang/String;
    //   247: areturn
    //   248: aconst_null
    //   249: areturn
    //   250: astore_0
    //   251: aload #5
    //   253: astore_0
    //   254: goto -> 177
    //   257: astore #4
    //   259: goto -> 160
    //   262: astore_0
    //   263: goto -> 147
    //   266: astore_3
    //   267: goto -> 175
    // Exception table:
    //   from	to	target	type
    //   6	31	68	java/lang/Throwable
    //   31	61	64	java/lang/Throwable
    //   96	112	250	java/io/IOException
    //   96	112	163	finally
    //   112	118	257	java/io/IOException
    //   112	118	150	finally
    //   123	137	257	java/io/IOException
    //   123	137	150	finally
    //   140	144	262	java/lang/Exception
    //   171	175	266	java/lang/Exception
    //   181	185	262	java/lang/Exception
  }
  
  private static boolean b(File paramFile) {
    try {
      boolean bool = b.b(paramFile);
      if (!bool)
        return true; 
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
    return false;
  }
  
  public static void c(Context paramContext) {
    try {
      SharedPreferences sharedPreferences;
      if (Build.VERSION.SDK_INT >= 11) {
        sharedPreferences = paramContext.getSharedPreferences("tbs_extension_config", 4);
      } else {
        sharedPreferences = paramContext.getSharedPreferences("tbs_extension_config", 0);
      } 
      sharedPreferences.edit().clear().commit();
      if (Build.VERSION.SDK_INT >= 11) {
        sharedPreferences = paramContext.getSharedPreferences("tbs_download_config", 4);
      } else {
        sharedPreferences = paramContext.getSharedPreferences("tbs_download_config", 0);
      } 
      sharedPreferences.edit().clear().commit();
      a(TbsSDKExtension.getTbsFolderDir(paramContext), false);
      return;
    } catch (Throwable throwable) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("reset exception:");
      stringBuilder.append(Log.getStackTraceString(throwable));
      Log.e("TbsPrecheck", stringBuilder.toString());
      return;
    } 
  }
  
  private static void c(Context paramContext, String paramString1, boolean paramBoolean, String paramString2) {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #10
    //   9: aload #10
    //   11: ldc_w 'TbsPreckeck -- preloadX5CheckTask -- going to check & report...  msg: '
    //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload #10
    //   20: aload_3
    //   21: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload #10
    //   27: invokevirtual toString : ()Ljava/lang/String;
    //   30: pop
    //   31: new java/io/File
    //   34: dup
    //   35: aload_1
    //   36: invokespecial <init> : (Ljava/lang/String;)V
    //   39: astore #14
    //   41: aconst_null
    //   42: astore #13
    //   44: aconst_null
    //   45: astore #12
    //   47: aconst_null
    //   48: astore #10
    //   50: aload #13
    //   52: astore_3
    //   53: new java/io/File
    //   56: dup
    //   57: aload #14
    //   59: getstatic com/tencent/tbs/sdk/extension/partner/a.b : Ljava/lang/String;
    //   62: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   65: astore #15
    //   67: aload #13
    //   69: astore_3
    //   70: new java/util/Properties
    //   73: dup
    //   74: invokespecial <init> : ()V
    //   77: astore #11
    //   79: aload #13
    //   81: astore_3
    //   82: aload #15
    //   84: invokevirtual exists : ()Z
    //   87: ifeq -> 142
    //   90: aload #13
    //   92: astore_3
    //   93: new java/io/BufferedInputStream
    //   96: dup
    //   97: new java/io/FileInputStream
    //   100: dup
    //   101: aload #15
    //   103: invokespecial <init> : (Ljava/io/File;)V
    //   106: invokespecial <init> : (Ljava/io/InputStream;)V
    //   109: astore #10
    //   111: aload #11
    //   113: aload #10
    //   115: invokevirtual load : (Ljava/io/InputStream;)V
    //   118: iconst_1
    //   119: istore #4
    //   121: goto -> 145
    //   124: astore_0
    //   125: aload #10
    //   127: astore_3
    //   128: goto -> 832
    //   131: astore_3
    //   132: aload #10
    //   134: astore #12
    //   136: aload_3
    //   137: astore #10
    //   139: goto -> 201
    //   142: iconst_0
    //   143: istore #4
    //   145: aload #11
    //   147: astore_3
    //   148: iload #4
    //   150: istore #5
    //   152: aload #10
    //   154: ifnull -> 230
    //   157: aload #10
    //   159: invokevirtual close : ()V
    //   162: aload #11
    //   164: astore_3
    //   165: iload #4
    //   167: istore #5
    //   169: goto -> 230
    //   172: astore_3
    //   173: aload_3
    //   174: invokevirtual printStackTrace : ()V
    //   177: aload #11
    //   179: astore_3
    //   180: iload #4
    //   182: istore #5
    //   184: goto -> 230
    //   187: astore #10
    //   189: goto -> 201
    //   192: astore_0
    //   193: goto -> 832
    //   196: astore #10
    //   198: aconst_null
    //   199: astore #11
    //   201: aload #12
    //   203: astore_3
    //   204: aload #10
    //   206: invokevirtual printStackTrace : ()V
    //   209: aload #12
    //   211: ifnull -> 862
    //   214: aload #12
    //   216: invokevirtual close : ()V
    //   219: goto -> 862
    //   222: astore_3
    //   223: aload_3
    //   224: invokevirtual printStackTrace : ()V
    //   227: goto -> 862
    //   230: aload #14
    //   232: invokevirtual listFiles : ()[Ljava/io/File;
    //   235: astore #12
    //   237: new java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial <init> : ()V
    //   244: astore #11
    //   246: iconst_0
    //   247: istore #7
    //   249: iconst_0
    //   250: istore #4
    //   252: iconst_0
    //   253: istore #6
    //   255: iload #7
    //   257: aload #12
    //   259: arraylength
    //   260: if_icmpge -> 760
    //   263: aload #12
    //   265: iload #7
    //   267: aaload
    //   268: invokevirtual getName : ()Ljava/lang/String;
    //   271: astore #10
    //   273: new java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial <init> : ()V
    //   280: astore #13
    //   282: aload #13
    //   284: ldc_w 'TbsPreckeck -- preloadX5CheckTask -- filename('
    //   287: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload #13
    //   293: aload #10
    //   295: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload #13
    //   301: ldc_w ')'
    //   304: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload #13
    //   310: invokevirtual toString : ()Ljava/lang/String;
    //   313: pop
    //   314: aload #10
    //   316: ldc_w '.dex'
    //   319: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   322: ifeq -> 490
    //   325: aload #10
    //   327: ldc_w 'tbs_jars_fusion_dex.dex'
    //   330: invokevirtual equals : (Ljava/lang/Object;)Z
    //   333: ifne -> 366
    //   336: aload #10
    //   338: ldc_w 'webview_dex.dex'
    //   341: invokevirtual equals : (Ljava/lang/Object;)Z
    //   344: ifne -> 366
    //   347: iload #4
    //   349: istore #8
    //   351: iload #6
    //   353: istore #9
    //   355: aload #10
    //   357: ldc_w 'tbs_sdk_extension_dex.dex'
    //   360: invokevirtual equals : (Ljava/lang/Object;)Z
    //   363: ifeq -> 897
    //   366: aload #11
    //   368: aload #10
    //   370: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload #11
    //   376: ldc_w '='
    //   379: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload #11
    //   385: aload #12
    //   387: iload #7
    //   389: aaload
    //   390: invokestatic a : (Ljava/io/File;)Ljava/lang/String;
    //   393: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload #11
    //   399: ldc_w ','
    //   402: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload #11
    //   408: aload #12
    //   410: iload #7
    //   412: aaload
    //   413: invokevirtual length : ()J
    //   416: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload #11
    //   422: ldc_w 'B,'
    //   425: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload #12
    //   431: iload #7
    //   433: aaload
    //   434: invokestatic b : (Ljava/io/File;)Z
    //   437: ifeq -> 871
    //   440: iload #6
    //   442: iconst_1
    //   443: iadd
    //   444: istore #9
    //   446: aload #11
    //   448: ldc_w 'broken;'
    //   451: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: pop
    //   455: aload #12
    //   457: iload #7
    //   459: aaload
    //   460: iconst_0
    //   461: invokestatic a : (Ljava/io/File;Z)V
    //   464: iload #4
    //   466: istore #8
    //   468: goto -> 897
    //   471: aload #11
    //   473: aload #10
    //   475: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: iload #4
    //   481: istore #8
    //   483: iload #6
    //   485: istore #9
    //   487: goto -> 897
    //   490: aload #10
    //   492: ldc_w '.jar'
    //   495: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   498: ifne -> 555
    //   501: aload #10
    //   503: ldc_w '.so'
    //   506: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   509: ifne -> 555
    //   512: new java/lang/StringBuilder
    //   515: dup
    //   516: invokespecial <init> : ()V
    //   519: astore #13
    //   521: aload #13
    //   523: ldc_w 'TbsPreckeck -- preloadX5CheckTask -- skip '
    //   526: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload #13
    //   532: aload #10
    //   534: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: aload #13
    //   540: invokevirtual toString : ()Ljava/lang/String;
    //   543: pop
    //   544: iload #4
    //   546: istore #8
    //   548: iload #6
    //   550: istore #9
    //   552: goto -> 897
    //   555: aload #12
    //   557: iload #7
    //   559: aaload
    //   560: invokestatic a : (Ljava/io/File;)Ljava/lang/String;
    //   563: astore #13
    //   565: iload #5
    //   567: ifeq -> 892
    //   570: aload_3
    //   571: aload #10
    //   573: ldc ''
    //   575: invokevirtual getProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   578: astore #14
    //   580: new java/lang/StringBuilder
    //   583: dup
    //   584: invokespecial <init> : ()V
    //   587: astore #15
    //   589: aload #15
    //   591: ldc_w 'TbsPreckeck -- preloadX5CheckTask -- md5 for '
    //   594: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: pop
    //   598: aload #15
    //   600: aload #10
    //   602: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: pop
    //   606: aload #15
    //   608: ldc_w ' ('
    //   611: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: aload #15
    //   617: aload #14
    //   619: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: pop
    //   623: aload #15
    //   625: ldc_w ')'
    //   628: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: pop
    //   632: aload #15
    //   634: invokevirtual toString : ()Ljava/lang/String;
    //   637: pop
    //   638: aload #14
    //   640: ldc ''
    //   642: invokevirtual equals : (Ljava/lang/Object;)Z
    //   645: ifne -> 879
    //   648: aload #14
    //   650: aload #13
    //   652: invokevirtual equals : (Ljava/lang/Object;)Z
    //   655: ifne -> 892
    //   658: goto -> 879
    //   661: new java/lang/StringBuilder
    //   664: dup
    //   665: invokespecial <init> : ()V
    //   668: astore #14
    //   670: aload #14
    //   672: ldc_w 'TbsPreckeck -- preloadX5CheckTask -- md5_check_success('
    //   675: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: pop
    //   679: aload #14
    //   681: iload_2
    //   682: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   685: pop
    //   686: aload #14
    //   688: ldc_w ')'
    //   691: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: pop
    //   695: aload #14
    //   697: invokevirtual toString : ()Ljava/lang/String;
    //   700: pop
    //   701: iload #4
    //   703: istore #8
    //   705: iload #6
    //   707: istore #9
    //   709: iload_2
    //   710: ifne -> 897
    //   713: iload #4
    //   715: iconst_1
    //   716: iadd
    //   717: istore #4
    //   719: aload #11
    //   721: ldc_w 'broken:'
    //   724: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: pop
    //   728: aload #11
    //   730: aload #10
    //   732: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: pop
    //   736: aload #11
    //   738: ldc_w ','
    //   741: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: pop
    //   745: aload #11
    //   747: aload #13
    //   749: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: pop
    //   753: ldc ';'
    //   755: astore #10
    //   757: goto -> 471
    //   760: iload #4
    //   762: ifle -> 822
    //   765: new java/lang/StringBuilder
    //   768: dup
    //   769: invokespecial <init> : ()V
    //   772: astore_3
    //   773: aload_3
    //   774: ldc_w 'TbsPreckeck -- preloadX5CheckTask -- check_failure: '
    //   777: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: pop
    //   781: aload_3
    //   782: iload #4
    //   784: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   787: pop
    //   788: aload_3
    //   789: invokevirtual toString : ()Ljava/lang/String;
    //   792: pop
    //   793: aload #11
    //   795: ldc_w 'failure_cnt:'
    //   798: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: pop
    //   802: aload #11
    //   804: iload #4
    //   806: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   809: pop
    //   810: aload #11
    //   812: ldc ';'
    //   814: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: pop
    //   818: aload_0
    //   819: invokestatic c : (Landroid/content/Context;)V
    //   822: aload_0
    //   823: aload_1
    //   824: aload #11
    //   826: iload #6
    //   828: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/StringBuilder;I)V
    //   831: return
    //   832: aload_3
    //   833: ifnull -> 848
    //   836: aload_3
    //   837: invokevirtual close : ()V
    //   840: goto -> 848
    //   843: astore_1
    //   844: aload_1
    //   845: invokevirtual printStackTrace : ()V
    //   848: aload_0
    //   849: athrow
    //   850: astore_0
    //   851: goto -> 860
    //   854: astore_0
    //   855: aload_0
    //   856: invokevirtual printStackTrace : ()V
    //   859: return
    //   860: aload_0
    //   861: athrow
    //   862: iconst_1
    //   863: istore #5
    //   865: aload #11
    //   867: astore_3
    //   868: goto -> 230
    //   871: ldc_w 'normal;'
    //   874: astore #10
    //   876: goto -> 471
    //   879: aload #13
    //   881: ifnonnull -> 887
    //   884: goto -> 892
    //   887: iconst_0
    //   888: istore_2
    //   889: goto -> 661
    //   892: iconst_1
    //   893: istore_2
    //   894: goto -> 661
    //   897: iload #7
    //   899: iconst_1
    //   900: iadd
    //   901: istore #7
    //   903: iload #8
    //   905: istore #4
    //   907: iload #9
    //   909: istore #6
    //   911: goto -> 255
    // Exception table:
    //   from	to	target	type
    //   0	41	854	java/lang/Throwable
    //   0	41	850	finally
    //   53	67	196	java/lang/Exception
    //   53	67	192	finally
    //   70	79	196	java/lang/Exception
    //   70	79	192	finally
    //   82	90	187	java/lang/Exception
    //   82	90	192	finally
    //   93	111	187	java/lang/Exception
    //   93	111	192	finally
    //   111	118	131	java/lang/Exception
    //   111	118	124	finally
    //   157	162	172	java/lang/Throwable
    //   157	162	850	finally
    //   173	177	854	java/lang/Throwable
    //   173	177	850	finally
    //   204	209	192	finally
    //   214	219	222	java/lang/Throwable
    //   214	219	850	finally
    //   223	227	854	java/lang/Throwable
    //   223	227	850	finally
    //   230	246	854	java/lang/Throwable
    //   230	246	850	finally
    //   255	347	854	java/lang/Throwable
    //   255	347	850	finally
    //   355	366	854	java/lang/Throwable
    //   355	366	850	finally
    //   366	440	854	java/lang/Throwable
    //   366	440	850	finally
    //   446	464	854	java/lang/Throwable
    //   446	464	850	finally
    //   471	479	854	java/lang/Throwable
    //   471	479	850	finally
    //   490	544	854	java/lang/Throwable
    //   490	544	850	finally
    //   555	565	854	java/lang/Throwable
    //   555	565	850	finally
    //   570	658	854	java/lang/Throwable
    //   570	658	850	finally
    //   661	701	854	java/lang/Throwable
    //   661	701	850	finally
    //   719	753	854	java/lang/Throwable
    //   719	753	850	finally
    //   765	822	854	java/lang/Throwable
    //   765	822	850	finally
    //   822	831	854	java/lang/Throwable
    //   822	831	850	finally
    //   836	840	843	java/lang/Throwable
    //   836	840	850	finally
    //   844	848	854	java/lang/Throwable
    //   844	848	850	finally
    //   848	850	854	java/lang/Throwable
    //   848	850	850	finally
    //   855	859	850	finally
  }
  
  private static File d(Context paramContext) {
    File file = new File(TbsSDKExtension.getTbsFolderDir(paramContext), "crash_record");
    if (!file.exists())
      file.mkdir(); 
    return file;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */