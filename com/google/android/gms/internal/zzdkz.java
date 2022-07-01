package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.vision.barcode.Barcode;

public final class zzdkz extends zzev implements zzdky {
  zzdkz(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
  }
  
  public final Barcode[] zza(IObjectWrapper paramIObjectWrapper, zzdld paramzzdld) {
    Parcel parcel2 = zzbc();
    zzex.zza(parcel2, (IInterface)paramIObjectWrapper);
    zzex.zza(parcel2, paramzzdld);
    Parcel parcel1 = zza(1, parcel2);
    Barcode[] arrayOfBarcode = (Barcode[])parcel1.createTypedArray(Barcode.CREATOR);
    parcel1.recycle();
    return arrayOfBarcode;
  }
  
  public final Barcode[] zzb(IObjectWrapper paramIObjectWrapper, zzdld paramzzdld) {
    Parcel parcel2 = zzbc();
    zzex.zza(parcel2, (IInterface)paramIObjectWrapper);
    zzex.zza(parcel2, paramzzdld);
    Parcel parcel1 = zza(2, parcel2);
    Barcode[] arrayOfBarcode = (Barcode[])parcel1.createTypedArray(Barcode.CREATOR);
    parcel1.recycle();
    return arrayOfBarcode;
  }
  
  public final void zzblm() {
    zzb(3, zzbc());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzdkz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */