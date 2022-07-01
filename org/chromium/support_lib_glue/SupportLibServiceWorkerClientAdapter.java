package org.chromium.support_lib_glue;

import android.webkit.WebResourceRequest;
import com.android.webview.chromium.ServiceWorkerClientAdapter;
import com.android.webview.chromium.WebResourceRequestAdapter;
import org.chromium.android_webview.AwContentsClient;
import org.chromium.android_webview.AwServiceWorkerClient;
import org.chromium.android_webview.AwWebResourceResponse;
import org.chromium.support_lib_boundary.ServiceWorkerClientBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

final class SupportLibServiceWorkerClientAdapter extends AwServiceWorkerClient {
  private ServiceWorkerClientBoundaryInterface mImpl;
  
  SupportLibServiceWorkerClientAdapter(ServiceWorkerClientBoundaryInterface paramServiceWorkerClientBoundaryInterface) {
    this.mImpl = paramServiceWorkerClientBoundaryInterface;
  }
  
  public final AwWebResourceResponse shouldInterceptRequest(AwContentsClient.AwWebResourceRequest paramAwWebResourceRequest) {
    return !BoundaryInterfaceReflectionUtil.containsFeature(this.mImpl.getSupportedFeatures(), "SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST") ? null : ServiceWorkerClientAdapter.fromWebResourceResponse(this.mImpl.shouldInterceptRequest((WebResourceRequest)new WebResourceRequestAdapter(paramAwWebResourceRequest)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_glue\SupportLibServiceWorkerClientAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */