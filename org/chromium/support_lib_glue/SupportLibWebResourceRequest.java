package org.chromium.support_lib_glue;

import org.chromium.android_webview.AwContentsClient;
import org.chromium.support_lib_boundary.WebResourceRequestBoundaryInterface;

public final class SupportLibWebResourceRequest implements WebResourceRequestBoundaryInterface {
  private final AwContentsClient.AwWebResourceRequest mAwRequest;
  
  SupportLibWebResourceRequest(AwContentsClient.AwWebResourceRequest paramAwWebResourceRequest) {
    this.mAwRequest = paramAwWebResourceRequest;
  }
  
  public final boolean isRedirect() {
    return this.mAwRequest.isRedirect;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_glue\SupportLibWebResourceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */