package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.maps.zzw;
import java.util.List;

public final class Polygon {
  private final zzw zzdw;
  
  public Polygon(zzw paramzzw) {
    this.zzdw = (zzw)Preconditions.checkNotNull(paramzzw);
  }
  
  public final boolean equals(Object paramObject) {
    if (!(paramObject instanceof Polygon))
      return false; 
    try {
      return this.zzdw.zzb(((Polygon)paramObject).zzdw);
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final int getFillColor() {
    try {
      return this.zzdw.getFillColor();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final List<List<LatLng>> getHoles() {
    try {
      return this.zzdw.getHoles();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final String getId() {
    try {
      return this.zzdw.getId();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final List<LatLng> getPoints() {
    try {
      return this.zzdw.getPoints();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final int getStrokeColor() {
    try {
      return this.zzdw.getStrokeColor();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final int getStrokeJointType() {
    try {
      return this.zzdw.getStrokeJointType();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final List<PatternItem> getStrokePattern() {
    try {
      return PatternItem.zza(this.zzdw.getStrokePattern());
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final float getStrokeWidth() {
    try {
      return this.zzdw.getStrokeWidth();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final Object getTag() {
    try {
      return ObjectWrapper.unwrap(this.zzdw.zzk());
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final float getZIndex() {
    try {
      return this.zzdw.getZIndex();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final int hashCode() {
    try {
      return this.zzdw.zzj();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final boolean isClickable() {
    try {
      return this.zzdw.isClickable();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final boolean isGeodesic() {
    try {
      return this.zzdw.isGeodesic();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final boolean isVisible() {
    try {
      return this.zzdw.isVisible();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void remove() {
    try {
      this.zzdw.remove();
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setClickable(boolean paramBoolean) {
    try {
      this.zzdw.setClickable(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setFillColor(int paramInt) {
    try {
      this.zzdw.setFillColor(paramInt);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setGeodesic(boolean paramBoolean) {
    try {
      this.zzdw.setGeodesic(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setHoles(List<? extends List<LatLng>> paramList) {
    try {
      this.zzdw.setHoles(paramList);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setPoints(List<LatLng> paramList) {
    try {
      this.zzdw.setPoints(paramList);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setStrokeColor(int paramInt) {
    try {
      this.zzdw.setStrokeColor(paramInt);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setStrokeJointType(int paramInt) {
    try {
      this.zzdw.setStrokeJointType(paramInt);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setStrokePattern(List<PatternItem> paramList) {
    try {
      this.zzdw.setStrokePattern(paramList);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setStrokeWidth(float paramFloat) {
    try {
      this.zzdw.setStrokeWidth(paramFloat);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setTag(Object paramObject) {
    try {
      this.zzdw.zze(ObjectWrapper.wrap(paramObject));
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setVisible(boolean paramBoolean) {
    try {
      this.zzdw.setVisible(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setZIndex(float paramFloat) {
    try {
      this.zzdw.setZIndex(paramFloat);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\model\Polygon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */