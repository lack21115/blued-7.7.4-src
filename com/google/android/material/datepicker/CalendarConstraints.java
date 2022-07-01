package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class CalendarConstraints implements Parcelable {
  public static final Parcelable.Creator<CalendarConstraints> CREATOR = new Parcelable.Creator<CalendarConstraints>() {
      public CalendarConstraints a(Parcel param1Parcel) {
        return new CalendarConstraints((Month)param1Parcel.readParcelable(Month.class.getClassLoader()), (Month)param1Parcel.readParcelable(Month.class.getClassLoader()), (Month)param1Parcel.readParcelable(Month.class.getClassLoader()), (CalendarConstraints.DateValidator)param1Parcel.readParcelable(CalendarConstraints.DateValidator.class.getClassLoader()));
      }
      
      public CalendarConstraints[] a(int param1Int) {
        return new CalendarConstraints[param1Int];
      }
    };
  
  private final Month a;
  
  private final Month b;
  
  private final Month c;
  
  private final DateValidator d;
  
  private final int e;
  
  private final int f;
  
  private CalendarConstraints(Month paramMonth1, Month paramMonth2, Month paramMonth3, DateValidator paramDateValidator) {
    this.a = paramMonth1;
    this.b = paramMonth2;
    this.c = paramMonth3;
    this.d = paramDateValidator;
    if (paramMonth1.a(paramMonth3) <= 0) {
      if (paramMonth3.a(paramMonth2) <= 0) {
        this.f = paramMonth1.b(paramMonth2) + 1;
        this.e = paramMonth2.b - paramMonth1.b + 1;
        return;
      } 
      throw new IllegalArgumentException("current Month cannot be after end Month");
    } 
    throw new IllegalArgumentException("start Month cannot be after current Month");
  }
  
  public DateValidator a() {
    return this.d;
  }
  
  Month a(Month paramMonth) {
    if (paramMonth.a(this.a) < 0)
      return this.a; 
    Month month = paramMonth;
    if (paramMonth.a(this.b) > 0)
      month = this.b; 
    return month;
  }
  
  boolean a(long paramLong) {
    if (this.a.a(1) <= paramLong) {
      Month month = this.b;
      if (paramLong <= month.a(month.d))
        return true; 
    } 
    return false;
  }
  
  Month b() {
    return this.a;
  }
  
  Month c() {
    return this.b;
  }
  
  Month d() {
    return this.c;
  }
  
  public int describeContents() {
    return 0;
  }
  
  int e() {
    return this.f;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof CalendarConstraints))
      return false; 
    paramObject = paramObject;
    return (this.a.equals(((CalendarConstraints)paramObject).a) && this.b.equals(((CalendarConstraints)paramObject).b) && this.c.equals(((CalendarConstraints)paramObject).c) && this.d.equals(((CalendarConstraints)paramObject).d));
  }
  
  int f() {
    return this.e;
  }
  
  public int hashCode() {
    return Arrays.hashCode(new Object[] { this.a, this.b, this.c, this.d });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeParcelable(this.a, 0);
    paramParcel.writeParcelable(this.b, 0);
    paramParcel.writeParcelable(this.c, 0);
    paramParcel.writeParcelable(this.d, 0);
  }
  
  public static final class Builder {
    static final long a = UtcDates.a((Month.a(1900, 0)).e);
    
    static final long b = UtcDates.a((Month.a(2100, 11)).e);
    
    private long c = a;
    
    private long d = b;
    
    private Long e;
    
    private CalendarConstraints.DateValidator f = DateValidatorPointForward.b(Long.MIN_VALUE);
    
    public Builder() {}
    
    Builder(CalendarConstraints param1CalendarConstraints) {
      this.c = (CalendarConstraints.a(param1CalendarConstraints)).e;
      this.d = (CalendarConstraints.b(param1CalendarConstraints)).e;
      this.e = Long.valueOf((CalendarConstraints.c(param1CalendarConstraints)).e);
      this.f = CalendarConstraints.d(param1CalendarConstraints);
    }
    
    public Builder a(long param1Long) {
      this.e = Long.valueOf(param1Long);
      return this;
    }
    
    public CalendarConstraints a() {
      if (this.e == null) {
        long l = MaterialDatePicker.a();
        if (this.c > l || l > this.d)
          l = this.c; 
        this.e = Long.valueOf(l);
      } 
      Bundle bundle = new Bundle();
      bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f);
      return new CalendarConstraints(Month.a(this.c), Month.a(this.d), Month.a(this.e.longValue()), (CalendarConstraints.DateValidator)bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY"));
    }
  }
  
  public static interface DateValidator extends Parcelable {
    boolean a(long param1Long);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\datepicker\CalendarConstraints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */