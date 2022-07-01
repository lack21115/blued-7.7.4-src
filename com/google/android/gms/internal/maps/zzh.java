package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.List;

public interface zzh extends IInterface {
  LatLng getCenter() throws RemoteException;
  
  int getFillColor() throws RemoteException;
  
  String getId() throws RemoteException;
  
  double getRadius() throws RemoteException;
  
  int getStrokeColor() throws RemoteException;
  
  List<PatternItem> getStrokePattern() throws RemoteException;
  
  float getStrokeWidth() throws RemoteException;
  
  float getZIndex() throws RemoteException;
  
  boolean isClickable() throws RemoteException;
  
  boolean isVisible() throws RemoteException;
  
  void remove() throws RemoteException;
  
  void setCenter(LatLng paramLatLng) throws RemoteException;
  
  void setClickable(boolean paramBoolean) throws RemoteException;
  
  void setFillColor(int paramInt) throws RemoteException;
  
  void setRadius(double paramDouble) throws RemoteException;
  
  void setStrokeColor(int paramInt) throws RemoteException;
  
  void setStrokePattern(List<PatternItem> paramList) throws RemoteException;
  
  void setStrokeWidth(float paramFloat) throws RemoteException;
  
  void setVisible(boolean paramBoolean) throws RemoteException;
  
  void setZIndex(float paramFloat) throws RemoteException;
  
  boolean zzb(zzh paramzzh) throws RemoteException;
  
  void zze(IObjectWrapper paramIObjectWrapper) throws RemoteException;
  
  int zzj() throws RemoteException;
  
  IObjectWrapper zzk() throws RemoteException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\maps\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */