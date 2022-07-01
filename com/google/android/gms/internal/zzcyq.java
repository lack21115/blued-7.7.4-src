package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

public abstract class zzcyq extends zzew implements zzcyp {
  public zzcyq() {
    attachInterface(this, "com.google.android.gms.signin.internal.ISignInCallbacks");
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
    Parcelable.Creator creator;
    if (zza(paramInt1, paramParcel1, paramParcel2, paramInt2))
      return true; 
    switch (paramInt1) {
      default:
        return false;
      case 8:
        zzb((zzcyw)zzex.zza(paramParcel1, zzcyw.CREATOR));
        paramParcel2.writeNoException();
        return true;
      case 7:
        zzex.zza(paramParcel1, Status.CREATOR);
        creator = GoogleSignInAccount.CREATOR;
        break;
      case 4:
      case 6:
        creator = Status.CREATOR;
        break;
      case 3:
        zzex.zza(paramParcel1, ConnectionResult.CREATOR);
        creator = zzcym.CREATOR;
        break;
    } 
    zzex.zza(paramParcel1, creator);
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzcyq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */