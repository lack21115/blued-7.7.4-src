package com.google.android.gms.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzcfy;
import com.google.android.gms.internal.zzcgn;
import com.google.android.gms.internal.zzchh;
import com.google.android.gms.internal.zzchs;

public final class LocationServices {
  public static final Api API;
  
  @Deprecated
  public static final FusedLocationProviderApi FusedLocationApi;
  
  private static final Api.zzf zzegu = new Api.zzf();
  
  private static final Api.zza zzegv = new zzad();
  
  static {
    API = new Api("LocationServices.API", zzegv, zzegu);
    FusedLocationApi = (FusedLocationProviderApi)new zzcfy();
    new zzcgn();
    new zzchs();
    throw new VerifyError("bad dex opcode");
  }
  
  public static zzchh zzi(GoogleApiClient paramGoogleApiClient) {
    boolean bool2 = false;
    if (paramGoogleApiClient != null) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    zzbq.checkArgument(bool1, "GoogleApiClient parameter is required.");
    zzchh zzchh = (zzchh)paramGoogleApiClient.zza((Api.zzc)zzegu);
    boolean bool1 = bool2;
    if (zzchh != null)
      bool1 = true; 
    zzbq.zza(bool1, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
    return zzchh;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\location\LocationServices.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */