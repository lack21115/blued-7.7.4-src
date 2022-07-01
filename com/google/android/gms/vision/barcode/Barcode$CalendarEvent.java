package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

public class Barcode$CalendarEvent extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zze();
  
  private String description;
  
  private Barcode$CalendarDateTime end;
  
  private String location;
  
  private String organizer;
  
  private Barcode$CalendarDateTime start;
  
  private String status;
  
  private String summary;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public Barcode$CalendarEvent() {}
  
  public Barcode$CalendarEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Barcode$CalendarDateTime paramBarcode$CalendarDateTime1, Barcode$CalendarDateTime paramBarcode$CalendarDateTime2) {
    this.summary = paramString1;
    this.description = paramString2;
    this.location = paramString3;
    this.organizer = paramString4;
    this.status = paramString5;
    this.start = paramBarcode$CalendarDateTime1;
    this.end = paramBarcode$CalendarDateTime2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zza(paramParcel, 2, this.summary, false);
    zzbgo.zza(paramParcel, 3, this.description, false);
    zzbgo.zza(paramParcel, 4, this.location, false);
    zzbgo.zza(paramParcel, 5, this.organizer, false);
    zzbgo.zza(paramParcel, 6, this.status, false);
    zzbgo.zza(paramParcel, 7, (Parcelable)this.start, paramInt, false);
    zzbgo.zza(paramParcel, 8, (Parcelable)this.end, paramInt, false);
    zzbgo.zzah(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\barcode\Barcode$CalendarEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */