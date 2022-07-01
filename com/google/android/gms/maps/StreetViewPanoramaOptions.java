package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewSource;

public final class StreetViewPanoramaOptions extends AbstractSafeParcelable implements ReflectedParcelable {
  public static final Parcelable.Creator<StreetViewPanoramaOptions> CREATOR = new zzai();
  
  private String panoId;
  
  private LatLng position;
  
  private Boolean zzak;
  
  private Boolean zzap;
  
  private StreetViewPanoramaCamera zzbx;
  
  private Integer zzby;
  
  private Boolean zzbz;
  
  private Boolean zzca;
  
  private Boolean zzcb;
  
  private StreetViewSource zzcc;
  
  public StreetViewPanoramaOptions() {
    Boolean bool = Boolean.valueOf(true);
    this.zzbz = bool;
    this.zzap = bool;
    this.zzca = bool;
    this.zzcb = bool;
    this.zzcc = StreetViewSource.DEFAULT;
  }
  
  StreetViewPanoramaOptions(StreetViewPanoramaCamera paramStreetViewPanoramaCamera, String paramString, LatLng paramLatLng, Integer paramInteger, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, StreetViewSource paramStreetViewSource) {
    Boolean bool = Boolean.valueOf(true);
    this.zzbz = bool;
    this.zzap = bool;
    this.zzca = bool;
    this.zzcb = bool;
    this.zzcc = StreetViewSource.DEFAULT;
    this.zzbx = paramStreetViewPanoramaCamera;
    this.position = paramLatLng;
    this.zzby = paramInteger;
    this.panoId = paramString;
    this.zzbz = zza.zza(paramByte1);
    this.zzap = zza.zza(paramByte2);
    this.zzca = zza.zza(paramByte3);
    this.zzcb = zza.zza(paramByte4);
    this.zzak = zza.zza(paramByte5);
    this.zzcc = paramStreetViewSource;
  }
  
  public final Boolean getPanningGesturesEnabled() {
    return this.zzca;
  }
  
  public final String getPanoramaId() {
    return this.panoId;
  }
  
  public final LatLng getPosition() {
    return this.position;
  }
  
  public final Integer getRadius() {
    return this.zzby;
  }
  
  public final StreetViewSource getSource() {
    return this.zzcc;
  }
  
  public final Boolean getStreetNamesEnabled() {
    return this.zzcb;
  }
  
  public final StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
    return this.zzbx;
  }
  
  public final Boolean getUseViewLifecycleInFragment() {
    return this.zzak;
  }
  
  public final Boolean getUserNavigationEnabled() {
    return this.zzbz;
  }
  
  public final Boolean getZoomGesturesEnabled() {
    return this.zzap;
  }
  
  public final StreetViewPanoramaOptions panningGesturesEnabled(boolean paramBoolean) {
    this.zzca = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public final StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera paramStreetViewPanoramaCamera) {
    this.zzbx = paramStreetViewPanoramaCamera;
    return this;
  }
  
  public final StreetViewPanoramaOptions panoramaId(String paramString) {
    this.panoId = paramString;
    return this;
  }
  
  public final StreetViewPanoramaOptions position(LatLng paramLatLng) {
    this.position = paramLatLng;
    return this;
  }
  
  public final StreetViewPanoramaOptions position(LatLng paramLatLng, StreetViewSource paramStreetViewSource) {
    this.position = paramLatLng;
    this.zzcc = paramStreetViewSource;
    return this;
  }
  
  public final StreetViewPanoramaOptions position(LatLng paramLatLng, Integer paramInteger) {
    this.position = paramLatLng;
    this.zzby = paramInteger;
    return this;
  }
  
  public final StreetViewPanoramaOptions position(LatLng paramLatLng, Integer paramInteger, StreetViewSource paramStreetViewSource) {
    this.position = paramLatLng;
    this.zzby = paramInteger;
    this.zzcc = paramStreetViewSource;
    return this;
  }
  
  public final StreetViewPanoramaOptions streetNamesEnabled(boolean paramBoolean) {
    this.zzcb = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public final String toString() {
    return Objects.toStringHelper(this).add("PanoramaId", this.panoId).add("Position", this.position).add("Radius", this.zzby).add("Source", this.zzcc).add("StreetViewPanoramaCamera", this.zzbx).add("UserNavigationEnabled", this.zzbz).add("ZoomGesturesEnabled", this.zzap).add("PanningGesturesEnabled", this.zzca).add("StreetNamesEnabled", this.zzcb).add("UseViewLifecycleInFragment", this.zzak).toString();
  }
  
  public final StreetViewPanoramaOptions useViewLifecycleInFragment(boolean paramBoolean) {
    this.zzak = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public final StreetViewPanoramaOptions userNavigationEnabled(boolean paramBoolean) {
    this.zzbz = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, (Parcelable)getStreetViewPanoramaCamera(), paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 3, getPanoramaId(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, (Parcelable)getPosition(), paramInt, false);
    SafeParcelWriter.writeIntegerObject(paramParcel, 5, getRadius(), false);
    SafeParcelWriter.writeByte(paramParcel, 6, zza.zza(this.zzbz));
    SafeParcelWriter.writeByte(paramParcel, 7, zza.zza(this.zzap));
    SafeParcelWriter.writeByte(paramParcel, 8, zza.zza(this.zzca));
    SafeParcelWriter.writeByte(paramParcel, 9, zza.zza(this.zzcb));
    SafeParcelWriter.writeByte(paramParcel, 10, zza.zza(this.zzak));
    SafeParcelWriter.writeParcelable(paramParcel, 11, (Parcelable)getSource(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final StreetViewPanoramaOptions zoomGesturesEnabled(boolean paramBoolean) {
    this.zzap = Boolean.valueOf(paramBoolean);
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\StreetViewPanoramaOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */