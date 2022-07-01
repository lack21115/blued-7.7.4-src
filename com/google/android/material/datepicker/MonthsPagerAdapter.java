package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;

class MonthsPagerAdapter extends RecyclerView.Adapter<MonthsPagerAdapter.ViewHolder> {
  private final CalendarConstraints a;
  
  private final DateSelector<?> b;
  
  private final MaterialCalendar.OnDayClickListener c;
  
  private final int d;
  
  MonthsPagerAdapter(Context paramContext, DateSelector<?> paramDateSelector, CalendarConstraints paramCalendarConstraints, MaterialCalendar.OnDayClickListener paramOnDayClickListener) {
    Month month1 = paramCalendarConstraints.b();
    Month month2 = paramCalendarConstraints.c();
    Month month3 = paramCalendarConstraints.d();
    if (month1.a(month3) <= 0) {
      if (month3.a(month2) <= 0) {
        byte b;
        int i = MonthAdapter.a;
        int j = MaterialCalendar.a(paramContext);
        if (MaterialDatePicker.a(paramContext)) {
          b = MaterialCalendar.a(paramContext);
        } else {
          b = 0;
        } 
        this.d = i * j + b;
        this.a = paramCalendarConstraints;
        this.b = paramDateSelector;
        this.c = paramOnDayClickListener;
        setHasStableIds(true);
        return;
      } 
      throw new IllegalArgumentException("currentPage cannot be after lastPage");
    } 
    throw new IllegalArgumentException("firstPage cannot be after currentPage");
  }
  
  int a(Month paramMonth) {
    return this.a.b().b(paramMonth);
  }
  
  public ViewHolder a(ViewGroup paramViewGroup, int paramInt) {
    LinearLayout linearLayout = (LinearLayout)LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, paramViewGroup, false);
    if (MaterialDatePicker.a(paramViewGroup.getContext())) {
      linearLayout.setLayoutParams((ViewGroup.LayoutParams)new RecyclerView.LayoutParams(-1, this.d));
      return new ViewHolder(linearLayout, true);
    } 
    return new ViewHolder(linearLayout, false);
  }
  
  CharSequence a(int paramInt) {
    return b(paramInt).d();
  }
  
  public void a(ViewHolder paramViewHolder, int paramInt) {
    Month month = this.a.b().b(paramInt);
    paramViewHolder.p.setText(month.d());
    MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView)paramViewHolder.q.findViewById(R.id.month_grid);
    if (materialCalendarGridView.a() != null && month.equals((materialCalendarGridView.a()).b)) {
      materialCalendarGridView.a().notifyDataSetChanged();
    } else {
      MonthAdapter monthAdapter = new MonthAdapter(month, this.b, this.a);
      materialCalendarGridView.setNumColumns(month.c);
      materialCalendarGridView.setAdapter((ListAdapter)monthAdapter);
    } 
    materialCalendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener(this, materialCalendarGridView) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            if (this.a.a().d(param1Int))
              MonthsPagerAdapter.a(this.b).a(this.a.a().a(param1Int).longValue()); 
          }
        });
  }
  
  Month b(int paramInt) {
    return this.a.b().b(paramInt);
  }
  
  public int getItemCount() {
    return this.a.e();
  }
  
  public long getItemId(int paramInt) {
    return this.a.b().b(paramInt).c();
  }
  
  public static class ViewHolder extends RecyclerView.ViewHolder {
    final TextView p;
    
    final MaterialCalendarGridView q;
    
    ViewHolder(LinearLayout param1LinearLayout, boolean param1Boolean) {
      super((View)param1LinearLayout);
      this.p = (TextView)param1LinearLayout.findViewById(R.id.month_title);
      ViewCompat.setAccessibilityHeading((View)this.p, true);
      this.q = (MaterialCalendarGridView)param1LinearLayout.findViewById(R.id.month_grid);
      if (!param1Boolean)
        this.p.setVisibility(8); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\datepicker\MonthsPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */