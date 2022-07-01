package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public class DateValidatorPointBackward implements CalendarConstraints.DateValidator {
  public static final Parcelable.Creator<DateValidatorPointBackward> CREATOR = new Parcelable.Creator<DateValidatorPointBackward>() {
      public DateValidatorPointBackward a(Parcel param1Parcel) {
        return new DateValidatorPointBackward(param1Parcel.readLong());
      }
      
      public DateValidatorPointBackward[] a(int param1Int) {
        return new DateValidatorPointBackward[param1Int];
      }
    };
  
  private final long a;
  
  private DateValidatorPointBackward(long paramLong) {
    this.a = paramLong;
  }
  
  public boolean a(long paramLong) {
    return (paramLong <= this.a);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof DateValidatorPointBackward))
      return false; 
    paramObject = paramObject;
    return (this.a == ((DateValidatorPointBackward)paramObject).a);
  }
  
  public int hashCode() {
    return Arrays.hashCode(new Object[] { Long.valueOf(this.a) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeLong(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\datepicker\DateValidatorPointBackward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */