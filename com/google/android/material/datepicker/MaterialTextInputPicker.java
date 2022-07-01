package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

public final class MaterialTextInputPicker<S> extends PickerFragment<S> {
  private DateSelector<S> a;
  
  private CalendarConstraints b;
  
  static <T> MaterialTextInputPicker<T> a(DateSelector<T> paramDateSelector, CalendarConstraints paramCalendarConstraints) {
    MaterialTextInputPicker<T> materialTextInputPicker = new MaterialTextInputPicker();
    Bundle bundle = new Bundle();
    bundle.putParcelable("DATE_SELECTOR_KEY", paramDateSelector);
    bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", paramCalendarConstraints);
    materialTextInputPicker.setArguments(bundle);
    return materialTextInputPicker;
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    Bundle bundle = paramBundle;
    if (paramBundle == null)
      bundle = getArguments(); 
    this.a = (DateSelector<S>)bundle.getParcelable("DATE_SELECTOR_KEY");
    this.b = (CalendarConstraints)bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    return this.a.a(paramLayoutInflater, paramViewGroup, paramBundle, this.b, new OnSelectionChangedListener<S>(this) {
          void a() {
            Iterator<OnSelectionChangedListener> iterator = this.a.e.iterator();
            while (iterator.hasNext())
              ((OnSelectionChangedListener)iterator.next()).a(); 
          }
          
          public void a(S param1S) {
            Iterator<OnSelectionChangedListener<S>> iterator = this.a.e.iterator();
            while (iterator.hasNext())
              ((OnSelectionChangedListener<S>)iterator.next()).a(param1S); 
          }
        });
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("DATE_SELECTOR_KEY", this.a);
    paramBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\datepicker\MaterialTextInputPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */