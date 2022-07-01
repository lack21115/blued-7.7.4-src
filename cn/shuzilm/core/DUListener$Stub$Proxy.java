package cn.shuzilm.core;

import android.os.IBinder;
import android.os.Parcel;

class DUListener$Stub$Proxy implements DUListener {
  private IBinder mRemote;
  
  DUListener$Stub$Proxy(IBinder paramIBinder) {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder() {
    return this.mRemote;
  }
  
  public String getInterfaceDescriptor() {
    return "cn.shuzilm.core.DUListener";
  }
  
  public void handle(String paramString) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("cn.shuzilm.core.DUListener");
      parcel1.writeString(paramString);
      this.mRemote.transact(1, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\DUListener$Stub$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */