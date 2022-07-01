package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import androidx.appcompat.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DrawerArrowDrawable extends Drawable {
  public static final int ARROW_DIRECTION_END = 3;
  
  public static final int ARROW_DIRECTION_LEFT = 0;
  
  public static final int ARROW_DIRECTION_RIGHT = 1;
  
  public static final int ARROW_DIRECTION_START = 2;
  
  private static final float b = (float)Math.toRadians(45.0D);
  
  private final Paint a = new Paint();
  
  private float c;
  
  private float d;
  
  private float e;
  
  private float f;
  
  private boolean g;
  
  private final Path h = new Path();
  
  private final int i;
  
  private boolean j = false;
  
  private float k;
  
  private float l;
  
  private int m = 2;
  
  public DrawerArrowDrawable(Context paramContext) {
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setStrokeJoin(Paint.Join.MITER);
    this.a.setStrokeCap(Paint.Cap.BUTT);
    this.a.setAntiAlias(true);
    TypedArray typedArray = paramContext.getTheme().obtainStyledAttributes(null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
    setColor(typedArray.getColor(R.styleable.DrawerArrowToggle_color, 0));
    setBarThickness(typedArray.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0F));
    setSpinEnabled(typedArray.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true));
    setGapSize(Math.round(typedArray.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0F)));
    this.i = typedArray.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
    this.d = Math.round(typedArray.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0F));
    this.c = Math.round(typedArray.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0F));
    this.e = typedArray.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0F);
    typedArray.recycle();
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3) {
    return paramFloat1 + (paramFloat2 - paramFloat1) * paramFloat3;
  }
  
  public void draw(Canvas paramCanvas) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getBounds : ()Landroid/graphics/Rect;
    //   4: astore #16
    //   6: aload_0
    //   7: getfield m : I
    //   10: istore #15
    //   12: iconst_0
    //   13: istore #14
    //   15: iload #14
    //   17: istore #13
    //   19: iload #15
    //   21: ifeq -> 65
    //   24: iload #15
    //   26: iconst_1
    //   27: if_icmpeq -> 62
    //   30: iload #15
    //   32: iconst_3
    //   33: if_icmpeq -> 51
    //   36: iload #14
    //   38: istore #13
    //   40: aload_0
    //   41: invokestatic getLayoutDirection : (Landroid/graphics/drawable/Drawable;)I
    //   44: iconst_1
    //   45: if_icmpne -> 65
    //   48: goto -> 62
    //   51: iload #14
    //   53: istore #13
    //   55: aload_0
    //   56: invokestatic getLayoutDirection : (Landroid/graphics/drawable/Drawable;)I
    //   59: ifne -> 65
    //   62: iconst_1
    //   63: istore #13
    //   65: aload_0
    //   66: getfield c : F
    //   69: fstore #6
    //   71: fload #6
    //   73: fload #6
    //   75: fmul
    //   76: fconst_2
    //   77: fmul
    //   78: f2d
    //   79: invokestatic sqrt : (D)D
    //   82: d2f
    //   83: fstore #6
    //   85: aload_0
    //   86: getfield d : F
    //   89: fload #6
    //   91: aload_0
    //   92: getfield k : F
    //   95: invokestatic a : (FFF)F
    //   98: fstore #10
    //   100: aload_0
    //   101: getfield d : F
    //   104: aload_0
    //   105: getfield e : F
    //   108: aload_0
    //   109: getfield k : F
    //   112: invokestatic a : (FFF)F
    //   115: fstore #8
    //   117: fconst_0
    //   118: aload_0
    //   119: getfield l : F
    //   122: aload_0
    //   123: getfield k : F
    //   126: invokestatic a : (FFF)F
    //   129: invokestatic round : (F)I
    //   132: i2f
    //   133: fstore #9
    //   135: fconst_0
    //   136: getstatic androidx/appcompat/graphics/drawable/DrawerArrowDrawable.b : F
    //   139: aload_0
    //   140: getfield k : F
    //   143: invokestatic a : (FFF)F
    //   146: fstore #11
    //   148: iload #13
    //   150: ifeq -> 159
    //   153: fconst_0
    //   154: fstore #6
    //   156: goto -> 163
    //   159: ldc -180.0
    //   161: fstore #6
    //   163: iload #13
    //   165: ifeq -> 175
    //   168: ldc 180.0
    //   170: fstore #7
    //   172: goto -> 178
    //   175: fconst_0
    //   176: fstore #7
    //   178: fload #6
    //   180: fload #7
    //   182: aload_0
    //   183: getfield k : F
    //   186: invokestatic a : (FFF)F
    //   189: fstore #6
    //   191: fload #10
    //   193: f2d
    //   194: dstore_2
    //   195: fload #11
    //   197: f2d
    //   198: dstore #4
    //   200: dload #4
    //   202: invokestatic cos : (D)D
    //   205: dload_2
    //   206: dmul
    //   207: invokestatic round : (D)J
    //   210: l2f
    //   211: fstore #7
    //   213: dload_2
    //   214: dload #4
    //   216: invokestatic sin : (D)D
    //   219: dmul
    //   220: invokestatic round : (D)J
    //   223: l2f
    //   224: fstore #10
    //   226: aload_0
    //   227: getfield h : Landroid/graphics/Path;
    //   230: invokevirtual rewind : ()V
    //   233: aload_0
    //   234: getfield f : F
    //   237: aload_0
    //   238: getfield a : Landroid/graphics/Paint;
    //   241: invokevirtual getStrokeWidth : ()F
    //   244: fadd
    //   245: aload_0
    //   246: getfield l : F
    //   249: fneg
    //   250: aload_0
    //   251: getfield k : F
    //   254: invokestatic a : (FFF)F
    //   257: fstore #11
    //   259: fload #8
    //   261: fneg
    //   262: fconst_2
    //   263: fdiv
    //   264: fstore #12
    //   266: aload_0
    //   267: getfield h : Landroid/graphics/Path;
    //   270: fload #12
    //   272: fload #9
    //   274: fadd
    //   275: fconst_0
    //   276: invokevirtual moveTo : (FF)V
    //   279: aload_0
    //   280: getfield h : Landroid/graphics/Path;
    //   283: fload #8
    //   285: fload #9
    //   287: fconst_2
    //   288: fmul
    //   289: fsub
    //   290: fconst_0
    //   291: invokevirtual rLineTo : (FF)V
    //   294: aload_0
    //   295: getfield h : Landroid/graphics/Path;
    //   298: fload #12
    //   300: fload #11
    //   302: invokevirtual moveTo : (FF)V
    //   305: aload_0
    //   306: getfield h : Landroid/graphics/Path;
    //   309: fload #7
    //   311: fload #10
    //   313: invokevirtual rLineTo : (FF)V
    //   316: aload_0
    //   317: getfield h : Landroid/graphics/Path;
    //   320: fload #12
    //   322: fload #11
    //   324: fneg
    //   325: invokevirtual moveTo : (FF)V
    //   328: aload_0
    //   329: getfield h : Landroid/graphics/Path;
    //   332: fload #7
    //   334: fload #10
    //   336: fneg
    //   337: invokevirtual rLineTo : (FF)V
    //   340: aload_0
    //   341: getfield h : Landroid/graphics/Path;
    //   344: invokevirtual close : ()V
    //   347: aload_1
    //   348: invokevirtual save : ()I
    //   351: pop
    //   352: aload_0
    //   353: getfield a : Landroid/graphics/Paint;
    //   356: invokevirtual getStrokeWidth : ()F
    //   359: fstore #7
    //   361: aload #16
    //   363: invokevirtual height : ()I
    //   366: i2f
    //   367: fstore #9
    //   369: aload_0
    //   370: getfield f : F
    //   373: fstore #8
    //   375: fload #9
    //   377: ldc_w 3.0
    //   380: fload #7
    //   382: fmul
    //   383: fsub
    //   384: fconst_2
    //   385: fload #8
    //   387: fmul
    //   388: fsub
    //   389: f2i
    //   390: iconst_4
    //   391: idiv
    //   392: iconst_2
    //   393: imul
    //   394: i2f
    //   395: fstore #9
    //   397: aload_1
    //   398: aload #16
    //   400: invokevirtual centerX : ()I
    //   403: i2f
    //   404: fload #9
    //   406: fload #7
    //   408: ldc_w 1.5
    //   411: fmul
    //   412: fload #8
    //   414: fadd
    //   415: fadd
    //   416: invokevirtual translate : (FF)V
    //   419: aload_0
    //   420: getfield g : Z
    //   423: ifeq -> 458
    //   426: aload_0
    //   427: getfield j : Z
    //   430: iload #13
    //   432: ixor
    //   433: ifeq -> 442
    //   436: iconst_m1
    //   437: istore #13
    //   439: goto -> 445
    //   442: iconst_1
    //   443: istore #13
    //   445: aload_1
    //   446: fload #6
    //   448: iload #13
    //   450: i2f
    //   451: fmul
    //   452: invokevirtual rotate : (F)V
    //   455: goto -> 469
    //   458: iload #13
    //   460: ifeq -> 469
    //   463: aload_1
    //   464: ldc 180.0
    //   466: invokevirtual rotate : (F)V
    //   469: aload_1
    //   470: aload_0
    //   471: getfield h : Landroid/graphics/Path;
    //   474: aload_0
    //   475: getfield a : Landroid/graphics/Paint;
    //   478: invokevirtual drawPath : (Landroid/graphics/Path;Landroid/graphics/Paint;)V
    //   481: aload_1
    //   482: invokevirtual restore : ()V
    //   485: return
  }
  
  public float getArrowHeadLength() {
    return this.c;
  }
  
  public float getArrowShaftLength() {
    return this.e;
  }
  
  public float getBarLength() {
    return this.d;
  }
  
  public float getBarThickness() {
    return this.a.getStrokeWidth();
  }
  
  public int getColor() {
    return this.a.getColor();
  }
  
  public int getDirection() {
    return this.m;
  }
  
  public float getGapSize() {
    return this.f;
  }
  
  public int getIntrinsicHeight() {
    return this.i;
  }
  
  public int getIntrinsicWidth() {
    return this.i;
  }
  
  public int getOpacity() {
    return -3;
  }
  
  public final Paint getPaint() {
    return this.a;
  }
  
  public float getProgress() {
    return this.k;
  }
  
  public boolean isSpinEnabled() {
    return this.g;
  }
  
  public void setAlpha(int paramInt) {
    if (paramInt != this.a.getAlpha()) {
      this.a.setAlpha(paramInt);
      invalidateSelf();
    } 
  }
  
  public void setArrowHeadLength(float paramFloat) {
    if (this.c != paramFloat) {
      this.c = paramFloat;
      invalidateSelf();
    } 
  }
  
  public void setArrowShaftLength(float paramFloat) {
    if (this.e != paramFloat) {
      this.e = paramFloat;
      invalidateSelf();
    } 
  }
  
  public void setBarLength(float paramFloat) {
    if (this.d != paramFloat) {
      this.d = paramFloat;
      invalidateSelf();
    } 
  }
  
  public void setBarThickness(float paramFloat) {
    if (this.a.getStrokeWidth() != paramFloat) {
      this.a.setStrokeWidth(paramFloat);
      this.l = (float)((paramFloat / 2.0F) * Math.cos(b));
      invalidateSelf();
    } 
  }
  
  public void setColor(int paramInt) {
    if (paramInt != this.a.getColor()) {
      this.a.setColor(paramInt);
      invalidateSelf();
    } 
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    this.a.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setDirection(int paramInt) {
    if (paramInt != this.m) {
      this.m = paramInt;
      invalidateSelf();
    } 
  }
  
  public void setGapSize(float paramFloat) {
    if (paramFloat != this.f) {
      this.f = paramFloat;
      invalidateSelf();
    } 
  }
  
  public void setProgress(float paramFloat) {
    if (this.k != paramFloat) {
      this.k = paramFloat;
      invalidateSelf();
    } 
  }
  
  public void setSpinEnabled(boolean paramBoolean) {
    if (this.g != paramBoolean) {
      this.g = paramBoolean;
      invalidateSelf();
    } 
  }
  
  public void setVerticalMirror(boolean paramBoolean) {
    if (this.j != paramBoolean) {
      this.j = paramBoolean;
      invalidateSelf();
    } 
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ArrowDirection {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\graphics\drawable\DrawerArrowDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */