package com.blued.android.module.location.utils;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.blued.android.module.location.LocationService;
import com.blued.android.module.location.View.MapViews;
import com.blued.android.module.location.listener.OnLocationRequestListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.List;

public class MapGoogleUtils {
  private static double a(double paramDouble) {
    return paramDouble * Math.PI / 180.0D;
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
    paramDouble1 = a(paramDouble1);
    paramDouble3 = a(paramDouble3);
    paramDouble2 = a(paramDouble2);
    paramDouble4 = a(paramDouble4);
    return (Math.round(Math.asin(Math.sqrt(Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D) + Math.cos(paramDouble1) * Math.cos(paramDouble3) * Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D))) * 2.0D * 6370996.81D * 1000000.0D) / 1000000L);
  }
  
  public static float a() {
    try {
      if (!LocationService.e().equals("0") && !LocationService.a().equals("0")) {
        double d = a(Double.parseDouble(LocationService.b()), Double.parseDouble(LocationService.a()), Double.parseDouble(LocationService.e()), Double.parseDouble(LocationService.d()));
        return (float)(d / 1000.0D);
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return 0.0F;
  }
  
  public static void a(GoogleMap paramGoogleMap, double paramDouble1, double paramDouble2) {
    if (paramGoogleMap != null)
      try {
        paramGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(paramDouble1, paramDouble2)));
        paramGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(15.0F));
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public static void a(GoogleMap paramGoogleMap, double paramDouble1, double paramDouble2, Bitmap paramBitmap) {
    if (paramGoogleMap != null && paramDouble1 != 0.0D && paramDouble2 != 0.0D) {
      if (paramBitmap == null)
        return; 
      MarkerOptions markerOptions = new MarkerOptions();
      LatLng latLng = new LatLng(paramDouble1, paramDouble2);
      markerOptions.position(latLng);
      markerOptions.draggable(false);
      markerOptions.anchor(0.5F, 0.5F);
      markerOptions.icon(BitmapDescriptorFactory.fromBitmap(paramBitmap));
      paramGoogleMap.addMarker(markerOptions).setPosition(latLng);
    } 
  }
  
  public static void a(GoogleMap paramGoogleMap, GoogleMap.OnCameraIdleListener paramOnCameraIdleListener, List<MapViews.Marker> paramList, LifecycleOwner paramLifecycleOwner) {
    if (paramGoogleMap == null)
      return; 
    paramGoogleMap.setMapType(1);
    UiSettings uiSettings = paramGoogleMap.getUiSettings();
    uiSettings.setTiltGesturesEnabled(true);
    uiSettings.setMyLocationButtonEnabled(false);
    if (Build.VERSION.SDK_INT <= 23) {
      uiSettings.setZoomControlsEnabled(false);
      uiSettings.setZoomGesturesEnabled(false);
      paramGoogleMap.setMinZoomPreference(6.0F);
      paramGoogleMap.setMaxZoomPreference(15.0F);
    } 
    if (paramOnCameraIdleListener != null)
      paramGoogleMap.setOnCameraIdleListener(paramOnCameraIdleListener); 
    if (paramList != null && paramList.size() > 0) {
      paramGoogleMap.setMyLocationEnabled(false);
      for (MapViews.Marker marker : paramList)
        a(paramGoogleMap, marker.b, marker.a, marker.c); 
      try {
        paramGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(((MapViews.Marker)paramList.get(0)).b, ((MapViews.Marker)paramList.get(0)).a)));
        paramGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(15.0F));
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
        return;
      } 
    } 
    try {
      a((GoogleMap)exception, Double.parseDouble(LocationService.b()), Double.parseDouble(LocationService.a()));
    } catch (Exception exception1) {
      exception1.printStackTrace();
    } 
    LocationService.a(new OnLocationRequestListener((LifecycleOwner)marker, (GoogleMap)exception) {
          public void onComplete(int param1Int, String param1String1, String param1String2) {
            if (param1Int == 0) {
              LifecycleOwner lifecycleOwner = this.a;
              if (lifecycleOwner == null || lifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.INITIALIZED))
                MapGoogleUtils.a(this.b, Double.parseDouble(param1String2), Double.parseDouble(param1String1)); 
            } 
          }
        }true);
  }
  
  public static void a(GoogleMap paramGoogleMap, boolean paramBoolean) {
    if (paramGoogleMap == null)
      return; 
    UiSettings uiSettings = paramGoogleMap.getUiSettings();
    if (uiSettings != null)
      uiSettings.setZoomGesturesEnabled(paramBoolean); 
  }
  
  public static void b(GoogleMap paramGoogleMap, boolean paramBoolean) {
    if (paramGoogleMap == null)
      return; 
    UiSettings uiSettings = paramGoogleMap.getUiSettings();
    if (uiSettings != null)
      uiSettings.setScrollGesturesEnabled(paramBoolean); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\locatio\\utils\MapGoogleUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */