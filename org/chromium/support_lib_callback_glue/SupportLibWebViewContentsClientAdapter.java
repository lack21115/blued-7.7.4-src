package org.chromium.support_lib_callback_glue;

import android.webkit.WebViewClient;
import org.chromium.support_lib_boundary.WebViewClientBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class SupportLibWebViewContentsClientAdapter {
  public static final String[] EMPTY_FEATURE_LIST;
  
  public WebViewClientBoundaryInterface mWebViewClient;
  
  public String[] mWebViewClientSupportedFeatures = EMPTY_FEATURE_LIST;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static boolean clientIsCompat(WebViewClient paramWebViewClient) {
    try {
      return Class.forName("androidx.webkit.WebViewClientCompat", false, paramWebViewClient.getClass().getClassLoader()).isInstance(paramWebViewClient);
    } catch (ClassNotFoundException classNotFoundException) {
      return false;
    } 
  }
  
  public final boolean isFeatureAvailable(String paramString) {
    return (this.mWebViewClient == null) ? false : BoundaryInterfaceReflectionUtil.containsFeature(this.mWebViewClientSupportedFeatures, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_callback_glue\SupportLibWebViewContentsClientAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */