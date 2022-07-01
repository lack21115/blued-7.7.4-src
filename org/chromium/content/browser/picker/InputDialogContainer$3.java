package org.chromium.content.browser.picker;

import android.content.DialogInterface;

final class InputDialogContainer$3 implements DialogInterface.OnDismissListener {
  public final void onDismiss(DialogInterface paramDialogInterface) {
    if (InputDialogContainer.this.mDialog == paramDialogInterface && !InputDialogContainer.this.mDialogAlreadyDismissed) {
      InputDialogContainer.this.mDialogAlreadyDismissed = true;
      InputDialogContainer.this.mInputActionDelegate.cancelDateTimeDialog();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\InputDialogContainer$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */