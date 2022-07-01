package com.soft.blued.ui.find.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.smartrefresh.TwoLevelNearbyRefreshView;
import com.soft.blued.ui.find.view.NearbyChatRoomView;
import com.soft.blued.ui.find.view.RecommendViewMixedInNearby;
import com.soft.blued.ui.live.view.CustomTwoLevelHeader;

public class NearbyPeopleFragment_ViewBinding implements Unbinder {
  private NearbyPeopleFragment b;
  
  public NearbyPeopleFragment_ViewBinding(NearbyPeopleFragment paramNearbyPeopleFragment, View paramView) {
    this.b = paramNearbyPeopleFragment;
    paramNearbyPeopleFragment.mRefreshLayout = (SmartRefreshLayout)Utils.a(paramView, 2131299616, "field 'mRefreshLayout'", SmartRefreshLayout.class);
    paramNearbyPeopleFragment.mRecyclerView = (RecyclerView)Utils.a(paramView, 2131299605, "field 'mRecyclerView'", RecyclerView.class);
    paramNearbyPeopleFragment.tabBar = (LinearLayout)Utils.a(paramView, 2131300164, "field 'tabBar'", LinearLayout.class);
    paramNearbyPeopleFragment.sortTabBar = (LinearLayout)Utils.a(paramView, 2131299997, "field 'sortTabBar'", LinearLayout.class);
    paramNearbyPeopleFragment.layoutFilterReset = (LinearLayout)Utils.a(paramView, 2131298062, "field 'layoutFilterReset'", LinearLayout.class);
    paramNearbyPeopleFragment.stvFilterReset = (ShapeTextView)Utils.a(paramView, 2131300092, "field 'stvFilterReset'", ShapeTextView.class);
    paramNearbyPeopleFragment.mRecommendViewMixedInNearby = (RecommendViewMixedInNearby)Utils.a(paramView, 2131299587, "field 'mRecommendViewMixedInNearby'", RecommendViewMixedInNearby.class);
    paramNearbyPeopleFragment.mCallBtn = (RelativeLayout)Utils.a(paramView, 2131299690, "field 'mCallBtn'", RelativeLayout.class);
    paramNearbyPeopleFragment.mCallBtnState = (RelativeLayout)Utils.a(paramView, 2131299692, "field 'mCallBtnState'", RelativeLayout.class);
    paramNearbyPeopleFragment.rl_location_root = (RelativeLayout)Utils.a(paramView, 2131299717, "field 'rl_location_root'", RelativeLayout.class);
    paramNearbyPeopleFragment.iv_icon = (ImageView)Utils.a(paramView, 2131297804, "field 'iv_icon'", ImageView.class);
    paramNearbyPeopleFragment.iv_close = (ImageView)Utils.a(paramView, 2131297729, "field 'iv_close'", ImageView.class);
    paramNearbyPeopleFragment.tv_distance = (TextView)Utils.a(paramView, 2131300715, "field 'tv_distance'", TextView.class);
    paramNearbyPeopleFragment.tv_location = (TextView)Utils.a(paramView, 2131300998, "field 'tv_location'", TextView.class);
    paramNearbyPeopleFragment.appbar = (AppBarLayout)Utils.a(paramView, 2131296447, "field 'appbar'", AppBarLayout.class);
    paramNearbyPeopleFragment.header = (CustomTwoLevelHeader)Utils.a(paramView, 2131297358, "field 'header'", CustomTwoLevelHeader.class);
    paramNearbyPeopleFragment.refresh_view = (TwoLevelNearbyRefreshView)Utils.a(paramView, 2131299618, "field 'refresh_view'", TwoLevelNearbyRefreshView.class);
    paramNearbyPeopleFragment.llRefresh = (LinearLayout)Utils.a(paramView, 2131299045, "field 'llRefresh'", LinearLayout.class);
    paramNearbyPeopleFragment.flBanner = (FrameLayout)Utils.a(paramView, 2131297089, "field 'flBanner'", FrameLayout.class);
    paramNearbyPeopleFragment.nearbyChatRoomView = (NearbyChatRoomView)Utils.a(paramView, 2131299361, "field 'nearbyChatRoomView'", NearbyChatRoomView.class);
    paramNearbyPeopleFragment.noDataAndLoadFailView = (NoDataAndLoadFailView)Utils.a(paramView, 2131299395, "field 'noDataAndLoadFailView'", NoDataAndLoadFailView.class);
  }
  
  public void unbind() {
    NearbyPeopleFragment nearbyPeopleFragment = this.b;
    if (nearbyPeopleFragment != null) {
      this.b = null;
      nearbyPeopleFragment.mRefreshLayout = null;
      nearbyPeopleFragment.mRecyclerView = null;
      nearbyPeopleFragment.tabBar = null;
      nearbyPeopleFragment.sortTabBar = null;
      nearbyPeopleFragment.layoutFilterReset = null;
      nearbyPeopleFragment.stvFilterReset = null;
      nearbyPeopleFragment.mRecommendViewMixedInNearby = null;
      nearbyPeopleFragment.mCallBtn = null;
      nearbyPeopleFragment.mCallBtnState = null;
      nearbyPeopleFragment.rl_location_root = null;
      nearbyPeopleFragment.iv_icon = null;
      nearbyPeopleFragment.iv_close = null;
      nearbyPeopleFragment.tv_distance = null;
      nearbyPeopleFragment.tv_location = null;
      nearbyPeopleFragment.appbar = null;
      nearbyPeopleFragment.header = null;
      nearbyPeopleFragment.refresh_view = null;
      nearbyPeopleFragment.llRefresh = null;
      nearbyPeopleFragment.flBanner = null;
      nearbyPeopleFragment.nearbyChatRoomView = null;
      nearbyPeopleFragment.noDataAndLoadFailView = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\NearbyPeopleFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */