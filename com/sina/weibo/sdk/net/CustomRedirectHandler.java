package com.sina.weibo.sdk.net;

import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.RedirectHandler;
import org.apache.http.protocol.HttpContext;

public abstract class CustomRedirectHandler implements RedirectHandler {
  private static final int MAX_REDIRECT_COUNT = 15;
  
  private static final String TAG = CustomRedirectHandler.class.getCanonicalName();
  
  int redirectCount;
  
  String redirectUrl;
  
  private String tempRedirectUrl;
  
  public URI getLocationURI(HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws ProtocolException {
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder("CustomRedirectHandler getLocationURI getRedirectUrl : ");
    stringBuilder.append(this.tempRedirectUrl);
    LogUtil.d(str, stringBuilder.toString());
    return !TextUtils.isEmpty(this.tempRedirectUrl) ? URI.create(this.tempRedirectUrl) : null;
  }
  
  public int getRedirectCount() {
    return this.redirectCount;
  }
  
  public String getRedirectUrl() {
    return this.redirectUrl;
  }
  
  public boolean isRedirectRequested(HttpResponse paramHttpResponse, HttpContext paramHttpContext) {
    int i = paramHttpResponse.getStatusLine().getStatusCode();
    if (i == 301 || i == 302) {
      this.tempRedirectUrl = paramHttpResponse.getFirstHeader("Location").getValue();
      if (!TextUtils.isEmpty(this.tempRedirectUrl) && this.redirectCount < 15 && shouldRedirectUrl(this.tempRedirectUrl)) {
        this.redirectCount++;
        return true;
      } 
      return false;
    } 
    if (i == 200) {
      this.redirectUrl = this.tempRedirectUrl;
    } else {
      onReceivedException();
    } 
    return false;
  }
  
  public abstract void onReceivedException();
  
  public abstract boolean shouldRedirectUrl(String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\net\CustomRedirectHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */