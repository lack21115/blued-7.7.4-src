package com.amap.api.maps2d;

import android.os.RemoteException;
import com.amap.api.interfaces.IUiSettings;
import com.amap.api.mapcore2d.cm;

public final class UiSettings {
  private final IUiSettings a;
  
  public UiSettings(IUiSettings paramIUiSettings) {
    this.a = paramIUiSettings;
  }
  
  public int getLogoPosition() {
    try {
      return this.a.getLogoPosition();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "UiSettings", "getLogoPosition");
      remoteException.printStackTrace();
      return 0;
    } 
  }
  
  public int getZoomPosition() {
    try {
      return this.a.getZoomPosition();
    } finally {
      Exception exception = null;
      cm.a(exception, "UiSettings", "getZoomPosition");
      exception.printStackTrace();
    } 
  }
  
  public boolean isCompassEnabled() {
    try {
      return this.a.isCompassEnabled();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "UiSettings", "isCompassEnabled");
      remoteException.printStackTrace();
      return false;
    } 
  }
  
  public boolean isMyLocationButtonEnabled() {
    try {
      return this.a.isMyLocationButtonEnabled();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "UiSettings", "isMyLocationButtonEnabled");
      remoteException.printStackTrace();
      return false;
    } 
  }
  
  public boolean isScaleControlsEnabled() {
    try {
      return this.a.isScaleControlsEnabled();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "UiSettings", "isScaleControlsEnabled");
      remoteException.printStackTrace();
      return false;
    } 
  }
  
  public boolean isScrollGesturesEnabled() {
    try {
      return this.a.isScrollGesturesEnabled();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "UiSettings", "isScrollGestureEnabled");
      remoteException.printStackTrace();
      return false;
    } 
  }
  
  public boolean isZoomControlsEnabled() {
    try {
      return this.a.isZoomControlsEnabled();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "UiSettings", "isZoomControlsEnabled");
      remoteException.printStackTrace();
      return false;
    } 
  }
  
  public boolean isZoomGesturesEnabled() {
    try {
      return this.a.isZoomGesturesEnabled();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "UiSettings", "isZoomGesturesEnabled");
      remoteException.printStackTrace();
      return false;
    } 
  }
  
  public void setAllGesturesEnabled(boolean paramBoolean) {
    try {
      this.a.setAllGesturesEnabled(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "UiSettings", "setAllGesturesEnabled");
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public void setCompassEnabled(boolean paramBoolean) {
    try {
      this.a.setCompassEnabled(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "UiSettings", "setCompassEnabled");
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public void setLogoCenter(int paramInt1, int paramInt2) {
    try {
      return;
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
  
  public void setLogoPosition(int paramInt) {
    try {
      this.a.setLogoPosition(paramInt);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "UiSettings", "setLogoPosition");
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public void setMyLocationButtonEnabled(boolean paramBoolean) {
    try {
      this.a.setMyLocationButtonEnabled(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "UiSettings", "setMyLocationButtonEnabled");
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public void setScaleControlsEnabled(boolean paramBoolean) {
    try {
      this.a.setScaleControlsEnabled(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "UiSettings", "setScaleControlsEnabled");
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public void setScrollGesturesEnabled(boolean paramBoolean) {
    try {
      this.a.setScrollGesturesEnabled(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "UiSettings", "setScrollGesturesEnabled");
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public void setZoomControlsEnabled(boolean paramBoolean) {
    try {
      this.a.setZoomControlsEnabled(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "UiSettings", "setZoomControlsEnabled");
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public void setZoomGesturesEnabled(boolean paramBoolean) {
    try {
      this.a.setZoomGesturesEnabled(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "UiSettings", "setZoomGesturesEnabled");
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public void setZoomInByScreenCenter(boolean paramBoolean) {
    try {
      return;
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
  
  public void setZoomPosition(int paramInt) {
    try {
      this.a.setZoomPosition(paramInt);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "UiSettings", "setZoomPosition");
      remoteException.printStackTrace();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\UiSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */