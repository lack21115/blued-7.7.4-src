package org.chromium.content.browser.androidoverlay;

final class DialogOverlayImpl$2 implements Runnable {
  public final void run() {
    DialogOverlayCore dialogOverlayCore = dialogCore;
    dialogOverlayCore.dismissDialogQuietly();
    dialogOverlayCore.mLayoutParams.token = null;
    dialogOverlayCore.mHost = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\androidoverlay\DialogOverlayImpl$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */