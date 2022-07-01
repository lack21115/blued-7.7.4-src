package com.google.android.gms.vision.face.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzex;

public final class zzh extends zzev implements zzg {
  zzh(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
  }
  
  public final zze zza(IObjectWrapper paramIObjectWrapper, zzc paramzzc) {
    zze zze;
    Parcel parcel2 = zzbc();
    zzex.zza(parcel2, (IInterface)paramIObjectWrapper);
    zzex.zza(parcel2, (Parcelable)paramzzc);
    Parcel parcel1 = zza(1, parcel2);
    IBinder iBinder = parcel1.readStrongBinder();
    if (iBinder == null) {
      iBinder = null;
    } else {
      IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
      if (iInterface instanceof zze) {
        zze = (zze)iInterface;
      } else {
        zze = new zzf((IBinder)zze);
      } 
    } 
    parcel1.recycle();
    return zze;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\face\internal\client\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */