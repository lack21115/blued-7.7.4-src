package com.qq.e.comm.plugin.ab.d;

import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.bk;
import org.json.JSONObject;

public class e {
  private final JSONObject a;
  
  private Context b;
  
  private boolean c;
  
  public e(Context paramContext, JSONObject paramJSONObject) {
    this(paramContext, paramJSONObject, false);
  }
  
  public e(Context paramContext, JSONObject paramJSONObject, boolean paramBoolean) {
    this.b = paramContext;
    this.a = paramJSONObject;
    this.c = paramBoolean;
  }
  
  public a a() {
    c c;
    if (GDTADManager.getInstance().getSM().getInteger("innerWebViewX5On", 1) == 1 && bk.a()) {
      h h = new h(this.b, this.a);
    } else {
      c = new c(this.b, this.a);
    } 
    if (this.c)
      c.f(); 
    return c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */