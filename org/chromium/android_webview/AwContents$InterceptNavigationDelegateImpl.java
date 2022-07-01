package org.chromium.android_webview;

import org.chromium.components.navigation_interception.InterceptNavigationDelegate;
import org.chromium.components.navigation_interception.NavigationParams;

final class AwContents$InterceptNavigationDelegateImpl implements InterceptNavigationDelegate {
  private AwContents$InterceptNavigationDelegateImpl() {}
  
  public final boolean shouldIgnoreNavigation(NavigationParams paramNavigationParams) {
    AwContentsClientCallbackHelper awContentsClientCallbackHelper = (AwContents.access$600(AwContents.this)).mCallbackHelper;
    String str = paramNavigationParams.url;
    awContentsClientCallbackHelper.mHandler.sendMessage(awContentsClientCallbackHelper.mHandler.obtainMessage(2, str));
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContents$InterceptNavigationDelegateImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */