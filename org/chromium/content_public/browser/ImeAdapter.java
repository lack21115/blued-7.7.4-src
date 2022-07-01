package org.chromium.content_public.browser;

import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

public interface ImeAdapter {
  void addEventObserver(ImeEventObserver paramImeEventObserver);
  
  boolean onCheckIsTextEditor();
  
  InputConnection onCreateInputConnection(EditorInfo paramEditorInfo);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\browser\ImeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */