package org.chromium.content_public.browser;

import android.view.KeyEvent;
import android.view.MotionEvent;

public interface ViewEventSink$InternalAccessDelegate {
  void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  boolean super_dispatchKeyEvent(KeyEvent paramKeyEvent);
  
  boolean super_onGenericMotionEvent(MotionEvent paramMotionEvent);
  
  boolean super_onKeyUp(int paramInt, KeyEvent paramKeyEvent);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\browser\ViewEventSink$InternalAccessDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */