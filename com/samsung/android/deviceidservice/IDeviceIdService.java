package com.samsung.android.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface IDeviceIdService extends IInterface {
  String getAAID(String paramString);
  
  String getOAID();
  
  String getVAID(String paramString);
  
  public static abstract class Stub extends Binder implements IDeviceIdService {
    public Stub() {
      attachInterface(this, "com.samsung.android.deviceidservice.IDeviceIdService");
    }
    
    public static IDeviceIdService a(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
      return (iInterface != null && iInterface instanceof IDeviceIdService) ? (IDeviceIdService)iInterface : new Proxy(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) {
      if (param1Int1 != 1) {
        if (param1Int1 != 2) {
          if (param1Int1 != 3) {
            if (param1Int1 != 1598968902)
              return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); 
            param1Parcel2.writeString("com.samsung.android.deviceidservice.IDeviceIdService");
            return true;
          } 
          param1Parcel1.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
          str = getAAID(param1Parcel1.readString());
          param1Parcel2.writeNoException();
          param1Parcel2.writeString(str);
          return true;
        } 
        str.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
        str = getVAID(str.readString());
        param1Parcel2.writeNoException();
        param1Parcel2.writeString(str);
        return true;
      } 
      str.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
      String str = getOAID();
      param1Parcel2.writeNoException();
      param1Parcel2.writeString(str);
      return true;
    }
    
    private static class Proxy implements IDeviceIdService {
      private IBinder a;
      
      Proxy(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.a;
      }
      
      public String getAAID(String param2String) {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
          parcel1.writeString(param2String);
          this.a.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          param2String = parcel2.readString();
          return param2String;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public String getOAID() {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
          this.a.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readString();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public String getVAID(String param2String) {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
          parcel1.writeString(param2String);
          this.a.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          param2String = parcel2.readString();
          return param2String;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  private static class Proxy implements IDeviceIdService {
    private IBinder a;
    
    Proxy(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.a;
    }
    
    public String getAAID(String param1String) {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
        parcel1.writeString(param1String);
        this.a.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        param1String = parcel2.readString();
        return param1String;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public String getOAID() {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
        this.a.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readString();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public String getVAID(String param1String) {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
        parcel1.writeString(param1String);
        this.a.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        param1String = parcel2.readString();
        return param1String;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\samsung\android\deviceidservice\IDeviceIdService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */