package com.bytedance.embedapplog.b;

import android.content.Context;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

class k extends c {
  private final Context e;
  
  k(Context paramContext) {
    super(true, true);
    this.e = paramContext;
  }
  
  protected boolean a(JSONObject paramJSONObject) {
    i.a(paramJSONObject, "language", (this.e.getResources().getConfiguration()).locale.getLanguage());
    int j = TimeZone.getDefault().getRawOffset() / 3600000;
    int i = j;
    if (j < -12)
      i = -12; 
    j = i;
    if (i > 12)
      j = 12; 
    paramJSONObject.put("timezone", j);
    i.a(paramJSONObject, "region", Locale.getDefault().getCountry());
    TimeZone timeZone = Calendar.getInstance().getTimeZone();
    i.a(paramJSONObject, "tz_name", timeZone.getID());
    paramJSONObject.put("tz_offset", timeZone.getOffset(System.currentTimeMillis() / 1000L));
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\b\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */