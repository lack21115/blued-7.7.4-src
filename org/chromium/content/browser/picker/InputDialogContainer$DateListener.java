package org.chromium.content.browser.picker;

import android.app.DatePickerDialog;
import android.widget.DatePicker;

final class InputDialogContainer$DateListener implements DatePickerDialog.OnDateSetListener {
  private final int mDialogType;
  
  InputDialogContainer$DateListener(int paramInt) {
    this.mDialogType = paramInt;
  }
  
  public final void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3) {
    InputDialogContainer.this.setFieldDateTimeValue(this.mDialogType, paramInt1, paramInt2, paramInt3, 0, 0, 0, 0, 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\InputDialogContainer$DateListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */