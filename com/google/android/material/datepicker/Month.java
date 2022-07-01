package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;

final class Month implements Parcelable, Comparable<Month> {
  public static final Parcelable.Creator<Month> CREATOR = new Parcelable.Creator<Month>() {
      public Month a(Parcel param1Parcel) {
        return Month.a(param1Parcel.readInt(), param1Parcel.readInt());
      }
      
      public Month[] a(int param1Int) {
        return new Month[param1Int];
      }
    };
  
  final int a;
  
  final int b;
  
  final int c;
  
  final int d;
  
  final long e;
  
  private final Calendar f;
  
  private final String g;
  
  private Month(Calendar paramCalendar) {
    paramCalendar.set(5, 1);
    this.f = UtcDates.b(paramCalendar);
    this.a = this.f.get(2);
    this.b = this.f.get(1);
    this.c = this.f.getMaximum(7);
    this.d = this.f.getActualMaximum(5);
    this.g = UtcDates.e().format(this.f.getTime());
    this.e = this.f.getTimeInMillis();
  }
  
  static Month a() {
    return new Month(UtcDates.b());
  }
  
  static Month a(int paramInt1, int paramInt2) {
    Calendar calendar = UtcDates.c();
    calendar.set(1, paramInt1);
    calendar.set(2, paramInt2);
    return new Month(calendar);
  }
  
  static Month a(long paramLong) {
    Calendar calendar = UtcDates.c();
    calendar.setTimeInMillis(paramLong);
    return new Month(calendar);
  }
  
  public int a(Month paramMonth) {
    return this.f.compareTo(paramMonth.f);
  }
  
  long a(int paramInt) {
    Calendar calendar = UtcDates.b(this.f);
    calendar.set(5, paramInt);
    return calendar.getTimeInMillis();
  }
  
  int b() {
    int j = this.f.get(7) - this.f.getFirstDayOfWeek();
    int i = j;
    if (j < 0)
      i = j + this.c; 
    return i;
  }
  
  int b(Month paramMonth) {
    if (this.f instanceof java.util.GregorianCalendar)
      return (paramMonth.b - this.b) * 12 + paramMonth.a - this.a; 
    throw new IllegalArgumentException("Only Gregorian calendars are supported.");
  }
  
  Month b(int paramInt) {
    Calendar calendar = UtcDates.b(this.f);
    calendar.add(2, paramInt);
    return new Month(calendar);
  }
  
  long c() {
    return this.f.getTimeInMillis();
  }
  
  String d() {
    return this.g;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof Month))
      return false; 
    paramObject = paramObject;
    return (this.a == ((Month)paramObject).a && this.b == ((Month)paramObject).b);
  }
  
  public int hashCode() {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\datepicker\Month.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */