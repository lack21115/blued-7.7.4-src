package com.bytedance.embedapplog.b;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;
import org.json.JSONObject;

class f extends c {
  private final Context e;
  
  f(Context paramContext) {
    super(false, false);
    this.e = paramContext;
  }
  
  protected boolean a(JSONObject paramJSONObject) {
    SharedPreferences sharedPreferences = this.e.getSharedPreferences("snssdk_openudid", 0);
    String str1 = sharedPreferences.getString("clientudid", null);
    String str2 = str1;
    if (!i.d(str1)) {
      try {
        str2 = UUID.randomUUID().toString();
        str1 = str2;
        str2 = a("clientudid.dat", str2);
        str1 = str2;
      } catch (Exception exception) {}
      SharedPreferences.Editor editor = sharedPreferences.edit();
      editor.putString("clientudid", str1);
      editor.apply();
      str2 = str1;
    } 
    paramJSONObject.put("clientudid", str2);
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */