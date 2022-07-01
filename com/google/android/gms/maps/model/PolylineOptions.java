package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolylineOptions extends AbstractSafeParcelable {
  public static final Parcelable.Creator<PolylineOptions> CREATOR = new zzl();
  
  private int color = -16777216;
  
  private float width = 10.0F;
  
  private float zzcs = 0.0F;
  
  private boolean zzct = true;
  
  private boolean zzcu = false;
  
  private final List<LatLng> zzdx = new ArrayList<LatLng>();
  
  private boolean zzdz = false;
  
  private Cap zzec = new ButtCap();
  
  private Cap zzed = new ButtCap();
  
  private int zzee = 0;
  
  private List<PatternItem> zzef = null;
  
  public PolylineOptions() {}
  
  PolylineOptions(List<LatLng> paramList, float paramFloat1, int paramInt1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Cap paramCap1, Cap paramCap2, int paramInt2, List<PatternItem> paramList1) {
    this.width = paramFloat1;
    this.color = paramInt1;
    this.zzcs = paramFloat2;
    this.zzct = paramBoolean1;
    this.zzdz = paramBoolean2;
    this.zzcu = paramBoolean3;
    if (paramCap1 != null)
      this.zzec = paramCap1; 
    if (paramCap2 != null)
      this.zzed = paramCap2; 
    this.zzee = paramInt2;
    this.zzef = paramList1;
  }
  
  public final PolylineOptions add(LatLng paramLatLng) {
    this.zzdx.add(paramLatLng);
    return this;
  }
  
  public final PolylineOptions add(LatLng... paramVarArgs) {
    this.zzdx.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public final PolylineOptions addAll(Iterable<LatLng> paramIterable) {
    for (LatLng latLng : paramIterable)
      this.zzdx.add(latLng); 
    return this;
  }
  
  public final PolylineOptions clickable(boolean paramBoolean) {
    this.zzcu = paramBoolean;
    return this;
  }
  
  public final PolylineOptions color(int paramInt) {
    this.color = paramInt;
    return this;
  }
  
  public final PolylineOptions endCap(Cap paramCap) {
    this.zzed = (Cap)Preconditions.checkNotNull(paramCap, "endCap must not be null");
    return this;
  }
  
  public final PolylineOptions geodesic(boolean paramBoolean) {
    this.zzdz = paramBoolean;
    return this;
  }
  
  public final int getColor() {
    return this.color;
  }
  
  public final Cap getEndCap() {
    return this.zzed;
  }
  
  public final int getJointType() {
    return this.zzee;
  }
  
  public final List<PatternItem> getPattern() {
    return this.zzef;
  }
  
  public final List<LatLng> getPoints() {
    return this.zzdx;
  }
  
  public final Cap getStartCap() {
    return this.zzec;
  }
  
  public final float getWidth() {
    return this.width;
  }
  
  public final float getZIndex() {
    return this.zzcs;
  }
  
  public final boolean isClickable() {
    return this.zzcu;
  }
  
  public final boolean isGeodesic() {
    return this.zzdz;
  }
  
  public final boolean isVisible() {
    return this.zzct;
  }
  
  public final PolylineOptions jointType(int paramInt) {
    this.zzee = paramInt;
    return this;
  }
  
  public final PolylineOptions pattern(List<PatternItem> paramList) {
    this.zzef = paramList;
    return this;
  }
  
  public final PolylineOptions startCap(Cap paramCap) {
    this.zzec = (Cap)Preconditions.checkNotNull(paramCap, "startCap must not be null");
    return this;
  }
  
  public final PolylineOptions visible(boolean paramBoolean) {
    this.zzct = paramBoolean;
    return this;
  }
  
  public final PolylineOptions width(float paramFloat) {
    this.width = paramFloat;
    return this;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 2, getPoints(), false);
    SafeParcelWriter.writeFloat(paramParcel, 3, getWidth());
    SafeParcelWriter.writeInt(paramParcel, 4, getColor());
    SafeParcelWriter.writeFloat(paramParcel, 5, getZIndex());
    SafeParcelWriter.writeBoolean(paramParcel, 6, isVisible());
    SafeParcelWriter.writeBoolean(paramParcel, 7, isGeodesic());
    SafeParcelWriter.writeBoolean(paramParcel, 8, isClickable());
    SafeParcelWriter.writeParcelable(paramParcel, 9, (Parcelable)getStartCap(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 10, (Parcelable)getEndCap(), paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 11, getJointType());
    SafeParcelWriter.writeTypedList(paramParcel, 12, getPattern(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final PolylineOptions zIndex(float paramFloat) {
    this.zzcs = paramFloat;
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\model\PolylineOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */