package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.common.internal.zzbq;

public final class SupportErrorDialogFragment extends DialogFragment {
  private Dialog mDialog = null;
  
  private DialogInterface.OnCancelListener zzfqv = null;
  
  public static SupportErrorDialogFragment newInstance(Dialog paramDialog, DialogInterface.OnCancelListener paramOnCancelListener) {
    SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
    paramDialog = (Dialog)zzbq.checkNotNull(paramDialog, "Cannot display null dialog");
    paramDialog.setOnCancelListener(null);
    paramDialog.setOnDismissListener(null);
    supportErrorDialogFragment.mDialog = paramDialog;
    if (paramOnCancelListener != null)
      supportErrorDialogFragment.zzfqv = paramOnCancelListener; 
    return supportErrorDialogFragment;
  }
  
  public final void onCancel(DialogInterface paramDialogInterface) {
    if (this.zzfqv != null)
      this.zzfqv.onCancel(paramDialogInterface); 
  }
  
  public final Dialog onCreateDialog$5709b310() {
    if (this.mDialog == null)
      this.mShowsDialog = false; 
    return this.mDialog;
  }
  
  public final void show(FragmentManager paramFragmentManager, String paramString) {
    super.show(paramFragmentManager, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\SupportErrorDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */