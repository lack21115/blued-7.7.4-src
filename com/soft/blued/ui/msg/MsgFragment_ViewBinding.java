package com.soft.blued.ui.msg;

import android.view.View;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.soft.blued.customview.TouchEnableKeyboardLinearLayout;
import com.soft.blued.ui.msg.customview.MsgFilterView;
import com.soft.blued.ui.msg.customview.TranslationAnimHintView;

public class MsgFragment_ViewBinding implements Unbinder {
  private MsgFragment b;
  
  public MsgFragment_ViewBinding(MsgFragment paramMsgFragment, View paramView) {
    this.b = paramMsgFragment;
    paramMsgFragment.keyboardLayout = (TouchEnableKeyboardLinearLayout)Utils.a(paramView, 2131297981, "field 'keyboardLayout'", TouchEnableKeyboardLinearLayout.class);
    paramMsgFragment.cover_view = Utils.a(paramView, 2131296849, "field 'cover_view'");
    paramMsgFragment.msg_filter_guide_iv = Utils.a(paramView, 2131299250, "field 'msg_filter_guide_iv'");
    paramMsgFragment.msgFilterView = (MsgFilterView)Utils.a(paramView, 2131299259, "field 'msgFilterView'", MsgFilterView.class);
    paramMsgFragment.pullRefresh = (RenrenPullToRefreshListView)Utils.a(paramView, 2131299268, "field 'pullRefresh'", RenrenPullToRefreshListView.class);
    paramMsgFragment.rLayout = (RelativeLayout)Utils.a(paramView, 2131299558, "field 'rLayout'", RelativeLayout.class);
    paramMsgFragment.bottom_hint_view = (TranslationAnimHintView)Utils.a(paramView, 2131296552, "field 'bottom_hint_view'", TranslationAnimHintView.class);
  }
  
  public void unbind() {
    MsgFragment msgFragment = this.b;
    if (msgFragment != null) {
      this.b = null;
      msgFragment.keyboardLayout = null;
      msgFragment.cover_view = null;
      msgFragment.msg_filter_guide_iv = null;
      msgFragment.msgFilterView = null;
      msgFragment.pullRefresh = null;
      msgFragment.rLayout = null;
      msgFragment.bottom_hint_view = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\MsgFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */