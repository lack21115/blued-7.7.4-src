package com.soft.blued.ui.setting.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class SwitchAccountFragment_ViewBinding implements Unbinder {
  private SwitchAccountFragment b;
  
  public SwitchAccountFragment_ViewBinding(SwitchAccountFragment paramSwitchAccountFragment, View paramView) {
    this.b = paramSwitchAccountFragment;
    paramSwitchAccountFragment.top_title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300300, "field 'top_title'", CommonTopTitleNoTrans.class);
    paramSwitchAccountFragment.iv_account_icon_one = (ImageView)Utils.a(paramView, 2131297666, "field 'iv_account_icon_one'", ImageView.class);
    paramSwitchAccountFragment.iv_account_icon_two = (ImageView)Utils.a(paramView, 2131297667, "field 'iv_account_icon_two'", ImageView.class);
    paramSwitchAccountFragment.iv_online_state_one = (ImageView)Utils.a(paramView, 2131297884, "field 'iv_online_state_one'", ImageView.class);
    paramSwitchAccountFragment.iv_online_state_two = (ImageView)Utils.a(paramView, 2131297885, "field 'iv_online_state_two'", ImageView.class);
    paramSwitchAccountFragment.tv_account_nick_one = (TextView)Utils.a(paramView, 2131300481, "field 'tv_account_nick_one'", TextView.class);
    paramSwitchAccountFragment.tv_account_nick_two = (TextView)Utils.a(paramView, 2131300482, "field 'tv_account_nick_two'", TextView.class);
    paramSwitchAccountFragment.tv_online_hint_one = (TextView)Utils.a(paramView, 2131301135, "field 'tv_online_hint_one'", TextView.class);
    paramSwitchAccountFragment.iv_delete_one = (ImageView)Utils.a(paramView, 2131297743, "field 'iv_delete_one'", ImageView.class);
    paramSwitchAccountFragment.iv_delete_two = (ImageView)Utils.a(paramView, 2131297745, "field 'iv_delete_two'", ImageView.class);
    paramSwitchAccountFragment.tv_add_account = (TextView)Utils.a(paramView, 2131300492, "field 'tv_add_account'", TextView.class);
    paramSwitchAccountFragment.tv_management = (TextView)Utils.a(paramView, 2131301024, "field 'tv_management'", TextView.class);
    paramSwitchAccountFragment.tv_management_hint = (TextView)Utils.a(paramView, 2131301025, "field 'tv_management_hint'", TextView.class);
    paramSwitchAccountFragment.tv_has_unread = (ShapeTextView)Utils.a(paramView, 2131300876, "field 'tv_has_unread'", ShapeTextView.class);
  }
  
  public void unbind() {
    SwitchAccountFragment switchAccountFragment = this.b;
    if (switchAccountFragment != null) {
      this.b = null;
      switchAccountFragment.top_title = null;
      switchAccountFragment.iv_account_icon_one = null;
      switchAccountFragment.iv_account_icon_two = null;
      switchAccountFragment.iv_online_state_one = null;
      switchAccountFragment.iv_online_state_two = null;
      switchAccountFragment.tv_account_nick_one = null;
      switchAccountFragment.tv_account_nick_two = null;
      switchAccountFragment.tv_online_hint_one = null;
      switchAccountFragment.iv_delete_one = null;
      switchAccountFragment.iv_delete_two = null;
      switchAccountFragment.tv_add_account = null;
      switchAccountFragment.tv_management = null;
      switchAccountFragment.tv_management_hint = null;
      switchAccountFragment.tv_has_unread = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\SwitchAccountFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */