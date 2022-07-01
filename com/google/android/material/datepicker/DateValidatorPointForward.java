package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public class DateValidatorPointForward implements CalendarConstraints.DateValidator {
  public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = new Parcelable.Creator<DateValidatorPointForward>() {
      public DateValidatorPointForward a(Parcel param1Parcel) {
        return new DateValidatorPointForward(param1Parcel.readLong());
      }
      
      public DateValidatorPointForward[] a(int param1Int) {
        return new DateValidatorPointForward[param1Int];
      }
    };
  
  private final long a;
  
  private DateValidatorPointForward(long paramLong) {
    this.a = paramLong;
  }
  
  public static DateValidatorPointForward b(long paramLong) {
    return new DateValidatorPointForward(paramLong);
  }
  
  public boolean a(long paramLong) {
    return (paramLong >= this.a);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof DateValidatorPointForward))
      return false; 
    paramObject = paramObject;
    return (this.a == ((DateValidatorPointForward)paramObject).a);
  }
  
  public int hashCode() {
    return Arrays.hashCode(new Object[] { Long.valueOf(this.a) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeLong(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\datepicker\DateValidatorPointForward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */