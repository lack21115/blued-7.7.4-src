package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

class YearGridAdapter extends RecyclerView.Adapter<YearGridAdapter.ViewHolder> {
  private final MaterialCalendar<?> a;
  
  YearGridAdapter(MaterialCalendar<?> paramMaterialCalendar) {
    this.a = paramMaterialCalendar;
  }
  
  private View.OnClickListener c(int paramInt) {
    return new View.OnClickListener(this, paramInt) {
        public void onClick(View param1View) {
          Month month = Month.a(this.a, (YearGridAdapter.a(this.b).a()).a);
          month = YearGridAdapter.a(this.b).b().a(month);
          YearGridAdapter.a(this.b).a(month);
          YearGridAdapter.a(this.b).a(MaterialCalendar.CalendarSelector.a);
        }
      };
  }
  
  int a(int paramInt) {
    return paramInt - (this.a.b().b()).b;
  }
  
  public ViewHolder a(ViewGroup paramViewGroup, int paramInt) {
    return new ViewHolder((TextView)LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, paramViewGroup, false));
  }
  
  public void a(ViewHolder paramViewHolder, int paramInt) {
    CalendarItemStyle calendarItemStyle;
    paramInt = b(paramInt);
    String str = paramViewHolder.p.getContext().getString(R.string.mtrl_picker_navigate_to_year_description);
    paramViewHolder.p.setText(String.format(Locale.getDefault(), "%d", new Object[] { Integer.valueOf(paramInt) }));
    paramViewHolder.p.setContentDescription(String.format(str, new Object[] { Integer.valueOf(paramInt) }));
    CalendarStyle calendarStyle = this.a.d();
    Calendar calendar = UtcDates.b();
    if (calendar.get(1) == paramInt) {
      calendarItemStyle = calendarStyle.f;
    } else {
      calendarItemStyle = calendarStyle.d;
    } 
    Iterator<Long> iterator = this.a.c().c().iterator();
    while (iterator.hasNext()) {
      calendar.setTimeInMillis(((Long)iterator.next()).longValue());
      if (calendar.get(1) == paramInt)
        calendarItemStyle = calendarStyle.e; 
    } 
    calendarItemStyle.a(paramViewHolder.p);
    paramViewHolder.p.setOnClickListener(c(paramInt));
  }
  
  int b(int paramInt) {
    return (this.a.b().b()).b + paramInt;
  }
  
  public int getItemCount() {
    return this.a.b().f();
  }
  
  public static class ViewHolder extends RecyclerView.ViewHolder {
    final TextView p;
    
    ViewHolder(TextView param1TextView) {
      super((View)param1TextView);
      this.p = param1TextView;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\datepicker\YearGridAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */