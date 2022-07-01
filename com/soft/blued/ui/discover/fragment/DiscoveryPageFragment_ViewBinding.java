package com.soft.blued.ui.discover.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.customview.CustomViewPager;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.customview.bluedad.BluedADConstraintLayout;

public class DiscoveryPageFragment_ViewBinding implements Unbinder {
  private DiscoveryPageFragment b;
  
  public DiscoveryPageFragment_ViewBinding(DiscoveryPageFragment paramDiscoveryPageFragment, View paramView) {
    this.b = paramDiscoveryPageFragment;
    paramDiscoveryPageFragment.vpIndicator = (TabPageIndicatorWithDot)Utils.a(paramView, 2131301725, "field 'vpIndicator'", TabPageIndicatorWithDot.class);
    paramDiscoveryPageFragment.title = Utils.a(paramView, 2131300273, "field 'title'");
    paramDiscoveryPageFragment.cttLeft = (ImageView)Utils.a(paramView, 2131296863, "field 'cttLeft'", ImageView.class);
    paramDiscoveryPageFragment.imgNewRemindVisitor = (ShapeTextView)Utils.a(paramView, 2131297532, "field 'imgNewRemindVisitor'", ShapeTextView.class);
    paramDiscoveryPageFragment.cttRightText = (TextView)Utils.a(paramView, 2131296871, "field 'cttRightText'", TextView.class);
    paramDiscoveryPageFragment.imgNearbyAd = (ImageView)Utils.a(paramView, 2131297530, "field 'imgNearbyAd'", ImageView.class);
    paramDiscoveryPageFragment.bluedAdLayout = (BluedADConstraintLayout)Utils.a(paramView, 2131296537, "field 'bluedAdLayout'", BluedADConstraintLayout.class);
    paramDiscoveryPageFragment.cttRight = (ImageView)Utils.a(paramView, 2131296867, "field 'cttRight'", ImageView.class);
    paramDiscoveryPageFragment.imgRightNewDot = (ShapeTextView)Utils.a(paramView, 2131297551, "field 'imgRightNewDot'", ShapeTextView.class);
    paramDiscoveryPageFragment.cttRightMenu = (FrameLayout)Utils.a(paramView, 2131296869, "field 'cttRightMenu'", FrameLayout.class);
    paramDiscoveryPageFragment.viewPager = (CustomViewPager)Utils.a(paramView, 2131301672, "field 'viewPager'", CustomViewPager.class);
    paramDiscoveryPageFragment.findBadgeContainer = (QBadgeContainer)Utils.a(paramView, 2131297060, "field 'findBadgeContainer'", QBadgeContainer.class);
  }
  
  public void unbind() {
    DiscoveryPageFragment discoveryPageFragment = this.b;
    if (discoveryPageFragment != null) {
      this.b = null;
      discoveryPageFragment.vpIndicator = null;
      discoveryPageFragment.title = null;
      discoveryPageFragment.cttLeft = null;
      discoveryPageFragment.imgNewRemindVisitor = null;
      discoveryPageFragment.cttRightText = null;
      discoveryPageFragment.imgNearbyAd = null;
      discoveryPageFragment.bluedAdLayout = null;
      discoveryPageFragment.cttRight = null;
      discoveryPageFragment.imgRightNewDot = null;
      discoveryPageFragment.cttRightMenu = null;
      discoveryPageFragment.viewPager = null;
      discoveryPageFragment.findBadgeContainer = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\fragment\DiscoveryPageFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */