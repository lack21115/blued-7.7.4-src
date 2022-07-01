package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzb;

public interface ICancelToken extends IInterface {
  void cancel() throws RemoteException;
  
  public static abstract class Stub extends com.google.android.gms.internal.common.zza implements ICancelToken {
    public Stub() {
      super("com.google.android.gms.common.internal.ICancelToken");
    }
    
    public static ICancelToken asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken");
      return (iInterface instanceof ICancelToken) ? (ICancelToken)iInterface : new zza(param1IBinder);
    }
    
    public static final class zza extends zzb implements ICancelToken {
      zza(IBinder param2IBinder) {
        super(param2IBinder, "com.google.android.gms.common.internal.ICancelToken");
      }
      
      public final void cancel() throws RemoteException {
        zzc(2, a_());
      }
    }
  }
  
  public static final class zza extends zzb implements ICancelToken {
    zza(IBinder param1IBinder) {
      super(param1IBinder, "com.google.android.gms.common.internal.ICancelToken");
    }
    
    public final void cancel() throws RemoteException {
      zzc(2, a_());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\ICancelToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */