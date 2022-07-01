package org.chromium.content.browser.androidoverlay;

import android.os.IBinder;

final class DialogOverlayImpl$4 implements Runnable {
  public final void run() {
    DialogOverlayCore dialogOverlayCore = dialogCore;
    IBinder iBinder = token;
    if (dialogOverlayCore.mDialog != null) {
      if (dialogOverlayCore.mHost == null)
        return; 
      if (iBinder == null || (dialogOverlayCore.mLayoutParams.token != null && iBinder != dialogOverlayCore.mLayoutParams.token)) {
        dialogOverlayCore.mHost.onOverlayDestroyed();
        dialogOverlayCore.mHost = null;
        dialogOverlayCore.dismissDialogQuietly();
        return;
      } 
      if (dialogOverlayCore.mLayoutParams.token != iBinder) {
        dialogOverlayCore.mLayoutParams.token = iBinder;
        dialogOverlayCore.mDialog.getWindow().setAttributes(dialogOverlayCore.mLayoutParams);
        dialogOverlayCore.mDialogCallbacks = new DialogOverlayCore$Callbacks(dialogOverlayCore, (byte)0);
        dialogOverlayCore.mDialog.getWindow().takeSurface(dialogOverlayCore.mDialogCallbacks);
        dialogOverlayCore.mDialog.show();
      } 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\androidoverlay\DialogOverlayImpl$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */