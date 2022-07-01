package com.blued.android.framework.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class CustomDialog extends Dialog {
  private OnBackCallBack a;
  
  public CustomDialog(Context paramContext) {
    super(paramContext);
  }
  
  public CustomDialog(Context paramContext, int paramInt) {
    super(paramContext, paramInt);
  }
  
  public void a(View paramView, OnBackCallBack paramOnBackCallBack) {
    requestWindowFeature(1);
    setContentView(paramView);
    setCancelable(false);
    Window window = getWindow();
    if (Build.VERSION.SDK_INT >= 21 && window != null && window.getDecorView() != null) {
      window.getDecorView().setSystemUiVisibility(1280);
      window.addFlags(-2147483648);
      window.setStatusBarColor(0);
    } 
    WindowManager.LayoutParams layoutParams = window.getAttributes();
    window.setGravity(17);
    window.setAttributes(layoutParams);
    a(paramOnBackCallBack);
    show();
  }
  
  public void a(OnBackCallBack paramOnBackCallBack) {
    this.a = paramOnBackCallBack;
  }
  
  public void onBackPressed() {
    super.onBackPressed();
    if (isShowing())
      dismiss(); 
    OnBackCallBack onBackCallBack = this.a;
    if (onBackCallBack != null)
      onBackCallBack.a(); 
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public static interface OnBackCallBack {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\CustomDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */