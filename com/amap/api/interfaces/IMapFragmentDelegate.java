package com.amap.api.interfaces;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.maps2d.AMapOptions;

public interface IMapFragmentDelegate {
  IAMap getMap() throws RemoteException;
  
  void onCreate(Bundle paramBundle) throws RemoteException;
  
  View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) throws RemoteException;
  
  void onDestroy() throws RemoteException;
  
  void onDestroyView() throws RemoteException;
  
  void onInflate(Activity paramActivity, AMapOptions paramAMapOptions, Bundle paramBundle) throws RemoteException;
  
  void onLowMemory() throws RemoteException;
  
  void onPause() throws RemoteException;
  
  void onResume() throws RemoteException;
  
  void onSaveInstanceState(Bundle paramBundle) throws RemoteException;
  
  void setContext(Context paramContext);
  
  void setOptions(AMapOptions paramAMapOptions);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\interfaces\IMapFragmentDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */