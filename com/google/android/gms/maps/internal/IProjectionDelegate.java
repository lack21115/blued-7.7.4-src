package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

public interface IProjectionDelegate extends IInterface {
  LatLng fromScreenLocation(IObjectWrapper paramIObjectWrapper) throws RemoteException;
  
  VisibleRegion getVisibleRegion() throws RemoteException;
  
  IObjectWrapper toScreenLocation(LatLng paramLatLng) throws RemoteException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\internal\IProjectionDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */