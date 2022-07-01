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
    
    public static native IDeviceIdService a(IBinder param1IBinder);
    
    public native IBinder asBinder();
    
    public native boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2);
    
    static class Proxy implements IDeviceIdService {
      private IBinder a;
      
      Proxy(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public native IBinder asBinder();
      
      public native String getAAID(String param2String);
      
      public native String getOAID();
      
      public native String getVAID(String param2String);
    }
  }
  
  static class Proxy implements IDeviceIdService {
    private IBinder a;
    
    Proxy(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public native IBinder asBinder();
    
    public native String getAAID(String param1String);
    
    public native String getOAID();
    
    public native String getVAID(String param1String);
  }
  
  static class Proxy implements IDeviceIdService {
    private IBinder a;
    
    Proxy(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public native IBinder asBinder();
    
    public native String getAAID(String param1String);
    
    public native String getOAID();
    
    public native String getVAID(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\samsung\android\deviceidservice\IDeviceIdService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */