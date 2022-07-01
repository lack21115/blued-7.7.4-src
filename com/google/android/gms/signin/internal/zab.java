package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zab extends AbstractSafeParcelable implements Result {
  public static final Parcelable.Creator<zab> CREATOR = new zaa();
  
  private final int zaa;
  
  private int zab;
  
  private Intent zac;
  
  public zab() {
    this(0, null);
  }
  
  zab(int paramInt1, int paramInt2, Intent paramIntent) {
    this.zaa = paramInt1;
    this.zab = paramInt2;
    this.zac = paramIntent;
  }
  
  private zab(int paramInt, Intent paramIntent) {
    this(2, 0, null);
  }
  
  public final Status getStatus() {
    return (this.zab == 0) ? Status.RESULT_SUCCESS : Status.RESULT_CANCELED;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zaa);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zab);
    SafeParcelWriter.writeParcelable(paramParcel, 3, (Parcelable)this.zac, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\signin\internal\zab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */