package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.List;

public interface zzz extends IInterface {
  int getColor() throws RemoteException;
  
  Cap getEndCap() throws RemoteException;
  
  String getId() throws RemoteException;
  
  int getJointType() throws RemoteException;
  
  List<PatternItem> getPattern() throws RemoteException;
  
  List<LatLng> getPoints() throws RemoteException;
  
  Cap getStartCap() throws RemoteException;
  
  float getWidth() throws RemoteException;
  
  float getZIndex() throws RemoteException;
  
  boolean isClickable() throws RemoteException;
  
  boolean isGeodesic() throws RemoteException;
  
  boolean isVisible() throws RemoteException;
  
  void remove() throws RemoteException;
  
  void setClickable(boolean paramBoolean) throws RemoteException;
  
  void setColor(int paramInt) throws RemoteException;
  
  void setEndCap(Cap paramCap) throws RemoteException;
  
  void setGeodesic(boolean paramBoolean) throws RemoteException;
  
  void setJointType(int paramInt) throws RemoteException;
  
  void setPattern(List<PatternItem> paramList) throws RemoteException;
  
  void setPoints(List<LatLng> paramList) throws RemoteException;
  
  void setStartCap(Cap paramCap) throws RemoteException;
  
  void setVisible(boolean paramBoolean) throws RemoteException;
  
  void setWidth(float paramFloat) throws RemoteException;
  
  void setZIndex(float paramFloat) throws RemoteException;
  
  boolean zzb(zzz paramzzz) throws RemoteException;
  
  void zze(IObjectWrapper paramIObjectWrapper) throws RemoteException;
  
  int zzj() throws RemoteException;
  
  IObjectWrapper zzk() throws RemoteException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\maps\zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */