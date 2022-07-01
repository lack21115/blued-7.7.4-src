package org.chromium.android_webview;

import android.content.Context;
import java.util.concurrent.TimeUnit;
import org.chromium.base.metrics.RecordHistogram;

public final class AwAutofillUMA {
  private static final long MAX_TIME_MILLIS = 0L;
  
  Boolean mAutofillDisabled;
  
  AwAutofillUMA$SessionRecorder mRecorder;
  
  static {
    TimeUnit timeUnit = TimeUnit.SECONDS;
    throw new VerifyError("bad dex opcode");
  }
  
  public AwAutofillUMA(Context paramContext) {
    boolean bool;
    if (AwContents.activityFromContext(paramContext) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    RecordHistogram.recordBooleanHistogram("Autofill.WebView.CreatedByActivityContext", bool);
  }
  
  static int toUMASubmissionSource(int paramInt) {
    switch (paramInt) {
      default:
        return 6;
      case 5:
        return 5;
      case 4:
        return 4;
      case 3:
        return 3;
      case 2:
        return 2;
      case 1:
        return 1;
      case 0:
        break;
    } 
    return 0;
  }
  
  final void recordSession() {
    if (this.mAutofillDisabled != null && !this.mAutofillDisabled.booleanValue() && this.mRecorder != null) {
      AwAutofillUMA$SessionRecorder awAutofillUMA$SessionRecorder = this.mRecorder;
      int i = awAutofillUMA$SessionRecorder.mState;
      byte b = 11;
      if (i == 0) {
        b = 1;
      } else if (awAutofillUMA$SessionRecorder.mState == 1) {
        b = 5;
      } else if (awAutofillUMA$SessionRecorder.mState == 9) {
        b = 3;
      } else if (awAutofillUMA$SessionRecorder.mState == 17) {
        b = 4;
      } else if (awAutofillUMA$SessionRecorder.mState == 25) {
        b = 2;
      } else if (awAutofillUMA$SessionRecorder.mState == 7) {
        b = 9;
      } else if (awAutofillUMA$SessionRecorder.mState == 23) {
        b = 8;
      } else if (awAutofillUMA$SessionRecorder.mState == 31) {
        b = 6;
      } else if (awAutofillUMA$SessionRecorder.mState == 15) {
        b = 7;
      } else if (awAutofillUMA$SessionRecorder.mState == 3) {
        b = 13;
      } else if (awAutofillUMA$SessionRecorder.mState == 19) {
        b = 12;
      } else if (awAutofillUMA$SessionRecorder.mState == 27) {
        b = 10;
      } else if (awAutofillUMA$SessionRecorder.mState != 11) {
        b = 0;
      } 
      RecordHistogram.recordEnumeratedHistogram("Autofill.WebView.AutofillSession", b, 14);
      if (awAutofillUMA$SessionRecorder.mUserChangedAutofilledField != null)
        RecordHistogram.recordBooleanHistogram("Autofill.WebView.UserChangedAutofilledField", awAutofillUMA$SessionRecorder.mUserChangedAutofilledField.booleanValue()); 
      if (awAutofillUMA$SessionRecorder.mSuggestionTimeMillis != null)
        RecordHistogram.recordCustomTimesHistogram("Autofill.WebView.SuggestionTime", awAutofillUMA$SessionRecorder.mSuggestionTimeMillis.longValue(), 10L, MAX_TIME_MILLIS, TimeUnit.MILLISECONDS, 50); 
    } 
    this.mRecorder = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwAutofillUMA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */