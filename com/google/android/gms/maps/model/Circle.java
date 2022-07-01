package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.maps.zzh;
import java.util.List;

public final class Circle {
  private final zzh zzco;
  
  public Circle(zzh paramzzh) {
    this.zzco = (zzh)Preconditions.checkNotNull(paramzzh);
  }
  
  public final boolean equals(Object paramObject) {
    if (!(paramObject instanceof Circle))
      return false; 
    try {
      return this.zzco.zzb(((Circle)paramObject).zzco);
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final LatLng getCenter() {
    try {
      return this.zzco.getCenter();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final int getFillColor() {
    try {
      return this.zzco.getFillColor();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final String getId() {
    try {
      return this.zzco.getId();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final double getRadius() {
    try {
      return this.zzco.getRadius();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final int getStrokeColor() {
    try {
      return this.zzco.getStrokeColor();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final List<PatternItem> getStrokePattern() {
    try {
      return PatternItem.zza(this.zzco.getStrokePattern());
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final float getStrokeWidth() {
    try {
      return this.zzco.getStrokeWidth();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final Object getTag() {
    try {
      return ObjectWrapper.unwrap(this.zzco.zzk());
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final float getZIndex() {
    try {
      return this.zzco.getZIndex();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final int hashCode() {
    try {
      return this.zzco.zzj();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final boolean isClickable() {
    try {
      return this.zzco.isClickable();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final boolean isVisible() {
    try {
      return this.zzco.isVisible();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void remove() {
    try {
      this.zzco.remove();
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setCenter(LatLng paramLatLng) {
    try {
      this.zzco.setCenter(paramLatLng);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setClickable(boolean paramBoolean) {
    try {
      this.zzco.setClickable(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setFillColor(int paramInt) {
    try {
      this.zzco.setFillColor(paramInt);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setRadius(double paramDouble) {
    try {
      this.zzco.setRadius(paramDouble);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setStrokeColor(int paramInt) {
    try {
      this.zzco.setStrokeColor(paramInt);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setStrokePattern(List<PatternItem> paramList) {
    try {
      this.zzco.setStrokePattern(paramList);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setStrokeWidth(float paramFloat) {
    try {
      this.zzco.setStrokeWidth(paramFloat);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setTag(Object paramObject) {
    try {
      this.zzco.zze(ObjectWrapper.wrap(paramObject));
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setVisible(boolean paramBoolean) {
    try {
      this.zzco.setVisible(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setZIndex(float paramFloat) {
    try {
      this.zzco.setZIndex(paramFloat);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\model\Circle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */