package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.R;

public class PullToRefreshRecyclerView extends PullToRefreshBase<RecyclerView> {
  public PullToRefreshRecyclerView(Context paramContext) {
    super(paramContext);
  }
  
  public PullToRefreshRecyclerView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public PullToRefreshRecyclerView(Context paramContext, PullToRefreshBase.Mode paramMode) {
    super(paramContext, paramMode);
  }
  
  public PullToRefreshRecyclerView(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle) {
    super(paramContext, paramMode, paramAnimationStyle);
  }
  
  protected RecyclerView b(Context paramContext, AttributeSet paramAttributeSet) {
    RecyclerView recyclerView = new RecyclerView(paramContext, paramAttributeSet);
    recyclerView.setId(R.id.recycler_list);
    return recyclerView;
  }
  
  protected boolean d() {
    return getRefreshableView().canScrollVertically(-1) ^ true;
  }
  
  protected boolean e() {
    return getRefreshableView().canScrollVertically(1) ^ true;
  }
  
  public PullToRefreshBase.Orientation getPullToRefreshScrollDirection() {
    return PullToRefreshBase.Orientation.a;
  }
  
  public void setRefreshEnabled(boolean paramBoolean) {
    if (paramBoolean) {
      setMode(PullToRefreshBase.Mode.b);
      return;
    } 
    setMode(PullToRefreshBase.Mode.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\pulltorefresh\PullToRefreshRecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */