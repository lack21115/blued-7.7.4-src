package com.heytap.openid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface a extends IInterface {
  public static abstract class a extends Binder implements a {
    public static a a(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.heytap.openid.IOpenID");
      return (iInterface != null && iInterface instanceof a) ? (a)iInterface : new a(param1IBinder);
    }
    
    private static class a implements a {
      public IBinder a;
      
      public a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public String a(String param2String1, String param2String2, String param2String3) {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.heytap.openid.IOpenID");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          parcel1.writeString(param2String3);
          this.a.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          param2String1 = parcel2.readString();
          return param2String1;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public IBinder asBinder() {
        return this.a;
      }
    }
  }
  
  private static class a implements a {
    public IBinder a;
    
    public a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public String a(String param1String1, String param1String2, String param1String3) {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.heytap.openid.IOpenID");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        parcel1.writeString(param1String3);
        this.a.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        param1String1 = parcel2.readString();
        return param1String1;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public IBinder asBinder() {
      return this.a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\heytap\openid\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */