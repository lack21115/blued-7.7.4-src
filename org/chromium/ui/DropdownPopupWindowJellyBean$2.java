package org.chromium.ui;

import android.widget.PopupWindow;

final class DropdownPopupWindowJellyBean$2 implements PopupWindow.OnDismissListener {
  public final void onDismiss() {
    if (DropdownPopupWindowJellyBean.access$100(DropdownPopupWindowJellyBean.this) != null)
      DropdownPopupWindowJellyBean.access$100(DropdownPopupWindowJellyBean.this).onDismiss(); 
    DropdownPopupWindowJellyBean.access$000(DropdownPopupWindowJellyBean.this).removeOnLayoutChangeListener(DropdownPopupWindowJellyBean.access$200(DropdownPopupWindowJellyBean.this));
    DropdownPopupWindowJellyBean.access$000(DropdownPopupWindowJellyBean.this).setTag(null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\DropdownPopupWindowJellyBean$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */