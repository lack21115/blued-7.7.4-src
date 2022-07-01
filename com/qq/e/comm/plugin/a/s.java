package com.qq.e.comm.plugin.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface s extends IInterface {
  int a(c paramc) throws RemoteException;
  
  int a(String paramString) throws RemoteException;
  
  List<c> a() throws RemoteException;
  
  boolean a(int paramInt) throws RemoteException;
  
  boolean a(int paramInt1, int paramInt2) throws RemoteException;
  
  boolean a(int paramInt1, int paramInt2, long paramLong) throws RemoteException;
  
  boolean a(int paramInt1, String paramString, int paramInt2) throws RemoteException;
  
  List<c> b() throws RemoteException;
  
  public static abstract class a extends Binder implements s {
    public a() {
      attachInterface(this, "com.qq.e.comm.plugin.apkmanager.IDownloadService");
    }
    
    public static s a(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
      return (iInterface != null && iInterface instanceof s) ? (s)iInterface : new a(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    static class a implements s {
      private IBinder a;
      
      a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public int a(c param2c) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
          if (param2c != null) {
            parcel1.writeInt(1);
            param2c.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(4, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readInt();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public int a(String param2String) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
          parcel1.writeString(param2String);
          this.a.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readInt();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public List<c> a() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
          this.a.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.createTypedArrayList(c.a);
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean a(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
          parcel1.writeInt(param2Int);
          IBinder iBinder = this.a;
          boolean bool = false;
          iBinder.transact(6, parcel1, parcel2, 0);
          parcel2.readException();
          param2Int = parcel2.readInt();
          if (param2Int != 0)
            bool = true; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean a(int param2Int1, int param2Int2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
          parcel1.writeInt(param2Int1);
          parcel1.writeInt(param2Int2);
          IBinder iBinder = this.a;
          boolean bool = false;
          iBinder.transact(5, parcel1, parcel2, 0);
          parcel2.readException();
          param2Int1 = parcel2.readInt();
          if (param2Int1 != 0)
            bool = true; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean a(int param2Int1, int param2Int2, long param2Long) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
          parcel1.writeInt(param2Int1);
          parcel1.writeInt(param2Int2);
          parcel1.writeLong(param2Long);
          IBinder iBinder = this.a;
          boolean bool = false;
          iBinder.transact(8, parcel1, parcel2, 0);
          parcel2.readException();
          param2Int1 = parcel2.readInt();
          if (param2Int1 != 0)
            bool = true; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean a(int param2Int1, String param2String, int param2Int2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
          parcel1.writeInt(param2Int1);
          parcel1.writeString(param2String);
          parcel1.writeInt(param2Int2);
          IBinder iBinder = this.a;
          boolean bool = false;
          iBinder.transact(7, parcel1, parcel2, 0);
          parcel2.readException();
          param2Int1 = parcel2.readInt();
          if (param2Int1 != 0)
            bool = true; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public IBinder asBinder() {
        return this.a;
      }
      
      public List<c> b() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
          this.a.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.createTypedArrayList(c.a);
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  static class a implements s {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public int a(c param1c) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
        if (param1c != null) {
          parcel1.writeInt(1);
          param1c.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(4, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public int a(String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
        parcel1.writeString(param1String);
        this.a.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public List<c> a() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
        this.a.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.createTypedArrayList(c.a);
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean a(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
        parcel1.writeInt(param1Int);
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(6, parcel1, parcel2, 0);
        parcel2.readException();
        param1Int = parcel2.readInt();
        if (param1Int != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean a(int param1Int1, int param1Int2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(5, parcel1, parcel2, 0);
        parcel2.readException();
        param1Int1 = parcel2.readInt();
        if (param1Int1 != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean a(int param1Int1, int param1Int2, long param1Long) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        parcel1.writeLong(param1Long);
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(8, parcel1, parcel2, 0);
        parcel2.readException();
        param1Int1 = parcel2.readInt();
        if (param1Int1 != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean a(int param1Int1, String param1String, int param1Int2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
        parcel1.writeInt(param1Int1);
        parcel1.writeString(param1String);
        parcel1.writeInt(param1Int2);
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(7, parcel1, parcel2, 0);
        parcel2.readException();
        param1Int1 = parcel2.readInt();
        if (param1Int1 != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public IBinder asBinder() {
      return this.a;
    }
    
    public List<c> b() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
        this.a.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.createTypedArrayList(c.a);
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
  
  static class a implements s {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public int a(c param1c) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
        if (param1c != null) {
          parcel1.writeInt(1);
          param1c.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(4, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public int a(String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
        parcel1.writeString(param1String);
        this.a.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public List<c> a() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
        this.a.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.createTypedArrayList(c.a);
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean a(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
        parcel1.writeInt(param1Int);
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(6, parcel1, parcel2, 0);
        parcel2.readException();
        param1Int = parcel2.readInt();
        if (param1Int != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean a(int param1Int1, int param1Int2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(5, parcel1, parcel2, 0);
        parcel2.readException();
        param1Int1 = parcel2.readInt();
        if (param1Int1 != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean a(int param1Int1, int param1Int2, long param1Long) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        parcel1.writeLong(param1Long);
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(8, parcel1, parcel2, 0);
        parcel2.readException();
        param1Int1 = parcel2.readInt();
        if (param1Int1 != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean a(int param1Int1, String param1String, int param1Int2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
        parcel1.writeInt(param1Int1);
        parcel1.writeString(param1String);
        parcel1.writeInt(param1Int2);
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(7, parcel1, parcel2, 0);
        parcel2.readException();
        param1Int1 = parcel2.readInt();
        if (param1Int1 != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public IBinder asBinder() {
      return this.a;
    }
    
    public List<c> b() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
        this.a.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.createTypedArrayList(c.a);
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */