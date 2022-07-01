package com.soft.blued.ui.live.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.soft.blued.customview.AutoScrollViewPager;
import com.soft.blued.customview.LinePageIndicator;
import com.soft.blued.customview.LiveHotPullToRefreshLayout;
import com.soft.blued.customview.smartrefresh.TwoLevelRefreshView;
import com.soft.blued.ui.live.view.CustomTwoLevelHeader;

public class LiveHomeFragment_ViewBinding implements Unbinder {
  private LiveHomeFragment b;
  
  public LiveHomeFragment_ViewBinding(LiveHomeFragment paramLiveHomeFragment, View paramView) {
    this.b = paramLiveHomeFragment;
    paramLiveHomeFragment.swipe_view = (LiveHotPullToRefreshLayout)Utils.a(paramView, 2131300148, "field 'swipe_view'", LiveHotPullToRefreshLayout.class);
    paramLiveHomeFragment.ll_tab = Utils.a(paramView, 2131299091, "field 'll_tab'");
    paramLiveHomeFragment.refreshLayout = (RefreshLayout)Utils.a(paramView, 2131299613, "field 'refreshLayout'", RefreshLayout.class);
    paramLiveHomeFragment.header = (CustomTwoLevelHeader)Utils.a(paramView, 2131297358, "field 'header'", CustomTwoLevelHeader.class);
    paramLiveHomeFragment.refresh_view = (TwoLevelRefreshView)Utils.a(paramView, 2131299618, "field 'refresh_view'", TwoLevelRefreshView.class);
    paramLiveHomeFragment.asvp_banner_hot_parent = (FrameLayout)Utils.a(paramView, 2131296472, "field 'asvp_banner_hot_parent'", FrameLayout.class);
    paramLiveHomeFragment.asvp_banner_hot_new = (AutoScrollViewPager)Utils.a(paramView, 2131296471, "field 'asvp_banner_hot_new'", AutoScrollViewPager.class);
    paramLiveHomeFragment.lpi_line = (LinePageIndicator)Utils.a(paramView, 2131299176, "field 'lpi_line'", LinePageIndicator.class);
    paramLiveHomeFragment.live_banner = (FrameLayout)Utils.a(paramView, 2131298175, "field 'live_banner'", FrameLayout.class);
    paramLiveHomeFragment.tv_living_count = (TextView)Utils.a(paramView, 2131300996, "field 'tv_living_count'", TextView.class);
    paramLiveHomeFragment.living_count = (ShapeLinearLayout)Utils.a(paramView, 2131298684, "field 'living_count'", ShapeLinearLayout.class);
    paramLiveHomeFragment.ll_live_tips = (LinearLayout)Utils.a(paramView, 2131298924, "field 'll_live_tips'", LinearLayout.class);
    paramLiveHomeFragment.main_live_new_viewpager = (ViewPager)Utils.a(paramView, 2131299193, "field 'main_live_new_viewpager'", ViewPager.class);
    paramLiveHomeFragment.recycle_view_cateroty = (RecyclerView)Utils.a(paramView, 2131299599, "field 'recycle_view_cateroty'", RecyclerView.class);
  }
  
  public void unbind() {
    LiveHomeFragment liveHomeFragment = this.b;
    if (liveHomeFragment != null) {
      this.b = null;
      liveHomeFragment.swipe_view = null;
      liveHomeFragment.ll_tab = null;
      liveHomeFragment.refreshLayout = null;
      liveHomeFragment.header = null;
      liveHomeFragment.refresh_view = null;
      liveHomeFragment.asvp_banner_hot_parent = null;
      liveHomeFragment.asvp_banner_hot_new = null;
      liveHomeFragment.lpi_line = null;
      liveHomeFragment.live_banner = null;
      liveHomeFragment.tv_living_count = null;
      liveHomeFragment.living_count = null;
      liveHomeFragment.ll_live_tips = null;
      liveHomeFragment.main_live_new_viewpager = null;
      liveHomeFragment.recycle_view_cateroty = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveHomeFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */