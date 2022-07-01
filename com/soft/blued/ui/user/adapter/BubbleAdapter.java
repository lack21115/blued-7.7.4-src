package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.user.model.VipBubbleModel;
import com.soft.blued.utils.TimeAndDateUtils;

public class BubbleAdapter extends BaseQuickAdapter<VipBubbleModel, BaseViewHolder> {
  public BubbleAdapter() {
    super(2131493679);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, VipBubbleModel paramVipBubbleModel) {
    View view1 = paramBaseViewHolder.d(2131299751);
    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams)view1.getLayoutParams();
    layoutParams.width = (AppInfo.l - DensityUtils.a(this.k, 36.0F)) / 3;
    int i = paramBaseViewHolder.getAdapterPosition();
    if (i != 0 && i != 1 && i != 2) {
      layoutParams.topMargin = DensityUtils.a(this.k, 0.0F);
    } else {
      layoutParams.topMargin = DensityUtils.a(this.k, 10.0F);
    } 
    view1.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    ShapeTextView shapeTextView = (ShapeTextView)paramBaseViewHolder.d(2131300890);
    Context context = this.k;
    if (paramVipBubbleModel.vip_status == 0) {
      i = 2131755010;
    } else {
      i = 2131759281;
    } 
    shapeTextView.setText(context.getString(i));
    View view2 = paramBaseViewHolder.d(2131297706);
    GridLayoutManager.LayoutParams layoutParams1 = (GridLayoutManager.LayoutParams)view2.getLayoutParams();
    layoutParams1.width = layoutParams.width;
    layoutParams1.height = layoutParams.width;
    view2.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    if (paramVipBubbleModel.selected == 1) {
      paramBaseViewHolder.c(2131297921, true);
      ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, 2131100980);
      ShapeHelper.b((ShapeHelper.ShapeView)shapeTextView, 2131100716);
    } else {
      paramBaseViewHolder.c(2131297921, false);
      ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, 2131100716);
      ShapeHelper.b((ShapeHelper.ShapeView)shapeTextView, 2131100980);
    } 
    if (paramBaseViewHolder.getAdapterPosition() == 0) {
      paramBaseViewHolder.c(2131297812, 2131231180);
    } else {
      ImageLoader.a(null, paramVipBubbleModel.front_cover).a((ImageView)paramBaseViewHolder.d(2131297812));
    } 
    paramBaseViewHolder.a(2131301088, paramVipBubbleModel.name);
    if (paramVipBubbleModel.is_termination == 1) {
      paramBaseViewHolder.c(2131301389, true);
      paramBaseViewHolder.c(2131301386, true);
      String str = TimeAndDateUtils.d(paramVipBubbleModel.stop_time * 1000L);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.k.getResources().getString(2131759193));
      stringBuilder.append(str);
      paramBaseViewHolder.a(2131301386, stringBuilder.toString());
      return;
    } 
    paramBaseViewHolder.c(2131301389, false);
    paramBaseViewHolder.c(2131301386, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\adapter\BubbleAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */