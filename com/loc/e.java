package com.loc;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;

public final class e {
  static boolean g = false;
  
  private i A = null;
  
  private List<Messenger> B;
  
  private boolean C = true;
  
  private String D = "";
  
  private final int E = 5000;
  
  private String F = "jsonp1";
  
  String a = null;
  
  b b = null;
  
  AMapLocation c = null;
  
  a d = null;
  
  Context e = null;
  
  dn f = null;
  
  HashMap<Messenger, Long> h = new HashMap<Messenger, Long>();
  
  en i = null;
  
  long j = 0L;
  
  long k = 0L;
  
  String l = null;
  
  AMapLocationClientOption m = null;
  
  AMapLocationClientOption n = new AMapLocationClientOption();
  
  ServerSocket o = null;
  
  boolean p = false;
  
  Socket q = null;
  
  boolean r = false;
  
  c s = null;
  
  private boolean t = false;
  
  private boolean u = false;
  
  private long v = 0L;
  
  private long w = 0L;
  
  private ds x = null;
  
  private long y = 0L;
  
  private int z = 0;
  
  public e(Context paramContext) {
    this.e = paramContext;
  }
  
  private static ds a(int paramInt, String paramString) {
    try {
      ds ds1 = new ds("");
      return ds1;
    } finally {
      paramString = null;
      ej.a((Throwable)paramString, "ApsServiceCore", "newInstanceAMapLoc");
    } 
  }
  
  private void a(Bundle paramBundle) {
    try {
      if (this.t)
        return; 
      ej.a(this.e);
      if (paramBundle != null)
        this.n = ej.a(paramBundle.getBundle("optBundle")); 
      this.f.a(this.e);
      this.f.a();
      a(this.n);
      this.f.b();
      return;
    } finally {
      paramBundle = null;
      this.C = false;
      this.D = paramBundle.getMessage();
      ej.a((Throwable)paramBundle, "ApsServiceCore", "init");
    } 
  }
  
  private static void a(Messenger paramMessenger, int paramInt, Bundle paramBundle) {
    if (paramMessenger != null)
      try {
        Message message = Message.obtain();
        message.setData(paramBundle);
        message.what = paramInt;
        return;
      } finally {
        paramMessenger = null;
      }  
  }
  
  private void a(Messenger paramMessenger, AMapLocation paramAMapLocation, String paramString, dm paramdm) {
    Bundle bundle = new Bundle();
    bundle.setClassLoader(AMapLocation.class.getClassLoader());
    bundle.putParcelable("loc", (Parcelable)paramAMapLocation);
    bundle.putString("nb", paramString);
    bundle.putParcelable("statics", paramdm);
    this.h.put(paramMessenger, Long.valueOf(ep.b()));
    a(paramMessenger, 1, bundle);
  }
  
  private void a(AMapLocationClientOption paramAMapLocationClientOption) {
    try {
      return;
    } finally {
      paramAMapLocationClientOption = null;
      ej.a((Throwable)paramAMapLocationClientOption, "ApsServiceCore", "setExtra");
    } 
  }
  
  private void a(BufferedReader paramBufferedReader) throws Exception {
    String str = paramBufferedReader.readLine();
    int k = 30000;
    int j = k;
    if (str != null) {
      j = k;
      if (str.length() > 0) {
        String[] arrayOfString = str.split(" ");
        j = k;
        if (arrayOfString != null) {
          j = k;
          if (arrayOfString.length > 1) {
            arrayOfString = arrayOfString[1].split("\\?");
            j = k;
            if (arrayOfString != null) {
              j = k;
              if (arrayOfString.length > 1) {
                arrayOfString = arrayOfString[1].split("&");
                j = k;
                if (arrayOfString != null) {
                  j = k;
                  if (arrayOfString.length > 0) {
                    k = 0;
                    for (j = 30000; k < arrayOfString.length; j = m) {
                      String[] arrayOfString1 = arrayOfString[k].split("=");
                      int m = j;
                      if (arrayOfString1 != null) {
                        m = j;
                        if (arrayOfString1.length > 1) {
                          if ("to".equals(arrayOfString1[0]))
                            j = ep.g(arrayOfString1[1]); 
                          m = j;
                          if ("callback".equals(arrayOfString1[0])) {
                            this.F = arrayOfString1[1];
                            m = j;
                          } 
                        } 
                      } 
                      k++;
                    } 
                  } 
                } 
              } 
            } 
          } 
        } 
      } 
    } 
    ej.g = j;
  }
  
  private AMapLocationClientOption b(Bundle paramBundle) {
    AMapLocationClientOption aMapLocationClientOption = ej.a(paramBundle.getBundle("optBundle"));
    a(aMapLocationClientOption);
    try {
      String str = paramBundle.getString("d");
      if (!TextUtils.isEmpty(str))
        return aMapLocationClientOption; 
    } finally {
      paramBundle = null;
    } 
  }
  
  private void b(String paramString) throws UnsupportedEncodingException, IOException {
    PrintStream printStream = new PrintStream(this.q.getOutputStream(), true, "UTF-8");
    printStream.println("HTTP/1.0 200 OK");
    StringBuilder stringBuilder = new StringBuilder("Content-Length:");
    stringBuilder.append((paramString.getBytes("UTF-8")).length);
    printStream.println(stringBuilder.toString());
    printStream.println();
    printStream.println(paramString);
    printStream.close();
  }
  
  public static void d() {
    g = false;
  }
  
  private String e() {
    long l = System.currentTimeMillis();
    if (ep.e(this.e)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(this.F);
      stringBuilder.append("&&");
      stringBuilder.append(this.F);
      stringBuilder.append("({'package':'");
      stringBuilder.append(this.a);
      String str1 = "','error_code':36,'error':'app is background'})";
      stringBuilder.append(str1);
      return stringBuilder.toString();
    } 
    ds ds1 = this.x;
    if (ds1 == null || l - ds1.getTime() > 5000L)
      try {
        dm dm = new dm();
        this.x = this.f.a(dm);
      } finally {
        ds1 = null;
      }  
    ds1 = this.x;
    if (ds1 == null) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(this.F);
      stringBuilder.append("&&");
      stringBuilder.append(this.F);
      stringBuilder.append("({'package':'");
      stringBuilder.append(this.a);
      String str1 = "','error_code':8,'error':'unknown error'})";
      stringBuilder.append(str1);
      return stringBuilder.toString();
    } 
    if (stringBuilder.getErrorCode() != 0) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(this.F);
      stringBuilder.append("&&");
      stringBuilder.append(this.F);
      stringBuilder.append("({'package':'");
      stringBuilder.append(this.a);
      stringBuilder.append("','error_code':");
      stringBuilder.append(this.x.getErrorCode());
      stringBuilder.append(",'error':'");
      stringBuilder.append(this.x.getErrorInfo());
      String str1 = "'})";
      stringBuilder.append(str1);
      return stringBuilder.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.F);
    stringBuilder.append("&&");
    stringBuilder.append(this.F);
    stringBuilder.append("({'package':'");
    stringBuilder.append(this.a);
    stringBuilder.append("','error_code':0,'error':'','location':{'y':");
    stringBuilder.append(this.x.getLatitude());
    stringBuilder.append(",'precision':");
    stringBuilder.append(this.x.getAccuracy());
    stringBuilder.append(",'x':");
    stringBuilder.append(this.x.getLongitude());
    String str = "},'version_code':'5.2.0','version':'5.2.0'})";
    stringBuilder.append(str);
    return stringBuilder.toString();
  }
  
  private void f() {
    try {
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "ApsServiceCore", "startColl");
    } 
  }
  
  public final void a() {
    try {
      this.i = new en();
      this.b = new b(this, "amapLocCoreThread");
      this.b.setPriority(5);
      this.b.start();
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "ApsServiceCore", "onCreate");
    } 
  }
  
  final void a(Messenger paramMessenger, Bundle paramBundle) {
    if (paramBundle != null)
      try {
        float f;
        if (paramBundle.isEmpty())
          return; 
        if (!ei.h())
          return; 
        double d1 = paramBundle.getDouble("lat");
        double d2 = paramBundle.getDouble("lon");
        b(paramBundle);
        if (this.c != null) {
          float f1 = ep.a(new double[] { d1, d2, this.c.getLatitude(), this.c.getLongitude() });
          f = f1;
          if (f1 < (ei.i() * 3)) {
            Bundle bundle = new Bundle();
            bundle.setClassLoader(AMapLocation.class.getClassLoader());
            bundle.putInt("I_MAX_GEO_DIS", ei.i() * 3);
            bundle.putInt("I_MIN_GEO_DIS", ei.i());
            bundle.putParcelable("loc", (Parcelable)this.c);
            a(paramMessenger, 6, bundle);
            f = f1;
          } 
        } else {
          f = -1.0F;
        } 
        return;
      } finally {
        paramMessenger = null;
      }  
  }
  
  public final void b() {
    try {
      if (this.q != null)
        this.q.close(); 
    } finally {
      Exception exception = null;
    } 
    this.s = null;
    this.o = null;
    this.p = false;
    this.r = false;
  }
  
  public final void c() {
    // Byte code:
    //   0: aload_0
    //   1: getfield h : Ljava/util/HashMap;
    //   4: ifnull -> 19
    //   7: aload_0
    //   8: getfield h : Ljava/util/HashMap;
    //   11: invokevirtual clear : ()V
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield h : Ljava/util/HashMap;
    //   19: aload_0
    //   20: getfield B : Ljava/util/List;
    //   23: ifnull -> 51
    //   26: aload_0
    //   27: getfield B : Ljava/util/List;
    //   30: invokeinterface clear : ()V
    //   35: goto -> 51
    //   38: astore #7
    //   40: aload #7
    //   42: ldc_w 'apm'
    //   45: ldc_w 'des1'
    //   48: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   51: aload_0
    //   52: getfield d : Lcom/loc/e$a;
    //   55: ifnull -> 66
    //   58: aload_0
    //   59: getfield d : Lcom/loc/e$a;
    //   62: aconst_null
    //   63: invokevirtual removeCallbacksAndMessages : (Ljava/lang/Object;)V
    //   66: aload_0
    //   67: getfield b : Lcom/loc/e$b;
    //   70: ifnull -> 128
    //   73: getstatic android/os/Build$VERSION.SDK_INT : I
    //   76: istore_1
    //   77: iload_1
    //   78: bipush #18
    //   80: if_icmplt -> 119
    //   83: aload_0
    //   84: getfield b : Lcom/loc/e$b;
    //   87: ldc_w android/os/HandlerThread
    //   90: ldc_w 'quitSafely'
    //   93: iconst_0
    //   94: anewarray java/lang/Object
    //   97: invokestatic a : (Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   100: pop
    //   101: goto -> 128
    //   104: aload_0
    //   105: getfield b : Lcom/loc/e$b;
    //   108: astore #7
    //   110: aload #7
    //   112: invokevirtual quit : ()Z
    //   115: pop
    //   116: goto -> 128
    //   119: aload_0
    //   120: getfield b : Lcom/loc/e$b;
    //   123: astore #7
    //   125: goto -> 110
    //   128: aload_0
    //   129: aconst_null
    //   130: putfield b : Lcom/loc/e$b;
    //   133: aload_0
    //   134: aconst_null
    //   135: putfield d : Lcom/loc/e$a;
    //   138: aload_0
    //   139: getfield A : Lcom/loc/i;
    //   142: ifnull -> 157
    //   145: aload_0
    //   146: getfield A : Lcom/loc/i;
    //   149: invokevirtual c : ()V
    //   152: aload_0
    //   153: aconst_null
    //   154: putfield A : Lcom/loc/i;
    //   157: aload_0
    //   158: invokevirtual b : ()V
    //   161: aload_0
    //   162: iconst_0
    //   163: putfield t : Z
    //   166: aload_0
    //   167: iconst_0
    //   168: putfield u : Z
    //   171: aload_0
    //   172: getfield f : Lcom/loc/dn;
    //   175: invokevirtual d : ()V
    //   178: aload_0
    //   179: getfield i : Lcom/loc/en;
    //   182: ifnull -> 265
    //   185: aload_0
    //   186: getfield j : J
    //   189: lconst_0
    //   190: lcmp
    //   191: ifeq -> 265
    //   194: aload_0
    //   195: getfield k : J
    //   198: lconst_0
    //   199: lcmp
    //   200: ifeq -> 265
    //   203: invokestatic b : ()J
    //   206: lstore_3
    //   207: aload_0
    //   208: getfield j : J
    //   211: lstore #5
    //   213: aload_0
    //   214: getfield i : Lcom/loc/en;
    //   217: aload_0
    //   218: getfield e : Landroid/content/Context;
    //   221: invokevirtual c : (Landroid/content/Context;)I
    //   224: istore_1
    //   225: aload_0
    //   226: getfield i : Lcom/loc/en;
    //   229: aload_0
    //   230: getfield e : Landroid/content/Context;
    //   233: invokevirtual d : (Landroid/content/Context;)I
    //   236: istore_2
    //   237: aload_0
    //   238: getfield e : Landroid/content/Context;
    //   241: iload_1
    //   242: iload_2
    //   243: aload_0
    //   244: getfield k : J
    //   247: lload_3
    //   248: lload #5
    //   250: lsub
    //   251: invokestatic a : (Landroid/content/Context;IIJJ)V
    //   254: aload_0
    //   255: getfield i : Lcom/loc/en;
    //   258: aload_0
    //   259: getfield e : Landroid/content/Context;
    //   262: invokevirtual e : (Landroid/content/Context;)V
    //   265: aload_0
    //   266: getfield e : Landroid/content/Context;
    //   269: invokestatic a : (Landroid/content/Context;)V
    //   272: invokestatic b : ()V
    //   275: getstatic com/loc/e.g : Z
    //   278: ifeq -> 287
    //   281: invokestatic myPid : ()I
    //   284: invokestatic killProcess : (I)V
    //   287: return
    //   288: astore #7
    //   290: aload #7
    //   292: ldc_w 'apm'
    //   295: ldc_w 'tdest'
    //   298: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   301: return
    //   302: astore #7
    //   304: goto -> 104
    // Exception table:
    //   from	to	target	type
    //   0	19	288	finally
    //   19	35	38	finally
    //   40	51	288	finally
    //   51	66	288	finally
    //   66	77	288	finally
    //   83	101	302	finally
    //   104	110	288	finally
    //   110	116	288	finally
    //   119	125	288	finally
    //   128	157	288	finally
    //   157	265	288	finally
    //   265	287	288	finally
  }
  
  public final class a extends Handler {
    public a(e this$0, Looper param1Looper) {
      super(param1Looper);
    }
    
    public final void handleMessage(Message param1Message) {
      // Byte code:
      //   0: aload_1
      //   1: invokevirtual getData : ()Landroid/os/Bundle;
      //   4: astore #4
      //   6: aload_1
      //   7: getfield replyTo : Landroid/os/Messenger;
      //   10: astore_3
      //   11: aload #4
      //   13: astore #6
      //   15: aload_3
      //   16: astore #5
      //   18: aload #4
      //   20: ifnull -> 211
      //   23: aload #4
      //   25: astore #6
      //   27: aload_3
      //   28: astore #5
      //   30: aload #4
      //   32: invokevirtual isEmpty : ()Z
      //   35: ifne -> 211
      //   38: aload #4
      //   40: ldc 'c'
      //   42: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
      //   45: astore #5
      //   47: aload_0
      //   48: getfield a : Lcom/loc/e;
      //   51: astore #6
      //   53: aload #6
      //   55: getfield l : Ljava/lang/String;
      //   58: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   61: ifeq -> 77
      //   64: aload #6
      //   66: aload #6
      //   68: getfield e : Landroid/content/Context;
      //   71: invokestatic b : (Landroid/content/Context;)Ljava/lang/String;
      //   74: putfield l : Ljava/lang/String;
      //   77: aload #5
      //   79: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   82: ifne -> 671
      //   85: aload #5
      //   87: aload #6
      //   89: getfield l : Ljava/lang/String;
      //   92: invokevirtual equals : (Ljava/lang/Object;)Z
      //   95: ifne -> 666
      //   98: goto -> 671
      //   101: aload #4
      //   103: astore #6
      //   105: aload_3
      //   106: astore #5
      //   108: iload_2
      //   109: ifne -> 211
      //   112: aload_1
      //   113: getfield what : I
      //   116: iconst_1
      //   117: if_icmpne -> 174
      //   120: aconst_null
      //   121: sipush #2102
      //   124: invokestatic a : (Ljava/lang/String;I)V
      //   127: ldc 'invalid handlder scode!!!#1002'
      //   129: invokestatic a : (Ljava/lang/String;)Lcom/loc/ds;
      //   132: astore #5
      //   134: new com/loc/dm
      //   137: dup
      //   138: invokespecial <init> : ()V
      //   141: astore #6
      //   143: aload #6
      //   145: ldc '#1002'
      //   147: invokevirtual f : (Ljava/lang/String;)V
      //   150: aload #6
      //   152: ldc 'conitue'
      //   154: invokevirtual e : (Ljava/lang/String;)V
      //   157: aload_0
      //   158: getfield a : Lcom/loc/e;
      //   161: aload_3
      //   162: aload #5
      //   164: aload #5
      //   166: invokevirtual k : ()Ljava/lang/String;
      //   169: aload #6
      //   171: invokestatic a : (Lcom/loc/e;Landroid/os/Messenger;Lcom/amap/api/location/AMapLocation;Ljava/lang/String;Lcom/loc/dm;)V
      //   174: return
      //   175: astore #5
      //   177: goto -> 195
      //   180: astore #5
      //   182: aconst_null
      //   183: astore_3
      //   184: goto -> 195
      //   187: astore #5
      //   189: aconst_null
      //   190: astore #4
      //   192: aload #4
      //   194: astore_3
      //   195: aload #5
      //   197: ldc 'ApsServiceCore'
      //   199: ldc 'ActionHandler handlerMessage'
      //   201: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   204: aload_3
      //   205: astore #5
      //   207: aload #4
      //   209: astore #6
      //   211: aload_1
      //   212: getfield what : I
      //   215: istore_2
      //   216: iload_2
      //   217: ifeq -> 630
      //   220: iload_2
      //   221: iconst_1
      //   222: if_icmpeq -> 607
      //   225: iload_2
      //   226: iconst_2
      //   227: if_icmpeq -> 534
      //   230: iload_2
      //   231: iconst_3
      //   232: if_icmpeq -> 502
      //   235: iload_2
      //   236: tableswitch default -> 676, 9 -> 483, 10 -> 460, 11 -> 450, 12 -> 438, 13 -> 363, 14 -> 276
      //   276: aload_1
      //   277: getfield replyTo : Landroid/os/Messenger;
      //   280: astore_3
      //   281: aload_3
      //   282: ifnull -> 325
      //   285: aload_0
      //   286: getfield a : Lcom/loc/e;
      //   289: invokestatic b : (Lcom/loc/e;)Ljava/util/List;
      //   292: ifnull -> 325
      //   295: aload_0
      //   296: getfield a : Lcom/loc/e;
      //   299: invokestatic b : (Lcom/loc/e;)Ljava/util/List;
      //   302: aload_3
      //   303: invokeinterface contains : (Ljava/lang/Object;)Z
      //   308: ifeq -> 325
      //   311: aload_0
      //   312: getfield a : Lcom/loc/e;
      //   315: invokestatic b : (Lcom/loc/e;)Ljava/util/List;
      //   318: aload_3
      //   319: invokeinterface remove : (Ljava/lang/Object;)Z
      //   324: pop
      //   325: aload_0
      //   326: getfield a : Lcom/loc/e;
      //   329: invokestatic b : (Lcom/loc/e;)Ljava/util/List;
      //   332: ifnull -> 650
      //   335: aload_0
      //   336: getfield a : Lcom/loc/e;
      //   339: invokestatic b : (Lcom/loc/e;)Ljava/util/List;
      //   342: invokeinterface size : ()I
      //   347: ifne -> 650
      //   350: aload_0
      //   351: getfield a : Lcom/loc/e;
      //   354: getfield f : Lcom/loc/dn;
      //   357: invokevirtual h : ()V
      //   360: goto -> 650
      //   363: aload_1
      //   364: getfield replyTo : Landroid/os/Messenger;
      //   367: astore_3
      //   368: aload_3
      //   369: ifnull -> 650
      //   372: aload_0
      //   373: getfield a : Lcom/loc/e;
      //   376: invokestatic b : (Lcom/loc/e;)Ljava/util/List;
      //   379: ifnull -> 650
      //   382: aload_0
      //   383: getfield a : Lcom/loc/e;
      //   386: invokestatic b : (Lcom/loc/e;)Ljava/util/List;
      //   389: aload_3
      //   390: invokeinterface contains : (Ljava/lang/Object;)Z
      //   395: ifne -> 650
      //   398: aload_0
      //   399: getfield a : Lcom/loc/e;
      //   402: invokestatic b : (Lcom/loc/e;)Ljava/util/List;
      //   405: aload_3
      //   406: invokeinterface add : (Ljava/lang/Object;)Z
      //   411: pop
      //   412: aload_0
      //   413: getfield a : Lcom/loc/e;
      //   416: invokestatic b : (Lcom/loc/e;)Ljava/util/List;
      //   419: invokeinterface size : ()I
      //   424: iconst_1
      //   425: if_icmpne -> 650
      //   428: aload_0
      //   429: getfield a : Lcom/loc/e;
      //   432: invokestatic c : (Lcom/loc/e;)V
      //   435: goto -> 650
      //   438: aload_0
      //   439: getfield a : Lcom/loc/e;
      //   442: aload #5
      //   444: invokestatic a : (Lcom/loc/e;Landroid/os/Messenger;)V
      //   447: goto -> 650
      //   450: aload_0
      //   451: getfield a : Lcom/loc/e;
      //   454: invokevirtual c : ()V
      //   457: goto -> 650
      //   460: aload_0
      //   461: getfield a : Lcom/loc/e;
      //   464: aload #6
      //   466: invokestatic a : (Lcom/loc/e;Landroid/os/Bundle;)V
      //   469: aload_0
      //   470: getfield a : Lcom/loc/e;
      //   473: aload #5
      //   475: aload #6
      //   477: invokevirtual a : (Landroid/os/Messenger;Landroid/os/Bundle;)V
      //   480: goto -> 650
      //   483: aload_0
      //   484: getfield a : Lcom/loc/e;
      //   487: aload #6
      //   489: invokestatic a : (Lcom/loc/e;Landroid/os/Bundle;)V
      //   492: aload_0
      //   493: getfield a : Lcom/loc/e;
      //   496: invokestatic a : (Lcom/loc/e;)V
      //   499: goto -> 650
      //   502: aload #6
      //   504: ifnull -> 679
      //   507: aload #6
      //   509: invokevirtual isEmpty : ()Z
      //   512: ifeq -> 516
      //   515: return
      //   516: aload_0
      //   517: getfield a : Lcom/loc/e;
      //   520: aconst_null
      //   521: invokestatic a : (Lcom/loc/e;Landroid/os/Bundle;)V
      //   524: aload_0
      //   525: getfield a : Lcom/loc/e;
      //   528: invokevirtual b : ()V
      //   531: goto -> 650
      //   534: aload #6
      //   536: ifnull -> 680
      //   539: aload #6
      //   541: invokevirtual isEmpty : ()Z
      //   544: ifeq -> 548
      //   547: return
      //   548: aload_0
      //   549: getfield a : Lcom/loc/e;
      //   552: aconst_null
      //   553: invokestatic a : (Lcom/loc/e;Landroid/os/Bundle;)V
      //   556: aload_0
      //   557: getfield a : Lcom/loc/e;
      //   560: astore_3
      //   561: aload_3
      //   562: getfield r : Z
      //   565: ifne -> 650
      //   568: aload_3
      //   569: new com/loc/e$c
      //   572: dup
      //   573: aload_3
      //   574: invokespecial <init> : (Lcom/loc/e;)V
      //   577: putfield s : Lcom/loc/e$c;
      //   580: aload_3
      //   581: getfield s : Lcom/loc/e$c;
      //   584: invokevirtual start : ()V
      //   587: aload_3
      //   588: iconst_1
      //   589: putfield r : Z
      //   592: goto -> 650
      //   595: astore_3
      //   596: aload_3
      //   597: ldc 'ApsServiceCore'
      //   599: ldc 'startSocket'
      //   601: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   604: goto -> 650
      //   607: aload_0
      //   608: getfield a : Lcom/loc/e;
      //   611: aload #6
      //   613: invokestatic a : (Lcom/loc/e;Landroid/os/Bundle;)V
      //   616: aload_0
      //   617: getfield a : Lcom/loc/e;
      //   620: aload #5
      //   622: aload #6
      //   624: invokestatic b : (Lcom/loc/e;Landroid/os/Messenger;Landroid/os/Bundle;)V
      //   627: goto -> 650
      //   630: aload_0
      //   631: getfield a : Lcom/loc/e;
      //   634: aload #6
      //   636: invokestatic a : (Lcom/loc/e;Landroid/os/Bundle;)V
      //   639: aload_0
      //   640: getfield a : Lcom/loc/e;
      //   643: aload #5
      //   645: aload #6
      //   647: invokestatic a : (Lcom/loc/e;Landroid/os/Messenger;Landroid/os/Bundle;)V
      //   650: aload_0
      //   651: aload_1
      //   652: invokespecial handleMessage : (Landroid/os/Message;)V
      //   655: return
      //   656: astore_1
      //   657: aload_1
      //   658: ldc 'actionHandler'
      //   660: ldc 'handleMessage'
      //   662: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   665: return
      //   666: iconst_1
      //   667: istore_2
      //   668: goto -> 101
      //   671: iconst_0
      //   672: istore_2
      //   673: goto -> 101
      //   676: goto -> 650
      //   679: return
      //   680: return
      // Exception table:
      //   from	to	target	type
      //   0	6	187	finally
      //   6	11	180	finally
      //   30	77	175	finally
      //   77	98	175	finally
      //   112	174	175	finally
      //   195	204	656	finally
      //   211	216	656	finally
      //   276	281	656	finally
      //   285	325	656	finally
      //   325	360	656	finally
      //   363	368	656	finally
      //   372	435	656	finally
      //   438	447	656	finally
      //   450	457	656	finally
      //   460	480	656	finally
      //   483	499	656	finally
      //   507	515	656	finally
      //   516	531	656	finally
      //   539	547	656	finally
      //   548	561	656	finally
      //   561	592	595	finally
      //   596	604	656	finally
      //   607	627	656	finally
      //   630	650	656	finally
      //   650	655	656	finally
    }
  }
  
  final class b extends HandlerThread {
    public b(e this$0, String param1String) {
      super(param1String);
    }
    
    protected final void onLooperPrepared() {
      // Byte code:
      //   0: aload_0
      //   1: getfield a : Lcom/loc/e;
      //   4: new com/loc/i
      //   7: dup
      //   8: aload_0
      //   9: getfield a : Lcom/loc/e;
      //   12: getfield e : Landroid/content/Context;
      //   15: invokespecial <init> : (Landroid/content/Context;)V
      //   18: invokestatic a : (Lcom/loc/e;Lcom/loc/i;)Lcom/loc/i;
      //   21: pop
      //   22: goto -> 34
      //   25: astore_1
      //   26: aload_1
      //   27: ldc 'APSManager$ActionThread'
      //   29: ldc 'init 2'
      //   31: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   34: aload_0
      //   35: getfield a : Lcom/loc/e;
      //   38: getfield e : Landroid/content/Context;
      //   41: invokestatic b : (Landroid/content/Context;)V
      //   44: aload_0
      //   45: getfield a : Lcom/loc/e;
      //   48: getfield e : Landroid/content/Context;
      //   51: invokestatic a : (Landroid/content/Context;)V
      //   54: goto -> 66
      //   57: astore_1
      //   58: aload_1
      //   59: ldc 'APSManager$ActionThread'
      //   61: ldc 'init 3'
      //   63: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   66: aload_0
      //   67: getfield a : Lcom/loc/e;
      //   70: new com/loc/dn
      //   73: dup
      //   74: invokespecial <init> : ()V
      //   77: putfield f : Lcom/loc/dn;
      //   80: aload_0
      //   81: invokespecial onLooperPrepared : ()V
      //   84: return
      //   85: astore_1
      //   86: aload_1
      //   87: ldc 'APSManager$ActionThread'
      //   89: ldc 'onLooperPrepared'
      //   91: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   94: return
      // Exception table:
      //   from	to	target	type
      //   0	22	25	finally
      //   26	34	85	finally
      //   34	54	57	finally
      //   58	66	85	finally
      //   66	84	85	finally
    }
    
    public final void run() {
      try {
        return;
      } finally {
        Exception exception = null;
        ej.a(exception, "APSManager$ActionThread", "run");
      } 
    }
  }
  
  final class c extends Thread {
    c(e this$0) {}
    
    public final void run() {
      try {
        if (!this.a.p) {
          this.a.p = true;
          this.a.o = new ServerSocket(43689);
        } 
      } finally {
        Exception exception = null;
      } 
      super.run();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */