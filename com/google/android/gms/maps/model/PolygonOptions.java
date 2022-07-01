package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolygonOptions extends AbstractSafeParcelable {
  public static final Parcelable.Creator<PolygonOptions> CREATOR = new zzk();
  
  private int fillColor = 0;
  
  private int strokeColor = -16777216;
  
  private float zzcr = 10.0F;
  
  private float zzcs = 0.0F;
  
  private boolean zzct = true;
  
  private boolean zzcu = false;
  
  private List<PatternItem> zzcv = null;
  
  private final List<LatLng> zzdx = new ArrayList<LatLng>();
  
  private final List<List<LatLng>> zzdy = new ArrayList<List<LatLng>>();
  
  private boolean zzdz = false;
  
  private int zzea = 0;
  
  public PolygonOptions() {}
  
  PolygonOptions(List<LatLng> paramList, List<List<LatLng>> paramList1, float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt3, List<PatternItem> paramList2) {
    this.zzcr = paramFloat1;
    this.strokeColor = paramInt1;
    this.fillColor = paramInt2;
    this.zzcs = paramFloat2;
    this.zzct = paramBoolean1;
    this.zzdz = paramBoolean2;
    this.zzcu = paramBoolean3;
    this.zzea = paramInt3;
    this.zzcv = paramList2;
  }
  
  public final PolygonOptions add(LatLng paramLatLng) {
    this.zzdx.add(paramLatLng);
    return this;
  }
  
  public final PolygonOptions add(LatLng... paramVarArgs) {
    this.zzdx.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public final PolygonOptions addAll(Iterable<LatLng> paramIterable) {
    for (LatLng latLng : paramIterable)
      this.zzdx.add(latLng); 
    return this;
  }
  
  public final PolygonOptions addHole(Iterable<LatLng> paramIterable) {
    ArrayList<LatLng> arrayList = new ArrayList();
    Iterator<LatLng> iterator = paramIterable.iterator();
    while (iterator.hasNext())
      arrayList.add(iterator.next()); 
    this.zzdy.add(arrayList);
    return this;
  }
  
  public final PolygonOptions clickable(boolean paramBoolean) {
    this.zzcu = paramBoolean;
    return this;
  }
  
  public final PolygonOptions fillColor(int paramInt) {
    this.fillColor = paramInt;
    return this;
  }
  
  public final PolygonOptions geodesic(boolean paramBoolean) {
    this.zzdz = paramBoolean;
    return this;
  }
  
  public final int getFillColor() {
    return this.fillColor;
  }
  
  public final List<List<LatLng>> getHoles() {
    return this.zzdy;
  }
  
  public final List<LatLng> getPoints() {
    return this.zzdx;
  }
  
  public final int getStrokeColor() {
    return this.strokeColor;
  }
  
  public final int getStrokeJointType() {
    return this.zzea;
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
  
  public final boolean isGeodesic() {
    return this.zzdz;
  }
  
  public final boolean isVisible() {
    return this.zzct;
  }
  
  public final PolygonOptions strokeColor(int paramInt) {
    this.strokeColor = paramInt;
    return this;
  }
  
  public final PolygonOptions strokeJointType(int paramInt) {
    this.zzea = paramInt;
    return this;
  }
  
  public final PolygonOptions strokePattern(List<PatternItem> paramList) {
    this.zzcv = paramList;
    return this;
  }
  
  public final PolygonOptions strokeWidth(float paramFloat) {
    this.zzcr = paramFloat;
    return this;
  }
  
  public final PolygonOptions visible(boolean paramBoolean) {
    this.zzct = paramBoolean;
    return this;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 2, getPoints(), false);
    SafeParcelWriter.writeList(paramParcel, 3, this.zzdy, false);
    SafeParcelWriter.writeFloat(paramParcel, 4, getStrokeWidth());
    SafeParcelWriter.writeInt(paramParcel, 5, getStrokeColor());
    SafeParcelWriter.writeInt(paramParcel, 6, getFillColor());
    SafeParcelWriter.writeFloat(paramParcel, 7, getZIndex());
    SafeParcelWriter.writeBoolean(paramParcel, 8, isVisible());
    SafeParcelWriter.writeBoolean(paramParcel, 9, isGeodesic());
    SafeParcelWriter.writeBoolean(paramParcel, 10, isClickable());
    SafeParcelWriter.writeInt(paramParcel, 11, getStrokeJointType());
    SafeParcelWriter.writeTypedList(paramParcel, 12, getStrokePattern(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final PolygonOptions zIndex(float paramFloat) {
    this.zzcs = paramFloat;
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\model\PolygonOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */