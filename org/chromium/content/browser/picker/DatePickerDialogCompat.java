package org.chromium.content.browser.picker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.widget.DatePicker;

final class DatePickerDialogCompat extends DatePickerDialog {
  private final DatePickerDialog.OnDateSetListener mCallBack;
  
  public DatePickerDialogCompat(Context paramContext, DatePickerDialog.OnDateSetListener paramOnDateSetListener, int paramInt1, int paramInt2, int paramInt3) {
    super(paramContext, paramOnDateSetListener, paramInt1, paramInt2, paramInt3);
    this.mCallBack = paramOnDateSetListener;
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt) {
    if (paramInt == -1 && this.mCallBack != null) {
      DatePicker datePicker = getDatePicker();
      datePicker.clearFocus();
      this.mCallBack.onDateSet(datePicker, datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
    } 
  }
  
  public final void setTitle(CharSequence paramCharSequence) {
    if (Build.VERSION.SDK_INT >= 21)
      paramCharSequence = ""; 
    super.setTitle(paramCharSequence);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\DatePickerDialogCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */