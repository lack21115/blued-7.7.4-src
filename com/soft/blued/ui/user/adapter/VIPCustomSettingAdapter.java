package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.utils.DensityUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.user.model.VIPCustomSettingBase;
import java.util.ArrayList;

public class VIPCustomSettingAdapter extends BaseQuickAdapter<VIPCustomSettingBase, BaseViewHolder> {
  public Context a;
  
  public int b;
  
  public int c = 3;
  
  public int d;
  
  public int e;
  
  public String f;
  
  public Drawable g;
  
  public int h;
  
  public VIPCustomSettingAdapter(Context paramContext, int paramInt1, String paramString, Drawable paramDrawable, int paramInt2) {
    super(2131493043, new ArrayList());
    this.a = paramContext;
    this.e = paramInt1;
    this.f = paramString;
    this.g = paramDrawable;
    this.h = paramInt2;
    this.d = (this.a.getResources().getDisplayMetrics()).widthPixels;
    this.b = (this.d - DensityUtils.a(this.a, 36.0F)) / this.c;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, VIPCustomSettingBase paramVIPCustomSettingBase) {
    View view = paramBaseViewHolder.d(2131299751);
    GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams)view.getLayoutParams();
    layoutParams.width = (AppInfo.l - DensityUtils.a(this.a, 36.0F)) / 3;
    int i = paramBaseViewHolder.getAdapterPosition();
    if (i != 0 && i != 1 && i != 2) {
      layoutParams.topMargin = DensityUtils.a(this.a, 0.0F);
    } else {
      layoutParams.topMargin = DensityUtils.a(this.a, 10.0F);
    } 
    view.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    view = paramBaseViewHolder.d(2131297706);
    ConstraintLayout.LayoutParams layoutParams1 = (ConstraintLayout.LayoutParams)view.getLayoutParams();
    layoutParams1.width = layoutParams.width;
    layoutParams1.height = layoutParams.width;
    view.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    if (paramVIPCustomSettingBase.lastSelected) {
      paramBaseViewHolder.c(2131297737, true);
    } else {
      paramBaseViewHolder.c(2131297737, false);
    } 
    if (paramVIPCustomSettingBase.selected == 1) {
      paramBaseViewHolder.c(2131297921, true);
    } else {
      paramBaseViewHolder.c(2131297921, false);
    } 
    if (paramBaseViewHolder.getAdapterPosition() == 0) {
      paramBaseViewHolder.a(2131297812, this.g);
    } else {
      ImageLoader.a(null, paramVIPCustomSettingBase.front_cover).a((ImageView)paramBaseViewHolder.d(2131297812));
    } 
    paramBaseViewHolder.a(2131301088, paramVIPCustomSettingBase.name);
    if (paramVIPCustomSettingBase.is_termination == 1) {
      paramBaseViewHolder.c(2131301495, false);
      paramBaseViewHolder.c(2131301389, true);
    } else {
      if (paramVIPCustomSettingBase.isDefault) {
        paramBaseViewHolder.c(2131301495, false);
      } else {
        paramBaseViewHolder.c(2131301495, true);
      } 
      paramBaseViewHolder.c(2131301389, false);
    } 
    if (this.h == 1) {
      paramBaseViewHolder.c(2131297976, true);
      return;
    } 
    paramBaseViewHolder.c(2131297976, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\adapter\VIPCustomSettingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */