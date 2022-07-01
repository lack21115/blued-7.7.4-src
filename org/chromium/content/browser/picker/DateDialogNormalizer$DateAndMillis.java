package org.chromium.content.browser.picker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

final class DateDialogNormalizer$DateAndMillis {
  public final int day;
  
  public final long millisForPicker;
  
  public final int month;
  
  public final int year;
  
  private DateDialogNormalizer$DateAndMillis(long paramLong, int paramInt1, int paramInt2, int paramInt3) {
    this.millisForPicker = paramLong;
    this.year = paramInt1;
    this.month = paramInt2;
    this.day = paramInt3;
  }
  
  static DateDialogNormalizer$DateAndMillis create(int paramInt1, int paramInt2, int paramInt3) {
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    calendar.clear();
    calendar.set(paramInt1, paramInt2, paramInt3);
    return new DateDialogNormalizer$DateAndMillis(calendar.getTimeInMillis(), paramInt1, paramInt2, paramInt3);
  }
  
  static DateDialogNormalizer$DateAndMillis create(long paramLong) {
    GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
    gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
    gregorianCalendar.setTimeInMillis(paramLong);
    return create(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\DateDialogNormalizer$DateAndMillis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */