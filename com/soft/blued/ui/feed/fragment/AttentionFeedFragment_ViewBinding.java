package com.soft.blued.ui.feed.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.customview.FeedSendRecyclerView;
import com.soft.blued.customview.FloatFooterView;

public class AttentionFeedFragment_ViewBinding implements Unbinder {
  private AttentionFeedFragment b;
  
  public AttentionFeedFragment_ViewBinding(AttentionFeedFragment paramAttentionFeedFragment, View paramView) {
    this.b = paramAttentionFeedFragment;
    paramAttentionFeedFragment.rvLiveRecommend = (RecyclerView)Utils.a(paramView, 2131299779, "field 'rvLiveRecommend'", RecyclerView.class);
    paramAttentionFeedFragment.feedSendList = (FeedSendRecyclerView)Utils.a(paramView, 2131297048, "field 'feedSendList'", FeedSendRecyclerView.class);
    paramAttentionFeedFragment.viewSendListCut = Utils.a(paramView, 2131301683, "field 'viewSendListCut'");
    paramAttentionFeedFragment.llLiveRecommend = (LinearLayout)Utils.a(paramView, 2131298921, "field 'llLiveRecommend'", LinearLayout.class);
    paramAttentionFeedFragment.appbar = (AppBarLayout)Utils.a(paramView, 2131296447, "field 'appbar'", AppBarLayout.class);
    paramAttentionFeedFragment.recyclerView = (RecyclerView)Utils.a(paramView, 2131299605, "field 'recyclerView'", RecyclerView.class);
    paramAttentionFeedFragment.coordinator = (CoordinatorLayout)Utils.a(paramView, 2131296843, "field 'coordinator'", CoordinatorLayout.class);
    paramAttentionFeedFragment.refreshLayout = (SmartRefreshLayout)Utils.a(paramView, 2131299616, "field 'refreshLayout'", SmartRefreshLayout.class);
    paramAttentionFeedFragment.llFeedPost = (FloatFooterView)Utils.a(paramView, 2131298800, "field 'llFeedPost'", FloatFooterView.class);
    paramAttentionFeedFragment.keyboardRelativeLayout = (RelativeLayout)Utils.a(paramView, 2131297981, "field 'keyboardRelativeLayout'", RelativeLayout.class);
  }
  
  public void unbind() {
    AttentionFeedFragment attentionFeedFragment = this.b;
    if (attentionFeedFragment != null) {
      this.b = null;
      attentionFeedFragment.rvLiveRecommend = null;
      attentionFeedFragment.feedSendList = null;
      attentionFeedFragment.viewSendListCut = null;
      attentionFeedFragment.llLiveRecommend = null;
      attentionFeedFragment.appbar = null;
      attentionFeedFragment.recyclerView = null;
      attentionFeedFragment.coordinator = null;
      attentionFeedFragment.refreshLayout = null;
      attentionFeedFragment.llFeedPost = null;
      attentionFeedFragment.keyboardRelativeLayout = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\AttentionFeedFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */