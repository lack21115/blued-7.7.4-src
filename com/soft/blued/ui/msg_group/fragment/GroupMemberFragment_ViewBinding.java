package com.soft.blued.ui.msg_group.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;

public class GroupMemberFragment_ViewBinding implements Unbinder {
  private GroupMemberFragment b;
  
  public GroupMemberFragment_ViewBinding(GroupMemberFragment paramGroupMemberFragment, View paramView) {
    this.b = paramGroupMemberFragment;
    paramGroupMemberFragment.ctt_left_img = (ImageView)Utils.a(paramView, 2131296865, "field 'ctt_left_img'", ImageView.class);
    paramGroupMemberFragment.iv_delete = (ImageView)Utils.a(paramView, 2131297741, "field 'iv_delete'", ImageView.class);
    paramGroupMemberFragment.iv_sort = (ImageView)Utils.a(paramView, 2131297924, "field 'iv_sort'", ImageView.class);
    paramGroupMemberFragment.mListViewWrapper = (RenrenPullToRefreshListView)Utils.a(paramView, 2131299213, "field 'mListViewWrapper'", RenrenPullToRefreshListView.class);
    paramGroupMemberFragment.frame_layout = (FrameLayout)Utils.a(paramView, 2131297224, "field 'frame_layout'", FrameLayout.class);
    paramGroupMemberFragment.rl_bottom = (RelativeLayout)Utils.a(paramView, 2131299689, "field 'rl_bottom'", RelativeLayout.class);
    paramGroupMemberFragment.tv_delete = (TextView)Utils.a(paramView, 2131300702, "field 'tv_delete'", TextView.class);
  }
  
  public void unbind() {
    GroupMemberFragment groupMemberFragment = this.b;
    if (groupMemberFragment != null) {
      this.b = null;
      groupMemberFragment.ctt_left_img = null;
      groupMemberFragment.iv_delete = null;
      groupMemberFragment.iv_sort = null;
      groupMemberFragment.mListViewWrapper = null;
      groupMemberFragment.frame_layout = null;
      groupMemberFragment.rl_bottom = null;
      groupMemberFragment.tv_delete = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\fragment\GroupMemberFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */