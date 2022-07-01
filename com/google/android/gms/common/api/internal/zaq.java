package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;

public final class zaq implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
  public final Api<?> zaa;
  
  private final boolean zab;
  
  private zap zac;
  
  public zaq(Api<?> paramApi, boolean paramBoolean) {
    this.zaa = paramApi;
    this.zab = paramBoolean;
  }
  
  private final zap zaa() {
    Preconditions.checkNotNull(this.zac, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    return this.zac;
  }
  
  public final void onConnected(Bundle paramBundle) {
    zaa().onConnected(paramBundle);
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult) {
    zaa().zaa(paramConnectionResult, this.zaa, this.zab);
  }
  
  public final void onConnectionSuspended(int paramInt) {
    zaa().onConnectionSuspended(paramInt);
  }
  
  public final void zaa(zap paramzap) {
    this.zac = paramzap;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zaq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */