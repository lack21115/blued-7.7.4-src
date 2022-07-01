package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

public class Barcode$DriverLicense extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzg();
  
  private String addressCity;
  
  private String addressState;
  
  private String addressStreet;
  
  private String addressZip;
  
  private String birthDate;
  
  private String documentType;
  
  private String expiryDate;
  
  private String firstName;
  
  private String gender;
  
  private String issueDate;
  
  private String issuingCountry;
  
  private String lastName;
  
  private String licenseNumber;
  
  private String middleName;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public Barcode$DriverLicense() {}
  
  public Barcode$DriverLicense(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14) {
    this.documentType = paramString1;
    this.firstName = paramString2;
    this.middleName = paramString3;
    this.lastName = paramString4;
    this.gender = paramString5;
    this.addressStreet = paramString6;
    this.addressCity = paramString7;
    this.addressState = paramString8;
    this.addressZip = paramString9;
    this.licenseNumber = paramString10;
    this.issueDate = paramString11;
    this.expiryDate = paramString12;
    this.birthDate = paramString13;
    this.issuingCountry = paramString14;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zza(paramParcel, 2, this.documentType, false);
    zzbgo.zza(paramParcel, 3, this.firstName, false);
    zzbgo.zza(paramParcel, 4, this.middleName, false);
    zzbgo.zza(paramParcel, 5, this.lastName, false);
    zzbgo.zza(paramParcel, 6, this.gender, false);
    zzbgo.zza(paramParcel, 7, this.addressStreet, false);
    zzbgo.zza(paramParcel, 8, this.addressCity, false);
    zzbgo.zza(paramParcel, 9, this.addressState, false);
    zzbgo.zza(paramParcel, 10, this.addressZip, false);
    zzbgo.zza(paramParcel, 11, this.licenseNumber, false);
    zzbgo.zza(paramParcel, 12, this.issueDate, false);
    zzbgo.zza(paramParcel, 13, this.expiryDate, false);
    zzbgo.zza(paramParcel, 14, this.birthDate, false);
    zzbgo.zza(paramParcel, 15, this.issuingCountry, false);
    zzbgo.zzah(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\barcode\Barcode$DriverLicense.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */