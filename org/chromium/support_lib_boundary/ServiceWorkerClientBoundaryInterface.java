package org.chromium.support_lib_boundary;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;

public interface ServiceWorkerClientBoundaryInterface extends FeatureFlagHolderBoundaryInterface {
  WebResourceResponse shouldInterceptRequest(WebResourceRequest paramWebResourceRequest);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_boundary\ServiceWorkerClientBoundaryInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */