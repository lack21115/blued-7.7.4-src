package com.soft.blued.ui.find.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.customview.NearbyHomeViewPager;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.customview.bluedad.BluedADConstraintLayout;

public class NearbyHomeFragment_ViewBinding implements Unbinder {
  private NearbyHomeFragment b;
  
  public NearbyHomeFragment_ViewBinding(NearbyHomeFragment paramNearbyHomeFragment, View paramView) {
    this.b = paramNearbyHomeFragment;
    paramNearbyHomeFragment.second_floor = (ImageView)Utils.a(paramView, 2131299876, "field 'second_floor'", ImageView.class);
    paramNearbyHomeFragment.fl_floor = (FrameLayout)Utils.a(paramView, 2131297107, "field 'fl_floor'", FrameLayout.class);
    paramNearbyHomeFragment.indicatorTitle = (TabPageIndicatorWithDot)Utils.a(paramView, 2131301725, "field 'indicatorTitle'", TabPageIndicatorWithDot.class);
    paramNearbyHomeFragment.mTitleLeft = (ImageView)Utils.a(paramView, 2131296863, "field 'mTitleLeft'", ImageView.class);
    paramNearbyHomeFragment.imgNewRemindVisitor = (ShapeTextView)Utils.a(paramView, 2131297532, "field 'imgNewRemindVisitor'", ShapeTextView.class);
    paramNearbyHomeFragment.mTitleRightText = (TextView)Utils.a(paramView, 2131296871, "field 'mTitleRightText'", TextView.class);
    paramNearbyHomeFragment.mTitleRight = (ImageView)Utils.a(paramView, 2131296867, "field 'mTitleRight'", ImageView.class);
    paramNearbyHomeFragment.mTitleRightDot = (ShapeTextView)Utils.a(paramView, 2131297551, "field 'mTitleRightDot'", ShapeTextView.class);
    paramNearbyHomeFragment.mTitleRightMenu = (FrameLayout)Utils.a(paramView, 2131296869, "field 'mTitleRightMenu'", FrameLayout.class);
    paramNearbyHomeFragment.mViewPager = (NearbyHomeViewPager)Utils.a(paramView, 2131299192, "field 'mViewPager'", NearbyHomeViewPager.class);
    paramNearbyHomeFragment.tvTip = (TextView)Utils.a(paramView, 2131301393, "field 'tvTip'", TextView.class);
    paramNearbyHomeFragment.mTitle = Utils.a(paramView, 2131300273, "field 'mTitle'");
    paramNearbyHomeFragment.adConstraintLayout = (BluedADConstraintLayout)Utils.a(paramView, 2131296537, "field 'adConstraintLayout'", BluedADConstraintLayout.class);
    paramNearbyHomeFragment.adNearbyImg = (ImageView)Utils.a(paramView, 2131297530, "field 'adNearbyImg'", ImageView.class);
    paramNearbyHomeFragment.nearbyActivityTip = (TextView)Utils.a(paramView, 2131299360, "field 'nearbyActivityTip'", TextView.class);
  }
  
  public void unbind() {
    NearbyHomeFragment nearbyHomeFragment = this.b;
    if (nearbyHomeFragment != null) {
      this.b = null;
      nearbyHomeFragment.second_floor = null;
      nearbyHomeFragment.fl_floor = null;
      nearbyHomeFragment.indicatorTitle = null;
      nearbyHomeFragment.mTitleLeft = null;
      nearbyHomeFragment.imgNewRemindVisitor = null;
      nearbyHomeFragment.mTitleRightText = null;
      nearbyHomeFragment.mTitleRight = null;
      nearbyHomeFragment.mTitleRightDot = null;
      nearbyHomeFragment.mTitleRightMenu = null;
      nearbyHomeFragment.mViewPager = null;
      nearbyHomeFragment.tvTip = null;
      nearbyHomeFragment.mTitle = null;
      nearbyHomeFragment.adConstraintLayout = null;
      nearbyHomeFragment.adNearbyImg = null;
      nearbyHomeFragment.nearbyActivityTip = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\NearbyHomeFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */