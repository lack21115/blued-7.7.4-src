package org.chromium.ui.base;

import android.view.View;

public final class ViewUtils {
  public static boolean hasFocus(View paramView) {
    return !isFocusable(paramView) ? true : paramView.hasFocus();
  }
  
  static boolean isFocusable(View paramView) {
    return paramView.isInTouchMode() ? paramView.isFocusableInTouchMode() : paramView.isFocusable();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\base\ViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */