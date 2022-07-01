package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzi$zza implements GoogleApiClient.OnConnectionFailedListener {
  public final int zzfug;
  
  public final GoogleApiClient zzfuh;
  
  public final GoogleApiClient.OnConnectionFailedListener zzfui;
  
  public zzi$zza(zzi paramzzi, int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    this.zzfug = paramInt;
    this.zzfuh = paramGoogleApiClient;
    this.zzfui = paramOnConnectionFailedListener;
    paramGoogleApiClient.registerConnectionFailedListener(this);
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult) {
    String str = String.valueOf(paramConnectionResult);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 27);
    stringBuilder.append("beginFailureResolution for ");
    stringBuilder.append(str);
    this.zzfuj.zzb(paramConnectionResult, this.zzfug);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzi$zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */