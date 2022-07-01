package org.chromium.content.browser.input;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

final class SelectPopupDialog$3 implements AdapterView.OnItemClickListener {
  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {
    SelectPopupDialog.access$100(SelectPopupDialog.this, SelectPopupDialog.access$000(listView));
    SelectPopupDialog.access$200(SelectPopupDialog.this).dismiss();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\SelectPopupDialog$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */