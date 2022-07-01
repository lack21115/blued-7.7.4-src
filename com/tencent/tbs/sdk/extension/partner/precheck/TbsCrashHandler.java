package com.tencent.tbs.sdk.extension.partner.precheck;

import android.content.Context;
import android.util.Log;
import com.tencent.tbs.sdk.extension.TbsSDKExtension;
import com.tencent.tbs.sdk.extension.partner.a;
import java.io.File;

public class TbsCrashHandler implements Thread.UncaughtExceptionHandler {
  private static String a;
  
  private static TbsCrashHandler b;
  
  private static Thread.UncaughtExceptionHandler c;
  
  private static boolean f = false;
  
  private Context d = null;
  
  private String e = "0";
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private TbsCrashHandler(Context paramContext, String paramString) {
    this.d = paramContext;
    this.e = paramString;
  }
  
  public static TbsCrashHandler a(Context paramContext, String paramString1, String paramString2) {
    // Byte code:
    //   0: ldc com/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler
    //   2: monitorenter
    //   3: getstatic com/tencent/tbs/sdk/extension/TbsSDKExtension.mNotLoadSo : Ljava/lang/String;
    //   6: ifnull -> 27
    //   9: ldc 'notLoadSo'
    //   11: getstatic com/tencent/tbs/sdk/extension/TbsSDKExtension.mNotLoadSo : Ljava/lang/String;
    //   14: invokevirtual equals : (Ljava/lang/Object;)Z
    //   17: istore_3
    //   18: iload_3
    //   19: ifeq -> 27
    //   22: ldc com/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler
    //   24: monitorexit
    //   25: aconst_null
    //   26: areturn
    //   27: getstatic com/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler.f : Z
    //   30: ifne -> 482
    //   33: new java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial <init> : ()V
    //   40: astore #5
    //   42: aload #5
    //   44: ldc 'initializing, context: '
    //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload #5
    //   52: aload_0
    //   53: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   56: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload #5
    //   62: invokevirtual toString : ()Ljava/lang/String;
    //   65: pop
    //   66: iconst_1
    //   67: putstatic com/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler.f : Z
    //   70: getstatic com/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler.b : Lcom/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler;
    //   73: ifnonnull -> 91
    //   76: new com/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler
    //   79: dup
    //   80: aload_0
    //   81: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   84: aload_2
    //   85: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;)V
    //   88: putstatic com/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler.b : Lcom/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler;
    //   91: invokestatic getDefaultUncaughtExceptionHandler : ()Ljava/lang/Thread$UncaughtExceptionHandler;
    //   94: putstatic com/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler.c : Ljava/lang/Thread$UncaughtExceptionHandler;
    //   97: getstatic com/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler.b : Lcom/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler;
    //   100: invokestatic setDefaultUncaughtExceptionHandler : (Ljava/lang/Thread$UncaughtExceptionHandler;)V
    //   103: new java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial <init> : ()V
    //   110: astore #5
    //   112: aload #5
    //   114: ldc 'after set: '
    //   116: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload #5
    //   122: getstatic com/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler.b : Lcom/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler;
    //   125: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload #5
    //   131: invokevirtual toString : ()Ljava/lang/String;
    //   134: pop
    //   135: new java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial <init> : ()V
    //   142: astore #5
    //   144: aload #5
    //   146: aload_1
    //   147: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload #5
    //   153: getstatic java/io/File.separator : Ljava/lang/String;
    //   156: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload #5
    //   162: ldc 'libtbs_crash_handler.so'
    //   164: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload #5
    //   170: invokevirtual toString : ()Ljava/lang/String;
    //   173: invokestatic load : (Ljava/lang/String;)V
    //   176: getstatic com/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler.b : Lcom/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler;
    //   179: astore #5
    //   181: aload_0
    //   182: invokestatic a : (Landroid/content/Context;)Ljava/io/File;
    //   185: astore #5
    //   187: aload #5
    //   189: instanceof java/io/File
    //   192: ifeq -> 238
    //   195: iconst_0
    //   196: istore_3
    //   197: ldc 'com.tencent.mobileqq'
    //   199: aload_0
    //   200: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   203: invokevirtual getApplicationInfo : ()Landroid/content/pm/ApplicationInfo;
    //   206: getfield packageName : Ljava/lang/String;
    //   209: invokevirtual equals : (Ljava/lang/Object;)Z
    //   212: istore #4
    //   214: iload #4
    //   216: istore_3
    //   217: goto -> 225
    //   220: astore_0
    //   221: aload_0
    //   222: invokevirtual printStackTrace : ()V
    //   225: getstatic com/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler.b : Lcom/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler;
    //   228: aload #5
    //   230: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   233: aload_2
    //   234: iload_3
    //   235: invokevirtual nativeSetCrashRecordDir : (Ljava/lang/String;Ljava/lang/String;Z)V
    //   238: getstatic com/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler.b : Lcom/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler;
    //   241: invokevirtual nativeGetHandlerInfo : ()Ljava/lang/String;
    //   244: putstatic com/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler.a : Ljava/lang/String;
    //   247: goto -> 482
    //   250: astore_2
    //   251: new java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial <init> : ()V
    //   258: astore_0
    //   259: aload_0
    //   260: ldc 'getInstance exception: '
    //   262: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload_0
    //   267: aload_2
    //   268: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: ldc 'CrashHandler'
    //   274: aload_0
    //   275: invokevirtual toString : ()Ljava/lang/String;
    //   278: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   281: pop
    //   282: getstatic com/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler.c : Ljava/lang/Thread$UncaughtExceptionHandler;
    //   285: ifnull -> 294
    //   288: getstatic com/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler.c : Ljava/lang/Thread$UncaughtExceptionHandler;
    //   291: invokestatic setDefaultUncaughtExceptionHandler : (Ljava/lang/Thread$UncaughtExceptionHandler;)V
    //   294: new java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial <init> : ()V
    //   301: astore_0
    //   302: aload_0
    //   303: aload_1
    //   304: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload_0
    //   309: getstatic java/io/File.separator : Ljava/lang/String;
    //   312: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload_0
    //   317: ldc 'libtbs_crash_handler.so'
    //   319: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: new java/io/File
    //   326: dup
    //   327: aload_0
    //   328: invokevirtual toString : ()Ljava/lang/String;
    //   331: invokespecial <init> : (Ljava/lang/String;)V
    //   334: astore #5
    //   336: new java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial <init> : ()V
    //   343: astore_0
    //   344: aload_0
    //   345: aload_1
    //   346: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload_0
    //   351: getstatic java/io/File.separator : Ljava/lang/String;
    //   354: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload_0
    //   359: ldc 'libmttwebview.so'
    //   361: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: pop
    //   365: new java/io/File
    //   368: dup
    //   369: aload_0
    //   370: invokevirtual toString : ()Ljava/lang/String;
    //   373: invokespecial <init> : (Ljava/lang/String;)V
    //   376: astore_1
    //   377: ldc ''
    //   379: astore_0
    //   380: aload_1
    //   381: invokevirtual exists : ()Z
    //   384: ifeq -> 437
    //   387: new java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial <init> : ()V
    //   394: astore_0
    //   395: aload_0
    //   396: ldc 'webview_so('
    //   398: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload_0
    //   403: aload_1
    //   404: invokevirtual length : ()J
    //   407: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload_0
    //   412: ldc ', '
    //   414: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload_0
    //   419: ldc 12345678
    //   421: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload_0
    //   426: ldc ')'
    //   428: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload_0
    //   433: invokevirtual toString : ()Ljava/lang/String;
    //   436: astore_0
    //   437: aload #5
    //   439: invokevirtual exists : ()Z
    //   442: ifeq -> 448
    //   445: goto -> 482
    //   448: new java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial <init> : ()V
    //   455: astore_1
    //   456: aload_1
    //   457: ldc 'libtbs_crash_handler.so not found; '
    //   459: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: aload_1
    //   464: aload_0
    //   465: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: new com/tencent/tbs/sdk/extension/f
    //   472: dup
    //   473: aload_1
    //   474: invokevirtual toString : ()Ljava/lang/String;
    //   477: aload_2
    //   478: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   481: athrow
    //   482: getstatic com/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler.b : Lcom/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler;
    //   485: astore_0
    //   486: ldc com/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler
    //   488: monitorexit
    //   489: aload_0
    //   490: areturn
    //   491: astore_0
    //   492: ldc com/tencent/tbs/sdk/extension/partner/precheck/TbsCrashHandler
    //   494: monitorexit
    //   495: aload_0
    //   496: athrow
    // Exception table:
    //   from	to	target	type
    //   3	18	491	finally
    //   27	66	491	finally
    //   66	91	250	java/lang/Throwable
    //   66	91	491	finally
    //   91	195	250	java/lang/Throwable
    //   91	195	491	finally
    //   197	214	220	java/lang/Exception
    //   197	214	250	java/lang/Throwable
    //   197	214	491	finally
    //   221	225	250	java/lang/Throwable
    //   221	225	491	finally
    //   225	238	250	java/lang/Throwable
    //   225	238	491	finally
    //   238	247	250	java/lang/Throwable
    //   238	247	491	finally
    //   251	294	491	finally
    //   294	377	491	finally
    //   380	437	491	finally
    //   437	445	491	finally
    //   448	482	491	finally
    //   482	486	491	finally
  }
  
  private File a() {
    File file = a(this.d);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("tbs_crash_report_");
    stringBuilder.append(this.e);
    return new File(file, stringBuilder.toString());
  }
  
  private static File a(Context paramContext) {
    File file = new File(TbsSDKExtension.getTbsFolderDir(paramContext), "crash_record");
    if (!file.exists())
      file.mkdir(); 
    return file;
  }
  
  public static boolean a(Context paramContext, String paramString) {
    boolean bool1;
    File file1 = a(paramContext);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("tbs_crash_disable_");
    stringBuilder.append(paramString);
    File file2 = new File(file1, stringBuilder.toString());
    if (file2.exists()) {
      bool1 = file2.delete();
    } else {
      bool1 = false;
    } 
    file1 = new File(file1, "crash_count");
    boolean bool2 = bool1;
    if (file1.exists()) {
      if (bool1 && file1.delete())
        return true; 
      bool2 = false;
    } 
    return bool2;
  }
  
  private boolean a(String paramString) {
    return paramString.contains("java.lang.UnsatisfiedLinkError") ? b() : false;
  }
  
  private boolean b() {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    try {
      File file = a();
      boolean bool = bool2;
      if (file != null) {
        bool = bool2;
        bool1 = bool3;
        if (!file.exists()) {
          bool1 = bool3;
          bool = file.createNewFile();
        } 
      } 
      bool1 = bool;
      f();
      return bool;
    } catch (Throwable throwable) {
      throwable.printStackTrace();
      return bool1;
    } 
  }
  
  private boolean c() {
    File file = a();
    return (file != null && file.exists()) ? file.delete() : false;
  }
  
  private boolean d() {
    File file = a();
    return (file != null && file.exists());
  }
  
  private File e() {
    return new File(TbsSDKExtension.getTbsFolderDir(this.d), "core_private");
  }
  
  private boolean f() {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #5
    //   9: aconst_null
    //   10: astore_2
    //   11: aconst_null
    //   12: astore_3
    //   13: aconst_null
    //   14: astore #4
    //   16: new java/io/BufferedReader
    //   19: dup
    //   20: new java/io/FileReader
    //   23: dup
    //   24: new java/io/File
    //   27: dup
    //   28: ldc '/proc/self/maps'
    //   30: invokespecial <init> : (Ljava/lang/String;)V
    //   33: invokespecial <init> : (Ljava/io/File;)V
    //   36: invokespecial <init> : (Ljava/io/Reader;)V
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual readLine : ()Ljava/lang/String;
    //   44: astore #4
    //   46: aload #4
    //   48: ifnull -> 70
    //   51: aload #5
    //   53: aload #4
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload #5
    //   61: bipush #10
    //   63: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: goto -> 40
    //   70: aload_1
    //   71: invokevirtual close : ()V
    //   74: goto -> 125
    //   77: astore_3
    //   78: aload_1
    //   79: astore_2
    //   80: aload_3
    //   81: astore_1
    //   82: goto -> 89
    //   85: astore_1
    //   86: aload #4
    //   88: astore_2
    //   89: aload_2
    //   90: ifnull -> 105
    //   93: aload_2
    //   94: invokevirtual close : ()V
    //   97: goto -> 105
    //   100: astore_2
    //   101: aload_2
    //   102: invokevirtual printStackTrace : ()V
    //   105: aload_1
    //   106: athrow
    //   107: aconst_null
    //   108: astore_1
    //   109: aload_1
    //   110: ifnull -> 125
    //   113: aload_1
    //   114: invokevirtual close : ()V
    //   117: goto -> 125
    //   120: astore_1
    //   121: aload_1
    //   122: invokevirtual printStackTrace : ()V
    //   125: new java/io/File
    //   128: dup
    //   129: aload_0
    //   130: invokespecial e : ()Ljava/io/File;
    //   133: ldc 'self_maps_at_crash'
    //   135: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   138: astore #4
    //   140: aload #4
    //   142: invokevirtual exists : ()Z
    //   145: ifeq -> 154
    //   148: aload #4
    //   150: invokevirtual delete : ()Z
    //   153: pop
    //   154: aload #4
    //   156: invokevirtual createNewFile : ()Z
    //   159: pop
    //   160: goto -> 168
    //   163: astore_1
    //   164: aload_1
    //   165: invokevirtual printStackTrace : ()V
    //   168: aload #5
    //   170: invokevirtual toString : ()Ljava/lang/String;
    //   173: astore #5
    //   175: new java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial <init> : ()V
    //   182: astore_1
    //   183: aload_1
    //   184: ldc 'self_maps: '
    //   186: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload_1
    //   191: aload #5
    //   193: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload_1
    //   198: invokevirtual toString : ()Ljava/lang/String;
    //   201: pop
    //   202: aload_2
    //   203: astore_1
    //   204: new java/io/FileOutputStream
    //   207: dup
    //   208: aload #4
    //   210: invokespecial <init> : (Ljava/io/File;)V
    //   213: astore_2
    //   214: aload_2
    //   215: aload #5
    //   217: invokevirtual getBytes : ()[B
    //   220: invokevirtual write : ([B)V
    //   223: aload_2
    //   224: invokevirtual close : ()V
    //   227: goto -> 273
    //   230: astore_3
    //   231: aload_2
    //   232: astore_1
    //   233: aload_3
    //   234: astore_2
    //   235: goto -> 275
    //   238: astore_3
    //   239: goto -> 251
    //   242: astore_2
    //   243: goto -> 275
    //   246: astore_1
    //   247: aload_3
    //   248: astore_2
    //   249: aload_1
    //   250: astore_3
    //   251: aload_2
    //   252: astore_1
    //   253: aload_3
    //   254: invokevirtual printStackTrace : ()V
    //   257: aload_2
    //   258: ifnull -> 273
    //   261: aload_2
    //   262: invokevirtual close : ()V
    //   265: goto -> 273
    //   268: astore_1
    //   269: aload_1
    //   270: invokevirtual printStackTrace : ()V
    //   273: iconst_1
    //   274: ireturn
    //   275: aload_1
    //   276: ifnull -> 291
    //   279: aload_1
    //   280: invokevirtual close : ()V
    //   283: goto -> 291
    //   286: astore_1
    //   287: aload_1
    //   288: invokevirtual printStackTrace : ()V
    //   291: aload_2
    //   292: athrow
    //   293: astore_1
    //   294: goto -> 107
    //   297: astore #4
    //   299: goto -> 109
    // Exception table:
    //   from	to	target	type
    //   16	40	293	java/io/IOException
    //   16	40	85	finally
    //   40	46	297	java/io/IOException
    //   40	46	77	finally
    //   51	67	297	java/io/IOException
    //   51	67	77	finally
    //   70	74	120	java/io/IOException
    //   93	97	100	java/io/IOException
    //   113	117	120	java/io/IOException
    //   140	154	163	java/lang/Throwable
    //   154	160	163	java/lang/Throwable
    //   204	214	246	java/lang/Throwable
    //   204	214	242	finally
    //   214	223	238	java/lang/Throwable
    //   214	223	230	finally
    //   223	227	268	java/io/IOException
    //   253	257	242	finally
    //   261	265	268	java/io/IOException
    //   279	283	286	java/io/IOException
  }
  
  public boolean b(Context paramContext, String paramString) {
    if (d()) {
      a.a(paramContext, paramString, false, "TBS_PRECHECK_REPORT_RESTORE");
      c();
      return true;
    } 
    return false;
  }
  
  public native String nativeGetHandlerInfo();
  
  public native void nativeRecordTbsCrash(String paramString);
  
  public native void nativeSetCrashRecordDir(String paramString1, String paramString2, boolean paramBoolean);
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
    String str = Log.getStackTraceString(paramThrowable);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("In thread: ");
    stringBuilder.append(paramThread);
    stringBuilder.append("\n");
    stringBuilder.append("UncaughtException detected: ");
    stringBuilder.append(str);
    Log.e("CrashHandler", stringBuilder.toString());
    if (!a(str))
      nativeRecordTbsCrash(str); 
    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = c;
    if (uncaughtExceptionHandler != null)
      uncaughtExceptionHandler.uncaughtException(paramThread, paramThrowable); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\precheck\TbsCrashHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */