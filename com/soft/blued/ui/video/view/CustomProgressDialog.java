package com.soft.blued.ui.video.view;

import android.app.ProgressDialog;
import android.content.Context;

public class CustomProgressDialog extends ProgressDialog {
  public CustomProgressDialog(Context paramContext) {
    super(paramContext);
    setMessage("处理中...");
    setMax(100);
    setProgressStyle(1);
    setCanceledOnTouchOutside(false);
    setCancelable(true);
  }
  
  public void cancel() {
    super.cancel();
    setProgress(0);
  }
  
  public void dismiss() {
    super.dismiss();
    setProgress(0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\view\CustomProgressDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */