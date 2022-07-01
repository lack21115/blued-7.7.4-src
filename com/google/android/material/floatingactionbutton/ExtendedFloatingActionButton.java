package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.Iterator;
import java.util.List;

public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {
  static final Property<View, Float> a;
  
  static final Property<View, Float> b;
  
  private static final int c = R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
  
  private int d = 0;
  
  private final AnimatorTracker e = new AnimatorTracker();
  
  private final MotionStrategy f;
  
  private final MotionStrategy g;
  
  private final MotionStrategy h = new ShowStrategy(this, this.e);
  
  private final MotionStrategy i = new HideStrategy(this, this.e);
  
  private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> j;
  
  private boolean k = true;
  
  static {
    a = new Property<View, Float>(Float.class, "width") {
        public Float a(View param1View) {
          return Float.valueOf((param1View.getLayoutParams()).width);
        }
        
        public void a(View param1View, Float param1Float) {
          (param1View.getLayoutParams()).width = param1Float.intValue();
          param1View.requestLayout();
        }
      };
    b = new Property<View, Float>(Float.class, "height") {
        public Float a(View param1View) {
          return Float.valueOf((param1View.getLayoutParams()).height);
        }
        
        public void a(View param1View, Float param1Float) {
          (param1View.getLayoutParams()).height = param1Float.intValue();
          param1View.requestLayout();
        }
      };
  }
  
  public ExtendedFloatingActionButton(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.extendedFloatingActionButtonStyle);
  }
  
  public ExtendedFloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, c), paramAttributeSet, paramInt);
    paramContext = getContext();
    this.j = new ExtendedFloatingActionButtonBehavior<ExtendedFloatingActionButton>(paramContext, paramAttributeSet);
    TypedArray typedArray = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.ExtendedFloatingActionButton, paramInt, c, new int[0]);
    MotionSpec motionSpec1 = MotionSpec.a(paramContext, typedArray, R.styleable.ExtendedFloatingActionButton_showMotionSpec);
    MotionSpec motionSpec2 = MotionSpec.a(paramContext, typedArray, R.styleable.ExtendedFloatingActionButton_hideMotionSpec);
    MotionSpec motionSpec3 = MotionSpec.a(paramContext, typedArray, R.styleable.ExtendedFloatingActionButton_extendMotionSpec);
    MotionSpec motionSpec4 = MotionSpec.a(paramContext, typedArray, R.styleable.ExtendedFloatingActionButton_shrinkMotionSpec);
    AnimatorTracker animatorTracker = new AnimatorTracker();
    this.g = new ChangeSizeStrategy(this, animatorTracker, new Size(this) {
          public int a() {
            return this.a.getMeasuredWidth();
          }
          
          public int b() {
            return this.a.getMeasuredHeight();
          }
          
          public ViewGroup.LayoutParams c() {
            return new ViewGroup.LayoutParams(-2, -2);
          }
        }true);
    this.f = new ChangeSizeStrategy(this, animatorTracker, new Size(this) {
          public int a() {
            return this.a.getCollapsedSize();
          }
          
          public int b() {
            return this.a.getCollapsedSize();
          }
          
          public ViewGroup.LayoutParams c() {
            return new ViewGroup.LayoutParams(a(), b());
          }
        }false);
    this.h.a(motionSpec1);
    this.i.a(motionSpec2);
    this.g.a(motionSpec3);
    this.f.a(motionSpec4);
    typedArray.recycle();
    setShapeAppearanceModel(ShapeAppearanceModel.a(paramContext, paramAttributeSet, paramInt, c, ShapeAppearanceModel.a).a());
  }
  
  private void a(MotionStrategy paramMotionStrategy, OnChangedCallback paramOnChangedCallback) {
    if (paramMotionStrategy.i())
      return; 
    if (!d()) {
      paramMotionStrategy.g();
      paramMotionStrategy.a(paramOnChangedCallback);
      return;
    } 
    measure(0, 0);
    AnimatorSet animatorSet = paramMotionStrategy.f();
    animatorSet.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, paramMotionStrategy, paramOnChangedCallback) {
          private boolean d;
          
          public void onAnimationCancel(Animator param1Animator) {
            this.d = true;
            this.a.e();
          }
          
          public void onAnimationEnd(Animator param1Animator) {
            this.a.d();
            if (!this.d)
              this.a.a(this.b); 
          }
          
          public void onAnimationStart(Animator param1Animator) {
            this.a.a(param1Animator);
            this.d = false;
          }
        });
    Iterator<Animator.AnimatorListener> iterator = paramMotionStrategy.b().iterator();
    while (iterator.hasNext())
      animatorSet.addListener(iterator.next()); 
    animatorSet.start();
  }
  
  private boolean b() {
    int i = getVisibility();
    boolean bool2 = false;
    boolean bool1 = false;
    if (i != 0) {
      if (this.d == 2)
        bool1 = true; 
      return bool1;
    } 
    bool1 = bool2;
    if (this.d != 1)
      bool1 = true; 
    return bool1;
  }
  
  private boolean c() {
    int i = getVisibility();
    boolean bool2 = false;
    boolean bool1 = false;
    if (i == 0) {
      if (this.d == 1)
        bool1 = true; 
      return bool1;
    } 
    bool1 = bool2;
    if (this.d != 2)
      bool1 = true; 
    return bool1;
  }
  
  private boolean d() {
    return (ViewCompat.isLaidOut((View)this) && !isInEditMode());
  }
  
  public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
    return this.j;
  }
  
  int getCollapsedSize() {
    return Math.min(ViewCompat.getPaddingStart((View)this), ViewCompat.getPaddingEnd((View)this)) * 2 + getIconSize();
  }
  
  public MotionSpec getExtendMotionSpec() {
    return this.g.c();
  }
  
  public MotionSpec getHideMotionSpec() {
    return this.i.c();
  }
  
  public MotionSpec getShowMotionSpec() {
    return this.h.c();
  }
  
  public MotionSpec getShrinkMotionSpec() {
    return this.f.c();
  }
  
  public void onAttachedToWindow() {
    super.onAttachedToWindow();
    if (this.k && TextUtils.isEmpty(getText()) && getIcon() != null) {
      this.k = false;
      this.f.g();
    } 
  }
  
  public void setExtendMotionSpec(MotionSpec paramMotionSpec) {
    this.g.a(paramMotionSpec);
  }
  
  public void setExtendMotionSpecResource(int paramInt) {
    setExtendMotionSpec(MotionSpec.a(getContext(), paramInt));
  }
  
  public void setExtended(boolean paramBoolean) {
    MotionStrategy motionStrategy;
    if (this.k == paramBoolean)
      return; 
    if (paramBoolean) {
      motionStrategy = this.g;
    } else {
      motionStrategy = this.f;
    } 
    if (motionStrategy.i())
      return; 
    motionStrategy.g();
  }
  
  public void setHideMotionSpec(MotionSpec paramMotionSpec) {
    this.i.a(paramMotionSpec);
  }
  
  public void setHideMotionSpecResource(int paramInt) {
    setHideMotionSpec(MotionSpec.a(getContext(), paramInt));
  }
  
  public void setShowMotionSpec(MotionSpec paramMotionSpec) {
    this.h.a(paramMotionSpec);
  }
  
  public void setShowMotionSpecResource(int paramInt) {
    setShowMotionSpec(MotionSpec.a(getContext(), paramInt));
  }
  
  public void setShrinkMotionSpec(MotionSpec paramMotionSpec) {
    this.f.a(paramMotionSpec);
  }
  
  public void setShrinkMotionSpecResource(int paramInt) {
    setShrinkMotionSpec(MotionSpec.a(getContext(), paramInt));
  }
  
  class ChangeSizeStrategy extends BaseMotionStrategy {
    private final ExtendedFloatingActionButton.Size b;
    
    private final boolean c;
    
    ChangeSizeStrategy(ExtendedFloatingActionButton this$0, AnimatorTracker param1AnimatorTracker, ExtendedFloatingActionButton.Size param1Size, boolean param1Boolean) {
      super(this$0, param1AnimatorTracker);
      this.b = param1Size;
      this.c = param1Boolean;
    }
    
    public void a(Animator param1Animator) {
      super.a(param1Animator);
      ExtendedFloatingActionButton.a(this.a, this.c);
      this.a.setHorizontallyScrolling(true);
    }
    
    public void a(ExtendedFloatingActionButton.OnChangedCallback param1OnChangedCallback) {
      if (param1OnChangedCallback == null)
        return; 
      if (this.c) {
        param1OnChangedCallback.c(this.a);
        return;
      } 
      param1OnChangedCallback.d(this.a);
    }
    
    public void d() {
      super.d();
      this.a.setHorizontallyScrolling(false);
      ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
      if (layoutParams == null)
        return; 
      layoutParams.width = (this.b.c()).width;
      layoutParams.height = (this.b.c()).height;
    }
    
    public AnimatorSet f() {
      MotionSpec motionSpec = a();
      if (motionSpec.c("width")) {
        PropertyValuesHolder[] arrayOfPropertyValuesHolder = motionSpec.d("width");
        arrayOfPropertyValuesHolder[0].setFloatValues(new float[] { this.a.getWidth(), this.b.a() });
        motionSpec.a("width", arrayOfPropertyValuesHolder);
      } 
      if (motionSpec.c("height")) {
        PropertyValuesHolder[] arrayOfPropertyValuesHolder = motionSpec.d("height");
        arrayOfPropertyValuesHolder[0].setFloatValues(new float[] { this.a.getHeight(), this.b.b() });
        motionSpec.a("height", arrayOfPropertyValuesHolder);
      } 
      return b(motionSpec);
    }
    
    public void g() {
      ExtendedFloatingActionButton.a(this.a, this.c);
      ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
      if (layoutParams == null)
        return; 
      layoutParams.width = (this.b.c()).width;
      layoutParams.height = (this.b.c()).height;
      this.a.requestLayout();
    }
    
    public int h() {
      return R.animator.mtrl_extended_fab_change_size_motion_spec;
    }
    
    public boolean i() {
      return (this.c == ExtendedFloatingActionButton.e(this.a) || this.a.getIcon() == null || TextUtils.isEmpty(this.a.getText()));
    }
  }
  
  public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {
    private Rect a;
    
    private ExtendedFloatingActionButton.OnChangedCallback b;
    
    private ExtendedFloatingActionButton.OnChangedCallback c;
    
    private boolean d;
    
    private boolean e;
    
    public ExtendedFloatingActionButtonBehavior() {
      this.d = false;
      this.e = true;
    }
    
    public ExtendedFloatingActionButtonBehavior(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
      this.d = typedArray.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
      this.e = typedArray.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
      typedArray.recycle();
    }
    
    private static boolean a(View param1View) {
      ViewGroup.LayoutParams layoutParams = param1View.getLayoutParams();
      return (layoutParams instanceof CoordinatorLayout.LayoutParams) ? (((CoordinatorLayout.LayoutParams)layoutParams).getBehavior() instanceof com.google.android.material.bottomsheet.BottomSheetBehavior) : false;
    }
    
    private boolean a(View param1View, ExtendedFloatingActionButton param1ExtendedFloatingActionButton) {
      CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams)param1ExtendedFloatingActionButton.getLayoutParams();
      return (!this.d && !this.e) ? false : (!(layoutParams.getAnchorId() != param1View.getId()));
    }
    
    private boolean a(CoordinatorLayout param1CoordinatorLayout, AppBarLayout param1AppBarLayout, ExtendedFloatingActionButton param1ExtendedFloatingActionButton) {
      if (!a((View)param1AppBarLayout, param1ExtendedFloatingActionButton))
        return false; 
      if (this.a == null)
        this.a = new Rect(); 
      Rect rect = this.a;
      DescendantOffsetUtils.b((ViewGroup)param1CoordinatorLayout, (View)param1AppBarLayout, rect);
      if (rect.bottom <= param1AppBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
        a(param1ExtendedFloatingActionButton);
      } else {
        b(param1ExtendedFloatingActionButton);
      } 
      return true;
    }
    
    private boolean b(View param1View, ExtendedFloatingActionButton param1ExtendedFloatingActionButton) {
      if (!a(param1View, param1ExtendedFloatingActionButton))
        return false; 
      CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams)param1ExtendedFloatingActionButton.getLayoutParams();
      if (param1View.getTop() < param1ExtendedFloatingActionButton.getHeight() / 2 + layoutParams.topMargin) {
        a(param1ExtendedFloatingActionButton);
      } else {
        b(param1ExtendedFloatingActionButton);
      } 
      return true;
    }
    
    protected void a(ExtendedFloatingActionButton param1ExtendedFloatingActionButton) {
      ExtendedFloatingActionButton.OnChangedCallback onChangedCallback;
      MotionStrategy motionStrategy;
      if (this.e) {
        onChangedCallback = this.c;
      } else {
        onChangedCallback = this.b;
      } 
      if (this.e) {
        motionStrategy = ExtendedFloatingActionButton.a(param1ExtendedFloatingActionButton);
      } else {
        motionStrategy = ExtendedFloatingActionButton.b(param1ExtendedFloatingActionButton);
      } 
      ExtendedFloatingActionButton.a(param1ExtendedFloatingActionButton, motionStrategy, onChangedCallback);
    }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, ExtendedFloatingActionButton param1ExtendedFloatingActionButton, int param1Int) {
      List<View> list = param1CoordinatorLayout.getDependencies((View)param1ExtendedFloatingActionButton);
      int j = list.size();
      int i;
      for (i = 0; i < j; i++) {
        View view = list.get(i);
        if ((view instanceof AppBarLayout) ? a(param1CoordinatorLayout, (AppBarLayout)view, param1ExtendedFloatingActionButton) : (a(view) && b(view, param1ExtendedFloatingActionButton)))
          break; 
      } 
      param1CoordinatorLayout.onLayoutChild((View)param1ExtendedFloatingActionButton, param1Int);
      return true;
    }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, ExtendedFloatingActionButton param1ExtendedFloatingActionButton, Rect param1Rect) {
      return super.getInsetDodgeRect(param1CoordinatorLayout, (View)param1ExtendedFloatingActionButton, param1Rect);
    }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, ExtendedFloatingActionButton param1ExtendedFloatingActionButton, View param1View) {
      if (param1View instanceof AppBarLayout) {
        a(param1CoordinatorLayout, (AppBarLayout)param1View, param1ExtendedFloatingActionButton);
      } else if (a(param1View)) {
        b(param1View, param1ExtendedFloatingActionButton);
      } 
      return false;
    }
    
    protected void b(ExtendedFloatingActionButton param1ExtendedFloatingActionButton) {
      ExtendedFloatingActionButton.OnChangedCallback onChangedCallback;
      MotionStrategy motionStrategy;
      if (this.e) {
        onChangedCallback = this.c;
      } else {
        onChangedCallback = this.b;
      } 
      if (this.e) {
        motionStrategy = ExtendedFloatingActionButton.c(param1ExtendedFloatingActionButton);
      } else {
        motionStrategy = ExtendedFloatingActionButton.d(param1ExtendedFloatingActionButton);
      } 
      ExtendedFloatingActionButton.a(param1ExtendedFloatingActionButton, motionStrategy, onChangedCallback);
    }
    
    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams param1LayoutParams) {
      if (param1LayoutParams.dodgeInsetEdges == 0)
        param1LayoutParams.dodgeInsetEdges = 80; 
    }
  }
  
  class HideStrategy extends BaseMotionStrategy {
    private boolean b;
    
    public HideStrategy(ExtendedFloatingActionButton this$0, AnimatorTracker param1AnimatorTracker) {
      super(this$0, param1AnimatorTracker);
    }
    
    public void a(Animator param1Animator) {
      super.a(param1Animator);
      this.b = false;
      this.a.setVisibility(0);
      ExtendedFloatingActionButton.a(this.a, 1);
    }
    
    public void a(ExtendedFloatingActionButton.OnChangedCallback param1OnChangedCallback) {
      if (param1OnChangedCallback != null)
        param1OnChangedCallback.b(this.a); 
    }
    
    public void d() {
      super.d();
      ExtendedFloatingActionButton.a(this.a, 0);
      if (!this.b)
        this.a.setVisibility(8); 
    }
    
    public void e() {
      super.e();
      this.b = true;
    }
    
    public void g() {
      this.a.setVisibility(8);
    }
    
    public int h() {
      return R.animator.mtrl_extended_fab_hide_motion_spec;
    }
    
    public boolean i() {
      return ExtendedFloatingActionButton.g(this.a);
    }
  }
  
  public static abstract class OnChangedCallback {
    public void a(ExtendedFloatingActionButton param1ExtendedFloatingActionButton) {}
    
    public void b(ExtendedFloatingActionButton param1ExtendedFloatingActionButton) {}
    
    public void c(ExtendedFloatingActionButton param1ExtendedFloatingActionButton) {}
    
    public void d(ExtendedFloatingActionButton param1ExtendedFloatingActionButton) {}
  }
  
  class ShowStrategy extends BaseMotionStrategy {
    public ShowStrategy(ExtendedFloatingActionButton this$0, AnimatorTracker param1AnimatorTracker) {
      super(this$0, param1AnimatorTracker);
    }
    
    public void a(Animator param1Animator) {
      super.a(param1Animator);
      this.a.setVisibility(0);
      ExtendedFloatingActionButton.a(this.a, 2);
    }
    
    public void a(ExtendedFloatingActionButton.OnChangedCallback param1OnChangedCallback) {
      if (param1OnChangedCallback != null)
        param1OnChangedCallback.a(this.a); 
    }
    
    public void d() {
      super.d();
      ExtendedFloatingActionButton.a(this.a, 0);
    }
    
    public void g() {
      this.a.setVisibility(0);
      this.a.setAlpha(1.0F);
      this.a.setScaleY(1.0F);
      this.a.setScaleX(1.0F);
    }
    
    public int h() {
      return R.animator.mtrl_extended_fab_show_motion_spec;
    }
    
    public boolean i() {
      return ExtendedFloatingActionButton.f(this.a);
    }
  }
  
  static interface Size {
    int a();
    
    int b();
    
    ViewGroup.LayoutParams c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\floatingactionbutton\ExtendedFloatingActionButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */