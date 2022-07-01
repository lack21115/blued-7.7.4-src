package com.blued.android.core.imagecache.drawable.apng;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import ar.com.hjg.pngj.PngReaderApng;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.utils.Log;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

public class ApngDrawable extends Drawable implements Animatable {
  protected final Uri a;
  
  String b;
  
  int c;
  
  int d;
  
  protected int e;
  
  ScheduledThreadPoolExecutor f = null;
  
  ApngFrameDecode g = new ApngFrameDecode(this);
  
  ApngBitmapCache h = new ApngBitmapCache();
  
  ApngInvalidationHandler i;
  
  Bitmap j;
  
  private Paint k;
  
  private final ImageView.ScaleType l;
  
  private WeakReference<ApngPlayListener> m = null;
  
  private boolean n = false;
  
  private RectF o;
  
  private int p;
  
  public ApngDrawable(Bitmap paramBitmap, Uri paramUri, ImageView.ScaleType paramScaleType) {
    this.l = paramScaleType;
    this.e = -1;
    this.p = 0;
    this.k = new Paint();
    this.k.setAntiAlias(true);
    this.b = RecyclingUtils.a();
    this.a = paramUri;
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(this.a.getPath(), options);
    this.c = options.outWidth;
    this.d = options.outHeight;
    this.i = new ApngInvalidationHandler(this);
  }
  
  private RectF a(Canvas paramCanvas) {
    int i = paramCanvas.getWidth();
    int j = paramCanvas.getHeight();
    float f1 = i;
    float f5 = f1 / this.c;
    float f4 = j;
    float f6 = f4 / this.d;
    i = null.a[this.l.ordinal()];
    float f2 = 0.0F;
    float f3 = 0.0F;
    if (i != 1) {
      if (i != 2 && i != 3) {
        f2 = f3;
      } else if (f5 > f6) {
        f3 = this.c * f6;
        f2 = (f1 - f3) / 2.0F;
        f1 = f3;
      } else {
        f6 = f5 * this.d;
        f5 = (f4 - f6) / 2.0F;
        f3 = f1;
        f1 = f6;
        f4 = f2;
        f2 = f5;
        return new RectF(f4, f2, f3 + f4, f1 + f2);
      } 
    } else {
      if (f5 > f6) {
        f6 = f5 * this.d;
        f5 = 0.0F - (f6 - f4) / 2.0F;
        f3 = f1;
        f1 = f6;
        f4 = f2;
        f2 = f5;
      } else {
        f2 = this.c * f6;
        f3 = 0.0F - (f2 - f1) / 2.0F;
        f1 = f2;
        f2 = f3;
        f5 = 0.0F;
        f3 = f1;
        f1 = f4;
        f4 = f2;
        f2 = f5;
      } 
      return new RectF(f4, f2, f3 + f4, f1 + f2);
    } 
    f5 = 0.0F;
    f3 = f1;
    f1 = f4;
    f4 = f2;
    f2 = f5;
  }
  
  private void a(Canvas paramCanvas, Bitmap paramBitmap) {
    if (this.o == null)
      this.o = a(paramCanvas); 
    paramCanvas.drawBitmap(paramBitmap, null, this.o, this.k);
  }
  
  public static boolean a(File paramFile) {
    boolean bool = false;
    try {
      PngReaderApng pngReaderApng = new PngReaderApng(paramFile);
      pngReaderApng.c();
      int i = pngReaderApng.h();
      if (i > 1)
        bool = true; 
      return bool;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public void a(int paramInt) {
    this.g.c = paramInt;
  }
  
  public void a(ApngPlayListener paramApngPlayListener) {
    if (paramApngPlayListener != null) {
      this.m = new WeakReference<ApngPlayListener>(paramApngPlayListener);
      return;
    } 
    this.m = null;
  }
  
  public void draw(Canvas paramCanvas) {
    if (this.e <= 0)
      this.j = this.h.b(0); 
    Bitmap bitmap = this.j;
    if (bitmap != null)
      a(paramCanvas, bitmap); 
  }
  
  public ApngPlayListener f() {
    WeakReference<ApngPlayListener> weakReference = this.m;
    return (weakReference != null) ? weakReference.get() : null;
  }
  
  public void g() {
    this.o = null;
    this.m = null;
  }
  
  public int getOpacity() {
    return -3;
  }
  
  boolean h() {
    this.p++;
    if (this.p < this.g.c || this.g.c == 0) {
      this.i.post(new Runnable(this) {
            public void run() {
              ApngPlayListener apngPlayListener = this.a.f();
              if (apngPlayListener != null)
                apngPlayListener.c(this.a); 
            }
          });
      return true;
    } 
    this.i.post(new Runnable(this) {
          public void run() {
            this.a.stop();
          }
        });
    return false;
  }
  
  String i() {
    Uri uri = this.a;
    if (uri == null)
      return null; 
    try {
      String str = uri.getLastPathSegment();
      File file = new File(this.b, str);
      if (!file.exists())
        AppMethods.a(this.a.getPath(), file.getPath(), false); 
      return file.getPath();
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Error: ");
      stringBuilder.append(exception.toString());
      Log.e("ApngDrawable2", stringBuilder.toString());
      return null;
    } 
  }
  
  public boolean isRunning() {
    return this.n;
  }
  
  public void setAlpha(int paramInt) {
    this.k.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    this.k.setColorFilter(paramColorFilter);
  }
  
  public void start() {
    if (!isRunning()) {
      this.n = true;
      this.e = 0;
      ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f;
      if (scheduledThreadPoolExecutor != null)
        scheduledThreadPoolExecutor.shutdownNow(); 
      this.f = new ScheduledThreadPoolExecutor(1, new ThreadPoolExecutor.DiscardPolicy());
      if (!this.g.a)
        this.f.execute(new Runnable(this) {
              public void run() {
                this.a.g.a();
              }
            }); 
      this.f.execute(new Runnable(this) {
            public void run() {
              this.a.g.b();
              this.a.i.post(new Runnable(this) {
                    public void run() {
                      if (this.a.a.g.a) {
                        ApngPlayListener apngPlayListener = this.a.a.f();
                        if (apngPlayListener != null)
                          apngPlayListener.a(this.a.a); 
                        this.a.a.invalidateSelf();
                        return;
                      } 
                      this.a.a.stop();
                    }
                  });
            }
          });
    } 
  }
  
  public void stop() {
    if (isRunning()) {
      this.p = 0;
      this.n = false;
      ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f;
      if (scheduledThreadPoolExecutor != null) {
        scheduledThreadPoolExecutor.shutdownNow();
        this.f = null;
      } 
      ApngPlayListener apngPlayListener = f();
      if (apngPlayListener != null)
        apngPlayListener.b(this); 
      this.h.a();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\drawable\apng\ApngDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */