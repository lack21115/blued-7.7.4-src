package com.soft.blued.ui.user.fragment;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.soft.blued.customview.AutoScrollViewPager;
import com.soft.blued.customview.LinePageIndicator;

public class VIPCenterTabPageFragment$BannerHolder_ViewBinding implements Unbinder {
  private VIPCenterTabPageFragment.BannerHolder b;
  
  public VIPCenterTabPageFragment$BannerHolder_ViewBinding(VIPCenterTabPageFragment.BannerHolder paramBannerHolder, View paramView) {
    this.b = paramBannerHolder;
    paramBannerHolder.bannerViewPager = (AutoScrollViewPager)Utils.a(paramView, 2131296497, "field 'bannerViewPager'", AutoScrollViewPager.class);
    paramBannerHolder.indicator = (LinePageIndicator)Utils.a(paramView, 2131297592, "field 'indicator'", LinePageIndicator.class);
  }
  
  public void unbind() {
    VIPCenterTabPageFragment.BannerHolder bannerHolder = this.b;
    if (bannerHolder != null) {
      this.b = null;
      bannerHolder.bannerViewPager = null;
      bannerHolder.indicator = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\VIPCenterTabPageFragment$BannerHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */