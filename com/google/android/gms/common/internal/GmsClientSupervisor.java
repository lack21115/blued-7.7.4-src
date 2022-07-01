package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public abstract class GmsClientSupervisor {
  private static int zza = 129;
  
  private static final Object zzb = new Object();
  
  private static GmsClientSupervisor zzc;
  
  public static int getDefaultBindFlags() {
    return zza;
  }
  
  public static GmsClientSupervisor getInstance(Context paramContext) {
    synchronized (zzb) {
      if (zzc == null)
        zzc = new zzf(paramContext.getApplicationContext()); 
      return zzc;
    } 
  }
  
  public boolean bindService(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString) {
    return zza(new zza(paramComponentName, getDefaultBindFlags()), paramServiceConnection, paramString);
  }
  
  public boolean bindService(String paramString1, ServiceConnection paramServiceConnection, String paramString2) {
    return zza(new zza(paramString1, getDefaultBindFlags()), paramServiceConnection, paramString2);
  }
  
  public void unbindService(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString) {
    zzb(new zza(paramComponentName, getDefaultBindFlags()), paramServiceConnection, paramString);
  }
  
  public void unbindService(String paramString1, ServiceConnection paramServiceConnection, String paramString2) {
    zzb(new zza(paramString1, getDefaultBindFlags()), paramServiceConnection, paramString2);
  }
  
  public final void zza(String paramString1, String paramString2, int paramInt, ServiceConnection paramServiceConnection, String paramString3, boolean paramBoolean) {
    zzb(new zza(paramString1, paramString2, paramInt, paramBoolean), paramServiceConnection, paramString3);
  }
  
  protected abstract boolean zza(zza paramzza, ServiceConnection paramServiceConnection, String paramString);
  
  protected abstract void zzb(zza paramzza, ServiceConnection paramServiceConnection, String paramString);
  
  public static final class zza {
    private static final Uri zzf = (new Uri.Builder()).scheme("content").authority("com.google.android.gms.chimera").build();
    
    private final String zza = null;
    
    private final String zzb = null;
    
    private final ComponentName zzc;
    
    private final int zzd;
    
    private final boolean zze;
    
    public zza(ComponentName param1ComponentName, int param1Int) {
      this.zzc = Preconditions.<ComponentName>checkNotNull(param1ComponentName);
      this.zzd = param1Int;
      this.zze = false;
    }
    
    public zza(String param1String, int param1Int) {
      this(param1String, "com.google.android.gms", param1Int);
    }
    
    private zza(String param1String1, String param1String2, int param1Int) {
      this(param1String1, param1String2, param1Int, false);
    }
    
    public zza(String param1String1, String param1String2, int param1Int, boolean param1Boolean) {
      this.zzc = null;
      this.zzd = param1Int;
      this.zze = param1Boolean;
    }
    
    private final Intent zzb(Context param1Context) {
      String str1;
      Intent intent;
      Bundle bundle = new Bundle();
      bundle.putString("serviceActionBundleKey", this.zza);
      String str2 = null;
      try {
        Bundle bundle1 = param1Context.getContentResolver().call(zzf, "serviceIntentCall", null, bundle);
      } catch (IllegalArgumentException illegalArgumentException) {
        str1 = String.valueOf(illegalArgumentException);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 34);
        stringBuilder.append("Dynamic intent resolution failed: ");
        stringBuilder.append(str1);
        Log.w("ConnectionStatusConfig", stringBuilder.toString());
        str1 = null;
      } 
      if (str1 == null) {
        str1 = str2;
      } else {
        intent = (Intent)str1.getParcelable("serviceResponseIntentKey");
      } 
      if (intent == null) {
        str2 = String.valueOf(this.zza);
        if (str2.length() != 0) {
          str2 = "Dynamic lookup for intent failed for action: ".concat(str2);
        } else {
          str2 = new String("Dynamic lookup for intent failed for action: ");
        } 
        Log.w("ConnectionStatusConfig", str2);
      } 
      return intent;
    }
    
    public final boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (!(param1Object instanceof zza))
        return false; 
      param1Object = param1Object;
      return (Objects.equal(this.zza, ((zza)param1Object).zza) && Objects.equal(this.zzb, ((zza)param1Object).zzb) && Objects.equal(this.zzc, ((zza)param1Object).zzc) && this.zzd == ((zza)param1Object).zzd && this.zze == ((zza)param1Object).zze);
    }
    
    public final int hashCode() {
      return Objects.hashCode(new Object[] { this.zza, this.zzb, this.zzc, Integer.valueOf(this.zzd), Boolean.valueOf(this.zze) });
    }
    
    public final String toString() {
      String str2 = this.zza;
      String str1 = str2;
      if (str2 == null) {
        Preconditions.checkNotNull(this.zzc);
        str1 = this.zzc.flattenToString();
      } 
      return str1;
    }
    
    public final Intent zza(Context param1Context) {
      Intent intent;
      if (this.zza != null) {
        if (this.zze) {
          Intent intent1 = zzb(param1Context);
        } else {
          param1Context = null;
        } 
        Context context = param1Context;
        if (param1Context == null)
          return (new Intent(this.zza)).setPackage(this.zzb); 
      } else {
        intent = (new Intent()).setComponent(this.zzc);
      } 
      return intent;
    }
    
    public final String zza() {
      return this.zzb;
    }
    
    public final ComponentName zzb() {
      return this.zzc;
    }
    
    public final int zzc() {
      return this.zzd;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\GmsClientSupervisor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */