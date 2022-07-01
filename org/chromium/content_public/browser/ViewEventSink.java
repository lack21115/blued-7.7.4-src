package org.chromium.content_public.browser;

import android.content.res.Configuration;

public interface ViewEventSink {
  void onAttachedToWindow();
  
  void onConfigurationChanged(Configuration paramConfiguration);
  
  void onDetachedFromWindow();
  
  void onViewFocusChanged(boolean paramBoolean);
  
  void onWindowFocusChanged(boolean paramBoolean);
  
  void setAccessDelegate(ViewEventSink$InternalAccessDelegate paramViewEventSink$InternalAccessDelegate);
  
  void setHideKeyboardOnBlur(boolean paramBoolean);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\browser\ViewEventSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */