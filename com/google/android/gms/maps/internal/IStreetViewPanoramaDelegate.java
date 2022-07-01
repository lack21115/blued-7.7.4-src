package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.StreetViewSource;

public interface IStreetViewPanoramaDelegate extends IInterface {
  void animateTo(StreetViewPanoramaCamera paramStreetViewPanoramaCamera, long paramLong) throws RemoteException;
  
  void enablePanning(boolean paramBoolean) throws RemoteException;
  
  void enableStreetNames(boolean paramBoolean) throws RemoteException;
  
  void enableUserNavigation(boolean paramBoolean) throws RemoteException;
  
  void enableZoom(boolean paramBoolean) throws RemoteException;
  
  StreetViewPanoramaCamera getPanoramaCamera() throws RemoteException;
  
  StreetViewPanoramaLocation getStreetViewPanoramaLocation() throws RemoteException;
  
  boolean isPanningGesturesEnabled() throws RemoteException;
  
  boolean isStreetNamesEnabled() throws RemoteException;
  
  boolean isUserNavigationEnabled() throws RemoteException;
  
  boolean isZoomGesturesEnabled() throws RemoteException;
  
  IObjectWrapper orientationToPoint(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation) throws RemoteException;
  
  StreetViewPanoramaOrientation pointToOrientation(IObjectWrapper paramIObjectWrapper) throws RemoteException;
  
  void setOnStreetViewPanoramaCameraChangeListener(zzbh paramzzbh) throws RemoteException;
  
  void setOnStreetViewPanoramaChangeListener(zzbj paramzzbj) throws RemoteException;
  
  void setOnStreetViewPanoramaClickListener(zzbl paramzzbl) throws RemoteException;
  
  void setOnStreetViewPanoramaLongClickListener(zzbn paramzzbn) throws RemoteException;
  
  void setPosition(LatLng paramLatLng) throws RemoteException;
  
  void setPositionWithID(String paramString) throws RemoteException;
  
  void setPositionWithRadius(LatLng paramLatLng, int paramInt) throws RemoteException;
  
  void setPositionWithRadiusAndSource(LatLng paramLatLng, int paramInt, StreetViewSource paramStreetViewSource) throws RemoteException;
  
  void setPositionWithSource(LatLng paramLatLng, StreetViewSource paramStreetViewSource) throws RemoteException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\internal\IStreetViewPanoramaDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */