package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Chip extends AppCompatCheckBox implements ChipDrawable.Delegate, Shapeable {
  private static final int a = R.style.Widget_MaterialComponents_Chip_Action;
  
  private static final Rect b = new Rect();
  
  private static final int[] c = new int[] { 16842913 };
  
  private static final int[] d = new int[] { 16842911 };
  
  private ChipDrawable e;
  
  private InsetDrawable f;
  
  private RippleDrawable g;
  
  private View.OnClickListener h;
  
  private CompoundButton.OnCheckedChangeListener i;
  
  private boolean j;
  
  private boolean k;
  
  private boolean l;
  
  private boolean m;
  
  private boolean n;
  
  private int o;
  
  private int p;
  
  private final ChipTouchHelper q;
  
  private final Rect r = new Rect();
  
  private final RectF s = new RectF();
  
  private final TextAppearanceFontCallback t = new TextAppearanceFontCallback(this) {
      public void a(int param1Int) {}
      
      public void a(Typeface param1Typeface, boolean param1Boolean) {
        CharSequence charSequence;
        Chip chip = this.a;
        if (Chip.a(chip).L()) {
          charSequence = Chip.a(this.a).n();
        } else {
          charSequence = this.a.getText();
        } 
        chip.setText(charSequence);
        this.a.requestLayout();
        this.a.invalidate();
      }
    };
  
  public Chip(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public Chip(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.chipStyle);
  }
  
  public Chip(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, a), paramAttributeSet, paramInt);
    paramContext = getContext();
    a(paramAttributeSet);
    ChipDrawable chipDrawable = ChipDrawable.a(paramContext, paramAttributeSet, paramInt, a);
    a(paramContext, paramAttributeSet, paramInt);
    setChipDrawable(chipDrawable);
    chipDrawable.r(ViewCompat.getElevation((View)this));
    TypedArray typedArray = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.Chip, paramInt, a, new int[0]);
    if (Build.VERSION.SDK_INT < 23)
      setTextColor(MaterialResources.a(paramContext, typedArray, R.styleable.Chip_android_textColor)); 
    boolean bool = typedArray.hasValue(R.styleable.Chip_shapeAppearance);
    typedArray.recycle();
    this.q = new ChipTouchHelper(this, this);
    g();
    if (!bool)
      i(); 
    setChecked(this.j);
    setText(chipDrawable.n());
    setEllipsize(chipDrawable.p());
    o();
    if (!this.e.L()) {
      setLines(1);
      setHorizontallyScrolling(true);
    } 
    setGravity(8388627);
    h();
    if (e())
      setMinHeight(this.p); 
    this.o = ViewCompat.getLayoutDirection((View)this);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.f = new InsetDrawable((Drawable)this.e, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    TypedArray typedArray = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.Chip, paramInt, a, new int[0]);
    this.n = typedArray.getBoolean(R.styleable.Chip_ensureMinTouchTargetSize, false);
    float f = (float)Math.ceil(ViewUtils.a(getContext(), 48));
    this.p = (int)Math.ceil(typedArray.getDimension(R.styleable.Chip_chipMinTouchTargetSize, f));
    typedArray.recycle();
  }
  
  private void a(AttributeSet paramAttributeSet) {
    if (paramAttributeSet == null)
      return; 
    if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null)
      Log.w("Chip", "Do not set the background; Chip manages its own background drawable."); 
    if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") == null) {
      if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") == null) {
        if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") == null) {
          if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") == null) {
            if (paramAttributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) && paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) == 1 && paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) == 1 && paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) == 1) {
              if (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627)
                Log.w("Chip", "Chip text must be vertically center and start aligned"); 
              return;
            } 
            throw new UnsupportedOperationException("Chip does not support multi-line text");
          } 
          throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        } 
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
      } 
      throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    } 
    throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
  }
  
  private void a(ChipDrawable paramChipDrawable) {
    if (paramChipDrawable != null)
      paramChipDrawable.a((ChipDrawable.Delegate)null); 
  }
  
  private boolean a(MotionEvent paramMotionEvent) {
    if (paramMotionEvent.getAction() == 10)
      try {
        Field field = ExploreByTouchHelper.class.getDeclaredField("k");
        field.setAccessible(true);
        if (((Integer)field.get(this.q)).intValue() != Integer.MIN_VALUE) {
          Method method = ExploreByTouchHelper.class.getDeclaredMethod("c", new Class[] { int.class });
          method.setAccessible(true);
          method.invoke(this.q, new Object[] { Integer.valueOf(-2147483648) });
          return true;
        } 
      } catch (NoSuchMethodException noSuchMethodException) {
        Log.e("Chip", "Unable to send Accessibility Exit event", noSuchMethodException);
      } catch (IllegalAccessException illegalAccessException) {
        Log.e("Chip", "Unable to send Accessibility Exit event", illegalAccessException);
        return false;
      } catch (InvocationTargetException invocationTargetException) {
        Log.e("Chip", "Unable to send Accessibility Exit event", invocationTargetException);
        return false;
      } catch (NoSuchFieldException noSuchFieldException) {
        Log.e("Chip", "Unable to send Accessibility Exit event", noSuchFieldException);
        return false;
      }  
    return false;
  }
  
  private void b(ChipDrawable paramChipDrawable) {
    paramChipDrawable.a(this);
  }
  
  private void g() {
    if (n() && c() && this.h != null) {
      ViewCompat.setAccessibilityDelegate((View)this, (AccessibilityDelegateCompat)this.q);
      return;
    } 
    ViewCompat.setAccessibilityDelegate((View)this, null);
  }
  
  private RectF getCloseIconTouchBounds() {
    this.s.setEmpty();
    if (n())
      this.e.a(this.s); 
    return this.s;
  }
  
  private Rect getCloseIconTouchBoundsInt() {
    RectF rectF = getCloseIconTouchBounds();
    this.r.set((int)rectF.left, (int)rectF.top, (int)rectF.right, (int)rectF.bottom);
    return this.r;
  }
  
  private TextAppearance getTextAppearance() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.o() : null;
  }
  
  private void h() {
    if (!TextUtils.isEmpty(getText())) {
      ChipDrawable chipDrawable = this.e;
      if (chipDrawable == null)
        return; 
      int k = (int)(chipDrawable.K() + this.e.H() + this.e.d());
      int m = (int)(this.e.D() + this.e.G() + this.e.c());
      int j = k;
      int i = m;
      if (this.f != null) {
        Rect rect = new Rect();
        this.f.getPadding(rect);
        i = m + rect.left;
        j = k + rect.right;
      } 
      ViewCompat.setPaddingRelative((View)this, i, getPaddingTop(), j, getPaddingBottom());
    } 
  }
  
  private void i() {
    if (Build.VERSION.SDK_INT >= 21)
      setOutlineProvider(new ViewOutlineProvider(this) {
            public void getOutline(View param1View, Outline param1Outline) {
              if (Chip.a(this.a) != null) {
                Chip.a(this.a).getOutline(param1Outline);
                return;
              } 
              param1Outline.setAlpha(0.0F);
            }
          }); 
  }
  
  private void j() {
    if (RippleUtils.a) {
      l();
      return;
    } 
    this.e.a(true);
    ViewCompat.setBackground((View)this, getBackgroundDrawable());
    h();
    k();
  }
  
  private void k() {
    if (getBackgroundDrawable() == this.f && this.e.getCallback() == null)
      this.e.setCallback((Drawable.Callback)this.f); 
  }
  
  private void l() {
    this.g = new RippleDrawable(RippleUtils.b(this.e.m()), getBackgroundDrawable(), null);
    this.e.a(false);
    ViewCompat.setBackground((View)this, (Drawable)this.g);
    h();
  }
  
  private int[] m() {
    boolean bool1 = isEnabled();
    boolean bool = false;
    if (bool1) {
      j = 1;
    } else {
      j = 0;
    } 
    int i = j;
    if (this.m)
      i = j + 1; 
    int j = i;
    if (this.l)
      j = i + 1; 
    i = j;
    if (this.k)
      i = j + 1; 
    j = i;
    if (isChecked())
      j = i + 1; 
    int[] arrayOfInt = new int[j];
    j = bool;
    if (isEnabled()) {
      arrayOfInt[0] = 16842910;
      j = 1;
    } 
    i = j;
    if (this.m) {
      arrayOfInt[j] = 16842908;
      i = j + 1;
    } 
    j = i;
    if (this.l) {
      arrayOfInt[i] = 16843623;
      j = i + 1;
    } 
    i = j;
    if (this.k) {
      arrayOfInt[j] = 16842919;
      i = j + 1;
    } 
    if (isChecked())
      arrayOfInt[i] = 16842913; 
    return arrayOfInt;
  }
  
  private boolean n() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null && chipDrawable.u() != null);
  }
  
  private void o() {
    TextPaint textPaint = getPaint();
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      textPaint.drawableState = chipDrawable.getState(); 
    TextAppearance textAppearance = getTextAppearance();
    if (textAppearance != null)
      textAppearance.b(getContext(), textPaint, this.t); 
  }
  
  private void p() {
    if (this.f != null) {
      this.f = null;
      setMinWidth(0);
      setMinHeight((int)getChipMinHeight());
      j();
    } 
  }
  
  private void setCloseIconHovered(boolean paramBoolean) {
    if (this.l != paramBoolean) {
      this.l = paramBoolean;
      refreshDrawableState();
    } 
  }
  
  private void setCloseIconPressed(boolean paramBoolean) {
    if (this.k != paramBoolean) {
      this.k = paramBoolean;
      refreshDrawableState();
    } 
  }
  
  public void a() {
    a(this.p);
    requestLayout();
    if (Build.VERSION.SDK_INT >= 21)
      invalidateOutline(); 
  }
  
  public boolean a(int paramInt) {
    this.p = paramInt;
    boolean bool = e();
    int j = 0;
    if (!bool) {
      if (this.f != null) {
        p();
        return false;
      } 
      j();
      return false;
    } 
    int k = Math.max(0, paramInt - this.e.getIntrinsicHeight());
    int i = Math.max(0, paramInt - this.e.getIntrinsicWidth());
    if (i <= 0 && k <= 0) {
      if (this.f != null) {
        p();
        return false;
      } 
      j();
      return false;
    } 
    if (i > 0) {
      i /= 2;
    } else {
      i = 0;
    } 
    if (k > 0)
      j = k / 2; 
    if (this.f != null) {
      Rect rect = new Rect();
      this.f.getPadding(rect);
      if (rect.top == j && rect.bottom == j && rect.left == i && rect.right == i) {
        j();
        return true;
      } 
    } 
    if (Build.VERSION.SDK_INT >= 16) {
      if (getMinHeight() != paramInt)
        setMinHeight(paramInt); 
      if (getMinWidth() != paramInt)
        setMinWidth(paramInt); 
    } else {
      setMinHeight(paramInt);
      setMinWidth(paramInt);
    } 
    a(i, j, i, j);
    j();
    return true;
  }
  
  public boolean b() {
    boolean bool = false;
    playSoundEffect(0);
    View.OnClickListener onClickListener = this.h;
    if (onClickListener != null) {
      onClickListener.onClick((View)this);
      bool = true;
    } 
    this.q.sendEventForVirtualView(1, 1);
    return bool;
  }
  
  public boolean c() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null && chipDrawable.t());
  }
  
  public boolean d() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null && chipDrawable.y());
  }
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent) {
    return (a(paramMotionEvent) || this.q.dispatchHoverEvent(paramMotionEvent) || super.dispatchHoverEvent(paramMotionEvent));
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    return (this.q.dispatchKeyEvent(paramKeyEvent) && this.q.getKeyboardFocusedVirtualViewId() != Integer.MIN_VALUE) ? true : super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void drawableStateChanged() {
    boolean bool;
    super.drawableStateChanged();
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null && chipDrawable.f()) {
      bool = this.e.a(m());
    } else {
      bool = false;
    } 
    if (bool)
      invalidate(); 
  }
  
  public boolean e() {
    return this.n;
  }
  
  public Drawable getBackgroundDrawable() {
    ChipDrawable chipDrawable;
    InsetDrawable insetDrawable2 = this.f;
    InsetDrawable insetDrawable1 = insetDrawable2;
    if (insetDrawable2 == null)
      chipDrawable = this.e; 
    return (Drawable)chipDrawable;
  }
  
  public Drawable getCheckedIcon() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.z() : null;
  }
  
  public ColorStateList getCheckedIconTint() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.A() : null;
  }
  
  public ColorStateList getChipBackgroundColor() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.h() : null;
  }
  
  public float getChipCornerRadius() {
    ChipDrawable chipDrawable = this.e;
    float f = 0.0F;
    if (chipDrawable != null)
      f = Math.max(0.0F, chipDrawable.j()); 
    return f;
  }
  
  public Drawable getChipDrawable() {
    return (Drawable)this.e;
  }
  
  public float getChipEndPadding() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.K() : 0.0F;
  }
  
  public Drawable getChipIcon() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.q() : null;
  }
  
  public float getChipIconSize() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.s() : 0.0F;
  }
  
  public ColorStateList getChipIconTint() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.r() : null;
  }
  
  public float getChipMinHeight() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.i() : 0.0F;
  }
  
  public float getChipStartPadding() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.D() : 0.0F;
  }
  
  public ColorStateList getChipStrokeColor() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.k() : null;
  }
  
  public float getChipStrokeWidth() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.l() : 0.0F;
  }
  
  @Deprecated
  public CharSequence getChipText() {
    return getText();
  }
  
  public Drawable getCloseIcon() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.u() : null;
  }
  
  public CharSequence getCloseIconContentDescription() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.x() : null;
  }
  
  public float getCloseIconEndPadding() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.J() : 0.0F;
  }
  
  public float getCloseIconSize() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.w() : 0.0F;
  }
  
  public float getCloseIconStartPadding() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.I() : 0.0F;
  }
  
  public ColorStateList getCloseIconTint() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.v() : null;
  }
  
  public TextUtils.TruncateAt getEllipsize() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.p() : null;
  }
  
  public void getFocusedRect(Rect paramRect) {
    if (this.q.getKeyboardFocusedVirtualViewId() == 1 || this.q.getAccessibilityFocusedVirtualViewId() == 1) {
      paramRect.set(getCloseIconTouchBoundsInt());
      return;
    } 
    super.getFocusedRect(paramRect);
  }
  
  public MotionSpec getHideMotionSpec() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.C() : null;
  }
  
  public float getIconEndPadding() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.F() : 0.0F;
  }
  
  public float getIconStartPadding() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.E() : 0.0F;
  }
  
  public ColorStateList getRippleColor() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.m() : null;
  }
  
  public ShapeAppearanceModel getShapeAppearanceModel() {
    return this.e.getShapeAppearanceModel();
  }
  
  public MotionSpec getShowMotionSpec() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.B() : null;
  }
  
  public float getTextEndPadding() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.H() : 0.0F;
  }
  
  public float getTextStartPadding() {
    ChipDrawable chipDrawable = this.e;
    return (chipDrawable != null) ? chipDrawable.G() : 0.0F;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    MaterialShapeUtils.a((View)this, this.e);
  }
  
  protected int[] onCreateDrawableState(int paramInt) {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    if (isChecked())
      mergeDrawableStates(arrayOfInt, c); 
    if (d())
      mergeDrawableStates(arrayOfInt, d); 
    return arrayOfInt;
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect) {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    this.q.onFocusChanged(paramBoolean, paramInt, paramRect);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getActionMasked();
    if (i != 7) {
      if (i == 10)
        setCloseIconHovered(false); 
    } else {
      setCloseIconHovered(getCloseIconTouchBounds().contains(paramMotionEvent.getX(), paramMotionEvent.getY()));
    } 
    return super.onHoverEvent(paramMotionEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    if (d() || isClickable()) {
      String str;
      if (d()) {
        str = "android.widget.CompoundButton";
      } else {
        str = "android.widget.Button";
      } 
      paramAccessibilityNodeInfo.setClassName(str);
    } else {
      paramAccessibilityNodeInfo.setClassName("android.view.View");
    } 
    paramAccessibilityNodeInfo.setCheckable(d());
    paramAccessibilityNodeInfo.setClickable(isClickable());
    if (getParent() instanceof ChipGroup) {
      byte b;
      ChipGroup chipGroup = (ChipGroup)getParent();
      AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo);
      if (chipGroup.b()) {
        b = chipGroup.a((View)this);
      } else {
        b = -1;
      } 
      accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(chipGroup.b((View)this), 1, b, 1, false, isChecked()));
    } 
  }
  
  public PointerIcon onResolvePointerIcon(MotionEvent paramMotionEvent, int paramInt) {
    return (getCloseIconTouchBounds().contains(paramMotionEvent.getX(), paramMotionEvent.getY()) && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : null;
  }
  
  public void onRtlPropertiesChanged(int paramInt) {
    super.onRtlPropertiesChanged(paramInt);
    if (this.o != paramInt) {
      this.o = paramInt;
      h();
    } 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getActionMasked : ()I
    //   4: istore_2
    //   5: aload_0
    //   6: invokespecial getCloseIconTouchBounds : ()Landroid/graphics/RectF;
    //   9: aload_1
    //   10: invokevirtual getX : ()F
    //   13: aload_1
    //   14: invokevirtual getY : ()F
    //   17: invokevirtual contains : (FF)Z
    //   20: istore #4
    //   22: iconst_0
    //   23: istore_3
    //   24: iload_2
    //   25: ifeq -> 93
    //   28: iload_2
    //   29: iconst_1
    //   30: if_icmpeq -> 66
    //   33: iload_2
    //   34: iconst_2
    //   35: if_icmpeq -> 46
    //   38: iload_2
    //   39: iconst_3
    //   40: if_icmpeq -> 83
    //   43: goto -> 108
    //   46: aload_0
    //   47: getfield k : Z
    //   50: ifeq -> 108
    //   53: iload #4
    //   55: ifne -> 103
    //   58: aload_0
    //   59: iconst_0
    //   60: invokespecial setCloseIconPressed : (Z)V
    //   63: goto -> 103
    //   66: aload_0
    //   67: getfield k : Z
    //   70: ifeq -> 83
    //   73: aload_0
    //   74: invokevirtual b : ()Z
    //   77: pop
    //   78: iconst_1
    //   79: istore_2
    //   80: goto -> 85
    //   83: iconst_0
    //   84: istore_2
    //   85: aload_0
    //   86: iconst_0
    //   87: invokespecial setCloseIconPressed : (Z)V
    //   90: goto -> 110
    //   93: iload #4
    //   95: ifeq -> 108
    //   98: aload_0
    //   99: iconst_1
    //   100: invokespecial setCloseIconPressed : (Z)V
    //   103: iconst_1
    //   104: istore_2
    //   105: goto -> 110
    //   108: iconst_0
    //   109: istore_2
    //   110: iload_2
    //   111: ifne -> 122
    //   114: aload_0
    //   115: aload_1
    //   116: invokespecial onTouchEvent : (Landroid/view/MotionEvent;)Z
    //   119: ifeq -> 124
    //   122: iconst_1
    //   123: istore_3
    //   124: iload_3
    //   125: ireturn
  }
  
  public void setBackground(Drawable paramDrawable) {
    if (paramDrawable != getBackgroundDrawable() && paramDrawable != this.g) {
      Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
      return;
    } 
    super.setBackground(paramDrawable);
  }
  
  public void setBackgroundColor(int paramInt) {
    Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {
    if (paramDrawable != getBackgroundDrawable() && paramDrawable != this.g) {
      Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
      return;
    } 
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundResource(int paramInt) {
    Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
  }
  
  public void setBackgroundTintList(ColorStateList paramColorStateList) {
    Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode) {
    Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
  }
  
  public void setCheckable(boolean paramBoolean) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.d(paramBoolean); 
  }
  
  public void setCheckableResource(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.o(paramInt); 
  }
  
  public void setChecked(boolean paramBoolean) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable == null) {
      this.j = paramBoolean;
      return;
    } 
    if (chipDrawable.y()) {
      boolean bool = isChecked();
      super.setChecked(paramBoolean);
      if (bool != paramBoolean) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.i;
        if (onCheckedChangeListener != null)
          onCheckedChangeListener.onCheckedChanged((CompoundButton)this, paramBoolean); 
      } 
    } 
  }
  
  public void setCheckedIcon(Drawable paramDrawable) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.c(paramDrawable); 
  }
  
  @Deprecated
  public void setCheckedIconEnabled(boolean paramBoolean) {
    setCheckedIconVisible(paramBoolean);
  }
  
  @Deprecated
  public void setCheckedIconEnabledResource(int paramInt) {
    setCheckedIconVisible(paramInt);
  }
  
  public void setCheckedIconResource(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.q(paramInt); 
  }
  
  public void setCheckedIconTint(ColorStateList paramColorStateList) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.f(paramColorStateList); 
  }
  
  public void setCheckedIconTintResource(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.r(paramInt); 
  }
  
  public void setCheckedIconVisible(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.p(paramInt); 
  }
  
  public void setCheckedIconVisible(boolean paramBoolean) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.e(paramBoolean); 
  }
  
  public void setChipBackgroundColor(ColorStateList paramColorStateList) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.a(paramColorStateList); 
  }
  
  public void setChipBackgroundColorResource(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.a(paramInt); 
  }
  
  @Deprecated
  public void setChipCornerRadius(float paramFloat) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.b(paramFloat); 
  }
  
  @Deprecated
  public void setChipCornerRadiusResource(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.c(paramInt); 
  }
  
  public void setChipDrawable(ChipDrawable paramChipDrawable) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != paramChipDrawable) {
      a(chipDrawable);
      this.e = paramChipDrawable;
      this.e.f(false);
      b(this.e);
      a(this.p);
    } 
  }
  
  public void setChipEndPadding(float paramFloat) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.m(paramFloat); 
  }
  
  public void setChipEndPaddingResource(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.B(paramInt); 
  }
  
  public void setChipIcon(Drawable paramDrawable) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.a(paramDrawable); 
  }
  
  @Deprecated
  public void setChipIconEnabled(boolean paramBoolean) {
    setChipIconVisible(paramBoolean);
  }
  
  @Deprecated
  public void setChipIconEnabledResource(int paramInt) {
    setChipIconVisible(paramInt);
  }
  
  public void setChipIconResource(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.i(paramInt); 
  }
  
  public void setChipIconSize(float paramFloat) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.d(paramFloat); 
  }
  
  public void setChipIconSizeResource(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.k(paramInt); 
  }
  
  public void setChipIconTint(ColorStateList paramColorStateList) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.d(paramColorStateList); 
  }
  
  public void setChipIconTintResource(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.j(paramInt); 
  }
  
  public void setChipIconVisible(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.h(paramInt); 
  }
  
  public void setChipIconVisible(boolean paramBoolean) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.b(paramBoolean); 
  }
  
  public void setChipMinHeight(float paramFloat) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.a(paramFloat); 
  }
  
  public void setChipMinHeightResource(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.b(paramInt); 
  }
  
  public void setChipStartPadding(float paramFloat) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.f(paramFloat); 
  }
  
  public void setChipStartPaddingResource(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.u(paramInt); 
  }
  
  public void setChipStrokeColor(ColorStateList paramColorStateList) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.b(paramColorStateList); 
  }
  
  public void setChipStrokeColorResource(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.d(paramInt); 
  }
  
  public void setChipStrokeWidth(float paramFloat) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.c(paramFloat); 
  }
  
  public void setChipStrokeWidthResource(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.e(paramInt); 
  }
  
  @Deprecated
  public void setChipText(CharSequence paramCharSequence) {
    setText(paramCharSequence);
  }
  
  @Deprecated
  public void setChipTextResource(int paramInt) {
    setText(getResources().getString(paramInt));
  }
  
  public void setCloseIcon(Drawable paramDrawable) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.b(paramDrawable); 
    g();
  }
  
  public void setCloseIconContentDescription(CharSequence paramCharSequence) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.b(paramCharSequence); 
  }
  
  @Deprecated
  public void setCloseIconEnabled(boolean paramBoolean) {
    setCloseIconVisible(paramBoolean);
  }
  
  @Deprecated
  public void setCloseIconEnabledResource(int paramInt) {
    setCloseIconVisible(paramInt);
  }
  
  public void setCloseIconEndPadding(float paramFloat) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.l(paramFloat); 
  }
  
  public void setCloseIconEndPaddingResource(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.A(paramInt); 
  }
  
  public void setCloseIconResource(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.l(paramInt); 
    g();
  }
  
  public void setCloseIconSize(float paramFloat) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.e(paramFloat); 
  }
  
  public void setCloseIconSizeResource(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.n(paramInt); 
  }
  
  public void setCloseIconStartPadding(float paramFloat) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.k(paramFloat); 
  }
  
  public void setCloseIconStartPaddingResource(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.z(paramInt); 
  }
  
  public void setCloseIconTint(ColorStateList paramColorStateList) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.e(paramColorStateList); 
  }
  
  public void setCloseIconTintResource(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.m(paramInt); 
  }
  
  public void setCloseIconVisible(int paramInt) {
    setCloseIconVisible(getResources().getBoolean(paramInt));
  }
  
  public void setCloseIconVisible(boolean paramBoolean) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.c(paramBoolean); 
    g();
  }
  
  public void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4) {
    if (paramDrawable1 == null) {
      if (paramDrawable3 == null) {
        super.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
        return;
      } 
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    } 
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesRelative(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4) {
    if (paramDrawable1 == null) {
      if (paramDrawable3 == null) {
        super.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
        return;
      } 
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    } 
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (paramInt1 == 0) {
      if (paramInt3 == 0) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      } 
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    } 
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4) {
    if (paramDrawable1 == null) {
      if (paramDrawable3 == null) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
        return;
      } 
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    } 
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (paramInt1 == 0) {
      if (paramInt3 == 0) {
        super.setCompoundDrawablesWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      } 
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    } 
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4) {
    if (paramDrawable1 == null) {
      if (paramDrawable3 == null) {
        super.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
        return;
      } 
      throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    } 
    throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
  }
  
  public void setElevation(float paramFloat) {
    super.setElevation(paramFloat);
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.r(paramFloat); 
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt) {
    if (this.e == null)
      return; 
    if (paramTruncateAt != TextUtils.TruncateAt.MARQUEE) {
      super.setEllipsize(paramTruncateAt);
      ChipDrawable chipDrawable = this.e;
      if (chipDrawable != null)
        chipDrawable.a(paramTruncateAt); 
      return;
    } 
    throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
  }
  
  public void setEnsureMinTouchTargetSize(boolean paramBoolean) {
    this.n = paramBoolean;
    a(this.p);
  }
  
  public void setGravity(int paramInt) {
    if (paramInt != 8388627) {
      Log.w("Chip", "Chip text must be vertically center and start aligned");
      return;
    } 
    super.setGravity(paramInt);
  }
  
  public void setHideMotionSpec(MotionSpec paramMotionSpec) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.b(paramMotionSpec); 
  }
  
  public void setHideMotionSpecResource(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.t(paramInt); 
  }
  
  public void setIconEndPadding(float paramFloat) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.h(paramFloat); 
  }
  
  public void setIconEndPaddingResource(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.w(paramInt); 
  }
  
  public void setIconStartPadding(float paramFloat) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.g(paramFloat); 
  }
  
  public void setIconStartPaddingResource(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.v(paramInt); 
  }
  
  public void setLayoutDirection(int paramInt) {
    if (this.e == null)
      return; 
    if (Build.VERSION.SDK_INT >= 17)
      super.setLayoutDirection(paramInt); 
  }
  
  public void setLines(int paramInt) {
    if (paramInt <= 1) {
      super.setLines(paramInt);
      return;
    } 
    throw new UnsupportedOperationException("Chip does not support multi-line text");
  }
  
  public void setMaxLines(int paramInt) {
    if (paramInt <= 1) {
      super.setMaxLines(paramInt);
      return;
    } 
    throw new UnsupportedOperationException("Chip does not support multi-line text");
  }
  
  public void setMaxWidth(int paramInt) {
    super.setMaxWidth(paramInt);
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.C(paramInt); 
  }
  
  public void setMinLines(int paramInt) {
    if (paramInt <= 1) {
      super.setMinLines(paramInt);
      return;
    } 
    throw new UnsupportedOperationException("Chip does not support multi-line text");
  }
  
  void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener) {
    this.i = paramOnCheckedChangeListener;
  }
  
  public void setOnCloseIconClickListener(View.OnClickListener paramOnClickListener) {
    this.h = paramOnClickListener;
    g();
  }
  
  public void setRippleColor(ColorStateList paramColorStateList) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.c(paramColorStateList); 
    if (!this.e.a())
      l(); 
  }
  
  public void setRippleColorResource(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null) {
      chipDrawable.f(paramInt);
      if (!this.e.a())
        l(); 
    } 
  }
  
  public void setShapeAppearanceModel(ShapeAppearanceModel paramShapeAppearanceModel) {
    this.e.setShapeAppearanceModel(paramShapeAppearanceModel);
  }
  
  public void setShowMotionSpec(MotionSpec paramMotionSpec) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.a(paramMotionSpec); 
  }
  
  public void setShowMotionSpecResource(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.s(paramInt); 
  }
  
  public void setSingleLine(boolean paramBoolean) {
    if (paramBoolean) {
      super.setSingleLine(paramBoolean);
      return;
    } 
    throw new UnsupportedOperationException("Chip does not support multi-line text");
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType) {
    if (this.e == null)
      return; 
    CharSequence charSequence = paramCharSequence;
    if (paramCharSequence == null)
      charSequence = ""; 
    if (this.e.L()) {
      paramCharSequence = null;
    } else {
      paramCharSequence = charSequence;
    } 
    super.setText(paramCharSequence, paramBufferType);
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.a(charSequence); 
  }
  
  public void setTextAppearance(int paramInt) {
    super.setTextAppearance(paramInt);
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.g(paramInt); 
    o();
  }
  
  public void setTextAppearance(Context paramContext, int paramInt) {
    super.setTextAppearance(paramContext, paramInt);
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.g(paramInt); 
    o();
  }
  
  public void setTextAppearance(TextAppearance paramTextAppearance) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.a(paramTextAppearance); 
    o();
  }
  
  public void setTextAppearanceResource(int paramInt) {
    setTextAppearance(getContext(), paramInt);
  }
  
  public void setTextEndPadding(float paramFloat) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.j(paramFloat); 
  }
  
  public void setTextEndPaddingResource(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.y(paramInt); 
  }
  
  public void setTextStartPadding(float paramFloat) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.i(paramFloat); 
  }
  
  public void setTextStartPaddingResource(int paramInt) {
    ChipDrawable chipDrawable = this.e;
    if (chipDrawable != null)
      chipDrawable.x(paramInt); 
  }
  
  class ChipTouchHelper extends ExploreByTouchHelper {
    ChipTouchHelper(Chip this$0, Chip param1Chip1) {
      super((View)param1Chip1);
    }
    
    public int a(float param1Float1, float param1Float2) {
      return (Chip.b(this.c) && Chip.c(this.c).contains(param1Float1, param1Float2)) ? 1 : 0;
    }
    
    public void a(int param1Int, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
      if (param1Int == 1) {
        CharSequence charSequence = this.c.getCloseIconContentDescription();
        if (charSequence != null) {
          param1AccessibilityNodeInfoCompat.setContentDescription(charSequence);
        } else {
          charSequence = this.c.getText();
          Context context = this.c.getContext();
          param1Int = R.string.mtrl_chip_close_icon_content_description;
          if (TextUtils.isEmpty(charSequence))
            charSequence = ""; 
          param1AccessibilityNodeInfoCompat.setContentDescription(context.getString(param1Int, new Object[] { charSequence }).trim());
        } 
        param1AccessibilityNodeInfoCompat.setBoundsInParent(Chip.e(this.c));
        param1AccessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        param1AccessibilityNodeInfoCompat.setEnabled(this.c.isEnabled());
        return;
      } 
      param1AccessibilityNodeInfoCompat.setContentDescription("");
      param1AccessibilityNodeInfoCompat.setBoundsInParent(Chip.f());
    }
    
    public void a(int param1Int, boolean param1Boolean) {
      if (param1Int == 1) {
        Chip.a(this.c, param1Boolean);
        this.c.refreshDrawableState();
      } 
    }
    
    public void a(AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
      param1AccessibilityNodeInfoCompat.setCheckable(this.c.d());
      param1AccessibilityNodeInfoCompat.setClickable(this.c.isClickable());
      if (this.c.d() || this.c.isClickable()) {
        String str;
        if (this.c.d()) {
          str = "android.widget.CompoundButton";
        } else {
          str = "android.widget.Button";
        } 
        param1AccessibilityNodeInfoCompat.setClassName(str);
      } else {
        param1AccessibilityNodeInfoCompat.setClassName("android.view.View");
      } 
      CharSequence charSequence = this.c.getText();
      if (Build.VERSION.SDK_INT >= 23) {
        param1AccessibilityNodeInfoCompat.setText(charSequence);
        return;
      } 
      param1AccessibilityNodeInfoCompat.setContentDescription(charSequence);
    }
    
    public void a(List<Integer> param1List) {
      param1List.add(Integer.valueOf(0));
      if (Chip.b(this.c) && this.c.c() && Chip.d(this.c) != null)
        param1List.add(Integer.valueOf(1)); 
    }
    
    public boolean b(int param1Int1, int param1Int2, Bundle param1Bundle) {
      if (param1Int2 == 16) {
        if (param1Int1 == 0)
          return this.c.performClick(); 
        if (param1Int1 == 1)
          return this.c.b(); 
      } 
      return false;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\chip\Chip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */