package com.soft.blued.ui.find.fragment;

import android.view.View;
import android.widget.ViewFlipper;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.customview.FloatFooterView;

public class NearbyFeedFragment_ViewBinding implements Unbinder {
  private NearbyFeedFragment b;
  
  public NearbyFeedFragment_ViewBinding(NearbyFeedFragment paramNearbyFeedFragment, View paramView) {
    this.b = paramNearbyFeedFragment;
    paramNearbyFeedFragment.mRecyclerView = (RecyclerView)Utils.a(paramView, 2131299605, "field 'mRecyclerView'", RecyclerView.class);
    paramNearbyFeedFragment.mRefreshLayout = (SmartRefreshLayout)Utils.a(paramView, 2131299616, "field 'mRefreshLayout'", SmartRefreshLayout.class);
    paramNearbyFeedFragment.llFeedPost = (FloatFooterView)Utils.a(paramView, 2131298800, "field 'llFeedPost'", FloatFooterView.class);
    paramNearbyFeedFragment.vfFeedOperate = (ViewFlipper)Utils.a(paramView, 2131301590, "field 'vfFeedOperate'", ViewFlipper.class);
    paramNearbyFeedFragment.appbar = (AppBarLayout)Utils.a(paramView, 2131296447, "field 'appbar'", AppBarLayout.class);
  }
  
  public void unbind() {
    NearbyFeedFragment nearbyFeedFragment = this.b;
    if (nearbyFeedFragment != null) {
      this.b = null;
      nearbyFeedFragment.mRecyclerView = null;
      nearbyFeedFragment.mRefreshLayout = null;
      nearbyFeedFragment.llFeedPost = null;
      nearbyFeedFragment.vfFeedOperate = null;
      nearbyFeedFragment.appbar = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\NearbyFeedFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */