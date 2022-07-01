package com.datavisor.vangogh.b;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.webkit.WebSettings;
import com.datavisor.vangogh.f.d;
import com.datavisor.vangogh.f.e;
import com.datavisor.vangogh.f.f;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
  public static String a;
  
  private static b b = new b();
  
  static {
    a = com.datavisor.vangogh.c.a.a;
  }
  
  private String A() {
    try {
      String str;
      BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
      if (bluetoothAdapter == null)
        return null; 
      if (bluetoothAdapter.isEnabled()) {
        str = bluetoothAdapter.getAddress();
      } else {
        str = null;
      } 
      return bool ? null : str;
    } finally {
      Exception exception = null;
      d.a(exception);
    } 
  }
  
  private String B() {
    String str;
    try {
      new FileReader("/sys/block/mmcblk0/device/type");
    } finally {
      Exception exception = null;
    } 
    try {
      new FileReader("/sys/block/mmcblk1/device/type");
      str = "/sys/block/mmcblk1/device/";
    } finally {
      Exception exception;
    } 
    try {
      return "/sys/block/mmcblk2/device/";
    } finally {
      Exception exception = null;
    } 
  }
  
  private String T(Context paramContext) {
    if (a(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
      d.b(a, "no permission ACCESS_WIFI_STATE");
      return "no_permission";
    } 
    try {
      int i;
      String str = c.a().a(paramContext);
      boolean bool = f.a(str);
      if (bool)
        return "empty"; 
      byte[] arrayOfByte = NetworkInterface.getByInetAddress(InetAddress.getByName(str)).getHardwareAddress();
      if (arrayOfByte == null)
        return "empty"; 
      StringBuilder stringBuilder = new StringBuilder();
      int j = arrayOfByte.length;
      return !stringBuilder.toString().equals("02:00:00:00:00:00") ? (stringBuilder.toString().equals("00:00:00:00:00:00") ? "empty" : stringBuilder.toString()) : "empty";
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public static b a() {
    return b;
  }
  
  private String a(BluetoothAdapter paramBluetoothAdapter) {
    try {
      Field field = BluetoothAdapter.class.getDeclaredField("mService");
      field.setAccessible(true);
      Object object = field.get(paramBluetoothAdapter);
      if (object == null)
        return null; 
      Class<?> clazz = object.getClass();
      Method method = clazz.getDeclaredMethod("getAddress", new Class[0]);
      method.setAccessible(true);
      return (object != null && object instanceof String) ? (String)object : null;
    } finally {
      paramBluetoothAdapter = null;
    } 
  }
  
  public static boolean a(Context paramContext, String paramString) {
    return b(paramContext, paramString) ^ true;
  }
  
  private boolean a(String paramString) {
    if (paramString != null) {
      try {
        if (paramString.equals(""))
          return true; 
      } finally {
        paramString = null;
      } 
    } else {
      return true;
    } 
    int i = 0;
    int j;
    for (j = 0; i <= paramString.length() - 1; j = k) {
      int m = i + 1;
      int k = j;
      if (paramString.substring(i, m).equals("0")) {
        i = j + 1;
        j = paramString.length() / 2;
        k = i;
        if (i > j)
          return true; 
      } 
      i = m;
    } 
    return false;
  }
  
  public static boolean b(Context paramContext, String paramString) {
    boolean bool = false;
    try {
      int i = paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName());
      return bool;
    } finally {
      paramContext = null;
    } 
  }
  
  public String A(Context paramContext) {
    try {
      if (a(paramContext, "android.permission.READ_PHONE_STATE"))
        return "no_permission"; 
      if (paramContext == null)
        return "para_err"; 
      String str = ((TelephonyManager)paramContext.getSystemService("phone")).getSimOperator();
      return str;
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String B(Context paramContext) {
    try {
      if (a(paramContext, "android.permission.READ_PHONE_STATE"))
        return "no_permission"; 
      if (paramContext == null)
        return "para_err"; 
      String str = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperatorName();
      return str;
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String C(Context paramContext) {
    if (paramContext == null)
      return "empty"; 
    try {
      int i = Settings.System.getInt(paramContext.getContentResolver(), "screen_brightness");
      StringBuilder stringBuilder = new StringBuilder();
      return stringBuilder.toString();
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String D(Context paramContext) {
    try {
      List list = ((SensorManager)paramContext.getSystemService("sensor")).getSensorList(-1);
      StringBuilder stringBuilder = new StringBuilder();
      return stringBuilder.toString();
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String E(Context paramContext) {
    try {
      if (a(paramContext, "android.permission.READ_PHONE_STATE"))
        return "no_permission"; 
      if (paramContext == null)
        return "para_err"; 
      return "empty";
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String F(Context paramContext) {
    try {
      String str2 = Build.SERIAL;
      String str1 = str2;
      return bool ? "empty" : str1;
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String G(Context paramContext) {
    try {
      return (i > 0) ? "1" : "0";
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String H(Context paramContext) {
    if (a(paramContext, "android.permission.READ_PHONE_STATE")) {
      d.b(a, "no permission READ_PHONE_STATE");
      return "no_permission";
    } 
    try {
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      Class<?> clazz = telephonyManager.getClass();
      String str = (String)clazz.getMethod("getDeviceId", new Class[] { int.class }).invoke(telephonyManager, new Object[] { Integer.valueOf(1) });
      return str;
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String I(Context paramContext) {
    if (a(paramContext, "android.permission.READ_PHONE_STATE")) {
      d.b(a, "no permission READ_PHONE_STATE");
      return "no_permission";
    } 
    try {
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      Class<?> clazz = telephonyManager.getClass();
      String str = (String)clazz.getMethod("getDeviceId", new Class[] { int.class }).invoke(telephonyManager, new Object[] { Integer.valueOf(2) });
      return str;
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String J(Context paramContext) {
    String str;
    if (a(paramContext, "android.permission.CHANGE_WIFI_STATE")) {
      String str1 = a;
      str = "no permission CHANGE_WIFI_STATE";
      d.b(str1, str);
      return "no_permission";
    } 
    if (a((Context)str, "android.permission.ACCESS_WIFI_STATE")) {
      String str1 = a;
      str = "no permission ACCESS_WIFI_STATE";
      d.b(str1, str);
      return "no_permission";
    } 
    if (a((Context)str, "android.permission.ACCESS_NETWORK_STATE")) {
      String str1 = a;
      str = "no permission ACCESS_NETWORK_STATE";
      d.b(str1, str);
      return "no_permission";
    } 
    if (a((Context)str, "android.permission.ACCESS_FINE_LOCATION")) {
      String str1 = a;
      str = "no permission ACCESS_FINE_LOCATION";
      d.b(str1, str);
      return "no_permission";
    } 
    try {
      JSONArray jSONArray = new JSONArray();
      WifiManager wifiManager = (WifiManager)str.getSystemService("wifi");
      wifiManager.startScan();
      for (ScanResult scanResult : wifiManager.getScanResults()) {
        JSONArray jSONArray1 = new JSONArray();
        jSONArray1.put(scanResult.SSID);
        jSONArray1.put(scanResult.BSSID);
        jSONArray1.put(scanResult.level);
        jSONArray.put(jSONArray1);
      } 
      ArrayList<JSONArray> arrayList = new ArrayList();
      boolean bool = false;
      int i;
      for (i = 0; i < jSONArray.length(); i++)
        arrayList.add((JSONArray)jSONArray.get(i)); 
      Collections.sort(arrayList, new a(this));
      return jSONArray.toString();
    } finally {
      str = null;
      d.a((Throwable)str);
    } 
  }
  
  public String K(Context paramContext) {
    if (a(paramContext, "android.permission.READ_PHONE_STATE")) {
      d.b(a, "no permission READ_PHONE_STATE");
      return "no_permission";
    } 
    return e.a(paramContext);
  }
  
  public String L(Context paramContext) {
    if (a(paramContext, "android.permission.READ_PHONE_STATE")) {
      d.b(a, "no permission READ_PHONE_STATE");
      return "no_permission";
    } 
    return e.b(paramContext);
  }
  
  public String M(Context paramContext) {
    if (a(paramContext, "android.permission.READ_PHONE_STATE")) {
      d.b(a, "no permission READ_PHONE_STATE");
      return "no_permission";
    } 
    return e.c(paramContext);
  }
  
  public String N(Context paramContext) {
    return e.d(paramContext);
  }
  
  public String O(Context paramContext) {
    return e.e(paramContext);
  }
  
  public String P(Context paramContext) {
    try {
      return "empty";
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String Q(Context paramContext) {
    try {
      return "empty";
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String R(Context paramContext) {
    try {
      Map map = com.datavisor.vangogh.f.h.a.a();
      if (map == null)
        return "empty"; 
      int i = ((Integer)map.get("userid")).intValue();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("");
      return stringBuilder.toString();
    } finally {
      paramContext = null;
    } 
  }
  
  public String S(Context paramContext) {
    try {
      return "empty";
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String a(Context paramContext) {
    String str1;
    if (a(paramContext, "android.permission.READ_PHONE_STATE")) {
      d.b(a, "no permission READ_PHONE_STATE");
      return "no_permission";
    } 
    if (paramContext == null) {
      d.b(a, "context is null");
      return "para_err";
    } 
    try {
    
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
    String str2 = str1;
    if (f.a(str1))
      str2 = "empty"; 
    return str2;
  }
  
  public String b() {
    try {
      long l = Environment.getDataDirectory().getTotalSpace();
      if (l == 0L)
        return "default"; 
      StringBuilder stringBuilder = new StringBuilder();
      return stringBuilder.toString();
    } finally {
      Exception exception = null;
      d.a(exception);
    } 
  }
  
  public String b(Context paramContext) {
    String str1;
    if (a(paramContext, "android.permission.READ_PHONE_STATE")) {
      d.b(a, "no permission READ_PHONE_STATE");
      return "no_permission";
    } 
    if (paramContext == null) {
      d.b(a, "context is null");
      return "para_err";
    } 
    try {
    
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
    String str2 = str1;
    if (f.a(str1))
      str2 = "empty"; 
    return str2;
  }
  
  public String c() {
    try {
      long l = Environment.getDataDirectory().getFreeSpace();
      if (l == 0L)
        return "default"; 
      StringBuilder stringBuilder = new StringBuilder();
      return stringBuilder.toString();
    } finally {
      Exception exception = null;
      d.a(exception);
    } 
  }
  
  public String c(Context paramContext) {
    String str1;
    if (a(paramContext, "android.permission.READ_PHONE_STATE")) {
      d.b(a, "no permission READ_PHONE_STATE");
      return "no_permission";
    } 
    if (paramContext == null) {
      d.b(a, "context is null");
      return "para_err";
    } 
    try {
    
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
    String str2 = str1;
    if (f.a(str1))
      str2 = "empty"; 
    return str2;
  }
  
  public String c(Context paramContext, String paramString) {
    if (a(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
      d.b(a, "no permission ACCESS_WIFI_STATE");
      return "no_permission";
    } 
    if (paramContext == null) {
      d.b(a, "context is null");
      return "para_err";
    } 
    try {
      return "empty";
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String d() {
    BufferedReader bufferedReader1;
    FileReader fileReader;
    BufferedReader bufferedReader2 = null;
    try {
    
    } finally {
      null = null;
      fileReader = null;
    } 
    try {
      d.a(null);
      return "exception";
    } finally {
      if (fileReader != null)
        try {
          fileReader.close();
        } finally {} 
      if (bufferedReader1 != null)
        try {
          bufferedReader1.close();
        } finally {} 
    } 
  }
  
  public String d(Context paramContext) {
    String str;
    if (a(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
      d.b(a, "no permission ACCESS_WIFI_STATE");
      return "no_permission";
    } 
    if (paramContext == null) {
      d.b(a, "context is null");
      return "para_err";
    } 
    try {
    
    } finally {
      paramContext = null;
      d.b(a, "throw Exce");
    } 
    return str;
  }
  
  public String e() {
    return Build.DEVICE;
  }
  
  public String e(Context paramContext) {
    if (a(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
      d.b(a, "no permission ACCESS_WIFI_STATE");
      return "no_permission";
    } 
    if (paramContext == null) {
      d.b(a, "context is null");
      return "para_err";
    } 
    try {
      String str = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      return "empty";
    } finally {
      paramContext = null;
    } 
  }
  
  public String f() {
    return Build.MODEL;
  }
  
  public String f(Context paramContext) {
    try {
      return (x(paramContext) == 1) ? T(paramContext) : "empty";
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String g() {
    return Build.VERSION.RELEASE;
  }
  
  public String g(Context paramContext) {
    try {
      return (x(paramContext) == 0) ? T(paramContext) : "empty";
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String h() {
    return Build.HARDWARE;
  }
  
  public String h(Context paramContext) {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 'android.permission.BLUETOOTH'
    //   4: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   7: ifeq -> 21
    //   10: getstatic com/datavisor/vangogh/b/b.a : Ljava/lang/String;
    //   13: ldc 'no permission ACCESS_WIFI_STATE'
    //   15: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   18: ldc 'no_permission'
    //   20: areturn
    //   21: aload_1
    //   22: ifnonnull -> 36
    //   25: getstatic com/datavisor/vangogh/b/b.a : Ljava/lang/String;
    //   28: ldc 'context is null'
    //   30: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   33: ldc 'para_err'
    //   35: areturn
    //   36: aload_0
    //   37: invokespecial A : ()Ljava/lang/String;
    //   40: astore #4
    //   42: aload #4
    //   44: invokestatic a : (Ljava/lang/String;)Z
    //   47: istore_2
    //   48: iload_2
    //   49: ifne -> 75
    //   52: ldc '02:00:00:00:00:00'
    //   54: aload #4
    //   56: invokevirtual equals : (Ljava/lang/Object;)Z
    //   59: ifne -> 75
    //   62: aload #4
    //   64: astore_3
    //   65: ldc '00:00:00:00:00:00'
    //   67: aload #4
    //   69: invokevirtual equals : (Ljava/lang/Object;)Z
    //   72: ifeq -> 116
    //   75: aload_1
    //   76: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   79: ldc_w 'bluetooth_address'
    //   82: invokestatic getString : (Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   85: astore_3
    //   86: aload_3
    //   87: invokestatic a : (Ljava/lang/String;)Z
    //   90: ifne -> 113
    //   93: ldc '02:00:00:00:00:00'
    //   95: aload_3
    //   96: invokevirtual equals : (Ljava/lang/Object;)Z
    //   99: ifne -> 113
    //   102: ldc '00:00:00:00:00:00'
    //   104: aload_3
    //   105: invokevirtual equals : (Ljava/lang/Object;)Z
    //   108: istore_2
    //   109: iload_2
    //   110: ifeq -> 116
    //   113: ldc 'empty'
    //   115: astore_3
    //   116: aload_3
    //   117: invokestatic a : (Ljava/lang/String;)Z
    //   120: ifeq -> 126
    //   123: ldc 'empty'
    //   125: areturn
    //   126: aload_3
    //   127: areturn
    //   128: astore_1
    //   129: aload_1
    //   130: invokestatic a : (Ljava/lang/Throwable;)V
    //   133: ldc 'exception'
    //   135: areturn
    // Exception table:
    //   from	to	target	type
    //   42	48	128	finally
    //   52	62	128	finally
    //   65	75	128	finally
    //   75	109	128	finally
  }
  
  public String i() {
    return Build.CPU_ABI;
  }
  
  public String i(Context paramContext) {
    if (paramContext == null) {
      d.b(a, "context is null");
      return "para_err";
    } 
    try {
      String str2 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return str1;
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String j() {
    try {
      File[] arrayOfFile = (new File("/sys/devices/system/cpu/")).listFiles(new b(this));
      StringBuilder stringBuilder = new StringBuilder();
      return stringBuilder.toString();
    } finally {
      Exception exception = null;
      d.a(exception);
    } 
  }
  
  public String j(Context paramContext) {
    try {
      return jSONArray.toString();
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String k() {
    try {
      String str = com.datavisor.vangogh.f.h.a.b("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
      return str;
    } finally {
      Exception exception = null;
      d.a(exception);
    } 
  }
  
  public String k(Context paramContext) {
    try {
      String str1;
      String str3 = com.datavisor.vangogh.storage.local.b.b(".__puuk.sys");
      String str4 = com.datavisor.vangogh.e.b.a.b(paramContext, "DVSPUUID");
      if (f.b(str3)) {
        str1 = str3;
      } else {
        boolean bool = f.b(str4);
        if (bool) {
          str1 = str4;
        } else {
          str1 = "";
        } 
      } 
      String str2 = str1;
      if (f.a(str1))
        str2 = UUID.randomUUID().toString(); 
      return str2;
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String l() {
    try {
      String str = com.datavisor.vangogh.f.h.a.d("Processor");
      return str;
    } finally {
      Exception exception = null;
      d.a(exception);
    } 
  }
  
  public String l(Context paramContext) {
    try {
      boolean bool = com.datavisor.vangogh.d.b.a(paramContext).b("uuid10");
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
    return "empty";
  }
  
  public String m() {
    try {
      String str = com.datavisor.vangogh.f.h.a.d("Hardware");
      return str;
    } finally {
      Exception exception = null;
      d.a(exception);
    } 
  }
  
  public String m(Context paramContext) {
    try {
      String str2 = com.datavisor.vangogh.storage.local.b.b(".__psek.sys");
      boolean bool = f.a(str2);
      if (bool)
        str2 = com.datavisor.vangogh.e.b.a.b(paramContext, "DVSPSEQ"); 
      int i = 0;
      if (f.b(str2))
        i = Integer.parseInt(str2); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(i + 1);
      stringBuilder.append("");
      String str1 = stringBuilder.toString();
      return str1;
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String n() {
    try {
      int i = Process.myPid();
      StringBuilder stringBuilder = new StringBuilder();
      return stringBuilder.toString();
    } finally {
      Exception exception = null;
      d.a(exception);
    } 
  }
  
  public String n(Context paramContext) {
    try {
      String str1;
      String str3 = com.datavisor.vangogh.storage.local.b.b(".__pfrk.sys");
      String str4 = com.datavisor.vangogh.e.b.a.b(paramContext, "DVSPFIRSTREPORTTIME");
      boolean bool = f.b(str3);
      if (bool) {
        str1 = str3;
      } else if (f.b(str4)) {
        str1 = str4;
      } else {
        str1 = "";
      } 
      String str2 = str1;
      if (f.a(str1)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("");
        str2 = stringBuilder.toString();
      } 
      return str2;
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String o() {
    return Build.BRAND;
  }
  
  public String o(Context paramContext) {
    try {
      DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
      StringBuilder stringBuilder = new StringBuilder();
      return stringBuilder.toString();
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String p() {
    return Build.MANUFACTURER;
  }
  
  public String p(Context paramContext) {
    try {
      DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
      StringBuilder stringBuilder = new StringBuilder();
      return stringBuilder.toString();
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String q() {
    try {
      String str2 = Locale.getDefault().toString();
      return str1;
    } finally {
      Exception exception = null;
      d.a(exception);
    } 
  }
  
  public String q(Context paramContext) {
    try {
      DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels));
      return stringBuilder.toString();
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String r() {
    try {
      String str = TimeZone.getDefault().getDisplayName(false, 0);
      return str;
    } finally {
      Exception exception = null;
      d.a(exception);
    } 
  }
  
  public String r(Context paramContext) {
    try {
      return ((i & 0xF) >= 3) ? "1" : "0";
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String s() {
    try {
      return (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).format(new Date(System.currentTimeMillis()));
    } finally {
      Exception exception = null;
      d.a(exception);
    } 
  }
  
  public String s(Context paramContext) {
    try {
      String str;
      if (Build.VERSION.SDK_INT >= 17) {
        String str1 = WebSettings.getDefaultUserAgent(paramContext);
      } else {
        paramContext = null;
      } 
      Context context = paramContext;
      if (f.a((String)paramContext))
        str = System.getProperty("http.agent"); 
      boolean bool = f.a(str);
      if (bool)
        return "empty"; 
      StringBuilder stringBuilder = new StringBuilder();
      int j = str.length();
      for (int i = 0;; i++) {
        if (i < j) {
          char c = str.charAt(i);
          if (c <= '\037' || c >= '') {
            stringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
          } else {
            stringBuilder.append(c);
          } 
        } else {
          return stringBuilder.toString();
        } 
      } 
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String t() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      return stringBuilder.toString();
    } finally {
      Exception exception = null;
      d.a(exception);
    } 
  }
  
  public String t(Context paramContext) {
    if (paramContext == null) {
      d.b(a, "context is null");
      return "para_err";
    } 
    try {
      boolean bool;
      JSONObject jSONObject = new JSONObject();
      AudioManager audioManager = (AudioManager)paramContext.getSystemService("audio");
      if (audioManager.getRingerMode() == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      int i = audioManager.getStreamVolume(0);
      int j = audioManager.getStreamVolume(1);
      int k = audioManager.getStreamVolume(2);
      int m = audioManager.getStreamVolume(3);
      int n = audioManager.getStreamVolume(4);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(bool);
      jSONObject.put("ringermode", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(i);
      jSONObject.put("call", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(j);
      jSONObject.put("system", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(k);
      jSONObject.put("ring", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(m);
      jSONObject.put("music", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("");
      return jSONObject.toString();
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String u() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      return stringBuilder.toString();
    } finally {
      Exception exception = null;
      d.a(exception);
    } 
  }
  
  public String u(Context paramContext) {
    String str;
    if (a(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
      String str1 = a;
      str = "no ACCESS_WIFI_STATE";
      d.b(str1, str);
      return "no_permission";
    } 
    if (a((Context)str, "android.permission.ACCESS_COARSE_LOCATION")) {
      String str1 = a;
      str = "no ACCESS_COARSE_LOCATION";
      d.b(str1, str);
      return "no_permission";
    } 
    if (str == null) {
      d.b(a, "context is null");
      return "para_err";
    } 
    try {
    
    } finally {
      str = null;
      d.a((Throwable)str);
    } 
    if (!f.a(str) && !str.equals("02:00:00:00:00:00")) {
      String str1 = str;
      return str.equals("00:00:00:00:00:00") ? "empty" : str1;
    } 
    return "empty";
  }
  
  public String v() {
    String str = B();
    if (str == null)
      return "empty"; 
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      return (new BufferedReader(new FileReader(stringBuilder.toString()))).readLine();
    } finally {
      str = null;
    } 
  }
  
  public String v(Context paramContext) {
    String str1;
    if (a(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
      d.b(a, "no ACCESS_WIFI_STATE");
      return "no_permission";
    } 
    if (paramContext == null) {
      d.b(a, "context is null");
      return "para_err";
    } 
    String str2 = null;
    try {
      WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
      if (wifiManager.isWifiEnabled())
        str2 = wifiManager.getConnectionInfo().getSSID(); 
      String str = str2;
      if (f.b(str2)) {
        str = str2;
        if (str2.equals("<unknown ssid>"))
          str = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo().getExtraInfo(); 
      } 
      if (f.a(str))
        return "empty"; 
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
    return str1;
  }
  
  public String w() {
    String str = B();
    if (str == null)
      return "empty"; 
    try {
      StringBuilder stringBuilder = new StringBuilder();
      return (new BufferedReader(new FileReader(stringBuilder.toString()))).readLine();
    } finally {
      str = null;
      d.a((Throwable)str);
    } 
  }
  
  public boolean w(Context paramContext) {
    try {
      if (a(paramContext, "android.permission.ACCESS_NETWORK_STATE"))
        return true; 
      if (paramContext == null)
        return true; 
      NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      return false;
    } finally {
      paramContext = null;
    } 
  }
  
  public int x(Context paramContext) {
    if (paramContext == null)
      return -1; 
    if (a(paramContext, "android.permission.ACCESS_NETWORK_STATE"))
      return -1; 
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      return -1;
    } finally {
      paramContext = null;
    } 
  }
  
  public String x() {
    String str = B();
    if (str == null)
      return "empty"; 
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      return (new BufferedReader(new FileReader(stringBuilder.toString()))).readLine();
    } finally {
      str = null;
    } 
  }
  
  public String y() {
    String str = B();
    if (str == null)
      return "empty"; 
    try {
      StringBuilder stringBuilder = new StringBuilder();
      return (new BufferedReader(new FileReader(stringBuilder.toString()))).readLine();
    } finally {
      str = null;
      d.a((Throwable)str);
    } 
  }
  
  public String y(Context paramContext) {
    if (paramContext == null) {
      d.b(a, "context is null");
      return "para_err";
    } 
    if (a(paramContext, "android.permission.ACCESS_NETWORK_STATE")) {
      d.b(a, "no ACCESS_NETWORK_STATE");
      return "no_permission";
    } 
    try {
      return "-1";
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String z() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Build.BOARD);
      stringBuilder.append(Build.BRAND);
      stringBuilder.append(Build.CPU_ABI);
      stringBuilder.append(Build.DEVICE);
      stringBuilder.append(Build.DISPLAY);
      stringBuilder.append(Build.HOST);
      stringBuilder.append(Build.ID);
      stringBuilder.append(Build.MANUFACTURER);
      stringBuilder.append(Build.MODEL);
      stringBuilder.append(Build.PRODUCT);
      stringBuilder.append(Build.TAGS);
      stringBuilder.append(Build.TYPE);
      stringBuilder.append(Build.USER);
      String str = com.datavisor.vangogh.f.g.a.a(stringBuilder.toString());
      return str;
    } finally {
      Exception exception = null;
      d.a(exception);
    } 
  }
  
  public String z(Context paramContext) {
    boolean bool;
    boolean bool1;
    if (a(paramContext, "android.permission.INTERNET")) {
      d.b(a, "no permission INTERNET");
      return "no_permission";
    } 
    boolean bool2 = false;
    try {
    
    } finally {
      Exception exception = null;
      boolean bool3 = false;
      d.a(exception);
    } 
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
    return (bool || bool1) ? "1" : "0";
  }
  
  class a implements Comparator<JSONArray> {
    a(b this$0) {}
    
    public int a(JSONArray param1JSONArray1, JSONArray param1JSONArray2) {
      try {
        int i = param1JSONArray1.getInt(2);
        int j = param1JSONArray2.getInt(2);
        return (i < j) ? 1 : ((i == j) ? 0 : -1);
      } catch (JSONException jSONException) {
        return 0;
      } 
    }
  }
  
  class b implements FileFilter {
    b(b this$0) {}
    
    public boolean accept(File param1File) {
      try {
        return Pattern.matches("cpu[0-9]", param1File.getName());
      } finally {
        param1File = null;
        d.a((Throwable)param1File);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */