package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.zas;

public final class zak extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zak> CREATOR = new zaj();
  
  private final int zaa;
  
  private final zas zab;
  
  zak(int paramInt, zas paramzas) {
    this.zaa = paramInt;
    this.zab = paramzas;
  }
  
  public zak(zas paramzas) {
    this(1, paramzas);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zaa);
    SafeParcelWriter.writeParcelable(paramParcel, 2, (Parcelable)this.zab, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\signin\internal\zak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */