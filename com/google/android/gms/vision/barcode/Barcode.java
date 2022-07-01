package com.google.android.gms.vision.barcode;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

public class Barcode extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzb();
  
  private Barcode$CalendarEvent calendarEvent;
  
  private Barcode$ContactInfo contactInfo;
  
  public Point[] cornerPoints;
  
  private String displayValue;
  
  private Barcode$DriverLicense driverLicense;
  
  private Barcode$Email email;
  
  private int format;
  
  private Barcode$GeoPoint geoPoint;
  
  private Barcode$Phone phone;
  
  public String rawValue;
  
  private Barcode$Sms sms;
  
  private Barcode$UrlBookmark url;
  
  private int valueFormat;
  
  private Barcode$WiFi wifi;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public Barcode() {}
  
  public Barcode(int paramInt1, String paramString1, String paramString2, int paramInt2, Point[] paramArrayOfPoint, Barcode$Email paramBarcode$Email, Barcode$Phone paramBarcode$Phone, Barcode$Sms paramBarcode$Sms, Barcode$WiFi paramBarcode$WiFi, Barcode$UrlBookmark paramBarcode$UrlBookmark, Barcode$GeoPoint paramBarcode$GeoPoint, Barcode$CalendarEvent paramBarcode$CalendarEvent, Barcode$ContactInfo paramBarcode$ContactInfo, Barcode$DriverLicense paramBarcode$DriverLicense) {
    this.format = paramInt1;
    this.rawValue = paramString1;
    this.displayValue = paramString2;
    this.valueFormat = paramInt2;
    this.cornerPoints = paramArrayOfPoint;
    this.email = paramBarcode$Email;
    this.phone = paramBarcode$Phone;
    this.sms = paramBarcode$Sms;
    this.wifi = paramBarcode$WiFi;
    this.url = paramBarcode$UrlBookmark;
    this.geoPoint = paramBarcode$GeoPoint;
    this.calendarEvent = paramBarcode$CalendarEvent;
    this.contactInfo = paramBarcode$ContactInfo;
    this.driverLicense = paramBarcode$DriverLicense;
  }
  
  public final Rect getBoundingBox() {
    int m = Integer.MIN_VALUE;
    int n = Integer.MAX_VALUE;
    int j = 0;
    int k = Integer.MAX_VALUE;
    int i = Integer.MIN_VALUE;
    while (j < this.cornerPoints.length) {
      Point point = this.cornerPoints[j];
      n = Math.min(n, point.x);
      m = Math.max(m, point.x);
      k = Math.min(k, point.y);
      i = Math.max(i, point.y);
      j++;
    } 
    return new Rect(n, k, m, i);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zzc(paramParcel, 2, this.format);
    zzbgo.zza(paramParcel, 3, this.rawValue, false);
    zzbgo.zza(paramParcel, 4, this.displayValue, false);
    zzbgo.zzc(paramParcel, 5, this.valueFormat);
    zzbgo.zza$2d7953c6(paramParcel, 6, (Parcelable[])this.cornerPoints, paramInt);
    zzbgo.zza(paramParcel, 7, (Parcelable)this.email, paramInt, false);
    zzbgo.zza(paramParcel, 8, (Parcelable)this.phone, paramInt, false);
    zzbgo.zza(paramParcel, 9, (Parcelable)this.sms, paramInt, false);
    zzbgo.zza(paramParcel, 10, (Parcelable)this.wifi, paramInt, false);
    zzbgo.zza(paramParcel, 11, (Parcelable)this.url, paramInt, false);
    zzbgo.zza(paramParcel, 12, (Parcelable)this.geoPoint, paramInt, false);
    zzbgo.zza(paramParcel, 13, (Parcelable)this.calendarEvent, paramInt, false);
    zzbgo.zza(paramParcel, 14, (Parcelable)this.contactInfo, paramInt, false);
    zzbgo.zza(paramParcel, 15, (Parcelable)this.driverLicense, paramInt, false);
    zzbgo.zzah(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\barcode\Barcode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */