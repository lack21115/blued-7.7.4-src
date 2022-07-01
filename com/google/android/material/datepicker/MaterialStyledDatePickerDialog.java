package com.google.android.material.datepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.R;
import com.google.android.material.dialog.InsetDialogOnTouchListener;

public class MaterialStyledDatePickerDialog extends DatePickerDialog {
  private static final int a = R.style.MaterialAlertDialog_MaterialComponents_Picker_Date_Spinner;
  
  private final Drawable b;
  
  private final Rect c;
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawable(this.b);
    getWindow().getDecorView().setOnTouchListener((View.OnTouchListener)new InsetDialogOnTouchListener((Dialog)this, this.c));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\datepicker\MaterialStyledDatePickerDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */