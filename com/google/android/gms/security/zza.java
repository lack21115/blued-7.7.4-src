package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

final class zza extends AsyncTask<Void, Void, Integer> {
  zza(Context paramContext, ProviderInstaller.ProviderInstallListener paramProviderInstallListener) {}
  
  private final Integer zza(Void... paramVarArgs) {
    try {
      ProviderInstaller.installIfNeeded(this.zza);
      return Integer.valueOf(0);
    } catch (GooglePlayServicesRepairableException googlePlayServicesRepairableException) {
      return Integer.valueOf(googlePlayServicesRepairableException.getConnectionStatusCode());
    } catch (GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException) {
      return Integer.valueOf(googlePlayServicesNotAvailableException.errorCode);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\security\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */