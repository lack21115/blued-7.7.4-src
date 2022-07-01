package org.chromium.ui;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

public class DropdownPopupWindow {
  public DropdownPopupWindowInterface mPopup;
  
  public DropdownPopupWindow(Context paramContext, View paramView) {
    if (Build.VERSION.SDK_INT >= 24) {
      this.mPopup = new DropdownPopupWindowImpl(paramContext, paramView);
      return;
    } 
    this.mPopup = new DropdownPopupWindowJellyBean(paramContext, paramView);
  }
  
  public final void dismiss() {
    this.mPopup.dismiss();
  }
  
  public final ListView getListView() {
    return this.mPopup.getListView();
  }
  
  public final void setAdapter(ListAdapter paramListAdapter) {
    this.mPopup.setAdapter(paramListAdapter);
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener) {
    this.mPopup.setOnDismissListener(paramOnDismissListener);
  }
  
  public final void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener) {
    this.mPopup.setOnItemClickListener(paramOnItemClickListener);
  }
  
  public final void setRtl(boolean paramBoolean) {
    this.mPopup.setRtl(paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\DropdownPopupWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */