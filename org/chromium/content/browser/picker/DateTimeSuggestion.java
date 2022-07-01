package org.chromium.content.browser.picker;

import android.text.TextUtils;

public class DateTimeSuggestion {
  final String mLabel;
  
  final String mLocalizedValue;
  
  final double mValue;
  
  public DateTimeSuggestion(double paramDouble, String paramString1, String paramString2) {
    this.mValue = paramDouble;
    this.mLocalizedValue = paramString1;
    this.mLabel = paramString2;
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof DateTimeSuggestion))
      return false; 
    paramObject = paramObject;
    return (this.mValue == ((DateTimeSuggestion)paramObject).mValue && TextUtils.equals(this.mLocalizedValue, ((DateTimeSuggestion)paramObject).mLocalizedValue) && TextUtils.equals(this.mLabel, ((DateTimeSuggestion)paramObject).mLabel));
  }
  
  public int hashCode() {
    return (((int)this.mValue + 1147) * 37 + this.mLocalizedValue.hashCode()) * 37 + this.mLabel.hashCode();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\DateTimeSuggestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */