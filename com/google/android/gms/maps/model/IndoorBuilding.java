package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.maps.zzn;
import com.google.android.gms.internal.maps.zzq;
import com.google.android.gms.internal.maps.zzr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class IndoorBuilding {
  private final zzn zzdd;
  
  private final zza zzde;
  
  public IndoorBuilding(zzn paramzzn) {
    this(paramzzn, zza.zzdf);
  }
  
  private IndoorBuilding(zzn paramzzn, zza paramzza) {
    this.zzdd = (zzn)Preconditions.checkNotNull(paramzzn, "delegate");
    this.zzde = (zza)Preconditions.checkNotNull(paramzza, "shim");
  }
  
  public final boolean equals(Object paramObject) {
    if (!(paramObject instanceof IndoorBuilding))
      return false; 
    try {
      return this.zzdd.zzb(((IndoorBuilding)paramObject).zzdd);
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final int getActiveLevelIndex() {
    try {
      return this.zzdd.getActiveLevelIndex();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final int getDefaultLevelIndex() {
    try {
      return this.zzdd.getDefaultLevelIndex();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final List<IndoorLevel> getLevels() {
    try {
      List list = this.zzdd.getLevels();
      ArrayList<IndoorLevel> arrayList = new ArrayList(list.size());
      Iterator<IBinder> iterator = list.iterator();
      while (iterator.hasNext())
        arrayList.add(zza.zza(zza.zza(iterator.next()))); 
      return arrayList;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final int hashCode() {
    try {
      return this.zzdd.zzj();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final boolean isUnderground() {
    try {
      return this.zzdd.isUnderground();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  static final class zza {
    public static final zza zzdf = new zza();
    
    public static zzq zza(IBinder param1IBinder) {
      return zzr.zzf(param1IBinder);
    }
    
    public static IndoorLevel zza(zzq param1zzq) {
      return new IndoorLevel(param1zzq);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\model\IndoorBuilding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */