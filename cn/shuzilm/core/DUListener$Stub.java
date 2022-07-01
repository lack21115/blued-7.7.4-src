package cn.shuzilm.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class DUListener$Stub extends Binder implements DUListener {
  private static final String DESCRIPTOR = "cn.shuzilm.core.DUListener";
  
  static final int TRANSACTION_handle = 1;
  
  public DUListener$Stub() {
    attachInterface(this, "cn.shuzilm.core.DUListener");
  }
  
  public static DUListener asInterface(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("cn.shuzilm.core.DUListener");
    return (iInterface != null && iInterface instanceof DUListener) ? (DUListener)iInterface : new DUListener$Stub$Proxy(paramIBinder);
  }
  
  public IBinder asBinder() {
    return (IBinder)this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
    if (paramInt1 != 1) {
      if (paramInt1 != 1598968902)
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2); 
      paramParcel2.writeString("cn.shuzilm.core.DUListener");
      return true;
    } 
    paramParcel1.enforceInterface("cn.shuzilm.core.DUListener");
    handle(paramParcel1.readString());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\DUListener$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */