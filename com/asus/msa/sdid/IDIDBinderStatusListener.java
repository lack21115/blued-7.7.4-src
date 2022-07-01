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
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) {
      if (param1Int1 != 1) {
        if (param1Int1 != 2) {
          if (param1Int1 != 1598968902)
            return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); 
          param1Parcel2.writeString("com.asus.msa.sdid.IDIDBinderStatusListener");
          return true;
        } 
        param1Parcel1.enforceInterface("com.asus.msa.sdid.IDIDBinderStatusListener");
        b();
        param1Parcel2.writeNoException();
        return true;
      } 
      param1Parcel1.enforceInterface("com.asus.msa.sdid.IDIDBinderStatusListener");
      a(IDidAidlInterface.Stub.a(param1Parcel1.readStrongBinder()));
      param1Parcel2.writeNoException();
      return true;
    }
    
    public static class Proxy implements IDIDBinderStatusListener {
      public IBinder a;
      
      public void a(IDidAidlInterface param2IDidAidlInterface) {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.asus.msa.sdid.IDIDBinderStatusListener");
          if (param2IDidAidlInterface != null) {
            IBinder iBinder = param2IDidAidlInterface.asBinder();
          } else {
            param2IDidAidlInterface = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2IDidAidlInterface);
          this.a.transact(1, parcel1, parcel2, 0);
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
      
      public void b() {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.asus.msa.sdid.IDIDBinderStatusListener");
          this.a.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  public static class Proxy implements IDIDBinderStatusListener {
    public IBinder a;
    
    public void a(IDidAidlInterface param1IDidAidlInterface) {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.asus.msa.sdid.IDIDBinderStatusListener");
        if (param1IDidAidlInterface != null) {
          IBinder iBinder = param1IDidAidlInterface.asBinder();
        } else {
          param1IDidAidlInterface = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1IDidAidlInterface);
        this.a.transact(1, parcel1, parcel2, 0);
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
    
    public void b() {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.asus.msa.sdid.IDIDBinderStatusListener");
        this.a.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\asus\msa\sdid\IDIDBinderStatusListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */