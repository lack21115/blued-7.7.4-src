package com.blued.android.core.utils.toast;

import android.widget.Toast;

public class ToastInterceptor implements IToastInterceptor {
  public boolean a(Toast paramToast, CharSequence paramCharSequence) {
    return (paramCharSequence == null || "".equals(paramCharSequence.toString()));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\utils\toast\ToastInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */