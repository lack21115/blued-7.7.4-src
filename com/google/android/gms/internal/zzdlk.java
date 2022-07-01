package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzdlk extends zzev implements zzdlj {
  zzdlk(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizerCreator");
  }
  
  public final zzdlh zza(IObjectWrapper paramIObjectWrapper, zzdls paramzzdls) {
    zzdlh zzdlh;
    Parcel parcel2 = zzbc();
    zzex.zza(parcel2, (IInterface)paramIObjectWrapper);
    zzex.zza(parcel2, paramzzdls);
    Parcel parcel1 = zza(1, parcel2);
    IBinder iBinder = parcel1.readStrongBinder();
    if (iBinder == null) {
      iBinder = null;
    } else {
      IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
      if (iInterface instanceof zzdlh) {
        zzdlh = (zzdlh)iInterface;
      } else {
        zzdlh = new zzdli((IBinder)zzdlh);
      } 
    } 
    parcel1.recycle();
    return zzdlh;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzdlk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */