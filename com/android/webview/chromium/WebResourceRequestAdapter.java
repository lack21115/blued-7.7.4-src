package com.android.webview.chromium;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import java.util.Map;
import org.chromium.android_webview.AwContentsClient;

public final class WebResourceRequestAdapter implements WebResourceRequest {
  public final AwContentsClient.AwWebResourceRequest mRequest;
  
  public WebResourceRequestAdapter(AwContentsClient.AwWebResourceRequest paramAwWebResourceRequest) {
    this.mRequest = paramAwWebResourceRequest;
  }
  
  public final String getMethod() {
    return this.mRequest.method;
  }
  
  public final Map getRequestHeaders() {
    return this.mRequest.requestHeaders;
  }
  
  public final Uri getUrl() {
    return Uri.parse(this.mRequest.url);
  }
  
  public final boolean hasGesture() {
    return this.mRequest.hasUserGesture;
  }
  
  public final boolean isForMainFrame() {
    return this.mRequest.isMainFrame;
  }
  
  public final boolean isRedirect() {
    return this.mRequest.isRedirect;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebResourceRequestAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */