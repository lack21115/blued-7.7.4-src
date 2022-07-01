package com.huawei.multimedia.liteav.audioengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface IHwAudioEngine extends IInterface {
  List a() throws RemoteException;
  
  void a(String paramString1, String paramString2) throws RemoteException;
  
  boolean a(int paramInt) throws RemoteException;
  
  public static abstract class Stub extends Binder implements IHwAudioEngine {
    public Stub() {
      attachInterface(this, "com.huawei.multimedia.audioengine.IHwAudioEngine");
    }
    
    public static IHwAudioEngine a(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.huawei.multimedia.audioengine.IHwAudioEngine");
      return (iInterface != null && iInterface instanceof IHwAudioEngine) ? (IHwAudioEngine)iInterface : new Proxy(param1IBinder);
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    static class Proxy implements IHwAudioEngine {
      private IBinder a;
      
      Proxy(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public List a() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioEngine");
          this.a.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readArrayList(getClass().getClassLoader());
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioEngine");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          this.a.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean a(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioEngine");
          parcel1.writeInt(param2Int);
          IBinder iBinder = this.a;
          boolean bool = false;
          iBinder.transact(2, parcel1, parcel2, 0);
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
      
      public IBinder asBinder() {
        return this.a;
      }
    }
  }
  
  static class Proxy implements IHwAudioEngine {
    private IBinder a;
    
    Proxy(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public List a() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioEngine");
        this.a.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readArrayList(getClass().getClassLoader());
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioEngine");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        this.a.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean a(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioEngine");
        parcel1.writeInt(param1Int);
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(2, parcel1, parcel2, 0);
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
    
    public IBinder asBinder() {
      return this.a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\multimedia\liteav\audioengine\IHwAudioEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */