package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

public class Barcode$Sms extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzl();
  
  private String message;
  
  private String phoneNumber;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public Barcode$Sms() {}
  
  public Barcode$Sms(String paramString1, String paramString2) {
    this.message = paramString1;
    this.phoneNumber = paramString2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zza(paramParcel, 2, this.message, false);
    zzbgo.zza(paramParcel, 3, this.phoneNumber, false);
    zzbgo.zzah(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\barcode\Barcode$Sms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */