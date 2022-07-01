package com.amap.api.interfaces;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.VisibleRegion;

public interface IProjection {
  LatLng fromScreenLocation(Point paramPoint) throws RemoteException;
  
  VisibleRegion getVisibleRegion() throws RemoteException;
  
  PointF toMapLocation(LatLng paramLatLng) throws RemoteException;
  
  Point toScreenLocation(LatLng paramLatLng) throws RemoteException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\interfaces\IProjection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */