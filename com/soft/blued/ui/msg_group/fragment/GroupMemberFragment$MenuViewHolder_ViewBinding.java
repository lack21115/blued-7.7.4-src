package com.soft.blued.ui.msg_group.fragment;

import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class GroupMemberFragment$MenuViewHolder_ViewBinding implements Unbinder {
  private GroupMemberFragment.MenuViewHolder b;
  
  public GroupMemberFragment$MenuViewHolder_ViewBinding(GroupMemberFragment.MenuViewHolder paramMenuViewHolder, View paramView) {
    this.b = paramMenuViewHolder;
    paramMenuViewHolder.checkbox0 = (CheckBox)Utils.a(paramView, 2131296731, "field 'checkbox0'", CheckBox.class);
    paramMenuViewHolder.checkbox1 = (CheckBox)Utils.a(paramView, 2131296732, "field 'checkbox1'", CheckBox.class);
    paramMenuViewHolder.checkbox2 = (CheckBox)Utils.a(paramView, 2131296733, "field 'checkbox2'", CheckBox.class);
    paramMenuViewHolder.rl_item0 = (RelativeLayout)Utils.a(paramView, 2131299713, "field 'rl_item0'", RelativeLayout.class);
    paramMenuViewHolder.rl_item1 = (RelativeLayout)Utils.a(paramView, 2131299714, "field 'rl_item1'", RelativeLayout.class);
    paramMenuViewHolder.rl_item2 = (RelativeLayout)Utils.a(paramView, 2131299715, "field 'rl_item2'", RelativeLayout.class);
  }
  
  public void unbind() {
    GroupMemberFragment.MenuViewHolder menuViewHolder = this.b;
    if (menuViewHolder != null) {
      this.b = null;
      menuViewHolder.checkbox0 = null;
      menuViewHolder.checkbox1 = null;
      menuViewHolder.checkbox2 = null;
      menuViewHolder.rl_item0 = null;
      menuViewHolder.rl_item1 = null;
      menuViewHolder.rl_item2 = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\fragment\GroupMemberFragment$MenuViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */