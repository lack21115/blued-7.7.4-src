package com.soft.blued.ui.msg;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class MsgFragment$MenuViewHolder_ViewBinding implements Unbinder {
  private MsgFragment.MenuViewHolder b;
  
  public MsgFragment$MenuViewHolder_ViewBinding(MsgFragment.MenuViewHolder paramMenuViewHolder, View paramView) {
    this.b = paramMenuViewHolder;
    paramMenuViewHolder.tv_item0 = (RelativeLayout)Utils.a(paramView, 2131300927, "field 'tv_item0'", RelativeLayout.class);
    paramMenuViewHolder.tv_item1 = (TextView)Utils.a(paramView, 2131300928, "field 'tv_item1'", TextView.class);
    paramMenuViewHolder.tv_item2 = (TextView)Utils.a(paramView, 2131300929, "field 'tv_item2'", TextView.class);
    paramMenuViewHolder.tv_item3 = (TextView)Utils.a(paramView, 2131300930, "field 'tv_item3'", TextView.class);
    paramMenuViewHolder.tv_item4 = (TextView)Utils.a(paramView, 2131300931, "field 'tv_item4'", TextView.class);
    paramMenuViewHolder.lay_item4 = (RelativeLayout)Utils.a(paramView, 2131298009, "field 'lay_item4'", RelativeLayout.class);
    paramMenuViewHolder.iv_msg_box_red_point = (ImageView)Utils.a(paramView, 2131297864, "field 'iv_msg_box_red_point'", ImageView.class);
  }
  
  public void unbind() {
    MsgFragment.MenuViewHolder menuViewHolder = this.b;
    if (menuViewHolder != null) {
      this.b = null;
      menuViewHolder.tv_item0 = null;
      menuViewHolder.tv_item1 = null;
      menuViewHolder.tv_item2 = null;
      menuViewHolder.tv_item3 = null;
      menuViewHolder.tv_item4 = null;
      menuViewHolder.lay_item4 = null;
      menuViewHolder.iv_msg_box_red_point = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\MsgFragment$MenuViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */