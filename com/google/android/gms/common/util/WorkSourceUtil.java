package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkSourceUtil {
  private static final int zza = Process.myUid();
  
  private static final Method zzb = zza();
  
  private static final Method zzc = zzb();
  
  private static final Method zzd = zzc();
  
  private static final Method zze = zzd();
  
  private static final Method zzf = zze();
  
  private static final Method zzg = zzf();
  
  private static final Method zzh = zzg();
  
  public static WorkSource fromPackage(Context paramContext, String paramString) {
    if (paramContext != null && paramContext.getPackageManager() != null) {
      if (paramString == null)
        return null; 
      try {
        String str;
        ApplicationInfo applicationInfo = Wrappers.packageManager(paramContext).getApplicationInfo(paramString, 0);
        if (applicationInfo == null) {
          str = String.valueOf(paramString);
          if (str.length() != 0) {
            str = "Could not get applicationInfo from package: ".concat(str);
          } else {
            str = new String("Could not get applicationInfo from package: ");
          } 
          Log.e("WorkSourceUtil", str);
          return null;
        } 
        return zza(((ApplicationInfo)str).uid, paramString);
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        String str = String.valueOf(paramString);
        if (str.length() != 0) {
          str = "Could not find package: ".concat(str);
        } else {
          str = new String("Could not find package: ");
        } 
        Log.e("WorkSourceUtil", str);
      } 
    } 
    return null;
  }
  
  public static WorkSource fromPackageAndModuleExperimentalPi(Context paramContext, String paramString1, String paramString2) {
    if (paramContext == null || paramContext.getPackageManager() == null || paramString2 == null || paramString1 == null) {
      Log.w("WorkSourceUtil", "Unexpected null arguments");
      return null;
    } 
    int i = zza(paramContext, paramString1);
    if (i < 0)
      return null; 
    WorkSource workSource = new WorkSource();
    Method method = zzg;
    if (method == null || zzh == null) {
      zza(workSource, i, paramString1);
      return workSource;
    } 
    try {
      Object object = method.invoke(workSource, new Object[0]);
      if (i != zza)
        zzh.invoke(object, new Object[] { Integer.valueOf(i), paramString1 }); 
      zzh.invoke(object, new Object[] { Integer.valueOf(zza), paramString2 });
      return workSource;
    } catch (Exception exception) {
      Log.w("WorkSourceUtil", "Unable to assign chained blame through WorkSource", exception);
      return workSource;
    } 
  }
  
  public static List<String> getNames(WorkSource paramWorkSource) {
    int i;
    int j = 0;
    if (paramWorkSource == null) {
      i = 0;
    } else {
      i = zza(paramWorkSource);
    } 
    if (i == 0)
      return Collections.emptyList(); 
    ArrayList<String> arrayList = new ArrayList();
    while (j < i) {
      String str = zza(paramWorkSource, j);
      if (!Strings.isEmptyOrWhitespace(str))
        arrayList.add(str); 
      j++;
    } 
    return arrayList;
  }
  
  public static boolean hasWorkSourcePermission(Context paramContext) {
    return (paramContext == null) ? false : ((paramContext.getPackageManager() == null) ? false : ((Wrappers.packageManager(paramContext).checkPermission("android.permission.UPDATE_DEVICE_STATS", paramContext.getPackageName()) == 0)));
  }
  
  private static int zza(Context paramContext, String paramString) {
    try {
      String str;
      ApplicationInfo applicationInfo = Wrappers.packageManager(paramContext).getApplicationInfo(paramString, 0);
      if (applicationInfo == null) {
        str = String.valueOf(paramString);
        if (str.length() != 0) {
          str = "Could not get applicationInfo from package: ".concat(str);
        } else {
          str = new String("Could not get applicationInfo from package: ");
        } 
        Log.e("WorkSourceUtil", str);
        return -1;
      } 
      return ((ApplicationInfo)str).uid;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      String str = String.valueOf(paramString);
      if (str.length() != 0) {
        str = "Could not find package: ".concat(str);
      } else {
        str = new String("Could not find package: ");
      } 
      Log.e("WorkSourceUtil", str);
      return -1;
    } 
  }
  
  private static int zza(WorkSource paramWorkSource) {
    Method method = zzd;
    if (method != null)
      try {
        return ((Integer)method.invoke(paramWorkSource, new Object[0])).intValue();
      } catch (Exception exception) {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", exception);
      }  
    return 0;
  }
  
  private static WorkSource zza(int paramInt, String paramString) {
    WorkSource workSource = new WorkSource();
    zza(workSource, paramInt, paramString);
    return workSource;
  }
  
  private static String zza(WorkSource paramWorkSource, int paramInt) {
    Method method = zzf;
    if (method != null)
      try {
        return (String)method.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt) });
      } catch (Exception exception) {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", exception);
      }  
    return null;
  }
  
  private static Method zza() {
    try {
      return WorkSource.class.getMethod("add", new Class[] { int.class });
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private static void zza(WorkSource paramWorkSource, int paramInt, String paramString) {
    if (zzc != null) {
      String str = paramString;
      if (paramString == null)
        str = ""; 
      try {
        zzc.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt), str });
        return;
      } catch (Exception exception) {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", exception);
        return;
      } 
    } 
    Method method = zzb;
    if (method != null)
      try {
        method.invoke(exception, new Object[] { Integer.valueOf(paramInt) });
        return;
      } catch (Exception exception1) {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", exception1);
      }  
  }
  
  private static Method zzb() {
    if (PlatformVersion.isAtLeastJellyBeanMR2())
      try {
        return WorkSource.class.getMethod("add", new Class[] { int.class, String.class });
      } catch (Exception exception) {} 
    return null;
  }
  
  private static Method zzc() {
    try {
      return WorkSource.class.getMethod("size", new Class[0]);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private static Method zzd() {
    try {
      return WorkSource.class.getMethod("get", new Class[] { int.class });
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private static Method zze() {
    if (PlatformVersion.isAtLeastJellyBeanMR2())
      try {
        return WorkSource.class.getMethod("getName", new Class[] { int.class });
      } catch (Exception exception) {} 
    return null;
  }
  
  private static final Method zzf() {
    if (PlatformVersion.isAtLeastP())
      try {
        return WorkSource.class.getMethod("createWorkChain", new Class[0]);
      } catch (Exception exception) {
        Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", exception);
      }  
    return null;
  }
  
  private static final Method zzg() {
    if (PlatformVersion.isAtLeastP())
      try {
        return Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", new Class[] { int.class, String.class });
      } catch (Exception exception) {
        Log.w("WorkSourceUtil", "Missing WorkChain class", exception);
      }  
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\commo\\util\WorkSourceUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */