package com.soft.blued.ui.live.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class LiveBaseImproveFragment$DialogViewHolder_ViewBinding implements Unbinder {
  private LiveBaseImproveFragment.DialogViewHolder b;
  
  public LiveBaseImproveFragment$DialogViewHolder_ViewBinding(LiveBaseImproveFragment.DialogViewHolder paramDialogViewHolder, View paramView) {
    this.b = paramDialogViewHolder;
    paramDialogViewHolder.viewer_card = (ImageView)Utils.a(paramView, 2131301696, "field 'viewer_card'", ImageView.class);
    paramDialogViewHolder.openPhones = (Button)Utils.a(paramView, 2131299424, "field 'openPhones'", Button.class);
    paramDialogViewHolder.openCamera = (Button)Utils.a(paramView, 2131299421, "field 'openCamera'", Button.class);
    paramDialogViewHolder.openClose = (ImageView)Utils.a(paramView, 2131299422, "field 'openClose'", ImageView.class);
  }
  
  public void unbind() {
    LiveBaseImproveFragment.DialogViewHolder dialogViewHolder = this.b;
    if (dialogViewHolder != null) {
      this.b = null;
      dialogViewHolder.viewer_card = null;
      dialogViewHolder.openPhones = null;
      dialogViewHolder.openCamera = null;
      dialogViewHolder.openClose = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveBaseImproveFragment$DialogViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */