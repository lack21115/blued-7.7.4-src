package com.bytedance.embedapplog.b;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONObject;

class t extends c {
  private final Context e;
  
  t(Context paramContext) {
    super(true, false);
    this.e = paramContext;
  }
  
  protected boolean a(JSONObject paramJSONObject) {
    i.a(paramJSONObject, "sim_region", ((TelephonyManager)this.e.getSystemService("phone")).getSimCountryIso());
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\b\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */