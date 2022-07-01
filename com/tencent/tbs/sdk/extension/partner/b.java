package com.tencent.tbs.sdk.extension.partner;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.Log;
import com.tencent.tbs.sdk.extension.partner.c.d;
import com.tencent.tbs.sdk.extension.partner.c.g;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

public class b {
  private static b d;
  
  private Context a = null;
  
  private File b = null;
  
  private String c = "https://log.tbs.qq.com/ajax?c=ucfu&k=";
  
  private String e = "https://cfg.imtt.qq.com/tbs?v=2&mk=";
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  @TargetApi(11)
  private b(Context paramContext) {
    Log.w("TbsSDKExtensionCommonConfig", "TbsCommonConfig constructing...");
    this.a = paramContext.getApplicationContext();
    c();
  }
  
  public static b a(Context paramContext) {
    // Byte code:
    //   0: ldc com/tencent/tbs/sdk/extension/partner/b
    //   2: monitorenter
    //   3: getstatic com/tencent/tbs/sdk/extension/partner/b.d : Lcom/tencent/tbs/sdk/extension/partner/b;
    //   6: ifnonnull -> 20
    //   9: new com/tencent/tbs/sdk/extension/partner/b
    //   12: dup
    //   13: aload_0
    //   14: invokespecial <init> : (Landroid/content/Context;)V
    //   17: putstatic com/tencent/tbs/sdk/extension/partner/b.d : Lcom/tencent/tbs/sdk/extension/partner/b;
    //   20: getstatic com/tencent/tbs/sdk/extension/partner/b.d : Lcom/tencent/tbs/sdk/extension/partner/b;
    //   23: astore_0
    //   24: ldc com/tencent/tbs/sdk/extension/partner/b
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: astore_0
    //   30: ldc com/tencent/tbs/sdk/extension/partner/b
    //   32: monitorexit
    //   33: aload_0
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   3	20	29	finally
    //   20	24	29	finally
  }
  
  private void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial d : ()Ljava/io/File;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: new java/io/FileInputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial <init> : (Ljava/io/File;)V
    //   22: astore_2
    //   23: new java/io/BufferedInputStream
    //   26: dup
    //   27: aload_2
    //   28: invokespecial <init> : (Ljava/io/InputStream;)V
    //   31: astore_1
    //   32: aload_1
    //   33: astore_3
    //   34: aload_2
    //   35: astore #4
    //   37: new java/util/Properties
    //   40: dup
    //   41: invokespecial <init> : ()V
    //   44: astore #5
    //   46: aload_1
    //   47: astore_3
    //   48: aload_2
    //   49: astore #4
    //   51: aload #5
    //   53: aload_1
    //   54: invokevirtual load : (Ljava/io/InputStream;)V
    //   57: aload_1
    //   58: astore_3
    //   59: aload_2
    //   60: astore #4
    //   62: aload #5
    //   64: ldc 'tbs_downloader_post_url'
    //   66: ldc ''
    //   68: invokevirtual getProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   71: astore #6
    //   73: aload_1
    //   74: astore_3
    //   75: aload_2
    //   76: astore #4
    //   78: ldc ''
    //   80: aload #6
    //   82: invokevirtual equals : (Ljava/lang/Object;)Z
    //   85: ifne -> 99
    //   88: aload_1
    //   89: astore_3
    //   90: aload_2
    //   91: astore #4
    //   93: aload_0
    //   94: aload #6
    //   96: putfield e : Ljava/lang/String;
    //   99: aload_1
    //   100: astore_3
    //   101: aload_2
    //   102: astore #4
    //   104: aload #5
    //   106: ldc 'tbs_cmd_post_url'
    //   108: ldc ''
    //   110: invokevirtual getProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   113: astore #5
    //   115: aload_1
    //   116: astore_3
    //   117: aload_2
    //   118: astore #4
    //   120: ldc ''
    //   122: aload #5
    //   124: invokevirtual equals : (Ljava/lang/Object;)Z
    //   127: ifne -> 141
    //   130: aload_1
    //   131: astore_3
    //   132: aload_2
    //   133: astore #4
    //   135: aload_0
    //   136: aload #5
    //   138: putfield c : Ljava/lang/String;
    //   141: aload_1
    //   142: astore_3
    //   143: aload_2
    //   144: astore #4
    //   146: aload_1
    //   147: invokevirtual close : ()V
    //   150: aload_1
    //   151: invokevirtual close : ()V
    //   154: goto -> 162
    //   157: astore_1
    //   158: aload_1
    //   159: invokevirtual printStackTrace : ()V
    //   162: aload_2
    //   163: invokevirtual close : ()V
    //   166: goto -> 332
    //   169: astore_1
    //   170: aload_1
    //   171: invokevirtual printStackTrace : ()V
    //   174: goto -> 332
    //   177: astore #5
    //   179: goto -> 209
    //   182: astore_1
    //   183: aconst_null
    //   184: astore_3
    //   185: goto -> 339
    //   188: astore #5
    //   190: aconst_null
    //   191: astore_1
    //   192: goto -> 209
    //   195: astore_1
    //   196: aconst_null
    //   197: astore_2
    //   198: aload_2
    //   199: astore_3
    //   200: goto -> 339
    //   203: astore #5
    //   205: aconst_null
    //   206: astore_2
    //   207: aload_2
    //   208: astore_1
    //   209: aload_1
    //   210: astore_3
    //   211: aload_2
    //   212: astore #4
    //   214: new java/io/StringWriter
    //   217: dup
    //   218: invokespecial <init> : ()V
    //   221: astore #6
    //   223: aload_1
    //   224: astore_3
    //   225: aload_2
    //   226: astore #4
    //   228: aload #5
    //   230: new java/io/PrintWriter
    //   233: dup
    //   234: aload #6
    //   236: invokespecial <init> : (Ljava/io/Writer;)V
    //   239: invokevirtual printStackTrace : (Ljava/io/PrintWriter;)V
    //   242: aload_1
    //   243: astore_3
    //   244: aload_2
    //   245: astore #4
    //   247: new java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial <init> : ()V
    //   254: astore #5
    //   256: aload_1
    //   257: astore_3
    //   258: aload_2
    //   259: astore #4
    //   261: aload #5
    //   263: ldc 'exceptions occurred1:'
    //   265: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_1
    //   270: astore_3
    //   271: aload_2
    //   272: astore #4
    //   274: aload #5
    //   276: aload #6
    //   278: invokevirtual toString : ()Ljava/lang/String;
    //   281: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_1
    //   286: astore_3
    //   287: aload_2
    //   288: astore #4
    //   290: ldc 'TbsSDKExtensionCommonConfig'
    //   292: aload #5
    //   294: invokevirtual toString : ()Ljava/lang/String;
    //   297: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   300: pop
    //   301: aload_1
    //   302: ifnull -> 317
    //   305: aload_1
    //   306: invokevirtual close : ()V
    //   309: goto -> 317
    //   312: astore_1
    //   313: aload_1
    //   314: invokevirtual printStackTrace : ()V
    //   317: aload_2
    //   318: ifnull -> 332
    //   321: aload_2
    //   322: invokevirtual close : ()V
    //   325: goto -> 332
    //   328: astore_1
    //   329: goto -> 170
    //   332: aload_0
    //   333: monitorexit
    //   334: return
    //   335: astore_1
    //   336: aload #4
    //   338: astore_2
    //   339: aload_3
    //   340: ifnull -> 359
    //   343: aload_3
    //   344: invokevirtual close : ()V
    //   347: goto -> 359
    //   350: astore_1
    //   351: goto -> 377
    //   354: astore_3
    //   355: aload_3
    //   356: invokevirtual printStackTrace : ()V
    //   359: aload_2
    //   360: ifnull -> 375
    //   363: aload_2
    //   364: invokevirtual close : ()V
    //   367: goto -> 375
    //   370: astore_2
    //   371: aload_2
    //   372: invokevirtual printStackTrace : ()V
    //   375: aload_1
    //   376: athrow
    //   377: aload_0
    //   378: monitorexit
    //   379: aload_1
    //   380: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	203	java/lang/Throwable
    //   2	7	195	finally
    //   14	23	203	java/lang/Throwable
    //   14	23	195	finally
    //   23	32	188	java/lang/Throwable
    //   23	32	182	finally
    //   37	46	177	java/lang/Throwable
    //   37	46	335	finally
    //   51	57	177	java/lang/Throwable
    //   51	57	335	finally
    //   62	73	177	java/lang/Throwable
    //   62	73	335	finally
    //   78	88	177	java/lang/Throwable
    //   78	88	335	finally
    //   93	99	177	java/lang/Throwable
    //   93	99	335	finally
    //   104	115	177	java/lang/Throwable
    //   104	115	335	finally
    //   120	130	177	java/lang/Throwable
    //   120	130	335	finally
    //   135	141	177	java/lang/Throwable
    //   135	141	335	finally
    //   146	150	177	java/lang/Throwable
    //   146	150	335	finally
    //   150	154	157	java/lang/Exception
    //   150	154	350	finally
    //   158	162	350	finally
    //   162	166	169	java/io/IOException
    //   162	166	350	finally
    //   170	174	350	finally
    //   214	223	335	finally
    //   228	242	335	finally
    //   247	256	335	finally
    //   261	269	335	finally
    //   274	285	335	finally
    //   290	301	335	finally
    //   305	309	312	java/lang/Exception
    //   305	309	350	finally
    //   313	317	350	finally
    //   321	325	328	java/io/IOException
    //   321	325	350	finally
    //   343	347	354	java/lang/Exception
    //   343	347	350	finally
    //   355	359	350	finally
    //   363	367	370	java/io/IOException
    //   363	367	350	finally
    //   371	375	350	finally
    //   375	377	350	finally
  }
  
  private File d() {
    StringWriter stringWriter1;
    StringWriter stringWriter2 = null;
    try {
      if (this.b == null) {
        this.b = new File(d.a(this.a));
        if (this.b != null) {
          if (!this.b.isDirectory())
            return null; 
        } else {
          return null;
        } 
      } 
      File file = new File(this.b, "tbsnet.conf");
      if (!file.exists()) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Get file(");
        stringBuilder1.append(file.getCanonicalPath());
        stringBuilder1.append(") failed!");
        Log.e("TbsSDKExtensionCommonConfig", stringBuilder1.toString());
        return null;
      } 
      try {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("pathc:");
        stringBuilder1.append(file.getCanonicalPath());
        Log.w("TbsSDKExtensionCommonConfig", stringBuilder1.toString());
        return file;
      } catch (Throwable null) {}
    } catch (Throwable throwable) {
      stringWriter1 = stringWriter2;
    } 
    stringWriter2 = new StringWriter();
    throwable.printStackTrace(new PrintWriter(stringWriter2));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("exceptions occurred2:");
    stringBuilder.append(stringWriter2.toString());
    Log.e("TbsSDKExtensionCommonConfig", stringBuilder.toString());
    return (File)stringWriter1;
  }
  
  public String a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getTbsDownloaderPostUrl:");
    stringBuilder.append(this.e);
    stringBuilder.toString();
    return this.e;
  }
  
  public String b() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getTbsCmdPostUrl:");
    stringBuilder.append(this.c);
    g.b("TbsSDKExtensionCommonConfig", stringBuilder.toString());
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */