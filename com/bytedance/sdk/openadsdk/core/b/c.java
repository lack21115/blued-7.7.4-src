package com.bytedance.sdk.openadsdk.core.b;

import android.content.Context;
import com.bytedance.sdk.adnet.b.h;
import com.bytedance.sdk.adnet.face.d;
import com.bytedance.sdk.openadsdk.g.e;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
  private static JSONObject a(String paramString, long paramLong) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("type", "over_freq");
      jSONObject.put("rit", paramString);
      jSONObject.put("ad_sdk_version", "2.9.5.6");
      jSONObject.put("timestamp", paramLong);
      return jSONObject;
    } catch (JSONException jSONException) {
      return jSONObject;
    } 
  }
  
  public static void a(Context paramContext, String paramString, long paramLong) {
    (new h(1, "https://i.snssdk.com/api/ad/union/sdk/stats/", a(paramString, paramLong), null)).setRetryPolicy((d)e.b().a(10000)).build(e.a(paramContext).d());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */