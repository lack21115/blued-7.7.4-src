package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface IMapViewDelegate extends IInterface {
  IGoogleMapDelegate getMap() throws RemoteException;
  
  void getMapAsync(zzap paramzzap) throws RemoteException;
  
  IObjectWrapper getView() throws RemoteException;
  
  void onCreate(Bundle paramBundle) throws RemoteException;
  
  void onDestroy() throws RemoteException;
  
  void onEnterAmbient(Bundle paramBundle) throws RemoteException;
  
  void onExitAmbient() throws RemoteException;
  
  void onLowMemory() throws RemoteException;
  
  void onPause() throws RemoteException;
  
  void onResume() throws RemoteException;
  
  void onSaveInstanceState(Bundle paramBundle) throws RemoteException;
  
  void onStart() throws RemoteException;
  
  void onStop() throws RemoteException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\internal\IMapViewDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */