package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.core.util.Pair;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

public class RangeDateSelector implements DateSelector<Pair<Long, Long>> {
  public static final Parcelable.Creator<RangeDateSelector> CREATOR = new Parcelable.Creator<RangeDateSelector>() {
      public RangeDateSelector a(Parcel param1Parcel) {
        RangeDateSelector rangeDateSelector = new RangeDateSelector();
        RangeDateSelector.c(rangeDateSelector, (Long)param1Parcel.readValue(Long.class.getClassLoader()));
        RangeDateSelector.d(rangeDateSelector, (Long)param1Parcel.readValue(Long.class.getClassLoader()));
        return rangeDateSelector;
      }
      
      public RangeDateSelector[] a(int param1Int) {
        return new RangeDateSelector[param1Int];
      }
    };
  
  private String a;
  
  private final String b = " ";
  
  private Long c = null;
  
  private Long d = null;
  
  private Long e = null;
  
  private Long f = null;
  
  private void a(TextInputLayout paramTextInputLayout1, TextInputLayout paramTextInputLayout2) {
    if (paramTextInputLayout1.getError() != null && this.a.contentEquals(paramTextInputLayout1.getError()))
      paramTextInputLayout1.setError(null); 
    if (paramTextInputLayout2.getError() != null && " ".contentEquals(paramTextInputLayout2.getError()))
      paramTextInputLayout2.setError(null); 
  }
  
  private void a(TextInputLayout paramTextInputLayout1, TextInputLayout paramTextInputLayout2, OnSelectionChangedListener<Pair<Long, Long>> paramOnSelectionChangedListener) {
    Long long_ = this.e;
    if (long_ == null || this.f == null) {
      a(paramTextInputLayout1, paramTextInputLayout2);
      paramOnSelectionChangedListener.a();
      return;
    } 
    if (a(long_.longValue(), this.f.longValue())) {
      this.c = this.e;
      this.d = this.f;
      paramOnSelectionChangedListener.a(e());
      return;
    } 
    b(paramTextInputLayout1, paramTextInputLayout2);
    paramOnSelectionChangedListener.a();
  }
  
  private boolean a(long paramLong1, long paramLong2) {
    return (paramLong1 <= paramLong2);
  }
  
  private void b(TextInputLayout paramTextInputLayout1, TextInputLayout paramTextInputLayout2) {
    paramTextInputLayout1.setError(this.a);
    paramTextInputLayout2.setError(" ");
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle, CalendarConstraints paramCalendarConstraints, OnSelectionChangedListener<Pair<Long, Long>> paramOnSelectionChangedListener) {
    View view = paramLayoutInflater.inflate(R.layout.mtrl_picker_text_input_date_range, paramViewGroup, false);
    TextInputLayout textInputLayout1 = (TextInputLayout)view.findViewById(R.id.mtrl_picker_text_input_range_start);
    TextInputLayout textInputLayout2 = (TextInputLayout)view.findViewById(R.id.mtrl_picker_text_input_range_end);
    EditText editText1 = textInputLayout1.getEditText();
    EditText editText2 = textInputLayout2.getEditText();
    if (ManufacturerUtils.d()) {
      editText1.setInputType(17);
      editText2.setInputType(17);
    } 
    this.a = view.getResources().getString(R.string.mtrl_picker_invalid_range);
    SimpleDateFormat simpleDateFormat = UtcDates.d();
    Long long_ = this.c;
    if (long_ != null) {
      editText1.setText(simpleDateFormat.format(long_));
      this.e = this.c;
    } 
    long_ = this.d;
    if (long_ != null) {
      editText2.setText(simpleDateFormat.format(long_));
      this.f = this.d;
    } 
    String str = UtcDates.a(view.getResources(), simpleDateFormat);
    editText1.addTextChangedListener(new DateFormatTextWatcher(this, str, simpleDateFormat, textInputLayout1, paramCalendarConstraints, textInputLayout1, textInputLayout2, paramOnSelectionChangedListener) {
          void a() {
            RangeDateSelector.a(this.d, (Long)null);
            RangeDateSelector.a(this.d, this.a, this.b, this.c);
          }
          
          void a(Long param1Long) {
            RangeDateSelector.a(this.d, param1Long);
            RangeDateSelector.a(this.d, this.a, this.b, this.c);
          }
        });
    editText2.addTextChangedListener(new DateFormatTextWatcher(this, str, simpleDateFormat, textInputLayout2, paramCalendarConstraints, textInputLayout1, textInputLayout2, paramOnSelectionChangedListener) {
          void a() {
            RangeDateSelector.b(this.d, (Long)null);
            RangeDateSelector.a(this.d, this.a, this.b, this.c);
          }
          
          void a(Long param1Long) {
            RangeDateSelector.b(this.d, param1Long);
            RangeDateSelector.a(this.d, this.a, this.b, this.c);
          }
        });
    ViewUtils.b((View)editText1);
    return view;
  }
  
  public String a(Context paramContext) {
    Resources resources = paramContext.getResources();
    if (this.c == null && this.d == null)
      return resources.getString(R.string.mtrl_picker_range_header_unselected); 
    Long long_1 = this.d;
    if (long_1 == null)
      return resources.getString(R.string.mtrl_picker_range_header_only_start_selected, new Object[] { DateStrings.e(this.c.longValue()) }); 
    Long long_2 = this.c;
    if (long_2 == null)
      return resources.getString(R.string.mtrl_picker_range_header_only_end_selected, new Object[] { DateStrings.e(this.d.longValue()) }); 
    Pair<String, String> pair = DateStrings.a(long_2, long_1);
    return resources.getString(R.string.mtrl_picker_range_header_selected, new Object[] { pair.first, pair.second });
  }
  
  public void a(long paramLong) {
    Long long_ = this.c;
    if (long_ == null) {
      this.c = Long.valueOf(paramLong);
      return;
    } 
    if (this.d == null && a(long_.longValue(), paramLong)) {
      this.d = Long.valueOf(paramLong);
      return;
    } 
    this.d = null;
    this.c = Long.valueOf(paramLong);
  }
  
  public int b(Context paramContext) {
    Resources resources = paramContext.getResources();
    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
    int i = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis);
    if (Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > i) {
      i = R.attr.materialCalendarTheme;
    } else {
      i = R.attr.materialCalendarFullscreenTheme;
    } 
    return MaterialAttributes.a(paramContext, i, MaterialDatePicker.class.getCanonicalName());
  }
  
  public boolean b() {
    Long long_ = this.c;
    return (long_ != null && this.d != null && a(long_.longValue(), this.d.longValue()));
  }
  
  public Collection<Long> c() {
    ArrayList<Long> arrayList = new ArrayList();
    Long long_ = this.c;
    if (long_ != null)
      arrayList.add(long_); 
    long_ = this.d;
    if (long_ != null)
      arrayList.add(long_); 
    return arrayList;
  }
  
  public Collection<Pair<Long, Long>> d() {
    if (this.c == null || this.d == null)
      return new ArrayList<Pair<Long, Long>>(); 
    ArrayList<Pair> arrayList = new ArrayList();
    arrayList.add(new Pair(this.c, this.d));
    return (Collection)arrayList;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public Pair<Long, Long> e() {
    return new Pair(this.c, this.d);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeValue(this.c);
    paramParcel.writeValue(this.d);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\datepicker\RangeDateSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */