package com.huawei.multimedia.liteav.audioengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IHwAudioKaraokeFeature extends IInterface {
  int a(String paramString, int paramInt) throws RemoteException;
  
  int a(boolean paramBoolean) throws RemoteException;
  
  void a(String paramString) throws RemoteException;
  
  boolean a() throws RemoteException;
  
  int b() throws RemoteException;
  
  public static abstract class Stub extends Binder implements IHwAudioKaraokeFeature {
    public Stub() {
      attachInterface(this, "com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
    }
    
    public static IHwAudioKaraokeFeature a(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
      return (iInterface != null && iInterface instanceof IHwAudioKaraokeFeature) ? (IHwAudioKaraokeFeature)iInterface : new Proxy(param1IBinder);
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    static class Proxy implements IHwAudioKaraokeFeature {
      private IBinder a;
      
      Proxy(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public int a(String param2String, int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
          parcel1.writeString(param2String);
          parcel1.writeInt(param2Int);
          this.a.transact(4, parcel1, parcel2, 0);
          parcel2.readException();
          param2Int = parcel2.readInt();
          return param2Int;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public int a(boolean param2Boolean) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
        
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        int i = 0;
        parcel1.writeInt(i);
        this.a.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public void a(String param2String) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
          parcel1.writeString(param2String);
          this.a.transact(5, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean a() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
          IBinder iBinder = this.a;
          boolean bool = false;
          iBinder.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          int i = parcel2.readInt();
          if (i != 0)
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
      
      public int b() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
          this.a.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readInt();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  static class Proxy implements IHwAudioKaraokeFeature {
    private IBinder a;
    
    Proxy(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public int a(String param1String, int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
        parcel1.writeString(param1String);
        parcel1.writeInt(param1Int);
        this.a.transact(4, parcel1, parcel2, 0);
        parcel2.readException();
        param1Int = parcel2.readInt();
        return param1Int;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public int a(boolean param1Boolean) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
      
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      int i = 0;
      parcel1.writeInt(i);
      this.a.transact(2, parcel1, parcel2, 0);
      parcel2.readException();
      i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public void a(String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
        parcel1.writeString(param1String);
        this.a.transact(5, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean a() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        if (i != 0)
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
    
    public int b() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
        this.a.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\multimedia\liteav\audioengine\IHwAudioKaraokeFeature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */