package com.soft.blued.ui.msg;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class MsgBoxFragment$HeaderHolder_ViewBinding implements Unbinder {
  private MsgBoxFragment.HeaderHolder b;
  
  public MsgBoxFragment$HeaderHolder_ViewBinding(MsgBoxFragment.HeaderHolder paramHeaderHolder, View paramView) {
    this.b = paramHeaderHolder;
    paramHeaderHolder.secretView = (TextView)Utils.a(paramView, 2131301313, "field 'secretView'", TextView.class);
    paramHeaderHolder.rl_hint = (RelativeLayout)Utils.a(paramView, 2131299711, "field 'rl_hint'", RelativeLayout.class);
    paramHeaderHolder.view_line = Utils.a(paramView, 2131301657, "field 'view_line'");
    paramHeaderHolder.iv_close = (ImageView)Utils.a(paramView, 2131297729, "field 'iv_close'", ImageView.class);
  }
  
  public void unbind() {
    MsgBoxFragment.HeaderHolder headerHolder = this.b;
    if (headerHolder != null) {
      this.b = null;
      headerHolder.secretView = null;
      headerHolder.rl_hint = null;
      headerHolder.view_line = null;
      headerHolder.iv_close = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\MsgBoxFragment$HeaderHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */