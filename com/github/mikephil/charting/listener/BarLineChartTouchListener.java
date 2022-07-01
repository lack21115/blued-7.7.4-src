package com.github.mikephil.charting.listener;

import android.graphics.Matrix;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class BarLineChartTouchListener extends ChartTouchListener<BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>>> {
  private Matrix f = new Matrix();
  
  private Matrix g = new Matrix();
  
  private MPPointF h = MPPointF.a(0.0F, 0.0F);
  
  private MPPointF i = MPPointF.a(0.0F, 0.0F);
  
  private float j = 1.0F;
  
  private float k = 1.0F;
  
  private float l = 1.0F;
  
  private IDataSet m;
  
  private VelocityTracker n;
  
  private long o = 0L;
  
  private MPPointF p = MPPointF.a(0.0F, 0.0F);
  
  private MPPointF q = MPPointF.a(0.0F, 0.0F);
  
  private float r;
  
  private float s;
  
  public BarLineChartTouchListener(BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>> paramBarLineChartBase, Matrix paramMatrix, float paramFloat) {
    super(paramBarLineChartBase);
    this.f = paramMatrix;
    this.r = Utils.a(paramFloat);
    this.s = Utils.a(3.5F);
  }
  
  private void a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2) {
    this.a = ChartTouchListener.ChartGesture.b;
    this.f.set(this.g);
    OnChartGestureListener onChartGestureListener = this.e.getOnChartGestureListener();
    float f1 = paramFloat1;
    float f2 = paramFloat2;
    if (c())
      if (this.e instanceof com.github.mikephil.charting.charts.HorizontalBarChart) {
        f1 = -paramFloat1;
        f2 = paramFloat2;
      } else {
        f2 = -paramFloat2;
        f1 = paramFloat1;
      }  
    this.f.postTranslate(f1, f2);
    if (onChartGestureListener != null)
      onChartGestureListener.b(paramMotionEvent, f1, f2); 
  }
  
  private static void a(MPPointF paramMPPointF, MotionEvent paramMotionEvent) {
    float f1 = paramMotionEvent.getX(0);
    float f2 = paramMotionEvent.getX(1);
    float f3 = paramMotionEvent.getY(0);
    float f4 = paramMotionEvent.getY(1);
    paramMPPointF.a = (f1 + f2) / 2.0F;
    paramMPPointF.b = (f3 + f4) / 2.0F;
  }
  
  private void c(MotionEvent paramMotionEvent) {
    this.g.set(this.f);
    this.h.a = paramMotionEvent.getX();
    this.h.b = paramMotionEvent.getY();
    this.m = (IDataSet)this.e.b(paramMotionEvent.getX(), paramMotionEvent.getY());
  }
  
  private boolean c() {
    return ((this.m == null && this.e.v()) || (this.m != null && this.e.c(this.m.C())));
  }
  
  private void d(MotionEvent paramMotionEvent) {
    if (paramMotionEvent.getPointerCount() >= 2) {
      OnChartGestureListener onChartGestureListener = this.e.getOnChartGestureListener();
      float f = f(paramMotionEvent);
      if (f > this.s) {
        MPPointF mPPointF = a(this.i.a, this.i.b);
        ViewPortHandler viewPortHandler = this.e.getViewPortHandler();
        int i = this.b;
        boolean bool2 = true;
        boolean bool3 = true;
        boolean bool1 = true;
        if (i == 4) {
          float f1;
          boolean bool4;
          boolean bool5;
          this.a = ChartTouchListener.ChartGesture.e;
          f /= this.l;
          if (f >= 1.0F)
            bool1 = false; 
          if (bool1) {
            bool4 = viewPortHandler.w();
          } else {
            bool4 = viewPortHandler.x();
          } 
          if (bool1) {
            bool5 = viewPortHandler.y();
          } else {
            bool5 = viewPortHandler.z();
          } 
          if (this.e.o()) {
            f1 = f;
          } else {
            f1 = 1.0F;
          } 
          if (!this.e.p())
            f = 1.0F; 
          if (bool5 || bool4) {
            this.f.set(this.g);
            this.f.postScale(f1, f, mPPointF.a, mPPointF.b);
            if (onChartGestureListener != null)
              onChartGestureListener.a(paramMotionEvent, f1, f); 
          } 
        } else if (this.b == 2 && this.e.o()) {
          boolean bool;
          this.a = ChartTouchListener.ChartGesture.c;
          f = g(paramMotionEvent) / this.j;
          if (f < 1.0F) {
            bool1 = bool2;
          } else {
            bool1 = false;
          } 
          if (bool1) {
            bool = viewPortHandler.w();
          } else {
            bool = viewPortHandler.x();
          } 
          if (bool) {
            this.f.set(this.g);
            this.f.postScale(f, 1.0F, mPPointF.a, mPPointF.b);
            if (onChartGestureListener != null)
              onChartGestureListener.a(paramMotionEvent, f, 1.0F); 
          } 
        } else if (this.b == 3 && this.e.p()) {
          boolean bool;
          this.a = ChartTouchListener.ChartGesture.d;
          f = h(paramMotionEvent) / this.k;
          if (f < 1.0F) {
            bool1 = bool3;
          } else {
            bool1 = false;
          } 
          if (bool1) {
            bool = viewPortHandler.y();
          } else {
            bool = viewPortHandler.z();
          } 
          if (bool) {
            this.f.set(this.g);
            this.f.postScale(1.0F, f, mPPointF.a, mPPointF.b);
            if (onChartGestureListener != null)
              onChartGestureListener.a(paramMotionEvent, 1.0F, f); 
          } 
        } 
        MPPointF.b(mPPointF);
      } 
    } 
  }
  
  private void e(MotionEvent paramMotionEvent) {
    Highlight highlight = this.e.a(paramMotionEvent.getX(), paramMotionEvent.getY());
    if (highlight != null && !highlight.a(this.c)) {
      this.c = highlight;
      this.e.a(highlight, true);
    } 
  }
  
  private static float f(MotionEvent paramMotionEvent) {
    float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
    return (float)Math.sqrt((f1 * f1 + f2 * f2));
  }
  
  private static float g(MotionEvent paramMotionEvent) {
    return Math.abs(paramMotionEvent.getX(0) - paramMotionEvent.getX(1));
  }
  
  private static float h(MotionEvent paramMotionEvent) {
    return Math.abs(paramMotionEvent.getY(0) - paramMotionEvent.getY(1));
  }
  
  public MPPointF a(float paramFloat1, float paramFloat2) {
    ViewPortHandler viewPortHandler = this.e.getViewPortHandler();
    float f = viewPortHandler.a();
    if (c()) {
      paramFloat2 = -(paramFloat2 - viewPortHandler.c());
    } else {
      paramFloat2 = -(this.e.getMeasuredHeight() - paramFloat2 - viewPortHandler.d());
    } 
    return MPPointF.a(paramFloat1 - f, paramFloat2);
  }
  
  public void a() {
    MPPointF mPPointF = this.q;
    mPPointF.a = 0.0F;
    mPPointF.b = 0.0F;
  }
  
  public void b() {
    float f1 = this.q.a;
    float f2 = 0.0F;
    if (f1 == 0.0F && this.q.b == 0.0F)
      return; 
    long l = AnimationUtils.currentAnimationTimeMillis();
    MPPointF mPPointF = this.q;
    mPPointF.a *= this.e.getDragDecelerationFrictionCoef();
    mPPointF = this.q;
    mPPointF.b *= this.e.getDragDecelerationFrictionCoef();
    f1 = (float)(l - this.o) / 1000.0F;
    float f3 = this.q.a;
    float f4 = this.q.b;
    mPPointF = this.p;
    mPPointF.a += f3 * f1;
    mPPointF = this.p;
    mPPointF.b += f4 * f1;
    MotionEvent motionEvent = MotionEvent.obtain(l, l, 2, this.p.a, this.p.b, 0);
    if (this.e.m()) {
      f1 = this.p.a - this.h.a;
    } else {
      f1 = 0.0F;
    } 
    if (this.e.n())
      f2 = this.p.b - this.h.b; 
    a(motionEvent, f1, f2);
    motionEvent.recycle();
    this.f = this.e.getViewPortHandler().a(this.f, (View)this.e, false);
    this.o = l;
    if (Math.abs(this.q.a) >= 0.01D || Math.abs(this.q.b) >= 0.01D) {
      Utils.a((View)this.e);
      return;
    } 
    this.e.j();
    this.e.postInvalidate();
    a();
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent) {
    this.a = ChartTouchListener.ChartGesture.h;
    OnChartGestureListener onChartGestureListener = this.e.getOnChartGestureListener();
    if (onChartGestureListener != null)
      onChartGestureListener.b(paramMotionEvent); 
    if (this.e.q() && ((BarLineScatterCandleBubbleData)this.e.getData()).j() > 0) {
      float f1;
      MPPointF mPPointF = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>> barLineChartBase = this.e;
      boolean bool = this.e.o();
      float f2 = 1.4F;
      if (bool) {
        f1 = 1.4F;
      } else {
        f1 = 1.0F;
      } 
      if (!this.e.p())
        f2 = 1.0F; 
      barLineChartBase.a(f1, f2, mPPointF.a, mPPointF.b);
      if (this.e.z()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Double-Tap, Zooming In, x: ");
        stringBuilder.append(mPPointF.a);
        stringBuilder.append(", y: ");
        stringBuilder.append(mPPointF.b);
        Log.i("BarlineChartTouch", stringBuilder.toString());
      } 
      MPPointF.b(mPPointF);
    } 
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
    this.a = ChartTouchListener.ChartGesture.j;
    OnChartGestureListener onChartGestureListener = this.e.getOnChartGestureListener();
    if (onChartGestureListener != null)
      onChartGestureListener.a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2); 
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {
    this.a = ChartTouchListener.ChartGesture.i;
    OnChartGestureListener onChartGestureListener = this.e.getOnChartGestureListener();
    if (onChartGestureListener != null)
      onChartGestureListener.a(paramMotionEvent); 
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent) {
    this.a = ChartTouchListener.ChartGesture.g;
    OnChartGestureListener onChartGestureListener = this.e.getOnChartGestureListener();
    if (onChartGestureListener != null)
      onChartGestureListener.c(paramMotionEvent); 
    if (!this.e.w())
      return false; 
    a(this.e.a(paramMotionEvent.getX(), paramMotionEvent.getY()), paramMotionEvent);
    return super.onSingleTapUp(paramMotionEvent);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_0
    //   1: getfield n : Landroid/view/VelocityTracker;
    //   4: ifnonnull -> 14
    //   7: aload_0
    //   8: invokestatic obtain : ()Landroid/view/VelocityTracker;
    //   11: putfield n : Landroid/view/VelocityTracker;
    //   14: aload_0
    //   15: getfield n : Landroid/view/VelocityTracker;
    //   18: aload_2
    //   19: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   22: aload_2
    //   23: invokevirtual getActionMasked : ()I
    //   26: istore #6
    //   28: iconst_3
    //   29: istore #5
    //   31: iload #6
    //   33: iconst_3
    //   34: if_icmpne -> 55
    //   37: aload_0
    //   38: getfield n : Landroid/view/VelocityTracker;
    //   41: astore_1
    //   42: aload_1
    //   43: ifnull -> 55
    //   46: aload_1
    //   47: invokevirtual recycle : ()V
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield n : Landroid/view/VelocityTracker;
    //   55: aload_0
    //   56: getfield b : I
    //   59: ifne -> 71
    //   62: aload_0
    //   63: getfield d : Landroid/view/GestureDetector;
    //   66: aload_2
    //   67: invokevirtual onTouchEvent : (Landroid/view/MotionEvent;)Z
    //   70: pop
    //   71: aload_0
    //   72: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   75: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   78: invokevirtual l : ()Z
    //   81: ifne -> 112
    //   84: aload_0
    //   85: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   88: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   91: invokevirtual o : ()Z
    //   94: ifne -> 112
    //   97: aload_0
    //   98: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   101: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   104: invokevirtual p : ()Z
    //   107: ifne -> 112
    //   110: iconst_1
    //   111: ireturn
    //   112: aload_2
    //   113: invokevirtual getAction : ()I
    //   116: sipush #255
    //   119: iand
    //   120: istore #7
    //   122: iload #7
    //   124: ifeq -> 973
    //   127: iconst_0
    //   128: istore #6
    //   130: iload #7
    //   132: iconst_1
    //   133: if_icmpeq -> 740
    //   136: iload #7
    //   138: iconst_2
    //   139: if_icmpeq -> 352
    //   142: iload #7
    //   144: iconst_3
    //   145: if_icmpeq -> 339
    //   148: iload #7
    //   150: iconst_5
    //   151: if_icmpeq -> 180
    //   154: iload #7
    //   156: bipush #6
    //   158: if_icmpeq -> 164
    //   161: goto -> 987
    //   164: aload_2
    //   165: aload_0
    //   166: getfield n : Landroid/view/VelocityTracker;
    //   169: invokestatic a : (Landroid/view/MotionEvent;Landroid/view/VelocityTracker;)V
    //   172: aload_0
    //   173: iconst_5
    //   174: putfield b : I
    //   177: goto -> 987
    //   180: aload_2
    //   181: invokevirtual getPointerCount : ()I
    //   184: iconst_2
    //   185: if_icmplt -> 987
    //   188: aload_0
    //   189: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   192: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   195: invokevirtual A : ()V
    //   198: aload_0
    //   199: aload_2
    //   200: invokespecial c : (Landroid/view/MotionEvent;)V
    //   203: aload_0
    //   204: aload_2
    //   205: invokestatic g : (Landroid/view/MotionEvent;)F
    //   208: putfield j : F
    //   211: aload_0
    //   212: aload_2
    //   213: invokestatic h : (Landroid/view/MotionEvent;)F
    //   216: putfield k : F
    //   219: aload_0
    //   220: aload_2
    //   221: invokestatic f : (Landroid/view/MotionEvent;)F
    //   224: putfield l : F
    //   227: aload_0
    //   228: getfield l : F
    //   231: ldc_w 10.0
    //   234: fcmpl
    //   235: ifle -> 328
    //   238: aload_0
    //   239: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   242: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   245: invokevirtual t : ()Z
    //   248: ifeq -> 259
    //   251: aload_0
    //   252: iconst_4
    //   253: putfield b : I
    //   256: goto -> 328
    //   259: aload_0
    //   260: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   263: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   266: invokevirtual o : ()Z
    //   269: aload_0
    //   270: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   273: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   276: invokevirtual p : ()Z
    //   279: if_icmpeq -> 307
    //   282: aload_0
    //   283: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   286: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   289: invokevirtual o : ()Z
    //   292: ifeq -> 298
    //   295: iconst_2
    //   296: istore #5
    //   298: aload_0
    //   299: iload #5
    //   301: putfield b : I
    //   304: goto -> 328
    //   307: aload_0
    //   308: getfield j : F
    //   311: aload_0
    //   312: getfield k : F
    //   315: fcmpl
    //   316: ifle -> 322
    //   319: iconst_2
    //   320: istore #5
    //   322: aload_0
    //   323: iload #5
    //   325: putfield b : I
    //   328: aload_0
    //   329: getfield i : Lcom/github/mikephil/charting/utils/MPPointF;
    //   332: aload_2
    //   333: invokestatic a : (Lcom/github/mikephil/charting/utils/MPPointF;Landroid/view/MotionEvent;)V
    //   336: goto -> 987
    //   339: aload_0
    //   340: iconst_0
    //   341: putfield b : I
    //   344: aload_0
    //   345: aload_2
    //   346: invokevirtual b : (Landroid/view/MotionEvent;)V
    //   349: goto -> 987
    //   352: aload_0
    //   353: getfield b : I
    //   356: iconst_1
    //   357: if_icmpne -> 446
    //   360: aload_0
    //   361: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   364: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   367: invokevirtual A : ()V
    //   370: aload_0
    //   371: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   374: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   377: invokevirtual m : ()Z
    //   380: istore #8
    //   382: fconst_0
    //   383: fstore #4
    //   385: iload #8
    //   387: ifeq -> 406
    //   390: aload_2
    //   391: invokevirtual getX : ()F
    //   394: aload_0
    //   395: getfield h : Lcom/github/mikephil/charting/utils/MPPointF;
    //   398: getfield a : F
    //   401: fsub
    //   402: fstore_3
    //   403: goto -> 408
    //   406: fconst_0
    //   407: fstore_3
    //   408: aload_0
    //   409: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   412: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   415: invokevirtual n : ()Z
    //   418: ifeq -> 435
    //   421: aload_2
    //   422: invokevirtual getY : ()F
    //   425: aload_0
    //   426: getfield h : Lcom/github/mikephil/charting/utils/MPPointF;
    //   429: getfield b : F
    //   432: fsub
    //   433: fstore #4
    //   435: aload_0
    //   436: aload_2
    //   437: fload_3
    //   438: fload #4
    //   440: invokespecial a : (Landroid/view/MotionEvent;FF)V
    //   443: goto -> 987
    //   446: aload_0
    //   447: getfield b : I
    //   450: iconst_2
    //   451: if_icmpeq -> 696
    //   454: aload_0
    //   455: getfield b : I
    //   458: iconst_3
    //   459: if_icmpeq -> 696
    //   462: aload_0
    //   463: getfield b : I
    //   466: iconst_4
    //   467: if_icmpne -> 473
    //   470: goto -> 696
    //   473: aload_0
    //   474: getfield b : I
    //   477: ifne -> 987
    //   480: aload_2
    //   481: invokevirtual getX : ()F
    //   484: aload_0
    //   485: getfield h : Lcom/github/mikephil/charting/utils/MPPointF;
    //   488: getfield a : F
    //   491: aload_2
    //   492: invokevirtual getY : ()F
    //   495: aload_0
    //   496: getfield h : Lcom/github/mikephil/charting/utils/MPPointF;
    //   499: getfield b : F
    //   502: invokestatic a : (FFFF)F
    //   505: invokestatic abs : (F)F
    //   508: aload_0
    //   509: getfield r : F
    //   512: fcmpl
    //   513: ifle -> 987
    //   516: aload_0
    //   517: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   520: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   523: invokevirtual l : ()Z
    //   526: ifeq -> 987
    //   529: aload_0
    //   530: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   533: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   536: invokevirtual s : ()Z
    //   539: ifeq -> 559
    //   542: iload #6
    //   544: istore #5
    //   546: aload_0
    //   547: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   550: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   553: invokevirtual u : ()Z
    //   556: ifne -> 562
    //   559: iconst_1
    //   560: istore #5
    //   562: iload #5
    //   564: ifeq -> 655
    //   567: aload_2
    //   568: invokevirtual getX : ()F
    //   571: aload_0
    //   572: getfield h : Lcom/github/mikephil/charting/utils/MPPointF;
    //   575: getfield a : F
    //   578: fsub
    //   579: invokestatic abs : (F)F
    //   582: fstore_3
    //   583: aload_2
    //   584: invokevirtual getY : ()F
    //   587: aload_0
    //   588: getfield h : Lcom/github/mikephil/charting/utils/MPPointF;
    //   591: getfield b : F
    //   594: fsub
    //   595: invokestatic abs : (F)F
    //   598: fstore #4
    //   600: aload_0
    //   601: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   604: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   607: invokevirtual m : ()Z
    //   610: ifne -> 620
    //   613: fload #4
    //   615: fload_3
    //   616: fcmpl
    //   617: iflt -> 987
    //   620: aload_0
    //   621: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   624: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   627: invokevirtual n : ()Z
    //   630: ifne -> 640
    //   633: fload #4
    //   635: fload_3
    //   636: fcmpg
    //   637: ifgt -> 987
    //   640: aload_0
    //   641: getstatic com/github/mikephil/charting/listener/ChartTouchListener$ChartGesture.b : Lcom/github/mikephil/charting/listener/ChartTouchListener$ChartGesture;
    //   644: putfield a : Lcom/github/mikephil/charting/listener/ChartTouchListener$ChartGesture;
    //   647: aload_0
    //   648: iconst_1
    //   649: putfield b : I
    //   652: goto -> 987
    //   655: aload_0
    //   656: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   659: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   662: invokevirtual k : ()Z
    //   665: ifeq -> 987
    //   668: aload_0
    //   669: getstatic com/github/mikephil/charting/listener/ChartTouchListener$ChartGesture.b : Lcom/github/mikephil/charting/listener/ChartTouchListener$ChartGesture;
    //   672: putfield a : Lcom/github/mikephil/charting/listener/ChartTouchListener$ChartGesture;
    //   675: aload_0
    //   676: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   679: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   682: invokevirtual k : ()Z
    //   685: ifeq -> 987
    //   688: aload_0
    //   689: aload_2
    //   690: invokespecial e : (Landroid/view/MotionEvent;)V
    //   693: goto -> 987
    //   696: aload_0
    //   697: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   700: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   703: invokevirtual A : ()V
    //   706: aload_0
    //   707: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   710: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   713: invokevirtual o : ()Z
    //   716: ifne -> 732
    //   719: aload_0
    //   720: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   723: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   726: invokevirtual p : ()Z
    //   729: ifeq -> 987
    //   732: aload_0
    //   733: aload_2
    //   734: invokespecial d : (Landroid/view/MotionEvent;)V
    //   737: goto -> 987
    //   740: aload_0
    //   741: getfield n : Landroid/view/VelocityTracker;
    //   744: astore_1
    //   745: aload_2
    //   746: iconst_0
    //   747: invokevirtual getPointerId : (I)I
    //   750: istore #5
    //   752: aload_1
    //   753: sipush #1000
    //   756: invokestatic c : ()I
    //   759: i2f
    //   760: invokevirtual computeCurrentVelocity : (IF)V
    //   763: aload_1
    //   764: iload #5
    //   766: invokevirtual getYVelocity : (I)F
    //   769: fstore_3
    //   770: aload_1
    //   771: iload #5
    //   773: invokevirtual getXVelocity : (I)F
    //   776: fstore #4
    //   778: fload #4
    //   780: invokestatic abs : (F)F
    //   783: invokestatic b : ()I
    //   786: i2f
    //   787: fcmpl
    //   788: ifgt -> 803
    //   791: fload_3
    //   792: invokestatic abs : (F)F
    //   795: invokestatic b : ()I
    //   798: i2f
    //   799: fcmpl
    //   800: ifle -> 880
    //   803: aload_0
    //   804: getfield b : I
    //   807: iconst_1
    //   808: if_icmpne -> 880
    //   811: aload_0
    //   812: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   815: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   818: invokevirtual y : ()Z
    //   821: ifeq -> 880
    //   824: aload_0
    //   825: invokevirtual a : ()V
    //   828: aload_0
    //   829: invokestatic currentAnimationTimeMillis : ()J
    //   832: putfield o : J
    //   835: aload_0
    //   836: getfield p : Lcom/github/mikephil/charting/utils/MPPointF;
    //   839: aload_2
    //   840: invokevirtual getX : ()F
    //   843: putfield a : F
    //   846: aload_0
    //   847: getfield p : Lcom/github/mikephil/charting/utils/MPPointF;
    //   850: aload_2
    //   851: invokevirtual getY : ()F
    //   854: putfield b : F
    //   857: aload_0
    //   858: getfield q : Lcom/github/mikephil/charting/utils/MPPointF;
    //   861: astore_1
    //   862: aload_1
    //   863: fload #4
    //   865: putfield a : F
    //   868: aload_1
    //   869: fload_3
    //   870: putfield b : F
    //   873: aload_0
    //   874: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   877: invokestatic a : (Landroid/view/View;)V
    //   880: aload_0
    //   881: getfield b : I
    //   884: iconst_2
    //   885: if_icmpeq -> 912
    //   888: aload_0
    //   889: getfield b : I
    //   892: iconst_3
    //   893: if_icmpeq -> 912
    //   896: aload_0
    //   897: getfield b : I
    //   900: iconst_4
    //   901: if_icmpeq -> 912
    //   904: aload_0
    //   905: getfield b : I
    //   908: iconst_5
    //   909: if_icmpne -> 932
    //   912: aload_0
    //   913: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   916: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   919: invokevirtual j : ()V
    //   922: aload_0
    //   923: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   926: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   929: invokevirtual postInvalidate : ()V
    //   932: aload_0
    //   933: iconst_0
    //   934: putfield b : I
    //   937: aload_0
    //   938: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   941: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   944: invokevirtual B : ()V
    //   947: aload_0
    //   948: getfield n : Landroid/view/VelocityTracker;
    //   951: astore_1
    //   952: aload_1
    //   953: ifnull -> 965
    //   956: aload_1
    //   957: invokevirtual recycle : ()V
    //   960: aload_0
    //   961: aconst_null
    //   962: putfield n : Landroid/view/VelocityTracker;
    //   965: aload_0
    //   966: aload_2
    //   967: invokevirtual b : (Landroid/view/MotionEvent;)V
    //   970: goto -> 987
    //   973: aload_0
    //   974: aload_2
    //   975: invokevirtual a : (Landroid/view/MotionEvent;)V
    //   978: aload_0
    //   979: invokevirtual a : ()V
    //   982: aload_0
    //   983: aload_2
    //   984: invokespecial c : (Landroid/view/MotionEvent;)V
    //   987: aload_0
    //   988: aload_0
    //   989: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   992: checkcast com/github/mikephil/charting/charts/BarLineChartBase
    //   995: invokevirtual getViewPortHandler : ()Lcom/github/mikephil/charting/utils/ViewPortHandler;
    //   998: aload_0
    //   999: getfield f : Landroid/graphics/Matrix;
    //   1002: aload_0
    //   1003: getfield e : Lcom/github/mikephil/charting/charts/Chart;
    //   1006: iconst_1
    //   1007: invokevirtual a : (Landroid/graphics/Matrix;Landroid/view/View;Z)Landroid/graphics/Matrix;
    //   1010: putfield f : Landroid/graphics/Matrix;
    //   1013: iconst_1
    //   1014: ireturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\listener\BarLineChartTouchListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */