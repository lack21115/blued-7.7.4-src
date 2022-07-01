package com.blued.android.module.live.base.view;

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
import com.blued.android.module.live.base.R;
import java.lang.ref.WeakReference;

public class LiveCircleProgressView extends View {
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
  
  public LiveCircleProgressView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LiveCircleProgressView));
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
    setBarWidth((int)paramTypedArray.getDimension(R.styleable.LiveCircleProgressView_barWidth, this.l));
    setRimWidth((int)paramTypedArray.getDimension(R.styleable.LiveCircleProgressView_rimWidth, this.m));
    setSpinSpeed((int)paramTypedArray.getDimension(R.styleable.LiveCircleProgressView_spinSpeed, this.S));
    if (paramTypedArray.hasValue(R.styleable.LiveCircleProgressView_barColor) && paramTypedArray.hasValue(R.styleable.LiveCircleProgressView_barColor1) && paramTypedArray.hasValue(R.styleable.LiveCircleProgressView_barColor2) && paramTypedArray.hasValue(R.styleable.LiveCircleProgressView_barColor3)) {
      this.C = new int[] { paramTypedArray.getColor(R.styleable.LiveCircleProgressView_barColor, -1871679376), paramTypedArray.getColor(R.styleable.LiveCircleProgressView_barColor1, -1871679376), paramTypedArray.getColor(R.styleable.LiveCircleProgressView_barColor2, -1871679376), paramTypedArray.getColor(R.styleable.LiveCircleProgressView_barColor3, -1871679376) };
    } else if (paramTypedArray.hasValue(R.styleable.LiveCircleProgressView_barColor) && paramTypedArray.hasValue(R.styleable.LiveCircleProgressView_barColor1) && paramTypedArray.hasValue(R.styleable.LiveCircleProgressView_barColor2)) {
      this.C = new int[] { paramTypedArray.getColor(R.styleable.LiveCircleProgressView_barColor, -1871679376), paramTypedArray.getColor(R.styleable.LiveCircleProgressView_barColor1, -1871679376), paramTypedArray.getColor(R.styleable.LiveCircleProgressView_barColor2, -1871679376) };
    } else if (paramTypedArray.hasValue(R.styleable.LiveCircleProgressView_barColor) && paramTypedArray.hasValue(R.styleable.LiveCircleProgressView_barColor1)) {
      this.C = new int[] { paramTypedArray.getColor(R.styleable.LiveCircleProgressView_barColor, -1871679376), paramTypedArray.getColor(R.styleable.LiveCircleProgressView_barColor1, -1871679376) };
    } else {
      this.C = new int[] { paramTypedArray.getColor(R.styleable.LiveCircleProgressView_barColor, -1871679376), paramTypedArray.getColor(R.styleable.LiveCircleProgressView_barColor, -1871679376) };
    } 
    setSpinBarColor(paramTypedArray.getColor(R.styleable.LiveCircleProgressView_spinColor, this.x));
    float f = paramTypedArray.getDimension(R.styleable.LiveCircleProgressView_spinBarLength, this.f);
    this.f = f;
    setSpinningBarLength(f);
    setTextSize((int)paramTypedArray.getDimension(R.styleable.LiveCircleProgressView_textSize, -1.0F));
    setTextColor(paramTypedArray.getColor(R.styleable.LiveCircleProgressView_textColor, -1));
    setUnitColor(paramTypedArray.getColor(R.styleable.LiveCircleProgressView_unitColor, -1));
    setText(paramTypedArray.getString(R.styleable.LiveCircleProgressView_text));
    setRimColor(paramTypedArray.getColor(R.styleable.LiveCircleProgressView_rimColor, this.z));
    setFillColor(paramTypedArray.getColor(R.styleable.LiveCircleProgressView_circleFillColor, this.y));
    setContourColor(paramTypedArray.getColor(R.styleable.LiveCircleProgressView_contourColor, this.w));
    setContourSize(paramTypedArray.getDimension(R.styleable.LiveCircleProgressView_contourSize, this.o));
    setMaxValue(paramTypedArray.getDimension(R.styleable.LiveCircleProgressView_maxValue, this.d));
    setUnit(paramTypedArray.getString(R.styleable.LiveCircleProgressView_unit));
    setShowUnit(paramTypedArray.getBoolean(R.styleable.LiveCircleProgressView_showUnit, this.aj));
    setTextScale(paramTypedArray.getDimension(R.styleable.LiveCircleProgressView_textScale, this.p));
    setUnitScale(paramTypedArray.getDimension(R.styleable.LiveCircleProgressView_unitScale, this.q));
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
  
  private void c() {
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
  
  public void a(float paramFloat1, float paramFloat2, long paramLong) {
    this.T = paramLong;
    Message message = new Message();
    message.what = AnimationMsg.d.ordinal();
    message.obj = new float[] { paramFloat1, paramFloat2 };
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
    c();
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
    private final WeakReference<LiveCircleProgressView> a;
    
    private float b;
    
    private long c;
    
    private long d;
    
    private DecelerateInterpolator e = new DecelerateInterpolator();
    
    private double f;
    
    AnimationHandler(LiveCircleProgressView param1LiveCircleProgressView) {
      super(param1LiveCircleProgressView.getContext().getMainLooper());
      this.a = new WeakReference<LiveCircleProgressView>(param1LiveCircleProgressView);
    }
    
    private void a(Message param1Message, LiveCircleProgressView param1LiveCircleProgressView) {
      LiveCircleProgressView.c(param1LiveCircleProgressView, ((float[])param1Message.obj)[0]);
      LiveCircleProgressView.d(param1LiveCircleProgressView, ((float[])param1Message.obj)[1]);
      this.c = System.currentTimeMillis();
      LiveCircleProgressView.a(param1LiveCircleProgressView, LiveCircleProgressView.AnimationState.e);
      LiveCircleProgressView.g(param1LiveCircleProgressView).sendEmptyMessageDelayed(LiveCircleProgressView.AnimationMsg.e.ordinal(), LiveCircleProgressView.f(param1LiveCircleProgressView));
    }
    
    private void a(LiveCircleProgressView param1LiveCircleProgressView) {
      LiveCircleProgressView.a(param1LiveCircleProgressView, LiveCircleProgressView.AnimationState.c);
      b(param1LiveCircleProgressView);
      LiveCircleProgressView.g(param1LiveCircleProgressView).sendEmptyMessageDelayed(LiveCircleProgressView.AnimationMsg.e.ordinal(), LiveCircleProgressView.f(param1LiveCircleProgressView));
    }
    
    private void a(LiveCircleProgressView param1LiveCircleProgressView, Message param1Message) {
      LiveCircleProgressView.a(param1LiveCircleProgressView, LiveCircleProgressView.AnimationState.d);
      LiveCircleProgressView.c(param1LiveCircleProgressView, 0.0F);
      LiveCircleProgressView.d(param1LiveCircleProgressView, ((float[])param1Message.obj)[1]);
      this.d = System.currentTimeMillis();
      this.b = LiveCircleProgressView.b(param1LiveCircleProgressView);
      LiveCircleProgressView.g(param1LiveCircleProgressView).sendEmptyMessageDelayed(LiveCircleProgressView.AnimationMsg.e.ordinal(), LiveCircleProgressView.f(param1LiveCircleProgressView));
    }
    
    private void b(Message param1Message, LiveCircleProgressView param1LiveCircleProgressView) {
      LiveCircleProgressView.c(param1LiveCircleProgressView, LiveCircleProgressView.j(param1LiveCircleProgressView));
      LiveCircleProgressView.e(param1LiveCircleProgressView, LiveCircleProgressView.d(param1LiveCircleProgressView, ((float[])param1Message.obj)[0]));
      LiveCircleProgressView.a(param1LiveCircleProgressView, LiveCircleProgressView.AnimationState.a);
      param1LiveCircleProgressView.invalidate();
    }
    
    private void b(LiveCircleProgressView param1LiveCircleProgressView) {
      this.f = (LiveCircleProgressView.b(param1LiveCircleProgressView) / LiveCircleProgressView.e(param1LiveCircleProgressView) * LiveCircleProgressView.f(param1LiveCircleProgressView) * 2.0F);
      this.d = System.currentTimeMillis();
      this.b = LiveCircleProgressView.b(param1LiveCircleProgressView);
    }
    
    private void c(LiveCircleProgressView param1LiveCircleProgressView) {
      LiveCircleProgressView.a(param1LiveCircleProgressView, LiveCircleProgressView.AnimationState.b);
      LiveCircleProgressView.a(param1LiveCircleProgressView, 360.0F / LiveCircleProgressView.k(param1LiveCircleProgressView) * LiveCircleProgressView.i(param1LiveCircleProgressView));
      LiveCircleProgressView.b(param1LiveCircleProgressView, 360.0F / LiveCircleProgressView.k(param1LiveCircleProgressView) * LiveCircleProgressView.i(param1LiveCircleProgressView));
      this.d = System.currentTimeMillis();
      this.b = LiveCircleProgressView.b(param1LiveCircleProgressView);
      this.f = (LiveCircleProgressView.c(param1LiveCircleProgressView) / LiveCircleProgressView.e(param1LiveCircleProgressView) * LiveCircleProgressView.f(param1LiveCircleProgressView) * 2.0F);
      LiveCircleProgressView.g(param1LiveCircleProgressView).sendEmptyMessageDelayed(LiveCircleProgressView.AnimationMsg.e.ordinal(), LiveCircleProgressView.f(param1LiveCircleProgressView));
    }
    
    private boolean d(LiveCircleProgressView param1LiveCircleProgressView) {
      float f2 = (float)((System.currentTimeMillis() - this.c) / LiveCircleProgressView.l(param1LiveCircleProgressView));
      float f1 = f2;
      if (f2 > 1.0F)
        f1 = 1.0F; 
      f2 = LiveCircleProgressView.m(param1LiveCircleProgressView).getInterpolation(f1);
      LiveCircleProgressView.e(param1LiveCircleProgressView, LiveCircleProgressView.n(param1LiveCircleProgressView) + (LiveCircleProgressView.j(param1LiveCircleProgressView) - LiveCircleProgressView.n(param1LiveCircleProgressView)) * f2);
      return (f1 >= 1.0F);
    }
    
    public void handleMessage(Message param1Message) {
      LiveCircleProgressView liveCircleProgressView = this.a.get();
      if (liveCircleProgressView == null)
        return; 
      LiveCircleProgressView.AnimationMsg animationMsg = LiveCircleProgressView.AnimationMsg.values()[param1Message.what];
      if (animationMsg == LiveCircleProgressView.AnimationMsg.e)
        removeMessages(LiveCircleProgressView.AnimationMsg.e.ordinal()); 
      int i = LiveCircleProgressView.null.b[LiveCircleProgressView.a(liveCircleProgressView).ordinal()];
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i != 4) {
              if (i != 5)
                return; 
              i = LiveCircleProgressView.null.a[animationMsg.ordinal()];
              if (i != 1) {
                if (i != 2) {
                  if (i != 3) {
                    if (i != 4) {
                      if (i != 5)
                        return; 
                      if (d(liveCircleProgressView)) {
                        LiveCircleProgressView.a(liveCircleProgressView, LiveCircleProgressView.AnimationState.a);
                        LiveCircleProgressView.e(liveCircleProgressView, LiveCircleProgressView.j(liveCircleProgressView));
                      } 
                      LiveCircleProgressView.g(liveCircleProgressView).sendEmptyMessageDelayed(LiveCircleProgressView.AnimationMsg.e.ordinal(), LiveCircleProgressView.f(liveCircleProgressView));
                      liveCircleProgressView.invalidate();
                      return;
                    } 
                    this.c = System.currentTimeMillis();
                    LiveCircleProgressView.c(liveCircleProgressView, LiveCircleProgressView.i(liveCircleProgressView));
                    LiveCircleProgressView.d(liveCircleProgressView, ((float[])param1Message.obj)[1]);
                    return;
                  } 
                  b(param1Message, liveCircleProgressView);
                  return;
                } 
              } else {
                c(liveCircleProgressView);
                return;
              } 
            } else {
              i = LiveCircleProgressView.null.a[animationMsg.ordinal()];
              if (i != 1) {
                if (i != 2) {
                  if (i != 3) {
                    if (i != 4) {
                      if (i != 5)
                        return; 
                      if (LiveCircleProgressView.b(liveCircleProgressView) > LiveCircleProgressView.c(liveCircleProgressView) && !LiveCircleProgressView.h(liveCircleProgressView)) {
                        float f2 = (float)((System.currentTimeMillis() - this.d) / this.f);
                        float f1 = f2;
                        if (f2 > 1.0F)
                          f1 = 1.0F; 
                        f1 = this.e.getInterpolation(f1);
                        LiveCircleProgressView.a(liveCircleProgressView, this.b * (1.0F - f1));
                      } 
                      LiveCircleProgressView.b(liveCircleProgressView, LiveCircleProgressView.d(liveCircleProgressView) + LiveCircleProgressView.e(liveCircleProgressView));
                      if (LiveCircleProgressView.d(liveCircleProgressView) > 360.0F && !LiveCircleProgressView.h(liveCircleProgressView)) {
                        this.c = System.currentTimeMillis();
                        LiveCircleProgressView.a(liveCircleProgressView, true);
                        b(liveCircleProgressView);
                      } 
                      if (LiveCircleProgressView.h(liveCircleProgressView)) {
                        LiveCircleProgressView.b(liveCircleProgressView, 360.0F);
                        LiveCircleProgressView.a(liveCircleProgressView, LiveCircleProgressView.b(liveCircleProgressView) - LiveCircleProgressView.e(liveCircleProgressView));
                        d(liveCircleProgressView);
                        float f2 = (float)((System.currentTimeMillis() - this.d) / this.f);
                        float f1 = f2;
                        if (f2 > 1.0F)
                          f1 = 1.0F; 
                        f1 = this.e.getInterpolation(f1);
                        LiveCircleProgressView.a(liveCircleProgressView, this.b * (1.0F - f1));
                      } 
                      if (LiveCircleProgressView.b(liveCircleProgressView) < 0.1D) {
                        LiveCircleProgressView.a(liveCircleProgressView, LiveCircleProgressView.AnimationState.e);
                        liveCircleProgressView.invalidate();
                        LiveCircleProgressView.a(liveCircleProgressView, false);
                        LiveCircleProgressView.a(liveCircleProgressView, LiveCircleProgressView.c(liveCircleProgressView));
                      } else {
                        liveCircleProgressView.invalidate();
                      } 
                      LiveCircleProgressView.g(liveCircleProgressView).sendEmptyMessageDelayed(LiveCircleProgressView.AnimationMsg.e.ordinal(), LiveCircleProgressView.f(liveCircleProgressView));
                      return;
                    } 
                    LiveCircleProgressView.c(liveCircleProgressView, 0.0F);
                    LiveCircleProgressView.d(liveCircleProgressView, ((float[])param1Message.obj)[1]);
                    LiveCircleProgressView.g(liveCircleProgressView).sendEmptyMessageDelayed(LiveCircleProgressView.AnimationMsg.e.ordinal(), LiveCircleProgressView.f(liveCircleProgressView));
                    return;
                  } 
                  LiveCircleProgressView.a(liveCircleProgressView, false);
                  b(param1Message, liveCircleProgressView);
                  return;
                } 
              } else {
                LiveCircleProgressView.a(liveCircleProgressView, false);
                c(liveCircleProgressView);
                return;
              } 
            } 
          } else {
            i = LiveCircleProgressView.null.a[animationMsg.ordinal()];
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
                    LiveCircleProgressView.a(liveCircleProgressView, this.b * (1.0F - f1));
                    LiveCircleProgressView.b(liveCircleProgressView, LiveCircleProgressView.d(liveCircleProgressView) + LiveCircleProgressView.e(liveCircleProgressView));
                    if (LiveCircleProgressView.b(liveCircleProgressView) < 0.01F)
                      LiveCircleProgressView.a(liveCircleProgressView, LiveCircleProgressView.AnimationState.a); 
                    LiveCircleProgressView.g(liveCircleProgressView).sendEmptyMessageDelayed(LiveCircleProgressView.AnimationMsg.e.ordinal(), LiveCircleProgressView.f(liveCircleProgressView));
                    liveCircleProgressView.invalidate();
                    return;
                  } 
                  a(liveCircleProgressView, param1Message);
                  return;
                } 
                b(param1Message, liveCircleProgressView);
                return;
              } 
            } else {
              LiveCircleProgressView.a(liveCircleProgressView, LiveCircleProgressView.AnimationState.b);
              LiveCircleProgressView.g(liveCircleProgressView).sendEmptyMessageDelayed(LiveCircleProgressView.AnimationMsg.e.ordinal(), LiveCircleProgressView.f(liveCircleProgressView));
              return;
            } 
          } 
        } else {
          i = LiveCircleProgressView.null.a[animationMsg.ordinal()];
          if (i != 1) {
            if (i != 2) {
              if (i != 3) {
                if (i != 4) {
                  if (i != 5)
                    return; 
                  float f3 = LiveCircleProgressView.b(liveCircleProgressView);
                  float f4 = LiveCircleProgressView.c(liveCircleProgressView);
                  float f2 = (float)((System.currentTimeMillis() - this.d) / this.f);
                  float f1 = f2;
                  if (f2 > 1.0F)
                    f1 = 1.0F; 
                  f1 = this.e.getInterpolation(f1);
                  if (Math.abs(f3 - f4) < 1.0F) {
                    LiveCircleProgressView.a(liveCircleProgressView, LiveCircleProgressView.c(liveCircleProgressView));
                  } else if (LiveCircleProgressView.b(liveCircleProgressView) < LiveCircleProgressView.c(liveCircleProgressView)) {
                    LiveCircleProgressView.a(liveCircleProgressView, this.b + (LiveCircleProgressView.c(liveCircleProgressView) - this.b) * f1);
                  } else {
                    f2 = this.b;
                    LiveCircleProgressView.a(liveCircleProgressView, f2 - (f2 - LiveCircleProgressView.c(liveCircleProgressView)) * f1);
                  } 
                  LiveCircleProgressView.b(liveCircleProgressView, LiveCircleProgressView.d(liveCircleProgressView) + LiveCircleProgressView.e(liveCircleProgressView));
                  if (LiveCircleProgressView.d(liveCircleProgressView) > 360.0F)
                    LiveCircleProgressView.b(liveCircleProgressView, 0.0F); 
                  LiveCircleProgressView.g(liveCircleProgressView).sendEmptyMessageDelayed(LiveCircleProgressView.AnimationMsg.e.ordinal(), LiveCircleProgressView.f(liveCircleProgressView));
                  liveCircleProgressView.invalidate();
                  return;
                } 
                a(liveCircleProgressView, param1Message);
                return;
              } 
              b(param1Message, liveCircleProgressView);
              return;
            } 
            a(liveCircleProgressView);
            return;
          } 
        } 
      } else {
        i = LiveCircleProgressView.null.a[animationMsg.ordinal()];
        if (i != 1) {
          if (i != 2) {
            if (i != 3) {
              if (i != 4) {
                if (i != 5)
                  return; 
                removeMessages(LiveCircleProgressView.AnimationMsg.e.ordinal());
                return;
              } 
              a(param1Message, liveCircleProgressView);
              return;
            } 
            b(param1Message, liveCircleProgressView);
            return;
          } 
        } else {
          c(liveCircleProgressView);
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\view\LiveCircleProgressView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */