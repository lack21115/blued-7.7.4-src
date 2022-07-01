package com.soft.blued.ui.circle.fragment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class CircleJoinMemberFragment_ViewBinding implements Unbinder {
  private CircleJoinMemberFragment b;
  
  public CircleJoinMemberFragment_ViewBinding(CircleJoinMemberFragment paramCircleJoinMemberFragment, View paramView) {
    this.b = paramCircleJoinMemberFragment;
    paramCircleJoinMemberFragment.recyclerView = (RecyclerView)Utils.a(paramView, 2131299605, "field 'recyclerView'", RecyclerView.class);
    paramCircleJoinMemberFragment.refreshLayout = (SmartRefreshLayout)Utils.a(paramView, 2131299616, "field 'refreshLayout'", SmartRefreshLayout.class);
  }
  
  public void unbind() {
    CircleJoinMemberFragment circleJoinMemberFragment = this.b;
    if (circleJoinMemberFragment != null) {
      this.b = null;
      circleJoinMemberFragment.recyclerView = null;
      circleJoinMemberFragment.refreshLayout = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleJoinMemberFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */