package com.amap.api.interfaces;

import android.os.RemoteException;
import com.amap.api.maps2d.model.BitmapDescriptor;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;

public interface IGroundOverlay {
  float getBearing() throws RemoteException;
  
  LatLngBounds getBounds() throws RemoteException;
  
  float getHeight() throws RemoteException;
  
  LatLng getPosition() throws RemoteException;
  
  float getTransparency() throws RemoteException;
  
  float getWidth() throws RemoteException;
  
  void setBearing(float paramFloat) throws RemoteException;
  
  void setDimensions(float paramFloat) throws RemoteException;
  
  void setDimensions(float paramFloat1, float paramFloat2) throws RemoteException;
  
  void setImage(BitmapDescriptor paramBitmapDescriptor) throws RemoteException;
  
  void setPosition(LatLng paramLatLng) throws RemoteException;
  
  void setPositionFromBounds(LatLngBounds paramLatLngBounds) throws RemoteException;
  
  void setTransparency(float paramFloat) throws RemoteException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\interfaces\IGroundOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */