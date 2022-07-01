package com.amap.api.mapcore2d;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Point;
import android.os.RemoteException;
import com.amap.api.interfaces.IOverlay;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;

class bf implements ag {
  private y a;
  
  private float b = 10.0F;
  
  private int c = -16777216;
  
  private float d = 0.0F;
  
  private boolean e = true;
  
  private boolean f = false;
  
  private boolean g = false;
  
  private String h;
  
  private List<ae> i = new ArrayList<ae>();
  
  private List<LatLng> j = new ArrayList<LatLng>();
  
  private LatLngBounds k = null;
  
  public bf(y paramy) {
    this.a = paramy;
    try {
      this.h = getId();
      return;
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "PolylineDelegateImp", "PolylineDelegateImp");
      return;
    } 
  }
  
  private List<LatLng> b() throws RemoteException {
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
  
  ae a(ae paramae1, ae paramae2, ae paramae3, double paramDouble, int paramInt) {
    ae ae1 = new ae();
    double d1 = (paramae2.a - paramae1.a);
    double d2 = (paramae2.b - paramae1.b);
    double d3 = d2 * d2 / d1 * d1;
    ae1.b = (int)(paramInt * paramDouble / Math.sqrt(d3 + 1.0D) + paramae3.b);
    ae1.a = (int)((paramae3.b - ae1.b) * d2 / d1 + paramae3.a);
    return ae1;
  }
  
  public void a(Canvas paramCanvas) throws RemoteException {
    List<ae> list = this.i;
    if (list != null && list.size() != 0) {
      if (this.b <= 0.0F)
        return; 
      try {
        Path path = new Path();
        w w = new w(((ae)this.i.get(0)).b, ((ae)this.i.get(0)).a);
        Point point2 = new Point();
        Point point1 = this.a.d().a(w, point2);
        path.moveTo(point1.x, point1.y);
        int i;
        for (i = 1; i < this.i.size(); i++) {
          w w1 = new w(((ae)this.i.get(i)).b, ((ae)this.i.get(i)).a);
          point2 = new Point();
          Point point = this.a.d().a(w1, point2);
          path.lineTo(point.x, point.y);
        } 
        Paint paint = new Paint();
        paint.setColor(getColor());
        paint.setAntiAlias(true);
        paint.setStrokeWidth(getWidth());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        if (this.f) {
          i = (int)getWidth();
          float f1 = (i * 3);
          float f2 = i;
          paint.setPathEffect((PathEffect)new DashPathEffect(new float[] { f1, f2, f1, f2 }, 1.0F));
        } 
        return;
      } finally {
        paramCanvas = null;
      } 
    } 
  }
  
  void a(LatLng paramLatLng1, LatLng paramLatLng2, List<ae> paramList, LatLngBounds.Builder paramBuilder) {
    byte b;
    double d1 = Math.abs(paramLatLng1.longitude - paramLatLng2.longitude) * Math.PI / 180.0D;
    LatLng latLng = new LatLng((paramLatLng2.latitude + paramLatLng1.latitude) / 2.0D, (paramLatLng2.longitude + paramLatLng1.longitude) / 2.0D);
    paramBuilder.include(paramLatLng1).include(latLng).include(paramLatLng2);
    if (latLng.latitude > 0.0D) {
      b = 1;
    } else {
      b = -1;
    } 
    ae ae3 = new ae();
    this.a.a(paramLatLng1.latitude, paramLatLng1.longitude, ae3);
    ae ae1 = new ae();
    this.a.a(paramLatLng2.latitude, paramLatLng2.longitude, ae1);
    ae ae2 = new ae();
    this.a.a(latLng.latitude, latLng.longitude, ae2);
    d1 *= 0.5D;
    double d2 = Math.cos(d1);
    ae2 = a(ae3, ae1, ae2, Math.hypot((ae3.a - ae1.a), (ae3.b - ae1.b)) * 0.5D * Math.tan(d1), b);
    ArrayList<ae> arrayList = new ArrayList();
    arrayList.add(ae3);
    arrayList.add(ae2);
    arrayList.add(ae1);
    a(arrayList, paramList, d2);
  }
  
  void a(List<LatLng> paramList) throws RemoteException {
    if (paramList != null)
      try {
        if (paramList.size() == 0)
          return; 
        LatLngBounds.Builder builder = LatLngBounds.builder();
        this.i.clear();
        if (paramList != null) {
          Object object = null;
          int i = 0;
          while (true) {
            if (i < paramList.size()) {
              LatLng latLng = paramList.get(i);
              Object object1 = object;
              if (latLng != null)
                if (latLng.equals(object)) {
                  object1 = object;
                } else {
                  if (!this.g) {
                    object = new ae();
                    this.a.a(latLng.latitude, latLng.longitude, (ae)object);
                    this.i.add(object);
                    builder.include(latLng);
                  } else if (object != null) {
                    if (Math.abs(latLng.longitude - ((LatLng)object).longitude) < 0.01D) {
                      object1 = new ae();
                      this.a.a(((LatLng)object).latitude, ((LatLng)object).longitude, (ae)object1);
                      this.i.add(object1);
                      builder.include((LatLng)object);
                      object = new ae();
                      this.a.a(latLng.latitude, latLng.longitude, (ae)object);
                      this.i.add(object);
                      builder.include(latLng);
                    } else {
                      a((LatLng)object, latLng, this.i, builder);
                    } 
                  } 
                  object1 = latLng;
                }  
              continue;
            } 
            if (this.i.size() > 0)
              return; 
            i++;
            object = SYNTHETIC_LOCAL_VARIABLE_4;
          } 
        } 
      } finally {
        paramList = null;
      }  
  }
  
  void a(List<ae> paramList1, List<ae> paramList2, double paramDouble) {
    if (paramList1.size() != 3)
      return; 
    int i;
    for (i = 0; i <= 10; i = (int)(f1 + 1.0F)) {
      float f1 = i;
      float f2 = f1 / 10.0F;
      ae ae = new ae();
      double d3 = 1.0D - f2;
      double d1 = d3 * d3;
      double d2 = ((ae)paramList1.get(0)).a;
      d3 = (2.0F * f2) * d3;
      double d4 = ((ae)paramList1.get(1)).a;
      f2 *= f2;
      double d5 = (((ae)paramList1.get(2)).a * f2);
      double d6 = ((ae)paramList1.get(0)).b;
      double d7 = ((ae)paramList1.get(1)).b;
      double d8 = (((ae)paramList1.get(2)).b * f2);
      double d9 = d1 + d3 * paramDouble + f2;
      ae.a = (int)((d2 * d1 + d4 * d3 * paramDouble + d5) / d9);
      ae.b = (int)((d6 * d1 + d7 * d3 * paramDouble + d8) / d9);
      paramList2.add(ae);
    } 
  }
  
  public boolean a() {
    LatLngBounds latLngBounds = this.k;
    boolean bool = false;
    if (latLngBounds == null)
      return false; 
    latLngBounds = this.a.getMapBounds();
    if (latLngBounds == null)
      return true; 
    if (latLngBounds.contains(this.k) || this.k.intersects(latLngBounds))
      bool = true; 
    return bool;
  }
  
  public void destroy() {}
  
  public boolean equalsRemote(IOverlay paramIOverlay) throws RemoteException {
    return (equals(paramIOverlay) || paramIOverlay.getId().equals(getId()));
  }
  
  public int getColor() throws RemoteException {
    return this.c;
  }
  
  public String getId() throws RemoteException {
    if (this.h == null)
      this.h = v.a("Polyline"); 
    return this.h;
  }
  
  public List<LatLng> getPoints() throws RemoteException {
    return (this.g || this.f) ? this.j : b();
  }
  
  public float getWidth() throws RemoteException {
    return this.b;
  }
  
  public float getZIndex() throws RemoteException {
    return this.d;
  }
  
  public int hashCodeRemote() throws RemoteException {
    return hashCode();
  }
  
  public boolean isDottedLine() {
    return this.f;
  }
  
  public boolean isGeodesic() {
    return this.g;
  }
  
  public boolean isVisible() throws RemoteException {
    return this.e;
  }
  
  public void remove() throws RemoteException {
    this.a.removeGLOverlay(getId());
  }
  
  public void setColor(int paramInt) throws RemoteException {
    this.c = paramInt;
  }
  
  public void setDottedLine(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  public void setGeodesic(boolean paramBoolean) throws RemoteException {
    if (this.g != paramBoolean)
      this.g = paramBoolean; 
  }
  
  public void setPoints(List<LatLng> paramList) throws RemoteException {
    if (this.g || this.f)
      this.j = paramList; 
    a(paramList);
  }
  
  public void setVisible(boolean paramBoolean) throws RemoteException {
    this.e = paramBoolean;
  }
  
  public void setWidth(float paramFloat) throws RemoteException {
    this.b = paramFloat;
  }
  
  public void setZIndex(float paramFloat) throws RemoteException {
    this.d = paramFloat;
    this.a.postInvalidate();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */