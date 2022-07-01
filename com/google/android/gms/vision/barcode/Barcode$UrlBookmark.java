package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

public class Barcode$UrlBookmark extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzm();
  
  private String title;
  
  private String url;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public Barcode$UrlBookmark() {}
  
  public Barcode$UrlBookmark(String paramString1, String paramString2) {
    this.title = paramString1;
    this.url = paramString2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zza(paramParcel, 2, this.title, false);
    zzbgo.zza(paramParcel, 3, this.url, false);
    zzbgo.zzah(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\barcode\Barcode$UrlBookmark.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */