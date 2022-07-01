package com.amap.api.interfaces;

import android.os.RemoteException;
import com.amap.api.maps2d.model.LatLng;

public interface ICircle extends IOverlay {
  boolean contains(LatLng paramLatLng) throws RemoteException;
  
  LatLng getCenter() throws RemoteException;
  
  int getFillColor() throws RemoteException;
  
  double getRadius() throws RemoteException;
  
  int getStrokeColor() throws RemoteException;
  
  float getStrokeWidth() throws RemoteException;
  
  void setCenter(LatLng paramLatLng) throws RemoteException;
  
  void setFillColor(int paramInt) throws RemoteException;
  
  void setRadius(double paramDouble) throws RemoteException;
  
  void setStrokeColor(int paramInt) throws RemoteException;
  
  void setStrokeWidth(float paramFloat) throws RemoteException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\interfaces\ICircle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */