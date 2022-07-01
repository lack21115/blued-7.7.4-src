package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;

public interface ILocationSourceDelegate extends IInterface {
  void activate(zzah paramzzah) throws RemoteException;
  
  void deactivate() throws RemoteException;
  
  public static abstract class zza extends zzb implements ILocationSourceDelegate {
    public zza() {
      super("com.google.android.gms.maps.internal.ILocationSourceDelegate");
    }
    
    public final boolean dispatchTransaction(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      if (param1Int1 != 1) {
        if (param1Int1 != 2)
          return false; 
        deactivate();
      } else {
        zzah zzah;
        IBinder iBinder = param1Parcel1.readStrongBinder();
        if (iBinder == null) {
          iBinder = null;
        } else {
          IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
          if (iInterface instanceof zzah) {
            zzah = (zzah)iInterface;
          } else {
            zzah = new zzai((IBinder)zzah);
          } 
        } 
        activate(zzah);
      } 
      param1Parcel2.writeNoException();
      return true;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\internal\ILocationSourceDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */