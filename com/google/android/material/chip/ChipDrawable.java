package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.text.BidiFormatter;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class ChipDrawable extends MaterialShapeDrawable implements Drawable.Callback, TintAwareDrawable, TextDrawableHelper.TextDrawableDelegate {
  private static final int[] a = new int[] { 16842910 };
  
  private static final ShapeDrawable b = new ShapeDrawable((Shape)new OvalShape());
  
  private MotionSpec A;
  
  private float B;
  
  private float C;
  
  private float D;
  
  private float E;
  
  private float F;
  
  private float G;
  
  private float H;
  
  private float I;
  
  private final Context J;
  
  private final Paint K = new Paint(1);
  
  private final Paint L;
  
  private final Paint.FontMetrics M = new Paint.FontMetrics();
  
  private final RectF N = new RectF();
  
  private final PointF O = new PointF();
  
  private final Path P = new Path();
  
  private final TextDrawableHelper Q;
  
  private int R;
  
  private int S;
  
  private int T;
  
  private int U;
  
  private int V;
  
  private int W;
  
  private boolean X;
  
  private int Y;
  
  private int Z = 255;
  
  private ColorFilter aa;
  
  private PorterDuffColorFilter ab;
  
  private ColorStateList ac;
  
  private PorterDuff.Mode ad = PorterDuff.Mode.SRC_IN;
  
  private int[] ae;
  
  private boolean af;
  
  private ColorStateList ag;
  
  private WeakReference<Delegate> ah = new WeakReference<Delegate>(null);
  
  private TextUtils.TruncateAt ai;
  
  private boolean aj;
  
  private int ak;
  
  private boolean al;
  
  private ColorStateList c;
  
  private ColorStateList d;
  
  private float e;
  
  private float f = -1.0F;
  
  private ColorStateList g;
  
  private float h;
  
  private ColorStateList i;
  
  private CharSequence j;
  
  private boolean k;
  
  private Drawable l;
  
  private ColorStateList m;
  
  private float n;
  
  private boolean o;
  
  private boolean p;
  
  private Drawable q;
  
  private Drawable r;
  
  private ColorStateList s;
  
  private float t;
  
  private CharSequence u;
  
  private boolean v;
  
  private boolean w;
  
  private Drawable x;
  
  private ColorStateList y;
  
  private MotionSpec z;
  
  private ChipDrawable(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext);
    this.J = paramContext;
    this.Q = new TextDrawableHelper(this);
    this.j = "";
    (this.Q.a()).density = (paramContext.getResources().getDisplayMetrics()).density;
    this.L = null;
    Paint paint = this.L;
    if (paint != null)
      paint.setStyle(Paint.Style.STROKE); 
    setState(a);
    a(a);
    this.aj = true;
    if (RippleUtils.a)
      b.setTint(-1); 
  }
  
  public static ChipDrawable a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    ChipDrawable chipDrawable = new ChipDrawable(paramContext, paramAttributeSet, paramInt1, paramInt2);
    chipDrawable.a(paramAttributeSet, paramInt1, paramInt2);
    return chipDrawable;
  }
  
  private void a(Canvas paramCanvas, Rect paramRect) {
    if (!this.al) {
      this.K.setColor(this.R);
      this.K.setStyle(Paint.Style.FILL);
      this.N.set(paramRect);
      paramCanvas.drawRoundRect(this.N, j(), j(), this.K);
    } 
  }
  
  private void a(Rect paramRect, RectF paramRectF) {
    paramRectF.setEmpty();
    if (ae() || af()) {
      float f = this.B + this.C;
      if (DrawableCompat.getLayoutDirection((Drawable)this) == 0) {
        paramRectF.left = paramRect.left + f;
        paramRectF.right = paramRectF.left + this.n;
      } else {
        paramRectF.right = paramRect.right - f;
        paramRectF.left = paramRectF.right - this.n;
      } 
      paramRectF.top = paramRect.exactCenterY() - this.n / 2.0F;
      paramRectF.bottom = paramRectF.top + this.n;
    } 
  }
  
  private void a(AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    TypedArray typedArray = ThemeEnforcement.a(this.J, paramAttributeSet, R.styleable.Chip, paramInt1, paramInt2, new int[0]);
    this.al = typedArray.hasValue(R.styleable.Chip_shapeAppearance);
    j(MaterialResources.a(this.J, typedArray, R.styleable.Chip_chipSurfaceColor));
    a(MaterialResources.a(this.J, typedArray, R.styleable.Chip_chipBackgroundColor));
    a(typedArray.getDimension(R.styleable.Chip_chipMinHeight, 0.0F));
    if (typedArray.hasValue(R.styleable.Chip_chipCornerRadius))
      b(typedArray.getDimension(R.styleable.Chip_chipCornerRadius, 0.0F)); 
    b(MaterialResources.a(this.J, typedArray, R.styleable.Chip_chipStrokeColor));
    c(typedArray.getDimension(R.styleable.Chip_chipStrokeWidth, 0.0F));
    c(MaterialResources.a(this.J, typedArray, R.styleable.Chip_rippleColor));
    a(typedArray.getText(R.styleable.Chip_android_text));
    a(MaterialResources.c(this.J, typedArray, R.styleable.Chip_android_textAppearance));
    paramInt1 = typedArray.getInt(R.styleable.Chip_android_ellipsize, 0);
    if (paramInt1 != 1) {
      if (paramInt1 != 2) {
        if (paramInt1 == 3)
          a(TextUtils.TruncateAt.END); 
      } else {
        a(TextUtils.TruncateAt.MIDDLE);
      } 
    } else {
      a(TextUtils.TruncateAt.START);
    } 
    b(typedArray.getBoolean(R.styleable.Chip_chipIconVisible, false));
    if (paramAttributeSet != null && paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null)
      b(typedArray.getBoolean(R.styleable.Chip_chipIconEnabled, false)); 
    a(MaterialResources.b(this.J, typedArray, R.styleable.Chip_chipIcon));
    if (typedArray.hasValue(R.styleable.Chip_chipIconTint))
      d(MaterialResources.a(this.J, typedArray, R.styleable.Chip_chipIconTint)); 
    d(typedArray.getDimension(R.styleable.Chip_chipIconSize, 0.0F));
    c(typedArray.getBoolean(R.styleable.Chip_closeIconVisible, false));
    if (paramAttributeSet != null && paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null)
      c(typedArray.getBoolean(R.styleable.Chip_closeIconEnabled, false)); 
    b(MaterialResources.b(this.J, typedArray, R.styleable.Chip_closeIcon));
    e(MaterialResources.a(this.J, typedArray, R.styleable.Chip_closeIconTint));
    e(typedArray.getDimension(R.styleable.Chip_closeIconSize, 0.0F));
    d(typedArray.getBoolean(R.styleable.Chip_android_checkable, false));
    e(typedArray.getBoolean(R.styleable.Chip_checkedIconVisible, false));
    if (paramAttributeSet != null && paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null)
      e(typedArray.getBoolean(R.styleable.Chip_checkedIconEnabled, false)); 
    c(MaterialResources.b(this.J, typedArray, R.styleable.Chip_checkedIcon));
    if (typedArray.hasValue(R.styleable.Chip_checkedIconTint))
      f(MaterialResources.a(this.J, typedArray, R.styleable.Chip_checkedIconTint)); 
    a(MotionSpec.a(this.J, typedArray, R.styleable.Chip_showMotionSpec));
    b(MotionSpec.a(this.J, typedArray, R.styleable.Chip_hideMotionSpec));
    f(typedArray.getDimension(R.styleable.Chip_chipStartPadding, 0.0F));
    g(typedArray.getDimension(R.styleable.Chip_iconStartPadding, 0.0F));
    h(typedArray.getDimension(R.styleable.Chip_iconEndPadding, 0.0F));
    i(typedArray.getDimension(R.styleable.Chip_textStartPadding, 0.0F));
    j(typedArray.getDimension(R.styleable.Chip_textEndPadding, 0.0F));
    k(typedArray.getDimension(R.styleable.Chip_closeIconStartPadding, 0.0F));
    l(typedArray.getDimension(R.styleable.Chip_closeIconEndPadding, 0.0F));
    m(typedArray.getDimension(R.styleable.Chip_chipEndPadding, 0.0F));
    C(typedArray.getDimensionPixelSize(R.styleable.Chip_android_maxWidth, 2147483647));
    typedArray.recycle();
  }
  
  private static boolean a(int[] paramArrayOfint, int paramInt) {
    if (paramArrayOfint == null)
      return false; 
    int j = paramArrayOfint.length;
    for (int i = 0; i < j; i++) {
      if (paramArrayOfint[i] == paramInt)
        return true; 
    } 
    return false;
  }
  
  private boolean a(int[] paramArrayOfint1, int[] paramArrayOfint2) {
    int j;
    boolean bool3;
    boolean bool1 = super.onStateChange(paramArrayOfint1);
    ColorStateList colorStateList = this.c;
    if (colorStateList != null) {
      i = colorStateList.getColorForState(paramArrayOfint1, this.R);
    } else {
      i = 0;
    } 
    if (this.R != i) {
      this.R = i;
      bool1 = true;
    } 
    colorStateList = this.d;
    if (colorStateList != null) {
      j = colorStateList.getColorForState(paramArrayOfint1, this.S);
    } else {
      j = 0;
    } 
    if (this.S != j) {
      this.S = j;
      bool1 = true;
    } 
    int k = MaterialColors.a(i, j);
    if (this.T != k) {
      i = 1;
    } else {
      i = 0;
    } 
    if (M() == null) {
      j = 1;
    } else {
      j = 0;
    } 
    if ((i | j) != 0) {
      this.T = k;
      g(ColorStateList.valueOf(this.T));
      bool1 = true;
    } 
    colorStateList = this.g;
    if (colorStateList != null) {
      i = colorStateList.getColorForState(paramArrayOfint1, this.U);
    } else {
      i = 0;
    } 
    if (this.U != i) {
      this.U = i;
      bool1 = true;
    } 
    if (this.ag != null && RippleUtils.a(paramArrayOfint1)) {
      i = this.ag.getColorForState(paramArrayOfint1, this.V);
    } else {
      i = 0;
    } 
    boolean bool2 = bool1;
    if (this.V != i) {
      this.V = i;
      bool2 = bool1;
      if (this.af)
        bool2 = true; 
    } 
    if (this.Q.b() != null && (this.Q.b()).b != null) {
      i = (this.Q.b()).b.getColorForState(paramArrayOfint1, this.W);
    } else {
      i = 0;
    } 
    bool1 = bool2;
    if (this.W != i) {
      this.W = i;
      bool1 = true;
    } 
    if (a(getState(), 16842912) && this.v) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    bool2 = bool1;
    if (this.X != bool3) {
      bool2 = bool1;
      if (this.x != null) {
        float f = c();
        this.X = bool3;
        if (f != c()) {
          bool2 = true;
          i = 1;
        } else {
          bool2 = true;
          i = 0;
        } 
        colorStateList = this.ac;
        if (colorStateList != null) {
          j = colorStateList.getColorForState(paramArrayOfint1, this.Y);
        } else {
          j = 0;
        } 
        if (this.Y != j) {
          this.Y = j;
          this.ab = DrawableUtils.a((Drawable)this, this.ac, this.ad);
          bool2 = true;
        } 
        bool1 = bool2;
        if (d(this.l))
          bool1 = bool2 | this.l.setState(paramArrayOfint1); 
        bool2 = bool1;
        if (d(this.x))
          bool2 = bool1 | this.x.setState(paramArrayOfint1); 
        bool1 = bool2;
        if (d(this.q)) {
          int[] arrayOfInt = new int[paramArrayOfint1.length + paramArrayOfint2.length];
          System.arraycopy(paramArrayOfint1, 0, arrayOfInt, 0, paramArrayOfint1.length);
          System.arraycopy(paramArrayOfint2, 0, arrayOfInt, paramArrayOfint1.length, paramArrayOfint2.length);
          bool1 = bool2 | this.q.setState(arrayOfInt);
        } 
        bool2 = bool1;
        if (RippleUtils.a) {
          bool2 = bool1;
          if (d(this.r))
            bool2 = bool1 | this.r.setState(paramArrayOfint2); 
        } 
        if (bool2)
          invalidateSelf(); 
        if (i != 0)
          b(); 
        return bool2;
      } 
    } 
    int i = 0;
  }
  
  private boolean ae() {
    return (this.k && this.l != null);
  }
  
  private boolean af() {
    return (this.w && this.x != null && this.X);
  }
  
  private boolean ag() {
    return (this.p && this.q != null);
  }
  
  private boolean ah() {
    return (this.w && this.x != null && this.v);
  }
  
  private float ai() {
    this.Q.a().getFontMetrics(this.M);
    return (this.M.descent + this.M.ascent) / 2.0F;
  }
  
  private ColorFilter aj() {
    ColorFilter colorFilter = this.aa;
    return (ColorFilter)((colorFilter != null) ? colorFilter : this.ab);
  }
  
  private void ak() {
    ColorStateList colorStateList;
    if (this.af) {
      colorStateList = RippleUtils.b(this.i);
    } else {
      colorStateList = null;
    } 
    this.ag = colorStateList;
  }
  
  private void al() {
    this.r = (Drawable)new RippleDrawable(RippleUtils.b(m()), this.q, (Drawable)b);
  }
  
  private void b(Canvas paramCanvas, Rect paramRect) {
    if (!this.al) {
      this.K.setColor(this.S);
      this.K.setStyle(Paint.Style.FILL);
      this.K.setColorFilter(aj());
      this.N.set(paramRect);
      paramCanvas.drawRoundRect(this.N, j(), j(), this.K);
    } 
  }
  
  private void b(Rect paramRect, RectF paramRectF) {
    paramRectF.setEmpty();
    if (this.j != null) {
      float f1 = this.B + c() + this.E;
      float f2 = this.I + d() + this.F;
      if (DrawableCompat.getLayoutDirection((Drawable)this) == 0) {
        paramRectF.left = paramRect.left + f1;
        paramRectF.right = paramRect.right - f2;
      } else {
        paramRectF.left = paramRect.left + f2;
        paramRectF.right = paramRect.right - f1;
      } 
      paramRectF.top = paramRect.top;
      paramRectF.bottom = paramRect.bottom;
    } 
  }
  
  private static boolean b(TextAppearance paramTextAppearance) {
    return (paramTextAppearance != null && paramTextAppearance.b != null && paramTextAppearance.b.isStateful());
  }
  
  private void c(Canvas paramCanvas, Rect paramRect) {
    if (this.h > 0.0F && !this.al) {
      this.K.setColor(this.U);
      this.K.setStyle(Paint.Style.STROKE);
      if (!this.al)
        this.K.setColorFilter(aj()); 
      this.N.set(paramRect.left + this.h / 2.0F, paramRect.top + this.h / 2.0F, paramRect.right - this.h / 2.0F, paramRect.bottom - this.h / 2.0F);
      float f = this.f - this.h / 2.0F;
      paramCanvas.drawRoundRect(this.N, f, f, this.K);
    } 
  }
  
  private void c(Rect paramRect, RectF paramRectF) {
    paramRectF.setEmpty();
    if (ag()) {
      float f = this.I + this.H;
      if (DrawableCompat.getLayoutDirection((Drawable)this) == 0) {
        paramRectF.right = paramRect.right - f;
        paramRectF.left = paramRectF.right - this.t;
      } else {
        paramRectF.left = paramRect.left + f;
        paramRectF.right = paramRectF.left + this.t;
      } 
      paramRectF.top = paramRect.exactCenterY() - this.t / 2.0F;
      paramRectF.bottom = paramRectF.top + this.t;
    } 
  }
  
  private void d(Canvas paramCanvas, Rect paramRect) {
    this.K.setColor(this.V);
    this.K.setStyle(Paint.Style.FILL);
    this.N.set(paramRect);
    if (!this.al) {
      paramCanvas.drawRoundRect(this.N, j(), j(), this.K);
      return;
    } 
    a(new RectF(paramRect), this.P);
    a(paramCanvas, this.K, this.P, O());
  }
  
  private void d(Rect paramRect, RectF paramRectF) {
    paramRectF.set(paramRect);
    if (ag()) {
      float f = this.I + this.H + this.t + this.G + this.F;
      if (DrawableCompat.getLayoutDirection((Drawable)this) == 0) {
        paramRectF.right = paramRect.right - f;
        return;
      } 
      paramRectF.left = paramRect.left + f;
    } 
  }
  
  private static boolean d(Drawable paramDrawable) {
    return (paramDrawable != null && paramDrawable.isStateful());
  }
  
  private void e(Canvas paramCanvas, Rect paramRect) {
    if (ae()) {
      a(paramRect, this.N);
      float f1 = this.N.left;
      float f2 = this.N.top;
      paramCanvas.translate(f1, f2);
      this.l.setBounds(0, 0, (int)this.N.width(), (int)this.N.height());
      this.l.draw(paramCanvas);
      paramCanvas.translate(-f1, -f2);
    } 
  }
  
  private void e(Rect paramRect, RectF paramRectF) {
    paramRectF.setEmpty();
    if (ag()) {
      float f = this.I + this.H + this.t + this.G + this.F;
      if (DrawableCompat.getLayoutDirection((Drawable)this) == 0) {
        paramRectF.right = paramRect.right;
        paramRectF.left = paramRectF.right - f;
      } else {
        paramRectF.left = paramRect.left;
        paramRectF.right = paramRect.left + f;
      } 
      paramRectF.top = paramRect.top;
      paramRectF.bottom = paramRect.bottom;
    } 
  }
  
  private void e(Drawable paramDrawable) {
    if (paramDrawable != null)
      paramDrawable.setCallback(null); 
  }
  
  private void f(Canvas paramCanvas, Rect paramRect) {
    if (af()) {
      a(paramRect, this.N);
      float f1 = this.N.left;
      float f2 = this.N.top;
      paramCanvas.translate(f1, f2);
      this.x.setBounds(0, 0, (int)this.N.width(), (int)this.N.height());
      this.x.draw(paramCanvas);
      paramCanvas.translate(-f1, -f2);
    } 
  }
  
  private void f(Drawable paramDrawable) {
    if (paramDrawable == null)
      return; 
    paramDrawable.setCallback(this);
    DrawableCompat.setLayoutDirection(paramDrawable, DrawableCompat.getLayoutDirection((Drawable)this));
    paramDrawable.setLevel(getLevel());
    paramDrawable.setVisible(isVisible(), false);
    if (paramDrawable == this.q) {
      if (paramDrawable.isStateful())
        paramDrawable.setState(g()); 
      DrawableCompat.setTintList(paramDrawable, this.s);
      return;
    } 
    if (paramDrawable.isStateful())
      paramDrawable.setState(getState()); 
    Drawable drawable = this.l;
    if (paramDrawable == drawable && this.o)
      DrawableCompat.setTintList(drawable, this.m); 
  }
  
  private void g(Canvas paramCanvas, Rect paramRect) {
    if (this.j != null) {
      Paint.Align align = a(paramRect, this.O);
      b(paramRect, this.N);
      if (this.Q.b() != null) {
        (this.Q.a()).drawableState = getState();
        this.Q.a(this.J);
      } 
      this.Q.a().setTextAlign(align);
      int i = Math.round(this.Q.a(n().toString()));
      int k = Math.round(this.N.width());
      int j = 0;
      if (i > k) {
        i = 1;
      } else {
        i = 0;
      } 
      if (i != 0) {
        j = paramCanvas.save();
        paramCanvas.clipRect(this.N);
      } 
      CharSequence charSequence2 = this.j;
      CharSequence charSequence1 = charSequence2;
      if (i != 0) {
        charSequence1 = charSequence2;
        if (this.ai != null)
          charSequence1 = TextUtils.ellipsize(charSequence2, this.Q.a(), this.N.width(), this.ai); 
      } 
      paramCanvas.drawText(charSequence1, 0, charSequence1.length(), this.O.x, this.O.y, (Paint)this.Q.a());
      if (i != 0)
        paramCanvas.restoreToCount(j); 
    } 
  }
  
  private void h(Canvas paramCanvas, Rect paramRect) {
    if (ag()) {
      c(paramRect, this.N);
      float f1 = this.N.left;
      float f2 = this.N.top;
      paramCanvas.translate(f1, f2);
      this.q.setBounds(0, 0, (int)this.N.width(), (int)this.N.height());
      if (RippleUtils.a) {
        this.r.setBounds(this.q.getBounds());
        this.r.jumpToCurrentState();
        this.r.draw(paramCanvas);
      } else {
        this.q.draw(paramCanvas);
      } 
      paramCanvas.translate(-f1, -f2);
    } 
  }
  
  private void i(Canvas paramCanvas, Rect paramRect) {
    Paint paint = this.L;
    if (paint != null) {
      paint.setColor(ColorUtils.setAlphaComponent(-16777216, 127));
      paramCanvas.drawRect(paramRect, this.L);
      if (ae() || af()) {
        a(paramRect, this.N);
        paramCanvas.drawRect(this.N, this.L);
      } 
      if (this.j != null)
        paramCanvas.drawLine(paramRect.left, paramRect.exactCenterY(), paramRect.right, paramRect.exactCenterY(), this.L); 
      if (ag()) {
        c(paramRect, this.N);
        paramCanvas.drawRect(this.N, this.L);
      } 
      this.L.setColor(ColorUtils.setAlphaComponent(-65536, 127));
      d(paramRect, this.N);
      paramCanvas.drawRect(this.N, this.L);
      this.L.setColor(ColorUtils.setAlphaComponent(-16711936, 127));
      e(paramRect, this.N);
      paramCanvas.drawRect(this.N, this.L);
    } 
  }
  
  private static boolean i(ColorStateList paramColorStateList) {
    return (paramColorStateList != null && paramColorStateList.isStateful());
  }
  
  private void j(ColorStateList paramColorStateList) {
    if (this.c != paramColorStateList) {
      this.c = paramColorStateList;
      onStateChange(getState());
    } 
  }
  
  public ColorStateList A() {
    return this.y;
  }
  
  public void A(int paramInt) {
    l(this.J.getResources().getDimension(paramInt));
  }
  
  public MotionSpec B() {
    return this.z;
  }
  
  public void B(int paramInt) {
    m(this.J.getResources().getDimension(paramInt));
  }
  
  public MotionSpec C() {
    return this.A;
  }
  
  public void C(int paramInt) {
    this.ak = paramInt;
  }
  
  public float D() {
    return this.B;
  }
  
  public float E() {
    return this.C;
  }
  
  public float F() {
    return this.D;
  }
  
  public float G() {
    return this.E;
  }
  
  public float H() {
    return this.F;
  }
  
  public float I() {
    return this.G;
  }
  
  public float J() {
    return this.H;
  }
  
  public float K() {
    return this.I;
  }
  
  boolean L() {
    return this.aj;
  }
  
  Paint.Align a(Rect paramRect, PointF paramPointF) {
    paramPointF.set(0.0F, 0.0F);
    Paint.Align align = Paint.Align.LEFT;
    if (this.j != null) {
      float f = this.B + c() + this.E;
      if (DrawableCompat.getLayoutDirection((Drawable)this) == 0) {
        paramPointF.x = paramRect.left + f;
        align = Paint.Align.LEFT;
      } else {
        paramPointF.x = paramRect.right - f;
        align = Paint.Align.RIGHT;
      } 
      paramPointF.y = paramRect.centerY() - ai();
    } 
    return align;
  }
  
  public void a(float paramFloat) {
    if (this.e != paramFloat) {
      this.e = paramFloat;
      invalidateSelf();
      b();
    } 
  }
  
  public void a(int paramInt) {
    a(AppCompatResources.getColorStateList(this.J, paramInt));
  }
  
  public void a(ColorStateList paramColorStateList) {
    if (this.d != paramColorStateList) {
      this.d = paramColorStateList;
      onStateChange(getState());
    } 
  }
  
  public void a(RectF paramRectF) {
    e(getBounds(), paramRectF);
  }
  
  public void a(Drawable paramDrawable) {
    Drawable drawable = q();
    if (drawable != paramDrawable) {
      float f1 = c();
      if (paramDrawable != null) {
        paramDrawable = DrawableCompat.wrap(paramDrawable).mutate();
      } else {
        paramDrawable = null;
      } 
      this.l = paramDrawable;
      float f2 = c();
      e(drawable);
      if (ae())
        f(this.l); 
      invalidateSelf();
      if (f1 != f2)
        b(); 
    } 
  }
  
  public void a(TextUtils.TruncateAt paramTruncateAt) {
    this.ai = paramTruncateAt;
  }
  
  public void a(MotionSpec paramMotionSpec) {
    this.z = paramMotionSpec;
  }
  
  public void a(Delegate paramDelegate) {
    this.ah = new WeakReference<Delegate>(paramDelegate);
  }
  
  public void a(TextAppearance paramTextAppearance) {
    this.Q.a(paramTextAppearance, this.J);
  }
  
  public void a(CharSequence paramCharSequence) {
    CharSequence charSequence = paramCharSequence;
    if (paramCharSequence == null)
      charSequence = ""; 
    if (!TextUtils.equals(this.j, charSequence)) {
      this.j = charSequence;
      this.Q.a(true);
      invalidateSelf();
      b();
    } 
  }
  
  public void a(boolean paramBoolean) {
    if (this.af != paramBoolean) {
      this.af = paramBoolean;
      ak();
      onStateChange(getState());
    } 
  }
  
  public boolean a() {
    return this.af;
  }
  
  public boolean a(int[] paramArrayOfint) {
    if (!Arrays.equals(this.ae, paramArrayOfint)) {
      this.ae = paramArrayOfint;
      if (ag())
        return a(getState(), paramArrayOfint); 
    } 
    return false;
  }
  
  protected void b() {
    Delegate delegate = this.ah.get();
    if (delegate != null)
      delegate.a(); 
  }
  
  @Deprecated
  public void b(float paramFloat) {
    if (this.f != paramFloat) {
      this.f = paramFloat;
      setShapeAppearanceModel(getShapeAppearanceModel().a(paramFloat));
    } 
  }
  
  public void b(int paramInt) {
    a(this.J.getResources().getDimension(paramInt));
  }
  
  public void b(ColorStateList paramColorStateList) {
    if (this.g != paramColorStateList) {
      this.g = paramColorStateList;
      if (this.al)
        h(paramColorStateList); 
      onStateChange(getState());
    } 
  }
  
  public void b(Drawable paramDrawable) {
    Drawable drawable = u();
    if (drawable != paramDrawable) {
      float f1 = d();
      if (paramDrawable != null) {
        paramDrawable = DrawableCompat.wrap(paramDrawable).mutate();
      } else {
        paramDrawable = null;
      } 
      this.q = paramDrawable;
      if (RippleUtils.a)
        al(); 
      float f2 = d();
      e(drawable);
      if (ag())
        f(this.q); 
      invalidateSelf();
      if (f1 != f2)
        b(); 
    } 
  }
  
  public void b(MotionSpec paramMotionSpec) {
    this.A = paramMotionSpec;
  }
  
  public void b(CharSequence paramCharSequence) {
    if (this.u != paramCharSequence) {
      this.u = BidiFormatter.getInstance().unicodeWrap(paramCharSequence);
      invalidateSelf();
    } 
  }
  
  public void b(boolean paramBoolean) {
    if (this.k != paramBoolean) {
      boolean bool;
      boolean bool1 = ae();
      this.k = paramBoolean;
      paramBoolean = ae();
      if (bool1 != paramBoolean) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool) {
        if (paramBoolean) {
          f(this.l);
        } else {
          e(this.l);
        } 
        invalidateSelf();
        b();
      } 
    } 
  }
  
  float c() {
    return (ae() || af()) ? (this.C + this.n + this.D) : 0.0F;
  }
  
  public void c(float paramFloat) {
    if (this.h != paramFloat) {
      this.h = paramFloat;
      this.K.setStrokeWidth(paramFloat);
      if (this.al)
        n(paramFloat); 
      invalidateSelf();
    } 
  }
  
  @Deprecated
  public void c(int paramInt) {
    b(this.J.getResources().getDimension(paramInt));
  }
  
  public void c(ColorStateList paramColorStateList) {
    if (this.i != paramColorStateList) {
      this.i = paramColorStateList;
      ak();
      onStateChange(getState());
    } 
  }
  
  public void c(Drawable paramDrawable) {
    if (this.x != paramDrawable) {
      float f1 = c();
      this.x = paramDrawable;
      float f2 = c();
      e(this.x);
      f(this.x);
      invalidateSelf();
      if (f1 != f2)
        b(); 
    } 
  }
  
  public void c(boolean paramBoolean) {
    if (this.p != paramBoolean) {
      boolean bool;
      boolean bool1 = ag();
      this.p = paramBoolean;
      paramBoolean = ag();
      if (bool1 != paramBoolean) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool) {
        if (paramBoolean) {
          f(this.q);
        } else {
          e(this.q);
        } 
        invalidateSelf();
        b();
      } 
    } 
  }
  
  float d() {
    return ag() ? (this.G + this.t + this.H) : 0.0F;
  }
  
  public void d(float paramFloat) {
    if (this.n != paramFloat) {
      float f = c();
      this.n = paramFloat;
      paramFloat = c();
      invalidateSelf();
      if (f != paramFloat)
        b(); 
    } 
  }
  
  public void d(int paramInt) {
    b(AppCompatResources.getColorStateList(this.J, paramInt));
  }
  
  public void d(ColorStateList paramColorStateList) {
    this.o = true;
    if (this.m != paramColorStateList) {
      this.m = paramColorStateList;
      if (ae())
        DrawableCompat.setTintList(this.l, paramColorStateList); 
      onStateChange(getState());
    } 
  }
  
  public void d(boolean paramBoolean) {
    if (this.v != paramBoolean) {
      this.v = paramBoolean;
      float f1 = c();
      if (!paramBoolean && this.X)
        this.X = false; 
      float f2 = c();
      invalidateSelf();
      if (f1 != f2)
        b(); 
    } 
  }
  
  public void draw(Canvas paramCanvas) {
    Rect rect = getBounds();
    if (!rect.isEmpty()) {
      if (getAlpha() == 0)
        return; 
      int i = 0;
      if (this.Z < 255)
        i = CanvasCompat.a(paramCanvas, rect.left, rect.top, rect.right, rect.bottom, this.Z); 
      a(paramCanvas, rect);
      b(paramCanvas, rect);
      if (this.al)
        super.draw(paramCanvas); 
      c(paramCanvas, rect);
      d(paramCanvas, rect);
      e(paramCanvas, rect);
      f(paramCanvas, rect);
      if (this.aj)
        g(paramCanvas, rect); 
      h(paramCanvas, rect);
      i(paramCanvas, rect);
      if (this.Z < 255)
        paramCanvas.restoreToCount(i); 
    } 
  }
  
  public void e() {
    b();
    invalidateSelf();
  }
  
  public void e(float paramFloat) {
    if (this.t != paramFloat) {
      this.t = paramFloat;
      invalidateSelf();
      if (ag())
        b(); 
    } 
  }
  
  public void e(int paramInt) {
    c(this.J.getResources().getDimension(paramInt));
  }
  
  public void e(ColorStateList paramColorStateList) {
    if (this.s != paramColorStateList) {
      this.s = paramColorStateList;
      if (ag())
        DrawableCompat.setTintList(this.q, paramColorStateList); 
      onStateChange(getState());
    } 
  }
  
  public void e(boolean paramBoolean) {
    if (this.w != paramBoolean) {
      boolean bool;
      boolean bool1 = af();
      this.w = paramBoolean;
      paramBoolean = af();
      if (bool1 != paramBoolean) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool) {
        if (paramBoolean) {
          f(this.x);
        } else {
          e(this.x);
        } 
        invalidateSelf();
        b();
      } 
    } 
  }
  
  public void f(float paramFloat) {
    if (this.B != paramFloat) {
      this.B = paramFloat;
      invalidateSelf();
      b();
    } 
  }
  
  public void f(int paramInt) {
    c(AppCompatResources.getColorStateList(this.J, paramInt));
  }
  
  public void f(ColorStateList paramColorStateList) {
    if (this.y != paramColorStateList) {
      this.y = paramColorStateList;
      if (ah())
        DrawableCompat.setTintList(this.x, paramColorStateList); 
      onStateChange(getState());
    } 
  }
  
  void f(boolean paramBoolean) {
    this.aj = paramBoolean;
  }
  
  public boolean f() {
    return d(this.q);
  }
  
  public void g(float paramFloat) {
    if (this.C != paramFloat) {
      float f = c();
      this.C = paramFloat;
      paramFloat = c();
      invalidateSelf();
      if (f != paramFloat)
        b(); 
    } 
  }
  
  public void g(int paramInt) {
    a(new TextAppearance(this.J, paramInt));
  }
  
  public int[] g() {
    return this.ae;
  }
  
  public int getAlpha() {
    return this.Z;
  }
  
  public ColorFilter getColorFilter() {
    return this.aa;
  }
  
  public int getIntrinsicHeight() {
    return (int)this.e;
  }
  
  public int getIntrinsicWidth() {
    return Math.min(Math.round(this.B + c() + this.E + this.Q.a(n().toString()) + this.F + d() + this.I), this.ak);
  }
  
  public int getOpacity() {
    return -3;
  }
  
  public void getOutline(Outline paramOutline) {
    if (this.al) {
      super.getOutline(paramOutline);
      return;
    } 
    Rect rect = getBounds();
    if (!rect.isEmpty()) {
      paramOutline.setRoundRect(rect, this.f);
    } else {
      paramOutline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.f);
    } 
    paramOutline.setAlpha(getAlpha() / 255.0F);
  }
  
  public ColorStateList h() {
    return this.d;
  }
  
  public void h(float paramFloat) {
    if (this.D != paramFloat) {
      float f = c();
      this.D = paramFloat;
      paramFloat = c();
      invalidateSelf();
      if (f != paramFloat)
        b(); 
    } 
  }
  
  public void h(int paramInt) {
    b(this.J.getResources().getBoolean(paramInt));
  }
  
  public float i() {
    return this.e;
  }
  
  public void i(float paramFloat) {
    if (this.E != paramFloat) {
      this.E = paramFloat;
      invalidateSelf();
      b();
    } 
  }
  
  public void i(int paramInt) {
    a(AppCompatResources.getDrawable(this.J, paramInt));
  }
  
  public void invalidateDrawable(Drawable paramDrawable) {
    Drawable.Callback callback = getCallback();
    if (callback != null)
      callback.invalidateDrawable((Drawable)this); 
  }
  
  public boolean isStateful() {
    return (i(this.c) || i(this.d) || i(this.g) || (this.af && i(this.ag)) || b(this.Q.b()) || ah() || d(this.l) || d(this.x) || i(this.ac));
  }
  
  public float j() {
    return this.al ? Z() : this.f;
  }
  
  public void j(float paramFloat) {
    if (this.F != paramFloat) {
      this.F = paramFloat;
      invalidateSelf();
      b();
    } 
  }
  
  public void j(int paramInt) {
    d(AppCompatResources.getColorStateList(this.J, paramInt));
  }
  
  public ColorStateList k() {
    return this.g;
  }
  
  public void k(float paramFloat) {
    if (this.G != paramFloat) {
      this.G = paramFloat;
      invalidateSelf();
      if (ag())
        b(); 
    } 
  }
  
  public void k(int paramInt) {
    d(this.J.getResources().getDimension(paramInt));
  }
  
  public float l() {
    return this.h;
  }
  
  public void l(float paramFloat) {
    if (this.H != paramFloat) {
      this.H = paramFloat;
      invalidateSelf();
      if (ag())
        b(); 
    } 
  }
  
  public void l(int paramInt) {
    b(AppCompatResources.getDrawable(this.J, paramInt));
  }
  
  public ColorStateList m() {
    return this.i;
  }
  
  public void m(float paramFloat) {
    if (this.I != paramFloat) {
      this.I = paramFloat;
      invalidateSelf();
      b();
    } 
  }
  
  public void m(int paramInt) {
    e(AppCompatResources.getColorStateList(this.J, paramInt));
  }
  
  public CharSequence n() {
    return this.j;
  }
  
  public void n(int paramInt) {
    e(this.J.getResources().getDimension(paramInt));
  }
  
  public TextAppearance o() {
    return this.Q.b();
  }
  
  public void o(int paramInt) {
    d(this.J.getResources().getBoolean(paramInt));
  }
  
  public boolean onLayoutDirectionChanged(int paramInt) {
    boolean bool2 = super.onLayoutDirectionChanged(paramInt);
    boolean bool1 = bool2;
    if (ae())
      bool1 = bool2 | DrawableCompat.setLayoutDirection(this.l, paramInt); 
    bool2 = bool1;
    if (af())
      bool2 = bool1 | DrawableCompat.setLayoutDirection(this.x, paramInt); 
    bool1 = bool2;
    if (ag())
      bool1 = bool2 | DrawableCompat.setLayoutDirection(this.q, paramInt); 
    if (bool1)
      invalidateSelf(); 
    return true;
  }
  
  protected boolean onLevelChange(int paramInt) {
    boolean bool2 = super.onLevelChange(paramInt);
    boolean bool1 = bool2;
    if (ae())
      bool1 = bool2 | this.l.setLevel(paramInt); 
    bool2 = bool1;
    if (af())
      bool2 = bool1 | this.x.setLevel(paramInt); 
    bool1 = bool2;
    if (ag())
      bool1 = bool2 | this.q.setLevel(paramInt); 
    if (bool1)
      invalidateSelf(); 
    return bool1;
  }
  
  public boolean onStateChange(int[] paramArrayOfint) {
    if (this.al)
      super.onStateChange(paramArrayOfint); 
    return a(paramArrayOfint, g());
  }
  
  public TextUtils.TruncateAt p() {
    return this.ai;
  }
  
  public void p(int paramInt) {
    e(this.J.getResources().getBoolean(paramInt));
  }
  
  public Drawable q() {
    Drawable drawable = this.l;
    return (drawable != null) ? DrawableCompat.unwrap(drawable) : null;
  }
  
  public void q(int paramInt) {
    c(AppCompatResources.getDrawable(this.J, paramInt));
  }
  
  public ColorStateList r() {
    return this.m;
  }
  
  public void r(int paramInt) {
    f(AppCompatResources.getColorStateList(this.J, paramInt));
  }
  
  public float s() {
    return this.n;
  }
  
  public void s(int paramInt) {
    a(MotionSpec.a(this.J, paramInt));
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong) {
    Drawable.Callback callback = getCallback();
    if (callback != null)
      callback.scheduleDrawable((Drawable)this, paramRunnable, paramLong); 
  }
  
  public void setAlpha(int paramInt) {
    if (this.Z != paramInt) {
      this.Z = paramInt;
      invalidateSelf();
    } 
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    if (this.aa != paramColorFilter) {
      this.aa = paramColorFilter;
      invalidateSelf();
    } 
  }
  
  public void setTintList(ColorStateList paramColorStateList) {
    if (this.ac != paramColorStateList) {
      this.ac = paramColorStateList;
      onStateChange(getState());
    } 
  }
  
  public void setTintMode(PorterDuff.Mode paramMode) {
    if (this.ad != paramMode) {
      this.ad = paramMode;
      this.ab = DrawableUtils.a((Drawable)this, this.ac, paramMode);
      invalidateSelf();
    } 
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2) {
    boolean bool2 = super.setVisible(paramBoolean1, paramBoolean2);
    boolean bool1 = bool2;
    if (ae())
      bool1 = bool2 | this.l.setVisible(paramBoolean1, paramBoolean2); 
    bool2 = bool1;
    if (af())
      bool2 = bool1 | this.x.setVisible(paramBoolean1, paramBoolean2); 
    bool1 = bool2;
    if (ag())
      bool1 = bool2 | this.q.setVisible(paramBoolean1, paramBoolean2); 
    if (bool1)
      invalidateSelf(); 
    return bool1;
  }
  
  public void t(int paramInt) {
    b(MotionSpec.a(this.J, paramInt));
  }
  
  public boolean t() {
    return this.p;
  }
  
  public Drawable u() {
    Drawable drawable = this.q;
    return (drawable != null) ? DrawableCompat.unwrap(drawable) : null;
  }
  
  public void u(int paramInt) {
    f(this.J.getResources().getDimension(paramInt));
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable) {
    Drawable.Callback callback = getCallback();
    if (callback != null)
      callback.unscheduleDrawable((Drawable)this, paramRunnable); 
  }
  
  public ColorStateList v() {
    return this.s;
  }
  
  public void v(int paramInt) {
    g(this.J.getResources().getDimension(paramInt));
  }
  
  public float w() {
    return this.t;
  }
  
  public void w(int paramInt) {
    h(this.J.getResources().getDimension(paramInt));
  }
  
  public CharSequence x() {
    return this.u;
  }
  
  public void x(int paramInt) {
    i(this.J.getResources().getDimension(paramInt));
  }
  
  public void y(int paramInt) {
    j(this.J.getResources().getDimension(paramInt));
  }
  
  public boolean y() {
    return this.v;
  }
  
  public Drawable z() {
    return this.x;
  }
  
  public void z(int paramInt) {
    k(this.J.getResources().getDimension(paramInt));
  }
  
  public static interface Delegate {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\chip\ChipDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */