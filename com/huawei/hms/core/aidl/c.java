package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface c extends IInterface {
  void call(b paramb) throws RemoteException;
  
  public static abstract class a extends Binder implements c {
    public a() {
      attachInterface(this, "com.huawei.hms.core.aidl.IAIDLCallback");
    }
    
    public static c asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.huawei.hms.core.aidl.IAIDLCallback");
      return (iInterface != null && iInterface instanceof c) ? (c)iInterface : new a(param1IBinder);
    }
    
    public static c getDefaultImpl() {
      return a.a;
    }
    
    public static boolean setDefaultImpl(c param1c) {
      if (a.a == null && param1c != null) {
        a.a = param1c;
        return true;
      } 
      return false;
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      if (param1Int1 != 1) {
        if (param1Int1 != 1598968902)
          return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); 
        param1Parcel2.writeString("com.huawei.hms.core.aidl.IAIDLCallback");
        return true;
      } 
      param1Parcel1.enforceInterface("com.huawei.hms.core.aidl.IAIDLCallback");
      if (param1Parcel1.readInt() != 0) {
        b b = (b)b.CREATOR.createFromParcel(param1Parcel1);
      } else {
        param1Parcel1 = null;
      } 
      call((b)param1Parcel1);
      return true;
    }
    
    static class a implements c {
      public static c a;
      
      private IBinder b;
      
      a(IBinder param2IBinder) {
        this.b = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.b;
      }
      
      public void call(b param2b) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("com.huawei.hms.core.aidl.IAIDLCallback");
          if (param2b != null) {
            parcel.writeInt(1);
            param2b.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          if (!this.b.transact(1, parcel, null, 1) && c.a.getDefaultImpl() != null) {
            c.a.getDefaultImpl().call(param2b);
            return;
          } 
          return;
        } finally {
          parcel.recycle();
        } 
      }
    }
  }
  
  static class a implements c {
    public static c a;
    
    private IBinder b;
    
    a(IBinder param1IBinder) {
      this.b = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.b;
    }
    
    public void call(b param1b) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("com.huawei.hms.core.aidl.IAIDLCallback");
        if (param1b != null) {
          parcel.writeInt(1);
          param1b.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        if (!this.b.transact(1, parcel, null, 1) && c.a.getDefaultImpl() != null) {
          c.a.getDefaultImpl().call(param1b);
          return;
        } 
        return;
      } finally {
        parcel.recycle();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\core\aidl\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */