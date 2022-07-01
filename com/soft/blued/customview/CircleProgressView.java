package com.soft.blued.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.blued.android.core.AppMethods;
import com.soft.blued.R;
import java.lang.ref.WeakReference;

public class CircleProgressView extends View {
  private int A = -16777216;
  
  private int B = -16777216;
  
  private int[] C = new int[] { -1871679376, -1871679376 };
  
  private Paint.Cap D = Paint.Cap.BUTT;
  
  private Paint.Cap E = Paint.Cap.BUTT;
  
  private Paint F = new Paint();
  
  private Paint G = new Paint();
  
  private Paint H = new Paint();
  
  private Paint I = new Paint();
  
  private Paint J = new Paint();
  
  private Paint K = new Paint();
  
  private Paint L = new Paint();
  
  private RectF M = new RectF();
  
  private RectF N = new RectF();
  
  private RectF O = new RectF();
  
  private RectF P = new RectF();
  
  private RectF Q = new RectF();
  
  private RectF R = new RectF();
  
  private float S = 2.8F;
  
  private double T = 900.0D;
  
  private int U = 15;
  
  private boolean V;
  
  private Handler W = new AnimationHandler(this);
  
  private float a = 0.0F;
  
  private AnimationState aa = AnimationState.a;
  
  private AccelerateDecelerateInterpolator ab = new AccelerateDecelerateInterpolator();
  
  private String ac = "";
  
  private String ad = "";
  
  private int ae;
  
  private boolean af;
  
  private boolean ag;
  
  private boolean ah = true;
  
  private boolean ai = false;
  
  private boolean aj = false;
  
  private float ak = 0.3F;
  
  private float b = 0.0F;
  
  private float c = 0.0F;
  
  private float d = 100.0F;
  
  private float e = 0.0F;
  
  private float f = 42.0F;
  
  private float g = 0.0F;
  
  private int h = 0;
  
  private int i = 0;
  
  private int j = 100;
  
  private int k = 80;
  
  private int l = AppMethods.a(5);
  
  private int m = AppMethods.a(5);
  
  private int n = AppMethods.b(5);
  
  private float o = 0.0F;
  
  private float p = 1.0F;
  
  private float q = 1.0F;
  
  private int r = 0;
  
  private int s = 0;
  
  private int t = 0;
  
  private int u = 0;
  
  private final int v = -1871679376;
  
  private int w = -1442840576;
  
  private int x = -1871679376;
  
  private int y = 0;
  
  private int z = -1342177281;
  
  public CircleProgressView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CircleProgressView));
  }
  
  private static float a(String paramString, Paint paramPaint, RectF paramRectF) {
    Matrix matrix = new Matrix();
    Rect rect = new Rect();
    paramPaint.getTextBounds(paramString, 0, paramString.length(), rect);
    matrix.setRectToRect(new RectF(rect), paramRectF, Matrix.ScaleToFit.CENTER);
    float[] arrayOfFloat = new float[9];
    matrix.getValues(arrayOfFloat);
    return paramPaint.getTextSize() * arrayOfFloat[0];
  }
  
  private RectF a(RectF paramRectF) {
    double d1 = (paramRectF.width() - Math.max(this.l, this.m) - this.o * 2.0F) / 2.0D;
    double d2 = Math.sqrt(2.0D);
    float f3 = (paramRectF.width() - (float)(d1 * d2)) / 2.0F;
    boolean bool = a();
    float f2 = 1.0F;
    if (bool) {
      f2 = 0.77F;
      f1 = 1.33F;
    } else {
      f1 = 1.0F;
    } 
    float f4 = paramRectF.left;
    f2 *= f3;
    float f5 = paramRectF.top;
    float f1 = f3 * f1;
    return new RectF(f4 + f2, f5 + f1, paramRectF.right - f2, paramRectF.bottom - f1);
  }
  
  private void a(TypedArray paramTypedArray) {
    setBarWidth((int)paramTypedArray.getDimension(4, this.l));
    setRimWidth((int)paramTypedArray.getDimension(10, this.m));
    setSpinSpeed((int)paramTypedArray.getDimension(14, this.S));
    if (paramTypedArray.hasValue(0) && paramTypedArray.hasValue(1) && paramTypedArray.hasValue(2) && paramTypedArray.hasValue(3)) {
      this.C = new int[] { paramTypedArray.getColor(0, -1871679376), paramTypedArray.getColor(1, -1871679376), paramTypedArray.getColor(2, -1871679376), paramTypedArray.getColor(3, -1871679376) };
    } else if (paramTypedArray.hasValue(0) && paramTypedArray.hasValue(1) && paramTypedArray.hasValue(2)) {
      this.C = new int[] { paramTypedArray.getColor(0, -1871679376), paramTypedArray.getColor(1, -1871679376), paramTypedArray.getColor(2, -1871679376) };
    } else if (paramTypedArray.hasValue(0) && paramTypedArray.hasValue(1)) {
      this.C = new int[] { paramTypedArray.getColor(0, -1871679376), paramTypedArray.getColor(1, -1871679376) };
    } else {
      this.C = new int[] { paramTypedArray.getColor(0, -1871679376), paramTypedArray.getColor(0, -1871679376) };
    } 
    setSpinBarColor(paramTypedArray.getColor(13, this.x));
    float f = paramTypedArray.getDimension(12, this.f);
    this.f = f;
    setSpinningBarLength(f);
    setTextSize((int)paramTypedArray.getDimension(18, -1.0F));
    setTextColor(paramTypedArray.getColor(16, -1));
    setUnitColor(paramTypedArray.getColor(20, -1));
    setText(paramTypedArray.getString(15));
    setRimColor(paramTypedArray.getColor(9, this.z));
    setFillColor(paramTypedArray.getColor(5, this.y));
    setContourColor(paramTypedArray.getColor(6, this.w));
    setContourSize(paramTypedArray.getDimension(7, this.o));
    setMaxValue(paramTypedArray.getDimension(8, this.d));
    setUnit(paramTypedArray.getString(19));
    setShowUnit(paramTypedArray.getBoolean(11, this.aj));
    setTextScale(paramTypedArray.getDimension(17, this.p));
    setUnitScale(paramTypedArray.getDimension(21, this.q));
    paramTypedArray.recycle();
  }
  
  private void a(Canvas paramCanvas) {
    if (this.e < 0.0F)
      this.e = 1.0F; 
    float f1 = this.g;
    float f2 = this.e;
    paramCanvas.drawArc(this.M, f1 - 90.0F - f2, f2, false, this.G);
  }
  
  private void a(Canvas paramCanvas, float paramFloat) {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: getfield M : Landroid/graphics/RectF;
    //   5: ldc_w -90.0
    //   8: fload_2
    //   9: iconst_0
    //   10: aload_0
    //   11: getfield F : Landroid/graphics/Paint;
    //   14: invokevirtual drawArc : (Landroid/graphics/RectF;FFZLandroid/graphics/Paint;)V
    //   17: aload_0
    //   18: getfield J : Landroid/graphics/Paint;
    //   21: astore #5
    //   23: iconst_1
    //   24: istore #4
    //   26: aload #5
    //   28: iconst_1
    //   29: invokevirtual setSubpixelText : (Z)V
    //   32: aload_0
    //   33: getfield J : Landroid/graphics/Paint;
    //   36: iconst_1
    //   37: invokevirtual setLinearText : (Z)V
    //   40: aload_0
    //   41: getfield J : Landroid/graphics/Paint;
    //   44: getstatic android/graphics/Typeface.MONOSPACE : Landroid/graphics/Typeface;
    //   47: invokevirtual setTypeface : (Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    //   50: pop
    //   51: aload_0
    //   52: getfield A : I
    //   55: iconst_m1
    //   56: if_icmpne -> 75
    //   59: aload_0
    //   60: getfield J : Landroid/graphics/Paint;
    //   63: aload_0
    //   64: aload_0
    //   65: getfield a : F
    //   68: f2d
    //   69: invokevirtual a : (D)I
    //   72: invokevirtual setColor : (I)V
    //   75: aload_0
    //   76: getfield ac : Ljava/lang/String;
    //   79: astore #5
    //   81: aload_0
    //   82: getfield af : Z
    //   85: ifeq -> 126
    //   88: aload_0
    //   89: getfield ah : Z
    //   92: ifeq -> 116
    //   95: ldc 100.0
    //   97: aload_0
    //   98: getfield d : F
    //   101: fdiv
    //   102: aload_0
    //   103: getfield a : F
    //   106: fmul
    //   107: f2i
    //   108: invokestatic valueOf : (I)Ljava/lang/String;
    //   111: astore #5
    //   113: goto -> 126
    //   116: aload_0
    //   117: getfield a : F
    //   120: f2i
    //   121: invokestatic valueOf : (I)Ljava/lang/String;
    //   124: astore #5
    //   126: aload_0
    //   127: getfield ag : Z
    //   130: ifeq -> 353
    //   133: aload_0
    //   134: getfield ae : I
    //   137: aload #5
    //   139: invokevirtual length : ()I
    //   142: if_icmpeq -> 371
    //   145: aload_0
    //   146: aload #5
    //   148: invokevirtual length : ()I
    //   151: putfield ae : I
    //   154: aload_0
    //   155: getfield ae : I
    //   158: iconst_1
    //   159: if_icmpne -> 228
    //   162: aload_0
    //   163: new android/graphics/RectF
    //   166: dup
    //   167: aload_0
    //   168: getfield N : Landroid/graphics/RectF;
    //   171: getfield left : F
    //   174: aload_0
    //   175: getfield N : Landroid/graphics/RectF;
    //   178: invokevirtual width : ()F
    //   181: ldc_w 0.1
    //   184: fmul
    //   185: fadd
    //   186: aload_0
    //   187: getfield N : Landroid/graphics/RectF;
    //   190: getfield top : F
    //   193: aload_0
    //   194: getfield N : Landroid/graphics/RectF;
    //   197: getfield right : F
    //   200: aload_0
    //   201: getfield N : Landroid/graphics/RectF;
    //   204: invokevirtual width : ()F
    //   207: ldc_w 0.1
    //   210: fmul
    //   211: fsub
    //   212: aload_0
    //   213: getfield N : Landroid/graphics/RectF;
    //   216: getfield bottom : F
    //   219: invokespecial <init> : (FFFF)V
    //   222: putfield N : Landroid/graphics/RectF;
    //   225: goto -> 240
    //   228: aload_0
    //   229: aload_0
    //   230: aload_0
    //   231: getfield M : Landroid/graphics/RectF;
    //   234: invokespecial a : (Landroid/graphics/RectF;)Landroid/graphics/RectF;
    //   237: putfield N : Landroid/graphics/RectF;
    //   240: aload_0
    //   241: getfield N : Landroid/graphics/RectF;
    //   244: astore #7
    //   246: aload #7
    //   248: astore #6
    //   250: aload_0
    //   251: getfield aj : Z
    //   254: ifeq -> 309
    //   257: new android/graphics/RectF
    //   260: dup
    //   261: aload #7
    //   263: getfield left : F
    //   266: aload_0
    //   267: getfield N : Landroid/graphics/RectF;
    //   270: getfield top : F
    //   273: aload_0
    //   274: getfield N : Landroid/graphics/RectF;
    //   277: getfield right : F
    //   280: aload_0
    //   281: getfield N : Landroid/graphics/RectF;
    //   284: invokevirtual width : ()F
    //   287: aload_0
    //   288: getfield ak : F
    //   291: fmul
    //   292: ldc_w 1.03
    //   295: fmul
    //   296: fsub
    //   297: aload_0
    //   298: getfield N : Landroid/graphics/RectF;
    //   301: getfield bottom : F
    //   304: invokespecial <init> : (FFFF)V
    //   307: astore #6
    //   309: aload_0
    //   310: getfield J : Landroid/graphics/Paint;
    //   313: astore #7
    //   315: aload #7
    //   317: aload #5
    //   319: aload #7
    //   321: aload #6
    //   323: invokestatic a : (Ljava/lang/String;Landroid/graphics/Paint;Landroid/graphics/RectF;)F
    //   326: aload_0
    //   327: getfield p : F
    //   330: fmul
    //   331: invokevirtual setTextSize : (F)V
    //   334: aload_0
    //   335: aload_0
    //   336: aload #5
    //   338: aload_0
    //   339: getfield J : Landroid/graphics/Paint;
    //   342: aload #6
    //   344: invokespecial b : (Ljava/lang/String;Landroid/graphics/Paint;Landroid/graphics/RectF;)Landroid/graphics/RectF;
    //   347: putfield O : Landroid/graphics/RectF;
    //   350: goto -> 374
    //   353: aload_0
    //   354: aload_0
    //   355: aload #5
    //   357: aload_0
    //   358: getfield J : Landroid/graphics/Paint;
    //   361: aload_0
    //   362: getfield M : Landroid/graphics/RectF;
    //   365: invokespecial b : (Ljava/lang/String;Landroid/graphics/Paint;Landroid/graphics/RectF;)Landroid/graphics/RectF;
    //   368: putfield O : Landroid/graphics/RectF;
    //   371: iconst_0
    //   372: istore #4
    //   374: aload_0
    //   375: getfield ai : Z
    //   378: ifeq -> 613
    //   381: aload_1
    //   382: aload #5
    //   384: aload_0
    //   385: getfield O : Landroid/graphics/RectF;
    //   388: getfield left : F
    //   391: aload_0
    //   392: getfield J : Landroid/graphics/Paint;
    //   395: invokevirtual getTextSize : ()F
    //   398: ldc_w 0.09
    //   401: fmul
    //   402: fsub
    //   403: aload_0
    //   404: getfield O : Landroid/graphics/RectF;
    //   407: getfield bottom : F
    //   410: aload_0
    //   411: getfield J : Landroid/graphics/Paint;
    //   414: invokevirtual drawText : (Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   417: aload_0
    //   418: getfield aj : Z
    //   421: ifeq -> 613
    //   424: aload_0
    //   425: getfield B : I
    //   428: iconst_m1
    //   429: if_icmpne -> 448
    //   432: aload_0
    //   433: getfield K : Landroid/graphics/Paint;
    //   436: aload_0
    //   437: aload_0
    //   438: getfield a : F
    //   441: f2d
    //   442: invokevirtual a : (D)I
    //   445: invokevirtual setColor : (I)V
    //   448: iload #4
    //   450: ifeq -> 587
    //   453: aload_0
    //   454: new android/graphics/RectF
    //   457: dup
    //   458: aload_0
    //   459: getfield N : Landroid/graphics/RectF;
    //   462: getfield left : F
    //   465: aload_0
    //   466: getfield N : Landroid/graphics/RectF;
    //   469: invokevirtual width : ()F
    //   472: fconst_1
    //   473: aload_0
    //   474: getfield ak : F
    //   477: fsub
    //   478: fmul
    //   479: ldc_w 1.03
    //   482: fmul
    //   483: fadd
    //   484: aload_0
    //   485: getfield N : Landroid/graphics/RectF;
    //   488: getfield top : F
    //   491: aload_0
    //   492: getfield N : Landroid/graphics/RectF;
    //   495: getfield right : F
    //   498: aload_0
    //   499: getfield N : Landroid/graphics/RectF;
    //   502: getfield bottom : F
    //   505: invokespecial <init> : (FFFF)V
    //   508: putfield P : Landroid/graphics/RectF;
    //   511: aload_0
    //   512: getfield K : Landroid/graphics/Paint;
    //   515: astore #5
    //   517: aload #5
    //   519: aload_0
    //   520: getfield ad : Ljava/lang/String;
    //   523: aload #5
    //   525: aload_0
    //   526: getfield P : Landroid/graphics/RectF;
    //   529: invokestatic a : (Ljava/lang/String;Landroid/graphics/Paint;Landroid/graphics/RectF;)F
    //   532: aload_0
    //   533: getfield q : F
    //   536: fmul
    //   537: invokevirtual setTextSize : (F)V
    //   540: aload_0
    //   541: aload_0
    //   542: aload_0
    //   543: getfield ad : Ljava/lang/String;
    //   546: aload_0
    //   547: getfield K : Landroid/graphics/Paint;
    //   550: aload_0
    //   551: getfield P : Landroid/graphics/RectF;
    //   554: invokespecial b : (Ljava/lang/String;Landroid/graphics/Paint;Landroid/graphics/RectF;)Landroid/graphics/RectF;
    //   557: putfield P : Landroid/graphics/RectF;
    //   560: aload_0
    //   561: getfield O : Landroid/graphics/RectF;
    //   564: getfield top : F
    //   567: fstore_2
    //   568: aload_0
    //   569: getfield P : Landroid/graphics/RectF;
    //   572: getfield top : F
    //   575: fstore_3
    //   576: aload_0
    //   577: getfield P : Landroid/graphics/RectF;
    //   580: fconst_0
    //   581: fload_2
    //   582: fload_3
    //   583: fsub
    //   584: invokevirtual offset : (FF)V
    //   587: aload_1
    //   588: aload_0
    //   589: getfield ad : Ljava/lang/String;
    //   592: aload_0
    //   593: getfield P : Landroid/graphics/RectF;
    //   596: getfield left : F
    //   599: aload_0
    //   600: getfield P : Landroid/graphics/RectF;
    //   603: getfield bottom : F
    //   606: aload_0
    //   607: getfield K : Landroid/graphics/Paint;
    //   610: invokevirtual drawText : (Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   613: return
  }
  
  private RectF b(String paramString, Paint paramPaint, RectF paramRectF) {
    Rect rect = new Rect();
    paramPaint.getTextBounds(paramString, 0, paramString.length(), rect);
    RectF rectF = new RectF();
    paramRectF.left += (paramRectF.width() - rect.width()) / 2.0F;
    paramRectF.top += (paramRectF.height() - rect.height()) / 2.0F;
    rectF.right = rectF.left + rect.width();
    rectF.bottom = rectF.top + rect.height();
    return rectF;
  }
  
  private void e() {
    int i = Math.min(this.i, this.h);
    int j = this.i;
    int m = this.h;
    int k = getPaddingTop();
    m = (m - i) / 2;
    this.r = k + m;
    this.s = getPaddingBottom() + m;
    k = getPaddingLeft();
    i = (j - i) / 2;
    this.t = k + i;
    this.u = getPaddingRight() + i;
    i = getWidth();
    j = getHeight();
    k = this.t;
    m = this.l;
    this.M = new RectF((k + m), (this.r + m), (i - this.u - m), (j - this.s - m));
    this.N = a(this.M);
    this.R = new RectF(this.M.left + this.m / 2.0F + this.o / 2.0F, this.M.top + this.m / 2.0F + this.o / 2.0F, this.M.right - this.m / 2.0F - this.o / 2.0F, this.M.bottom - this.m / 2.0F - this.o / 2.0F);
    this.Q = new RectF(this.M.left - this.m / 2.0F - this.o / 2.0F, this.M.top - this.m / 2.0F - this.o / 2.0F, this.M.right + this.m / 2.0F + this.o / 2.0F, this.M.bottom + this.m / 2.0F + this.o / 2.0F);
    j = this.u;
    k = this.l;
    this.j = (i - j - k) / 2;
    this.k = this.j - k + 1;
  }
  
  public int a(double paramDouble) {
    double d = 1.0D / getMaxValue();
    int[] arrayOfInt = this.C;
    int j = (int)(arrayOfInt.length * d * paramDouble);
    int i = j;
    if (j >= arrayOfInt.length)
      i = arrayOfInt.length - 1; 
    return arrayOfInt[i];
  }
  
  public void a(float paramFloat, long paramLong) {
    this.T = paramLong;
    Message message = new Message();
    message.what = AnimationMsg.d.ordinal();
    message.obj = new float[] { this.a, paramFloat };
    this.W.sendMessage(message);
  }
  
  public boolean a() {
    return this.aj;
  }
  
  public void b() {
    this.F.setShader((Shader)new SweepGradient(this.M.centerX(), this.M.centerY(), this.C, null));
    Matrix matrix = new Matrix();
    this.F.getShader().getLocalMatrix(matrix);
    matrix.postTranslate(-this.M.centerX(), -this.M.centerY());
    matrix.postRotate(-90.0F);
    matrix.postTranslate(this.M.centerX(), this.M.centerY());
    this.F.getShader().setLocalMatrix(matrix);
    this.F.setAntiAlias(true);
    this.F.setStrokeCap(this.D);
    this.F.setStyle(Paint.Style.STROKE);
    this.F.setStrokeWidth(this.l);
    this.G.setAntiAlias(true);
    this.G.setStrokeCap(this.E);
    this.G.setStyle(Paint.Style.STROKE);
    this.G.setStrokeWidth(this.l);
    this.G.setColor(this.x);
    this.I.setColor(this.z);
    this.I.setAntiAlias(true);
    this.I.setStyle(Paint.Style.STROKE);
    this.I.setStrokeWidth(this.m);
    this.H.setColor(this.y);
    this.H.setAntiAlias(true);
    this.H.setStyle(Paint.Style.FILL);
    this.J.setColor(this.A);
    this.J.setStyle(Paint.Style.FILL);
    this.J.setAntiAlias(true);
    this.J.setTextSize(getTextSize());
    this.K.setColor(this.B);
    this.K.setStyle(Paint.Style.FILL);
    this.K.setAntiAlias(true);
    this.K.setTextSize(getTextSize());
    this.L.setColor(this.w);
    this.L.setAntiAlias(true);
    this.L.setStyle(Paint.Style.STROKE);
    this.L.setStrokeWidth(this.o);
  }
  
  public void c() {
    this.W.sendEmptyMessage(AnimationMsg.b.ordinal());
  }
  
  public void d() {
    this.W.sendEmptyMessage(AnimationMsg.a.ordinal());
  }
  
  public int[] getBarColors() {
    return this.C;
  }
  
  public Paint.Cap getBarStrokeCap() {
    return this.D;
  }
  
  public int getBarWidth() {
    return this.l;
  }
  
  public int getCircleRadius() {
    return this.k;
  }
  
  public int getContourColor() {
    return this.w;
  }
  
  public float getContourSize() {
    return this.o;
  }
  
  public int getDelayMillis() {
    return this.U;
  }
  
  public int getFillColor() {
    return this.y;
  }
  
  public double getMaxValue() {
    return this.d;
  }
  
  public int getPaddingBottom() {
    return this.s;
  }
  
  public int getPaddingLeft() {
    return this.t;
  }
  
  public int getPaddingRight() {
    return this.u;
  }
  
  public int getPaddingTop() {
    return this.r;
  }
  
  public int getRimColor() {
    return this.z;
  }
  
  public Shader getRimShader() {
    return this.I.getShader();
  }
  
  public int getRimWidth() {
    return this.m;
  }
  
  public float getSpinSpeed() {
    return this.S;
  }
  
  public Paint.Cap getSpinnerStrokeCap() {
    return this.E;
  }
  
  public int getTextColor() {
    return this.A;
  }
  
  public float getTextScale() {
    return this.p;
  }
  
  public int getTextSize() {
    return this.n;
  }
  
  public String getUnit() {
    return this.ad;
  }
  
  public float getUnitScale() {
    return this.q;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    float f = 360.0F / this.d * this.a;
    paramCanvas.drawArc(this.M, 360.0F, 360.0F, false, this.H);
    if (this.m > 0)
      paramCanvas.drawArc(this.M, 360.0F, 360.0F, false, this.I); 
    if (this.o > 0.0F) {
      paramCanvas.drawArc(this.Q, 360.0F, 360.0F, false, this.L);
      paramCanvas.drawArc(this.R, 360.0F, 360.0F, false, this.L);
    } 
    if (this.aa == AnimationState.b || this.aa == AnimationState.c) {
      a(paramCanvas);
      return;
    } 
    if (this.aa == AnimationState.d) {
      a(paramCanvas);
      if (this.V) {
        a(paramCanvas, f);
        return;
      } 
    } else {
      a(paramCanvas, f);
      return;
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = getMeasuredWidth();
    paramInt1 = getMeasuredHeight();
    paramInt2 = paramInt2 - getPaddingLeft() - getPaddingRight();
    int i = paramInt1 - getPaddingTop() - getPaddingBottom();
    paramInt1 = paramInt2;
    if (paramInt2 > i)
      paramInt1 = i; 
    setMeasuredDimension(getPaddingLeft() + paramInt1 + getPaddingRight(), paramInt1 + getPaddingTop() + getPaddingBottom());
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.i = paramInt1;
    this.h = paramInt2;
    e();
    b();
    invalidate();
  }
  
  public void setBarColor(int... paramVarArgs) {
    if (paramVarArgs.length == 1) {
      this.C = new int[] { paramVarArgs[0], paramVarArgs[0] };
      return;
    } 
    this.C = paramVarArgs;
  }
  
  public void setBarStrokeCap(Paint.Cap paramCap) {
    this.D = paramCap;
  }
  
  public void setBarWidth(int paramInt) {
    this.l = paramInt;
  }
  
  public void setContourColor(int paramInt) {
    this.w = paramInt;
  }
  
  public void setContourSize(float paramFloat) {
    this.o = paramFloat;
  }
  
  public void setDelayMillis(int paramInt) {
    this.U = paramInt;
  }
  
  public void setFillColor(int paramInt) {
    this.y = paramInt;
  }
  
  public void setMaxValue(float paramFloat) {
    this.d = paramFloat;
  }
  
  public void setPaddingBottom(int paramInt) {
    this.s = paramInt;
  }
  
  public void setPaddingLeft(int paramInt) {
    this.t = paramInt;
  }
  
  public void setPaddingRight(int paramInt) {
    this.u = paramInt;
  }
  
  public void setPaddingTop(int paramInt) {
    this.r = paramInt;
  }
  
  public void setRimColor(int paramInt) {
    this.z = paramInt;
  }
  
  public void setRimShader(Shader paramShader) {
    this.I.setShader(paramShader);
  }
  
  public void setRimWidth(int paramInt) {
    this.m = paramInt;
  }
  
  public void setShowPercentAsAutoValue(boolean paramBoolean) {
    this.ah = paramBoolean;
  }
  
  public void setShowUnit(boolean paramBoolean) {
    this.aj = paramBoolean;
    this.ae = 0;
    invalidate();
    this.N = a(this.M);
  }
  
  public void setSpinBarColor(int paramInt) {
    this.x = paramInt;
  }
  
  public void setSpinSpeed(float paramFloat) {
    this.S = paramFloat;
  }
  
  public void setSpinnerStrokeCap(Paint.Cap paramCap) {
    this.E = paramCap;
  }
  
  public void setSpinningBarLength(float paramFloat) {
    this.f = paramFloat;
    this.e = paramFloat;
  }
  
  public void setText(String paramString) {
    if (paramString == null || paramString.isEmpty()) {
      this.ac = "";
      this.af = true;
    } else {
      this.ac = paramString;
      this.af = false;
    } 
    invalidate();
  }
  
  public void setTextColor(int paramInt) {
    this.A = paramInt;
  }
  
  public void setTextScale(float paramFloat) {
    this.p = paramFloat;
  }
  
  public void setTextSize(int paramInt) {
    if (paramInt > 0) {
      this.n = paramInt;
      this.ag = false;
      return;
    } 
    this.ag = true;
  }
  
  public void setUnit(String paramString) {
    if (paramString == null) {
      this.ad = "";
    } else {
      this.ad = paramString;
    } 
    invalidate();
  }
  
  public void setUnitColor(int paramInt) {
    this.B = paramInt;
  }
  
  public void setUnitScale(float paramFloat) {
    this.q = paramFloat;
  }
  
  public void setValue(float paramFloat) {
    Message message = new Message();
    message.what = AnimationMsg.c.ordinal();
    message.obj = new float[] { paramFloat, paramFloat };
    this.W.sendMessage(message);
  }
  
  public void setValueAnimated(float paramFloat) {
    this.T = 1200.0D;
    Message message = new Message();
    message.what = AnimationMsg.d.ordinal();
    message.obj = new float[] { this.a, paramFloat };
    this.W.sendMessage(message);
  }
  
  static class AnimationHandler extends Handler {
    private final WeakReference<CircleProgressView> a;
    
    private float b;
    
    private long c;
    
    private long d;
    
    private DecelerateInterpolator e = new DecelerateInterpolator();
    
    private double f;
    
    AnimationHandler(CircleProgressView param1CircleProgressView) {
      super(param1CircleProgressView.getContext().getMainLooper());
      this.a = new WeakReference<CircleProgressView>(param1CircleProgressView);
    }
    
    private void a(Message param1Message, CircleProgressView param1CircleProgressView) {
      CircleProgressView.c(param1CircleProgressView, ((float[])param1Message.obj)[0]);
      CircleProgressView.d(param1CircleProgressView, ((float[])param1Message.obj)[1]);
      this.c = System.currentTimeMillis();
      CircleProgressView.a(param1CircleProgressView, CircleProgressView.AnimationState.e);
      CircleProgressView.g(param1CircleProgressView).sendEmptyMessageDelayed(CircleProgressView.AnimationMsg.e.ordinal(), CircleProgressView.f(param1CircleProgressView));
    }
    
    private void a(CircleProgressView param1CircleProgressView) {
      CircleProgressView.a(param1CircleProgressView, CircleProgressView.AnimationState.c);
      b(param1CircleProgressView);
      CircleProgressView.g(param1CircleProgressView).sendEmptyMessageDelayed(CircleProgressView.AnimationMsg.e.ordinal(), CircleProgressView.f(param1CircleProgressView));
    }
    
    private void a(CircleProgressView param1CircleProgressView, Message param1Message) {
      CircleProgressView.a(param1CircleProgressView, CircleProgressView.AnimationState.d);
      CircleProgressView.c(param1CircleProgressView, 0.0F);
      CircleProgressView.d(param1CircleProgressView, ((float[])param1Message.obj)[1]);
      this.d = System.currentTimeMillis();
      this.b = CircleProgressView.b(param1CircleProgressView);
      CircleProgressView.g(param1CircleProgressView).sendEmptyMessageDelayed(CircleProgressView.AnimationMsg.e.ordinal(), CircleProgressView.f(param1CircleProgressView));
    }
    
    private void b(Message param1Message, CircleProgressView param1CircleProgressView) {
      CircleProgressView.c(param1CircleProgressView, CircleProgressView.j(param1CircleProgressView));
      CircleProgressView.e(param1CircleProgressView, CircleProgressView.d(param1CircleProgressView, ((float[])param1Message.obj)[0]));
      CircleProgressView.a(param1CircleProgressView, CircleProgressView.AnimationState.a);
      param1CircleProgressView.invalidate();
    }
    
    private void b(CircleProgressView param1CircleProgressView) {
      this.f = (CircleProgressView.b(param1CircleProgressView) / CircleProgressView.e(param1CircleProgressView) * CircleProgressView.f(param1CircleProgressView) * 2.0F);
      this.d = System.currentTimeMillis();
      this.b = CircleProgressView.b(param1CircleProgressView);
    }
    
    private void c(CircleProgressView param1CircleProgressView) {
      CircleProgressView.a(param1CircleProgressView, CircleProgressView.AnimationState.b);
      CircleProgressView.a(param1CircleProgressView, 360.0F / CircleProgressView.k(param1CircleProgressView) * CircleProgressView.i(param1CircleProgressView));
      CircleProgressView.b(param1CircleProgressView, 360.0F / CircleProgressView.k(param1CircleProgressView) * CircleProgressView.i(param1CircleProgressView));
      this.d = System.currentTimeMillis();
      this.b = CircleProgressView.b(param1CircleProgressView);
      this.f = (CircleProgressView.c(param1CircleProgressView) / CircleProgressView.e(param1CircleProgressView) * CircleProgressView.f(param1CircleProgressView) * 2.0F);
      CircleProgressView.g(param1CircleProgressView).sendEmptyMessageDelayed(CircleProgressView.AnimationMsg.e.ordinal(), CircleProgressView.f(param1CircleProgressView));
    }
    
    private boolean d(CircleProgressView param1CircleProgressView) {
      float f2 = (float)((System.currentTimeMillis() - this.c) / CircleProgressView.l(param1CircleProgressView));
      float f1 = f2;
      if (f2 > 1.0F)
        f1 = 1.0F; 
      f2 = CircleProgressView.m(param1CircleProgressView).getInterpolation(f1);
      CircleProgressView.e(param1CircleProgressView, CircleProgressView.n(param1CircleProgressView) + (CircleProgressView.j(param1CircleProgressView) - CircleProgressView.n(param1CircleProgressView)) * f2);
      return (f1 >= 1.0F);
    }
    
    public void handleMessage(Message param1Message) {
      CircleProgressView circleProgressView = this.a.get();
      if (circleProgressView == null)
        return; 
      CircleProgressView.AnimationMsg animationMsg = CircleProgressView.AnimationMsg.values()[param1Message.what];
      if (animationMsg == CircleProgressView.AnimationMsg.e)
        removeMessages(CircleProgressView.AnimationMsg.e.ordinal()); 
      int i = CircleProgressView.null.b[CircleProgressView.a(circleProgressView).ordinal()];
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i != 4) {
              if (i != 5)
                return; 
              i = CircleProgressView.null.a[animationMsg.ordinal()];
              if (i != 1) {
                if (i != 2) {
                  if (i != 3) {
                    if (i != 4) {
                      if (i != 5)
                        return; 
                      if (d(circleProgressView)) {
                        CircleProgressView.a(circleProgressView, CircleProgressView.AnimationState.a);
                        CircleProgressView.e(circleProgressView, CircleProgressView.j(circleProgressView));
                      } 
                      CircleProgressView.g(circleProgressView).sendEmptyMessageDelayed(CircleProgressView.AnimationMsg.e.ordinal(), CircleProgressView.f(circleProgressView));
                      circleProgressView.invalidate();
                      return;
                    } 
                    this.c = System.currentTimeMillis();
                    CircleProgressView.c(circleProgressView, CircleProgressView.i(circleProgressView));
                    CircleProgressView.d(circleProgressView, ((float[])param1Message.obj)[1]);
                    return;
                  } 
                  b(param1Message, circleProgressView);
                  return;
                } 
              } else {
                c(circleProgressView);
                return;
              } 
            } else {
              i = CircleProgressView.null.a[animationMsg.ordinal()];
              if (i != 1) {
                if (i != 2) {
                  if (i != 3) {
                    if (i != 4) {
                      if (i != 5)
                        return; 
                      if (CircleProgressView.b(circleProgressView) > CircleProgressView.c(circleProgressView) && !CircleProgressView.h(circleProgressView)) {
                        float f2 = (float)((System.currentTimeMillis() - this.d) / this.f);
                        float f1 = f2;
                        if (f2 > 1.0F)
                          f1 = 1.0F; 
                        f1 = this.e.getInterpolation(f1);
                        CircleProgressView.a(circleProgressView, this.b * (1.0F - f1));
                      } 
                      CircleProgressView.b(circleProgressView, CircleProgressView.d(circleProgressView) + CircleProgressView.e(circleProgressView));
                      if (CircleProgressView.d(circleProgressView) > 360.0F && !CircleProgressView.h(circleProgressView)) {
                        this.c = System.currentTimeMillis();
                        CircleProgressView.a(circleProgressView, true);
                        b(circleProgressView);
                      } 
                      if (CircleProgressView.h(circleProgressView)) {
                        CircleProgressView.b(circleProgressView, 360.0F);
                        CircleProgressView.a(circleProgressView, CircleProgressView.b(circleProgressView) - CircleProgressView.e(circleProgressView));
                        d(circleProgressView);
                        float f2 = (float)((System.currentTimeMillis() - this.d) / this.f);
                        float f1 = f2;
                        if (f2 > 1.0F)
                          f1 = 1.0F; 
                        f1 = this.e.getInterpolation(f1);
                        CircleProgressView.a(circleProgressView, this.b * (1.0F - f1));
                      } 
                      if (CircleProgressView.b(circleProgressView) < 0.1D) {
                        CircleProgressView.a(circleProgressView, CircleProgressView.AnimationState.e);
                        circleProgressView.invalidate();
                        CircleProgressView.a(circleProgressView, false);
                        CircleProgressView.a(circleProgressView, CircleProgressView.c(circleProgressView));
                      } else {
                        circleProgressView.invalidate();
                      } 
                      CircleProgressView.g(circleProgressView).sendEmptyMessageDelayed(CircleProgressView.AnimationMsg.e.ordinal(), CircleProgressView.f(circleProgressView));
                      return;
                    } 
                    CircleProgressView.c(circleProgressView, 0.0F);
                    CircleProgressView.d(circleProgressView, ((float[])param1Message.obj)[1]);
                    CircleProgressView.g(circleProgressView).sendEmptyMessageDelayed(CircleProgressView.AnimationMsg.e.ordinal(), CircleProgressView.f(circleProgressView));
                    return;
                  } 
                  CircleProgressView.a(circleProgressView, false);
                  b(param1Message, circleProgressView);
                  return;
                } 
              } else {
                CircleProgressView.a(circleProgressView, false);
                c(circleProgressView);
                return;
              } 
            } 
          } else {
            i = CircleProgressView.null.a[animationMsg.ordinal()];
            if (i != 1) {
              if (i != 2) {
                if (i != 3) {
                  if (i != 4) {
                    if (i != 5)
                      return; 
                    float f2 = (float)((System.currentTimeMillis() - this.d) / this.f);
                    float f1 = f2;
                    if (f2 > 1.0F)
                      f1 = 1.0F; 
                    f1 = this.e.getInterpolation(f1);
                    CircleProgressView.a(circleProgressView, this.b * (1.0F - f1));
                    CircleProgressView.b(circleProgressView, CircleProgressView.d(circleProgressView) + CircleProgressView.e(circleProgressView));
                    if (CircleProgressView.b(circleProgressView) < 0.01F)
                      CircleProgressView.a(circleProgressView, CircleProgressView.AnimationState.a); 
                    CircleProgressView.g(circleProgressView).sendEmptyMessageDelayed(CircleProgressView.AnimationMsg.e.ordinal(), CircleProgressView.f(circleProgressView));
                    circleProgressView.invalidate();
                    return;
                  } 
                  a(circleProgressView, param1Message);
                  return;
                } 
                b(param1Message, circleProgressView);
                return;
              } 
            } else {
              CircleProgressView.a(circleProgressView, CircleProgressView.AnimationState.b);
              CircleProgressView.g(circleProgressView).sendEmptyMessageDelayed(CircleProgressView.AnimationMsg.e.ordinal(), CircleProgressView.f(circleProgressView));
              return;
            } 
          } 
        } else {
          i = CircleProgressView.null.a[animationMsg.ordinal()];
          if (i != 1) {
            if (i != 2) {
              if (i != 3) {
                if (i != 4) {
                  if (i != 5)
                    return; 
                  float f3 = CircleProgressView.b(circleProgressView);
                  float f4 = CircleProgressView.c(circleProgressView);
                  float f2 = (float)((System.currentTimeMillis() - this.d) / this.f);
                  float f1 = f2;
                  if (f2 > 1.0F)
                    f1 = 1.0F; 
                  f1 = this.e.getInterpolation(f1);
                  if (Math.abs(f3 - f4) < 1.0F) {
                    CircleProgressView.a(circleProgressView, CircleProgressView.c(circleProgressView));
                  } else if (CircleProgressView.b(circleProgressView) < CircleProgressView.c(circleProgressView)) {
                    CircleProgressView.a(circleProgressView, this.b + (CircleProgressView.c(circleProgressView) - this.b) * f1);
                  } else {
                    f2 = this.b;
                    CircleProgressView.a(circleProgressView, f2 - (f2 - CircleProgressView.c(circleProgressView)) * f1);
                  } 
                  CircleProgressView.b(circleProgressView, CircleProgressView.d(circleProgressView) + CircleProgressView.e(circleProgressView));
                  if (CircleProgressView.d(circleProgressView) > 360.0F)
                    CircleProgressView.b(circleProgressView, 0.0F); 
                  CircleProgressView.g(circleProgressView).sendEmptyMessageDelayed(CircleProgressView.AnimationMsg.e.ordinal(), CircleProgressView.f(circleProgressView));
                  circleProgressView.invalidate();
                  return;
                } 
                a(circleProgressView, param1Message);
                return;
              } 
              b(param1Message, circleProgressView);
              return;
            } 
            a(circleProgressView);
            return;
          } 
        } 
      } else {
        i = CircleProgressView.null.a[animationMsg.ordinal()];
        if (i != 1) {
          if (i != 2) {
            if (i != 3) {
              if (i != 4) {
                if (i != 5)
                  return; 
                removeMessages(CircleProgressView.AnimationMsg.e.ordinal());
                return;
              } 
              a(param1Message, circleProgressView);
              return;
            } 
            b(param1Message, circleProgressView);
            return;
          } 
        } else {
          c(circleProgressView);
        } 
      } 
    }
  }
  
  enum AnimationMsg {
    a, b, c, d, e;
  }
  
  enum AnimationState {
    a, b, c, d, e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\CircleProgressView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */