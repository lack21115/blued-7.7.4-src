package com.alipay.android.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

public interface IAlixPay extends IInterface {
  String Pay(String paramString) throws RemoteException;
  
  void deployFastConnect() throws RemoteException;
  
  int getVersion() throws RemoteException;
  
  boolean manager(String paramString) throws RemoteException;
  
  String pay02(String paramString, Map paramMap) throws RemoteException;
  
  String prePay(String paramString) throws RemoteException;
  
  void registerCallback(IRemoteServiceCallback paramIRemoteServiceCallback) throws RemoteException;
  
  String test() throws RemoteException;
  
  void unregisterCallback(IRemoteServiceCallback paramIRemoteServiceCallback) throws RemoteException;
  
  public static abstract class Stub extends Binder implements IAlixPay {
    private static final String DESCRIPTOR = "com.alipay.android.app.IAlixPay";
    
    static final int TRANSACTION_Pay = 1;
    
    static final int TRANSACTION_deployFastConnect = 6;
    
    static final int TRANSACTION_getVersion = 8;
    
    static final int TRANSACTION_manager = 7;
    
    static final int TRANSACTION_pay02 = 9;
    
    static final int TRANSACTION_prePay = 5;
    
    static final int TRANSACTION_registerCallback = 3;
    
    static final int TRANSACTION_test = 2;
    
    static final int TRANSACTION_unregisterCallback = 4;
    
    public Stub() {
      attachInterface(this, "com.alipay.android.app.IAlixPay");
    }
    
    public static IAlixPay asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.alipay.android.app.IAlixPay");
      return (iInterface != null && iInterface instanceof IAlixPay) ? (IAlixPay)iInterface : new a(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    static class a implements IAlixPay {
      private IBinder a;
      
      a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public String Pay(String param2String) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
          parcel1.writeString(param2String);
          this.a.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          param2String = parcel2.readString();
          return param2String;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public String a() {
        return "com.alipay.android.app.IAlixPay";
      }
      
      public IBinder asBinder() {
        return this.a;
      }
      
      public void deployFastConnect() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
          this.a.transact(6, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public int getVersion() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
          this.a.transact(8, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readInt();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean manager(String param2String) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
          parcel1.writeString(param2String);
          IBinder iBinder = this.a;
          boolean bool = false;
          iBinder.transact(7, parcel1, parcel2, 0);
          parcel2.readException();
          int i = parcel2.readInt();
          if (i != 0)
            bool = true; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public String pay02(String param2String, Map param2Map) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
          parcel1.writeString(param2String);
          parcel1.writeMap(param2Map);
          this.a.transact(9, parcel1, parcel2, 0);
          parcel2.readException();
          param2String = parcel2.readString();
          return param2String;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public String prePay(String param2String) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
          parcel1.writeString(param2String);
          this.a.transact(5, parcel1, parcel2, 0);
          parcel2.readException();
          param2String = parcel2.readString();
          return param2String;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void registerCallback(IRemoteServiceCallback param2IRemoteServiceCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
          if (param2IRemoteServiceCallback != null) {
            IBinder iBinder = param2IRemoteServiceCallback.asBinder();
          } else {
            param2IRemoteServiceCallback = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2IRemoteServiceCallback);
          this.a.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public String test() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
          this.a.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readString();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void unregisterCallback(IRemoteServiceCallback param2IRemoteServiceCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
          if (param2IRemoteServiceCallback != null) {
            IBinder iBinder = param2IRemoteServiceCallback.asBinder();
          } else {
            param2IRemoteServiceCallback = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2IRemoteServiceCallback);
          this.a.transact(4, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  static class a implements IAlixPay {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public String Pay(String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
        parcel1.writeString(param1String);
        this.a.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        param1String = parcel2.readString();
        return param1String;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public String a() {
      return "com.alipay.android.app.IAlixPay";
    }
    
    public IBinder asBinder() {
      return this.a;
    }
    
    public void deployFastConnect() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
        this.a.transact(6, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public int getVersion() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
        this.a.transact(8, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean manager(String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
        parcel1.writeString(param1String);
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(7, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        if (i != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public String pay02(String param1String, Map param1Map) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
        parcel1.writeString(param1String);
        parcel1.writeMap(param1Map);
        this.a.transact(9, parcel1, parcel2, 0);
        parcel2.readException();
        param1String = parcel2.readString();
        return param1String;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public String prePay(String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
        parcel1.writeString(param1String);
        this.a.transact(5, parcel1, parcel2, 0);
        parcel2.readException();
        param1String = parcel2.readString();
        return param1String;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void registerCallback(IRemoteServiceCallback param1IRemoteServiceCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
        if (param1IRemoteServiceCallback != null) {
          IBinder iBinder = param1IRemoteServiceCallback.asBinder();
        } else {
          param1IRemoteServiceCallback = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1IRemoteServiceCallback);
        this.a.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public String test() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
        this.a.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readString();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void unregisterCallback(IRemoteServiceCallback param1IRemoteServiceCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
        if (param1IRemoteServiceCallback != null) {
          IBinder iBinder = param1IRemoteServiceCallback.asBinder();
        } else {
          param1IRemoteServiceCallback = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1IRemoteServiceCallback);
        this.a.transact(4, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\android\app\IAlixPay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */