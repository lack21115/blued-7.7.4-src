package org.chromium.android_webview;

final class AwAutofillUMA$SessionRecorder {
  int mState;
  
  Long mSuggestionTimeMillis;
  
  Boolean mUserChangedAutofilledField;
  
  private AwAutofillUMA$SessionRecorder() {}
  
  public final void record(int paramInt) {
    int i;
    if (paramInt != 1 && this.mState == 0)
      return; 
    if (8 == paramInt && this.mUserChangedAutofilledField == null) {
      this.mUserChangedAutofilledField = Boolean.valueOf(false);
      i = paramInt;
    } else {
      i = paramInt;
      if (32 == paramInt) {
        if (this.mUserChangedAutofilledField == null)
          this.mUserChangedAutofilledField = Boolean.valueOf(true); 
        this.mUserChangedAutofilledField = Boolean.valueOf(true);
        i = 8;
      } 
    } 
    this.mState = i | this.mState;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwAutofillUMA$SessionRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */