package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.q;

public class b extends WebChromeClient {
  private static final String a = WebChromeClient.class.getSimpleName();
  
  private final x b;
  
  private j c;
  
  public b(x paramx, j paramj) {
    this.b = paramx;
    this.c = paramj;
  }
  
  private boolean a(String paramString) {
    try {
      Uri uri = Uri.parse(paramString);
      if ("bytedance".equals(uri.getScheme().toLowerCase())) {
        q.a(uri, this.b);
        return true;
      } 
    } catch (Exception exception) {}
    return false;
  }
  
  public void onConsoleMessage(String paramString1, int paramInt, String paramString2) {
    if (!TextUtils.isEmpty(paramString1))
      a(paramString1); 
    super.onConsoleMessage(paramString1, paramInt, paramString2);
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage) {
    return (paramConsoleMessage != null && !TextUtils.isEmpty(paramConsoleMessage.message()) && a(paramConsoleMessage.message())) ? true : super.onConsoleMessage(paramConsoleMessage);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt) {
    super.onProgressChanged(paramWebView, paramInt);
    j j1 = this.c;
    if (j1 != null)
      j1.a(paramWebView, paramInt); 
  }
  
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback) {
    super.onShowCustomView(paramView, paramCustomViewCallback);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\widget\webview\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */