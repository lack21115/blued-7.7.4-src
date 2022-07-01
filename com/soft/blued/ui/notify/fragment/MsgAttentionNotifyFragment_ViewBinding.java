package com.soft.blued.ui.notify.fragment;

import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;

public class MsgAttentionNotifyFragment_ViewBinding implements Unbinder {
  private MsgAttentionNotifyFragment b;
  
  public MsgAttentionNotifyFragment_ViewBinding(MsgAttentionNotifyFragment paramMsgAttentionNotifyFragment, View paramView) {
    this.b = paramMsgAttentionNotifyFragment;
    paramMsgAttentionNotifyFragment.lv_friend = (ListView)Utils.a(paramView, 2131299400, "field 'lv_friend'", ListView.class);
    paramMsgAttentionNotifyFragment.topTitle = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300300, "field 'topTitle'", CommonTopTitleNoTrans.class);
    paramMsgAttentionNotifyFragment.llNodataChats = (NoDataAndLoadFailView)Utils.a(paramView, 2131298988, "field 'llNodataChats'", NoDataAndLoadFailView.class);
    paramMsgAttentionNotifyFragment.msgFrientPullrefresh = (SmartRefreshLayout)Utils.a(paramView, 2131299268, "field 'msgFrientPullrefresh'", SmartRefreshLayout.class);
  }
  
  public void unbind() {
    MsgAttentionNotifyFragment msgAttentionNotifyFragment = this.b;
    if (msgAttentionNotifyFragment != null) {
      this.b = null;
      msgAttentionNotifyFragment.lv_friend = null;
      msgAttentionNotifyFragment.topTitle = null;
      msgAttentionNotifyFragment.llNodataChats = null;
      msgAttentionNotifyFragment.msgFrientPullrefresh = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\notify\fragment\MsgAttentionNotifyFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */