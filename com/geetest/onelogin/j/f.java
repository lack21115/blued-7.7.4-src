package com.geetest.onelogin.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.io.IOException;
import java.io.InputStream;

public class f {
  private final long a = 16L;
  
  private InputStream b;
  
  private View c;
  
  private Movie d;
  
  private Bitmap e;
  
  private Canvas f;
  
  private Handler g = new Handler(Looper.getMainLooper());
  
  private Paint h;
  
  private Runnable i = new Runnable(this) {
      public void run() {
        try {
          f.a(this.a);
          if (f.b(this.a) != null) {
            f.d(this.a).postDelayed(f.c(this.a), 16L);
            return;
          } 
        } catch (Exception exception) {
          exception.printStackTrace();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Play gif Exception:");
          stringBuilder.append(exception.toString());
          h.c(stringBuilder.toString());
        } 
      }
    };
  
  private void a() {
    this.f.save();
    this.h = new Paint(1);
    this.h.setColor(-1);
    this.h.setStyle(Paint.Style.FILL);
    this.h.setAntiAlias(true);
    this.h.setDither(true);
    this.f.drawPaint(this.h);
    this.d.setTime((int)(System.currentTimeMillis() % this.d.duration()));
    this.d.draw(this.f, 0.0F, 0.0F);
    BitmapDrawable bitmapDrawable = new BitmapDrawable(this.e);
    if (this.c != null)
      if (Build.VERSION.SDK_INT >= 16) {
        this.c.setBackground((Drawable)bitmapDrawable);
      } else {
        this.c.setBackgroundDrawable((Drawable)bitmapDrawable);
      }  
    this.f.restore();
  }
  
  private void a(InputStream paramInputStream) {
    InputStream inputStream = this.b;
    if (inputStream != null)
      try {
        inputStream.close();
      } catch (IOException iOException) {
        iOException.printStackTrace();
      }  
    this.b = paramInputStream;
  }
  
  public void a(Context paramContext, int paramInt) {
    StringBuilder stringBuilder;
    try {
      InputStream inputStream = paramContext.getResources().openRawResource(paramInt);
    } catch (Exception exception) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("openRawResource exception from resourceId:");
      stringBuilder.append(paramInt);
      h.c(stringBuilder.toString());
      stringBuilder = null;
    } 
    a((InputStream)stringBuilder);
  }
  
  public void a(View paramView) {
    this.c = paramView;
    InputStream inputStream = this.b;
    if (inputStream != null) {
      if (paramView == null) {
        h.c("view can not be null");
        return;
      } 
      this.d = Movie.decodeStream(inputStream);
      Movie movie = this.d;
      if (movie == null) {
        h.c("gif file is invalid");
        return;
      } 
      if (movie.width() > 0 && this.d.height() > 0) {
        this.e = Bitmap.createBitmap(this.d.width(), this.d.height(), Bitmap.Config.RGB_565);
        this.f = new Canvas(this.e);
        this.g.post(this.i);
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\j\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */