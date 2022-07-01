package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.util.Preconditions;
import java.util.List;

public final class CompositeDateValidator implements CalendarConstraints.DateValidator {
  public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new Parcelable.Creator<CompositeDateValidator>() {
      public CompositeDateValidator a(Parcel param1Parcel) {
        return new CompositeDateValidator((List)Preconditions.checkNotNull(param1Parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader())));
      }
      
      public CompositeDateValidator[] a(int param1Int) {
        return new CompositeDateValidator[param1Int];
      }
    };
  
  private final List<CalendarConstraints.DateValidator> a;
  
  private CompositeDateValidator(List<CalendarConstraints.DateValidator> paramList) {
    this.a = paramList;
  }
  
  public boolean a(long paramLong) {
    for (CalendarConstraints.DateValidator dateValidator : this.a) {
      if (dateValidator != null && !dateValidator.a(paramLong))
        return false; 
    } 
    return true;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof CompositeDateValidator))
      return false; 
    paramObject = paramObject;
    return this.a.equals(((CompositeDateValidator)paramObject).a);
  }
  
  public int hashCode() {
    return this.a.hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeList(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\datepicker\CompositeDateValidator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */