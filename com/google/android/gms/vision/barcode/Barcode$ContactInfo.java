package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

public class Barcode$ContactInfo extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzf();
  
  private Barcode$Address[] addresses;
  
  private Barcode$Email[] emails;
  
  private Barcode$PersonName name;
  
  private String organization;
  
  private Barcode$Phone[] phones;
  
  private String title;
  
  private String[] urls;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public Barcode$ContactInfo() {}
  
  public Barcode$ContactInfo(Barcode$PersonName paramBarcode$PersonName, String paramString1, String paramString2, Barcode$Phone[] paramArrayOfBarcode$Phone, Barcode$Email[] paramArrayOfBarcode$Email, String[] paramArrayOfString, Barcode$Address[] paramArrayOfBarcode$Address) {
    this.name = paramBarcode$PersonName;
    this.organization = paramString1;
    this.title = paramString2;
    this.phones = paramArrayOfBarcode$Phone;
    this.emails = paramArrayOfBarcode$Email;
    this.urls = paramArrayOfString;
    this.addresses = paramArrayOfBarcode$Address;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zza(paramParcel, 2, (Parcelable)this.name, paramInt, false);
    zzbgo.zza(paramParcel, 3, this.organization, false);
    zzbgo.zza(paramParcel, 4, this.title, false);
    zzbgo.zza$2d7953c6(paramParcel, 5, (Parcelable[])this.phones, paramInt);
    zzbgo.zza$2d7953c6(paramParcel, 6, (Parcelable[])this.emails, paramInt);
    zzbgo.zza$41b439c0(paramParcel, 7, this.urls);
    zzbgo.zza$2d7953c6(paramParcel, 8, (Parcelable[])this.addresses, paramInt);
    zzbgo.zzah(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\barcode\Barcode$ContactInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */