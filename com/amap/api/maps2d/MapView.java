package com.amap.api.maps2d;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.amap.api.interfaces.IAMap;
import com.amap.api.interfaces.IMapFragmentDelegate;
import com.amap.api.mapcore2d.ar;
import com.amap.api.mapcore2d.cm;
import com.amap.api.mapcore2d.ef;
import com.amap.api.maps2d.model.RuntimeRemoteException;

public class MapView extends FrameLayout {
  private IMapFragmentDelegate a;
  
  private AMap b;
  
  public MapView(Context paramContext) {
    super(paramContext);
    getMapFragmentDelegate().setContext(paramContext);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    getMapFragmentDelegate().setContext(paramContext);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    getMapFragmentDelegate().setContext(paramContext);
  }
  
  public MapView(Context paramContext, AMapOptions paramAMapOptions) {
    super(paramContext);
    getMapFragmentDelegate().setContext(paramContext);
    getMapFragmentDelegate().setOptions(paramAMapOptions);
  }
  
  public AMap getMap() {
    IMapFragmentDelegate iMapFragmentDelegate = getMapFragmentDelegate();
    if (iMapFragmentDelegate == null)
      return null; 
    try {
      IAMap iAMap = iMapFragmentDelegate.getMap();
      if (iAMap == null)
        return null; 
      if (this.b == null)
        this.b = new AMap(iAMap); 
      return this.b;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "MapView", "getMap");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  protected IMapFragmentDelegate getMapFragmentDelegate() {
    try {
      if (this.a == null)
        this.a = (IMapFragmentDelegate)ef.a(getContext(), cm.a(), "com.amap.api.wrapper.MapFragmentDelegateWrapper", ar.class, null, null); 
    } finally {
      Exception exception;
    } 
    if (this.a == null)
      this.a = (IMapFragmentDelegate)new ar(); 
    return this.a;
  }
  
  public final void onCreate(Bundle paramBundle) {
    try {
      return;
    } catch (RemoteException remoteException) {
      return;
    } finally {
      paramBundle = null;
      cm.a((Throwable)paramBundle, "MapView", "onCreate");
    } 
  }
  
  public final void onDestroy() {
    try {
      getMapFragmentDelegate().onDestroy();
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "MapView", "onDestroy");
      return;
    } 
  }
  
  public final void onLowMemory() {
    try {
      getMapFragmentDelegate().onLowMemory();
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "MapView", "onLowMemory");
      return;
    } 
  }
  
  public final void onPause() {
    try {
      getMapFragmentDelegate().onPause();
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "MapView", "onPause");
      return;
    } 
  }
  
  public final void onResume() {
    try {
      getMapFragmentDelegate().onResume();
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "MapView", "onResume");
      return;
    } 
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {
    try {
      getMapFragmentDelegate().onSaveInstanceState(paramBundle);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "MapView", "onSaveInstanceState");
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\MapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */