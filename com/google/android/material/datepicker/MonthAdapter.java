package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.R;
import java.util.Iterator;

class MonthAdapter extends BaseAdapter {
  static final int a = UtcDates.c().getMaximum(4);
  
  final Month b;
  
  final DateSelector<?> c;
  
  CalendarStyle d;
  
  final CalendarConstraints e;
  
  MonthAdapter(Month paramMonth, DateSelector<?> paramDateSelector, CalendarConstraints paramCalendarConstraints) {
    this.b = paramMonth;
    this.c = paramDateSelector;
    this.e = paramCalendarConstraints;
  }
  
  private void a(Context paramContext) {
    if (this.d == null)
      this.d = new CalendarStyle(paramContext); 
  }
  
  int a() {
    return this.b.b();
  }
  
  public TextView a(int paramInt, View paramView, ViewGroup paramViewGroup) {
    a(paramViewGroup.getContext());
    TextView textView = (TextView)paramView;
    if (paramView == null)
      textView = (TextView)LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.mtrl_calendar_day, paramViewGroup, false); 
    int i = paramInt - a();
    if (i < 0 || i >= this.b.d) {
      textView.setVisibility(8);
      textView.setEnabled(false);
    } else {
      i++;
      textView.setTag(this.b);
      textView.setText(String.valueOf(i));
      long l = this.b.a(i);
      if (this.b.b == (Month.a()).b) {
        textView.setContentDescription(DateStrings.c(l));
      } else {
        textView.setContentDescription(DateStrings.d(l));
      } 
      textView.setVisibility(0);
      textView.setEnabled(true);
    } 
    Long long_ = a(paramInt);
    if (long_ == null)
      return textView; 
    if (this.e.a().a(long_.longValue())) {
      textView.setEnabled(true);
      Iterator<Long> iterator = this.c.c().iterator();
      while (iterator.hasNext()) {
        long l = ((Long)iterator.next()).longValue();
        if (UtcDates.a(long_.longValue()) == UtcDates.a(l)) {
          this.d.b.a(textView);
          return textView;
        } 
      } 
      if (UtcDates.b().getTimeInMillis() == long_.longValue()) {
        this.d.c.a(textView);
        return textView;
      } 
      this.d.a.a(textView);
      return textView;
    } 
    textView.setEnabled(false);
    this.d.g.a(textView);
    return textView;
  }
  
  public Long a(int paramInt) {
    return (paramInt < this.b.b() || paramInt > b()) ? null : Long.valueOf(this.b.a(b(paramInt)));
  }
  
  int b() {
    return this.b.b() + this.b.d - 1;
  }
  
  int b(int paramInt) {
    return paramInt - this.b.b() + 1;
  }
  
  int c(int paramInt) {
    return a() + paramInt - 1;
  }
  
  boolean d(int paramInt) {
    return (paramInt >= a() && paramInt <= b());
  }
  
  boolean e(int paramInt) {
    return (paramInt % this.b.c == 0);
  }
  
  boolean f(int paramInt) {
    return ((paramInt + 1) % this.b.c == 0);
  }
  
  public int getCount() {
    return this.b.d + a();
  }
  
  public long getItemId(int paramInt) {
    return (paramInt / this.b.c);
  }
  
  public boolean hasStableIds() {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\datepicker\MonthAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */