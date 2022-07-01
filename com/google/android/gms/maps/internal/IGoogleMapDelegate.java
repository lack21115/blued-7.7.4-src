package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.maps.zzac;
import com.google.android.gms.internal.maps.zzh;
import com.google.android.gms.internal.maps.zzk;
import com.google.android.gms.internal.maps.zzn;
import com.google.android.gms.internal.maps.zzt;
import com.google.android.gms.internal.maps.zzw;
import com.google.android.gms.internal.maps.zzz;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;

public interface IGoogleMapDelegate extends IInterface {
  zzh addCircle(CircleOptions paramCircleOptions) throws RemoteException;
  
  zzk addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions) throws RemoteException;
  
  zzt addMarker(MarkerOptions paramMarkerOptions) throws RemoteException;
  
  zzw addPolygon(PolygonOptions paramPolygonOptions) throws RemoteException;
  
  zzz addPolyline(PolylineOptions paramPolylineOptions) throws RemoteException;
  
  zzac addTileOverlay(TileOverlayOptions paramTileOverlayOptions) throws RemoteException;
  
  void animateCamera(IObjectWrapper paramIObjectWrapper) throws RemoteException;
  
  void animateCameraWithCallback(IObjectWrapper paramIObjectWrapper, zzc paramzzc) throws RemoteException;
  
  void animateCameraWithDurationAndCallback(IObjectWrapper paramIObjectWrapper, int paramInt, zzc paramzzc) throws RemoteException;
  
  void clear() throws RemoteException;
  
  CameraPosition getCameraPosition() throws RemoteException;
  
  zzn getFocusedBuilding() throws RemoteException;
  
  void getMapAsync(zzap paramzzap) throws RemoteException;
  
  int getMapType() throws RemoteException;
  
  float getMaxZoomLevel() throws RemoteException;
  
  float getMinZoomLevel() throws RemoteException;
  
  Location getMyLocation() throws RemoteException;
  
  IProjectionDelegate getProjection() throws RemoteException;
  
  IUiSettingsDelegate getUiSettings() throws RemoteException;
  
  boolean isBuildingsEnabled() throws RemoteException;
  
  boolean isIndoorEnabled() throws RemoteException;
  
  boolean isMyLocationEnabled() throws RemoteException;
  
  boolean isTrafficEnabled() throws RemoteException;
  
  void moveCamera(IObjectWrapper paramIObjectWrapper) throws RemoteException;
  
  void onCreate(Bundle paramBundle) throws RemoteException;
  
  void onDestroy() throws RemoteException;
  
  void onEnterAmbient(Bundle paramBundle) throws RemoteException;
  
  void onExitAmbient() throws RemoteException;
  
  void onLowMemory() throws RemoteException;
  
  void onPause() throws RemoteException;
  
  void onResume() throws RemoteException;
  
  void onSaveInstanceState(Bundle paramBundle) throws RemoteException;
  
  void onStart() throws RemoteException;
  
  void onStop() throws RemoteException;
  
  void resetMinMaxZoomPreference() throws RemoteException;
  
  void setBuildingsEnabled(boolean paramBoolean) throws RemoteException;
  
  void setContentDescription(String paramString) throws RemoteException;
  
  boolean setIndoorEnabled(boolean paramBoolean) throws RemoteException;
  
  void setInfoWindowAdapter(zzh paramzzh) throws RemoteException;
  
  void setLatLngBoundsForCameraTarget(LatLngBounds paramLatLngBounds) throws RemoteException;
  
  void setLocationSource(ILocationSourceDelegate paramILocationSourceDelegate) throws RemoteException;
  
  boolean setMapStyle(MapStyleOptions paramMapStyleOptions) throws RemoteException;
  
  void setMapType(int paramInt) throws RemoteException;
  
  void setMaxZoomPreference(float paramFloat) throws RemoteException;
  
  void setMinZoomPreference(float paramFloat) throws RemoteException;
  
  void setMyLocationEnabled(boolean paramBoolean) throws RemoteException;
  
  void setOnCameraChangeListener(zzl paramzzl) throws RemoteException;
  
  void setOnCameraIdleListener(zzn paramzzn) throws RemoteException;
  
  void setOnCameraMoveCanceledListener(zzp paramzzp) throws RemoteException;
  
  void setOnCameraMoveListener(zzr paramzzr) throws RemoteException;
  
  void setOnCameraMoveStartedListener(zzt paramzzt) throws RemoteException;
  
  void setOnCircleClickListener(zzv paramzzv) throws RemoteException;
  
  void setOnGroundOverlayClickListener(zzx paramzzx) throws RemoteException;
  
  void setOnIndoorStateChangeListener(zzz paramzzz) throws RemoteException;
  
  void setOnInfoWindowClickListener(zzab paramzzab) throws RemoteException;
  
  void setOnInfoWindowCloseListener(zzad paramzzad) throws RemoteException;
  
  void setOnInfoWindowLongClickListener(zzaf paramzzaf) throws RemoteException;
  
  void setOnMapClickListener(zzaj paramzzaj) throws RemoteException;
  
  void setOnMapLoadedCallback(zzal paramzzal) throws RemoteException;
  
  void setOnMapLongClickListener(zzan paramzzan) throws RemoteException;
  
  void setOnMarkerClickListener(zzar paramzzar) throws RemoteException;
  
  void setOnMarkerDragListener(zzat paramzzat) throws RemoteException;
  
  void setOnMyLocationButtonClickListener(zzav paramzzav) throws RemoteException;
  
  void setOnMyLocationChangeListener(zzax paramzzax) throws RemoteException;
  
  void setOnMyLocationClickListener(zzaz paramzzaz) throws RemoteException;
  
  void setOnPoiClickListener(zzbb paramzzbb) throws RemoteException;
  
  void setOnPolygonClickListener(zzbd paramzzbd) throws RemoteException;
  
  void setOnPolylineClickListener(zzbf paramzzbf) throws RemoteException;
  
  void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) throws RemoteException;
  
  void setTrafficEnabled(boolean paramBoolean) throws RemoteException;
  
  void setWatermarkEnabled(boolean paramBoolean) throws RemoteException;
  
  void snapshot(zzbs paramzzbs, IObjectWrapper paramIObjectWrapper) throws RemoteException;
  
  void snapshotForTest(zzbs paramzzbs) throws RemoteException;
  
  void stopAnimation() throws RemoteException;
  
  boolean useViewLifecycleWhenInFragment() throws RemoteException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\internal\IGoogleMapDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */