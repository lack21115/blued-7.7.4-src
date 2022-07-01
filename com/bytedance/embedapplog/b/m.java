package com.bytedance.embedapplog.b;

import android.content.Context;
import com.bytedance.embedapplog.util.d;
import org.json.JSONObject;

class m extends c {
  private final Context e;
  
  m(Context paramContext) {
    super(true, true);
    this.e = paramContext;
  }
  
  protected boolean a(JSONObject paramJSONObject) {
    i.a(paramJSONObject, "access", d.c(this.e));
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\b\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */