package com.soft.blued.ui.msg;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class MsgFragment$HelloHeaderHolder_ViewBinding implements Unbinder {
  private MsgFragment.HelloHeaderHolder b;
  
  public MsgFragment$HelloHeaderHolder_ViewBinding(MsgFragment.HelloHeaderHolder paramHelloHeaderHolder, View paramView) {
    this.b = paramHelloHeaderHolder;
    paramHelloHeaderHolder.tv_call_me_btn = (TextView)Utils.a(paramView, 2131300606, "field 'tv_call_me_btn'", TextView.class);
    paramHelloHeaderHolder.iv_call_default = (ImageView)Utils.a(paramView, 2131297713, "field 'iv_call_default'", ImageView.class);
    paramHelloHeaderHolder.tv_hint = (TextView)Utils.a(paramView, 2131300890, "field 'tv_hint'", TextView.class);
  }
  
  public void unbind() {
    MsgFragment.HelloHeaderHolder helloHeaderHolder = this.b;
    if (helloHeaderHolder != null) {
      this.b = null;
      helloHeaderHolder.tv_call_me_btn = null;
      helloHeaderHolder.iv_call_default = null;
      helloHeaderHolder.tv_hint = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\MsgFragment$HelloHeaderHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */