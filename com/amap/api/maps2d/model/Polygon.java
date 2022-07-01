package com.amap.api.maps2d.model;

import android.os.RemoteException;
import com.amap.api.interfaces.IOverlay;
import com.amap.api.interfaces.IPolygon;
import com.amap.api.mapcore2d.af;
import com.amap.api.mapcore2d.cm;
import java.util.List;

public final class Polygon {
  private IPolygon a;
  
  public Polygon(af paramaf) {
    this.a = (IPolygon)paramaf;
  }
  
  public boolean contains(LatLng paramLatLng) {
    try {
      return (this.a == null) ? false : this.a.contains(paramLatLng);
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Polygon", "contains");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof Polygon))
      return false; 
    try {
      return (this.a == null) ? false : this.a.equalsRemote((IOverlay)((Polygon)paramObject).a);
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Polygon", "equeals");
      return false;
    } 
  }
  
  public int getFillColor() {
    try {
      return (this.a == null) ? 0 : this.a.getFillColor();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Polygon", "getFillColor");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public String getId() {
    try {
      return (this.a == null) ? null : this.a.getId();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Polygon", "getId");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public List<LatLng> getPoints() {
    try {
      return (this.a == null) ? null : this.a.getPoints();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Polygon", "getPoints");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public int getStrokeColor() {
    try {
      return (this.a == null) ? 0 : this.a.getStrokeColor();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Polygon", "getStrokeColor");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public float getStrokeWidth() {
    try {
      return (this.a == null) ? 0.0F : this.a.getStrokeWidth();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Polygon", "getStrokeWidth");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public float getZIndex() {
    try {
      return (this.a == null) ? 0.0F : this.a.getZIndex();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Polygon", "getZIndex");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public int hashCode() {
    try {
      return (this.a == null) ? 0 : this.a.hashCodeRemote();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Polygon", "hashCode");
      return super.hashCode();
    } 
  }
  
  public boolean isVisible() {
    try {
      return (this.a == null) ? true : this.a.isVisible();
    } catch (RemoteException remoteException) {
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
      cm.a((Throwable)remoteException, "Polygon", "remove");
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
      cm.a((Throwable)remoteException, "Polygon", "setFillColor");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setPoints(List<LatLng> paramList) {
    try {
      if (this.a == null)
        return; 
      this.a.setPoints(paramList);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Polygon", "setPoints");
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
      cm.a((Throwable)remoteException, "Polygon", "setStrokeColor");
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
      cm.a((Throwable)remoteException, "Polygon", "setStrokeWidth");
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
      cm.a((Throwable)remoteException, "Polygon", "setVisible");
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
      cm.a((Throwable)remoteException, "Polygon", "setZIndex");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\Polygon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */