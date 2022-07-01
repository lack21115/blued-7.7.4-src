package com.bytedance.sdk.openadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IFullScreenVideoAdInteractionListener extends IInterface {
  void onAdClose() throws RemoteException;
  
  void onAdShow() throws RemoteException;
  
  void onAdVideoBarClick() throws RemoteException;
  
  void onDestroy() throws RemoteException;
  
  void onSkippedVideo() throws RemoteException;
  
  void onVideoComplete() throws RemoteException;
  
  public static abstract class Stub extends Binder implements IFullScreenVideoAdInteractionListener {
    public Stub() {
      attachInterface(this, "com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
    }
    
    public static IFullScreenVideoAdInteractionListener asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
      return (iInterface != null && iInterface instanceof IFullScreenVideoAdInteractionListener) ? (IFullScreenVideoAdInteractionListener)iInterface : new a(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      if (param1Int1 != 1598968902) {
        switch (param1Int1) {
          default:
            return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
          case 6:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
            onSkippedVideo();
            param1Parcel2.writeNoException();
            return true;
          case 5:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
            onVideoComplete();
            param1Parcel2.writeNoException();
            return true;
          case 4:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
            onAdClose();
            param1Parcel2.writeNoException();
            return true;
          case 3:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
            onAdVideoBarClick();
            param1Parcel2.writeNoException();
            return true;
          case 2:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
            onAdShow();
            param1Parcel2.writeNoException();
            return true;
          case 1:
            break;
        } 
        param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
        onDestroy();
        param1Parcel2.writeNoException();
        return true;
      } 
      param1Parcel2.writeString("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
      return true;
    }
    
    static class a implements IFullScreenVideoAdInteractionListener {
      private IBinder a;
      
      a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.a;
      }
      
      public void onAdClose() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
          this.a.transact(4, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void onAdShow() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
          this.a.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void onAdVideoBarClick() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
          this.a.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void onDestroy() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
          this.a.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void onSkippedVideo() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
          this.a.transact(6, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void onVideoComplete() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
          this.a.transact(5, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  static class a implements IFullScreenVideoAdInteractionListener {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.a;
    }
    
    public void onAdClose() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
        this.a.transact(4, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void onAdShow() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
        this.a.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void onAdVideoBarClick() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
        this.a.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void onDestroy() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
        this.a.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void onSkippedVideo() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
        this.a.transact(6, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void onVideoComplete() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
        this.a.transact(5, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\IFullScreenVideoAdInteractionListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */