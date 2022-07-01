package com.bytedance.embedapplog.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.embed_device_register.b;
import java.util.Map;
import org.json.JSONObject;

final class n extends c {
  private final Context e;
  
  private final h f;
  
  n(Context paramContext, h paramh) {
    super(true, false);
    this.e = paramContext;
    this.f = paramh;
  }
  
  protected boolean a(JSONObject paramJSONObject) {
    SharedPreferences sharedPreferences = this.f.d();
    Map map = b.b(this.e, sharedPreferences);
    if (map != null) {
      paramJSONObject.put("oaid", new JSONObject(map));
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\b\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */