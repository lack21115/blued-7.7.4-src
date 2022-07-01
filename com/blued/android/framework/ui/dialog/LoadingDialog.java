package com.blued.android.framework.ui.dialog;

import android.content.DialogInterface;

public class LoadingDialog implements DialogInterface.OnCancelListener {
  private OnCancelListener a;
  
  public void onCancel(DialogInterface paramDialogInterface) {
    OnCancelListener onCancelListener = this.a;
    if (onCancelListener != null)
      onCancelListener.a(); 
  }
  
  public static interface OnCancelListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framewor\\ui\dialog\LoadingDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */