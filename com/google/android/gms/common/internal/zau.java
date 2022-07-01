package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zau extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zau> CREATOR = new zat();
  
  private final int zaa;
  
  private IBinder zab;
  
  private ConnectionResult zac;
  
  private boolean zad;
  
  private boolean zae;
  
  zau(int paramInt, IBinder paramIBinder, ConnectionResult paramConnectionResult, boolean paramBoolean1, boolean paramBoolean2) {
    this.zaa = paramInt;
    this.zab = paramIBinder;
    this.zac = paramConnectionResult;
    this.zad = paramBoolean1;
    this.zae = paramBoolean2;
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof zau))
      return false; 
    paramObject = paramObject;
    return (this.zac.equals(((zau)paramObject).zac) && Objects.equal(zaa(), paramObject.zaa()));
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zaa);
    SafeParcelWriter.writeIBinder(paramParcel, 2, this.zab, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, (Parcelable)this.zac, paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 4, this.zad);
    SafeParcelWriter.writeBoolean(paramParcel, 5, this.zae);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final IAccountAccessor zaa() {
    IBinder iBinder = this.zab;
    return (iBinder == null) ? null : IAccountAccessor.Stub.asInterface(iBinder);
  }
  
  public final ConnectionResult zab() {
    return this.zac;
  }
  
  public final boolean zac() {
    return this.zad;
  }
  
  public final boolean zad() {
    return this.zae;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\zau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */