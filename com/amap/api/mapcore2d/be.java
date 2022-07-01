package com.amap.api.mapcore2d;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.RemoteException;
import com.amap.api.interfaces.IOverlay;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class be implements af {
  private y a;
  
  private float b = 0.0F;
  
  private boolean c = true;
  
  private String d;
  
  private float e;
  
  private int f;
  
  private int g;
  
  private List<LatLng> h;
  
  private List<ae> i = new ArrayList<ae>();
  
  private LatLngBounds j = null;
  
  public be(y paramy) {
    this.a = paramy;
    try {
      this.d = getId();
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "PolygonDelegateImp", "PolygonDelegateImp");
      return;
    } 
  }
  
  public void a(Canvas paramCanvas) throws RemoteException {
    List<ae> list = this.i;
    if (list != null) {
      if (list.size() == 0)
        return; 
      Path path = new Path();
      w w = new w(((ae)this.i.get(0)).b, ((ae)this.i.get(0)).a);
      Point point2 = new Point();
      Point point1 = this.a.d().a(w, point2);
      path.moveTo(point1.x, point1.y);
      for (int i = 1; i < this.i.size(); i++) {
        w w1 = new w(((ae)this.i.get(i)).b, ((ae)this.i.get(i)).a);
        point2 = new Point();
        Point point = this.a.d().a(w1, point2);
        path.lineTo(point.x, point.y);
      } 
      Paint paint = new Paint();
      paint.setColor(getFillColor());
      paint.setAntiAlias(true);
      path.close();
      paint.setStyle(Paint.Style.FILL);
      paramCanvas.drawPath(path, paint);
      paint.setStyle(Paint.Style.STROKE);
      paint.setColor(getStrokeColor());
      paint.setStrokeWidth(getStrokeWidth());
      paramCanvas.drawPath(path, paint);
    } 
  }
  
  void a(List<LatLng> paramList) throws RemoteException {
    LatLngBounds.Builder builder = LatLngBounds.builder();
    this.i.clear();
    if (paramList != null) {
      List<ae> list = null;
      Iterator<LatLng> iterator = paramList.iterator();
      paramList = (List)list;
      while (iterator.hasNext()) {
        LatLng latLng2 = iterator.next();
        if (latLng2 == null || latLng2.equals(paramList))
          continue; 
        ae ae = new ae();
        this.a.a(latLng2.latitude, latLng2.longitude, ae);
        this.i.add(ae);
        builder.include(latLng2);
        LatLng latLng1 = latLng2;
      } 
      int i = this.i.size();
      if (i > 1) {
        ae ae1 = this.i.get(0);
        list = this.i;
        ae ae2 = list.get(--i);
        if (ae1.a == ae2.a && ae1.b == ae2.b)
          this.i.remove(i); 
      } 
    } 
    this.j = builder.build();
  }
  
  public boolean a() {
    LatLngBounds latLngBounds = this.j;
    boolean bool = false;
    if (latLngBounds == null)
      return false; 
    latLngBounds = this.a.getMapBounds();
    if (latLngBounds == null)
      return true; 
    if (this.j.contains(latLngBounds) || this.j.intersects(latLngBounds))
      bool = true; 
    return bool;
  }
  
  List<LatLng> b() throws RemoteException {
    if (this.i != null) {
      ArrayList<LatLng> arrayList = new ArrayList();
      for (ae ae : this.i) {
        if (ae != null) {
          s s = new s();
          this.a.b(ae.a, ae.b, s);
          arrayList.add(new LatLng(s.b, s.a));
        } 
      } 
      return arrayList;
    } 
    return null;
  }
  
  public boolean contains(LatLng paramLatLng) throws RemoteException {
    return cm.a(paramLatLng, getPoints());
  }
  
  public void destroy() {}
  
  public boolean equalsRemote(IOverlay paramIOverlay) throws RemoteException {
    return (equals(paramIOverlay) || paramIOverlay.getId().equals(getId()));
  }
  
  public int getFillColor() throws RemoteException {
    return this.f;
  }
  
  public String getId() throws RemoteException {
    if (this.d == null)
      this.d = v.a("Polygon"); 
    return this.d;
  }
  
  public List<LatLng> getPoints() throws RemoteException {
    return b();
  }
  
  public int getStrokeColor() throws RemoteException {
    return this.g;
  }
  
  public float getStrokeWidth() throws RemoteException {
    return this.e;
  }
  
  public float getZIndex() throws RemoteException {
    return this.b;
  }
  
  public int hashCodeRemote() throws RemoteException {
    return hashCode();
  }
  
  public boolean isVisible() throws RemoteException {
    return this.c;
  }
  
  public void remove() throws RemoteException {
    this.a.removeGLOverlay(getId());
  }
  
  public void setFillColor(int paramInt) throws RemoteException {
    this.f = paramInt;
  }
  
  public void setPoints(List<LatLng> paramList) throws RemoteException {
    this.h = paramList;
    a(paramList);
  }
  
  public void setStrokeColor(int paramInt) throws RemoteException {
    this.g = paramInt;
  }
  
  public void setStrokeWidth(float paramFloat) throws RemoteException {
    this.e = paramFloat;
  }
  
  public void setVisible(boolean paramBoolean) throws RemoteException {
    this.c = paramBoolean;
  }
  
  public void setZIndex(float paramFloat) throws RemoteException {
    this.b = paramFloat;
    this.a.postInvalidate();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */