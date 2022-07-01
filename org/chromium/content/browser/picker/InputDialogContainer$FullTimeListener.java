package org.chromium.content.browser.picker;

final class InputDialogContainer$FullTimeListener implements MultiFieldTimePickerDialog$OnMultiFieldTimeSetListener {
  private final int mDialogType;
  
  InputDialogContainer$FullTimeListener(int paramInt) {
    this.mDialogType = paramInt;
  }
  
  public final void onTimeSet(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    InputDialogContainer.this.setFieldDateTimeValue(this.mDialogType, 0, 0, 0, paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\InputDialogContainer$FullTimeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */