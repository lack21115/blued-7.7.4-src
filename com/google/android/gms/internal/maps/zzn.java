package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

public interface zzn extends IInterface {
  int getActiveLevelIndex() throws RemoteException;
  
  int getDefaultLevelIndex() throws RemoteException;
  
  List<IBinder> getLevels() throws RemoteException;
  
  boolean isUnderground() throws RemoteException;
  
  boolean zzb(zzn paramzzn) throws RemoteException;
  
  int zzj() throws RemoteException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\maps\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */