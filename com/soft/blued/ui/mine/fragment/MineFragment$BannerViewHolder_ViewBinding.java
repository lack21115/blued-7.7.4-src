package com.soft.blued.ui.mine.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class MineFragment$BannerViewHolder_ViewBinding implements Unbinder {
  private MineFragment.BannerViewHolder b;
  
  public MineFragment$BannerViewHolder_ViewBinding(MineFragment.BannerViewHolder paramBannerViewHolder, View paramView) {
    this.b = paramBannerViewHolder;
    paramBannerViewHolder.title = (TextView)Utils.a(paramView, 2131300490, "field 'title'", TextView.class);
    paramBannerViewHolder.content = (TextView)Utils.a(paramView, 2131300488, "field 'content'", TextView.class);
  }
  
  public void unbind() {
    MineFragment.BannerViewHolder bannerViewHolder = this.b;
    if (bannerViewHolder != null) {
      this.b = null;
      bannerViewHolder.title = null;
      bannerViewHolder.content = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\mine\fragment\MineFragment$BannerViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */