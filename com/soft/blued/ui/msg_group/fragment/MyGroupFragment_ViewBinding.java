package com.soft.blued.ui.msg_group.fragment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;

public class MyGroupFragment_ViewBinding implements Unbinder {
  private MyGroupFragment b;
  
  public MyGroupFragment_ViewBinding(MyGroupFragment paramMyGroupFragment, View paramView) {
    this.b = paramMyGroupFragment;
    paramMyGroupFragment.title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300273, "field 'title'", CommonTopTitleNoTrans.class);
    paramMyGroupFragment.group_list = (RecyclerView)Utils.a(paramView, 2131297296, "field 'group_list'", RecyclerView.class);
    paramMyGroupFragment.noDataView = (NoDataAndLoadFailView)Utils.a(paramView, 2131299385, "field 'noDataView'", NoDataAndLoadFailView.class);
    paramMyGroupFragment.refresh_layout = (SmartRefreshLayout)Utils.a(paramView, 2131299616, "field 'refresh_layout'", SmartRefreshLayout.class);
  }
  
  public void unbind() {
    MyGroupFragment myGroupFragment = this.b;
    if (myGroupFragment != null) {
      this.b = null;
      myGroupFragment.title = null;
      myGroupFragment.group_list = null;
      myGroupFragment.noDataView = null;
      myGroupFragment.refresh_layout = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\fragment\MyGroupFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */