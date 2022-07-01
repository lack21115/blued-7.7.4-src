package com.amap.api.mapcore2d;

import android.graphics.Point;
import com.amap.api.interfaces.MapCameraMessage;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;

public class m extends MapCameraMessage {
  private float a;
  
  private float b;
  
  private ae c;
  
  public static MapCameraMessage a(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    m m1 = a();
    m1.nowType = MapCameraMessage.Type.j;
    m1.bounds = paramLatLngBounds;
    m1.paddingLeft = paramInt1;
    m1.paddingRight = paramInt2;
    m1.paddingTop = paramInt3;
    m1.paddingBottom = paramInt4;
    return m1;
  }
  
  public static m a() {
    return new m();
  }
  
  public static m a(float paramFloat) {
    m m1 = a();
    m1.nowType = MapCameraMessage.Type.f;
    m1.zoom = paramFloat;
    return m1;
  }
  
  public static m a(float paramFloat1, float paramFloat2) {
    m m1 = a();
    m1.nowType = MapCameraMessage.Type.h;
    m1.xPixel = paramFloat1;
    m1.yPixel = paramFloat2;
    return m1;
  }
  
  public static m a(float paramFloat, Point paramPoint) {
    m m1 = a();
    m1.nowType = MapCameraMessage.Type.g;
    m1.amount = paramFloat;
    m1.focus = paramPoint;
    return m1;
  }
  
  static m a(ae paramae, float paramFloat1, float paramFloat2, float paramFloat3) {
    m m1 = a();
    m1.nowType = MapCameraMessage.Type.l;
    m1.c = paramae;
    m1.zoom = paramFloat1;
    m1.b = paramFloat2;
    m1.a = paramFloat3;
    return m1;
  }
  
  public static m a(CameraPosition paramCameraPosition) {
    m m1 = a();
    m1.nowType = MapCameraMessage.Type.i;
    m1.cameraPosition = paramCameraPosition;
    return m1;
  }
  
  public static m a(LatLng paramLatLng) {
    m m1 = a();
    m1.nowType = MapCameraMessage.Type.c;
    m1.cameraPosition = new CameraPosition(paramLatLng, 0.0F, 0.0F, 0.0F);
    return m1;
  }
  
  public static m a(LatLng paramLatLng, float paramFloat) {
    return a(CameraPosition.builder().target(paramLatLng).zoom(paramFloat).build());
  }
  
  public static m a(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3) {
    return a(CameraPosition.builder().target(paramLatLng).zoom(paramFloat1).bearing(paramFloat2).tilt(paramFloat3).build());
  }
  
  public static m a(LatLngBounds paramLatLngBounds, int paramInt) {
    m m1 = a();
    m1.nowType = MapCameraMessage.Type.j;
    m1.bounds = paramLatLngBounds;
    m1.paddingLeft = paramInt;
    m1.paddingRight = paramInt;
    m1.paddingTop = paramInt;
    m1.paddingBottom = paramInt;
    return m1;
  }
  
  public static m a(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3) {
    m m1 = a();
    m1.nowType = MapCameraMessage.Type.k;
    m1.bounds = paramLatLngBounds;
    m1.paddingLeft = paramInt3;
    m1.paddingRight = paramInt3;
    m1.paddingTop = paramInt3;
    m1.paddingBottom = paramInt3;
    m1.width = paramInt1;
    m1.height = paramInt2;
    return m1;
  }
  
  public static m b() {
    m m1 = a();
    m1.nowType = MapCameraMessage.Type.b;
    return m1;
  }
  
  public static m b(float paramFloat) {
    return a(paramFloat, (Point)null);
  }
  
  public static m b(LatLng paramLatLng) {
    return a(CameraPosition.builder().target(paramLatLng).build());
  }
  
  public static m c() {
    m m1 = a();
    m1.nowType = MapCameraMessage.Type.e;
    return m1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */