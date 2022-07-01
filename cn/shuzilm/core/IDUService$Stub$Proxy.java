package cn.shuzilm.core;

import android.os.IBinder;
import android.os.Parcel;
import java.util.HashMap;
import java.util.Map;

class IDUService$Stub$Proxy implements IDUService {
  private IBinder mRemote;
  
  IDUService$Stub$Proxy(IBinder paramIBinder) {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder() {
    return this.mRemote;
  }
  
  public String getInterfaceDescriptor() {
    return "cn.shuzilm.core.IDUService";
  }
  
  public void getOpenAnmsIDAsyn(DUListener paramDUListener) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("cn.shuzilm.core.IDUService");
      if (paramDUListener != null) {
        IBinder iBinder = paramDUListener.asBinder();
      } else {
        paramDUListener = null;
      } 
      parcel1.writeStrongBinder((IBinder)paramDUListener);
      this.mRemote.transact(9, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public String getQueryID(String paramString1, String paramString2) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("cn.shuzilm.core.IDUService");
      parcel1.writeString(paramString1);
      parcel1.writeString(paramString2);
      this.mRemote.transact(5, parcel1, parcel2, 0);
      parcel2.readException();
      paramString1 = parcel2.readString();
      return paramString1;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public Map getQueryIDAsyn(String paramString1, String paramString2, DUListener paramDUListener) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("cn.shuzilm.core.IDUService");
      parcel1.writeString(paramString1);
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
    paramString1 = null;
    parcel1.writeStrongBinder((IBinder)paramString1);
    this.mRemote.transact(8, parcel1, parcel2, 0);
    parcel2.readException();
    HashMap hashMap = parcel2.readHashMap(getClass().getClassLoader());
    parcel2.recycle();
    parcel1.recycle();
    return hashMap;
  }
  
  public void go(String paramString1, String paramString2) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("cn.shuzilm.core.IDUService");
      parcel1.writeString(paramString1);
      parcel1.writeString(paramString2);
      this.mRemote.transact(3, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public Map onEvent(String paramString1, String paramString2, String paramString3) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("cn.shuzilm.core.IDUService");
      parcel1.writeString(paramString1);
      parcel1.writeString(paramString2);
      parcel1.writeString(paramString3);
      this.mRemote.transact(6, parcel1, parcel2, 0);
      parcel2.readException();
      return parcel2.readHashMap(getClass().getClassLoader());
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public Map onEventAsyn(String paramString1, String paramString2, String paramString3, DUListener paramDUListener) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("cn.shuzilm.core.IDUService");
      parcel1.writeString(paramString1);
      parcel1.writeString(paramString2);
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
    paramString1 = null;
    parcel1.writeStrongBinder((IBinder)paramString1);
    this.mRemote.transact(7, parcel1, parcel2, 0);
    parcel2.readException();
    HashMap hashMap = parcel2.readHashMap(getClass().getClassLoader());
    parcel2.recycle();
    parcel1.recycle();
    return hashMap;
  }
  
  public void report(String paramString1, String paramString2) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("cn.shuzilm.core.IDUService");
      parcel1.writeString(paramString1);
      parcel1.writeString(paramString2);
      this.mRemote.transact(4, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public int setConfig(String paramString1, String paramString2) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("cn.shuzilm.core.IDUService");
      parcel1.writeString(paramString1);
      parcel1.writeString(paramString2);
      this.mRemote.transact(2, parcel1, parcel2, 0);
      parcel2.readException();
      return parcel2.readInt();
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public int setData(String paramString1, String paramString2) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("cn.shuzilm.core.IDUService");
      parcel1.writeString(paramString1);
      parcel1.writeString(paramString2);
      this.mRemote.transact(1, parcel1, parcel2, 0);
      parcel2.readException();
      return parcel2.readInt();
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\IDUService$Stub$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */