package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class GroundOverlayOptions extends AbstractSafeParcelable {
  public static final Parcelable.Creator<GroundOverlayOptions> CREATOR = new zzd();
  
  public static final float NO_DIMENSION = -1.0F;
  
  private float bearing;
  
  private float height;
  
  private float width;
  
  private float zzcs;
  
  private boolean zzct = true;
  
  private boolean zzcu = false;
  
  private BitmapDescriptor zzcx;
  
  private LatLng zzcy;
  
  private LatLngBounds zzcz;
  
  private float zzda = 0.0F;
  
  private float zzdb = 0.5F;
  
  private float zzdc = 0.5F;
  
  public GroundOverlayOptions() {}
  
  GroundOverlayOptions(IBinder paramIBinder, LatLng paramLatLng, float paramFloat1, float paramFloat2, LatLngBounds paramLatLngBounds, float paramFloat3, float paramFloat4, boolean paramBoolean1, float paramFloat5, float paramFloat6, float paramFloat7, boolean paramBoolean2) {
    this.zzcx = new BitmapDescriptor(IObjectWrapper.Stub.asInterface(paramIBinder));
    this.zzcy = paramLatLng;
    this.width = paramFloat1;
    this.height = paramFloat2;
    this.zzcz = paramLatLngBounds;
    this.bearing = paramFloat3;
    this.zzcs = paramFloat4;
    this.zzct = paramBoolean1;
    this.zzda = paramFloat5;
    this.zzdb = paramFloat6;
    this.zzdc = paramFloat7;
    this.zzcu = paramBoolean2;
  }
  
  private final GroundOverlayOptions zza(LatLng paramLatLng, float paramFloat1, float paramFloat2) {
    this.zzcy = paramLatLng;
    this.width = paramFloat1;
    this.height = paramFloat2;
    return this;
  }
  
  public final GroundOverlayOptions anchor(float paramFloat1, float paramFloat2) {
    this.zzdb = paramFloat1;
    this.zzdc = paramFloat2;
    return this;
  }
  
  public final GroundOverlayOptions bearing(float paramFloat) {
    this.bearing = (paramFloat % 360.0F + 360.0F) % 360.0F;
    return this;
  }
  
  public final GroundOverlayOptions clickable(boolean paramBoolean) {
    this.zzcu = paramBoolean;
    return this;
  }
  
  public final float getAnchorU() {
    return this.zzdb;
  }
  
  public final float getAnchorV() {
    return this.zzdc;
  }
  
  public final float getBearing() {
    return this.bearing;
  }
  
  public final LatLngBounds getBounds() {
    return this.zzcz;
  }
  
  public final float getHeight() {
    return this.height;
  }
  
  public final BitmapDescriptor getImage() {
    return this.zzcx;
  }
  
  public final LatLng getLocation() {
    return this.zzcy;
  }
  
  public final float getTransparency() {
    return this.zzda;
  }
  
  public final float getWidth() {
    return this.width;
  }
  
  public final float getZIndex() {
    return this.zzcs;
  }
  
  public final GroundOverlayOptions image(BitmapDescriptor paramBitmapDescriptor) {
    Preconditions.checkNotNull(paramBitmapDescriptor, "imageDescriptor must not be null");
    this.zzcx = paramBitmapDescriptor;
    return this;
  }
  
  public final boolean isClickable() {
    return this.zzcu;
  }
  
  public final boolean isVisible() {
    return this.zzct;
  }
  
  public final GroundOverlayOptions position(LatLng paramLatLng, float paramFloat) {
    boolean bool1;
    LatLngBounds latLngBounds = this.zzcz;
    boolean bool2 = true;
    if (latLngBounds == null) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    Preconditions.checkState(bool1, "Position has already been set using positionFromBounds");
    if (paramLatLng != null) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    Preconditions.checkArgument(bool1, "Location must be specified");
    if (paramFloat >= 0.0F) {
      bool1 = bool2;
    } else {
      bool1 = false;
    } 
    Preconditions.checkArgument(bool1, "Width must be non-negative");
    return zza(paramLatLng, paramFloat, -1.0F);
  }
  
  public final GroundOverlayOptions position(LatLng paramLatLng, float paramFloat1, float paramFloat2) {
    boolean bool1;
    LatLngBounds latLngBounds = this.zzcz;
    boolean bool2 = true;
    if (latLngBounds == null) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    Preconditions.checkState(bool1, "Position has already been set using positionFromBounds");
    if (paramLatLng != null) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    Preconditions.checkArgument(bool1, "Location must be specified");
    if (paramFloat1 >= 0.0F) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    Preconditions.checkArgument(bool1, "Width must be non-negative");
    if (paramFloat2 >= 0.0F) {
      bool1 = bool2;
    } else {
      bool1 = false;
    } 
    Preconditions.checkArgument(bool1, "Height must be non-negative");
    return zza(paramLatLng, paramFloat1, paramFloat2);
  }
  
  public final GroundOverlayOptions positionFromBounds(LatLngBounds paramLatLngBounds) {
    boolean bool;
    if (this.zzcy == null) {
      bool = true;
    } else {
      bool = false;
    } 
    String str = String.valueOf(this.zzcy);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 46);
    stringBuilder.append("Position has already been set using position: ");
    stringBuilder.append(str);
    Preconditions.checkState(bool, stringBuilder.toString());
    this.zzcz = paramLatLngBounds;
    return this;
  }
  
  public final GroundOverlayOptions transparency(float paramFloat) {
    boolean bool;
    if (paramFloat >= 0.0F && paramFloat <= 1.0F) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Transparency must be in the range [0..1]");
    this.zzda = paramFloat;
    return this;
  }
  
  public final GroundOverlayOptions visible(boolean paramBoolean) {
    this.zzct = paramBoolean;
    return this;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeIBinder(paramParcel, 2, this.zzcx.zzb().asBinder(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, (Parcelable)getLocation(), paramInt, false);
    SafeParcelWriter.writeFloat(paramParcel, 4, getWidth());
    SafeParcelWriter.writeFloat(paramParcel, 5, getHeight());
    SafeParcelWriter.writeParcelable(paramParcel, 6, (Parcelable)getBounds(), paramInt, false);
    SafeParcelWriter.writeFloat(paramParcel, 7, getBearing());
    SafeParcelWriter.writeFloat(paramParcel, 8, getZIndex());
    SafeParcelWriter.writeBoolean(paramParcel, 9, isVisible());
    SafeParcelWriter.writeFloat(paramParcel, 10, getTransparency());
    SafeParcelWriter.writeFloat(paramParcel, 11, getAnchorU());
    SafeParcelWriter.writeFloat(paramParcel, 12, getAnchorV());
    SafeParcelWriter.writeBoolean(paramParcel, 13, isClickable());
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final GroundOverlayOptions zIndex(float paramFloat) {
    this.zzcs = paramFloat;
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\model\GroundOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */