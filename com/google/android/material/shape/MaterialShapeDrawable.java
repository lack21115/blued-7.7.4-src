package com.google.android.material.shape;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shadow.ShadowRenderer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.BitSet;

public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable, Shapeable {
  private static final String a = MaterialShapeDrawable.class.getSimpleName();
  
  private static final Paint b = new Paint(1);
  
  private MaterialShapeDrawableState c;
  
  private final ShapePath.ShadowCompatOperation[] d = new ShapePath.ShadowCompatOperation[4];
  
  private final ShapePath.ShadowCompatOperation[] e = new ShapePath.ShadowCompatOperation[4];
  
  private final BitSet f = new BitSet(8);
  
  private boolean g;
  
  private final Matrix h = new Matrix();
  
  private final Path i = new Path();
  
  private final Path j = new Path();
  
  private final RectF k = new RectF();
  
  private final RectF l = new RectF();
  
  private final Region m = new Region();
  
  private final Region n = new Region();
  
  private ShapeAppearanceModel o;
  
  private final Paint p = new Paint(1);
  
  private final Paint q = new Paint(1);
  
  private final ShadowRenderer r = new ShadowRenderer();
  
  private final ShapeAppearancePathProvider.PathListener s;
  
  private final ShapeAppearancePathProvider t = new ShapeAppearancePathProvider();
  
  private PorterDuffColorFilter u;
  
  private PorterDuffColorFilter v;
  
  private final RectF w = new RectF();
  
  private boolean x = true;
  
  public MaterialShapeDrawable() {
    this(new ShapeAppearanceModel());
  }
  
  public MaterialShapeDrawable(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    this(ShapeAppearanceModel.a(paramContext, paramAttributeSet, paramInt1, paramInt2).a());
  }
  
  private MaterialShapeDrawable(MaterialShapeDrawableState paramMaterialShapeDrawableState) {
    this.c = paramMaterialShapeDrawableState;
    this.q.setStyle(Paint.Style.STROKE);
    this.p.setStyle(Paint.Style.FILL);
    b.setColor(-1);
    b.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    g();
    a(getState());
    this.s = new ShapeAppearancePathProvider.PathListener(this) {
        public void a(ShapePath param1ShapePath, Matrix param1Matrix, int param1Int) {
          MaterialShapeDrawable.a(this.a).set(param1Int, param1ShapePath.a());
          MaterialShapeDrawable.b(this.a)[param1Int] = param1ShapePath.a(param1Matrix);
        }
        
        public void b(ShapePath param1ShapePath, Matrix param1Matrix, int param1Int) {
          MaterialShapeDrawable.a(this.a).set(param1Int + 4, param1ShapePath.a());
          MaterialShapeDrawable.c(this.a)[param1Int] = param1ShapePath.a(param1Matrix);
        }
      };
  }
  
  public MaterialShapeDrawable(ShapeAppearanceModel paramShapeAppearanceModel) {
    this(new MaterialShapeDrawableState(paramShapeAppearanceModel, null));
  }
  
  private int a(int paramInt) {
    float f1 = U();
    float f2 = R();
    int i = paramInt;
    if (this.c.b != null)
      i = this.c.b.a(paramInt, f1 + f2); 
    return i;
  }
  
  private static int a(int paramInt1, int paramInt2) {
    return paramInt1 * (paramInt2 + (paramInt2 >>> 7)) >>> 8;
  }
  
  private PorterDuffColorFilter a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, Paint paramPaint, boolean paramBoolean) {
    return (paramColorStateList == null || paramMode == null) ? a(paramPaint, paramBoolean) : a(paramColorStateList, paramMode, paramBoolean);
  }
  
  private PorterDuffColorFilter a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, boolean paramBoolean) {
    int j = paramColorStateList.getColorForState(getState(), 0);
    int i = j;
    if (paramBoolean)
      i = a(j); 
    return new PorterDuffColorFilter(i, paramMode);
  }
  
  private PorterDuffColorFilter a(Paint paramPaint, boolean paramBoolean) {
    if (paramBoolean) {
      int i = paramPaint.getColor();
      int j = a(i);
      if (j != i)
        return new PorterDuffColorFilter(j, PorterDuff.Mode.SRC_IN); 
    } 
    return null;
  }
  
  public static MaterialShapeDrawable a(Context paramContext, float paramFloat) {
    int i = MaterialColors.a(paramContext, R.attr.colorSurface, MaterialShapeDrawable.class.getSimpleName());
    MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
    materialShapeDrawable.a(paramContext);
    materialShapeDrawable.g(ColorStateList.valueOf(i));
    materialShapeDrawable.r(paramFloat);
    return materialShapeDrawable;
  }
  
  private void a() {
    float f = U();
    this.c.r = (int)Math.ceil((0.75F * f));
    this.c.s = (int)Math.ceil((f * 0.25F));
    g();
    b();
  }
  
  private void a(Canvas paramCanvas) {
    if (!c())
      return; 
    paramCanvas.save();
    d(paramCanvas);
    if (!this.x) {
      e(paramCanvas);
      paramCanvas.restore();
      return;
    } 
    int i = (int)(this.w.width() - getBounds().width());
    int j = (int)(this.w.height() - getBounds().height());
    if (i >= 0 && j >= 0) {
      Bitmap bitmap = Bitmap.createBitmap((int)this.w.width() + this.c.r * 2 + i, (int)this.w.height() + this.c.r * 2 + j, Bitmap.Config.ARGB_8888);
      Canvas canvas = new Canvas(bitmap);
      float f1 = ((getBounds()).left - this.c.r - i);
      float f2 = ((getBounds()).top - this.c.r - j);
      canvas.translate(-f1, -f2);
      e(canvas);
      paramCanvas.drawBitmap(bitmap, f1, f2, null);
      bitmap.recycle();
      paramCanvas.restore();
      return;
    } 
    throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, Path paramPath, ShapeAppearanceModel paramShapeAppearanceModel, RectF paramRectF) {
    if (paramShapeAppearanceModel.a(paramRectF)) {
      float f = paramShapeAppearanceModel.g().a(paramRectF) * this.c.k;
      paramCanvas.drawRoundRect(paramRectF, f, f, paramPaint);
      return;
    } 
    paramCanvas.drawPath(paramPath, paramPaint);
  }
  
  private boolean a(int[] paramArrayOfint) {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Lcom/google/android/material/shape/MaterialShapeDrawable$MaterialShapeDrawableState;
    //   4: getfield d : Landroid/content/res/ColorStateList;
    //   7: ifnull -> 50
    //   10: aload_0
    //   11: getfield p : Landroid/graphics/Paint;
    //   14: invokevirtual getColor : ()I
    //   17: istore_2
    //   18: aload_0
    //   19: getfield c : Lcom/google/android/material/shape/MaterialShapeDrawable$MaterialShapeDrawableState;
    //   22: getfield d : Landroid/content/res/ColorStateList;
    //   25: aload_1
    //   26: iload_2
    //   27: invokevirtual getColorForState : ([II)I
    //   30: istore_3
    //   31: iload_2
    //   32: iload_3
    //   33: if_icmpeq -> 50
    //   36: aload_0
    //   37: getfield p : Landroid/graphics/Paint;
    //   40: iload_3
    //   41: invokevirtual setColor : (I)V
    //   44: iconst_1
    //   45: istore #4
    //   47: goto -> 53
    //   50: iconst_0
    //   51: istore #4
    //   53: iload #4
    //   55: istore #5
    //   57: aload_0
    //   58: getfield c : Lcom/google/android/material/shape/MaterialShapeDrawable$MaterialShapeDrawableState;
    //   61: getfield e : Landroid/content/res/ColorStateList;
    //   64: ifnull -> 108
    //   67: aload_0
    //   68: getfield q : Landroid/graphics/Paint;
    //   71: invokevirtual getColor : ()I
    //   74: istore_2
    //   75: aload_0
    //   76: getfield c : Lcom/google/android/material/shape/MaterialShapeDrawable$MaterialShapeDrawableState;
    //   79: getfield e : Landroid/content/res/ColorStateList;
    //   82: aload_1
    //   83: iload_2
    //   84: invokevirtual getColorForState : ([II)I
    //   87: istore_3
    //   88: iload #4
    //   90: istore #5
    //   92: iload_2
    //   93: iload_3
    //   94: if_icmpeq -> 108
    //   97: aload_0
    //   98: getfield q : Landroid/graphics/Paint;
    //   101: iload_3
    //   102: invokevirtual setColor : (I)V
    //   105: iconst_1
    //   106: istore #5
    //   108: iload #5
    //   110: ireturn
  }
  
  private void b() {
    super.invalidateSelf();
  }
  
  private void b(Canvas paramCanvas) {
    a(paramCanvas, this.p, this.i, this.c.a, O());
  }
  
  private void b(RectF paramRectF, Path paramPath) {
    a(paramRectF, paramPath);
    if (this.c.j != 1.0F) {
      this.h.reset();
      this.h.setScale(this.c.j, this.c.j, paramRectF.width() / 2.0F, paramRectF.height() / 2.0F);
      paramPath.transform(this.h);
    } 
    paramPath.computeBounds(this.w, true);
  }
  
  private void c(Canvas paramCanvas) {
    a(paramCanvas, this.q, this.j, this.o, i());
  }
  
  private boolean c() {
    int i = this.c.q;
    null = true;
    if (i != 1 && this.c.r > 0)
      if (this.c.q != 2) {
        if (W())
          return true; 
      } else {
        return null;
      }  
    return false;
  }
  
  private void d(Canvas paramCanvas) {
    int i = X();
    int j = Y();
    if (Build.VERSION.SDK_INT < 21 && this.x) {
      Rect rect = paramCanvas.getClipBounds();
      rect.inset(-this.c.r, -this.c.r);
      rect.offset(i, j);
      paramCanvas.clipRect(rect, Region.Op.REPLACE);
    } 
    paramCanvas.translate(i, j);
  }
  
  private boolean d() {
    return (this.c.v == Paint.Style.FILL_AND_STROKE || this.c.v == Paint.Style.FILL);
  }
  
  private void e(Canvas paramCanvas) {
    if (this.f.cardinality() > 0)
      Log.w(a, "Compatibility shadow requested but can't be drawn for all operations in this shape."); 
    if (this.c.s != 0)
      paramCanvas.drawPath(this.i, this.r.a()); 
    int i;
    for (i = 0; i < 4; i++) {
      this.d[i].a(this.r, this.c.r, paramCanvas);
      this.e[i].a(this.r, this.c.r, paramCanvas);
    } 
    if (this.x) {
      i = X();
      int j = Y();
      paramCanvas.translate(-i, -j);
      paramCanvas.drawPath(this.i, b);
      paramCanvas.translate(i, j);
    } 
  }
  
  private boolean e() {
    return ((this.c.v == Paint.Style.FILL_AND_STROKE || this.c.v == Paint.Style.STROKE) && this.q.getStrokeWidth() > 0.0F);
  }
  
  private void f() {
    float f = -h();
    this.o = getShapeAppearanceModel().a(new ShapeAppearanceModel.CornerSizeUnaryOperator(this, f) {
          public CornerSize a(CornerSize param1CornerSize) {
            return (param1CornerSize instanceof RelativeCornerSize) ? param1CornerSize : new AdjustedCornerSize(this.a, param1CornerSize);
          }
        });
    this.t.a(this.o, this.c.k, i(), this.j);
  }
  
  private boolean g() {
    PorterDuffColorFilter porterDuffColorFilter1 = this.u;
    PorterDuffColorFilter porterDuffColorFilter2 = this.v;
    ColorStateList colorStateList = this.c.g;
    PorterDuff.Mode mode = this.c.h;
    Paint paint = this.p;
    boolean bool = true;
    this.u = a(colorStateList, mode, paint, true);
    this.v = a(this.c.f, this.c.h, this.q, false);
    if (this.c.u)
      this.r.a(this.c.g.getColorForState(getState(), 0)); 
    if (ObjectsCompat.equals(porterDuffColorFilter1, this.u)) {
      if (!ObjectsCompat.equals(porterDuffColorFilter2, this.v))
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  private float h() {
    return e() ? (this.q.getStrokeWidth() / 2.0F) : 0.0F;
  }
  
  private RectF i() {
    this.l.set(O());
    float f = h();
    this.l.inset(f, f);
    return this.l;
  }
  
  public void D(int paramInt) {
    if (this.c.q != paramInt) {
      this.c.q = paramInt;
      b();
    } 
  }
  
  public void E(int paramInt) {
    if (this.c.s != paramInt) {
      this.c.s = paramInt;
      b();
    } 
  }
  
  public void F(int paramInt) {
    if (this.c.t != paramInt) {
      this.c.t = paramInt;
      b();
    } 
  }
  
  public void G(int paramInt) {
    this.r.a(paramInt);
    this.c.u = false;
    b();
  }
  
  public ColorStateList M() {
    return this.c.d;
  }
  
  public ColorStateList N() {
    return this.c.g;
  }
  
  protected RectF O() {
    this.k.set(getBounds());
    return this.k;
  }
  
  public boolean P() {
    return (this.c.b != null && this.c.b.a());
  }
  
  public float Q() {
    return this.c.k;
  }
  
  public float R() {
    return this.c.n;
  }
  
  public float S() {
    return this.c.o;
  }
  
  public float T() {
    return this.c.p;
  }
  
  public float U() {
    return S() + T();
  }
  
  public int V() {
    return this.c.r;
  }
  
  public boolean W() {
    return (Build.VERSION.SDK_INT < 21 || (!ad() && !this.i.isConvex() && Build.VERSION.SDK_INT < 29));
  }
  
  public int X() {
    return (int)(this.c.s * Math.sin(Math.toRadians(this.c.t)));
  }
  
  public int Y() {
    return (int)(this.c.s * Math.cos(Math.toRadians(this.c.t)));
  }
  
  public float Z() {
    return this.c.a.f().a(O());
  }
  
  public void a(float paramFloat, int paramInt) {
    n(paramFloat);
    h(ColorStateList.valueOf(paramInt));
  }
  
  public void a(float paramFloat, ColorStateList paramColorStateList) {
    n(paramFloat);
    h(paramColorStateList);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (this.c.i == null)
      this.c.i = new Rect(); 
    this.c.i.set(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidateSelf();
  }
  
  public void a(Context paramContext) {
    this.c.b = new ElevationOverlayProvider(paramContext);
    a();
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint, Path paramPath, RectF paramRectF) {
    a(paramCanvas, paramPaint, paramPath, this.c.a, paramRectF);
  }
  
  public void a(Paint.Style paramStyle) {
    this.c.v = paramStyle;
    b();
  }
  
  protected final void a(RectF paramRectF, Path paramPath) {
    this.t.a(this.c.a, this.c.k, paramRectF, this.s, paramPath);
  }
  
  public float aa() {
    return this.c.a.g().a(O());
  }
  
  public float ab() {
    return this.c.a.i().a(O());
  }
  
  public float ac() {
    return this.c.a.h().a(O());
  }
  
  public boolean ad() {
    return this.c.a.a(O());
  }
  
  public void draw(Canvas paramCanvas) {
    this.p.setColorFilter((ColorFilter)this.u);
    int i = this.p.getAlpha();
    this.p.setAlpha(a(i, this.c.m));
    this.q.setColorFilter((ColorFilter)this.v);
    this.q.setStrokeWidth(this.c.l);
    int j = this.q.getAlpha();
    this.q.setAlpha(a(j, this.c.m));
    if (this.g) {
      f();
      b(O(), this.i);
      this.g = false;
    } 
    a(paramCanvas);
    if (d())
      b(paramCanvas); 
    if (e())
      c(paramCanvas); 
    this.p.setAlpha(i);
    this.q.setAlpha(j);
  }
  
  public void g(ColorStateList paramColorStateList) {
    if (this.c.d != paramColorStateList) {
      this.c.d = paramColorStateList;
      onStateChange(getState());
    } 
  }
  
  public void g(boolean paramBoolean) {
    this.x = paramBoolean;
  }
  
  public Drawable.ConstantState getConstantState() {
    return this.c;
  }
  
  public int getOpacity() {
    return -3;
  }
  
  public void getOutline(Outline paramOutline) {
    if (this.c.q == 2)
      return; 
    if (ad()) {
      float f1 = Z();
      float f2 = this.c.k;
      paramOutline.setRoundRect(getBounds(), f1 * f2);
      return;
    } 
    b(O(), this.i);
    if (this.i.isConvex() || Build.VERSION.SDK_INT >= 29)
      try {
        paramOutline.setConvexPath(this.i);
        return;
      } catch (IllegalArgumentException illegalArgumentException) {
        return;
      }  
  }
  
  public boolean getPadding(Rect paramRect) {
    if (this.c.i != null) {
      paramRect.set(this.c.i);
      return true;
    } 
    return super.getPadding(paramRect);
  }
  
  public ShapeAppearanceModel getShapeAppearanceModel() {
    return this.c.a;
  }
  
  public Region getTransparentRegion() {
    Rect rect = getBounds();
    this.m.set(rect);
    b(O(), this.i);
    this.n.setPath(this.i, this.m);
    this.m.op(this.n, Region.Op.DIFFERENCE);
    return this.m;
  }
  
  public void h(ColorStateList paramColorStateList) {
    if (this.c.e != paramColorStateList) {
      this.c.e = paramColorStateList;
      onStateChange(getState());
    } 
  }
  
  public void invalidateSelf() {
    this.g = true;
    super.invalidateSelf();
  }
  
  public boolean isStateful() {
    return (super.isStateful() || (this.c.g != null && this.c.g.isStateful()) || (this.c.f != null && this.c.f.isStateful()) || (this.c.e != null && this.c.e.isStateful()) || (this.c.d != null && this.c.d.isStateful()));
  }
  
  public Drawable mutate() {
    this.c = new MaterialShapeDrawableState(this.c);
    return this;
  }
  
  public void n(float paramFloat) {
    this.c.l = paramFloat;
    invalidateSelf();
  }
  
  public void o(float paramFloat) {
    setShapeAppearanceModel(this.c.a.a(paramFloat));
  }
  
  public void onBoundsChange(Rect paramRect) {
    this.g = true;
    super.onBoundsChange(paramRect);
  }
  
  public boolean onStateChange(int[] paramArrayOfint) {
    boolean bool1 = a(paramArrayOfint);
    boolean bool2 = g();
    if (bool1 || bool2) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (bool1)
      invalidateSelf(); 
    return bool1;
  }
  
  public void p(float paramFloat) {
    if (this.c.k != paramFloat) {
      this.c.k = paramFloat;
      this.g = true;
      invalidateSelf();
    } 
  }
  
  public void q(float paramFloat) {
    if (this.c.n != paramFloat) {
      this.c.n = paramFloat;
      a();
    } 
  }
  
  public void r(float paramFloat) {
    if (this.c.o != paramFloat) {
      this.c.o = paramFloat;
      a();
    } 
  }
  
  public void setAlpha(int paramInt) {
    if (this.c.m != paramInt) {
      this.c.m = paramInt;
      b();
    } 
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    this.c.c = paramColorFilter;
    b();
  }
  
  public void setShapeAppearanceModel(ShapeAppearanceModel paramShapeAppearanceModel) {
    this.c.a = paramShapeAppearanceModel;
    invalidateSelf();
  }
  
  public void setTint(int paramInt) {
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList) {
    this.c.g = paramColorStateList;
    g();
    b();
  }
  
  public void setTintMode(PorterDuff.Mode paramMode) {
    if (this.c.h != paramMode) {
      this.c.h = paramMode;
      g();
      b();
    } 
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CompatibilityShadowMode {}
  
  static final class MaterialShapeDrawableState extends Drawable.ConstantState {
    public ShapeAppearanceModel a;
    
    public ElevationOverlayProvider b;
    
    public ColorFilter c;
    
    public ColorStateList d = null;
    
    public ColorStateList e = null;
    
    public ColorStateList f = null;
    
    public ColorStateList g = null;
    
    public PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
    
    public Rect i = null;
    
    public float j = 1.0F;
    
    public float k = 1.0F;
    
    public float l;
    
    public int m = 255;
    
    public float n = 0.0F;
    
    public float o = 0.0F;
    
    public float p = 0.0F;
    
    public int q = 0;
    
    public int r = 0;
    
    public int s = 0;
    
    public int t = 0;
    
    public boolean u = false;
    
    public Paint.Style v = Paint.Style.FILL_AND_STROKE;
    
    public MaterialShapeDrawableState(MaterialShapeDrawableState param1MaterialShapeDrawableState) {
      this.a = param1MaterialShapeDrawableState.a;
      this.b = param1MaterialShapeDrawableState.b;
      this.l = param1MaterialShapeDrawableState.l;
      this.c = param1MaterialShapeDrawableState.c;
      this.d = param1MaterialShapeDrawableState.d;
      this.e = param1MaterialShapeDrawableState.e;
      this.h = param1MaterialShapeDrawableState.h;
      this.g = param1MaterialShapeDrawableState.g;
      this.m = param1MaterialShapeDrawableState.m;
      this.j = param1MaterialShapeDrawableState.j;
      this.s = param1MaterialShapeDrawableState.s;
      this.q = param1MaterialShapeDrawableState.q;
      this.u = param1MaterialShapeDrawableState.u;
      this.k = param1MaterialShapeDrawableState.k;
      this.n = param1MaterialShapeDrawableState.n;
      this.o = param1MaterialShapeDrawableState.o;
      this.p = param1MaterialShapeDrawableState.p;
      this.r = param1MaterialShapeDrawableState.r;
      this.t = param1MaterialShapeDrawableState.t;
      this.f = param1MaterialShapeDrawableState.f;
      this.v = param1MaterialShapeDrawableState.v;
      Rect rect = param1MaterialShapeDrawableState.i;
      if (rect != null)
        this.i = new Rect(rect); 
    }
    
    public MaterialShapeDrawableState(ShapeAppearanceModel param1ShapeAppearanceModel, ElevationOverlayProvider param1ElevationOverlayProvider) {
      this.a = param1ShapeAppearanceModel;
      this.b = param1ElevationOverlayProvider;
    }
    
    public int getChangingConfigurations() {
      return 0;
    }
    
    public Drawable newDrawable() {
      MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this);
      MaterialShapeDrawable.a(materialShapeDrawable, true);
      return materialShapeDrawable;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\shape\MaterialShapeDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */