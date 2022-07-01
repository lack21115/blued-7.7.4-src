package com.amap.api.interfaces;

import android.os.RemoteException;
import com.amap.api.maps2d.model.LatLng;
import java.util.List;

public interface IPolyline extends IOverlay {
  int getColor() throws RemoteException;
  
  List<LatLng> getPoints() throws RemoteException;
  
  float getWidth() throws RemoteException;
  
  boolean isDottedLine();
  
  boolean isGeodesic();
  
  void setColor(int paramInt) throws RemoteException;
  
  void setDottedLine(boolean paramBoolean);
  
  void setGeodesic(boolean paramBoolean) throws RemoteException;
  
  void setPoints(List<LatLng> paramList) throws RemoteException;
  
  void setWidth(float paramFloat) throws RemoteException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\interfaces\IPolyline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */