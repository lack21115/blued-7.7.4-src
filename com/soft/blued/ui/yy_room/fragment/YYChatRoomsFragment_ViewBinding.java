package com.soft.blued.ui.yy_room.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.customview.AutoScrollViewPager;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.HorizontalScrollView;
import com.soft.blued.customview.LinePageIndicator;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.VerticalTextView;

public class YYChatRoomsFragment_ViewBinding implements Unbinder {
  private YYChatRoomsFragment b;
  
  public YYChatRoomsFragment_ViewBinding(YYChatRoomsFragment paramYYChatRoomsFragment, View paramView) {
    this.b = paramYYChatRoomsFragment;
    paramYYChatRoomsFragment.topTitle = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300300, "field 'topTitle'", CommonTopTitleNoTrans.class);
    paramYYChatRoomsFragment.rvRoomTabs = (RecyclerView)Utils.a(paramView, 2131300164, "field 'rvRoomTabs'", RecyclerView.class);
    paramYYChatRoomsFragment.refreshLayout = (SmartRefreshLayout)Utils.a(paramView, 2131299616, "field 'refreshLayout'", SmartRefreshLayout.class);
    paramYYChatRoomsFragment.rvFollowList = (RecyclerView)Utils.a(paramView, 2131299772, "field 'rvFollowList'", RecyclerView.class);
    paramYYChatRoomsFragment.llFollowView = (LinearLayout)Utils.a(paramView, 2131298810, "field 'llFollowView'", LinearLayout.class);
    paramYYChatRoomsFragment.tvMoreFollowed = (TextView)Utils.a(paramView, 2131301051, "field 'tvMoreFollowed'", TextView.class);
    paramYYChatRoomsFragment.flLoadingView = (FrameLayout)Utils.a(paramView, 2131297122, "field 'flLoadingView'", FrameLayout.class);
    paramYYChatRoomsFragment.asvpBannerHotNew = (AutoScrollViewPager)Utils.a(paramView, 2131301772, "field 'asvpBannerHotNew'", AutoScrollViewPager.class);
    paramYYChatRoomsFragment.lpiLine = (LinePageIndicator)Utils.a(paramView, 2131301779, "field 'lpiLine'", LinePageIndicator.class);
    paramYYChatRoomsFragment.llRefresh = (LinearLayout)Utils.a(paramView, 2131299045, "field 'llRefresh'", LinearLayout.class);
    paramYYChatRoomsFragment.appbar = (AppBarLayout)Utils.a(paramView, 2131296447, "field 'appbar'", AppBarLayout.class);
    paramYYChatRoomsFragment.rvRoomListVew = (RecyclerView)Utils.a(paramView, 2131299790, "field 'rvRoomListVew'", RecyclerView.class);
    paramYYChatRoomsFragment.tvCreateRoom = (TextView)Utils.a(paramView, 2131300683, "field 'tvCreateRoom'", TextView.class);
    paramYYChatRoomsFragment.tvRandomEnter = (TextView)Utils.a(paramView, 2131301213, "field 'tvRandomEnter'", TextView.class);
    paramYYChatRoomsFragment.llBottomView = (ShapeLinearLayout)Utils.a(paramView, 2131298730, "field 'llBottomView'", ShapeLinearLayout.class);
    paramYYChatRoomsFragment.asvpBannerHotParent = (ConstraintLayout)Utils.a(paramView, 2131301773, "field 'asvpBannerHotParent'", ConstraintLayout.class);
    paramYYChatRoomsFragment.coordinator = (CoordinatorLayout)Utils.a(paramView, 2131296843, "field 'coordinator'", CoordinatorLayout.class);
    paramYYChatRoomsFragment.roomNoDataView = (NoDataAndLoadFailView)Utils.a(paramView, 2131299389, "field 'roomNoDataView'", NoDataAndLoadFailView.class);
    paramYYChatRoomsFragment.scrollView = (HorizontalScrollView)Utils.a(paramView, 2131299842, "field 'scrollView'", HorizontalScrollView.class);
    paramYYChatRoomsFragment.tvFollowedMore = (VerticalTextView)Utils.a(paramView, 2131300780, "field 'tvFollowedMore'", VerticalTextView.class);
    paramYYChatRoomsFragment.flCodeOfCondutLayout = (FrameLayout)Utils.a(paramView, 2131297098, "field 'flCodeOfCondutLayout'", FrameLayout.class);
  }
  
  public void unbind() {
    YYChatRoomsFragment yYChatRoomsFragment = this.b;
    if (yYChatRoomsFragment != null) {
      this.b = null;
      yYChatRoomsFragment.topTitle = null;
      yYChatRoomsFragment.rvRoomTabs = null;
      yYChatRoomsFragment.refreshLayout = null;
      yYChatRoomsFragment.rvFollowList = null;
      yYChatRoomsFragment.llFollowView = null;
      yYChatRoomsFragment.tvMoreFollowed = null;
      yYChatRoomsFragment.flLoadingView = null;
      yYChatRoomsFragment.asvpBannerHotNew = null;
      yYChatRoomsFragment.lpiLine = null;
      yYChatRoomsFragment.llRefresh = null;
      yYChatRoomsFragment.appbar = null;
      yYChatRoomsFragment.rvRoomListVew = null;
      yYChatRoomsFragment.tvCreateRoom = null;
      yYChatRoomsFragment.tvRandomEnter = null;
      yYChatRoomsFragment.llBottomView = null;
      yYChatRoomsFragment.asvpBannerHotParent = null;
      yYChatRoomsFragment.coordinator = null;
      yYChatRoomsFragment.roomNoDataView = null;
      yYChatRoomsFragment.scrollView = null;
      yYChatRoomsFragment.tvFollowedMore = null;
      yYChatRoomsFragment.flCodeOfCondutLayout = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\yy_room\fragment\YYChatRoomsFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */