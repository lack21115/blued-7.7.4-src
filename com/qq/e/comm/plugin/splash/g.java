package com.qq.e.comm.plugin.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import com.qq.e.comm.plugin.ac.g;
import com.qq.e.comm.util.GDTLogger;

class g extends ImageView implements g {
  private int a;
  
  private int b;
  
  private int c;
  
  private int d;
  
  private int e;
  
  private Movie f;
  
  private int g;
  
  private long h = -1L;
  
  private float i = -1.0F;
  
  private float j = 0.0F;
  
  private Bitmap k;
  
  public g(Context paramContext) {
    super(paramContext);
  }
  
  private void a(Canvas paramCanvas) {
    long l = System.currentTimeMillis();
    if (this.h < 0L)
      this.h = l; 
    int i = (int)(l - this.h);
    int j = this.g;
    this.f.setTime(i % j);
    if (this.i < 0.0F) {
      double d1 = Double.valueOf(this.d).doubleValue() / this.e;
      double d2 = Double.valueOf(this.a).doubleValue();
      i = this.b;
      if (d1 < d2 / i) {
        this.i = this.e / i;
      } else {
        this.i = this.d / this.a;
        float f1 = i;
        float f2 = this.i;
        this.j = -((f1 * f2 - this.e) / 2.0F) / f2;
      } 
    } 
    float f = this.i;
    paramCanvas.scale(f, f);
    this.f.draw(paramCanvas, this.j, 0.0F);
    invalidate();
  }
  
  public void a(Movie paramMovie) {
    if (paramMovie == null) {
      GDTLogger.e("movie is null");
      return;
    } 
    if (Build.VERSION.SDK_INT >= 11)
      setLayerType(1, null); 
    this.f = paramMovie;
    this.g = this.f.duration();
    if (this.g == 0) {
      this.g = 2500;
      GDTLogger.e("gif duration = 0, reset to 2500");
    } 
    this.b = paramMovie.width();
    this.a = paramMovie.height();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    Bitmap bitmap = this.k;
    if (bitmap != null && bitmap.isRecycled())
      return; 
    this.d = getHeight();
    this.e = getWidth();
    if (this.e != 0 && this.b != 0)
      if (this.f != null) {
        a(paramCanvas);
      } else {
        double d1 = Double.valueOf(this.d).doubleValue() / this.e;
        double d2 = Double.valueOf(this.a).doubleValue();
        int i = this.b;
        if (d1 < d2 / i) {
          this.c = this.a * this.e / i;
          getDrawable().setBounds(0, 0, this.e, this.c);
        } else {
          this.c = (i * this.d / this.a - this.e) / 2;
          Drawable drawable = getDrawable();
          i = this.c;
          drawable.setBounds(-i, 0, this.e + i, this.d);
        } 
      }  
    super.onDraw(paramCanvas);
  }
  
  public void setImageBitmap(Bitmap paramBitmap) {
    if (paramBitmap != null) {
      this.a = paramBitmap.getHeight();
      this.b = paramBitmap.getWidth();
      this.k = paramBitmap;
      super.setImageBitmap(paramBitmap);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\splash\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */