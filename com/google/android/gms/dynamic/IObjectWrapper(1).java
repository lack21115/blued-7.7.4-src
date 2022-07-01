package com.google.android.gms.dynamic;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.common.zzb;

public interface IObjectWrapper extends IInterface {
  public static class Stub extends com.google.android.gms.internal.common.zza implements IObjectWrapper {
    public Stub() {
      super("com.google.android.gms.dynamic.IObjectWrapper");
    }
    
    public static IObjectWrapper asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
      return (iInterface instanceof IObjectWrapper) ? (IObjectWrapper)iInterface : new zza(param1IBinder);
    }
    
    public static final class zza extends zzb implements IObjectWrapper {
      zza(IBinder param2IBinder) {
        super(param2IBinder, "com.google.android.gms.dynamic.IObjectWrapper");
      }
    }
  }
  
  public static final class zza extends zzb implements IObjectWrapper {
    zza(IBinder param1IBinder) {
      super(param1IBinder, "com.google.android.gms.dynamic.IObjectWrapper");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\dynamic\IObjectWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */