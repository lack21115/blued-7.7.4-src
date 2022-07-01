package com.blued.android.sdk.a;

import android.content.Intent;
import com.blued.android.sdk.BluedPay;

public class f extends a {
  public static final String c = "com.blued.android.sdk.action.pay";
  
  public static final String d = "com.blued.android.sdk.action.pay_result";
  
  public static final String e = "extra_pay_balance_int";
  
  private BluedPay.PayCallback f;
  
  public f(BluedPay.PayCallback paramPayCallback) {
    this.f = paramPayCallback;
  }
  
  public void a(Intent paramIntent) {
    String str = paramIntent.getAction();
    if (this.f == null)
      return; 
    if ("com.blued.android.sdk.action.pay_result".equals(str)) {
      int i = paramIntent.getIntExtra("extra_result_int", 2);
      if (i != 0) {
        if (i != 2) {
          i = paramIntent.getIntExtra("extra_error_code_int", 0);
          this.f.onFailed(i);
          return;
        } 
        this.f.onCancel();
        return;
      } 
      i = paramIntent.getIntExtra("extra_pay_balance_int", 0);
      this.f.onSuccess(i);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\sdk\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */