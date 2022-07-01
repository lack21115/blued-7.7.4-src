package com.blued.android.core.utils.toast;

import android.app.Application;

final class SupportToast extends BaseToast {
  private final ToastHelper a;
  
  SupportToast(Application paramApplication) {
    super(paramApplication);
    this.a = new ToastHelper(this, paramApplication);
  }
  
  public void cancel() {
    this.a.b();
  }
  
  public void show() {
    this.a.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\utils\toast\SupportToast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */