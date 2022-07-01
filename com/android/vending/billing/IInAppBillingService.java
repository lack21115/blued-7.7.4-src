package com.android.vending.billing;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface IInAppBillingService extends IInterface {
  int a(int paramInt, String paramString1, String paramString2) throws RemoteException;
  
  Bundle a(int paramInt, String paramString1, String paramString2, Bundle paramBundle) throws RemoteException;
  
  Bundle a(int paramInt, String paramString1, String paramString2, String paramString3) throws RemoteException;
  
  Bundle a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) throws RemoteException;
  
  Bundle a(int paramInt, String paramString1, List<String> paramList, String paramString2, String paramString3, String paramString4) throws RemoteException;
  
  int b(int paramInt, String paramString1, String paramString2) throws RemoteException;
  
  int c(int paramInt, String paramString1, String paramString2) throws RemoteException;
  
  public static class Default implements IInAppBillingService {
    public int a(int param1Int, String param1String1, String param1String2) throws RemoteException {
      return 0;
    }
    
    public Bundle a(int param1Int, String param1String1, String param1String2, Bundle param1Bundle) throws RemoteException {
      return null;
    }
    
    public Bundle a(int param1Int, String param1String1, String param1String2, String param1String3) throws RemoteException {
      return null;
    }
    
    public Bundle a(int param1Int, String param1String1, String param1String2, String param1String3, String param1String4) throws RemoteException {
      return null;
    }
    
    public Bundle a(int param1Int, String param1String1, List<String> param1List, String param1String2, String param1String3, String param1String4) throws RemoteException {
      return null;
    }
    
    public IBinder asBinder() {
      return null;
    }
    
    public int b(int param1Int, String param1String1, String param1String2) throws RemoteException {
      return 0;
    }
    
    public int c(int param1Int, String param1String1, String param1String2) throws RemoteException {
      return 0;
    }
  }
  
  public static abstract class Stub extends Binder implements IInAppBillingService {
    public Stub() {
      attachInterface(this, "com.android.vending.billing.IInAppBillingService");
    }
    
    public static IInAppBillingService a() {
      return Proxy.a;
    }
    
    public static IInAppBillingService a(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
      return (iInterface != null && iInterface instanceof IInAppBillingService) ? (IInAppBillingService)iInterface : new Proxy(param1IBinder);
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      if (param1Int1 != 1598968902) {
        Bundle bundle;
        String str1;
        String str2;
        switch (param1Int1) {
          default:
            return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
          case 7:
            param1Parcel1.enforceInterface("com.android.vending.billing.IInAppBillingService");
            bundle = a(param1Parcel1.readInt(), param1Parcel1.readString(), param1Parcel1.createStringArrayList(), param1Parcel1.readString(), param1Parcel1.readString(), param1Parcel1.readString());
            param1Parcel2.writeNoException();
            if (bundle != null) {
              param1Parcel2.writeInt(1);
              bundle.writeToParcel(param1Parcel2, 1);
              return true;
            } 
            param1Parcel2.writeInt(0);
            return true;
          case 6:
            bundle.enforceInterface("com.android.vending.billing.IInAppBillingService");
            param1Int1 = c(bundle.readInt(), bundle.readString(), bundle.readString());
            param1Parcel2.writeNoException();
            param1Parcel2.writeInt(param1Int1);
            return true;
          case 5:
            bundle.enforceInterface("com.android.vending.billing.IInAppBillingService");
            param1Int1 = b(bundle.readInt(), bundle.readString(), bundle.readString());
            param1Parcel2.writeNoException();
            param1Parcel2.writeInt(param1Int1);
            return true;
          case 4:
            bundle.enforceInterface("com.android.vending.billing.IInAppBillingService");
            bundle = a(bundle.readInt(), bundle.readString(), bundle.readString(), bundle.readString());
            param1Parcel2.writeNoException();
            if (bundle != null) {
              param1Parcel2.writeInt(1);
              bundle.writeToParcel(param1Parcel2, 1);
              return true;
            } 
            param1Parcel2.writeInt(0);
            return true;
          case 3:
            bundle.enforceInterface("com.android.vending.billing.IInAppBillingService");
            bundle = a(bundle.readInt(), bundle.readString(), bundle.readString(), bundle.readString(), bundle.readString());
            param1Parcel2.writeNoException();
            if (bundle != null) {
              param1Parcel2.writeInt(1);
              bundle.writeToParcel(param1Parcel2, 1);
              return true;
            } 
            param1Parcel2.writeInt(0);
            return true;
          case 2:
            bundle.enforceInterface("com.android.vending.billing.IInAppBillingService");
            param1Int1 = bundle.readInt();
            str1 = bundle.readString();
            str2 = bundle.readString();
            if (bundle.readInt() != 0) {
              bundle = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)bundle);
            } else {
              bundle = null;
            } 
            bundle = a(param1Int1, str1, str2, bundle);
            param1Parcel2.writeNoException();
            if (bundle != null) {
              param1Parcel2.writeInt(1);
              bundle.writeToParcel(param1Parcel2, 1);
              return true;
            } 
            param1Parcel2.writeInt(0);
            return true;
          case 1:
            break;
        } 
        bundle.enforceInterface("com.android.vending.billing.IInAppBillingService");
        param1Int1 = a(bundle.readInt(), bundle.readString(), bundle.readString());
        param1Parcel2.writeNoException();
        param1Parcel2.writeInt(param1Int1);
        return true;
      } 
      param1Parcel2.writeString("com.android.vending.billing.IInAppBillingService");
      return true;
    }
    
    static class Proxy implements IInAppBillingService {
      public static IInAppBillingService a;
      
      private IBinder b;
      
      Proxy(IBinder param2IBinder) {
        this.b = param2IBinder;
      }
      
      public int a(int param2Int, String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
          parcel1.writeInt(param2Int);
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          if (!this.b.transact(1, parcel1, parcel2, 0) && IInAppBillingService.Stub.a() != null) {
            param2Int = IInAppBillingService.Stub.a().a(param2Int, param2String1, param2String2);
            return param2Int;
          } 
          parcel2.readException();
          param2Int = parcel2.readInt();
          return param2Int;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public Bundle a(int param2Int, String param2String1, String param2String2, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
          parcel1.writeInt(param2Int);
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.b.transact(2, parcel1, parcel2, 0) && IInAppBillingService.Stub.a() != null)
            return IInAppBillingService.Stub.a().a(param2Int, param2String1, param2String2, param2Bundle); 
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
          } else {
            param2String1 = null;
          } 
          return (Bundle)param2String1;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public Bundle a(int param2Int, String param2String1, String param2String2, String param2String3) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
          parcel1.writeInt(param2Int);
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          parcel1.writeString(param2String3);
          if (!this.b.transact(4, parcel1, parcel2, 0) && IInAppBillingService.Stub.a() != null)
            return IInAppBillingService.Stub.a().a(param2Int, param2String1, param2String2, param2String3); 
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
          } else {
            param2String1 = null;
          } 
          return (Bundle)param2String1;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public Bundle a(int param2Int, String param2String1, String param2String2, String param2String3, String param2String4) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
          parcel1.writeInt(param2Int);
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          parcel1.writeString(param2String3);
          parcel1.writeString(param2String4);
          if (!this.b.transact(3, parcel1, parcel2, 0) && IInAppBillingService.Stub.a() != null)
            return IInAppBillingService.Stub.a().a(param2Int, param2String1, param2String2, param2String3, param2String4); 
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
          } else {
            param2String1 = null;
          } 
          return (Bundle)param2String1;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public Bundle a(int param2Int, String param2String1, List<String> param2List, String param2String2, String param2String3, String param2String4) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
          parcel1.writeInt(param2Int);
          parcel1.writeString(param2String1);
          parcel1.writeStringList(param2List);
          parcel1.writeString(param2String2);
          parcel1.writeString(param2String3);
          parcel1.writeString(param2String4);
          try {
            if (!this.b.transact(7, parcel1, parcel2, 0) && IInAppBillingService.Stub.a() != null) {
              Bundle bundle = IInAppBillingService.Stub.a().a(param2Int, param2String1, param2List, param2String2, param2String3, param2String4);
              parcel2.recycle();
              parcel1.recycle();
              return bundle;
            } 
            parcel2.readException();
            if (parcel2.readInt() != 0) {
              Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
            } else {
              param2String1 = null;
            } 
            parcel2.recycle();
            parcel1.recycle();
            return (Bundle)param2String1;
          } finally {}
        } finally {}
        parcel2.recycle();
        parcel1.recycle();
        throw param2String1;
      }
      
      public IBinder asBinder() {
        return this.b;
      }
      
      public int b(int param2Int, String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
          parcel1.writeInt(param2Int);
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          if (!this.b.transact(5, parcel1, parcel2, 0) && IInAppBillingService.Stub.a() != null) {
            param2Int = IInAppBillingService.Stub.a().b(param2Int, param2String1, param2String2);
            return param2Int;
          } 
          parcel2.readException();
          param2Int = parcel2.readInt();
          return param2Int;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public int c(int param2Int, String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
          parcel1.writeInt(param2Int);
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          if (!this.b.transact(6, parcel1, parcel2, 0) && IInAppBillingService.Stub.a() != null) {
            param2Int = IInAppBillingService.Stub.a().c(param2Int, param2String1, param2String2);
            return param2Int;
          } 
          parcel2.readException();
          param2Int = parcel2.readInt();
          return param2Int;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  static class Proxy implements IInAppBillingService {
    public static IInAppBillingService a;
    
    private IBinder b;
    
    Proxy(IBinder param1IBinder) {
      this.b = param1IBinder;
    }
    
    public int a(int param1Int, String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
        parcel1.writeInt(param1Int);
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        if (!this.b.transact(1, parcel1, parcel2, 0) && IInAppBillingService.Stub.a() != null) {
          param1Int = IInAppBillingService.Stub.a().a(param1Int, param1String1, param1String2);
          return param1Int;
        } 
        parcel2.readException();
        param1Int = parcel2.readInt();
        return param1Int;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public Bundle a(int param1Int, String param1String1, String param1String2, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
        parcel1.writeInt(param1Int);
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.b.transact(2, parcel1, parcel2, 0) && IInAppBillingService.Stub.a() != null)
          return IInAppBillingService.Stub.a().a(param1Int, param1String1, param1String2, param1Bundle); 
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
        } else {
          param1String1 = null;
        } 
        return (Bundle)param1String1;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public Bundle a(int param1Int, String param1String1, String param1String2, String param1String3) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
        parcel1.writeInt(param1Int);
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        parcel1.writeString(param1String3);
        if (!this.b.transact(4, parcel1, parcel2, 0) && IInAppBillingService.Stub.a() != null)
          return IInAppBillingService.Stub.a().a(param1Int, param1String1, param1String2, param1String3); 
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
        } else {
          param1String1 = null;
        } 
        return (Bundle)param1String1;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public Bundle a(int param1Int, String param1String1, String param1String2, String param1String3, String param1String4) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
        parcel1.writeInt(param1Int);
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        parcel1.writeString(param1String3);
        parcel1.writeString(param1String4);
        if (!this.b.transact(3, parcel1, parcel2, 0) && IInAppBillingService.Stub.a() != null)
          return IInAppBillingService.Stub.a().a(param1Int, param1String1, param1String2, param1String3, param1String4); 
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
        } else {
          param1String1 = null;
        } 
        return (Bundle)param1String1;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public Bundle a(int param1Int, String param1String1, List<String> param1List, String param1String2, String param1String3, String param1String4) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
        parcel1.writeInt(param1Int);
        parcel1.writeString(param1String1);
        parcel1.writeStringList(param1List);
        parcel1.writeString(param1String2);
        parcel1.writeString(param1String3);
        parcel1.writeString(param1String4);
        try {
          if (!this.b.transact(7, parcel1, parcel2, 0) && IInAppBillingService.Stub.a() != null) {
            Bundle bundle = IInAppBillingService.Stub.a().a(param1Int, param1String1, param1List, param1String2, param1String3, param1String4);
            parcel2.recycle();
            parcel1.recycle();
            return bundle;
          } 
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
          } else {
            param1String1 = null;
          } 
          parcel2.recycle();
          parcel1.recycle();
          return (Bundle)param1String1;
        } finally {}
      } finally {}
      parcel2.recycle();
      parcel1.recycle();
      throw param1String1;
    }
    
    public IBinder asBinder() {
      return this.b;
    }
    
    public int b(int param1Int, String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
        parcel1.writeInt(param1Int);
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        if (!this.b.transact(5, parcel1, parcel2, 0) && IInAppBillingService.Stub.a() != null) {
          param1Int = IInAppBillingService.Stub.a().b(param1Int, param1String1, param1String2);
          return param1Int;
        } 
        parcel2.readException();
        param1Int = parcel2.readInt();
        return param1Int;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public int c(int param1Int, String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
        parcel1.writeInt(param1Int);
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        if (!this.b.transact(6, parcel1, parcel2, 0) && IInAppBillingService.Stub.a() != null) {
          param1Int = IInAppBillingService.Stub.a().c(param1Int, param1String1, param1String2);
          return param1Int;
        } 
        parcel2.readException();
        param1Int = parcel2.readInt();
        return param1Int;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\android\vending\billing\IInAppBillingService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */