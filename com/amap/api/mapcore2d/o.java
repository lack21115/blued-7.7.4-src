package com.amap.api.mapcore2d;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.RemoteException;
import com.amap.api.interfaces.IOverlay;
import com.amap.api.maps2d.AMapUtils;
import com.amap.api.maps2d.model.LatLng;

class o implements z {
  private LatLng a = null;
  
  private double b = 0.0D;
  
  private float c = 10.0F;
  
  private int d = -16777216;
  
  private int e = 0;
  
  private float f = 0.0F;
  
  private boolean g = true;
  
  private String h;
  
  private y i;
  
  public o(y paramy) {
    this.i = paramy;
    try {
      this.h = getId();
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "CircleDelegateImp", "CircleDelegateIme");
      return;
    } 
  }
  
  public void a(Canvas paramCanvas) throws RemoteException {
    if (getCenter() != null && this.b > 0.0D) {
      if (!isVisible())
        return; 
      try {
        float f = (this.i.a()).b.a((float)getRadius());
        w w = new w((int)(this.a.latitude * 1000000.0D), (int)(this.a.longitude * 1000000.0D));
        Point point = new Point();
        this.i.d().a(w, point);
        Paint paint = new Paint();
        paint.setColor(getFillColor());
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paramCanvas.drawCircle(point.x, point.y, f, paint);
        paint.setColor(getStrokeColor());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(getStrokeWidth());
        return;
      } finally {
        paramCanvas = null;
      } 
    } 
  }
  
  public boolean a() {
    return true;
  }
  
  public boolean contains(LatLng paramLatLng) throws RemoteException {
    return (this.b >= AMapUtils.calculateLineDistance(this.a, paramLatLng));
  }
  
  public void destroy() {
    this.a = null;
  }
  
  public boolean equalsRemote(IOverlay paramIOverlay) throws RemoteException {
    return (equals(paramIOverlay) || paramIOverlay.getId().equals(getId()));
  }
  
  public LatLng getCenter() throws RemoteException {
    return this.a;
  }
  
  public int getFillColor() throws RemoteException {
    return this.e;
  }
  
  public String getId() throws RemoteException {
    if (this.h == null)
      this.h = v.a("Circle"); 
    return this.h;
  }
  
  public double getRadius() throws RemoteException {
    return this.b;
  }
  
  public int getStrokeColor() throws RemoteException {
    return this.d;
  }
  
  public float getStrokeWidth() throws RemoteException {
    return this.c;
  }
  
  public float getZIndex() throws RemoteException {
    return this.f;
  }
  
  public int hashCodeRemote() throws RemoteException {
    return 0;
  }
  
  public boolean isVisible() throws RemoteException {
    return this.g;
  }
  
  public void remove() throws RemoteException {
    this.i.removeGLOverlay(getId());
    this.i.postInvalidate();
  }
  
  public void setCenter(LatLng paramLatLng) throws RemoteException {
    this.a = paramLatLng;
  }
  
  public void setFillColor(int paramInt) throws RemoteException {
    this.e = paramInt;
  }
  
  public void setRadius(double paramDouble) throws RemoteException {
    this.b = paramDouble;
  }
  
  public void setStrokeColor(int paramInt) throws RemoteException {
    this.d = paramInt;
  }
  
  public void setStrokeWidth(float paramFloat) throws RemoteException {
    this.c = paramFloat;
  }
  
  public void setVisible(boolean paramBoolean) throws RemoteException {
    this.g = paramBoolean;
    this.i.postInvalidate();
  }
  
  public void setZIndex(float paramFloat) throws RemoteException {
    this.f = paramFloat;
    this.i.postInvalidate();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */