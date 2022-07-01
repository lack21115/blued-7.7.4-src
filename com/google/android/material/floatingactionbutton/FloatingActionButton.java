package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableImageSourceView;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.expandable.ExpandableTransformationWidget;
import com.google.android.material.expandable.ExpandableWidget;
import com.google.android.material.expandable.ExpandableWidgetHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.stateful.ExtendableSavedState;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class FloatingActionButton extends VisibilityAwareImageButton implements CoordinatorLayout.AttachedBehavior, TintableBackgroundView, TintableImageSourceView, ExpandableTransformationWidget, Shapeable {
  private static final int c = R.style.Widget_Design_FloatingActionButton;
  
  boolean a;
  
  final Rect b = new Rect();
  
  private ColorStateList d;
  
  private PorterDuff.Mode e;
  
  private ColorStateList f;
  
  private PorterDuff.Mode g;
  
  private ColorStateList h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private final Rect n = new Rect();
  
  private final AppCompatImageHelper o;
  
  private final ExpandableWidgetHelper p;
  
  private FloatingActionButtonImpl q;
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.floatingActionButtonStyle);
  }
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, c), paramAttributeSet, paramInt);
    Context context = getContext();
    TypedArray typedArray = ThemeEnforcement.a(context, paramAttributeSet, R.styleable.FloatingActionButton, paramInt, c, new int[0]);
    this.d = MaterialResources.a(context, typedArray, R.styleable.FloatingActionButton_backgroundTint);
    this.e = ViewUtils.a(typedArray.getInt(R.styleable.FloatingActionButton_backgroundTintMode, -1), null);
    this.h = MaterialResources.a(context, typedArray, R.styleable.FloatingActionButton_rippleColor);
    this.j = typedArray.getInt(R.styleable.FloatingActionButton_fabSize, -1);
    this.k = typedArray.getDimensionPixelSize(R.styleable.FloatingActionButton_fabCustomSize, 0);
    this.i = typedArray.getDimensionPixelSize(R.styleable.FloatingActionButton_borderWidth, 0);
    float f1 = typedArray.getDimension(R.styleable.FloatingActionButton_elevation, 0.0F);
    float f2 = typedArray.getDimension(R.styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0.0F);
    float f3 = typedArray.getDimension(R.styleable.FloatingActionButton_pressedTranslationZ, 0.0F);
    this.a = typedArray.getBoolean(R.styleable.FloatingActionButton_useCompatPadding, false);
    int i = getResources().getDimensionPixelSize(R.dimen.mtrl_fab_min_touch_target);
    this.m = typedArray.getDimensionPixelSize(R.styleable.FloatingActionButton_maxImageSize, 0);
    MotionSpec motionSpec1 = MotionSpec.a(context, typedArray, R.styleable.FloatingActionButton_showMotionSpec);
    MotionSpec motionSpec2 = MotionSpec.a(context, typedArray, R.styleable.FloatingActionButton_hideMotionSpec);
    ShapeAppearanceModel shapeAppearanceModel = ShapeAppearanceModel.a(context, paramAttributeSet, paramInt, c, ShapeAppearanceModel.a).a();
    boolean bool = typedArray.getBoolean(R.styleable.FloatingActionButton_ensureMinTouchTargetSize, false);
    setEnabled(typedArray.getBoolean(R.styleable.FloatingActionButton_android_enabled, true));
    typedArray.recycle();
    this.o = new AppCompatImageHelper((ImageView)this);
    this.o.loadFromAttributes(paramAttributeSet, paramInt);
    this.p = new ExpandableWidgetHelper((ExpandableWidget)this);
    getImpl().a(shapeAppearanceModel);
    getImpl().a(this.d, this.e, this.h, this.i);
    getImpl().a(i);
    getImpl().a(f1);
    getImpl().b(f2);
    getImpl().c(f3);
    getImpl().b(this.m);
    getImpl().a(motionSpec1);
    getImpl().b(motionSpec2);
    getImpl().a(bool);
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  private int a(int paramInt) {
    int i = this.k;
    if (i != 0)
      return i; 
    Resources resources = getResources();
    return (paramInt != -1) ? ((paramInt != 1) ? resources.getDimensionPixelSize(R.dimen.design_fab_size_normal) : resources.getDimensionPixelSize(R.dimen.design_fab_size_mini)) : ((Math.max((resources.getConfiguration()).screenWidthDp, (resources.getConfiguration()).screenHeightDp) < 470) ? a(1) : a(0));
  }
  
  private static int a(int paramInt1, int paramInt2) {
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (i != Integer.MIN_VALUE) {
      if (i != 0) {
        if (i == 1073741824)
          return paramInt2; 
        throw new IllegalArgumentException();
      } 
    } else {
      paramInt1 = Math.min(paramInt1, paramInt2);
    } 
    return paramInt1;
  }
  
  private FloatingActionButtonImpl.InternalVisibilityChangedListener c(OnVisibilityChangedListener paramOnVisibilityChangedListener) {
    return (paramOnVisibilityChangedListener == null) ? null : new FloatingActionButtonImpl.InternalVisibilityChangedListener(this, paramOnVisibilityChangedListener) {
        public void a() {
          this.a.b(this.b);
        }
        
        public void b() {
          this.a.a(this.b);
        }
      };
  }
  
  private void c(Rect paramRect) {
    paramRect.left += this.b.left;
    paramRect.top += this.b.top;
    paramRect.right -= this.b.right;
    paramRect.bottom -= this.b.bottom;
  }
  
  private void d() {
    Drawable drawable = getDrawable();
    if (drawable == null)
      return; 
    ColorStateList colorStateList = this.f;
    if (colorStateList == null) {
      DrawableCompat.clearColorFilter(drawable);
      return;
    } 
    int i = colorStateList.getColorForState(getDrawableState(), 0);
    PorterDuff.Mode mode2 = this.g;
    PorterDuff.Mode mode1 = mode2;
    if (mode2 == null)
      mode1 = PorterDuff.Mode.SRC_IN; 
    drawable.mutate().setColorFilter((ColorFilter)AppCompatDrawableManager.getPorterDuffColorFilter(i, mode1));
  }
  
  private FloatingActionButtonImpl e() {
    return (Build.VERSION.SDK_INT >= 21) ? new FloatingActionButtonImplLollipop(this, new ShadowDelegateImpl(this)) : new FloatingActionButtonImpl(this, new ShadowDelegateImpl(this));
  }
  
  private FloatingActionButtonImpl getImpl() {
    if (this.q == null)
      this.q = e(); 
    return this.q;
  }
  
  public void a(Animator.AnimatorListener paramAnimatorListener) {
    getImpl().a(paramAnimatorListener);
  }
  
  public void a(TransformationCallback<? extends FloatingActionButton> paramTransformationCallback) {
    getImpl().a(new TransformationCallbackWrapper<FloatingActionButton>(this, paramTransformationCallback));
  }
  
  public void a(OnVisibilityChangedListener paramOnVisibilityChangedListener) {
    a(paramOnVisibilityChangedListener, true);
  }
  
  void a(OnVisibilityChangedListener paramOnVisibilityChangedListener, boolean paramBoolean) {
    getImpl().b(c(paramOnVisibilityChangedListener), paramBoolean);
  }
  
  public boolean a() {
    return this.p.a();
  }
  
  @Deprecated
  public boolean a(Rect paramRect) {
    if (ViewCompat.isLaidOut((View)this)) {
      paramRect.set(0, 0, getWidth(), getHeight());
      c(paramRect);
      return true;
    } 
    return false;
  }
  
  public void b(Animator.AnimatorListener paramAnimatorListener) {
    getImpl().b(paramAnimatorListener);
  }
  
  public void b(Rect paramRect) {
    paramRect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
    c(paramRect);
  }
  
  public void b(OnVisibilityChangedListener paramOnVisibilityChangedListener) {
    b(paramOnVisibilityChangedListener, true);
  }
  
  void b(OnVisibilityChangedListener paramOnVisibilityChangedListener, boolean paramBoolean) {
    getImpl().a(c(paramOnVisibilityChangedListener), paramBoolean);
  }
  
  public boolean b() {
    return getImpl().w();
  }
  
  public boolean c() {
    return getImpl().v();
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    getImpl().a(getDrawableState());
  }
  
  public ColorStateList getBackgroundTintList() {
    return this.d;
  }
  
  public PorterDuff.Mode getBackgroundTintMode() {
    return this.e;
  }
  
  public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
    return new Behavior();
  }
  
  public float getCompatElevation() {
    return getImpl().a();
  }
  
  public float getCompatHoveredFocusedTranslationZ() {
    return getImpl().b();
  }
  
  public float getCompatPressedTranslationZ() {
    return getImpl().c();
  }
  
  public Drawable getContentBackground() {
    return getImpl().m();
  }
  
  public int getCustomSize() {
    return this.k;
  }
  
  public int getExpandedComponentIdHint() {
    return this.p.c();
  }
  
  public MotionSpec getHideMotionSpec() {
    return getImpl().g();
  }
  
  @Deprecated
  public int getRippleColor() {
    ColorStateList colorStateList = this.h;
    return (colorStateList != null) ? colorStateList.getDefaultColor() : 0;
  }
  
  public ColorStateList getRippleColorStateList() {
    return this.h;
  }
  
  public ShapeAppearanceModel getShapeAppearanceModel() {
    return (ShapeAppearanceModel)Preconditions.checkNotNull(getImpl().e());
  }
  
  public MotionSpec getShowMotionSpec() {
    return getImpl().f();
  }
  
  public int getSize() {
    return this.j;
  }
  
  int getSizeDimension() {
    return a(this.j);
  }
  
  public ColorStateList getSupportBackgroundTintList() {
    return getBackgroundTintList();
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode() {
    return getBackgroundTintMode();
  }
  
  public ColorStateList getSupportImageTintList() {
    return this.f;
  }
  
  public PorterDuff.Mode getSupportImageTintMode() {
    return this.g;
  }
  
  public boolean getUseCompatPadding() {
    return this.a;
  }
  
  public void jumpDrawablesToCurrentState() {
    super.jumpDrawablesToCurrentState();
    getImpl().j();
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    getImpl().q();
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    getImpl().r();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int i = getSizeDimension();
    this.l = (i - this.m) / 2;
    getImpl().o();
    paramInt1 = Math.min(a(i, paramInt1), a(i, paramInt2));
    setMeasuredDimension(this.b.left + paramInt1 + this.b.right, paramInt1 + this.b.top + this.b.bottom);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof ExtendableSavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    ExtendableSavedState extendableSavedState = (ExtendableSavedState)paramParcelable;
    super.onRestoreInstanceState(extendableSavedState.getSuperState());
    this.p.a((Bundle)Preconditions.checkNotNull(extendableSavedState.a.get("expandableWidgetHelper")));
  }
  
  protected Parcelable onSaveInstanceState() {
    Bundle bundle;
    Parcelable parcelable2 = super.onSaveInstanceState();
    Parcelable parcelable1 = parcelable2;
    if (parcelable2 == null)
      bundle = new Bundle(); 
    ExtendableSavedState extendableSavedState = new ExtendableSavedState((Parcelable)bundle);
    extendableSavedState.a.put("expandableWidgetHelper", this.p.b());
    return (Parcelable)extendableSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    return (paramMotionEvent.getAction() == 0 && a(this.n) && !this.n.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) ? false : super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBackgroundColor(int paramInt) {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundResource(int paramInt) {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundTintList(ColorStateList paramColorStateList) {
    if (this.d != paramColorStateList) {
      this.d = paramColorStateList;
      getImpl().a(paramColorStateList);
    } 
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode) {
    if (this.e != paramMode) {
      this.e = paramMode;
      getImpl().a(paramMode);
    } 
  }
  
  public void setCompatElevation(float paramFloat) {
    getImpl().a(paramFloat);
  }
  
  public void setCompatElevationResource(int paramInt) {
    setCompatElevation(getResources().getDimension(paramInt));
  }
  
  public void setCompatHoveredFocusedTranslationZ(float paramFloat) {
    getImpl().b(paramFloat);
  }
  
  public void setCompatHoveredFocusedTranslationZResource(int paramInt) {
    setCompatHoveredFocusedTranslationZ(getResources().getDimension(paramInt));
  }
  
  public void setCompatPressedTranslationZ(float paramFloat) {
    getImpl().c(paramFloat);
  }
  
  public void setCompatPressedTranslationZResource(int paramInt) {
    setCompatPressedTranslationZ(getResources().getDimension(paramInt));
  }
  
  public void setCustomSize(int paramInt) {
    if (paramInt >= 0) {
      if (paramInt != this.k) {
        this.k = paramInt;
        requestLayout();
      } 
      return;
    } 
    throw new IllegalArgumentException("Custom size must be non-negative");
  }
  
  public void setElevation(float paramFloat) {
    super.setElevation(paramFloat);
    getImpl().e(paramFloat);
  }
  
  public void setEnsureMinTouchTargetSize(boolean paramBoolean) {
    if (paramBoolean != getImpl().i()) {
      getImpl().a(paramBoolean);
      requestLayout();
    } 
  }
  
  public void setExpandedComponentIdHint(int paramInt) {
    this.p.a(paramInt);
  }
  
  public void setHideMotionSpec(MotionSpec paramMotionSpec) {
    getImpl().b(paramMotionSpec);
  }
  
  public void setHideMotionSpecResource(int paramInt) {
    setHideMotionSpec(MotionSpec.a(getContext(), paramInt));
  }
  
  public void setImageDrawable(Drawable paramDrawable) {
    if (getDrawable() != paramDrawable) {
      super.setImageDrawable(paramDrawable);
      getImpl().d();
      if (this.f != null)
        d(); 
    } 
  }
  
  public void setImageResource(int paramInt) {
    this.o.setImageResource(paramInt);
    d();
  }
  
  public void setRippleColor(int paramInt) {
    setRippleColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setRippleColor(ColorStateList paramColorStateList) {
    if (this.h != paramColorStateList) {
      this.h = paramColorStateList;
      getImpl().b(this.h);
    } 
  }
  
  public void setScaleX(float paramFloat) {
    super.setScaleX(paramFloat);
    getImpl().l();
  }
  
  public void setScaleY(float paramFloat) {
    super.setScaleY(paramFloat);
    getImpl().l();
  }
  
  public void setShadowPaddingEnabled(boolean paramBoolean) {
    getImpl().b(paramBoolean);
  }
  
  public void setShapeAppearanceModel(ShapeAppearanceModel paramShapeAppearanceModel) {
    getImpl().a(paramShapeAppearanceModel);
  }
  
  public void setShowMotionSpec(MotionSpec paramMotionSpec) {
    getImpl().a(paramMotionSpec);
  }
  
  public void setShowMotionSpecResource(int paramInt) {
    setShowMotionSpec(MotionSpec.a(getContext(), paramInt));
  }
  
  public void setSize(int paramInt) {
    this.k = 0;
    if (paramInt != this.j) {
      this.j = paramInt;
      requestLayout();
    } 
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList) {
    setBackgroundTintList(paramColorStateList);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode) {
    setBackgroundTintMode(paramMode);
  }
  
  public void setSupportImageTintList(ColorStateList paramColorStateList) {
    if (this.f != paramColorStateList) {
      this.f = paramColorStateList;
      d();
    } 
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode) {
    if (this.g != paramMode) {
      this.g = paramMode;
      d();
    } 
  }
  
  public void setTranslationX(float paramFloat) {
    super.setTranslationX(paramFloat);
    getImpl().k();
  }
  
  public void setTranslationY(float paramFloat) {
    super.setTranslationY(paramFloat);
    getImpl().k();
  }
  
  public void setTranslationZ(float paramFloat) {
    super.setTranslationZ(paramFloat);
    getImpl().k();
  }
  
  public void setUseCompatPadding(boolean paramBoolean) {
    if (this.a != paramBoolean) {
      this.a = paramBoolean;
      getImpl().n();
    } 
  }
  
  public void setVisibility(int paramInt) {
    super.setVisibility(paramInt);
  }
  
  public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {
    private Rect a;
    
    private FloatingActionButton.OnVisibilityChangedListener b;
    
    private boolean c;
    
    public BaseBehavior() {
      this.c = true;
    }
    
    public BaseBehavior(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
      this.c = typedArray.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
      typedArray.recycle();
    }
    
    private void a(CoordinatorLayout param1CoordinatorLayout, FloatingActionButton param1FloatingActionButton) {
      Rect rect = param1FloatingActionButton.b;
      if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams)param1FloatingActionButton.getLayoutParams();
        int i = param1FloatingActionButton.getRight();
        int k = param1CoordinatorLayout.getWidth();
        int m = layoutParams.rightMargin;
        int j = 0;
        if (i >= k - m) {
          i = rect.right;
        } else if (param1FloatingActionButton.getLeft() <= layoutParams.leftMargin) {
          i = -rect.left;
        } else {
          i = 0;
        } 
        if (param1FloatingActionButton.getBottom() >= param1CoordinatorLayout.getHeight() - layoutParams.bottomMargin) {
          j = rect.bottom;
        } else if (param1FloatingActionButton.getTop() <= layoutParams.topMargin) {
          j = -rect.top;
        } 
        if (j != 0)
          ViewCompat.offsetTopAndBottom((View)param1FloatingActionButton, j); 
        if (i != 0)
          ViewCompat.offsetLeftAndRight((View)param1FloatingActionButton, i); 
      } 
    }
    
    private static boolean a(View param1View) {
      ViewGroup.LayoutParams layoutParams = param1View.getLayoutParams();
      return (layoutParams instanceof CoordinatorLayout.LayoutParams) ? (((CoordinatorLayout.LayoutParams)layoutParams).getBehavior() instanceof com.google.android.material.bottomsheet.BottomSheetBehavior) : false;
    }
    
    private boolean a(View param1View, FloatingActionButton param1FloatingActionButton) {
      CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams)param1FloatingActionButton.getLayoutParams();
      return !this.c ? false : ((layoutParams.getAnchorId() != param1View.getId()) ? false : (!(param1FloatingActionButton.getUserSetVisibility() != 0)));
    }
    
    private boolean a(CoordinatorLayout param1CoordinatorLayout, AppBarLayout param1AppBarLayout, FloatingActionButton param1FloatingActionButton) {
      if (!a((View)param1AppBarLayout, param1FloatingActionButton))
        return false; 
      if (this.a == null)
        this.a = new Rect(); 
      Rect rect = this.a;
      DescendantOffsetUtils.b((ViewGroup)param1CoordinatorLayout, (View)param1AppBarLayout, rect);
      if (rect.bottom <= param1AppBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
        param1FloatingActionButton.b(this.b, false);
      } else {
        param1FloatingActionButton.a(this.b, false);
      } 
      return true;
    }
    
    private boolean b(View param1View, FloatingActionButton param1FloatingActionButton) {
      if (!a(param1View, param1FloatingActionButton))
        return false; 
      CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams)param1FloatingActionButton.getLayoutParams();
      if (param1View.getTop() < param1FloatingActionButton.getHeight() / 2 + layoutParams.topMargin) {
        param1FloatingActionButton.b(this.b, false);
      } else {
        param1FloatingActionButton.a(this.b, false);
      } 
      return true;
    }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, FloatingActionButton param1FloatingActionButton, int param1Int) {
      List<View> list = param1CoordinatorLayout.getDependencies((View)param1FloatingActionButton);
      int j = list.size();
      int i;
      for (i = 0; i < j; i++) {
        View view = list.get(i);
        if ((view instanceof AppBarLayout) ? a(param1CoordinatorLayout, (AppBarLayout)view, param1FloatingActionButton) : (a(view) && b(view, param1FloatingActionButton)))
          break; 
      } 
      param1CoordinatorLayout.onLayoutChild((View)param1FloatingActionButton, param1Int);
      a(param1CoordinatorLayout, param1FloatingActionButton);
      return true;
    }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, FloatingActionButton param1FloatingActionButton, Rect param1Rect) {
      Rect rect = param1FloatingActionButton.b;
      param1Rect.set(param1FloatingActionButton.getLeft() + rect.left, param1FloatingActionButton.getTop() + rect.top, param1FloatingActionButton.getRight() - rect.right, param1FloatingActionButton.getBottom() - rect.bottom);
      return true;
    }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, FloatingActionButton param1FloatingActionButton, View param1View) {
      if (param1View instanceof AppBarLayout) {
        a(param1CoordinatorLayout, (AppBarLayout)param1View, param1FloatingActionButton);
      } else if (a(param1View)) {
        b(param1View, param1FloatingActionButton);
      } 
      return false;
    }
    
    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams param1LayoutParams) {
      if (param1LayoutParams.dodgeInsetEdges == 0)
        param1LayoutParams.dodgeInsetEdges = 80; 
    }
  }
  
  public static class Behavior extends BaseBehavior<FloatingActionButton> {
    public Behavior() {}
    
    public Behavior(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
    }
  }
  
  public static abstract class OnVisibilityChangedListener {
    public void a(FloatingActionButton param1FloatingActionButton) {}
    
    public void b(FloatingActionButton param1FloatingActionButton) {}
  }
  
  class ShadowDelegateImpl implements ShadowViewDelegate {
    ShadowDelegateImpl(FloatingActionButton this$0) {}
    
    public void a(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      this.a.b.set(param1Int1, param1Int2, param1Int3, param1Int4);
      FloatingActionButton floatingActionButton = this.a;
      floatingActionButton.setPadding(param1Int1 + FloatingActionButton.a(floatingActionButton), param1Int2 + FloatingActionButton.a(this.a), param1Int3 + FloatingActionButton.a(this.a), param1Int4 + FloatingActionButton.a(this.a));
    }
    
    public void a(Drawable param1Drawable) {
      if (param1Drawable != null)
        FloatingActionButton.a(this.a, param1Drawable); 
    }
    
    public boolean a() {
      return this.a.a;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Size {}
  
  class TransformationCallbackWrapper<T extends FloatingActionButton> implements FloatingActionButtonImpl.InternalTransformationCallback {
    private final TransformationCallback<T> b;
    
    TransformationCallbackWrapper(FloatingActionButton this$0, TransformationCallback<T> param1TransformationCallback) {
      this.b = param1TransformationCallback;
    }
    
    public void a() {
      this.b.a((View)this.a);
    }
    
    public void b() {
      this.b.b((View)this.a);
    }
    
    public boolean equals(Object param1Object) {
      return (param1Object instanceof TransformationCallbackWrapper && ((TransformationCallbackWrapper)param1Object).b.equals(this.b));
    }
    
    public int hashCode() {
      return this.b.hashCode();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\floatingactionbutton\FloatingActionButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */