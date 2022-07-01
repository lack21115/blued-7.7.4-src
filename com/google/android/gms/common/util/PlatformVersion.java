package com.google.android.gms.common.util;

import android.os.Build;
import android.util.Log;

public final class PlatformVersion {
  private static Boolean zza;
  
  public static boolean isAtLeastHoneycomb() {
    return true;
  }
  
  public static boolean isAtLeastHoneycombMR1() {
    return true;
  }
  
  public static boolean isAtLeastIceCreamSandwich() {
    return true;
  }
  
  public static boolean isAtLeastIceCreamSandwichMR1() {
    return (Build.VERSION.SDK_INT >= 15);
  }
  
  public static boolean isAtLeastJellyBean() {
    return (Build.VERSION.SDK_INT >= 16);
  }
  
  public static boolean isAtLeastJellyBeanMR1() {
    return (Build.VERSION.SDK_INT >= 17);
  }
  
  public static boolean isAtLeastJellyBeanMR2() {
    return (Build.VERSION.SDK_INT >= 18);
  }
  
  public static boolean isAtLeastKitKat() {
    return (Build.VERSION.SDK_INT >= 19);
  }
  
  public static boolean isAtLeastKitKatWatch() {
    return (Build.VERSION.SDK_INT >= 20);
  }
  
  public static boolean isAtLeastLollipop() {
    return (Build.VERSION.SDK_INT >= 21);
  }
  
  public static boolean isAtLeastLollipopMR1() {
    return (Build.VERSION.SDK_INT >= 22);
  }
  
  public static boolean isAtLeastM() {
    return (Build.VERSION.SDK_INT >= 23);
  }
  
  public static boolean isAtLeastN() {
    return (Build.VERSION.SDK_INT >= 24);
  }
  
  public static boolean isAtLeastO() {
    return (Build.VERSION.SDK_INT >= 26);
  }
  
  public static boolean isAtLeastP() {
    return (Build.VERSION.SDK_INT >= 28);
  }
  
  public static boolean isAtLeastQ() {
    return (Build.VERSION.SDK_INT >= 29);
  }
  
  public static boolean isAtLeastR() {
    boolean bool1;
    boolean bool = isAtLeastQ();
    boolean bool2 = false;
    if (!bool)
      return false; 
    if (Build.VERSION.SDK_INT >= 30 && Build.VERSION.CODENAME.equals("REL"))
      return true; 
    if (Build.VERSION.CODENAME.length() == 1 && Build.VERSION.CODENAME.charAt(0) >= 'R' && Build.VERSION.CODENAME.charAt(0) <= 'Z') {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (!bool1)
      return false; 
    Boolean bool3 = zza;
    if (bool3 != null)
      return bool3.booleanValue(); 
    bool = bool2;
    try {
      if ("google".equals(Build.BRAND)) {
        bool = bool2;
        if (!Build.ID.startsWith("RPP1")) {
          bool = bool2;
          if (!Build.ID.startsWith("RPP2")) {
            bool = bool2;
            if (Integer.parseInt(Build.VERSION.INCREMENTAL) >= 6301457)
              bool = true; 
          } 
        } 
      } 
      zza = Boolean.valueOf(bool);
    } catch (NumberFormatException numberFormatException) {
      zza = Boolean.valueOf(true);
    } 
    if (!zza.booleanValue())
      Log.w("PlatformVersion", "Build version must be at least 6301457 to support R in gmscore"); 
    return zza.booleanValue();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\commo\\util\PlatformVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */