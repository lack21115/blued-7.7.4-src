package com.bytedance.sdk.openadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IListenerManager extends IInterface {
  void broadcastDialogListener(String paramString, int paramInt) throws RemoteException;
  
  void broadcastPermissionListener(String paramString1, String paramString2) throws RemoteException;
  
  void executeAppDownloadCallback(String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3, String paramString4) throws RemoteException;
  
  void executeFullVideoCallback(String paramString1, String paramString2) throws RemoteException;
  
  void executeRewardVideoCallback(String paramString1, String paramString2, boolean paramBoolean, int paramInt, String paramString3) throws RemoteException;
  
  void registerDialogListener(String paramString, ICommonDialogListener paramICommonDialogListener) throws RemoteException;
  
  void registerFullVideoListener(String paramString, IFullScreenVideoAdInteractionListener paramIFullScreenVideoAdInteractionListener) throws RemoteException;
  
  void registerPermissionListener(String paramString, ICommonPermissionListener paramICommonPermissionListener) throws RemoteException;
  
  void registerRewardVideoListener(String paramString, IRewardAdInteractionListener paramIRewardAdInteractionListener) throws RemoteException;
  
  void registerTTAppDownloadListener(String paramString, ITTAppDownloadListener paramITTAppDownloadListener) throws RemoteException;
  
  void unregisterTTAppDownloadListener(String paramString, ITTAppDownloadListener paramITTAppDownloadListener) throws RemoteException;
  
  public static abstract class Stub extends Binder implements IListenerManager {
    public Stub() {
      attachInterface(this, "com.bytedance.sdk.openadsdk.IListenerManager");
    }
    
    public static IListenerManager asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.IListenerManager");
      return (iInterface != null && iInterface instanceof IListenerManager) ? (IListenerManager)iInterface : new a(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      if (param1Int1 != 1598968902) {
        boolean bool;
        String str1;
        String str2;
        switch (param1Int1) {
          default:
            return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
          case 11:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
            broadcastPermissionListener(param1Parcel1.readString(), param1Parcel1.readString());
            param1Parcel2.writeNoException();
            return true;
          case 10:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
            registerPermissionListener(param1Parcel1.readString(), ICommonPermissionListener.Stub.asInterface(param1Parcel1.readStrongBinder()));
            param1Parcel2.writeNoException();
            return true;
          case 9:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
            broadcastDialogListener(param1Parcel1.readString(), param1Parcel1.readInt());
            param1Parcel2.writeNoException();
            return true;
          case 8:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
            registerDialogListener(param1Parcel1.readString(), ICommonDialogListener.Stub.asInterface(param1Parcel1.readStrongBinder()));
            param1Parcel2.writeNoException();
            return true;
          case 7:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
            executeAppDownloadCallback(param1Parcel1.readString(), param1Parcel1.readString(), param1Parcel1.readLong(), param1Parcel1.readLong(), param1Parcel1.readString(), param1Parcel1.readString());
            param1Parcel2.writeNoException();
            return true;
          case 6:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
            unregisterTTAppDownloadListener(param1Parcel1.readString(), ITTAppDownloadListener.Stub.asInterface(param1Parcel1.readStrongBinder()));
            param1Parcel2.writeNoException();
            return true;
          case 5:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
            registerTTAppDownloadListener(param1Parcel1.readString(), ITTAppDownloadListener.Stub.asInterface(param1Parcel1.readStrongBinder()));
            param1Parcel2.writeNoException();
            return true;
          case 4:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
            executeFullVideoCallback(param1Parcel1.readString(), param1Parcel1.readString());
            param1Parcel2.writeNoException();
            return true;
          case 3:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
            registerFullVideoListener(param1Parcel1.readString(), IFullScreenVideoAdInteractionListener.Stub.asInterface(param1Parcel1.readStrongBinder()));
            param1Parcel2.writeNoException();
            return true;
          case 2:
            param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
            str1 = param1Parcel1.readString();
            str2 = param1Parcel1.readString();
            if (param1Parcel1.readInt() != 0) {
              bool = true;
            } else {
              bool = false;
            } 
            executeRewardVideoCallback(str1, str2, bool, param1Parcel1.readInt(), param1Parcel1.readString());
            param1Parcel2.writeNoException();
            return true;
          case 1:
            break;
        } 
        param1Parcel1.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
        registerRewardVideoListener(param1Parcel1.readString(), IRewardAdInteractionListener.Stub.asInterface(param1Parcel1.readStrongBinder()));
        param1Parcel2.writeNoException();
        return true;
      } 
      param1Parcel2.writeString("com.bytedance.sdk.openadsdk.IListenerManager");
      return true;
    }
    
    static class a implements IListenerManager {
      private IBinder a;
      
      a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.a;
      }
      
      public void broadcastDialogListener(String param2String, int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
          parcel1.writeString(param2String);
          parcel1.writeInt(param2Int);
          this.a.transact(9, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void broadcastPermissionListener(String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          this.a.transact(11, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void executeAppDownloadCallback(String param2String1, String param2String2, long param2Long1, long param2Long2, String param2String3, String param2String4) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          parcel1.writeLong(param2Long1);
          parcel1.writeLong(param2Long2);
          parcel1.writeString(param2String3);
          parcel1.writeString(param2String4);
          this.a.transact(7, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void executeFullVideoCallback(String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
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
      
      public void executeRewardVideoCallback(String param2String1, String param2String2, boolean param2Boolean, int param2Int, String param2String3) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          boolean bool;
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          if (param2Boolean) {
            bool = true;
          } else {
            bool = false;
          } 
          parcel1.writeInt(bool);
          parcel1.writeInt(param2Int);
          parcel1.writeString(param2String3);
          this.a.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void registerDialogListener(String param2String, ICommonDialogListener param2ICommonDialogListener) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
          parcel1.writeString(param2String);
          if (param2ICommonDialogListener != null) {
            IBinder iBinder = param2ICommonDialogListener.asBinder();
          } else {
            param2String = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2String);
          this.a.transact(8, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void registerFullVideoListener(String param2String, IFullScreenVideoAdInteractionListener param2IFullScreenVideoAdInteractionListener) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
          parcel1.writeString(param2String);
          if (param2IFullScreenVideoAdInteractionListener != null) {
            IBinder iBinder = param2IFullScreenVideoAdInteractionListener.asBinder();
          } else {
            param2String = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2String);
          this.a.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void registerPermissionListener(String param2String, ICommonPermissionListener param2ICommonPermissionListener) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
          parcel1.writeString(param2String);
          if (param2ICommonPermissionListener != null) {
            IBinder iBinder = param2ICommonPermissionListener.asBinder();
          } else {
            param2String = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2String);
          this.a.transact(10, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void registerRewardVideoListener(String param2String, IRewardAdInteractionListener param2IRewardAdInteractionListener) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
          parcel1.writeString(param2String);
          if (param2IRewardAdInteractionListener != null) {
            IBinder iBinder = param2IRewardAdInteractionListener.asBinder();
          } else {
            param2String = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2String);
          this.a.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void registerTTAppDownloadListener(String param2String, ITTAppDownloadListener param2ITTAppDownloadListener) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
          parcel1.writeString(param2String);
          if (param2ITTAppDownloadListener != null) {
            IBinder iBinder = param2ITTAppDownloadListener.asBinder();
          } else {
            param2String = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2String);
          this.a.transact(5, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void unregisterTTAppDownloadListener(String param2String, ITTAppDownloadListener param2ITTAppDownloadListener) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
          parcel1.writeString(param2String);
          if (param2ITTAppDownloadListener != null) {
            IBinder iBinder = param2ITTAppDownloadListener.asBinder();
          } else {
            param2String = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2String);
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
  
  static class a implements IListenerManager {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.a;
    }
    
    public void broadcastDialogListener(String param1String, int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
        parcel1.writeString(param1String);
        parcel1.writeInt(param1Int);
        this.a.transact(9, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void broadcastPermissionListener(String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        this.a.transact(11, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void executeAppDownloadCallback(String param1String1, String param1String2, long param1Long1, long param1Long2, String param1String3, String param1String4) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        parcel1.writeLong(param1Long1);
        parcel1.writeLong(param1Long2);
        parcel1.writeString(param1String3);
        parcel1.writeString(param1String4);
        this.a.transact(7, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void executeFullVideoCallback(String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
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
    
    public void executeRewardVideoCallback(String param1String1, String param1String2, boolean param1Boolean, int param1Int, String param1String3) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        boolean bool;
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        if (param1Boolean) {
          bool = true;
        } else {
          bool = false;
        } 
        parcel1.writeInt(bool);
        parcel1.writeInt(param1Int);
        parcel1.writeString(param1String3);
        this.a.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void registerDialogListener(String param1String, ICommonDialogListener param1ICommonDialogListener) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
        parcel1.writeString(param1String);
        if (param1ICommonDialogListener != null) {
          IBinder iBinder = param1ICommonDialogListener.asBinder();
        } else {
          param1String = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1String);
        this.a.transact(8, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void registerFullVideoListener(String param1String, IFullScreenVideoAdInteractionListener param1IFullScreenVideoAdInteractionListener) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
        parcel1.writeString(param1String);
        if (param1IFullScreenVideoAdInteractionListener != null) {
          IBinder iBinder = param1IFullScreenVideoAdInteractionListener.asBinder();
        } else {
          param1String = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1String);
        this.a.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void registerPermissionListener(String param1String, ICommonPermissionListener param1ICommonPermissionListener) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
        parcel1.writeString(param1String);
        if (param1ICommonPermissionListener != null) {
          IBinder iBinder = param1ICommonPermissionListener.asBinder();
        } else {
          param1String = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1String);
        this.a.transact(10, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void registerRewardVideoListener(String param1String, IRewardAdInteractionListener param1IRewardAdInteractionListener) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
        parcel1.writeString(param1String);
        if (param1IRewardAdInteractionListener != null) {
          IBinder iBinder = param1IRewardAdInteractionListener.asBinder();
        } else {
          param1String = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1String);
        this.a.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void registerTTAppDownloadListener(String param1String, ITTAppDownloadListener param1ITTAppDownloadListener) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
        parcel1.writeString(param1String);
        if (param1ITTAppDownloadListener != null) {
          IBinder iBinder = param1ITTAppDownloadListener.asBinder();
        } else {
          param1String = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1String);
        this.a.transact(5, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void unregisterTTAppDownloadListener(String param1String, ITTAppDownloadListener param1ITTAppDownloadListener) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
        parcel1.writeString(param1String);
        if (param1ITTAppDownloadListener != null) {
          IBinder iBinder = param1ITTAppDownloadListener.asBinder();
        } else {
          param1String = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1String);
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\IListenerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */