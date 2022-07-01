package com.amap.api.interfaces;

import android.os.RemoteException;
import com.amap.api.maps2d.model.BitmapDescriptor;
import com.amap.api.maps2d.model.LatLng;
import java.util.ArrayList;

public interface IMarker {
  void destroy();
  
  boolean equalsRemote(IMarker paramIMarker);
  
  ArrayList<BitmapDescriptor> getIcons() throws RemoteException;
  
  String getId();
  
  Object getObject();
  
  int getPeriod() throws RemoteException;
  
  LatLng getPosition();
  
  LatLng getRealPosition();
  
  String getSnippet();
  
  String getTitle();
  
  int getWidth();
  
  float getZIndex();
  
  int hashCodeRemote();
  
  void hideInfoWindow();
  
  boolean isDraggable();
  
  boolean isInfoWindowShown();
  
  boolean isViewMode() throws RemoteException;
  
  boolean isVisible();
  
  boolean remove() throws RemoteException;
  
  void setAnchor(float paramFloat1, float paramFloat2);
  
  void setDraggable(boolean paramBoolean);
  
  void setIcon(BitmapDescriptor paramBitmapDescriptor);
  
  void setIcons(ArrayList<BitmapDescriptor> paramArrayList) throws RemoteException;
  
  void setObject(Object paramObject);
  
  void setPeriod(int paramInt) throws RemoteException;
  
  void setPosition(LatLng paramLatLng);
  
  void setPositionByPixels(int paramInt1, int paramInt2) throws RemoteException;
  
  void setRotateAngle(float paramFloat) throws RemoteException;
  
  void setSnippet(String paramString);
  
  void setTitle(String paramString);
  
  void setVisible(boolean paramBoolean);
  
  void setZIndex(float paramFloat);
  
  void showInfoWindow();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\interfaces\IMarker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */