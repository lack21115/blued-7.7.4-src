package com.blued.android.framework.view;

import android.widget.AbsListView;
import com.blued.android.core.imagecache.RecyclingImageLoader;

public class PauseOnScrollListener implements AbsListView.OnScrollListener {
  private final boolean a;
  
  private final boolean b;
  
  private AbsListView.OnScrollListener c;
  
  public PauseOnScrollListener(boolean paramBoolean1, boolean paramBoolean2) {
    this(paramBoolean1, paramBoolean2, null);
  }
  
  public PauseOnScrollListener(boolean paramBoolean1, boolean paramBoolean2, AbsListView.OnScrollListener paramOnScrollListener) {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramOnScrollListener;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {
    AbsListView.OnScrollListener onScrollListener = this.c;
    if (onScrollListener != null)
      onScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3); 
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt == 2 && this.b)
          RecyclingImageLoader.b(); 
      } else if (this.a) {
        RecyclingImageLoader.b();
      } 
    } else {
      RecyclingImageLoader.c();
    } 
    AbsListView.OnScrollListener onScrollListener = this.c;
    if (onScrollListener != null)
      onScrollListener.onScrollStateChanged(paramAbsListView, paramInt); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\PauseOnScrollListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */