package com.bytedance.sdk.openadsdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.core.x;

public class q {
  public static String a(WebView paramWebView, int paramInt) {
    if (paramWebView == null)
      return ""; 
    String str = paramWebView.getSettings().getUserAgentString();
    if (TextUtils.isEmpty(str))
      return ""; 
    StringBuilder stringBuilder = new StringBuilder(str);
    stringBuilder.append(" open_news");
    stringBuilder.append(" open_news_u_s/");
    stringBuilder.append(paramInt);
    return stringBuilder.toString();
  }
  
  public static void a(Uri paramUri, x paramx) {
    if (paramx != null && paramx.a(paramUri))
      try {
        paramx.b(paramUri);
        return;
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TTAndroidObj handleUri exception: ");
        stringBuilder.append(exception);
        t.d("WebView", stringBuilder.toString());
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */