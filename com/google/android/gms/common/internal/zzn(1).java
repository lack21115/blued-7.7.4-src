package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzd;

public abstract class zzn extends zza implements zzl {
  public zzn() {
    super("com.google.android.gms.common.internal.ICertData");
  }
  
  public static zzl zza(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
    return (iInterface instanceof zzl) ? (zzl)iInterface : new zzm(paramIBinder);
  }
  
  public final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    if (paramInt1 != 1) {
      if (paramInt1 != 2)
        return false; 
      paramInt1 = zzc();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    } 
    IObjectWrapper iObjectWrapper = zzb();
    paramParcel2.writeNoException();
    zzd.zza(paramParcel2, (IInterface)iObjectWrapper);
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */