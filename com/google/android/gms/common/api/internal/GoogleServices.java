package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.zzs;

@Deprecated
public final class GoogleServices {
  private static final Object zza = new Object();
  
  private static GoogleServices zzb;
  
  private final String zzc;
  
  private final Status zzd;
  
  private final boolean zze;
  
  private final boolean zzf;
  
  GoogleServices(Context paramContext) {
    Resources resources = paramContext.getResources();
    int i = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
    boolean bool2 = true;
    boolean bool1 = true;
    if (i != 0) {
      if (resources.getInteger(i) == 0)
        bool1 = false; 
      this.zzf = bool1 ^ true;
    } else {
      this.zzf = false;
      bool1 = bool2;
    } 
    this.zze = bool1;
    String str2 = zzs.zza(paramContext);
    String str1 = str2;
    if (str2 == null)
      str1 = (new StringResourceValueReader(paramContext)).getString("google_app_id"); 
    if (TextUtils.isEmpty(str1)) {
      this.zzd = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
      this.zzc = null;
      return;
    } 
    this.zzc = str1;
    this.zzd = Status.RESULT_SUCCESS;
  }
  
  GoogleServices(String paramString, boolean paramBoolean) {
    this.zzc = paramString;
    this.zzd = Status.RESULT_SUCCESS;
    this.zze = paramBoolean;
    this.zzf = paramBoolean ^ true;
  }
  
  private static GoogleServices checkInitialized(String paramString) {
    synchronized (zza) {
      GoogleServices googleServices;
      if (zzb != null) {
        googleServices = zzb;
        return googleServices;
      } 
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(googleServices).length() + 34);
      stringBuilder.append("Initialize must be called before ");
      stringBuilder.append((String)googleServices);
      stringBuilder.append(".");
      throw new IllegalStateException(stringBuilder.toString());
    } 
  }
  
  static void clearInstanceForTest() {
    synchronized (zza) {
      zzb = null;
      return;
    } 
  }
  
  public static String getGoogleAppId() {
    return (checkInitialized("getGoogleAppId")).zzc;
  }
  
  public static Status initialize(Context paramContext) {
    Preconditions.checkNotNull(paramContext, "Context must not be null.");
    synchronized (zza) {
      if (zzb == null)
        zzb = new GoogleServices(paramContext); 
      return zzb.zzd;
    } 
  }
  
  public static Status initialize(Context paramContext, String paramString, boolean paramBoolean) {
    Preconditions.checkNotNull(paramContext, "Context must not be null.");
    Preconditions.checkNotEmpty(paramString, "App ID must be nonempty.");
    synchronized (zza) {
      Status status;
      if (zzb != null) {
        status = zzb.checkGoogleAppId(paramString);
        return status;
      } 
      GoogleServices googleServices = new GoogleServices((String)status, paramBoolean);
      zzb = googleServices;
      return googleServices.zzd;
    } 
  }
  
  public static boolean isMeasurementEnabled() {
    GoogleServices googleServices = checkInitialized("isMeasurementEnabled");
    return (googleServices.zzd.isSuccess() && googleServices.zze);
  }
  
  public static boolean isMeasurementExplicitlyDisabled() {
    return (checkInitialized("isMeasurementExplicitlyDisabled")).zzf;
  }
  
  final Status checkGoogleAppId(String paramString) {
    String str = this.zzc;
    if (str != null && !str.equals(paramString)) {
      paramString = this.zzc;
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString).length() + 97);
      stringBuilder.append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '");
      stringBuilder.append(paramString);
      stringBuilder.append("'.");
      return new Status(10, stringBuilder.toString());
    } 
    return Status.RESULT_SUCCESS;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\GoogleServices.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */