package com.amap.api.maps2d.model;

import android.os.RemoteException;
import com.amap.api.interfaces.ICircle;
import com.amap.api.interfaces.IOverlay;
import com.amap.api.mapcore2d.cm;

public final class Circle {
  private final ICircle a;
  
  public Circle(ICircle paramICircle) {
    this.a = paramICircle;
  }
  
  public boolean contains(LatLng paramLatLng) {
    try {
      return (this.a == null || paramLatLng == null) ? false : this.a.contains(paramLatLng);
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Circle", "contains");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof Circle))
      return false; 
    try {
      return (this.a == null) ? false : this.a.equalsRemote((IOverlay)((Circle)paramObject).a);
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Circle", "equals");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public LatLng getCenter() {
    try {
      return (this.a == null) ? null : this.a.getCenter();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Circle", "getCenter");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public int getFillColor() {
    try {
      return (this.a == null) ? 0 : this.a.getFillColor();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Circle", "getFillColor");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public String getId() {
    try {
      return (this.a == null) ? "" : this.a.getId();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Circle", "getId");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public double getRadius() {
    try {
      return (this.a == null) ? 0.0D : this.a.getRadius();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Circle", "getRadius");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public int getStrokeColor() {
    try {
      return (this.a == null) ? 0 : this.a.getStrokeColor();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Circle", "getStrokeColor");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public float getStrokeWidth() {
    try {
      return (this.a == null) ? 0.0F : this.a.getStrokeWidth();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Circle", "getStrokeWidth");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public float getZIndex() {
    try {
      return (this.a == null) ? 0.0F : this.a.getZIndex();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Circle", "getZIndex");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public int hashCode() {
    try {
      return (this.a == null) ? 0 : this.a.hashCodeRemote();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Circle", "hashCode");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public boolean isVisible() {
    try {
      return (this.a == null) ? false : this.a.isVisible();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Circle", "isVisible");
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
      cm.a((Throwable)remoteException, "Circle", "remove");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setCenter(LatLng paramLatLng) {
    try {
      if (this.a == null)
        return; 
      this.a.setCenter(paramLatLng);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Circle", "setCenter");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setFillColor(int paramInt) {
    try {
      if (this.a == null)
        return; 
      this.a.setFillColor(paramInt);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Circle", "setFillColor");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setRadius(double paramDouble) {
    try {
      if (this.a == null)
        return; 
      this.a.setRadius(paramDouble);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Circle", "setRadius");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setStrokeColor(int paramInt) {
    try {
      if (this.a == null)
        return; 
      this.a.setStrokeColor(paramInt);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Circle", "setStrokeColor");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setStrokeWidth(float paramFloat) {
    try {
      if (this.a == null)
        return; 
      this.a.setStrokeWidth(paramFloat);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Circle", "setStrokeWidth");
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
      cm.a((Throwable)remoteException, "Circle", "setVisible");
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
      cm.a((Throwable)remoteException, "Circle", "setZIndex");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\Circle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */