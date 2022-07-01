package com.android.webview.chromium;

import android.webkit.ValueCallback;
import org.chromium.base.Callback;

public final class CallbackConverter {
  public static Callback fromValueCallback(ValueCallback paramValueCallback) {
    return (paramValueCallback == null) ? null : new CallbackConverter$$Lambda$0(paramValueCallback);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\CallbackConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */