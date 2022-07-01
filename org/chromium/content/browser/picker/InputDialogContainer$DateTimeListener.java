package org.chromium.content.browser.picker;

final class InputDialogContainer$DateTimeListener implements DateTimePickerDialog$OnDateTimeSetListener {
  private final int mDialogType;
  
  public InputDialogContainer$DateTimeListener(int paramInt) {
    this.mDialogType = paramInt;
  }
  
  public final void onDateTimeSet$2da1b2cd(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    InputDialogContainer.this.setFieldDateTimeValue(this.mDialogType, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 0, 0, 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\InputDialogContainer$DateTimeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */