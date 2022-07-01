package com.amap.api.col.s;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;
import com.amap.api.services.share.ShareSearch;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import java.util.Iterator;
import java.util.List;

public final class s extends Handler {
  private static s a;
  
  s() {}
  
  private s(Looper paramLooper) {
    super(paramLooper);
  }
  
  public static s a() {
    // Byte code:
    //   0: ldc com/amap/api/col/s/s
    //   2: monitorenter
    //   3: getstatic com/amap/api/col/s/s.a : Lcom/amap/api/col/s/s;
    //   6: ifnonnull -> 53
    //   9: invokestatic myLooper : ()Landroid/os/Looper;
    //   12: ifnull -> 40
    //   15: invokestatic myLooper : ()Landroid/os/Looper;
    //   18: invokestatic getMainLooper : ()Landroid/os/Looper;
    //   21: if_acmpeq -> 27
    //   24: goto -> 40
    //   27: new com/amap/api/col/s/s
    //   30: dup
    //   31: invokespecial <init> : ()V
    //   34: putstatic com/amap/api/col/s/s.a : Lcom/amap/api/col/s/s;
    //   37: goto -> 53
    //   40: new com/amap/api/col/s/s
    //   43: dup
    //   44: invokestatic getMainLooper : ()Landroid/os/Looper;
    //   47: invokespecial <init> : (Landroid/os/Looper;)V
    //   50: putstatic com/amap/api/col/s/s.a : Lcom/amap/api/col/s/s;
    //   53: getstatic com/amap/api/col/s/s.a : Lcom/amap/api/col/s/s;
    //   56: astore_0
    //   57: ldc com/amap/api/col/s/s
    //   59: monitorexit
    //   60: aload_0
    //   61: areturn
    //   62: astore_0
    //   63: ldc com/amap/api/col/s/s
    //   65: monitorexit
    //   66: aload_0
    //   67: athrow
    // Exception table:
    //   from	to	target	type
    //   3	24	62	finally
    //   27	37	62	finally
    //   40	53	62	finally
    //   53	57	62	finally
  }
  
  public final void handleMessage(Message paramMessage) {
    try {
      DriveRoutePlanResult driveRoutePlanResult;
      Bundle bundle1;
      ShareSearch.OnShareSearchListener onShareSearchListener;
      List list;
      Iterator<NearbySearch.NearbyListener> iterator;
      BusStationSearch.OnBusStationSearchListener onBusStationSearchListener;
      int i = paramMessage.arg1;
      Bundle bundle2 = null;
      b b = null;
      f f = null;
      RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener = null;
      switch (i) {
        default:
          return;
        case 18:
          return;
        case 17:
          return;
        case 16:
          return;
        case 14:
          return;
        case 13:
          return;
        case 12:
          return;
        case 11:
          i = ((Message)bundle1).arg2;
          onShareSearchListener = (ShareSearch.OnShareSearchListener)((Message)bundle1).obj;
          return;
        case 10:
          return;
        case 9:
          return;
        case 8:
          return;
        case 7:
          return;
        case 6:
          return;
        case 5:
          return;
        case 4:
          return;
        case 3:
          return;
        case 2:
          return;
        case 1:
          break;
      } 
    } finally {
      paramMessage = null;
      i.a((Throwable)paramMessage, "MessageHandler", "handleMessage");
    } 
  }
  
  public static final class a {
    public BusLineResult a;
    
    public BusLineSearch.OnBusLineSearchListener b;
  }
  
  public static final class b {
    public BusStationResult a;
    
    public BusStationSearch.OnBusStationSearchListener b;
  }
  
  public static final class c {
    public CloudItemDetail a;
    
    public CloudSearch.OnCloudSearchListener b;
  }
  
  public static final class d {
    public CloudResult a;
    
    public CloudSearch.OnCloudSearchListener b;
  }
  
  public static final class e {
    public GeocodeResult a;
    
    public GeocodeSearch.OnGeocodeSearchListener b;
  }
  
  public static final class f {
    public List<NearbySearch.NearbyListener> a;
    
    public NearbySearchResult b;
  }
  
  public static final class g {
    public PoiItem a;
    
    public PoiSearch.OnPoiSearchListener b;
  }
  
  public static final class h {
    public PoiResult a;
    
    public PoiSearch.OnPoiSearchListener b;
  }
  
  public static final class i {
    public RegeocodeResult a;
    
    public GeocodeSearch.OnGeocodeSearchListener b;
  }
  
  public static final class j {
    public RoutePOISearchResult a;
    
    public RoutePOISearch.OnRoutePOISearchListener b;
  }
  
  public static final class k {
    public LocalWeatherForecastResult a;
    
    public WeatherSearch.OnWeatherSearchListener b;
  }
  
  public static final class l {
    public LocalWeatherLiveResult a;
    
    public WeatherSearch.OnWeatherSearchListener b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */