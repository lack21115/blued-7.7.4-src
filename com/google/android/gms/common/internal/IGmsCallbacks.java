package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzd;

public interface IGmsCallbacks extends IInterface {
  void onPostInitComplete(int paramInt, IBinder paramIBinder, Bundle paramBundle) throws RemoteException;
  
  void zza(int paramInt, Bundle paramBundle) throws RemoteException;
  
  void zza(int paramInt, IBinder paramIBinder, zzc paramzzc) throws RemoteException;
  
  public static abstract class zza extends com.google.android.gms.internal.common.zza implements IGmsCallbacks {
    public zza() {
      super("com.google.android.gms.common.internal.IGmsCallbacks");
    }
    
    public final boolean zza(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      if (param1Int1 != 1) {
        if (param1Int1 != 2) {
          if (param1Int1 != 3)
            return false; 
          zza(param1Parcel1.readInt(), param1Parcel1.readStrongBinder(), (zzc)zzd.zza(param1Parcel1, zzc.CREATOR));
        } else {
          zza(param1Parcel1.readInt(), (Bundle)zzd.zza(param1Parcel1, Bundle.CREATOR));
        } 
      } else {
        onPostInitComplete(param1Parcel1.readInt(), param1Parcel1.readStrongBinder(), (Bundle)zzd.zza(param1Parcel1, Bundle.CREATOR));
      } 
      param1Parcel2.writeNoException();
      return true;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\IGmsCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */