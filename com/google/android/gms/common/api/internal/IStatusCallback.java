package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zad;

public interface IStatusCallback extends IInterface {
  void onResult(Status paramStatus) throws RemoteException;
  
  public static abstract class Stub extends com.google.android.gms.internal.base.zaa implements IStatusCallback {
    public Stub() {
      super("com.google.android.gms.common.api.internal.IStatusCallback");
    }
    
    public static IStatusCallback asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
      return (iInterface instanceof IStatusCallback) ? (IStatusCallback)iInterface : new zaa(param1IBinder);
    }
    
    public final boolean zaa(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      if (param1Int1 == 1) {
        onResult((Status)zad.zaa(param1Parcel1, Status.CREATOR));
        return true;
      } 
      return false;
    }
    
    public static final class zaa extends zab implements IStatusCallback {
      zaa(IBinder param2IBinder) {
        super(param2IBinder, "com.google.android.gms.common.api.internal.IStatusCallback");
      }
      
      public final void onResult(Status param2Status) throws RemoteException {
        Parcel parcel = zaa();
        zad.zaa(parcel, (Parcelable)param2Status);
        zac(1, parcel);
      }
    }
  }
  
  public static final class zaa extends zab implements IStatusCallback {
    zaa(IBinder param1IBinder) {
      super(param1IBinder, "com.google.android.gms.common.api.internal.IStatusCallback");
    }
    
    public final void onResult(Status param1Status) throws RemoteException {
      Parcel parcel = zaa();
      zad.zaa(parcel, (Parcelable)param1Status);
      zac(1, parcel);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\IStatusCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */