package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

public class Barcode$WiFi extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzn();
  
  private int encryptionType;
  
  private String password;
  
  private String ssid;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public Barcode$WiFi() {}
  
  public Barcode$WiFi(String paramString1, String paramString2, int paramInt) {
    this.ssid = paramString1;
    this.password = paramString2;
    this.encryptionType = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zza(paramParcel, 2, this.ssid, false);
    zzbgo.zza(paramParcel, 3, this.password, false);
    zzbgo.zzc(paramParcel, 4, this.encryptionType);
    zzbgo.zzah(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\barcode\Barcode$WiFi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */