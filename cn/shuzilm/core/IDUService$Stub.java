package cn.shuzilm.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.Map;

public abstract class IDUService$Stub extends Binder implements IDUService {
  private static final String DESCRIPTOR = "cn.shuzilm.core.IDUService";
  
  static final int TRANSACTION_getOpenAnmsIDAsyn = 9;
  
  static final int TRANSACTION_getQueryID = 5;
  
  static final int TRANSACTION_getQueryIDAsyn = 8;
  
  static final int TRANSACTION_go = 3;
  
  static final int TRANSACTION_onEvent = 6;
  
  static final int TRANSACTION_onEventAsyn = 7;
  
  static final int TRANSACTION_report = 4;
  
  static final int TRANSACTION_setConfig = 2;
  
  static final int TRANSACTION_setData = 1;
  
  public IDUService$Stub() {
    attachInterface(this, "cn.shuzilm.core.IDUService");
  }
  
  public static IDUService asInterface(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("cn.shuzilm.core.IDUService");
    return (iInterface != null && iInterface instanceof IDUService) ? (IDUService)iInterface : new IDUService$Stub$Proxy(paramIBinder);
  }
  
  public IBinder asBinder() {
    return (IBinder)this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
    if (paramInt1 != 1598968902) {
      Map map;
      String str;
      switch (paramInt1) {
        default:
          return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        case 9:
          paramParcel1.enforceInterface("cn.shuzilm.core.IDUService");
          getOpenAnmsIDAsyn(DUListener$Stub.asInterface(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
        case 8:
          paramParcel1.enforceInterface("cn.shuzilm.core.IDUService");
          map = getQueryIDAsyn(paramParcel1.readString(), paramParcel1.readString(), DUListener$Stub.asInterface(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          paramParcel2.writeMap(map);
          return true;
        case 7:
          map.enforceInterface("cn.shuzilm.core.IDUService");
          map = onEventAsyn(map.readString(), map.readString(), map.readString(), DUListener$Stub.asInterface(map.readStrongBinder()));
          paramParcel2.writeNoException();
          paramParcel2.writeMap(map);
          return true;
        case 6:
          map.enforceInterface("cn.shuzilm.core.IDUService");
          map = onEvent(map.readString(), map.readString(), map.readString());
          paramParcel2.writeNoException();
          paramParcel2.writeMap(map);
          return true;
        case 5:
          map.enforceInterface("cn.shuzilm.core.IDUService");
          str = getQueryID(map.readString(), map.readString());
          paramParcel2.writeNoException();
          paramParcel2.writeString(str);
          return true;
        case 4:
          str.enforceInterface("cn.shuzilm.core.IDUService");
          report(str.readString(), str.readString());
          paramParcel2.writeNoException();
          return true;
        case 3:
          str.enforceInterface("cn.shuzilm.core.IDUService");
          go(str.readString(), str.readString());
          paramParcel2.writeNoException();
          return true;
        case 2:
          str.enforceInterface("cn.shuzilm.core.IDUService");
          paramInt1 = setConfig(str.readString(), str.readString());
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          return true;
        case 1:
          break;
      } 
      str.enforceInterface("cn.shuzilm.core.IDUService");
      paramInt1 = setData(str.readString(), str.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    } 
    paramParcel2.writeString("cn.shuzilm.core.IDUService");
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\IDUService$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */