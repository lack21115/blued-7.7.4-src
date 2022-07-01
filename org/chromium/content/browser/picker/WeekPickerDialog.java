package org.chromium.content.browser.picker;

import android.content.Context;
import org.chromium.content.R;

public final class WeekPickerDialog extends TwoFieldDatePickerDialog {
  private WeekPickerDialog(Context paramContext, int paramInt1, TwoFieldDatePickerDialog$OnValueSetListener paramTwoFieldDatePickerDialog$OnValueSetListener, int paramInt2, int paramInt3, double paramDouble1, double paramDouble2) {
    super(paramContext, paramInt1, paramTwoFieldDatePickerDialog$OnValueSetListener, paramInt2, paramInt3, paramDouble1, paramDouble2);
    setTitle(R.string.week_picker_dialog_title);
  }
  
  public WeekPickerDialog(Context paramContext, TwoFieldDatePickerDialog$OnValueSetListener paramTwoFieldDatePickerDialog$OnValueSetListener, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2) {
    this(paramContext, 0, paramTwoFieldDatePickerDialog$OnValueSetListener, paramInt1, paramInt2, paramDouble1, paramDouble2);
  }
  
  protected final TwoFieldDatePicker createPicker(Context paramContext, double paramDouble1, double paramDouble2) {
    return new WeekPicker(paramContext, paramDouble1, paramDouble2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\WeekPickerDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */