package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.dynamite.DynamiteModule;
import java.lang.reflect.Method;

public class ProviderInstaller {
  public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
  
  private static final GoogleApiAvailabilityLight zza = GoogleApiAvailabilityLight.getInstance();
  
  private static final Object zzb = new Object();
  
  private static Method zzc = null;
  
  public static void installIfNeeded(Context paramContext) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
    Preconditions.checkNotNull(paramContext, "Context must not be null");
    zza.verifyGooglePlayServicesIsAvailable(paramContext, 11925000);
    Context context2 = zza(paramContext);
    Context context1 = context2;
    if (context2 == null)
      context1 = zzb(paramContext); 
    if (context1 != null)
      synchronized (zzb) {
        if (zzc == null)
          zzc = context1.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[] { Context.class }); 
        zzc.invoke(null, new Object[] { context1 });
        return;
      }  
    Log.e("ProviderInstaller", "Failed to get remote context");
    throw new GooglePlayServicesNotAvailableException(8);
  }
  
  public static void installIfNeededAsync(Context paramContext, ProviderInstallListener paramProviderInstallListener) {
    Preconditions.checkNotNull(paramContext, "Context must not be null");
    Preconditions.checkNotNull(paramProviderInstallListener, "Listener must not be null");
    Preconditions.checkMainThread("Must be called on the UI thread");
    (new zza(paramContext, paramProviderInstallListener)).execute((Object[])new Void[0]);
  }
  
  private static Context zza(Context paramContext) {
    try {
      return DynamiteModule.load(paramContext, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "providerinstaller").getModuleContext();
    } catch (com.google.android.gms.dynamite.DynamiteModule.LoadingException loadingException) {
      String str = String.valueOf(loadingException.getMessage());
      if (str.length() != 0) {
        str = "Failed to load providerinstaller module: ".concat(str);
      } else {
        str = new String("Failed to load providerinstaller module: ");
      } 
      Log.w("ProviderInstaller", str);
      return null;
    } 
  }
  
  private static Context zzb(Context paramContext) {
    try {
      return GooglePlayServicesUtilLight.getRemoteContext(paramContext);
    } catch (android.content.res.Resources.NotFoundException notFoundException) {
      String str = String.valueOf(notFoundException.getMessage());
      if (str.length() != 0) {
        str = "Failed to load GMS Core context for providerinstaller: ".concat(str);
      } else {
        str = new String("Failed to load GMS Core context for providerinstaller: ");
      } 
      Log.w("ProviderInstaller", str);
      CrashUtils.addDynamiteErrorToDropBox(paramContext, (Throwable)notFoundException);
      return null;
    } 
  }
  
  public static interface ProviderInstallListener {
    void onProviderInstallFailed(int param1Int, Intent param1Intent);
    
    void onProviderInstalled();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\security\ProviderInstaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */