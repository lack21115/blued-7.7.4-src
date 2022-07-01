package org.chromium.content.browser.input;

import android.app.Activity;
import android.content.Context;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content.browser.picker.DateTimeSuggestion;
import org.chromium.content.browser.picker.InputDialogContainer;
import org.chromium.ui.base.WindowAndroid;

class DateTimeChooserAndroid {
  private final InputDialogContainer mInputDialogContainer;
  
  private final long mNativeDateTimeChooserAndroid;
  
  private DateTimeChooserAndroid(Context paramContext, long paramLong) {
    this.mNativeDateTimeChooserAndroid = paramLong;
    this.mInputDialogContainer = new InputDialogContainer(paramContext, new DateTimeChooserAndroid$1(this));
  }
  
  @CalledByNative
  private static DateTimeChooserAndroid createDateTimeChooser(WindowAndroid paramWindowAndroid, long paramLong, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, DateTimeSuggestion[] paramArrayOfDateTimeSuggestion) {
    Activity activity = paramWindowAndroid.getActivity().get();
    if (activity == null)
      return null; 
    DateTimeChooserAndroid dateTimeChooserAndroid = new DateTimeChooserAndroid((Context)activity, paramLong);
    dateTimeChooserAndroid.mInputDialogContainer.showDialog(paramInt, paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramArrayOfDateTimeSuggestion);
    return dateTimeChooserAndroid;
  }
  
  @CalledByNative
  private static DateTimeSuggestion[] createSuggestionsArray(int paramInt) {
    return new DateTimeSuggestion[paramInt];
  }
  
  private native void nativeCancelDialog(long paramLong);
  
  private native void nativeReplaceDateTime(long paramLong, double paramDouble);
  
  @CalledByNative
  private static void setDateTimeSuggestionAt(DateTimeSuggestion[] paramArrayOfDateTimeSuggestion, int paramInt, double paramDouble, String paramString1, String paramString2) {
    paramArrayOfDateTimeSuggestion[paramInt] = new DateTimeSuggestion(paramDouble, paramString1, paramString2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\DateTimeChooserAndroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */