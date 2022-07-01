package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;

public interface zzac extends IInterface {
  void clearTileCache() throws RemoteException;
  
  boolean getFadeIn() throws RemoteException;
  
  String getId() throws RemoteException;
  
  float getTransparency() throws RemoteException;
  
  float getZIndex() throws RemoteException;
  
  boolean isVisible() throws RemoteException;
  
  void remove() throws RemoteException;
  
  void setFadeIn(boolean paramBoolean) throws RemoteException;
  
  void setTransparency(float paramFloat) throws RemoteException;
  
  void setVisible(boolean paramBoolean) throws RemoteException;
  
  void setZIndex(float paramFloat) throws RemoteException;
  
  boolean zza(zzac paramzzac) throws RemoteException;
  
  int zzj() throws RemoteException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\maps\zzac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */