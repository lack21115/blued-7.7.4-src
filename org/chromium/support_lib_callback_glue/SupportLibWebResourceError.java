package org.chromium.support_lib_callback_glue;

import org.chromium.android_webview.AwContentsClient;
import org.chromium.support_lib_boundary.WebResourceErrorBoundaryInterface;

public final class SupportLibWebResourceError implements WebResourceErrorBoundaryInterface {
  public AwContentsClient.AwWebResourceError mError;
  
  public SupportLibWebResourceError(AwContentsClient.AwWebResourceError paramAwWebResourceError) {
    this.mError = paramAwWebResourceError;
  }
  
  public final CharSequence getDescription() {
    return this.mError.description;
  }
  
  public final int getErrorCode() {
    return this.mError.errorCode;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_callback_glue\SupportLibWebResourceError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */