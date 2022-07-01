package org.chromium.content.browser.input;

import android.view.View;

final class ThreadedInputConnection$18 implements Runnable {
  public final void run() {
    boolean bool1;
    ImeAdapterImpl imeAdapterImpl = ThreadedInputConnection.access$100(ThreadedInputConnection.this);
    int i = cursorUpdateMode;
    boolean bool2 = false;
    if ((i & 0x1) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if ((i & 0x2) != 0)
      bool2 = true; 
    if (imeAdapterImpl.isValid())
      imeAdapterImpl.nativeRequestCursorUpdate(imeAdapterImpl.mNativeImeAdapterAndroid, bool1, bool2); 
    if (imeAdapterImpl.mCursorAnchorInfoController != null)
      imeAdapterImpl.mCursorAnchorInfoController.onRequestCursorUpdates(bool1, bool2, (View)imeAdapterImpl.mViewDelegate.getContainerView()); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\ThreadedInputConnection$18.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */