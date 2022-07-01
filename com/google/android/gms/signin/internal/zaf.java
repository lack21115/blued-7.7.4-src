package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zad;

public abstract class zaf extends zaa implements zac {
  public zaf() {
    super("com.google.android.gms.signin.internal.ISignInCallbacks");
  }
  
  public final boolean zaa(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    switch (paramInt1) {
      default:
        return false;
      case 9:
        zaa((zag)zad.zaa(paramParcel1, zag.CREATOR));
        paramParcel2.writeNoException();
        return true;
      case 8:
        zaa((zam)zad.zaa(paramParcel1, zam.CREATOR));
        paramParcel2.writeNoException();
        return true;
      case 7:
        zaa((Status)zad.zaa(paramParcel1, Status.CREATOR), (GoogleSignInAccount)zad.zaa(paramParcel1, GoogleSignInAccount.CREATOR));
        paramParcel2.writeNoException();
        return true;
      case 6:
        zab((Status)zad.zaa(paramParcel1, Status.CREATOR));
        paramParcel2.writeNoException();
        return true;
      case 4:
        zaa((Status)zad.zaa(paramParcel1, Status.CREATOR));
        paramParcel2.writeNoException();
        return true;
      case 3:
        break;
    } 
    zaa((ConnectionResult)zad.zaa(paramParcel1, ConnectionResult.CREATOR), (zab)zad.zaa(paramParcel1, zab.CREATOR));
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\signin\internal\zaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */