package com.bytedance.sdk.adnet.d;

import android.content.Context;
import com.bytedance.sdk.adnet.a;
import java.util.LinkedHashMap;

public class e {
  public static String a(Context paramContext, int paramInt) {
    String str2 = "";
    if (paramInt == 1)
      try {
        String str = a.a().a(paramContext, "tnc_config", "");
        if (str instanceof String)
          str2 = String.valueOf(str); 
        return str2;
      } catch (Exception exception) {} 
    String str1 = "";
    if (str1 instanceof String)
      str2 = String.valueOf(str1); 
    return str2;
  }
  
  public static void a(Context paramContext, int paramInt, String paramString) {
    try {
      LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
      if (paramInt == 1)
        linkedHashMap.put("tnc_config", paramString); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("saveData = ");
      stringBuilder.append(paramString);
      d.b("MultiProcessFileUtils", stringBuilder.toString());
      a.a().a(paramContext, linkedHashMap);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */