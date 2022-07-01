package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import java.util.LinkedList;

public class PLPaintView extends View {
  private Bitmap a;
  
  private Canvas b;
  
  private Paint c = new Paint();
  
  private Path d = new Path();
  
  private boolean e = true;
  
  private int f;
  
  private int g;
  
  private float h;
  
  private float i;
  
  private LinkedList<a> j = new LinkedList<a>();
  
  public PLPaintView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public PLPaintView(Context paramContext, int paramInt1, int paramInt2) {
    this(paramContext);
    this.f = paramInt1;
    this.g = paramInt2;
  }
  
  private void a() {
    this.c.setAntiAlias(true);
    this.c.setDither(true);
    this.c.setStrokeJoin(Paint.Join.ROUND);
    this.c.setStrokeCap(Paint.Cap.ROUND);
    this.c.setColor(-16777216);
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setStrokeWidth(10.0F);
  }
  
  private void b() {
    int j = getWidth();
    int k = getHeight();
    int i = this.f;
    boolean bool = true;
    if (i != 0 && i < j) {
      i = 1;
    } else {
      i = 0;
    } 
    int m = this.g;
    if (m == 0 || m >= k)
      bool = false; 
    if (i != 0)
      j = this.f; 
    this.f = j;
    i = k;
    if (bool)
      i = this.g; 
    this.g = i;
    this.a = Bitmap.createBitmap(this.f, this.g, Bitmap.Config.ARGB_8888);
    this.b = new Canvas(this.a);
  }
  
  private void c() {
    Path path = new Path(this.d);
    a a = new a(this, new Paint(this.c), path);
    this.j.add(a);
  }
  
  private void d() {
    Bitmap bitmap = this.a;
    if (bitmap != null) {
      bitmap.eraseColor(0);
      if (!this.j.isEmpty())
        for (a a : this.j)
          this.b.drawPath(a.b(), a.a());  
      invalidate();
    } 
  }
  
  public void clear() {
    this.j.clear();
    d();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    Bitmap bitmap = this.a;
    if (bitmap != null)
      paramCanvas.drawBitmap(bitmap, 0.0F, 0.0F, null); 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (!this.e)
      return false; 
    int i = paramMotionEvent.getAction() & 0xFF;
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int j = paramMotionEvent.getActionIndex();
    if (i != 0) {
      if (i != 1) {
        if (i != 2)
          return true; 
        if (paramMotionEvent.getPointerId(j) == 1)
          return true; 
        if (this.a == null)
          b(); 
        float f3 = Math.abs(f1 - this.h);
        float f4 = Math.abs(this.i - f2);
        if (f3 >= 3.0F || f4 >= 3.0F) {
          Path path = this.d;
          f3 = this.h;
          f4 = this.i;
          path.quadTo(f3, f4, (f1 + f3) / 2.0F, (f2 + f4) / 2.0F);
          this.b.drawPath(this.d, this.c);
          invalidate();
          this.h = f1;
          this.i = f2;
          return true;
        } 
      } else {
        c();
        this.d.reset();
        return true;
      } 
    } else {
      this.h = f1;
      this.i = f2;
      this.d.moveTo(f1, f2);
    } 
    return true;
  }
  
  public void setPaint(Paint paramPaint) {
    this.c = paramPaint;
  }
  
  public void setPaintColor(int paramInt) {
    this.c.setColor(paramInt);
  }
  
  public void setPaintEnable(boolean paramBoolean) {
    this.e = paramBoolean;
  }
  
  public void setPaintSize(int paramInt) {
    this.c.setStrokeWidth(paramInt);
  }
  
  public void undo() {
    if (!this.j.isEmpty())
      this.j.removeLast(); 
    d();
  }
  
  class a {
    private Paint b;
    
    private Path c;
    
    public a(PLPaintView this$0, Paint param1Paint, Path param1Path) {
      this.b = param1Paint;
      this.c = param1Path;
    }
    
    public Paint a() {
      return this.b;
    }
    
    public Path b() {
      return this.c;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLPaintView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */