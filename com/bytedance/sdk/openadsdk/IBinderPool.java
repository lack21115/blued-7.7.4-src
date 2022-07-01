package com.bytedance.sdk.openadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IBinderPool extends IInterface {
  IBinder queryBinder(int paramInt) throws RemoteException;
  
  public static abstract class Stub extends Binder implements IBinderPool {
    public Stub() {
      attachInterface(this, "com.bytedance.sdk.openadsdk.IBinderPool");
    }
    
    public static IBinderPool asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.IBinderPool");
      return (iInterface != null && iInterface instanceof IBinderPool) ? (IBinderPool)iInterface : new a(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      if (param1Int1 != 1) {
        if (param1Int1 != 1598968902)
          return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); 
        param1Parcel2.writeString("com.bytedance.sdk.openadsdk.IBinderPool");
        return true;
      } 
      param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IBinderPool");
      IBinder iBinder = queryBinder(param1Parcel1.readInt());
      param1Parcel2.writeNoException();
      param1Parcel2.writeStrongBinder(iBinder);
      return true;
    }
    
    static class a implements IBinderPool {
      private IBinder a;
      
      a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.a;
      }
      
      public IBinder queryBinder(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IBinderPool");
          parcel1.writeInt(param2Int);
          this.a.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readStrongBinder();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  static class a implements IBinderPool {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.a;
    }
    
    public IBinder queryBinder(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IBinderPool");
        parcel1.writeInt(param1Int);
        this.a.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readStrongBinder();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\IBinderPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */