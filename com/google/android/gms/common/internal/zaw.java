package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zaw extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zaw> CREATOR = new zav();
  
  private final int zaa;
  
  private final int zab;
  
  private final int zac;
  
  @Deprecated
  private final Scope[] zad;
  
  zaw(int paramInt1, int paramInt2, int paramInt3, Scope[] paramArrayOfScope) {
    this.zaa = paramInt1;
    this.zab = paramInt2;
    this.zac = paramInt3;
    this.zad = paramArrayOfScope;
  }
  
  public zaw(int paramInt1, int paramInt2, Scope[] paramArrayOfScope) {
    this(1, paramInt1, paramInt2, null);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zaa);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zab);
    SafeParcelWriter.writeInt(paramParcel, 3, this.zac);
    SafeParcelWriter.writeTypedArray(paramParcel, 4, (Parcelable[])this.zad, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\zaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */