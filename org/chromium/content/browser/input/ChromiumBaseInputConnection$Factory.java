package org.chromium.content.browser.input;

import android.view.View;
import android.view.inputmethod.EditorInfo;

public interface ChromiumBaseInputConnection$Factory {
  ChromiumBaseInputConnection initializeAndGet(View paramView, ImeAdapterImpl paramImeAdapterImpl, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, EditorInfo paramEditorInfo);
  
  void onViewAttachedToWindow();
  
  void onViewDetachedFromWindow();
  
  void onViewFocusChanged(boolean paramBoolean);
  
  void onWindowFocusChanged(boolean paramBoolean);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\ChromiumBaseInputConnection$Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */