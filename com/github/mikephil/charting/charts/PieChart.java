package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.IHighlighter;
import com.github.mikephil.charting.highlight.PieHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.PieChartRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

public class PieChart extends PieRadarChartBase<PieData> {
  protected float a = 55.0F;
  
  protected float b = 360.0F;
  
  private RectF e = new RectF();
  
  private boolean f = true;
  
  private float[] g = new float[1];
  
  private float[] h = new float[1];
  
  private boolean i = true;
  
  private boolean j = false;
  
  private boolean k = false;
  
  private boolean l = false;
  
  private CharSequence m = "";
  
  private MPPointF n = MPPointF.a(0.0F, 0.0F);
  
  private float o = 50.0F;
  
  private boolean p = true;
  
  private float q = 100.0F;
  
  private float r = 0.0F;
  
  public PieChart(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public PieChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private float e(float paramFloat1, float paramFloat2) {
    return paramFloat1 / paramFloat2 * this.b;
  }
  
  private void l() {
    int i;
    int m = this.C.j();
    if (this.g.length != m) {
      this.g = new float[m];
    } else {
      for (i = 0; i < m; i++)
        this.g[i] = 0.0F; 
    } 
    if (this.h.length != m) {
      this.h = new float[m];
    } else {
      for (i = 0; i < m; i++)
        this.h[i] = 0.0F; 
    } 
    float f3 = this.C.l();
    List<IPieDataSet> list = this.C.i();
    float f1 = this.r;
    if (f1 != 0.0F && m * f1 <= this.b) {
      i = 1;
    } else {
      i = 0;
    } 
    float[] arrayOfFloat = new float[m];
    int j = 0;
    f1 = 0.0F;
    float f2 = 0.0F;
    int k = 0;
    while (j < this.C.d()) {
      IPieDataSet iPieDataSet = list.get(j);
      int n = 0;
      while (n < iPieDataSet.H()) {
        float f6 = e(Math.abs(((PieEntry)iPieDataSet.e(n)).b()), f3);
        float f4 = f2;
        float f5 = f1;
        if (i) {
          f4 = this.r;
          f5 = f6 - f4;
          if (f5 <= 0.0F) {
            arrayOfFloat[k] = f4;
            f5 = f1 + -f5;
            f4 = f2;
          } else {
            arrayOfFloat[k] = f6;
            f4 = f2 + f5;
            f5 = f1;
          } 
        } 
        float[] arrayOfFloat1 = this.g;
        arrayOfFloat1[k] = f6;
        if (!k) {
          this.h[k] = arrayOfFloat1[k];
        } else {
          float[] arrayOfFloat2 = this.h;
          arrayOfFloat2[k] = arrayOfFloat2[k - 1] + arrayOfFloat1[k];
        } 
        k++;
        n++;
        f2 = f4;
        f1 = f5;
      } 
      j++;
    } 
    if (i) {
      for (i = 0; i < m; i++) {
        arrayOfFloat[i] = arrayOfFloat[i] - (arrayOfFloat[i] - this.r) / f2 * f1;
        if (i == 0) {
          this.h[0] = arrayOfFloat[0];
        } else {
          float[] arrayOfFloat1 = this.h;
          arrayOfFloat1[i] = arrayOfFloat1[i - 1] + arrayOfFloat[i];
        } 
      } 
      this.g = arrayOfFloat;
    } 
  }
  
  public int a(float paramFloat) {
    paramFloat = Utils.c(paramFloat - getRotationAngle());
    int i = 0;
    while (true) {
      float[] arrayOfFloat = this.h;
      if (i < arrayOfFloat.length) {
        if (arrayOfFloat[i] > paramFloat)
          return i; 
        i++;
        continue;
      } 
      return -1;
    } 
  }
  
  protected void a() {
    super.a();
    this.O = (DataRenderer)new PieChartRenderer(this, this.R, this.Q);
    this.H = null;
    this.P = (IHighlighter)new PieHighlighter(this);
  }
  
  public boolean a(int paramInt) {
    if (!x())
      return false; 
    for (int i = 0; i < this.S.length; i++) {
      if ((int)this.S[i].a() == paramInt)
        return true; 
    } 
    return false;
  }
  
  protected float[] a(Highlight paramHighlight) {
    MPPointF mPPointF = getCenterCircleBox();
    float f2 = getRadius();
    float f1 = f2 / 10.0F * 3.6F;
    if (d())
      f1 = (f2 - f2 / 100.0F * getHoleRadius()) / 2.0F; 
    float f3 = getRotationAngle();
    int i = (int)paramHighlight.a();
    float f4 = this.g[i] / 2.0F;
    double d = (f2 - f1);
    f1 = (float)(Math.cos(Math.toRadians(((this.h[i] + f3 - f4) * this.R.a()))) * d + mPPointF.a);
    f2 = (float)(d * Math.sin(Math.toRadians(((f3 + this.h[i] - f4) * this.R.a()))) + mPPointF.b);
    MPPointF.b(mPPointF);
    return new float[] { f1, f2 };
  }
  
  protected void b() {
    l();
  }
  
  public boolean c() {
    return this.j;
  }
  
  public boolean d() {
    return this.i;
  }
  
  public boolean e() {
    return this.p;
  }
  
  public boolean f() {
    return this.f;
  }
  
  public boolean g() {
    return this.l;
  }
  
  public float[] getAbsoluteAngles() {
    return this.h;
  }
  
  public MPPointF getCenterCircleBox() {
    return MPPointF.a(this.e.centerX(), this.e.centerY());
  }
  
  public CharSequence getCenterText() {
    return this.m;
  }
  
  public MPPointF getCenterTextOffset() {
    return MPPointF.a(this.n.a, this.n.b);
  }
  
  public float getCenterTextRadiusPercent() {
    return this.q;
  }
  
  public RectF getCircleBox() {
    return this.e;
  }
  
  public float[] getDrawAngles() {
    return this.g;
  }
  
  public float getHoleRadius() {
    return this.o;
  }
  
  public float getMaxAngle() {
    return this.b;
  }
  
  public float getMinAngleForSlices() {
    return this.r;
  }
  
  public float getRadius() {
    RectF rectF = this.e;
    return (rectF == null) ? 0.0F : Math.min(rectF.width() / 2.0F, this.e.height() / 2.0F);
  }
  
  protected float getRequiredBaseOffset() {
    return 0.0F;
  }
  
  protected float getRequiredLegendOffset() {
    return this.N.a().getTextSize() * 2.0F;
  }
  
  public float getTransparentCircleRadius() {
    return this.a;
  }
  
  @Deprecated
  public XAxis getXAxis() {
    throw new RuntimeException("PieChart has no XAxis");
  }
  
  public boolean i() {
    return this.k;
  }
  
  public void j() {
    super.j();
    if (this.C == null)
      return; 
    float f1 = getDiameter() / 2.0F;
    MPPointF mPPointF = getCenterOffsets();
    float f2 = this.C.a().c();
    this.e.set(mPPointF.a - f1 + f2, mPPointF.b - f1 + f2, mPPointF.a + f1 - f2, mPPointF.b + f1 - f2);
    MPPointF.b(mPPointF);
  }
  
  protected void onDetachedFromWindow() {
    if (this.O != null && this.O instanceof PieChartRenderer)
      ((PieChartRenderer)this.O).f(); 
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    if (this.C == null)
      return; 
    this.O.a(paramCanvas);
    if (x())
      this.O.a(paramCanvas, this.S); 
    this.O.c(paramCanvas);
    this.O.b(paramCanvas);
    this.N.a(paramCanvas);
    b(paramCanvas);
    c(paramCanvas);
  }
  
  public void setCenterText(CharSequence paramCharSequence) {
    if (paramCharSequence == null) {
      this.m = "";
      return;
    } 
    this.m = paramCharSequence;
  }
  
  public void setCenterTextColor(int paramInt) {
    ((PieChartRenderer)this.O).d().setColor(paramInt);
  }
  
  public void setCenterTextRadiusPercent(float paramFloat) {
    this.q = paramFloat;
  }
  
  public void setCenterTextSize(float paramFloat) {
    ((PieChartRenderer)this.O).d().setTextSize(Utils.a(paramFloat));
  }
  
  public void setCenterTextSizePixels(float paramFloat) {
    ((PieChartRenderer)this.O).d().setTextSize(paramFloat);
  }
  
  public void setCenterTextTypeface(Typeface paramTypeface) {
    ((PieChartRenderer)this.O).d().setTypeface(paramTypeface);
  }
  
  public void setDrawCenterText(boolean paramBoolean) {
    this.p = paramBoolean;
  }
  
  public void setDrawEntryLabels(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  public void setDrawHoleEnabled(boolean paramBoolean) {
    this.i = paramBoolean;
  }
  
  public void setDrawRoundedSlices(boolean paramBoolean) {
    this.l = paramBoolean;
  }
  
  @Deprecated
  public void setDrawSliceText(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  public void setDrawSlicesUnderHole(boolean paramBoolean) {
    this.j = paramBoolean;
  }
  
  public void setEntryLabelColor(int paramInt) {
    ((PieChartRenderer)this.O).e().setColor(paramInt);
  }
  
  public void setEntryLabelTextSize(float paramFloat) {
    ((PieChartRenderer)this.O).e().setTextSize(Utils.a(paramFloat));
  }
  
  public void setEntryLabelTypeface(Typeface paramTypeface) {
    ((PieChartRenderer)this.O).e().setTypeface(paramTypeface);
  }
  
  public void setHoleColor(int paramInt) {
    ((PieChartRenderer)this.O).b().setColor(paramInt);
  }
  
  public void setHoleRadius(float paramFloat) {
    this.o = paramFloat;
  }
  
  public void setMaxAngle(float paramFloat) {
    float f = paramFloat;
    if (paramFloat > 360.0F)
      f = 360.0F; 
    paramFloat = f;
    if (f < 90.0F)
      paramFloat = 90.0F; 
    this.b = paramFloat;
  }
  
  public void setMinAngleForSlices(float paramFloat) {
    float f = this.b;
    if (paramFloat > f / 2.0F) {
      f /= 2.0F;
    } else {
      f = paramFloat;
      if (paramFloat < 0.0F)
        f = 0.0F; 
    } 
    this.r = f;
  }
  
  public void setTransparentCircleAlpha(int paramInt) {
    ((PieChartRenderer)this.O).c().setAlpha(paramInt);
  }
  
  public void setTransparentCircleColor(int paramInt) {
    Paint paint = ((PieChartRenderer)this.O).c();
    int i = paint.getAlpha();
    paint.setColor(paramInt);
    paint.setAlpha(i);
  }
  
  public void setTransparentCircleRadius(float paramFloat) {
    this.a = paramFloat;
  }
  
  public void setUsePercentValues(boolean paramBoolean) {
    this.k = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\charts\PieChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */