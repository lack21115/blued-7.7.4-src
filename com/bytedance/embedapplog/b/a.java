package com.bytedance.embedapplog.b;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.embedapplog.util.h;
import org.json.JSONObject;

class a extends c {
  private final Context e;
  
  private final h f;
  
  a(Context paramContext, h paramh) {
    super(true, false);
    this.e = paramContext;
    this.f = paramh;
  }
  
  protected boolean a(JSONObject paramJSONObject) {
    if (!TextUtils.isEmpty(this.f.M()))
      paramJSONObject.put("ab_client", this.f.M()); 
    if (!TextUtils.isEmpty(this.f.w())) {
      if (h.b) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("init config has abversion:");
        stringBuilder.append(this.f.w());
        h.a(stringBuilder.toString(), null);
      } 
      paramJSONObject.put("ab_version", this.f.w());
    } 
    if (!TextUtils.isEmpty(this.f.N()))
      paramJSONObject.put("ab_group", this.f.N()); 
    if (!TextUtils.isEmpty(this.f.O()))
      paramJSONObject.put("ab_feature", this.f.O()); 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */