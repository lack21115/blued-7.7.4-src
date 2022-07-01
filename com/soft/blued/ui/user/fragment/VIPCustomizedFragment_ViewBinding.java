package com.soft.blued.ui.user.fragment;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.LabeledTextView;

public class VIPCustomizedFragment_ViewBinding implements Unbinder {
  private VIPCustomizedFragment b;
  
  public VIPCustomizedFragment_ViewBinding(VIPCustomizedFragment paramVIPCustomizedFragment, View paramView) {
    this.b = paramVIPCustomizedFragment;
    paramVIPCustomizedFragment.title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300273, "field 'title'", CommonTopTitleNoTrans.class);
    paramVIPCustomizedFragment.viewBubble = (LabeledTextView)Utils.a(paramView, 2131301628, "field 'viewBubble'", LabeledTextView.class);
    paramVIPCustomizedFragment.viewChatBg = (LabeledTextView)Utils.a(paramView, 2131301630, "field 'viewChatBg'", LabeledTextView.class);
    paramVIPCustomizedFragment.viewFeedBg = (LabeledTextView)Utils.a(paramView, 2131301647, "field 'viewFeedBg'", LabeledTextView.class);
    paramVIPCustomizedFragment.viewAppIcon = (LabeledTextView)Utils.a(paramView, 2131301620, "field 'viewAppIcon'", LabeledTextView.class);
    paramVIPCustomizedFragment.viewWidget = (LabeledTextView)Utils.a(paramView, 2131301695, "field 'viewWidget'", LabeledTextView.class);
  }
  
  public void unbind() {
    VIPCustomizedFragment vIPCustomizedFragment = this.b;
    if (vIPCustomizedFragment != null) {
      this.b = null;
      vIPCustomizedFragment.title = null;
      vIPCustomizedFragment.viewBubble = null;
      vIPCustomizedFragment.viewChatBg = null;
      vIPCustomizedFragment.viewFeedBg = null;
      vIPCustomizedFragment.viewAppIcon = null;
      vIPCustomizedFragment.viewWidget = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\VIPCustomizedFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */