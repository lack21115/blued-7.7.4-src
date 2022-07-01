package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface d extends IInterface {
  void a(b paramb) throws RemoteException;
  
  void a(b paramb, c paramc) throws RemoteException;
  
  public static abstract class a extends Binder implements d {
    public static d a() {
      return a.a;
    }
    
    public static d a(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.huawei.hms.core.aidl.IAIDLInvoke");
      return (iInterface != null && iInterface instanceof d) ? (d)iInterface : new a(param1IBinder);
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      b b1;
      b b2;
      Parcel parcel2 = null;
      Parcel parcel1 = null;
      if (param1Int1 != 1) {
        if (param1Int1 != 2) {
          if (param1Int1 != 1598968902)
            return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); 
          param1Parcel2.writeString("com.huawei.hms.core.aidl.IAIDLInvoke");
          return true;
        } 
        param1Parcel1.enforceInterface("com.huawei.hms.core.aidl.IAIDLInvoke");
        param1Parcel2 = parcel1;
        if (param1Parcel1.readInt() != 0)
          b1 = (b)b.CREATOR.createFromParcel(param1Parcel1); 
        a(b1, c.a.asInterface(param1Parcel1.readStrongBinder()));
        return true;
      } 
      param1Parcel1.enforceInterface("com.huawei.hms.core.aidl.IAIDLInvoke");
      parcel1 = parcel2;
      if (param1Parcel1.readInt() != 0)
        b2 = (b)b.CREATOR.createFromParcel(param1Parcel1); 
      a(b2);
      b1.writeNoException();
      return true;
    }
    
    static class a implements d {
      public static d a;
      
      private IBinder b;
      
      a(IBinder param2IBinder) {
        this.b = param2IBinder;
      }
      
      public void a(b param2b) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.huawei.hms.core.aidl.IAIDLInvoke");
          if (param2b != null) {
            parcel1.writeInt(1);
            param2b.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.b.transact(1, parcel1, parcel2, 0) && d.a.a() != null) {
            d.a.a().a(param2b);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(b param2b, c param2c) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          IBinder iBinder;
          parcel.writeInterfaceToken("com.huawei.hms.core.aidl.IAIDLInvoke");
          if (param2b != null) {
            parcel.writeInt(1);
            param2b.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          if (param2c != null) {
            iBinder = param2c.asBinder();
          } else {
            iBinder = null;
          } 
          parcel.writeStrongBinder(iBinder);
          if (!this.b.transact(2, parcel, null, 1) && d.a.a() != null) {
            d.a.a().a(param2b, param2c);
            return;
          } 
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public IBinder asBinder() {
        return this.b;
      }
    }
  }
  
  static class a implements d {
    public static d a;
    
    private IBinder b;
    
    a(IBinder param1IBinder) {
      this.b = param1IBinder;
    }
    
    public void a(b param1b) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.huawei.hms.core.aidl.IAIDLInvoke");
        if (param1b != null) {
          parcel1.writeInt(1);
          param1b.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.b.transact(1, parcel1, parcel2, 0) && d.a.a() != null) {
          d.a.a().a(param1b);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(b param1b, c param1c) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        IBinder iBinder;
        parcel.writeInterfaceToken("com.huawei.hms.core.aidl.IAIDLInvoke");
        if (param1b != null) {
          parcel.writeInt(1);
          param1b.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        if (param1c != null) {
          iBinder = param1c.asBinder();
        } else {
          iBinder = null;
        } 
        parcel.writeStrongBinder(iBinder);
        if (!this.b.transact(2, parcel, null, 1) && d.a.a() != null) {
          d.a.a().a(param1b, param1c);
          return;
        } 
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public IBinder asBinder() {
      return this.b;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\core\aidl\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */