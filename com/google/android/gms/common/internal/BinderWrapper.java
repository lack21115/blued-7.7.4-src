package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class BinderWrapper implements Parcelable {
  public static final Parcelable.Creator<BinderWrapper> CREATOR = new zza();
  
  private IBinder zza = null;
  
  public BinderWrapper() {}
  
  public BinderWrapper(IBinder paramIBinder) {
    this.zza = paramIBinder;
  }
  
  private BinderWrapper(Parcel paramParcel) {
    this.zza = paramParcel.readStrongBinder();
  }
  
  public final int describeContents() {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeStrongBinder(this.zza);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\BinderWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */