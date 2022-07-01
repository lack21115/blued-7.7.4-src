package com.google.android.gms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzbq;

public final class ErrorDialogFragment extends DialogFragment {
  private Dialog mDialog = null;
  
  private DialogInterface.OnCancelListener zzfqv = null;
  
  public static ErrorDialogFragment newInstance(Dialog paramDialog, DialogInterface.OnCancelListener paramOnCancelListener) {
    ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
    paramDialog = (Dialog)zzbq.checkNotNull(paramDialog, "Cannot display null dialog");
    paramDialog.setOnCancelListener(null);
    paramDialog.setOnDismissListener(null);
    errorDialogFragment.mDialog = paramDialog;
    if (paramOnCancelListener != null)
      errorDialogFragment.zzfqv = paramOnCancelListener; 
    return errorDialogFragment;
  }
  
  public final void onCancel(DialogInterface paramDialogInterface) {
    if (this.zzfqv != null)
      this.zzfqv.onCancel(paramDialogInterface); 
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle) {
    if (this.mDialog == null)
      setShowsDialog(false); 
    return this.mDialog;
  }
  
  public final void show(FragmentManager paramFragmentManager, String paramString) {
    super.show(paramFragmentManager, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\ErrorDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */