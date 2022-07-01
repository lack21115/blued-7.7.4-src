package com.google.android.gms.vision.face.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzdld;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzex;

public final class zzf extends zzev implements zze {
  zzf(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
  }
  
  public final void zzblm() {
    zzb(3, zzbc());
  }
  
  public final FaceParcel[] zzc(IObjectWrapper paramIObjectWrapper, zzdld paramzzdld) {
    Parcel parcel2 = zzbc();
    zzex.zza(parcel2, (IInterface)paramIObjectWrapper);
    zzex.zza(parcel2, (Parcelable)paramzzdld);
    Parcel parcel1 = zza(1, parcel2);
    FaceParcel[] arrayOfFaceParcel = (FaceParcel[])parcel1.createTypedArray(FaceParcel.CREATOR);
    parcel1.recycle();
    return arrayOfFaceParcel;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\face\internal\client\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */