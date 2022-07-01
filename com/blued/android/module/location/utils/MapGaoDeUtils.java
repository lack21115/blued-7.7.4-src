package com.blued.android.module.location.utils;

import android.graphics.Bitmap;
import android.graphics.Color;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.AMapUtils;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.UiSettings;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.blued.android.module.location.LocationService;
import com.blued.android.module.location.R;
import com.blued.android.module.location.View.MapViews;
import com.blued.android.module.location.listener.OnLocationRequestListener;
import java.util.List;

public class MapGaoDeUtils {
  public static float a() {
    try {
      if (!LocationService.e().equals("0") && !LocationService.a().equals("0")) {
        double d1 = Double.parseDouble(LocationService.b());
        double d2 = Double.parseDouble(LocationService.a());
        double d3 = Double.parseDouble(LocationService.e());
        double d4 = Double.parseDouble(LocationService.d());
        float f = AMapUtils.calculateLineDistance(new LatLng(d1, d2), new LatLng(d3, d4));
        return f / 1000.0F;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return 0.0F;
  }
  
  public static void a(AMap paramAMap, double paramDouble1, double paramDouble2) {
    if (paramAMap != null)
      try {
        paramAMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(paramDouble1, paramDouble2), 15.0F));
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public static void a(AMap paramAMap, double paramDouble1, double paramDouble2, Bitmap paramBitmap) {
    if (paramAMap != null && paramDouble1 != 0.0D && paramDouble2 != 0.0D) {
      if (paramBitmap == null)
        return; 
      MarkerOptions markerOptions = new MarkerOptions();
      LatLng latLng = new LatLng(paramDouble1, paramDouble2);
      markerOptions.position(latLng);
      markerOptions.draggable(false);
      markerOptions.anchor(0.5F, 0.5F);
      markerOptions.icon(BitmapDescriptorFactory.fromBitmap(paramBitmap));
      paramAMap.addMarker(markerOptions).setPosition(latLng);
    } 
  }
  
  public static void a(AMap paramAMap, AMap.OnCameraChangeListener paramOnCameraChangeListener, List<MapViews.Marker> paramList, LifecycleOwner paramLifecycleOwner) {
    if (paramAMap == null)
      return; 
    MyLocationStyle myLocationStyle = new MyLocationStyle();
    myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(R.drawable.my_position));
    myLocationStyle.strokeColor(Color.argb(0, 0, 0, 0));
    myLocationStyle.radiusFillColor(Color.argb(0, 0, 0, 0));
    myLocationStyle.strokeWidth(0.0F);
    paramAMap.setMyLocationStyle(myLocationStyle);
    paramAMap.getUiSettings().setMyLocationButtonEnabled(false);
    paramAMap.getUiSettings().setZoomControlsEnabled(false);
    if (paramOnCameraChangeListener != null)
      paramAMap.setOnCameraChangeListener(paramOnCameraChangeListener); 
    paramAMap.moveCamera(CameraUpdateFactory.zoomTo(15.0F));
    if (AppUtils.e()) {
      paramAMap.setMapLanguage("zh_cn");
    } else {
      paramAMap.setMapLanguage("en");
    } 
    if (paramList != null && paramList.size() > 0) {
      for (MapViews.Marker marker : paramList)
        a(paramAMap, marker.b, marker.a, marker.c); 
      paramAMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(((MapViews.Marker)paramList.get(0)).b, ((MapViews.Marker)paramList.get(0)).a), 15.0F));
      return;
    } 
    try {
      a(paramAMap, Double.parseDouble(LocationService.b()), Double.parseDouble(LocationService.a()));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    LocationService.a(new OnLocationRequestListener((LifecycleOwner)marker, paramAMap) {
          public void onComplete(int param1Int, String param1String1, String param1String2) {
            if (param1Int == 0) {
              LifecycleOwner lifecycleOwner = this.a;
              if (lifecycleOwner == null || lifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.INITIALIZED))
                MapGaoDeUtils.a(this.b, Double.parseDouble(param1String2), Double.parseDouble(param1String1)); 
            } 
          }
        }true);
  }
  
  public static void a(AMap paramAMap, boolean paramBoolean) {
    if (paramAMap != null) {
      UiSettings uiSettings = paramAMap.getUiSettings();
      if (uiSettings != null)
        uiSettings.setZoomGesturesEnabled(paramBoolean); 
    } 
  }
  
  public static void b(AMap paramAMap, boolean paramBoolean) {
    if (paramAMap != null) {
      UiSettings uiSettings = paramAMap.getUiSettings();
      if (uiSettings != null)
        uiSettings.setScrollGesturesEnabled(paramBoolean); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\locatio\\utils\MapGaoDeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */