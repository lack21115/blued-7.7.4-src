package com.baidu.mobads.f;

import android.text.TextUtils;
import com.baidu.mobads.b.a;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

class r implements Runnable {
  r(q paramq) {}
  
  public void run() {
    try {
      String str1 = q.a(this.a, "key_crash_trace");
      String str2 = q.a(this.a, "key_crash_ad");
      if (!TextUtils.isEmpty(str1)) {
        a.a().a(q.a(this.a, "key_crash_source"), str1, str2);
        q.a(this.a);
        return;
      } 
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d(exception);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\f\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */