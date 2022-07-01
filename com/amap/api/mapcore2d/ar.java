package com.amap.api.mapcore2d;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.interfaces.IAMap;
import com.amap.api.interfaces.IMapFragmentDelegate;
import com.amap.api.maps2d.AMapOptions;
import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.UiSettings;
import com.amap.api.maps2d.model.CameraPosition;

public class ar implements IMapFragmentDelegate {
  public static volatile Context a;
  
  private IAMap b;
  
  private AMapOptions c;
  
  private void a(Context paramContext) {
    if (paramContext != null)
      a = paramContext.getApplicationContext(); 
  }
  
  void a() {
    int i = (a.getResources().getDisplayMetrics()).densityDpi;
    q.l = i;
    if (i > 320) {
      if (i <= 480) {
        q.j = 384;
      } else {
        q.j = 512;
      } 
    } else {
      q.j = 256;
    } 
    if (i <= 120) {
      q.a = 0.5F;
    } else if (i <= 160) {
      q.a = 0.6F;
      q.a(18);
    } else if (i <= 240) {
      q.a = 0.87F;
    } else if (i <= 320) {
      q.a = 1.0F;
    } else if (i <= 480) {
      q.a = 1.5F;
    } else {
      q.a = 1.8F;
    } 
    if (q.a <= 0.6F)
      q.c = 18; 
  }
  
  void a(AMapOptions paramAMapOptions) throws RemoteException {
    if (paramAMapOptions != null && this.b != null) {
      CameraPosition cameraPosition = paramAMapOptions.getCamera();
      if (cameraPosition != null)
        this.b.moveCamera(new CameraUpdate(m.a(cameraPosition.target, cameraPosition.zoom, cameraPosition.bearing, cameraPosition.tilt))); 
      UiSettings uiSettings = this.b.getAMapUiSettings();
      uiSettings.setScrollGesturesEnabled(paramAMapOptions.getScrollGesturesEnabled().booleanValue());
      uiSettings.setZoomControlsEnabled(paramAMapOptions.getZoomControlsEnabled().booleanValue());
      uiSettings.setZoomGesturesEnabled(paramAMapOptions.getZoomGesturesEnabled().booleanValue());
      uiSettings.setCompassEnabled(paramAMapOptions.getCompassEnabled().booleanValue());
      uiSettings.setScaleControlsEnabled(paramAMapOptions.getScaleControlsEnabled().booleanValue());
      uiSettings.setLogoPosition(paramAMapOptions.getLogoPosition());
      this.b.setMapType(paramAMapOptions.getMapType());
      this.b.setZOrderOnTop(paramAMapOptions.getZOrderOnTop().booleanValue());
    } 
  }
  
  public IAMap getMap() throws RemoteException {
    if (this.b == null)
      if (a != null) {
        a();
        this.b = new b(a);
      } else {
        throw new NullPointerException("Context 为 null 请在地图调用之前 使用 MapsInitializer.initialize(Context paramContext) 来设置Context");
      }  
    return this.b;
  }
  
  public boolean isReady() throws RemoteException {
    return false;
  }
  
  public void onCreate(Bundle paramBundle) throws RemoteException {
    ck.a("MapFragmentDelegateImp", "onCreate", 113);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) throws RemoteException {
    if (this.b == null) {
      if (a == null && paramLayoutInflater != null)
        setContext(paramLayoutInflater.getContext().getApplicationContext()); 
      if (a != null) {
        a();
        this.b = new b(a);
      } else {
        throw new NullPointerException("Context 为 null 请在地图调用之前 使用 MapsInitializer.initialize(Context paramContext) 来设置Context");
      } 
    } 
    try {
      if (this.c == null && paramBundle != null) {
        byte[] arrayOfByte = paramBundle.getByteArray("MapOptions");
        if (arrayOfByte != null) {
          Parcel parcel = Parcel.obtain();
          parcel.unmarshall(arrayOfByte, 0, arrayOfByte.length);
          parcel.setDataPosition(0);
          this.c = AMapOptions.CREATOR.createFromParcel(parcel);
        } 
      } 
      a(this.c);
    } finally {
      paramLayoutInflater = null;
    } 
    return this.b.getView();
  }
  
  public void onDestroy() throws RemoteException {
    if (getMap() != null) {
      getMap().clear();
      getMap().destroy();
    } 
    setContext(null);
  }
  
  public void onDestroyView() throws RemoteException {}
  
  public void onInflate(Activity paramActivity, AMapOptions paramAMapOptions, Bundle paramBundle) throws RemoteException {
    setContext((Context)paramActivity);
    this.c = paramAMapOptions;
  }
  
  public void onLowMemory() throws RemoteException {
    Log.d("onLowMemory", "onLowMemory run");
  }
  
  public void onPause() throws RemoteException {
    IAMap iAMap = this.b;
    if (iAMap != null)
      iAMap.onPause(); 
  }
  
  public void onResume() throws RemoteException {
    IAMap iAMap = this.b;
    if (iAMap != null)
      iAMap.onResume(); 
  }
  
  public void onSaveInstanceState(Bundle paramBundle) throws RemoteException {
    if (this.b != null) {
      if (this.c == null)
        this.c = new AMapOptions(); 
      this.c = this.c.camera(getMap().getCameraPosition());
      if (paramBundle != null)
        try {
          Parcel parcel = Parcel.obtain();
          this.c.writeToParcel(parcel, 0);
          return;
        } finally {
          paramBundle = null;
        }  
    } 
  }
  
  public void setContext(Context paramContext) {
    a(paramContext);
  }
  
  public void setOptions(AMapOptions paramAMapOptions) {
    this.c = paramAMapOptions;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */