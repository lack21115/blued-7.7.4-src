package org.chromium.content.browser.input;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;

public interface ChromiumBaseInputConnection extends InputConnection {
  boolean sendKeyEventOnUiThread(KeyEvent paramKeyEvent);
  
  void unblockOnUiThread();
  
  void updateStateOnUiThread(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\ChromiumBaseInputConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */