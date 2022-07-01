package org.chromium.content.browser;

import android.content.res.Configuration;
import org.chromium.ui.base.WindowAndroid;
import org.chromium.ui.display.DisplayAndroid;

public interface WindowEventObserver extends DisplayAndroid.DisplayAndroidObserver {
  void onAttachedToWindow();
  
  void onConfigurationChanged(Configuration paramConfiguration);
  
  void onDetachedFromWindow();
  
  void onViewFocusChanged(boolean paramBoolean1, boolean paramBoolean2);
  
  void onWindowAndroidChanged(WindowAndroid paramWindowAndroid);
  
  void onWindowFocusChanged(boolean paramBoolean);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\WindowEventObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */