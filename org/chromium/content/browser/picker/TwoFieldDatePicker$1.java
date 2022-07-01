package org.chromium.content.browser.picker;

import android.widget.NumberPicker;

final class TwoFieldDatePicker$1 implements NumberPicker.OnValueChangeListener {
  public final void onValueChange(NumberPicker paramNumberPicker, int paramInt1, int paramInt2) {
    int i = TwoFieldDatePicker.this.getYear();
    int j = TwoFieldDatePicker.this.getPositionInYear();
    if (paramNumberPicker == TwoFieldDatePicker.access$000(TwoFieldDatePicker.this)) {
      if (paramInt1 == paramNumberPicker.getMaxValue() && paramInt2 == paramNumberPicker.getMinValue()) {
        paramInt2 = i + 1;
        paramInt1 = TwoFieldDatePicker.this.getMinPositionInYear(paramInt2);
      } else if (paramInt1 == paramNumberPicker.getMinValue() && paramInt2 == paramNumberPicker.getMaxValue()) {
        paramInt2 = i - 1;
        paramInt1 = TwoFieldDatePicker.this.getMaxPositionInYear(paramInt2);
      } else {
        paramInt1 = paramInt2;
        paramInt2 = i;
      } 
    } else if (paramNumberPicker == TwoFieldDatePicker.access$100(TwoFieldDatePicker.this)) {
      paramInt1 = j;
    } else {
      throw new IllegalArgumentException();
    } 
    TwoFieldDatePicker.this.setCurrentDate(paramInt2, paramInt1);
    TwoFieldDatePicker.this.updateSpinners();
    TwoFieldDatePicker twoFieldDatePicker = TwoFieldDatePicker.this;
    twoFieldDatePicker.sendAccessibilityEvent(4);
    if (twoFieldDatePicker.mMonthOrWeekChangedListener != null)
      twoFieldDatePicker.mMonthOrWeekChangedListener.onMonthOrWeekChanged$d8a024(twoFieldDatePicker.getYear(), twoFieldDatePicker.getPositionInYear()); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\TwoFieldDatePicker$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */