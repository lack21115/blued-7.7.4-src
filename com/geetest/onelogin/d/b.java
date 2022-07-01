package com.geetest.onelogin.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.DisplayMetrics;
import com.geetest.onelogin.a.c;
import com.geetest.onelogin.j.j;
import java.net.URLEncoder;

public class b {
  public static void a(Context paramContext, a parama) {
    try {
      PackageManager packageManager = paramContext.getPackageManager();
      PackageInfo packageInfo = packageManager.getPackageInfo(paramContext.getPackageName(), 0);
      parama.setAppName(URLEncoder.encode((String)packageManager.getApplicationLabel(paramContext.getApplicationInfo()), "utf-8"));
      if (packageInfo != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(packageInfo.versionCode);
        stringBuilder.append("");
        parama.setVersionCode(stringBuilder.toString());
        parama.setVersionName(packageInfo.versionName);
        parama.setPackageName(packageInfo.packageName);
        parama.setPackageSign(e.a(paramContext));
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void a(a parama) {
    try {
      parama.setModel(Build.MODEL);
      parama.setDeviceSystemVersion(Build.VERSION.RELEASE);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void b(Context paramContext, a parama) {
    try {
      DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(displayMetrics.heightPixels);
      stringBuilder.append("");
      parama.setDeviceHeight(stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(displayMetrics.widthPixels);
      stringBuilder.append("");
      parama.setDeviceWidth(stringBuilder.toString());
      parama.setDeviceSystemName("android");
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void c(Context paramContext, a parama) {
    try {
      c c = j.a(paramContext);
      parama.setNetworkType(c.a());
      parama.setOperator(c.b());
      parama.setOp(j.c(paramContext));
      parama.setNetInfo((new d(paramContext)).toString());
      return;
    } catch (Exception exception) {
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */