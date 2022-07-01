package com.amap.api.maps2d;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.interfaces.IAMap;
import com.amap.api.mapcore2d.cm;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.Circle;
import com.amap.api.maps2d.model.CircleOptions;
import com.amap.api.maps2d.model.GroundOverlay;
import com.amap.api.maps2d.model.GroundOverlayOptions;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.amap.api.maps2d.model.Polygon;
import com.amap.api.maps2d.model.PolygonOptions;
import com.amap.api.maps2d.model.Polyline;
import com.amap.api.maps2d.model.PolylineOptions;
import com.amap.api.maps2d.model.RuntimeRemoteException;
import com.amap.api.maps2d.model.Text;
import com.amap.api.maps2d.model.TextOptions;
import com.amap.api.maps2d.model.TileOverlay;
import com.amap.api.maps2d.model.TileOverlayOptions;
import java.util.List;

public final class AMap {
  public static final String CHINESE = "zh_cn";
  
  public static final String ENGLISH = "en";
  
  public static final int MAP_TYPE_NORMAL = 1;
  
  public static final int MAP_TYPE_SATELLITE = 2;
  
  private final IAMap a;
  
  private UiSettings b;
  
  private Projection c;
  
  protected AMap(IAMap paramIAMap) {
    this.a = paramIAMap;
  }
  
  private IAMap a() {
    return this.a;
  }
  
  public static String getVersion() {
    return "6.0.0";
  }
  
  public final Circle addCircle(CircleOptions paramCircleOptions) {
    try {
      return a().addCircle(paramCircleOptions);
    } finally {
      paramCircleOptions = null;
      cm.a((Throwable)paramCircleOptions, "AMap", "addCircle");
    } 
  }
  
  public final GroundOverlay addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions) {
    try {
      return a().addGroundOverlay(paramGroundOverlayOptions);
    } finally {
      paramGroundOverlayOptions = null;
      cm.a((Throwable)paramGroundOverlayOptions, "AMap", "addGroundOverlay");
    } 
  }
  
  public final Marker addMarker(MarkerOptions paramMarkerOptions) {
    try {
      return a().addMarker(paramMarkerOptions);
    } finally {
      paramMarkerOptions = null;
      cm.a((Throwable)paramMarkerOptions, "AMap", "addMarker");
    } 
  }
  
  public final Polygon addPolygon(PolygonOptions paramPolygonOptions) {
    try {
      return a().addPolygon(paramPolygonOptions);
    } finally {
      paramPolygonOptions = null;
      cm.a((Throwable)paramPolygonOptions, "AMap", "addPolygon");
    } 
  }
  
  public final Polyline addPolyline(PolylineOptions paramPolylineOptions) {
    try {
      return a().addPolyline(paramPolylineOptions);
    } finally {
      paramPolylineOptions = null;
      cm.a((Throwable)paramPolylineOptions, "AMap", "addPolyline");
    } 
  }
  
  public final Text addText(TextOptions paramTextOptions) {
    try {
      return this.a.addText(paramTextOptions);
    } finally {
      paramTextOptions = null;
      cm.a((Throwable)paramTextOptions, "AMap", "addText");
    } 
  }
  
  public final TileOverlay addTileOverlay(TileOverlayOptions paramTileOverlayOptions) {
    try {
      return a().addTileOverlay(paramTileOverlayOptions);
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "AMap", "addtileOverlay");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void animateCamera(CameraUpdate paramCameraUpdate) {
    try {
      return;
    } finally {
      paramCameraUpdate = null;
      cm.a((Throwable)paramCameraUpdate, "AMap", "animateCamera");
    } 
  }
  
  public final void animateCamera(CameraUpdate paramCameraUpdate, long paramLong, CancelableCallback paramCancelableCallback) {
    if (paramLong <= 0L)
      try {
        return;
      } finally {
        paramCameraUpdate = null;
        cm.a((Throwable)paramCameraUpdate, "AMap", "animateCamera");
      }  
    a().animateCameraWithDurationAndCallback(paramCameraUpdate, paramLong, paramCancelableCallback);
  }
  
  public final void animateCamera(CameraUpdate paramCameraUpdate, CancelableCallback paramCancelableCallback) {
    try {
      return;
    } finally {
      paramCameraUpdate = null;
      cm.a((Throwable)paramCameraUpdate, "AMap", "animateCamera");
    } 
  }
  
  public final void clear() {
    try {
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "AMap", "clear");
      throw new RuntimeRemoteException(remoteException);
    } finally {
      Exception exception = null;
      cm.a(exception, "AMap", "clear");
    } 
  }
  
  public final CameraPosition getCameraPosition() {
    try {
      return a().getCameraPosition();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "AMap", "getCameraPosition");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final List<Marker> getMapScreenMarkers() {
    try {
      return this.a.getMapScreenMarkers();
    } finally {
      Exception exception = null;
      cm.a(exception, "AMap", "getMapScreenaMarkers");
    } 
  }
  
  public void getMapScreenShot(OnMapScreenShotListener paramOnMapScreenShotListener) {
    a().getMapScreenShot(paramOnMapScreenShotListener);
    invalidate();
  }
  
  public final int getMapType() {
    try {
      return a().getMapType();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "AMap", "getMapType");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final float getMaxZoomLevel() {
    return a().getMaxZoomLevel();
  }
  
  public final float getMinZoomLevel() {
    return a().getMinZoomLevel();
  }
  
  public final Location getMyLocation() {
    try {
      return a().getMyLocation();
    } finally {
      Exception exception = null;
      cm.a(exception, "AMap", "getMyLocation");
    } 
  }
  
  public final Projection getProjection() {
    try {
      return this.c;
    } finally {
      Exception exception = null;
      cm.a(exception, "AMap", "getProjection");
    } 
  }
  
  public float getScalePerPixel() {
    return a().getScalePerPixel();
  }
  
  public final UiSettings getUiSettings() {
    try {
      return this.b;
    } finally {
      Exception exception = null;
      cm.a(exception, "AMap", "getUiSettings");
    } 
  }
  
  public void invalidate() {
    postInvalidate();
  }
  
  public final boolean isMyLocationEnabled() {
    try {
      return a().isMyLocationEnabled();
    } finally {
      Exception exception = null;
      cm.a(exception, "AMap", "isMyLocationEnabled");
    } 
  }
  
  public final boolean isTrafficEnabled() {
    try {
      return a().isTrafficEnabled();
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "AMap", "isTrafficEnable");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void moveCamera(CameraUpdate paramCameraUpdate) {
    try {
      return;
    } finally {
      paramCameraUpdate = null;
      cm.a((Throwable)paramCameraUpdate, "AMap", "moveCamera");
    } 
  }
  
  public void postInvalidate() {
    a().AMapInvalidate();
  }
  
  public void removecache() {
    try {
      return;
    } finally {
      Exception exception = null;
      cm.a(exception, "AMap", "removecache");
    } 
  }
  
  public void removecache(OnCacheRemoveListener paramOnCacheRemoveListener) {
    try {
      return;
    } finally {
      paramOnCacheRemoveListener = null;
      cm.a((Throwable)paramOnCacheRemoveListener, "AMap", "removecache");
    } 
  }
  
  public final void setInfoWindowAdapter(InfoWindowAdapter paramInfoWindowAdapter) {
    try {
      return;
    } finally {
      paramInfoWindowAdapter = null;
      cm.a((Throwable)paramInfoWindowAdapter, "AMap", "setInfoWindowAdapter");
    } 
  }
  
  public final void setLocationSource(LocationSource paramLocationSource) {
    try {
      return;
    } finally {
      paramLocationSource = null;
      cm.a((Throwable)paramLocationSource, "AMap", "setLocationSource");
    } 
  }
  
  public void setMapLanguage(String paramString) {
    try {
      return;
    } finally {
      paramString = null;
      cm.a((Throwable)paramString, "AMap", "setMapLanguage");
    } 
  }
  
  public final void setMapType(int paramInt) {
    try {
      a().setMapType(paramInt);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "AMap", "setMapType");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setMyLocationEnabled(boolean paramBoolean) {
    try {
      return;
    } finally {
      Exception exception = null;
      cm.a(exception, "AMap", "setMyLocationEnabled");
    } 
  }
  
  public final void setMyLocationRotateAngle(float paramFloat) {
    try {
      this.a.setMyLocationRotateAngle(paramFloat);
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "AMap", "setMyLocationRoteteAngle");
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public final void setMyLocationStyle(MyLocationStyle paramMyLocationStyle) {
    try {
      return;
    } finally {
      paramMyLocationStyle = null;
      cm.a((Throwable)paramMyLocationStyle, "AMap", "setMyLocationStyle");
    } 
  }
  
  public final void setMyLocationType(int paramInt) {
    try {
      return;
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
  
  public final void setOnCameraChangeListener(OnCameraChangeListener paramOnCameraChangeListener) {
    try {
      return;
    } finally {
      paramOnCameraChangeListener = null;
      cm.a((Throwable)paramOnCameraChangeListener, "AMap", "setOnCameraChangeListener");
    } 
  }
  
  public final void setOnInfoWindowClickListener(OnInfoWindowClickListener paramOnInfoWindowClickListener) {
    try {
      return;
    } finally {
      paramOnInfoWindowClickListener = null;
      cm.a((Throwable)paramOnInfoWindowClickListener, "AMap", "setOnInfoWindowClickListener");
    } 
  }
  
  public final void setOnMapClickListener(OnMapClickListener paramOnMapClickListener) {
    try {
      return;
    } finally {
      paramOnMapClickListener = null;
      cm.a((Throwable)paramOnMapClickListener, "AMap", "setOnMapClickListener");
    } 
  }
  
  public final void setOnMapLoadedListener(OnMapLoadedListener paramOnMapLoadedListener) {
    try {
      return;
    } finally {
      paramOnMapLoadedListener = null;
      cm.a((Throwable)paramOnMapLoadedListener, "AMap", "setOnMapLoadedListener");
    } 
  }
  
  public final void setOnMapLongClickListener(OnMapLongClickListener paramOnMapLongClickListener) {
    try {
      return;
    } finally {
      paramOnMapLongClickListener = null;
      cm.a((Throwable)paramOnMapLongClickListener, "AMap", "setOnMapLongClickListener");
    } 
  }
  
  public final void setOnMapTouchListener(OnMapTouchListener paramOnMapTouchListener) {
    try {
      return;
    } finally {
      paramOnMapTouchListener = null;
      cm.a((Throwable)paramOnMapTouchListener, "AMap", "setOnMapTouchListener");
    } 
  }
  
  public final void setOnMarkerClickListener(OnMarkerClickListener paramOnMarkerClickListener) {
    try {
      return;
    } finally {
      paramOnMarkerClickListener = null;
      cm.a((Throwable)paramOnMarkerClickListener, "AMap", "setOnMarkerClickListener");
    } 
  }
  
  public final void setOnMarkerDragListener(OnMarkerDragListener paramOnMarkerDragListener) {
    try {
      return;
    } finally {
      paramOnMarkerDragListener = null;
      cm.a((Throwable)paramOnMarkerDragListener, "AMap", "setOnMarkerDragListener");
    } 
  }
  
  public final void setOnMyLocationChangeListener(OnMyLocationChangeListener paramOnMyLocationChangeListener) {
    try {
      return;
    } finally {
      paramOnMyLocationChangeListener = null;
      cm.a((Throwable)paramOnMyLocationChangeListener, "AMap", "setOnMyLocaitonChangeListener");
    } 
  }
  
  public void setTrafficEnabled(boolean paramBoolean) {
    try {
      return;
    } finally {
      Exception exception = null;
      cm.a(exception, "AMap", "setTradficEnabled");
    } 
  }
  
  public final void stopAnimation() {
    try {
      return;
    } finally {
      Exception exception = null;
      cm.a(exception, "AMap", "stopAnimation");
    } 
  }
  
  public static interface CancelableCallback {
    void onCancel();
    
    void onFinish();
  }
  
  public static interface InfoWindowAdapter {
    View getInfoContents(Marker param1Marker);
    
    View getInfoWindow(Marker param1Marker);
  }
  
  public static interface OnCacheRemoveListener {
    void onRemoveCacheFinish(boolean param1Boolean);
  }
  
  public static interface OnCameraChangeListener {
    void onCameraChange(CameraPosition param1CameraPosition);
    
    void onCameraChangeFinish(CameraPosition param1CameraPosition);
  }
  
  public static interface OnInfoWindowClickListener {
    void onInfoWindowClick(Marker param1Marker);
  }
  
  public static interface OnMapClickListener {
    void onMapClick(LatLng param1LatLng);
  }
  
  public static interface OnMapLoadedListener {
    void onMapLoaded();
  }
  
  public static interface OnMapLongClickListener {
    void onMapLongClick(LatLng param1LatLng);
  }
  
  public static interface OnMapScreenShotListener {
    void onMapScreenShot(Bitmap param1Bitmap);
  }
  
  public static interface OnMapTouchListener {
    void onTouch(MotionEvent param1MotionEvent);
  }
  
  public static interface OnMarkerClickListener {
    boolean onMarkerClick(Marker param1Marker);
  }
  
  public static interface OnMarkerDragListener {
    void onMarkerDrag(Marker param1Marker);
    
    void onMarkerDragEnd(Marker param1Marker);
    
    void onMarkerDragStart(Marker param1Marker);
  }
  
  public static interface OnMyLocationChangeListener {
    void onMyLocationChange(Location param1Location);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\AMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */