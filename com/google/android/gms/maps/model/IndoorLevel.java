package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.maps.zzq;

public final class IndoorLevel {
  private final zzq zzdg;
  
  public IndoorLevel(zzq paramzzq) {
    this.zzdg = (zzq)Preconditions.checkNotNull(paramzzq);
  }
  
  public final void activate() {
    try {
      this.zzdg.activate();
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final boolean equals(Object paramObject) {
    if (!(paramObject instanceof IndoorLevel))
      return false; 
    try {
      return this.zzdg.zzb(((IndoorLevel)paramObject).zzdg);
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final String getName() {
    try {
      return this.zzdg.getName();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final String getShortName() {
    try {
      return this.zzdg.getShortName();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final int hashCode() {
    try {
      return this.zzdg.zzj();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\model\IndoorLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */