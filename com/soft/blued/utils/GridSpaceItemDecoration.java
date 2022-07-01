package com.soft.blued.utils;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {
  private int a;
  
  private int b;
  
  private boolean c;
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState) {
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    int j = this.a;
    int k = i % j;
    if (this.c) {
      int n = this.b;
      paramRect.left = n - k * n / j;
      paramRect.right = (k + 1) * n / j;
      if (i < j)
        paramRect.top = n; 
      paramRect.bottom = this.b;
      return;
    } 
    int m = this.b;
    paramRect.left = k * m / j;
    paramRect.right = m - (k + 1) * m / j;
    if (i >= j)
      paramRect.top = m; 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\GridSpaceItemDecoration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */