package com.github.mikephil.charting.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;

public abstract class Utils {
  public static final double a = Double.longBitsToDouble(1L);
  
  public static final float b = Float.intBitsToFloat(1);
  
  private static DisplayMetrics c;
  
  private static int d = 50;
  
  private static int e = 8000;
  
  private static Rect f = new Rect();
  
  private static Paint.FontMetrics g = new Paint.FontMetrics();
  
  private static Rect h = new Rect();
  
  private static final int[] i = new int[] { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };
  
  private static ValueFormatter j = e();
  
  private static Rect k = new Rect();
  
  private static Rect l = new Rect();
  
  private static Paint.FontMetrics m = new Paint.FontMetrics();
  
  public static float a(double paramDouble) {
    double d;
    if (Double.isInfinite(paramDouble) || Double.isNaN(paramDouble) || paramDouble == 0.0D)
      return 0.0F; 
    if (paramDouble < 0.0D) {
      d = -paramDouble;
    } else {
      d = paramDouble;
    } 
    float f = (float)Math.pow(10.0D, (1 - (int)(float)Math.ceil((float)Math.log10(d))));
    return (float)Math.round(paramDouble * f) / f;
  }
  
  public static float a(float paramFloat) {
    DisplayMetrics displayMetrics = c;
    if (displayMetrics == null) {
      Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertDpToPixel(...). Otherwise conversion does not take place.");
      return paramFloat;
    } 
    return paramFloat * displayMetrics.density;
  }
  
  public static float a(Paint paramPaint) {
    return a(paramPaint, g);
  }
  
  public static float a(Paint paramPaint, Paint.FontMetrics paramFontMetrics) {
    paramPaint.getFontMetrics(paramFontMetrics);
    return paramFontMetrics.descent - paramFontMetrics.ascent;
  }
  
  public static int a(Paint paramPaint, String paramString) {
    return (int)paramPaint.measureText(paramString);
  }
  
  public static ValueFormatter a() {
    return j;
  }
  
  public static FSize a(float paramFloat1, float paramFloat2, float paramFloat3) {
    return b(paramFloat1, paramFloat2, paramFloat3 * 0.017453292F);
  }
  
  public static void a(Context paramContext) {
    if (paramContext == null) {
      d = ViewConfiguration.getMinimumFlingVelocity();
      e = ViewConfiguration.getMaximumFlingVelocity();
      Log.e("MPChartLib-Utils", "Utils.init(...) PROVIDED CONTEXT OBJECT IS NULL");
      return;
    } 
    ViewConfiguration viewConfiguration = ViewConfiguration.get(paramContext);
    d = viewConfiguration.getScaledMinimumFlingVelocity();
    e = viewConfiguration.getScaledMaximumFlingVelocity();
    c = paramContext.getResources().getDisplayMetrics();
  }
  
  public static void a(Canvas paramCanvas, Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    MPPointF mPPointF = MPPointF.a();
    mPPointF.a = (paramInt1 - paramInt3 / 2);
    mPPointF.b = (paramInt2 - paramInt4 / 2);
    paramDrawable.copyBounds(k);
    paramDrawable.setBounds(k.left, k.top, k.left + paramInt3, k.top + paramInt3);
    paramInt1 = paramCanvas.save();
    paramCanvas.translate(mPPointF.a, mPPointF.b);
    paramDrawable.draw(paramCanvas);
    paramCanvas.restoreToCount(paramInt1);
  }
  
  public static void a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, Paint paramPaint, MPPointF paramMPPointF, float paramFloat3) {
    // Byte code:
    //   0: aload #4
    //   2: getstatic com/github/mikephil/charting/utils/Utils.m : Landroid/graphics/Paint$FontMetrics;
    //   5: invokevirtual getFontMetrics : (Landroid/graphics/Paint$FontMetrics;)F
    //   8: fstore #11
    //   10: aload #4
    //   12: aload_1
    //   13: iconst_0
    //   14: aload_1
    //   15: invokevirtual length : ()I
    //   18: getstatic com/github/mikephil/charting/utils/Utils.l : Landroid/graphics/Rect;
    //   21: invokevirtual getTextBounds : (Ljava/lang/String;IILandroid/graphics/Rect;)V
    //   24: fconst_0
    //   25: getstatic com/github/mikephil/charting/utils/Utils.l : Landroid/graphics/Rect;
    //   28: getfield left : I
    //   31: i2f
    //   32: fsub
    //   33: fstore #10
    //   35: getstatic com/github/mikephil/charting/utils/Utils.m : Landroid/graphics/Paint$FontMetrics;
    //   38: getfield ascent : F
    //   41: fneg
    //   42: fconst_0
    //   43: fadd
    //   44: fstore #9
    //   46: aload #4
    //   48: invokevirtual getTextAlign : ()Landroid/graphics/Paint$Align;
    //   51: astore #13
    //   53: aload #4
    //   55: getstatic android/graphics/Paint$Align.LEFT : Landroid/graphics/Paint$Align;
    //   58: invokevirtual setTextAlign : (Landroid/graphics/Paint$Align;)V
    //   61: fload #6
    //   63: fconst_0
    //   64: fcmpl
    //   65: ifeq -> 217
    //   68: getstatic com/github/mikephil/charting/utils/Utils.l : Landroid/graphics/Rect;
    //   71: invokevirtual width : ()I
    //   74: i2f
    //   75: fstore #12
    //   77: aload #5
    //   79: getfield a : F
    //   82: ldc_w 0.5
    //   85: fcmpl
    //   86: ifne -> 107
    //   89: fload_2
    //   90: fstore #8
    //   92: fload_3
    //   93: fstore #7
    //   95: aload #5
    //   97: getfield b : F
    //   100: ldc_w 0.5
    //   103: fcmpl
    //   104: ifeq -> 166
    //   107: getstatic com/github/mikephil/charting/utils/Utils.l : Landroid/graphics/Rect;
    //   110: invokevirtual width : ()I
    //   113: i2f
    //   114: fload #11
    //   116: fload #6
    //   118: invokestatic a : (FFF)Lcom/github/mikephil/charting/utils/FSize;
    //   121: astore #14
    //   123: fload_2
    //   124: aload #14
    //   126: getfield a : F
    //   129: aload #5
    //   131: getfield a : F
    //   134: ldc_w 0.5
    //   137: fsub
    //   138: fmul
    //   139: fsub
    //   140: fstore #8
    //   142: fload_3
    //   143: aload #14
    //   145: getfield b : F
    //   148: aload #5
    //   150: getfield b : F
    //   153: ldc_w 0.5
    //   156: fsub
    //   157: fmul
    //   158: fsub
    //   159: fstore #7
    //   161: aload #14
    //   163: invokestatic a : (Lcom/github/mikephil/charting/utils/FSize;)V
    //   166: aload_0
    //   167: invokevirtual save : ()I
    //   170: pop
    //   171: aload_0
    //   172: fload #8
    //   174: fload #7
    //   176: invokevirtual translate : (FF)V
    //   179: aload_0
    //   180: fload #6
    //   182: invokevirtual rotate : (F)V
    //   185: aload_0
    //   186: aload_1
    //   187: fload #10
    //   189: fload #12
    //   191: ldc_w 0.5
    //   194: fmul
    //   195: fsub
    //   196: fload #9
    //   198: fload #11
    //   200: ldc_w 0.5
    //   203: fmul
    //   204: fsub
    //   205: aload #4
    //   207: invokevirtual drawText : (Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   210: aload_0
    //   211: invokevirtual restore : ()V
    //   214: goto -> 291
    //   217: aload #5
    //   219: getfield a : F
    //   222: fconst_0
    //   223: fcmpl
    //   224: ifne -> 245
    //   227: fload #10
    //   229: fstore #7
    //   231: fload #9
    //   233: fstore #6
    //   235: aload #5
    //   237: getfield b : F
    //   240: fconst_0
    //   241: fcmpl
    //   242: ifeq -> 276
    //   245: fload #10
    //   247: getstatic com/github/mikephil/charting/utils/Utils.l : Landroid/graphics/Rect;
    //   250: invokevirtual width : ()I
    //   253: i2f
    //   254: aload #5
    //   256: getfield a : F
    //   259: fmul
    //   260: fsub
    //   261: fstore #7
    //   263: fload #9
    //   265: fload #11
    //   267: aload #5
    //   269: getfield b : F
    //   272: fmul
    //   273: fsub
    //   274: fstore #6
    //   276: aload_0
    //   277: aload_1
    //   278: fload #7
    //   280: fload_2
    //   281: fadd
    //   282: fload #6
    //   284: fload_3
    //   285: fadd
    //   286: aload #4
    //   288: invokevirtual drawText : (Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   291: aload #4
    //   293: aload #13
    //   295: invokevirtual setTextAlign : (Landroid/graphics/Paint$Align;)V
    //   298: return
  }
  
  public static void a(Paint paramPaint, String paramString, FSize paramFSize) {
    Rect rect = h;
    rect.set(0, 0, 0, 0);
    paramPaint.getTextBounds(paramString, 0, paramString.length(), rect);
    paramFSize.a = rect.width();
    paramFSize.b = rect.height();
  }
  
  public static void a(MotionEvent paramMotionEvent, VelocityTracker paramVelocityTracker) {
    paramVelocityTracker.computeCurrentVelocity(1000, e);
    int j = paramMotionEvent.getActionIndex();
    int i = paramMotionEvent.getPointerId(j);
    float f1 = paramVelocityTracker.getXVelocity(i);
    float f2 = paramVelocityTracker.getYVelocity(i);
    int k = paramMotionEvent.getPointerCount();
    for (i = 0; i < k; i++) {
      if (i != j) {
        int m = paramMotionEvent.getPointerId(i);
        if (paramVelocityTracker.getXVelocity(m) * f1 + paramVelocityTracker.getYVelocity(m) * f2 < 0.0F) {
          paramVelocityTracker.clear();
          return;
        } 
      } 
    } 
  }
  
  public static void a(View paramView) {
    if (Build.VERSION.SDK_INT >= 16) {
      paramView.postInvalidateOnAnimation();
      return;
    } 
    paramView.postInvalidateDelayed(10L);
  }
  
  public static void a(MPPointF paramMPPointF1, float paramFloat1, float paramFloat2, MPPointF paramMPPointF2) {
    double d1 = paramMPPointF1.a;
    double d2 = paramFloat1;
    double d3 = paramFloat2;
    paramMPPointF2.a = (float)(d1 + Math.cos(Math.toRadians(d3)) * d2);
    paramMPPointF2.b = (float)(paramMPPointF1.b + d2 * Math.sin(Math.toRadians(d3)));
  }
  
  public static double b(double paramDouble) {
    long l1;
    if (paramDouble == Double.POSITIVE_INFINITY)
      return paramDouble; 
    paramDouble += 0.0D;
    long l2 = Double.doubleToRawLongBits(paramDouble);
    if (paramDouble >= 0.0D) {
      l1 = 1L;
    } else {
      l1 = -1L;
    } 
    return Double.longBitsToDouble(l2 + l1);
  }
  
  public static float b(Paint paramPaint) {
    return b(paramPaint, g);
  }
  
  public static float b(Paint paramPaint, Paint.FontMetrics paramFontMetrics) {
    paramPaint.getFontMetrics(paramFontMetrics);
    return paramFontMetrics.ascent - paramFontMetrics.top + paramFontMetrics.bottom;
  }
  
  public static int b() {
    return d;
  }
  
  public static int b(float paramFloat) {
    paramFloat = a(paramFloat);
    return Float.isInfinite(paramFloat) ? 0 : ((int)Math.ceil(-Math.log10(paramFloat)) + 2);
  }
  
  public static int b(Paint paramPaint, String paramString) {
    Rect rect = f;
    rect.set(0, 0, 0, 0);
    paramPaint.getTextBounds(paramString, 0, paramString.length(), rect);
    return rect.height();
  }
  
  public static FSize b(float paramFloat1, float paramFloat2, float paramFloat3) {
    double d = paramFloat3;
    return FSize.a(Math.abs((float)Math.cos(d) * paramFloat1) + Math.abs((float)Math.sin(d) * paramFloat2), Math.abs(paramFloat1 * (float)Math.sin(d)) + Math.abs(paramFloat2 * (float)Math.cos(d)));
  }
  
  public static float c(float paramFloat) {
    while (paramFloat < 0.0F)
      paramFloat += 360.0F; 
    return paramFloat % 360.0F;
  }
  
  public static int c() {
    return e;
  }
  
  public static FSize c(Paint paramPaint, String paramString) {
    FSize fSize = FSize.a(0.0F, 0.0F);
    a(paramPaint, paramString, fSize);
    return fSize;
  }
  
  public static int d() {
    return Build.VERSION.SDK_INT;
  }
  
  private static ValueFormatter e() {
    return (ValueFormatter)new DefaultValueFormatter(1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\chartin\\utils\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */