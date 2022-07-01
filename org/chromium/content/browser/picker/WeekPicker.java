package org.chromium.content.browser.picker;

import android.content.Context;
import java.util.Calendar;
import java.util.TimeZone;
import org.chromium.content.R;

public final class WeekPicker extends TwoFieldDatePicker {
  public WeekPicker(Context paramContext, double paramDouble1, double paramDouble2) {
    super(paramContext, paramDouble1, paramDouble2);
    this.mPositionInYearSpinner.setContentDescription(getResources().getString(R.string.accessibility_date_picker_week));
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    calendar.setFirstDayOfWeek(2);
    calendar.setMinimalDaysInFirstWeek(4);
    calendar.setTimeInMillis(System.currentTimeMillis());
    init(getISOWeekYearForDate(calendar), calendar.get(3), (TwoFieldDatePicker$OnMonthOrWeekChangedListener)null);
  }
  
  public static Calendar createDateFromValue(double paramDouble) {
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    calendar.clear();
    calendar.setFirstDayOfWeek(2);
    calendar.setMinimalDaysInFirstWeek(4);
    calendar.setTimeInMillis((long)paramDouble);
    return calendar;
  }
  
  public static Calendar createDateFromWeek(int paramInt1, int paramInt2) {
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    calendar.clear();
    calendar.setFirstDayOfWeek(2);
    calendar.setMinimalDaysInFirstWeek(4);
    calendar.set(7, 2);
    calendar.set(1, paramInt1);
    calendar.set(3, paramInt2);
    return calendar;
  }
  
  public static int getISOWeekYearForDate(Calendar paramCalendar) {
    int j = paramCalendar.get(1);
    int k = paramCalendar.get(2);
    int m = paramCalendar.get(3);
    if (k == 0 && m > 51)
      return j - 1; 
    int i = j;
    if (k == 11) {
      i = j;
      if (m == 1)
        i = j + 1; 
    } 
    return i;
  }
  
  public static int getWeekForDate(Calendar paramCalendar) {
    return paramCalendar.get(3);
  }
  
  protected final Calendar getDateForValue(double paramDouble) {
    return createDateFromValue(paramDouble);
  }
  
  protected final int getMaxPositionInYear(int paramInt) {
    return (paramInt == getISOWeekYearForDate(this.mMaxDate)) ? this.mMaxDate.get(3) : createDateFromWeek(paramInt, 20).getActualMaximum(3);
  }
  
  protected final int getMaxYear() {
    return getISOWeekYearForDate(this.mMaxDate);
  }
  
  protected final int getMinPositionInYear(int paramInt) {
    return (paramInt == getISOWeekYearForDate(this.mMinDate)) ? this.mMinDate.get(3) : 1;
  }
  
  protected final int getMinYear() {
    return getISOWeekYearForDate(this.mMinDate);
  }
  
  public final int getPositionInYear() {
    return this.mCurrentDate.get(3);
  }
  
  public final int getYear() {
    return getISOWeekYearForDate(this.mCurrentDate);
  }
  
  protected final void setCurrentDate(int paramInt1, int paramInt2) {
    Calendar calendar = createDateFromWeek(paramInt1, paramInt2);
    if (calendar.before(this.mMinDate)) {
      this.mCurrentDate = this.mMinDate;
      return;
    } 
    if (calendar.after(this.mMaxDate)) {
      this.mCurrentDate = this.mMaxDate;
      return;
    } 
    this.mCurrentDate = calendar;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\WeekPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */