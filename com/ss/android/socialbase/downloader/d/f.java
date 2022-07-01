package com.ss.android.socialbase.downloader.d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.g.c;

public interface f extends IInterface {
  void a(c paramc, com.ss.android.socialbase.downloader.e.a parama, int paramInt) throws RemoteException;
  
  public static abstract class a extends Binder implements f {
    public a() {
      attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
    }
    
    public static f a(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
      return (iInterface != null && iInterface instanceof f) ? (f)iInterface : new a(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      c c;
      if (param1Int1 != 1) {
        if (param1Int1 != 1598968902)
          return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); 
        param1Parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
        return true;
      } 
      param1Parcel1.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
      param1Int1 = param1Parcel1.readInt();
      com.ss.android.socialbase.downloader.e.a a1 = null;
      if (param1Int1 != 0) {
        c = (c)c.CREATOR.createFromParcel(param1Parcel1);
      } else {
        c = null;
      } 
      if (param1Parcel1.readInt() != 0)
        a1 = (com.ss.android.socialbase.downloader.e.a)com.ss.android.socialbase.downloader.e.a.CREATOR.createFromParcel(param1Parcel1); 
      a(c, a1, param1Parcel1.readInt());
      param1Parcel2.writeNoException();
      return true;
    }
    
    static class a implements f {
      private IBinder a;
      
      a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public void a(c param2c, com.ss.android.socialbase.downloader.e.a param2a, int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
          if (param2c != null) {
            parcel1.writeInt(1);
            param2c.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (param2a != null) {
            parcel1.writeInt(1);
            param2a.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          parcel1.writeInt(param2Int);
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
  
  static class a implements f {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public void a(c param1c, com.ss.android.socialbase.downloader.e.a param1a, int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
        if (param1c != null) {
          parcel1.writeInt(1);
          param1c.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (param1a != null) {
          parcel1.writeInt(1);
          param1a.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        parcel1.writeInt(param1Int);
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\d\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */