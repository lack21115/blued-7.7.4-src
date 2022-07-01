package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public interface zzk extends IInterface {
  float getBearing() throws RemoteException;
  
  LatLngBounds getBounds() throws RemoteException;
  
  float getHeight() throws RemoteException;
  
  String getId() throws RemoteException;
  
  LatLng getPosition() throws RemoteException;
  
  float getTransparency() throws RemoteException;
  
  float getWidth() throws RemoteException;
  
  float getZIndex() throws RemoteException;
  
  boolean isClickable() throws RemoteException;
  
  boolean isVisible() throws RemoteException;
  
  void remove() throws RemoteException;
  
  void setBearing(float paramFloat) throws RemoteException;
  
  void setClickable(boolean paramBoolean) throws RemoteException;
  
  void setDimensions(float paramFloat) throws RemoteException;
  
  void setPosition(LatLng paramLatLng) throws RemoteException;
  
  void setPositionFromBounds(LatLngBounds paramLatLngBounds) throws RemoteException;
  
  void setTransparency(float paramFloat) throws RemoteException;
  
  void setVisible(boolean paramBoolean) throws RemoteException;
  
  void setZIndex(float paramFloat) throws RemoteException;
  
  void zza(float paramFloat1, float paramFloat2) throws RemoteException;
  
  boolean zzb(zzk paramzzk) throws RemoteException;
  
  void zze(IObjectWrapper paramIObjectWrapper) throws RemoteException;
  
  void zzf(IObjectWrapper paramIObjectWrapper) throws RemoteException;
  
  int zzj() throws RemoteException;
  
  IObjectWrapper zzk() throws RemoteException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\maps\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */