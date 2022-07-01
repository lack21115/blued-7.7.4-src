package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.listener.BarLineChartTouchListener;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnDrawListener;
import com.github.mikephil.charting.renderer.XAxisRenderer;
import com.github.mikephil.charting.renderer.YAxisRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;

public abstract class BarLineChartBase<T extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>> extends Chart<T> implements BarLineScatterCandleBubbleDataProvider {
  protected float[] A = new float[2];
  
  private boolean a = true;
  
  private boolean aa = true;
  
  private boolean ab = true;
  
  private boolean ac = true;
  
  private long ad = 0L;
  
  private long ae = 0L;
  
  private RectF af = new RectF();
  
  private boolean ag = false;
  
  protected int b = 100;
  
  protected boolean c = false;
  
  protected boolean d = false;
  
  protected boolean e = true;
  
  protected boolean f = true;
  
  protected Paint g;
  
  protected Paint h;
  
  protected boolean i = false;
  
  protected boolean j = false;
  
  protected boolean k = false;
  
  protected float l = 15.0F;
  
  protected boolean m = false;
  
  protected OnDrawListener n;
  
  protected YAxis o;
  
  protected YAxis p;
  
  protected YAxisRenderer q;
  
  protected YAxisRenderer r;
  
  protected Transformer s;
  
  protected Transformer t;
  
  protected XAxisRenderer u;
  
  protected Matrix v = new Matrix();
  
  protected Matrix w = new Matrix();
  
  protected float[] x = new float[2];
  
  protected MPPointD y = MPPointD.a(0.0D, 0.0D);
  
  protected MPPointD z = MPPointD.a(0.0D, 0.0D);
  
  public BarLineChartBase(Context paramContext) {
    super(paramContext);
  }
  
  public BarLineChartBase(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public BarLineChartBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public Transformer a(YAxis.AxisDependency paramAxisDependency) {
    return (paramAxisDependency == YAxis.AxisDependency.a) ? this.s : this.t;
  }
  
  protected void a() {
    super.a();
    this.o = new YAxis(YAxis.AxisDependency.a);
    this.p = new YAxis(YAxis.AxisDependency.b);
    this.s = new Transformer(this.Q);
    this.t = new Transformer(this.Q);
    this.q = new YAxisRenderer(this.Q, this.o, this.s);
    this.r = new YAxisRenderer(this.Q, this.p, this.t);
    this.u = new XAxisRenderer(this.Q, this.H, this.s);
    setHighlighter(new ChartHighlighter(this));
    this.M = (ChartTouchListener)new BarLineChartTouchListener(this, this.Q.p(), 3.0F);
    this.g = new Paint();
    this.g.setStyle(Paint.Style.FILL);
    this.g.setColor(Color.rgb(240, 240, 240));
    this.h = new Paint();
    this.h.setStyle(Paint.Style.STROKE);
    this.h.setColor(-16777216);
    this.h.setStrokeWidth(Utils.a(1.0F));
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    this.Q.a(paramFloat1, paramFloat2, paramFloat3, -paramFloat4, this.v);
    this.Q.a(this.v, (View)this, false);
    j();
    postInvalidate();
  }
  
  protected void a(Canvas paramCanvas) {
    if (this.i)
      paramCanvas.drawRect(this.Q.k(), this.g); 
    if (this.j)
      paramCanvas.drawRect(this.Q.k(), this.h); 
  }
  
  protected void a(RectF paramRectF) {
    paramRectF.left = 0.0F;
    paramRectF.right = 0.0F;
    paramRectF.top = 0.0F;
    paramRectF.bottom = 0.0F;
    if (this.K != null && this.K.z() && !this.K.g()) {
      int i = null.c[this.K.f().ordinal()];
      if (i != 1) {
        if (i != 2)
          return; 
        i = null.a[this.K.e().ordinal()];
        if (i != 1) {
          if (i != 2)
            return; 
          paramRectF.bottom += Math.min(this.K.b, this.Q.m() * this.K.q()) + this.K.v();
          return;
        } 
        paramRectF.top += Math.min(this.K.b, this.Q.m() * this.K.q()) + this.K.v();
        return;
      } 
      i = null.b[this.K.d().ordinal()];
      if (i != 1) {
        if (i != 2) {
          if (i != 3)
            return; 
          i = null.a[this.K.e().ordinal()];
          if (i != 1) {
            if (i != 2)
              return; 
            paramRectF.bottom += Math.min(this.K.b, this.Q.m() * this.K.q()) + this.K.v();
            return;
          } 
          paramRectF.top += Math.min(this.K.b, this.Q.m() * this.K.q()) + this.K.v();
          return;
        } 
        paramRectF.right += Math.min(this.K.a, this.Q.n() * this.K.q()) + this.K.u();
        return;
      } 
      paramRectF.left += Math.min(this.K.a, this.Q.n() * this.K.q()) + this.K.u();
    } 
  }
  
  public YAxis b(YAxis.AxisDependency paramAxisDependency) {
    return (paramAxisDependency == YAxis.AxisDependency.a) ? this.o : this.p;
  }
  
  public IBarLineScatterCandleBubbleDataSet b(float paramFloat1, float paramFloat2) {
    Highlight highlight = a(paramFloat1, paramFloat2);
    return (highlight != null) ? (IBarLineScatterCandleBubbleDataSet)((BarLineScatterCandleBubbleData)this.C).a(highlight.f()) : null;
  }
  
  protected void b() {
    this.H.a(((BarLineScatterCandleBubbleData)this.C).g(), ((BarLineScatterCandleBubbleData)this.C).h());
    this.o.a(((BarLineScatterCandleBubbleData)this.C).a(YAxis.AxisDependency.a), ((BarLineScatterCandleBubbleData)this.C).b(YAxis.AxisDependency.a));
    this.p.a(((BarLineScatterCandleBubbleData)this.C).a(YAxis.AxisDependency.b), ((BarLineScatterCandleBubbleData)this.C).b(YAxis.AxisDependency.b));
  }
  
  public boolean c(YAxis.AxisDependency paramAxisDependency) {
    return b(paramAxisDependency).G();
  }
  
  public void computeScroll() {
    if (this.M instanceof BarLineChartTouchListener)
      ((BarLineChartTouchListener)this.M).b(); 
  }
  
  protected void f() {
    if (this.B) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Preparing Value-Px Matrix, xmin: ");
      stringBuilder.append(this.H.u);
      stringBuilder.append(", xmax: ");
      stringBuilder.append(this.H.t);
      stringBuilder.append(", xdelta: ");
      stringBuilder.append(this.H.v);
      Log.i("MPAndroidChart", stringBuilder.toString());
    } 
    this.t.a(this.H.u, this.H.v, this.p.v, this.p.u);
    this.s.a(this.H.u, this.H.v, this.o.v, this.o.u);
  }
  
  protected void g() {
    this.t.a(this.p.G());
    this.s.a(this.o.G());
  }
  
  public YAxis getAxisLeft() {
    return this.o;
  }
  
  public YAxis getAxisRight() {
    return this.p;
  }
  
  public OnDrawListener getDrawListener() {
    return this.n;
  }
  
  public float getHighestVisibleX() {
    a(YAxis.AxisDependency.a).a(this.Q.g(), this.Q.h(), this.z);
    return (float)Math.min(this.H.t, this.z.a);
  }
  
  public float getLowestVisibleX() {
    a(YAxis.AxisDependency.a).a(this.Q.f(), this.Q.h(), this.y);
    return (float)Math.max(this.H.u, this.y.a);
  }
  
  public int getMaxVisibleCount() {
    return this.b;
  }
  
  public float getMinOffset() {
    return this.l;
  }
  
  public YAxisRenderer getRendererLeftYAxis() {
    return this.q;
  }
  
  public YAxisRenderer getRendererRightYAxis() {
    return this.r;
  }
  
  public XAxisRenderer getRendererXAxis() {
    return this.u;
  }
  
  public float getScaleX() {
    return (this.Q == null) ? 1.0F : this.Q.q();
  }
  
  public float getScaleY() {
    return (this.Q == null) ? 1.0F : this.Q.r();
  }
  
  public float getVisibleXRange() {
    return Math.abs(getHighestVisibleX() - getLowestVisibleX());
  }
  
  public float getYChartMax() {
    return Math.max(this.o.t, this.p.t);
  }
  
  public float getYChartMin() {
    return Math.min(this.o.u, this.p.u);
  }
  
  public void h() {
    if (this.C == null) {
      if (this.B)
        Log.i("MPAndroidChart", "Preparing... DATA NOT SET."); 
      return;
    } 
    if (this.B)
      Log.i("MPAndroidChart", "Preparing..."); 
    if (this.O != null)
      this.O.a(); 
    b();
    this.q.a(this.o.u, this.o.t, this.o.G());
    this.r.a(this.p.u, this.p.t, this.p.G());
    this.u.a(this.H.u, this.H.t, false);
    if (this.K != null)
      this.N.a((ChartData)this.C); 
    j();
  }
  
  protected void i() {
    float f1 = getLowestVisibleX();
    float f2 = getHighestVisibleX();
    ((BarLineScatterCandleBubbleData)this.C).a(f1, f2);
    this.H.a(((BarLineScatterCandleBubbleData)this.C).g(), ((BarLineScatterCandleBubbleData)this.C).h());
    if (this.o.z())
      this.o.a(((BarLineScatterCandleBubbleData)this.C).a(YAxis.AxisDependency.a), ((BarLineScatterCandleBubbleData)this.C).b(YAxis.AxisDependency.a)); 
    if (this.p.z())
      this.p.a(((BarLineScatterCandleBubbleData)this.C).a(YAxis.AxisDependency.b), ((BarLineScatterCandleBubbleData)this.C).b(YAxis.AxisDependency.b)); 
    j();
  }
  
  public void j() {
    // Byte code:
    //   0: aload_0
    //   1: getfield ag : Z
    //   4: ifne -> 458
    //   7: aload_0
    //   8: aload_0
    //   9: getfield af : Landroid/graphics/RectF;
    //   12: invokevirtual a : (Landroid/graphics/RectF;)V
    //   15: aload_0
    //   16: getfield af : Landroid/graphics/RectF;
    //   19: getfield left : F
    //   22: fconst_0
    //   23: fadd
    //   24: fstore_3
    //   25: aload_0
    //   26: getfield af : Landroid/graphics/RectF;
    //   29: getfield top : F
    //   32: fconst_0
    //   33: fadd
    //   34: fstore #6
    //   36: aload_0
    //   37: getfield af : Landroid/graphics/RectF;
    //   40: getfield right : F
    //   43: fconst_0
    //   44: fadd
    //   45: fstore_1
    //   46: aload_0
    //   47: getfield af : Landroid/graphics/RectF;
    //   50: getfield bottom : F
    //   53: fconst_0
    //   54: fadd
    //   55: fstore #4
    //   57: fload_3
    //   58: fstore_2
    //   59: aload_0
    //   60: getfield o : Lcom/github/mikephil/charting/components/YAxis;
    //   63: invokevirtual M : ()Z
    //   66: ifeq -> 86
    //   69: fload_3
    //   70: aload_0
    //   71: getfield o : Lcom/github/mikephil/charting/components/YAxis;
    //   74: aload_0
    //   75: getfield q : Lcom/github/mikephil/charting/renderer/YAxisRenderer;
    //   78: invokevirtual a : ()Landroid/graphics/Paint;
    //   81: invokevirtual a : (Landroid/graphics/Paint;)F
    //   84: fadd
    //   85: fstore_2
    //   86: fload_1
    //   87: fstore_3
    //   88: aload_0
    //   89: getfield p : Lcom/github/mikephil/charting/components/YAxis;
    //   92: invokevirtual M : ()Z
    //   95: ifeq -> 115
    //   98: fload_1
    //   99: aload_0
    //   100: getfield p : Lcom/github/mikephil/charting/components/YAxis;
    //   103: aload_0
    //   104: getfield r : Lcom/github/mikephil/charting/renderer/YAxisRenderer;
    //   107: invokevirtual a : ()Landroid/graphics/Paint;
    //   110: invokevirtual a : (Landroid/graphics/Paint;)F
    //   113: fadd
    //   114: fstore_3
    //   115: fload #6
    //   117: fstore #5
    //   119: fload #4
    //   121: fstore_1
    //   122: aload_0
    //   123: getfield H : Lcom/github/mikephil/charting/components/XAxis;
    //   126: invokevirtual z : ()Z
    //   129: ifeq -> 248
    //   132: fload #6
    //   134: fstore #5
    //   136: fload #4
    //   138: fstore_1
    //   139: aload_0
    //   140: getfield H : Lcom/github/mikephil/charting/components/XAxis;
    //   143: invokevirtual h : ()Z
    //   146: ifeq -> 248
    //   149: aload_0
    //   150: getfield H : Lcom/github/mikephil/charting/components/XAxis;
    //   153: getfield F : I
    //   156: i2f
    //   157: aload_0
    //   158: getfield H : Lcom/github/mikephil/charting/components/XAxis;
    //   161: invokevirtual v : ()F
    //   164: fadd
    //   165: fstore #7
    //   167: aload_0
    //   168: getfield H : Lcom/github/mikephil/charting/components/XAxis;
    //   171: invokevirtual A : ()Lcom/github/mikephil/charting/components/XAxis$XAxisPosition;
    //   174: getstatic com/github/mikephil/charting/components/XAxis$XAxisPosition.b : Lcom/github/mikephil/charting/components/XAxis$XAxisPosition;
    //   177: if_acmpne -> 193
    //   180: fload #4
    //   182: fload #7
    //   184: fadd
    //   185: fstore_1
    //   186: fload #6
    //   188: fstore #5
    //   190: goto -> 248
    //   193: aload_0
    //   194: getfield H : Lcom/github/mikephil/charting/components/XAxis;
    //   197: invokevirtual A : ()Lcom/github/mikephil/charting/components/XAxis$XAxisPosition;
    //   200: getstatic com/github/mikephil/charting/components/XAxis$XAxisPosition.a : Lcom/github/mikephil/charting/components/XAxis$XAxisPosition;
    //   203: if_acmpne -> 219
    //   206: fload #4
    //   208: fstore_1
    //   209: fload #6
    //   211: fload #7
    //   213: fadd
    //   214: fstore #5
    //   216: goto -> 248
    //   219: fload #6
    //   221: fstore #5
    //   223: fload #4
    //   225: fstore_1
    //   226: aload_0
    //   227: getfield H : Lcom/github/mikephil/charting/components/XAxis;
    //   230: invokevirtual A : ()Lcom/github/mikephil/charting/components/XAxis$XAxisPosition;
    //   233: getstatic com/github/mikephil/charting/components/XAxis$XAxisPosition.c : Lcom/github/mikephil/charting/components/XAxis$XAxisPosition;
    //   236: if_acmpne -> 248
    //   239: fload #4
    //   241: fload #7
    //   243: fadd
    //   244: fstore_1
    //   245: goto -> 209
    //   248: fload #5
    //   250: aload_0
    //   251: invokevirtual getExtraTopOffset : ()F
    //   254: fadd
    //   255: fstore #4
    //   257: fload_3
    //   258: aload_0
    //   259: invokevirtual getExtraRightOffset : ()F
    //   262: fadd
    //   263: fstore_3
    //   264: fload_1
    //   265: aload_0
    //   266: invokevirtual getExtraBottomOffset : ()F
    //   269: fadd
    //   270: fstore_1
    //   271: fload_2
    //   272: aload_0
    //   273: invokevirtual getExtraLeftOffset : ()F
    //   276: fadd
    //   277: fstore_2
    //   278: aload_0
    //   279: getfield l : F
    //   282: invokestatic a : (F)F
    //   285: fstore #5
    //   287: aload_0
    //   288: getfield Q : Lcom/github/mikephil/charting/utils/ViewPortHandler;
    //   291: fload #5
    //   293: fload_2
    //   294: invokestatic max : (FF)F
    //   297: fload #5
    //   299: fload #4
    //   301: invokestatic max : (FF)F
    //   304: fload #5
    //   306: fload_3
    //   307: invokestatic max : (FF)F
    //   310: fload #5
    //   312: fload_1
    //   313: invokestatic max : (FF)F
    //   316: invokevirtual a : (FFFF)V
    //   319: aload_0
    //   320: getfield B : Z
    //   323: ifeq -> 458
    //   326: new java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial <init> : ()V
    //   333: astore #8
    //   335: aload #8
    //   337: ldc_w 'offsetLeft: '
    //   340: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload #8
    //   346: fload_2
    //   347: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload #8
    //   353: ldc_w ', offsetTop: '
    //   356: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload #8
    //   362: fload #4
    //   364: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload #8
    //   370: ldc_w ', offsetRight: '
    //   373: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload #8
    //   379: fload_3
    //   380: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload #8
    //   386: ldc_w ', offsetBottom: '
    //   389: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload #8
    //   395: fload_1
    //   396: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: ldc_w 'MPAndroidChart'
    //   403: aload #8
    //   405: invokevirtual toString : ()Ljava/lang/String;
    //   408: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   411: pop
    //   412: new java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial <init> : ()V
    //   419: astore #8
    //   421: aload #8
    //   423: ldc_w 'Content: '
    //   426: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload #8
    //   432: aload_0
    //   433: getfield Q : Lcom/github/mikephil/charting/utils/ViewPortHandler;
    //   436: invokevirtual k : ()Landroid/graphics/RectF;
    //   439: invokevirtual toString : ()Ljava/lang/String;
    //   442: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: ldc_w 'MPAndroidChart'
    //   449: aload #8
    //   451: invokevirtual toString : ()Ljava/lang/String;
    //   454: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   457: pop
    //   458: aload_0
    //   459: invokevirtual g : ()V
    //   462: aload_0
    //   463: invokevirtual f : ()V
    //   466: return
  }
  
  public boolean k() {
    return this.f;
  }
  
  public boolean l() {
    return (this.a || this.aa);
  }
  
  public boolean m() {
    return this.a;
  }
  
  public boolean n() {
    return this.aa;
  }
  
  public boolean o() {
    return this.ab;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    if (this.C == null)
      return; 
    long l = System.currentTimeMillis();
    a(paramCanvas);
    if (this.c)
      i(); 
    if (this.o.z())
      this.q.a(this.o.u, this.o.t, this.o.G()); 
    if (this.p.z())
      this.r.a(this.p.u, this.p.t, this.p.G()); 
    if (this.H.z())
      this.u.a(this.H.u, this.H.t, false); 
    this.u.b(paramCanvas);
    this.q.b(paramCanvas);
    this.r.b(paramCanvas);
    if (this.H.o())
      this.u.c(paramCanvas); 
    if (this.o.o())
      this.q.c(paramCanvas); 
    if (this.p.o())
      this.r.c(paramCanvas); 
    if (this.H.z() && this.H.n())
      this.u.d(paramCanvas); 
    if (this.o.z() && this.o.n())
      this.q.e(paramCanvas); 
    if (this.p.z() && this.p.n())
      this.r.e(paramCanvas); 
    int i = paramCanvas.save();
    paramCanvas.clipRect(this.Q.k());
    this.O.a(paramCanvas);
    if (!this.H.o())
      this.u.c(paramCanvas); 
    if (!this.o.o())
      this.q.c(paramCanvas); 
    if (!this.p.o())
      this.r.c(paramCanvas); 
    if (x())
      this.O.a(paramCanvas, this.S); 
    paramCanvas.restoreToCount(i);
    this.O.c(paramCanvas);
    if (this.H.z() && !this.H.n())
      this.u.d(paramCanvas); 
    if (this.o.z() && !this.o.n())
      this.q.e(paramCanvas); 
    if (this.p.z() && !this.p.n())
      this.r.e(paramCanvas); 
    this.u.a(paramCanvas);
    this.q.a(paramCanvas);
    this.r.a(paramCanvas);
    if (r()) {
      i = paramCanvas.save();
      paramCanvas.clipRect(this.Q.k());
      this.O.b(paramCanvas);
      paramCanvas.restoreToCount(i);
    } else {
      this.O.b(paramCanvas);
    } 
    this.N.a(paramCanvas);
    b(paramCanvas);
    c(paramCanvas);
    if (this.B) {
      l = System.currentTimeMillis() - l;
      this.ad += l;
      this.ae++;
      long l1 = this.ad / this.ae;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Drawtime: ");
      stringBuilder.append(l);
      stringBuilder.append(" ms, average: ");
      stringBuilder.append(l1);
      stringBuilder.append(" ms, cycles: ");
      stringBuilder.append(this.ae);
      Log.i("MPAndroidChart", stringBuilder.toString());
    } 
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    float[] arrayOfFloat = this.A;
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[0] = 0.0F;
    if (this.m) {
      arrayOfFloat[0] = this.Q.f();
      this.A[1] = this.Q.e();
      a(YAxis.AxisDependency.a).b(this.A);
    } 
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.m) {
      a(YAxis.AxisDependency.a).a(this.A);
      this.Q.a(this.A, (View)this);
      return;
    } 
    this.Q.a(this.Q.p(), (View)this, true);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    super.onTouchEvent(paramMotionEvent);
    return (this.M != null) ? ((this.C == null) ? false : (!this.I ? false : this.M.onTouch((View)this, paramMotionEvent))) : false;
  }
  
  public boolean p() {
    return this.ac;
  }
  
  public boolean q() {
    return this.e;
  }
  
  public boolean r() {
    return this.k;
  }
  
  public boolean s() {
    return this.Q.s();
  }
  
  public void setAutoScaleMinMaxEnabled(boolean paramBoolean) {
    this.c = paramBoolean;
  }
  
  public void setBorderColor(int paramInt) {
    this.h.setColor(paramInt);
  }
  
  public void setBorderWidth(float paramFloat) {
    this.h.setStrokeWidth(Utils.a(paramFloat));
  }
  
  public void setClipValuesToContent(boolean paramBoolean) {
    this.k = paramBoolean;
  }
  
  public void setDoubleTapToZoomEnabled(boolean paramBoolean) {
    this.e = paramBoolean;
  }
  
  public void setDragEnabled(boolean paramBoolean) {
    this.a = paramBoolean;
    this.aa = paramBoolean;
  }
  
  public void setDragOffsetX(float paramFloat) {
    this.Q.k(paramFloat);
  }
  
  public void setDragOffsetY(float paramFloat) {
    this.Q.l(paramFloat);
  }
  
  public void setDragXEnabled(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  public void setDragYEnabled(boolean paramBoolean) {
    this.aa = paramBoolean;
  }
  
  public void setDrawBorders(boolean paramBoolean) {
    this.j = paramBoolean;
  }
  
  public void setDrawGridBackground(boolean paramBoolean) {
    this.i = paramBoolean;
  }
  
  public void setGridBackgroundColor(int paramInt) {
    this.g.setColor(paramInt);
  }
  
  public void setHighlightPerDragEnabled(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  public void setKeepPositionOnRotation(boolean paramBoolean) {
    this.m = paramBoolean;
  }
  
  public void setMaxVisibleValueCount(int paramInt) {
    this.b = paramInt;
  }
  
  public void setMinOffset(float paramFloat) {
    this.l = paramFloat;
  }
  
  public void setOnDrawListener(OnDrawListener paramOnDrawListener) {
    this.n = paramOnDrawListener;
  }
  
  public void setPinchZoom(boolean paramBoolean) {
    this.d = paramBoolean;
  }
  
  public void setRendererLeftYAxis(YAxisRenderer paramYAxisRenderer) {
    this.q = paramYAxisRenderer;
  }
  
  public void setRendererRightYAxis(YAxisRenderer paramYAxisRenderer) {
    this.r = paramYAxisRenderer;
  }
  
  public void setScaleEnabled(boolean paramBoolean) {
    this.ab = paramBoolean;
    this.ac = paramBoolean;
  }
  
  public void setScaleXEnabled(boolean paramBoolean) {
    this.ab = paramBoolean;
  }
  
  public void setScaleYEnabled(boolean paramBoolean) {
    this.ac = paramBoolean;
  }
  
  public void setVisibleXRangeMaximum(float paramFloat) {
    paramFloat = this.H.v / paramFloat;
    this.Q.a(paramFloat);
  }
  
  public void setVisibleXRangeMinimum(float paramFloat) {
    paramFloat = this.H.v / paramFloat;
    this.Q.b(paramFloat);
  }
  
  public void setXAxisRenderer(XAxisRenderer paramXAxisRenderer) {
    this.u = paramXAxisRenderer;
  }
  
  public boolean t() {
    return this.d;
  }
  
  public boolean u() {
    return this.Q.v();
  }
  
  public boolean v() {
    return this.o.G() ? true : (this.p.G());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\charts\BarLineChartBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */