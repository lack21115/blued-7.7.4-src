package org.chromium.base;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import org.chromium.base.annotations.CalledByNative;

public class BuildInfo {
  private static PackageInfo sBrowserPackageInfo;
  
  private static boolean sInitialized;
  
  private String abiString;
  
  private String androidBuildFingerprint;
  
  private String customThemes;
  
  public final String extractedFileSuffix;
  
  private String gmsVersionCode;
  
  private String hostPackageLabel;
  
  private int hostVersionCode;
  
  private String installerPackageName;
  
  private String packageName;
  
  private String resourcesVersion;
  
  private int versionCode;
  
  private String versionName;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private BuildInfo() {
    sInitialized = true;
    try {
      long l;
      Context context = ContextUtils.sApplicationContext;
      String str2 = context.getPackageName();
      PackageManager packageManager = context.getPackageManager();
      PackageInfo packageInfo = packageManager.getPackageInfo(str2, 0);
      this.hostVersionCode = packageInfo.versionCode;
      if (sBrowserPackageInfo != null) {
        this.packageName = sBrowserPackageInfo.packageName;
        this.versionCode = sBrowserPackageInfo.versionCode;
        this.versionName = nullToEmpty(sBrowserPackageInfo.versionName);
        sBrowserPackageInfo = null;
      } else {
        this.packageName = str2;
        this.versionCode = this.hostVersionCode;
        this.versionName = nullToEmpty(packageInfo.versionName);
      } 
      this.hostPackageLabel = nullToEmpty(packageManager.getApplicationLabel(packageInfo.applicationInfo));
      this.installerPackageName = nullToEmpty(packageManager.getInstallerPackageName(this.packageName));
      try {
        PackageInfo packageInfo1 = packageManager.getPackageInfo("com.google.android.gms", 0);
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        nameNotFoundException = null;
      } 
      if (nameNotFoundException != null) {
        str1 = String.valueOf(((PackageInfo)nameNotFoundException).versionCode);
      } else {
        str1 = "gms versionCode not available.";
      } 
      this.gmsVersionCode = str1;
      String str1 = "true";
      try {
        packageManager.getPackageInfo("projekt.substratum", 0);
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException1) {
        str1 = "false";
      } 
      this.customThemes = str1;
      str1 = "Not Enabled";
      int i = BuildConfig.R_STRING_PRODUCT_VERSION;
      if (i != 0)
        try {
          str1 = ContextUtils.sApplicationContext.getString(BuildConfig.R_STRING_PRODUCT_VERSION);
        } catch (Exception exception) {
          str1 = "Not found";
        }  
      this.resourcesVersion = str1;
      if (Build.VERSION.SDK_INT >= 21) {
        this.abiString = TextUtils.join(", ", (Object[])Build.SUPPORTED_ABIS);
      } else {
        this.abiString = String.format("ABI1: %s, ABI2: %s", new Object[] { Build.CPU_ABI, Build.CPU_ABI2 });
      } 
      if (this.versionCode > 10) {
        l = this.versionCode;
      } else {
        l = packageInfo.lastUpdateTime;
      } 
      this.extractedFileSuffix = String.format("@%x", new Object[] { Long.valueOf(l) });
      this.androidBuildFingerprint = Build.FINGERPRINT.substring(0, Math.min(Build.FINGERPRINT.length(), 128));
      return;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      throw new RuntimeException(nameNotFoundException);
    } 
  }
  
  @CalledByNative
  private static String[] getAll() {
    String str1;
    BuildInfo buildInfo = BuildInfo$Holder.access$100();
    String str2 = ContextUtils.sApplicationContext.getPackageName();
    String str3 = Build.BRAND;
    String str4 = Build.DEVICE;
    String str5 = Build.ID;
    String str6 = Build.MANUFACTURER;
    String str7 = Build.MODEL;
    int i = Build.VERSION.SDK_INT;
    String str8 = Build.TYPE;
    String str9 = Build.BOARD;
    int j = buildInfo.hostVersionCode;
    String str10 = buildInfo.hostPackageLabel;
    String str11 = buildInfo.packageName;
    int k = buildInfo.versionCode;
    String str12 = buildInfo.versionName;
    String str13 = buildInfo.androidBuildFingerprint;
    String str14 = buildInfo.gmsVersionCode;
    String str15 = buildInfo.installerPackageName;
    String str16 = buildInfo.abiString;
    String str17 = BuildConfig.FIREBASE_APP_ID;
    String str18 = buildInfo.customThemes;
    String str19 = buildInfo.resourcesVersion;
    String str20 = buildInfo.extractedFileSuffix;
    if (isAtLeastP()) {
      str1 = "1";
    } else {
      str1 = "0";
    } 
    return new String[] { 
        str3, str4, str5, str6, str7, String.valueOf(i), str8, str9, str2, String.valueOf(j), 
        str10, str11, String.valueOf(k), str12, str13, str14, str15, str16, str17, str18, 
        str19, str20, str1 };
  }
  
  public static BuildInfo getInstance() {
    return BuildInfo$Holder.access$100();
  }
  
  public static boolean isAtLeastP() {
    return (Build.VERSION.SDK_INT >= 28);
  }
  
  public static boolean isDebugAndroid() {
    return ("eng".equals(Build.TYPE) || "userdebug".equals(Build.TYPE));
  }
  
  private static String nullToEmpty(CharSequence paramCharSequence) {
    return (paramCharSequence == null) ? "" : paramCharSequence.toString();
  }
  
  public static void setBrowserPackageInfo(PackageInfo paramPackageInfo) {
    assert false;
    throw new AssertionError();
  }
  
  public static boolean targetsAtLeastP() {
    return ((ContextUtils.sApplicationContext.getApplicationInfo()).targetSdkVersion >= 28);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\BuildInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */