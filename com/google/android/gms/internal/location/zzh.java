package com.google.android.gms.internal.location;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.location.zzp;

public class zzh extends GmsClient<zzal> {
  protected final zzbi<zzal> zzd = new zzk(this);
  
  private final String zze;
  
  public zzh(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, ClientSettings paramClientSettings) {
    super(paramContext, paramLooper, 23, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zze = paramString;
  }
  
  public Feature[] getApiFeatures() {
    return zzp.zzc;
  }
  
  public Bundle getGetServiceRequestExtraArgs() {
    Bundle bundle = new Bundle();
    bundle.putString("client_name", this.zze);
    return bundle;
  }
  
  public int getMinApkVersion() {
    return 11717000;
  }
  
  public String getServiceDescriptor() {
    return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
  }
  
  public String getStartServiceAction() {
    return "com.google.android.location.internal.GoogleLocationManagerService.START";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */