package com.amap.api.maps2d.model;

import android.os.RemoteException;
import com.amap.api.mapcore2d.aa;
import com.amap.api.mapcore2d.cm;

public final class GroundOverlay {
  private aa a;
  
  public GroundOverlay(aa paramaa) {
    this.a = paramaa;
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof GroundOverlay))
      return false; 
    try {
      throw new RemoteException();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "GroundOverlay", "equals");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public float getBearing() {
    try {
      return (this.a == null) ? 0.0F : this.a.getBearing();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "GroundOverlay", "getBearing");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public LatLngBounds getBounds() {
    try {
      return (this.a == null) ? null : this.a.getBounds();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "GroundOverlay", "getBounds");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public float getHeight() {
    try {
      return (this.a == null) ? 0.0F : this.a.getHeight();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "GroundOverlay", "getHeight");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public String getId() {
    try {
      return (this.a == null) ? "" : this.a.getId();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "GroundOverlay", "getId");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public LatLng getPosition() {
    try {
      return (this.a == null) ? null : this.a.getPosition();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "GroundOverlay", "getPosition");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public float getTransparency() {
    try {
      return (this.a == null) ? 0.0F : this.a.getTransparency();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "GroundOverlay", "getTransparency");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public float getWidth() {
    try {
      return (this.a == null) ? 0.0F : this.a.getWidth();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "GroundOverlay", "getWidth");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public float getZIndex() {
    try {
      return (this.a == null) ? 0.0F : this.a.getZIndex();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "GroundOverlay", "getZIndex");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public int hashCode() {
    aa aa1 = this.a;
    return (aa1 == null) ? 0 : aa1.hashCode();
  }
  
  public boolean isVisible() {
    try {
      return (this.a == null) ? false : this.a.isVisible();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "GroundOverlay", "isVisible");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void remove() {
    try {
      if (this.a == null)
        return; 
      this.a.remove();
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "GroundOverlay", "remove");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setBearing(float paramFloat) {
    try {
      if (this.a == null)
        return; 
      this.a.setBearing(paramFloat);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "GroundOverlay", "setBearing");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setDimensions(float paramFloat) {
    try {
      if (this.a == null)
        return; 
      this.a.setDimensions(paramFloat);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "GroundOverlay", "setDimensions");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setDimensions(float paramFloat1, float paramFloat2) {
    try {
      if (this.a == null)
        return; 
      this.a.setDimensions(paramFloat1, paramFloat2);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "GroundOverlay", "setDimensions");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setImage(BitmapDescriptor paramBitmapDescriptor) {
    try {
      if (this.a == null)
        return; 
      this.a.setImage(paramBitmapDescriptor);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "GroundOverlay", "setImage");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setPosition(LatLng paramLatLng) {
    try {
      if (this.a == null)
        return; 
      this.a.setPosition(paramLatLng);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "GroundOverlay", "setPosition");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setPositionFromBounds(LatLngBounds paramLatLngBounds) {
    try {
      if (this.a == null)
        return; 
      this.a.setPositionFromBounds(paramLatLngBounds);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "GroundOverlay", "setPositionFromBounds");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setTransparency(float paramFloat) {
    try {
      if (this.a == null)
        return; 
      this.a.setTransparency(paramFloat);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "GroundOverlay", "setTransparency");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setVisible(boolean paramBoolean) {
    try {
      if (this.a == null)
        return; 
      this.a.setVisible(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "GroundOverlay", "setVisible");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setZIndex(float paramFloat) {
    try {
      if (this.a == null)
        return; 
      this.a.setZIndex(paramFloat);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "GroundOverlay", "setZIndex");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\GroundOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */