package com.google.android.gms.common.internal;

import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzex;

public abstract class zzau extends zzew implements zzat {
  public zzau() {
    attachInterface(this, "com.google.android.gms.common.internal.ICertData");
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
    if (zza(paramInt1, paramParcel1, paramParcel2, paramInt2))
      return true; 
    switch (paramInt1) {
      default:
        return false;
      case 2:
        paramInt1 = zzahh();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 1:
        break;
    } 
    IObjectWrapper iObjectWrapper = zzahg();
    paramParcel2.writeNoException();
    zzex.zza(paramParcel2, (IInterface)iObjectWrapper);
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\internal\zzau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */