package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

public interface zze extends IInterface {
  IMapViewDelegate zza(IObjectWrapper paramIObjectWrapper, GoogleMapOptions paramGoogleMapOptions) throws RemoteException;
  
  IStreetViewPanoramaViewDelegate zza(IObjectWrapper paramIObjectWrapper, StreetViewPanoramaOptions paramStreetViewPanoramaOptions) throws RemoteException;
  
  void zza(IObjectWrapper paramIObjectWrapper, int paramInt) throws RemoteException;
  
  IMapFragmentDelegate zzc(IObjectWrapper paramIObjectWrapper) throws RemoteException;
  
  IStreetViewPanoramaFragmentDelegate zzd(IObjectWrapper paramIObjectWrapper) throws RemoteException;
  
  ICameraUpdateFactoryDelegate zze() throws RemoteException;
  
  com.google.android.gms.internal.maps.zze zzf() throws RemoteException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\internal\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */