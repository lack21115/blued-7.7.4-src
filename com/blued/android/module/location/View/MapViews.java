package com.blued.android.module.location.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.LifecycleOwner;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.CameraPosition;
import com.blued.android.module.location.LocationService;
import com.blued.android.module.location.LocationType;
import com.blued.android.module.location.R;
import com.blued.android.module.location.listener.OnMapReadyListener;
import com.blued.android.module.location.listener.OnPositionMovedListener;
import com.blued.android.module.location.utils.AppUtils;
import com.blued.android.module.location.utils.LocationCacheUtils;
import com.blued.android.module.location.utils.MapGaoDeUtils;
import com.blued.android.module.location.utils.MapGoogleUtils;
import com.blued.android.module.location.utils.UiUtils;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import java.io.File;
import java.util.List;

public class MapViews extends FrameLayout {
  private MapView a;
  
  private AMap b;
  
  private ImageView c;
  
  private ImageView d;
  
  private List<Marker> e;
  
  private MapView f;
  
  private GoogleMap g;
  
  private OnPositionMovedListener h;
  
  private OnMapReadyListener i;
  
  private boolean j = false;
  
  public MapViews(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public MapViews(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MapViews(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(double paramDouble1, double paramDouble2) {
    if (this.f != null) {
      MapGoogleUtils.a(this.g, paramDouble1, paramDouble2);
      return;
    } 
    if (this.a != null)
      MapGaoDeUtils.a(this.b, paramDouble1, paramDouble2); 
  }
  
  private void a(Context paramContext) {
    if (AppUtils.c() >= 23 && ActivityCompat.checkSelfPermission(paramContext, "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission(paramContext, "android.permission.ACCESS_COARSE_LOCATION") != 0)
      return; 
    if (!LocationCacheUtils.h() && b(paramContext) != null) {
      try {
        (new File(paramContext.getFilesDir(), "ZoomTables.data")).delete();
        (new File(paramContext.getFilesDir(), "SavedClientParameters.data.cs")).delete();
        File file = paramContext.getFilesDir();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DATA_ServerControlledParametersManager.data.");
        stringBuilder.append(paramContext.getPackageName());
        (new File(file, stringBuilder.toString())).delete();
        file = paramContext.getFilesDir();
        stringBuilder = new StringBuilder();
        stringBuilder.append("DATA_ServerControlledParametersManager.data.v1.");
        stringBuilder.append(paramContext.getPackageName());
        (new File(file, stringBuilder.toString())).delete();
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      LocationCacheUtils.a(true);
    } 
    FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(-2, -2);
    layoutParams1.gravity = 17;
    layoutParams1.bottomMargin = UiUtils.a(paramContext, 15.0F);
    this.c = new ImageView(paramContext);
    this.c.setImageResource(R.drawable.location_mark);
    this.c.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.c.setVisibility(8);
    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
    layoutParams2.gravity = 80;
    layoutParams2.bottomMargin = UiUtils.a(paramContext, 30.0F);
    layoutParams2.leftMargin = UiUtils.a(paramContext, 10.0F);
    layoutParams1.gravity = 17;
    this.d = new ImageView(paramContext);
    this.d.setImageResource(R.drawable.icon_map_location);
    this.d.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    this.d.setId(R.id.my_location);
    this.d.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.a();
          }
        });
    this.d.setVisibility(8);
  }
  
  private void a(Context paramContext, Bundle paramBundle, LifecycleOwner paramLifecycleOwner) {
    this.f = new MapView(paramContext);
    if (paramBundle != null) {
      Bundle bundle = paramBundle.getBundle("MapViewBundleKey");
    } else {
      paramContext = null;
    } 
    this.f.onCreate((Bundle)paramContext);
    removeAllViews();
    addView((View)this.f);
    addView((View)this.c);
    addView((View)this.d);
    this.f.getMapAsync(new OnMapReadyCallback(this, paramLifecycleOwner) {
          public void onMapReady(GoogleMap param1GoogleMap) {
            MapViews.a(this.b, param1GoogleMap);
            if (MapViews.a(this.b) != null)
              MapGoogleUtils.a(MapViews.a(this.b), new GoogleMap.OnCameraIdleListener(this) {
                    public void onCameraIdle() {
                      CameraPosition cameraPosition = MapViews.a(this.a.b).getCameraPosition();
                      if (cameraPosition != null) {
                        LocationCacheUtils.c(cameraPosition.target.longitude);
                        LocationCacheUtils.d(cameraPosition.target.latitude);
                        if (MapViews.b(this.a.b) != null && !MapViews.c(this.a.b)) {
                          MapViews.a(this.a.b, true);
                          MapViews.b(this.a.b).a();
                        } 
                        if (MapViews.d(this.a.b) != null)
                          MapViews.d(this.a.b).onComplete(cameraPosition.target.latitude, cameraPosition.target.longitude); 
                      } 
                    }
                  }MapViews.e(this.b), this.a); 
          }
        });
  }
  
  private File b(Context paramContext) {
    return ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) ? paramContext.getExternalCacheDir() : paramContext.getCacheDir();
  }
  
  private void b(Context paramContext, Bundle paramBundle, LifecycleOwner paramLifecycleOwner) {
    this.a = new MapView(paramContext);
    this.a.onCreate(paramBundle);
    removeAllViews();
    addView((View)this.a);
    addView((View)this.c);
    addView((View)this.d);
    this.b = this.a.getMap();
    this.b.setMapType(1);
    MapGaoDeUtils.a(this.b, new AMap.OnCameraChangeListener(this) {
          public void onCameraChange(CameraPosition param1CameraPosition) {}
          
          public void onCameraChangeFinish(CameraPosition param1CameraPosition) {
            if (param1CameraPosition != null && param1CameraPosition.target != null) {
              LocationCacheUtils.c(param1CameraPosition.target.longitude);
              LocationCacheUtils.d(param1CameraPosition.target.latitude);
              if (MapViews.b(this.a) != null && !MapViews.c(this.a)) {
                MapViews.a(this.a, true);
                MapViews.b(this.a).a();
              } 
              if (MapViews.d(this.a) != null)
                MapViews.d(this.a).onComplete(param1CameraPosition.target.latitude, param1CameraPosition.target.longitude); 
            } 
          }
        }this.e, paramLifecycleOwner);
  }
  
  public void a() {
    if (!LocationService.b().equals("0")) {
      if (LocationService.a().equals("0"))
        return; 
      try {
        a(Double.parseDouble(LocationService.b()), Double.parseDouble(LocationService.a()));
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } 
  }
  
  public void a(Context paramContext, Bundle paramBundle, List<Marker> paramList) {
    a(paramContext, paramBundle, paramList, (LifecycleOwner)null);
  }
  
  public void a(Context paramContext, Bundle paramBundle, List<Marker> paramList, LifecycleOwner paramLifecycleOwner) {
    this.e = paramList;
    if (AppUtils.c() >= 23 && ActivityCompat.checkSelfPermission(paramContext, "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission(paramContext, "android.permission.ACCESS_COARSE_LOCATION") != 0)
      return; 
    LocationType locationType = LocationService.c();
    if (!AppUtils.f())
      locationType = LocationType.b; 
    int i = null.a[locationType.ordinal()];
    if (i != 1 && i != 2) {
      if (i != 3) {
        if (i != 4)
          return; 
        if (LocationService.f()) {
          a(paramContext, paramBundle, paramLifecycleOwner);
          return;
        } 
        b(paramContext, paramBundle, paramLifecycleOwner);
        return;
      } 
      if (LocationService.f()) {
        a(paramContext, paramBundle, paramLifecycleOwner);
        return;
      } 
    } else {
      b(paramContext, paramBundle, paramLifecycleOwner);
    } 
  }
  
  public void a(Bundle paramBundle) {
    if (this.f != null) {
      Bundle bundle2 = paramBundle.getBundle("MapViewBundleKey");
      Bundle bundle1 = bundle2;
      if (bundle2 == null) {
        bundle1 = new Bundle();
        paramBundle.putBundle("MapViewBundleKey", bundle1);
      } 
      this.f.onSaveInstanceState(bundle1);
      return;
    } 
    MapView mapView = this.a;
    if (mapView != null)
      mapView.onSaveInstanceState(paramBundle); 
  }
  
  public void a(String paramString1, String paramString2) {
    try {
      a(Double.parseDouble(paramString1), Double.parseDouble(paramString2));
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void b() {
    ImageView imageView = this.d;
    if (imageView != null)
      imageView.setVisibility(0); 
  }
  
  public void c() {
    MapView mapView1 = this.f;
    if (mapView1 != null) {
      mapView1.onResume();
      return;
    } 
    MapView mapView = this.a;
    if (mapView != null)
      mapView.onResume(); 
  }
  
  public void d() {
    MapView mapView1 = this.f;
    if (mapView1 != null) {
      mapView1.onPause();
      return;
    } 
    MapView mapView = this.a;
    if (mapView != null)
      mapView.onPause(); 
  }
  
  public void e() {
    MapView mapView1 = this.f;
    if (mapView1 != null) {
      mapView1.onDestroy();
      this.f = null;
      return;
    } 
    MapView mapView = this.a;
    if (mapView != null) {
      mapView.onDestroy();
      this.a = null;
    } 
    this.i = null;
    this.h = null;
  }
  
  public float getDistance() {
    return (this.f != null) ? MapGoogleUtils.a() : ((this.a != null) ? MapGaoDeUtils.a() : 0.0F);
  }
  
  public void setMapReadyListener(OnMapReadyListener paramOnMapReadyListener) {
    this.i = paramOnMapReadyListener;
  }
  
  public void setMyLocationButton(int paramInt) {
    ImageView imageView = this.d;
    if (imageView != null)
      imageView.setImageResource(paramInt); 
  }
  
  public void setMyMarkButton(int paramInt) {
    ImageView imageView = this.c;
    if (imageView != null)
      imageView.setImageResource(paramInt); 
  }
  
  public void setPositionMovedListener(OnPositionMovedListener paramOnPositionMovedListener) {
    this.h = paramOnPositionMovedListener;
  }
  
  public void setScrollGesturesEnabled(boolean paramBoolean) {
    if (this.f != null) {
      MapGoogleUtils.b(this.g, paramBoolean);
      return;
    } 
    if (this.a != null)
      MapGaoDeUtils.b(this.b, paramBoolean); 
  }
  
  public void setZoomGesturesEnabled(boolean paramBoolean) {
    if (this.f != null) {
      MapGoogleUtils.a(this.g, paramBoolean);
      return;
    } 
    if (this.a != null)
      MapGaoDeUtils.a(this.b, paramBoolean); 
  }
  
  public static class Marker {
    public double a;
    
    public double b;
    
    public Bitmap c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\location\View\MapViews.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */