package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;

public interface IAccountAccessor extends IInterface {
  Account zza() throws RemoteException;
  
  public static abstract class Stub extends com.google.android.gms.internal.common.zza implements IAccountAccessor {
    public Stub() {
      super("com.google.android.gms.common.internal.IAccountAccessor");
    }
    
    public static IAccountAccessor asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
      return (iInterface instanceof IAccountAccessor) ? (IAccountAccessor)iInterface : new zza(param1IBinder);
    }
    
    public final boolean zza(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      if (param1Int1 == 2) {
        Account account = zza();
        param1Parcel2.writeNoException();
        zzd.zzb(param1Parcel2, (Parcelable)account);
        return true;
      } 
      return false;
    }
    
    public static final class zza extends zzb implements IAccountAccessor {
      zza(IBinder param2IBinder) {
        super(param2IBinder, "com.google.android.gms.common.internal.IAccountAccessor");
      }
      
      public final Account zza() throws RemoteException {
        Parcel parcel = zza(2, a_());
        Account account = (Account)zzd.zza(parcel, Account.CREATOR);
        parcel.recycle();
        return account;
      }
    }
  }
  
  public static final class zza extends zzb implements IAccountAccessor {
    zza(IBinder param1IBinder) {
      super(param1IBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }
    
    public final Account zza() throws RemoteException {
      Parcel parcel = zza(2, a_());
      Account account = (Account)zzd.zza(parcel, Account.CREATOR);
      parcel.recycle();
      return account;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\IAccountAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */