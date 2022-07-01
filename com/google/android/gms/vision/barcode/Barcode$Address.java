package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

public class Barcode$Address extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zza();
  
  private String[] addressLines;
  
  private int type;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public Barcode$Address() {}
  
  public Barcode$Address(int paramInt, String[] paramArrayOfString) {
    this.type = paramInt;
    this.addressLines = paramArrayOfString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zzc(paramParcel, 2, this.type);
    zzbgo.zza$41b439c0(paramParcel, 3, this.addressLines);
    zzbgo.zzah(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\barcode\Barcode$Address.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */