package org.chromium.android_webview;

import android.view.KeyEvent;
import org.chromium.content_public.browser.ImeEventObserver;

final class AwContents$1 implements ImeEventObserver {
  public final void onBeforeSendKeyEvent(KeyEvent paramKeyEvent) {
    if (AwContents.isDpadEvent(paramKeyEvent))
      AwContents.access$300(AwContents.this).setSpatialNavigationEnabled(true); 
  }
  
  public final void onImeEvent() {}
  
  public final void onNodeAttributeUpdated(boolean paramBoolean1, boolean paramBoolean2) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContents$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */