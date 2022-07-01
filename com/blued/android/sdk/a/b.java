package com.blued.android.sdk.a;

import android.content.Intent;
import com.blued.android.sdk.BluedAuth;

public class b extends a {
  public static final String c = "com.blued.android.sdk.action.auth";
  
  public static final String d = "com.blued.android.sdk.action.auth_result";
  
  public static final String e = "extra_auth_token_string";
  
  public static final String f = "extra_auth_expire_int";
  
  private final BluedAuth.AuthCallback g;
  
  public b(BluedAuth.AuthCallback paramAuthCallback) {
    this.g = paramAuthCallback;
  }
  
  public void a(Intent paramIntent) {
    String str = paramIntent.getAction();
    if (this.g == null)
      return; 
    if ("com.blued.android.sdk.action.auth_result".equals(str)) {
      int i = paramIntent.getIntExtra("extra_result_int", 2);
      if (i != 0) {
        if (i != 2) {
          i = paramIntent.getIntExtra("extra_error_code_int", 0);
          this.g.onFailed(i);
          return;
        } 
        this.g.onCancel();
        return;
      } 
      str = paramIntent.getStringExtra("extra_auth_token_string");
      i = paramIntent.getIntExtra("extra_auth_expire_int", 0);
      this.g.onSuccess(str, i);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\sdk\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */