package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

abstract class AbsActionBarView extends ViewGroup {
  protected final VisibilityAnimListener a = new VisibilityAnimListener(this);
  
  protected final Context b;
  
  protected ActionMenuView c;
  
  protected ActionMenuPresenter d;
  
  protected int e;
  
  protected ViewPropertyAnimatorCompat f;
  
  private boolean g;
  
  private boolean h;
  
  AbsActionBarView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  AbsActionBarView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  AbsActionBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TypedValue typedValue = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
      this.b = (Context)new ContextThemeWrapper(paramContext, typedValue.resourceId);
      return;
    } 
    this.b = paramContext;
  }
  
  protected static int a(int paramInt1, int paramInt2, boolean paramBoolean) {
    return paramBoolean ? (paramInt1 - paramInt2) : (paramInt1 + paramInt2);
  }
  
  protected int a(View paramView, int paramInt1, int paramInt2, int paramInt3) {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648), paramInt2);
    return Math.max(0, paramInt1 - paramView.getMeasuredWidth() - paramInt3);
  }
  
  protected int a(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    paramInt2 += (paramInt3 - j) / 2;
    if (paramBoolean) {
      paramView.layout(paramInt1 - i, paramInt2, paramInt1, j + paramInt2);
    } else {
      paramView.layout(paramInt1, paramInt2, paramInt1 + i, j + paramInt2);
    } 
    paramInt1 = i;
    if (paramBoolean)
      paramInt1 = -i; 
    return paramInt1;
  }
  
  public void animateToVisibility(int paramInt) {
    setupAnimatorToVisibility(paramInt, 200L).start();
  }
  
  public boolean canShowOverflowMenu() {
    return (isOverflowReserved() && getVisibility() == 0);
  }
  
  public void dismissPopupMenus() {
    ActionMenuPresenter actionMenuPresenter = this.d;
    if (actionMenuPresenter != null)
      actionMenuPresenter.dismissPopupMenus(); 
  }
  
  public int getAnimatedVisibility() {
    return (this.f != null) ? this.a.a : getVisibility();
  }
  
  public int getContentHeight() {
    return this.e;
  }
  
  public boolean hideOverflowMenu() {
    ActionMenuPresenter actionMenuPresenter = this.d;
    return (actionMenuPresenter != null) ? actionMenuPresenter.hideOverflowMenu() : false;
  }
  
  public boolean isOverflowMenuShowPending() {
    ActionMenuPresenter actionMenuPresenter = this.d;
    return (actionMenuPresenter != null) ? actionMenuPresenter.isOverflowMenuShowPending() : false;
  }
  
  public boolean isOverflowMenuShowing() {
    ActionMenuPresenter actionMenuPresenter = this.d;
    return (actionMenuPresenter != null) ? actionMenuPresenter.isOverflowMenuShowing() : false;
  }
  
  public boolean isOverflowReserved() {
    ActionMenuPresenter actionMenuPresenter = this.d;
    return (actionMenuPresenter != null && actionMenuPresenter.isOverflowReserved());
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    TypedArray typedArray = getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
    setContentHeight(typedArray.getLayoutDimension(R.styleable.ActionBar_height, 0));
    typedArray.recycle();
    ActionMenuPresenter actionMenuPresenter = this.d;
    if (actionMenuPresenter != null)
      actionMenuPresenter.onConfigurationChanged(paramConfiguration); 
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9)
      this.h = false; 
    if (!this.h) {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if (i == 9 && !bool)
        this.h = true; 
    } 
    if (i == 10 || i == 3)
      this.h = false; 
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
      this.g = false; 
    if (!this.g) {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if (i == 0 && !bool)
        this.g = true; 
    } 
    if (i == 1 || i == 3)
      this.g = false; 
    return true;
  }
  
  public void postShowOverflowMenu() {
    post(new Runnable(this) {
          public void run() {
            this.a.showOverflowMenu();
          }
        });
  }
  
  public void setContentHeight(int paramInt) {
    this.e = paramInt;
    requestLayout();
  }
  
  public void setVisibility(int paramInt) {
    if (paramInt != getVisibility()) {
      ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f;
      if (viewPropertyAnimatorCompat != null)
        viewPropertyAnimatorCompat.cancel(); 
      super.setVisibility(paramInt);
    } 
  }
  
  public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int paramInt, long paramLong) {
    ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f;
    if (viewPropertyAnimatorCompat != null)
      viewPropertyAnimatorCompat.cancel(); 
    if (paramInt == 0) {
      if (getVisibility() != 0)
        setAlpha(0.0F); 
      viewPropertyAnimatorCompat = ViewCompat.animate((View)this).alpha(1.0F);
      viewPropertyAnimatorCompat.setDuration(paramLong);
      viewPropertyAnimatorCompat.setListener(this.a.withFinalVisibility(viewPropertyAnimatorCompat, paramInt));
      return viewPropertyAnimatorCompat;
    } 
    viewPropertyAnimatorCompat = ViewCompat.animate((View)this).alpha(0.0F);
    viewPropertyAnimatorCompat.setDuration(paramLong);
    viewPropertyAnimatorCompat.setListener(this.a.withFinalVisibility(viewPropertyAnimatorCompat, paramInt));
    return viewPropertyAnimatorCompat;
  }
  
  public boolean showOverflowMenu() {
    ActionMenuPresenter actionMenuPresenter = this.d;
    return (actionMenuPresenter != null) ? actionMenuPresenter.showOverflowMenu() : false;
  }
  
  public class VisibilityAnimListener implements ViewPropertyAnimatorListener {
    int a;
    
    private boolean c = false;
    
    protected VisibilityAnimListener(AbsActionBarView this$0) {}
    
    public void onAnimationCancel(View param1View) {
      this.c = true;
    }
    
    public void onAnimationEnd(View param1View) {
      if (this.c)
        return; 
      AbsActionBarView absActionBarView = this.b;
      absActionBarView.f = null;
      AbsActionBarView.b(absActionBarView, this.a);
    }
    
    public void onAnimationStart(View param1View) {
      AbsActionBarView.a(this.b, 0);
      this.c = false;
    }
    
    public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, int param1Int) {
      this.b.f = param1ViewPropertyAnimatorCompat;
      this.a = param1Int;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\AbsActionBarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */