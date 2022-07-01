package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.common.zzn;
import com.google.android.gms.internal.common.zzo;
import java.util.concurrent.ConcurrentHashMap;

public class ConnectionTracker {
  private static final Object zza = new Object();
  
  private static volatile ConnectionTracker zzb;
  
  private static boolean zzc = false;
  
  private static zzo<Boolean> zzd = zzn.zza(zza.zza);
  
  private ConcurrentHashMap<ServiceConnection, ServiceConnection> zze = new ConcurrentHashMap<ServiceConnection, ServiceConnection>();
  
  public static ConnectionTracker getInstance() {
    if (zzb == null)
      synchronized (zza) {
        if (zzb == null)
          zzb = new ConnectionTracker(); 
      }  
    return zzb;
  }
  
  private static void zza(Context paramContext, ServiceConnection paramServiceConnection) {
    try {
      paramContext.unbindService(paramServiceConnection);
      return;
    } catch (IllegalArgumentException illegalArgumentException) {
    
    } catch (IllegalStateException illegalStateException) {}
    Log.w("ConnectionTracker", "Exception thrown while unbinding", illegalStateException);
  }
  
  private final boolean zza(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt, boolean paramBoolean) {
    ComponentName componentName = paramIntent.getComponent();
    if (componentName == null) {
      paramBoolean = false;
    } else {
      paramBoolean = ClientLibraryUtils.zza(paramContext, componentName.getPackageName());
    } 
    if (paramBoolean) {
      Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
      return false;
    } 
    if (zza(paramServiceConnection)) {
      ServiceConnection serviceConnection = this.zze.putIfAbsent(paramServiceConnection, paramServiceConnection);
      if (serviceConnection != null && paramServiceConnection != serviceConnection)
        Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", new Object[] { paramServiceConnection, paramString, paramIntent.getAction() })); 
      try {
        boolean bool = paramContext.bindService(paramIntent, paramServiceConnection, paramInt);
        paramBoolean = bool;
      } finally {
        this.zze.remove(paramServiceConnection, paramServiceConnection);
      } 
    } else {
      paramBoolean = paramContext.bindService(paramIntent, paramServiceConnection, paramInt);
    } 
    return paramBoolean;
  }
  
  private static boolean zza(ServiceConnection paramServiceConnection) {
    return (((Boolean)zzd.zza()).booleanValue() && !(paramServiceConnection instanceof com.google.android.gms.common.internal.zzj));
  }
  
  public boolean bindService(Context paramContext, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt) {
    return zza(paramContext, paramContext.getClass().getName(), paramIntent, paramServiceConnection, paramInt);
  }
  
  public void unbindService(Context paramContext, ServiceConnection paramServiceConnection) {
    if (zza(paramServiceConnection) && this.zze.containsKey(paramServiceConnection))
      try {
        zza(paramContext, this.zze.get(paramServiceConnection));
        return;
      } finally {
        this.zze.remove(paramServiceConnection);
      }  
    zza(paramContext, paramServiceConnection);
  }
  
  public void unbindServiceSafe(Context paramContext, ServiceConnection paramServiceConnection) {
    try {
      unbindService(paramContext, paramServiceConnection);
      return;
    } catch (IllegalArgumentException illegalArgumentException) {
      Log.w("ConnectionTracker", "Exception thrown while unbinding", illegalArgumentException);
      return;
    } 
  }
  
  public final boolean zza(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt) {
    return zza(paramContext, paramString, paramIntent, paramServiceConnection, paramInt, true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\stats\ConnectionTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */