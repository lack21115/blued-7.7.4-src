package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.LocationSettingsResult;

final class zzaz extends zzaq {
  private BaseImplementation.ResultHolder<LocationSettingsResult> zza;
  
  public zzaz(BaseImplementation.ResultHolder<LocationSettingsResult> paramResultHolder) {
    boolean bool;
    if (paramResultHolder != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "listener can't be null.");
    this.zza = paramResultHolder;
  }
  
  public final void zza(LocationSettingsResult paramLocationSettingsResult) throws RemoteException {
    this.zza.setResult(paramLocationSettingsResult);
    this.zza = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzaz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */