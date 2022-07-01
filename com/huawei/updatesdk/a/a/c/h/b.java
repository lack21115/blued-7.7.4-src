package com.huawei.updatesdk.a.a.c.h;

import android.content.Context;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.updatesdk.a.a.b.a.a.a;
import com.huawei.updatesdk.a.a.c.c;
import com.huawei.updatesdk.a.a.c.e;
import com.huawei.updatesdk.b.f.a;
import com.huawei.updatesdk.service.otaupdate.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class b {
  private static b c = new b();
  
  private static String d = null;
  
  private int a = 0;
  
  private int b = 0;
  
  private b() {
    if (a("ro.maple.enable", 0) == 1)
      this.a = 1; 
    this.b = a("ro.build.version.ark", 0);
  }
  
  public static int a(String paramString, int paramInt) {
    try {
      return ((Integer)clazz.getMethod("getInt", new Class[] { String.class, int.class }).invoke(null, new Object[] { paramString, Integer.valueOf(paramInt) })).intValue();
    } finally {
      paramString = null;
      a.a("DeviceUtil", "Exception while getting system property: ", (Throwable)paramString);
    } 
  }
  
  static String a(Context paramContext) {
    if (d == null)
      d = e.a(b(paramContext), ","); 
    return d;
  }
  
  public static String a(Context paramContext, String paramString) {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = "com.huawei.appmarket"; 
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append((paramContext.getPackageManager().getPackageInfo(str, 16)).versionName);
      stringBuilder.append("");
      return stringBuilder.toString();
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return "";
    } 
  }
  
  private static String a(String paramString) {
    if (paramString == null)
      return null; 
    try {
      return paramString.substring(0, paramString.indexOf('.'));
    } catch (Exception exception) {
      a.b("DeviceUtil", exception.toString());
      return null;
    } 
  }
  
  public static String a(String paramString1, String paramString2) {
    try {
      return (String)clazz.getMethod("get", new Class[] { String.class, String.class }).invoke(null, new Object[] { paramString1, paramString2 });
    } finally {
      paramString1 = null;
      a.a("DeviceUtil", "Exception while getting system property: ", (Throwable)paramString1);
    } 
  }
  
  public static List<String> a(List<String> paramList, String[] paramArrayOfString) {
    ArrayList<String> arrayList = new ArrayList();
    for (String str : paramList) {
      if (!a(str, paramArrayOfString))
        arrayList.add(str); 
    } 
    return arrayList;
  }
  
  static boolean a(String paramString, String[] paramArrayOfString) {
    int m = paramArrayOfString.length;
    boolean bool = false;
    int j = 0;
    byte b1 = 0;
    int k = 0;
    int i;
    for (i = 0; j < m; i = i1) {
      byte b2;
      int n;
      String str = paramArrayOfString[j];
      if (str.startsWith("config.")) {
        b2 = 1;
        n = k;
      } else {
        b2 = b1;
        n = k;
        if (!str.contains(".config.")) {
          n = k + 1;
          b2 = b1;
        } 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("config.");
      stringBuilder.append(paramString);
      int i1 = i;
      if (str.endsWith(stringBuilder.toString()))
        i1 = i + 1; 
      j++;
      b1 = b2;
      k = n;
    } 
    if (b1 + k == i)
      bool = true; 
    return bool;
  }
  
  public static String b(Context paramContext, String paramString) {
    paramString = a(paramContext, paramString);
    int i = 0;
    int j;
    for (j = 0; i < paramString.length() && j < 3; j = k) {
      int k = j;
      if (paramString.charAt(i) == '.')
        k = j + 1; 
      i++;
    } 
    String str = paramString;
    if (3 == j)
      str = paramString.substring(0, i - 1); 
    return str;
  }
  
  private static List<String> b(Context paramContext) {
    ArrayList<String> arrayList = new ArrayList();
    FeatureInfo[] arrayOfFeatureInfo = paramContext.getPackageManager().getSystemAvailableFeatures();
    if (arrayOfFeatureInfo != null) {
      int j = arrayOfFeatureInfo.length;
      for (int i = 0; i < j; i++) {
        String str = (arrayOfFeatureInfo[i]).name;
        if (str != null)
          arrayList.add(c.a(str)); 
      } 
    } 
    return arrayList;
  }
  
  private static DisplayMetrics c(Context paramContext) {
    WindowManager windowManager;
    Object object = paramContext.getSystemService("window");
    boolean bool = object instanceof WindowManager;
    Object object1 = null;
    if (bool) {
      windowManager = (WindowManager)object;
    } else {
      windowManager = null;
    } 
    object = object1;
    if (windowManager != null) {
      Display display = windowManager.getDefaultDisplay();
      object = object1;
      if (display != null) {
        object = new DisplayMetrics();
        display.getMetrics((DisplayMetrics)object);
      } 
    } 
    return (DisplayMetrics)object;
  }
  
  public static String c() {
    try {
      return (null == null) ? Build.DISPLAY : null.toString();
    } catch (IllegalAccessException illegalAccessException) {
      return Build.DISPLAY;
    } catch (NoSuchFieldException noSuchFieldException) {
      return Build.DISPLAY;
    } catch (ClassNotFoundException classNotFoundException) {
      return Build.DISPLAY;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static String c(Context paramContext, String paramString) {
    String str1;
    String str3 = h.g().a();
    if (TextUtils.isEmpty(str3)) {
      str1 = "UpdateSDK accoutZone is empty, so url is default";
      Log.i("DeviceUtil", str1);
      return paramString;
    } 
    String str2 = null;
    try {
      GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
    } finally {
      str1 = null;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("UpdateSDK Get url from GRS_SDK error: ");
      stringBuilder1.append(str1.toString());
      Log.w("DeviceUtil", stringBuilder1.toString());
    } 
    if (TextUtils.isEmpty(str1)) {
      str1 = "UpdateSDK Get url is default url";
      Log.i("DeviceUtil", str1);
      return paramString;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("UpdateSDK Get url from GRS_SDK Success!");
    stringBuilder.append(a(str1));
    Log.i("DeviceUtil", stringBuilder.toString());
    return str1;
  }
  
  public static b d() {
    return c;
  }
  
  public static List<String> d(Context paramContext) {
    LocaleList localeList;
    ArrayList<String> arrayList = new ArrayList();
    int i = Build.VERSION.SDK_INT;
    Configuration configuration = paramContext.getResources().getConfiguration();
    if (i >= 24) {
      localeList = configuration.getLocales();
      for (i = 0; i < localeList.size(); i++) {
        String str = localeList.get(i).getLanguage();
        if (!TextUtils.isEmpty(str) && !arrayList.contains(str))
          arrayList.add(str); 
      } 
    } else {
      arrayList.add(((Configuration)localeList).locale.getLanguage());
    } 
    return arrayList;
  }
  
  public static String e(Context paramContext) {
    DisplayMetrics displayMetrics = c(paramContext);
    if (displayMetrics != null) {
      int i = displayMetrics.widthPixels;
      int j = displayMetrics.heightPixels;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(String.valueOf(i));
      stringBuilder.append("_");
      stringBuilder.append(String.valueOf(j));
      return stringBuilder.toString();
    } 
    return "";
  }
  
  public static String[] e() {
    String[] arrayOfString;
    if (Build.VERSION.SDK_INT >= 21) {
      String[] arrayOfString1 = Build.SUPPORTED_ABIS;
      arrayOfString = arrayOfString1;
      if (arrayOfString1 == null)
        return new String[0]; 
    } else {
      arrayOfString = new String[1];
      arrayOfString[0] = Build.CPU_ABI;
    } 
    return arrayOfString;
  }
  
  public static String f() {
    String str1;
    String str3;
    StringBuilder stringBuilder1;
    Locale locale = Locale.getDefault();
    String str2 = "";
    if (locale != null) {
      String str = locale.getLanguage();
      str1 = str2;
      if (Build.VERSION.SDK_INT >= 21)
        str1 = locale.getScript(); 
      str2 = locale.getCountry();
      str3 = str1;
      str1 = str;
    } else {
      str1 = "en";
      String str = "US";
      str3 = str2;
      str2 = str;
    } 
    if (TextUtils.isEmpty(str3)) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str1);
      stringBuilder1.append("_");
      stringBuilder1.append(str2);
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str1);
    stringBuilder2.append("_");
    stringBuilder2.append((String)stringBuilder1);
    stringBuilder2.append("_");
    stringBuilder2.append(str2);
    return stringBuilder2.toString();
  }
  
  public static String f(Context paramContext) {
    DisplayMetrics displayMetrics = c(paramContext);
    return (displayMetrics != null) ? String.valueOf(displayMetrics.densityDpi) : "";
  }
  
  public static int g(Context paramContext) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append((paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 16)).versionCode);
      stringBuilder.append("");
      return Integer.parseInt(stringBuilder.toString());
    } catch (Exception exception) {
      return 1;
    } 
  }
  
  public static boolean g() {
    return ("huawei".equalsIgnoreCase(Build.BRAND) || "huawei".equalsIgnoreCase(Build.MANUFACTURER));
  }
  
  public static String h(Context paramContext) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append((paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 16)).versionName);
      stringBuilder.append("");
      return stringBuilder.toString();
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static boolean i(Context paramContext) {
    PackageManager packageManager = paramContext.getPackageManager();
    try {
      packageManager.getPackageInfo("com.google.android.gsf.login", 16);
      packageManager.getPackageInfo("com.google.android.gsf", 16);
      int i = (packageManager.getPackageInfo("com.google.android.gms", 16)).applicationInfo.flags;
      return ((i & 0x1) != 0);
    } catch (Exception exception) {
      a.b("DeviceUtil", exception.getMessage());
      return false;
    } 
  }
  
  public int a() {
    return this.a;
  }
  
  public void a(Window paramWindow) {
    if (a.d().a() >= 21) {
      if (paramWindow == null)
        return; 
      WindowManager.LayoutParams layoutParams = paramWindow.getAttributes();
      try {
        Class<?> clazz = Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx");
        layoutParams = clazz.getConstructor(new Class[] { WindowManager.LayoutParams.class }).newInstance(new Object[] { layoutParams });
        return;
      } finally {
        paramWindow = null;
      } 
    } 
  }
  
  public int b() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\a\c\h\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */