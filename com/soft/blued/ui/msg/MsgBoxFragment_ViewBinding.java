package com.soft.blued.ui.msg;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;

public class MsgBoxFragment_ViewBinding implements Unbinder {
  private MsgBoxFragment b;
  
  public MsgBoxFragment_ViewBinding(MsgBoxFragment paramMsgBoxFragment, View paramView) {
    this.b = paramMsgBoxFragment;
    paramMsgBoxFragment.title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300300, "field 'title'", CommonTopTitleNoTrans.class);
    paramMsgBoxFragment.pullRefresh = (RenrenPullToRefreshListView)Utils.a(paramView, 2131297226, "field 'pullRefresh'", RenrenPullToRefreshListView.class);
    paramMsgBoxFragment.nodataview = (NoDataAndLoadFailView)Utils.a(paramView, 2131299395, "field 'nodataview'", NoDataAndLoadFailView.class);
  }
  
  public void unbind() {
    MsgBoxFragment msgBoxFragment = this.b;
    if (msgBoxFragment != null) {
      this.b = null;
      msgBoxFragment.title = null;
      msgBoxFragment.pullRefresh = null;
      msgBoxFragment.nodataview = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\MsgBoxFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */