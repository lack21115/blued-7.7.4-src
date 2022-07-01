package org.chromium.ui.display;

import org.chromium.base.ThreadUtils;

final class DisplayAndroidManager$DisplayListenerAPI16$1 implements Runnable {
  public final void run() {
    self.onConfigurationChanged(null);
    if (DisplayAndroidManager$DisplayListenerAPI16.access$100(self) <= 0)
      return; 
    ThreadUtils.postOnUiThreadDelayed(this, 500L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\display\DisplayAndroidManager$DisplayListenerAPI16$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */