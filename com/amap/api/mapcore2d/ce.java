package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps2d.CameraUpdate;

class ce extends LinearLayout {
  private Bitmap a;
  
  private Bitmap b;
  
  private Bitmap c;
  
  private Bitmap d;
  
  private Bitmap e;
  
  private Bitmap f;
  
  private ImageView g;
  
  private ImageView h;
  
  private aq i;
  
  private y j;
  
  private int k = 0;
  
  public ce(Context paramContext, aq paramaq, y paramy) {
    super(paramContext);
    setWillNotDraw(false);
    this.i = paramaq;
    this.j = paramy;
    try {
      this.a = cm.a("zoomin_selected2d.png");
      this.a = cm.a(this.a, q.a);
      this.b = cm.a("zoomin_unselected2d.png");
      this.b = cm.a(this.b, q.a);
      this.c = cm.a("zoomout_selected2d.png");
      this.c = cm.a(this.c, q.a);
      this.d = cm.a("zoomout_unselected2d.png");
      this.d = cm.a(this.d, q.a);
      this.e = cm.a("zoomin_pressed2d.png");
      this.f = cm.a("zoomout_pressed2d.png");
      this.e = cm.a(this.e, q.a);
      this.f = cm.a(this.f, q.a);
      this.g = new ImageView(paramContext);
      this.g.setImageBitmap(this.a);
      this.g.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              ce.b(this.a).setImageBitmap(ce.a(this.a));
              if (ce.c(this.a).getZoomLevel() > ((int)ce.c(this.a).getMaxZoomLevel() - 2)) {
                ce.e(this.a).setImageBitmap(ce.d(this.a));
              } else {
                ce.e(this.a).setImageBitmap(ce.f(this.a));
              } 
              ce ce1 = this.a;
              ce1.a(ce.c(ce1).getZoomLevel() + 1.0F);
              ce.g(this.a).c();
            }
          });
      this.h = new ImageView(paramContext);
      this.h.setImageBitmap(this.c);
      this.h.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              ce.e(this.a).setImageBitmap(ce.f(this.a));
              ce ce1 = this.a;
              ce1.a(ce.c(ce1).getZoomLevel() - 1.0F);
              if (ce.c(this.a).getZoomLevel() < ((int)ce.c(this.a).getMinZoomLevel() + 2)) {
                ce.b(this.a).setImageBitmap(ce.h(this.a));
              } else {
                ce.b(this.a).setImageBitmap(ce.a(this.a));
              } 
              ce.g(this.a).d();
            }
          });
      this.g.setOnTouchListener(new View.OnTouchListener(this) {
            public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
              if (ce.c(this.a).getZoomLevel() >= ce.c(this.a).getMaxZoomLevel())
                return false; 
              if (param1MotionEvent.getAction() == 0) {
                ce.e(this.a).setImageBitmap(ce.i(this.a));
                return false;
              } 
              if (param1MotionEvent.getAction() == 1) {
                ce.e(this.a).setImageBitmap(ce.f(this.a));
                try {
                  ce.c(this.a).animateCamera(new CameraUpdate(m.b()));
                  return false;
                } catch (RemoteException remoteException) {
                  cm.a((Throwable)remoteException, "ZoomControllerView", "ontouch");
                } 
              } 
              return false;
            }
          });
      this.h.setOnTouchListener(new View.OnTouchListener(this) {
            public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
              if (ce.c(this.a).getZoomLevel() <= ce.c(this.a).getMinZoomLevel())
                return false; 
              if (param1MotionEvent.getAction() == 0) {
                ce.b(this.a).setImageBitmap(ce.j(this.a));
                return false;
              } 
              if (param1MotionEvent.getAction() == 1) {
                ce.b(this.a).setImageBitmap(ce.a(this.a));
                try {
                  ce.c(this.a).animateCamera(new CameraUpdate(m.c()));
                  return false;
                } catch (RemoteException remoteException) {
                  cm.a((Throwable)remoteException, "ZoomControllerView", "onTouch");
                } 
              } 
              return false;
            }
          });
      this.g.setPadding(0, 0, 20, -2);
      this.h.setPadding(0, 0, 20, 20);
      setOrientation(1);
      return;
    } finally {
      paramContext = null;
      cm.a((Throwable)paramContext, "ZoomControllerView", "ZoomControllerView");
    } 
  }
  
  public void a() {
    try {
      if (this.a != null)
        this.a.recycle(); 
      if (this.b != null)
        this.b.recycle(); 
      if (this.c != null)
        this.c.recycle(); 
      if (this.d != null)
        this.d.recycle(); 
      if (this.e != null)
        this.e.recycle(); 
      if (this.f != null)
        this.f.recycle(); 
      this.a = null;
      this.b = null;
      this.c = null;
      this.d = null;
      this.e = null;
      this.f = null;
      return;
    } catch (Exception exception) {
      cm.a(exception, "ZoomControllerView", "destory");
      return;
    } 
  }
  
  public void a(float paramFloat) {
    try {
      if (paramFloat < this.j.getMaxZoomLevel() && paramFloat > this.j.getMinZoomLevel()) {
        this.g.setImageBitmap(this.a);
        return;
      } 
      if (paramFloat <= this.j.getMinZoomLevel()) {
        this.h.setImageBitmap(this.d);
        return;
      } 
    } finally {
      Exception exception = null;
    } 
  }
  
  public void a(int paramInt) {
    this.k = paramInt;
    removeView((View)this.g);
    removeView((View)this.h);
    addView((View)this.g);
    addView((View)this.h);
  }
  
  public int b() {
    return this.k;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */