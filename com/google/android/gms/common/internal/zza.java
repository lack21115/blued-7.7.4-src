package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;

public final class zza extends zzao {
  public static Account zza(zzan paramzzan) {
    if (paramzzan != null) {
      long l = Binder.clearCallingIdentity();
      try {
        Account account = paramzzan.getAccount();
        Binder.restoreCallingIdentity(l);
        return account;
      } catch (RemoteException remoteException) {
        Log.w("AccountAccessor", "Remote account accessor probably died");
        Binder.restoreCallingIdentity(l);
      } finally {}
    } 
    return null;
  }
  
  public final boolean equals(Object paramObject) {
    throw new NoSuchMethodError();
  }
  
  public final Account getAccount() {
    throw new NoSuchMethodError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\internal\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */