package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

public class Barcode$GeoPoint extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzi();
  
  private double lat;
  
  private double lng;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public Barcode$GeoPoint() {}
  
  public Barcode$GeoPoint(double paramDouble1, double paramDouble2) {
    this.lat = paramDouble1;
    this.lng = paramDouble2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zza(paramParcel, 2, this.lat);
    zzbgo.zza(paramParcel, 3, this.lng);
    zzbgo.zzah(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\barcode\Barcode$GeoPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */