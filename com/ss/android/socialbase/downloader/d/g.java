package com.ss.android.socialbase.downloader.d;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface g extends IInterface {
  Uri a(String paramString1, String paramString2) throws RemoteException;
  
  public static abstract class a extends Binder implements g {
    public a() {
      attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
    }
    
    public static g a(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
      return (iInterface != null && iInterface instanceof g) ? (g)iInterface : new a(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      if (param1Int1 != 1) {
        if (param1Int1 != 1598968902)
          return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); 
        param1Parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
        return true;
      } 
      param1Parcel1.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
      Uri uri = a(param1Parcel1.readString(), param1Parcel1.readString());
      param1Parcel2.writeNoException();
      if (uri != null) {
        param1Parcel2.writeInt(1);
        uri.writeToParcel(param1Parcel2, 1);
        return true;
      } 
      param1Parcel2.writeInt(0);
      return true;
    }
    
    static class a implements g {
      private IBinder a;
      
      a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public Uri a(String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          this.a.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            Uri uri = (Uri)Uri.CREATOR.createFromParcel(parcel2);
          } else {
            param2String1 = null;
          } 
          return (Uri)param2String1;
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
  
  static class a implements g {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public Uri a(String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        this.a.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          Uri uri = (Uri)Uri.CREATOR.createFromParcel(parcel2);
        } else {
          param1String1 = null;
        } 
        return (Uri)param1String1;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\d\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */