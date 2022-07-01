package com.ss.android.a.a.d;

import org.json.JSONObject;

public class a {
  public static long a(JSONObject paramJSONObject, String paramString) {
    if (paramJSONObject == null)
      return 0L; 
    String str = paramJSONObject.optString(paramString);
    try {
      return Long.valueOf(str).longValue();
    } catch (NumberFormatException numberFormatException) {
      return 0L;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\a\a\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */