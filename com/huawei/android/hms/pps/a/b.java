package com.huawei.android.hms.pps.a;

import android.os.IBinder;
import android.os.Parcel;

public final class b implements c {
  private IBinder a;
  
  public b(IBinder paramIBinder) {
    this.a = paramIBinder;
  }
  
  public final IBinder asBinder() {
    return this.a;
  }
  
  public final boolean d() {
    boolean bool = false;
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
      this.a.transact(2, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      if (i != 0)
        bool = true; 
      return bool;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final String e() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
      this.a.transact(1, parcel1, parcel2, 0);
      parcel2.readException();
      return parcel2.readString();
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\huawei\android\hms\pps\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */