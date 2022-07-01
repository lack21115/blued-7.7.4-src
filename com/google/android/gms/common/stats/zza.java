package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.util.zzd;
import java.util.Collections;
import java.util.List;

public final class zza {
  private static final Object zzggs = new Object();
  
  private static volatile zza zzgjh;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private zza() {
    List list = Collections.EMPTY_LIST;
    list = Collections.EMPTY_LIST;
    list = Collections.EMPTY_LIST;
    list = Collections.EMPTY_LIST;
  }
  
  public static boolean zza$58d5677d(Context paramContext, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt) {
    boolean bool;
    ComponentName componentName = paramIntent.getComponent();
    if (componentName == null) {
      bool = false;
    } else {
      bool = zzd.zzv(paramContext, componentName.getPackageName());
    } 
    if (bool) {
      Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
      return false;
    } 
    return paramContext.bindService(paramIntent, paramServiceConnection, paramInt);
  }
  
  public static zza zzanm() {
    if (zzgjh == null)
      synchronized (zzggs) {
        if (zzgjh == null)
          zzgjh = new zza(); 
      }  
    return zzgjh;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\stats\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */