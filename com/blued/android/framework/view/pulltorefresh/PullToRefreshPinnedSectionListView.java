package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.framework.R;

public class PullToRefreshPinnedSectionListView extends PullToRefreshAdapterViewBase<ListView> {
  private LoadingLayout b;
  
  private LoadingLayout c;
  
  private FrameLayout d;
  
  private boolean e;
  
  public PullToRefreshPinnedSectionListView(Context paramContext) {
    super(paramContext);
  }
  
  public PullToRefreshPinnedSectionListView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public PullToRefreshPinnedSectionListView(Context paramContext, PullToRefreshBase.Mode paramMode) {
    super(paramContext, paramMode);
  }
  
  public PullToRefreshPinnedSectionListView(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle) {
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
  
  protected ListView b(Context paramContext, AttributeSet paramAttributeSet) {
    return new PinnedSectionListView(paramContext, paramAttributeSet);
  }
  
  protected ListView c(Context paramContext, AttributeSet paramAttributeSet) {
    ListView listView = b(paramContext, paramAttributeSet);
    listView.setId(16908298);
    return listView;
  }
  
  public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection() {
    return PullToRefreshBase.Orientation.a;
  }
  
  public class InternalListView extends ListView implements EmptyViewMethodAccessor {
    private boolean b;
    
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
      if (PullToRefreshPinnedSectionListView.a(this.a) != null && !this.b) {
        addFooterView((View)PullToRefreshPinnedSectionListView.a(this.a), null, false);
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
    protected boolean overScrollBy(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int param1Int6, int param1Int7, int param1Int8, boolean param1Boolean) {
      boolean bool = super.overScrollBy(param1Int1, param1Int2, param1Int3, param1Int4, param1Int5, param1Int6, param1Int7, param1Int8, param1Boolean);
      OverscrollHelper.a(this.b, param1Int1, param1Int3, param1Int2, param1Int4, param1Boolean);
      return bool;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\pulltorefresh\PullToRefreshPinnedSectionListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */