package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;

final class ListPopupWindow$ResizePopupRunnable implements Runnable {
  public final void run() {
    if (ListPopupWindow.this.mDropDownList != null && ViewCompat.isAttachedToWindow((View)ListPopupWindow.this.mDropDownList) && ListPopupWindow.this.mDropDownList.getCount() > ListPopupWindow.this.mDropDownList.getChildCount() && ListPopupWindow.this.mDropDownList.getChildCount() <= ListPopupWindow.this.mListItemExpandMaximum) {
      ListPopupWindow.this.mPopup.setInputMethodMode(2);
      ListPopupWindow.this.show();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ListPopupWindow$ResizePopupRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */