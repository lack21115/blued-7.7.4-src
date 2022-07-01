package com.blued.android.module.location.gaode;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.blued.android.module.location.listener.OnLocationListener;
import com.blued.android.module.location.utils.AppUtils;
import com.blued.android.module.location.utils.LocationCacheUtils;
import com.blued.android.module.location.utils.ThreadUtils;

public class GaoDeLocationService {
  private static String a = GaoDeLocationService.class.getSimpleName();
  
  private static volatile GaoDeLocationService c;
  
  private AMapLocationClient b = new AMapLocationClient((Context)AppUtils.a());
  
  private OnLocationListener d;
  
  private GaoDeLocationService() {
    this.b.setLocationListener(new MyLocationListener());
  }
  
  public static GaoDeLocationService a() {
    // Byte code:
    //   0: getstatic com/blued/android/module/location/gaode/GaoDeLocationService.c : Lcom/blued/android/module/location/gaode/GaoDeLocationService;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/module/location/gaode/GaoDeLocationService
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/location/gaode/GaoDeLocationService.c : Lcom/blued/android/module/location/gaode/GaoDeLocationService;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/module/location/gaode/GaoDeLocationService
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/location/gaode/GaoDeLocationService.c : Lcom/blued/android/module/location/gaode/GaoDeLocationService;
    //   25: ldc com/blued/android/module/location/gaode/GaoDeLocationService
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/module/location/gaode/GaoDeLocationService
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/module/location/gaode/GaoDeLocationService.c : Lcom/blued/android/module/location/gaode/GaoDeLocationService;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void a(double paramDouble1, double paramDouble2) {
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("定位Log: 高德： onGetLocation   longitude：");
    stringBuilder.append(paramDouble1);
    stringBuilder.append(",latitude:");
    stringBuilder.append(paramDouble2);
    Log.i(str, stringBuilder.toString());
    if (paramDouble1 != Double.MIN_VALUE && paramDouble2 != Double.MIN_VALUE) {
      if (paramDouble1 == 0.0D && paramDouble2 == 0.0D)
        return; 
      LocationCacheUtils.a(paramDouble1);
      LocationCacheUtils.b(paramDouble2);
    } 
  }
  
  private void a(int paramInt) {
    ThreadUtils.b(new Runnable(this, paramInt) {
          public void run() {
            if (GaoDeLocationService.a(this.b) != null)
              GaoDeLocationService.a(this.b).a(this.a); 
          }
        });
    this.b.stopLocation();
    Log.i(a, "定位Log: 高德： locationError  定位失败===");
  }
  
  private void a(String paramString1, String paramString2) {
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("定位Log: 高德： 更新地理地理位置：address 两级：");
    stringBuilder.append(paramString1);
    stringBuilder.append("，特别详细的位置信息：Detail:");
    stringBuilder.append(paramString2);
    Log.i(str, stringBuilder.toString());
    if (!TextUtils.isEmpty(paramString1) && !paramString1.contains("null"))
      LocationCacheUtils.c(paramString1); 
  }
  
  private void a(boolean paramBoolean, int paramInt) {
    AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
    if (paramBoolean) {
      aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
    } else {
      aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
    } 
    aMapLocationClientOption.setOnceLocation(true);
    aMapLocationClientOption.setOnceLocationLatest(true);
    aMapLocationClientOption.setHttpTimeOut((paramInt * 1000));
    this.b.setLocationOption(aMapLocationClientOption);
  }
  
  private void c() {
    ThreadUtils.b(new Runnable(this) {
          public void run() {
            if (GaoDeLocationService.a(this.a) != null)
              GaoDeLocationService.a(this.a).a(); 
          }
        });
    this.b.stopLocation();
    Log.i(a, "定位Log: 高德： locationSuccess  定位成功===");
  }
  
  public void a(boolean paramBoolean, int paramInt, OnLocationListener paramOnLocationListener) {
    this.d = paramOnLocationListener;
    if (paramInt < 8 || this.b == null) {
      ThreadUtils.b(new Runnable(this) {
            public void run() {
              if (GaoDeLocationService.a(this.a) != null)
                GaoDeLocationService.a(this.a).a(); 
            }
          });
      return;
    } 
    a(paramBoolean, paramInt);
    this.b.startLocation();
  }
  
  class MyLocationListener implements AMapLocationListener {
    private MyLocationListener(GaoDeLocationService this$0) {}
    
    public void onLocationChanged(AMapLocation param1AMapLocation) {
      if (param1AMapLocation != null) {
        if (param1AMapLocation.getErrorCode() == 0) {
          String str1;
          GaoDeLocationService.a(this.a, param1AMapLocation.getLongitude(), param1AMapLocation.getLatitude());
          if (!TextUtils.isEmpty(param1AMapLocation.getProvince()) && !TextUtils.isEmpty(param1AMapLocation.getCity()) && param1AMapLocation.getProvince().equals(param1AMapLocation.getCity())) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(param1AMapLocation.getCity());
            stringBuilder1.append(" ");
            stringBuilder1.append(param1AMapLocation.getDistrict());
            str1 = stringBuilder1.toString();
          } else {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(param1AMapLocation.getProvince());
            stringBuilder1.append(" ");
            stringBuilder1.append(param1AMapLocation.getCity());
            str1 = stringBuilder1.toString();
          } 
          GaoDeLocationService.a(this.a, str1, param1AMapLocation.getAddress());
          LocationCacheUtils.a(param1AMapLocation.getCity());
          LocationCacheUtils.b(param1AMapLocation.getProvince());
          GaoDeLocationService.b(this.a);
          return;
        } 
        String str = GaoDeLocationService.b();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("定位Log: 高德： location Error, ErrCode:");
        stringBuilder.append(param1AMapLocation.getErrorCode());
        stringBuilder.append(", errInfo:");
        stringBuilder.append(param1AMapLocation.getErrorInfo());
        Log.i(str, stringBuilder.toString());
        GaoDeLocationService.a(this.a, param1AMapLocation.getErrorCode());
        return;
      } 
      GaoDeLocationService.a(this.a, 110);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\location\gaode\GaoDeLocationService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */