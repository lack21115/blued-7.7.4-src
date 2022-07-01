package com.qiniu.pili.droid.shortvideo.f;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class j {
  public static long a(long paramLong) {
    return paramLong * 1000000L;
  }
  
  public static Bitmap a(View paramView) {
    Bitmap bitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    paramView.layout(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    paramView.draw(canvas);
    return bitmap;
  }
  
  public static String a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("os version:");
    stringBuilder.append(Build.VERSION.RELEASE);
    stringBuilder.append(", Android SDK_INT:");
    stringBuilder.append(Build.VERSION.SDK_INT);
    stringBuilder.append(", SoC Hardware:");
    stringBuilder.append(Build.HARDWARE);
    return a(stringBuilder.toString().trim());
  }
  
  public static String a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    int k = paramString.length();
    for (int i = 0; i < k; i++) {
      char c = paramString.charAt(i);
      if (c > '\037' && c < '')
        stringBuilder.append(c); 
    } 
    return stringBuilder.toString();
  }
  
  private static String a(String paramString1, String paramString2) {
    String str = paramString1.toLowerCase(Locale.getDefault());
    return (str.startsWith("unknown") || str.startsWith("alps") || str.startsWith("android") || str.startsWith("sprd") || str.startsWith("spreadtrum") || str.startsWith("rockchip") || str.startsWith("wondermedia") || str.startsWith("mtk") || str.startsWith("mt65") || str.startsWith("nvidia") || str.startsWith("brcm") || str.startsWith("marvell") || paramString2.toLowerCase(Locale.getDefault()).contains(str)) ? null : paramString1;
  }
  
  public static boolean a(double paramDouble) {
    int i = paramDouble cmp 1.0D;
    return ((i > 0 && paramDouble % 2.0D == 0.0D) || (paramDouble < 1.0D && 1.0D / paramDouble % 2.0D == 0.0D) || i == 0);
  }
  
  public static boolean a(int paramInt) {
    paramInt = Math.abs(paramInt);
    return (paramInt == 0 || paramInt == 90 || paramInt == 180 || paramInt == 270);
  }
  
  public static boolean a(Context paramContext) {
    return paramContext.getPackageManager().hasSystemFeature("android.hardware.camera");
  }
  
  public static int b(int paramInt) {
    int i = paramInt % 360;
    paramInt = i;
    if (i < 0)
      paramInt = 360 - Math.abs(i); 
    return paramInt;
  }
  
  public static int b(Context paramContext) {
    return ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRotation();
  }
  
  public static long b(long paramLong) {
    return paramLong / 1000000L;
  }
  
  public static String b() {
    String str3 = Build.MODEL.trim();
    String str2 = a(Build.MANUFACTURER.trim(), str3);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = a(Build.BRAND.trim(), str3); 
    StringBuilder stringBuilder = new StringBuilder();
    str2 = str1;
    if (str1 == null)
      str2 = ""; 
    stringBuilder.append(str2);
    stringBuilder.append(str3);
    return a(stringBuilder.toString()).replace(" ", "_");
  }
  
  private static int c(int paramInt) {
    return (paramInt & 0xFFFF0000) >> 16;
  }
  
  public static int c(Context paramContext) {
    int i = b(paramContext);
    return (i != 0) ? ((i != 1) ? ((i != 2) ? ((i != 3) ? 0 : 270) : 180) : 90) : 0;
  }
  
  public static long c(long paramLong) {
    return paramLong / 1000L / 60L;
  }
  
  public static int d(Context paramContext) {
    ConfigurationInfo configurationInfo = ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo();
    return (configurationInfo.reqGlEsVersion != 0) ? c(configurationInfo.reqGlEsVersion) : 1;
  }
  
  public static boolean e(Context paramContext) {
    Point point = f(paramContext);
    return (point.x > point.y);
  }
  
  public static Point f(Context paramContext) {
    Point point = new Point();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getSize(point);
    return point;
  }
  
  public static String g(Context paramContext) {
    try {
      return (paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0)).packageName;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return "";
    } 
  }
  
  public static String h(Context paramContext) {
    try {
      return (paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0)).versionName;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return "";
    } 
  }
  
  public static String i(Context paramContext) {
    ApplicationInfo applicationInfo = paramContext.getApplicationInfo();
    int i = applicationInfo.labelRes;
    return (i == 0) ? applicationInfo.nonLocalizedLabel.toString() : paramContext.getString(i);
  }
  
  public static String j(Context paramContext) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("device_model", b());
      jSONObject.put("os_version", a());
      jSONObject.put("sdk_version", "amix-3.0;PLDroidShortVideo-3.1.1");
      jSONObject.put("app_name", g(paramContext));
      jSONObject.put("app_version", h(paramContext));
      jSONObject.put("gl_version", d(paramContext));
      return jSONObject.toString();
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return jSONException.toString();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\f\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */