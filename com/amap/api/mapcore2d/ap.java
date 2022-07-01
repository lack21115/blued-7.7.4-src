package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.model.LatLng;

class ap extends LinearLayout {
  private Bitmap a;
  
  private Bitmap b;
  
  private Bitmap c;
  
  private ImageView d;
  
  private y e;
  
  private boolean f = false;
  
  public ap(Context paramContext, as paramas, y paramy) {
    super(paramContext);
    this.e = paramy;
    try {
      this.a = cm.a("location_selected2d.png");
      this.b = cm.a("location_pressed2d.png");
      this.a = cm.a(this.a, q.a);
      this.b = cm.a(this.b, q.a);
      this.c = cm.a("location_unselected2d.png");
      this.c = cm.a(this.c, q.a);
    } finally {
      paramas = null;
    } 
    this.d.setImageBitmap(this.a);
    this.d.setPadding(0, 20, 20, 0);
    this.d.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.d.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            if (!ap.a(this.a))
              return false; 
            if (param1MotionEvent.getAction() == 0) {
              ap.c(this.a).setImageBitmap(ap.b(this.a));
              return false;
            } 
            if (param1MotionEvent.getAction() == 1)
              try {
                ap.c(this.a).setImageBitmap(ap.d(this.a));
                ap.e(this.a).setMyLocationEnabled(true);
                Location location = ap.e(this.a).getMyLocation();
                if (location == null)
                  return false; 
                LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                ap.e(this.a).showMyLocationOverlay(location);
                ap.e(this.a).moveCamera(new CameraUpdate(m.a(latLng, ap.e(this.a).getZoomLevel())));
                return false;
              } catch (Exception exception) {
                cm.a(exception, "LocationView", "onTouch");
              }  
            return false;
          }
        });
    addView((View)this.d);
  }
  
  public void a() {
    try {
      if (this.a != null)
        this.a.recycle(); 
      if (this.b != null)
        this.b.recycle(); 
      if (this.c != null)
        this.c.recycle(); 
      this.a = null;
      this.b = null;
      this.c = null;
      return;
    } catch (Exception exception) {
      cm.a(exception, "LocationView", "destory");
      return;
    } 
  }
  
  public void a(boolean paramBoolean) {
    this.f = paramBoolean;
    if (paramBoolean) {
      this.d.setImageBitmap(this.a);
    } else {
      this.d.setImageBitmap(this.c);
    } 
    this.d.postInvalidate();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */