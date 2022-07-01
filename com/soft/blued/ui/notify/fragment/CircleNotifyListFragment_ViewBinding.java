package com.soft.blued.ui.notify.fragment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class CircleNotifyListFragment_ViewBinding implements Unbinder {
  private CircleNotifyListFragment b;
  
  public CircleNotifyListFragment_ViewBinding(CircleNotifyListFragment paramCircleNotifyListFragment, View paramView) {
    this.b = paramCircleNotifyListFragment;
    paramCircleNotifyListFragment.title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300273, "field 'title'", CommonTopTitleNoTrans.class);
    paramCircleNotifyListFragment.recyclerView = (RecyclerView)Utils.a(paramView, 2131299605, "field 'recyclerView'", RecyclerView.class);
    paramCircleNotifyListFragment.refreshLayout = (SmartRefreshLayout)Utils.a(paramView, 2131299616, "field 'refreshLayout'", SmartRefreshLayout.class);
  }
  
  public void unbind() {
    CircleNotifyListFragment circleNotifyListFragment = this.b;
    if (circleNotifyListFragment != null) {
      this.b = null;
      circleNotifyListFragment.title = null;
      circleNotifyListFragment.recyclerView = null;
      circleNotifyListFragment.refreshLayout = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\notify\fragment\CircleNotifyListFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */