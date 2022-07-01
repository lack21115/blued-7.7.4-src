package com.soft.blued.ui.circle.adapter;

import android.view.ViewGroup;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.feed.model.CircleTextVote;

public class CircleTextVoteViewAdapter extends BaseQuickAdapter<CircleTextVote, BaseViewHolder> {
  private int a = 0;
  
  private boolean b = false;
  
  private boolean c = false;
  
  public CircleTextVoteViewAdapter() {
    super(2131494244);
  }
  
  private void a(ShapeTextView paramShapeTextView, int paramInt1, int paramInt2) {
    if (paramInt2 <= 0) {
      ViewGroup.LayoutParams layoutParams1 = paramShapeTextView.getLayoutParams();
      layoutParams1.width = 0;
      paramShapeTextView.setLayoutParams(layoutParams1);
      return;
    } 
    int i = DensityUtils.a(this.k, 14);
    int j = this.a;
    if (paramInt2 == j) {
      ViewGroup.LayoutParams layoutParams1 = paramShapeTextView.getLayoutParams();
      layoutParams1.width = paramInt1;
      paramShapeTextView.setLayoutParams(layoutParams1);
      ShapeHelper.a((ShapeHelper.ShapeView)paramShapeTextView, i);
      return;
    } 
    float f = paramInt2 / j;
    paramInt1 = (int)((paramInt1 - i * 2) * f);
    ViewGroup.LayoutParams layoutParams = paramShapeTextView.getLayoutParams();
    layoutParams.width = paramInt1 + i;
    paramShapeTextView.setLayoutParams(layoutParams);
    ShapeHelper.a((ShapeHelper.ShapeView)paramShapeTextView, 0.0F);
    f = i;
    ShapeHelper.a((ShapeHelper.ShapeView)paramShapeTextView, f, 0.0F, f, 0.0F);
  }
  
  public void a(int paramInt) {
    this.a = paramInt;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, CircleTextVote paramCircleTextVote) {
    if (paramBaseViewHolder != null && paramCircleTextVote != null) {
      paramBaseViewHolder.getAdapterPosition();
      o();
      paramBaseViewHolder.a(2131301143, paramCircleTextVote.option);
      if (paramCircleTextVote.select) {
        paramBaseViewHolder.b(2131297882, true);
      } else {
        paramBaseViewHolder.b(2131297882, false);
      } 
      if (this.b) {
        paramBaseViewHolder.a(2131301126, String.valueOf(paramCircleTextVote.count));
        paramBaseViewHolder.b(2131301126, true);
      } else {
        paramBaseViewHolder.b(2131301126, false);
      } 
      ShapeTextView shapeTextView2 = (ShapeTextView)paramBaseViewHolder.d(2131300114);
      ShapeTextView shapeTextView1 = (ShapeTextView)paramBaseViewHolder.d(2131300133);
      if (this.b) {
        if (paramCircleTextVote.select) {
          ShapeHelper.b((ShapeHelper.ShapeView)shapeTextView1, 2131100866);
        } else {
          ShapeHelper.b((ShapeHelper.ShapeView)shapeTextView1, 2131100882);
        } 
        a(shapeTextView1, AppInfo.l - DensityUtils.a(this.k, 40.0F), paramCircleTextVote.count);
        shapeTextView1.setVisibility(0);
        shapeTextView2.setEnabled(false);
        return;
      } 
      shapeTextView1.setVisibility(8);
      shapeTextView2.setEnabled(true);
    } 
  }
  
  public void a(boolean paramBoolean) {
    this.b = paramBoolean;
    notifyDataSetChanged();
  }
  
  public boolean a() {
    return this.b;
  }
  
  public void e(boolean paramBoolean) {
    this.c = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\adapter\CircleTextVoteViewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */