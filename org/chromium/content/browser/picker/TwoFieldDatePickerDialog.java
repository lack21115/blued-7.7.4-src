package org.chromium.content.browser.picker;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import org.chromium.content.R;

public abstract class TwoFieldDatePickerDialog extends AlertDialog implements DialogInterface.OnClickListener, TwoFieldDatePicker$OnMonthOrWeekChangedListener {
  private TwoFieldDatePickerDialog$OnValueSetListener mCallBack;
  
  private TwoFieldDatePicker mPicker;
  
  public TwoFieldDatePickerDialog(Context paramContext, int paramInt1, TwoFieldDatePickerDialog$OnValueSetListener paramTwoFieldDatePickerDialog$OnValueSetListener, int paramInt2, int paramInt3, double paramDouble1, double paramDouble2) {
    super(paramContext, paramInt1);
    this.mCallBack = paramTwoFieldDatePickerDialog$OnValueSetListener;
    setButton(-1, paramContext.getText(R.string.date_picker_dialog_set), this);
    setButton(-2, paramContext.getText(17039360), null);
    setIcon(0);
    this.mPicker = createPicker(paramContext, paramDouble1, paramDouble2);
    setView((View)this.mPicker);
    this.mPicker.init(paramInt2, paramInt3, this);
  }
  
  public TwoFieldDatePickerDialog(Context paramContext, TwoFieldDatePickerDialog$OnValueSetListener paramTwoFieldDatePickerDialog$OnValueSetListener, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2) {
    this(paramContext, 0, paramTwoFieldDatePickerDialog$OnValueSetListener, paramInt1, paramInt2, paramDouble1, paramDouble2);
  }
  
  protected TwoFieldDatePicker createPicker(Context paramContext, double paramDouble1, double paramDouble2) {
    return null;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {
    if (this.mCallBack != null) {
      this.mPicker.clearFocus();
      this.mCallBack.onValueSet(this.mPicker.getYear(), this.mPicker.getPositionInYear());
    } 
  }
  
  public final void onMonthOrWeekChanged$d8a024(int paramInt1, int paramInt2) {
    this.mPicker.init(paramInt1, paramInt2, (TwoFieldDatePicker$OnMonthOrWeekChangedListener)null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\TwoFieldDatePickerDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */