package org.chromium.content.browser.picker;

import android.widget.NumberPicker;

final class MultiFieldTimePickerDialog$NumberFormatter implements NumberPicker.Formatter {
  private final String mFormat;
  
  MultiFieldTimePickerDialog$NumberFormatter(String paramString) {
    this.mFormat = paramString;
  }
  
  public final String format(int paramInt) {
    return String.format(this.mFormat, new Object[] { Integer.valueOf(paramInt) });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\MultiFieldTimePickerDialog$NumberFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */