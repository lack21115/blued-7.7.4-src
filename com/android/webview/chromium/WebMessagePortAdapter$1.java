package com.android.webview.chromium;

import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import org.chromium.content_public.browser.MessagePort;

final class WebMessagePortAdapter$1 implements MessagePort.MessageCallback {
  public final void onMessage(String paramString, MessagePort[] paramArrayOfMessagePort) {
    callback.onMessage(WebMessagePortAdapter.this, new WebMessage(paramString, WebMessagePortAdapter.fromMessagePorts(paramArrayOfMessagePort)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebMessagePortAdapter$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */