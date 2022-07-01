package com.amap.api.mapcore2d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.interfaces.IOverlay;
import com.amap.api.maps2d.model.BitmapDescriptor;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;

class x implements aa {
  private final double a = 0.01745329251994329D;
  
  private final double b = 6371000.79D;
  
  private y c;
  
  private BitmapDescriptor d;
  
  private LatLng e;
  
  private float f;
  
  private float g;
  
  private LatLngBounds h;
  
  private float i;
  
  private float j;
  
  private boolean k = true;
  
  private float l = 0.0F;
  
  private float m = 0.5F;
  
  private float n = 0.5F;
  
  private String o;
  
  private Bitmap p;
  
  x(y paramy) {
    this.c = paramy;
    try {
      this.o = getId();
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "GroundOverlayDelegateImp", "GroundOverlayDelegateImp");
      return;
    } 
  }
  
  private w a(LatLng paramLatLng) {
    return (paramLatLng == null) ? null : new w((int)(paramLatLng.latitude * 1000000.0D), (int)(paramLatLng.longitude * 1000000.0D));
  }
  
  private void c() {
    double d1 = this.f / Math.cos(this.e.latitude * 0.01745329251994329D) * 6371000.79D * 0.01745329251994329D;
    double d2 = this.g / 111194.94043265979D;
    try {
      return;
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
  
  private void d() {
    LatLng latLng1 = this.h.southwest;
    LatLng latLng2 = this.h.northeast;
    this.e = new LatLng(latLng1.latitude + (1.0F - this.n) * (latLng2.latitude - latLng1.latitude), latLng1.longitude + this.m * (latLng2.longitude - latLng1.longitude));
    this.f = (float)(Math.cos(this.e.latitude * 0.01745329251994329D) * 6371000.79D * (latLng2.longitude - latLng1.longitude) * 0.01745329251994329D);
    this.g = (float)((latLng2.latitude - latLng1.latitude) * 6371000.79D * 0.01745329251994329D);
  }
  
  public void a(Canvas paramCanvas) throws RemoteException {
    if (this.k && (this.e != null || this.h != null)) {
      if (this.d == null)
        return; 
      b();
      if (this.f == 0.0F && this.g == 0.0F)
        return; 
      this.p = this.d.getBitmap();
      Bitmap bitmap = this.p;
      if (bitmap != null && !bitmap.isRecycled()) {
        LatLng latLng1 = this.h.southwest;
        LatLng latLng3 = this.h.northeast;
        LatLng latLng2 = this.e;
        w w1 = a(latLng1);
        w w2 = a(latLng3);
        w w3 = a(latLng2);
        Point point2 = new Point();
        Point point3 = new Point();
        Point point1 = new Point();
        this.c.d().a(w1, point2);
        this.c.d().a(w2, point3);
        this.c.d().a(w3, point1);
        Paint paint = new Paint();
        RectF rectF = new RectF(point2.x, point3.y, point3.x, point2.y);
        paint.setAlpha((int)(255.0F - this.l * 255.0F));
        paint.setFilterBitmap(true);
        paramCanvas.save();
        paramCanvas.rotate(this.i, point1.x, point1.y);
        paramCanvas.drawBitmap(this.p, null, rectF, paint);
        paramCanvas.restore();
      } 
    } 
  }
  
  public boolean a() {
    LatLngBounds latLngBounds = this.h;
    boolean bool = false;
    if (latLngBounds == null)
      return false; 
    latLngBounds = this.c.getMapBounds();
    if (latLngBounds == null)
      return true; 
    if (latLngBounds.contains(this.h) || this.h.intersects(latLngBounds))
      bool = true; 
    return bool;
  }
  
  public void b() throws RemoteException {
    if (this.e == null) {
      d();
      return;
    } 
    if (this.h == null)
      c(); 
  }
  
  public void destroy() {
    try {
      remove();
      if (this.d != null) {
        Bitmap bitmap = this.d.getBitmap();
        if (bitmap != null) {
          bitmap.recycle();
          this.d = null;
        } 
      } 
      this.e = null;
      this.h = null;
      return;
    } catch (Exception exception) {
      cm.a(exception, "GroundOverlayDelegateImp", "destroy");
      Log.d("destroy erro", "GroundOverlayDelegateImp destroy");
      return;
    } 
  }
  
  public boolean equalsRemote(IOverlay paramIOverlay) throws RemoteException {
    return (equals(paramIOverlay) || paramIOverlay.getId().equals(getId()));
  }
  
  public float getBearing() throws RemoteException {
    return this.i;
  }
  
  public LatLngBounds getBounds() throws RemoteException {
    return this.h;
  }
  
  public float getHeight() throws RemoteException {
    return this.g;
  }
  
  public String getId() throws RemoteException {
    if (this.o == null)
      this.o = v.a("GroundOverlay"); 
    return this.o;
  }
  
  public LatLng getPosition() throws RemoteException {
    return this.e;
  }
  
  public float getTransparency() throws RemoteException {
    return this.l;
  }
  
  public float getWidth() throws RemoteException {
    return this.f;
  }
  
  public float getZIndex() throws RemoteException {
    return this.j;
  }
  
  public int hashCodeRemote() throws RemoteException {
    return hashCode();
  }
  
  public boolean isVisible() throws RemoteException {
    return this.k;
  }
  
  public void remove() throws RemoteException {
    this.c.removeGLOverlay(getId());
  }
  
  public void setAnchor(float paramFloat1, float paramFloat2) throws RemoteException {
    this.m = paramFloat1;
    this.n = paramFloat2;
  }
  
  public void setBearing(float paramFloat) throws RemoteException {
    paramFloat = (-paramFloat % 360.0F + 360.0F) % 360.0F;
    if (Double.doubleToLongBits(this.i) != Double.doubleToLongBits(paramFloat)) {
      this.i = paramFloat;
      return;
    } 
    this.i = paramFloat;
  }
  
  public void setDimensions(float paramFloat) throws RemoteException {
    if (paramFloat <= 0.0F)
      Log.w("GroundOverlayDelegateImp", "Width must be non-negative"); 
    if (this.f != paramFloat) {
      this.f = paramFloat;
      this.g = paramFloat;
      return;
    } 
    this.f = paramFloat;
    this.g = paramFloat;
  }
  
  public void setDimensions(float paramFloat1, float paramFloat2) throws RemoteException {
    if (paramFloat1 <= 0.0F || paramFloat2 <= 0.0F)
      Log.w("GroundOverlayDelegateImp", "Width and Height must be non-negative"); 
    if (this.f != paramFloat1 && this.g != paramFloat2) {
      this.f = paramFloat1;
      this.g = paramFloat2;
      return;
    } 
    this.f = paramFloat1;
    this.g = paramFloat2;
  }
  
  public void setImage(BitmapDescriptor paramBitmapDescriptor) throws RemoteException {
    this.d = paramBitmapDescriptor;
  }
  
  public void setPosition(LatLng paramLatLng) throws RemoteException {
    LatLng latLng = this.e;
    if (latLng != null && !latLng.equals(paramLatLng)) {
      this.e = paramLatLng;
      c();
      return;
    } 
    this.e = paramLatLng;
  }
  
  public void setPositionFromBounds(LatLngBounds paramLatLngBounds) throws RemoteException {
    LatLngBounds latLngBounds = this.h;
    if (latLngBounds != null && !latLngBounds.equals(paramLatLngBounds)) {
      this.h = paramLatLngBounds;
      d();
      return;
    } 
    this.h = paramLatLngBounds;
  }
  
  public void setTransparency(float paramFloat) throws RemoteException {
    if (paramFloat < 0.0F)
      Log.w("GroundOverlayDelegateImp", "Transparency must be in the range [0..1]"); 
    this.l = paramFloat;
  }
  
  public void setVisible(boolean paramBoolean) throws RemoteException {
    this.k = paramBoolean;
    this.c.postInvalidate();
  }
  
  public void setZIndex(float paramFloat) throws RemoteException {
    this.j = paramFloat;
    this.c.postInvalidate();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */