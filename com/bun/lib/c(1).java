package com.bun.lib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface c extends IInterface {
  boolean c();
  
  String getAAID();
  
  String getOAID();
  
  String getVAID();
  
  boolean isSupported();
  
  void shutDown();
  
  public static abstract class a extends Binder implements c {
    public static native c a(IBinder param1IBinder);
    
    static class a implements c {
      private IBinder a;
      
      a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public native IBinder asBinder();
      
      public native boolean c();
      
      public native String getAAID();
      
      public native String getOAID();
      
      public native String getVAID();
      
      public native boolean isSupported();
      
      public native void shutDown();
    }
  }
  
  static class a implements c {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public native IBinder asBinder();
    
    public native boolean c();
    
    public native String getAAID();
    
    public native String getOAID();
    
    public native String getVAID();
    
    public native boolean isSupported();
    
    public native void shutDown();
  }
  
  static class a implements c {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public native IBinder asBinder();
    
    public native boolean c();
    
    public native String getAAID();
    
    public native String getOAID();
    
    public native String getVAID();
    
    public native boolean isSupported();
    
    public native void shutDown();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bun\lib\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */