package com.bytedance.sdk.openadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITTAppDownloadListener extends IInterface {
  void onDownloadActive(long paramLong1, long paramLong2, String paramString1, String paramString2) throws RemoteException;
  
  void onDownloadFailed(long paramLong1, long paramLong2, String paramString1, String paramString2) throws RemoteException;
  
  void onDownloadFinished(long paramLong, String paramString1, String paramString2) throws RemoteException;
  
  void onDownloadPaused(long paramLong1, long paramLong2, String paramString1, String paramString2) throws RemoteException;
  
  void onIdle() throws RemoteException;
  
  void onInstalled(String paramString1, String paramString2) throws RemoteException;
  
  public static abstract class Stub extends Binder implements ITTAppDownloadListener {
    public Stub() {
      attachInterface(this, "com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
    }
    
    public static ITTAppDownloadListener asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
      return (iInterface != null && iInterface instanceof ITTAppDownloadListener) ? (ITTAppDownloadListener)iInterface : new a(param1IBinder);
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
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
            onInstalled(param1Parcel1.readString(), param1Parcel1.readString());
            param1Parcel2.writeNoException();
            return true;
          case 5:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
            onDownloadFinished(param1Parcel1.readLong(), param1Parcel1.readString(), param1Parcel1.readString());
            param1Parcel2.writeNoException();
            return true;
          case 4:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
            onDownloadFailed(param1Parcel1.readLong(), param1Parcel1.readLong(), param1Parcel1.readString(), param1Parcel1.readString());
            param1Parcel2.writeNoException();
            return true;
          case 3:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
            onDownloadPaused(param1Parcel1.readLong(), param1Parcel1.readLong(), param1Parcel1.readString(), param1Parcel1.readString());
            param1Parcel2.writeNoException();
            return true;
          case 2:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
            onDownloadActive(param1Parcel1.readLong(), param1Parcel1.readLong(), param1Parcel1.readString(), param1Parcel1.readString());
            param1Parcel2.writeNoException();
            return true;
          case 1:
            break;
        } 
        param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
        onIdle();
        param1Parcel2.writeNoException();
        return true;
      } 
      param1Parcel2.writeString("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
      return true;
    }
    
    static class a implements ITTAppDownloadListener {
      private IBinder a;
      
      a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.a;
      }
      
      public void onDownloadActive(long param2Long1, long param2Long2, String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
          parcel1.writeLong(param2Long1);
          parcel1.writeLong(param2Long2);
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          this.a.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void onDownloadFailed(long param2Long1, long param2Long2, String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
          parcel1.writeLong(param2Long1);
          parcel1.writeLong(param2Long2);
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          this.a.transact(4, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void onDownloadFinished(long param2Long, String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
          parcel1.writeLong(param2Long);
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          this.a.transact(5, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void onDownloadPaused(long param2Long1, long param2Long2, String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
          parcel1.writeLong(param2Long1);
          parcel1.writeLong(param2Long2);
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
      
      public void onIdle() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
          this.a.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void onInstalled(String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
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
  
  static class a implements ITTAppDownloadListener {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.a;
    }
    
    public void onDownloadActive(long param1Long1, long param1Long2, String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
        parcel1.writeLong(param1Long1);
        parcel1.writeLong(param1Long2);
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        this.a.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void onDownloadFailed(long param1Long1, long param1Long2, String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
        parcel1.writeLong(param1Long1);
        parcel1.writeLong(param1Long2);
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        this.a.transact(4, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void onDownloadFinished(long param1Long, String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
        parcel1.writeLong(param1Long);
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        this.a.transact(5, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void onDownloadPaused(long param1Long1, long param1Long2, String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
        parcel1.writeLong(param1Long1);
        parcel1.writeLong(param1Long2);
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
    
    public void onIdle() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
        this.a.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void onInstalled(String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\ITTAppDownloadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */