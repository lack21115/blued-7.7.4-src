package org.chromium.android_webview;

import org.chromium.base.ThreadUtils;

final class JsResultHandler implements JsPromptResultReceiver, JsResultReceiver {
  AwContentsClientBridge mBridge;
  
  final int mId;
  
  JsResultHandler(AwContentsClientBridge paramAwContentsClientBridge, int paramInt) {
    this.mBridge = paramAwContentsClientBridge;
    this.mId = paramInt;
  }
  
  public final void cancel() {
    ThreadUtils.runOnUiThread(new JsResultHandler$$Lambda$1(this));
  }
  
  public final void confirm() {
    confirm(null);
  }
  
  public final void confirm(String paramString) {
    ThreadUtils.runOnUiThread(new JsResultHandler$$Lambda$0(this, paramString));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\JsResultHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */