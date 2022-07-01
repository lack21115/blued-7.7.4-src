package org.chromium.content.browser.picker;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;

final class DateTimePickerDialog$WorkaroundContextForSamsungLDateTimeBug extends ContextWrapper {
  private Resources mWrappedResources;
  
  private DateTimePickerDialog$WorkaroundContextForSamsungLDateTimeBug(Context paramContext) {
    super(paramContext);
  }
  
  public final Resources getResources() {
    if (this.mWrappedResources == null) {
      Resources resources = super.getResources();
      this.mWrappedResources = new DateTimePickerDialog$WorkaroundContextForSamsungLDateTimeBug$1(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
    } 
    return this.mWrappedResources;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\DateTimePickerDialog$WorkaroundContextForSamsungLDateTimeBug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */