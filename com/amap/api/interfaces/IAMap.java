package com.amap.api.interfaces;

import android.location.Location;
import android.os.Handler;
import android.os.RemoteException;
import android.view.View;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.Projection;
import com.amap.api.maps2d.UiSettings;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.Circle;
import com.amap.api.maps2d.model.CircleOptions;
import com.amap.api.maps2d.model.GroundOverlay;
import com.amap.api.maps2d.model.GroundOverlayOptions;
import com.amap.api.maps2d.model.LatLngBounds;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.amap.api.maps2d.model.Polygon;
import com.amap.api.maps2d.model.PolygonOptions;
import com.amap.api.maps2d.model.Polyline;
import com.amap.api.maps2d.model.PolylineOptions;
import com.amap.api.maps2d.model.Text;
import com.amap.api.maps2d.model.TextOptions;
import com.amap.api.maps2d.model.TileOverlay;
import com.amap.api.maps2d.model.TileOverlayOptions;
import java.util.List;

public interface IAMap {
  void AMapInvalidate();
  
  Circle addCircle(CircleOptions paramCircleOptions) throws RemoteException;
  
  GroundOverlay addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions) throws RemoteException;
  
  Marker addMarker(MarkerOptions paramMarkerOptions) throws RemoteException;
  
  Polygon addPolygon(PolygonOptions paramPolygonOptions) throws RemoteException;
  
  Polyline addPolyline(PolylineOptions paramPolylineOptions) throws RemoteException;
  
  Text addText(TextOptions paramTextOptions) throws RemoteException;
  
  TileOverlay addTileOverlay(TileOverlayOptions paramTileOverlayOptions) throws RemoteException;
  
  void animateCamera(CameraUpdate paramCameraUpdate) throws RemoteException;
  
  void animateCameraWithCallback(CameraUpdate paramCameraUpdate, AMap.CancelableCallback paramCancelableCallback) throws RemoteException;
  
  void animateCameraWithDurationAndCallback(CameraUpdate paramCameraUpdate, long paramLong, AMap.CancelableCallback paramCancelableCallback) throws RemoteException;
  
  void clear() throws RemoteException;
  
  void destroy();
  
  Projection getAMapProjection() throws RemoteException;
  
  UiSettings getAMapUiSettings() throws RemoteException;
  
  CameraPosition getCameraPosition() throws RemoteException;
  
  Handler getMainHandler();
  
  LatLngBounds getMapBounds();
  
  int getMapHeight();
  
  List<Marker> getMapScreenMarkers() throws RemoteException;
  
  void getMapScreenShot(AMap.OnMapScreenShotListener paramOnMapScreenShotListener);
  
  int getMapType() throws RemoteException;
  
  int getMapWidth();
  
  float getMaxZoomLevel();
  
  float getMinZoomLevel();
  
  Location getMyLocation() throws RemoteException;
  
  float getScalePerPixel();
  
  View getView() throws RemoteException;
  
  float getZoomLevel();
  
  boolean isMyLocationEnabled() throws RemoteException;
  
  boolean isTrafficEnabled() throws RemoteException;
  
  void moveCamera(CameraUpdate paramCameraUpdate) throws RemoteException;
  
  void onPause();
  
  void onResume();
  
  boolean removeGLOverlay(String paramString) throws RemoteException;
  
  void removecache() throws RemoteException;
  
  void removecache(AMap.OnCacheRemoveListener paramOnCacheRemoveListener) throws RemoteException;
  
  void setInfoWindowAdapter(AMap.InfoWindowAdapter paramInfoWindowAdapter) throws RemoteException;
  
  void setLocationSource(LocationSource paramLocationSource) throws RemoteException;
  
  void setLogoPosition(int paramInt);
  
  void setMapLanguage(String paramString) throws RemoteException;
  
  void setMapType(int paramInt) throws RemoteException;
  
  void setMyLocationEnabled(boolean paramBoolean) throws RemoteException;
  
  void setMyLocationRotateAngle(float paramFloat) throws RemoteException;
  
  void setMyLocationStyle(MyLocationStyle paramMyLocationStyle) throws RemoteException;
  
  void setMyLocationType(int paramInt);
  
  void setOnCameraChangeListener(AMap.OnCameraChangeListener paramOnCameraChangeListener) throws RemoteException;
  
  void setOnInfoWindowClickListener(AMap.OnInfoWindowClickListener paramOnInfoWindowClickListener) throws RemoteException;
  
  void setOnMapClickListener(AMap.OnMapClickListener paramOnMapClickListener) throws RemoteException;
  
  void setOnMapLongClickListener(AMap.OnMapLongClickListener paramOnMapLongClickListener) throws RemoteException;
  
  void setOnMapTouchListener(AMap.OnMapTouchListener paramOnMapTouchListener) throws RemoteException;
  
  void setOnMaploadedListener(AMap.OnMapLoadedListener paramOnMapLoadedListener) throws RemoteException;
  
  void setOnMarkerClickListener(AMap.OnMarkerClickListener paramOnMarkerClickListener) throws RemoteException;
  
  void setOnMarkerDragListener(AMap.OnMarkerDragListener paramOnMarkerDragListener) throws RemoteException;
  
  void setOnMyLocationChangeListener(AMap.OnMyLocationChangeListener paramOnMyLocationChangeListener) throws RemoteException;
  
  void setTrafficEnabled(boolean paramBoolean) throws RemoteException;
  
  void setZOrderOnTop(boolean paramBoolean) throws RemoteException;
  
  void setZoomPosition(int paramInt);
  
  void showCompassEnabled(boolean paramBoolean);
  
  void showMyLocationButtonEnabled(boolean paramBoolean);
  
  void showMyLocationOverlay(Location paramLocation);
  
  void showScaleEnabled(boolean paramBoolean);
  
  void showZoomControlsEnabled(boolean paramBoolean);
  
  void stopAnimation() throws RemoteException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\interfaces\IAMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */