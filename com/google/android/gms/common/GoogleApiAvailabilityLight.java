package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;

public class GoogleApiAvailabilityLight {
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  
  static final String TRACKING_SOURCE_DIALOG = "d";
  
  static final String TRACKING_SOURCE_NOTIFICATION = "n";
  
  private static final GoogleApiAvailabilityLight zza = new GoogleApiAvailabilityLight();
  
  public static GoogleApiAvailabilityLight getInstance() {
    return zza;
  }
  
  private static String zza(Context paramContext, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("gcore_");
    stringBuilder.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
    stringBuilder.append("-");
    if (!TextUtils.isEmpty(paramString))
      stringBuilder.append(paramString); 
    stringBuilder.append("-");
    if (paramContext != null)
      stringBuilder.append(paramContext.getPackageName()); 
    stringBuilder.append("-");
    if (paramContext != null)
      try {
        stringBuilder.append((Wrappers.packageManager(paramContext).getPackageInfo(paramContext.getPackageName(), 0)).versionCode);
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {} 
    return stringBuilder.toString();
  }
  
  public void cancelAvailabilityErrorNotifications(Context paramContext) {
    GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(paramContext);
  }
  
  public int getApkVersion(Context paramContext) {
    return GooglePlayServicesUtilLight.getApkVersion(paramContext);
  }
  
  public int getClientVersion(Context paramContext) {
    return GooglePlayServicesUtilLight.getClientVersion(paramContext);
  }
  
  @Deprecated
  public Intent getErrorResolutionIntent(int paramInt) {
    return getErrorResolutionIntent(null, paramInt, null);
  }
  
  public Intent getErrorResolutionIntent(Context paramContext, int paramInt, String paramString) {
    return (paramInt != 1 && paramInt != 2) ? ((paramInt != 3) ? null : zzi.zza("com.google.android.gms")) : ((paramContext != null && DeviceProperties.isWearableWithoutPlayStore(paramContext)) ? zzi.zza() : zzi.zza("com.google.android.gms", zza(paramContext, paramString)));
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2) {
    return getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2, null);
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2, String paramString) {
    Intent intent = getErrorResolutionIntent(paramContext, paramInt1, paramString);
    return (intent == null) ? null : PendingIntent.getActivity(paramContext, paramInt2, intent, 134217728);
  }
  
  public String getErrorString(int paramInt) {
    return GooglePlayServicesUtilLight.getErrorString(paramInt);
  }
  
  public int isGooglePlayServicesAvailable(Context paramContext) {
    return isGooglePlayServicesAvailable(paramContext, GOOGLE_PLAY_SERVICES_VERSION_CODE);
  }
  
  public int isGooglePlayServicesAvailable(Context paramContext, int paramInt) {
    int i = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(paramContext, paramInt);
    paramInt = i;
    if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(paramContext, i))
      paramInt = 18; 
    return paramInt;
  }
  
  public boolean isPlayServicesPossiblyUpdating(Context paramContext, int paramInt) {
    return GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(paramContext, paramInt);
  }
  
  public boolean isPlayStorePossiblyUpdating(Context paramContext, int paramInt) {
    return GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(paramContext, paramInt);
  }
  
  public boolean isUninstalledAppPossiblyUpdating(Context paramContext, String paramString) {
    return GooglePlayServicesUtilLight.zza(paramContext, paramString);
  }
  
  public boolean isUserResolvableError(int paramInt) {
    return GooglePlayServicesUtilLight.isUserRecoverableError(paramInt);
  }
  
  public void verifyGooglePlayServicesIsAvailable(Context paramContext, int paramInt) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
    GooglePlayServicesUtilLight.ensurePlayServicesAvailable(paramContext, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\GoogleApiAvailabilityLight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */