package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.maps.zzt;

public final class Marker {
  private final zzt zzdm;
  
  public Marker(zzt paramzzt) {
    this.zzdm = (zzt)Preconditions.checkNotNull(paramzzt);
  }
  
  public final boolean equals(Object paramObject) {
    if (!(paramObject instanceof Marker))
      return false; 
    try {
      return this.zzdm.zzj(((Marker)paramObject).zzdm);
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final float getAlpha() {
    try {
      return this.zzdm.getAlpha();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final String getId() {
    try {
      return this.zzdm.getId();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final LatLng getPosition() {
    try {
      return this.zzdm.getPosition();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final float getRotation() {
    try {
      return this.zzdm.getRotation();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final String getSnippet() {
    try {
      return this.zzdm.getSnippet();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final Object getTag() {
    try {
      return ObjectWrapper.unwrap(this.zzdm.zzk());
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final String getTitle() {
    try {
      return this.zzdm.getTitle();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final float getZIndex() {
    try {
      return this.zzdm.getZIndex();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final int hashCode() {
    try {
      return this.zzdm.zzj();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void hideInfoWindow() {
    try {
      this.zzdm.hideInfoWindow();
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final boolean isDraggable() {
    try {
      return this.zzdm.isDraggable();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final boolean isFlat() {
    try {
      return this.zzdm.isFlat();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final boolean isInfoWindowShown() {
    try {
      return this.zzdm.isInfoWindowShown();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final boolean isVisible() {
    try {
      return this.zzdm.isVisible();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void remove() {
    try {
      this.zzdm.remove();
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setAlpha(float paramFloat) {
    try {
      this.zzdm.setAlpha(paramFloat);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setAnchor(float paramFloat1, float paramFloat2) {
    try {
      this.zzdm.setAnchor(paramFloat1, paramFloat2);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setDraggable(boolean paramBoolean) {
    try {
      this.zzdm.setDraggable(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setFlat(boolean paramBoolean) {
    try {
      this.zzdm.setFlat(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setIcon(BitmapDescriptor paramBitmapDescriptor) {
    if (paramBitmapDescriptor == null)
      try {
        this.zzdm.zzg(null);
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      }  
    IObjectWrapper iObjectWrapper = remoteException.zzb();
    this.zzdm.zzg(iObjectWrapper);
  }
  
  public final void setInfoWindowAnchor(float paramFloat1, float paramFloat2) {
    try {
      this.zzdm.setInfoWindowAnchor(paramFloat1, paramFloat2);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setPosition(LatLng paramLatLng) {
    if (paramLatLng != null)
      try {
        this.zzdm.setPosition(paramLatLng);
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      }  
    throw new IllegalArgumentException("latlng cannot be null - a position is required.");
  }
  
  public final void setRotation(float paramFloat) {
    try {
      this.zzdm.setRotation(paramFloat);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setSnippet(String paramString) {
    try {
      this.zzdm.setSnippet(paramString);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setTag(Object paramObject) {
    try {
      this.zzdm.zze(ObjectWrapper.wrap(paramObject));
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setTitle(String paramString) {
    try {
      this.zzdm.setTitle(paramString);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setVisible(boolean paramBoolean) {
    try {
      this.zzdm.setVisible(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setZIndex(float paramFloat) {
    try {
      this.zzdm.setZIndex(paramFloat);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void showInfoWindow() {
    try {
      this.zzdm.showInfoWindow();
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\model\Marker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */