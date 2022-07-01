package org.chromium.android_webview;

import org.chromium.components.autofill.AutofillDelegate;

final class AwAutofillClient$1 implements AutofillDelegate {
  public final void dismissed() {
    AwAutofillClient.access$100(AwAutofillClient.this, AwAutofillClient.access$000(AwAutofillClient.this));
  }
  
  public final void suggestionSelected(int paramInt) {
    AwAutofillClient.access$200(AwAutofillClient.this, AwAutofillClient.access$000(AwAutofillClient.this), paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwAutofillClient$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */