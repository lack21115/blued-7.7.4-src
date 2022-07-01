package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.blued.android.framework.utils.DensityUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;

public class RecyclerViewSpacing extends RecyclerView.ItemDecoration {
  private int a;
  
  private int b;
  
  private int c;
  
  private int d = 0;
  
  private Context e;
  
  public RecyclerViewSpacing(Context paramContext, int paramInt1, int paramInt2) {
    a(paramContext, paramInt1, paramInt2, paramInt2, 0);
  }
  
  private void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.e = paramContext;
    this.a = DensityUtils.a(paramContext, paramInt1);
    this.b = DensityUtils.a(paramContext, paramInt2);
    this.c = DensityUtils.a(paramContext, paramInt3);
    this.d = DensityUtils.a(this.e, paramInt4);
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState) {
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    if (paramRecyclerView.getAdapter() instanceof BaseQuickAdapter && i < ((BaseQuickAdapter)paramRecyclerView.getAdapter()).o())
      return; 
    int j = 0;
    RecyclerView.LayoutManager layoutManager = paramRecyclerView.getLayoutManager();
    if (layoutManager instanceof StaggeredGridLayoutManager) {
      i = ((StaggeredGridLayoutManager)layoutManager).getSpanCount();
      j = ((StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams()).getSpanIndex();
    } else if (layoutManager instanceof GridLayoutManager) {
      i = ((GridLayoutManager)layoutManager).getSpanCount();
      j = ((GridLayoutManager.LayoutParams)paramView.getLayoutParams()).getSpanIndex();
    } else {
      i = 1;
    } 
    if (i == 1) {
      i = this.b;
      j = this.d;
      paramRect.left = i + j;
      paramRect.right = this.c + j;
    } else if (j == 0) {
      i = this.b;
      paramRect.left = this.d + i;
      paramRect.right = i / 2;
    } else if (j == i - 1) {
      i = this.b;
      paramRect.left = i / 2;
      paramRect.right = i + this.d;
    } else {
      i = this.b;
      paramRect.left = i / 2;
      paramRect.right = i / 2;
    } 
    paramRect.bottom = this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\pulltorefresh\RecyclerViewSpacing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */