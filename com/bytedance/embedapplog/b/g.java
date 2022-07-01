package com.bytedance.embedapplog.b;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.embedapplog.util.c;
import org.json.JSONObject;

class g extends c {
  private final Context e;
  
  private final h f;
  
  g(Context paramContext, h paramh) {
    super(false, false);
    this.e = paramContext;
    this.f = paramh;
  }
  
  protected boolean a(JSONObject paramJSONObject) {
    paramJSONObject.put("sdk_version", 336);
    paramJSONObject.put("sdk_version_name", "3.4.0-rc.1-embed");
    paramJSONObject.put("channel", this.f.n());
    i.a(paramJSONObject, "aid", this.f.m());
    i.a(paramJSONObject, "release_build", this.f.D());
    i.a(paramJSONObject, "app_region", this.f.q());
    i.a(paramJSONObject, "app_language", this.f.p());
    i.a(paramJSONObject, "user_agent", this.f.E());
    i.a(paramJSONObject, "ab_sdk_version", this.f.s());
    i.a(paramJSONObject, "ab_version", this.f.w());
    i.a(paramJSONObject, "aliyun_uuid", this.f.a());
    String str2 = this.f.o();
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = c.a(this.e, this.f); 
    if (!TextUtils.isEmpty(str1))
      i.a(paramJSONObject, "google_aid", str1); 
    str1 = this.f.C();
    if (!TextUtils.isEmpty(str1))
      try {
        paramJSONObject.put("app_track", new JSONObject(str1));
      } finally {
        str1 = null;
      }  
    str1 = this.f.r();
    if (str1 != null && str1.length() > 0)
      paramJSONObject.put("custom", new JSONObject(str1)); 
    i.a(paramJSONObject, "user_unique_id", this.f.t());
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */