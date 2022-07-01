package org.chromium.content.browser.input;

import android.view.View;
import android.widget.AdapterView;

final class SelectPopupDropdown$1 implements AdapterView.OnItemClickListener {
  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {
    SelectPopupDropdown.this.notifySelection(new int[] { paramInt });
    SelectPopupDropdown.this.hide(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\SelectPopupDropdown$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */