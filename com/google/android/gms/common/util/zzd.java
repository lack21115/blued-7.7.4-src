package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.zzbih;

public final class zzd {
  public static boolean zzv(Context paramContext, String paramString) {
    "com.google.android.gms".equals(paramString);
    try {
      int i = (zzbih.zzdd(paramContext).getApplicationInfo(paramString, 0)).flags;
      return ((i & 0x200000) != 0);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\commo\\util\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */