package org.chromium.base.process_launcher;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class ICallbackInt$Stub extends Binder implements ICallbackInt {
  public ICallbackInt$Stub() {
    attachInterface(this, "org.chromium.base.process_launcher.ICallbackInt");
  }
  
  public IBinder asBinder() {
    return (IBinder)this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
    if (paramInt1 != 1) {
      if (paramInt1 != 1598968902)
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2); 
      paramParcel2.writeString("org.chromium.base.process_launcher.ICallbackInt");
      return true;
    } 
    paramParcel1.enforceInterface("org.chromium.base.process_launcher.ICallbackInt");
    call(paramParcel1.readInt());
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\process_launcher\ICallbackInt$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */