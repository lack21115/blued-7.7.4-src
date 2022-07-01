package android.support.v7.widget;

import android.view.View;

final class ListPopupWindow$2 implements Runnable {
  public final void run() {
    View view = ListPopupWindow.this.mDropDownAnchorView;
    if (view != null && view.getWindowToken() != null)
      ListPopupWindow.this.show(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ListPopupWindow$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */