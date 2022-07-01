package com.blued.android.framework.qrcode.decoding;

import android.app.Activity;
import android.content.DialogInterface;

public final class FinishListener implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener, Runnable {
  private final Activity a;
  
  public FinishListener(Activity paramActivity) {
    this.a = paramActivity;
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {
    run();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {
    run();
  }
  
  public void run() {
    this.a.finish();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\qrcode\decoding\FinishListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */