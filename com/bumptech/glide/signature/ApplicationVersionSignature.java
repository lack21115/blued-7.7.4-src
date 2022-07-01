package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.bumptech.glide.load.Key;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class ApplicationVersionSignature {
  private static final ConcurrentMap<String, Key> a = new ConcurrentHashMap<String, Key>();
  
  public static Key a(Context paramContext) {
    String str = paramContext.getPackageName();
    Key key2 = a.get(str);
    Key key1 = key2;
    if (key2 == null) {
      Key key = b(paramContext);
      key1 = a.putIfAbsent(str, key);
      if (key1 == null)
        return key; 
    } 
    return key1;
  }
  
  private static String a(PackageInfo paramPackageInfo) {
    return (paramPackageInfo != null) ? String.valueOf(paramPackageInfo.versionCode) : UUID.randomUUID().toString();
  }
  
  private static Key b(Context paramContext) {
    return new ObjectKey(a(c(paramContext)));
  }
  
  private static PackageInfo c(Context paramContext) {
    try {
      return paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Cannot resolve info for");
      stringBuilder.append(paramContext.getPackageName());
      Log.e("AppVersionSignature", stringBuilder.toString(), (Throwable)nameNotFoundException);
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\signature\ApplicationVersionSignature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */