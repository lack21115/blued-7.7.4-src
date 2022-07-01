package com.google.android.gms.maps.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.maps.GoogleMapOptions;

public final class LatLngBounds extends AbstractSafeParcelable implements ReflectedParcelable {
  public static final Parcelable.Creator<LatLngBounds> CREATOR = new zze();
  
  public final LatLng northeast;
  
  public final LatLng southwest;
  
  public LatLngBounds(LatLng paramLatLng1, LatLng paramLatLng2) {
    boolean bool;
    Preconditions.checkNotNull(paramLatLng1, "null southwest");
    Preconditions.checkNotNull(paramLatLng2, "null northeast");
    if (paramLatLng2.latitude >= paramLatLng1.latitude) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "southern latitude exceeds northern latitude (%s > %s)", new Object[] { Double.valueOf(paramLatLng1.latitude), Double.valueOf(paramLatLng2.latitude) });
    this.southwest = paramLatLng1;
    this.northeast = paramLatLng2;
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public static LatLngBounds createFromAttributes(Context paramContext, AttributeSet paramAttributeSet) {
    return GoogleMapOptions.zza(paramContext, paramAttributeSet);
  }
  
  private static double zza(double paramDouble1, double paramDouble2) {
    return (paramDouble1 - paramDouble2 + 360.0D) % 360.0D;
  }
  
  private final boolean zza(double paramDouble) {
    return (this.southwest.longitude <= this.northeast.longitude) ? ((this.southwest.longitude <= paramDouble && paramDouble <= this.northeast.longitude)) : ((this.southwest.longitude > paramDouble) ? ((paramDouble <= this.northeast.longitude)) : true);
  }
  
  private static double zzb(double paramDouble1, double paramDouble2) {
    return (paramDouble2 - paramDouble1 + 360.0D) % 360.0D;
  }
  
  public final boolean contains(LatLng paramLatLng) {
    boolean bool;
    double d = paramLatLng.latitude;
    if (this.southwest.latitude <= d && d <= this.northeast.latitude) {
      bool = true;
    } else {
      bool = false;
    } 
    return (bool && zza(paramLatLng.longitude));
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof LatLngBounds))
      return false; 
    paramObject = paramObject;
    return (this.southwest.equals(((LatLngBounds)paramObject).southwest) && this.northeast.equals(((LatLngBounds)paramObject).northeast));
  }
  
  public final LatLng getCenter() {
    double d2 = (this.southwest.latitude + this.northeast.latitude) / 2.0D;
    double d1 = this.northeast.longitude;
    double d3 = this.southwest.longitude;
    if (d3 > d1)
      d1 += 360.0D; 
    return new LatLng(d2, (d1 + d3) / 2.0D);
  }
  
  public final int hashCode() {
    return Objects.hashCode(new Object[] { this.southwest, this.northeast });
  }
  
  public final LatLngBounds including(LatLng paramLatLng) {
    double d6 = Math.min(this.southwest.latitude, paramLatLng.latitude);
    double d7 = Math.max(this.northeast.latitude, paramLatLng.latitude);
    double d4 = this.northeast.longitude;
    double d5 = this.southwest.longitude;
    double d3 = paramLatLng.longitude;
    double d1 = d4;
    double d2 = d5;
    if (!zza(d3))
      if (zza(d5, d3) < zzb(d4, d3)) {
        d2 = d3;
        d1 = d4;
      } else {
        d1 = d3;
        d2 = d5;
      }  
    return new LatLngBounds(new LatLng(d6, d2), new LatLng(d7, d1));
  }
  
  public final String toString() {
    return Objects.toStringHelper(this).add("southwest", this.southwest).add("northeast", this.northeast).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, (Parcelable)this.southwest, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, (Parcelable)this.northeast, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public static final class Builder {
    private double zzdh = Double.POSITIVE_INFINITY;
    
    private double zzdi = Double.NEGATIVE_INFINITY;
    
    private double zzdj = Double.NaN;
    
    private double zzdk = Double.NaN;
    
    public final LatLngBounds build() {
      Preconditions.checkState(Double.isNaN(this.zzdj) ^ true, "no included points");
      return new LatLngBounds(new LatLng(this.zzdh, this.zzdj), new LatLng(this.zzdi, this.zzdk));
    }
    
    public final Builder include(LatLng param1LatLng) {
      // Byte code:
      //   0: aload_0
      //   1: aload_0
      //   2: getfield zzdh : D
      //   5: aload_1
      //   6: getfield latitude : D
      //   9: invokestatic min : (DD)D
      //   12: putfield zzdh : D
      //   15: aload_0
      //   16: aload_0
      //   17: getfield zzdi : D
      //   20: aload_1
      //   21: getfield latitude : D
      //   24: invokestatic max : (DD)D
      //   27: putfield zzdi : D
      //   30: aload_1
      //   31: getfield longitude : D
      //   34: dstore_2
      //   35: aload_0
      //   36: getfield zzdj : D
      //   39: invokestatic isNaN : (D)Z
      //   42: ifeq -> 53
      //   45: aload_0
      //   46: dload_2
      //   47: putfield zzdj : D
      //   50: goto -> 154
      //   53: aload_0
      //   54: getfield zzdj : D
      //   57: dstore #4
      //   59: aload_0
      //   60: getfield zzdk : D
      //   63: dstore #6
      //   65: iconst_0
      //   66: istore #9
      //   68: dload #4
      //   70: dload #6
      //   72: dcmpg
      //   73: ifgt -> 101
      //   76: iload #9
      //   78: istore #8
      //   80: dload #4
      //   82: dload_2
      //   83: dcmpg
      //   84: ifgt -> 122
      //   87: iload #9
      //   89: istore #8
      //   91: dload_2
      //   92: dload #6
      //   94: dcmpg
      //   95: ifgt -> 122
      //   98: goto -> 119
      //   101: dload #4
      //   103: dload_2
      //   104: dcmpg
      //   105: ifle -> 119
      //   108: iload #9
      //   110: istore #8
      //   112: dload_2
      //   113: dload #6
      //   115: dcmpg
      //   116: ifgt -> 122
      //   119: iconst_1
      //   120: istore #8
      //   122: iload #8
      //   124: ifne -> 159
      //   127: aload_0
      //   128: getfield zzdj : D
      //   131: dload_2
      //   132: invokestatic zzc : (DD)D
      //   135: aload_0
      //   136: getfield zzdk : D
      //   139: dload_2
      //   140: invokestatic zzd : (DD)D
      //   143: dcmpg
      //   144: ifge -> 154
      //   147: aload_0
      //   148: dload_2
      //   149: putfield zzdj : D
      //   152: aload_0
      //   153: areturn
      //   154: aload_0
      //   155: dload_2
      //   156: putfield zzdk : D
      //   159: aload_0
      //   160: areturn
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\model\LatLngBounds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */