package com.github.mikephil.charting.components;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import java.lang.ref.WeakReference;

public class MarkerView extends RelativeLayout implements IMarker {
  private MPPointF a = new MPPointF();
  
  private MPPointF b = new MPPointF();
  
  private WeakReference<Chart> c;
  
  public MarkerView(Context paramContext, int paramInt) {
    super(paramContext);
    setupLayoutResource(paramInt);
  }
  
  private void setupLayoutResource(int paramInt) {
    View view = LayoutInflater.from(getContext()).inflate(paramInt, (ViewGroup)this);
    view.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-2, -2));
    view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
  }
  
  public MPPointF a(float paramFloat1, float paramFloat2) {
    MPPointF mPPointF = getOffset();
    this.b.a = mPPointF.a;
    this.b.b = mPPointF.b;
    Chart chart = getChartView();
    float f1 = getWidth();
    float f2 = getHeight();
    if (this.b.a + paramFloat1 < 0.0F) {
      this.b.a = -paramFloat1;
    } else if (chart != null && paramFloat1 + f1 + this.b.a > chart.getWidth()) {
      this.b.a = chart.getWidth() - paramFloat1 - f1;
    } 
    if (this.b.b + paramFloat2 < 0.0F) {
      this.b.b = -paramFloat2;
    } else if (chart != null && paramFloat2 + f2 + this.b.b > chart.getHeight()) {
      this.b.b = chart.getHeight() - paramFloat2 - f2;
    } 
    return this.b;
  }
  
  public void a(Canvas paramCanvas, float paramFloat1, float paramFloat2) {
    MPPointF mPPointF = a(paramFloat1, paramFloat2);
    int i = paramCanvas.save();
    paramCanvas.translate(paramFloat1 + mPPointF.a, paramFloat2 + mPPointF.b);
    draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  public void a(Entry paramEntry, Highlight paramHighlight) {
    measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
  }
  
  public Chart getChartView() {
    WeakReference<Chart> weakReference = this.c;
    return (weakReference == null) ? null : weakReference.get();
  }
  
  public MPPointF getOffset() {
    return this.a;
  }
  
  public void setChartView(Chart paramChart) {
    this.c = new WeakReference<Chart>(paramChart);
  }
  
  public void setOffset(MPPointF paramMPPointF) {
    this.a = paramMPPointF;
    if (this.a == null)
      this.a = new MPPointF(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\components\MarkerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */