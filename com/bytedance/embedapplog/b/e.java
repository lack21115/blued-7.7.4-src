package com.bytedance.embedapplog.b;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.embed_device_register.b;
import org.json.JSONObject;

final class e extends c {
  private final h e;
  
  e(Context paramContext, h paramh) {
    super(true, false);
    this.e = paramh;
  }
  
  protected boolean a(JSONObject paramJSONObject) {
    String str = b.a(this.e.d());
    if (!TextUtils.isEmpty(str)) {
      paramJSONObject.put("cdid", str);
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */