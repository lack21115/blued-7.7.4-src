package com.huawei.hms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import com.huawei.hms.common.internal.Preconditions;

public class ErrDlgFragmentForSupport extends DialogFragment {
  private DialogInterface.OnCancelListener listener = null;
  
  private Dialog log = null;
  
  public static ErrDlgFragmentForSupport newInstance(Dialog paramDialog) {
    return newInstance(paramDialog, null);
  }
  
  public static ErrDlgFragmentForSupport newInstance(Dialog paramDialog, DialogInterface.OnCancelListener paramOnCancelListener) {
    Preconditions.checkNotNull(paramDialog, "Dialog cannot be null!");
    ErrDlgFragmentForSupport errDlgFragmentForSupport = new ErrDlgFragmentForSupport();
    errDlgFragmentForSupport.log = paramDialog;
    errDlgFragmentForSupport.log.setOnCancelListener(null);
    errDlgFragmentForSupport.log.setOnDismissListener(null);
    errDlgFragmentForSupport.listener = paramOnCancelListener;
    return errDlgFragmentForSupport;
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {
    DialogInterface.OnCancelListener onCancelListener = this.listener;
    if (onCancelListener != null)
      onCancelListener.onCancel(paramDialogInterface); 
  }
  
  public Dialog onCreateDialog(Bundle paramBundle) {
    if (this.log == null)
      setShowsDialog(false); 
    return this.log;
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString) {
    Preconditions.checkNotNull(paramFragmentManager, "FragmentManager cannot be null!");
    super.show(paramFragmentManager, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\ErrDlgFragmentForSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */