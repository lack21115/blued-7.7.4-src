package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
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

public class SingleDateSelector implements DateSelector<Long> {
  public static final Parcelable.Creator<SingleDateSelector> CREATOR = new Parcelable.Creator<SingleDateSelector>() {
      public SingleDateSelector a(Parcel param1Parcel) {
        SingleDateSelector singleDateSelector = new SingleDateSelector();
        SingleDateSelector.a(singleDateSelector, (Long)param1Parcel.readValue(Long.class.getClassLoader()));
        return singleDateSelector;
      }
      
      public SingleDateSelector[] a(int param1Int) {
        return new SingleDateSelector[param1Int];
      }
    };
  
  private Long a;
  
  private void f() {
    this.a = null;
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle, CalendarConstraints paramCalendarConstraints, OnSelectionChangedListener<Long> paramOnSelectionChangedListener) {
    View view = paramLayoutInflater.inflate(R.layout.mtrl_picker_text_input_date, paramViewGroup, false);
    TextInputLayout textInputLayout = (TextInputLayout)view.findViewById(R.id.mtrl_picker_text_input_date);
    EditText editText = textInputLayout.getEditText();
    if (ManufacturerUtils.d())
      editText.setInputType(17); 
    SimpleDateFormat simpleDateFormat = UtcDates.d();
    String str = UtcDates.a(view.getResources(), simpleDateFormat);
    Long long_ = this.a;
    if (long_ != null)
      editText.setText(simpleDateFormat.format(long_)); 
    editText.addTextChangedListener(new DateFormatTextWatcher(this, str, simpleDateFormat, textInputLayout, paramCalendarConstraints, paramOnSelectionChangedListener) {
          void a() {
            this.a.a();
          }
          
          void a(Long param1Long) {
            if (param1Long == null) {
              SingleDateSelector.a(this.b);
            } else {
              this.b.a(param1Long.longValue());
            } 
            this.a.a(this.b.e());
          }
        });
    ViewUtils.b((View)editText);
    return view;
  }
  
  public String a(Context paramContext) {
    Resources resources = paramContext.getResources();
    Long long_ = this.a;
    if (long_ == null)
      return resources.getString(R.string.mtrl_picker_date_header_unselected); 
    String str = DateStrings.a(long_.longValue());
    return resources.getString(R.string.mtrl_picker_date_header_selected, new Object[] { str });
  }
  
  public void a(long paramLong) {
    this.a = Long.valueOf(paramLong);
  }
  
  public int b(Context paramContext) {
    return MaterialAttributes.a(paramContext, R.attr.materialCalendarTheme, MaterialDatePicker.class.getCanonicalName());
  }
  
  public boolean b() {
    return (this.a != null);
  }
  
  public Collection<Long> c() {
    ArrayList<Long> arrayList = new ArrayList();
    Long long_ = this.a;
    if (long_ != null)
      arrayList.add(long_); 
    return arrayList;
  }
  
  public Collection<Pair<Long, Long>> d() {
    return new ArrayList<Pair<Long, Long>>();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public Long e() {
    return this.a;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeValue(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\datepicker\SingleDateSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */