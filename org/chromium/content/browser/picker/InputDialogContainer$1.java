package org.chromium.content.browser.picker;

import android.view.View;
import android.widget.AdapterView;

final class InputDialogContainer$1 implements AdapterView.OnItemClickListener {
  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {
    if (paramInt == adapter.getCount() - 1) {
      InputDialogContainer.this.dismissDialog();
      InputDialogContainer.this.showPickerDialog(dialogType, dialogValue, min, max, step);
      return;
    } 
    double d = ((DateTimeSuggestion)adapter.getItem(paramInt)).mValue;
    InputDialogContainer.this.mInputActionDelegate.replaceDateTime(d);
    InputDialogContainer.this.dismissDialog();
    InputDialogContainer.this.mDialogAlreadyDismissed = true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\InputDialogContainer$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */