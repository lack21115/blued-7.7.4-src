package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import java.util.Random;

public class h {
  public static String a() {
    return a("com.tencent.mobileqq", GDTADManager.getInstance().getSM().getInteger("qqNotFoundSampleRate", 1000));
  }
  
  private static String a(String paramString, int paramInt) {
    StringBuilder stringBuilder;
    d d = new d();
    if (TextUtils.isEmpty(paramString)) {
      GDTLogger.e("getVersionName error, packageName == null");
      paramInt = 1;
      u.a(100192, paramInt, null, d);
      return null;
    } 
    d.a("pkg", paramString);
    Context context = GDTADManager.getInstance().getAppContext();
    if (context == null) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("getVersionName error, context == null, pkg = ");
      stringBuilder.append(paramString);
      GDTLogger.e(stringBuilder.toString());
      paramInt = 2;
      u.a(100192, paramInt, null, d);
      return null;
    } 
    try {
      StringBuilder stringBuilder2;
      StringBuilder stringBuilder1;
      PackageManager packageManager = stringBuilder.getPackageManager();
      if (packageManager == null) {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("getVersionName error, pm == null, pkg = ");
        stringBuilder2.append(paramString);
        GDTLogger.e(stringBuilder2.toString());
        u.a(100192, 3, null, d);
        return null;
      } 
      PackageInfo packageInfo = stringBuilder2.getPackageInfo(paramString, 0);
      if (packageInfo == null) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("getVersionName error, info == null, pkg = ");
        stringBuilder1.append(paramString);
        GDTLogger.e(stringBuilder1.toString());
        u.a(100192, 4, null, d);
        return null;
      } 
      return ((PackageInfo)stringBuilder1).versionName;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      ak.a("getVersionName error, exception = %s", nameNotFoundException.toString());
      if ((new Random()).nextInt(10000) < paramInt) {
        paramInt = 5;
        u.a(100192, paramInt, null, d);
        return null;
      } 
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */