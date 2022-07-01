package com.bytedance.embedapplog.b;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.bytedance.embedapplog.util.e;
import com.bytedance.embedapplog.util.h;
import org.json.JSONObject;

class u extends c {
  private final Context e;
  
  private final h f;
  
  u(Context paramContext, h paramh) {
    super(true, false);
    this.e = paramContext;
    this.f = paramh;
  }
  
  protected boolean a(JSONObject paramJSONObject) {
    TelephonyManager telephonyManager = (TelephonyManager)this.e.getSystemService("phone");
    if (telephonyManager != null)
      try {
        String str;
        i.a(paramJSONObject, "carrier", telephonyManager.getNetworkOperatorName());
        i.a(paramJSONObject, "mcc_mnc", telephonyManager.getNetworkOperator());
        if (this.f.R()) {
          str = e.a(telephonyManager);
        } else {
          str = this.f.Q();
        } 
        i.a(paramJSONObject, "udid", str);
        return true;
      } catch (Exception exception) {
        h.a(exception);
      }  
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */