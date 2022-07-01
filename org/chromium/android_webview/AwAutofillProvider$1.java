package org.chromium.android_webview;

final class AwAutofillProvider$1 implements AwAutofillManager$InputUIObserver {
  public final void onInputUIShown() {
    if (AwAutofillProvider.access$000(AwAutofillProvider.this) == null)
      return; 
    AwAutofillUMA awAutofillUMA = AwAutofillProvider.access$200(AwAutofillProvider.this);
    long l1 = System.currentTimeMillis();
    long l2 = AwAutofillProvider.access$100(AwAutofillProvider.this);
    if (awAutofillUMA.mRecorder != null) {
      awAutofillUMA.mRecorder.record(2);
      AwAutofillUMA$SessionRecorder awAutofillUMA$SessionRecorder = awAutofillUMA.mRecorder;
      if (awAutofillUMA$SessionRecorder.mSuggestionTimeMillis == null)
        awAutofillUMA$SessionRecorder.mSuggestionTimeMillis = Long.valueOf(l1 - l2); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwAutofillProvider$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */