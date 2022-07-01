package com.google.android.gms.common.wrappers;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.util.PlatformVersion;

public class PackageManagerWrapper {
  private final Context zza;
  
  public PackageManagerWrapper(Context paramContext) {
    this.zza = paramContext;
  }
  
  public int checkCallingOrSelfPermission(String paramString) {
    return this.zza.checkCallingOrSelfPermission(paramString);
  }
  
  public int checkPermission(String paramString1, String paramString2) {
    return this.zza.getPackageManager().checkPermission(paramString1, paramString2);
  }
  
  public ApplicationInfo getApplicationInfo(String paramString, int paramInt) throws PackageManager.NameNotFoundException {
    return this.zza.getPackageManager().getApplicationInfo(paramString, paramInt);
  }
  
  public CharSequence getApplicationLabel(String paramString) throws PackageManager.NameNotFoundException {
    return this.zza.getPackageManager().getApplicationLabel(this.zza.getPackageManager().getApplicationInfo(paramString, 0));
  }
  
  public PackageInfo getPackageInfo(String paramString, int paramInt) throws PackageManager.NameNotFoundException {
    return this.zza.getPackageManager().getPackageInfo(paramString, paramInt);
  }
  
  public boolean isCallerInstantApp() {
    if (Binder.getCallingUid() == Process.myUid())
      return InstantApps.isInstantApp(this.zza); 
    if (PlatformVersion.isAtLeastO()) {
      String str = this.zza.getPackageManager().getNameForUid(Binder.getCallingUid());
      if (str != null)
        return this.zza.getPackageManager().isInstantApp(str); 
    } 
    return false;
  }
  
  public final PackageInfo zza(String paramString, int paramInt1, int paramInt2) throws PackageManager.NameNotFoundException {
    return this.zza.getPackageManager().getPackageInfo(paramString, 64);
  }
  
  public final boolean zza(int paramInt, String paramString) {
    if (PlatformVersion.isAtLeastKitKat())
      try {
        ((AppOpsManager)this.zza.getSystemService("appops")).checkPackage(paramInt, paramString);
        return true;
      } catch (SecurityException securityException) {
        return false;
      }  
    String[] arrayOfString = this.zza.getPackageManager().getPackagesForUid(paramInt);
    if (securityException != null && arrayOfString != null)
      for (paramInt = 0; paramInt < arrayOfString.length; paramInt++) {
        if (securityException.equals(arrayOfString[paramInt]))
          return true; 
      }  
    return false;
  }
  
  public final String[] zza(int paramInt) {
    return this.zza.getPackageManager().getPackagesForUid(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\wrappers\PackageManagerWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */