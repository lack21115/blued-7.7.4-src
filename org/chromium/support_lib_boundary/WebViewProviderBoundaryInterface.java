package org.chromium.support_lib_boundary;

import android.net.Uri;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import java.lang.reflect.InvocationHandler;

public interface WebViewProviderBoundaryInterface {
  InvocationHandler[] createWebMessageChannel();
  
  WebChromeClient getWebChromeClient();
  
  WebViewClient getWebViewClient();
  
  void insertVisualStateCallback(long paramLong, InvocationHandler paramInvocationHandler);
  
  void postMessageToMainFrame(InvocationHandler paramInvocationHandler, Uri paramUri);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_boundary\WebViewProviderBoundaryInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */