package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zas extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zas> CREATOR = new zar();
  
  private final int zaa;
  
  private final Account zab;
  
  private final int zac;
  
  private final GoogleSignInAccount zad;
  
  zas(int paramInt1, Account paramAccount, int paramInt2, GoogleSignInAccount paramGoogleSignInAccount) {
    this.zaa = paramInt1;
    this.zab = paramAccount;
    this.zac = paramInt2;
    this.zad = paramGoogleSignInAccount;
  }
  
  public zas(Account paramAccount, int paramInt, GoogleSignInAccount paramGoogleSignInAccount) {
    this(2, paramAccount, paramInt, paramGoogleSignInAccount);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zaa);
    SafeParcelWriter.writeParcelable(paramParcel, 2, (Parcelable)this.zab, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, this.zac);
    SafeParcelWriter.writeParcelable(paramParcel, 4, (Parcelable)this.zad, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\zas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */