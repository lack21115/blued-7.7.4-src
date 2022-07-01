package com.android.webview.chromium;

import android.annotation.TargetApi;
import android.webkit.ServiceWorkerClient;
import android.webkit.WebResourceResponse;
import java.util.HashMap;
import java.util.Map;
import org.chromium.android_webview.AwContentsClient;
import org.chromium.android_webview.AwServiceWorkerClient;
import org.chromium.android_webview.AwWebResourceResponse;

@TargetApi(24)
public final class ServiceWorkerClientAdapter extends AwServiceWorkerClient {
  private ServiceWorkerClient mServiceWorkerClient;
  
  public ServiceWorkerClientAdapter(ServiceWorkerClient paramServiceWorkerClient) {
    this.mServiceWorkerClient = paramServiceWorkerClient;
  }
  
  public static AwWebResourceResponse fromWebResourceResponse(WebResourceResponse paramWebResourceResponse) {
    if (paramWebResourceResponse == null)
      return null; 
    Map<Object, Object> map2 = paramWebResourceResponse.getResponseHeaders();
    Map<Object, Object> map1 = map2;
    if (map2 == null)
      map1 = new HashMap<Object, Object>(); 
    return new AwWebResourceResponse(paramWebResourceResponse.getMimeType(), paramWebResourceResponse.getEncoding(), paramWebResourceResponse.getData(), paramWebResourceResponse.getStatusCode(), paramWebResourceResponse.getReasonPhrase(), map1);
  }
  
  public final AwWebResourceResponse shouldInterceptRequest(AwContentsClient.AwWebResourceRequest paramAwWebResourceRequest) {
    return fromWebResourceResponse(this.mServiceWorkerClient.shouldInterceptRequest(new WebResourceRequestAdapter(paramAwWebResourceRequest)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\ServiceWorkerClientAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */