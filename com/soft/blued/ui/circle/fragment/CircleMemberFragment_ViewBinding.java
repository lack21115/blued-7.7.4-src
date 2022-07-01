package com.soft.blued.ui.circle.fragment;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.CustomViewPager;
import com.soft.blued.customview.PageTabLayout;

public class CircleMemberFragment_ViewBinding implements Unbinder {
  private CircleMemberFragment b;
  
  public CircleMemberFragment_ViewBinding(CircleMemberFragment paramCircleMemberFragment, View paramView) {
    this.b = paramCircleMemberFragment;
    paramCircleMemberFragment.topTitle = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300300, "field 'topTitle'", CommonTopTitleNoTrans.class);
    paramCircleMemberFragment.shapeTab = (ShapeTextView)Utils.a(paramView, 2131299938, "field 'shapeTab'", ShapeTextView.class);
    paramCircleMemberFragment.tabLayout = (PageTabLayout)Utils.a(paramView, 2131300167, "field 'tabLayout'", PageTabLayout.class);
    paramCircleMemberFragment.flTabTitle = (FrameLayout)Utils.a(paramView, 2131297163, "field 'flTabTitle'", FrameLayout.class);
    paramCircleMemberFragment.viewPager = (CustomViewPager)Utils.a(paramView, 2131301616, "field 'viewPager'", CustomViewPager.class);
  }
  
  public void unbind() {
    CircleMemberFragment circleMemberFragment = this.b;
    if (circleMemberFragment != null) {
      this.b = null;
      circleMemberFragment.topTitle = null;
      circleMemberFragment.shapeTab = null;
      circleMemberFragment.tabLayout = null;
      circleMemberFragment.flTabTitle = null;
      circleMemberFragment.viewPager = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleMemberFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */