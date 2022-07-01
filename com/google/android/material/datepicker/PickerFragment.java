package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

abstract class PickerFragment<S> extends Fragment {
  protected final LinkedHashSet<OnSelectionChangedListener<S>> e = new LinkedHashSet<OnSelectionChangedListener<S>>();
  
  boolean a(OnSelectionChangedListener<S> paramOnSelectionChangedListener) {
    return this.e.add(paramOnSelectionChangedListener);
  }
  
  void g() {
    this.e.clear();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\datepicker\PickerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */