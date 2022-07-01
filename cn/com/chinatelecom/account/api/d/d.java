package cn.com.chinatelecom.account.api.d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public class d {
  private static final String a = d.class.getCanonicalName();
  
  private static String b = "";
  
  private static final Pattern c = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
  
  private static String d = "";
  
  public static String a() {
    String str1 = UUID.randomUUID().toString();
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append(System.currentTimeMillis());
      stringBuilder.append(Math.random());
      String str = UUID.nameUUIDFromBytes(stringBuilder.toString().getBytes("utf8")).toString();
    } finally {
      Exception exception = null;
    } 
    String str2 = str1;
    if (!TextUtils.isEmpty(str1))
      str2 = str1.replace("-", ""); 
    return str2;
  }
  
  public static String a(Context paramContext) {
    if (TextUtils.isEmpty(d)) {
      d = e(paramContext);
      if (TextUtils.isEmpty(d)) {
        d = f(paramContext);
        a(paramContext, d);
      } 
    } 
    return d;
  }
  
  private static void a(Context paramContext, String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      if (paramContext == null)
        return; 
      c.a(paramContext, "key_d_i_u", paramString);
    } 
  }
  
  public static boolean a(Object paramObject, String paramString) {
    Method method = paramObject.getClass().getDeclaredMethod(paramString, new Class[0]);
    method.setAccessible(true);
    return ((Boolean)method.invoke(paramObject, new Object[0])).booleanValue();
  }
  
  public static boolean a(String paramString) {
    return (paramString != null && c.matcher(paramString).matches());
  }
  
  private static String b(Context paramContext, String paramString) {
    try {
      String str = l.a(new byte[] { 
            13, 2, 8, 30, 3, 5, 8, 66, 3, 31, 
            66, 28, 30, 3, 28, 9, 30, 24, 5, 9, 
            31 });
      Class<?> clazz = paramContext.getClassLoader().loadClass(str);
      return (String)clazz.getMethod("get", new Class[] { String.class }).invoke(clazz, new Object[] { paramString });
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String b(String paramString) {
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
    //   99: aload_0
    //   100: invokevirtual getBytes : ()[B
    //   103: astore_0
    //   104: ldc 'MD5'
    //   106: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/MessageDigest;
    //   109: astore #7
    //   111: aload #7
    //   113: aload_0
    //   114: invokevirtual update : ([B)V
    //   117: aload #7
    //   119: invokevirtual digest : ()[B
    //   122: astore_0
    //   123: aload_0
    //   124: arraylength
    //   125: istore_3
    //   126: iload_3
    //   127: iconst_2
    //   128: imul
    //   129: newarray char
    //   131: astore #7
    //   133: iconst_0
    //   134: istore_1
    //   135: iconst_0
    //   136: istore_2
    //   137: goto -> 158
    //   140: new java/lang/String
    //   143: dup
    //   144: aload #7
    //   146: invokespecial <init> : ([C)V
    //   149: astore_0
    //   150: aload_0
    //   151: areturn
    //   152: aconst_null
    //   153: areturn
    //   154: astore_0
    //   155: goto -> 152
    //   158: iload_1
    //   159: iload_3
    //   160: if_icmpge -> 140
    //   163: aload_0
    //   164: iload_1
    //   165: baload
    //   166: istore #4
    //   168: iload_2
    //   169: iconst_1
    //   170: iadd
    //   171: istore #5
    //   173: aload #7
    //   175: iload_2
    //   176: aload #6
    //   178: iload #4
    //   180: iconst_4
    //   181: iushr
    //   182: bipush #15
    //   184: iand
    //   185: caload
    //   186: castore
    //   187: iload #5
    //   189: iconst_1
    //   190: iadd
    //   191: istore_2
    //   192: aload #7
    //   194: iload #5
    //   196: aload #6
    //   198: iload #4
    //   200: bipush #15
    //   202: iand
    //   203: caload
    //   204: castore
    //   205: iload_1
    //   206: iconst_1
    //   207: iadd
    //   208: istore_1
    //   209: goto -> 158
    // Exception table:
    //   from	to	target	type
    //   99	133	154	java/lang/Exception
    //   140	150	154	java/lang/Exception
  }
  
  public static StringBuffer b() {
    StringBuffer stringBuffer = new StringBuffer();
    Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
    while (enumeration.hasMoreElements()) {
      NetworkInterface networkInterface = enumeration.nextElement();
      String str = networkInterface.getName();
      if (str != null && (str.contains("wlan") || str.equals("eth0")))
        continue; 
      Enumeration<InetAddress> enumeration1 = networkInterface.getInetAddresses();
      while (enumeration1.hasMoreElements()) {
        InetAddress inetAddress = enumeration1.nextElement();
        if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress()) {
          String str1 = inetAddress.getHostAddress();
          if (a(str1)) {
            if (stringBuffer.length() > 0)
              stringBuffer.append(","); 
            stringBuffer.append(str1);
          } 
        } 
      } 
    } 
    return stringBuffer;
  }
  
  public static boolean b(Context paramContext) {
    String str1;
    int i;
    if (Build.VERSION.SDK_INT >= 14) {
      i = 1;
    } else {
      i = 0;
    } 
    String str2 = l.a(new byte[] { 
          4, 24, 24, 28, 66, 28, 30, 3, 20, 21, 
          36, 3, 31, 24 });
    String str3 = l.a(new byte[] { 
          4, 24, 24, 28, 66, 28, 30, 3, 20, 21, 
          60, 3, 30, 24 });
    if (i) {
      str2 = System.getProperty(str2);
      str1 = System.getProperty(str3);
      if (str1 == null)
        str1 = "-1"; 
      i = Integer.parseInt(str1);
      str1 = str2;
    } else {
      str2 = Proxy.getHost((Context)str1);
      i = Proxy.getPort((Context)str1);
      str1 = str2;
    } 
    return (!TextUtils.isEmpty(str1) && i != -1);
  }
  
  public static boolean c() {
    String str1 = l.a(new byte[] { 
          67, 31, 21, 31, 24, 9, 1, 67, 14, 5, 
          2, 67, 31, 25 });
    String str2 = l.a(new byte[] { 
          67, 31, 21, 31, 24, 9, 1, 67, 20, 14, 
          5, 2, 67, 31, 25 });
    return ((new File(str1)).exists() && c(str1)) ? true : (((new File(str2)).exists() && c(str2)));
  }
  
  public static boolean c(Context paramContext) {
    return (g(paramContext) || h(paramContext) || i(paramContext));
  }
  
  private static boolean c(String paramString) {
    Process process2 = null;
    Process process1 = process2;
    try {
      Runtime runtime = Runtime.getRuntime();
      process1 = process2;
      StringBuilder stringBuilder = new StringBuilder();
      process1 = process2;
      stringBuilder.append("ls -l ");
      process1 = process2;
      stringBuilder.append(paramString);
      process1 = process2;
      Process process = runtime.exec(stringBuilder.toString());
      process1 = process;
      String str = (new BufferedReader(new InputStreamReader(process.getInputStream()))).readLine();
      if (str != null) {
        process1 = process;
        if (str.length() >= 4) {
          process1 = process;
          char c = str.charAt(3);
          if (c == 's' || c == 'x')
            return true; 
        } 
      } 
      return false;
    } finally {
      if (process1 != null)
        process1.destroy(); 
    } 
  }
  
  public static boolean d() {
    Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
    if (enumeration != null)
      while (enumeration.hasMoreElements()) {
        NetworkInterface networkInterface = enumeration.nextElement();
        if (!networkInterface.isUp() || networkInterface.getInterfaceAddresses().isEmpty())
          continue; 
        String str1 = l.a(new byte[] { 24, 25, 2, 92 });
        String str2 = l.a(new byte[] { 28, 28, 28, 92 });
        if (str1.equals(networkInterface.getName()) || str2.equals(networkInterface.getName()))
          return true; 
      }  
    return false;
  }
  
  public static boolean d(Context paramContext) {
    // Byte code:
    //   0: bipush #8
    //   2: newarray byte
    //   4: dup
    //   5: iconst_0
    //   6: bipush #11
    //   8: bastore
    //   9: dup
    //   10: iconst_1
    //   11: iconst_3
    //   12: bastore
    //   13: dup
    //   14: iconst_2
    //   15: iconst_0
    //   16: bastore
    //   17: dup
    //   18: iconst_3
    //   19: bipush #8
    //   21: bastore
    //   22: dup
    //   23: iconst_4
    //   24: bipush #10
    //   26: bastore
    //   27: dup
    //   28: iconst_5
    //   29: iconst_5
    //   30: bastore
    //   31: dup
    //   32: bipush #6
    //   34: bipush #31
    //   36: bastore
    //   37: dup
    //   38: bipush #7
    //   40: iconst_4
    //   41: bastore
    //   42: invokestatic a : ([B)Ljava/lang/String;
    //   45: astore_2
    //   46: bipush #11
    //   48: newarray byte
    //   50: dup
    //   51: iconst_0
    //   52: bipush #30
    //   54: bastore
    //   55: dup
    //   56: iconst_1
    //   57: iconst_3
    //   58: bastore
    //   59: dup
    //   60: iconst_2
    //   61: bipush #66
    //   63: bastore
    //   64: dup
    //   65: iconst_3
    //   66: iconst_4
    //   67: bastore
    //   68: dup
    //   69: iconst_4
    //   70: bipush #13
    //   72: bastore
    //   73: dup
    //   74: iconst_5
    //   75: bipush #30
    //   77: bastore
    //   78: dup
    //   79: bipush #6
    //   81: bipush #8
    //   83: bastore
    //   84: dup
    //   85: bipush #7
    //   87: bipush #27
    //   89: bastore
    //   90: dup
    //   91: bipush #8
    //   93: bipush #13
    //   95: bastore
    //   96: dup
    //   97: bipush #9
    //   99: bipush #30
    //   101: bastore
    //   102: dup
    //   103: bipush #10
    //   105: bipush #9
    //   107: bastore
    //   108: invokestatic a : ([B)Ljava/lang/String;
    //   111: astore_3
    //   112: bipush #14
    //   114: newarray byte
    //   116: dup
    //   117: iconst_0
    //   118: bipush #30
    //   120: bastore
    //   121: dup
    //   122: iconst_1
    //   123: iconst_3
    //   124: bastore
    //   125: dup
    //   126: iconst_2
    //   127: bipush #66
    //   129: bastore
    //   130: dup
    //   131: iconst_3
    //   132: bipush #7
    //   134: bastore
    //   135: dup
    //   136: iconst_4
    //   137: bipush #9
    //   139: bastore
    //   140: dup
    //   141: iconst_5
    //   142: bipush #30
    //   144: bastore
    //   145: dup
    //   146: bipush #6
    //   148: iconst_2
    //   149: bastore
    //   150: dup
    //   151: bipush #7
    //   153: bipush #9
    //   155: bastore
    //   156: dup
    //   157: bipush #8
    //   159: iconst_0
    //   160: bastore
    //   161: dup
    //   162: bipush #9
    //   164: bipush #66
    //   166: bastore
    //   167: dup
    //   168: bipush #10
    //   170: bipush #29
    //   172: bastore
    //   173: dup
    //   174: bipush #11
    //   176: bipush #9
    //   178: bastore
    //   179: dup
    //   180: bipush #12
    //   182: iconst_1
    //   183: bastore
    //   184: dup
    //   185: bipush #13
    //   187: bipush #25
    //   189: bastore
    //   190: invokestatic a : ([B)Ljava/lang/String;
    //   193: astore #4
    //   195: bipush #7
    //   197: newarray byte
    //   199: dup
    //   200: iconst_0
    //   201: bipush #11
    //   203: bastore
    //   204: dup
    //   205: iconst_1
    //   206: bipush #9
    //   208: bastore
    //   209: dup
    //   210: iconst_2
    //   211: iconst_2
    //   212: bastore
    //   213: dup
    //   214: iconst_3
    //   215: bipush #9
    //   217: bastore
    //   218: dup
    //   219: iconst_4
    //   220: bipush #30
    //   222: bastore
    //   223: dup
    //   224: iconst_5
    //   225: iconst_5
    //   226: bastore
    //   227: dup
    //   228: bipush #6
    //   230: bipush #15
    //   232: bastore
    //   233: invokestatic a : ([B)Ljava/lang/String;
    //   236: astore #5
    //   238: bipush #17
    //   240: newarray byte
    //   242: dup
    //   243: iconst_0
    //   244: bipush #30
    //   246: bastore
    //   247: dup
    //   248: iconst_1
    //   249: iconst_3
    //   250: bastore
    //   251: dup
    //   252: iconst_2
    //   253: bipush #66
    //   255: bastore
    //   256: dup
    //   257: iconst_3
    //   258: bipush #28
    //   260: bastore
    //   261: dup
    //   262: iconst_4
    //   263: bipush #30
    //   265: bastore
    //   266: dup
    //   267: iconst_5
    //   268: iconst_3
    //   269: bastore
    //   270: dup
    //   271: bipush #6
    //   273: bipush #8
    //   275: bastore
    //   276: dup
    //   277: bipush #7
    //   279: bipush #25
    //   281: bastore
    //   282: dup
    //   283: bipush #8
    //   285: bipush #15
    //   287: bastore
    //   288: dup
    //   289: bipush #9
    //   291: bipush #24
    //   293: bastore
    //   294: dup
    //   295: bipush #10
    //   297: bipush #66
    //   299: bastore
    //   300: dup
    //   301: bipush #11
    //   303: bipush #8
    //   305: bastore
    //   306: dup
    //   307: bipush #12
    //   309: bipush #9
    //   311: bastore
    //   312: dup
    //   313: bipush #13
    //   315: bipush #26
    //   317: bastore
    //   318: dup
    //   319: bipush #14
    //   321: iconst_5
    //   322: bastore
    //   323: dup
    //   324: bipush #15
    //   326: bipush #15
    //   328: bastore
    //   329: dup
    //   330: bipush #16
    //   332: bipush #9
    //   334: bastore
    //   335: invokestatic a : ([B)Ljava/lang/String;
    //   338: astore #6
    //   340: aload_2
    //   341: aload_0
    //   342: aload_3
    //   343: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   346: invokevirtual equals : (Ljava/lang/Object;)Z
    //   349: ifeq -> 354
    //   352: iconst_1
    //   353: ireturn
    //   354: ldc_w '1'
    //   357: aload_0
    //   358: aload #4
    //   360: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   363: invokevirtual equals : (Ljava/lang/Object;)Z
    //   366: ifeq -> 371
    //   369: iconst_1
    //   370: ireturn
    //   371: aload #5
    //   373: aload_0
    //   374: aload #6
    //   376: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   379: invokevirtual equals : (Ljava/lang/Object;)Z
    //   382: ifeq -> 387
    //   385: iconst_1
    //   386: ireturn
    //   387: getstatic android/os/Build.BRAND : Ljava/lang/String;
    //   390: astore_0
    //   391: getstatic android/os/Build.DEVICE : Ljava/lang/String;
    //   394: astore_3
    //   395: getstatic android/os/Build.HARDWARE : Ljava/lang/String;
    //   398: astore #4
    //   400: getstatic android/os/Build.MODEL : Ljava/lang/String;
    //   403: astore #5
    //   405: getstatic android/os/Build.PRODUCT : Ljava/lang/String;
    //   408: astore #6
    //   410: bipush #10
    //   412: newarray byte
    //   414: dup
    //   415: iconst_0
    //   416: bipush #43
    //   418: bastore
    //   419: dup
    //   420: iconst_1
    //   421: bipush #9
    //   423: bastore
    //   424: dup
    //   425: iconst_2
    //   426: iconst_2
    //   427: bastore
    //   428: dup
    //   429: iconst_3
    //   430: bipush #21
    //   432: bastore
    //   433: dup
    //   434: iconst_4
    //   435: iconst_1
    //   436: bastore
    //   437: dup
    //   438: iconst_5
    //   439: iconst_3
    //   440: bastore
    //   441: dup
    //   442: bipush #6
    //   444: bipush #24
    //   446: bastore
    //   447: dup
    //   448: bipush #7
    //   450: iconst_5
    //   451: bastore
    //   452: dup
    //   453: bipush #8
    //   455: iconst_3
    //   456: bastore
    //   457: dup
    //   458: bipush #9
    //   460: iconst_2
    //   461: bastore
    //   462: invokestatic a : ([B)Ljava/lang/String;
    //   465: astore #7
    //   467: bipush #7
    //   469: newarray byte
    //   471: dup
    //   472: iconst_0
    //   473: bipush #11
    //   475: bastore
    //   476: dup
    //   477: iconst_1
    //   478: bipush #9
    //   480: bastore
    //   481: dup
    //   482: iconst_2
    //   483: iconst_2
    //   484: bastore
    //   485: dup
    //   486: iconst_3
    //   487: bipush #9
    //   489: bastore
    //   490: dup
    //   491: iconst_4
    //   492: bipush #30
    //   494: bastore
    //   495: dup
    //   496: iconst_5
    //   497: iconst_5
    //   498: bastore
    //   499: dup
    //   500: bipush #6
    //   502: bipush #15
    //   504: bastore
    //   505: invokestatic a : ([B)Ljava/lang/String;
    //   508: astore #8
    //   510: iconst_3
    //   511: newarray byte
    //   513: dup
    //   514: iconst_0
    //   515: bipush #31
    //   517: bastore
    //   518: dup
    //   519: iconst_1
    //   520: bipush #8
    //   522: bastore
    //   523: dup
    //   524: iconst_2
    //   525: bipush #7
    //   527: bastore
    //   528: invokestatic a : ([B)Ljava/lang/String;
    //   531: astore #9
    //   533: getstatic android/os/Build.MANUFACTURER : Ljava/lang/String;
    //   536: aload #7
    //   538: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   541: ifeq -> 546
    //   544: iconst_1
    //   545: ireturn
    //   546: aload_3
    //   547: aload #8
    //   549: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   552: ifeq -> 557
    //   555: iconst_1
    //   556: ireturn
    //   557: aload #5
    //   559: aload #9
    //   561: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   564: ifeq -> 569
    //   567: iconst_1
    //   568: ireturn
    //   569: aload_0
    //   570: aload #8
    //   572: invokevirtual compareTo : (Ljava/lang/String;)I
    //   575: ifeq -> 851
    //   578: aload_3
    //   579: aload #8
    //   581: invokevirtual compareTo : (Ljava/lang/String;)I
    //   584: ifeq -> 851
    //   587: aload #5
    //   589: aload #9
    //   591: invokevirtual compareTo : (Ljava/lang/String;)I
    //   594: ifeq -> 851
    //   597: aload #6
    //   599: aload #9
    //   601: invokevirtual compareTo : (Ljava/lang/String;)I
    //   604: ifeq -> 851
    //   607: aload #4
    //   609: aload_2
    //   610: invokevirtual compareTo : (Ljava/lang/String;)I
    //   613: ifne -> 618
    //   616: iconst_1
    //   617: ireturn
    //   618: bipush #13
    //   620: newarray byte
    //   622: dup
    //   623: iconst_0
    //   624: bipush #67
    //   626: bastore
    //   627: dup
    //   628: iconst_1
    //   629: bipush #28
    //   631: bastore
    //   632: dup
    //   633: iconst_2
    //   634: bipush #30
    //   636: bastore
    //   637: dup
    //   638: iconst_3
    //   639: iconst_3
    //   640: bastore
    //   641: dup
    //   642: iconst_4
    //   643: bipush #15
    //   645: bastore
    //   646: dup
    //   647: iconst_5
    //   648: bipush #67
    //   650: bastore
    //   651: dup
    //   652: bipush #6
    //   654: bipush #15
    //   656: bastore
    //   657: dup
    //   658: bipush #7
    //   660: bipush #28
    //   662: bastore
    //   663: dup
    //   664: bipush #8
    //   666: bipush #25
    //   668: bastore
    //   669: dup
    //   670: bipush #9
    //   672: iconst_5
    //   673: bastore
    //   674: dup
    //   675: bipush #10
    //   677: iconst_2
    //   678: bastore
    //   679: dup
    //   680: bipush #11
    //   682: bipush #10
    //   684: bastore
    //   685: dup
    //   686: bipush #12
    //   688: iconst_3
    //   689: bastore
    //   690: invokestatic a : ([B)Ljava/lang/String;
    //   693: astore_0
    //   694: bipush #8
    //   696: newarray byte
    //   698: dup
    //   699: iconst_0
    //   700: bipush #43
    //   702: bastore
    //   703: dup
    //   704: iconst_1
    //   705: iconst_3
    //   706: bastore
    //   707: dup
    //   708: iconst_2
    //   709: iconst_0
    //   710: bastore
    //   711: dup
    //   712: iconst_3
    //   713: bipush #8
    //   715: bastore
    //   716: dup
    //   717: iconst_4
    //   718: bipush #10
    //   720: bastore
    //   721: dup
    //   722: iconst_5
    //   723: iconst_5
    //   724: bastore
    //   725: dup
    //   726: bipush #6
    //   728: bipush #31
    //   730: bastore
    //   731: dup
    //   732: bipush #7
    //   734: iconst_4
    //   735: bastore
    //   736: invokestatic a : ([B)Ljava/lang/String;
    //   739: astore_2
    //   740: new java/io/FileReader
    //   743: dup
    //   744: aload_0
    //   745: invokespecial <init> : (Ljava/lang/String;)V
    //   748: astore_0
    //   749: new java/io/BufferedReader
    //   752: dup
    //   753: aload_0
    //   754: invokespecial <init> : (Ljava/io/Reader;)V
    //   757: astore #4
    //   759: aload #4
    //   761: invokevirtual readLine : ()Ljava/lang/String;
    //   764: astore_3
    //   765: aload_3
    //   766: ifnull -> 805
    //   769: aload_3
    //   770: aload_2
    //   771: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   774: istore_1
    //   775: iload_1
    //   776: ifeq -> 759
    //   779: aload #4
    //   781: invokevirtual close : ()V
    //   784: goto -> 792
    //   787: astore_2
    //   788: aload_2
    //   789: invokevirtual printStackTrace : ()V
    //   792: aload_0
    //   793: invokevirtual close : ()V
    //   796: iconst_1
    //   797: ireturn
    //   798: astore_0
    //   799: aload_0
    //   800: invokevirtual printStackTrace : ()V
    //   803: iconst_1
    //   804: ireturn
    //   805: aload #4
    //   807: invokevirtual close : ()V
    //   810: goto -> 818
    //   813: astore_2
    //   814: aload_2
    //   815: invokevirtual printStackTrace : ()V
    //   818: aload_0
    //   819: invokevirtual close : ()V
    //   822: iconst_0
    //   823: ireturn
    //   824: astore_0
    //   825: aload_0
    //   826: invokevirtual printStackTrace : ()V
    //   829: iconst_0
    //   830: ireturn
    //   831: astore_2
    //   832: aload_0
    //   833: astore_3
    //   834: aload_2
    //   835: astore_0
    //   836: aload_3
    //   837: astore_2
    //   838: goto -> 859
    //   841: astore_2
    //   842: aload_0
    //   843: astore_3
    //   844: aload_2
    //   845: astore_0
    //   846: aload_3
    //   847: astore_2
    //   848: goto -> 856
    //   851: iconst_1
    //   852: ireturn
    //   853: astore_0
    //   854: aconst_null
    //   855: astore_2
    //   856: aconst_null
    //   857: astore #4
    //   859: aload #4
    //   861: ifnull -> 877
    //   864: aload #4
    //   866: invokevirtual close : ()V
    //   869: goto -> 877
    //   872: astore_3
    //   873: aload_3
    //   874: invokevirtual printStackTrace : ()V
    //   877: aload_2
    //   878: ifnull -> 893
    //   881: aload_2
    //   882: invokevirtual close : ()V
    //   885: goto -> 893
    //   888: astore_2
    //   889: aload_2
    //   890: invokevirtual printStackTrace : ()V
    //   893: aload_0
    //   894: athrow
    // Exception table:
    //   from	to	target	type
    //   0	352	853	finally
    //   354	369	853	finally
    //   371	385	853	finally
    //   387	544	853	finally
    //   546	555	853	finally
    //   557	567	853	finally
    //   569	616	853	finally
    //   618	749	853	finally
    //   749	759	841	finally
    //   759	765	831	finally
    //   769	775	831	finally
    //   779	784	787	java/io/IOException
    //   792	796	798	java/io/IOException
    //   805	810	813	java/io/IOException
    //   818	822	824	java/io/IOException
    //   864	869	872	java/io/IOException
    //   881	885	888	java/io/IOException
  }
  
  private static String e(Context paramContext) {
    return c.b(paramContext, "key_d_i_u", "");
  }
  
  private static String f(Context paramContext) {
    // Byte code:
    //   0: ldc ''
    //   2: astore_2
    //   3: aload_0
    //   4: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   7: ldc_w 'android_id'
    //   10: invokestatic getString : (Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   13: astore_0
    //   14: goto -> 24
    //   17: astore_0
    //   18: aload_0
    //   19: invokevirtual printStackTrace : ()V
    //   22: aload_2
    //   23: astore_0
    //   24: aload_0
    //   25: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   28: ifne -> 39
    //   31: aload_0
    //   32: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   35: astore_0
    //   36: goto -> 46
    //   39: invokestatic randomUUID : ()Ljava/util/UUID;
    //   42: invokevirtual toString : ()Ljava/lang/String;
    //   45: astore_0
    //   46: new java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial <init> : ()V
    //   53: astore_2
    //   54: aload_2
    //   55: aload_0
    //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload_2
    //   61: ldc_w 'default'
    //   64: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_2
    //   69: invokevirtual toString : ()Ljava/lang/String;
    //   72: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   75: astore_2
    //   76: aload_0
    //   77: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   80: istore_1
    //   81: iload_1
    //   82: ifeq -> 89
    //   85: ldc_w 'default'
    //   88: areturn
    //   89: aload_2
    //   90: areturn
    //   91: astore_0
    //   92: aload_0
    //   93: invokevirtual printStackTrace : ()V
    //   96: ldc_w 'default'
    //   99: areturn
    // Exception table:
    //   from	to	target	type
    //   3	14	17	finally
    //   18	22	91	finally
    //   24	36	91	finally
    //   39	46	91	finally
    //   46	81	91	finally
  }
  
  private static boolean g(Context paramContext) {
    List list = paramContext.getPackageManager().getInstalledApplications(128);
    String str1 = l.a(new byte[] { 
          8, 9, 66, 30, 3, 14, 26, 66, 13, 2, 
          8, 30, 3, 5, 8, 66, 20, 28, 3, 31, 
          9, 8, 66, 5, 2, 31, 24, 13, 0, 0, 
          9, 30 });
    String str2 = l.a(new byte[] { 
          15, 3, 1, 66, 31, 13, 25, 30, 5, 7, 
          66, 31, 25, 14, 31, 24, 30, 13, 24, 9 });
    for (ApplicationInfo applicationInfo : list) {
      if (applicationInfo.packageName.equals(str1))
        return true; 
      if (applicationInfo.packageName.equals(str2))
        return true; 
    } 
    return false;
  }
  
  private static boolean h(Context paramContext) {
    // Byte code:
    //   0: bipush #6
    //   2: newarray byte
    //   4: dup
    //   5: iconst_0
    //   6: bipush #67
    //   8: bastore
    //   9: dup
    //   10: iconst_1
    //   11: bipush #28
    //   13: bastore
    //   14: dup
    //   15: iconst_2
    //   16: bipush #30
    //   18: bastore
    //   19: dup
    //   20: iconst_3
    //   21: iconst_3
    //   22: bastore
    //   23: dup
    //   24: iconst_4
    //   25: bipush #15
    //   27: bastore
    //   28: dup
    //   29: iconst_5
    //   30: bipush #67
    //   32: bastore
    //   33: invokestatic a : ([B)Ljava/lang/String;
    //   36: astore_0
    //   37: iconst_5
    //   38: newarray byte
    //   40: dup
    //   41: iconst_0
    //   42: bipush #67
    //   44: bastore
    //   45: dup
    //   46: iconst_1
    //   47: iconst_1
    //   48: bastore
    //   49: dup
    //   50: iconst_2
    //   51: bipush #13
    //   53: bastore
    //   54: dup
    //   55: iconst_3
    //   56: bipush #28
    //   58: bastore
    //   59: dup
    //   60: iconst_4
    //   61: bipush #31
    //   63: bastore
    //   64: invokestatic a : ([B)Ljava/lang/String;
    //   67: astore #4
    //   69: bipush #20
    //   71: newarray byte
    //   73: dup
    //   74: iconst_0
    //   75: bipush #15
    //   77: bastore
    //   78: dup
    //   79: iconst_1
    //   80: iconst_3
    //   81: bastore
    //   82: dup
    //   83: iconst_2
    //   84: iconst_1
    //   85: bastore
    //   86: dup
    //   87: iconst_3
    //   88: bipush #66
    //   90: bastore
    //   91: dup
    //   92: iconst_4
    //   93: bipush #31
    //   95: bastore
    //   96: dup
    //   97: iconst_5
    //   98: bipush #13
    //   100: bastore
    //   101: dup
    //   102: bipush #6
    //   104: bipush #25
    //   106: bastore
    //   107: dup
    //   108: bipush #7
    //   110: bipush #30
    //   112: bastore
    //   113: dup
    //   114: bipush #8
    //   116: iconst_5
    //   117: bastore
    //   118: dup
    //   119: bipush #9
    //   121: bipush #7
    //   123: bastore
    //   124: dup
    //   125: bipush #10
    //   127: bipush #66
    //   129: bastore
    //   130: dup
    //   131: bipush #11
    //   133: bipush #31
    //   135: bastore
    //   136: dup
    //   137: bipush #12
    //   139: bipush #25
    //   141: bastore
    //   142: dup
    //   143: bipush #13
    //   145: bipush #14
    //   147: bastore
    //   148: dup
    //   149: bipush #14
    //   151: bipush #31
    //   153: bastore
    //   154: dup
    //   155: bipush #15
    //   157: bipush #24
    //   159: bastore
    //   160: dup
    //   161: bipush #16
    //   163: bipush #30
    //   165: bastore
    //   166: dup
    //   167: bipush #17
    //   169: bipush #13
    //   171: bastore
    //   172: dup
    //   173: bipush #18
    //   175: bipush #24
    //   177: bastore
    //   178: dup
    //   179: bipush #19
    //   181: bipush #9
    //   183: bastore
    //   184: invokestatic a : ([B)Ljava/lang/String;
    //   187: astore_2
    //   188: bipush #16
    //   190: newarray byte
    //   192: dup
    //   193: iconst_0
    //   194: bipush #52
    //   196: bastore
    //   197: dup
    //   198: iconst_1
    //   199: bipush #28
    //   201: bastore
    //   202: dup
    //   203: iconst_2
    //   204: iconst_3
    //   205: bastore
    //   206: dup
    //   207: iconst_3
    //   208: bipush #31
    //   210: bastore
    //   211: dup
    //   212: iconst_4
    //   213: bipush #9
    //   215: bastore
    //   216: dup
    //   217: iconst_5
    //   218: bipush #8
    //   220: bastore
    //   221: dup
    //   222: bipush #6
    //   224: bipush #46
    //   226: bastore
    //   227: dup
    //   228: bipush #7
    //   230: bipush #30
    //   232: bastore
    //   233: dup
    //   234: bipush #8
    //   236: iconst_5
    //   237: bastore
    //   238: dup
    //   239: bipush #9
    //   241: bipush #8
    //   243: bastore
    //   244: dup
    //   245: bipush #10
    //   247: bipush #11
    //   249: bastore
    //   250: dup
    //   251: bipush #11
    //   253: bipush #9
    //   255: bastore
    //   256: dup
    //   257: bipush #12
    //   259: bipush #66
    //   261: bastore
    //   262: dup
    //   263: bipush #13
    //   265: bipush #6
    //   267: bastore
    //   268: dup
    //   269: bipush #14
    //   271: bipush #13
    //   273: bastore
    //   274: dup
    //   275: bipush #15
    //   277: bipush #30
    //   279: bastore
    //   280: invokestatic a : ([B)Ljava/lang/String;
    //   283: astore_3
    //   284: new java/util/HashSet
    //   287: dup
    //   288: invokespecial <init> : ()V
    //   291: astore #5
    //   293: new java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial <init> : ()V
    //   300: astore #6
    //   302: aload #6
    //   304: aload_0
    //   305: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload #6
    //   311: invokestatic myPid : ()I
    //   314: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload #6
    //   320: aload #4
    //   322: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: new java/io/FileReader
    //   329: dup
    //   330: aload #6
    //   332: invokevirtual toString : ()Ljava/lang/String;
    //   335: invokespecial <init> : (Ljava/lang/String;)V
    //   338: astore_0
    //   339: new java/io/BufferedReader
    //   342: dup
    //   343: aload_0
    //   344: invokespecial <init> : (Ljava/io/Reader;)V
    //   347: astore #4
    //   349: aload #4
    //   351: invokevirtual readLine : ()Ljava/lang/String;
    //   354: astore #6
    //   356: aload #6
    //   358: ifnull -> 409
    //   361: aload #6
    //   363: ldc_w '.so'
    //   366: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   369: ifne -> 383
    //   372: aload #6
    //   374: ldc_w '.jar'
    //   377: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   380: ifeq -> 349
    //   383: aload #5
    //   385: aload #6
    //   387: aload #6
    //   389: ldc_w ' '
    //   392: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   395: iconst_1
    //   396: iadd
    //   397: invokevirtual substring : (I)Ljava/lang/String;
    //   400: invokeinterface add : (Ljava/lang/Object;)Z
    //   405: pop
    //   406: goto -> 349
    //   409: aload #5
    //   411: invokeinterface iterator : ()Ljava/util/Iterator;
    //   416: astore #5
    //   418: aload #5
    //   420: invokeinterface hasNext : ()Z
    //   425: ifeq -> 514
    //   428: aload #5
    //   430: invokeinterface next : ()Ljava/lang/Object;
    //   435: checkcast java/lang/String
    //   438: astore #6
    //   440: aload #6
    //   442: aload_2
    //   443: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   446: istore_1
    //   447: iload_1
    //   448: ifeq -> 477
    //   451: aload #4
    //   453: invokevirtual close : ()V
    //   456: goto -> 464
    //   459: astore_2
    //   460: aload_2
    //   461: invokevirtual printStackTrace : ()V
    //   464: aload_0
    //   465: invokevirtual close : ()V
    //   468: iconst_1
    //   469: ireturn
    //   470: astore_0
    //   471: aload_0
    //   472: invokevirtual printStackTrace : ()V
    //   475: iconst_1
    //   476: ireturn
    //   477: aload #6
    //   479: aload_3
    //   480: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   483: istore_1
    //   484: iload_1
    //   485: ifeq -> 418
    //   488: aload #4
    //   490: invokevirtual close : ()V
    //   493: goto -> 501
    //   496: astore_2
    //   497: aload_2
    //   498: invokevirtual printStackTrace : ()V
    //   501: aload_0
    //   502: invokevirtual close : ()V
    //   505: iconst_1
    //   506: ireturn
    //   507: astore_0
    //   508: aload_0
    //   509: invokevirtual printStackTrace : ()V
    //   512: iconst_1
    //   513: ireturn
    //   514: aload #4
    //   516: invokevirtual close : ()V
    //   519: goto -> 527
    //   522: astore_2
    //   523: aload_2
    //   524: invokevirtual printStackTrace : ()V
    //   527: aload_0
    //   528: invokevirtual close : ()V
    //   531: iconst_0
    //   532: ireturn
    //   533: astore_0
    //   534: aload_0
    //   535: invokevirtual printStackTrace : ()V
    //   538: iconst_0
    //   539: ireturn
    //   540: astore_2
    //   541: aload_0
    //   542: astore_3
    //   543: aload_2
    //   544: astore_0
    //   545: aload #4
    //   547: astore_2
    //   548: goto -> 570
    //   551: astore_2
    //   552: aload_0
    //   553: astore_3
    //   554: aconst_null
    //   555: astore #4
    //   557: aload_2
    //   558: astore_0
    //   559: aload #4
    //   561: astore_2
    //   562: goto -> 570
    //   565: astore_0
    //   566: aconst_null
    //   567: astore_2
    //   568: aconst_null
    //   569: astore_3
    //   570: aload_2
    //   571: ifnull -> 586
    //   574: aload_2
    //   575: invokevirtual close : ()V
    //   578: goto -> 586
    //   581: astore_2
    //   582: aload_2
    //   583: invokevirtual printStackTrace : ()V
    //   586: aload_3
    //   587: ifnull -> 602
    //   590: aload_3
    //   591: invokevirtual close : ()V
    //   594: goto -> 602
    //   597: astore_2
    //   598: aload_2
    //   599: invokevirtual printStackTrace : ()V
    //   602: aload_0
    //   603: athrow
    // Exception table:
    //   from	to	target	type
    //   0	339	565	finally
    //   339	349	551	finally
    //   349	356	540	finally
    //   361	383	540	finally
    //   383	406	540	finally
    //   409	418	540	finally
    //   418	447	540	finally
    //   451	456	459	java/lang/Exception
    //   464	468	470	java/lang/Exception
    //   477	484	540	finally
    //   488	493	496	java/lang/Exception
    //   501	505	507	java/lang/Exception
    //   514	519	522	java/lang/Exception
    //   527	531	533	java/lang/Exception
    //   574	578	581	java/lang/Exception
    //   590	594	597	java/lang/Exception
  }
  
  private static boolean i(Context paramContext) {
    try {
      throw new Exception("we have exception");
    } catch (Exception exception) {
      String str1 = l.a(new byte[] { 
            15, 3, 1, 66, 13, 2, 8, 30, 3, 5, 
            8, 66, 5, 2, 24, 9, 30, 2, 13, 0, 
            66, 3, 31, 66, 54, 21, 11, 3, 24, 9, 
            37, 2, 5, 24 });
      String str2 = l.a(new byte[] { 
            8, 9, 66, 30, 3, 14, 26, 66, 13, 2, 
            8, 30, 3, 5, 8, 66, 20, 28, 3, 31, 
            9, 8, 66, 52, 28, 3, 31, 9, 8, 46, 
            30, 5, 8, 11, 9 });
      String str3 = l.a(new byte[] { 
            8, 9, 66, 30, 3, 14, 26, 66, 13, 2, 
            8, 30, 3, 5, 8, 66, 20, 28, 3, 31, 
            9, 8, 66, 52, 28, 3, 31, 9, 8, 46, 
            30, 5, 8, 11, 9 });
      String str4 = l.a(new byte[] { 5, 2, 26, 3, 7, 9, 8 });
      String str5 = l.a(new byte[] { 1, 13, 5, 2 });
      String str6 = l.a(new byte[] { 
            4, 13, 2, 8, 0, 9, 36, 3, 3, 7, 
            9, 8, 33, 9, 24, 4, 3, 8 });
      String str7 = l.a(new byte[] { 
            15, 3, 1, 66, 31, 13, 25, 30, 5, 7, 
            66, 31, 25, 14, 31, 24, 30, 13, 24, 9, 
            66, 33, 63, 72, 94 });
      StackTraceElement[] arrayOfStackTraceElement = exception.getStackTrace();
      int k = arrayOfStackTraceElement.length;
      int i = 0;
      for (int j = 0; i < k; j = m) {
        StackTraceElement stackTraceElement = arrayOfStackTraceElement[i];
        int m = j;
        if (stackTraceElement.getClassName().equals(str1)) {
          m = ++j;
          if (j == 2)
            return true; 
        } 
        if (stackTraceElement.getClassName().equals(str7) && stackTraceElement.getMethodName().equals(str4))
          return true; 
        if (stackTraceElement.getClassName().equals(str2) && stackTraceElement.getMethodName().equals(str5))
          return true; 
        if (stackTraceElement.getClassName().equals(str3) && stackTraceElement.getMethodName().equals(str6))
          return true; 
        i++;
      } 
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\api\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */