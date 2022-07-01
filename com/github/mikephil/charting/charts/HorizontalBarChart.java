package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.HorizontalBarHighlighter;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.HorizontalBarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.renderer.YAxisRenderer;
import com.github.mikephil.charting.renderer.YAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.utils.HorizontalViewPortHandler;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.TransformerHorizontalBarChart;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class HorizontalBarChart extends BarChart {
  protected float[] aa = new float[2];
  
  private RectF ab = new RectF();
  
  public HorizontalBarChart(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public HorizontalBarChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public Highlight a(float paramFloat1, float paramFloat2) {
    if (this.C == null) {
      if (this.B)
        Log.e("MPAndroidChart", "Can't select by touch. No data set."); 
      return null;
    } 
    return getHighlighter().a(paramFloat2, paramFloat1);
  }
  
  protected void a() {
    this.Q = (ViewPortHandler)new HorizontalViewPortHandler();
    super.a();
    this.s = (Transformer)new TransformerHorizontalBarChart(this.Q);
    this.t = (Transformer)new TransformerHorizontalBarChart(this.Q);
    this.O = (DataRenderer)new HorizontalBarChartRenderer(this, this.R, this.Q);
    setHighlighter((ChartHighlighter)new HorizontalBarHighlighter(this));
    this.q = (YAxisRenderer)new YAxisRendererHorizontalBarChart(this.Q, this.o, this.s);
    this.r = (YAxisRenderer)new YAxisRendererHorizontalBarChart(this.Q, this.p, this.t);
    this.u = (XAxisRenderer)new XAxisRendererHorizontalBarChart(this.Q, this.H, this.s, this);
  }
  
  protected float[] a(Highlight paramHighlight) {
    return new float[] { paramHighlight.j(), paramHighlight.i() };
  }
  
  protected void f() {
    this.t.a(this.p.u, this.p.v, this.H.v, this.H.u);
    this.s.a(this.o.u, this.o.v, this.H.v, this.H.u);
  }
  
  public float getHighestVisibleX() {
    a(YAxis.AxisDependency.a).a(this.Q.f(), this.Q.e(), this.z);
    return (float)Math.min(this.H.t, this.z.b);
  }
  
  public float getLowestVisibleX() {
    a(YAxis.AxisDependency.a).a(this.Q.f(), this.Q.h(), this.y);
    return (float)Math.max(this.H.u, this.y.b);
  }
  
  public void j() {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield ab : Landroid/graphics/RectF;
    //   5: invokevirtual a : (Landroid/graphics/RectF;)V
    //   8: aload_0
    //   9: getfield ab : Landroid/graphics/RectF;
    //   12: getfield left : F
    //   15: fconst_0
    //   16: fadd
    //   17: fstore #4
    //   19: aload_0
    //   20: getfield ab : Landroid/graphics/RectF;
    //   23: getfield top : F
    //   26: fconst_0
    //   27: fadd
    //   28: fstore_3
    //   29: aload_0
    //   30: getfield ab : Landroid/graphics/RectF;
    //   33: getfield right : F
    //   36: fconst_0
    //   37: fadd
    //   38: fstore #6
    //   40: aload_0
    //   41: getfield ab : Landroid/graphics/RectF;
    //   44: getfield bottom : F
    //   47: fconst_0
    //   48: fadd
    //   49: fstore_1
    //   50: fload_3
    //   51: fstore_2
    //   52: aload_0
    //   53: getfield o : Lcom/github/mikephil/charting/components/YAxis;
    //   56: invokevirtual M : ()Z
    //   59: ifeq -> 79
    //   62: fload_3
    //   63: aload_0
    //   64: getfield o : Lcom/github/mikephil/charting/components/YAxis;
    //   67: aload_0
    //   68: getfield q : Lcom/github/mikephil/charting/renderer/YAxisRenderer;
    //   71: invokevirtual a : ()Landroid/graphics/Paint;
    //   74: invokevirtual b : (Landroid/graphics/Paint;)F
    //   77: fadd
    //   78: fstore_2
    //   79: fload_1
    //   80: fstore_3
    //   81: aload_0
    //   82: getfield p : Lcom/github/mikephil/charting/components/YAxis;
    //   85: invokevirtual M : ()Z
    //   88: ifeq -> 108
    //   91: fload_1
    //   92: aload_0
    //   93: getfield p : Lcom/github/mikephil/charting/components/YAxis;
    //   96: aload_0
    //   97: getfield r : Lcom/github/mikephil/charting/renderer/YAxisRenderer;
    //   100: invokevirtual a : ()Landroid/graphics/Paint;
    //   103: invokevirtual b : (Landroid/graphics/Paint;)F
    //   106: fadd
    //   107: fstore_3
    //   108: aload_0
    //   109: getfield H : Lcom/github/mikephil/charting/components/XAxis;
    //   112: getfield E : I
    //   115: i2f
    //   116: fstore #7
    //   118: fload #4
    //   120: fstore_1
    //   121: fload #6
    //   123: fstore #5
    //   125: aload_0
    //   126: getfield H : Lcom/github/mikephil/charting/components/XAxis;
    //   129: invokevirtual z : ()Z
    //   132: ifeq -> 216
    //   135: aload_0
    //   136: getfield H : Lcom/github/mikephil/charting/components/XAxis;
    //   139: invokevirtual A : ()Lcom/github/mikephil/charting/components/XAxis$XAxisPosition;
    //   142: getstatic com/github/mikephil/charting/components/XAxis$XAxisPosition.b : Lcom/github/mikephil/charting/components/XAxis$XAxisPosition;
    //   145: if_acmpne -> 161
    //   148: fload #4
    //   150: fload #7
    //   152: fadd
    //   153: fstore_1
    //   154: fload #6
    //   156: fstore #5
    //   158: goto -> 216
    //   161: aload_0
    //   162: getfield H : Lcom/github/mikephil/charting/components/XAxis;
    //   165: invokevirtual A : ()Lcom/github/mikephil/charting/components/XAxis$XAxisPosition;
    //   168: getstatic com/github/mikephil/charting/components/XAxis$XAxisPosition.a : Lcom/github/mikephil/charting/components/XAxis$XAxisPosition;
    //   171: if_acmpne -> 187
    //   174: fload #4
    //   176: fstore_1
    //   177: fload #6
    //   179: fload #7
    //   181: fadd
    //   182: fstore #5
    //   184: goto -> 216
    //   187: fload #4
    //   189: fstore_1
    //   190: fload #6
    //   192: fstore #5
    //   194: aload_0
    //   195: getfield H : Lcom/github/mikephil/charting/components/XAxis;
    //   198: invokevirtual A : ()Lcom/github/mikephil/charting/components/XAxis$XAxisPosition;
    //   201: getstatic com/github/mikephil/charting/components/XAxis$XAxisPosition.c : Lcom/github/mikephil/charting/components/XAxis$XAxisPosition;
    //   204: if_acmpne -> 216
    //   207: fload #4
    //   209: fload #7
    //   211: fadd
    //   212: fstore_1
    //   213: goto -> 177
    //   216: fload_2
    //   217: aload_0
    //   218: invokevirtual getExtraTopOffset : ()F
    //   221: fadd
    //   222: fstore_2
    //   223: fload #5
    //   225: aload_0
    //   226: invokevirtual getExtraRightOffset : ()F
    //   229: fadd
    //   230: fstore #4
    //   232: fload_3
    //   233: aload_0
    //   234: invokevirtual getExtraBottomOffset : ()F
    //   237: fadd
    //   238: fstore_3
    //   239: fload_1
    //   240: aload_0
    //   241: invokevirtual getExtraLeftOffset : ()F
    //   244: fadd
    //   245: fstore_1
    //   246: aload_0
    //   247: getfield l : F
    //   250: invokestatic a : (F)F
    //   253: fstore #5
    //   255: aload_0
    //   256: getfield Q : Lcom/github/mikephil/charting/utils/ViewPortHandler;
    //   259: fload #5
    //   261: fload_1
    //   262: invokestatic max : (FF)F
    //   265: fload #5
    //   267: fload_2
    //   268: invokestatic max : (FF)F
    //   271: fload #5
    //   273: fload #4
    //   275: invokestatic max : (FF)F
    //   278: fload #5
    //   280: fload_3
    //   281: invokestatic max : (FF)F
    //   284: invokevirtual a : (FFFF)V
    //   287: aload_0
    //   288: getfield B : Z
    //   291: ifeq -> 424
    //   294: new java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial <init> : ()V
    //   301: astore #8
    //   303: aload #8
    //   305: ldc_w 'offsetLeft: '
    //   308: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload #8
    //   314: fload_1
    //   315: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload #8
    //   321: ldc_w ', offsetTop: '
    //   324: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload #8
    //   330: fload_2
    //   331: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload #8
    //   337: ldc_w ', offsetRight: '
    //   340: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload #8
    //   346: fload #4
    //   348: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload #8
    //   354: ldc_w ', offsetBottom: '
    //   357: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: aload #8
    //   363: fload_3
    //   364: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: ldc 'MPAndroidChart'
    //   370: aload #8
    //   372: invokevirtual toString : ()Ljava/lang/String;
    //   375: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   378: pop
    //   379: new java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial <init> : ()V
    //   386: astore #8
    //   388: aload #8
    //   390: ldc_w 'Content: '
    //   393: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload #8
    //   399: aload_0
    //   400: getfield Q : Lcom/github/mikephil/charting/utils/ViewPortHandler;
    //   403: invokevirtual k : ()Landroid/graphics/RectF;
    //   406: invokevirtual toString : ()Ljava/lang/String;
    //   409: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: ldc 'MPAndroidChart'
    //   415: aload #8
    //   417: invokevirtual toString : ()Ljava/lang/String;
    //   420: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   423: pop
    //   424: aload_0
    //   425: invokevirtual g : ()V
    //   428: aload_0
    //   429: invokevirtual f : ()V
    //   432: return
  }
  
  public void setVisibleXRangeMaximum(float paramFloat) {
    paramFloat = this.H.v / paramFloat;
    this.Q.c(paramFloat);
  }
  
  public void setVisibleXRangeMinimum(float paramFloat) {
    paramFloat = this.H.v / paramFloat;
    this.Q.d(paramFloat);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\charts\HorizontalBarChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */