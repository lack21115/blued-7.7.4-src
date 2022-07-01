package com.google.android.material.datepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

abstract class DateFormatTextWatcher implements TextWatcher {
  private final String a;
  
  private final DateFormat b;
  
  private final TextInputLayout c;
  
  private final CalendarConstraints d;
  
  private final String e;
  
  DateFormatTextWatcher(String paramString, DateFormat paramDateFormat, TextInputLayout paramTextInputLayout, CalendarConstraints paramCalendarConstraints) {
    this.a = paramString;
    this.b = paramDateFormat;
    this.c = paramTextInputLayout;
    this.d = paramCalendarConstraints;
    this.e = paramTextInputLayout.getContext().getString(R.string.mtrl_picker_out_of_range);
  }
  
  void a() {}
  
  abstract void a(Long paramLong);
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    if (TextUtils.isEmpty(paramCharSequence)) {
      this.c.setError(null);
      a(null);
      return;
    } 
    try {
      Date date = this.b.parse(paramCharSequence.toString());
      this.c.setError(null);
      long l = date.getTime();
      if (this.d.a().a(l) && this.d.a(l)) {
        a(Long.valueOf(date.getTime()));
        return;
      } 
      this.c.setError(String.format(this.e, new Object[] { DateStrings.e(l) }));
      a();
      return;
    } catch (ParseException parseException) {
      String str1 = this.c.getContext().getString(R.string.mtrl_picker_invalid_format);
      String str2 = String.format(this.c.getContext().getString(R.string.mtrl_picker_invalid_format_use), new Object[] { this.a });
      String str3 = String.format(this.c.getContext().getString(R.string.mtrl_picker_invalid_format_example), new Object[] { this.b.format(new Date(UtcDates.b().getTimeInMillis())) });
      TextInputLayout textInputLayout = this.c;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append("\n");
      stringBuilder.append(str2);
      stringBuilder.append("\n");
      stringBuilder.append(str3);
      textInputLayout.setError(stringBuilder.toString());
      a();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\datepicker\DateFormatTextWatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */