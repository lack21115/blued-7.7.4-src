package org.chromium.content.browser.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.chromium.content.R;

@SuppressLint({"DefaultLocale"})
public final class MonthPicker extends TwoFieldDatePicker {
  private final String[] mShortMonths;
  
  public MonthPicker(Context paramContext, double paramDouble1, double paramDouble2) {
    super(paramContext, paramDouble1, paramDouble2);
    this.mPositionInYearSpinner.setContentDescription(getResources().getString(R.string.accessibility_date_picker_month));
    this.mShortMonths = DateFormatSymbols.getInstance(Locale.getDefault()).getShortMonths();
    if (Character.isDigit(this.mShortMonths[0].charAt(0))) {
      int i;
      for (i = 0; i < this.mShortMonths.length; i = j) {
        String[] arrayOfString = this.mShortMonths;
        int j = i + 1;
        arrayOfString[i] = String.format("%d", new Object[] { Integer.valueOf(j) });
      } 
    } 
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    init(calendar.get(1), calendar.get(2), (TwoFieldDatePicker$OnMonthOrWeekChangedListener)null);
  }
  
  public static Calendar createDateFromValue(double paramDouble) {
    int i = (int)Math.min(paramDouble / 12.0D + 1970.0D, 2.147483647E9D);
    int j = (int)(paramDouble % 12.0D);
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    calendar.clear();
    calendar.set(i, j, 1);
    return calendar;
  }
  
  protected final Calendar getDateForValue(double paramDouble) {
    return createDateFromValue(paramDouble);
  }
  
  protected final int getMaxPositionInYear(int paramInt) {
    return (paramInt == this.mMaxDate.get(1)) ? this.mMaxDate.get(2) : 11;
  }
  
  protected final int getMaxYear() {
    return this.mMaxDate.get(1);
  }
  
  protected final int getMinPositionInYear(int paramInt) {
    return (paramInt == this.mMinDate.get(1)) ? this.mMinDate.get(2) : 0;
  }
  
  protected final int getMinYear() {
    return this.mMinDate.get(1);
  }
  
  public final int getPositionInYear() {
    return this.mCurrentDate.get(2);
  }
  
  protected final void setCurrentDate(int paramInt1, int paramInt2) {
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    calendar.set(paramInt1, paramInt2, 1);
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
  
  protected final void updateSpinners() {
    super.updateSpinners();
    String[] arrayOfString = Arrays.<String>copyOfRange(this.mShortMonths, this.mPositionInYearSpinner.getMinValue(), this.mPositionInYearSpinner.getMaxValue() + 1);
    this.mPositionInYearSpinner.setDisplayedValues(arrayOfString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\MonthPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */