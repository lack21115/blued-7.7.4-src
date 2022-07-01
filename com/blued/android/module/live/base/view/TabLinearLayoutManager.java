package com.blued.android.module.live.base.view;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

public class TabLinearLayoutManager extends LinearLayoutManager {
  public TabLinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean) {
    super(paramContext, paramInt, paramBoolean);
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt) {
    LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(this, paramRecyclerView.getContext()) {
        public float a(DisplayMetrics param1DisplayMetrics) {
          return 150.0F / param1DisplayMetrics.densityDpi;
        }
      };
    linearSmoothScroller.setTargetPosition(paramInt);
    startSmoothScroll((RecyclerView.SmoothScroller)linearSmoothScroller);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\view\TabLinearLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */