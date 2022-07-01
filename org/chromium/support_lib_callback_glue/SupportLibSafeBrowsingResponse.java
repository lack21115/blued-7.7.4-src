package org.chromium.support_lib_callback_glue;

import org.chromium.android_webview.AwSafeBrowsingResponse;
import org.chromium.base.Callback;
import org.chromium.support_lib_boundary.SafeBrowsingResponseBoundaryInterface;

public final class SupportLibSafeBrowsingResponse implements SafeBrowsingResponseBoundaryInterface {
  public final Callback mCallback;
  
  public SupportLibSafeBrowsingResponse(Callback paramCallback) {
    this.mCallback = paramCallback;
  }
  
  public final void backToSafety(boolean paramBoolean) {
    this.mCallback.onResult(new AwSafeBrowsingResponse(2, paramBoolean));
  }
  
  public final void proceed(boolean paramBoolean) {
    this.mCallback.onResult(new AwSafeBrowsingResponse(1, paramBoolean));
  }
  
  public final void showInterstitial(boolean paramBoolean) {
    this.mCallback.onResult(new AwSafeBrowsingResponse(0, paramBoolean));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_callback_glue\SupportLibSafeBrowsingResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */