package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.framework.R;

public class PullToRefreshListView extends PullToRefreshAdapterViewBase<ListView> {
  private LoadingLayout b;
  
  private LoadingLayout c;
  
  private FrameLayout d;
  
  private boolean e;
  
  public PullToRefreshListView(Context paramContext) {
    super(paramContext);
  }
  
  public PullToRefreshListView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public PullToRefreshListView(Context paramContext, PullToRefreshBase.Mode paramMode) {
    super(paramContext, paramMode);
  }
  
  public PullToRefreshListView(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle) {
    super(paramContext, paramMode, paramAnimationStyle);
  }
  
  protected void a(TypedArray paramTypedArray) {
    super.a(paramTypedArray);
    this.e = paramTypedArray.getBoolean(R.styleable.PullToRefresh_ptrListViewExtrasEnabled, true);
    if (this.e) {
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 1);
      FrameLayout frameLayout = new FrameLayout(getContext());
      this.b = a(getContext(), PullToRefreshBase.Mode.b, paramTypedArray);
      this.b.setVisibility(8);
      frameLayout.addView((View)this.b, (ViewGroup.LayoutParams)layoutParams);
      this.a.addHeaderView((View)frameLayout, null, false);
      this.d = new FrameLayout(getContext());
      this.c = a(getContext(), PullToRefreshBase.Mode.c, paramTypedArray);
      this.c.setVisibility(8);
      this.d.addView((View)this.c, (ViewGroup.LayoutParams)layoutParams);
      if (!paramTypedArray.hasValue(R.styleable.PullToRefresh_ptrScrollingWhileRefreshingEnabled))
        setScrollingWhileRefreshingEnabled(true); 
    } 
  }
  
  protected void a(boolean paramBoolean) {
    int j;
    LoadingLayout loadingLayout1;
    LoadingLayout loadingLayout2;
    LoadingLayout loadingLayout3;
    ListAdapter listAdapter = this.a.getAdapter();
    if (!this.e || !getShowViewWhileRefreshing() || listAdapter == null || listAdapter.isEmpty() || paramBoolean) {
      this.a.setSelection(0);
      super.a(paramBoolean);
      return;
    } 
    super.a(false);
    int i = null.a[getCurrentMode().ordinal()];
    if (i != 1 && i != 2) {
      loadingLayout1 = getHeaderLayout();
      loadingLayout2 = this.b;
      loadingLayout3 = this.c;
      i = getScrollY() + getHeaderSize();
      j = 0;
    } else {
      LoadingLayout loadingLayout = getFooterLayout();
      loadingLayout1 = this.c;
      loadingLayout3 = this.b;
      j = this.a.getCount();
      i = getScrollY();
      int k = getFooterSize();
      j--;
      i -= k;
      loadingLayout2 = loadingLayout1;
      loadingLayout1 = loadingLayout;
    } 
    loadingLayout1.reset();
    loadingLayout1.hideAllViews();
    loadingLayout3.setVisibility(8);
    loadingLayout2.setVisibility(0);
    loadingLayout2.refreshing();
    if (paramBoolean) {
      l();
      setHeaderScroll(i);
      this.a.setSelection(j);
      a(0);
    } 
  }
  
  protected ListView b(Context paramContext, AttributeSet paramAttributeSet) {
    return (Build.VERSION.SDK_INT >= 9) ? new InternalListViewSDK9(this, paramContext, paramAttributeSet) : new InternalListView(this, paramContext, paramAttributeSet);
  }
  
  protected LoadingLayoutProxy b(boolean paramBoolean1, boolean paramBoolean2) {
    LoadingLayoutProxy loadingLayoutProxy = super.b(paramBoolean1, paramBoolean2);
    if (this.e) {
      PullToRefreshBase.Mode mode = getMode();
      if (paramBoolean1 && mode.c())
        loadingLayoutProxy.a(this.b); 
      if (paramBoolean2 && mode.d())
        loadingLayoutProxy.a(this.c); 
    } 
    return loadingLayoutProxy;
  }
  
  protected ListView c(Context paramContext, AttributeSet paramAttributeSet) {
    ListView listView = b(paramContext, paramAttributeSet);
    listView.setDrawSelectorOnTop(false);
    listView.setFadingEdgeLength(0);
    listView.setDivider(null);
    listView.setDividerHeight(0);
    listView.setFooterDividersEnabled(false);
    listView.setHeaderDividersEnabled(false);
    listView.setSelector((Drawable)new ColorDrawable(0));
    listView.setCacheColorHint(0);
    listView.setId(16908298);
    return listView;
  }
  
  protected void c() {
    LoadingLayout loadingLayout1;
    LoadingLayout loadingLayout2;
    if (!this.e) {
      super.c();
      return;
    } 
    int j = null.a[getCurrentMode().ordinal()];
    int i = 0;
    boolean bool2 = true;
    boolean bool1 = true;
    if (j != 1 && j != 2) {
      loadingLayout1 = getHeaderLayout();
      loadingLayout2 = this.b;
      j = -getHeaderSize();
      if (Math.abs(this.a.getFirstVisiblePosition() - 0) <= 1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      } 
    } else {
      loadingLayout1 = getFooterLayout();
      loadingLayout2 = this.c;
      i = this.a.getCount() - 1;
      j = getFooterSize();
      if (Math.abs(this.a.getLastVisiblePosition() - i) > 1)
        bool1 = false; 
    } 
    if (loadingLayout2.getVisibility() == 0) {
      loadingLayout1.showInvisibleViews();
      loadingLayout2.setVisibility(8);
      if (bool1 && getState() != PullToRefreshBase.State.e) {
        this.a.setSelection(i);
        setHeaderScroll(j);
      } 
    } 
    super.c();
  }
  
  public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection() {
    return PullToRefreshBase.Orientation.a;
  }
  
  public class InternalListView extends ListView implements EmptyViewMethodAccessor {
    private boolean b = false;
    
    public InternalListView(PullToRefreshListView this$0, Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
    }
    
    protected void dispatchDraw(Canvas param1Canvas) {
      try {
        super.dispatchDraw(param1Canvas);
        return;
      } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        indexOutOfBoundsException.printStackTrace();
        return;
      } 
    }
    
    public boolean dispatchTouchEvent(MotionEvent param1MotionEvent) {
      try {
        return super.dispatchTouchEvent(param1MotionEvent);
      } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        indexOutOfBoundsException.printStackTrace();
        return false;
      } 
    }
    
    public void setAdapter(ListAdapter param1ListAdapter) {
      if (PullToRefreshListView.a(this.a) != null && !this.b) {
        addFooterView((View)PullToRefreshListView.a(this.a), null, false);
        this.b = true;
      } 
      super.setAdapter(param1ListAdapter);
    }
    
    public void setEmptyView(View param1View) {
      this.a.setEmptyView(param1View);
    }
    
    public void setEmptyViewInternal(View param1View) {
      super.setEmptyView(param1View);
    }
  }
  
  final class InternalListViewSDK9 extends InternalListView {
    public InternalListViewSDK9(PullToRefreshListView this$0, Context param1Context, AttributeSet param1AttributeSet) {
      super(this$0, param1Context, param1AttributeSet);
    }
    
    protected boolean overScrollBy(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int param1Int6, int param1Int7, int param1Int8, boolean param1Boolean) {
      boolean bool = super.overScrollBy(param1Int1, param1Int2, param1Int3, param1Int4, param1Int5, param1Int6, param1Int7, param1Int8, param1Boolean);
      OverscrollHelper.a(this.b, param1Int1, param1Int3, param1Int2, param1Int4, param1Boolean);
      return bool;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\pulltorefresh\PullToRefreshListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */