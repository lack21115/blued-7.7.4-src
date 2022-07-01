package org.chromium.android_webview;

import org.chromium.base.ObserverList;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;

public class AwContentsLifecycleNotifier {
  private static final ObserverList sLifecycleObservers;
  
  private static int sNumWebViews;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static void addObserver(AwContentsLifecycleNotifier$Observer paramAwContentsLifecycleNotifier$Observer) {
    sLifecycleObservers.addObserver(paramAwContentsLifecycleNotifier$Observer);
  }
  
  @CalledByNative
  private static void onWebViewCreated() {
    ThreadUtils.assertOnUiThread();
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private static void onWebViewDestroyed() {
    ThreadUtils.assertOnUiThread();
    assert false;
    throw new AssertionError();
  }
  
  public static void removeObserver(AwContentsLifecycleNotifier$Observer paramAwContentsLifecycleNotifier$Observer) {
    sLifecycleObservers.removeObserver(paramAwContentsLifecycleNotifier$Observer);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContentsLifecycleNotifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */