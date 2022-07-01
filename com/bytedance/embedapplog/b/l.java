package com.bytedance.embedapplog.b;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.embedapplog.AppLog;
import org.json.JSONObject;

class l extends c {
  private final Context e;
  
  private final h f;
  
  l(Context paramContext, h paramh) {
    super(true, false);
    this.e = paramContext;
    this.f = paramh;
  }
  
  protected boolean a(JSONObject paramJSONObject) {
    String str;
    if (AppLog.getInitConfig() != null) {
      str = AppLog.getInitConfig().getSensitiveInfoProvider().getMac();
    } else {
      str = "";
    } 
    if (!TextUtils.isEmpty(str))
      paramJSONObject.put("mc", str); 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\b\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */