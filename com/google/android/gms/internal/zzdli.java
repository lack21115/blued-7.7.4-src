package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzdli extends zzev implements zzdlh {
  zzdli(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
  }
  
  public final zzdll[] zza(IObjectWrapper paramIObjectWrapper, zzdld paramzzdld, zzdln paramzzdln) {
    Parcel parcel2 = zzbc();
    zzex.zza(parcel2, (IInterface)paramIObjectWrapper);
    zzex.zza(parcel2, paramzzdld);
    zzex.zza(parcel2, paramzzdln);
    Parcel parcel1 = zza(3, parcel2);
    zzdll[] arrayOfZzdll = (zzdll[])parcel1.createTypedArray(zzdll.CREATOR);
    parcel1.recycle();
    return arrayOfZzdll;
  }
  
  public final void zzblp() {
    zzb(2, zzbc());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzdli.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */