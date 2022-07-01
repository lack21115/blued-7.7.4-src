package com.baidu.mobads.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobads.MobadsPermissionSettings;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.openad.e.e;
import java.io.Closeable;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class t implements IXAdSystemUtils {
  static List<String[]> a = (List)new ArrayList<String>();
  
  static List<String[]> b = (List)new ArrayList<String>();
  
  static JSONArray c = new JSONArray();
  
  private static String e;
  
  private static String f;
  
  private static String g;
  
  private static String h;
  
  private static String i;
  
  private static String j;
  
  private static volatile t k = null;
  
  public JSONArray d = new JSONArray();
  
  private String l = "";
  
  private String m = "";
  
  private String n;
  
  private int o = -1;
  
  private String p;
  
  private String q;
  
  private String r;
  
  private long a(File paramFile) {
    try {
      StatFs statFs = new StatFs(paramFile.getPath());
      int i = statFs.getBlockCount() * statFs.getBlockSize() / 1024 / 1024;
      return i;
    } catch (Exception exception) {
      return -1L;
    } 
  }
  
  public static t a() {
    // Byte code:
    //   0: getstatic com/baidu/mobads/utils/t.k : Lcom/baidu/mobads/utils/t;
    //   3: ifnonnull -> 37
    //   6: ldc com/baidu/mobads/utils/t
    //   8: monitorenter
    //   9: getstatic com/baidu/mobads/utils/t.k : Lcom/baidu/mobads/utils/t;
    //   12: ifnonnull -> 25
    //   15: new com/baidu/mobads/utils/t
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/baidu/mobads/utils/t.k : Lcom/baidu/mobads/utils/t;
    //   25: ldc com/baidu/mobads/utils/t
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/baidu/mobads/utils/t
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/baidu/mobads/utils/t.k : Lcom/baidu/mobads/utils/t;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private Boolean a(Context paramContext, int paramInt) {
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      int i = paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE");
      boolean bool = true;
      if (i != 0) {
        XAdSDKFoundationFacade.getInstance().getAdLogger().e(new Object[] { "Utils", "no permission android.permission.ACCESS_NETWORK_STATE" });
        return Boolean.valueOf(false);
      } 
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      if (networkInfo == null || networkInfo.getType() != paramInt || !networkInfo.isConnected())
        bool = false; 
      return Boolean.valueOf(bool);
    } catch (Exception exception) {
      return Boolean.valueOf(false);
    } 
  }
  
  private void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        return;
      } finally {
        paramCloseable = null;
      }  
  }
  
  private long b(File paramFile) {
    try {
      StatFs statFs = new StatFs(paramFile.getPath());
      int i = statFs.getAvailableBlocks() * statFs.getBlockSize() / 1024 / 1024;
      return i;
    } catch (Exception exception) {
      return -1L;
    } 
  }
  
  private boolean e(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return true; 
    int i = paramString.length();
    while (true) {
      int j = i - 1;
      if (j >= 0) {
        i = j;
        if (paramString.charAt(j) != '0')
          return false; 
        continue;
      } 
      return true;
    } 
  }
  
  public boolean canSupportSdcardStroage(Context paramContext) {
    boolean bool = false;
    try {
      h h = XAdSDKFoundationFacade.getInstance().getCommonUtils();
      if (Build.VERSION.SDK_INT <= 28 && !h.hasPermission(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE")) {
        boolean bool1 = isUseOldStoragePath();
        return !bool1 ? true : bool;
      } 
      return true;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public long getAllExternalMemorySize() {
    long l = -1L;
    try {
      if (Environment.getExternalStorageState().equals("mounted"))
        l = a(Environment.getExternalStorageDirectory()); 
      return l;
    } catch (Exception exception) {
      return -1L;
    } 
  }
  
  public long getAllInternalMemorySize() {
    try {
      return a(Environment.getDataDirectory());
    } catch (Exception exception) {
      return -1L;
    } 
  }
  
  public String getAndroidId(Context paramContext) {
    try {
      if (!MobadsPermissionSettings.hasPermissionGranted("permission_read_phone_state"))
        return ""; 
      if (TextUtils.isEmpty(this.n)) {
        String str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
        this.n = XAdSDKFoundationFacade.getInstance().getCommonUtils().b(str);
      } 
      return this.n;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public String getAppSDC() {
    try {
      Object object = XAdSDKFoundationFacade.getInstance().getCommonUtils().a("sysSdc");
      if (object != null)
        return (String)object; 
    } catch (Exception exception) {
      q.a().e(exception);
    } 
    if (Environment.getExternalStorageState().equals("mounted")) {
      String str2 = "";
      String str1 = str2;
      try {
        long l1 = getAvailableExternalMemorySize();
        str1 = str2;
        long l2 = getAllExternalMemorySize();
        str1 = str2;
        StringBuilder stringBuilder = new StringBuilder();
        str1 = str2;
        stringBuilder.append(l1);
        str1 = str2;
        stringBuilder.append(",");
        str1 = str2;
        stringBuilder.append(l2);
        str1 = str2;
        str2 = stringBuilder.toString();
        str1 = str2;
        XAdSDKFoundationFacade.getInstance().getCommonUtils().a("sysSdc", str2);
        return str2;
      } catch (Exception exception) {
        return str1;
      } 
    } 
    return "0,0";
  }
  
  public long getAvailableExternalMemorySize() {
    long l = -1L;
    try {
      if (Environment.getExternalStorageState().equals("mounted"))
        l = b(Environment.getExternalStorageDirectory()); 
      return l;
    } catch (Exception exception) {
      return -1L;
    } 
  }
  
  public long getAvailableInternalMemorySize() {
    try {
      return b(Environment.getDataDirectory());
    } catch (Exception exception) {
      return -1L;
    } 
  }
  
  public JSONArray getBackgroundBrowsers(Context paramContext) {
    IXAdLogger iXAdLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
    try {
      String[] arrayOfString = XAdSDKFoundationFacade.getInstance().getAdConstants().getSupportedBrowsers();
      List list = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      PackageManager packageManager = paramContext.getApplicationContext().getPackageManager();
      for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
        if (packageManager.getLaunchIntentForPackage(runningAppProcessInfo.processName) != null && packageManager.getApplicationInfo(runningAppProcessInfo.processName, 128) != null)
          for (int i = 0; i < arrayOfString.length; i++) {
            if (runningAppProcessInfo.processName.equals(arrayOfString[i]))
              this.d.put(runningAppProcessInfo.processName); 
          }  
      } 
    } catch (Exception exception) {
      iXAdLogger.d(exception);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("bgBrowsers:");
    stringBuilder.append(this.d);
    iXAdLogger.d(stringBuilder.toString());
    return this.d;
  }
  
  public String getCUID(Context paramContext) {
    if (TextUtils.isEmpty(e))
      e.a((e.c)new v(this, paramContext)); 
    return XAdSDKFoundationFacade.getInstance().getCommonUtils().b(e);
  }
  
  public List<String[]> getCell(Context paramContext) {
    List<String[]> list1;
    if (!MobadsPermissionSettings.hasPermissionGranted("permission_location")) {
      list1 = a;
      if (list1 == null) {
        a = (List)new ArrayList<String>();
      } else {
        list1.clear();
      } 
      return a;
    } 
    List<String[]> list2 = a;
    if (list2 == null || list2.size() == 0)
      try {
        e.a((e.c)new z(this, ((TelephonyManager)list1.getSystemService("phone")).getCellLocation()));
      } finally {} 
    return a;
  }
  
  public int getCurrentProcessId(Context paramContext) {
    try {
      return Process.myPid();
    } catch (Exception exception) {
      return 0;
    } 
  }
  
  public String getCurrentProcessName(Context paramContext) {
    try {
      ActivityManager activityManager = (ActivityManager)paramContext.getSystemService("activity");
      if (this.r == null) {
        int i = Process.myPid();
        if (activityManager != null) {
          List list = activityManager.getRunningAppProcesses();
          if (list != null)
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
              if (runningAppProcessInfo.pid == i)
                this.r = runningAppProcessInfo.processName; 
            }  
        } 
      } 
      return this.r;
    } catch (Exception exception) {
      return this.r;
    } 
  }
  
  public String getDeviceId(Context paramContext) {
    if (!MobadsPermissionSettings.hasPermissionGranted("permission_read_phone_state"))
      return ""; 
    if (TextUtils.isEmpty(g) && paramContext != null) {
      SharedPreferences sharedPreferences = paramContext.getSharedPreferences("__x_adsdk_agent_header__", 0);
      String str = sharedPreferences.getString(XAdSDKFoundationFacade.getInstance().getBase64().decodeStr("pyd-pifb"), "");
      if (!TextUtils.isEmpty(str)) {
        g = str;
      } else {
        try {
          TelephonyManager telephonyManager = (TelephonyManager)paramContext.getApplicationContext().getSystemService("phone");
          String str2 = XAdSDKFoundationFacade.getInstance().getBase64().decodeStr("uvNYwANvpyP-iyfb");
          h h = XAdSDKFoundationFacade.getInstance().getCommonUtils();
          String str1 = str;
          if (Build.VERSION.SDK_INT < 29)
            str1 = (String)h.a(telephonyManager, str2, new Object[0]); 
        } finally {
          paramContext = null;
        } 
      } 
    } 
    return XAdSDKFoundationFacade.getInstance().getCommonUtils().b(g);
  }
  
  public String getEncodedSN(Context paramContext) {
    try {
      if (TextUtils.isEmpty(this.q))
        this.q = XAdSDKFoundationFacade.getInstance().getBase64().encode(getSn(paramContext)); 
      return this.q;
    } catch (Exception exception) {
      return this.q;
    } 
  }
  
  public double[] getGPS(Context paramContext) {
    return null;
  }
  
  public String getGUID(Context paramContext) {
    if (TextUtils.isEmpty(i))
      e.a((e.c)new w(this, paramContext)); 
    return i;
  }
  
  public HttpURLConnection getHttpConnection(Context paramContext, String paramString, int paramInt1, int paramInt2) {
    try {
      HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL(paramString)).openConnection();
      try {
        httpURLConnection.setConnectTimeout(paramInt1);
        httpURLConnection.setReadTimeout(paramInt2);
        return httpURLConnection;
      } catch (Exception exception) {}
      return httpURLConnection;
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public String getIMEI(Context paramContext) {
    if (!MobadsPermissionSettings.hasPermissionGranted("permission_read_phone_state"))
      return ""; 
    if (TextUtils.isEmpty(f)) {
      if (XAdSDKFoundationFacade.getInstance().getCommonUtils().hasPermission(paramContext, "android.permission.READ_PHONE_STATE")) {
        this.m = "1";
        String str = getDeviceId(paramContext);
        if (!e(str)) {
          this.l = "0";
          f = str;
          return f;
        } 
      } 
      e.a((e.c)new u(this, paramContext));
    } 
    return f;
  }
  
  public String getIp(Context paramContext) {
    return "";
  }
  
  public String getMacAddress(Context paramContext) {
    return "";
  }
  
  public String getMaxCpuFreq() {
    // Byte code:
    //   0: aload_0
    //   1: getfield o : I
    //   4: ifge -> 154
    //   7: new java/io/FileReader
    //   10: dup
    //   11: ldc_w '/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq'
    //   14: invokespecial <init> : (Ljava/lang/String;)V
    //   17: astore_1
    //   18: new java/io/BufferedReader
    //   21: dup
    //   22: aload_1
    //   23: invokespecial <init> : (Ljava/io/Reader;)V
    //   26: astore #4
    //   28: aload_1
    //   29: astore_3
    //   30: aload #4
    //   32: astore #6
    //   34: aload_0
    //   35: aload #4
    //   37: invokevirtual readLine : ()Ljava/lang/String;
    //   40: invokevirtual trim : ()Ljava/lang/String;
    //   43: invokestatic parseInt : (Ljava/lang/String;)I
    //   46: sipush #1000
    //   49: idiv
    //   50: putfield o : I
    //   53: goto -> 124
    //   56: astore #5
    //   58: aload_1
    //   59: astore_2
    //   60: aload #4
    //   62: astore_1
    //   63: goto -> 100
    //   66: astore_2
    //   67: aconst_null
    //   68: astore #6
    //   70: goto -> 141
    //   73: astore #5
    //   75: aconst_null
    //   76: astore_3
    //   77: aload_1
    //   78: astore_2
    //   79: aload_3
    //   80: astore_1
    //   81: goto -> 100
    //   84: astore_2
    //   85: aconst_null
    //   86: astore #6
    //   88: aload #6
    //   90: astore_1
    //   91: goto -> 141
    //   94: astore #5
    //   96: aconst_null
    //   97: astore_1
    //   98: aload_1
    //   99: astore_2
    //   100: aload_2
    //   101: astore_3
    //   102: aload_1
    //   103: astore #6
    //   105: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   108: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   111: aload #5
    //   113: invokeinterface d : (Ljava/lang/Throwable;)I
    //   118: pop
    //   119: aload_1
    //   120: astore #4
    //   122: aload_2
    //   123: astore_1
    //   124: aload_0
    //   125: aload_1
    //   126: invokespecial a : (Ljava/io/Closeable;)V
    //   129: aload_0
    //   130: aload #4
    //   132: invokespecial a : (Ljava/io/Closeable;)V
    //   135: goto -> 154
    //   138: astore_2
    //   139: aload_3
    //   140: astore_1
    //   141: aload_0
    //   142: aload_1
    //   143: invokespecial a : (Ljava/io/Closeable;)V
    //   146: aload_0
    //   147: aload #6
    //   149: invokespecial a : (Ljava/io/Closeable;)V
    //   152: aload_2
    //   153: athrow
    //   154: new java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial <init> : ()V
    //   161: astore_1
    //   162: aload_1
    //   163: aload_0
    //   164: getfield o : I
    //   167: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_1
    //   172: ldc ''
    //   174: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload_1
    //   179: invokevirtual toString : ()Ljava/lang/String;
    //   182: areturn
    // Exception table:
    //   from	to	target	type
    //   7	18	94	java/lang/Exception
    //   7	18	84	finally
    //   18	28	73	java/lang/Exception
    //   18	28	66	finally
    //   34	53	56	java/lang/Exception
    //   34	53	138	finally
    //   105	119	138	finally
  }
  
  public String getMem() {
    try {
      Object object = XAdSDKFoundationFacade.getInstance().getCommonUtils().a("sysMem");
      if (object != null)
        return (String)object; 
    } catch (Exception exception) {
      q.a().e(exception);
    } 
    String str2 = "";
    String str1 = str2;
    try {
      long l1 = getAvailableInternalMemorySize();
      str1 = str2;
      long l2 = getAllInternalMemorySize();
      str1 = str2;
      StringBuilder stringBuilder = new StringBuilder();
      str1 = str2;
      stringBuilder.append(l1);
      str1 = str2;
      stringBuilder.append(",");
      str1 = str2;
      stringBuilder.append(l2);
      str1 = str2;
      str2 = stringBuilder.toString();
      str1 = str2;
      XAdSDKFoundationFacade.getInstance().getCommonUtils().a("sysMem", str2);
      return str2;
    } catch (Exception exception) {
      return str1;
    } 
  }
  
  public String getNetType(Context paramContext) {
    String str1;
    String str3 = "";
    String str2 = str3;
    try {
      StringBuilder stringBuilder1;
      StringBuilder stringBuilder2 = new StringBuilder();
      str2 = str3;
      stringBuilder2.append("_");
      str2 = str3;
      stringBuilder2.append(((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType());
      str2 = str3;
      str3 = stringBuilder2.toString();
      str2 = str3;
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      str2 = str3;
      NetworkInfo networkInfo1 = connectivityManager.getNetworkInfo(0);
      str2 = str3;
      NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
      if (networkInfo1 != null) {
        str2 = str3;
        if (networkInfo1.isAvailable()) {
          str2 = str3;
          stringBuilder1 = new StringBuilder();
          str2 = str3;
          stringBuilder1.append(networkInfo1.getExtraInfo());
          str2 = str3;
          stringBuilder1.append(str3);
          str2 = str3;
          return stringBuilder1.toString();
        } 
      } 
      str1 = str3;
      if (stringBuilder1 != null) {
        str2 = str3;
        str1 = str3;
        if (stringBuilder1.isAvailable()) {
          str2 = str3;
          StringBuilder stringBuilder = new StringBuilder();
          str2 = str3;
          stringBuilder.append("wifi");
          str2 = str3;
          stringBuilder.append(str3);
          str2 = str3;
          return stringBuilder.toString();
        } 
      } 
    } catch (Exception exception) {
      q.a().e(exception);
      str1 = str2;
    } 
    return str1;
  }
  
  public int getNetworkCatagory(Context paramContext) {
    try {
      NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (networkInfo != null && networkInfo.isConnected()) {
        if (networkInfo.getType() == 1)
          return 100; 
        if (networkInfo.getType() == 0) {
          String str = networkInfo.getSubtypeName();
          switch (networkInfo.getSubtype()) {
            default:
              if (str != null)
                if (!str.equalsIgnoreCase("TD-SCDMA") && !str.equalsIgnoreCase("WCDMA")) {
                  boolean bool = str.equalsIgnoreCase("CDMA2000");
                  if (bool)
                    return 3; 
                  break;
                }  
              break;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
              return 3;
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
              return 2;
            case 0:
              break;
          } 
        } else {
          return 0;
        } 
      } else {
        return 0;
      } 
    } catch (Exception exception) {
      return 0;
    } 
    return 1;
  }
  
  public String getNetworkOperator(Context paramContext) {
    try {
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (TextUtils.isEmpty(this.p))
        this.p = XAdSDKFoundationFacade.getInstance().getCommonUtils().b(telephonyManager.getNetworkOperator()); 
      return this.p;
    } catch (Exception exception) {
      return this.p;
    } 
  }
  
  public String getNetworkOperatorName(Context paramContext) {
    if (TextUtils.isEmpty(j))
      e.a((e.c)new x(this, (TelephonyManager)paramContext.getSystemService("phone"))); 
    return j;
  }
  
  public String getNetworkType(Context paramContext) {
    String str1;
    String str3 = "none";
    String str2 = str3;
    try {
      NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      str1 = str3;
      if (networkInfo != null) {
        str2 = str3;
        str1 = str3;
        if (networkInfo.isConnectedOrConnecting()) {
          str2 = str3;
          if (networkInfo.getType() == 1)
            return "wifi"; 
          str3 = "unknown";
          str2 = str3;
          str1 = str3;
          if (networkInfo.getSubtypeName() != null) {
            str2 = str3;
            return networkInfo.getSubtypeName().toLowerCase();
          } 
        } 
      } 
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().i(new Object[] { exception });
      str1 = str2;
    } 
    return str1;
  }
  
  public String getPhoneOSBrand() {
    return XAdSDKFoundationFacade.getInstance().getCommonUtils().b(Build.BRAND);
  }
  
  public String getPhoneOSBuildVersionSdk() {
    return XAdSDKFoundationFacade.getInstance().getCommonUtils().b(Build.VERSION.SDK);
  }
  
  public String getSn(Context paramContext) {
    try {
      if (TextUtils.isEmpty(h)) {
        String str2 = getIMEI(paramContext);
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
          str1 = getMacAddress(paramContext); 
        h = XAdSDKFoundationFacade.getInstance().getCommonUtils().b(str1);
      } 
      return h;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public String getSnFrom(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.l);
    stringBuilder.append(this.m);
    return stringBuilder.toString();
  }
  
  public List<String[]> getWIFI(Context paramContext) {
    return b;
  }
  
  public String getWifiConnected(Context paramContext) {
    return "";
  }
  
  public JSONArray getWifiScans(Context paramContext) {
    return c;
  }
  
  public Boolean is3GConnected(Context paramContext) {
    return a(paramContext, 0);
  }
  
  public boolean isCurrentNetworkAvailable(Context paramContext) {
    try {
      NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (networkInfo != null) {
        boolean bool = networkInfo.isAvailable();
        if (bool)
          return true; 
      } 
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d("isCurrentNetworkAvailable", exception);
    } 
    return false;
  }
  
  public boolean isTablet(Context paramContext) {
    return (((paramContext.getResources().getConfiguration()).screenLayout & 0xF) >= 3);
  }
  
  public boolean isUseOldStoragePath() {
    return (Build.VERSION.SDK_INT < 23);
  }
  
  public Boolean isWifiConnected(Context paramContext) {
    return a(paramContext, 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\\utils\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */