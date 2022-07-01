package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class UiSettings {
  private final IUiSettingsDelegate zzcj;
  
  UiSettings(IUiSettingsDelegate paramIUiSettingsDelegate) {
    this.zzcj = paramIUiSettingsDelegate;
  }
  
  public final boolean isCompassEnabled() {
    try {
      return this.zzcj.isCompassEnabled();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final boolean isIndoorLevelPickerEnabled() {
    try {
      return this.zzcj.isIndoorLevelPickerEnabled();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final boolean isMapToolbarEnabled() {
    try {
      return this.zzcj.isMapToolbarEnabled();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final boolean isMyLocationButtonEnabled() {
    try {
      return this.zzcj.isMyLocationButtonEnabled();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final boolean isRotateGesturesEnabled() {
    try {
      return this.zzcj.isRotateGesturesEnabled();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final boolean isScrollGesturesEnabled() {
    try {
      return this.zzcj.isScrollGesturesEnabled();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final boolean isScrollGesturesEnabledDuringRotateOrZoom() {
    try {
      return this.zzcj.isScrollGesturesEnabled();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final boolean isTiltGesturesEnabled() {
    try {
      return this.zzcj.isTiltGesturesEnabled();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final boolean isZoomControlsEnabled() {
    try {
      return this.zzcj.isZoomControlsEnabled();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final boolean isZoomGesturesEnabled() {
    try {
      return this.zzcj.isZoomGesturesEnabled();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setAllGesturesEnabled(boolean paramBoolean) {
    try {
      this.zzcj.setAllGesturesEnabled(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setCompassEnabled(boolean paramBoolean) {
    try {
      this.zzcj.setCompassEnabled(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setIndoorLevelPickerEnabled(boolean paramBoolean) {
    try {
      this.zzcj.setIndoorLevelPickerEnabled(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setMapToolbarEnabled(boolean paramBoolean) {
    try {
      this.zzcj.setMapToolbarEnabled(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setMyLocationButtonEnabled(boolean paramBoolean) {
    try {
      this.zzcj.setMyLocationButtonEnabled(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setRotateGesturesEnabled(boolean paramBoolean) {
    try {
      this.zzcj.setRotateGesturesEnabled(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setScrollGesturesEnabled(boolean paramBoolean) {
    try {
      this.zzcj.setScrollGesturesEnabled(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setScrollGesturesEnabledDuringRotateOrZoom(boolean paramBoolean) {
    try {
      this.zzcj.setScrollGesturesEnabledDuringRotateOrZoom(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setTiltGesturesEnabled(boolean paramBoolean) {
    try {
      this.zzcj.setTiltGesturesEnabled(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setZoomControlsEnabled(boolean paramBoolean) {
    try {
      this.zzcj.setZoomControlsEnabled(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setZoomGesturesEnabled(boolean paramBoolean) {
    try {
      this.zzcj.setZoomGesturesEnabled(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\UiSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */