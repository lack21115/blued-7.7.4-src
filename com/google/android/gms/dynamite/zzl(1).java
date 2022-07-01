package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;

public final class zzl extends zzb implements zzm {
  zzl(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
  }
  
  public final IObjectWrapper zza(IObjectWrapper paramIObjectWrapper1, String paramString, int paramInt, IObjectWrapper paramIObjectWrapper2) throws RemoteException {
    Parcel parcel2 = a_();
    zzd.zza(parcel2, (IInterface)paramIObjectWrapper1);
    parcel2.writeString(paramString);
    parcel2.writeInt(paramInt);
    zzd.zza(parcel2, (IInterface)paramIObjectWrapper2);
    Parcel parcel1 = zza(2, parcel2);
    IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface(parcel1.readStrongBinder());
    parcel1.recycle();
    return iObjectWrapper;
  }
  
  public final IObjectWrapper zzb(IObjectWrapper paramIObjectWrapper1, String paramString, int paramInt, IObjectWrapper paramIObjectWrapper2) throws RemoteException {
    Parcel parcel2 = a_();
    zzd.zza(parcel2, (IInterface)paramIObjectWrapper1);
    parcel2.writeString(paramString);
    parcel2.writeInt(paramInt);
    zzd.zza(parcel2, (IInterface)paramIObjectWrapper2);
    Parcel parcel1 = zza(3, parcel2);
    IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface(parcel1.readStrongBinder());
    parcel1.recycle();
    return iObjectWrapper;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\dynamite\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */