package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.blued.android.framework.R;
import com.blued.android.framework.view.PauseOnScrollListener;

public abstract class PullToRefreshAdapterViewBase<T extends AbsListView> extends PullToRefreshBase<T> implements AbsListView.OnScrollListener {
  private boolean b;
  
  private PauseOnScrollListener c = new PauseOnScrollListener(false, true);
  
  private AbsListView.OnScrollListener d;
  
  private PullToRefreshBase.OnLastItemVisibleListener e;
  
  private View f;
  
  private IndicatorLayout g;
  
  private IndicatorLayout h;
  
  private boolean i;
  
  private boolean j = true;
  
  public PullToRefreshAdapterViewBase(Context paramContext) {
    super(paramContext);
    ((AbsListView)this.a).setOnScrollListener(this);
  }
  
  public PullToRefreshAdapterViewBase(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    ((AbsListView)this.a).setOnScrollListener(this);
  }
  
  public PullToRefreshAdapterViewBase(Context paramContext, PullToRefreshBase.Mode paramMode) {
    super(paramContext, paramMode);
    ((AbsListView)this.a).setOnScrollListener(this);
  }
  
  public PullToRefreshAdapterViewBase(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle) {
    super(paramContext, paramMode, paramAnimationStyle);
    ((AbsListView)this.a).setOnScrollListener(this);
  }
  
  private static FrameLayout.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams) {
    if (paramLayoutParams != null) {
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
      if (paramLayoutParams instanceof LinearLayout.LayoutParams) {
        layoutParams.gravity = ((LinearLayout.LayoutParams)paramLayoutParams).gravity;
        return layoutParams;
      } 
      layoutParams.gravity = 17;
      return layoutParams;
    } 
    return null;
  }
  
  private boolean getShowIndicatorInternal() {
    return (this.i && g());
  }
  
  private void o() {
    FrameLayout.LayoutParams layoutParams;
    PullToRefreshBase.Mode mode = getMode();
    FrameLayout frameLayout = getRefreshableViewWrapper();
    if (mode.c() && this.g == null) {
      this.g = new IndicatorLayout(getContext(), PullToRefreshBase.Mode.b);
      FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(-2, -2);
      layoutParams1.rightMargin = getResources().getDimensionPixelSize(R.dimen.indicator_right_padding);
      layoutParams1.gravity = 53;
      frameLayout.addView((View)this.g, (ViewGroup.LayoutParams)layoutParams1);
    } else if (!mode.c()) {
      IndicatorLayout indicatorLayout = this.g;
      if (indicatorLayout != null) {
        frameLayout.removeView((View)indicatorLayout);
        this.g = null;
      } 
    } 
    if (mode.d() && this.h == null) {
      this.h = new IndicatorLayout(getContext(), PullToRefreshBase.Mode.c);
      layoutParams = new FrameLayout.LayoutParams(-2, -2);
      layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.indicator_right_padding);
      layoutParams.gravity = 85;
      frameLayout.addView((View)this.h, (ViewGroup.LayoutParams)layoutParams);
      return;
    } 
    if (!layoutParams.d()) {
      IndicatorLayout indicatorLayout = this.h;
      if (indicatorLayout != null) {
        frameLayout.removeView((View)indicatorLayout);
        this.h = null;
      } 
    } 
  }
  
  private boolean p() {
    if (((AbsListView)this.a).getAdapter() == null)
      return true; 
    if (((AbsListView)this.a).getFirstVisiblePosition() <= 1) {
      View view = ((AbsListView)this.a).getChildAt(0);
      if (view != null)
        return (view.getTop() >= ((AbsListView)this.a).getTop()); 
    } 
    return false;
  }
  
  private boolean q() {
    Adapter adapter = ((AbsListView)this.a).getAdapter();
    if (adapter != null) {
      if (adapter.isEmpty())
        return true; 
      int j = ((AbsListView)this.a).getCount();
      int i = ((AbsListView)this.a).getLastVisiblePosition();
      if (i >= j - 1 - 1) {
        j = ((AbsListView)this.a).getFirstVisiblePosition();
        View view = ((AbsListView)this.a).getChildAt(i - j);
        if (view != null)
          return (view.getBottom() <= ((AbsListView)this.a).getBottom()); 
      } 
      return false;
    } 
    return true;
  }
  
  private void r() {
    if (this.g != null) {
      getRefreshableViewWrapper().removeView((View)this.g);
      this.g = null;
    } 
    if (this.h != null) {
      getRefreshableViewWrapper().removeView((View)this.h);
      this.h = null;
    } 
  }
  
  private void s() {
    if (this.g != null)
      if (!i() && d()) {
        if (!this.g.a())
          this.g.c(); 
      } else if (this.g.a()) {
        this.g.b();
      }  
    if (this.h != null)
      if (!i() && e()) {
        if (!this.h.a()) {
          this.h.c();
          return;
        } 
      } else if (this.h.a()) {
        this.h.b();
      }  
  }
  
  protected void a() {
    super.a();
    if (getShowIndicatorInternal()) {
      int i = null.a[getCurrentMode().ordinal()];
      if (i != 1) {
        if (i != 2)
          return; 
        this.g.e();
        return;
      } 
      this.h.e();
    } 
  }
  
  protected void a(TypedArray paramTypedArray) {
    this.i = paramTypedArray.getBoolean(R.styleable.PullToRefresh_ptrShowIndicator, h() ^ true);
  }
  
  protected void a(boolean paramBoolean) {
    super.a(paramBoolean);
    if (getShowIndicatorInternal())
      s(); 
  }
  
  protected void b() {
    super.b();
    if (getShowIndicatorInternal()) {
      int i = null.a[getCurrentMode().ordinal()];
      if (i != 1) {
        if (i != 2)
          return; 
        this.g.d();
        return;
      } 
      this.h.d();
    } 
  }
  
  protected void c() {
    super.c();
    if (getShowIndicatorInternal())
      s(); 
  }
  
  protected boolean d() {
    return p();
  }
  
  protected boolean e() {
    return q();
  }
  
  protected void f() {
    super.f();
    if (getShowIndicatorInternal()) {
      o();
      return;
    } 
    r();
  }
  
  public boolean getShowIndicator() {
    return this.i;
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {
    this.c.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (this.e != null) {
      boolean bool;
      if (paramInt3 > 0 && paramInt1 + paramInt2 >= paramInt3 - 1) {
        bool = true;
      } else {
        bool = false;
      } 
      this.b = bool;
    } 
    if (getShowIndicatorInternal())
      s(); 
    AbsListView.OnScrollListener onScrollListener = this.d;
    if (onScrollListener != null)
      onScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3); 
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View view = this.f;
    if (view != null && !this.j)
      view.scrollTo(-paramInt1, -paramInt2); 
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
    this.c.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0) {
      PullToRefreshBase.OnLastItemVisibleListener onLastItemVisibleListener = this.e;
      if (onLastItemVisibleListener != null && this.b)
        onLastItemVisibleListener.a(); 
    } 
    AbsListView.OnScrollListener onScrollListener = this.d;
    if (onScrollListener != null)
      onScrollListener.onScrollStateChanged(paramAbsListView, paramInt); 
  }
  
  public void setAdapter(ListAdapter paramListAdapter) {
    ((AdapterView)this.a).setAdapter((Adapter)paramListAdapter);
  }
  
  public final void setEmptyView(View paramView) {
    FrameLayout frameLayout = getRefreshableViewWrapper();
    if (paramView != null) {
      paramView.setClickable(true);
      ViewParent viewParent = paramView.getParent();
      if (viewParent != null && viewParent instanceof ViewGroup)
        ((ViewGroup)viewParent).removeView(paramView); 
      FrameLayout.LayoutParams layoutParams = a(paramView.getLayoutParams());
      if (layoutParams != null) {
        frameLayout.addView(paramView, (ViewGroup.LayoutParams)layoutParams);
      } else {
        frameLayout.addView(paramView);
      } 
    } 
    if (this.a instanceof EmptyViewMethodAccessor) {
      ((EmptyViewMethodAccessor)this.a).setEmptyViewInternal(paramView);
    } else {
      ((AbsListView)this.a).setEmptyView(paramView);
    } 
    this.f = paramView;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener) {
    ((AbsListView)this.a).setOnItemClickListener(paramOnItemClickListener);
  }
  
  public final void setOnLastItemVisibleListener(PullToRefreshBase.OnLastItemVisibleListener paramOnLastItemVisibleListener) {
    this.e = paramOnLastItemVisibleListener;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener) {
    this.d = paramOnScrollListener;
  }
  
  public final void setScrollEmptyView(boolean paramBoolean) {
    this.j = paramBoolean;
  }
  
  public void setShowIndicator(boolean paramBoolean) {
    this.i = paramBoolean;
    if (getShowIndicatorInternal()) {
      o();
      return;
    } 
    r();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\pulltorefresh\PullToRefreshAdapterViewBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */