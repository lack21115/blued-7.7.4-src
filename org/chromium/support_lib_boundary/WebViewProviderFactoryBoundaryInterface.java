package org.chromium.support_lib_boundary;

import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;

public interface WebViewProviderFactoryBoundaryInterface {
  InvocationHandler createWebView(WebView paramWebView);
  
  InvocationHandler getServiceWorkerController();
  
  InvocationHandler getStatics();
  
  String[] getSupportedFeatures();
  
  InvocationHandler getWebkitToCompatConverter();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_boundary\WebViewProviderFactoryBoundaryInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */