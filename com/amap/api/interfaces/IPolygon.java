package com.amap.api.interfaces;

import android.os.RemoteException;
import com.amap.api.maps2d.model.LatLng;
import java.util.List;

public interface IPolygon extends IOverlay {
  boolean contains(LatLng paramLatLng) throws RemoteException;
  
  int getFillColor() throws RemoteException;
  
  List<LatLng> getPoints() throws RemoteException;
  
  int getStrokeColor() throws RemoteException;
  
  float getStrokeWidth() throws RemoteException;
  
  void setFillColor(int paramInt) throws RemoteException;
  
  void setPoints(List<LatLng> paramList) throws RemoteException;
  
  void setStrokeColor(int paramInt) throws RemoteException;
  
  void setStrokeWidth(float paramFloat) throws RemoteException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\interfaces\IPolygon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */