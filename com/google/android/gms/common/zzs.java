package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.Log;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.zzbf;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzj;
import java.util.concurrent.atomic.AtomicBoolean;

public class zzs {
  @Deprecated
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12211000;
  
  static final AtomicBoolean zzfrv = new AtomicBoolean();
  
  private static final AtomicBoolean zzfrw = new AtomicBoolean();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  @Deprecated
  public static String getErrorString(int paramInt) {
    return ConnectionResult.getStatusString(paramInt);
  }
  
  public static Resources getRemoteResource(Context paramContext) {
    try {
      return paramContext.getPackageManager().getResourcesForApplication("com.google.android.gms");
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return null;
    } 
  }
  
  @Deprecated
  public static boolean isUserRecoverableError(int paramInt) {
    if (paramInt != 9)
      switch (paramInt) {
        default:
          return false;
        case 1:
        case 2:
        case 3:
          break;
      }  
    return true;
  }
  
  private static int zza(Context paramContext, boolean paramBoolean, int paramInt1, int paramInt2) {
    String str;
    boolean bool;
    if (paramInt2 == -1 || paramInt2 >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    zzbq.checkArgument(bool);
    PackageManager packageManager = paramContext.getPackageManager();
    PackageInfo packageInfo = null;
    if (paramBoolean)
      try {
        packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        str = "Google Play Store is missing.";
        Log.w("GooglePlayServicesUtil", str);
        return 9;
      }  
    try {
      PackageInfo packageInfo1 = packageManager.getPackageInfo("com.google.android.gms", 64);
      zzt.zzcj((Context)str);
      if (!zzt.zza(packageInfo1, true)) {
        str = "Google Play services signature invalid.";
        Log.w("GooglePlayServicesUtil", str);
        return 9;
      } 
      if (paramBoolean && (!zzt.zza(packageInfo, true) || !packageInfo.signatures[0].equals(packageInfo1.signatures[0]))) {
        str = "Google Play Store signature invalid.";
        Log.w("GooglePlayServicesUtil", str);
        return 9;
      } 
      paramInt1 /= 1000;
      int i = packageInfo1.versionCode / 1000;
      if (i < paramInt1 && (paramInt2 == -1 || i < paramInt2 / 1000)) {
        paramInt1 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        paramInt2 = packageInfo1.versionCode;
        StringBuilder stringBuilder = new StringBuilder(77);
        stringBuilder.append("Google Play services out of date.  Requires ");
        stringBuilder.append(paramInt1);
        stringBuilder.append(" but found ");
        stringBuilder.append(paramInt2);
        Log.w("GooglePlayServicesUtil", stringBuilder.toString());
        return 2;
      } 
      ApplicationInfo applicationInfo2 = packageInfo1.applicationInfo;
      ApplicationInfo applicationInfo1 = applicationInfo2;
      if (applicationInfo2 == null)
        try {
          applicationInfo1 = packageManager.getApplicationInfo("com.google.android.gms", 0);
        } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
          Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", (Throwable)nameNotFoundException);
          return 1;
        }  
      return !((ApplicationInfo)nameNotFoundException).enabled ? 3 : 0;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
      return 1;
    } 
  }
  
  @Deprecated
  public static int zzc(Context paramContext, int paramInt) {
    StringBuilder stringBuilder;
    try {
      paramContext.getResources().getString(R.string.common_google_play_services_unknown_issue);
    } catch (Throwable throwable) {
      Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
    } 
    if (!"com.google.android.gms".equals(paramContext.getPackageName()) && !zzfrw.get()) {
      int i = zzbf.zzcs(paramContext);
      if (i != 0) {
        if (i != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
          paramInt = GOOGLE_PLAY_SERVICES_VERSION_CODE;
          stringBuilder = new StringBuilder(320);
          stringBuilder.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
          stringBuilder.append(paramInt);
          stringBuilder.append(" but found ");
          stringBuilder.append(i);
          stringBuilder.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
          throw new IllegalStateException(stringBuilder.toString());
        } 
      } else {
        throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
      } 
    } 
    boolean bool = zzj.zzcv((Context)stringBuilder);
    boolean bool1 = true;
    if (!bool) {
      if (zzj.zzgku == null) {
        if (stringBuilder.getPackageManager().hasSystemFeature("android.hardware.type.iot") || stringBuilder.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
          bool = true;
        } else {
          bool = false;
        } 
        zzj.zzgku = Boolean.valueOf(bool);
      } 
      if (!zzj.zzgku.booleanValue()) {
        bool = bool1;
        return zza((Context)stringBuilder, bool, GOOGLE_PLAY_SERVICES_VERSION_CODE, paramInt);
      } 
    } 
    bool = false;
    return zza((Context)stringBuilder, bool, GOOGLE_PLAY_SERVICES_VERSION_CODE, paramInt);
  }
  
  @Deprecated
  public static void zzcf(Context paramContext) {
    if (zzfrv.getAndSet(true))
      return; 
    try {
      NotificationManager notificationManager = (NotificationManager)paramContext.getSystemService("notification");
      if (notificationManager != null)
        notificationManager.cancel(10436); 
      return;
    } catch (SecurityException securityException) {
      return;
    } 
  }
  
  @Deprecated
  public static boolean zzd(Context paramContext, int paramInt) {
    return (paramInt == 18) ? true : ((paramInt == 1) ? zzr(paramContext, "com.google.android.gms") : false);
  }
  
  @TargetApi(21)
  static boolean zzr(Context paramContext, String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'com.google.android.gms'
    //   3: invokevirtual equals : (Ljava/lang/Object;)Z
    //   6: istore_3
    //   7: invokestatic zzanx : ()Z
    //   10: ifeq -> 69
    //   13: aload_0
    //   14: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   17: invokevirtual getPackageInstaller : ()Landroid/content/pm/PackageInstaller;
    //   20: invokevirtual getAllSessions : ()Ljava/util/List;
    //   23: astore #4
    //   25: aload #4
    //   27: invokeinterface iterator : ()Ljava/util/Iterator;
    //   32: astore #4
    //   34: aload #4
    //   36: invokeinterface hasNext : ()Z
    //   41: ifeq -> 69
    //   44: aload_1
    //   45: aload #4
    //   47: invokeinterface next : ()Ljava/lang/Object;
    //   52: checkcast android/content/pm/PackageInstaller$SessionInfo
    //   55: invokevirtual getAppPackageName : ()Ljava/lang/String;
    //   58: invokevirtual equals : (Ljava/lang/Object;)Z
    //   61: ifeq -> 34
    //   64: iconst_1
    //   65: ireturn
    //   66: astore_0
    //   67: iconst_0
    //   68: ireturn
    //   69: aload_0
    //   70: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   73: astore #4
    //   75: aload #4
    //   77: aload_1
    //   78: sipush #8192
    //   81: invokevirtual getApplicationInfo : (Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   84: astore_1
    //   85: iload_3
    //   86: ifeq -> 94
    //   89: aload_1
    //   90: getfield enabled : Z
    //   93: ireturn
    //   94: aload_1
    //   95: getfield enabled : Z
    //   98: ifeq -> 171
    //   101: getstatic android/os/Build$VERSION.SDK_INT : I
    //   104: bipush #18
    //   106: if_icmplt -> 176
    //   109: iconst_1
    //   110: istore_2
    //   111: goto -> 114
    //   114: iload_2
    //   115: ifeq -> 163
    //   118: aload_0
    //   119: ldc_w 'user'
    //   122: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   125: checkcast android/os/UserManager
    //   128: aload_0
    //   129: invokevirtual getPackageName : ()Ljava/lang/String;
    //   132: invokevirtual getApplicationRestrictions : (Ljava/lang/String;)Landroid/os/Bundle;
    //   135: astore_0
    //   136: aload_0
    //   137: ifnull -> 163
    //   140: ldc_w 'true'
    //   143: aload_0
    //   144: ldc_w 'restricted_profile'
    //   147: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   150: invokevirtual equals : (Ljava/lang/Object;)Z
    //   153: istore_3
    //   154: iload_3
    //   155: ifeq -> 163
    //   158: iconst_1
    //   159: istore_2
    //   160: goto -> 165
    //   163: iconst_0
    //   164: istore_2
    //   165: iload_2
    //   166: ifne -> 171
    //   169: iconst_1
    //   170: ireturn
    //   171: iconst_0
    //   172: ireturn
    //   173: astore_0
    //   174: iconst_0
    //   175: ireturn
    //   176: iconst_0
    //   177: istore_2
    //   178: goto -> 114
    // Exception table:
    //   from	to	target	type
    //   13	25	66	java/lang/Exception
    //   75	85	173	android/content/pm/PackageManager$NameNotFoundException
    //   89	94	173	android/content/pm/PackageManager$NameNotFoundException
    //   94	109	173	android/content/pm/PackageManager$NameNotFoundException
    //   118	136	173	android/content/pm/PackageManager$NameNotFoundException
    //   140	154	173	android/content/pm/PackageManager$NameNotFoundException
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */