package com.google.android.material.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.tooltip.TooltipDrawable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends BaseOnChangeListener<S>, T extends BaseOnSliderTouchListener<S>> extends View {
  private static final String a = BaseSlider.class.getSimpleName();
  
  private static final int b = R.style.Widget_MaterialComponents_Slider;
  
  private LabelFormatter A;
  
  private boolean B = false;
  
  private float C;
  
  private float D;
  
  private ArrayList<Float> E = new ArrayList<Float>();
  
  private int F = -1;
  
  private int G = -1;
  
  private float H = 0.0F;
  
  private float[] I;
  
  private int J;
  
  private boolean K;
  
  private boolean L = false;
  
  private boolean M;
  
  private ColorStateList N;
  
  private ColorStateList O;
  
  private ColorStateList P;
  
  private ColorStateList Q;
  
  private ColorStateList R;
  
  private final MaterialShapeDrawable S = new MaterialShapeDrawable();
  
  private float T;
  
  private final Paint c;
  
  private final Paint d;
  
  private final Paint e;
  
  private final Paint f;
  
  private final Paint g;
  
  private final Paint h;
  
  private final AccessibilityHelper i;
  
  private final AccessibilityManager j;
  
  private AccessibilityEventSender k;
  
  private final TooltipDrawableFactory l;
  
  private final List<TooltipDrawable> m = new ArrayList<TooltipDrawable>();
  
  private final List<L> n = new ArrayList<L>();
  
  private final List<T> o = new ArrayList<T>();
  
  private final int p;
  
  private int q;
  
  private int r;
  
  private int s;
  
  private int t;
  
  private int u;
  
  private int v;
  
  private int w;
  
  private int x;
  
  private float y;
  
  private MotionEvent z;
  
  public BaseSlider(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.sliderStyle);
  }
  
  public BaseSlider(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, b), paramAttributeSet, paramInt);
    paramContext = getContext();
    this.c = new Paint();
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setStrokeCap(Paint.Cap.ROUND);
    this.d = new Paint();
    this.d.setStyle(Paint.Style.STROKE);
    this.d.setStrokeCap(Paint.Cap.ROUND);
    this.e = new Paint(1);
    this.e.setStyle(Paint.Style.FILL);
    this.e.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.f = new Paint(1);
    this.f.setStyle(Paint.Style.FILL);
    this.g = new Paint();
    this.g.setStyle(Paint.Style.STROKE);
    this.g.setStrokeCap(Paint.Cap.ROUND);
    this.h = new Paint();
    this.h.setStyle(Paint.Style.STROKE);
    this.h.setStrokeCap(Paint.Cap.ROUND);
    a(paramContext.getResources());
    this.l = new TooltipDrawableFactory(this, paramAttributeSet, paramInt) {
        public TooltipDrawable a() {
          TypedArray typedArray = ThemeEnforcement.a(this.c.getContext(), this.a, R.styleable.Slider, this.b, BaseSlider.d(), new int[0]);
          TooltipDrawable tooltipDrawable = BaseSlider.a(this.c.getContext(), typedArray);
          typedArray.recycle();
          return tooltipDrawable;
        }
      };
    a(paramContext, paramAttributeSet, paramInt);
    setFocusable(true);
    setClickable(true);
    this.S.D(2);
    this.p = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.i = new AccessibilityHelper(this);
    ViewCompat.setAccessibilityDelegate(this, (AccessibilityDelegateCompat)this.i);
    this.j = (AccessibilityManager)getContext().getSystemService("accessibility");
  }
  
  private int a(ColorStateList paramColorStateList) {
    return paramColorStateList.getColorForState(getDrawableState(), paramColorStateList.getDefaultColor());
  }
  
  private static int a(float[] paramArrayOffloat, float paramFloat) {
    return Math.round(paramFloat * (paramArrayOffloat.length / 2 - 1));
  }
  
  private Boolean a(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt != 61) {
      if (paramInt != 66)
        if (paramInt != 81) {
          if (paramInt != 69) {
            if (paramInt != 70) {
              switch (paramInt) {
                default:
                  return null;
                case 22:
                  c(1);
                  return Boolean.valueOf(true);
                case 21:
                  c(-1);
                  return Boolean.valueOf(true);
                case 23:
                  break;
              } 
            } else {
              b(1);
              return Boolean.valueOf(true);
            } 
          } else {
            b(-1);
            return Boolean.valueOf(true);
          } 
        } else {
          b(1);
          return Boolean.valueOf(true);
        }  
      this.F = this.G;
      postInvalidate();
      return Boolean.valueOf(true);
    } 
    return paramKeyEvent.hasNoModifiers() ? Boolean.valueOf(b(1)) : (paramKeyEvent.isShiftPressed() ? Boolean.valueOf(b(-1)) : Boolean.valueOf(false));
  }
  
  private void a(int paramInt) {
    Iterator<L> iterator = this.n.iterator();
    while (iterator.hasNext())
      ((BaseOnChangeListener<BaseSlider>)iterator.next()).a(this, ((Float)this.E.get(paramInt)).floatValue(), true); 
    AccessibilityManager accessibilityManager = this.j;
    if (accessibilityManager != null && accessibilityManager.isEnabled())
      g(paramInt); 
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    ColorStateList colorStateList1;
    int i;
    TypedArray typedArray = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.Slider, paramInt, b, new int[0]);
    this.C = typedArray.getFloat(R.styleable.Slider_android_valueFrom, 0.0F);
    this.D = typedArray.getFloat(R.styleable.Slider_android_valueTo, 1.0F);
    setValues(new Float[] { Float.valueOf(this.C) });
    this.H = typedArray.getFloat(R.styleable.Slider_android_stepSize, 0.0F);
    boolean bool = typedArray.hasValue(R.styleable.Slider_trackColor);
    if (bool) {
      paramInt = R.styleable.Slider_trackColor;
    } else {
      paramInt = R.styleable.Slider_trackColorInactive;
    } 
    if (bool) {
      i = R.styleable.Slider_trackColor;
    } else {
      i = R.styleable.Slider_trackColorActive;
    } 
    ColorStateList colorStateList2 = MaterialResources.a(paramContext, typedArray, paramInt);
    if (colorStateList2 == null)
      colorStateList2 = AppCompatResources.getColorStateList(paramContext, R.color.material_slider_inactive_track_color); 
    setTrackInactiveTintList(colorStateList2);
    colorStateList2 = MaterialResources.a(paramContext, typedArray, i);
    if (colorStateList2 == null)
      colorStateList2 = AppCompatResources.getColorStateList(paramContext, R.color.material_slider_active_track_color); 
    setTrackActiveTintList(colorStateList2);
    colorStateList2 = MaterialResources.a(paramContext, typedArray, R.styleable.Slider_thumbColor);
    this.S.g(colorStateList2);
    colorStateList2 = MaterialResources.a(paramContext, typedArray, R.styleable.Slider_haloColor);
    if (colorStateList2 == null)
      colorStateList2 = AppCompatResources.getColorStateList(paramContext, R.color.material_slider_halo_color); 
    setHaloTintList(colorStateList2);
    bool = typedArray.hasValue(R.styleable.Slider_tickColor);
    if (bool) {
      paramInt = R.styleable.Slider_tickColor;
    } else {
      paramInt = R.styleable.Slider_tickColorInactive;
    } 
    if (bool) {
      i = R.styleable.Slider_tickColor;
    } else {
      i = R.styleable.Slider_tickColorActive;
    } 
    colorStateList2 = MaterialResources.a(paramContext, typedArray, paramInt);
    if (colorStateList2 == null)
      colorStateList2 = AppCompatResources.getColorStateList(paramContext, R.color.material_slider_inactive_tick_marks_color); 
    setTickInactiveTintList(colorStateList2);
    colorStateList2 = MaterialResources.a(paramContext, typedArray, i);
    if (colorStateList2 != null) {
      colorStateList1 = colorStateList2;
    } else {
      colorStateList1 = AppCompatResources.getColorStateList((Context)colorStateList1, R.color.material_slider_active_tick_marks_color);
    } 
    setTickActiveTintList(colorStateList1);
    setThumbRadius(typedArray.getDimensionPixelSize(R.styleable.Slider_thumbRadius, 0));
    setHaloRadius(typedArray.getDimensionPixelSize(R.styleable.Slider_haloRadius, 0));
    setThumbElevation(typedArray.getDimension(R.styleable.Slider_thumbElevation, 0.0F));
    setTrackHeight(typedArray.getDimensionPixelSize(R.styleable.Slider_trackHeight, 0));
    this.r = typedArray.getInt(R.styleable.Slider_labelBehavior, 0);
    if (!typedArray.getBoolean(R.styleable.Slider_android_enabled, true))
      setEnabled(false); 
    typedArray.recycle();
  }
  
  private void a(Resources paramResources) {
    this.q = paramResources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
    this.t = paramResources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
    this.u = paramResources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_top);
    this.x = paramResources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
  }
  
  private void a(Canvas paramCanvas) {
    float[] arrayOfFloat = getActiveRange();
    int j = a(this.I, arrayOfFloat[0]);
    int i = a(this.I, arrayOfFloat[1]);
    arrayOfFloat = this.I;
    j *= 2;
    paramCanvas.drawPoints(arrayOfFloat, 0, j, this.g);
    arrayOfFloat = this.I;
    i *= 2;
    paramCanvas.drawPoints(arrayOfFloat, j, i - j, this.h);
    arrayOfFloat = this.I;
    paramCanvas.drawPoints(arrayOfFloat, i, arrayOfFloat.length - i, this.g);
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2) {
    float[] arrayOfFloat = getActiveRange();
    int i = this.t;
    float f2 = i;
    float f3 = arrayOfFloat[1];
    float f1 = paramInt1;
    f2 += f3 * f1;
    if (f2 < (i + paramInt1)) {
      f3 = paramInt2;
      paramCanvas.drawLine(f2, f3, (i + paramInt1), f3, this.c);
    } 
    paramInt1 = this.t;
    f1 = paramInt1 + arrayOfFloat[0] * f1;
    if (f1 > paramInt1) {
      f2 = paramInt1;
      f3 = paramInt2;
      paramCanvas.drawLine(f2, f3, f1, f3, this.c);
    } 
  }
  
  private void a(TooltipDrawable paramTooltipDrawable) {
    paramTooltipDrawable.a((View)ViewUtils.f(this));
  }
  
  private void a(TooltipDrawable paramTooltipDrawable, float paramFloat) {
    paramTooltipDrawable.a(f(paramFloat));
    int i = this.t + (int)(b(paramFloat) * this.J) - paramTooltipDrawable.getIntrinsicWidth() / 2;
    int j = n() - this.x + this.v;
    paramTooltipDrawable.setBounds(i, j - paramTooltipDrawable.getIntrinsicHeight(), paramTooltipDrawable.getIntrinsicWidth() + i, j);
    Rect rect = new Rect(paramTooltipDrawable.getBounds());
    DescendantOffsetUtils.a(ViewUtils.f(this), this, rect);
    paramTooltipDrawable.setBounds(rect);
    ViewUtils.g(this).a((Drawable)paramTooltipDrawable);
  }
  
  private boolean a(float paramFloat) {
    double d = (new BigDecimal(Float.toString(paramFloat))).subtract(new BigDecimal(Float.toString(this.C))).divide(new BigDecimal(Float.toString(this.H)), MathContext.DECIMAL64).doubleValue();
    return (Math.abs(Math.round(d) - d) < 1.0E-4D);
  }
  
  private boolean a(int paramInt, float paramFloat) {
    if (Math.abs(paramFloat - ((Float)this.E.get(paramInt)).floatValue()) < 1.0E-4D)
      return false; 
    paramFloat = b(paramInt, paramFloat);
    this.E.set(paramInt, Float.valueOf(paramFloat));
    this.G = paramInt;
    a(paramInt);
    return true;
  }
  
  private float b(float paramFloat) {
    float f = this.C;
    paramFloat = (paramFloat - f) / (this.D - f);
    return c() ? (1.0F - paramFloat) : paramFloat;
  }
  
  private float b(int paramInt, float paramFloat) {
    float f1;
    float f2;
    int i = paramInt + 1;
    if (i >= this.E.size()) {
      f1 = this.D;
    } else {
      f1 = ((Float)this.E.get(i)).floatValue();
    } 
    if (--paramInt < 0) {
      f2 = this.C;
    } else {
      f2 = ((Float)this.E.get(paramInt)).floatValue();
    } 
    return MathUtils.clamp(paramFloat, f2, f1);
  }
  
  private static TooltipDrawable b(Context paramContext, TypedArray paramTypedArray) {
    return TooltipDrawable.a(paramContext, null, 0, paramTypedArray.getResourceId(R.styleable.Slider_labelStyle, R.style.Widget_MaterialComponents_Tooltip));
  }
  
  private void b(Canvas paramCanvas, int paramInt1, int paramInt2) {
    float[] arrayOfFloat = getActiveRange();
    int i = this.t;
    float f1 = i;
    float f2 = arrayOfFloat[1];
    float f3 = paramInt1;
    float f4 = i;
    float f5 = arrayOfFloat[0];
    float f6 = paramInt2;
    paramCanvas.drawLine(f4 + f5 * f3, f6, f1 + f2 * f3, f6, this.d);
  }
  
  private void b(TooltipDrawable paramTooltipDrawable) {
    ViewOverlayImpl viewOverlayImpl = ViewUtils.g(this);
    if (viewOverlayImpl != null) {
      viewOverlayImpl.b((Drawable)paramTooltipDrawable);
      paramTooltipDrawable.b((View)ViewUtils.f(this));
    } 
  }
  
  private boolean b(int paramInt) {
    int i = this.G;
    this.G = (int)MathUtils.clamp(i + paramInt, 0L, (this.E.size() - 1));
    paramInt = this.G;
    if (paramInt == i)
      return false; 
    if (this.F != -1)
      this.F = paramInt; 
    m();
    postInvalidate();
    return true;
  }
  
  private double c(float paramFloat) {
    float f = this.H;
    if (f > 0.0F) {
      int i = (int)((this.D - this.C) / f);
      return Math.round(paramFloat * i) / i;
    } 
    return paramFloat;
  }
  
  private void c(Canvas paramCanvas, int paramInt1, int paramInt2) {
    if (!isEnabled())
      for (Float float_ : this.E)
        paramCanvas.drawCircle(this.t + b(float_.floatValue()) * paramInt1, paramInt2, this.v, this.e);  
    for (Float float_ : this.E) {
      paramCanvas.save();
      int i = this.t;
      int j = (int)(b(float_.floatValue()) * paramInt1);
      int k = this.v;
      paramCanvas.translate((i + j - k), (paramInt2 - k));
      this.S.draw(paramCanvas);
      paramCanvas.restore();
    } 
  }
  
  private boolean c(int paramInt) {
    int i = paramInt;
    if (c())
      if (paramInt == Integer.MIN_VALUE) {
        i = Integer.MAX_VALUE;
      } else {
        i = -paramInt;
      }  
    return b(i);
  }
  
  private Float d(int paramInt) {
    float f;
    if (this.L) {
      f = e(20);
    } else {
      f = w();
    } 
    if (paramInt != 21) {
      if (paramInt != 22)
        return (paramInt != 69) ? ((paramInt != 70 && paramInt != 81) ? null : Float.valueOf(f)) : Float.valueOf(-f); 
      float f1 = f;
      if (c())
        f1 = -f; 
      return Float.valueOf(f1);
    } 
    if (!c())
      f = -f; 
    return Float.valueOf(f);
  }
  
  private void d(Canvas paramCanvas, int paramInt1, int paramInt2) {
    if (o()) {
      paramInt1 = (int)(this.t + b(((Float)this.E.get(this.G)).floatValue()) * paramInt1);
      if (Build.VERSION.SDK_INT < 28) {
        int i = this.w;
        paramCanvas.clipRect((paramInt1 - i), (paramInt2 - i), (paramInt1 + i), (i + paramInt2), Region.Op.UNION);
      } 
      paramCanvas.drawCircle(paramInt1, paramInt2, this.w, this.f);
    } 
  }
  
  private boolean d(float paramFloat) {
    return a(this.F, paramFloat);
  }
  
  private float e(float paramFloat) {
    return b(paramFloat) * this.J + this.t;
  }
  
  private float e(int paramInt) {
    float f1 = w();
    float f2 = (this.D - this.C) / f1;
    float f3 = paramInt;
    return (f2 <= f3) ? f1 : (Math.round(f2 / f3) * f1);
  }
  
  private void e() {
    float f = this.C;
    if (f < this.D)
      return; 
    throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", new Object[] { Float.toString(f), Float.toString(this.D) }));
  }
  
  private String f(float paramFloat) {
    String str;
    if (a())
      return this.A.a(paramFloat); 
    if ((int)paramFloat == paramFloat) {
      str = "%.0f";
    } else {
      str = "%.2f";
    } 
    return String.format(str, new Object[] { Float.valueOf(paramFloat) });
  }
  
  private void f() {
    float f = this.D;
    if (f > this.C)
      return; 
    throw new IllegalStateException(String.format("valueTo(%s) must be greater than valueFrom(%s)", new Object[] { Float.toString(f), Float.toString(this.C) }));
  }
  
  private void f(int paramInt) {
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 17) {
          if (paramInt != 66)
            return; 
          c(-2147483648);
          return;
        } 
        c(2147483647);
        return;
      } 
      b(-2147483648);
      return;
    } 
    b(2147483647);
  }
  
  private void g() {
    if (this.H > 0.0F) {
      if (a(this.D))
        return; 
      throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", new Object[] { Float.toString(this.H), Float.toString(this.C), Float.toString(this.D) }));
    } 
  }
  
  private void g(int paramInt) {
    AccessibilityEventSender accessibilityEventSender = this.k;
    if (accessibilityEventSender == null) {
      this.k = new AccessibilityEventSender();
    } else {
      removeCallbacks(accessibilityEventSender);
    } 
    this.k.a(paramInt);
    postDelayed(this.k, 200L);
  }
  
  private float[] getActiveRange() {
    float f2 = ((Float)Collections.<Float>max(getValues())).floatValue();
    float f1 = ((Float)Collections.<Float>min(getValues())).floatValue();
    if (this.E.size() == 1)
      f1 = this.C; 
    f1 = b(f1);
    f2 = b(f2);
    return c() ? new float[] { f2, f1 } : new float[] { f1, f2 };
  }
  
  private float getValueOfTouchPosition() {
    double d2 = c(this.T);
    double d1 = d2;
    if (c())
      d1 = 1.0D - d2; 
    float f1 = this.D;
    float f2 = this.C;
    return (float)(d1 * (f1 - f2) + f2);
  }
  
  private float getValueOfTouchPositionAbsolute() {
    float f2 = this.T;
    float f1 = f2;
    if (c())
      f1 = 1.0F - f2; 
    f2 = this.D;
    float f3 = this.C;
    return f1 * (f2 - f3) + f3;
  }
  
  private void h() {
    for (Float float_ : this.E) {
      if (float_.floatValue() >= this.C && float_.floatValue() <= this.D) {
        if (this.H <= 0.0F || a(float_.floatValue()))
          continue; 
        throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", new Object[] { Float.toString(float_.floatValue()), Float.toString(this.C), Float.toString(this.H), Float.toString(this.H) }));
      } 
      throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", new Object[] { Float.toString(float_.floatValue()), Float.toString(this.C), Float.toString(this.D) }));
    } 
  }
  
  private void i() {
    float f = this.H;
    if (f == 0.0F)
      return; 
    if ((int)f != f)
      Log.w(a, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", new Object[] { "stepSize", Float.valueOf(f) })); 
    f = this.C;
    if ((int)f != f)
      Log.w(a, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", new Object[] { "valueFrom", Float.valueOf(f) })); 
    f = this.D;
    if ((int)f != f)
      Log.w(a, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", new Object[] { "valueTo", Float.valueOf(f) })); 
  }
  
  private void j() {
    if (this.M) {
      e();
      f();
      g();
      h();
      i();
      this.M = false;
    } 
  }
  
  private void k() {
    if (this.m.size() > this.E.size()) {
      List<TooltipDrawable> list = this.m.subList(this.E.size(), this.m.size());
      for (TooltipDrawable tooltipDrawable : list) {
        if (ViewCompat.isAttachedToWindow(this))
          b(tooltipDrawable); 
      } 
      list.clear();
    } 
    while (this.m.size() < this.E.size()) {
      TooltipDrawable tooltipDrawable = this.l.a();
      this.m.add(tooltipDrawable);
      if (ViewCompat.isAttachedToWindow(this))
        a(tooltipDrawable); 
    } 
    int i = this.m.size();
    boolean bool = true;
    if (i == 1)
      bool = false; 
    Iterator<TooltipDrawable> iterator = this.m.iterator();
    while (iterator.hasNext())
      ((TooltipDrawable)iterator.next()).n(bool); 
  }
  
  private void l() {
    j();
    int j = Math.min((int)((this.D - this.C) / this.H + 1.0F), this.J / this.s * 2 + 1);
    float[] arrayOfFloat = this.I;
    if (arrayOfFloat == null || arrayOfFloat.length != j * 2)
      this.I = new float[j * 2]; 
    float f = this.J / (j - 1);
    for (int i = 0; i < j * 2; i += 2) {
      arrayOfFloat = this.I;
      arrayOfFloat[i] = this.t + (i / 2) * f;
      arrayOfFloat[i + 1] = n();
    } 
  }
  
  private void m() {
    if (!o() && getMeasuredWidth() > 0) {
      Drawable drawable = getBackground();
      if (drawable instanceof RippleDrawable) {
        int i = (int)(b(((Float)this.E.get(this.G)).floatValue()) * this.J + this.t);
        int j = n();
        int k = this.w;
        DrawableCompat.setHotspotBounds(drawable, i - k, j - k, i + k, j + k);
      } 
    } 
  }
  
  private int n() {
    int j = this.u;
    int k = this.r;
    int i = 0;
    if (k == 1)
      i = ((TooltipDrawable)this.m.get(0)).getIntrinsicHeight(); 
    return j + i;
  }
  
  private boolean o() {
    return (this.K || Build.VERSION.SDK_INT < 21 || !(getBackground() instanceof RippleDrawable));
  }
  
  private boolean p() {
    return d(getValueOfTouchPosition());
  }
  
  private void q() {
    if (this.r == 2)
      return; 
    Iterator<TooltipDrawable> iterator = this.m.iterator();
    for (int i = 0; i < this.E.size() && iterator.hasNext(); i++) {
      if (i != this.G)
        a(iterator.next(), ((Float)this.E.get(i)).floatValue()); 
    } 
    if (iterator.hasNext()) {
      a(iterator.next(), ((Float)this.E.get(this.G)).floatValue());
      return;
    } 
    throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", new Object[] { Integer.valueOf(this.m.size()), Integer.valueOf(this.E.size()) }));
  }
  
  private void r() {
    this.c.setStrokeWidth(this.s);
    this.d.setStrokeWidth(this.s);
    this.g.setStrokeWidth(this.s / 2.0F);
    this.h.setStrokeWidth(this.s / 2.0F);
  }
  
  private boolean s() {
    for (ViewParent viewParent = getParent(); viewParent instanceof ViewGroup; viewParent = viewParent.getParent()) {
      if (((ViewGroup)viewParent).shouldDelayChildPressedState())
        return true; 
    } 
    return false;
  }
  
  private void setValuesInternal(ArrayList<Float> paramArrayList) {
    if (!paramArrayList.isEmpty()) {
      Collections.sort(paramArrayList);
      if (this.E.size() == paramArrayList.size() && this.E.equals(paramArrayList))
        return; 
      this.E = paramArrayList;
      this.M = true;
      this.G = 0;
      m();
      k();
      t();
      postInvalidate();
      return;
    } 
    throw new IllegalArgumentException("At least one value must be set");
  }
  
  private void t() {
    for (BaseOnChangeListener<BaseSlider> baseOnChangeListener : this.n) {
      Iterator<Float> iterator = this.E.iterator();
      while (iterator.hasNext())
        baseOnChangeListener.a(this, ((Float)iterator.next()).floatValue(), false); 
    } 
  }
  
  private void u() {
    Iterator<T> iterator = this.o.iterator();
    while (iterator.hasNext())
      ((BaseOnSliderTouchListener<BaseSlider>)iterator.next()).a(this); 
  }
  
  private void v() {
    Iterator<T> iterator = this.o.iterator();
    while (iterator.hasNext())
      ((BaseOnSliderTouchListener<BaseSlider>)iterator.next()).b(this); 
  }
  
  private float w() {
    float f2 = this.H;
    float f1 = f2;
    if (f2 == 0.0F)
      f1 = 1.0F; 
    return f1;
  }
  
  void a(int paramInt, Rect paramRect) {
    paramInt = this.t + (int)(b(((Float)getValues().get(paramInt)).floatValue()) * this.J);
    int i = n();
    int j = this.v;
    paramRect.set(paramInt - j, i - j, paramInt + j, i + j);
  }
  
  public boolean a() {
    return (this.A != null);
  }
  
  protected boolean b() {
    Object object;
    if (this.F != -1)
      return true; 
    float f2 = getValueOfTouchPositionAbsolute();
    float f3 = e(f2);
    this.F = 0;
    float f1 = Math.abs(((Float)this.E.get(this.F)).floatValue() - f2);
    int i = 1;
    while (i < this.E.size()) {
      boolean bool;
      float f5 = Math.abs(((Float)this.E.get(i)).floatValue() - f2);
      float f6 = e(((Float)this.E.get(i)).floatValue());
      if (Float.compare(f5, object) > 1)
        break; 
      if (c() ? (f6 - f3 > 0.0F) : (f6 - f3 < 0.0F)) {
        bool = true;
      } else {
        bool = false;
      } 
      if (Float.compare(f5, object) < 0) {
        this.F = i;
      } else {
        Object object1 = object;
        if (Float.compare(f5, object) == 0) {
          if (Math.abs(f6 - f3) < this.p) {
            this.F = -1;
            return false;
          } 
          object1 = object;
          if (bool) {
            this.F = i;
          } else {
            continue;
          } 
        } else {
          continue;
        } 
      } 
      float f4 = f5;
      continue;
      i++;
      object = SYNTHETIC_LOCAL_VARIABLE_2;
    } 
    return (this.F != -1);
  }
  
  final boolean c() {
    return (ViewCompat.getLayoutDirection(this) == 1);
  }
  
  public boolean dispatchHoverEvent(MotionEvent paramMotionEvent) {
    return (this.i.dispatchHoverEvent(paramMotionEvent) || super.dispatchHoverEvent(paramMotionEvent));
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    this.c.setColor(a(this.R));
    this.d.setColor(a(this.Q));
    this.g.setColor(a(this.P));
    this.h.setColor(a(this.O));
    for (TooltipDrawable tooltipDrawable : this.m) {
      if (tooltipDrawable.isStateful())
        tooltipDrawable.setState(getDrawableState()); 
    } 
    if (this.S.isStateful())
      this.S.setState(getDrawableState()); 
    this.f.setColor(a(this.N));
    this.f.setAlpha(63);
  }
  
  public CharSequence getAccessibilityClassName() {
    return SeekBar.class.getName();
  }
  
  final int getAccessibilityFocusedVirtualViewId() {
    return this.i.getAccessibilityFocusedVirtualViewId();
  }
  
  public int getActiveThumbIndex() {
    return this.F;
  }
  
  public int getFocusedThumbIndex() {
    return this.G;
  }
  
  public int getHaloRadius() {
    return this.w;
  }
  
  public ColorStateList getHaloTintList() {
    return this.N;
  }
  
  public int getLabelBehavior() {
    return this.r;
  }
  
  public float getStepSize() {
    return this.H;
  }
  
  public float getThumbElevation() {
    return this.S.S();
  }
  
  public int getThumbRadius() {
    return this.v;
  }
  
  public ColorStateList getThumbTintList() {
    return this.S.M();
  }
  
  public ColorStateList getTickActiveTintList() {
    return this.O;
  }
  
  public ColorStateList getTickInactiveTintList() {
    return this.P;
  }
  
  public ColorStateList getTickTintList() {
    if (this.P.equals(this.O))
      return this.O; 
    throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
  }
  
  public ColorStateList getTrackActiveTintList() {
    return this.Q;
  }
  
  public int getTrackHeight() {
    return this.s;
  }
  
  public ColorStateList getTrackInactiveTintList() {
    return this.R;
  }
  
  public int getTrackSidePadding() {
    return this.t;
  }
  
  public ColorStateList getTrackTintList() {
    if (this.R.equals(this.Q))
      return this.Q; 
    throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
  }
  
  public int getTrackWidth() {
    return this.J;
  }
  
  public float getValueFrom() {
    return this.C;
  }
  
  public float getValueTo() {
    return this.D;
  }
  
  List<Float> getValues() {
    return new ArrayList<Float>(this.E);
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    Iterator<TooltipDrawable> iterator = this.m.iterator();
    while (iterator.hasNext())
      a(iterator.next()); 
  }
  
  protected void onDetachedFromWindow() {
    AccessibilityEventSender accessibilityEventSender = this.k;
    if (accessibilityEventSender != null)
      removeCallbacks(accessibilityEventSender); 
    Iterator<TooltipDrawable> iterator = this.m.iterator();
    while (iterator.hasNext())
      b(iterator.next()); 
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    if (this.M) {
      j();
      if (this.H > 0.0F)
        l(); 
    } 
    super.onDraw(paramCanvas);
    int i = n();
    a(paramCanvas, this.J, i);
    if (((Float)Collections.<Float>max(getValues())).floatValue() > this.C)
      b(paramCanvas, this.J, i); 
    if (this.H > 0.0F)
      a(paramCanvas); 
    if ((this.B || isFocused()) && isEnabled()) {
      d(paramCanvas, this.J, i);
      if (this.F != -1)
        q(); 
    } 
    c(paramCanvas, this.J, i);
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect) {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (!paramBoolean) {
      this.F = -1;
      for (TooltipDrawable tooltipDrawable : this.m)
        ViewUtils.g(this).b((Drawable)tooltipDrawable); 
      this.i.clearKeyboardFocusForVirtualView(this.G);
      return;
    } 
    f(paramInt);
    this.i.requestKeyboardFocusForVirtualView(this.G);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (!isEnabled())
      return super.onKeyDown(paramInt, paramKeyEvent); 
    if (this.E.size() == 1)
      this.F = 0; 
    if (this.F == -1) {
      Boolean bool = a(paramInt, paramKeyEvent);
      return (bool != null) ? bool.booleanValue() : super.onKeyDown(paramInt, paramKeyEvent);
    } 
    this.L |= paramKeyEvent.isLongPress();
    Float float_ = d(paramInt);
    if (float_ != null) {
      if (d(((Float)this.E.get(this.F)).floatValue() + float_.floatValue())) {
        m();
        postInvalidate();
      } 
      return true;
    } 
    if (paramInt != 23)
      if (paramInt != 61) {
        if (paramInt != 66)
          return super.onKeyDown(paramInt, paramKeyEvent); 
      } else {
        return paramKeyEvent.hasNoModifiers() ? b(1) : (paramKeyEvent.isShiftPressed() ? b(-1) : false);
      }  
    this.F = -1;
    for (TooltipDrawable tooltipDrawable : this.m)
      ViewUtils.g(this).b((Drawable)tooltipDrawable); 
    postInvalidate();
    return true;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    this.L = false;
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int i = this.q;
    int j = this.r;
    paramInt2 = 0;
    if (j == 1)
      paramInt2 = ((TooltipDrawable)this.m.get(0)).getIntrinsicHeight(); 
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(i + paramInt2, 1073741824));
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    SliderState sliderState = (SliderState)paramParcelable;
    super.onRestoreInstanceState(sliderState.getSuperState());
    this.C = sliderState.a;
    this.D = sliderState.b;
    setValuesInternal(sliderState.c);
    this.H = sliderState.d;
    if (sliderState.e)
      requestFocus(); 
    t();
  }
  
  protected Parcelable onSaveInstanceState() {
    SliderState sliderState = new SliderState(super.onSaveInstanceState());
    sliderState.a = this.C;
    sliderState.b = this.D;
    sliderState.c = new ArrayList<Float>(this.E);
    sliderState.d = this.H;
    sliderState.e = hasFocus();
    return (Parcelable)sliderState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.J = Math.max(paramInt1 - this.t * 2, 0);
    if (this.H > 0.0F)
      l(); 
    m();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (!isEnabled())
      return false; 
    float f = paramMotionEvent.getX();
    this.T = (f - this.t) / this.J;
    this.T = Math.max(0.0F, this.T);
    this.T = Math.min(1.0F, this.T);
    int i = paramMotionEvent.getActionMasked();
    if (i != 0) {
      if (i != 1) {
        if (i == 2) {
          if (!this.B) {
            if (Math.abs(f - this.y) < this.p)
              return false; 
            getParent().requestDisallowInterceptTouchEvent(true);
            u();
          } 
          if (b()) {
            this.B = true;
            p();
            m();
            invalidate();
          } 
        } 
      } else {
        this.B = false;
        MotionEvent motionEvent = this.z;
        if (motionEvent != null && motionEvent.getActionMasked() == 0 && Math.abs(this.z.getX() - paramMotionEvent.getX()) <= this.p && Math.abs(this.z.getY() - paramMotionEvent.getY()) <= this.p)
          b(); 
        if (this.F != -1) {
          p();
          this.F = -1;
        } 
        for (TooltipDrawable tooltipDrawable : this.m)
          ViewUtils.g(this).b((Drawable)tooltipDrawable); 
        v();
        invalidate();
      } 
    } else {
      this.y = f;
      if (!s()) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (b()) {
          requestFocus();
          this.B = true;
          p();
          m();
          invalidate();
          u();
        } 
      } 
    } 
    setPressed(this.B);
    this.z = MotionEvent.obtain(paramMotionEvent);
    return true;
  }
  
  protected void setActiveThumbIndex(int paramInt) {
    this.F = paramInt;
  }
  
  public void setEnabled(boolean paramBoolean) {
    byte b;
    super.setEnabled(paramBoolean);
    if (paramBoolean) {
      b = 0;
    } else {
      b = 2;
    } 
    setLayerType(b, null);
  }
  
  public void setFocusedThumbIndex(int paramInt) {
    if (paramInt >= 0 && paramInt < this.E.size()) {
      this.G = paramInt;
      this.i.requestKeyboardFocusForVirtualView(this.G);
      postInvalidate();
      return;
    } 
    throw new IllegalArgumentException("index out of range");
  }
  
  public void setHaloRadius(int paramInt) {
    if (paramInt == this.w)
      return; 
    this.w = paramInt;
    Drawable drawable = getBackground();
    if (!o() && drawable instanceof RippleDrawable) {
      DrawableUtils.a((RippleDrawable)drawable, this.w);
      return;
    } 
    postInvalidate();
  }
  
  public void setHaloRadiusResource(int paramInt) {
    setHaloRadius(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setHaloTintList(ColorStateList paramColorStateList) {
    if (paramColorStateList.equals(this.N))
      return; 
    this.N = paramColorStateList;
    Drawable drawable = getBackground();
    if (!o() && drawable instanceof RippleDrawable) {
      ((RippleDrawable)drawable).setColor(paramColorStateList);
      return;
    } 
    this.f.setColor(a(paramColorStateList));
    this.f.setAlpha(63);
    invalidate();
  }
  
  public void setLabelBehavior(int paramInt) {
    if (this.r != paramInt) {
      this.r = paramInt;
      requestLayout();
    } 
  }
  
  public void setLabelFormatter(LabelFormatter paramLabelFormatter) {
    this.A = paramLabelFormatter;
  }
  
  public void setStepSize(float paramFloat) {
    if (paramFloat >= 0.0F) {
      if (this.H != paramFloat) {
        this.H = paramFloat;
        this.M = true;
        postInvalidate();
      } 
      return;
    } 
    throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", new Object[] { Float.toString(paramFloat), Float.toString(this.C), Float.toString(this.D) }));
  }
  
  public void setThumbElevation(float paramFloat) {
    this.S.r(paramFloat);
  }
  
  public void setThumbElevationResource(int paramInt) {
    setThumbElevation(getResources().getDimension(paramInt));
  }
  
  public void setThumbRadius(int paramInt) {
    if (paramInt == this.v)
      return; 
    this.v = paramInt;
    this.S.setShapeAppearanceModel(ShapeAppearanceModel.a().a(0, this.v).a());
    MaterialShapeDrawable materialShapeDrawable = this.S;
    paramInt = this.v;
    materialShapeDrawable.setBounds(0, 0, paramInt * 2, paramInt * 2);
    postInvalidate();
  }
  
  public void setThumbRadiusResource(int paramInt) {
    setThumbRadius(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setThumbTintList(ColorStateList paramColorStateList) {
    this.S.g(paramColorStateList);
  }
  
  public void setTickActiveTintList(ColorStateList paramColorStateList) {
    if (paramColorStateList.equals(this.O))
      return; 
    this.O = paramColorStateList;
    this.h.setColor(a(this.O));
    invalidate();
  }
  
  public void setTickInactiveTintList(ColorStateList paramColorStateList) {
    if (paramColorStateList.equals(this.P))
      return; 
    this.P = paramColorStateList;
    this.g.setColor(a(this.P));
    invalidate();
  }
  
  public void setTickTintList(ColorStateList paramColorStateList) {
    setTickInactiveTintList(paramColorStateList);
    setTickActiveTintList(paramColorStateList);
  }
  
  public void setTrackActiveTintList(ColorStateList paramColorStateList) {
    if (paramColorStateList.equals(this.Q))
      return; 
    this.Q = paramColorStateList;
    this.d.setColor(a(this.Q));
    invalidate();
  }
  
  public void setTrackHeight(int paramInt) {
    if (this.s != paramInt) {
      this.s = paramInt;
      r();
      postInvalidate();
    } 
  }
  
  public void setTrackInactiveTintList(ColorStateList paramColorStateList) {
    if (paramColorStateList.equals(this.R))
      return; 
    this.R = paramColorStateList;
    this.c.setColor(a(this.R));
    invalidate();
  }
  
  public void setTrackTintList(ColorStateList paramColorStateList) {
    setTrackInactiveTintList(paramColorStateList);
    setTrackActiveTintList(paramColorStateList);
  }
  
  public void setValueFrom(float paramFloat) {
    this.C = paramFloat;
    this.M = true;
    postInvalidate();
  }
  
  public void setValueTo(float paramFloat) {
    this.D = paramFloat;
    this.M = true;
    postInvalidate();
  }
  
  void setValues(List<Float> paramList) {
    setValuesInternal(new ArrayList<Float>(paramList));
  }
  
  void setValues(Float... paramVarArgs) {
    ArrayList<? super Float> arrayList = new ArrayList();
    Collections.addAll(arrayList, paramVarArgs);
    setValuesInternal((ArrayList)arrayList);
  }
  
  class AccessibilityEventSender implements Runnable {
    int a = -1;
    
    private AccessibilityEventSender(BaseSlider this$0) {}
    
    void a(int param1Int) {
      this.a = param1Int;
    }
    
    public void run() {
      BaseSlider.a(this.b).sendEventForVirtualView(this.a, 4);
    }
  }
  
  static class AccessibilityHelper extends ExploreByTouchHelper {
    Rect c = new Rect();
    
    private final BaseSlider<?, ?, ?> d;
    
    AccessibilityHelper(BaseSlider<?, ?, ?> param1BaseSlider) {
      super(param1BaseSlider);
      this.d = param1BaseSlider;
    }
    
    private String b(int param1Int) {
      return (param1Int == this.d.getValues().size() - 1) ? this.d.getContext().getString(R.string.material_slider_range_end) : ((param1Int == 0) ? this.d.getContext().getString(R.string.material_slider_range_start) : "");
    }
    
    public int a(float param1Float1, float param1Float2) {
      for (int i = 0; i < this.d.getValues().size(); i++) {
        this.d.a(i, this.c);
        if (this.c.contains((int)param1Float1, (int)param1Float2))
          return i; 
      } 
      return -1;
    }
    
    public void a(int param1Int, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
      param1AccessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
      List<Float> list = this.d.getValues();
      float f1 = ((Float)list.get(param1Int)).floatValue();
      float f2 = this.d.getValueFrom();
      float f3 = this.d.getValueTo();
      if (this.d.isEnabled()) {
        if (f1 > f2)
          param1AccessibilityNodeInfoCompat.addAction(8192); 
        if (f1 < f3)
          param1AccessibilityNodeInfoCompat.addAction(4096); 
      } 
      param1AccessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, f2, f3, f1));
      param1AccessibilityNodeInfoCompat.setClassName(SeekBar.class.getName());
      StringBuilder stringBuilder = new StringBuilder();
      if (this.d.getContentDescription() != null) {
        stringBuilder.append(this.d.getContentDescription());
        stringBuilder.append(",");
      } 
      if (list.size() > 1) {
        stringBuilder.append(b(param1Int));
        stringBuilder.append(BaseSlider.a(this.d, f1));
      } 
      param1AccessibilityNodeInfoCompat.setContentDescription(stringBuilder.toString());
      this.d.a(param1Int, this.c);
      param1AccessibilityNodeInfoCompat.setBoundsInParent(this.c);
    }
    
    public void a(List<Integer> param1List) {
      for (int i = 0; i < this.d.getValues().size(); i++)
        param1List.add(Integer.valueOf(i)); 
    }
    
    public boolean b(int param1Int1, int param1Int2, Bundle param1Bundle) {
      if (!this.d.isEnabled())
        return false; 
      if (param1Int2 != 4096 && param1Int2 != 8192) {
        if (param1Int2 != 16908349)
          return false; 
        if (param1Bundle != null) {
          if (!param1Bundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"))
            return false; 
          float f = param1Bundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE");
          if (BaseSlider.a(this.d, param1Int1, f)) {
            BaseSlider.b(this.d);
            this.d.postInvalidate();
            invalidateVirtualView(param1Int1);
            return true;
          } 
        } 
        return false;
      } 
      float f2 = BaseSlider.a(this.d, 20);
      float f1 = f2;
      if (param1Int2 == 8192)
        f1 = -f2; 
      f2 = f1;
      if (this.d.c())
        f2 = -f1; 
      f1 = MathUtils.clamp(((Float)this.d.getValues().get(param1Int1)).floatValue() + f2, this.d.getValueFrom(), this.d.getValueTo());
      if (BaseSlider.a(this.d, param1Int1, f1)) {
        BaseSlider.b(this.d);
        this.d.postInvalidate();
        invalidateVirtualView(param1Int1);
        return true;
      } 
      return false;
    }
  }
  
  static class SliderState extends View.BaseSavedState {
    public static final Parcelable.Creator<SliderState> CREATOR = new Parcelable.Creator<SliderState>() {
        public BaseSlider.SliderState a(Parcel param2Parcel) {
          return new BaseSlider.SliderState(param2Parcel);
        }
        
        public BaseSlider.SliderState[] a(int param2Int) {
          return new BaseSlider.SliderState[param2Int];
        }
      };
    
    float a;
    
    float b;
    
    ArrayList<Float> c;
    
    float d;
    
    boolean e;
    
    private SliderState(Parcel param1Parcel) {
      super(param1Parcel);
      this.a = param1Parcel.readFloat();
      this.b = param1Parcel.readFloat();
      this.c = new ArrayList<Float>();
      param1Parcel.readList(this.c, Float.class.getClassLoader());
      this.d = param1Parcel.readFloat();
      this.e = param1Parcel.createBooleanArray()[0];
    }
    
    SliderState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeFloat(this.a);
      param1Parcel.writeFloat(this.b);
      param1Parcel.writeList(this.c);
      param1Parcel.writeFloat(this.d);
      param1Parcel.writeBooleanArray(new boolean[] { this.e });
    }
  }
  
  static final class null implements Parcelable.Creator<SliderState> {
    public BaseSlider.SliderState a(Parcel param1Parcel) {
      return new BaseSlider.SliderState(param1Parcel);
    }
    
    public BaseSlider.SliderState[] a(int param1Int) {
      return new BaseSlider.SliderState[param1Int];
    }
  }
  
  static interface TooltipDrawableFactory {
    TooltipDrawable a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\slider\BaseSlider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */