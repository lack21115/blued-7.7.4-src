package com.soft.blued.ui.mine.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class MineFragment$VipViewHolder_ViewBinding implements Unbinder {
  private MineFragment.VipViewHolder b;
  
  public MineFragment$VipViewHolder_ViewBinding(MineFragment.VipViewHolder paramVipViewHolder, View paramView) {
    this.b = paramVipViewHolder;
    paramVipViewHolder.icon = (ImageView)Utils.a(paramView, 2131297964, "field 'icon'", ImageView.class);
    paramVipViewHolder.content = (TextView)Utils.a(paramView, 2131300663, "field 'content'", TextView.class);
  }
  
  public void unbind() {
    MineFragment.VipViewHolder vipViewHolder = this.b;
    if (vipViewHolder != null) {
      this.b = null;
      vipViewHolder.icon = null;
      vipViewHolder.content = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\mine\fragment\MineFragment$VipViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */