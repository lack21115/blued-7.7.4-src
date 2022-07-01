package com.amap.api.maps2d.model;

import android.os.RemoteException;
import com.amap.api.interfaces.IOverlay;
import com.amap.api.interfaces.IPolyline;
import com.amap.api.mapcore2d.cm;
import java.util.List;

public class Polyline {
  private final IPolyline a;
  
  public Polyline(IPolyline paramIPolyline) {
    this.a = paramIPolyline;
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof Polyline))
      return false; 
    try {
      return (this.a == null) ? false : this.a.equalsRemote((IOverlay)((Polyline)paramObject).a);
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Polyline", "equals");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public int getColor() {
    try {
      return (this.a == null) ? 0 : this.a.getColor();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Polyline", "getColor");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public String getId() {
    try {
      return (this.a == null) ? "" : this.a.getId();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Polyline", "getId");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public List<LatLng> getPoints() {
    try {
      return (this.a == null) ? null : this.a.getPoints();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Polyline", "getPoints");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public float getWidth() {
    try {
      return (this.a == null) ? 0.0F : this.a.getWidth();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Polyline", "getWidth");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public float getZIndex() {
    try {
      return (this.a == null) ? 0.0F : this.a.getZIndex();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Polyline", "getZIndex");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public int hashCode() {
    try {
      return (this.a == null) ? 0 : this.a.hashCodeRemote();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Polyline", "hashCode");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public boolean isDottedLine() {
    IPolyline iPolyline = this.a;
    return (iPolyline == null) ? false : iPolyline.isDottedLine();
  }
  
  public boolean isGeodesic() {
    IPolyline iPolyline = this.a;
    return (iPolyline == null) ? false : iPolyline.isGeodesic();
  }
  
  public boolean isVisible() {
    try {
      return (this.a == null) ? false : this.a.isVisible();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Polyline", "isVisible");
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
      cm.a((Throwable)remoteException, "Polyline", "remove");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setColor(int paramInt) {
    try {
      if (this.a == null)
        return; 
      this.a.setColor(paramInt);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Polyline", "setColor");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setDottedLine(boolean paramBoolean) {
    IPolyline iPolyline = this.a;
    if (iPolyline == null)
      return; 
    iPolyline.setDottedLine(paramBoolean);
  }
  
  public void setGeodesic(boolean paramBoolean) {
    try {
      if (this.a == null)
        return; 
      if (this.a.isGeodesic() != paramBoolean) {
        List<LatLng> list = getPoints();
        this.a.setGeodesic(paramBoolean);
        setPoints(list);
      } 
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Polyline", "setGeodesic");
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
      cm.a((Throwable)remoteException, "Polyline", "setPoints");
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
      cm.a((Throwable)remoteException, "Polyline", "setVisible");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setWidth(float paramFloat) {
    try {
      if (this.a == null)
        return; 
      this.a.setWidth(paramFloat);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "Polyline", "setWidth");
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
      cm.a((Throwable)remoteException, "Polyline", "setZIndex");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\Polyline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */