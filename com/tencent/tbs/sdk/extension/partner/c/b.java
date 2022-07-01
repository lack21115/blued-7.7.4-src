package com.tencent.tbs.sdk.extension.partner.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.tbs.sdk.extension.TbsSDKExtension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class b {
  public static String a = "";
  
  public static String b = "";
  
  public static String c = "";
  
  public static String d = "";
  
  static final String[] e;
  
  private static int f = 1;
  
  private static int g = 0;
  
  private static int h = -1;
  
  private static int i = h;
  
  static {
    e = new String[] { "com.tencent.mm", "com.tencent.mobileqq", "com.qzone" };
    throw new VerifyError("bad dex opcode");
  }
  
  private static PackageInfo a(String paramString, int paramInt) {
    // Byte code:
    //   0: ldc 'android.content.pm.PackageParser'
    //   2: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore #6
    //   7: aload #6
    //   9: invokevirtual getDeclaredClasses : ()[Ljava/lang/Class;
    //   12: astore #5
    //   14: aload #5
    //   16: arraylength
    //   17: istore_3
    //   18: iconst_0
    //   19: istore_2
    //   20: iload_2
    //   21: iload_3
    //   22: if_icmpge -> 349
    //   25: aload #5
    //   27: iload_2
    //   28: aaload
    //   29: astore #4
    //   31: aload #4
    //   33: invokevirtual getName : ()Ljava/lang/String;
    //   36: ldc 'android.content.pm.PackageParser$Package'
    //   38: invokevirtual compareTo : (Ljava/lang/String;)I
    //   41: ifne -> 342
    //   44: goto -> 47
    //   47: aload #6
    //   49: iconst_1
    //   50: anewarray java/lang/Class
    //   53: dup
    //   54: iconst_0
    //   55: ldc java/lang/String
    //   57: aastore
    //   58: invokevirtual getConstructor : ([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   61: astore #8
    //   63: aload #6
    //   65: ldc 'parsePackage'
    //   67: iconst_4
    //   68: anewarray java/lang/Class
    //   71: dup
    //   72: iconst_0
    //   73: ldc java/io/File
    //   75: aastore
    //   76: dup
    //   77: iconst_1
    //   78: ldc java/lang/String
    //   80: aastore
    //   81: dup
    //   82: iconst_2
    //   83: ldc android/util/DisplayMetrics
    //   85: aastore
    //   86: dup
    //   87: iconst_3
    //   88: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   91: aastore
    //   92: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   95: astore #7
    //   97: aload #6
    //   99: ldc 'collectCertificates'
    //   101: iconst_2
    //   102: anewarray java/lang/Class
    //   105: dup
    //   106: iconst_0
    //   107: aload #4
    //   109: aastore
    //   110: dup
    //   111: iconst_1
    //   112: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   115: aastore
    //   116: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   119: astore #5
    //   121: aload #6
    //   123: ldc 'generatePackageInfo'
    //   125: iconst_5
    //   126: anewarray java/lang/Class
    //   129: dup
    //   130: iconst_0
    //   131: aload #4
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: ldc [I
    //   138: aastore
    //   139: dup
    //   140: iconst_2
    //   141: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   144: aastore
    //   145: dup
    //   146: iconst_3
    //   147: getstatic java/lang/Long.TYPE : Ljava/lang/Class;
    //   150: aastore
    //   151: dup
    //   152: iconst_4
    //   153: getstatic java/lang/Long.TYPE : Ljava/lang/Class;
    //   156: aastore
    //   157: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   160: astore #4
    //   162: aload #8
    //   164: iconst_1
    //   165: invokevirtual setAccessible : (Z)V
    //   168: aload #7
    //   170: iconst_1
    //   171: invokevirtual setAccessible : (Z)V
    //   174: aload #5
    //   176: iconst_1
    //   177: invokevirtual setAccessible : (Z)V
    //   180: aload #4
    //   182: iconst_1
    //   183: invokevirtual setAccessible : (Z)V
    //   186: aload #8
    //   188: iconst_1
    //   189: anewarray java/lang/Object
    //   192: dup
    //   193: iconst_0
    //   194: aload_0
    //   195: aastore
    //   196: invokevirtual newInstance : ([Ljava/lang/Object;)Ljava/lang/Object;
    //   199: astore #6
    //   201: new android/util/DisplayMetrics
    //   204: dup
    //   205: invokespecial <init> : ()V
    //   208: astore #8
    //   210: aload #8
    //   212: invokevirtual setToDefaults : ()V
    //   215: aload #7
    //   217: aload #6
    //   219: iconst_4
    //   220: anewarray java/lang/Object
    //   223: dup
    //   224: iconst_0
    //   225: new java/io/File
    //   228: dup
    //   229: aload_0
    //   230: invokespecial <init> : (Ljava/lang/String;)V
    //   233: aastore
    //   234: dup
    //   235: iconst_1
    //   236: aload_0
    //   237: aastore
    //   238: dup
    //   239: iconst_2
    //   240: aload #8
    //   242: aastore
    //   243: dup
    //   244: iconst_3
    //   245: iconst_0
    //   246: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   249: aastore
    //   250: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   253: astore_0
    //   254: aload_0
    //   255: ifnonnull -> 260
    //   258: aconst_null
    //   259: areturn
    //   260: iload_1
    //   261: bipush #64
    //   263: iand
    //   264: ifeq -> 290
    //   267: aload #5
    //   269: aload #6
    //   271: iconst_2
    //   272: anewarray java/lang/Object
    //   275: dup
    //   276: iconst_0
    //   277: aload_0
    //   278: aastore
    //   279: dup
    //   280: iconst_1
    //   281: iconst_0
    //   282: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   285: aastore
    //   286: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   289: pop
    //   290: aload #4
    //   292: aconst_null
    //   293: iconst_5
    //   294: anewarray java/lang/Object
    //   297: dup
    //   298: iconst_0
    //   299: aload_0
    //   300: aastore
    //   301: dup
    //   302: iconst_1
    //   303: aconst_null
    //   304: aastore
    //   305: dup
    //   306: iconst_2
    //   307: iload_1
    //   308: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   311: aastore
    //   312: dup
    //   313: iconst_3
    //   314: iconst_0
    //   315: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   318: aastore
    //   319: dup
    //   320: iconst_4
    //   321: iconst_0
    //   322: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   325: aastore
    //   326: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   329: checkcast android/content/pm/PackageInfo
    //   332: astore_0
    //   333: aload_0
    //   334: areturn
    //   335: astore_0
    //   336: aload_0
    //   337: invokevirtual printStackTrace : ()V
    //   340: aconst_null
    //   341: areturn
    //   342: iload_2
    //   343: iconst_1
    //   344: iadd
    //   345: istore_2
    //   346: goto -> 20
    //   349: aconst_null
    //   350: astore #4
    //   352: goto -> 47
    // Exception table:
    //   from	to	target	type
    //   0	18	335	java/lang/Exception
    //   31	44	335	java/lang/Exception
    //   47	254	335	java/lang/Exception
    //   267	290	335	java/lang/Exception
    //   290	333	335	java/lang/Exception
  }
  
  public static String a() {
    // Byte code:
    //   0: getstatic com/tencent/tbs/sdk/extension/partner/c/b.c : Ljava/lang/String;
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: ifne -> 13
    //   9: getstatic com/tencent/tbs/sdk/extension/partner/c/b.c : Ljava/lang/String;
    //   12: areturn
    //   13: new java/io/InputStreamReader
    //   16: dup
    //   17: invokestatic getRuntime : ()Ljava/lang/Runtime;
    //   20: ldc 'getprop ro.product.cpu.abi'
    //   22: invokevirtual exec : (Ljava/lang/String;)Ljava/lang/Process;
    //   25: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   28: invokespecial <init> : (Ljava/io/InputStream;)V
    //   31: astore_1
    //   32: new java/io/BufferedReader
    //   35: dup
    //   36: aload_1
    //   37: invokespecial <init> : (Ljava/io/Reader;)V
    //   40: astore_0
    //   41: aload_0
    //   42: astore_2
    //   43: aload_1
    //   44: astore_3
    //   45: aload_0
    //   46: invokevirtual readLine : ()Ljava/lang/String;
    //   49: ldc 'x86'
    //   51: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   54: ifeq -> 75
    //   57: ldc 'i686'
    //   59: astore #4
    //   61: aload_0
    //   62: astore_2
    //   63: aload_1
    //   64: astore_3
    //   65: aload #4
    //   67: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   70: astore #4
    //   72: goto -> 89
    //   75: aload_0
    //   76: astore_2
    //   77: aload_1
    //   78: astore_3
    //   79: ldc 'os.arch'
    //   81: invokestatic getProperty : (Ljava/lang/String;)Ljava/lang/String;
    //   84: astore #4
    //   86: goto -> 61
    //   89: aload_0
    //   90: invokevirtual close : ()V
    //   93: aload_1
    //   94: invokevirtual close : ()V
    //   97: aload #4
    //   99: areturn
    //   100: astore #4
    //   102: goto -> 132
    //   105: astore_0
    //   106: aconst_null
    //   107: astore_2
    //   108: goto -> 177
    //   111: astore #4
    //   113: aconst_null
    //   114: astore_0
    //   115: goto -> 132
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_1
    //   121: aload_1
    //   122: astore_2
    //   123: goto -> 177
    //   126: astore #4
    //   128: aconst_null
    //   129: astore_1
    //   130: aload_1
    //   131: astore_0
    //   132: aload_0
    //   133: astore_2
    //   134: aload_1
    //   135: astore_3
    //   136: ldc 'os.arch'
    //   138: invokestatic getProperty : (Ljava/lang/String;)Ljava/lang/String;
    //   141: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   144: astore #5
    //   146: aload_0
    //   147: astore_2
    //   148: aload_1
    //   149: astore_3
    //   150: aload #4
    //   152: invokevirtual printStackTrace : ()V
    //   155: aload_0
    //   156: ifnull -> 163
    //   159: aload_0
    //   160: invokevirtual close : ()V
    //   163: aload_1
    //   164: ifnull -> 171
    //   167: aload_1
    //   168: invokevirtual close : ()V
    //   171: aload #5
    //   173: areturn
    //   174: astore_0
    //   175: aload_3
    //   176: astore_1
    //   177: aload_2
    //   178: ifnull -> 185
    //   181: aload_2
    //   182: invokevirtual close : ()V
    //   185: aload_1
    //   186: ifnull -> 193
    //   189: aload_1
    //   190: invokevirtual close : ()V
    //   193: aload_0
    //   194: athrow
    //   195: astore_0
    //   196: goto -> 93
    //   199: astore_0
    //   200: aload #4
    //   202: areturn
    //   203: astore_0
    //   204: goto -> 163
    //   207: astore_0
    //   208: goto -> 171
    //   211: astore_2
    //   212: goto -> 185
    //   215: astore_1
    //   216: goto -> 193
    // Exception table:
    //   from	to	target	type
    //   13	32	126	java/lang/Throwable
    //   13	32	118	finally
    //   32	41	111	java/lang/Throwable
    //   32	41	105	finally
    //   45	57	100	java/lang/Throwable
    //   45	57	174	finally
    //   65	72	100	java/lang/Throwable
    //   65	72	174	finally
    //   79	86	100	java/lang/Throwable
    //   79	86	174	finally
    //   89	93	195	java/io/IOException
    //   93	97	199	java/io/IOException
    //   136	146	174	finally
    //   150	155	174	finally
    //   159	163	203	java/io/IOException
    //   167	171	207	java/io/IOException
    //   181	185	211	java/io/IOException
    //   189	193	215	java/io/IOException
  }
  
  public static String a(Context paramContext) {
    try {
      String str = paramContext.getPackageName();
      return (paramContext.getPackageManager().getPackageInfo(str, 0)).versionName;
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static String a(Context paramContext, File paramFile) {
    String str2 = a(paramContext, paramFile, false);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[AppUtil.getSignatureFromApk]  android api signature=");
    stringBuilder.append(str2);
    g.b("AppUtilExtension", stringBuilder.toString());
    String str1 = str2;
    if (str2 == null) {
      str1 = b(paramFile);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("[AppUtil.getSignatureFromApk]  java get signature=");
      stringBuilder1.append(str1);
      g.b("AppUtilExtension", stringBuilder1.toString());
    } 
    str2 = str1;
    if (str1 == null) {
      str2 = a(paramContext, paramFile, true);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("[AppUtil.getSignatureFromApk]  android reflection signature=");
      stringBuilder1.append(str2);
      g.b("AppUtilExtension", stringBuilder1.toString());
    } 
    return str2;
  }
  
  private static String a(Context paramContext, File paramFile, boolean paramBoolean) {
    if (paramBoolean) {
      packageInfo = a(paramFile.getAbsolutePath(), 65);
    } else {
      packageInfo = packageInfo.getPackageManager().getPackageArchiveInfo(paramFile.getAbsolutePath(), 65);
    } 
    paramFile = null;
    if (packageInfo != null) {
      String str;
      if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
        Signature signature = packageInfo.signatures[0];
      } else {
        g.d("AppUtilExtension", "[getSignatureFromApk] pkgInfo is not null BUT signatures is null!");
        packageInfo = null;
      } 
      if (packageInfo != null)
        str = packageInfo.toCharsString(); 
      return str;
    } 
    PackageInfo packageInfo = null;
  }
  
  public static String a(Context paramContext, String paramString) {
    try {
      String str2 = paramContext.getPackageName();
      String str1 = String.valueOf((paramContext.getPackageManager().getApplicationInfo(str2, 128)).metaData.get(paramString));
      try {
        return String.valueOf(Integer.toHexString(Integer.parseInt(str1)));
      } catch (Exception exception) {
        return str1;
      } 
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static String a(File paramFile) {
    // Byte code:
    //   0: bipush #16
    //   2: newarray char
    //   4: astore #6
    //   6: aload #6
    //   8: dup
    //   9: iconst_0
    //   10: ldc_w 48
    //   13: castore
    //   14: dup
    //   15: iconst_1
    //   16: ldc_w 49
    //   19: castore
    //   20: dup
    //   21: iconst_2
    //   22: ldc_w 50
    //   25: castore
    //   26: dup
    //   27: iconst_3
    //   28: ldc_w 51
    //   31: castore
    //   32: dup
    //   33: iconst_4
    //   34: ldc_w 52
    //   37: castore
    //   38: dup
    //   39: iconst_5
    //   40: ldc_w 53
    //   43: castore
    //   44: dup
    //   45: bipush #6
    //   47: ldc_w 54
    //   50: castore
    //   51: dup
    //   52: bipush #7
    //   54: ldc_w 55
    //   57: castore
    //   58: dup
    //   59: bipush #8
    //   61: ldc_w 56
    //   64: castore
    //   65: dup
    //   66: bipush #9
    //   68: ldc_w 57
    //   71: castore
    //   72: dup
    //   73: bipush #10
    //   75: ldc_w 97
    //   78: castore
    //   79: dup
    //   80: bipush #11
    //   82: ldc_w 98
    //   85: castore
    //   86: dup
    //   87: bipush #12
    //   89: ldc_w 99
    //   92: castore
    //   93: dup
    //   94: bipush #13
    //   96: ldc_w 100
    //   99: castore
    //   100: dup
    //   101: bipush #14
    //   103: ldc_w 101
    //   106: castore
    //   107: dup
    //   108: bipush #15
    //   110: ldc_w 102
    //   113: castore
    //   114: pop
    //   115: bipush #32
    //   117: newarray char
    //   119: astore #7
    //   121: ldc_w 'MD5'
    //   124: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/MessageDigest;
    //   127: astore #8
    //   129: new java/io/FileInputStream
    //   132: dup
    //   133: aload_0
    //   134: invokespecial <init> : (Ljava/io/File;)V
    //   137: astore #5
    //   139: aload #5
    //   141: astore_0
    //   142: sipush #4096
    //   145: newarray byte
    //   147: astore #9
    //   149: aload #5
    //   151: astore_0
    //   152: aload #5
    //   154: aload #9
    //   156: invokevirtual read : ([B)I
    //   159: istore_1
    //   160: iconst_0
    //   161: istore_2
    //   162: iload_1
    //   163: iconst_m1
    //   164: if_icmpeq -> 182
    //   167: aload #5
    //   169: astore_0
    //   170: aload #8
    //   172: aload #9
    //   174: iconst_0
    //   175: iload_1
    //   176: invokevirtual update : ([BII)V
    //   179: goto -> 149
    //   182: aload #5
    //   184: astore_0
    //   185: aload #8
    //   187: invokevirtual digest : ()[B
    //   190: astore #8
    //   192: iconst_0
    //   193: istore_1
    //   194: goto -> 292
    //   197: aload #5
    //   199: astore_0
    //   200: new java/lang/String
    //   203: dup
    //   204: aload #7
    //   206: invokespecial <init> : ([C)V
    //   209: astore #6
    //   211: aload #5
    //   213: invokevirtual close : ()V
    //   216: aload #6
    //   218: areturn
    //   219: astore_0
    //   220: aload_0
    //   221: invokevirtual printStackTrace : ()V
    //   224: aload #6
    //   226: areturn
    //   227: astore #6
    //   229: goto -> 244
    //   232: astore #5
    //   234: aconst_null
    //   235: astore_0
    //   236: goto -> 273
    //   239: astore #6
    //   241: aconst_null
    //   242: astore #5
    //   244: aload #5
    //   246: astore_0
    //   247: aload #6
    //   249: invokevirtual printStackTrace : ()V
    //   252: aload #5
    //   254: ifnull -> 269
    //   257: aload #5
    //   259: invokevirtual close : ()V
    //   262: aconst_null
    //   263: areturn
    //   264: astore_0
    //   265: aload_0
    //   266: invokevirtual printStackTrace : ()V
    //   269: aconst_null
    //   270: areturn
    //   271: astore #5
    //   273: aload_0
    //   274: ifnull -> 289
    //   277: aload_0
    //   278: invokevirtual close : ()V
    //   281: goto -> 289
    //   284: astore_0
    //   285: aload_0
    //   286: invokevirtual printStackTrace : ()V
    //   289: aload #5
    //   291: athrow
    //   292: iload_2
    //   293: bipush #16
    //   295: if_icmpge -> 197
    //   298: aload #8
    //   300: iload_2
    //   301: baload
    //   302: istore_3
    //   303: iload_1
    //   304: iconst_1
    //   305: iadd
    //   306: istore #4
    //   308: aload #7
    //   310: iload_1
    //   311: aload #6
    //   313: iload_3
    //   314: iconst_4
    //   315: iushr
    //   316: bipush #15
    //   318: iand
    //   319: caload
    //   320: castore
    //   321: iload #4
    //   323: iconst_1
    //   324: iadd
    //   325: istore_1
    //   326: aload #7
    //   328: iload #4
    //   330: aload #6
    //   332: iload_3
    //   333: bipush #15
    //   335: iand
    //   336: caload
    //   337: castore
    //   338: iload_2
    //   339: iconst_1
    //   340: iadd
    //   341: istore_2
    //   342: goto -> 292
    // Exception table:
    //   from	to	target	type
    //   121	139	239	java/lang/Exception
    //   121	139	232	finally
    //   142	149	227	java/lang/Exception
    //   142	149	271	finally
    //   152	160	227	java/lang/Exception
    //   152	160	271	finally
    //   170	179	227	java/lang/Exception
    //   170	179	271	finally
    //   185	192	227	java/lang/Exception
    //   185	192	271	finally
    //   200	211	227	java/lang/Exception
    //   200	211	271	finally
    //   211	216	219	java/io/IOException
    //   247	252	271	finally
    //   257	262	264	java/io/IOException
    //   277	281	284	java/io/IOException
  }
  
  private static String a(File paramFile, String paramString) {
    Properties properties1;
    File file = null;
    Properties properties2 = null;
    if (paramFile == null)
      return ""; 
    try {
      FileInputStream fileInputStream = new FileInputStream(paramFile);
    } catch (Throwable throwable) {
    
    } finally {
      paramString = null;
    } 
    properties2 = properties1;
    paramString.printStackTrace();
    if (properties1 != null)
      try {
        properties1.close();
      } catch (Exception exception) {} 
    return "";
  }
  
  private static String a(String paramString) {
    String str = paramString;
    if (paramString == null)
      str = ""; 
    return str;
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    int j = paramArrayOfbyte.length;
    char[] arrayOfChar = new char[j * 2];
    for (int i = 0; i < j; i++) {
      byte b1 = paramArrayOfbyte[i];
      int k = b1 >> 4 & 0xF;
      int m = i * 2;
      if (k >= 10) {
        k = k + 97 - 10;
      } else {
        k += 48;
      } 
      arrayOfChar[m] = (char)k;
      k = b1 & 0xF;
      if (k >= 10) {
        k = k + 97 - 10;
      } else {
        k += 48;
      } 
      arrayOfChar[m + 1] = (char)k;
    } 
    return new String(arrayOfChar);
  }
  
  private static Certificate[] a(JarFile paramJarFile, JarEntry paramJarEntry, byte[] paramArrayOfbyte) {
    InputStream inputStream1 = null;
    InputStream inputStream2 = null;
    if (paramJarEntry == null)
      return null; 
    try {
      InputStream inputStream = paramJarFile.getInputStream(paramJarEntry);
      while (true) {
        inputStream2 = inputStream;
        inputStream1 = inputStream;
        int i = inputStream.read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
        if (i != -1)
          continue; 
        if (inputStream != null) {
          inputStream.close();
          return paramJarEntry.getCertificates();
        } 
        return paramJarEntry.getCertificates();
      } 
    } catch (Exception exception) {
      inputStream2 = inputStream1;
      exception.printStackTrace();
      if (inputStream1 != null) {
        InputStream inputStream = inputStream1;
      } else {
        return paramJarEntry.getCertificates();
      } 
    } finally {}
    paramJarFile.close();
    return paramJarEntry.getCertificates();
  }
  
  public static int b(Context paramContext) {
    try {
      String str = paramContext.getPackageName();
      return (paramContext.getPackageManager().getPackageInfo(str, 0)).versionCode;
    } catch (Exception exception) {
      return 0;
    } 
  }
  
  private static File b(Context paramContext, String paramString) {
    File file = d(paramContext);
    if (file == null)
      return null; 
    file = new File(file, paramString);
    if (file.exists())
      return file; 
    try {
      file.createNewFile();
      return file;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return null;
    } 
  }
  
  private static String b(File paramFile) {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc_w '[getSignatureFromApk]## file='
    //   12: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_2
    //   17: aload_0
    //   18: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: ldc 'AppUtilExtension'
    //   24: aload_2
    //   25: invokevirtual toString : ()Ljava/lang/String;
    //   28: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   31: aconst_null
    //   32: astore #4
    //   34: aconst_null
    //   35: astore #5
    //   37: new java/util/jar/JarFile
    //   40: dup
    //   41: aload_0
    //   42: invokespecial <init> : (Ljava/io/File;)V
    //   45: astore_2
    //   46: aload_2
    //   47: astore_0
    //   48: aload_2
    //   49: ldc_w 'AndroidManifest.xml'
    //   52: invokevirtual getJarEntry : (Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   55: astore_3
    //   56: aload_2
    //   57: astore_0
    //   58: sipush #8192
    //   61: newarray byte
    //   63: astore #7
    //   65: aload_2
    //   66: astore_0
    //   67: aload_2
    //   68: aload_3
    //   69: aload #7
    //   71: invokestatic a : (Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;[B)[Ljava/security/cert/Certificate;
    //   74: astore_3
    //   75: aload_3
    //   76: ifnull -> 341
    //   79: aload_3
    //   80: iconst_0
    //   81: aaload
    //   82: ifnonnull -> 88
    //   85: goto -> 341
    //   88: aload_2
    //   89: astore_0
    //   90: aload_3
    //   91: iconst_0
    //   92: aaload
    //   93: invokevirtual getEncoded : ()[B
    //   96: invokestatic a : ([B)Ljava/lang/String;
    //   99: astore #6
    //   101: aload_2
    //   102: astore_0
    //   103: aload_2
    //   104: invokevirtual entries : ()Ljava/util/Enumeration;
    //   107: astore #8
    //   109: aload_2
    //   110: astore_0
    //   111: aload #8
    //   113: invokeinterface hasMoreElements : ()Z
    //   118: ifeq -> 323
    //   121: aload_2
    //   122: astore_0
    //   123: aload #8
    //   125: invokeinterface nextElement : ()Ljava/lang/Object;
    //   130: checkcast java/util/jar/JarEntry
    //   133: astore_3
    //   134: aload_2
    //   135: astore_0
    //   136: aload_3
    //   137: invokevirtual getName : ()Ljava/lang/String;
    //   140: astore #9
    //   142: aload #9
    //   144: ifnull -> 109
    //   147: aload_2
    //   148: astore_0
    //   149: new java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial <init> : ()V
    //   156: astore #10
    //   158: aload_2
    //   159: astore_0
    //   160: aload #10
    //   162: ldc_w '[getSignatureFromApk]## loadCertificates & check:'
    //   165: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_2
    //   170: astore_0
    //   171: aload #10
    //   173: aload #9
    //   175: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_2
    //   180: astore_0
    //   181: ldc 'AppUtilExtension'
    //   183: aload #10
    //   185: invokevirtual toString : ()Ljava/lang/String;
    //   188: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload_2
    //   192: astore_0
    //   193: aload_2
    //   194: aload_3
    //   195: aload #7
    //   197: invokestatic a : (Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;[B)[Ljava/security/cert/Certificate;
    //   200: astore_3
    //   201: aload_3
    //   202: ifnull -> 220
    //   205: aload_2
    //   206: astore_0
    //   207: aload_3
    //   208: iconst_0
    //   209: aaload
    //   210: invokevirtual getEncoded : ()[B
    //   213: invokestatic a : ([B)Ljava/lang/String;
    //   216: astore_3
    //   217: goto -> 232
    //   220: aload_2
    //   221: astore_0
    //   222: ldc 'AppUtilExtension'
    //   224: ldc_w '[getSignatureFromApk]## certs2 is null!'
    //   227: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   230: aconst_null
    //   231: astore_3
    //   232: aload_3
    //   233: ifnonnull -> 265
    //   236: aload_2
    //   237: astore_0
    //   238: ldc 'AppUtilExtension'
    //   240: ldc_w '[getSignatureFromApk]## loadCertificates failed!'
    //   243: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   246: aload_2
    //   247: astore_0
    //   248: aload #9
    //   250: ldc_w 'META-INF/'
    //   253: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   256: ifne -> 109
    //   259: aload #5
    //   261: astore_0
    //   262: goto -> 326
    //   265: aload_2
    //   266: astore_0
    //   267: aload_3
    //   268: aload #6
    //   270: invokevirtual equals : (Ljava/lang/Object;)Z
    //   273: istore_1
    //   274: aload_2
    //   275: astore_0
    //   276: new java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial <init> : ()V
    //   283: astore_3
    //   284: aload_2
    //   285: astore_0
    //   286: aload_3
    //   287: ldc_w '[getSignatureFromApk]## loadCertificates check:'
    //   290: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload_2
    //   295: astore_0
    //   296: aload_3
    //   297: iload_1
    //   298: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload_2
    //   303: astore_0
    //   304: ldc 'AppUtilExtension'
    //   306: aload_3
    //   307: invokevirtual toString : ()Ljava/lang/String;
    //   310: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   313: iload_1
    //   314: ifne -> 109
    //   317: aload #5
    //   319: astore_0
    //   320: goto -> 326
    //   323: aload #6
    //   325: astore_0
    //   326: aload_0
    //   327: astore_3
    //   328: aload_2
    //   329: invokevirtual close : ()V
    //   332: aload_0
    //   333: areturn
    //   334: astore_0
    //   335: aload_0
    //   336: invokevirtual printStackTrace : ()V
    //   339: aload_3
    //   340: areturn
    //   341: aload_2
    //   342: invokevirtual close : ()V
    //   345: aconst_null
    //   346: areturn
    //   347: astore_0
    //   348: aload_0
    //   349: invokevirtual printStackTrace : ()V
    //   352: aconst_null
    //   353: areturn
    //   354: astore_3
    //   355: goto -> 367
    //   358: astore_2
    //   359: aconst_null
    //   360: astore_0
    //   361: goto -> 387
    //   364: astore_3
    //   365: aconst_null
    //   366: astore_2
    //   367: aload_2
    //   368: astore_0
    //   369: aload_3
    //   370: invokevirtual printStackTrace : ()V
    //   373: aload_2
    //   374: ifnull -> 384
    //   377: aload #4
    //   379: astore_3
    //   380: aload_2
    //   381: invokevirtual close : ()V
    //   384: aconst_null
    //   385: areturn
    //   386: astore_2
    //   387: aload_0
    //   388: ifnull -> 403
    //   391: aload_0
    //   392: invokevirtual close : ()V
    //   395: goto -> 403
    //   398: astore_0
    //   399: aload_0
    //   400: invokevirtual printStackTrace : ()V
    //   403: aload_2
    //   404: athrow
    // Exception table:
    //   from	to	target	type
    //   37	46	364	java/lang/Exception
    //   37	46	358	finally
    //   48	56	354	java/lang/Exception
    //   48	56	386	finally
    //   58	65	354	java/lang/Exception
    //   58	65	386	finally
    //   67	75	354	java/lang/Exception
    //   67	75	386	finally
    //   90	101	354	java/lang/Exception
    //   90	101	386	finally
    //   103	109	354	java/lang/Exception
    //   103	109	386	finally
    //   111	121	354	java/lang/Exception
    //   111	121	386	finally
    //   123	134	354	java/lang/Exception
    //   123	134	386	finally
    //   136	142	354	java/lang/Exception
    //   136	142	386	finally
    //   149	158	354	java/lang/Exception
    //   149	158	386	finally
    //   160	169	354	java/lang/Exception
    //   160	169	386	finally
    //   171	179	354	java/lang/Exception
    //   171	179	386	finally
    //   181	191	354	java/lang/Exception
    //   181	191	386	finally
    //   193	201	354	java/lang/Exception
    //   193	201	386	finally
    //   207	217	354	java/lang/Exception
    //   207	217	386	finally
    //   222	230	354	java/lang/Exception
    //   222	230	386	finally
    //   238	246	354	java/lang/Exception
    //   238	246	386	finally
    //   248	259	354	java/lang/Exception
    //   248	259	386	finally
    //   267	274	354	java/lang/Exception
    //   267	274	386	finally
    //   276	284	354	java/lang/Exception
    //   276	284	386	finally
    //   286	294	354	java/lang/Exception
    //   286	294	386	finally
    //   296	302	354	java/lang/Exception
    //   296	302	386	finally
    //   304	313	354	java/lang/Exception
    //   304	313	386	finally
    //   328	332	334	java/io/IOException
    //   341	345	347	java/io/IOException
    //   369	373	386	finally
    //   380	384	334	java/io/IOException
    //   391	395	398	java/io/IOException
  }
  
  public static String c(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   4: aload_0
    //   5: invokevirtual getPackageName : ()Ljava/lang/String;
    //   8: bipush #64
    //   10: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   13: getfield signatures : [Landroid/content/pm/Signature;
    //   16: iconst_0
    //   17: aaload
    //   18: invokevirtual toByteArray : ()[B
    //   21: astore_0
    //   22: aload_0
    //   23: ifnull -> 141
    //   26: ldc_w 'SHA-1'
    //   29: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/MessageDigest;
    //   32: astore_2
    //   33: aload_2
    //   34: aload_0
    //   35: invokevirtual update : ([B)V
    //   38: aload_2
    //   39: invokevirtual digest : ()[B
    //   42: astore_0
    //   43: aload_0
    //   44: ifnull -> 141
    //   47: new java/lang/StringBuilder
    //   50: dup
    //   51: ldc ''
    //   53: invokespecial <init> : (Ljava/lang/String;)V
    //   56: astore_2
    //   57: aload_0
    //   58: ifnull -> 134
    //   61: aload_0
    //   62: arraylength
    //   63: ifgt -> 143
    //   66: aconst_null
    //   67: areturn
    //   68: iload_1
    //   69: aload_0
    //   70: arraylength
    //   71: if_icmpge -> 127
    //   74: aload_0
    //   75: iload_1
    //   76: baload
    //   77: sipush #255
    //   80: iand
    //   81: invokestatic toHexString : (I)Ljava/lang/String;
    //   84: invokevirtual toUpperCase : ()Ljava/lang/String;
    //   87: astore_3
    //   88: iload_1
    //   89: ifle -> 100
    //   92: aload_2
    //   93: ldc_w ':'
    //   96: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_3
    //   101: invokevirtual length : ()I
    //   104: iconst_2
    //   105: if_icmpge -> 114
    //   108: aload_2
    //   109: iconst_0
    //   110: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_2
    //   115: aload_3
    //   116: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: iload_1
    //   121: iconst_1
    //   122: iadd
    //   123: istore_1
    //   124: goto -> 68
    //   127: aload_2
    //   128: invokevirtual toString : ()Ljava/lang/String;
    //   131: astore_0
    //   132: aload_0
    //   133: areturn
    //   134: aconst_null
    //   135: areturn
    //   136: astore_0
    //   137: aload_0
    //   138: invokevirtual printStackTrace : ()V
    //   141: aconst_null
    //   142: areturn
    //   143: iconst_0
    //   144: istore_1
    //   145: goto -> 68
    // Exception table:
    //   from	to	target	type
    //   0	22	136	java/lang/Exception
    //   26	43	136	java/lang/Exception
    //   47	57	136	java/lang/Exception
    //   61	66	136	java/lang/Exception
    //   68	88	136	java/lang/Exception
    //   92	100	136	java/lang/Exception
    //   100	114	136	java/lang/Exception
    //   114	120	136	java/lang/Exception
    //   127	132	136	java/lang/Exception
  }
  
  static File d(Context paramContext) {
    File file = new File(TbsSDKExtension.getTbsFolderDir(paramContext), "share");
    return (!file.isDirectory() && !file.mkdir()) ? null : file;
  }
  
  public static int e(Context paramContext) {
    String str = a(b(paramContext, "core_info"), "core_version");
    if (!TextUtils.isEmpty(str))
      try {
        return Math.max(Integer.parseInt(str), 0);
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getCoreInfoVersion,exception:");
        stringBuilder.append(exception.toString());
        stringBuilder.toString();
      }  
    return 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */