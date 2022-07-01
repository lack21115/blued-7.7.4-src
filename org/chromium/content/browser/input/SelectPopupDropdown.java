package org.chromium.content.browser.input;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import java.util.List;
import org.chromium.ui.DropdownAdapter;
import org.chromium.ui.DropdownPopupWindow;

public final class SelectPopupDropdown implements SelectPopup$Ui {
  private final DropdownPopupWindow mDropdownPopupWindow;
  
  private final SelectPopup mSelectPopup;
  
  private boolean mSelectionNotified;
  
  public SelectPopupDropdown(SelectPopup paramSelectPopup, Context paramContext, View paramView, List paramList, int[] paramArrayOfint, boolean paramBoolean) {
    byte b;
    this.mSelectPopup = paramSelectPopup;
    this.mDropdownPopupWindow = new DropdownPopupWindow(paramContext, paramView);
    this.mDropdownPopupWindow.setOnItemClickListener(new SelectPopupDropdown$1(this));
    if (paramArrayOfint.length > 0) {
      b = paramArrayOfint[0];
    } else {
      b = -1;
    } 
    this.mDropdownPopupWindow.mPopup.setInitialSelection(b);
    this.mDropdownPopupWindow.setAdapter((ListAdapter)new DropdownAdapter(paramContext, paramList, null));
    this.mDropdownPopupWindow.setRtl(paramBoolean);
    this.mDropdownPopupWindow.setOnDismissListener(new SelectPopupDropdown$2(this));
  }
  
  public final void hide(boolean paramBoolean) {
    if (paramBoolean) {
      this.mDropdownPopupWindow.dismiss();
      notifySelection(null);
      return;
    } 
    this.mSelectionNotified = true;
    this.mDropdownPopupWindow.dismiss();
  }
  
  final void notifySelection(int[] paramArrayOfint) {
    if (this.mSelectionNotified)
      return; 
    this.mSelectPopup.selectMenuItems(paramArrayOfint);
    this.mSelectionNotified = true;
  }
  
  public final void show() {
    this.mDropdownPopupWindow.mPopup.postShow();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\SelectPopupDropdown.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */