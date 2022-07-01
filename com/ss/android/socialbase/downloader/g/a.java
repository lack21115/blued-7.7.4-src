package com.ss.android.socialbase.downloader.g;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.d.ab;
import com.ss.android.socialbase.downloader.d.ad;
import com.ss.android.socialbase.downloader.d.e;
import com.ss.android.socialbase.downloader.d.f;
import com.ss.android.socialbase.downloader.d.g;
import com.ss.android.socialbase.downloader.d.h;
import com.ss.android.socialbase.downloader.d.i;
import com.ss.android.socialbase.downloader.d.j;
import com.ss.android.socialbase.downloader.d.n;
import com.ss.android.socialbase.downloader.d.s;
import com.ss.android.socialbase.downloader.d.y;

public interface a extends IInterface {
  int a(int paramInt) throws RemoteException;
  
  i a(int paramInt1, int paramInt2) throws RemoteException;
  
  c a() throws RemoteException;
  
  e b() throws RemoteException;
  
  i b(int paramInt) throws RemoteException;
  
  y c() throws RemoteException;
  
  ab d() throws RemoteException;
  
  h e() throws RemoteException;
  
  f f() throws RemoteException;
  
  s g() throws RemoteException;
  
  ad h() throws RemoteException;
  
  n i() throws RemoteException;
  
  j j() throws RemoteException;
  
  g k() throws RemoteException;
  
  public static abstract class a extends Binder implements a {
    public a() {
      attachInterface(this, "com.ss.android.socialbase.downloader.model.DownloadAidlTask");
    }
    
    public static a a(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
      return (iInterface != null && iInterface instanceof a) ? (a)iInterface : new a(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      if (param1Int1 != 1598968902) {
        IBinder iBinder2;
        g g1;
        IBinder iBinder1;
        j j;
        n n;
        ad ad;
        s s;
        f f;
        h h;
        ab ab;
        y y;
        i i;
        e e;
        g g2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        IBinder iBinder5 = null;
        IBinder iBinder6 = null;
        IBinder iBinder7 = null;
        IBinder iBinder8 = null;
        IBinder iBinder9 = null;
        IBinder iBinder10 = null;
        IBinder iBinder11 = null;
        IBinder iBinder12 = null;
        Parcel parcel = null;
        switch (param1Int1) {
          default:
            return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
          case 14:
            param1Parcel1.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            g2 = k();
            param1Parcel2.writeNoException();
            param1Parcel1 = parcel;
            if (g2 != null)
              iBinder2 = g2.asBinder(); 
            param1Parcel2.writeStrongBinder(iBinder2);
            return true;
          case 13:
            iBinder2.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            j = j();
            param1Parcel2.writeNoException();
            g1 = g2;
            if (j != null)
              iBinder1 = j.asBinder(); 
            param1Parcel2.writeStrongBinder(iBinder1);
            return true;
          case 12:
            iBinder1.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            n = i();
            param1Parcel2.writeNoException();
            iBinder1 = iBinder3;
            if (n != null)
              iBinder1 = n.asBinder(); 
            param1Parcel2.writeStrongBinder(iBinder1);
            return true;
          case 11:
            iBinder1.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            ad = h();
            param1Parcel2.writeNoException();
            iBinder1 = iBinder4;
            if (ad != null)
              iBinder1 = ad.asBinder(); 
            param1Parcel2.writeStrongBinder(iBinder1);
            return true;
          case 10:
            iBinder1.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            s = g();
            param1Parcel2.writeNoException();
            iBinder1 = iBinder5;
            if (s != null)
              iBinder1 = s.asBinder(); 
            param1Parcel2.writeStrongBinder(iBinder1);
            return true;
          case 9:
            iBinder1.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            f = f();
            param1Parcel2.writeNoException();
            iBinder1 = iBinder6;
            if (f != null)
              iBinder1 = f.asBinder(); 
            param1Parcel2.writeStrongBinder(iBinder1);
            return true;
          case 8:
            iBinder1.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            h = e();
            param1Parcel2.writeNoException();
            iBinder1 = iBinder7;
            if (h != null)
              iBinder1 = h.asBinder(); 
            param1Parcel2.writeStrongBinder(iBinder1);
            return true;
          case 7:
            iBinder1.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            ab = d();
            param1Parcel2.writeNoException();
            iBinder1 = iBinder8;
            if (ab != null)
              iBinder1 = ab.asBinder(); 
            param1Parcel2.writeStrongBinder(iBinder1);
            return true;
          case 6:
            iBinder1.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            y = c();
            param1Parcel2.writeNoException();
            iBinder1 = iBinder9;
            if (y != null)
              iBinder1 = y.asBinder(); 
            param1Parcel2.writeStrongBinder(iBinder1);
            return true;
          case 5:
            iBinder1.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            i = b(iBinder1.readInt());
            param1Parcel2.writeNoException();
            iBinder1 = iBinder10;
            if (i != null)
              iBinder1 = i.asBinder(); 
            param1Parcel2.writeStrongBinder(iBinder1);
            return true;
          case 4:
            iBinder1.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            i = a(iBinder1.readInt(), iBinder1.readInt());
            param1Parcel2.writeNoException();
            iBinder1 = iBinder11;
            if (i != null)
              iBinder1 = i.asBinder(); 
            param1Parcel2.writeStrongBinder(iBinder1);
            return true;
          case 3:
            iBinder1.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            param1Int1 = a(iBinder1.readInt());
            param1Parcel2.writeNoException();
            param1Parcel2.writeInt(param1Int1);
            return true;
          case 2:
            iBinder1.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            e = b();
            param1Parcel2.writeNoException();
            iBinder1 = iBinder12;
            if (e != null)
              iBinder1 = e.asBinder(); 
            param1Parcel2.writeStrongBinder(iBinder1);
            return true;
          case 1:
            break;
        } 
        iBinder1.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        c c = a();
        param1Parcel2.writeNoException();
        if (c != null) {
          param1Parcel2.writeInt(1);
          c.writeToParcel(param1Parcel2, 1);
          return true;
        } 
        param1Parcel2.writeInt(0);
        return true;
      } 
      param1Parcel2.writeString("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
      return true;
    }
    
    static class a implements a {
      private IBinder a;
      
      a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public int a(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
          parcel1.writeInt(param2Int);
          this.a.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          param2Int = parcel2.readInt();
          return param2Int;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public i a(int param2Int1, int param2Int2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
          parcel1.writeInt(param2Int1);
          parcel1.writeInt(param2Int2);
          this.a.transact(4, parcel1, parcel2, 0);
          parcel2.readException();
          return i.a.a(parcel2.readStrongBinder());
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public c a() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          c c;
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
          this.a.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            c = (c)c.CREATOR.createFromParcel(parcel2);
          } else {
            c = null;
          } 
          return c;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public IBinder asBinder() {
        return this.a;
      }
      
      public e b() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
          this.a.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          return e.a.a(parcel2.readStrongBinder());
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public i b(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
          parcel1.writeInt(param2Int);
          this.a.transact(5, parcel1, parcel2, 0);
          parcel2.readException();
          return i.a.a(parcel2.readStrongBinder());
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public y c() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
          this.a.transact(6, parcel1, parcel2, 0);
          parcel2.readException();
          return y.a.a(parcel2.readStrongBinder());
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public ab d() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
          this.a.transact(7, parcel1, parcel2, 0);
          parcel2.readException();
          return ab.a.a(parcel2.readStrongBinder());
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public h e() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
          this.a.transact(8, parcel1, parcel2, 0);
          parcel2.readException();
          return h.a.a(parcel2.readStrongBinder());
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public f f() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
          this.a.transact(9, parcel1, parcel2, 0);
          parcel2.readException();
          return f.a.a(parcel2.readStrongBinder());
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public s g() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
          this.a.transact(10, parcel1, parcel2, 0);
          parcel2.readException();
          return s.a.a(parcel2.readStrongBinder());
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public ad h() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
          this.a.transact(11, parcel1, parcel2, 0);
          parcel2.readException();
          return ad.a.a(parcel2.readStrongBinder());
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public n i() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
          this.a.transact(12, parcel1, parcel2, 0);
          parcel2.readException();
          return n.a.a(parcel2.readStrongBinder());
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public j j() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
          this.a.transact(13, parcel1, parcel2, 0);
          parcel2.readException();
          return j.a.a(parcel2.readStrongBinder());
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public g k() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
          this.a.transact(14, parcel1, parcel2, 0);
          parcel2.readException();
          return g.a.a(parcel2.readStrongBinder());
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  static class a implements a {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public int a(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        parcel1.writeInt(param1Int);
        this.a.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        param1Int = parcel2.readInt();
        return param1Int;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public i a(int param1Int1, int param1Int2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        this.a.transact(4, parcel1, parcel2, 0);
        parcel2.readException();
        return i.a.a(parcel2.readStrongBinder());
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public c a() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        c c;
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        this.a.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          c = (c)c.CREATOR.createFromParcel(parcel2);
        } else {
          c = null;
        } 
        return c;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public IBinder asBinder() {
      return this.a;
    }
    
    public e b() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        this.a.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        return e.a.a(parcel2.readStrongBinder());
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public i b(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        parcel1.writeInt(param1Int);
        this.a.transact(5, parcel1, parcel2, 0);
        parcel2.readException();
        return i.a.a(parcel2.readStrongBinder());
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public y c() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        this.a.transact(6, parcel1, parcel2, 0);
        parcel2.readException();
        return y.a.a(parcel2.readStrongBinder());
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public ab d() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        this.a.transact(7, parcel1, parcel2, 0);
        parcel2.readException();
        return ab.a.a(parcel2.readStrongBinder());
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public h e() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        this.a.transact(8, parcel1, parcel2, 0);
        parcel2.readException();
        return h.a.a(parcel2.readStrongBinder());
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public f f() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        this.a.transact(9, parcel1, parcel2, 0);
        parcel2.readException();
        return f.a.a(parcel2.readStrongBinder());
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public s g() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        this.a.transact(10, parcel1, parcel2, 0);
        parcel2.readException();
        return s.a.a(parcel2.readStrongBinder());
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public ad h() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        this.a.transact(11, parcel1, parcel2, 0);
        parcel2.readException();
        return ad.a.a(parcel2.readStrongBinder());
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public n i() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        this.a.transact(12, parcel1, parcel2, 0);
        parcel2.readException();
        return n.a.a(parcel2.readStrongBinder());
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public j j() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        this.a.transact(13, parcel1, parcel2, 0);
        parcel2.readException();
        return j.a.a(parcel2.readStrongBinder());
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public g k() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        this.a.transact(14, parcel1, parcel2, 0);
        parcel2.readException();
        return g.a.a(parcel2.readStrongBinder());
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */