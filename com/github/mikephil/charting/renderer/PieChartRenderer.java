package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.List;

public class PieChartRenderer extends DataRenderer {
  protected PieChart a;
  
  protected Paint b;
  
  protected Paint c;
  
  protected Paint d;
  
  protected WeakReference<Bitmap> e;
  
  protected Canvas f;
  
  protected Path l = new Path();
  
  protected RectF m = new RectF();
  
  private TextPaint n;
  
  private Paint p;
  
  private StaticLayout q;
  
  private CharSequence r;
  
  private RectF s = new RectF();
  
  private RectF[] t = new RectF[] { new RectF(), new RectF(), new RectF() };
  
  private Path u = new Path();
  
  private RectF v = new RectF();
  
  private Path w = new Path();
  
  public PieChartRenderer(PieChart paramPieChart, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler) {
    super(paramChartAnimator, paramViewPortHandler);
    this.a = paramPieChart;
    this.b = new Paint(1);
    this.b.setColor(-1);
    this.b.setStyle(Paint.Style.FILL);
    this.c = new Paint(1);
    this.c.setColor(-1);
    this.c.setStyle(Paint.Style.FILL);
    this.c.setAlpha(105);
    this.n = new TextPaint(1);
    this.n.setColor(-16777216);
    this.n.setTextSize(Utils.a(12.0F));
    this.k.setTextSize(Utils.a(13.0F));
    this.k.setColor(-1);
    this.k.setTextAlign(Paint.Align.CENTER);
    this.p = new Paint(1);
    this.p.setColor(-1);
    this.p.setTextAlign(Paint.Align.CENTER);
    this.p.setTextSize(Utils.a(13.0F));
    this.d = new Paint(1);
    this.d.setStyle(Paint.Style.STROKE);
  }
  
  protected float a(IPieDataSet paramIPieDataSet) {
    return !paramIPieDataSet.b() ? paramIPieDataSet.a() : ((paramIPieDataSet.a() / this.o.o() > paramIPieDataSet.J() / ((PieData)this.a.getData()).l() * 2.0F) ? 0.0F : paramIPieDataSet.a());
  }
  
  protected float a(MPPointF paramMPPointF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
    float f3 = paramFloat6 / 2.0F;
    float f1 = paramMPPointF.a;
    double d = ((paramFloat5 + paramFloat6) * 0.017453292F);
    paramFloat6 = f1 + (float)Math.cos(d) * paramFloat1;
    f1 = paramMPPointF.b + (float)Math.sin(d) * paramFloat1;
    float f2 = paramMPPointF.a;
    d = ((paramFloat5 + f3) * 0.017453292F);
    paramFloat5 = (float)Math.cos(d);
    f3 = paramMPPointF.b;
    float f4 = (float)Math.sin(d);
    return (float)((paramFloat1 - (float)(Math.sqrt(Math.pow((paramFloat6 - paramFloat3), 2.0D) + Math.pow((f1 - paramFloat4), 2.0D)) / 2.0D * Math.tan((180.0D - paramFloat2) / 2.0D * 0.017453292519943295D))) - Math.sqrt(Math.pow((f2 + paramFloat5 * paramFloat1 - (paramFloat6 + paramFloat3) / 2.0F), 2.0D) + Math.pow((f3 + f4 * paramFloat1 - (f1 + paramFloat4) / 2.0F), 2.0D)));
  }
  
  public void a() {}
  
  public void a(Canvas paramCanvas) {
    // Byte code:
    //   0: aload_0
    //   1: getfield o : Lcom/github/mikephil/charting/utils/ViewPortHandler;
    //   4: invokevirtual n : ()F
    //   7: f2i
    //   8: istore_2
    //   9: aload_0
    //   10: getfield o : Lcom/github/mikephil/charting/utils/ViewPortHandler;
    //   13: invokevirtual m : ()F
    //   16: f2i
    //   17: istore_3
    //   18: aload_0
    //   19: getfield e : Ljava/lang/ref/WeakReference;
    //   22: astore #4
    //   24: aload #4
    //   26: ifnonnull -> 35
    //   29: aconst_null
    //   30: astore #4
    //   32: goto -> 45
    //   35: aload #4
    //   37: invokevirtual get : ()Ljava/lang/Object;
    //   40: checkcast android/graphics/Bitmap
    //   43: astore #4
    //   45: aload #4
    //   47: ifnull -> 72
    //   50: aload #4
    //   52: invokevirtual getWidth : ()I
    //   55: iload_2
    //   56: if_icmpne -> 72
    //   59: aload #4
    //   61: astore #5
    //   63: aload #4
    //   65: invokevirtual getHeight : ()I
    //   68: iload_3
    //   69: if_icmpeq -> 116
    //   72: iload_2
    //   73: ifle -> 194
    //   76: iload_3
    //   77: ifle -> 194
    //   80: iload_2
    //   81: iload_3
    //   82: getstatic android/graphics/Bitmap$Config.ARGB_4444 : Landroid/graphics/Bitmap$Config;
    //   85: invokestatic createBitmap : (IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   88: astore #5
    //   90: aload_0
    //   91: new java/lang/ref/WeakReference
    //   94: dup
    //   95: aload #5
    //   97: invokespecial <init> : (Ljava/lang/Object;)V
    //   100: putfield e : Ljava/lang/ref/WeakReference;
    //   103: aload_0
    //   104: new android/graphics/Canvas
    //   107: dup
    //   108: aload #5
    //   110: invokespecial <init> : (Landroid/graphics/Bitmap;)V
    //   113: putfield f : Landroid/graphics/Canvas;
    //   116: aload #5
    //   118: iconst_0
    //   119: invokevirtual eraseColor : (I)V
    //   122: aload_0
    //   123: getfield a : Lcom/github/mikephil/charting/charts/PieChart;
    //   126: invokevirtual getData : ()Lcom/github/mikephil/charting/data/ChartData;
    //   129: checkcast com/github/mikephil/charting/data/PieData
    //   132: invokevirtual i : ()Ljava/util/List;
    //   135: invokeinterface iterator : ()Ljava/util/Iterator;
    //   140: astore #4
    //   142: aload #4
    //   144: invokeinterface hasNext : ()Z
    //   149: ifeq -> 194
    //   152: aload #4
    //   154: invokeinterface next : ()Ljava/lang/Object;
    //   159: checkcast com/github/mikephil/charting/interfaces/datasets/IPieDataSet
    //   162: astore #5
    //   164: aload #5
    //   166: invokeinterface B : ()Z
    //   171: ifeq -> 142
    //   174: aload #5
    //   176: invokeinterface H : ()I
    //   181: ifle -> 142
    //   184: aload_0
    //   185: aload_1
    //   186: aload #5
    //   188: invokevirtual a : (Landroid/graphics/Canvas;Lcom/github/mikephil/charting/interfaces/datasets/IPieDataSet;)V
    //   191: goto -> 142
    //   194: return
  }
  
  protected void a(Canvas paramCanvas, IPieDataSet paramIPieDataSet) {
    // Byte code:
    //   0: aload_0
    //   1: astore #27
    //   3: aload_2
    //   4: astore #28
    //   6: aload #27
    //   8: getfield a : Lcom/github/mikephil/charting/charts/PieChart;
    //   11: invokevirtual getRotationAngle : ()F
    //   14: fstore #10
    //   16: aload #27
    //   18: getfield g : Lcom/github/mikephil/charting/animation/ChartAnimator;
    //   21: invokevirtual b : ()F
    //   24: fstore #9
    //   26: aload #27
    //   28: getfield g : Lcom/github/mikephil/charting/animation/ChartAnimator;
    //   31: invokevirtual a : ()F
    //   34: fstore #15
    //   36: aload #27
    //   38: getfield a : Lcom/github/mikephil/charting/charts/PieChart;
    //   41: invokevirtual getCircleBox : ()Landroid/graphics/RectF;
    //   44: astore #31
    //   46: aload_2
    //   47: invokeinterface H : ()I
    //   52: istore #24
    //   54: aload #27
    //   56: getfield a : Lcom/github/mikephil/charting/charts/PieChart;
    //   59: invokevirtual getDrawAngles : ()[F
    //   62: astore #32
    //   64: aload #27
    //   66: getfield a : Lcom/github/mikephil/charting/charts/PieChart;
    //   69: invokevirtual getCenterCircleBox : ()Lcom/github/mikephil/charting/utils/MPPointF;
    //   72: astore_1
    //   73: aload #27
    //   75: getfield a : Lcom/github/mikephil/charting/charts/PieChart;
    //   78: invokevirtual getRadius : ()F
    //   81: fstore #11
    //   83: aload #27
    //   85: getfield a : Lcom/github/mikephil/charting/charts/PieChart;
    //   88: invokevirtual d : ()Z
    //   91: ifeq -> 111
    //   94: aload #27
    //   96: getfield a : Lcom/github/mikephil/charting/charts/PieChart;
    //   99: invokevirtual c : ()Z
    //   102: ifne -> 111
    //   105: iconst_1
    //   106: istore #20
    //   108: goto -> 114
    //   111: iconst_0
    //   112: istore #20
    //   114: iload #20
    //   116: ifeq -> 139
    //   119: aload #27
    //   121: getfield a : Lcom/github/mikephil/charting/charts/PieChart;
    //   124: invokevirtual getHoleRadius : ()F
    //   127: ldc_w 100.0
    //   130: fdiv
    //   131: fload #11
    //   133: fmul
    //   134: fstore #5
    //   136: goto -> 142
    //   139: fconst_0
    //   140: fstore #5
    //   142: fload #11
    //   144: aload #27
    //   146: getfield a : Lcom/github/mikephil/charting/charts/PieChart;
    //   149: invokevirtual getHoleRadius : ()F
    //   152: fload #11
    //   154: fmul
    //   155: ldc_w 100.0
    //   158: fdiv
    //   159: fsub
    //   160: fconst_2
    //   161: fdiv
    //   162: fstore #16
    //   164: new android/graphics/RectF
    //   167: dup
    //   168: invokespecial <init> : ()V
    //   171: astore #26
    //   173: iload #20
    //   175: ifeq -> 195
    //   178: aload #27
    //   180: getfield a : Lcom/github/mikephil/charting/charts/PieChart;
    //   183: invokevirtual g : ()Z
    //   186: ifeq -> 195
    //   189: iconst_1
    //   190: istore #21
    //   192: goto -> 198
    //   195: iconst_0
    //   196: istore #21
    //   198: iconst_0
    //   199: istore #22
    //   201: iconst_0
    //   202: istore #19
    //   204: iload #22
    //   206: iload #24
    //   208: if_icmpge -> 259
    //   211: iload #19
    //   213: istore #23
    //   215: aload #28
    //   217: iload #22
    //   219: invokeinterface e : (I)Lcom/github/mikephil/charting/data/Entry;
    //   224: checkcast com/github/mikephil/charting/data/PieEntry
    //   227: invokevirtual b : ()F
    //   230: invokestatic abs : (F)F
    //   233: getstatic com/github/mikephil/charting/utils/Utils.b : F
    //   236: fcmpl
    //   237: ifle -> 246
    //   240: iload #19
    //   242: iconst_1
    //   243: iadd
    //   244: istore #23
    //   246: iload #22
    //   248: iconst_1
    //   249: iadd
    //   250: istore #22
    //   252: iload #23
    //   254: istore #19
    //   256: goto -> 204
    //   259: iload #19
    //   261: iconst_1
    //   262: if_icmpgt -> 271
    //   265: fconst_0
    //   266: fstore #8
    //   268: goto -> 280
    //   271: aload #27
    //   273: aload #28
    //   275: invokevirtual a : (Lcom/github/mikephil/charting/interfaces/datasets/IPieDataSet;)F
    //   278: fstore #8
    //   280: iconst_0
    //   281: istore #23
    //   283: fconst_0
    //   284: fstore #12
    //   286: iload #24
    //   288: istore #22
    //   290: aload_2
    //   291: astore #28
    //   293: iload #23
    //   295: iload #22
    //   297: if_icmpge -> 1348
    //   300: aload #32
    //   302: iload #23
    //   304: faload
    //   305: fstore #17
    //   307: aload #28
    //   309: iload #23
    //   311: invokeinterface e : (I)Lcom/github/mikephil/charting/data/Entry;
    //   316: invokevirtual b : ()F
    //   319: invokestatic abs : (F)F
    //   322: getstatic com/github/mikephil/charting/utils/Utils.b : F
    //   325: fcmpl
    //   326: ifgt -> 352
    //   329: fload #12
    //   331: fload #17
    //   333: fload #9
    //   335: fmul
    //   336: fadd
    //   337: fstore #6
    //   339: aload_1
    //   340: astore #28
    //   342: aload #26
    //   344: astore_1
    //   345: aload #28
    //   347: astore #26
    //   349: goto -> 1325
    //   352: aload #27
    //   354: getfield a : Lcom/github/mikephil/charting/charts/PieChart;
    //   357: iload #23
    //   359: invokevirtual a : (I)Z
    //   362: ifeq -> 373
    //   365: iload #21
    //   367: ifne -> 373
    //   370: goto -> 329
    //   373: fload #8
    //   375: fconst_0
    //   376: fcmpl
    //   377: ifle -> 395
    //   380: fload #17
    //   382: ldc_w 180.0
    //   385: fcmpg
    //   386: ifgt -> 395
    //   389: iconst_1
    //   390: istore #24
    //   392: goto -> 398
    //   395: iconst_0
    //   396: istore #24
    //   398: aload #27
    //   400: getfield h : Landroid/graphics/Paint;
    //   403: aload #28
    //   405: iload #23
    //   407: invokeinterface a : (I)I
    //   412: invokevirtual setColor : (I)V
    //   415: iload #19
    //   417: iconst_1
    //   418: if_icmpne -> 427
    //   421: fconst_0
    //   422: fstore #6
    //   424: goto -> 437
    //   427: fload #8
    //   429: fload #11
    //   431: ldc 0.017453292
    //   433: fmul
    //   434: fdiv
    //   435: fstore #6
    //   437: fload #10
    //   439: fload #12
    //   441: fload #6
    //   443: fconst_2
    //   444: fdiv
    //   445: fadd
    //   446: fload #15
    //   448: fmul
    //   449: fadd
    //   450: fstore #13
    //   452: fload #17
    //   454: fload #6
    //   456: fsub
    //   457: fload #15
    //   459: fmul
    //   460: fstore #7
    //   462: fload #7
    //   464: fstore #6
    //   466: fload #7
    //   468: fconst_0
    //   469: fcmpg
    //   470: ifge -> 476
    //   473: fconst_0
    //   474: fstore #6
    //   476: aload #27
    //   478: getfield u : Landroid/graphics/Path;
    //   481: invokevirtual reset : ()V
    //   484: iload #21
    //   486: ifeq -> 565
    //   489: aload_1
    //   490: getfield a : F
    //   493: fstore #14
    //   495: fload #11
    //   497: fload #16
    //   499: fsub
    //   500: fstore #7
    //   502: fload #13
    //   504: ldc 0.017453292
    //   506: fmul
    //   507: f2d
    //   508: dstore_3
    //   509: fload #14
    //   511: dload_3
    //   512: invokestatic cos : (D)D
    //   515: d2f
    //   516: fload #7
    //   518: fmul
    //   519: fadd
    //   520: fstore #14
    //   522: aload_1
    //   523: getfield b : F
    //   526: fload #7
    //   528: dload_3
    //   529: invokestatic sin : (D)D
    //   532: d2f
    //   533: fmul
    //   534: fadd
    //   535: fstore #7
    //   537: aload #26
    //   539: fload #14
    //   541: fload #16
    //   543: fsub
    //   544: fload #7
    //   546: fload #16
    //   548: fsub
    //   549: fload #14
    //   551: fload #16
    //   553: fadd
    //   554: fload #7
    //   556: fload #16
    //   558: fadd
    //   559: invokevirtual set : (FFFF)V
    //   562: goto -> 565
    //   565: aload_1
    //   566: getfield a : F
    //   569: fstore #7
    //   571: fload #13
    //   573: ldc 0.017453292
    //   575: fmul
    //   576: f2d
    //   577: dstore_3
    //   578: fload #7
    //   580: dload_3
    //   581: invokestatic cos : (D)D
    //   584: d2f
    //   585: fload #11
    //   587: fmul
    //   588: fadd
    //   589: fstore #14
    //   591: aload_1
    //   592: getfield b : F
    //   595: dload_3
    //   596: invokestatic sin : (D)D
    //   599: d2f
    //   600: fload #11
    //   602: fmul
    //   603: fadd
    //   604: fstore #18
    //   606: fload #6
    //   608: ldc_w 360.0
    //   611: fcmpl
    //   612: istore #25
    //   614: iload #25
    //   616: iflt -> 656
    //   619: fload #6
    //   621: ldc_w 360.0
    //   624: frem
    //   625: getstatic com/github/mikephil/charting/utils/Utils.b : F
    //   628: fcmpg
    //   629: ifgt -> 656
    //   632: aload #27
    //   634: getfield u : Landroid/graphics/Path;
    //   637: aload_1
    //   638: getfield a : F
    //   641: aload_1
    //   642: getfield b : F
    //   645: fload #11
    //   647: getstatic android/graphics/Path$Direction.CW : Landroid/graphics/Path$Direction;
    //   650: invokevirtual addCircle : (FFFLandroid/graphics/Path$Direction;)V
    //   653: goto -> 697
    //   656: iload #21
    //   658: ifeq -> 683
    //   661: aload #27
    //   663: getfield u : Landroid/graphics/Path;
    //   666: aload #26
    //   668: fload #13
    //   670: ldc_w 180.0
    //   673: fadd
    //   674: ldc_w -180.0
    //   677: invokevirtual arcTo : (Landroid/graphics/RectF;FF)V
    //   680: goto -> 683
    //   683: aload #27
    //   685: getfield u : Landroid/graphics/Path;
    //   688: aload #31
    //   690: fload #13
    //   692: fload #6
    //   694: invokevirtual arcTo : (Landroid/graphics/RectF;FF)V
    //   697: aload #27
    //   699: getfield v : Landroid/graphics/RectF;
    //   702: aload_1
    //   703: getfield a : F
    //   706: fload #5
    //   708: fsub
    //   709: aload_1
    //   710: getfield b : F
    //   713: fload #5
    //   715: fsub
    //   716: aload_1
    //   717: getfield a : F
    //   720: fload #5
    //   722: fadd
    //   723: aload_1
    //   724: getfield b : F
    //   727: fload #5
    //   729: fadd
    //   730: invokevirtual set : (FFFF)V
    //   733: iload #20
    //   735: ifeq -> 1120
    //   738: fload #5
    //   740: fconst_0
    //   741: fcmpl
    //   742: ifgt -> 756
    //   745: iload #24
    //   747: ifeq -> 753
    //   750: goto -> 756
    //   753: goto -> 1120
    //   756: iload #24
    //   758: ifeq -> 811
    //   761: aload_0
    //   762: aload_1
    //   763: fload #11
    //   765: fload #17
    //   767: fload #15
    //   769: fmul
    //   770: fload #14
    //   772: fload #18
    //   774: fload #13
    //   776: fload #6
    //   778: invokevirtual a : (Lcom/github/mikephil/charting/utils/MPPointF;FFFFFF)F
    //   781: fstore #13
    //   783: fload #13
    //   785: fstore #7
    //   787: fload #13
    //   789: fconst_0
    //   790: fcmpg
    //   791: ifge -> 799
    //   794: fload #13
    //   796: fneg
    //   797: fstore #7
    //   799: fload #5
    //   801: fload #7
    //   803: invokestatic max : (FF)F
    //   806: fstore #7
    //   808: goto -> 815
    //   811: fload #5
    //   813: fstore #7
    //   815: fload #7
    //   817: fstore #13
    //   819: iload #19
    //   821: iconst_1
    //   822: if_icmpeq -> 848
    //   825: fload #13
    //   827: fconst_0
    //   828: fcmpl
    //   829: ifne -> 835
    //   832: goto -> 848
    //   835: fload #8
    //   837: fload #13
    //   839: ldc 0.017453292
    //   841: fmul
    //   842: fdiv
    //   843: fstore #7
    //   845: goto -> 851
    //   848: fconst_0
    //   849: fstore #7
    //   851: fload #7
    //   853: fconst_2
    //   854: fdiv
    //   855: fstore #18
    //   857: fload #17
    //   859: fload #7
    //   861: fsub
    //   862: fload #15
    //   864: fmul
    //   865: fstore #14
    //   867: fload #14
    //   869: fstore #7
    //   871: fload #14
    //   873: fconst_0
    //   874: fcmpg
    //   875: ifge -> 881
    //   878: fconst_0
    //   879: fstore #7
    //   881: fload #10
    //   883: fload #12
    //   885: fload #18
    //   887: fadd
    //   888: fload #15
    //   890: fmul
    //   891: fadd
    //   892: fload #7
    //   894: fadd
    //   895: fstore #14
    //   897: iload #25
    //   899: iflt -> 938
    //   902: fload #6
    //   904: ldc_w 360.0
    //   907: frem
    //   908: getstatic com/github/mikephil/charting/utils/Utils.b : F
    //   911: fcmpg
    //   912: ifgt -> 938
    //   915: aload_0
    //   916: getfield u : Landroid/graphics/Path;
    //   919: aload_1
    //   920: getfield a : F
    //   923: aload_1
    //   924: getfield b : F
    //   927: fload #13
    //   929: getstatic android/graphics/Path$Direction.CCW : Landroid/graphics/Path$Direction;
    //   932: invokevirtual addCircle : (FFFLandroid/graphics/Path$Direction;)V
    //   935: goto -> 1108
    //   938: aload_0
    //   939: astore #27
    //   941: iload #21
    //   943: ifeq -> 1041
    //   946: aload_1
    //   947: getfield a : F
    //   950: fstore #13
    //   952: fload #11
    //   954: fload #16
    //   956: fsub
    //   957: fstore #6
    //   959: fload #14
    //   961: ldc 0.017453292
    //   963: fmul
    //   964: f2d
    //   965: dstore_3
    //   966: fload #13
    //   968: dload_3
    //   969: invokestatic cos : (D)D
    //   972: d2f
    //   973: fload #6
    //   975: fmul
    //   976: fadd
    //   977: fstore #13
    //   979: aload_1
    //   980: getfield b : F
    //   983: fload #6
    //   985: dload_3
    //   986: invokestatic sin : (D)D
    //   989: d2f
    //   990: fmul
    //   991: fadd
    //   992: fstore #6
    //   994: aload #26
    //   996: astore #28
    //   998: aload #28
    //   1000: fload #13
    //   1002: fload #16
    //   1004: fsub
    //   1005: fload #6
    //   1007: fload #16
    //   1009: fsub
    //   1010: fload #13
    //   1012: fload #16
    //   1014: fadd
    //   1015: fload #6
    //   1017: fload #16
    //   1019: fadd
    //   1020: invokevirtual set : (FFFF)V
    //   1023: aload #27
    //   1025: getfield u : Landroid/graphics/Path;
    //   1028: aload #28
    //   1030: fload #14
    //   1032: ldc_w 180.0
    //   1035: invokevirtual arcTo : (Landroid/graphics/RectF;FF)V
    //   1038: goto -> 1090
    //   1041: aload #27
    //   1043: getfield u : Landroid/graphics/Path;
    //   1046: astore #28
    //   1048: aload_1
    //   1049: getfield a : F
    //   1052: fstore #6
    //   1054: fload #14
    //   1056: ldc 0.017453292
    //   1058: fmul
    //   1059: f2d
    //   1060: dstore_3
    //   1061: aload #28
    //   1063: fload #6
    //   1065: dload_3
    //   1066: invokestatic cos : (D)D
    //   1069: d2f
    //   1070: fload #13
    //   1072: fmul
    //   1073: fadd
    //   1074: aload_1
    //   1075: getfield b : F
    //   1078: fload #13
    //   1080: dload_3
    //   1081: invokestatic sin : (D)D
    //   1084: d2f
    //   1085: fmul
    //   1086: fadd
    //   1087: invokevirtual lineTo : (FF)V
    //   1090: aload #27
    //   1092: getfield u : Landroid/graphics/Path;
    //   1095: aload #27
    //   1097: getfield v : Landroid/graphics/RectF;
    //   1100: fload #14
    //   1102: fload #7
    //   1104: fneg
    //   1105: invokevirtual arcTo : (Landroid/graphics/RectF;FF)V
    //   1108: aload_0
    //   1109: astore #29
    //   1111: aload_1
    //   1112: astore #30
    //   1114: aload #26
    //   1116: astore_1
    //   1117: goto -> 1281
    //   1120: aload_1
    //   1121: astore #28
    //   1123: aload #26
    //   1125: astore_1
    //   1126: aload #27
    //   1128: astore #29
    //   1130: aload #28
    //   1132: astore #30
    //   1134: fload #6
    //   1136: ldc_w 360.0
    //   1139: frem
    //   1140: getstatic com/github/mikephil/charting/utils/Utils.b : F
    //   1143: fcmpl
    //   1144: ifle -> 1281
    //   1147: iload #24
    //   1149: ifeq -> 1253
    //   1152: fload #6
    //   1154: fconst_2
    //   1155: fdiv
    //   1156: fstore #7
    //   1158: aload #26
    //   1160: astore_1
    //   1161: aload_0
    //   1162: aload #28
    //   1164: fload #11
    //   1166: fload #17
    //   1168: fload #15
    //   1170: fmul
    //   1171: fload #14
    //   1173: fload #18
    //   1175: fload #13
    //   1177: fload #6
    //   1179: invokevirtual a : (Lcom/github/mikephil/charting/utils/MPPointF;FFFFFF)F
    //   1182: fstore #6
    //   1184: aload #28
    //   1186: getfield a : F
    //   1189: fstore #14
    //   1191: fload #13
    //   1193: fload #7
    //   1195: fadd
    //   1196: ldc 0.017453292
    //   1198: fmul
    //   1199: f2d
    //   1200: dstore_3
    //   1201: dload_3
    //   1202: invokestatic cos : (D)D
    //   1205: d2f
    //   1206: fstore #7
    //   1208: aload #28
    //   1210: getfield b : F
    //   1213: fstore #13
    //   1215: dload_3
    //   1216: invokestatic sin : (D)D
    //   1219: d2f
    //   1220: fstore #18
    //   1222: aload #27
    //   1224: getfield u : Landroid/graphics/Path;
    //   1227: fload #14
    //   1229: fload #7
    //   1231: fload #6
    //   1233: fmul
    //   1234: fadd
    //   1235: fload #13
    //   1237: fload #6
    //   1239: fload #18
    //   1241: fmul
    //   1242: fadd
    //   1243: invokevirtual lineTo : (FF)V
    //   1246: aload #28
    //   1248: astore #26
    //   1250: goto -> 1289
    //   1253: aload #26
    //   1255: astore_1
    //   1256: aload #27
    //   1258: getfield u : Landroid/graphics/Path;
    //   1261: aload #28
    //   1263: getfield a : F
    //   1266: aload #28
    //   1268: getfield b : F
    //   1271: invokevirtual lineTo : (FF)V
    //   1274: aload #28
    //   1276: astore #26
    //   1278: goto -> 1289
    //   1281: aload #30
    //   1283: astore #26
    //   1285: aload #29
    //   1287: astore #27
    //   1289: aload #27
    //   1291: getfield u : Landroid/graphics/Path;
    //   1294: invokevirtual close : ()V
    //   1297: aload #27
    //   1299: getfield f : Landroid/graphics/Canvas;
    //   1302: aload #27
    //   1304: getfield u : Landroid/graphics/Path;
    //   1307: aload #27
    //   1309: getfield h : Landroid/graphics/Paint;
    //   1312: invokevirtual drawPath : (Landroid/graphics/Path;Landroid/graphics/Paint;)V
    //   1315: fload #12
    //   1317: fload #17
    //   1319: fload #9
    //   1321: fmul
    //   1322: fadd
    //   1323: fstore #6
    //   1325: iload #23
    //   1327: iconst_1
    //   1328: iadd
    //   1329: istore #23
    //   1331: aload #26
    //   1333: astore #28
    //   1335: aload_1
    //   1336: astore #26
    //   1338: aload #28
    //   1340: astore_1
    //   1341: fload #6
    //   1343: fstore #12
    //   1345: goto -> 290
    //   1348: aload_1
    //   1349: invokestatic b : (Lcom/github/mikephil/charting/utils/MPPointF;)V
    //   1352: return
  }
  
  protected void a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2) {
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, this.p);
  }
  
  public void a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, int paramInt) {
    this.k.setColor(paramInt);
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, this.k);
  }
  
  public void a(Canvas paramCanvas, Highlight[] paramArrayOfHighlight) {
    float f1;
    boolean bool;
    if (this.a.d() && !this.a.c()) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool && this.a.g())
      return; 
    float f3 = this.g.b();
    float f2 = this.g.a();
    float f4 = this.a.getRotationAngle();
    float[] arrayOfFloat1 = this.a.getDrawAngles();
    float[] arrayOfFloat2 = this.a.getAbsoluteAngles();
    MPPointF mPPointF = this.a.getCenterCircleBox();
    float f5 = this.a.getRadius();
    if (bool) {
      f1 = this.a.getHoleRadius() / 100.0F * f5;
    } else {
      f1 = 0.0F;
    } 
    RectF rectF = this.m;
    rectF.set(0.0F, 0.0F, 0.0F, 0.0F);
    int i = 0;
    while (true) {
      Highlight[] arrayOfHighlight = paramArrayOfHighlight;
      if (i < arrayOfHighlight.length) {
        int j = (int)arrayOfHighlight[i].a();
        if (j < arrayOfFloat1.length) {
          IPieDataSet iPieDataSet = ((PieData)this.a.getData()).b(arrayOfHighlight[i].f());
          if (iPieDataSet != null && iPieDataSet.p()) {
            float f7;
            float f8;
            int i1 = iPieDataSet.H();
            int m = 0;
            int k;
            for (k = 0; m < i1; k = i2) {
              int i2 = k;
              if (Math.abs(((PieEntry)iPieDataSet.e(m)).b()) > Utils.b)
                i2 = k + 1; 
              m++;
            } 
            if (j == 0) {
              f7 = 0.0F;
            } else {
              f7 = arrayOfFloat2[j - 1] * f3;
            } 
            if (k <= 1) {
              f8 = 0.0F;
            } else {
              f8 = iPieDataSet.a();
            } 
            float f12 = arrayOfFloat1[j];
            float f6 = iPieDataSet.c();
            float f13 = f5 + f6;
            rectF.set(this.a.getCircleBox());
            f6 = -f6;
            rectF.inset(f6, f6);
            if (f8 > 0.0F && f12 <= 180.0F) {
              m = 1;
            } else {
              m = 0;
            } 
            this.h.setColor(iPieDataSet.a(j));
            if (k == 1) {
              f9 = 0.0F;
            } else {
              f9 = f8 / f5 * 0.017453292F;
            } 
            if (k == 1) {
              f6 = 0.0F;
            } else {
              f6 = f8 / f13 * 0.017453292F;
            } 
            float f11 = f4 + (f9 / 2.0F + f7) * f2;
            float f9 = (f12 - f9) * f2;
            if (f9 < 0.0F)
              f9 = 0.0F; 
            float f14 = (f6 / 2.0F + f7) * f2 + f4;
            float f10 = (f12 - f6) * f2;
            f6 = f10;
            if (f10 < 0.0F)
              f6 = 0.0F; 
            this.u.reset();
            int n = f9 cmp 360.0F;
            if (n >= 0 && f9 % 360.0F <= Utils.b) {
              this.u.addCircle(mPPointF.a, mPPointF.b, f13, Path.Direction.CW);
            } else {
              Path path = this.u;
              f10 = mPPointF.a;
              double d = (f14 * 0.017453292F);
              path.moveTo(f10 + (float)Math.cos(d) * f13, mPPointF.b + f13 * (float)Math.sin(d));
              this.u.arcTo(rectF, f14, f6);
            } 
            if (m != 0) {
              f6 = mPPointF.a;
              double d = (f11 * 0.017453292F);
              f6 = a(mPPointF, f5, f12 * f2, (float)Math.cos(d) * f5 + f6, mPPointF.b + (float)Math.sin(d) * f5, f11, f9);
            } else {
              f6 = 0.0F;
            } 
            MPPointF mPPointF1 = mPPointF;
            f10 = f1;
            this.v.set(mPPointF1.a - f10, mPPointF1.b - f10, mPPointF1.a + f10, mPPointF1.b + f10);
            if (bool && (f10 > 0.0F || m != 0)) {
              if (m != 0) {
                f11 = f6;
                if (f6 < 0.0F)
                  f11 = -f6; 
                f6 = Math.max(f10, f11);
              } else {
                f6 = f10;
              } 
              if (k == 1 || f6 == 0.0F) {
                f8 = 0.0F;
              } else {
                f8 /= f6 * 0.017453292F;
              } 
              f11 = f8 / 2.0F;
              f10 = (f12 - f8) * f2;
              f8 = f10;
              if (f10 < 0.0F)
                f8 = 0.0F; 
              f7 = (f7 + f11) * f2 + f4 + f8;
              if (n >= 0 && f9 % 360.0F <= Utils.b) {
                this.u.addCircle(mPPointF1.a, mPPointF1.b, f6, Path.Direction.CCW);
              } else {
                Path path = this.u;
                f9 = mPPointF1.a;
                double d = (f7 * 0.017453292F);
                path.lineTo(f9 + (float)Math.cos(d) * f6, mPPointF1.b + f6 * (float)Math.sin(d));
                this.u.arcTo(this.v, f7, -f8);
              } 
            } else if (f9 % 360.0F > Utils.b) {
              if (m != 0) {
                f8 = f9 / 2.0F;
                f7 = mPPointF1.a;
                double d = ((f11 + f8) * 0.017453292F);
                f8 = (float)Math.cos(d);
                f9 = mPPointF1.b;
                f10 = (float)Math.sin(d);
                this.u.lineTo(f7 + f8 * f6, f9 + f6 * f10);
              } else {
                this.u.lineTo(mPPointF1.a, mPPointF1.b);
              } 
            } 
            this.u.close();
            this.f.drawPath(this.u, this.h);
          } 
        } 
        i++;
        continue;
      } 
      MPPointF.b(mPPointF);
      return;
    } 
  }
  
  public Paint b() {
    return this.b;
  }
  
  public void b(Canvas paramCanvas) {
    float[] arrayOfFloat1;
    Canvas canvas = paramCanvas;
    MPPointF mPPointF = this.a.getCenterCircleBox();
    float f6 = this.a.getRadius();
    float f5 = this.a.getRotationAngle();
    float[] arrayOfFloat2 = this.a.getDrawAngles();
    float[] arrayOfFloat3 = this.a.getAbsoluteAngles();
    float f3 = this.g.b();
    float f4 = this.g.a();
    float f7 = (f6 - this.a.getHoleRadius() * f6 / 100.0F) / 2.0F;
    float f8 = this.a.getHoleRadius() / 100.0F;
    float f2 = f6 / 10.0F * 3.6F;
    float f1 = f5;
    if (this.a.d()) {
      float f = (f6 - f6 * f8) / 2.0F;
      f1 = f5;
      f2 = f;
      if (!this.a.c()) {
        f1 = f5;
        f2 = f;
        if (this.a.g()) {
          f1 = (float)(f5 + (f7 * 360.0F) / f6 * 6.283185307179586D);
          f2 = f;
        } 
      } 
    } 
    f5 = f1;
    f1 = f6 - f2;
    PieData pieData = (PieData)this.a.getData();
    List<IPieDataSet> list = pieData.i();
    float f9 = pieData.l();
    boolean bool = this.a.f();
    paramCanvas.save();
    float f10 = Utils.a(5.0F);
    int i = 0;
    int j = 0;
    f2 = f6;
    while (j < list.size()) {
      float[] arrayOfFloat4;
      Canvas canvas1;
      MPPointF mPPointF1;
      MPPointF mPPointF3;
      float[] arrayOfFloat5;
      IPieDataSet iPieDataSet = list.get(j);
      boolean bool1 = iPieDataSet.y();
      if (!bool1 && !bool) {
        f6 = f2;
        float[] arrayOfFloat7 = arrayOfFloat2;
        float[] arrayOfFloat8 = arrayOfFloat3;
        f2 = f4;
        float f11 = f5;
        canvas3 = canvas;
        mPPointF3 = mPPointF;
        float[] arrayOfFloat6 = arrayOfFloat7;
        f5 = f1;
        arrayOfFloat4 = arrayOfFloat8;
        f4 = f3;
        f3 = f2;
        f2 = f11;
        f1 = f6;
      } else {
        PieDataSet.ValuePosition valuePosition3 = iPieDataSet.d();
        PieDataSet.ValuePosition valuePosition1 = iPieDataSet.e();
        b((IDataSet)iPieDataSet);
        float f11 = Utils.b(this.k, "Q") + Utils.a(4.0F);
        ValueFormatter valueFormatter = iPieDataSet.q();
        int k = iPieDataSet.H();
        this.d.setColor(iPieDataSet.g());
        this.d.setStrokeWidth(Utils.a(iPieDataSet.h()));
        f6 = a(iPieDataSet);
        MPPointF mPPointF5 = MPPointF.a(iPieDataSet.A());
        mPPointF5.a = Utils.a(mPPointF5.a);
        mPPointF5.b = Utils.a(mPPointF5.b);
        int m = 0;
        float[] arrayOfFloat6 = arrayOfFloat4;
        IPieDataSet iPieDataSet1 = iPieDataSet;
        PieDataSet.ValuePosition valuePosition2 = valuePosition3;
        while (m < k) {
          float f12;
          boolean bool2;
          boolean bool3;
          boolean bool4;
          boolean bool5;
          PieEntry pieEntry = (PieEntry)iPieDataSet1.e(m);
          if (!i) {
            f12 = 0.0F;
          } else {
            f12 = canvas3[i - 1] * f3;
          } 
          float f13 = f5 + (f12 + (mPPointF3[i] - f6 / f1 * 0.017453292F / 2.0F) / 2.0F) * f4;
          if (this.a.i()) {
            f12 = pieEntry.b() / f9 * 100.0F;
          } else {
            f12 = pieEntry.b();
          } 
          String str3 = valueFormatter.a(f12, pieEntry);
          String str1 = pieEntry.a();
          double d = (f13 * 0.017453292F);
          float f15 = (float)Math.cos(d);
          float f14 = (float)Math.sin(d);
          if (bool && valuePosition2 == PieDataSet.ValuePosition.b) {
            bool3 = true;
          } else {
            bool3 = false;
          } 
          if (bool1 && valuePosition1 == PieDataSet.ValuePosition.b) {
            bool4 = true;
          } else {
            bool4 = false;
          } 
          if (bool && valuePosition2 == PieDataSet.ValuePosition.a) {
            bool2 = true;
          } else {
            bool2 = false;
          } 
          if (bool1 && valuePosition1 == PieDataSet.ValuePosition.a) {
            bool5 = true;
          } else {
            bool5 = false;
          } 
          if (bool3 || bool4) {
            float f18 = iPieDataSet1.E();
            f7 = iPieDataSet1.F();
            f12 = iPieDataSet1.D() / 100.0F;
            if (this.a.d()) {
              float f20 = f2 * f8;
              f12 = (f2 - f20) * f12 + f20;
            } else {
              f12 = f2 * f12;
            } 
            if (iPieDataSet1.N()) {
              f7 = f7 * f1 * (float)Math.abs(Math.sin(d));
            } else {
              f7 *= f1;
            } 
            float f16 = ((MPPointF)arrayOfFloat6).a;
            float f17 = ((MPPointF)arrayOfFloat6).b;
            float f19 = (f18 + 1.0F) * f1;
            f18 = f19 * f15 + ((MPPointF)arrayOfFloat6).a;
            f19 = ((MPPointF)arrayOfFloat6).b + f19 * f14;
            d = f13 % 360.0D;
            if (d >= 90.0D && d <= 270.0D) {
              f13 = f18 - f7;
              this.k.setTextAlign(Paint.Align.RIGHT);
              if (bool3)
                this.p.setTextAlign(Paint.Align.RIGHT); 
              f7 = f13;
              f13 -= f10;
            } else {
              f7 = f18 + f7;
              this.k.setTextAlign(Paint.Align.LEFT);
              if (bool3)
                this.p.setTextAlign(Paint.Align.LEFT); 
              f13 = f7 + f10;
            } 
            if (iPieDataSet1.g() != 1122867) {
              if (iPieDataSet1.f())
                this.d.setColor(iPieDataSet1.a(m)); 
              paramCanvas.drawLine(f12 * f15 + f16, f12 * f14 + f17, f18, f19, this.d);
              paramCanvas.drawLine(f18, f19, f7, f19, this.d);
            } 
            IPieDataSet iPieDataSet2 = iPieDataSet1;
            if (bool3 && bool4) {
              a(paramCanvas, str3, f13, f19, iPieDataSet2.d(m));
              if (m < pieData.j() && str1 != null)
                a(paramCanvas, str1, f13, f19 + f11); 
            } else {
              String str = str1;
              if (bool3) {
                if (m < pieData.j() && str != null)
                  a(paramCanvas, str, f13, f19 + f11 / 2.0F); 
              } else if (bool4) {
                a(paramCanvas, str3, f13, f19 + f11 / 2.0F, iPieDataSet2.d(m));
              } 
            } 
          } 
          String str2 = str1;
          Canvas canvas5 = paramCanvas;
          if (bool2 || bool5) {
            float[] arrayOfFloat = arrayOfFloat6;
            f12 = f1 * f15 + ((MPPointF)arrayOfFloat).a;
            f7 = f1 * f14 + ((MPPointF)arrayOfFloat).b;
            this.k.setTextAlign(Paint.Align.CENTER);
            if (bool2 && bool5) {
              a(paramCanvas, str3, f12, f7, iPieDataSet1.d(m));
              if (m < pieData.j() && str2 != null)
                a(canvas5, str2, f12, f7 + f11); 
            } else if (bool2) {
              if (m < pieData.j() && str2 != null)
                a(canvas5, str2, f12, f7 + f11 / 2.0F); 
            } else if (bool5) {
              a(paramCanvas, str3, f12, f7 + f11 / 2.0F, iPieDataSet1.d(m));
            } 
          } 
          if (pieEntry.g() != null && iPieDataSet1.z()) {
            Drawable drawable = pieEntry.g();
            MPPointF mPPointF6 = mPPointF5;
            f12 = mPPointF6.b;
            f7 = ((MPPointF)arrayOfFloat6).a;
            f13 = mPPointF6.b;
            float f16 = ((MPPointF)arrayOfFloat6).b;
            float f17 = mPPointF6.a;
            Utils.a(paramCanvas, drawable, (int)((f1 + f12) * f15 + f7), (int)((f1 + f13) * f14 + f16 + f17), drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
          } 
          i++;
          m++;
        } 
        canvas1 = canvas3;
        f6 = f3;
        f3 = f4;
        f4 = f5;
        f5 = f1;
        float[] arrayOfFloat7 = arrayOfFloat6;
        canvas3 = paramCanvas;
        MPPointF.b(mPPointF5);
        f1 = f2;
        f2 = f4;
        f4 = f6;
        mPPointF1 = mPPointF3;
        arrayOfFloat5 = arrayOfFloat7;
      } 
      j++;
      MPPointF mPPointF4 = mPPointF1;
      f6 = f5;
      Canvas canvas4 = canvas1;
      f5 = f3;
      float f = f2;
      Canvas canvas2 = canvas3;
      arrayOfFloat1 = arrayOfFloat5;
      f2 = f1;
      MPPointF mPPointF2 = mPPointF4;
      Canvas canvas3 = canvas4;
      f3 = f4;
      f4 = f5;
      f5 = f;
      f1 = f6;
    } 
    MPPointF.b((MPPointF)arrayOfFloat1);
    paramCanvas.restore();
  }
  
  public Paint c() {
    return this.c;
  }
  
  public void c(Canvas paramCanvas) {
    d(paramCanvas);
    paramCanvas.drawBitmap(this.e.get(), 0.0F, 0.0F, null);
    e(paramCanvas);
  }
  
  public TextPaint d() {
    return this.n;
  }
  
  protected void d(Canvas paramCanvas) {
    if (this.a.d() && this.f != null) {
      float f1 = this.a.getRadius();
      float f2 = this.a.getHoleRadius() / 100.0F * f1;
      MPPointF mPPointF = this.a.getCenterCircleBox();
      if (Color.alpha(this.b.getColor()) > 0)
        this.f.drawCircle(mPPointF.a, mPPointF.b, f2, this.b); 
      if (Color.alpha(this.c.getColor()) > 0 && this.a.getTransparentCircleRadius() > this.a.getHoleRadius()) {
        int i = this.c.getAlpha();
        float f = this.a.getTransparentCircleRadius() / 100.0F;
        this.c.setAlpha((int)(i * this.g.b() * this.g.a()));
        this.w.reset();
        this.w.addCircle(mPPointF.a, mPPointF.b, f1 * f, Path.Direction.CW);
        this.w.addCircle(mPPointF.a, mPPointF.b, f2, Path.Direction.CCW);
        this.f.drawPath(this.w, this.c);
        this.c.setAlpha(i);
      } 
      MPPointF.b(mPPointF);
    } 
  }
  
  public Paint e() {
    return this.p;
  }
  
  protected void e(Canvas paramCanvas) {
    CharSequence charSequence = this.a.getCenterText();
    if (this.a.e() && charSequence != null) {
      MPPointF mPPointF1 = this.a.getCenterCircleBox();
      MPPointF mPPointF2 = this.a.getCenterTextOffset();
      float f2 = mPPointF1.a + mPPointF2.a;
      float f3 = mPPointF1.b + mPPointF2.b;
      if (this.a.d() && !this.a.c()) {
        f1 = this.a.getRadius() * this.a.getHoleRadius() / 100.0F;
      } else {
        f1 = this.a.getRadius();
      } 
      RectF[] arrayOfRectF = this.t;
      RectF rectF1 = arrayOfRectF[0];
      rectF1.left = f2 - f1;
      rectF1.top = f3 - f1;
      rectF1.right = f2 + f1;
      rectF1.bottom = f3 + f1;
      RectF rectF2 = arrayOfRectF[1];
      rectF2.set(rectF1);
      float f1 = this.a.getCenterTextRadiusPercent() / 100.0F;
      if (f1 > 0.0D)
        rectF2.inset((rectF2.width() - rectF2.width() * f1) / 2.0F, (rectF2.height() - rectF2.height() * f1) / 2.0F); 
      if (!charSequence.equals(this.r) || !rectF2.equals(this.s)) {
        this.s.set(rectF2);
        this.r = charSequence;
        f1 = this.s.width();
        this.q = new StaticLayout(charSequence, 0, charSequence.length(), this.n, (int)Math.max(Math.ceil(f1), 1.0D), Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
      } 
      f1 = this.q.getHeight();
      paramCanvas.save();
      if (Build.VERSION.SDK_INT >= 18) {
        Path path = this.l;
        path.reset();
        path.addOval(rectF1, Path.Direction.CW);
        paramCanvas.clipPath(path);
      } 
      paramCanvas.translate(rectF2.left, rectF2.top + (rectF2.height() - f1) / 2.0F);
      this.q.draw(paramCanvas);
      paramCanvas.restore();
      MPPointF.b(mPPointF1);
      MPPointF.b(mPPointF2);
    } 
  }
  
  public void f() {
    Canvas canvas = this.f;
    if (canvas != null) {
      canvas.setBitmap(null);
      this.f = null;
    } 
    WeakReference<Bitmap> weakReference = this.e;
    if (weakReference != null) {
      Bitmap bitmap = weakReference.get();
      if (bitmap != null)
        bitmap.recycle(); 
      this.e.clear();
      this.e = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\renderer\PieChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */