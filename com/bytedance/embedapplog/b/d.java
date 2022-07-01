package com.bytedance.embedapplog.b;

import android.os.Build;
import org.json.JSONObject;

class d extends c {
  d() {
    super(true, false);
  }
  
  protected boolean a(JSONObject paramJSONObject) {
    paramJSONObject.put("os", "Android");
    paramJSONObject.put("os_version", Build.VERSION.RELEASE);
    paramJSONObject.put("os_api", Build.VERSION.SDK_INT);
    paramJSONObject.put("device_model", Build.MODEL);
    paramJSONObject.put("device_brand", Build.BRAND);
    paramJSONObject.put("device_manufacturer", Build.MANUFACTURER);
    paramJSONObject.put("cpu_abi", Build.CPU_ABI);
    paramJSONObject.put("build_serial", Build.SERIAL);
    if (Build.VERSION.SDK_INT >= 26)
      paramJSONObject.put("build_serial", Build.getSerial()); 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */