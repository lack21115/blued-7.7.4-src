package com.asus.msa.sdid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

public interface IDIDBinderStatusListener extends IInterface {
  void a(IDidAidlInterface paramIDidAidlInterface);
  
  void b();
  
  public static abstract class Stub extends Binder implements IDIDBinderStatusListener {
    public Stub() {
      attachInterface(this, "com.asus.msa.sdid.IDIDBinderStatusListener");
    }
    
    public native IBinder asBinder();
    
    public native boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2);
    
    public static class Proxy implements IDIDBinderStatusListener {
      public IBinder a;
      
      public native void a(IDidAidlInterface param2IDidAidlInterface);
      
      public native IBinder asBinder();
      
      public native void b();
    }
  }
  
  public static class Proxy implements IDIDBinderStatusListener {
    public IBinder a;
    
    public native void a(IDidAidlInterface param1IDidAidlInterface);
    
    public native IBinder asBinder();
    
    public native void b();
  }
  
  public static class Proxy implements IDIDBinderStatusListener {
    public IBinder a;
    
    public native void a(IDidAidlInterface param1IDidAidlInterface);
    
    public native IBinder asBinder();
    
    public native void b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\asus\msa\sdid\IDIDBinderStatusListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */