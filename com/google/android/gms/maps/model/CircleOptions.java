package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

public final class CircleOptions extends AbstractSafeParcelable {
  public static final Parcelable.Creator<CircleOptions> CREATOR = new zzc();
  
  private int fillColor = 0;
  
  private int strokeColor = -16777216;
  
  private LatLng zzcp = null;
  
  private double zzcq = 0.0D;
  
  private float zzcr = 10.0F;
  
  private float zzcs = 0.0F;
  
  private boolean zzct = true;
  
  private boolean zzcu = false;
  
  private List<PatternItem> zzcv = null;
  
  public CircleOptions() {}
  
  CircleOptions(LatLng paramLatLng, double paramDouble, float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, List<PatternItem> paramList) {
    this.zzcp = paramLatLng;
    this.zzcq = paramDouble;
    this.zzcr = paramFloat1;
    this.strokeColor = paramInt1;
    this.fillColor = paramInt2;
    this.zzcs = paramFloat2;
    this.zzct = paramBoolean1;
    this.zzcu = paramBoolean2;
    this.zzcv = paramList;
  }
  
  public final CircleOptions center(LatLng paramLatLng) {
    this.zzcp = paramLatLng;
    return this;
  }
  
  public final CircleOptions clickable(boolean paramBoolean) {
    this.zzcu = paramBoolean;
    return this;
  }
  
  public final CircleOptions fillColor(int paramInt) {
    this.fillColor = paramInt;
    return this;
  }
  
  public final LatLng getCenter() {
    return this.zzcp;
  }
  
  public final int getFillColor() {
    return this.fillColor;
  }
  
  public final double getRadius() {
    return this.zzcq;
  }
  
  public final int getStrokeColor() {
    return this.strokeColor;
  }
  
  public final List<PatternItem> getStrokePattern() {
    return this.zzcv;
  }
  
  public final float getStrokeWidth() {
    return this.zzcr;
  }
  
  public final float getZIndex() {
    return this.zzcs;
  }
  
  public final boolean isClickable() {
    return this.zzcu;
  }
  
  public final boolean isVisible() {
    return this.zzct;
  }
  
  public final CircleOptions radius(double paramDouble) {
    this.zzcq = paramDouble;
    return this;
  }
  
  public final CircleOptions strokeColor(int paramInt) {
    this.strokeColor = paramInt;
    return this;
  }
  
  public final CircleOptions strokePattern(List<PatternItem> paramList) {
    this.zzcv = paramList;
    return this;
  }
  
  public final CircleOptions strokeWidth(float paramFloat) {
    this.zzcr = paramFloat;
    return this;
  }
  
  public final CircleOptions visible(boolean paramBoolean) {
    this.zzct = paramBoolean;
    return this;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, (Parcelable)getCenter(), paramInt, false);
    SafeParcelWriter.writeDouble(paramParcel, 3, getRadius());
    SafeParcelWriter.writeFloat(paramParcel, 4, getStrokeWidth());
    SafeParcelWriter.writeInt(paramParcel, 5, getStrokeColor());
    SafeParcelWriter.writeInt(paramParcel, 6, getFillColor());
    SafeParcelWriter.writeFloat(paramParcel, 7, getZIndex());
    SafeParcelWriter.writeBoolean(paramParcel, 8, isVisible());
    SafeParcelWriter.writeBoolean(paramParcel, 9, isClickable());
    SafeParcelWriter.writeTypedList(paramParcel, 10, getStrokePattern(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final CircleOptions zIndex(float paramFloat) {
    this.zzcs = paramFloat;
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\model\CircleOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */