package com.soft.blued.customview;

import android.content.Context;
import android.content.DialogInterface;
import net.simonvt.datepicker.DatePickerDialog;

public class MDatePickerDialog extends DatePickerDialog {
  public MDatePickerDialog(Context paramContext, DatePickerDialog.OnDateSetListener paramOnDateSetListener, int paramInt1, int paramInt2, int paramInt3) {
    super(paramContext, paramOnDateSetListener, paramInt1, paramInt2, paramInt3);
    setButton(-2, paramContext.getResources().getString(2131755577), (DialogInterface.OnClickListener)null);
    setButton(-1, paramContext.getResources().getString(2131755609), (DialogInterface.OnClickListener)this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\MDatePickerDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */