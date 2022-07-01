package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zzf;
import java.util.Iterator;
import java.util.Set;

public abstract class zzab extends zzd implements Api.zze, zzaf {
  private final Account zzeho;
  
  private final Set zzenh;
  
  public zzab(Context paramContext, Looper paramLooper, int paramInt, zzr paramzzr, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    this(paramContext, paramLooper, zzag.zzcp(paramContext), GoogleApiAvailability.getInstance(), paramInt, paramzzr, (GoogleApiClient.ConnectionCallbacks)zzbq.checkNotNull(paramConnectionCallbacks), (GoogleApiClient.OnConnectionFailedListener)zzbq.checkNotNull(paramOnConnectionFailedListener));
  }
  
  private zzab(Context paramContext, Looper paramLooper, zzag paramzzag, GoogleApiAvailability paramGoogleApiAvailability, int paramInt, zzr paramzzr, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    super(paramContext, paramLooper, paramzzag, (zzf)paramGoogleApiAvailability, paramInt, zzac, zzad, paramzzr.zzfta);
    zzac zzac;
    zzad zzad;
    this.zzeho = paramzzr.zzeho;
    Set set = paramzzr.zzgfq;
    Iterator<Scope> iterator = set.iterator();
    while (iterator.hasNext()) {
      if (set.contains(iterator.next()))
        continue; 
      throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
    } 
    this.zzenh = set;
  }
  
  public final Account getAccount() {
    return this.zzeho;
  }
  
  public final int zzahq() {
    return -1;
  }
  
  public final zzc[] zzalu() {
    return new zzc[0];
  }
  
  protected final Set zzaly() {
    return this.zzenh;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\internal\zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */