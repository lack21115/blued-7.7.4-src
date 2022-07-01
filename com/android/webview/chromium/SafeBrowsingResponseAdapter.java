package com.android.webview.chromium;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.webkit.SafeBrowsingResponse;
import org.chromium.android_webview.AwSafeBrowsingResponse;
import org.chromium.base.Callback;

@SuppressLint({"Override"})
@TargetApi(27)
public final class SafeBrowsingResponseAdapter extends SafeBrowsingResponse {
  public final Callback mCallback;
  
  public SafeBrowsingResponseAdapter(Callback paramCallback) {
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\SafeBrowsingResponseAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */