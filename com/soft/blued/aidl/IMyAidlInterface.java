package com.soft.blued.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IMyAidlInterface extends IInterface {
  String a() throws RemoteException;
  
  public static class Default implements IMyAidlInterface {
    public String a() throws RemoteException {
      return null;
    }
    
    public IBinder asBinder() {
      return null;
    }
  }
  
  public static abstract class Stub extends Binder implements IMyAidlInterface {
    public Stub() {
      attachInterface(this, "com.soft.blued.aidl.IMyAidlInterface");
    }
    
    public static IMyAidlInterface b() {
      return Proxy.a;
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      if (param1Int1 != 1) {
        if (param1Int1 != 1598968902)
          return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); 
        param1Parcel2.writeString("com.soft.blued.aidl.IMyAidlInterface");
        return true;
      } 
      param1Parcel1.enforceInterface("com.soft.blued.aidl.IMyAidlInterface");
      String str = a();
      param1Parcel2.writeNoException();
      param1Parcel2.writeString(str);
      return true;
    }
    
    static class Proxy implements IMyAidlInterface {
      public static IMyAidlInterface a;
      
      private IBinder b;
      
      public String a() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.soft.blued.aidl.IMyAidlInterface");
          if (!this.b.transact(1, parcel1, parcel2, 0) && IMyAidlInterface.Stub.b() != null)
            return IMyAidlInterface.Stub.b().a(); 
          parcel2.readException();
          return parcel2.readString();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public IBinder asBinder() {
        return this.b;
      }
    }
  }
  
  static class Proxy implements IMyAidlInterface {
    public static IMyAidlInterface a;
    
    private IBinder b;
    
    public String a() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.soft.blued.aidl.IMyAidlInterface");
        if (!this.b.transact(1, parcel1, parcel2, 0) && IMyAidlInterface.Stub.b() != null)
          return IMyAidlInterface.Stub.b().a(); 
        parcel2.readException();
        return parcel2.readString();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public IBinder asBinder() {
      return this.b;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\aidl\IMyAidlInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */