package org.chromium.content.browser.androidoverlay;

import org.chromium.gfx.mojom.Rect;

final class DialogOverlayImpl$3 implements Runnable {
  public final void run() {
    DialogOverlayCore dialogOverlayCore = dialogCore;
    Rect rect = rect;
    if (dialogOverlayCore.mDialog != null) {
      if (dialogOverlayCore.mLayoutParams.token == null)
        return; 
      if (dialogOverlayCore.copyRectToLayoutParams(rect))
        dialogOverlayCore.mDialog.getWindow().setAttributes(dialogOverlayCore.mLayoutParams); 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\androidoverlay\DialogOverlayImpl$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */