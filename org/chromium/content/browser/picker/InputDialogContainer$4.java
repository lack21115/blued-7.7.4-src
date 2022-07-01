package org.chromium.content.browser.picker;

import android.content.DialogInterface;

final class InputDialogContainer$4 implements DialogInterface.OnClickListener {
  public final void onClick(DialogInterface paramDialogInterface, int paramInt) {
    InputDialogContainer.this.mDialogAlreadyDismissed = true;
    InputDialogContainer.this.mInputActionDelegate.replaceDateTime(Double.NaN);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\InputDialogContainer$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */