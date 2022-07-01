package com.amap.api.maps2d;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.interfaces.IProjection;
import com.amap.api.mapcore2d.cm;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.RuntimeRemoteException;
import com.amap.api.maps2d.model.VisibleRegion;

public class Projection {
  private final IProjection a;
  
  public Projection(IProjection paramIProjection) {
    this.a = paramIProjection;
  }
  
  public LatLng fromScreenLocation(Point paramPoint) {
    try {
      return this.a.fromScreenLocation(paramPoint);
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Projection", "fromScreenLocation");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public VisibleRegion getVisibleRegion() {
    try {
      return this.a.getVisibleRegion();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Projection", "getVisibleRegion");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public PointF toMapLocation(LatLng paramLatLng) {
    try {
      return this.a.toMapLocation(paramLatLng);
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Projection", "toMapLocation");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public Point toScreenLocation(LatLng paramLatLng) {
    try {
      return this.a.toScreenLocation(paramLatLng);
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Projection", "toScreenLocation");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\Projection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */