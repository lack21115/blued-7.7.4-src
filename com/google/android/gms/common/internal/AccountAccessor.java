package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;

public class AccountAccessor extends IAccountAccessor.Stub {
  public static Account getAccountBinderSafe(IAccountAccessor paramIAccountAccessor) {
    if (paramIAccountAccessor != null) {
      long l = Binder.clearCallingIdentity();
      try {
        Account account = paramIAccountAccessor.zza();
        return Preconditions.<Account>checkNotNull(account);
      } catch (RemoteException remoteException) {
        Log.w("AccountAccessor", "Remote account accessor probably died");
      } finally {
        Binder.restoreCallingIdentity(l);
      } 
    } 
    paramIAccountAccessor = null;
    return (Account)Preconditions.checkNotNull(paramIAccountAccessor);
  }
  
  public boolean equals(Object paramObject) {
    throw new NoSuchMethodError();
  }
  
  public final Account zza() {
    throw new NoSuchMethodError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\AccountAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */