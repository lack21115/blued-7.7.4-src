package com.ss.android.downloadlib.e;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
  public static String a(String paramString1, String paramString2, boolean paramBoolean, String paramString3) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("extra", paramString1);
      if (!TextUtils.isEmpty(paramString2))
        jSONObject.put("notification_jump_url", paramString2); 
      jSONObject.put("show_toast", paramBoolean);
      jSONObject.put("business_type", paramString3);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return jSONObject.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */