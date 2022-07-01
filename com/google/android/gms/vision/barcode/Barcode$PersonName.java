package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

public class Barcode$PersonName extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzj();
  
  private String first;
  
  private String formattedName;
  
  private String last;
  
  private String middle;
  
  private String prefix;
  
  private String pronunciation;
  
  private String suffix;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public Barcode$PersonName() {}
  
  public Barcode$PersonName(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
    this.formattedName = paramString1;
    this.pronunciation = paramString2;
    this.prefix = paramString3;
    this.first = paramString4;
    this.middle = paramString5;
    this.last = paramString6;
    this.suffix = paramString7;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zza(paramParcel, 2, this.formattedName, false);
    zzbgo.zza(paramParcel, 3, this.pronunciation, false);
    zzbgo.zza(paramParcel, 4, this.prefix, false);
    zzbgo.zza(paramParcel, 5, this.first, false);
    zzbgo.zza(paramParcel, 6, this.middle, false);
    zzbgo.zza(paramParcel, 7, this.last, false);
    zzbgo.zza(paramParcel, 8, this.suffix, false);
    zzbgo.zzah(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\barcode\Barcode$PersonName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */