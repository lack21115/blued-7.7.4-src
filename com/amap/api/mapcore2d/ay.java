package com.amap.api.mapcore2d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.interfaces.IMarker;
import com.amap.api.maps2d.model.BitmapDescriptor;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.MarkerOptions;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

class ay implements ab {
  private static int a;
  
  private int b = 0;
  
  private float c = 0.0F;
  
  private CopyOnWriteArrayList<BitmapDescriptor> d = null;
  
  private int e = 20;
  
  private String f;
  
  private LatLng g;
  
  private LatLng h;
  
  private String i;
  
  private String j;
  
  private float k = 0.5F;
  
  private float l = 1.0F;
  
  private boolean m = false;
  
  private boolean n = true;
  
  private at o;
  
  private Object p;
  
  private boolean q = false;
  
  private a r;
  
  private boolean s = false;
  
  private int t;
  
  private int u;
  
  private float v;
  
  private int w;
  
  public ay(MarkerOptions paramMarkerOptions, at paramat) {
    this.o = paramat;
    this.q = paramMarkerOptions.isGps();
    this.v = paramMarkerOptions.getZIndex();
    if (paramMarkerOptions.getPosition() != null) {
      if (this.q)
        try {
          double[] arrayOfDouble = fy.a((paramMarkerOptions.getPosition()).longitude, (paramMarkerOptions.getPosition()).latitude);
          this.h = new LatLng(arrayOfDouble[1], arrayOfDouble[0]);
        } catch (Exception exception) {
          cm.a(exception, "MarkerDelegateImp", "MarkerDelegateImp");
          this.h = paramMarkerOptions.getPosition();
        }  
      this.g = paramMarkerOptions.getPosition();
    } 
    this.k = paramMarkerOptions.getAnchorU();
    this.l = paramMarkerOptions.getAnchorV();
    this.n = paramMarkerOptions.isVisible();
    this.j = paramMarkerOptions.getSnippet();
    this.i = paramMarkerOptions.getTitle();
    this.m = paramMarkerOptions.isDraggable();
    this.e = paramMarkerOptions.getPeriod();
    this.f = getId();
    a(paramMarkerOptions.getIcons());
    CopyOnWriteArrayList<BitmapDescriptor> copyOnWriteArrayList = this.d;
    if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() == 0)
      a(paramMarkerOptions.getIcon()); 
  }
  
  private ae a(float paramFloat1, float paramFloat2) {
    float f = (float)(this.c * Math.PI / 180.0D);
    ae ae = new ae();
    double d1 = paramFloat1;
    double d2 = f;
    double d3 = Math.cos(d2);
    double d4 = paramFloat2;
    ae.a = (int)(d3 * d1 + Math.sin(d2) * d4);
    ae.b = (int)(d4 * Math.cos(d2) - d1 * Math.sin(d2));
    return ae;
  }
  
  private static String a(String paramString) {
    a++;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(a);
    return stringBuilder.toString();
  }
  
  private void a(BitmapDescriptor paramBitmapDescriptor) {
    if (paramBitmapDescriptor != null) {
      c();
      this.d.add(paramBitmapDescriptor.clone());
    } 
    this.o.a().postInvalidate();
  }
  
  public Rect a() {
    ae ae = e();
    if (ae == null)
      return new Rect(0, 0, 0, 0); 
    try {
      int i = getWidth();
      int j = getHeight();
      Rect rect = new Rect();
      if (this.c == 0.0F) {
        float f6 = ae.b;
        float f5 = j;
        rect.top = (int)(f6 - this.l * f5);
        f6 = ae.a;
        float f7 = this.k;
        float f8 = i;
        rect.left = (int)(f6 - f7 * f8);
        return rect;
      } 
      float f1 = -this.k;
      float f2 = i;
      float f3 = this.l;
      float f4 = j;
      ae ae1 = a(f1 * f2, (f3 - 1.0F) * f4);
      ae ae2 = a(-this.k * f2, this.l * f4);
      ae ae3 = a((1.0F - this.k) * f2, this.l * f4);
      ae ae4 = a((1.0F - this.k) * f2, (this.l - 1.0F) * f4);
      rect.top = ae.b - Math.max(ae1.b, Math.max(ae2.b, Math.max(ae3.b, ae4.b)));
      rect.left = ae.a + Math.min(ae1.a, Math.min(ae2.a, Math.min(ae3.a, ae4.a)));
      return rect;
    } finally {
      ae = null;
      cm.a((Throwable)ae, "MarkerDelegateImp", "getRect");
    } 
  }
  
  public void a(Canvas paramCanvas, y paramy) {
    if (this.n && getPosition() != null) {
      Bitmap<BitmapDescriptor> bitmap;
      ae ae;
      if (f() == null)
        return; 
      if (isViewMode()) {
        ae = new ae(this.t, this.u);
      } else {
        ae = e();
      } 
      ArrayList<BitmapDescriptor> arrayList = getIcons();
      if (arrayList == null)
        return; 
      if (arrayList.size() > 1) {
        bitmap = ((BitmapDescriptor)arrayList.get(this.b)).getBitmap();
      } else if (bitmap.size() == 1) {
        bitmap = ((BitmapDescriptor)bitmap.get(0)).getBitmap();
      } else {
        bitmap = null;
      } 
      if (bitmap != null && !bitmap.isRecycled()) {
        paramCanvas.save();
        paramCanvas.rotate(this.c, ae.a, ae.b);
        paramCanvas.drawBitmap(bitmap, ae.a - g() * bitmap.getWidth(), ae.b - h() * bitmap.getHeight(), null);
        paramCanvas.restore();
      } 
    } 
  }
  
  public void a(LatLng paramLatLng) {
    if (this.q) {
      this.h = paramLatLng;
    } else {
      this.g = paramLatLng;
    } 
    try {
      Point point = this.o.a().getAMapProjection().toScreenLocation(paramLatLng);
      return;
    } finally {
      paramLatLng = null;
      cm.a((Throwable)paramLatLng, "MarkerDelegateImp", "setOffSetPosition");
    } 
  }
  
  public void a(ArrayList<BitmapDescriptor> paramArrayList) {
    try {
      c();
      return;
    } finally {
      paramArrayList = null;
      cm.a((Throwable)paramArrayList, "MarkerDelegateImp", "setBitmapDescriptor");
    } 
  }
  
  public s b() {
    s s = new s();
    CopyOnWriteArrayList<BitmapDescriptor> copyOnWriteArrayList = this.d;
    if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() != 0) {
      s.a = (getWidth() * this.k);
      s.b = (getHeight() * this.l);
    } 
    return s;
  }
  
  void c() {
    CopyOnWriteArrayList<BitmapDescriptor> copyOnWriteArrayList = this.d;
    if (copyOnWriteArrayList == null) {
      this.d = new CopyOnWriteArrayList<BitmapDescriptor>();
      return;
    } 
    copyOnWriteArrayList.clear();
  }
  
  public ae d() {
    if (getPosition() == null)
      return null; 
    ae ae = new ae();
    try {
      w w;
      if (this.q) {
        w = new w((int)((getRealPosition()).latitude * 1000000.0D), (int)((getRealPosition()).longitude * 1000000.0D));
      } else {
        w = new w((int)((getPosition()).latitude * 1000000.0D), (int)((getPosition()).longitude * 1000000.0D));
      } 
      Point point = new Point();
      this.o.a().d().a(w, point);
      return ae;
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
  
  public void destroy() {
    try {
      if (this.d == null) {
        this.g = null;
        this.p = null;
        this.r = null;
        return;
      } 
      for (BitmapDescriptor bitmapDescriptor : this.d) {
        if (bitmapDescriptor == null)
          continue; 
        Bitmap bitmap = bitmapDescriptor.getBitmap();
        if (bitmap != null)
          bitmap.recycle(); 
      } 
      this.d = null;
      this.g = null;
      this.p = null;
    } catch (Exception exception) {
      cm.a(exception, "MarkerDelegateImp", "destroy");
      Log.d("destroy erro", "MarkerDelegateImp destroy");
    } 
    this.r = null;
    at at1 = this.o;
    if (at1 != null && at1.a != null)
      this.o.a.postInvalidate(); 
  }
  
  public ae e() {
    ae ae2 = d();
    ae ae1 = ae2;
    if (ae2 == null)
      ae1 = null; 
    return ae1;
  }
  
  public boolean equalsRemote(IMarker paramIMarker) {
    return (paramIMarker != null && (equals(paramIMarker) || paramIMarker.getId().equals(getId())));
  }
  
  public BitmapDescriptor f() {
    CopyOnWriteArrayList<BitmapDescriptor> copyOnWriteArrayList = this.d;
    if (copyOnWriteArrayList == null)
      return null; 
    if (copyOnWriteArrayList.size() == 0) {
      c();
      this.d.add(BitmapDescriptorFactory.defaultMarker());
    } else if (this.d.get(0) == null) {
      this.d.clear();
      return f();
    } 
    return this.d.get(0);
  }
  
  public float g() {
    return this.k;
  }
  
  public int getAddIndex() {
    return this.w;
  }
  
  public int getHeight() {
    return (f() != null) ? f().getHeight() : 0;
  }
  
  public ArrayList<BitmapDescriptor> getIcons() {
    CopyOnWriteArrayList<BitmapDescriptor> copyOnWriteArrayList = this.d;
    if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
      ArrayList<BitmapDescriptor> arrayList = new ArrayList();
      for (BitmapDescriptor bitmapDescriptor : this.d) {
        if (bitmapDescriptor != null)
          arrayList.add(bitmapDescriptor); 
      } 
      return arrayList;
    } 
    return null;
  }
  
  public String getId() {
    if (this.f == null)
      this.f = a("Marker"); 
    return this.f;
  }
  
  public Object getObject() {
    return this.p;
  }
  
  public int getPeriod() throws RemoteException {
    return this.e;
  }
  
  public LatLng getPosition() {
    if (this.s) {
      s s = new s();
      this.o.a.a(this.t, this.u, s);
      return new LatLng(s.b, s.a);
    } 
    return this.g;
  }
  
  public LatLng getRealPosition() {
    if (this.s) {
      s s = new s();
      this.o.a.a(this.t, this.u, s);
      return new LatLng(s.b, s.a);
    } 
    return this.q ? this.h : this.g;
  }
  
  public String getSnippet() {
    return this.j;
  }
  
  public String getTitle() {
    return this.i;
  }
  
  public int getWidth() {
    return (f() != null) ? f().getWidth() : 0;
  }
  
  public float getZIndex() {
    return this.v;
  }
  
  public float h() {
    return this.l;
  }
  
  public int hashCodeRemote() {
    return hashCode();
  }
  
  public void hideInfoWindow() {
    if (isInfoWindowShown())
      this.o.e(this); 
  }
  
  public boolean isDraggable() {
    return this.m;
  }
  
  public boolean isInfoWindowShown() {
    return this.o.f(this);
  }
  
  public boolean isViewMode() {
    return this.s;
  }
  
  public boolean isVisible() {
    return this.n;
  }
  
  public boolean remove() {
    return this.o.b(this);
  }
  
  public void setAddIndex(int paramInt) {
    this.w = paramInt;
  }
  
  public void setAnchor(float paramFloat1, float paramFloat2) {
    if (this.k == paramFloat1 && this.l == paramFloat2)
      return; 
    this.k = paramFloat1;
    this.l = paramFloat2;
    if (isInfoWindowShown()) {
      this.o.e(this);
      this.o.d(this);
    } 
    this.o.a().postInvalidate();
  }
  
  public void setDraggable(boolean paramBoolean) {
    this.m = paramBoolean;
  }
  
  public void setIcon(BitmapDescriptor paramBitmapDescriptor) {
    if (paramBitmapDescriptor != null)
      try {
        if (this.d == null)
          return; 
        this.d.clear();
        this.d.add(paramBitmapDescriptor);
        if (isInfoWindowShown()) {
          this.o.e(this);
          this.o.d(this);
        } 
        return;
      } finally {
        paramBitmapDescriptor = null;
      }  
  }
  
  public void setIcons(ArrayList<BitmapDescriptor> paramArrayList) throws RemoteException {
    if (paramArrayList == null)
      return; 
    a(paramArrayList);
    if (this.r == null) {
      this.r = new a();
      this.r.start();
    } 
    if (isInfoWindowShown()) {
      this.o.e(this);
      this.o.d(this);
    } 
    this.o.a().postInvalidate();
  }
  
  public void setObject(Object paramObject) {
    this.p = paramObject;
  }
  
  public void setPeriod(int paramInt) throws RemoteException {
    if (paramInt <= 1) {
      this.e = 1;
      return;
    } 
    this.e = paramInt;
  }
  
  public void setPosition(LatLng paramLatLng) {
    if (paramLatLng == null)
      return; 
    if (this.q)
      try {
        double[] arrayOfDouble = fy.a(paramLatLng.longitude, paramLatLng.latitude);
        this.h = new LatLng(arrayOfDouble[1], arrayOfDouble[0]);
      } catch (Exception exception) {
        cm.a(exception, "MarkerDelegateImp", "setPosition");
        this.h = paramLatLng;
      }  
    this.s = false;
    this.g = paramLatLng;
    this.o.a().postInvalidate();
  }
  
  public void setPositionByPixels(int paramInt1, int paramInt2) {
    this.t = paramInt1;
    this.u = paramInt2;
    this.s = true;
    if (isInfoWindowShown())
      showInfoWindow(); 
  }
  
  public void setRotateAngle(float paramFloat) {
    this.c = (-paramFloat % 360.0F + 360.0F) % 360.0F;
    if (isInfoWindowShown()) {
      this.o.e(this);
      this.o.d(this);
    } 
    this.o.a().postInvalidate();
  }
  
  public void setSnippet(String paramString) {
    this.j = paramString;
  }
  
  public void setTitle(String paramString) {
    this.i = paramString;
  }
  
  public void setVisible(boolean paramBoolean) {
    this.n = paramBoolean;
    if (!paramBoolean && isInfoWindowShown())
      this.o.e(this); 
    this.o.a().postInvalidate();
  }
  
  public void setZIndex(float paramFloat) {
    this.v = paramFloat;
    this.o.d();
  }
  
  public void showInfoWindow() {
    if (!isVisible())
      return; 
    this.o.d(this);
  }
  
  class a extends Thread {
    private a(ay this$0) {}
    
    public void run() {
      try {
        setName("MarkerThread");
      } finally {
        Exception exception = null;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */