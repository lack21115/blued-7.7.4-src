package com.soft.blued.ui.circle.fragment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class CircleListFragment_ViewBinding implements Unbinder {
  private CircleListFragment b;
  
  public CircleListFragment_ViewBinding(CircleListFragment paramCircleListFragment, View paramView) {
    this.b = paramCircleListFragment;
    paramCircleListFragment.title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300273, "field 'title'", CommonTopTitleNoTrans.class);
    paramCircleListFragment.circleListView = (RecyclerView)Utils.a(paramView, 2131298136, "field 'circleListView'", RecyclerView.class);
    paramCircleListFragment.refreshLayout = (SmartRefreshLayout)Utils.a(paramView, 2131299616, "field 'refreshLayout'", SmartRefreshLayout.class);
  }
  
  public void unbind() {
    CircleListFragment circleListFragment = this.b;
    if (circleListFragment != null) {
      this.b = null;
      circleListFragment.title = null;
      circleListFragment.circleListView = null;
      circleListFragment.refreshLayout = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleListFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */