package com.soft.blued.ui.user.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class VIPCenterTabPageFragment$UpToSVIPViewHolder_ViewBinding implements Unbinder {
  private VIPCenterTabPageFragment.UpToSVIPViewHolder b;
  
  public VIPCenterTabPageFragment$UpToSVIPViewHolder_ViewBinding(VIPCenterTabPageFragment.UpToSVIPViewHolder paramUpToSVIPViewHolder, View paramView) {
    this.b = paramUpToSVIPViewHolder;
    paramUpToSVIPViewHolder.tvTitle = (TextView)Utils.a(paramView, 2131301409, "field 'tvTitle'", TextView.class);
  }
  
  public void unbind() {
    VIPCenterTabPageFragment.UpToSVIPViewHolder upToSVIPViewHolder = this.b;
    if (upToSVIPViewHolder != null) {
      this.b = null;
      upToSVIPViewHolder.tvTitle = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\VIPCenterTabPageFragment$UpToSVIPViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */