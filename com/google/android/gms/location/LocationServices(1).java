package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.location.zzae;
import com.google.android.gms.internal.location.zzay;
import com.google.android.gms.internal.location.zzbh;
import com.google.android.gms.internal.location.zzn;

public class LocationServices {
  public static final Api<Api.ApiOptions.NoOptions> API;
  
  @Deprecated
  public static final FusedLocationProviderApi FusedLocationApi;
  
  @Deprecated
  public static final GeofencingApi GeofencingApi;
  
  @Deprecated
  public static final SettingsApi SettingsApi;
  
  private static final Api.ClientKey<zzay> zza = new Api.ClientKey();
  
  private static final Api.AbstractClientBuilder<zzay, Api.ApiOptions.NoOptions> zzb = new zzax();
  
  static {
    API = new Api("LocationServices.API", zzb, zza);
    FusedLocationApi = (FusedLocationProviderApi)new zzn();
    GeofencingApi = (GeofencingApi)new zzae();
    SettingsApi = (SettingsApi)new zzbh();
  }
  
  public static FusedLocationProviderClient getFusedLocationProviderClient(Activity paramActivity) {
    return new FusedLocationProviderClient(paramActivity);
  }
  
  public static FusedLocationProviderClient getFusedLocationProviderClient(Context paramContext) {
    return new FusedLocationProviderClient(paramContext);
  }
  
  public static GeofencingClient getGeofencingClient(Activity paramActivity) {
    return new GeofencingClient(paramActivity);
  }
  
  public static GeofencingClient getGeofencingClient(Context paramContext) {
    return new GeofencingClient(paramContext);
  }
  
  public static SettingsClient getSettingsClient(Activity paramActivity) {
    return new SettingsClient(paramActivity);
  }
  
  public static SettingsClient getSettingsClient(Context paramContext) {
    return new SettingsClient(paramContext);
  }
  
  public static zzay zza(GoogleApiClient paramGoogleApiClient) {
    boolean bool1;
    boolean bool2 = true;
    if (paramGoogleApiClient != null) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    Preconditions.checkArgument(bool1, "GoogleApiClient parameter is required.");
    zzay zzay = (zzay)paramGoogleApiClient.getClient((Api.AnyClientKey)zza);
    if (zzay != null) {
      bool1 = bool2;
    } else {
      bool1 = false;
    } 
    Preconditions.checkState(bool1, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
    return zzay;
  }
  
  public static abstract class zza<R extends Result> extends BaseImplementation.ApiMethodImpl<R, zzay> {
    public zza(GoogleApiClient param1GoogleApiClient) {
      super(LocationServices.API, param1GoogleApiClient);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\LocationServices.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */