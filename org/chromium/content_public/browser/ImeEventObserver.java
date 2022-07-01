package org.chromium.content_public.browser;

import android.view.KeyEvent;

public interface ImeEventObserver {
  void onBeforeSendKeyEvent(KeyEvent paramKeyEvent);
  
  void onImeEvent();
  
  void onNodeAttributeUpdated(boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\browser\ImeEventObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */