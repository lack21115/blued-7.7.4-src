package com.blued.android.framework.view.stickylistheaders;

import android.content.Context;
import android.util.AttributeSet;

public class ExpandableStickyListHeadersListView extends StickyListHeadersListView {
  ExpandableStickyListHeadersAdapter a;
  
  IAnimationExecutor b = new IAnimationExecutor(this) {
    
    };
  
  public ExpandableStickyListHeadersListView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public ExpandableStickyListHeadersListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public ExpandableStickyListHeadersAdapter getAdapter() {
    return this.a;
  }
  
  public void setAdapter(StickyListHeadersAdapter paramStickyListHeadersAdapter) {
    this.a = new ExpandableStickyListHeadersAdapter(paramStickyListHeadersAdapter);
    super.setAdapter(this.a);
  }
  
  public void setAnimExecutor(IAnimationExecutor paramIAnimationExecutor) {
    this.b = paramIAnimationExecutor;
  }
  
  public static interface IAnimationExecutor {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\stickylistheaders\ExpandableStickyListHeadersListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */