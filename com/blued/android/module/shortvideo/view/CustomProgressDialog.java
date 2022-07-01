package com.blued.android.module.shortvideo.view;

import android.app.ProgressDialog;

public class CustomProgressDialog extends ProgressDialog {
  public void cancel() {
    super.cancel();
    setProgress(0);
  }
  
  public void dismiss() {
    super.dismiss();
    setProgress(0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\view\CustomProgressDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */