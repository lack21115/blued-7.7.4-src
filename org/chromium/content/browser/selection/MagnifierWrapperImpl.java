package org.chromium.content.browser.selection;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Magnifier;

@SuppressLint({"NewApi"})
public final class MagnifierWrapperImpl implements MagnifierWrapper {
  private SelectionPopupControllerImpl$ReadbackViewCallback mCallback;
  
  private Magnifier mMagnifier;
  
  public MagnifierWrapperImpl(SelectionPopupControllerImpl$ReadbackViewCallback paramSelectionPopupControllerImpl$ReadbackViewCallback) {
    this.mCallback = paramSelectionPopupControllerImpl$ReadbackViewCallback;
  }
  
  public final void dismiss() {
    if (this.mMagnifier != null) {
      this.mMagnifier.dismiss();
      this.mMagnifier = null;
    } 
  }
  
  public final boolean isAvailable() {
    return (this.mCallback.getReadbackView() != null);
  }
  
  public final void show(float paramFloat1, float paramFloat2) {
    View view = this.mCallback.getReadbackView();
    if (view == null)
      return; 
    if (this.mMagnifier == null)
      this.mMagnifier = new Magnifier(view); 
    this.mMagnifier.show(paramFloat1, paramFloat2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\selection\MagnifierWrapperImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */