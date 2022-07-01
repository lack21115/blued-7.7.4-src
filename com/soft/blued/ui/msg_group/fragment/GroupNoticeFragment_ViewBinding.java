package com.soft.blued.ui.msg_group.fragment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;

public class GroupNoticeFragment_ViewBinding implements Unbinder {
  private GroupNoticeFragment b;
  
  public GroupNoticeFragment_ViewBinding(GroupNoticeFragment paramGroupNoticeFragment, View paramView) {
    this.b = paramGroupNoticeFragment;
    paramGroupNoticeFragment.title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300273, "field 'title'", CommonTopTitleNoTrans.class);
    paramGroupNoticeFragment.notice_list = (RecyclerView)Utils.a(paramView, 2131299400, "field 'notice_list'", RecyclerView.class);
    paramGroupNoticeFragment.refresh_layout = (SmartRefreshLayout)Utils.a(paramView, 2131299616, "field 'refresh_layout'", SmartRefreshLayout.class);
    paramGroupNoticeFragment.noDataView = (NoDataAndLoadFailView)Utils.a(paramView, 2131299385, "field 'noDataView'", NoDataAndLoadFailView.class);
  }
  
  public void unbind() {
    GroupNoticeFragment groupNoticeFragment = this.b;
    if (groupNoticeFragment != null) {
      this.b = null;
      groupNoticeFragment.title = null;
      groupNoticeFragment.notice_list = null;
      groupNoticeFragment.refresh_layout = null;
      groupNoticeFragment.noDataView = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\fragment\GroupNoticeFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */