package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.a;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.common.strategy.a;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.b;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;

public class NativeCrashHandler implements a {
  private static NativeCrashHandler a;
  
  private static int b = 1;
  
  private static boolean m = false;
  
  private static boolean n = false;
  
  private static boolean p = true;
  
  private final Context c;
  
  private final a d;
  
  private final w e;
  
  private NativeExceptionHandler f;
  
  private String g;
  
  private final boolean h;
  
  private boolean i = false;
  
  private boolean j = false;
  
  private boolean k = false;
  
  private boolean l = false;
  
  private b o;
  
  private NativeCrashHandler(Context paramContext, a parama, b paramb, w paramw, boolean paramBoolean, String paramString) {
    this.c = z.a(paramContext);
    try {
    
    } finally {
      paramString = null;
      paramString = (a.a(paramContext)).c;
      StringBuilder stringBuilder = new StringBuilder("/data/data/");
      stringBuilder.append(paramString);
      stringBuilder.append("/app_bugly");
    } 
    this.o = paramb;
    this.g = paramString;
    this.d = parama;
    this.e = paramw;
    this.h = paramBoolean;
    this.f = new a(paramContext, parama, paramb, a.a());
  }
  
  private void a(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield k : Z
    //   6: ifeq -> 22
    //   9: ldc '[Native] Native crash report has already registered.'
    //   11: iconst_0
    //   12: anewarray java/lang/Object
    //   15: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   18: pop
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield j : Z
    //   26: istore #4
    //   28: iload #4
    //   30: ifeq -> 434
    //   33: ldc 'SDK INT IS %d'
    //   35: iconst_1
    //   36: anewarray java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: getstatic android/os/Build$VERSION.SDK_INT : I
    //   44: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   47: aastore
    //   48: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   51: pop
    //   52: getstatic android/os/Build$VERSION.SDK_INT : I
    //   55: bipush #28
    //   57: if_icmpgt -> 72
    //   60: getstatic android/os/Build$VERSION.SDK_INT : I
    //   63: bipush #23
    //   65: if_icmplt -> 72
    //   68: iconst_2
    //   69: putstatic com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler.b : I
    //   72: aload_0
    //   73: aload_0
    //   74: getfield g : Ljava/lang/String;
    //   77: iload_1
    //   78: getstatic com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler.b : I
    //   81: invokevirtual regist : (Ljava/lang/String;ZI)Ljava/lang/String;
    //   84: astore #7
    //   86: aload #7
    //   88: ifnull -> 772
    //   91: ldc '[Native] Native Crash Report enable.'
    //   93: iconst_0
    //   94: anewarray java/lang/Object
    //   97: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   100: pop
    //   101: ldc '[Native] Check extra jni for Bugly NDK v%s'
    //   103: iconst_1
    //   104: anewarray java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: aload #7
    //   111: aastore
    //   112: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   115: pop
    //   116: ldc '2.1.1'
    //   118: ldc '.'
    //   120: ldc ''
    //   122: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   125: astore #8
    //   127: ldc '2.3.0'
    //   129: ldc '.'
    //   131: ldc ''
    //   133: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   136: astore #9
    //   138: aload #7
    //   140: ldc '.'
    //   142: ldc ''
    //   144: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   147: astore #6
    //   149: aload #6
    //   151: invokevirtual length : ()I
    //   154: iconst_2
    //   155: if_icmpne -> 197
    //   158: new java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial <init> : ()V
    //   165: astore #5
    //   167: aload #5
    //   169: aload #6
    //   171: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: ldc '0'
    //   177: astore #6
    //   179: aload #5
    //   181: aload #6
    //   183: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload #5
    //   189: invokevirtual toString : ()Ljava/lang/String;
    //   192: astore #5
    //   194: goto -> 234
    //   197: aload #6
    //   199: astore #5
    //   201: aload #6
    //   203: invokevirtual length : ()I
    //   206: iconst_1
    //   207: if_icmpne -> 234
    //   210: new java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial <init> : ()V
    //   217: astore #5
    //   219: aload #5
    //   221: aload #6
    //   223: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: ldc '00'
    //   229: astore #6
    //   231: goto -> 179
    //   234: aload #5
    //   236: invokestatic parseInt : (Ljava/lang/String;)I
    //   239: aload #8
    //   241: invokestatic parseInt : (Ljava/lang/String;)I
    //   244: if_icmplt -> 251
    //   247: iconst_1
    //   248: putstatic com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler.m : Z
    //   251: aload #5
    //   253: invokestatic parseInt : (Ljava/lang/String;)I
    //   256: aload #9
    //   258: invokestatic parseInt : (Ljava/lang/String;)I
    //   261: if_icmplt -> 268
    //   264: iconst_1
    //   265: putstatic com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler.n : Z
    //   268: getstatic com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler.n : Z
    //   271: ifeq -> 287
    //   274: ldc '[Native] Info setting jni can be accessed.'
    //   276: iconst_0
    //   277: anewarray java/lang/Object
    //   280: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   283: pop
    //   284: goto -> 297
    //   287: ldc '[Native] Info setting jni can not be accessed.'
    //   289: iconst_0
    //   290: anewarray java/lang/Object
    //   293: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   296: pop
    //   297: getstatic com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler.m : Z
    //   300: ifeq -> 316
    //   303: ldc '[Native] Extra jni can be accessed.'
    //   305: iconst_0
    //   306: anewarray java/lang/Object
    //   309: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   312: pop
    //   313: goto -> 326
    //   316: ldc '[Native] Extra jni can not be accessed.'
    //   318: iconst_0
    //   319: anewarray java/lang/Object
    //   322: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   325: pop
    //   326: aload_0
    //   327: getfield d : Lcom/tencent/bugly/crashreport/common/info/a;
    //   330: aload #7
    //   332: putfield o : Ljava/lang/String;
    //   335: ldc '-'
    //   337: aload_0
    //   338: getfield d : Lcom/tencent/bugly/crashreport/common/info/a;
    //   341: getfield o : Ljava/lang/String;
    //   344: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   347: astore #5
    //   349: aload_0
    //   350: getfield d : Lcom/tencent/bugly/crashreport/common/info/a;
    //   353: getfield f : Ljava/lang/String;
    //   356: aload #5
    //   358: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   361: ifne -> 393
    //   364: aload_0
    //   365: getfield d : Lcom/tencent/bugly/crashreport/common/info/a;
    //   368: aload_0
    //   369: getfield d : Lcom/tencent/bugly/crashreport/common/info/a;
    //   372: getfield f : Ljava/lang/String;
    //   375: ldc '-'
    //   377: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   380: aload_0
    //   381: getfield d : Lcom/tencent/bugly/crashreport/common/info/a;
    //   384: getfield o : Ljava/lang/String;
    //   387: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   390: putfield f : Ljava/lang/String;
    //   393: ldc 'comInfo.sdkVersion %s'
    //   395: iconst_1
    //   396: anewarray java/lang/Object
    //   399: dup
    //   400: iconst_0
    //   401: aload_0
    //   402: getfield d : Lcom/tencent/bugly/crashreport/common/info/a;
    //   405: getfield f : Ljava/lang/String;
    //   408: aastore
    //   409: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   412: pop
    //   413: aload_0
    //   414: iconst_1
    //   415: putfield k : Z
    //   418: aload_0
    //   419: monitorexit
    //   420: return
    //   421: ldc '[Native] Failed to load Bugly SO file.'
    //   423: iconst_0
    //   424: anewarray java/lang/Object
    //   427: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   430: pop
    //   431: goto -> 772
    //   434: aload_0
    //   435: getfield i : Z
    //   438: istore #4
    //   440: iload #4
    //   442: ifeq -> 772
    //   445: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   448: astore #5
    //   450: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   453: astore #6
    //   455: aload_0
    //   456: getfield g : Ljava/lang/String;
    //   459: astore #7
    //   461: aload_0
    //   462: getfield c : Landroid/content/Context;
    //   465: iconst_0
    //   466: invokestatic a : (Landroid/content/Context;Z)Ljava/lang/String;
    //   469: astore #8
    //   471: iconst_5
    //   472: istore_3
    //   473: iload_1
    //   474: ifeq -> 807
    //   477: iconst_1
    //   478: istore_2
    //   479: goto -> 482
    //   482: ldc 'com.tencent.feedback.eup.jni.NativeExceptionUpload'
    //   484: ldc 'registNativeExceptionHandler2'
    //   486: aconst_null
    //   487: iconst_4
    //   488: anewarray java/lang/Class
    //   491: dup
    //   492: iconst_0
    //   493: ldc java/lang/String
    //   495: aastore
    //   496: dup
    //   497: iconst_1
    //   498: ldc java/lang/String
    //   500: aastore
    //   501: dup
    //   502: iconst_2
    //   503: aload #5
    //   505: aastore
    //   506: dup
    //   507: iconst_3
    //   508: aload #6
    //   510: aastore
    //   511: iconst_4
    //   512: anewarray java/lang/Object
    //   515: dup
    //   516: iconst_0
    //   517: aload #7
    //   519: aastore
    //   520: dup
    //   521: iconst_1
    //   522: aload #8
    //   524: aastore
    //   525: dup
    //   526: iconst_2
    //   527: iload_2
    //   528: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   531: aastore
    //   532: dup
    //   533: iconst_3
    //   534: iconst_1
    //   535: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   538: aastore
    //   539: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   542: checkcast java/lang/String
    //   545: astore #6
    //   547: aload #6
    //   549: astore #5
    //   551: aload #6
    //   553: ifnonnull -> 638
    //   556: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   559: astore #5
    //   561: aload_0
    //   562: getfield g : Ljava/lang/String;
    //   565: astore #6
    //   567: aload_0
    //   568: getfield c : Landroid/content/Context;
    //   571: iconst_0
    //   572: invokestatic a : (Landroid/content/Context;Z)Ljava/lang/String;
    //   575: astore #7
    //   577: invokestatic b : ()Lcom/tencent/bugly/crashreport/common/info/a;
    //   580: pop
    //   581: invokestatic K : ()I
    //   584: istore_2
    //   585: ldc 'com.tencent.feedback.eup.jni.NativeExceptionUpload'
    //   587: ldc 'registNativeExceptionHandler'
    //   589: aconst_null
    //   590: iconst_3
    //   591: anewarray java/lang/Class
    //   594: dup
    //   595: iconst_0
    //   596: ldc java/lang/String
    //   598: aastore
    //   599: dup
    //   600: iconst_1
    //   601: ldc java/lang/String
    //   603: aastore
    //   604: dup
    //   605: iconst_2
    //   606: aload #5
    //   608: aastore
    //   609: iconst_3
    //   610: anewarray java/lang/Object
    //   613: dup
    //   614: iconst_0
    //   615: aload #6
    //   617: aastore
    //   618: dup
    //   619: iconst_1
    //   620: aload #7
    //   622: aastore
    //   623: dup
    //   624: iconst_2
    //   625: iload_2
    //   626: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   629: aastore
    //   630: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   633: checkcast java/lang/String
    //   636: astore #5
    //   638: aload #5
    //   640: ifnull -> 772
    //   643: aload_0
    //   644: iconst_1
    //   645: putfield k : Z
    //   648: aload_0
    //   649: getfield d : Lcom/tencent/bugly/crashreport/common/info/a;
    //   652: aload #5
    //   654: putfield o : Ljava/lang/String;
    //   657: ldc 'com.tencent.feedback.eup.jni.NativeExceptionUpload'
    //   659: ldc 'checkExtraJni'
    //   661: aconst_null
    //   662: iconst_1
    //   663: anewarray java/lang/Class
    //   666: dup
    //   667: iconst_0
    //   668: ldc java/lang/String
    //   670: aastore
    //   671: iconst_1
    //   672: anewarray java/lang/Object
    //   675: dup
    //   676: iconst_0
    //   677: aload #5
    //   679: aastore
    //   680: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   683: checkcast java/lang/Boolean
    //   686: astore #5
    //   688: aload #5
    //   690: ifnull -> 701
    //   693: aload #5
    //   695: invokevirtual booleanValue : ()Z
    //   698: putstatic com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler.m : Z
    //   701: ldc 'com.tencent.feedback.eup.jni.NativeExceptionUpload'
    //   703: ldc 'enableHandler'
    //   705: aconst_null
    //   706: iconst_1
    //   707: anewarray java/lang/Class
    //   710: dup
    //   711: iconst_0
    //   712: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   715: aastore
    //   716: iconst_1
    //   717: anewarray java/lang/Object
    //   720: dup
    //   721: iconst_0
    //   722: iconst_1
    //   723: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   726: aastore
    //   727: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   730: pop
    //   731: iload_3
    //   732: istore_2
    //   733: iload_1
    //   734: ifeq -> 739
    //   737: iconst_1
    //   738: istore_2
    //   739: ldc 'com.tencent.feedback.eup.jni.NativeExceptionUpload'
    //   741: ldc 'setLogMode'
    //   743: aconst_null
    //   744: iconst_1
    //   745: anewarray java/lang/Class
    //   748: dup
    //   749: iconst_0
    //   750: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   753: aastore
    //   754: iconst_1
    //   755: anewarray java/lang/Object
    //   758: dup
    //   759: iconst_0
    //   760: iload_2
    //   761: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   764: aastore
    //   765: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   768: pop
    //   769: aload_0
    //   770: monitorexit
    //   771: return
    //   772: aload_0
    //   773: iconst_0
    //   774: putfield j : Z
    //   777: aload_0
    //   778: iconst_0
    //   779: putfield i : Z
    //   782: aload_0
    //   783: monitorexit
    //   784: return
    //   785: astore #5
    //   787: aload_0
    //   788: monitorexit
    //   789: aload #5
    //   791: athrow
    //   792: astore #5
    //   794: goto -> 421
    //   797: astore #5
    //   799: goto -> 268
    //   802: astore #5
    //   804: goto -> 772
    //   807: iconst_5
    //   808: istore_2
    //   809: goto -> 482
    // Exception table:
    //   from	to	target	type
    //   2	19	785	finally
    //   22	28	785	finally
    //   33	72	792	finally
    //   72	86	792	finally
    //   91	175	792	finally
    //   179	194	792	finally
    //   201	227	792	finally
    //   234	251	797	finally
    //   251	268	797	finally
    //   268	284	792	finally
    //   287	297	792	finally
    //   297	313	792	finally
    //   316	326	792	finally
    //   326	393	792	finally
    //   393	418	792	finally
    //   421	431	785	finally
    //   434	440	785	finally
    //   445	471	802	finally
    //   482	547	802	finally
    //   556	638	802	finally
    //   643	688	802	finally
    //   693	701	802	finally
    //   701	731	802	finally
    //   739	769	802	finally
    //   772	782	785	finally
  }
  
  private boolean a(int paramInt, String paramString) {
    if (this.j) {
      if (!n)
        return false; 
      try {
        return true;
      } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      
      } finally {
        paramString = null;
        if (!x.a((Throwable)paramString))
          paramString.printStackTrace(); 
      } 
    } 
    return false;
  }
  
  private static boolean a(String paramString, boolean paramBoolean) {
    Exception exception;
    try {
      x.a("[Native] Trying to load so: %s", new Object[] { paramString });
      if (paramBoolean) {
        System.load(paramString);
      } else {
        System.loadLibrary(paramString);
      } 
    } finally {
      exception = null;
    } 
    x.d(exception.getMessage(), new Object[0]);
    x.d("[Native] Failed to load so: %s", new Object[] { paramString });
    return paramBoolean;
  }
  
  private void b(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifeq -> 13
    //   6: aload_0
    //   7: invokevirtual startNativeMonitor : ()V
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: aload_0
    //   14: invokespecial c : ()V
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: astore_2
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_2
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   6	10	20	finally
    //   13	17	20	finally
  }
  
  private void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield k : Z
    //   6: ifne -> 23
    //   9: ldc_w '[Native] Native crash report has already unregistered.'
    //   12: iconst_0
    //   13: anewarray java/lang/Object
    //   16: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: invokevirtual unregist : ()Ljava/lang/String;
    //   27: ifnull -> 60
    //   30: ldc_w '[Native] Successfully closed native crash report.'
    //   33: iconst_0
    //   34: anewarray java/lang/Object
    //   37: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   40: pop
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield k : Z
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: ldc_w '[Native] Failed to close native crash report.'
    //   52: iconst_0
    //   53: anewarray java/lang/Object
    //   56: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   59: pop
    //   60: ldc 'com.tencent.feedback.eup.jni.NativeExceptionUpload'
    //   62: ldc 'enableHandler'
    //   64: aconst_null
    //   65: iconst_1
    //   66: anewarray java/lang/Class
    //   69: dup
    //   70: iconst_0
    //   71: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   74: aastore
    //   75: iconst_1
    //   76: anewarray java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: iconst_0
    //   82: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   85: aastore
    //   86: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   89: pop
    //   90: aload_0
    //   91: iconst_0
    //   92: putfield k : Z
    //   95: ldc_w '[Native] Successfully closed native crash report.'
    //   98: iconst_0
    //   99: anewarray java/lang/Object
    //   102: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   105: pop
    //   106: aload_0
    //   107: monitorexit
    //   108: return
    //   109: ldc_w '[Native] Failed to close native crash report.'
    //   112: iconst_0
    //   113: anewarray java/lang/Object
    //   116: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   119: pop
    //   120: aload_0
    //   121: iconst_0
    //   122: putfield j : Z
    //   125: aload_0
    //   126: iconst_0
    //   127: putfield i : Z
    //   130: aload_0
    //   131: monitorexit
    //   132: return
    //   133: astore_1
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_1
    //   137: athrow
    //   138: astore_1
    //   139: goto -> 49
    //   142: astore_1
    //   143: goto -> 109
    // Exception table:
    //   from	to	target	type
    //   2	20	133	finally
    //   23	46	138	finally
    //   49	60	133	finally
    //   60	106	142	finally
    //   109	130	133	finally
  }
  
  private void c(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield l : Z
    //   6: iload_1
    //   7: if_icmpeq -> 33
    //   10: ldc_w 'user change native %b'
    //   13: iconst_1
    //   14: anewarray java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: iload_1
    //   20: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   23: aastore
    //   24: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   27: pop
    //   28: aload_0
    //   29: iload_1
    //   30: putfield l : Z
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   2	33	36	finally
  }
  
  public static NativeCrashHandler getInstance() {
    // Byte code:
    //   0: ldc com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler.a : Lcom/tencent/bugly/crashreport/crash/jni/NativeCrashHandler;
    //   6: astore_0
    //   7: ldc com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static NativeCrashHandler getInstance(Context paramContext, a parama, b paramb, a parama1, w paramw, boolean paramBoolean, String paramString) {
    // Byte code:
    //   0: ldc com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler.a : Lcom/tencent/bugly/crashreport/crash/jni/NativeCrashHandler;
    //   6: ifnonnull -> 28
    //   9: new com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler
    //   12: dup
    //   13: aload_0
    //   14: aload_1
    //   15: aload_2
    //   16: aload #4
    //   18: iload #5
    //   20: aload #6
    //   22: invokespecial <init> : (Landroid/content/Context;Lcom/tencent/bugly/crashreport/common/info/a;Lcom/tencent/bugly/crashreport/crash/b;Lcom/tencent/bugly/proguard/w;ZLjava/lang/String;)V
    //   25: putstatic com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler.a : Lcom/tencent/bugly/crashreport/crash/jni/NativeCrashHandler;
    //   28: getstatic com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler.a : Lcom/tencent/bugly/crashreport/crash/jni/NativeCrashHandler;
    //   31: astore_0
    //   32: ldc com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler
    //   34: monitorexit
    //   35: aload_0
    //   36: areturn
    //   37: astore_0
    //   38: ldc com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler
    //   40: monitorexit
    //   41: aload_0
    //   42: athrow
    // Exception table:
    //   from	to	target	type
    //   3	28	37	finally
    //   28	32	37	finally
  }
  
  public static boolean isShouldHandleInJava() {
    return p;
  }
  
  public static void setShouldHandleInJava(boolean paramBoolean) {
    p = paramBoolean;
    NativeCrashHandler nativeCrashHandler = a;
    if (nativeCrashHandler != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramBoolean);
      nativeCrashHandler.a(999, stringBuilder.toString());
    } 
  }
  
  protected final void a() {
    // Byte code:
    //   0: invokestatic b : ()J
    //   3: lstore #7
    //   5: getstatic com/tencent/bugly/crashreport/crash/c.g : J
    //   8: lstore #9
    //   10: invokestatic b : ()J
    //   13: lstore #11
    //   15: new java/io/File
    //   18: dup
    //   19: aload_0
    //   20: getfield g : Ljava/lang/String;
    //   23: invokespecial <init> : (Ljava/lang/String;)V
    //   26: astore #15
    //   28: aload #15
    //   30: invokevirtual exists : ()Z
    //   33: ifeq -> 208
    //   36: aload #15
    //   38: invokevirtual isDirectory : ()Z
    //   41: ifeq -> 208
    //   44: aload #15
    //   46: invokevirtual listFiles : ()[Ljava/io/File;
    //   49: astore #15
    //   51: aload #15
    //   53: ifnull -> 199
    //   56: aload #15
    //   58: arraylength
    //   59: ifne -> 63
    //   62: return
    //   63: aload #15
    //   65: arraylength
    //   66: istore #6
    //   68: iconst_0
    //   69: istore_3
    //   70: iconst_0
    //   71: istore #5
    //   73: iconst_0
    //   74: istore_1
    //   75: iload_3
    //   76: iload #6
    //   78: if_icmpge -> 173
    //   81: aload #15
    //   83: iload_3
    //   84: aaload
    //   85: astore #16
    //   87: aload #16
    //   89: invokevirtual lastModified : ()J
    //   92: lstore #13
    //   94: lload #13
    //   96: lload #7
    //   98: lload #9
    //   100: lsub
    //   101: lcmp
    //   102: iflt -> 123
    //   105: iload #5
    //   107: istore_2
    //   108: iload_1
    //   109: istore #4
    //   111: lload #13
    //   113: lload #11
    //   115: ldc2_w 86400000
    //   118: ladd
    //   119: lcmp
    //   120: iflt -> 209
    //   123: ldc_w '[Native] Delete record file: %s'
    //   126: iconst_1
    //   127: anewarray java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload #16
    //   134: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   137: aastore
    //   138: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   141: pop
    //   142: iload #5
    //   144: iconst_1
    //   145: iadd
    //   146: istore #5
    //   148: iload #5
    //   150: istore_2
    //   151: iload_1
    //   152: istore #4
    //   154: aload #16
    //   156: invokevirtual delete : ()Z
    //   159: ifeq -> 209
    //   162: iload_1
    //   163: iconst_1
    //   164: iadd
    //   165: istore #4
    //   167: iload #5
    //   169: istore_2
    //   170: goto -> 209
    //   173: ldc_w '[Native] Number of record files overdue: %d, has deleted: %d'
    //   176: iconst_2
    //   177: anewarray java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: iload #5
    //   184: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   187: aastore
    //   188: dup
    //   189: iconst_1
    //   190: iload_1
    //   191: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   194: aastore
    //   195: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   198: pop
    //   199: return
    //   200: astore #15
    //   202: aload #15
    //   204: invokestatic a : (Ljava/lang/Throwable;)Z
    //   207: pop
    //   208: return
    //   209: iload_3
    //   210: iconst_1
    //   211: iadd
    //   212: istore_3
    //   213: iload_2
    //   214: istore #5
    //   216: iload #4
    //   218: istore_1
    //   219: goto -> 75
    // Exception table:
    //   from	to	target	type
    //   44	51	200	finally
    //   56	62	200	finally
    //   63	68	200	finally
    //   87	94	200	finally
    //   123	142	200	finally
    //   154	162	200	finally
    //   173	199	200	finally
  }
  
  public boolean appendLogToNative(String paramString1, String paramString2, String paramString3) {
    if (!this.i && !this.j)
      return false; 
    if (!m)
      return false; 
    if (paramString1 != null && paramString2 != null) {
      if (paramString3 == null)
        return false; 
      try {
        return (bool != null) ? bool.booleanValue() : false;
      } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      
      } finally {
        paramString1 = null;
        if (!x.a((Throwable)paramString1))
          paramString1.printStackTrace(); 
      } 
    } 
    return false;
  }
  
  protected native boolean appendNativeLog(String paramString1, String paramString2, String paramString3);
  
  protected native boolean appendWholeNativeLog(String paramString);
  
  public void checkUploadRecordCrash() {
    this.e.a(new Runnable(this) {
          public final void run() {
            if (!z.a(NativeCrashHandler.a(this.a), "native_record_lock", 10000L)) {
              x.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
              return;
            } 
            if (!NativeCrashHandler.b())
              NativeCrashHandler.a(this.a, 999, "false"); 
            CrashDetailBean crashDetailBean = b.a(NativeCrashHandler.a(this.a), NativeCrashHandler.b(this.a), NativeCrashHandler.c(this.a));
            if (crashDetailBean != null) {
              x.a("[Native] Get crash from native record.", new Object[0]);
              if (!NativeCrashHandler.d(this.a).a(crashDetailBean))
                NativeCrashHandler.d(this.a).a(crashDetailBean, 3000L, false); 
              b.a(false, NativeCrashHandler.b(this.a));
            } 
            this.a.a();
            z.b(NativeCrashHandler.a(this.a), "native_record_lock");
          }
        });
  }
  
  public boolean filterSigabrtSysLog() {
    return a(998, "true");
  }
  
  public String getDumpFilePath() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Ljava/lang/String;
    //   6: astore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_1
    //   10: areturn
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public String getLogFromNative() {
    if (!this.i && !this.j)
      return null; 
    if (!m)
      return null; 
    try {
      return this.j ? getNativeLog() : (String)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null, null);
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      return null;
    } finally {
      Exception exception = null;
      if (!x.a(exception))
        exception.printStackTrace(); 
    } 
  }
  
  public NativeExceptionHandler getNativeExceptionHandler() {
    return this.f;
  }
  
  protected native String getNativeKeyValueList();
  
  protected native String getNativeLog();
  
  public boolean isUserOpened() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield l : Z
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public void onStrategyChanged(StrategyBean paramStrategyBean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 38
    //   6: aload_1
    //   7: getfield g : Z
    //   10: aload_0
    //   11: getfield k : Z
    //   14: if_icmpeq -> 38
    //   17: ldc_w 'server native changed to %b'
    //   20: iconst_1
    //   21: anewarray java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: aload_1
    //   27: getfield g : Z
    //   30: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   33: aastore
    //   34: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   37: pop
    //   38: invokestatic a : ()Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   41: invokevirtual c : ()Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   44: getfield g : Z
    //   47: ifeq -> 101
    //   50: aload_0
    //   51: getfield l : Z
    //   54: ifeq -> 101
    //   57: iconst_1
    //   58: istore_2
    //   59: goto -> 62
    //   62: iload_2
    //   63: aload_0
    //   64: getfield k : Z
    //   67: if_icmpeq -> 93
    //   70: ldc_w 'native changed to %b'
    //   73: iconst_1
    //   74: anewarray java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: iload_2
    //   80: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   83: aastore
    //   84: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   87: pop
    //   88: aload_0
    //   89: iload_2
    //   90: invokespecial b : (Z)V
    //   93: aload_0
    //   94: monitorexit
    //   95: return
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    //   101: iconst_0
    //   102: istore_2
    //   103: goto -> 62
    // Exception table:
    //   from	to	target	type
    //   6	38	96	finally
    //   38	57	96	finally
    //   62	93	96	finally
  }
  
  public boolean putKeyValueToNative(String paramString1, String paramString2) {
    if (!this.i && !this.j)
      return false; 
    if (!m)
      return false; 
    if (paramString1 != null) {
      if (paramString2 == null)
        return false; 
      try {
        return (bool != null) ? bool.booleanValue() : false;
      } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      
      } finally {
        paramString1 = null;
        if (!x.a((Throwable)paramString1))
          paramString1.printStackTrace(); 
      } 
    } 
    return false;
  }
  
  protected native boolean putNativeKeyValue(String paramString1, String paramString2);
  
  protected native String regist(String paramString, boolean paramBoolean, int paramInt);
  
  public void removeEmptyNativeRecordFiles() {
    b.c(this.g);
  }
  
  protected native String removeNativeKeyValue(String paramString);
  
  public void setDumpFilePath(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield g : Ljava/lang/String;
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  public boolean setNativeAppChannel(String paramString) {
    return a(12, paramString);
  }
  
  public boolean setNativeAppPackage(String paramString) {
    return a(13, paramString);
  }
  
  public boolean setNativeAppVersion(String paramString) {
    return a(10, paramString);
  }
  
  protected native void setNativeInfo(int paramInt, String paramString);
  
  public boolean setNativeIsAppForeground(boolean paramBoolean) {
    String str;
    if (paramBoolean) {
      str = "true";
    } else {
      str = "false";
    } 
    return a(14, str);
  }
  
  public boolean setNativeLaunchTime(long paramLong) {
    try {
      return a(15, String.valueOf(paramLong));
    } catch (NumberFormatException numberFormatException) {
      if (!x.a(numberFormatException))
        numberFormatException.printStackTrace(); 
      return false;
    } 
  }
  
  public boolean setNativeUserId(String paramString) {
    return a(11, paramString);
  }
  
  public void setUserOpened(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokespecial c : (Z)V
    //   7: aload_0
    //   8: invokevirtual isUserOpened : ()Z
    //   11: istore_2
    //   12: invokestatic a : ()Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   15: astore_3
    //   16: iload_2
    //   17: istore_1
    //   18: aload_3
    //   19: ifnull -> 41
    //   22: iload_2
    //   23: ifeq -> 80
    //   26: aload_3
    //   27: invokevirtual c : ()Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   30: getfield g : Z
    //   33: ifeq -> 80
    //   36: iconst_1
    //   37: istore_1
    //   38: goto -> 41
    //   41: iload_1
    //   42: aload_0
    //   43: getfield k : Z
    //   46: if_icmpeq -> 72
    //   49: ldc_w 'native changed to %b'
    //   52: iconst_1
    //   53: anewarray java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: iload_1
    //   59: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   62: aastore
    //   63: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   66: pop
    //   67: aload_0
    //   68: iload_1
    //   69: invokespecial b : (Z)V
    //   72: aload_0
    //   73: monitorexit
    //   74: return
    //   75: astore_3
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_3
    //   79: athrow
    //   80: iconst_0
    //   81: istore_1
    //   82: goto -> 41
    // Exception table:
    //   from	to	target	type
    //   2	16	75	finally
    //   26	36	75	finally
    //   41	72	75	finally
  }
  
  public void startNativeMonitor() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Z
    //   6: ifne -> 181
    //   9: aload_0
    //   10: getfield i : Z
    //   13: ifeq -> 19
    //   16: goto -> 181
    //   19: ldc_w 'Bugly'
    //   22: astore_2
    //   23: aload_0
    //   24: getfield d : Lcom/tencent/bugly/crashreport/common/info/a;
    //   27: getfield n : Ljava/lang/String;
    //   30: invokestatic a : (Ljava/lang/String;)Z
    //   33: ifne -> 197
    //   36: iconst_1
    //   37: istore_1
    //   38: goto -> 41
    //   41: aload_0
    //   42: getfield d : Lcom/tencent/bugly/crashreport/common/info/a;
    //   45: getfield n : Ljava/lang/String;
    //   48: astore_3
    //   49: iload_1
    //   50: ifne -> 202
    //   53: aload_0
    //   54: getfield d : Lcom/tencent/bugly/crashreport/common/info/a;
    //   57: invokevirtual getClass : ()Ljava/lang/Class;
    //   60: pop
    //   61: goto -> 64
    //   64: aload_0
    //   65: aload_2
    //   66: iload_1
    //   67: invokestatic a : (Ljava/lang/String;Z)Z
    //   70: putfield j : Z
    //   73: aload_0
    //   74: getfield j : Z
    //   77: ifne -> 92
    //   80: aload_0
    //   81: getfield i : Z
    //   84: istore_1
    //   85: iload_1
    //   86: ifne -> 92
    //   89: aload_0
    //   90: monitorexit
    //   91: return
    //   92: aload_0
    //   93: aload_0
    //   94: getfield h : Z
    //   97: invokespecial a : (Z)V
    //   100: getstatic com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler.m : Z
    //   103: ifeq -> 178
    //   106: aload_0
    //   107: aload_0
    //   108: getfield d : Lcom/tencent/bugly/crashreport/common/info/a;
    //   111: getfield k : Ljava/lang/String;
    //   114: invokevirtual setNativeAppVersion : (Ljava/lang/String;)Z
    //   117: pop
    //   118: aload_0
    //   119: aload_0
    //   120: getfield d : Lcom/tencent/bugly/crashreport/common/info/a;
    //   123: getfield m : Ljava/lang/String;
    //   126: invokevirtual setNativeAppChannel : (Ljava/lang/String;)Z
    //   129: pop
    //   130: aload_0
    //   131: aload_0
    //   132: getfield d : Lcom/tencent/bugly/crashreport/common/info/a;
    //   135: getfield c : Ljava/lang/String;
    //   138: invokevirtual setNativeAppPackage : (Ljava/lang/String;)Z
    //   141: pop
    //   142: aload_0
    //   143: aload_0
    //   144: getfield d : Lcom/tencent/bugly/crashreport/common/info/a;
    //   147: invokevirtual g : ()Ljava/lang/String;
    //   150: invokevirtual setNativeUserId : (Ljava/lang/String;)Z
    //   153: pop
    //   154: aload_0
    //   155: aload_0
    //   156: getfield d : Lcom/tencent/bugly/crashreport/common/info/a;
    //   159: invokevirtual a : ()Z
    //   162: invokevirtual setNativeIsAppForeground : (Z)Z
    //   165: pop
    //   166: aload_0
    //   167: aload_0
    //   168: getfield d : Lcom/tencent/bugly/crashreport/common/info/a;
    //   171: getfield a : J
    //   174: invokevirtual setNativeLaunchTime : (J)Z
    //   177: pop
    //   178: aload_0
    //   179: monitorexit
    //   180: return
    //   181: aload_0
    //   182: aload_0
    //   183: getfield h : Z
    //   186: invokespecial a : (Z)V
    //   189: aload_0
    //   190: monitorexit
    //   191: return
    //   192: astore_2
    //   193: aload_0
    //   194: monitorexit
    //   195: aload_2
    //   196: athrow
    //   197: iconst_0
    //   198: istore_1
    //   199: goto -> 41
    //   202: aload_3
    //   203: astore_2
    //   204: goto -> 64
    // Exception table:
    //   from	to	target	type
    //   2	16	192	finally
    //   23	36	192	finally
    //   41	49	192	finally
    //   53	61	192	finally
    //   64	85	192	finally
    //   92	178	192	finally
    //   181	189	192	finally
  }
  
  protected native void testCrash();
  
  public void testNativeCrash() {
    if (!this.j) {
      x.d("[Native] Bugly SO file has not been load.", new Object[0]);
      return;
    } 
    testCrash();
  }
  
  public void testNativeCrash(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramBoolean1);
    a(16, stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramBoolean2);
    a(17, stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramBoolean3);
    a(18, stringBuilder.toString());
    testNativeCrash();
  }
  
  protected native String unregist();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\crashreport\crash\jni\NativeCrashHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */