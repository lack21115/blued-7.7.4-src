package com.google.android.gms.dynamic;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.zzew;

public class IObjectWrapper$zza extends zzew implements IObjectWrapper {
  public IObjectWrapper$zza() {
    attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
  }
  
  public static IObjectWrapper zzaq(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
    return (iInterface instanceof IObjectWrapper) ? (IObjectWrapper)iInterface : new zzm(paramIBinder);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\dynamic\IObjectWrapper$zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */