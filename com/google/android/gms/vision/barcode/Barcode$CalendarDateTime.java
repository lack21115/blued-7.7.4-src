package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

public class Barcode$CalendarDateTime extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzd();
  
  private int day;
  
  private int hours;
  
  private boolean isUtc;
  
  private int minutes;
  
  private int month;
  
  private String rawValue;
  
  private int seconds;
  
  private int year;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public Barcode$CalendarDateTime() {}
  
  public Barcode$CalendarDateTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, String paramString) {
    this.year = paramInt1;
    this.month = paramInt2;
    this.day = paramInt3;
    this.hours = paramInt4;
    this.minutes = paramInt5;
    this.seconds = paramInt6;
    this.isUtc = paramBoolean;
    this.rawValue = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zzc(paramParcel, 2, this.year);
    zzbgo.zzc(paramParcel, 3, this.month);
    zzbgo.zzc(paramParcel, 4, this.day);
    zzbgo.zzc(paramParcel, 5, this.hours);
    zzbgo.zzc(paramParcel, 6, this.minutes);
    zzbgo.zzc(paramParcel, 7, this.seconds);
    zzbgo.zza(paramParcel, 8, this.isUtc);
    zzbgo.zza(paramParcel, 9, this.rawValue, false);
    zzbgo.zzah(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\barcode\Barcode$CalendarDateTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */