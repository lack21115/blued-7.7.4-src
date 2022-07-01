package com.github.mikephil.charting.components;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointF;
import java.lang.ref.WeakReference;

public class MarkerImage implements IMarker {
  private Drawable a;
  
  private MPPointF b;
  
  private MPPointF c;
  
  private WeakReference<Chart> d;
  
  private FSize e;
  
  private Rect f;
  
  public MPPointF a() {
    return this.b;
  }
  
  public MPPointF a(float paramFloat1, float paramFloat2) {
    MPPointF mPPointF = a();
    this.c.a = mPPointF.a;
    this.c.b = mPPointF.b;
    Chart chart = b();
    float f2 = this.e.a;
    float f3 = this.e.b;
    float f1 = f2;
    if (f2 == 0.0F) {
      Drawable drawable = this.a;
      f1 = f2;
      if (drawable != null)
        f1 = drawable.getIntrinsicWidth(); 
    } 
    f2 = f3;
    if (f3 == 0.0F) {
      Drawable drawable = this.a;
      f2 = f3;
      if (drawable != null)
        f2 = drawable.getIntrinsicHeight(); 
    } 
    if (this.c.a + paramFloat1 < 0.0F) {
      this.c.a = -paramFloat1;
    } else if (chart != null && paramFloat1 + f1 + this.c.a > chart.getWidth()) {
      this.c.a = chart.getWidth() - paramFloat1 - f1;
    } 
    if (this.c.b + paramFloat2 < 0.0F) {
      this.c.b = -paramFloat2;
    } else if (chart != null && paramFloat2 + f2 + this.c.b > chart.getHeight()) {
      this.c.b = chart.getHeight() - paramFloat2 - f2;
    } 
    return this.c;
  }
  
  public void a(Canvas paramCanvas, float paramFloat1, float paramFloat2) {
    if (this.a == null)
      return; 
    MPPointF mPPointF = a(paramFloat1, paramFloat2);
    float f2 = this.e.a;
    float f3 = this.e.b;
    float f1 = f2;
    if (f2 == 0.0F)
      f1 = this.a.getIntrinsicWidth(); 
    f2 = f3;
    if (f3 == 0.0F)
      f2 = this.a.getIntrinsicHeight(); 
    this.a.copyBounds(this.f);
    this.a.setBounds(this.f.left, this.f.top, this.f.left + (int)f1, this.f.top + (int)f2);
    int i = paramCanvas.save();
    paramCanvas.translate(paramFloat1 + mPPointF.a, paramFloat2 + mPPointF.b);
    this.a.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
    this.a.setBounds(this.f);
  }
  
  public void a(Entry paramEntry, Highlight paramHighlight) {}
  
  public Chart b() {
    WeakReference<Chart> weakReference = this.d;
    return (weakReference == null) ? null : weakReference.get();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\components\MarkerImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */