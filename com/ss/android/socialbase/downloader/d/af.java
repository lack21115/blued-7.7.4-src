package com.ss.android.socialbase.downloader.d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface af extends IInterface {
  void a(int paramInt1, int paramInt2) throws RemoteException;
  
  public static abstract class a extends Binder implements af {
    public a() {
      attachInterface(this, "com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
    }
    
    public static af a(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
      return (iInterface != null && iInterface instanceof af) ? (af)iInterface : new a(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      if (param1Int1 != 1) {
        if (param1Int1 != 1598968902)
          return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); 
        param1Parcel2.writeString("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
        return true;
      } 
      param1Parcel1.enforceInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
      a(param1Parcel1.readInt(), param1Parcel1.readInt());
      param1Parcel2.writeNoException();
      return true;
    }
    
    static class a implements af {
      private IBinder a;
      
      a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public void a(int param2Int1, int param2Int2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
          parcel1.writeInt(param2Int1);
          parcel1.writeInt(param2Int2);
          this.a.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public IBinder asBinder() {
        return this.a;
      }
    }
  }
  
  static class a implements af {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public void a(int param1Int1, int param1Int2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        this.a.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public IBinder asBinder() {
      return this.a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\d\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */