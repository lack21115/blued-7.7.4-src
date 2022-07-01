package com.bytedance.sdk.openadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IRewardAdInteractionListener extends IInterface {
  void onAdClose() throws RemoteException;
  
  void onAdShow() throws RemoteException;
  
  void onAdVideoBarClick() throws RemoteException;
  
  void onDestroy() throws RemoteException;
  
  void onRewardVerify(boolean paramBoolean, int paramInt, String paramString) throws RemoteException;
  
  void onSkippedVideo() throws RemoteException;
  
  void onVideoComplete() throws RemoteException;
  
  void onVideoError() throws RemoteException;
  
  public static abstract class Stub extends Binder implements IRewardAdInteractionListener {
    public Stub() {
      attachInterface(this, "com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
    }
    
    public static IRewardAdInteractionListener asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
      return (iInterface != null && iInterface instanceof IRewardAdInteractionListener) ? (IRewardAdInteractionListener)iInterface : new a(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      if (param1Int1 != 1598968902) {
        boolean bool;
        switch (param1Int1) {
          default:
            return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
          case 8:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
            onSkippedVideo();
            param1Parcel2.writeNoException();
            return true;
          case 7:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
            if (param1Parcel1.readInt() != 0) {
              bool = true;
            } else {
              bool = false;
            } 
            onRewardVerify(bool, param1Parcel1.readInt(), param1Parcel1.readString());
            param1Parcel2.writeNoException();
            return true;
          case 6:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
            onVideoError();
            param1Parcel2.writeNoException();
            return true;
          case 5:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
            onVideoComplete();
            param1Parcel2.writeNoException();
            return true;
          case 4:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
            onAdClose();
            param1Parcel2.writeNoException();
            return true;
          case 3:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
            onAdVideoBarClick();
            param1Parcel2.writeNoException();
            return true;
          case 2:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
            onAdShow();
            param1Parcel2.writeNoException();
            return true;
          case 1:
            break;
        } 
        param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
        onDestroy();
        param1Parcel2.writeNoException();
        return true;
      } 
      param1Parcel2.writeString("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
      return true;
    }
    
    static class a implements IRewardAdInteractionListener {
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
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
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
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
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
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
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
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
          this.a.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void onRewardVerify(boolean param2Boolean, int param2Int, String param2String) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          boolean bool;
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
          if (param2Boolean) {
            bool = true;
          } else {
            bool = false;
          } 
          parcel1.writeInt(bool);
          parcel1.writeInt(param2Int);
          parcel1.writeString(param2String);
          this.a.transact(7, parcel1, parcel2, 0);
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
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
          this.a.transact(8, parcel1, parcel2, 0);
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
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
          this.a.transact(5, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void onVideoError() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
          this.a.transact(6, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  static class a implements IRewardAdInteractionListener {
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
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
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
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
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
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
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
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
        this.a.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void onRewardVerify(boolean param1Boolean, int param1Int, String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        boolean bool;
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
        if (param1Boolean) {
          bool = true;
        } else {
          bool = false;
        } 
        parcel1.writeInt(bool);
        parcel1.writeInt(param1Int);
        parcel1.writeString(param1String);
        this.a.transact(7, parcel1, parcel2, 0);
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
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
        this.a.transact(8, parcel1, parcel2, 0);
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
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
        this.a.transact(5, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void onVideoError() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
        this.a.transact(6, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\IRewardAdInteractionListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */