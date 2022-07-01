package com.google.android.material.internal;

import android.os.Build;
import java.util.Locale;

public class ManufacturerUtils {
  public static boolean a() {
    return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu");
  }
  
  public static boolean b() {
    return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("lge");
  }
  
  public static boolean c() {
    return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("samsung");
  }
  
  public static boolean d() {
    return (b() || c());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\internal\ManufacturerUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */