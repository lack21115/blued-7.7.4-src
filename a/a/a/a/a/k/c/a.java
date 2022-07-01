package a.a.a.a.a.k.c;

import a.a.a.a.a.e.e;
import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Debug;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import android.view.Choreographer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Method;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class a {
  public static b a(Context paramContext) {
    if (Build.VERSION.SDK_INT < 16)
      return new b(0L, 0L, 0L, 0L); 
    ActivityManager activityManager = (ActivityManager)paramContext.getSystemService("activity");
    if (activityManager == null)
      return new b(0L, 0L, 0L, 0L); 
    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
    activityManager.getMemoryInfo(memoryInfo);
    Debug.MemoryInfo memoryInfo1 = new Debug.MemoryInfo();
    Debug.getMemoryInfo(memoryInfo1);
    long l1 = ((memoryInfo1.dalvikPrivateDirty + memoryInfo1.nativePrivateDirty) * 1024);
    long l2 = memoryInfo.totalMem;
    return new b(l2, l2 - memoryInfo.availMem, memoryInfo.threshold, l1);
  }
  
  public static String a() {
    try {
      DatagramSocket datagramSocket = new DatagramSocket();
      datagramSocket.connect(InetAddress.getByName("114.114.114.114"), 53);
      InetAddress inetAddress = datagramSocket.getLocalAddress();
      datagramSocket.close();
      if (inetAddress == null)
        return ""; 
      String str = inetAddress.getHostAddress();
      return (str != null) ? ("::".equals(str) ? "" : str) : "";
    } catch (IOException iOException) {
      return "";
    } 
  }
  
  public static String a(String paramString1, String paramString2, JSONObject paramJSONObject) {
    // Byte code:
    //   0: new java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial <init> : (Ljava/lang/String;)V
    //   8: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   11: checkcast java/net/HttpURLConnection
    //   14: astore_0
    //   15: goto -> 42
    //   18: aload_1
    //   19: ifnull -> 40
    //   22: new java/net/URL
    //   25: dup
    //   26: aload_1
    //   27: invokespecial <init> : (Ljava/lang/String;)V
    //   30: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   33: checkcast java/net/HttpURLConnection
    //   36: astore_0
    //   37: goto -> 42
    //   40: aconst_null
    //   41: astore_0
    //   42: aload_0
    //   43: ifnonnull -> 49
    //   46: ldc ''
    //   48: areturn
    //   49: aload_0
    //   50: sipush #3000
    //   53: invokevirtual setConnectTimeout : (I)V
    //   56: aload_0
    //   57: sipush #10000
    //   60: invokevirtual setReadTimeout : (I)V
    //   63: aload_0
    //   64: ldc 'POST'
    //   66: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   69: aload_0
    //   70: ldc 'Content-Type'
    //   72: ldc 'application/json'
    //   74: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload_0
    //   78: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   81: astore_1
    //   82: aload_1
    //   83: aload_2
    //   84: invokevirtual toString : ()Ljava/lang/String;
    //   87: invokevirtual getBytes : ()[B
    //   90: invokevirtual write : ([B)V
    //   93: aload_1
    //   94: invokevirtual flush : ()V
    //   97: aload_0
    //   98: invokevirtual getResponseCode : ()I
    //   101: istore_3
    //   102: goto -> 107
    //   105: iconst_0
    //   106: istore_3
    //   107: iload_3
    //   108: sipush #200
    //   111: if_icmpeq -> 117
    //   114: ldc ''
    //   116: areturn
    //   117: aload_0
    //   118: invokevirtual getContentLength : ()I
    //   121: istore #4
    //   123: iload #4
    //   125: ifne -> 131
    //   128: ldc ''
    //   130: areturn
    //   131: iload #4
    //   133: istore_3
    //   134: iload #4
    //   136: ifge -> 143
    //   139: sipush #16384
    //   142: istore_3
    //   143: aload_0
    //   144: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   147: astore_0
    //   148: iload_3
    //   149: newarray byte
    //   151: astore_1
    //   152: aload_0
    //   153: aload_1
    //   154: invokevirtual read : ([B)I
    //   157: istore_3
    //   158: aload_0
    //   159: invokevirtual close : ()V
    //   162: goto -> 165
    //   165: iload_3
    //   166: ifgt -> 172
    //   169: ldc ''
    //   171: areturn
    //   172: new java/lang/String
    //   175: dup
    //   176: aload_1
    //   177: iconst_0
    //   178: iload_3
    //   179: invokespecial <init> : ([BII)V
    //   182: areturn
    //   183: astore_1
    //   184: aload_0
    //   185: invokevirtual close : ()V
    //   188: aload_1
    //   189: athrow
    //   190: aload_0
    //   191: invokevirtual close : ()V
    //   194: ldc ''
    //   196: areturn
    //   197: astore_0
    //   198: goto -> 18
    //   201: astore_0
    //   202: goto -> 40
    //   205: astore_1
    //   206: goto -> 69
    //   209: astore_0
    //   210: ldc ''
    //   212: areturn
    //   213: astore_1
    //   214: goto -> 105
    //   217: astore_1
    //   218: goto -> 190
    //   221: astore_0
    //   222: goto -> 165
    //   225: astore_0
    //   226: goto -> 188
    // Exception table:
    //   from	to	target	type
    //   0	15	197	java/io/IOException
    //   0	15	201	java/lang/Exception
    //   22	37	201	java/io/IOException
    //   63	69	205	java/net/ProtocolException
    //   77	97	209	java/io/IOException
    //   77	97	209	java/lang/Exception
    //   97	102	213	java/io/IOException
    //   143	148	209	java/io/IOException
    //   152	158	217	java/io/IOException
    //   152	158	183	finally
    //   158	162	221	java/io/IOException
    //   184	188	225	java/io/IOException
    //   190	194	209	java/io/IOException
  }
  
  public static boolean a(Context paramContext, String paramString) {
    return (paramContext.checkCallingOrSelfPermission(paramString) == 0);
  }
  
  public static String b(Context paramContext) {
    if (paramContext == null)
      return ""; 
    ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (connectivityManager == null)
      return "None"; 
    try {
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      if (networkInfo != null && networkInfo.isConnected()) {
        if (networkInfo.getState() != NetworkInfo.State.CONNECTED)
          return "None"; 
        int i = networkInfo.getType();
        return (i == 1) ? "WIFI" : networkInfo.getSubtypeName();
      } 
      return "None";
    } catch (Exception exception) {
      return "Unknown";
    } 
  }
  
  public static InetAddress[] b() {
    try {
      LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("getprop").getInputStream()));
      ArrayList<InetAddress> arrayList = new ArrayList(5);
      while (true) {
        String str = lineNumberReader.readLine();
        if (str != null) {
          int i = str.indexOf("]: [");
          if (i != -1) {
            int j = i + 4;
            if (j + 7 > str.length() - 1)
              continue; 
            String str1 = str.substring(1, i);
            str = str.substring(j, str.length() - 1);
            if (str1.endsWith(".dns") || str1.endsWith(".dns1") || str1.endsWith(".dns2") || str1.endsWith(".dns3") || str1.endsWith(".dns4")) {
              InetAddress inetAddress = InetAddress.getByName(str);
              if (inetAddress == null)
                continue; 
              str = inetAddress.getHostAddress();
              if (str == null || str.length() == 0)
                continue; 
              arrayList.add(inetAddress);
            } 
          } 
          continue;
        } 
        return (arrayList.size() > 0) ? arrayList.<InetAddress>toArray(new InetAddress[arrayList.size()]) : null;
      } 
    } catch (IOException iOException) {
      e e = e.c;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Exception in findDNSByExec: ");
      stringBuilder.append(iOException);
      e.b(stringBuilder.toString());
    } 
    return null;
  }
  
  public static boolean c(Context paramContext) {
    if (paramContext == null)
      return true; 
    String str = paramContext.getPackageName();
    if (str == null)
      return true; 
    List list = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (list == null)
      return true; 
    Iterator<ActivityManager.RunningAppProcessInfo> iterator = list.iterator();
    while (iterator.hasNext()) {
      ActivityManager.RunningAppProcessInfo runningAppProcessInfo = iterator.next();
      if (str.equals(runningAppProcessInfo.processName)) {
        if (runningAppProcessInfo.importance != 100) {
          e e1 = e.c;
          str1 = paramContext.getPackageName();
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Background");
          stringBuilder1.append(runningAppProcessInfo.processName);
          e1.c(str1, stringBuilder1.toString());
          return true;
        } 
        e e = e.c;
        String str1 = str1.getPackageName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Foreground");
        stringBuilder.append(runningAppProcessInfo.processName);
        e.c(str1, stringBuilder.toString());
        break;
      } 
    } 
    return false;
  }
  
  public static InetAddress[] c() {
    try {
      Class<?> clazz = Class.forName("android.os.SystemProperties");
      Method method = clazz.getMethod("get", new Class[] { String.class });
      ArrayList<InetAddress> arrayList = new ArrayList(5);
      for (int i = 0;; i++) {
        if (i < 4) {
          (new String[4])[0] = "net.dns1";
          (new String[4])[1] = "net.dns2";
          (new String[4])[2] = "net.dns3";
          (new String[4])[3] = "net.dns4";
          String str = (String)method.invoke(null, new Object[] { (new String[4])[i] });
          if (str != null && str.length() != 0) {
            InetAddress inetAddress = InetAddress.getByName(str);
            if (inetAddress != null) {
              String str1 = inetAddress.getHostAddress();
              if (str1 != null && str1.length() != 0 && !arrayList.contains(inetAddress))
                arrayList.add(inetAddress); 
            } 
          } 
        } else {
          return (arrayList.size() > 0) ? arrayList.<InetAddress>toArray(new InetAddress[arrayList.size()]) : null;
        } 
      } 
    } catch (Exception exception) {
      e e = e.c;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Exception in findDNSByReflection");
      stringBuilder.append(exception);
      e.b(stringBuilder.toString());
    } 
    return null;
  }
  
  public static String d() {
    InetAddress[] arrayOfInetAddress2 = c();
    String str = "";
    InetAddress[] arrayOfInetAddress1 = arrayOfInetAddress2;
    if (arrayOfInetAddress2 == null) {
      arrayOfInetAddress2 = b();
      arrayOfInetAddress1 = arrayOfInetAddress2;
      if (arrayOfInetAddress2 == null)
        return ""; 
    } 
    int j = arrayOfInetAddress1.length;
    String[] arrayOfString = new String[j];
    for (int i = 0; i < j; i++) {
      arrayOfString[i] = arrayOfInetAddress1[i].toString();
      if (arrayOfString[i].indexOf('/') == 0) {
        arrayOfString[i] = arrayOfString[i].substring(1);
        str = arrayOfString[i];
      } 
    } 
    return str;
  }
  
  public static boolean d(Context paramContext) {
    if (paramContext != null)
      try {
        if (a(paramContext, "android.permission.READ_PHONE_STATE")) {
          boolean bool = a(paramContext, "android.permission.ACCESS_COARSE_LOCATION");
          if (bool)
            return true; 
        } 
      } catch (RuntimeException runtimeException) {
        e e = e.e;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getPhonePermission failed: ");
        stringBuilder.append(runtimeException.getMessage());
        e.e("QosUtil", stringBuilder.toString());
      }  
    return false;
  }
  
  public static a e() {
    // Byte code:
    //   0: new java/io/BufferedReader
    //   3: dup
    //   4: new java/io/FileReader
    //   7: dup
    //   8: ldc_w '/proc/stat'
    //   11: invokespecial <init> : (Ljava/lang/String;)V
    //   14: invokespecial <init> : (Ljava/io/Reader;)V
    //   17: astore #38
    //   19: aload #38
    //   21: invokevirtual readLine : ()Ljava/lang/String;
    //   24: ldc_w '[ ]+'
    //   27: bipush #9
    //   29: invokevirtual split : (Ljava/lang/String;I)[Ljava/lang/String;
    //   32: astore #39
    //   34: aload #39
    //   36: iconst_1
    //   37: aaload
    //   38: invokestatic parseLong : (Ljava/lang/String;)J
    //   41: aload #39
    //   43: iconst_2
    //   44: aaload
    //   45: invokestatic parseLong : (Ljava/lang/String;)J
    //   48: ladd
    //   49: aload #39
    //   51: iconst_3
    //   52: aaload
    //   53: invokestatic parseLong : (Ljava/lang/String;)J
    //   56: ladd
    //   57: lstore_2
    //   58: aload #39
    //   60: iconst_4
    //   61: aaload
    //   62: invokestatic parseLong : (Ljava/lang/String;)J
    //   65: lstore #4
    //   67: aload #39
    //   69: iconst_5
    //   70: aaload
    //   71: invokestatic parseLong : (Ljava/lang/String;)J
    //   74: lstore #6
    //   76: aload #39
    //   78: bipush #6
    //   80: aaload
    //   81: invokestatic parseLong : (Ljava/lang/String;)J
    //   84: lstore #8
    //   86: aload #39
    //   88: bipush #7
    //   90: aaload
    //   91: invokestatic parseLong : (Ljava/lang/String;)J
    //   94: lstore #10
    //   96: aload #38
    //   98: invokevirtual close : ()V
    //   101: new java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial <init> : ()V
    //   108: astore #38
    //   110: aload #38
    //   112: ldc_w '/proc/'
    //   115: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload #38
    //   121: invokestatic myPid : ()I
    //   124: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload #38
    //   130: ldc_w '/stat'
    //   133: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: new java/io/BufferedReader
    //   140: dup
    //   141: new java/io/FileReader
    //   144: dup
    //   145: aload #38
    //   147: invokevirtual toString : ()Ljava/lang/String;
    //   150: invokespecial <init> : (Ljava/lang/String;)V
    //   153: invokespecial <init> : (Ljava/io/Reader;)V
    //   156: astore #38
    //   158: aload #38
    //   160: invokevirtual readLine : ()Ljava/lang/String;
    //   163: ldc_w '[ ]+'
    //   166: bipush #18
    //   168: invokevirtual split : (Ljava/lang/String;I)[Ljava/lang/String;
    //   171: astore #39
    //   173: aload #39
    //   175: bipush #13
    //   177: aaload
    //   178: invokestatic parseLong : (Ljava/lang/String;)J
    //   181: lstore #12
    //   183: aload #39
    //   185: bipush #14
    //   187: aaload
    //   188: invokestatic parseLong : (Ljava/lang/String;)J
    //   191: lstore #14
    //   193: aload #39
    //   195: bipush #15
    //   197: aaload
    //   198: invokestatic parseLong : (Ljava/lang/String;)J
    //   201: lstore #16
    //   203: aload #39
    //   205: bipush #16
    //   207: aaload
    //   208: invokestatic parseLong : (Ljava/lang/String;)J
    //   211: lstore #18
    //   213: aload #38
    //   215: invokevirtual close : ()V
    //   218: aload #38
    //   220: invokevirtual close : ()V
    //   223: ldc2_w 100
    //   226: invokestatic sleep : (J)V
    //   229: new java/io/BufferedReader
    //   232: dup
    //   233: new java/io/FileReader
    //   236: dup
    //   237: ldc_w '/proc/stat'
    //   240: invokespecial <init> : (Ljava/lang/String;)V
    //   243: invokespecial <init> : (Ljava/io/Reader;)V
    //   246: astore #38
    //   248: aload #38
    //   250: invokevirtual readLine : ()Ljava/lang/String;
    //   253: ldc_w '[ ]+'
    //   256: bipush #9
    //   258: invokevirtual split : (Ljava/lang/String;I)[Ljava/lang/String;
    //   261: astore #39
    //   263: aload #39
    //   265: iconst_1
    //   266: aaload
    //   267: invokestatic parseLong : (Ljava/lang/String;)J
    //   270: aload #39
    //   272: iconst_2
    //   273: aaload
    //   274: invokestatic parseLong : (Ljava/lang/String;)J
    //   277: ladd
    //   278: aload #39
    //   280: iconst_3
    //   281: aaload
    //   282: invokestatic parseLong : (Ljava/lang/String;)J
    //   285: ladd
    //   286: lstore #20
    //   288: aload #39
    //   290: iconst_4
    //   291: aaload
    //   292: invokestatic parseLong : (Ljava/lang/String;)J
    //   295: lstore #22
    //   297: aload #39
    //   299: iconst_5
    //   300: aaload
    //   301: invokestatic parseLong : (Ljava/lang/String;)J
    //   304: lstore #24
    //   306: aload #39
    //   308: bipush #6
    //   310: aaload
    //   311: invokestatic parseLong : (Ljava/lang/String;)J
    //   314: lstore #26
    //   316: aload #39
    //   318: bipush #7
    //   320: aaload
    //   321: invokestatic parseLong : (Ljava/lang/String;)J
    //   324: lstore #28
    //   326: aload #38
    //   328: invokevirtual close : ()V
    //   331: new java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial <init> : ()V
    //   338: astore #38
    //   340: aload #38
    //   342: ldc_w '/proc/'
    //   345: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload #38
    //   351: invokestatic myPid : ()I
    //   354: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload #38
    //   360: ldc_w '/stat'
    //   363: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: new java/io/BufferedReader
    //   370: dup
    //   371: new java/io/FileReader
    //   374: dup
    //   375: aload #38
    //   377: invokevirtual toString : ()Ljava/lang/String;
    //   380: invokespecial <init> : (Ljava/lang/String;)V
    //   383: invokespecial <init> : (Ljava/io/Reader;)V
    //   386: astore #39
    //   388: aload #39
    //   390: astore #38
    //   392: aload #39
    //   394: invokevirtual readLine : ()Ljava/lang/String;
    //   397: ldc_w '[ ]+'
    //   400: bipush #18
    //   402: invokevirtual split : (Ljava/lang/String;I)[Ljava/lang/String;
    //   405: astore #40
    //   407: aload #39
    //   409: astore #38
    //   411: aload #40
    //   413: bipush #13
    //   415: aaload
    //   416: invokestatic parseLong : (Ljava/lang/String;)J
    //   419: lstore #30
    //   421: aload #39
    //   423: astore #38
    //   425: aload #40
    //   427: bipush #14
    //   429: aaload
    //   430: invokestatic parseLong : (Ljava/lang/String;)J
    //   433: lstore #32
    //   435: aload #39
    //   437: astore #38
    //   439: aload #40
    //   441: bipush #15
    //   443: aaload
    //   444: invokestatic parseLong : (Ljava/lang/String;)J
    //   447: lstore #34
    //   449: aload #39
    //   451: astore #38
    //   453: aload #40
    //   455: bipush #16
    //   457: aaload
    //   458: invokestatic parseLong : (Ljava/lang/String;)J
    //   461: lstore #36
    //   463: aload #39
    //   465: astore #38
    //   467: aload #39
    //   469: invokevirtual close : ()V
    //   472: aload #39
    //   474: invokevirtual close : ()V
    //   477: goto -> 480
    //   480: lload #20
    //   482: lload_2
    //   483: lsub
    //   484: ldc2_w 100
    //   487: lmul
    //   488: l2f
    //   489: fstore_1
    //   490: lload #22
    //   492: lload #20
    //   494: ladd
    //   495: lload #24
    //   497: ladd
    //   498: lload #26
    //   500: ladd
    //   501: lload #28
    //   503: ladd
    //   504: lload #4
    //   506: lload_2
    //   507: ladd
    //   508: lload #6
    //   510: ladd
    //   511: lload #8
    //   513: ladd
    //   514: lload #10
    //   516: ladd
    //   517: lsub
    //   518: l2f
    //   519: fstore_0
    //   520: fload_1
    //   521: fload_0
    //   522: fdiv
    //   523: fstore_1
    //   524: lload #30
    //   526: lload #32
    //   528: ladd
    //   529: lload #34
    //   531: ladd
    //   532: lload #36
    //   534: ladd
    //   535: lload #12
    //   537: lload #14
    //   539: ladd
    //   540: lload #16
    //   542: ladd
    //   543: lload #18
    //   545: ladd
    //   546: lsub
    //   547: ldc2_w 100
    //   550: lmul
    //   551: l2f
    //   552: fload_0
    //   553: fdiv
    //   554: fstore_0
    //   555: fload_1
    //   556: fconst_0
    //   557: fcmpg
    //   558: iflt -> 582
    //   561: fload_1
    //   562: ldc_w 100.0
    //   565: fcmpl
    //   566: ifle -> 572
    //   569: goto -> 582
    //   572: new a/a/a/a/a/k/c/a$a
    //   575: dup
    //   576: fload_1
    //   577: fload_0
    //   578: invokespecial <init> : (FF)V
    //   581: areturn
    //   582: new a/a/a/a/a/k/c/a$a
    //   585: dup
    //   586: fconst_0
    //   587: fconst_0
    //   588: invokespecial <init> : (FF)V
    //   591: areturn
    //   592: astore #38
    //   594: aconst_null
    //   595: astore #39
    //   597: goto -> 641
    //   600: aconst_null
    //   601: astore #39
    //   603: aload #39
    //   605: astore #38
    //   607: new a/a/a/a/a/k/c/a$a
    //   610: dup
    //   611: fconst_0
    //   612: fconst_0
    //   613: invokespecial <init> : (FF)V
    //   616: astore #40
    //   618: aload #39
    //   620: ifnull -> 628
    //   623: aload #39
    //   625: invokevirtual close : ()V
    //   628: aload #40
    //   630: areturn
    //   631: astore #40
    //   633: aload #38
    //   635: astore #39
    //   637: aload #40
    //   639: astore #38
    //   641: aload #39
    //   643: ifnull -> 651
    //   646: aload #39
    //   648: invokevirtual close : ()V
    //   651: aload #38
    //   653: athrow
    //   654: astore #40
    //   656: aload #38
    //   658: astore #39
    //   660: aload #40
    //   662: astore #38
    //   664: goto -> 715
    //   667: goto -> 681
    //   670: astore #38
    //   672: aconst_null
    //   673: astore #39
    //   675: goto -> 715
    //   678: aconst_null
    //   679: astore #38
    //   681: new a/a/a/a/a/k/c/a$a
    //   684: dup
    //   685: fconst_0
    //   686: fconst_0
    //   687: invokespecial <init> : (FF)V
    //   690: astore #39
    //   692: aload #38
    //   694: ifnull -> 702
    //   697: aload #38
    //   699: invokevirtual close : ()V
    //   702: aload #39
    //   704: areturn
    //   705: astore #40
    //   707: aload #38
    //   709: astore #39
    //   711: aload #40
    //   713: astore #38
    //   715: aload #39
    //   717: ifnull -> 725
    //   720: aload #39
    //   722: invokevirtual close : ()V
    //   725: aload #38
    //   727: athrow
    //   728: astore #40
    //   730: aload #38
    //   732: astore #39
    //   734: aload #40
    //   736: astore #38
    //   738: goto -> 789
    //   741: goto -> 755
    //   744: astore #38
    //   746: aconst_null
    //   747: astore #39
    //   749: goto -> 789
    //   752: aconst_null
    //   753: astore #38
    //   755: new a/a/a/a/a/k/c/a$a
    //   758: dup
    //   759: fconst_0
    //   760: fconst_0
    //   761: invokespecial <init> : (FF)V
    //   764: astore #39
    //   766: aload #38
    //   768: ifnull -> 776
    //   771: aload #38
    //   773: invokevirtual close : ()V
    //   776: aload #39
    //   778: areturn
    //   779: astore #40
    //   781: aload #38
    //   783: astore #39
    //   785: aload #40
    //   787: astore #38
    //   789: aload #39
    //   791: ifnull -> 799
    //   794: aload #39
    //   796: invokevirtual close : ()V
    //   799: aload #38
    //   801: athrow
    //   802: astore #40
    //   804: aload #38
    //   806: astore #39
    //   808: aload #40
    //   810: astore #38
    //   812: goto -> 909
    //   815: aload #38
    //   817: astore #39
    //   819: goto -> 840
    //   822: aload #38
    //   824: astore #39
    //   826: goto -> 871
    //   829: astore #38
    //   831: aconst_null
    //   832: astore #39
    //   834: goto -> 909
    //   837: aconst_null
    //   838: astore #39
    //   840: aload #39
    //   842: astore #38
    //   844: new a/a/a/a/a/k/c/a$a
    //   847: dup
    //   848: fconst_0
    //   849: fconst_0
    //   850: invokespecial <init> : (FF)V
    //   853: astore #40
    //   855: aload #39
    //   857: ifnull -> 865
    //   860: aload #39
    //   862: invokevirtual close : ()V
    //   865: aload #40
    //   867: areturn
    //   868: aconst_null
    //   869: astore #39
    //   871: aload #39
    //   873: astore #38
    //   875: new a/a/a/a/a/k/c/a$a
    //   878: dup
    //   879: fconst_0
    //   880: fconst_0
    //   881: invokespecial <init> : (FF)V
    //   884: astore #40
    //   886: aload #39
    //   888: ifnull -> 896
    //   891: aload #39
    //   893: invokevirtual close : ()V
    //   896: aload #40
    //   898: areturn
    //   899: astore #40
    //   901: aload #38
    //   903: astore #39
    //   905: aload #40
    //   907: astore #38
    //   909: aload #39
    //   911: ifnull -> 919
    //   914: aload #39
    //   916: invokevirtual close : ()V
    //   919: aload #38
    //   921: athrow
    //   922: astore #38
    //   924: goto -> 868
    //   927: astore #38
    //   929: goto -> 837
    //   932: astore #39
    //   934: goto -> 822
    //   937: astore #39
    //   939: goto -> 815
    //   942: astore #38
    //   944: goto -> 101
    //   947: astore #38
    //   949: goto -> 752
    //   952: astore #39
    //   954: goto -> 741
    //   957: astore #38
    //   959: goto -> 223
    //   962: astore #38
    //   964: goto -> 229
    //   967: astore #38
    //   969: goto -> 678
    //   972: astore #39
    //   974: goto -> 667
    //   977: astore #38
    //   979: goto -> 331
    //   982: astore #38
    //   984: goto -> 600
    //   987: astore #38
    //   989: goto -> 603
    //   992: astore #38
    //   994: goto -> 480
    //   997: astore #38
    //   999: aload #40
    //   1001: areturn
    //   1002: astore #39
    //   1004: goto -> 651
    //   1007: astore #38
    //   1009: aload #39
    //   1011: areturn
    //   1012: astore #39
    //   1014: goto -> 725
    //   1017: astore #38
    //   1019: aload #39
    //   1021: areturn
    //   1022: astore #39
    //   1024: goto -> 799
    //   1027: astore #38
    //   1029: aload #40
    //   1031: areturn
    //   1032: astore #38
    //   1034: aload #40
    //   1036: areturn
    //   1037: astore #39
    //   1039: goto -> 919
    // Exception table:
    //   from	to	target	type
    //   0	19	922	java/io/IOException
    //   0	19	927	java/lang/Exception
    //   0	19	829	finally
    //   19	96	932	java/io/IOException
    //   19	96	937	java/lang/Exception
    //   19	96	802	finally
    //   96	101	942	java/io/IOException
    //   101	158	947	java/io/IOException
    //   101	158	744	finally
    //   158	218	952	java/io/IOException
    //   158	218	728	finally
    //   218	223	957	java/io/IOException
    //   223	229	962	java/lang/InterruptedException
    //   229	248	967	java/io/IOException
    //   229	248	670	finally
    //   248	326	972	java/io/IOException
    //   248	326	654	finally
    //   326	331	977	java/io/IOException
    //   331	388	982	java/io/IOException
    //   331	388	592	finally
    //   392	407	987	java/io/IOException
    //   392	407	631	finally
    //   411	421	987	java/io/IOException
    //   411	421	631	finally
    //   425	435	987	java/io/IOException
    //   425	435	631	finally
    //   439	449	987	java/io/IOException
    //   439	449	631	finally
    //   453	463	987	java/io/IOException
    //   453	463	631	finally
    //   467	472	987	java/io/IOException
    //   467	472	631	finally
    //   472	477	992	java/io/IOException
    //   607	618	631	finally
    //   623	628	997	java/io/IOException
    //   646	651	1002	java/io/IOException
    //   681	692	705	finally
    //   697	702	1007	java/io/IOException
    //   720	725	1012	java/io/IOException
    //   755	766	779	finally
    //   771	776	1017	java/io/IOException
    //   794	799	1022	java/io/IOException
    //   844	855	899	finally
    //   860	865	1027	java/io/IOException
    //   875	886	899	finally
    //   891	896	1032	java/io/IOException
    //   914	919	1037	java/io/IOException
  }
  
  public static boolean e(Context paramContext) {
    if (paramContext != null)
      try {
        return a(paramContext, "android.permission.ACCESS_WIFI_STATE");
      } catch (RuntimeException runtimeException) {
        e e = e.e;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getWifiPermission failed: ");
        stringBuilder.append(runtimeException.getMessage());
        e.e("QosUtil", stringBuilder.toString());
      }  
    return false;
  }
  
  public static void f() {
    if (Build.VERSION.SDK_INT >= 16) {
      a.a.a.a.a.k.d.a.a.a();
      try {
        Choreographer.getInstance().postFrameCallback((Choreographer.FrameCallback)a.a.a.a.a.k.d.a.a);
        return;
      } catch (RuntimeException runtimeException) {
        runtimeException.printStackTrace();
      } 
    } 
  }
  
  public static String[] f(Context paramContext) {
    if (e(paramContext)) {
      WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
      if (wifiManager != null) {
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if (wifiInfo != null)
          return new String[] { wifiInfo.getSSID(), Integer.toString(wifiInfo.getRssi()) }; 
      } 
    } 
    return null;
  }
  
  public static void g() {
    if (Build.VERSION.SDK_INT >= 16)
      a.a.a.a.a.k.d.a.a.b(); 
  }
  
  public static String[] g(Context paramContext) {
    CellInfo cellInfo;
    TelephonyManager telephonyManager2 = null;
    TelephonyManager telephonyManager1 = telephonyManager2;
    if (paramContext != null) {
      telephonyManager1 = telephonyManager2;
      if (d(paramContext)) {
        telephonyManager1 = telephonyManager2;
        if (Build.VERSION.SDK_INT > 17) {
          telephonyManager1 = (TelephonyManager)paramContext.getSystemService("phone");
          if (telephonyManager1 == null)
            return null; 
          String[] arrayOfString1 = { "", "" };
          String str = telephonyManager1.getNetworkOperatorName();
          int i = 0;
          arrayOfString1[0] = str;
          List<CellInfo> list = telephonyManager1.getAllCellInfo();
          String[] arrayOfString2 = arrayOfString1;
          if (list != null)
            while (true) {
              arrayOfString2 = arrayOfString1;
              if (i < list.size()) {
                if (((CellInfo)list.get(i)).isRegistered()) {
                  cellInfo = list.get(i);
                  if (cellInfo instanceof CellInfoCdma) {
                    arrayOfString1[1] = String.valueOf(((CellInfoCdma)cellInfo).getCellSignalStrength().getLevel());
                  } else if (cellInfo instanceof CellInfoWcdma) {
                    arrayOfString1[1] = String.valueOf(((CellInfoWcdma)cellInfo).getCellSignalStrength().getLevel());
                  } else if (cellInfo instanceof CellInfoGsm) {
                    arrayOfString1[1] = String.valueOf(((CellInfoGsm)cellInfo).getCellSignalStrength().getLevel());
                  } else if (cellInfo instanceof CellInfoLte) {
                    arrayOfString1[1] = String.valueOf(((CellInfoLte)cellInfo).getCellSignalStrength().getLevel());
                  } 
                } 
                i++;
                continue;
              } 
              break;
            }  
        } 
      } 
    } 
    return (String[])cellInfo;
  }
  
  public static int h() {
    return (Build.VERSION.SDK_INT >= 16) ? a.a.a.a.a.k.d.a.a.c() : 60;
  }
  
  public static class a {
    public final float a;
    
    public final float b;
    
    public a(float param1Float1, float param1Float2) {
      this.a = param1Float1;
      this.b = param1Float2;
    }
  }
  
  public static class b {
    public final long a;
    
    public final long b;
    
    public final long c;
    
    public b(long param1Long1, long param1Long2, long param1Long3, long param1Long4) {
      this.a = param1Long1;
      this.b = param1Long2;
      this.c = param1Long4;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\k\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */