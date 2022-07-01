package com.asus.msa.SupplementaryDID;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface IDidAidlInterface extends IInterface {
  boolean a();
  
  String getAAID();
  
  String getOAID();
  
  String getUDID();
  
  String getVAID();
  
  public static abstract class Stub extends Binder implements IDidAidlInterface {
    public Stub() {
      attachInterface(this, "com.asus.msa.SupplementaryDID.IDidAidlInterface");
    }
    
    public static native IDidAidlInterface a(IBinder param1IBinder);
    
    public native IBinder asBinder();
    
    public native boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2);
    
    public static class Proxy implements IDidAidlInterface {
      public IBinder a;
      
      public Proxy(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public native boolean a();
      
      public native IBinder asBinder();
      
      public native String getAAID();
      
      public native String getOAID();
      
      public native String getUDID();
      
      public native String getVAID();
    }
  }
  
  public static class Proxy implements IDidAidlInterface {
    public IBinder a;
    
    public Proxy(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public native boolean a();
    
    public native IBinder asBinder();
    
    public native String getAAID();
    
    public native String getOAID();
    
    public native String getUDID();
    
    public native String getVAID();
  }
  
  public static class Proxy implements IDidAidlInterface {
    public IBinder a;
    
    public Proxy(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public native boolean a();
    
    public native IBinder asBinder();
    
    public native String getAAID();
    
    public native String getOAID();
    
    public native String getUDID();
    
    public native String getVAID();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\asus\msa\SupplementaryDID\IDidAidlInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */