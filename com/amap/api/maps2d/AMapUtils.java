package com.amap.api.maps2d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.amap.api.mapcore2d.cp;
import com.amap.api.mapcore2d.cq;
import com.amap.api.mapcore2d.cs;
import com.amap.api.mapcore2d.da;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.NaviPara;
import com.amap.api.maps2d.model.PoiPara;
import com.amap.api.maps2d.model.RoutePara;
import java.util.Locale;

public class AMapUtils {
  public static final int BUS_COMFORT = 4;
  
  public static final int BUS_MONEY_LITTLE = 1;
  
  public static final int BUS_NO_SUBWAY = 5;
  
  public static final int BUS_TIME_FIRST = 0;
  
  public static final int BUS_TRANSFER_LITTLE = 2;
  
  public static final int BUS_WALK_LITTLE = 3;
  
  public static final int DRIVING_AVOID_CONGESTION = 4;
  
  public static final int DRIVING_DEFAULT = 0;
  
  public static final int DRIVING_NO_HIGHWAY = 3;
  
  public static final int DRIVING_NO_HIGHWAY_AVOID_CONGESTION = 6;
  
  public static final int DRIVING_NO_HIGHWAY_AVOID_SHORT_MONEY = 5;
  
  public static final int DRIVING_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 8;
  
  public static final int DRIVING_SAVE_MONEY = 1;
  
  public static final int DRIVING_SAVE_MONEY_AVOID_CONGESTION = 7;
  
  public static final int DRIVING_SHORT_DISTANCE = 2;
  
  private static String a(NaviPara paramNaviPara, Context paramContext) {
    return String.format(Locale.US, "androidamap://navi?sourceApplication=%s&lat=%f&lon=%f&dev=0&style=%d", new Object[] { cq.b(paramContext), Double.valueOf((paramNaviPara.getTargetPoint()).latitude), Double.valueOf((paramNaviPara.getTargetPoint()).longitude), Integer.valueOf(paramNaviPara.getNaviStyle()) });
  }
  
  private static String a(PoiPara paramPoiPara, Context paramContext) {
    String str2 = String.format(Locale.US, "androidamap://arroundpoi?sourceApplication=%s&keywords=%s&dev=0", new Object[] { cq.b(paramContext), paramPoiPara.getKeywords() });
    String str1 = str2;
    if (paramPoiPara.getCenter() != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str2);
      stringBuilder.append("&lat=");
      stringBuilder.append((paramPoiPara.getCenter()).latitude);
      stringBuilder.append("&lon=");
      stringBuilder.append((paramPoiPara.getCenter()).longitude);
      str1 = stringBuilder.toString();
    } 
    return str1;
  }
  
  private static String a(RoutePara paramRoutePara, Context paramContext, int paramInt) {
    String str2 = String.format(Locale.US, "androidamap://route?sourceApplication=%s&slat=%f&slon=%f&sname=%s&dlat=%f&dlon=%f&dname=%s&dev=0&t=%d", new Object[] { cq.b(paramContext), Double.valueOf((paramRoutePara.getStartPoint()).latitude), Double.valueOf((paramRoutePara.getStartPoint()).longitude), paramRoutePara.getStartName(), Double.valueOf((paramRoutePara.getEndPoint()).latitude), Double.valueOf((paramRoutePara.getEndPoint()).longitude), paramRoutePara.getEndName(), Integer.valueOf(paramInt) });
    if (paramInt == 1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str2);
      stringBuilder.append("&m=");
      stringBuilder.append(paramRoutePara.getTransitRouteStyle());
      return stringBuilder.toString();
    } 
    String str1 = str2;
    if (paramInt == 2) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str2);
      stringBuilder.append("&m=");
      stringBuilder.append(paramRoutePara.getDrivingRouteStyle());
      str1 = stringBuilder.toString();
    } 
    return str1;
  }
  
  private static boolean a(Context paramContext) {
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo("com.autonavi.minimap", 0);
      return (packageInfo != null);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return false;
    } 
  }
  
  private static boolean a(RoutePara paramRoutePara) {
    return !(paramRoutePara.getStartPoint() == null || paramRoutePara.getEndPoint() == null || paramRoutePara.getStartName() == null || paramRoutePara.getStartName().trim().length() <= 0 || paramRoutePara.getEndName() == null || paramRoutePara.getEndName().trim().length() <= 0);
  }
  
  private static void b(RoutePara paramRoutePara, Context paramContext, int paramInt) throws AMapException {
    if (a(paramContext)) {
      if (a(paramRoutePara))
        try {
          Intent intent = new Intent("android.intent.action.VIEW");
          intent.addFlags(276824064);
          intent.addCategory("android.intent.category.DEFAULT");
          intent.setData(Uri.parse(a(paramRoutePara, paramContext, paramInt)));
          intent.setPackage("com.autonavi.minimap");
          (new a("oan", paramContext)).start();
          return;
        } finally {
          paramRoutePara = null;
        }  
      throw new AMapException("非法导航参数");
    } 
    throw new AMapException("移动设备上未安装高德地图或高德地图版本较旧");
  }
  
  public static float calculateArea(LatLng paramLatLng1, LatLng paramLatLng2) {
    if (paramLatLng1 != null && paramLatLng2 != null) {
      double d3 = Math.sin(paramLatLng1.latitude * Math.PI / 180.0D);
      double d4 = Math.sin(paramLatLng2.latitude * Math.PI / 180.0D);
      double d2 = (paramLatLng2.longitude - paramLatLng1.longitude) / 360.0D;
      double d1 = d2;
      if (d2 < 0.0D)
        d1 = d2 + 1.0D; 
      return (float)(2.5560394669790553E14D * (d3 - d4) * d1);
    } 
    try {
      throw new AMapException("非法坐标值");
    } catch (AMapException aMapException) {
      aMapException.printStackTrace();
      return 0.0F;
    } 
  }
  
  public static float calculateLineDistance(LatLng paramLatLng1, LatLng paramLatLng2) {
    if (paramLatLng1 != null && paramLatLng2 != null) {
      double d4 = paramLatLng1.longitude;
      double d3 = paramLatLng1.latitude;
      double d2 = paramLatLng2.longitude;
      double d1 = paramLatLng2.latitude;
      double d5 = d4 * 0.01745329251994329D;
      double d6 = d3 * 0.01745329251994329D;
      d3 = d2 * 0.01745329251994329D;
      d4 = d1 * 0.01745329251994329D;
      d1 = Math.sin(d5);
      d2 = Math.sin(d6);
      d5 = Math.cos(d5);
      d6 = Math.cos(d6);
      double d7 = Math.sin(d3);
      double d8 = Math.sin(d4);
      d3 = Math.cos(d3);
      d4 = Math.cos(d4);
      double[] arrayOfDouble1 = new double[3];
      double[] arrayOfDouble2 = new double[3];
      arrayOfDouble1[0] = d5 * d6;
      arrayOfDouble1[1] = d6 * d1;
      arrayOfDouble1[2] = d2;
      arrayOfDouble2[0] = d3 * d4;
      arrayOfDouble2[1] = d4 * d7;
      arrayOfDouble2[2] = d8;
      return (float)(Math.asin(Math.sqrt((arrayOfDouble1[0] - arrayOfDouble2[0]) * (arrayOfDouble1[0] - arrayOfDouble2[0]) + (arrayOfDouble1[1] - arrayOfDouble2[1]) * (arrayOfDouble1[1] - arrayOfDouble2[1]) + (arrayOfDouble1[2] - arrayOfDouble2[2]) * (arrayOfDouble1[2] - arrayOfDouble2[2])) / 2.0D) * 1.27420015798544E7D);
    } 
    try {
      throw new AMapException("非法坐标值");
    } catch (AMapException aMapException) {
      aMapException.printStackTrace();
      return 0.0F;
    } 
  }
  
  public static void getLatestAMapApp(Context paramContext) {
    try {
      Intent intent = new Intent("android.intent.action.VIEW");
      intent.addFlags(276824064);
      intent.addCategory("android.intent.category.DEFAULT");
      intent.setData(Uri.parse("http://wap.amap.com/"));
      return;
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  public static void openAMapDrivingRoute(RoutePara paramRoutePara, Context paramContext) throws AMapException {
    b(paramRoutePara, paramContext, 2);
  }
  
  public static void openAMapNavi(NaviPara paramNaviPara, Context paramContext) throws AMapException {
    if (a(paramContext)) {
      if (paramNaviPara.getTargetPoint() != null)
        try {
          Intent intent = new Intent("android.intent.action.VIEW");
          intent.addFlags(276824064);
          intent.addCategory("android.intent.category.DEFAULT");
          intent.setData(Uri.parse(a(paramNaviPara, paramContext)));
          intent.setPackage("com.autonavi.minimap");
          (new a("oan", paramContext)).start();
          return;
        } finally {
          paramNaviPara = null;
        }  
      throw new AMapException("非法导航参数");
    } 
    throw new AMapException("移动设备上未安装高德地图或高德地图版本较旧");
  }
  
  public static void openAMapPoiNearbySearch(PoiPara paramPoiPara, Context paramContext) throws AMapException {
    if (a(paramContext)) {
      if (paramPoiPara.getKeywords() != null && paramPoiPara.getKeywords().trim().length() > 0)
        try {
          Intent intent = new Intent("android.intent.action.VIEW");
          intent.addFlags(276824064);
          intent.addCategory("android.intent.category.DEFAULT");
          intent.setData(Uri.parse(a(paramPoiPara, paramContext)));
          intent.setPackage("com.autonavi.minimap");
          (new a("oan", paramContext)).start();
          return;
        } finally {
          paramPoiPara = null;
        }  
      throw new AMapException("非法导航参数");
    } 
    throw new AMapException("移动设备上未安装高德地图或高德地图版本较旧");
  }
  
  public static void openAMapTransitRoute(RoutePara paramRoutePara, Context paramContext) throws AMapException {
    b(paramRoutePara, paramContext, 1);
  }
  
  public static void openAMapWalkingRoute(RoutePara paramRoutePara, Context paramContext) throws AMapException {
    b(paramRoutePara, paramContext, 4);
  }
  
  static class a extends Thread {
    String a = "";
    
    Context b;
    
    public a(String param1String, Context param1Context) {
      this.a = param1String;
      if (param1Context != null)
        this.b = param1Context.getApplicationContext(); 
    }
    
    public void run() {
      if (this.b != null)
        try {
          da da = (new da.a(this.a, "6.0.0", "AMAP_SDK_Android_2DMap_6.0.0")).a(new String[] { "com.amap.api.maps" }).a();
          cs.a(this.b, da);
          interrupt();
          return;
        } catch (cp cp) {
          cp.printStackTrace();
        }  
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\AMapUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */