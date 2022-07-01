package org.chromium.content.browser.picker;

final class InputDialogContainer$MonthOrWeekListener implements TwoFieldDatePickerDialog$OnValueSetListener {
  private final int mDialogType;
  
  InputDialogContainer$MonthOrWeekListener(int paramInt) {
    this.mDialogType = paramInt;
  }
  
  public final void onValueSet(int paramInt1, int paramInt2) {
    if (this.mDialogType == 11) {
      InputDialogContainer.this.setFieldDateTimeValue(this.mDialogType, paramInt1, paramInt2, 0, 0, 0, 0, 0, 0);
      return;
    } 
    InputDialogContainer.this.setFieldDateTimeValue(this.mDialogType, paramInt1, 0, 0, 0, 0, 0, 0, paramInt2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\InputDialogContainer$MonthOrWeekListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */