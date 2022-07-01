package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.zzbh;
import com.google.android.gms.maps.internal.zzbj;
import com.google.android.gms.maps.internal.zzbl;
import com.google.android.gms.maps.internal.zzbn;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.StreetViewSource;

public class StreetViewPanorama {
  private final IStreetViewPanoramaDelegate zzbo;
  
  public StreetViewPanorama(IStreetViewPanoramaDelegate paramIStreetViewPanoramaDelegate) {
    this.zzbo = (IStreetViewPanoramaDelegate)Preconditions.checkNotNull(paramIStreetViewPanoramaDelegate, "delegate");
  }
  
  public void animateTo(StreetViewPanoramaCamera paramStreetViewPanoramaCamera, long paramLong) {
    try {
      this.zzbo.animateTo(paramStreetViewPanoramaCamera, paramLong);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public StreetViewPanoramaLocation getLocation() {
    try {
      return this.zzbo.getStreetViewPanoramaLocation();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public StreetViewPanoramaCamera getPanoramaCamera() {
    try {
      return this.zzbo.getPanoramaCamera();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public boolean isPanningGesturesEnabled() {
    try {
      return this.zzbo.isPanningGesturesEnabled();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public boolean isStreetNamesEnabled() {
    try {
      return this.zzbo.isStreetNamesEnabled();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public boolean isUserNavigationEnabled() {
    try {
      return this.zzbo.isUserNavigationEnabled();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public boolean isZoomGesturesEnabled() {
    try {
      return this.zzbo.isZoomGesturesEnabled();
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public Point orientationToPoint(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation) {
    try {
      IObjectWrapper iObjectWrapper = this.zzbo.orientationToPoint(paramStreetViewPanoramaOrientation);
      return (iObjectWrapper == null) ? null : (Point)ObjectWrapper.unwrap(iObjectWrapper);
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public StreetViewPanoramaOrientation pointToOrientation(Point paramPoint) {
    try {
      return this.zzbo.pointToOrientation(ObjectWrapper.wrap(paramPoint));
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setOnStreetViewPanoramaCameraChangeListener(OnStreetViewPanoramaCameraChangeListener paramOnStreetViewPanoramaCameraChangeListener) {
    if (paramOnStreetViewPanoramaCameraChangeListener == null)
      try {
        this.zzbo.setOnStreetViewPanoramaCameraChangeListener(null);
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      }  
    this.zzbo.setOnStreetViewPanoramaCameraChangeListener((zzbh)new zzae(this, (OnStreetViewPanoramaCameraChangeListener)remoteException));
  }
  
  public final void setOnStreetViewPanoramaChangeListener(OnStreetViewPanoramaChangeListener paramOnStreetViewPanoramaChangeListener) {
    if (paramOnStreetViewPanoramaChangeListener == null)
      try {
        this.zzbo.setOnStreetViewPanoramaChangeListener(null);
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      }  
    this.zzbo.setOnStreetViewPanoramaChangeListener((zzbj)new zzad(this, (OnStreetViewPanoramaChangeListener)remoteException));
  }
  
  public final void setOnStreetViewPanoramaClickListener(OnStreetViewPanoramaClickListener paramOnStreetViewPanoramaClickListener) {
    if (paramOnStreetViewPanoramaClickListener == null)
      try {
        this.zzbo.setOnStreetViewPanoramaClickListener(null);
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      }  
    this.zzbo.setOnStreetViewPanoramaClickListener((zzbl)new zzaf(this, (OnStreetViewPanoramaClickListener)remoteException));
  }
  
  public final void setOnStreetViewPanoramaLongClickListener(OnStreetViewPanoramaLongClickListener paramOnStreetViewPanoramaLongClickListener) {
    if (paramOnStreetViewPanoramaLongClickListener == null)
      try {
        this.zzbo.setOnStreetViewPanoramaLongClickListener(null);
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      }  
    this.zzbo.setOnStreetViewPanoramaLongClickListener((zzbn)new zzag(this, (OnStreetViewPanoramaLongClickListener)remoteException));
  }
  
  public void setPanningGesturesEnabled(boolean paramBoolean) {
    try {
      this.zzbo.enablePanning(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setPosition(LatLng paramLatLng) {
    try {
      this.zzbo.setPosition(paramLatLng);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setPosition(LatLng paramLatLng, int paramInt) {
    try {
      this.zzbo.setPositionWithRadius(paramLatLng, paramInt);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setPosition(LatLng paramLatLng, int paramInt, StreetViewSource paramStreetViewSource) {
    try {
      this.zzbo.setPositionWithRadiusAndSource(paramLatLng, paramInt, paramStreetViewSource);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setPosition(LatLng paramLatLng, StreetViewSource paramStreetViewSource) {
    try {
      this.zzbo.setPositionWithSource(paramLatLng, paramStreetViewSource);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setPosition(String paramString) {
    try {
      this.zzbo.setPositionWithID(paramString);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setStreetNamesEnabled(boolean paramBoolean) {
    try {
      this.zzbo.enableStreetNames(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setUserNavigationEnabled(boolean paramBoolean) {
    try {
      this.zzbo.enableUserNavigation(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public void setZoomGesturesEnabled(boolean paramBoolean) {
    try {
      this.zzbo.enableZoom(paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public static interface OnStreetViewPanoramaCameraChangeListener {
    void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera param1StreetViewPanoramaCamera);
  }
  
  public static interface OnStreetViewPanoramaChangeListener {
    void onStreetViewPanoramaChange(StreetViewPanoramaLocation param1StreetViewPanoramaLocation);
  }
  
  public static interface OnStreetViewPanoramaClickListener {
    void onStreetViewPanoramaClick(StreetViewPanoramaOrientation param1StreetViewPanoramaOrientation);
  }
  
  public static interface OnStreetViewPanoramaLongClickListener {
    void onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation param1StreetViewPanoramaOrientation);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\StreetViewPanorama.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */