package org.chromium.support_lib_glue;

import android.webkit.WebView;
import com.android.webview.chromium.WebViewChromium;
import com.android.webview.chromium.WebViewChromiumAwInit;
import com.android.webview.chromium.WebViewChromiumFactoryProvider;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

final class SupportLibWebViewChromiumFactory implements WebViewProviderFactoryBoundaryInterface {
  private final WebViewChromiumAwInit mAwInit = (WebViewChromiumFactoryProvider.getSingleton()).mAwInit;
  
  private final InvocationHandler mCompatConverterAdapter = BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new SupportLibWebkitToCompatConverterAdapter());
  
  private InvocationHandler mServiceWorkerController;
  
  private InvocationHandler mStatics;
  
  private final String[] mWebViewSupportedFeatures = new String[] { 
      "VISUAL_STATE_CALLBACK", "OFF_SCREEN_PRERASTER", "SAFE_BROWSING_ENABLE", "DISABLED_ACTION_MODE_MENU_ITEMS", "START_SAFE_BROWSING", "SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_PRIVACY_POLICY_URL", "SERVICE_WORKER_BASIC_USAGE", "SERVICE_WORKER_CACHE_MODE", "SERVICE_WORKER_CONTENT_ACCESS", 
      "SERVICE_WORKER_FILE_ACCESS", "SERVICE_WORKER_BLOCK_NETWORK_LOADS", "SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST", "RECEIVE_WEB_RESOURCE_ERROR", "RECEIVE_HTTP_ERROR", "SAFE_BROWSING_HIT", "SHOULD_OVERRIDE_WITH_REDIRECTS", "WEB_RESOURCE_REQUEST_IS_REDIRECT", "WEB_RESOURCE_ERROR_GET_DESCRIPTION", "WEB_RESOURCE_ERROR_GET_CODE", 
      "SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY", "SAFE_BROWSING_RESPONSE_PROCEED", "SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL", "WEB_MESSAGE_PORT_POST_MESSAGE", "WEB_MESSAGE_PORT_CLOSE", "WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK", "CREATE_WEB_MESSAGE_CHANNEL", "POST_WEB_MESSAGE", "WEB_MESSAGE_CALLBACK_ON_MESSAGE", "GET_WEB_VIEW_CLIENT", 
      "GET_WEB_CHROME_CLIENT" };
  
  public final InvocationHandler createWebView(WebView paramWebView) {
    return BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new SupportLibWebViewChromium(((WebViewChromium)paramWebView.getWebViewProvider()).mSharedWebViewChromium));
  }
  
  public final InvocationHandler getServiceWorkerController() {
    synchronized (this.mAwInit.mLock) {
      if (this.mServiceWorkerController == null)
        this.mServiceWorkerController = BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new SupportLibServiceWorkerControllerAdapter(this.mAwInit.getServiceWorkerController())); 
      return this.mServiceWorkerController;
    } 
  }
  
  public final InvocationHandler getStatics() {
    synchronized (this.mAwInit.mLock) {
      if (this.mStatics == null) {
        (WebViewChromiumFactoryProvider.getSingleton()).mAwInit.getStatics();
        this.mStatics = BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new SupportLibWebViewChromiumFactory$StaticsAdapter());
      } 
      return this.mStatics;
    } 
  }
  
  public final String[] getSupportedFeatures() {
    return this.mWebViewSupportedFeatures;
  }
  
  public final InvocationHandler getWebkitToCompatConverter() {
    return this.mCompatConverterAdapter;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_glue\SupportLibWebViewChromiumFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */