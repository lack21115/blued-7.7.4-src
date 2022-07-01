package org.chromium.ui.widget;

import android.widget.PopupWindow;
import java.util.Iterator;

final class AnchoredPopupWindow$2 implements PopupWindow.OnDismissListener {
  public final void onDismiss() {
    if (AnchoredPopupWindow.access$100(AnchoredPopupWindow.this))
      return; 
    AnchoredPopupWindow.access$300(AnchoredPopupWindow.this).removeCallbacks(AnchoredPopupWindow.access$200(AnchoredPopupWindow.this));
    Iterator<PopupWindow.OnDismissListener> iterator = AnchoredPopupWindow.access$400(AnchoredPopupWindow.this).iterator();
    while (iterator.hasNext())
      ((PopupWindow.OnDismissListener)iterator.next()).onDismiss(); 
    AnchoredPopupWindow.access$500(AnchoredPopupWindow.this).stopObserving();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\widget\AnchoredPopupWindow$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */