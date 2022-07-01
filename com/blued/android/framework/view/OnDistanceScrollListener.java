package com.blued.android.framework.view;

import android.view.View;
import android.widget.AbsListView;

public class OnDistanceScrollListener implements AbsListView.OnScrollListener {
  private ScrollDistanceListener a;
  
  private boolean b = false;
  
  private int c;
  
  private int d;
  
  private int e;
  
  private int f;
  
  private int g;
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt3 != 0) {
      paramInt2 = 0;
      if (paramAbsListView.getChildAt(0) == null)
        return; 
      View view = paramAbsListView.getChildAt(0);
      if (!this.b) {
        this.c = paramAbsListView.getFirstVisiblePosition();
        this.e = view.getTop();
        this.f = view.getBottom();
        this.d = view.getHeight();
        this.b = true;
        this.g = 0;
      } 
      paramInt3 = view.getTop();
      int i = view.getBottom();
      int j = view.getHeight();
      int k = this.e;
      if (k != paramInt3) {
        paramInt2 = this.c;
        if (paramInt1 > paramInt2) {
          this.e = k + this.d;
          paramInt2 = paramInt3 - this.e;
        } else {
          if (paramInt1 < paramInt2) {
            this.f -= this.d;
            paramInt2 = this.f;
          } else {
            paramInt2 = this.f;
          } 
          paramInt2 = i - paramInt2;
        } 
      } 
      this.g += paramInt2;
      ScrollDistanceListener scrollDistanceListener = this.a;
      if (scrollDistanceListener != null)
        scrollDistanceListener.a(paramInt2, this.g); 
      this.e = paramInt3;
      this.f = i;
      this.d = j;
      this.c = paramInt1;
    } 
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
    if (paramAbsListView.getCount() == 0)
      return; 
    if (paramInt != 0)
      return; 
    this.b = false;
  }
  
  public static interface ScrollDistanceListener {
    void a(int param1Int1, int param1Int2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\OnDistanceScrollListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */