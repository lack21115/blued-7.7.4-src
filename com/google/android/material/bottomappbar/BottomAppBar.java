package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
  private static final int g = R.style.Widget_MaterialComponents_BottomAppBar;
  
  AnimatorListenerAdapter e = new AnimatorListenerAdapter(this) {
      public void onAnimationStart(Animator param1Animator) {
        BottomAppBar bottomAppBar = this.a;
        BottomAppBar.a(bottomAppBar, BottomAppBar.a(bottomAppBar), BottomAppBar.b(this.a));
      }
    };
  
  TransformationCallback<FloatingActionButton> f = new TransformationCallback<FloatingActionButton>(this) {
      public void a(FloatingActionButton param1FloatingActionButton) {
        float f;
        MaterialShapeDrawable materialShapeDrawable = BottomAppBar.c(this.a);
        if (param1FloatingActionButton.getVisibility() == 0) {
          f = param1FloatingActionButton.getScaleY();
        } else {
          f = 0.0F;
        } 
        materialShapeDrawable.p(f);
      }
      
      public void b(FloatingActionButton param1FloatingActionButton) {
        float f1 = param1FloatingActionButton.getTranslationX();
        if (BottomAppBar.d(this.a).b() != f1) {
          BottomAppBar.d(this.a).b(f1);
          BottomAppBar.c(this.a).invalidateSelf();
        } 
        float f2 = -param1FloatingActionButton.getTranslationY();
        f1 = 0.0F;
        f2 = Math.max(0.0F, f2);
        if (BottomAppBar.d(this.a).c() != f2) {
          BottomAppBar.d(this.a).c(f2);
          BottomAppBar.c(this.a).invalidateSelf();
        } 
        MaterialShapeDrawable materialShapeDrawable = BottomAppBar.c(this.a);
        if (param1FloatingActionButton.getVisibility() == 0)
          f1 = param1FloatingActionButton.getScaleY(); 
        materialShapeDrawable.p(f1);
      }
    };
  
  private final int h;
  
  private final MaterialShapeDrawable i = new MaterialShapeDrawable();
  
  private Animator j;
  
  private Animator k;
  
  private int l;
  
  private int m;
  
  private boolean n;
  
  private final boolean o;
  
  private final boolean p;
  
  private final boolean q;
  
  private int r = 0;
  
  private ArrayList<AnimationListener> s;
  
  private boolean t = true;
  
  private Behavior u;
  
  private int v;
  
  private int w;
  
  private int x;
  
  public BottomAppBar(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.bottomAppBarStyle);
  }
  
  public BottomAppBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, g), paramAttributeSet, paramInt);
    paramContext = getContext();
    TypedArray typedArray = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.BottomAppBar, paramInt, g, new int[0]);
    ColorStateList colorStateList = MaterialResources.a(paramContext, typedArray, R.styleable.BottomAppBar_backgroundTint);
    int i = typedArray.getDimensionPixelSize(R.styleable.BottomAppBar_elevation, 0);
    float f1 = typedArray.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleMargin, 0);
    float f2 = typedArray.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
    float f3 = typedArray.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleVerticalOffset, 0);
    this.l = typedArray.getInt(R.styleable.BottomAppBar_fabAlignmentMode, 0);
    this.m = typedArray.getInt(R.styleable.BottomAppBar_fabAnimationMode, 0);
    this.n = typedArray.getBoolean(R.styleable.BottomAppBar_hideOnScroll, false);
    this.o = typedArray.getBoolean(R.styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
    this.p = typedArray.getBoolean(R.styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
    this.q = typedArray.getBoolean(R.styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
    typedArray.recycle();
    this.h = getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fabOffsetEndMode);
    BottomAppBarTopEdgeTreatment bottomAppBarTopEdgeTreatment = new BottomAppBarTopEdgeTreatment(f1, f2, f3);
    ShapeAppearanceModel shapeAppearanceModel = ShapeAppearanceModel.a().a(bottomAppBarTopEdgeTreatment).a();
    this.i.setShapeAppearanceModel(shapeAppearanceModel);
    this.i.D(2);
    this.i.a(Paint.Style.FILL);
    this.i.a(paramContext);
    setElevation(i);
    DrawableCompat.setTintList((Drawable)this.i, colorStateList);
    ViewCompat.setBackground((View)this, (Drawable)this.i);
    ViewUtils.a((View)this, paramAttributeSet, paramInt, g, new ViewUtils.OnApplyWindowInsetsListener(this) {
          public WindowInsetsCompat a(View param1View, WindowInsetsCompat param1WindowInsetsCompat, ViewUtils.RelativePadding param1RelativePadding) {
            boolean bool2;
            if (BottomAppBar.e(this.a))
              BottomAppBar.a(this.a, param1WindowInsetsCompat.getSystemWindowInsetBottom()); 
            boolean bool = BottomAppBar.f(this.a);
            boolean bool4 = false;
            boolean bool3 = false;
            if (bool) {
              boolean bool5;
              if (BottomAppBar.g(this.a) != param1WindowInsetsCompat.getSystemWindowInsetLeft()) {
                bool5 = true;
              } else {
                bool5 = false;
              } 
              BottomAppBar.b(this.a, param1WindowInsetsCompat.getSystemWindowInsetLeft());
              bool2 = bool5;
            } else {
              bool2 = false;
            } 
            boolean bool1 = bool4;
            if (BottomAppBar.h(this.a)) {
              bool1 = bool3;
              if (BottomAppBar.i(this.a) != param1WindowInsetsCompat.getSystemWindowInsetRight())
                bool1 = true; 
              BottomAppBar.c(this.a, param1WindowInsetsCompat.getSystemWindowInsetRight());
            } 
            if (bool2 || bool1) {
              BottomAppBar.j(this.a);
              BottomAppBar.k(this.a);
              BottomAppBar.l(this.a);
            } 
            return param1WindowInsetsCompat;
          }
        });
  }
  
  private void a(int paramInt, boolean paramBoolean) {
    if (!ViewCompat.isLaidOut((View)this))
      return; 
    Animator animator = this.k;
    if (animator != null)
      animator.cancel(); 
    ArrayList<Animator> arrayList = new ArrayList();
    if (!i()) {
      paramInt = 0;
      paramBoolean = false;
    } 
    a(paramInt, paramBoolean, arrayList);
    AnimatorSet animatorSet = new AnimatorSet();
    animatorSet.playTogether(arrayList);
    this.k = (Animator)animatorSet;
    this.k.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
          public void onAnimationEnd(Animator param1Animator) {
            BottomAppBar.n(this.a);
            BottomAppBar.a(this.a, (Animator)null);
          }
          
          public void onAnimationStart(Animator param1Animator) {
            BottomAppBar.m(this.a);
          }
        });
    this.k.start();
  }
  
  private void a(int paramInt, boolean paramBoolean, List<Animator> paramList) {
    AnimatorSet animatorSet;
    ActionMenuView actionMenuView = getActionMenuView();
    if (actionMenuView == null)
      return; 
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(actionMenuView, "alpha", new float[] { 1.0F });
    if (Math.abs(actionMenuView.getTranslationX() - a(actionMenuView, paramInt, paramBoolean)) > 1.0F) {
      ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(actionMenuView, "alpha", new float[] { 0.0F });
      objectAnimator1.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, actionMenuView, paramInt, paramBoolean) {
            public boolean a;
            
            public void onAnimationCancel(Animator param1Animator) {
              this.a = true;
            }
            
            public void onAnimationEnd(Animator param1Animator) {
              if (!this.a)
                BottomAppBar.a(this.e, this.b, this.c, this.d); 
            }
          });
      animatorSet = new AnimatorSet();
      animatorSet.setDuration(150L);
      animatorSet.playSequentially(new Animator[] { (Animator)objectAnimator1, (Animator)objectAnimator });
      paramList.add(animatorSet);
      return;
    } 
    if (animatorSet.getAlpha() < 1.0F)
      paramList.add(objectAnimator); 
  }
  
  private void a(FloatingActionButton paramFloatingActionButton) {
    paramFloatingActionButton.b((Animator.AnimatorListener)this.e);
    paramFloatingActionButton.a((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
          public void onAnimationStart(Animator param1Animator) {
            this.a.e.onAnimationStart(param1Animator);
            FloatingActionButton floatingActionButton = BottomAppBar.o(this.a);
            if (floatingActionButton != null)
              floatingActionButton.setTranslationX(BottomAppBar.p(this.a)); 
          }
        });
    paramFloatingActionButton.a(this.f);
  }
  
  private void b(int paramInt) {
    if (this.l != paramInt) {
      if (!ViewCompat.isLaidOut((View)this))
        return; 
      Animator animator = this.j;
      if (animator != null)
        animator.cancel(); 
      ArrayList<Animator> arrayList = new ArrayList();
      if (this.m == 1) {
        b(paramInt, arrayList);
      } else {
        a(paramInt, arrayList);
      } 
      AnimatorSet animatorSet = new AnimatorSet();
      animatorSet.playTogether(arrayList);
      this.j = (Animator)animatorSet;
      this.j.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
            public void onAnimationEnd(Animator param1Animator) {
              BottomAppBar.n(this.a);
            }
            
            public void onAnimationStart(Animator param1Animator) {
              BottomAppBar.m(this.a);
            }
          });
      this.j.start();
    } 
  }
  
  private void b(int paramInt, List<Animator> paramList) {
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(g(), "translationX", new float[] { c(paramInt) });
    objectAnimator.setDuration(300L);
    paramList.add(objectAnimator);
  }
  
  private void b(ActionMenuView paramActionMenuView, int paramInt, boolean paramBoolean) {
    paramActionMenuView.setTranslationX(a(paramActionMenuView, paramInt, paramBoolean));
  }
  
  private float c(int paramInt) {
    boolean bool = ViewUtils.a((View)this);
    byte b = 1;
    if (paramInt == 1) {
      if (bool) {
        paramInt = this.x;
      } else {
        paramInt = this.w;
      } 
      int i = this.h;
      int j = getMeasuredWidth() / 2;
      if (bool)
        b = -1; 
      return ((j - i + paramInt) * b);
    } 
    return 0.0F;
  }
  
  private void e() {
    int i = this.r;
    this.r = i + 1;
    if (i == 0) {
      ArrayList<AnimationListener> arrayList = this.s;
      if (arrayList != null) {
        Iterator<AnimationListener> iterator = arrayList.iterator();
        while (iterator.hasNext())
          ((AnimationListener)iterator.next()).a(this); 
      } 
    } 
  }
  
  private void f() {
    int i = this.r - 1;
    this.r = i;
    if (i == 0) {
      ArrayList<AnimationListener> arrayList = this.s;
      if (arrayList != null) {
        Iterator<AnimationListener> iterator = arrayList.iterator();
        while (iterator.hasNext())
          ((AnimationListener)iterator.next()).b(this); 
      } 
    } 
  }
  
  private FloatingActionButton g() {
    View view = h();
    return (view instanceof FloatingActionButton) ? (FloatingActionButton)view : null;
  }
  
  private ActionMenuView getActionMenuView() {
    for (int i = 0; i < getChildCount(); i++) {
      View view = getChildAt(i);
      if (view instanceof ActionMenuView)
        return (ActionMenuView)view; 
    } 
    return null;
  }
  
  private int getBottomInset() {
    return this.v;
  }
  
  private float getFabTranslationX() {
    return c(this.l);
  }
  
  private float getFabTranslationY() {
    return -getTopEdgeTreatment().c();
  }
  
  private int getLeftInset() {
    return this.x;
  }
  
  private int getRightInset() {
    return this.w;
  }
  
  private BottomAppBarTopEdgeTreatment getTopEdgeTreatment() {
    return (BottomAppBarTopEdgeTreatment)this.i.getShapeAppearanceModel().k();
  }
  
  private View h() {
    if (!(getParent() instanceof CoordinatorLayout))
      return null; 
    for (View view : ((CoordinatorLayout)getParent()).getDependents((View)this)) {
      if (view instanceof FloatingActionButton || view instanceof com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton)
        return view; 
    } 
    return null;
  }
  
  private boolean i() {
    FloatingActionButton floatingActionButton = g();
    return (floatingActionButton != null && floatingActionButton.c());
  }
  
  private void j() {
    Animator animator = this.k;
    if (animator != null)
      animator.cancel(); 
    animator = this.j;
    if (animator != null)
      animator.cancel(); 
  }
  
  private void k() {
    float f;
    getTopEdgeTreatment().b(getFabTranslationX());
    View view = h();
    MaterialShapeDrawable materialShapeDrawable = this.i;
    if (this.t && i()) {
      f = 1.0F;
    } else {
      f = 0.0F;
    } 
    materialShapeDrawable.p(f);
    if (view != null) {
      view.setTranslationY(getFabTranslationY());
      view.setTranslationX(getFabTranslationX());
    } 
  }
  
  private void l() {
    ActionMenuView actionMenuView = getActionMenuView();
    if (actionMenuView != null) {
      actionMenuView.setAlpha(1.0F);
      if (!i()) {
        b(actionMenuView, 0, false);
        return;
      } 
      b(actionMenuView, this.l, this.t);
    } 
  }
  
  protected int a(ActionMenuView paramActionMenuView, int paramInt, boolean paramBoolean) {
    if (paramInt == 1) {
      if (!paramBoolean)
        return 0; 
      paramBoolean = ViewUtils.a((View)this);
      if (paramBoolean) {
        paramInt = getMeasuredWidth();
      } else {
        paramInt = 0;
      } 
      int j = 0;
      int i;
      for (i = paramInt; j < getChildCount(); i = paramInt) {
        boolean bool;
        View view = getChildAt(j);
        if (view.getLayoutParams() instanceof Toolbar.LayoutParams && (((Toolbar.LayoutParams)view.getLayoutParams()).gravity & 0x800007) == 8388611) {
          bool = true;
        } else {
          bool = false;
        } 
        paramInt = i;
        if (bool)
          if (paramBoolean) {
            paramInt = Math.min(i, view.getLeft());
          } else {
            paramInt = Math.max(i, view.getRight());
          }  
        j++;
      } 
      if (paramBoolean) {
        paramInt = paramActionMenuView.getRight();
      } else {
        paramInt = paramActionMenuView.getLeft();
      } 
      if (paramBoolean) {
        j = this.w;
      } else {
        j = -this.x;
      } 
      return i - paramInt + j;
    } 
    return 0;
  }
  
  protected void a(int paramInt, List<Animator> paramList) {
    FloatingActionButton floatingActionButton = g();
    if (floatingActionButton != null) {
      if (floatingActionButton.b())
        return; 
      e();
      floatingActionButton.b(new FloatingActionButton.OnVisibilityChangedListener(this, paramInt) {
            public void a(FloatingActionButton param1FloatingActionButton) {
              param1FloatingActionButton.setTranslationX(BottomAppBar.d(this.b, this.a));
              param1FloatingActionButton.a(new FloatingActionButton.OnVisibilityChangedListener(this) {
                    public void b(FloatingActionButton param2FloatingActionButton) {
                      BottomAppBar.n(this.a.b);
                    }
                  });
            }
          });
    } 
  }
  
  boolean a(int paramInt) {
    float f = paramInt;
    if (f != getTopEdgeTreatment().a()) {
      getTopEdgeTreatment().a(f);
      this.i.invalidateSelf();
      return true;
    } 
    return false;
  }
  
  public ColorStateList getBackgroundTint() {
    return this.i.N();
  }
  
  public Behavior getBehavior() {
    if (this.u == null)
      this.u = new Behavior(); 
    return this.u;
  }
  
  public float getCradleVerticalOffset() {
    return getTopEdgeTreatment().c();
  }
  
  public int getFabAlignmentMode() {
    return this.l;
  }
  
  public int getFabAnimationMode() {
    return this.m;
  }
  
  public float getFabCradleMargin() {
    return getTopEdgeTreatment().d();
  }
  
  public float getFabCradleRoundedCornerRadius() {
    return getTopEdgeTreatment().e();
  }
  
  public boolean getHideOnScroll() {
    return this.n;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    MaterialShapeUtils.a((View)this, this.i);
    if (getParent() instanceof ViewGroup)
      ((ViewGroup)getParent()).setClipChildren(false); 
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      j();
      k();
    } 
    l();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    this.l = savedState.a;
    this.t = savedState.b;
  }
  
  public Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    savedState.a = this.l;
    savedState.b = this.t;
    return (Parcelable)savedState;
  }
  
  public void setBackgroundTint(ColorStateList paramColorStateList) {
    DrawableCompat.setTintList((Drawable)this.i, paramColorStateList);
  }
  
  public void setCradleVerticalOffset(float paramFloat) {
    if (paramFloat != getCradleVerticalOffset()) {
      getTopEdgeTreatment().c(paramFloat);
      this.i.invalidateSelf();
      k();
    } 
  }
  
  public void setElevation(float paramFloat) {
    this.i.r(paramFloat);
    int i = this.i.V();
    int j = this.i.Y();
    getBehavior().a((View)this, i - j);
  }
  
  public void setFabAlignmentMode(int paramInt) {
    b(paramInt);
    a(paramInt, this.t);
    this.l = paramInt;
  }
  
  public void setFabAnimationMode(int paramInt) {
    this.m = paramInt;
  }
  
  public void setFabCradleMargin(float paramFloat) {
    if (paramFloat != getFabCradleMargin()) {
      getTopEdgeTreatment().d(paramFloat);
      this.i.invalidateSelf();
    } 
  }
  
  public void setFabCradleRoundedCornerRadius(float paramFloat) {
    if (paramFloat != getFabCradleRoundedCornerRadius()) {
      getTopEdgeTreatment().e(paramFloat);
      this.i.invalidateSelf();
    } 
  }
  
  public void setHideOnScroll(boolean paramBoolean) {
    this.n = paramBoolean;
  }
  
  public void setSubtitle(CharSequence paramCharSequence) {}
  
  public void setTitle(CharSequence paramCharSequence) {}
  
  static interface AnimationListener {
    void a(BottomAppBar param1BottomAppBar);
    
    void b(BottomAppBar param1BottomAppBar);
  }
  
  public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
    private final Rect a = new Rect();
    
    private WeakReference<BottomAppBar> b;
    
    private int c;
    
    private final View.OnLayoutChangeListener d = new View.OnLayoutChangeListener(this) {
        public void onLayoutChange(View param2View, int param2Int1, int param2Int2, int param2Int3, int param2Int4, int param2Int5, int param2Int6, int param2Int7, int param2Int8) {
          BottomAppBar bottomAppBar = BottomAppBar.Behavior.a(this.a).get();
          if (bottomAppBar == null || !(param2View instanceof FloatingActionButton)) {
            param2View.removeOnLayoutChangeListener(this);
            return;
          } 
          FloatingActionButton floatingActionButton = (FloatingActionButton)param2View;
          floatingActionButton.b(BottomAppBar.Behavior.b(this.a));
          param2Int1 = BottomAppBar.Behavior.b(this.a).height();
          bottomAppBar.a(param2Int1);
          CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams)param2View.getLayoutParams();
          if (BottomAppBar.Behavior.c(this.a) == 0) {
            param2Int1 = (floatingActionButton.getMeasuredHeight() - param2Int1) / 2;
            param2Int2 = bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin);
            layoutParams.bottomMargin = BottomAppBar.q(bottomAppBar) + param2Int2 - param2Int1;
            layoutParams.leftMargin = BottomAppBar.r(bottomAppBar);
            layoutParams.rightMargin = BottomAppBar.s(bottomAppBar);
            if (ViewUtils.a((View)floatingActionButton)) {
              layoutParams.leftMargin += BottomAppBar.t(bottomAppBar);
              return;
            } 
            layoutParams.rightMargin += BottomAppBar.t(bottomAppBar);
          } 
        }
      };
    
    public Behavior() {}
    
    public Behavior(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
    }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, BottomAppBar param1BottomAppBar, int param1Int) {
      this.b = new WeakReference<BottomAppBar>(param1BottomAppBar);
      View view = BottomAppBar.u(param1BottomAppBar);
      if (view != null && !ViewCompat.isLaidOut(view)) {
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams)view.getLayoutParams();
        layoutParams.anchorGravity = 49;
        this.c = layoutParams.bottomMargin;
        if (view instanceof FloatingActionButton) {
          FloatingActionButton floatingActionButton = (FloatingActionButton)view;
          floatingActionButton.addOnLayoutChangeListener(this.d);
          BottomAppBar.a(param1BottomAppBar, floatingActionButton);
        } 
        BottomAppBar.k(param1BottomAppBar);
      } 
      param1CoordinatorLayout.onLayoutChild((View)param1BottomAppBar, param1Int);
      return super.onLayoutChild(param1CoordinatorLayout, (View)param1BottomAppBar, param1Int);
    }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, BottomAppBar param1BottomAppBar, View param1View1, View param1View2, int param1Int1, int param1Int2) {
      return (param1BottomAppBar.getHideOnScroll() && super.onStartNestedScroll(param1CoordinatorLayout, (View)param1BottomAppBar, param1View1, param1View2, param1Int1, param1Int2));
    }
  }
  
  class null implements View.OnLayoutChangeListener {
    null(BottomAppBar this$0) {}
    
    public void onLayoutChange(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int param1Int6, int param1Int7, int param1Int8) {
      BottomAppBar bottomAppBar = BottomAppBar.Behavior.a(this.a).get();
      if (bottomAppBar == null || !(param1View instanceof FloatingActionButton)) {
        param1View.removeOnLayoutChangeListener(this);
        return;
      } 
      FloatingActionButton floatingActionButton = (FloatingActionButton)param1View;
      floatingActionButton.b(BottomAppBar.Behavior.b(this.a));
      param1Int1 = BottomAppBar.Behavior.b(this.a).height();
      bottomAppBar.a(param1Int1);
      CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams)param1View.getLayoutParams();
      if (BottomAppBar.Behavior.c(this.a) == 0) {
        param1Int1 = (floatingActionButton.getMeasuredHeight() - param1Int1) / 2;
        param1Int2 = bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin);
        layoutParams.bottomMargin = BottomAppBar.q(bottomAppBar) + param1Int2 - param1Int1;
        layoutParams.leftMargin = BottomAppBar.r(bottomAppBar);
        layoutParams.rightMargin = BottomAppBar.s(bottomAppBar);
        if (ViewUtils.a((View)floatingActionButton)) {
          layoutParams.leftMargin += BottomAppBar.t(bottomAppBar);
          return;
        } 
        layoutParams.rightMargin += BottomAppBar.t(bottomAppBar);
      } 
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FabAlignmentMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FabAnimationMode {}
  
  static class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = (Parcelable.Creator<SavedState>)new Parcelable.ClassLoaderCreator<SavedState>() {
        public BottomAppBar.SavedState a(Parcel param2Parcel) {
          return new BottomAppBar.SavedState(param2Parcel, null);
        }
        
        public BottomAppBar.SavedState a(Parcel param2Parcel, ClassLoader param2ClassLoader) {
          return new BottomAppBar.SavedState(param2Parcel, param2ClassLoader);
        }
        
        public BottomAppBar.SavedState[] a(int param2Int) {
          return new BottomAppBar.SavedState[param2Int];
        }
      };
    
    int a;
    
    boolean b;
    
    public SavedState(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      boolean bool;
      this.a = param1Parcel.readInt();
      if (param1Parcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.b = bool;
    }
    
    public SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  static final class null implements Parcelable.ClassLoaderCreator<SavedState> {
    public BottomAppBar.SavedState a(Parcel param1Parcel) {
      return new BottomAppBar.SavedState(param1Parcel, null);
    }
    
    public BottomAppBar.SavedState a(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return new BottomAppBar.SavedState(param1Parcel, param1ClassLoader);
    }
    
    public BottomAppBar.SavedState[] a(int param1Int) {
      return new BottomAppBar.SavedState[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\bottomappbar\BottomAppBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */