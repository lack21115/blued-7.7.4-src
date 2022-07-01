package org.chromium.content_public.browser;

public interface GestureListenerManager {
  void addListener(GestureStateListener paramGestureStateListener);
  
  void removeListener(GestureStateListener paramGestureStateListener);
  
  void updateDoubleTapSupport(boolean paramBoolean);
  
  void updateMultiTouchZoomSupport(boolean paramBoolean);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\browser\GestureListenerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */