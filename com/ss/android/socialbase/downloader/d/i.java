package com.ss.android.socialbase.downloader.d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.g.c;

public interface i extends IInterface {
  int a() throws RemoteException;
  
  void a(c paramc) throws RemoteException;
  
  void a(c paramc, com.ss.android.socialbase.downloader.e.a parama) throws RemoteException;
  
  void b(c paramc) throws RemoteException;
  
  void b(c paramc, com.ss.android.socialbase.downloader.e.a parama) throws RemoteException;
  
  void c(c paramc) throws RemoteException;
  
  void c(c paramc, com.ss.android.socialbase.downloader.e.a parama) throws RemoteException;
  
  void d(c paramc) throws RemoteException;
  
  void e(c paramc) throws RemoteException;
  
  void f(c paramc) throws RemoteException;
  
  void g(c paramc) throws RemoteException;
  
  void h(c paramc) throws RemoteException;
  
  public static abstract class a extends Binder implements i {
    public a() {
      attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
    }
    
    public static i a(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
      return (iInterface != null && iInterface instanceof i) ? (i)iInterface : new a(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      if (param1Int1 != 1598968902) {
        com.ss.android.socialbase.downloader.e.a a2 = null;
        c c1 = null;
        c c2 = null;
        c c3 = null;
        com.ss.android.socialbase.downloader.e.a a3 = null;
        c c4 = null;
        c c5 = null;
        c c6 = null;
        c c7 = null;
        c c8 = null;
        com.ss.android.socialbase.downloader.e.a a1 = null;
        switch (param1Int1) {
          default:
            return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
          case 12:
            param1Parcel1.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (param1Parcel1.readInt() != 0) {
              c1 = (c)c.CREATOR.createFromParcel(param1Parcel1);
            } else {
              c1 = null;
            } 
            if (param1Parcel1.readInt() != 0)
              a1 = (com.ss.android.socialbase.downloader.e.a)com.ss.android.socialbase.downloader.e.a.CREATOR.createFromParcel(param1Parcel1); 
            c(c1, a1);
            param1Parcel2.writeNoException();
            return true;
          case 11:
            param1Parcel1.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (param1Parcel1.readInt() != 0) {
              c1 = (c)c.CREATOR.createFromParcel(param1Parcel1);
            } else {
              c1 = null;
            } 
            a1 = a2;
            if (param1Parcel1.readInt() != 0)
              a1 = (com.ss.android.socialbase.downloader.e.a)com.ss.android.socialbase.downloader.e.a.CREATOR.createFromParcel(param1Parcel1); 
            b(c1, a1);
            param1Parcel2.writeNoException();
            return true;
          case 10:
            param1Parcel1.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (param1Parcel1.readInt() != 0)
              c1 = (c)c.CREATOR.createFromParcel(param1Parcel1); 
            h(c1);
            param1Parcel2.writeNoException();
            return true;
          case 9:
            param1Parcel1.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            c1 = c2;
            if (param1Parcel1.readInt() != 0)
              c1 = (c)c.CREATOR.createFromParcel(param1Parcel1); 
            g(c1);
            param1Parcel2.writeNoException();
            return true;
          case 8:
            param1Parcel1.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            c1 = c3;
            if (param1Parcel1.readInt() != 0)
              c1 = (c)c.CREATOR.createFromParcel(param1Parcel1); 
            f(c1);
            param1Parcel2.writeNoException();
            return true;
          case 7:
            param1Parcel1.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (param1Parcel1.readInt() != 0) {
              c1 = (c)c.CREATOR.createFromParcel(param1Parcel1);
            } else {
              c1 = null;
            } 
            a1 = a3;
            if (param1Parcel1.readInt() != 0)
              a1 = (com.ss.android.socialbase.downloader.e.a)com.ss.android.socialbase.downloader.e.a.CREATOR.createFromParcel(param1Parcel1); 
            a(c1, a1);
            param1Parcel2.writeNoException();
            return true;
          case 6:
            param1Parcel1.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            c1 = c4;
            if (param1Parcel1.readInt() != 0)
              c1 = (c)c.CREATOR.createFromParcel(param1Parcel1); 
            e(c1);
            param1Parcel2.writeNoException();
            return true;
          case 5:
            param1Parcel1.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            c1 = c5;
            if (param1Parcel1.readInt() != 0)
              c1 = (c)c.CREATOR.createFromParcel(param1Parcel1); 
            d(c1);
            param1Parcel2.writeNoException();
            return true;
          case 4:
            param1Parcel1.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            c1 = c6;
            if (param1Parcel1.readInt() != 0)
              c1 = (c)c.CREATOR.createFromParcel(param1Parcel1); 
            c(c1);
            param1Parcel2.writeNoException();
            return true;
          case 3:
            param1Parcel1.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            c1 = c7;
            if (param1Parcel1.readInt() != 0)
              c1 = (c)c.CREATOR.createFromParcel(param1Parcel1); 
            b(c1);
            param1Parcel2.writeNoException();
            return true;
          case 2:
            param1Parcel1.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            c1 = c8;
            if (param1Parcel1.readInt() != 0)
              c1 = (c)c.CREATOR.createFromParcel(param1Parcel1); 
            a(c1);
            param1Parcel2.writeNoException();
            return true;
          case 1:
            break;
        } 
        param1Parcel1.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
        param1Int1 = a();
        param1Parcel2.writeNoException();
        param1Parcel2.writeInt(param1Int1);
        return true;
      } 
      param1Parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
      return true;
    }
    
    static class a implements i {
      private IBinder a;
      
      a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public int a() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
          this.a.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readInt();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(c param2c) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
          if (param2c != null) {
            parcel1.writeInt(1);
            param2c.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(c param2c, com.ss.android.socialbase.downloader.e.a param2a) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
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
          this.a.transact(7, parcel1, parcel2, 0);
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
      
      public void b(c param2c) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
          if (param2c != null) {
            parcel1.writeInt(1);
            param2c.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void b(c param2c, com.ss.android.socialbase.downloader.e.a param2a) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
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
          this.a.transact(11, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void c(c param2c) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
          if (param2c != null) {
            parcel1.writeInt(1);
            param2c.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(4, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void c(c param2c, com.ss.android.socialbase.downloader.e.a param2a) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
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
          this.a.transact(12, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void d(c param2c) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
          if (param2c != null) {
            parcel1.writeInt(1);
            param2c.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(5, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void e(c param2c) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
          if (param2c != null) {
            parcel1.writeInt(1);
            param2c.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(6, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void f(c param2c) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
          if (param2c != null) {
            parcel1.writeInt(1);
            param2c.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(8, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void g(c param2c) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
          if (param2c != null) {
            parcel1.writeInt(1);
            param2c.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(9, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void h(c param2c) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
          if (param2c != null) {
            parcel1.writeInt(1);
            param2c.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(10, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  static class a implements i {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public int a() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
        this.a.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(c param1c) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
        if (param1c != null) {
          parcel1.writeInt(1);
          param1c.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(c param1c, com.ss.android.socialbase.downloader.e.a param1a) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
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
        this.a.transact(7, parcel1, parcel2, 0);
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
    
    public void b(c param1c) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
        if (param1c != null) {
          parcel1.writeInt(1);
          param1c.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void b(c param1c, com.ss.android.socialbase.downloader.e.a param1a) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
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
        this.a.transact(11, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void c(c param1c) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
        if (param1c != null) {
          parcel1.writeInt(1);
          param1c.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(4, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void c(c param1c, com.ss.android.socialbase.downloader.e.a param1a) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
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
        this.a.transact(12, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void d(c param1c) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
        if (param1c != null) {
          parcel1.writeInt(1);
          param1c.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(5, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void e(c param1c) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
        if (param1c != null) {
          parcel1.writeInt(1);
          param1c.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(6, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void f(c param1c) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
        if (param1c != null) {
          parcel1.writeInt(1);
          param1c.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(8, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void g(c param1c) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
        if (param1c != null) {
          parcel1.writeInt(1);
          param1c.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(9, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void h(c param1c) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
        if (param1c != null) {
          parcel1.writeInt(1);
          param1c.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(10, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\d\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */