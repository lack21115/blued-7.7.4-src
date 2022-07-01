package com.soft.blued.ui.yy_room.fragment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;

public class YYFollowedFragment_ViewBinding implements Unbinder {
  private YYFollowedFragment b;
  
  public YYFollowedFragment_ViewBinding(YYFollowedFragment paramYYFollowedFragment, View paramView) {
    this.b = paramYYFollowedFragment;
    paramYYFollowedFragment.llTitle = (CommonTopTitleNoTrans)Utils.a(paramView, 2131299102, "field 'llTitle'", CommonTopTitleNoTrans.class);
    paramYYFollowedFragment.rvFollowList = (RecyclerView)Utils.a(paramView, 2131299772, "field 'rvFollowList'", RecyclerView.class);
    paramYYFollowedFragment.llNoInternet = (NoDataAndLoadFailView)Utils.a(paramView, 2131298984, "field 'llNoInternet'", NoDataAndLoadFailView.class);
    paramYYFollowedFragment.refreshFollowList = (SmartRefreshLayout)Utils.a(paramView, 2131299614, "field 'refreshFollowList'", SmartRefreshLayout.class);
  }
  
  public void unbind() {
    YYFollowedFragment yYFollowedFragment = this.b;
    if (yYFollowedFragment != null) {
      this.b = null;
      yYFollowedFragment.llTitle = null;
      yYFollowedFragment.rvFollowList = null;
      yYFollowedFragment.llNoInternet = null;
      yYFollowedFragment.refreshFollowList = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\yy_room\fragment\YYFollowedFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */