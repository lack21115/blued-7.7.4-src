package org.chromium.content.browser.picker;

import android.app.TimePickerDialog;
import android.widget.TimePicker;

final class InputDialogContainer$TimeListener implements TimePickerDialog.OnTimeSetListener {
  private final int mDialogType;
  
  InputDialogContainer$TimeListener(int paramInt) {
    this.mDialogType = paramInt;
  }
  
  public final void onTimeSet(TimePicker paramTimePicker, int paramInt1, int paramInt2) {
    InputDialogContainer.this.setFieldDateTimeValue(this.mDialogType, 0, 0, 0, paramInt1, paramInt2, 0, 0, 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\InputDialogContainer$TimeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */