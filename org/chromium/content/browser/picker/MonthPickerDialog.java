package org.chromium.content.browser.picker;

import android.content.Context;
import org.chromium.content.R;

public final class MonthPickerDialog extends TwoFieldDatePickerDialog {
  public MonthPickerDialog(Context paramContext, TwoFieldDatePickerDialog$OnValueSetListener paramTwoFieldDatePickerDialog$OnValueSetListener, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2) {
    super(paramContext, paramTwoFieldDatePickerDialog$OnValueSetListener, paramInt1, paramInt2, paramDouble1, paramDouble2);
    setTitle(R.string.month_picker_dialog_title);
  }
  
  protected final TwoFieldDatePicker createPicker(Context paramContext, double paramDouble1, double paramDouble2) {
    return new MonthPicker(paramContext, paramDouble1, paramDouble2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\MonthPickerDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */