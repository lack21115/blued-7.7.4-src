package com.huawei.hms.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import com.huawei.hms.support.log.HMSLog;

public abstract class AbstractDialog {
  private Activity a;
  
  private AlertDialog b;
  
  private Callback c;
  
  private static int a(Context paramContext) {
    return (paramContext == null) ? 0 : paramContext.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
  }
  
  public void cancel() {
    AlertDialog alertDialog = this.b;
    if (alertDialog != null)
      alertDialog.cancel(); 
  }
  
  public void dismiss() {
    AlertDialog alertDialog = this.b;
    if (alertDialog != null)
      alertDialog.dismiss(); 
  }
  
  protected void fireCancel() {
    Callback callback = this.c;
    if (callback != null)
      callback.onCancel(this); 
  }
  
  protected void fireDoWork() {
    Callback callback = this.c;
    if (callback != null)
      callback.onDoWork(this); 
  }
  
  protected Activity getActivity() {
    return this.a;
  }
  
  protected int getDialogThemeId() {
    return (a((Context)this.a) != 0 && Build.VERSION.SDK_INT >= 16) ? 0 : 3;
  }
  
  protected AlertDialog onCreateDialog(Activity paramActivity) {
    AlertDialog.Builder builder = new AlertDialog.Builder((Context)getActivity(), getDialogThemeId());
    String str2 = onGetTitleString((Context)paramActivity);
    if (str2 != null)
      builder.setTitle(str2); 
    str2 = onGetMessageString((Context)paramActivity);
    if (str2 != null)
      builder.setMessage(str2); 
    str2 = onGetPositiveButtonString((Context)paramActivity);
    if (str2 != null)
      builder.setPositiveButton(str2, new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              this.a.fireDoWork();
            }
          }); 
    String str1 = onGetNegativeButtonString((Context)paramActivity);
    if (str1 != null)
      builder.setNegativeButton(str1, new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              this.a.cancel();
            }
          }); 
    return builder.create();
  }
  
  protected abstract String onGetMessageString(Context paramContext);
  
  protected abstract String onGetNegativeButtonString(Context paramContext);
  
  protected abstract String onGetPositiveButtonString(Context paramContext);
  
  protected abstract String onGetTitleString(Context paramContext);
  
  public void setMessage(CharSequence paramCharSequence) {
    AlertDialog alertDialog = this.b;
    if (alertDialog != null)
      alertDialog.setMessage(paramCharSequence); 
  }
  
  public void setTitle(CharSequence paramCharSequence) {
    AlertDialog alertDialog = this.b;
    if (alertDialog != null)
      alertDialog.setTitle(paramCharSequence); 
  }
  
  public void show(Activity paramActivity, Callback paramCallback) {
    this.a = paramActivity;
    this.c = paramCallback;
    paramActivity = this.a;
    if (paramActivity == null || paramActivity.isFinishing()) {
      HMSLog.e("AbstractDialog", "In show, The activity is null or finishing.");
      return;
    } 
    this.b = onCreateDialog(this.a);
    this.b.setCanceledOnTouchOutside(false);
    this.b.setOnCancelListener(new DialogInterface.OnCancelListener(this) {
          public void onCancel(DialogInterface param1DialogInterface) {
            this.a.fireCancel();
          }
        });
    this.b.setOnKeyListener(new DialogInterface.OnKeyListener(this) {
          public boolean onKey(DialogInterface param1DialogInterface, int param1Int, KeyEvent param1KeyEvent) {
            if (4 == param1Int && param1KeyEvent.getAction() == 1) {
              this.a.cancel();
              return true;
            } 
            return false;
          }
        });
    this.b.show();
  }
  
  public static interface Callback {
    void onCancel(AbstractDialog param1AbstractDialog);
    
    void onDoWork(AbstractDialog param1AbstractDialog);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\ui\AbstractDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */