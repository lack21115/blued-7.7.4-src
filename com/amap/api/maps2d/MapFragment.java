package com.amap.api.maps2d;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.interfaces.IAMap;
import com.amap.api.interfaces.IMapFragmentDelegate;
import com.amap.api.mapcore2d.ar;
import com.amap.api.mapcore2d.cm;
import com.amap.api.maps2d.model.RuntimeRemoteException;

public class MapFragment extends Fragment {
  private AMap a;
  
  private IMapFragmentDelegate b;
  
  public static MapFragment newInstance() {
    return newInstance(new AMapOptions());
  }
  
  public static MapFragment newInstance(AMapOptions paramAMapOptions) {
    MapFragment mapFragment = new MapFragment();
    Bundle bundle = new Bundle();
    try {
      Parcel parcel = Parcel.obtain();
      paramAMapOptions.writeToParcel(parcel, 0);
      bundle.putByteArray("MapOptions", parcel.marshall());
    } finally {
      paramAMapOptions = null;
    } 
    return mapFragment;
  }
  
  public AMap getMap() {
    IMapFragmentDelegate iMapFragmentDelegate = getMapFragmentDelegate();
    if (iMapFragmentDelegate == null)
      return null; 
    try {
      IAMap iAMap = iMapFragmentDelegate.getMap();
      if (iAMap == null)
        return null; 
      if (this.a == null)
        this.a = new AMap(iAMap); 
      return this.a;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "MapFragment", "getMap");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  protected IMapFragmentDelegate getMapFragmentDelegate() {
    if (this.b == null)
      this.b = (IMapFragmentDelegate)new ar(); 
    if (getActivity() != null)
      this.b.setContext((Context)getActivity()); 
    return this.b;
  }
  
  public void onAttach(Activity paramActivity) {
    super.onAttach(paramActivity);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    try {
      getMapFragmentDelegate().onCreate(paramBundle);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "MapFragment", "onCreate");
      return;
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    Bundle bundle = paramBundle;
    if (paramBundle == null)
      try {
        bundle = getArguments();
        return getMapFragmentDelegate().onCreateView(paramLayoutInflater, paramViewGroup, bundle);
      } catch (RemoteException remoteException) {
        cm.a((Throwable)remoteException, "MapFragment", "onCreateView");
        return null;
      }  
    return getMapFragmentDelegate().onCreateView((LayoutInflater)remoteException, paramViewGroup, bundle);
  }
  
  public void onDestroy() {
    try {
      getMapFragmentDelegate().onDestroy();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "MapFragment", "onDestroy");
    } 
    super.onDestroy();
  }
  
  public void onDestroyView() {
    try {
      getMapFragmentDelegate().onDestroyView();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "MapFragment", "onDestroyView");
    } 
    super.onDestroyView();
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle) {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    try {
      getMapFragmentDelegate().onInflate(paramActivity, new AMapOptions(), paramBundle);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "MapFragment", "onInflate");
      return;
    } 
  }
  
  public void onLowMemory() {
    super.onLowMemory();
    try {
      getMapFragmentDelegate().onLowMemory();
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "MapFragment", "onLowMemory");
      return;
    } 
  }
  
  public void onPause() {
    super.onPause();
    try {
      getMapFragmentDelegate().onPause();
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "MapFragment", "onPause");
      return;
    } 
  }
  
  public void onResume() {
    super.onResume();
    try {
      getMapFragmentDelegate().onResume();
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "MapFragment", "onResume");
      return;
    } 
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    try {
      getMapFragmentDelegate().onSaveInstanceState(paramBundle);
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "MapFragment", "onSaveInstanceState");
    } 
    super.onSaveInstanceState(paramBundle);
  }
  
  public void setArguments(Bundle paramBundle) {
    super.setArguments(paramBundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\MapFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */