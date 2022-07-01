package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;

public interface zzt extends IInterface {
  float getAlpha() throws RemoteException;
  
  String getId() throws RemoteException;
  
  LatLng getPosition() throws RemoteException;
  
  float getRotation() throws RemoteException;
  
  String getSnippet() throws RemoteException;
  
  String getTitle() throws RemoteException;
  
  float getZIndex() throws RemoteException;
  
  void hideInfoWindow() throws RemoteException;
  
  boolean isDraggable() throws RemoteException;
  
  boolean isFlat() throws RemoteException;
  
  boolean isInfoWindowShown() throws RemoteException;
  
  boolean isVisible() throws RemoteException;
  
  void remove() throws RemoteException;
  
  void setAlpha(float paramFloat) throws RemoteException;
  
  void setAnchor(float paramFloat1, float paramFloat2) throws RemoteException;
  
  void setDraggable(boolean paramBoolean) throws RemoteException;
  
  void setFlat(boolean paramBoolean) throws RemoteException;
  
  void setInfoWindowAnchor(float paramFloat1, float paramFloat2) throws RemoteException;
  
  void setPosition(LatLng paramLatLng) throws RemoteException;
  
  void setRotation(float paramFloat) throws RemoteException;
  
  void setSnippet(String paramString) throws RemoteException;
  
  void setTitle(String paramString) throws RemoteException;
  
  void setVisible(boolean paramBoolean) throws RemoteException;
  
  void setZIndex(float paramFloat) throws RemoteException;
  
  void showInfoWindow() throws RemoteException;
  
  void zze(IObjectWrapper paramIObjectWrapper) throws RemoteException;
  
  void zzg(IObjectWrapper paramIObjectWrapper) throws RemoteException;
  
  int zzj() throws RemoteException;
  
  boolean zzj(zzt paramzzt) throws RemoteException;
  
  IObjectWrapper zzk() throws RemoteException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\maps\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */