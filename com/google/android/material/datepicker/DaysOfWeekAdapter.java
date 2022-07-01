package com.google.android.material.datepicker;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.R;
import java.util.Calendar;
import java.util.Locale;

class DaysOfWeekAdapter extends BaseAdapter {
  private static final int d;
  
  private final Calendar a = UtcDates.c();
  
  private final int b = this.a.getMaximum(7);
  
  private final int c = this.a.getFirstDayOfWeek();
  
  static {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 26) {
      bool = true;
    } else {
      bool = true;
    } 
    d = bool;
  }
  
  private int b(int paramInt) {
    int i = paramInt + this.c;
    int j = this.b;
    paramInt = i;
    if (i > j)
      paramInt = i - j; 
    return paramInt;
  }
  
  public Integer a(int paramInt) {
    return (paramInt >= this.b) ? null : Integer.valueOf(b(paramInt));
  }
  
  public int getCount() {
    return this.b;
  }
  
  public long getItemId(int paramInt) {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    TextView textView = (TextView)paramView;
    if (paramView == null)
      textView = (TextView)LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, paramViewGroup, false); 
    this.a.set(7, b(paramInt));
    textView.setText(this.a.getDisplayName(7, d, Locale.getDefault()));
    textView.setContentDescription(String.format(paramViewGroup.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), new Object[] { this.a.getDisplayName(7, 2, Locale.getDefault()) }));
    return (View)textView;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\datepicker\DaysOfWeekAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */