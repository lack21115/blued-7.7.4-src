package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Pair;
import java.util.Collection;

public interface DateSelector<S> extends Parcelable {
  View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle, CalendarConstraints paramCalendarConstraints, OnSelectionChangedListener<S> paramOnSelectionChangedListener);
  
  S a();
  
  String a(Context paramContext);
  
  void a(long paramLong);
  
  int b(Context paramContext);
  
  boolean b();
  
  Collection<Long> c();
  
  Collection<Pair<Long, Long>> d();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\datepicker\DateSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */