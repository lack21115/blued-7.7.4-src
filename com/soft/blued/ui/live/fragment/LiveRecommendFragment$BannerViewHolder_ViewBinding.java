package com.soft.blued.ui.live.fragment;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class LiveRecommendFragment$BannerViewHolder_ViewBinding implements Unbinder {
  private LiveRecommendFragment.BannerViewHolder b;
  
  public LiveRecommendFragment$BannerViewHolder_ViewBinding(LiveRecommendFragment.BannerViewHolder paramBannerViewHolder, View paramView) {
    this.b = paramBannerViewHolder;
    paramBannerViewHolder.aariv_banner = (ImageView)Utils.a(paramView, 2131296339, "field 'aariv_banner'", ImageView.class);
  }
  
  public void unbind() {
    LiveRecommendFragment.BannerViewHolder bannerViewHolder = this.b;
    if (bannerViewHolder != null) {
      this.b = null;
      bannerViewHolder.aariv_banner = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveRecommendFragment$BannerViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */