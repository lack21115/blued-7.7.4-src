package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class MarkerOptions extends AbstractSafeParcelable {
  public static final Parcelable.Creator<MarkerOptions> CREATOR = new zzh();
  
  private float alpha = 1.0F;
  
  private LatLng position;
  
  private float zzcs;
  
  private boolean zzct = true;
  
  private float zzdb = 0.5F;
  
  private float zzdc = 1.0F;
  
  private String zzdn;
  
  private String zzdo;
  
  private BitmapDescriptor zzdp;
  
  private boolean zzdq;
  
  private boolean zzdr = false;
  
  private float zzds = 0.0F;
  
  private float zzdt = 0.5F;
  
  private float zzdu = 0.0F;
  
  public MarkerOptions() {}
  
  MarkerOptions(LatLng paramLatLng, String paramString1, String paramString2, IBinder paramIBinder, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7) {
    this.position = paramLatLng;
    this.zzdn = paramString1;
    this.zzdo = paramString2;
    if (paramIBinder == null) {
      this.zzdp = null;
    } else {
      this.zzdp = new BitmapDescriptor(IObjectWrapper.Stub.asInterface(paramIBinder));
    } 
    this.zzdb = paramFloat1;
    this.zzdc = paramFloat2;
    this.zzdq = paramBoolean1;
    this.zzct = paramBoolean2;
    this.zzdr = paramBoolean3;
    this.zzds = paramFloat3;
    this.zzdt = paramFloat4;
    this.zzdu = paramFloat5;
    this.alpha = paramFloat6;
    this.zzcs = paramFloat7;
  }
  
  public final MarkerOptions alpha(float paramFloat) {
    this.alpha = paramFloat;
    return this;
  }
  
  public final MarkerOptions anchor(float paramFloat1, float paramFloat2) {
    this.zzdb = paramFloat1;
    this.zzdc = paramFloat2;
    return this;
  }
  
  public final MarkerOptions draggable(boolean paramBoolean) {
    this.zzdq = paramBoolean;
    return this;
  }
  
  public final MarkerOptions flat(boolean paramBoolean) {
    this.zzdr = paramBoolean;
    return this;
  }
  
  public final float getAlpha() {
    return this.alpha;
  }
  
  public final float getAnchorU() {
    return this.zzdb;
  }
  
  public final float getAnchorV() {
    return this.zzdc;
  }
  
  public final BitmapDescriptor getIcon() {
    return this.zzdp;
  }
  
  public final float getInfoWindowAnchorU() {
    return this.zzdt;
  }
  
  public final float getInfoWindowAnchorV() {
    return this.zzdu;
  }
  
  public final LatLng getPosition() {
    return this.position;
  }
  
  public final float getRotation() {
    return this.zzds;
  }
  
  public final String getSnippet() {
    return this.zzdo;
  }
  
  public final String getTitle() {
    return this.zzdn;
  }
  
  public final float getZIndex() {
    return this.zzcs;
  }
  
  public final MarkerOptions icon(BitmapDescriptor paramBitmapDescriptor) {
    this.zzdp = paramBitmapDescriptor;
    return this;
  }
  
  public final MarkerOptions infoWindowAnchor(float paramFloat1, float paramFloat2) {
    this.zzdt = paramFloat1;
    this.zzdu = paramFloat2;
    return this;
  }
  
  public final boolean isDraggable() {
    return this.zzdq;
  }
  
  public final boolean isFlat() {
    return this.zzdr;
  }
  
  public final boolean isVisible() {
    return this.zzct;
  }
  
  public final MarkerOptions position(LatLng paramLatLng) {
    if (paramLatLng != null) {
      this.position = paramLatLng;
      return this;
    } 
    throw new IllegalArgumentException("latlng cannot be null - a position is required.");
  }
  
  public final MarkerOptions rotation(float paramFloat) {
    this.zzds = paramFloat;
    return this;
  }
  
  public final MarkerOptions snippet(String paramString) {
    this.zzdo = paramString;
    return this;
  }
  
  public final MarkerOptions title(String paramString) {
    this.zzdn = paramString;
    return this;
  }
  
  public final MarkerOptions visible(boolean paramBoolean) {
    this.zzct = paramBoolean;
    return this;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    IBinder iBinder;
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, (Parcelable)getPosition(), paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 3, getTitle(), false);
    SafeParcelWriter.writeString(paramParcel, 4, getSnippet(), false);
    BitmapDescriptor bitmapDescriptor = this.zzdp;
    if (bitmapDescriptor == null) {
      bitmapDescriptor = null;
    } else {
      iBinder = bitmapDescriptor.zzb().asBinder();
    } 
    SafeParcelWriter.writeIBinder(paramParcel, 5, iBinder, false);
    SafeParcelWriter.writeFloat(paramParcel, 6, getAnchorU());
    SafeParcelWriter.writeFloat(paramParcel, 7, getAnchorV());
    SafeParcelWriter.writeBoolean(paramParcel, 8, isDraggable());
    SafeParcelWriter.writeBoolean(paramParcel, 9, isVisible());
    SafeParcelWriter.writeBoolean(paramParcel, 10, isFlat());
    SafeParcelWriter.writeFloat(paramParcel, 11, getRotation());
    SafeParcelWriter.writeFloat(paramParcel, 12, getInfoWindowAnchorU());
    SafeParcelWriter.writeFloat(paramParcel, 13, getInfoWindowAnchorV());
    SafeParcelWriter.writeFloat(paramParcel, 14, getAlpha());
    SafeParcelWriter.writeFloat(paramParcel, 15, getZIndex());
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final MarkerOptions zIndex(float paramFloat) {
    this.zzcs = paramFloat;
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\model\MarkerOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */