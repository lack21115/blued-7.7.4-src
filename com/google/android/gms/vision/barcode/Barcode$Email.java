package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

public class Barcode$Email extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzh();
  
  private String address;
  
  private String body;
  
  private String subject;
  
  private int type;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public Barcode$Email() {}
  
  public Barcode$Email(int paramInt, String paramString1, String paramString2, String paramString3) {
    this.type = paramInt;
    this.address = paramString1;
    this.subject = paramString2;
    this.body = paramString3;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zzc(paramParcel, 2, this.type);
    zzbgo.zza(paramParcel, 3, this.address, false);
    zzbgo.zza(paramParcel, 4, this.subject, false);
    zzbgo.zza(paramParcel, 5, this.body, false);
    zzbgo.zzah(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\barcode\Barcode$Email.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */