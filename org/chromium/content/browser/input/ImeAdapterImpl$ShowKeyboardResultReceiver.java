package org.chromium.content.browser.input;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import org.chromium.ui.base.ViewUtils;

@SuppressLint({"ParcelCreator"})
class ImeAdapterImpl$ShowKeyboardResultReceiver extends ResultReceiver {
  private final WeakReference mImeAdapter;
  
  public ImeAdapterImpl$ShowKeyboardResultReceiver(ImeAdapterImpl paramImeAdapterImpl, Handler paramHandler) {
    super(paramHandler);
    this.mImeAdapter = new WeakReference<ImeAdapterImpl>(paramImeAdapterImpl);
  }
  
  public void onReceiveResult(int paramInt, Bundle paramBundle) {
    ImeAdapterImpl imeAdapterImpl = this.mImeAdapter.get();
    if (imeAdapterImpl == null)
      return; 
    ViewGroup viewGroup = imeAdapterImpl.mViewDelegate.getContainerView();
    if (paramInt == 2) {
      viewGroup.getWindowVisibleDisplayFrame(imeAdapterImpl.mFocusPreOSKViewportRect);
      return;
    } 
    if (ViewUtils.hasFocus((View)viewGroup) && paramInt == 0)
      imeAdapterImpl.mWebContents.scrollFocusedEditableNodeIntoView(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\ImeAdapterImpl$ShowKeyboardResultReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */