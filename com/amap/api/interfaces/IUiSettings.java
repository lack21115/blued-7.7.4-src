package com.amap.api.interfaces;

import android.os.RemoteException;

public interface IUiSettings {
  int getLogoPosition() throws RemoteException;
  
  int getZoomPosition() throws RemoteException;
  
  boolean isCompassEnabled() throws RemoteException;
  
  boolean isMyLocationButtonEnabled() throws RemoteException;
  
  boolean isScaleControlsEnabled() throws RemoteException;
  
  boolean isScrollGesturesEnabled() throws RemoteException;
  
  boolean isZoomControlsEnabled() throws RemoteException;
  
  boolean isZoomGesturesEnabled() throws RemoteException;
  
  boolean isZoomInByScreenCenter();
  
  void setAllGesturesEnabled(boolean paramBoolean) throws RemoteException;
  
  void setCompassEnabled(boolean paramBoolean) throws RemoteException;
  
  void setLogoCenter(int paramInt1, int paramInt2);
  
  void setLogoPosition(int paramInt) throws RemoteException;
  
  void setMyLocationButtonEnabled(boolean paramBoolean) throws RemoteException;
  
  void setScaleControlsEnabled(boolean paramBoolean) throws RemoteException;
  
  void setScrollGesturesEnabled(boolean paramBoolean) throws RemoteException;
  
  void setZoomControlsEnabled(boolean paramBoolean) throws RemoteException;
  
  void setZoomGesturesEnabled(boolean paramBoolean) throws RemoteException;
  
  void setZoomInByScreenCenter(boolean paramBoolean);
  
  void setZoomPosition(int paramInt) throws RemoteException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\interfaces\IUiSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */