package org.chromium.components.autofill;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public final class AutofillPopup$2 extends View.AccessibilityDelegate {
  public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent) {
    AutofillPopup.this.getListView().removeCallbacks(AutofillPopup.access$100(AutofillPopup.this));
    if (paramAccessibilityEvent.getEventType() == 65536)
      AutofillPopup.this.getListView().postDelayed(AutofillPopup.access$100(AutofillPopup.this), 100L); 
    return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\autofill\AutofillPopup$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */