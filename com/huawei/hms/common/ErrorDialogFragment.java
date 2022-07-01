package com.huawei.hms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import com.huawei.hms.common.internal.Preconditions;

public class ErrorDialogFragment extends DialogFragment {
  private DialogInterface.OnCancelListener myCancelLister = null;
  
  private Dialog myDialog = null;
  
  public static ErrorDialogFragment newInstance(Dialog paramDialog) {
    return newInstance(paramDialog, null);
  }
  
  public static ErrorDialogFragment newInstance(Dialog paramDialog, DialogInterface.OnCancelListener paramOnCancelListener) {
    Preconditions.checkNotNull(paramDialog, "Dialog cannot be null!");
    ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
    errorDialogFragment.myDialog = paramDialog;
    errorDialogFragment.myDialog.setOnCancelListener(null);
    errorDialogFragment.myDialog.setOnDismissListener(null);
    if (paramOnCancelListener != null)
      errorDialogFragment.myCancelLister = paramOnCancelListener; 
    return errorDialogFragment;
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {
    DialogInterface.OnCancelListener onCancelListener = this.myCancelLister;
    if (onCancelListener != null)
      onCancelListener.onCancel(paramDialogInterface); 
  }
  
  public Dialog onCreateDialog(Bundle paramBundle) {
    if (this.myDialog == null)
      setShowsDialog(false); 
    return this.myDialog;
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString) {
    Preconditions.checkNotNull(paramFragmentManager, "FragmentManager cannot be null!");
    super.show(paramFragmentManager, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\ErrorDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */