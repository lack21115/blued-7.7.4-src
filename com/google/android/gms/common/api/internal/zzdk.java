package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class zzdk {
  public static final Status zzgbq = new Status(8, "The connection to Google Play services was lost");
  
  static final BasePendingResult[] zzgbr = new BasePendingResult[0];
  
  private final Map zzfyj;
  
  final Set zzgbs = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap<Object, Boolean>()));
  
  private final zzdn zzgbt = new zzdl(this);
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public zzdk(Map paramMap) {
    this.zzfyj = paramMap;
  }
  
  public final void release() {
    for (BasePendingResult basePendingResult : (BasePendingResult[])this.zzgbs.toArray((Object[])zzgbr)) {
      basePendingResult.zza((zzdn)null);
      if (basePendingResult.zzaid() == null) {
        if (basePendingResult.zzaip())
          this.zzgbs.remove(basePendingResult); 
      } else {
        basePendingResult.setResultCallback(null);
        IBinder iBinder = ((Api.zze)this.zzfyj.get(((zzm)basePendingResult).zzfus)).zzaho();
        if (basePendingResult.isReady()) {
          basePendingResult.zza(new zzdm(basePendingResult, iBinder));
        } else if (iBinder != null && iBinder.isBinderAlive()) {
          zzdm zzdm = new zzdm(basePendingResult, iBinder);
          basePendingResult.zza(zzdm);
          try {
            iBinder.linkToDeath(zzdm, 0);
          } catch (RemoteException remoteException) {
            basePendingResult.cancel();
            basePendingResult.zzaid().intValue();
            throw new NullPointerException();
          } 
        } else {
          basePendingResult.zza((zzdn)null);
          basePendingResult.cancel();
          basePendingResult.zzaid().intValue();
          throw new NullPointerException();
        } 
        this.zzgbs.remove(basePendingResult);
      } 
    } 
  }
  
  final void zzb(BasePendingResult paramBasePendingResult) {
    this.zzgbs.add(paramBasePendingResult);
    paramBasePendingResult.zza(this.zzgbt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */