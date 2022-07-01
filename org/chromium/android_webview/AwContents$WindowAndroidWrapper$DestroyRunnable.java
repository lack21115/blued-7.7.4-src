package org.chromium.android_webview;

import android.os.Build;
import org.chromium.ui.base.WindowAndroid;

final class AwContents$WindowAndroidWrapper$DestroyRunnable implements Runnable {
  private final WindowAndroid mWindowAndroid;
  
  private AwContents$WindowAndroidWrapper$DestroyRunnable(WindowAndroid paramWindowAndroid) {
    this.mWindowAndroid = paramWindowAndroid;
  }
  
  public final void run() {
    WindowAndroid windowAndroid = this.mWindowAndroid;
    if (windowAndroid.mNativeWindowAndroid != 0L)
      windowAndroid.nativeDestroy(windowAndroid.mNativeWindowAndroid); 
    if (Build.VERSION.SDK_INT >= 19 && windowAndroid.mTouchExplorationMonitor != null) {
      WindowAndroid.TouchExplorationMonitor touchExplorationMonitor = windowAndroid.mTouchExplorationMonitor;
      WindowAndroid.access$100(touchExplorationMonitor.this$0).removeTouchExplorationStateChangeListener(touchExplorationMonitor.mTouchExplorationListener);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContents$WindowAndroidWrapper$DestroyRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */