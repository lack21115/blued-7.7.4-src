package com.alipay.sdk.app;

import android.content.Context;
import android.content.Intent;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.sys.a;

public class H5OpenAuthActivity extends H5PayActivity {
  private boolean a = false;
  
  public void a() {}
  
  protected void onDestroy() {
    if (this.a)
      try {
        a a = a.a.a(getIntent());
        if (a != null)
          a.b((Context)this, a, "", a.p); 
      } finally {
        Exception exception;
      }  
    super.onDestroy();
  }
  
  public void startActivity(Intent paramIntent) {
    try {
      a a = a.a.a(paramIntent);
    } finally {
      paramIntent = null;
      finish();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\app\H5OpenAuthActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */