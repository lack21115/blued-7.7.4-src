package com.soft.blued.ui.discover.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.customview.AutoScrollViewPager;
import com.soft.blued.customview.FloatFooterView;
import com.soft.blued.customview.LinePageIndicator;
import com.soft.blued.customview.NoDataAndLoadFailView;

public class RecommendFeedFragment_ViewBinding implements Unbinder {
  private RecommendFeedFragment b;
  
  public RecommendFeedFragment_ViewBinding(RecommendFeedFragment paramRecommendFeedFragment, View paramView) {
    this.b = paramRecommendFeedFragment;
    paramRecommendFeedFragment.rlSquare = (RelativeLayout)Utils.a(paramView, 2131299730, "field 'rlSquare'", RelativeLayout.class);
    paramRecommendFeedFragment.appbar = (AppBarLayout)Utils.a(paramView, 2131296447, "field 'appbar'", AppBarLayout.class);
    paramRecommendFeedFragment.flAds = (ConstraintLayout)Utils.a(paramView, 2131297080, "field 'flAds'", ConstraintLayout.class);
    paramRecommendFeedFragment.viewPagerAD = (AutoScrollViewPager)Utils.a(paramView, 2131299443, "field 'viewPagerAD'", AutoScrollViewPager.class);
    paramRecommendFeedFragment.indicator = (LinePageIndicator)Utils.a(paramView, 2131297592, "field 'indicator'", LinePageIndicator.class);
    paramRecommendFeedFragment.llEntry = (LinearLayout)Utils.a(paramView, 2131298787, "field 'llEntry'", LinearLayout.class);
    paramRecommendFeedFragment.lineEntry = Utils.a(paramView, 2131298122, "field 'lineEntry'");
    paramRecommendFeedFragment.noDataView = (NoDataAndLoadFailView)Utils.a(paramView, 2131301664, "field 'noDataView'", NoDataAndLoadFailView.class);
    paramRecommendFeedFragment.mRefreshLayout = (SmartRefreshLayout)Utils.a(paramView, 2131299616, "field 'mRefreshLayout'", SmartRefreshLayout.class);
    paramRecommendFeedFragment.mRecyclerView = (RecyclerView)Utils.a(paramView, 2131299605, "field 'mRecyclerView'", RecyclerView.class);
    paramRecommendFeedFragment.llFeedPost = (FloatFooterView)Utils.a(paramView, 2131298800, "field 'llFeedPost'", FloatFooterView.class);
    paramRecommendFeedFragment.imgGuide = (ImageView)Utils.a(paramView, 2131297488, "field 'imgGuide'", ImageView.class);
  }
  
  public void unbind() {
    RecommendFeedFragment recommendFeedFragment = this.b;
    if (recommendFeedFragment != null) {
      this.b = null;
      recommendFeedFragment.rlSquare = null;
      recommendFeedFragment.appbar = null;
      recommendFeedFragment.flAds = null;
      recommendFeedFragment.viewPagerAD = null;
      recommendFeedFragment.indicator = null;
      recommendFeedFragment.llEntry = null;
      recommendFeedFragment.lineEntry = null;
      recommendFeedFragment.noDataView = null;
      recommendFeedFragment.mRefreshLayout = null;
      recommendFeedFragment.mRecyclerView = null;
      recommendFeedFragment.llFeedPost = null;
      recommendFeedFragment.imgGuide = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\fragment\RecommendFeedFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */