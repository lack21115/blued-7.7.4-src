package com.loc;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

public final class dx {
  static long d;
  
  static long e;
  
  static long f;
  
  public static long g;
  
  static long h;
  
  public static HashMap<String, Long> s = new HashMap<String, Long>(36);
  
  public static long t = 0L;
  
  static int u = 0;
  
  public static long w = 0L;
  
  private do A;
  
  WifiManager a;
  
  ArrayList<ScanResult> b = new ArrayList<ScanResult>();
  
  ArrayList<dd> c = new ArrayList<dd>();
  
  Context i;
  
  boolean j = false;
  
  StringBuilder k = null;
  
  boolean l = true;
  
  boolean m = true;
  
  boolean n = true;
  
  String o = null;
  
  TreeMap<Integer, ScanResult> p = null;
  
  public boolean q = true;
  
  public boolean r = false;
  
  ConnectivityManager v = null;
  
  volatile boolean x = false;
  
  private volatile WifiInfo y = null;
  
  private long z = 30000L;
  
  public dx(Context paramContext, WifiManager paramWifiManager) {
    this.a = paramWifiManager;
    this.i = paramContext;
  }
  
  private static boolean a(int paramInt) {
    byte b = 20;
    try {
      paramInt = WifiManager.calculateSignalLevel(paramInt, 20);
    } catch (ArithmeticException arithmeticException) {
      ej.a(arithmeticException, "Aps", "wifiSigFine");
      paramInt = b;
    } 
    return (paramInt > 0);
  }
  
  public static boolean a(WifiInfo paramWifiInfo) {
    return (paramWifiInfo == null) ? false : (TextUtils.isEmpty(paramWifiInfo.getSSID()) ? false : (!!ep.a(paramWifiInfo.getBSSID())));
  }
  
  public static long b() {
    return (ep.b() - t) / 1000L + 1L;
  }
  
  private void c(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Ljava/util/ArrayList;
    //   4: astore #6
    //   6: aload #6
    //   8: ifnull -> 440
    //   11: aload #6
    //   13: invokevirtual isEmpty : ()Z
    //   16: ifeq -> 20
    //   19: return
    //   20: invokestatic b : ()J
    //   23: getstatic com/loc/dx.g : J
    //   26: lsub
    //   27: ldc2_w 3600000
    //   30: lcmp
    //   31: ifle -> 38
    //   34: aload_0
    //   35: invokevirtual g : ()V
    //   38: aload_0
    //   39: getfield p : Ljava/util/TreeMap;
    //   42: ifnonnull -> 59
    //   45: aload_0
    //   46: new java/util/TreeMap
    //   49: dup
    //   50: invokestatic reverseOrder : ()Ljava/util/Comparator;
    //   53: invokespecial <init> : (Ljava/util/Comparator;)V
    //   56: putfield p : Ljava/util/TreeMap;
    //   59: aload_0
    //   60: getfield p : Ljava/util/TreeMap;
    //   63: invokevirtual clear : ()V
    //   66: aload_0
    //   67: getfield r : Z
    //   70: ifeq -> 84
    //   73: iload_1
    //   74: ifeq -> 84
    //   77: aload_0
    //   78: getfield c : Ljava/util/ArrayList;
    //   81: invokevirtual clear : ()V
    //   84: aload_0
    //   85: getfield b : Ljava/util/ArrayList;
    //   88: invokevirtual size : ()I
    //   91: istore_3
    //   92: iconst_0
    //   93: istore_2
    //   94: iload_2
    //   95: iload_3
    //   96: if_icmpge -> 377
    //   99: aload_0
    //   100: getfield b : Ljava/util/ArrayList;
    //   103: iload_2
    //   104: invokevirtual get : (I)Ljava/lang/Object;
    //   107: checkcast android/net/wifi/ScanResult
    //   110: astore #7
    //   112: aload #7
    //   114: ifnull -> 127
    //   117: aload #7
    //   119: getfield BSSID : Ljava/lang/String;
    //   122: astore #6
    //   124: goto -> 131
    //   127: ldc ''
    //   129: astore #6
    //   131: aload #6
    //   133: invokestatic a : (Ljava/lang/String;)Z
    //   136: ifeq -> 370
    //   139: iload_3
    //   140: bipush #20
    //   142: if_icmple -> 156
    //   145: aload #7
    //   147: getfield level : I
    //   150: invokestatic a : (I)Z
    //   153: ifeq -> 370
    //   156: aload_0
    //   157: getfield r : Z
    //   160: ifeq -> 302
    //   163: iload_1
    //   164: ifeq -> 302
    //   167: new com/loc/dd
    //   170: dup
    //   171: iconst_0
    //   172: invokespecial <init> : (Z)V
    //   175: astore #6
    //   177: aload #6
    //   179: aload #7
    //   181: getfield SSID : Ljava/lang/String;
    //   184: putfield b : Ljava/lang/String;
    //   187: aload #6
    //   189: aload #7
    //   191: getfield frequency : I
    //   194: putfield d : I
    //   197: aload #6
    //   199: aload #7
    //   201: getfield timestamp : J
    //   204: putfield e : J
    //   207: aload #6
    //   209: aload #7
    //   211: getfield BSSID : Ljava/lang/String;
    //   214: invokestatic a : (Ljava/lang/String;)J
    //   217: putfield a : J
    //   220: aload #6
    //   222: aload #7
    //   224: getfield level : I
    //   227: i2s
    //   228: putfield c : I
    //   231: getstatic android/os/Build$VERSION.SDK_INT : I
    //   234: bipush #17
    //   236: if_icmplt -> 281
    //   239: aload #7
    //   241: getfield timestamp : J
    //   244: ldc2_w 1000
    //   247: ldiv
    //   248: lstore #4
    //   250: aload #6
    //   252: invokestatic elapsedRealtime : ()J
    //   255: lload #4
    //   257: lsub
    //   258: ldc2_w 1000
    //   261: ldiv
    //   262: l2i
    //   263: i2s
    //   264: putfield g : S
    //   267: aload #6
    //   269: getfield g : S
    //   272: ifge -> 281
    //   275: aload #6
    //   277: iconst_0
    //   278: putfield g : S
    //   281: aload #6
    //   283: invokestatic currentTimeMillis : ()J
    //   286: putfield f : J
    //   289: aload_0
    //   290: getfield c : Ljava/util/ArrayList;
    //   293: aload #6
    //   295: invokevirtual add : (Ljava/lang/Object;)Z
    //   298: pop
    //   299: goto -> 302
    //   302: aload #7
    //   304: getfield SSID : Ljava/lang/String;
    //   307: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   310: ifne -> 335
    //   313: ldc '<unknown ssid>'
    //   315: aload #7
    //   317: getfield SSID : Ljava/lang/String;
    //   320: invokevirtual equals : (Ljava/lang/Object;)Z
    //   323: ifne -> 347
    //   326: iload_2
    //   327: invokestatic valueOf : (I)Ljava/lang/String;
    //   330: astore #6
    //   332: goto -> 340
    //   335: ldc_w 'unkwn'
    //   338: astore #6
    //   340: aload #7
    //   342: aload #6
    //   344: putfield SSID : Ljava/lang/String;
    //   347: aload_0
    //   348: getfield p : Ljava/util/TreeMap;
    //   351: aload #7
    //   353: getfield level : I
    //   356: bipush #25
    //   358: imul
    //   359: iload_2
    //   360: iadd
    //   361: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   364: aload #7
    //   366: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   369: pop
    //   370: iload_2
    //   371: iconst_1
    //   372: iadd
    //   373: istore_2
    //   374: goto -> 94
    //   377: aload_0
    //   378: getfield b : Ljava/util/ArrayList;
    //   381: invokevirtual clear : ()V
    //   384: aload_0
    //   385: getfield p : Ljava/util/TreeMap;
    //   388: invokevirtual values : ()Ljava/util/Collection;
    //   391: invokeinterface iterator : ()Ljava/util/Iterator;
    //   396: astore #6
    //   398: aload #6
    //   400: invokeinterface hasNext : ()Z
    //   405: ifeq -> 433
    //   408: aload #6
    //   410: invokeinterface next : ()Ljava/lang/Object;
    //   415: checkcast android/net/wifi/ScanResult
    //   418: astore #7
    //   420: aload_0
    //   421: getfield b : Ljava/util/ArrayList;
    //   424: aload #7
    //   426: invokevirtual add : (Ljava/lang/Object;)Z
    //   429: pop
    //   430: goto -> 398
    //   433: aload_0
    //   434: getfield p : Ljava/util/TreeMap;
    //   437: invokevirtual clear : ()V
    //   440: return
    //   441: astore #6
    //   443: goto -> 84
    //   446: astore #6
    //   448: goto -> 302
    // Exception table:
    //   from	to	target	type
    //   77	84	441	finally
    //   167	281	446	finally
    //   281	299	446	finally
  }
  
  public static String o() {
    return String.valueOf(ep.b() - g);
  }
  
  private List<ScanResult> p() {
    WifiManager wifiManager = this.a;
    if (wifiManager != null)
      try {
        List<ScanResult> list = wifiManager.getScanResults();
        return list;
      } catch (SecurityException securityException) {
      
      } finally {
        wifiManager = null;
        this.o = null;
        ej.a((Throwable)wifiManager, "WifiManagerWrapper", "getScanResults");
      }  
    return null;
  }
  
  private void q() {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial r : ()Z
    //   4: ifeq -> 193
    //   7: invokestatic b : ()J
    //   10: getstatic com/loc/dx.d : J
    //   13: lsub
    //   14: lstore_3
    //   15: lload_3
    //   16: ldc2_w 4900
    //   19: lcmp
    //   20: iflt -> 194
    //   23: aload_0
    //   24: getfield v : Landroid/net/ConnectivityManager;
    //   27: ifnonnull -> 47
    //   30: aload_0
    //   31: aload_0
    //   32: getfield i : Landroid/content/Context;
    //   35: ldc_w 'connectivity'
    //   38: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;
    //   41: checkcast android/net/ConnectivityManager
    //   44: putfield v : Landroid/net/ConnectivityManager;
    //   47: aload_0
    //   48: aload_0
    //   49: getfield v : Landroid/net/ConnectivityManager;
    //   52: invokevirtual a : (Landroid/net/ConnectivityManager;)Z
    //   55: ifeq -> 66
    //   58: lload_3
    //   59: ldc2_w 9900
    //   62: lcmp
    //   63: iflt -> 194
    //   66: getstatic com/loc/dx.u : I
    //   69: iconst_1
    //   70: if_icmple -> 128
    //   73: aload_0
    //   74: getfield z : J
    //   77: lstore #5
    //   79: ldc2_w 30000
    //   82: lstore_1
    //   83: lload #5
    //   85: ldc2_w 30000
    //   88: lcmp
    //   89: ifeq -> 100
    //   92: aload_0
    //   93: getfield z : J
    //   96: lstore_1
    //   97: goto -> 114
    //   100: invokestatic n : ()J
    //   103: ldc2_w -1
    //   106: lcmp
    //   107: ifeq -> 114
    //   110: invokestatic n : ()J
    //   113: lstore_1
    //   114: getstatic android/os/Build$VERSION.SDK_INT : I
    //   117: bipush #28
    //   119: if_icmplt -> 128
    //   122: lload_3
    //   123: lload_1
    //   124: lcmp
    //   125: iflt -> 194
    //   128: aload_0
    //   129: getfield a : Landroid/net/wifi/WifiManager;
    //   132: ifnull -> 194
    //   135: invokestatic b : ()J
    //   138: putstatic com/loc/dx.d : J
    //   141: getstatic com/loc/dx.u : I
    //   144: iconst_2
    //   145: if_icmpge -> 156
    //   148: getstatic com/loc/dx.u : I
    //   151: iconst_1
    //   152: iadd
    //   153: putstatic com/loc/dx.u : I
    //   156: aload_0
    //   157: getfield a : Landroid/net/wifi/WifiManager;
    //   160: invokevirtual startScan : ()Z
    //   163: istore #7
    //   165: goto -> 168
    //   168: iload #7
    //   170: ifeq -> 179
    //   173: invokestatic b : ()J
    //   176: putstatic com/loc/dx.f : J
    //   179: return
    //   180: astore #8
    //   182: aload #8
    //   184: ldc_w 'WifiManager'
    //   187: ldc_w 'wifiScan'
    //   190: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   193: return
    //   194: iconst_0
    //   195: istore #7
    //   197: goto -> 168
    // Exception table:
    //   from	to	target	type
    //   7	15	180	finally
    //   23	47	180	finally
    //   47	58	180	finally
    //   66	79	180	finally
    //   92	97	180	finally
    //   100	114	180	finally
    //   114	122	180	finally
    //   128	156	180	finally
    //   156	165	180	finally
    //   173	179	180	finally
  }
  
  private boolean r() {
    boolean bool;
    if (this.a == null) {
      bool = false;
    } else {
      bool = ep.h(this.i);
    } 
    this.q = bool;
    if (!this.q)
      return false; 
    if (!this.l)
      return false; 
    if (f != 0L) {
      if (ep.b() - f < 4900L)
        return false; 
      if (ep.b() - g < 1500L)
        return false; 
      ep.b();
      long l = g;
    } 
    return true;
  }
  
  public final ArrayList<dd> a() {
    if (!this.r)
      return this.c; 
    b(true);
    return this.c;
  }
  
  public final void a(do paramdo) {
    this.A = paramdo;
  }
  
  public final void a(boolean paramBoolean) {
    Context context = this.i;
    if (ei.m()) {
      if (!this.n)
        return; 
      if (this.a != null && context != null) {
        if (!paramBoolean)
          return; 
        if (ep.c() <= 17)
          return; 
        ContentResolver contentResolver = context.getContentResolver();
        try {
          return;
        } finally {
          contentResolver = null;
        } 
      } 
    } 
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong) {
    this.l = paramBoolean1;
    this.m = paramBoolean2;
    this.n = paramBoolean3;
    if (paramLong < 10000L) {
      this.z = 10000L;
      return;
    } 
    this.z = paramLong;
  }
  
  public final boolean a(ConnectivityManager paramConnectivityManager) {
    WifiManager wifiManager = this.a;
    if (wifiManager == null)
      return false; 
    try {
      if (ep.a(paramConnectivityManager.getActiveNetworkInfo()) == 1) {
        boolean bool = a(wifiManager.getConnectionInfo());
        if (bool)
          return true; 
      } 
    } finally {
      paramConnectivityManager = null;
    } 
  }
  
  public final void b(boolean paramBoolean) {
    // Byte code:
    //   0: iload_1
    //   1: ifeq -> 89
    //   4: aload_0
    //   5: invokespecial r : ()Z
    //   8: ifeq -> 93
    //   11: invokestatic b : ()J
    //   14: lstore #4
    //   16: bipush #20
    //   18: istore_2
    //   19: lload #4
    //   21: getstatic com/loc/dx.e : J
    //   24: lsub
    //   25: ldc2_w 10000
    //   28: lcmp
    //   29: iflt -> 45
    //   32: aload_0
    //   33: getfield b : Ljava/util/ArrayList;
    //   36: invokevirtual clear : ()V
    //   39: getstatic com/loc/dx.g : J
    //   42: putstatic com/loc/dx.h : J
    //   45: aload_0
    //   46: invokespecial q : ()V
    //   49: lload #4
    //   51: getstatic com/loc/dx.e : J
    //   54: lsub
    //   55: ldc2_w 10000
    //   58: lcmp
    //   59: iflt -> 93
    //   62: iload_2
    //   63: ifle -> 93
    //   66: getstatic com/loc/dx.g : J
    //   69: getstatic com/loc/dx.h : J
    //   72: lcmp
    //   73: ifne -> 93
    //   76: ldc2_w 150
    //   79: invokestatic sleep : (J)V
    //   82: iload_2
    //   83: iconst_1
    //   84: isub
    //   85: istore_2
    //   86: goto -> 62
    //   89: aload_0
    //   90: invokespecial q : ()V
    //   93: aload_0
    //   94: getfield x : Z
    //   97: istore_3
    //   98: iconst_1
    //   99: istore_1
    //   100: iload_3
    //   101: ifeq -> 185
    //   104: aload_0
    //   105: iconst_0
    //   106: putfield x : Z
    //   109: aload_0
    //   110: getfield a : Landroid/net/wifi/WifiManager;
    //   113: astore #6
    //   115: aload #6
    //   117: ifnonnull -> 123
    //   120: goto -> 185
    //   123: aload_0
    //   124: getfield a : Landroid/net/wifi/WifiManager;
    //   127: ifnull -> 347
    //   130: aload_0
    //   131: getfield a : Landroid/net/wifi/WifiManager;
    //   134: invokevirtual getWifiState : ()I
    //   137: istore_2
    //   138: goto -> 157
    //   141: astore #6
    //   143: aload #6
    //   145: ldc_w 'WifiManager'
    //   148: ldc_w 'onReceive part'
    //   151: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   154: goto -> 347
    //   157: aload_0
    //   158: getfield b : Ljava/util/ArrayList;
    //   161: ifnonnull -> 352
    //   164: aload_0
    //   165: new java/util/ArrayList
    //   168: dup
    //   169: invokespecial <init> : ()V
    //   172: putfield b : Ljava/util/ArrayList;
    //   175: goto -> 352
    //   178: aload_0
    //   179: invokevirtual g : ()V
    //   182: goto -> 185
    //   185: getstatic com/loc/dx.h : J
    //   188: getstatic com/loc/dx.g : J
    //   191: lcmp
    //   192: ifeq -> 262
    //   195: aconst_null
    //   196: astore #6
    //   198: aload_0
    //   199: invokespecial p : ()Ljava/util/List;
    //   202: astore #7
    //   204: aload #7
    //   206: astore #6
    //   208: goto -> 224
    //   211: astore #7
    //   213: aload #7
    //   215: ldc_w 'WifiManager'
    //   218: ldc_w 'updateScanResult'
    //   221: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   224: getstatic com/loc/dx.g : J
    //   227: putstatic com/loc/dx.h : J
    //   230: aload #6
    //   232: ifnull -> 255
    //   235: aload_0
    //   236: getfield b : Ljava/util/ArrayList;
    //   239: invokevirtual clear : ()V
    //   242: aload_0
    //   243: getfield b : Ljava/util/ArrayList;
    //   246: aload #6
    //   248: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   251: pop
    //   252: goto -> 262
    //   255: aload_0
    //   256: getfield b : Ljava/util/ArrayList;
    //   259: invokevirtual clear : ()V
    //   262: invokestatic b : ()J
    //   265: getstatic com/loc/dx.g : J
    //   268: lsub
    //   269: ldc2_w 20000
    //   272: lcmp
    //   273: ifle -> 283
    //   276: aload_0
    //   277: getfield b : Ljava/util/ArrayList;
    //   280: invokevirtual clear : ()V
    //   283: invokestatic b : ()J
    //   286: putstatic com/loc/dx.e : J
    //   289: aload_0
    //   290: getfield b : Ljava/util/ArrayList;
    //   293: invokevirtual isEmpty : ()Z
    //   296: ifeq -> 329
    //   299: invokestatic b : ()J
    //   302: putstatic com/loc/dx.g : J
    //   305: aload_0
    //   306: invokespecial p : ()Ljava/util/List;
    //   309: astore #6
    //   311: aload #6
    //   313: ifnull -> 329
    //   316: aload_0
    //   317: getfield b : Ljava/util/ArrayList;
    //   320: aload #6
    //   322: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   325: pop
    //   326: goto -> 331
    //   329: iconst_0
    //   330: istore_1
    //   331: aload_0
    //   332: iload_1
    //   333: invokespecial c : (Z)V
    //   336: return
    //   337: astore #6
    //   339: goto -> 82
    //   342: astore #6
    //   344: goto -> 185
    //   347: iconst_4
    //   348: istore_2
    //   349: goto -> 157
    //   352: iload_2
    //   353: ifeq -> 178
    //   356: iload_2
    //   357: iconst_1
    //   358: if_icmpeq -> 178
    //   361: iload_2
    //   362: iconst_4
    //   363: if_icmpeq -> 178
    //   366: goto -> 185
    // Exception table:
    //   from	to	target	type
    //   76	82	337	finally
    //   109	115	342	finally
    //   123	138	141	finally
    //   143	154	342	finally
    //   157	175	342	finally
    //   178	182	342	finally
    //   198	204	211	finally
  }
  
  public final WifiInfo c() {
    try {
      if (this.a != null)
        return this.a.getConnectionInfo(); 
    } finally {
      Exception exception = null;
    } 
  }
  
  public final String d() {
    return this.o;
  }
  
  public final ArrayList<ScanResult> e() {
    if (this.b == null)
      return null; 
    ArrayList<ScanResult> arrayList = new ArrayList();
    if (!this.b.isEmpty())
      arrayList.addAll(this.b); 
    return arrayList;
  }
  
  public final void f() {
    try {
      this.r = true;
      List<ScanResult> list = p();
      if (list != null) {
        this.b.clear();
        this.b.addAll(list);
      } 
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public final void g() {
    this.y = null;
    this.b.clear();
  }
  
  public final void h() {
    w = System.currentTimeMillis();
    do do1 = this.A;
    if (do1 != null)
      do1.b(); 
  }
  
  public final void i() {
    if (this.a == null)
      return; 
    if (ep.b() - g > 4900L)
      g = ep.b(); 
  }
  
  public final void j() {
    if (this.a == null)
      return; 
    this.x = true;
  }
  
  public final WifiInfo k() {
    this.y = c();
    return this.y;
  }
  
  public final boolean l() {
    return this.j;
  }
  
  public final String m() {
    String str;
    StringBuilder stringBuilder = this.k;
    if (stringBuilder == null) {
      this.k = new StringBuilder(700);
    } else {
      stringBuilder.delete(0, stringBuilder.length());
    } 
    this.j = false;
    this.y = k();
    if (a(this.y)) {
      str = this.y.getBSSID();
    } else {
      str = "";
    } 
    int j = this.b.size();
    int i = 0;
    boolean bool2 = false;
    boolean bool1 = false;
    while (i < j) {
      String str1;
      String str2 = ((ScanResult)this.b.get(i)).BSSID;
      boolean bool = bool2;
      if (!this.m) {
        bool = bool2;
        if (!"<unknown ssid>".equals(((ScanResult)this.b.get(i)).SSID))
          bool = true; 
      } 
      if (str.equals(str2)) {
        str1 = "access";
        bool1 = true;
      } else {
        str1 = "nb";
      } 
      this.k.append(String.format(Locale.US, "#%s,%s", new Object[] { str2, str1 }));
      i++;
      bool2 = bool;
    } 
    if (this.b.size() == 0)
      bool2 = true; 
    if (!this.m && !bool2)
      this.j = true; 
    if (!bool1 && !TextUtils.isEmpty(str)) {
      StringBuilder stringBuilder1 = this.k;
      stringBuilder1.append("#");
      stringBuilder1.append(str);
      this.k.append(",access");
    } 
    return this.k.toString();
  }
  
  public final void n() {
    g();
    this.b.clear();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\dx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */