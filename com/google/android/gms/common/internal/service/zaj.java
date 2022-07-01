package com.google.android.gms.common.internal.service;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;

public final class zaj extends GmsClient<zak> {
  public zaj(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    super(paramContext, paramLooper, 39, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public final String getServiceDescriptor() {
    return "com.google.android.gms.common.internal.service.ICommonService";
  }
  
  public final String getStartServiceAction() {
    return "com.google.android.gms.common.service.START";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\service\zaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */