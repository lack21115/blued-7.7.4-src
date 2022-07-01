package com.google.android.gms.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

public interface zac extends IInterface {
  void zaa(ConnectionResult paramConnectionResult, zab paramzab) throws RemoteException;
  
  void zaa(Status paramStatus) throws RemoteException;
  
  void zaa(Status paramStatus, GoogleSignInAccount paramGoogleSignInAccount) throws RemoteException;
  
  void zaa(zag paramzag) throws RemoteException;
  
  void zaa(zam paramzam) throws RemoteException;
  
  void zab(Status paramStatus) throws RemoteException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\signin\internal\zac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */