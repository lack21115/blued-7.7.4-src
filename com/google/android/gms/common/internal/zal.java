package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;

public final class zal {
  private final SparseIntArray zaa = new SparseIntArray();
  
  private GoogleApiAvailabilityLight zab;
  
  public zal() {
    this((GoogleApiAvailabilityLight)GoogleApiAvailability.getInstance());
  }
  
  public zal(GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight) {
    Preconditions.checkNotNull(paramGoogleApiAvailabilityLight);
    this.zab = paramGoogleApiAvailabilityLight;
  }
  
  public final int zaa(Context paramContext, Api.Client paramClient) {
    int i;
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramClient);
    if (!paramClient.requiresGooglePlayServices())
      return 0; 
    int m = paramClient.getMinApkVersion();
    int k = this.zaa.get(m, -1);
    if (k != -1)
      return k; 
    int j = 0;
    while (true) {
      i = k;
      if (j < this.zaa.size()) {
        i = this.zaa.keyAt(j);
        if (i > m && this.zaa.get(i) == 0) {
          i = 0;
          break;
        } 
        j++;
        continue;
      } 
      break;
    } 
    j = i;
    if (i == -1)
      j = this.zab.isGooglePlayServicesAvailable(paramContext, m); 
    this.zaa.put(m, j);
    return j;
  }
  
  public final void zaa() {
    this.zaa.clear();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\zal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */