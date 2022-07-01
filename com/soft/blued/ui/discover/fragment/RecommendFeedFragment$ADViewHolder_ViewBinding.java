package com.soft.blued.ui.discover.fragment;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class RecommendFeedFragment$ADViewHolder_ViewBinding implements Unbinder {
  private RecommendFeedFragment.ADViewHolder b;
  
  public RecommendFeedFragment$ADViewHolder_ViewBinding(RecommendFeedFragment.ADViewHolder paramADViewHolder, View paramView) {
    this.b = paramADViewHolder;
    paramADViewHolder.img_ad = (ImageView)Utils.a(paramView, 2131297419, "field 'img_ad'", ImageView.class);
    paramADViewHolder.img_ad_icon = (ImageView)Utils.a(paramView, 2131297421, "field 'img_ad_icon'", ImageView.class);
  }
  
  public void unbind() {
    RecommendFeedFragment.ADViewHolder aDViewHolder = this.b;
    if (aDViewHolder != null) {
      this.b = null;
      aDViewHolder.img_ad = null;
      aDViewHolder.img_ad_icon = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\fragment\RecommendFeedFragment$ADViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */