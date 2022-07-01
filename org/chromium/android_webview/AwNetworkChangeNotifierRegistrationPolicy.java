package org.chromium.android_webview;

import org.chromium.net.NetworkChangeNotifierAutoDetect;

public final class AwNetworkChangeNotifierRegistrationPolicy extends NetworkChangeNotifierAutoDetect.RegistrationPolicy implements AwContentsLifecycleNotifier$Observer {
  protected final void destroy() {
    AwContentsLifecycleNotifier.removeObserver(this);
  }
  
  protected final void init(NetworkChangeNotifierAutoDetect paramNetworkChangeNotifierAutoDetect) {
    super.init(paramNetworkChangeNotifierAutoDetect);
    AwContentsLifecycleNotifier.addObserver(this);
  }
  
  public final void onFirstWebViewCreated() {
    register();
  }
  
  public final void onLastWebViewDestroyed() {
    unregister();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwNetworkChangeNotifierRegistrationPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */