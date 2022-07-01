package com.google.android.gms.common;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.concurrent.atomic.AtomicBoolean;

public class GooglePlayServicesUtilLight {
  static final int GMS_AVAILABILITY_NOTIFICATION_ID = 10436;
  
  static final int GMS_GENERAL_ERROR_NOTIFICATION_ID = 39789;
  
  public static final String GOOGLE_PLAY_GAMES_PACKAGE = "com.google.android.play.games";
  
  @Deprecated
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  
  @Deprecated
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
  
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  
  static final AtomicBoolean sCanceledAvailabilityNotification = new AtomicBoolean();
  
  private static boolean zza = false;
  
  private static boolean zzb = false;
  
  private static boolean zzc = false;
  
  private static boolean zzd = false;
  
  private static final AtomicBoolean zze = new AtomicBoolean();
  
  @Deprecated
  public static void cancelAvailabilityErrorNotifications(Context paramContext) {
    if (sCanceledAvailabilityNotification.getAndSet(true))
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
  
  public static void enableUsingApkIndependentContext() {
    zze.set(true);
  }
  
  @Deprecated
  public static void ensurePlayServicesAvailable(Context paramContext, int paramInt) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
    paramInt = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(paramContext, paramInt);
    if (paramInt != 0) {
      Intent intent = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(paramContext, paramInt, "e");
      StringBuilder stringBuilder = new StringBuilder(57);
      stringBuilder.append("GooglePlayServices not available due to error ");
      stringBuilder.append(paramInt);
      Log.e("GooglePlayServicesUtil", stringBuilder.toString());
      if (intent == null)
        throw new GooglePlayServicesNotAvailableException(paramInt); 
      throw new GooglePlayServicesRepairableException(paramInt, "Google Play Services not available", intent);
    } 
  }
  
  @Deprecated
  public static int getApkVersion(Context paramContext) {
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo("com.google.android.gms", 0);
      return packageInfo.versionCode;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
      return 0;
    } 
  }
  
  @Deprecated
  public static int getClientVersion(Context paramContext) {
    Preconditions.checkState(true);
    return ClientLibraryUtils.getClientVersion(paramContext, paramContext.getPackageName());
  }
  
  @Deprecated
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2) {
    return GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
  }
  
  @Deprecated
  public static String getErrorString(int paramInt) {
    return ConnectionResult.zza(paramInt);
  }
  
  @Deprecated
  public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int paramInt) {
    return GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(null, paramInt, null);
  }
  
  public static Context getRemoteContext(Context paramContext) {
    try {
      return paramContext.createPackageContext("com.google.android.gms", 3);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return null;
    } 
  }
  
  public static Resources getRemoteResource(Context paramContext) {
    try {
      return paramContext.getPackageManager().getResourcesForApplication("com.google.android.gms");
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return null;
    } 
  }
  
  public static boolean honorsDebugCertificates(Context paramContext) {
    if (!zzd)
      try {
        PackageInfo packageInfo = Wrappers.packageManager(paramContext).getPackageInfo("com.google.android.gms", 64);
        GoogleSignatureVerifier.getInstance(paramContext);
        if (packageInfo != null && !GoogleSignatureVerifier.zza(packageInfo, false) && GoogleSignatureVerifier.zza(packageInfo, true)) {
          zzc = true;
        } else {
          zzc = false;
        } 
        zzd = true;
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", (Throwable)nameNotFoundException);
        zzd = true;
      } finally {} 
    return !zzc ? (!DeviceProperties.isUserBuild()) : true;
  }
  
  @Deprecated
  public static int isGooglePlayServicesAvailable(Context paramContext) {
    return isGooglePlayServicesAvailable(paramContext, GOOGLE_PLAY_SERVICES_VERSION_CODE);
  }
  
  @Deprecated
  public static int isGooglePlayServicesAvailable(Context paramContext, int paramInt) {
    StringBuilder stringBuilder;
    boolean bool;
    try {
      paramContext.getResources().getString(R.string.common_google_play_services_unknown_issue);
    } finally {
      Exception exception = null;
    } 
    if (!DeviceProperties.isWearableWithoutPlayStore((Context)stringBuilder) && !DeviceProperties.zza((Context)stringBuilder)) {
      bool = true;
    } else {
      bool = false;
    } 
    return zza((Context)stringBuilder, bool, paramInt);
  }
  
  @Deprecated
  public static boolean isGooglePlayServicesUid(Context paramContext, int paramInt) {
    return UidVerifier.isGooglePlayServicesUid(paramContext, paramInt);
  }
  
  @Deprecated
  public static boolean isPlayServicesPossiblyUpdating(Context paramContext, int paramInt) {
    return (paramInt == 18) ? true : ((paramInt == 1) ? zza(paramContext, "com.google.android.gms") : false);
  }
  
  @Deprecated
  public static boolean isPlayStorePossiblyUpdating(Context paramContext, int paramInt) {
    return (paramInt == 9) ? zza(paramContext, "com.android.vending") : false;
  }
  
  public static boolean isRestrictedUserProfile(Context paramContext) {
    if (PlatformVersion.isAtLeastJellyBeanMR2()) {
      Bundle bundle = ((UserManager)paramContext.getSystemService("user")).getApplicationRestrictions(paramContext.getPackageName());
      if (bundle != null && "true".equals(bundle.getString("restricted_profile")))
        return true; 
    } 
    return false;
  }
  
  @Deprecated
  public static boolean isSidewinderDevice(Context paramContext) {
    return DeviceProperties.isSidewinder(paramContext);
  }
  
  @Deprecated
  public static boolean isUserRecoverableError(int paramInt) {
    return !(paramInt != 1 && paramInt != 2 && paramInt != 3 && paramInt != 9);
  }
  
  @Deprecated
  public static boolean uidHasPackageName(Context paramContext, int paramInt, String paramString) {
    return UidVerifier.uidHasPackageName(paramContext, paramInt, paramString);
  }
  
  private static int zza(Context paramContext, boolean paramBoolean, int paramInt) {
    // Byte code:
    //   0: iload_2
    //   1: iflt -> 10
    //   4: iconst_1
    //   5: istore #4
    //   7: goto -> 13
    //   10: iconst_0
    //   11: istore #4
    //   13: iload #4
    //   15: invokestatic checkArgument : (Z)V
    //   18: aload_0
    //   19: invokevirtual getPackageName : ()Ljava/lang/String;
    //   22: astore #6
    //   24: aload_0
    //   25: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   28: astore #7
    //   30: aconst_null
    //   31: astore #5
    //   33: iload_1
    //   34: ifeq -> 72
    //   37: aload #7
    //   39: ldc 'com.android.vending'
    //   41: sipush #8256
    //   44: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   47: astore #5
    //   49: goto -> 72
    //   52: ldc 'GooglePlayServicesUtil'
    //   54: aload #6
    //   56: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   59: ldc_w ' requires the Google Play Store, but it is missing.'
    //   62: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   65: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   68: pop
    //   69: bipush #9
    //   71: ireturn
    //   72: aload #7
    //   74: ldc 'com.google.android.gms'
    //   76: bipush #64
    //   78: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   81: astore #8
    //   83: aload_0
    //   84: invokestatic getInstance : (Landroid/content/Context;)Lcom/google/android/gms/common/GoogleSignatureVerifier;
    //   87: pop
    //   88: aload #8
    //   90: iconst_1
    //   91: invokestatic zza : (Landroid/content/pm/PackageInfo;Z)Z
    //   94: ifne -> 117
    //   97: ldc 'GooglePlayServicesUtil'
    //   99: aload #6
    //   101: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   104: ldc_w ' requires Google Play services, but their signature is invalid.'
    //   107: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   110: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   113: pop
    //   114: bipush #9
    //   116: ireturn
    //   117: iload_1
    //   118: ifeq -> 176
    //   121: aload #5
    //   123: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   126: checkcast android/content/pm/PackageInfo
    //   129: iconst_1
    //   130: invokestatic zza : (Landroid/content/pm/PackageInfo;Z)Z
    //   133: ifeq -> 156
    //   136: aload #5
    //   138: getfield signatures : [Landroid/content/pm/Signature;
    //   141: iconst_0
    //   142: aaload
    //   143: aload #8
    //   145: getfield signatures : [Landroid/content/pm/Signature;
    //   148: iconst_0
    //   149: aaload
    //   150: invokevirtual equals : (Ljava/lang/Object;)Z
    //   153: ifne -> 176
    //   156: ldc 'GooglePlayServicesUtil'
    //   158: aload #6
    //   160: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   163: ldc_w ' requires Google Play Store, but its signature is invalid.'
    //   166: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   169: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   172: pop
    //   173: bipush #9
    //   175: ireturn
    //   176: aload #8
    //   178: getfield versionCode : I
    //   181: invokestatic zza : (I)I
    //   184: iload_2
    //   185: invokestatic zza : (I)I
    //   188: if_icmpge -> 271
    //   191: aload #8
    //   193: getfield versionCode : I
    //   196: istore_3
    //   197: new java/lang/StringBuilder
    //   200: dup
    //   201: aload #6
    //   203: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   206: invokevirtual length : ()I
    //   209: bipush #82
    //   211: iadd
    //   212: invokespecial <init> : (I)V
    //   215: astore_0
    //   216: aload_0
    //   217: ldc_w 'Google Play services out of date for '
    //   220: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_0
    //   225: aload #6
    //   227: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload_0
    //   232: ldc_w '.  Requires '
    //   235: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload_0
    //   240: iload_2
    //   241: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload_0
    //   246: ldc_w ' but found '
    //   249: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload_0
    //   254: iload_3
    //   255: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: ldc 'GooglePlayServicesUtil'
    //   261: aload_0
    //   262: invokevirtual toString : ()Ljava/lang/String;
    //   265: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   268: pop
    //   269: iconst_2
    //   270: ireturn
    //   271: aload #8
    //   273: getfield applicationInfo : Landroid/content/pm/ApplicationInfo;
    //   276: astore #5
    //   278: aload #5
    //   280: astore_0
    //   281: aload #5
    //   283: ifnonnull -> 319
    //   286: aload #7
    //   288: ldc 'com.google.android.gms'
    //   290: iconst_0
    //   291: invokevirtual getApplicationInfo : (Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   294: astore_0
    //   295: goto -> 319
    //   298: astore_0
    //   299: ldc 'GooglePlayServicesUtil'
    //   301: aload #6
    //   303: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   306: ldc_w ' requires Google Play services, but they're missing when getting application info.'
    //   309: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   312: aload_0
    //   313: invokestatic wtf : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   316: pop
    //   317: iconst_1
    //   318: ireturn
    //   319: aload_0
    //   320: getfield enabled : Z
    //   323: ifne -> 328
    //   326: iconst_3
    //   327: ireturn
    //   328: iconst_0
    //   329: ireturn
    //   330: ldc 'GooglePlayServicesUtil'
    //   332: aload #6
    //   334: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   337: ldc_w ' requires Google Play services, but they are missing.'
    //   340: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   343: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   346: pop
    //   347: iconst_1
    //   348: ireturn
    //   349: astore_0
    //   350: goto -> 52
    //   353: astore_0
    //   354: goto -> 330
    // Exception table:
    //   from	to	target	type
    //   37	49	349	android/content/pm/PackageManager$NameNotFoundException
    //   72	83	353	android/content/pm/PackageManager$NameNotFoundException
    //   286	295	298	android/content/pm/PackageManager$NameNotFoundException
  }
  
  static boolean zza(Context paramContext, String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'com.google.android.gms'
    //   3: invokevirtual equals : (Ljava/lang/Object;)Z
    //   6: istore_2
    //   7: invokestatic isAtLeastLollipop : ()Z
    //   10: ifeq -> 61
    //   13: aload_0
    //   14: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   17: invokevirtual getPackageInstaller : ()Landroid/content/pm/PackageInstaller;
    //   20: invokevirtual getAllSessions : ()Ljava/util/List;
    //   23: astore_3
    //   24: aload_3
    //   25: invokeinterface iterator : ()Ljava/util/Iterator;
    //   30: astore_3
    //   31: aload_3
    //   32: invokeinterface hasNext : ()Z
    //   37: ifeq -> 61
    //   40: aload_1
    //   41: aload_3
    //   42: invokeinterface next : ()Ljava/lang/Object;
    //   47: checkcast android/content/pm/PackageInstaller$SessionInfo
    //   50: invokevirtual getAppPackageName : ()Ljava/lang/String;
    //   53: invokevirtual equals : (Ljava/lang/Object;)Z
    //   56: ifeq -> 31
    //   59: iconst_1
    //   60: ireturn
    //   61: aload_0
    //   62: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   65: astore_3
    //   66: aload_3
    //   67: aload_1
    //   68: sipush #8192
    //   71: invokevirtual getApplicationInfo : (Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   74: astore_1
    //   75: iload_2
    //   76: ifeq -> 84
    //   79: aload_1
    //   80: getfield enabled : Z
    //   83: ireturn
    //   84: aload_1
    //   85: getfield enabled : Z
    //   88: ifeq -> 102
    //   91: aload_0
    //   92: invokestatic isRestrictedUserProfile : (Landroid/content/Context;)Z
    //   95: istore_2
    //   96: iload_2
    //   97: ifne -> 102
    //   100: iconst_1
    //   101: ireturn
    //   102: iconst_0
    //   103: ireturn
    //   104: astore_0
    //   105: iconst_0
    //   106: ireturn
    //   107: astore_0
    //   108: iconst_0
    //   109: ireturn
    // Exception table:
    //   from	to	target	type
    //   13	24	104	java/lang/Exception
    //   66	75	107	android/content/pm/PackageManager$NameNotFoundException
    //   79	84	107	android/content/pm/PackageManager$NameNotFoundException
    //   84	96	107	android/content/pm/PackageManager$NameNotFoundException
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\GooglePlayServicesUtilLight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */