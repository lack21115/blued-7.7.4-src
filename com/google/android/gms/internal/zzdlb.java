package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzdlb extends zzev implements zzdla {
  zzdlb(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
  }
  
  public final zzdky zza(IObjectWrapper paramIObjectWrapper, zzdkv paramzzdkv) {
    zzdky zzdky;
    Parcel parcel2 = zzbc();
    zzex.zza(parcel2, (IInterface)paramIObjectWrapper);
    zzex.zza(parcel2, paramzzdkv);
    Parcel parcel1 = zza(1, parcel2);
    IBinder iBinder = parcel1.readStrongBinder();
    if (iBinder == null) {
      iBinder = null;
    } else {
      IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
      if (iInterface instanceof zzdky) {
        zzdky = (zzdky)iInterface;
      } else {
        zzdky = new zzdkz((IBinder)zzdky);
      } 
    } 
    parcel1.recycle();
    return zzdky;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzdlb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */