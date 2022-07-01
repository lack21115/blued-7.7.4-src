package org.chromium.content.browser.androidoverlay;

import android.app.Dialog;
import android.content.Context;
import org.chromium.base.ThreadUtils;
import org.chromium.media.mojom.AndroidOverlayConfig;

final class DialogOverlayImpl$1 implements Runnable {
  public final void run() {
    DialogOverlayCore dialogOverlayCore = dialogCore;
    Context context = context;
    AndroidOverlayConfig androidOverlayConfig = config;
    ThreadHoppingHost threadHoppingHost = DialogOverlayImpl.access$000(DialogOverlayImpl.this);
    boolean bool = asPanel;
    dialogOverlayCore.mHost = threadHoppingHost;
    dialogOverlayCore.mAsPanel = bool;
    dialogOverlayCore.mDialog = new Dialog(context, 16973909);
    dialogOverlayCore.mDialog.requestWindowFeature(1);
    dialogOverlayCore.mDialog.setCancelable(false);
    dialogOverlayCore.mLayoutParams = dialogOverlayCore.createLayoutParams(androidOverlayConfig.secure);
    dialogOverlayCore.copyRectToLayoutParams(androidOverlayConfig.rect);
    ThreadUtils.postOnUiThread(new DialogOverlayImpl$1$1(this));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\androidoverlay\DialogOverlayImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */