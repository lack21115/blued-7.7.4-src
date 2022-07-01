package com.bytedance.tea.crash.g;

import android.text.TextUtils;
import com.bytedance.tea.crash.c;
import com.bytedance.tea.crash.c.a;
import com.bytedance.tea.crash.c.b;
import com.bytedance.tea.crash.h;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class k {
  public static String a(String paramString) {
    if (h.a() != null) {
      Map map = h.a().a();
      if (map != null) {
        paramString = (String)map.get(paramString);
        if (paramString instanceof String)
          return paramString; 
      } 
    } 
    return null;
  }
  
  public static void a(a parama, b paramb, c paramc) {
    if (parama != null && parama.a() != null) {
      if (paramc == null)
        return; 
      JSONObject jSONObject = parama.a();
      long l = jSONObject.optLong("crash_time");
      int i = b(a("aid"));
      String str = h.c().a();
      if (l > 0L && i > 0 && !TextUtils.isEmpty(str) && !"0".equals(str) && !TextUtils.isEmpty(paramc.a()))
        try {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("android_");
          stringBuilder.append(i);
          stringBuilder.append("_");
          stringBuilder.append(str);
          stringBuilder.append("_");
          stringBuilder.append(l);
          stringBuilder.append("_");
          stringBuilder.append(paramc);
          String str1 = stringBuilder.toString();
          if (paramb != null) {
            jSONObject = paramb.a();
            if (jSONObject != null) {
              jSONObject.put("unique_key", str1);
              return;
            } 
          } else {
            jSONObject.put("unique_key", str1);
            return;
          } 
        } catch (JSONException jSONException) {
          jSONException.printStackTrace();
        }  
    } 
  }
  
  public static int b(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return 0; 
    try {
      return Integer.parseInt(paramString);
    } catch (NumberFormatException numberFormatException) {
      j.b(numberFormatException);
      return 0;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\g\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */