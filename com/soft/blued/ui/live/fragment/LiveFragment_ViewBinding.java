package com.soft.blued.ui.live.fragment;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.customview.CustomViewPager;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.ui.live.view.LiveListFloatReddishBag;

public class LiveFragment_ViewBinding implements Unbinder {
  private LiveFragment b;
  
  public LiveFragment_ViewBinding(LiveFragment paramLiveFragment, View paramView) {
    this.b = paramLiveFragment;
    paramLiveFragment.mTitle = Utils.a(paramView, 2131300273, "field 'mTitle'");
    paramLiveFragment.mTitleLeft = (ImageView)Utils.a(paramView, 2131296863, "field 'mTitleLeft'", ImageView.class);
    paramLiveFragment.mTitleRight = (ImageView)Utils.a(paramView, 2131296867, "field 'mTitleRight'", ImageView.class);
    paramLiveFragment.mRightNewDot = (ShapeTextView)Utils.a(paramView, 2131297551, "field 'mRightNewDot'", ShapeTextView.class);
    paramLiveFragment.ivRankingRemind = Utils.a(paramView, 2131297532, "field 'ivRankingRemind'");
    paramLiveFragment.mViewPager = (CustomViewPager)Utils.a(paramView, 2131299194, "field 'mViewPager'", CustomViewPager.class);
    paramLiveFragment.indicator = (TabPageIndicatorWithDot)Utils.a(paramView, 2131301725, "field 'indicator'", TabPageIndicatorWithDot.class);
    paramLiveFragment.view_soft = Utils.a(paramView, 2131299994, "field 'view_soft'");
    paramLiveFragment.view_hard = Utils.a(paramView, 2131297355, "field 'view_hard'");
    paramLiveFragment.beauty_open = Utils.a(paramView, 2131296526, "field 'beauty_open'");
    paramLiveFragment.beauty_close = Utils.a(paramView, 2131296523, "field 'beauty_close'");
    paramLiveFragment.mRedBagView = (LiveListFloatReddishBag)Utils.a(paramView, 2131299610, "field 'mRedBagView'", LiveListFloatReddishBag.class);
    paramLiveFragment.fl_floor = Utils.a(paramView, 2131297107, "field 'fl_floor'");
    paramLiveFragment.second_floor = (ImageView)Utils.a(paramView, 2131299876, "field 'second_floor'", ImageView.class);
    paramLiveFragment.fl_two_level_indicate = Utils.a(paramView, 2131297170, "field 'fl_two_level_indicate'");
    paramLiveFragment.iv_two_level_indicate = Utils.a(paramView, 2131297950, "field 'iv_two_level_indicate'");
  }
  
  public void unbind() {
    LiveFragment liveFragment = this.b;
    if (liveFragment != null) {
      this.b = null;
      liveFragment.mTitle = null;
      liveFragment.mTitleLeft = null;
      liveFragment.mTitleRight = null;
      liveFragment.mRightNewDot = null;
      liveFragment.ivRankingRemind = null;
      liveFragment.mViewPager = null;
      liveFragment.indicator = null;
      liveFragment.view_soft = null;
      liveFragment.view_hard = null;
      liveFragment.beauty_open = null;
      liveFragment.beauty_close = null;
      liveFragment.mRedBagView = null;
      liveFragment.fl_floor = null;
      liveFragment.second_floor = null;
      liveFragment.fl_two_level_indicate = null;
      liveFragment.iv_two_level_indicate = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */