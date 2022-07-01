package com.amap.api.mapcore2d;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public final class go {
  static long c;
  
  static long d;
  
  static long e;
  
  static long f;
  
  static long g;
  
  public static HashMap<String, Long> q = new HashMap<String, Long>(36);
  
  public static long r = 0L;
  
  static int s = 0;
  
  WifiManager a;
  
  ArrayList<ScanResult> b = new ArrayList<ScanResult>();
  
  Context h;
  
  boolean i = false;
  
  StringBuilder j = null;
  
  boolean k = true;
  
  boolean l = true;
  
  boolean m = true;
  
  String n = null;
  
  TreeMap<Integer, ScanResult> o = null;
  
  public boolean p = true;
  
  ConnectivityManager t = null;
  
  volatile boolean u = false;
  
  private volatile WifiInfo v = null;
  
  private long w = 30000L;
  
  public go(Context paramContext, WifiManager paramWifiManager) {
    this.a = paramWifiManager;
    this.h = paramContext;
  }
  
  private static boolean a(int paramInt) {
    byte b = 20;
    try {
      paramInt = WifiManager.calculateSignalLevel(paramInt, 20);
    } catch (ArithmeticException arithmeticException) {
      gu.a(arithmeticException, "Aps", "wifiSigFine");
      paramInt = b;
    } 
    return (paramInt > 0);
  }
  
  public static boolean a(WifiInfo paramWifiInfo) {
    return (paramWifiInfo == null) ? false : (TextUtils.isEmpty(paramWifiInfo.getSSID()) ? false : (!!gy.a(paramWifiInfo.getBSSID())));
  }
  
  private void d(boolean paramBoolean) {
    this.k = paramBoolean;
    this.l = true;
    this.m = true;
    this.w = 30000L;
  }
  
  public static String i() {
    return String.valueOf(gy.b() - f);
  }
  
  private List<ScanResult> j() {
    WifiManager wifiManager = this.a;
    if (wifiManager != null)
      try {
        List<ScanResult> list = wifiManager.getScanResults();
        return list;
      } catch (SecurityException securityException) {
      
      } finally {
        wifiManager = null;
        this.n = null;
        gu.a((Throwable)wifiManager, "WifiManagerWrapper", "getScanResults");
      }  
    return null;
  }
  
  private WifiInfo k() {
    try {
      if (this.a != null)
        return this.a.getConnectionInfo(); 
    } finally {
      Exception exception = null;
    } 
  }
  
  private int l() {
    WifiManager wifiManager = this.a;
    return (wifiManager != null) ? wifiManager.getWifiState() : 4;
  }
  
  private boolean m() {
    long l = gy.b() - c;
    if (l < 4900L)
      return false; 
    if (n() && l < 9900L)
      return false; 
    if (s > 1) {
      long l1 = this.w;
      if (l1 == 30000L)
        if (gt.b() != -1L) {
          l1 = gt.b();
        } else {
          l1 = 30000L;
        }  
      if (Build.VERSION.SDK_INT >= 28 && l < l1)
        return false; 
    } 
    if (this.a != null) {
      c = gy.b();
      int i = s;
      if (i < 2)
        s = i + 1; 
      return this.a.startScan();
    } 
    return false;
  }
  
  private boolean n() {
    if (this.t == null)
      this.t = (ConnectivityManager)gy.a(this.h, "connectivity"); 
    return a(this.t);
  }
  
  private boolean o() {
    return (this.a == null) ? false : gy.c(this.h);
  }
  
  private void p() {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Ljava/util/ArrayList;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull -> 266
    //   9: aload_3
    //   10: invokevirtual isEmpty : ()Z
    //   13: ifeq -> 17
    //   16: return
    //   17: invokestatic b : ()J
    //   20: getstatic com/amap/api/mapcore2d/go.f : J
    //   23: lsub
    //   24: ldc2_w 3600000
    //   27: lcmp
    //   28: ifle -> 35
    //   31: aload_0
    //   32: invokevirtual b : ()V
    //   35: aload_0
    //   36: getfield o : Ljava/util/TreeMap;
    //   39: ifnonnull -> 56
    //   42: aload_0
    //   43: new java/util/TreeMap
    //   46: dup
    //   47: invokestatic reverseOrder : ()Ljava/util/Comparator;
    //   50: invokespecial <init> : (Ljava/util/Comparator;)V
    //   53: putfield o : Ljava/util/TreeMap;
    //   56: aload_0
    //   57: getfield o : Ljava/util/TreeMap;
    //   60: invokevirtual clear : ()V
    //   63: aload_0
    //   64: getfield b : Ljava/util/ArrayList;
    //   67: invokevirtual size : ()I
    //   70: istore_2
    //   71: iconst_0
    //   72: istore_1
    //   73: iload_1
    //   74: iload_2
    //   75: if_icmpge -> 206
    //   78: aload_0
    //   79: getfield b : Ljava/util/ArrayList;
    //   82: iload_1
    //   83: invokevirtual get : (I)Ljava/lang/Object;
    //   86: checkcast android/net/wifi/ScanResult
    //   89: astore #4
    //   91: aload #4
    //   93: ifnull -> 105
    //   96: aload #4
    //   98: getfield BSSID : Ljava/lang/String;
    //   101: astore_3
    //   102: goto -> 109
    //   105: ldc_w ''
    //   108: astore_3
    //   109: aload_3
    //   110: invokestatic a : (Ljava/lang/String;)Z
    //   113: ifeq -> 199
    //   116: iload_2
    //   117: bipush #20
    //   119: if_icmple -> 133
    //   122: aload #4
    //   124: getfield level : I
    //   127: invokestatic a : (I)Z
    //   130: ifeq -> 199
    //   133: aload #4
    //   135: getfield SSID : Ljava/lang/String;
    //   138: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   141: ifne -> 166
    //   144: ldc_w '<unknown ssid>'
    //   147: aload #4
    //   149: getfield SSID : Ljava/lang/String;
    //   152: invokevirtual equals : (Ljava/lang/Object;)Z
    //   155: ifne -> 176
    //   158: iload_1
    //   159: invokestatic valueOf : (I)Ljava/lang/String;
    //   162: astore_3
    //   163: goto -> 170
    //   166: ldc_w 'unkwn'
    //   169: astore_3
    //   170: aload #4
    //   172: aload_3
    //   173: putfield SSID : Ljava/lang/String;
    //   176: aload_0
    //   177: getfield o : Ljava/util/TreeMap;
    //   180: aload #4
    //   182: getfield level : I
    //   185: bipush #25
    //   187: imul
    //   188: iload_1
    //   189: iadd
    //   190: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   193: aload #4
    //   195: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   198: pop
    //   199: iload_1
    //   200: iconst_1
    //   201: iadd
    //   202: istore_1
    //   203: goto -> 73
    //   206: aload_0
    //   207: getfield b : Ljava/util/ArrayList;
    //   210: invokevirtual clear : ()V
    //   213: aload_0
    //   214: getfield o : Ljava/util/TreeMap;
    //   217: invokevirtual values : ()Ljava/util/Collection;
    //   220: invokeinterface iterator : ()Ljava/util/Iterator;
    //   225: astore_3
    //   226: aload_3
    //   227: invokeinterface hasNext : ()Z
    //   232: ifeq -> 259
    //   235: aload_3
    //   236: invokeinterface next : ()Ljava/lang/Object;
    //   241: checkcast android/net/wifi/ScanResult
    //   244: astore #4
    //   246: aload_0
    //   247: getfield b : Ljava/util/ArrayList;
    //   250: aload #4
    //   252: invokevirtual add : (Ljava/lang/Object;)Z
    //   255: pop
    //   256: goto -> 226
    //   259: aload_0
    //   260: getfield o : Ljava/util/TreeMap;
    //   263: invokevirtual clear : ()V
    //   266: return
  }
  
  private void q() {
    if (t()) {
      long l = gy.b();
      int i = 20;
      if (l - d >= 10000L) {
        this.b.clear();
        g = f;
      } 
      r();
      if (l - d >= 10000L)
        while (true) {
          if (i > 0 && f == g) {
            try {
              Thread.sleep(150L);
            } finally {
              Exception exception;
            } 
            i--;
            continue;
          } 
          return;
        }  
    } 
  }
  
  private void r() {
    if (t())
      try {
        return;
      } finally {
        Exception exception = null;
      }  
  }
  
  private void s() {
    if (g != f) {
      List<ScanResult> list = null;
      try {
        List<ScanResult> list1 = j();
      } finally {
        Exception exception = null;
      } 
      g = f;
      if (list != null) {
        this.b.clear();
        this.b.addAll(list);
        return;
      } 
      this.b.clear();
    } 
  }
  
  private boolean t() {
    this.p = o();
    if (!this.p)
      return false; 
    if (!this.k)
      return false; 
    if (e != 0L) {
      if (gy.b() - e < 4900L)
        return false; 
      if (gy.b() - f < 1500L)
        return false; 
      gy.b();
      long l = f;
    } 
    return true;
  }
  
  public final ArrayList<ScanResult> a() {
    if (this.b == null)
      return null; 
    ArrayList<ScanResult> arrayList = new ArrayList();
    if (!this.b.isEmpty())
      arrayList.addAll(this.b); 
    return arrayList;
  }
  
  public final void a(boolean paramBoolean) {
    Context context = this.h;
    if (gt.a()) {
      if (!this.m)
        return; 
      if (this.a != null && context != null) {
        if (!paramBoolean)
          return; 
        if (gy.c() <= 17)
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
  
  public final boolean a(ConnectivityManager paramConnectivityManager) {
    WifiManager wifiManager = this.a;
    if (wifiManager == null)
      return false; 
    try {
      if (gy.a(paramConnectivityManager.getActiveNetworkInfo()) == 1) {
        boolean bool = a(wifiManager.getConnectionInfo());
        if (bool)
          return true; 
      } 
    } finally {
      paramConnectivityManager = null;
    } 
  }
  
  public final void b() {
    this.v = null;
    this.b.clear();
  }
  
  public final void b(boolean paramBoolean) {
    if (paramBoolean) {
      q();
    } else {
      r();
    } 
    if (this.u) {
      this.u = false;
      b();
    } 
    s();
    if (gy.b() - f > 20000L)
      this.b.clear(); 
    d = gy.b();
    if (this.b.isEmpty()) {
      f = gy.b();
      List<ScanResult> list = j();
      if (list != null)
        this.b.addAll(list); 
    } 
    p();
  }
  
  public final void c() {
    if (this.a == null)
      return; 
    if (gy.b() - f > 4900L)
      f = gy.b(); 
  }
  
  public final void c(boolean paramBoolean) {
    d(paramBoolean);
  }
  
  public final void d() {
    byte b;
    if (this.a == null)
      return; 
    try {
      b = l();
    } finally {
      Exception exception = null;
      gu.a(exception, "Aps", "onReceive part");
    } 
    this.u = true;
  }
  
  public final boolean e() {
    return this.p;
  }
  
  public final WifiInfo f() {
    this.v = k();
    return this.v;
  }
  
  public final boolean g() {
    return this.i;
  }
  
  public final void h() {
    b();
    this.b.clear();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\go.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */