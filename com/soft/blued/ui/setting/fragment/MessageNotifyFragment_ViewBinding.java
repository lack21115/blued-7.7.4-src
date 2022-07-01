package com.soft.blued.ui.setting.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ToggleButton;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class MessageNotifyFragment_ViewBinding implements Unbinder {
  private MessageNotifyFragment b;
  
  public MessageNotifyFragment_ViewBinding(MessageNotifyFragment paramMessageNotifyFragment, View paramView) {
    this.b = paramMessageNotifyFragment;
    paramMessageNotifyFragment.topTitle = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300300, "field 'topTitle'", CommonTopTitleNoTrans.class);
    paramMessageNotifyFragment.llMessageMobileLogin = (LinearLayout)Utils.a(paramView, 2131298950, "field 'llMessageMobileLogin'", LinearLayout.class);
    paramMessageNotifyFragment.llMessageCommonLogin = (LinearLayout)Utils.a(paramView, 2131298949, "field 'llMessageCommonLogin'", LinearLayout.class);
    paramMessageNotifyFragment.tbMessageMobileLogin = (ToggleButton)Utils.a(paramView, 2131300187, "field 'tbMessageMobileLogin'", ToggleButton.class);
    paramMessageNotifyFragment.tbMessageCommonLogin = (ToggleButton)Utils.a(paramView, 2131300186, "field 'tbMessageCommonLogin'", ToggleButton.class);
  }
  
  public void unbind() {
    MessageNotifyFragment messageNotifyFragment = this.b;
    if (messageNotifyFragment != null) {
      this.b = null;
      messageNotifyFragment.topTitle = null;
      messageNotifyFragment.llMessageMobileLogin = null;
      messageNotifyFragment.llMessageCommonLogin = null;
      messageNotifyFragment.tbMessageMobileLogin = null;
      messageNotifyFragment.tbMessageCommonLogin = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\MessageNotifyFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */