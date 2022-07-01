package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.model.CameraPosition;

class p extends LinearLayout {
  private Bitmap a;
  
  private Bitmap b;
  
  private ImageView c;
  
  private as d;
  
  private y e;
  
  public p(Context paramContext, as paramas, y paramy) {
    super(paramContext);
    this.d = paramas;
    this.e = paramy;
    try {
      Bitmap bitmap = cm.a("maps_dav_compass_needle_large2d.png");
      this.b = cm.a(bitmap, q.a * 0.8F);
      if (this.b != null) {
        bitmap = cm.a(bitmap, q.a * 0.7F);
        this.a = Bitmap.createBitmap(this.b.getWidth(), this.b.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.a);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, ((this.b.getWidth() - bitmap.getWidth()) / 2), ((this.b.getHeight() - bitmap.getHeight()) / 2), paint);
      } 
    } finally {
      paramas = null;
    } 
    this.c.setScaleType(ImageView.ScaleType.MATRIX);
    this.c.setImageBitmap(this.a);
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.c.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            if (param1MotionEvent.getAction() == 0) {
              p.b(this.a).setImageBitmap(p.a(this.a));
            } else if (param1MotionEvent.getAction() == 1) {
              try {
                p.b(this.a).setImageBitmap(p.c(this.a));
                CameraPosition cameraPosition = p.d(this.a).getCameraPosition();
                p.d(this.a).animateCamera(new CameraUpdate(m.a(new CameraPosition(cameraPosition.target, cameraPosition.zoom, 0.0F, 0.0F))));
              } catch (Exception exception) {
                cm.a(exception, "CompassView", "onTouch");
              } 
            } 
            return false;
          }
        });
    addView((View)this.c);
  }
  
  public void a() {
    try {
      if (this.a != null)
        this.a.recycle(); 
      if (this.b != null)
        this.b.recycle(); 
      this.a = null;
      this.b = null;
      return;
    } catch (Exception exception) {
      cm.a(exception, "CompassView", "destory");
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */