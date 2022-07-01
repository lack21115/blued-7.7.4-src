package com.github.mikephil.charting.charts;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.IHighlighter;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LegendRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class Chart<T extends ChartData<? extends IDataSet<? extends Entry>>> extends ViewGroup implements ChartInterface {
  protected boolean B = false;
  
  protected T C = null;
  
  protected boolean D = true;
  
  protected DefaultValueFormatter E = new DefaultValueFormatter(0);
  
  protected Paint F;
  
  protected Paint G;
  
  protected XAxis H;
  
  protected boolean I = true;
  
  protected Description J;
  
  protected Legend K;
  
  protected OnChartValueSelectedListener L;
  
  protected ChartTouchListener M;
  
  protected LegendRenderer N;
  
  protected DataRenderer O;
  
  protected IHighlighter P;
  
  protected ViewPortHandler Q = new ViewPortHandler();
  
  protected ChartAnimator R;
  
  protected Highlight[] S;
  
  protected float T = 0.0F;
  
  protected boolean U = true;
  
  protected IMarker V;
  
  protected ArrayList<Runnable> W = new ArrayList<Runnable>();
  
  private boolean a = true;
  
  private float b = 0.9F;
  
  private String c = "No chart data available.";
  
  private OnChartGestureListener d;
  
  private float e = 0.0F;
  
  private float f = 0.0F;
  
  private float g = 0.0F;
  
  private float h = 0.0F;
  
  private boolean i = false;
  
  private boolean j = false;
  
  public Chart(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public Chart(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public Chart(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a(View paramView) {
    if (paramView.getBackground() != null)
      paramView.getBackground().setCallback(null); 
    if (paramView instanceof ViewGroup) {
      int i = 0;
      while (true) {
        ViewGroup viewGroup = (ViewGroup)paramView;
        if (i < viewGroup.getChildCount()) {
          a(viewGroup.getChildAt(i));
          i++;
          continue;
        } 
        viewGroup.removeAllViews();
        break;
      } 
    } 
  }
  
  public void A() {
    ViewParent viewParent = getParent();
    if (viewParent != null)
      viewParent.requestDisallowInterceptTouchEvent(true); 
  }
  
  public void B() {
    ViewParent viewParent = getParent();
    if (viewParent != null)
      viewParent.requestDisallowInterceptTouchEvent(false); 
  }
  
  public boolean C() {
    return this.U;
  }
  
  public Highlight a(float paramFloat1, float paramFloat2) {
    if (this.C == null) {
      Log.e("MPAndroidChart", "Can't select by touch. No data set.");
      return null;
    } 
    return getHighlighter().a(paramFloat1, paramFloat2);
  }
  
  protected void a() {
    setWillNotDraw(false);
    this.R = new ChartAnimator(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            this.a.postInvalidate();
          }
        });
    Utils.a(getContext());
    this.T = Utils.a(500.0F);
    this.J = new Description();
    this.K = new Legend();
    this.N = new LegendRenderer(this.Q, this.K);
    this.H = new XAxis();
    this.F = new Paint(1);
    this.G = new Paint(1);
    this.G.setColor(Color.rgb(247, 189, 51));
    this.G.setTextAlign(Paint.Align.CENTER);
    this.G.setTextSize(Utils.a(12.0F));
    if (this.B)
      Log.i("", "Chart.init()"); 
  }
  
  public void a(Highlight paramHighlight, boolean paramBoolean) {
    Entry entry;
    if (paramHighlight == null) {
      this.S = null;
      entry = null;
    } else {
      if (this.B) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Highlighted: ");
        stringBuilder.append(paramHighlight.toString());
        Log.i("MPAndroidChart", stringBuilder.toString());
      } 
      entry = this.C.a(paramHighlight);
      if (entry == null) {
        this.S = null;
        paramHighlight = null;
      } else {
        this.S = new Highlight[] { paramHighlight };
      } 
    } 
    setLastHighlighted(this.S);
    if (paramBoolean && this.L != null)
      if (!x()) {
        this.L.a();
      } else {
        this.L.a(entry, paramHighlight);
      }  
    invalidate();
  }
  
  protected float[] a(Highlight paramHighlight) {
    return new float[] { paramHighlight.i(), paramHighlight.j() };
  }
  
  protected abstract void b();
  
  protected void b(Canvas paramCanvas) {
    Description description = this.J;
    if (description != null && description.z()) {
      float f1;
      float f2;
      MPPointF mPPointF = this.J.b();
      this.F.setTypeface(this.J.w());
      this.F.setTextSize(this.J.x());
      this.F.setColor(this.J.y());
      this.F.setTextAlign(this.J.c());
      if (mPPointF == null) {
        f1 = getWidth() - this.Q.b() - this.J.u();
        f2 = getHeight() - this.Q.d() - this.J.v();
      } else {
        f1 = mPPointF.a;
        f2 = mPPointF.b;
      } 
      paramCanvas.drawText(this.J.a(), f1, f2, this.F);
    } 
  }
  
  protected void c(float paramFloat1, float paramFloat2) {
    T t = this.C;
    if (t == null || t.j() < 2) {
      paramFloat1 = Math.max(Math.abs(paramFloat1), Math.abs(paramFloat2));
    } else {
      paramFloat1 = Math.abs(paramFloat2 - paramFloat1);
    } 
    int i = Utils.b(paramFloat1);
    this.E.a(i);
  }
  
  protected void c(Canvas paramCanvas) {
    if (this.V != null && C()) {
      if (!x())
        return; 
      int i = 0;
      while (true) {
        Highlight[] arrayOfHighlight = this.S;
        if (i < arrayOfHighlight.length) {
          Highlight highlight = arrayOfHighlight[i];
          IDataSet iDataSet = this.C.a(highlight.f());
          Entry entry = this.C.a(this.S[i]);
          int j = iDataSet.d(entry);
          if (entry != null && j <= iDataSet.H() * this.R.b()) {
            float[] arrayOfFloat = a(highlight);
            if (this.Q.b(arrayOfFloat[0], arrayOfFloat[1])) {
              this.V.a(entry, highlight);
              this.V.a(paramCanvas, arrayOfFloat[0], arrayOfFloat[1]);
            } 
          } 
          i++;
          continue;
        } 
        break;
      } 
    } 
  }
  
  public ChartAnimator getAnimator() {
    return this.R;
  }
  
  public MPPointF getCenter() {
    return MPPointF.a(getWidth() / 2.0F, getHeight() / 2.0F);
  }
  
  public MPPointF getCenterOfView() {
    return getCenter();
  }
  
  public MPPointF getCenterOffsets() {
    return this.Q.l();
  }
  
  public Bitmap getChartBitmap() {
    Bitmap bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
    Canvas canvas = new Canvas(bitmap);
    Drawable drawable = getBackground();
    if (drawable != null) {
      drawable.draw(canvas);
    } else {
      canvas.drawColor(-1);
    } 
    draw(canvas);
    return bitmap;
  }
  
  public RectF getContentRect() {
    return this.Q.k();
  }
  
  public T getData() {
    return this.C;
  }
  
  public ValueFormatter getDefaultValueFormatter() {
    return (ValueFormatter)this.E;
  }
  
  public Description getDescription() {
    return this.J;
  }
  
  public float getDragDecelerationFrictionCoef() {
    return this.b;
  }
  
  public float getExtraBottomOffset() {
    return this.g;
  }
  
  public float getExtraLeftOffset() {
    return this.h;
  }
  
  public float getExtraRightOffset() {
    return this.f;
  }
  
  public float getExtraTopOffset() {
    return this.e;
  }
  
  public Highlight[] getHighlighted() {
    return this.S;
  }
  
  public IHighlighter getHighlighter() {
    return this.P;
  }
  
  public ArrayList<Runnable> getJobs() {
    return this.W;
  }
  
  public Legend getLegend() {
    return this.K;
  }
  
  public LegendRenderer getLegendRenderer() {
    return this.N;
  }
  
  public IMarker getMarker() {
    return this.V;
  }
  
  @Deprecated
  public IMarker getMarkerView() {
    return getMarker();
  }
  
  public float getMaxHighlightDistance() {
    return this.T;
  }
  
  public OnChartGestureListener getOnChartGestureListener() {
    return this.d;
  }
  
  public ChartTouchListener getOnTouchListener() {
    return this.M;
  }
  
  public DataRenderer getRenderer() {
    return this.O;
  }
  
  public ViewPortHandler getViewPortHandler() {
    return this.Q;
  }
  
  public XAxis getXAxis() {
    return this.H;
  }
  
  public float getXChartMax() {
    return this.H.t;
  }
  
  public float getXChartMin() {
    return this.H.u;
  }
  
  public float getXRange() {
    return this.H.v;
  }
  
  public float getYMax() {
    return this.C.f();
  }
  
  public float getYMin() {
    return this.C.e();
  }
  
  public abstract void h();
  
  protected abstract void j();
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    if (this.j)
      a((View)this); 
  }
  
  protected void onDraw(Canvas paramCanvas) {
    if (this.C == null) {
      if ((TextUtils.isEmpty(this.c) ^ true) != 0) {
        MPPointF mPPointF = getCenter();
        paramCanvas.drawText(this.c, mPPointF.a, mPPointF.b, this.G);
      } 
      return;
    } 
    if (!this.i) {
      j();
      this.i = true;
    } 
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i;
    for (i = 0; i < getChildCount(); i++)
      getChildAt(i).layout(paramInt1, paramInt2, paramInt3, paramInt4); 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    int i = (int)Utils.a(50.0F);
    setMeasuredDimension(Math.max(getSuggestedMinimumWidth(), resolveSize(i, paramInt1)), Math.max(getSuggestedMinimumHeight(), resolveSize(i, paramInt2)));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (this.B)
      Log.i("MPAndroidChart", "OnSizeChanged()"); 
    if (paramInt1 > 0 && paramInt2 > 0 && paramInt1 < 10000 && paramInt2 < 10000) {
      if (this.B) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Setting chart dimens, width: ");
        stringBuilder.append(paramInt1);
        stringBuilder.append(", height: ");
        stringBuilder.append(paramInt2);
        Log.i("MPAndroidChart", stringBuilder.toString());
      } 
      this.Q.a(paramInt1, paramInt2);
    } else if (this.B) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("*Avoiding* setting chart dimens! width: ");
      stringBuilder.append(paramInt1);
      stringBuilder.append(", height: ");
      stringBuilder.append(paramInt2);
      Log.w("MPAndroidChart", stringBuilder.toString());
    } 
    h();
    Iterator<Runnable> iterator = this.W.iterator();
    while (iterator.hasNext())
      post(iterator.next()); 
    this.W.clear();
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setData(T paramT) {
    this.C = paramT;
    this.i = false;
    if (paramT == null)
      return; 
    c(paramT.e(), paramT.f());
    for (IDataSet iDataSet : this.C.i()) {
      if (iDataSet.r() || iDataSet.q() == this.E)
        iDataSet.a((ValueFormatter)this.E); 
    } 
    h();
    if (this.B)
      Log.i("MPAndroidChart", "Data is set."); 
  }
  
  public void setDescription(Description paramDescription) {
    this.J = paramDescription;
  }
  
  public void setDragDecelerationEnabled(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  public void setDragDecelerationFrictionCoef(float paramFloat) {
    float f = paramFloat;
    if (paramFloat < 0.0F)
      f = 0.0F; 
    paramFloat = f;
    if (f >= 1.0F)
      paramFloat = 0.999F; 
    this.b = paramFloat;
  }
  
  @Deprecated
  public void setDrawMarkerViews(boolean paramBoolean) {
    setDrawMarkers(paramBoolean);
  }
  
  public void setDrawMarkers(boolean paramBoolean) {
    this.U = paramBoolean;
  }
  
  public void setExtraBottomOffset(float paramFloat) {
    this.g = Utils.a(paramFloat);
  }
  
  public void setExtraLeftOffset(float paramFloat) {
    this.h = Utils.a(paramFloat);
  }
  
  public void setExtraRightOffset(float paramFloat) {
    this.f = Utils.a(paramFloat);
  }
  
  public void setExtraTopOffset(float paramFloat) {
    this.e = Utils.a(paramFloat);
  }
  
  public void setHardwareAccelerationEnabled(boolean paramBoolean) {
    if (paramBoolean) {
      setLayerType(2, null);
      return;
    } 
    setLayerType(1, null);
  }
  
  public void setHighlightPerTapEnabled(boolean paramBoolean) {
    this.D = paramBoolean;
  }
  
  public void setHighlighter(ChartHighlighter paramChartHighlighter) {
    this.P = (IHighlighter)paramChartHighlighter;
  }
  
  protected void setLastHighlighted(Highlight[] paramArrayOfHighlight) {
    if (paramArrayOfHighlight == null || paramArrayOfHighlight.length <= 0 || paramArrayOfHighlight[0] == null) {
      this.M.a(null);
      return;
    } 
    this.M.a(paramArrayOfHighlight[0]);
  }
  
  public void setLogEnabled(boolean paramBoolean) {
    this.B = paramBoolean;
  }
  
  public void setMarker(IMarker paramIMarker) {
    this.V = paramIMarker;
  }
  
  @Deprecated
  public void setMarkerView(IMarker paramIMarker) {
    setMarker(paramIMarker);
  }
  
  public void setMaxHighlightDistance(float paramFloat) {
    this.T = Utils.a(paramFloat);
  }
  
  public void setNoDataText(String paramString) {
    this.c = paramString;
  }
  
  public void setNoDataTextColor(int paramInt) {
    this.G.setColor(paramInt);
  }
  
  public void setNoDataTextTypeface(Typeface paramTypeface) {
    this.G.setTypeface(paramTypeface);
  }
  
  public void setOnChartGestureListener(OnChartGestureListener paramOnChartGestureListener) {
    this.d = paramOnChartGestureListener;
  }
  
  public void setOnChartValueSelectedListener(OnChartValueSelectedListener paramOnChartValueSelectedListener) {
    this.L = paramOnChartValueSelectedListener;
  }
  
  public void setOnTouchListener(ChartTouchListener paramChartTouchListener) {
    this.M = paramChartTouchListener;
  }
  
  public void setRenderer(DataRenderer paramDataRenderer) {
    if (paramDataRenderer != null)
      this.O = paramDataRenderer; 
  }
  
  public void setTouchEnabled(boolean paramBoolean) {
    this.I = paramBoolean;
  }
  
  public void setUnbindEnabled(boolean paramBoolean) {
    this.j = paramBoolean;
  }
  
  public boolean w() {
    return this.D;
  }
  
  public boolean x() {
    Highlight[] arrayOfHighlight = this.S;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (arrayOfHighlight != null) {
      bool1 = bool2;
      if (arrayOfHighlight.length > 0) {
        if (arrayOfHighlight[0] == null)
          return false; 
        bool1 = true;
      } 
    } 
    return bool1;
  }
  
  public boolean y() {
    return this.a;
  }
  
  public boolean z() {
    return this.B;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\charts\Chart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */