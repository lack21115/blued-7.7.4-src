package com.github.mikephil.charting.charts;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.PieRadarChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;

public abstract class PieRadarChartBase<T extends ChartData<? extends IDataSet<? extends Entry>>> extends Chart<T> {
  private float a = 270.0F;
  
  private float b = 270.0F;
  
  protected boolean c = true;
  
  protected float d = 0.0F;
  
  public PieRadarChartBase(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public PieRadarChartBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract int a(float paramFloat);
  
  public MPPointF a(MPPointF paramMPPointF, float paramFloat1, float paramFloat2) {
    MPPointF mPPointF = MPPointF.a(0.0F, 0.0F);
    a(paramMPPointF, paramFloat1, paramFloat2, mPPointF);
    return mPPointF;
  }
  
  protected void a() {
    super.a();
    this.M = (ChartTouchListener)new PieRadarChartTouchListener(this);
  }
  
  public void a(MPPointF paramMPPointF1, float paramFloat1, float paramFloat2, MPPointF paramMPPointF2) {
    double d1 = paramMPPointF1.a;
    double d2 = paramFloat1;
    double d3 = paramFloat2;
    paramMPPointF2.a = (float)(d1 + Math.cos(Math.toRadians(d3)) * d2);
    paramMPPointF2.b = (float)(paramMPPointF1.b + d2 * Math.sin(Math.toRadians(d3)));
  }
  
  public float b(float paramFloat1, float paramFloat2) {
    MPPointF mPPointF = getCenterOffsets();
    double d1 = (paramFloat1 - mPPointF.a);
    double d2 = (paramFloat2 - mPPointF.b);
    float f = (float)Math.toDegrees(Math.acos(d2 / Math.sqrt(d1 * d1 + d2 * d2)));
    paramFloat2 = f;
    if (paramFloat1 > mPPointF.a)
      paramFloat2 = 360.0F - f; 
    paramFloat2 += 90.0F;
    paramFloat1 = paramFloat2;
    if (paramFloat2 > 360.0F)
      paramFloat1 = paramFloat2 - 360.0F; 
    MPPointF.b(mPPointF);
    return paramFloat1;
  }
  
  protected void b() {}
  
  public void computeScroll() {
    if (this.M instanceof PieRadarChartTouchListener)
      ((PieRadarChartTouchListener)this.M).b(); 
  }
  
  public float d(float paramFloat1, float paramFloat2) {
    MPPointF mPPointF = getCenterOffsets();
    if (paramFloat1 > mPPointF.a) {
      paramFloat1 -= mPPointF.a;
    } else {
      paramFloat1 = mPPointF.a - paramFloat1;
    } 
    if (paramFloat2 > mPPointF.b) {
      paramFloat2 -= mPPointF.b;
    } else {
      paramFloat2 = mPPointF.b - paramFloat2;
    } 
    paramFloat1 = (float)Math.sqrt(Math.pow(paramFloat1, 2.0D) + Math.pow(paramFloat2, 2.0D));
    MPPointF.b(mPPointF);
    return paramFloat1;
  }
  
  public float getDiameter() {
    RectF rectF = this.Q.k();
    rectF.left += getExtraLeftOffset();
    rectF.top += getExtraTopOffset();
    rectF.right -= getExtraRightOffset();
    rectF.bottom -= getExtraBottomOffset();
    return Math.min(rectF.width(), rectF.height());
  }
  
  public int getMaxVisibleCount() {
    return this.C.j();
  }
  
  public float getMinOffset() {
    return this.d;
  }
  
  public abstract float getRadius();
  
  public float getRawRotationAngle() {
    return this.b;
  }
  
  protected abstract float getRequiredBaseOffset();
  
  protected abstract float getRequiredLegendOffset();
  
  public float getRotationAngle() {
    return this.a;
  }
  
  public float getYChartMax() {
    return 0.0F;
  }
  
  public float getYChartMin() {
    return 0.0F;
  }
  
  public void h() {
    if (this.C == null)
      return; 
    b();
    if (this.K != null)
      this.N.a((ChartData)this.C); 
    j();
  }
  
  public void j() {
    // Byte code:
    //   0: aload_0
    //   1: getfield K : Lcom/github/mikephil/charting/components/Legend;
    //   4: astore #11
    //   6: fconst_0
    //   7: fstore_2
    //   8: fconst_0
    //   9: fstore #4
    //   11: fconst_0
    //   12: fstore_3
    //   13: fconst_0
    //   14: fstore #6
    //   16: fconst_0
    //   17: fstore #5
    //   19: aload #11
    //   21: ifnull -> 662
    //   24: aload_0
    //   25: getfield K : Lcom/github/mikephil/charting/components/Legend;
    //   28: invokevirtual z : ()Z
    //   31: ifeq -> 662
    //   34: aload_0
    //   35: getfield K : Lcom/github/mikephil/charting/components/Legend;
    //   38: invokevirtual g : ()Z
    //   41: ifne -> 662
    //   44: aload_0
    //   45: getfield K : Lcom/github/mikephil/charting/components/Legend;
    //   48: getfield a : F
    //   51: aload_0
    //   52: getfield Q : Lcom/github/mikephil/charting/utils/ViewPortHandler;
    //   55: invokevirtual n : ()F
    //   58: aload_0
    //   59: getfield K : Lcom/github/mikephil/charting/components/Legend;
    //   62: invokevirtual q : ()F
    //   65: fmul
    //   66: invokestatic min : (FF)F
    //   69: fstore_1
    //   70: getstatic com/github/mikephil/charting/charts/PieRadarChartBase$2.c : [I
    //   73: aload_0
    //   74: getfield K : Lcom/github/mikephil/charting/components/Legend;
    //   77: invokevirtual f : ()Lcom/github/mikephil/charting/components/Legend$LegendOrientation;
    //   80: invokevirtual ordinal : ()I
    //   83: iaload
    //   84: istore #10
    //   86: iload #10
    //   88: iconst_1
    //   89: if_icmpeq -> 237
    //   92: iload #10
    //   94: iconst_2
    //   95: if_icmpeq -> 104
    //   98: fload #5
    //   100: fstore_2
    //   101: goto -> 201
    //   104: aload_0
    //   105: getfield K : Lcom/github/mikephil/charting/components/Legend;
    //   108: invokevirtual e : ()Lcom/github/mikephil/charting/components/Legend$LegendVerticalAlignment;
    //   111: getstatic com/github/mikephil/charting/components/Legend$LegendVerticalAlignment.a : Lcom/github/mikephil/charting/components/Legend$LegendVerticalAlignment;
    //   114: if_acmpeq -> 133
    //   117: fload #5
    //   119: fstore_2
    //   120: aload_0
    //   121: getfield K : Lcom/github/mikephil/charting/components/Legend;
    //   124: invokevirtual e : ()Lcom/github/mikephil/charting/components/Legend$LegendVerticalAlignment;
    //   127: getstatic com/github/mikephil/charting/components/Legend$LegendVerticalAlignment.c : Lcom/github/mikephil/charting/components/Legend$LegendVerticalAlignment;
    //   130: if_acmpne -> 201
    //   133: aload_0
    //   134: invokevirtual getRequiredLegendOffset : ()F
    //   137: fstore_1
    //   138: aload_0
    //   139: getfield K : Lcom/github/mikephil/charting/components/Legend;
    //   142: getfield b : F
    //   145: fload_1
    //   146: fadd
    //   147: aload_0
    //   148: getfield Q : Lcom/github/mikephil/charting/utils/ViewPortHandler;
    //   151: invokevirtual m : ()F
    //   154: aload_0
    //   155: getfield K : Lcom/github/mikephil/charting/components/Legend;
    //   158: invokevirtual q : ()F
    //   161: fmul
    //   162: invokestatic min : (FF)F
    //   165: fstore_2
    //   166: getstatic com/github/mikephil/charting/charts/PieRadarChartBase$2.a : [I
    //   169: aload_0
    //   170: getfield K : Lcom/github/mikephil/charting/components/Legend;
    //   173: invokevirtual e : ()Lcom/github/mikephil/charting/components/Legend$LegendVerticalAlignment;
    //   176: invokevirtual ordinal : ()I
    //   179: iaload
    //   180: istore #10
    //   182: fload_2
    //   183: fstore_1
    //   184: iload #10
    //   186: iconst_1
    //   187: if_icmpeq -> 221
    //   190: fload_2
    //   191: fstore_1
    //   192: iload #10
    //   194: iconst_2
    //   195: if_icmpeq -> 211
    //   198: fload #5
    //   200: fstore_2
    //   201: fconst_0
    //   202: fstore_1
    //   203: fconst_0
    //   204: fstore_3
    //   205: fconst_0
    //   206: fstore #4
    //   208: goto -> 621
    //   211: fload_1
    //   212: fstore_3
    //   213: fconst_0
    //   214: fstore_1
    //   215: fload #4
    //   217: fstore_2
    //   218: goto -> 205
    //   221: fload_1
    //   222: fstore #4
    //   224: fconst_0
    //   225: fstore_1
    //   226: fconst_0
    //   227: fstore #5
    //   229: fload_3
    //   230: fstore_2
    //   231: fload #5
    //   233: fstore_3
    //   234: goto -> 621
    //   237: aload_0
    //   238: getfield K : Lcom/github/mikephil/charting/components/Legend;
    //   241: invokevirtual d : ()Lcom/github/mikephil/charting/components/Legend$LegendHorizontalAlignment;
    //   244: getstatic com/github/mikephil/charting/components/Legend$LegendHorizontalAlignment.a : Lcom/github/mikephil/charting/components/Legend$LegendHorizontalAlignment;
    //   247: if_acmpeq -> 271
    //   250: aload_0
    //   251: getfield K : Lcom/github/mikephil/charting/components/Legend;
    //   254: invokevirtual d : ()Lcom/github/mikephil/charting/components/Legend$LegendHorizontalAlignment;
    //   257: getstatic com/github/mikephil/charting/components/Legend$LegendHorizontalAlignment.c : Lcom/github/mikephil/charting/components/Legend$LegendHorizontalAlignment;
    //   260: if_acmpne -> 266
    //   263: goto -> 271
    //   266: fconst_0
    //   267: fstore_1
    //   268: goto -> 487
    //   271: aload_0
    //   272: getfield K : Lcom/github/mikephil/charting/components/Legend;
    //   275: invokevirtual e : ()Lcom/github/mikephil/charting/components/Legend$LegendVerticalAlignment;
    //   278: getstatic com/github/mikephil/charting/components/Legend$LegendVerticalAlignment.b : Lcom/github/mikephil/charting/components/Legend$LegendVerticalAlignment;
    //   281: if_acmpne -> 295
    //   284: fload_1
    //   285: ldc 13.0
    //   287: invokestatic a : (F)F
    //   290: fadd
    //   291: fstore_1
    //   292: goto -> 487
    //   295: fload_1
    //   296: ldc 8.0
    //   298: invokestatic a : (F)F
    //   301: fadd
    //   302: fstore #6
    //   304: aload_0
    //   305: getfield K : Lcom/github/mikephil/charting/components/Legend;
    //   308: getfield b : F
    //   311: fstore #7
    //   313: aload_0
    //   314: getfield K : Lcom/github/mikephil/charting/components/Legend;
    //   317: getfield c : F
    //   320: fstore #8
    //   322: aload_0
    //   323: invokevirtual getCenter : ()Lcom/github/mikephil/charting/utils/MPPointF;
    //   326: astore #11
    //   328: aload_0
    //   329: getfield K : Lcom/github/mikephil/charting/components/Legend;
    //   332: invokevirtual d : ()Lcom/github/mikephil/charting/components/Legend$LegendHorizontalAlignment;
    //   335: getstatic com/github/mikephil/charting/components/Legend$LegendHorizontalAlignment.c : Lcom/github/mikephil/charting/components/Legend$LegendHorizontalAlignment;
    //   338: if_acmpne -> 356
    //   341: aload_0
    //   342: invokevirtual getWidth : ()I
    //   345: i2f
    //   346: fload #6
    //   348: fsub
    //   349: ldc 15.0
    //   351: fadd
    //   352: fstore_1
    //   353: goto -> 362
    //   356: fload #6
    //   358: ldc 15.0
    //   360: fsub
    //   361: fstore_1
    //   362: fload #7
    //   364: fload #8
    //   366: fadd
    //   367: ldc 15.0
    //   369: fadd
    //   370: fstore #7
    //   372: aload_0
    //   373: fload_1
    //   374: fload #7
    //   376: invokevirtual d : (FF)F
    //   379: fstore #8
    //   381: aload_0
    //   382: aload #11
    //   384: aload_0
    //   385: invokevirtual getRadius : ()F
    //   388: aload_0
    //   389: fload_1
    //   390: fload #7
    //   392: invokevirtual b : (FF)F
    //   395: invokevirtual a : (Lcom/github/mikephil/charting/utils/MPPointF;FF)Lcom/github/mikephil/charting/utils/MPPointF;
    //   398: astore #12
    //   400: aload_0
    //   401: aload #12
    //   403: getfield a : F
    //   406: aload #12
    //   408: getfield b : F
    //   411: invokevirtual d : (FF)F
    //   414: fstore_1
    //   415: ldc_w 5.0
    //   418: invokestatic a : (F)F
    //   421: fstore #9
    //   423: fload #7
    //   425: aload #11
    //   427: getfield b : F
    //   430: fcmpl
    //   431: iflt -> 457
    //   434: aload_0
    //   435: invokevirtual getHeight : ()I
    //   438: i2f
    //   439: fload #6
    //   441: fsub
    //   442: aload_0
    //   443: invokevirtual getWidth : ()I
    //   446: i2f
    //   447: fcmpl
    //   448: ifle -> 457
    //   451: fload #6
    //   453: fstore_1
    //   454: goto -> 477
    //   457: fload #8
    //   459: fload_1
    //   460: fcmpg
    //   461: ifge -> 475
    //   464: fload #9
    //   466: fload_1
    //   467: fload #8
    //   469: fsub
    //   470: fadd
    //   471: fstore_1
    //   472: goto -> 477
    //   475: fconst_0
    //   476: fstore_1
    //   477: aload #11
    //   479: invokestatic b : (Lcom/github/mikephil/charting/utils/MPPointF;)V
    //   482: aload #12
    //   484: invokestatic b : (Lcom/github/mikephil/charting/utils/MPPointF;)V
    //   487: getstatic com/github/mikephil/charting/charts/PieRadarChartBase$2.b : [I
    //   490: aload_0
    //   491: getfield K : Lcom/github/mikephil/charting/components/Legend;
    //   494: invokevirtual d : ()Lcom/github/mikephil/charting/components/Legend$LegendHorizontalAlignment;
    //   497: invokevirtual ordinal : ()I
    //   500: iaload
    //   501: istore #10
    //   503: iload #10
    //   505: iconst_1
    //   506: if_icmpeq -> 616
    //   509: iload #10
    //   511: iconst_2
    //   512: if_icmpeq -> 203
    //   515: iload #10
    //   517: iconst_3
    //   518: if_icmpeq -> 524
    //   521: goto -> 552
    //   524: getstatic com/github/mikephil/charting/charts/PieRadarChartBase$2.a : [I
    //   527: aload_0
    //   528: getfield K : Lcom/github/mikephil/charting/components/Legend;
    //   531: invokevirtual e : ()Lcom/github/mikephil/charting/components/Legend$LegendVerticalAlignment;
    //   534: invokevirtual ordinal : ()I
    //   537: iaload
    //   538: istore #10
    //   540: iload #10
    //   542: iconst_1
    //   543: if_icmpeq -> 587
    //   546: iload #10
    //   548: iconst_2
    //   549: if_icmpeq -> 558
    //   552: fload #5
    //   554: fstore_2
    //   555: goto -> 201
    //   558: aload_0
    //   559: getfield K : Lcom/github/mikephil/charting/components/Legend;
    //   562: getfield b : F
    //   565: aload_0
    //   566: getfield Q : Lcom/github/mikephil/charting/utils/ViewPortHandler;
    //   569: invokevirtual m : ()F
    //   572: aload_0
    //   573: getfield K : Lcom/github/mikephil/charting/components/Legend;
    //   576: invokevirtual q : ()F
    //   579: fmul
    //   580: invokestatic min : (FF)F
    //   583: fstore_1
    //   584: goto -> 211
    //   587: aload_0
    //   588: getfield K : Lcom/github/mikephil/charting/components/Legend;
    //   591: getfield b : F
    //   594: aload_0
    //   595: getfield Q : Lcom/github/mikephil/charting/utils/ViewPortHandler;
    //   598: invokevirtual m : ()F
    //   601: aload_0
    //   602: getfield K : Lcom/github/mikephil/charting/components/Legend;
    //   605: invokevirtual q : ()F
    //   608: fmul
    //   609: invokestatic min : (FF)F
    //   612: fstore_1
    //   613: goto -> 221
    //   616: fload_1
    //   617: fstore_2
    //   618: goto -> 201
    //   621: fload_2
    //   622: aload_0
    //   623: invokevirtual getRequiredBaseOffset : ()F
    //   626: fadd
    //   627: fstore #5
    //   629: fload_1
    //   630: aload_0
    //   631: invokevirtual getRequiredBaseOffset : ()F
    //   634: fadd
    //   635: fstore_2
    //   636: fload #4
    //   638: aload_0
    //   639: invokevirtual getRequiredBaseOffset : ()F
    //   642: fadd
    //   643: fstore #6
    //   645: fload_3
    //   646: aload_0
    //   647: invokevirtual getRequiredBaseOffset : ()F
    //   650: fadd
    //   651: fstore_1
    //   652: fload #5
    //   654: fstore #4
    //   656: fload #6
    //   658: fstore_3
    //   659: goto -> 672
    //   662: fconst_0
    //   663: fstore_2
    //   664: fconst_0
    //   665: fstore_1
    //   666: fconst_0
    //   667: fstore_3
    //   668: fload #6
    //   670: fstore #4
    //   672: aload_0
    //   673: getfield d : F
    //   676: invokestatic a : (F)F
    //   679: fstore #6
    //   681: fload #6
    //   683: fstore #5
    //   685: aload_0
    //   686: instanceof com/github/mikephil/charting/charts/RadarChart
    //   689: ifeq -> 735
    //   692: aload_0
    //   693: invokevirtual getXAxis : ()Lcom/github/mikephil/charting/components/XAxis;
    //   696: astore #11
    //   698: fload #6
    //   700: fstore #5
    //   702: aload #11
    //   704: invokevirtual z : ()Z
    //   707: ifeq -> 735
    //   710: fload #6
    //   712: fstore #5
    //   714: aload #11
    //   716: invokevirtual h : ()Z
    //   719: ifeq -> 735
    //   722: fload #6
    //   724: aload #11
    //   726: getfield E : I
    //   729: i2f
    //   730: invokestatic max : (FF)F
    //   733: fstore #5
    //   735: aload_0
    //   736: invokevirtual getExtraTopOffset : ()F
    //   739: fstore #8
    //   741: aload_0
    //   742: invokevirtual getExtraRightOffset : ()F
    //   745: fstore #7
    //   747: aload_0
    //   748: invokevirtual getExtraBottomOffset : ()F
    //   751: fstore #6
    //   753: fload #5
    //   755: fload #4
    //   757: aload_0
    //   758: invokevirtual getExtraLeftOffset : ()F
    //   761: fadd
    //   762: invokestatic max : (FF)F
    //   765: fstore #4
    //   767: fload #5
    //   769: fload_3
    //   770: fload #8
    //   772: fadd
    //   773: invokestatic max : (FF)F
    //   776: fstore_3
    //   777: fload #5
    //   779: fload_2
    //   780: fload #7
    //   782: fadd
    //   783: invokestatic max : (FF)F
    //   786: fstore_2
    //   787: fload #5
    //   789: aload_0
    //   790: invokevirtual getRequiredBaseOffset : ()F
    //   793: fload_1
    //   794: fload #6
    //   796: fadd
    //   797: invokestatic max : (FF)F
    //   800: invokestatic max : (FF)F
    //   803: fstore_1
    //   804: aload_0
    //   805: getfield Q : Lcom/github/mikephil/charting/utils/ViewPortHandler;
    //   808: fload #4
    //   810: fload_3
    //   811: fload_2
    //   812: fload_1
    //   813: invokevirtual a : (FFFF)V
    //   816: aload_0
    //   817: getfield B : Z
    //   820: ifeq -> 909
    //   823: new java/lang/StringBuilder
    //   826: dup
    //   827: invokespecial <init> : ()V
    //   830: astore #11
    //   832: aload #11
    //   834: ldc_w 'offsetLeft: '
    //   837: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: pop
    //   841: aload #11
    //   843: fload #4
    //   845: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   848: pop
    //   849: aload #11
    //   851: ldc_w ', offsetTop: '
    //   854: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: pop
    //   858: aload #11
    //   860: fload_3
    //   861: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   864: pop
    //   865: aload #11
    //   867: ldc_w ', offsetRight: '
    //   870: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: pop
    //   874: aload #11
    //   876: fload_2
    //   877: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   880: pop
    //   881: aload #11
    //   883: ldc_w ', offsetBottom: '
    //   886: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: pop
    //   890: aload #11
    //   892: fload_1
    //   893: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   896: pop
    //   897: ldc_w 'MPAndroidChart'
    //   900: aload #11
    //   902: invokevirtual toString : ()Ljava/lang/String;
    //   905: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   908: pop
    //   909: return
  }
  
  public boolean k() {
    return this.c;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    return (this.I && this.M != null) ? this.M.onTouch((View)this, paramMotionEvent) : super.onTouchEvent(paramMotionEvent);
  }
  
  public void setMinOffset(float paramFloat) {
    this.d = paramFloat;
  }
  
  public void setRotationAngle(float paramFloat) {
    this.b = paramFloat;
    this.a = Utils.c(this.b);
  }
  
  public void setRotationEnabled(boolean paramBoolean) {
    this.c = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\charts\PieRadarChartBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */