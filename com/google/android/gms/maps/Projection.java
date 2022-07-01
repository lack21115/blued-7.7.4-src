package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.VisibleRegion;

public final class Projection {
  private final IProjectionDelegate zzbn;
  
  Projection(IProjectionDelegate paramIProjectionDelegate) {
    this.zzbn = paramIProjectionDelegate;
  }
  
  public final LatLng fromScreenLocation(Point paramPoint) {
    try {
      return this.zzbn.fromScreenLocation(ObjectWrapper.wrap(paramPoint));
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final VisibleRegion getVisibleRegion() {
    try {
      return this.zzbn.getVisibleRegion();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final Point toScreenLocation(LatLng paramLatLng) {
    try {
      return (Point)ObjectWrapper.unwrap(this.zzbn.toScreenLocation(paramLatLng));
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\Projection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */