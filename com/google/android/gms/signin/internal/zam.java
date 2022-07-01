package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.zau;

public final class zam extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zam> CREATOR = new zal();
  
  private final int zaa;
  
  private final ConnectionResult zab;
  
  private final zau zac;
  
  public zam(int paramInt) {
    this(new ConnectionResult(8, null), null);
  }
  
  zam(int paramInt, ConnectionResult paramConnectionResult, zau paramzau) {
    this.zaa = paramInt;
    this.zab = paramConnectionResult;
    this.zac = paramzau;
  }
  
  private zam(ConnectionResult paramConnectionResult, zau paramzau) {
    this(1, paramConnectionResult, null);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zaa);
    SafeParcelWriter.writeParcelable(paramParcel, 2, (Parcelable)this.zab, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, (Parcelable)this.zac, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final ConnectionResult zaa() {
    return this.zab;
  }
  
  public final zau zab() {
    return this.zac;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\signin\internal\zam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */