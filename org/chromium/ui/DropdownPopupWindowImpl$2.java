package org.chromium.ui;

import android.widget.PopupWindow;

final class DropdownPopupWindowImpl$2 implements PopupWindow.OnDismissListener {
  public final void onDismiss() {
    (DropdownPopupWindowImpl.access$100(DropdownPopupWindowImpl.this)).mPopupWindow.dismiss();
    DropdownPopupWindowImpl.access$000(DropdownPopupWindowImpl.this).removeOnLayoutChangeListener(DropdownPopupWindowImpl.access$200(DropdownPopupWindowImpl.this));
    DropdownPopupWindowImpl.access$000(DropdownPopupWindowImpl.this).setTag(null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\DropdownPopupWindowImpl$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */