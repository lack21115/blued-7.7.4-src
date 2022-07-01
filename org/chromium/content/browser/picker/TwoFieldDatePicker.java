package org.chromium.content.browser.picker;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.chromium.content.R;

public abstract class TwoFieldDatePicker extends FrameLayout {
  Calendar mCurrentDate;
  
  Calendar mMaxDate;
  
  Calendar mMinDate;
  
  TwoFieldDatePicker$OnMonthOrWeekChangedListener mMonthOrWeekChangedListener;
  
  final NumberPicker mPositionInYearSpinner;
  
  private final NumberPicker mYearSpinner;
  
  public TwoFieldDatePicker(Context paramContext, double paramDouble1, double paramDouble2) {
    super(paramContext, null, 16843612);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(R.layout.two_field_date_picker, (ViewGroup)this, true);
    TwoFieldDatePicker$1 twoFieldDatePicker$1 = new TwoFieldDatePicker$1(this);
    this.mCurrentDate = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    if (paramDouble1 >= paramDouble2) {
      this.mMinDate = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
      this.mMinDate.set(0, 0, 1);
      this.mMaxDate = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
      this.mMaxDate.set(9999, 0, 1);
    } else {
      this.mMinDate = getDateForValue(paramDouble1);
      this.mMaxDate = getDateForValue(paramDouble2);
    } 
    this.mPositionInYearSpinner = (NumberPicker)findViewById(R.id.position_in_year);
    this.mPositionInYearSpinner.setOnLongPressUpdateInterval(200L);
    this.mPositionInYearSpinner.setOnValueChangedListener(twoFieldDatePicker$1);
    this.mYearSpinner = (NumberPicker)findViewById(R.id.year);
    this.mYearSpinner.setOnLongPressUpdateInterval(100L);
    this.mYearSpinner.setOnValueChangedListener(twoFieldDatePicker$1);
    reorderSpinners();
  }
  
  @TargetApi(18)
  private void reorderSpinners() {
    boolean bool;
    StringBuilder stringBuilder;
    LinearLayout linearLayout = (LinearLayout)findViewById(R.id.pickers);
    linearLayout.removeView((View)this.mPositionInYearSpinner);
    linearLayout.removeView((View)this.mYearSpinner);
    int i = Build.VERSION.SDK_INT;
    int k = 0;
    int j = 0;
    if (i >= 18) {
      String str = DateFormat.getBestDateTimePattern(Locale.getDefault(), "yyyyMMMdd");
      boolean bool1 = false;
      for (i = 0; j < str.length(); i = m) {
        boolean bool2;
        int m;
        char c = str.charAt(j);
        if (c == '\'') {
          k = str.indexOf('\'', j + 1);
          if (k != -1) {
            bool2 = bool1;
            m = i;
          } else {
            stringBuilder = new StringBuilder("Bad quoting in ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
          } 
        } else if ((c == 'M' || c == 'L') && !bool1) {
          stringBuilder.addView((View)this.mPositionInYearSpinner);
          bool2 = true;
          k = j;
          m = i;
        } else {
          k = j;
          bool2 = bool1;
          m = i;
          if (c == 'y') {
            k = j;
            bool2 = bool1;
            m = i;
            if (i == 0) {
              stringBuilder.addView((View)this.mYearSpinner);
              m = 1;
              bool2 = bool1;
              k = j;
            } 
          } 
        } 
        j = k + 1;
        bool1 = bool2;
      } 
      k = bool1;
      bool = i;
    } else {
      char[] arrayOfChar = DateFormat.getDateFormatOrder(getContext());
      i = 0;
      boolean bool1 = false;
      j = k;
      while (true) {
        k = i;
        bool = bool1;
        if (j < arrayOfChar.length) {
          if (arrayOfChar[j] == 'M') {
            stringBuilder.addView((View)this.mPositionInYearSpinner);
            k = 1;
          } else {
            k = i;
            if (arrayOfChar[j] == 'y') {
              stringBuilder.addView((View)this.mYearSpinner);
              bool1 = true;
              k = i;
            } 
          } 
          j++;
          i = k;
          continue;
        } 
        break;
      } 
    } 
    if (k == 0)
      stringBuilder.addView((View)this.mPositionInYearSpinner); 
    if (!bool)
      stringBuilder.addView((View)this.mYearSpinner); 
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    onPopulateAccessibilityEvent(paramAccessibilityEvent);
    return true;
  }
  
  protected abstract Calendar getDateForValue(double paramDouble);
  
  protected abstract int getMaxPositionInYear(int paramInt);
  
  protected abstract int getMaxYear();
  
  protected abstract int getMinPositionInYear(int paramInt);
  
  protected abstract int getMinYear();
  
  public abstract int getPositionInYear();
  
  public int getYear() {
    return this.mCurrentDate.get(1);
  }
  
  public final void init(int paramInt1, int paramInt2, TwoFieldDatePicker$OnMonthOrWeekChangedListener paramTwoFieldDatePicker$OnMonthOrWeekChangedListener) {
    setCurrentDate(paramInt1, paramInt2);
    updateSpinners();
    this.mMonthOrWeekChangedListener = paramTwoFieldDatePicker$OnMonthOrWeekChangedListener;
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    String str = DateUtils.formatDateTime(getContext(), this.mCurrentDate.getTimeInMillis(), 20);
    paramAccessibilityEvent.getText().add(str);
  }
  
  protected abstract void setCurrentDate(int paramInt1, int paramInt2);
  
  protected void updateSpinners() {
    boolean bool;
    this.mPositionInYearSpinner.setDisplayedValues(null);
    this.mPositionInYearSpinner.setMinValue(getMinPositionInYear(getYear()));
    this.mPositionInYearSpinner.setMaxValue(getMaxPositionInYear(getYear()));
    NumberPicker numberPicker = this.mPositionInYearSpinner;
    if (!this.mCurrentDate.equals(this.mMinDate) && !this.mCurrentDate.equals(this.mMaxDate)) {
      bool = true;
    } else {
      bool = false;
    } 
    numberPicker.setWrapSelectorWheel(bool);
    this.mYearSpinner.setMinValue(getMinYear());
    this.mYearSpinner.setMaxValue(getMaxYear());
    this.mYearSpinner.setWrapSelectorWheel(false);
    this.mYearSpinner.setValue(getYear());
    this.mPositionInYearSpinner.setValue(getPositionInYear());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\TwoFieldDatePicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */