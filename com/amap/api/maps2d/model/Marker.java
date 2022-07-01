package com.amap.api.maps2d.model;

import android.os.RemoteException;
import com.amap.api.interfaces.IMarker;
import com.amap.api.mapcore2d.cm;
import java.util.ArrayList;

public final class Marker {
  IMarker a;
  
  public Marker(IMarker paramIMarker) {
    this.a = paramIMarker;
  }
  
  public Marker(MarkerOptions paramMarkerOptions) {}
  
  public void destroy() {
    try {
      if (this.a != null) {
        this.a.destroy();
        return;
      } 
    } catch (Exception exception) {
      cm.a(exception, "Marker", "destroy");
    } 
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof Marker))
      return false; 
    IMarker iMarker = this.a;
    return (iMarker == null) ? false : iMarker.equalsRemote(((Marker)paramObject).a);
  }
  
  public ArrayList<BitmapDescriptor> getIcons() {
    try {
      return this.a.getIcons();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Marker", "getIcons");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public String getId() {
    IMarker iMarker = this.a;
    return (iMarker == null) ? null : iMarker.getId();
  }
  
  public Object getObject() {
    IMarker iMarker = this.a;
    return (iMarker != null) ? iMarker.getObject() : null;
  }
  
  public int getPeriod() {
    try {
      return this.a.getPeriod();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Marker", "getPeriod");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public LatLng getPosition() {
    IMarker iMarker = this.a;
    return (iMarker == null) ? null : iMarker.getPosition();
  }
  
  public String getSnippet() {
    IMarker iMarker = this.a;
    return (iMarker == null) ? null : iMarker.getSnippet();
  }
  
  public String getTitle() {
    IMarker iMarker = this.a;
    return (iMarker == null) ? null : iMarker.getTitle();
  }
  
  public float getZIndex() {
    IMarker iMarker = this.a;
    return (iMarker == null) ? 0.0F : iMarker.getZIndex();
  }
  
  public int hashCode() {
    IMarker iMarker = this.a;
    return (iMarker == null) ? super.hashCode() : iMarker.hashCodeRemote();
  }
  
  public void hideInfoWindow() {
    IMarker iMarker = this.a;
    if (iMarker != null)
      iMarker.hideInfoWindow(); 
  }
  
  public boolean isDraggable() {
    IMarker iMarker = this.a;
    return (iMarker == null) ? false : iMarker.isDraggable();
  }
  
  public boolean isInfoWindowShown() {
    IMarker iMarker = this.a;
    return (iMarker == null) ? false : iMarker.isInfoWindowShown();
  }
  
  public boolean isVisible() {
    IMarker iMarker = this.a;
    return (iMarker == null) ? false : iMarker.isVisible();
  }
  
  public void remove() {
    try {
      if (this.a != null) {
        this.a.remove();
        return;
      } 
    } catch (Exception exception) {
      cm.a(exception, "Marker", "remove");
    } 
  }
  
  public void setAnchor(float paramFloat1, float paramFloat2) {
    IMarker iMarker = this.a;
    if (iMarker != null)
      iMarker.setAnchor(paramFloat1, paramFloat2); 
  }
  
  public void setDraggable(boolean paramBoolean) {
    IMarker iMarker = this.a;
    if (iMarker != null)
      iMarker.setDraggable(paramBoolean); 
  }
  
  public void setIcon(BitmapDescriptor paramBitmapDescriptor) {
    IMarker iMarker = this.a;
    if (iMarker != null && paramBitmapDescriptor != null)
      iMarker.setIcon(paramBitmapDescriptor); 
  }
  
  public void setIcons(ArrayList<BitmapDescriptor> paramArrayList) {
    try {
      this.a.setIcons(paramArrayList);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Marker", "setIcons");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setObject(Object paramObject) {
    IMarker iMarker = this.a;
    if (iMarker != null)
      iMarker.setObject(paramObject); 
  }
  
  public void setPeriod(int paramInt) {
    try {
      if (this.a != null)
        this.a.setPeriod(paramInt); 
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Marker", "setPeriod");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setPosition(LatLng paramLatLng) {
    IMarker iMarker = this.a;
    if (iMarker != null)
      iMarker.setPosition(paramLatLng); 
  }
  
  public void setPositionByPixels(int paramInt1, int paramInt2) {
    try {
      if (this.a != null) {
        this.a.setPositionByPixels(paramInt1, paramInt2);
        return;
      } 
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Marker", "setPositionByPixels");
      remoteException.printStackTrace();
    } 
  }
  
  public void setRotateAngle(float paramFloat) {
    try {
      this.a.setRotateAngle(paramFloat);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Marker", "setRotateAngle");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setSnippet(String paramString) {
    IMarker iMarker = this.a;
    if (iMarker != null)
      iMarker.setSnippet(paramString); 
  }
  
  public void setTitle(String paramString) {
    IMarker iMarker = this.a;
    if (iMarker != null)
      iMarker.setTitle(paramString); 
  }
  
  public void setVisible(boolean paramBoolean) {
    IMarker iMarker = this.a;
    if (iMarker != null)
      iMarker.setVisible(paramBoolean); 
  }
  
  public void setZIndex(float paramFloat) {
    IMarker iMarker = this.a;
    if (iMarker != null)
      iMarker.setZIndex(paramFloat); 
  }
  
  public void showInfoWindow() {
    IMarker iMarker = this.a;
    if (iMarker != null)
      iMarker.showInfoWindow(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\Marker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */