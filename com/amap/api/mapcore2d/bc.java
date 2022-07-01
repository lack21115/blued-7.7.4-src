package com.amap.api.mapcore2d;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.model.BitmapDescriptor;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.Circle;
import com.amap.api.maps2d.model.CircleOptions;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.MyLocationStyle;

class bc {
  a a = null;
  
  ValueAnimator b;
  
  Animator.AnimatorListener c = new Animator.AnimatorListener(this) {
      public void onAnimationCancel(Animator param1Animator) {}
      
      public void onAnimationEnd(Animator param1Animator) {
        bc.a(this.a);
      }
      
      public void onAnimationRepeat(Animator param1Animator) {}
      
      public void onAnimationStart(Animator param1Animator) {}
    };
  
  ValueAnimator.AnimatorUpdateListener d = new ValueAnimator.AnimatorUpdateListener(this) {
      public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
        try {
          if (bc.b(this.a) != null) {
            LatLng latLng = (LatLng)param1ValueAnimator.getAnimatedValue();
            bc.b(this.a).setCenter(latLng);
            return;
          } 
        } finally {
          param1ValueAnimator = null;
        } 
      }
    };
  
  private y e;
  
  private Marker f;
  
  private Circle g;
  
  private MyLocationStyle h;
  
  private LatLng i;
  
  private double j;
  
  private Context k;
  
  private bl l;
  
  private int m = 1;
  
  private boolean n = false;
  
  private final String o = "location_map_gps_locked.png";
  
  private final String p = "location_map_gps_3d.png";
  
  private BitmapDescriptor q = null;
  
  private boolean r = false;
  
  private boolean s = false;
  
  private boolean t = false;
  
  private boolean u = false;
  
  private boolean v = false;
  
  public bc(y paramy, Context paramContext) {
    this.k = paramContext.getApplicationContext();
    this.e = paramy;
    this.l = new bl(this.k, paramy);
    a(1, true);
  }
  
  private void a(int paramInt, boolean paramBoolean) {
    this.m = paramInt;
    this.n = false;
    this.r = false;
    this.u = false;
    this.v = false;
    paramInt = this.m;
    if (paramInt != 0)
      if (paramInt != 1) {
        if (paramInt == 2) {
          this.r = true;
          this.s = false;
          this.t = true;
        } 
      } else {
        this.r = true;
        this.s = true;
        this.t = true;
      }  
    if (this.l != null) {
      if (this.u || this.v) {
        if (this.v) {
          this.l.a(true);
          if (!paramBoolean)
            try {
              this.e.moveCamera(CameraUpdateFactory.zoomTo(17.0F));
            } finally {
              Exception exception = null;
            }  
        } else {
          this.l.a(false);
        } 
        this.l.a();
        return;
      } 
      b();
      return;
    } 
  }
  
  private void a(LatLng paramLatLng) {
    LatLng latLng2 = this.f.getPosition();
    LatLng latLng1 = latLng2;
    if (latLng2 == null)
      latLng1 = new LatLng(0.0D, 0.0D); 
    if (this.a == null)
      this.a = new a(this); 
    ValueAnimator valueAnimator = this.b;
    if (valueAnimator == null) {
      this.b = ValueAnimator.ofObject(new a(this), new Object[] { latLng1, paramLatLng });
      this.b.addListener(this.c);
      this.b.addUpdateListener(this.d);
      this.b.setDuration(1000L);
    } else {
      valueAnimator.setObjectValues(new Object[] { latLng1, paramLatLng });
      this.b.setEvaluator(this.a);
    } 
    if (latLng1.latitude == 0.0D && latLng1.longitude == 0.0D) {
      this.b.setDuration(1L);
    } else {
      this.b.setDuration(1000L);
    } 
    this.b.start();
  }
  
  private void b() {
    this.l.b();
  }
  
  private void b(float paramFloat) {
    if (!this.t)
      return; 
    float f = paramFloat % 360.0F;
    if (f > 180.0F) {
      paramFloat = f - 360.0F;
    } else {
      paramFloat = f;
      if (f < -180.0F)
        paramFloat = f + 360.0F; 
    } 
    Marker marker = this.f;
    if (marker != null)
      marker.setRotateAngle(-paramFloat); 
  }
  
  private void c() {
    if (!this.r)
      return; 
    if (this.s && this.n)
      return; 
    this.n = true;
    try {
      return;
    } finally {
      Exception exception = null;
      do.c(exception, "MyLocationOverlay", "moveMapToLocation");
      exception.printStackTrace();
    } 
  }
  
  private void d() {
    MyLocationStyle myLocationStyle = this.h;
    if (myLocationStyle == null) {
      this.h = new MyLocationStyle();
      this.h.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
      f();
      return;
    } 
    if (myLocationStyle.getMyLocationIcon() == null || this.h.getMyLocationIcon().getBitmap() == null)
      this.h.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png")); 
    f();
  }
  
  private void e() {
    Circle circle = this.g;
    if (circle != null) {
      try {
        this.e.removeGLOverlay(circle.getId());
      } finally {
        circle = null;
        do.c((Throwable)circle, "MyLocationOverlay", "locationIconRemove");
      } 
      this.g = null;
    } 
    Marker marker = this.f;
    if (marker != null) {
      marker.remove();
      this.f.destroy();
      this.f = null;
      bl bl1 = this.l;
      if (bl1 != null)
        bl1.a((Marker)null); 
    } 
  }
  
  private void f() {
    try {
      if (this.g == null)
        this.g = this.e.addCircle((new CircleOptions()).zIndex(1.0F)); 
      if (this.g != null) {
        if (this.g.getStrokeWidth() != this.h.getStrokeWidth())
          this.g.setStrokeWidth(this.h.getStrokeWidth()); 
        if (this.g.getFillColor() != this.h.getRadiusFillColor())
          this.g.setFillColor(this.h.getRadiusFillColor()); 
        if (this.g.getStrokeColor() != this.h.getStrokeColor())
          this.g.setStrokeColor(this.h.getStrokeColor()); 
        if (this.i != null)
          this.g.setCenter(this.i); 
        this.g.setRadius(this.j);
        this.g.setVisible(true);
      } 
      if (this.f == null)
        this.f = this.e.addMarker((new MarkerOptions()).visible(false)); 
      if (this.f != null) {
        this.f.setAnchor(this.h.getAnchorU(), this.h.getAnchorV());
        if (this.f.getIcons() == null || this.f.getIcons().size() == 0) {
          this.f.setIcon(this.h.getMyLocationIcon());
        } else if (this.h.getMyLocationIcon() != null && !((BitmapDescriptor)this.f.getIcons().get(0)).equals(this.h.getMyLocationIcon())) {
          this.f.setIcon(this.h.getMyLocationIcon());
        } 
        if (this.i != null) {
          this.f.setPosition(this.i);
          this.f.setVisible(true);
        } 
      } 
    } finally {
      Exception exception = null;
      do.c(exception, "MyLocationOverlay", "myLocStyle");
    } 
  }
  
  public void a() throws RemoteException {
    e();
    if (this.l != null) {
      b();
      this.l = null;
    } 
  }
  
  public void a(float paramFloat) {
    Marker marker = this.f;
    if (marker != null)
      marker.setRotateAngle(paramFloat); 
  }
  
  public void a(int paramInt) {
    a(paramInt, false);
  }
  
  public void a(Location paramLocation) {
    if (paramLocation == null)
      return; 
    MyLocationStyle myLocationStyle = this.h;
    if (myLocationStyle != null) {
      a(myLocationStyle.isMyLocationShowing());
      if (!this.h.isMyLocationShowing())
        return; 
    } 
    this.i = new LatLng(paramLocation.getLatitude(), paramLocation.getLongitude());
    this.j = paramLocation.getAccuracy();
    if (this.f == null && this.g == null)
      d(); 
    Circle circle = this.g;
    if (circle != null)
      try {
        if (this.j != -1.0D)
          circle.setRadius(this.j); 
      } finally {
        circle = null;
        do.c((Throwable)circle, "MyLocationOverlay", "setCentAndRadius");
      }  
    b(paramLocation.getBearing());
    if (!this.i.equals(this.f.getPosition())) {
      a(this.i);
      return;
    } 
    c();
  }
  
  public void a(MyLocationStyle paramMyLocationStyle) {
    try {
      this.h = paramMyLocationStyle;
      a(this.h.isMyLocationShowing());
      if (!this.h.isMyLocationShowing())
        return; 
      if (this.f == null && this.g == null)
        return; 
      return;
    } finally {
      paramMyLocationStyle = null;
      do.c((Throwable)paramMyLocationStyle, "MyLocationOverlay", "setMyLocationStyle");
      paramMyLocationStyle.printStackTrace();
    } 
  }
  
  public void a(boolean paramBoolean) {
    Circle circle = this.g;
    if (circle != null && circle.isVisible() != paramBoolean)
      this.g.setVisible(paramBoolean); 
    Marker marker = this.f;
    if (marker != null && marker.isVisible() != paramBoolean)
      this.f.setVisible(paramBoolean); 
  }
  
  public class a implements TypeEvaluator {
    public a(bc this$0) {}
    
    public Object evaluate(float param1Float, Object param1Object1, Object param1Object2) {
      param1Object1 = param1Object1;
      param1Object2 = param1Object2;
      double d1 = ((LatLng)param1Object1).latitude;
      double d2 = param1Float;
      return new LatLng(d1 + (((LatLng)param1Object2).latitude - ((LatLng)param1Object1).latitude) * d2, ((LatLng)param1Object1).longitude + d2 * (((LatLng)param1Object2).longitude - ((LatLng)param1Object1).longitude));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */